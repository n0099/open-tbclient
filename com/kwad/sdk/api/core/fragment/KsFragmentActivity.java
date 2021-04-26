package com.kwad.sdk.api.core.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes6.dex */
public class KsFragmentActivity extends FragmentActivity {
    public KsFragmentManager mFragmentManager;

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final FragmentManager getSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }

    @Keep
    public final KsFragmentManager getSupportFragmentManager2() {
        if (this.mFragmentManager == null) {
            this.mFragmentManager = new KsFragmentManager(super.getSupportFragmentManager());
        }
        return this.mFragmentManager;
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof IDelegateFragment) {
            onAttachFragment(((IDelegateFragment) fragment).getBase());
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onAttachFragment(KsFragment ksFragment) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i2) {
        super.startActivityFromFragment(fragment, intent, i2);
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i2, @Nullable Bundle bundle) {
        super.startActivityFromFragment(fragment, intent, i2, bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public void supportFinishAfterTransition() {
        super.supportFinishAfterTransition();
    }
}
