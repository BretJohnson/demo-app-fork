package com.sonomademoapp;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.microsoft.codepush.react.CodePush;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import com.microsoft.react.sonoma.analytics.RNSonomaAnalyticsPackage;

import com.microsoft.react.sonoma.crashes.RNSonomaCrashesPackage;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {

    @Override
    protected String getJSBundleFile() {
      return CodePush.getJSBundleFile();
    }

    @Override
    protected boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      // Create RN native packages
      List<ReactPackage> packages = Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new CodePush(getResources().getString(R.string.reactNativeCodePush_androidDeploymentKey), getApplicationContext(), BuildConfig.DEBUG),
          new RNSonomaAnalyticsPackage(MainApplication.this),
          new RNSonomaCrashesPackage(MainApplication.this, new com.microsoft.react.sonoma.crashes.RNSonomaCrashesListenerAlwaysAsk())
      );
      return packages;
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
      return mReactNativeHost;
  }
}
