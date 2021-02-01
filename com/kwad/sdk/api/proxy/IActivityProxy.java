package com.kwad.sdk.api.proxy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes3.dex */
public abstract class IActivityProxy implements IComponentProxy {
    private Activity mActivity;

    @KsAdSdkDynamicApi
    @Keep
    public <T extends View> T findViewById(int i) {
        return (T) this.mActivity.findViewById(i);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void finish() {
        this.mActivity.finish();
    }

    @KsAdSdkDynamicApi
    @Keep
    public Activity getActivity() {
        return this.mActivity;
    }

    @KsAdSdkDynamicApi
    @Keep
    public Intent getIntent() {
        return this.mActivity.getIntent();
    }

    @KsAdSdkDynamicApi
    @Keep
    public Window getWindow() {
        return this.mActivity.getWindow();
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onBackPressed() {
        if (this.mActivity instanceof BaseProxyActivity) {
            ((BaseProxyActivity) this.mActivity).superOnBackPressed();
        } else if (!(this.mActivity instanceof BaseProxyFragmentActivity)) {
            throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
        } else {
            ((BaseProxyFragmentActivity) this.mActivity).superOnBackPressed();
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onConfigurationChanged(Configuration configuration) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KsAdSdkDynamicApi
    @Keep
    public void onCreate(@Nullable Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KsAdSdkDynamicApi
    @Keep
    public void onDestroy() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mActivity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) this.mActivity).superOnKeyDown(i, keyEvent);
        }
        if (this.mActivity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) this.mActivity).superOnKeyDown(i, keyEvent);
        }
        throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        if (this.mActivity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) this.mActivity).superOnKeyLongPress(i, keyEvent);
        }
        if (this.mActivity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) this.mActivity).superOnKeyLongPress(i, keyEvent);
        }
        throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.mActivity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) this.mActivity).superOnKeyUp(i, keyEvent);
        }
        if (this.mActivity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) this.mActivity).superOnKeyUp(i, keyEvent);
        }
        throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onNewIntent(Intent intent) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPause() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KsAdSdkDynamicApi
    @Keep
    public void onPostCreate(@Nullable Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPostResume() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KsAdSdkDynamicApi
    @Keep
    public void onPreCreate(@Nullable Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreDestroy() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPrePause() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreResume() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreSaveInstanceState(@NonNull Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreStart() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreStop() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onRestart() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onRestoreInstanceState(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onResume() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onSaveInstanceState(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onStart() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onStop() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onTitleChanged(CharSequence charSequence, int i) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onUserLeaveHint() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void overridePendingTransition(int i, int i2) {
        this.mActivity.overridePendingTransition(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setContentView(int i) {
        this.mActivity.setContentView(i);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setContentView(View view) {
        this.mActivity.setContentView(view);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mActivity.setContentView(view, layoutParams);
    }
}
