package com.kwad.sdk.api.core.fragment;

import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
@KsAdSdkDynamicApi
/* loaded from: classes7.dex */
public class KsFragmentTransaction {
    public final FragmentTransaction mBase;

    public KsFragmentTransaction(FragmentTransaction fragmentTransaction) {
        this.mBase = fragmentTransaction;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction add(int i, KsFragment ksFragment) {
        this.mBase.add(i, ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction add(int i, KsFragment ksFragment, String str) {
        this.mBase.add(i, ksFragment.getBase(), str);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction add(KsFragment ksFragment, String str) {
        this.mBase.add(ksFragment.getBase(), str);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction addSharedElement(View view2, String str) {
        this.mBase.addSharedElement(view2, str);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction addToBackStack(String str) {
        this.mBase.addToBackStack(str);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction attach(KsFragment ksFragment) {
        this.mBase.attach(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    public int commit() {
        return this.mBase.commit();
    }

    @KsAdSdkDynamicApi
    public int commitAllowingStateLoss() {
        return this.mBase.commitAllowingStateLoss();
    }

    @KsAdSdkDynamicApi
    public void commitNow() {
        this.mBase.commitNow();
    }

    @KsAdSdkDynamicApi
    public void commitNowAllowingStateLoss() {
        this.mBase.commitNowAllowingStateLoss();
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction detach(KsFragment ksFragment) {
        this.mBase.detach(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction disallowAddToBackStack() {
        this.mBase.disallowAddToBackStack();
        return this;
    }

    public FragmentTransaction getBase() {
        return this.mBase;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction hide(KsFragment ksFragment) {
        this.mBase.hide(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    public boolean isAddToBackStackAllowed() {
        return this.mBase.isAddToBackStackAllowed();
    }

    @KsAdSdkDynamicApi
    public boolean isEmpty() {
        return this.mBase.isEmpty();
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction remove(KsFragment ksFragment) {
        this.mBase.remove(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction replace(int i, KsFragment ksFragment) {
        this.mBase.replace(i, ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction replace(int i, KsFragment ksFragment, String str) {
        this.mBase.replace(i, ksFragment.getBase(), str);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction runOnCommit(Runnable runnable) {
        this.mBase.runOnCommit(runnable);
        return this;
    }

    @KsAdSdkDynamicApi
    @Deprecated
    public KsFragmentTransaction setAllowOptimization(boolean z) {
        this.mBase.setAllowOptimization(z);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction setBreadCrumbShortTitle(int i) {
        this.mBase.setBreadCrumbShortTitle(i);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        this.mBase.setBreadCrumbShortTitle(charSequence);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction setBreadCrumbTitle(int i) {
        this.mBase.setBreadCrumbTitle(i);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        this.mBase.setBreadCrumbTitle(charSequence);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction setCustomAnimations(int i, int i2) {
        this.mBase.setCustomAnimations(i, i2);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction setCustomAnimations(int i, int i2, int i3, int i4) {
        this.mBase.setCustomAnimations(i, i2, i3, i4);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction setPrimaryNavigationFragment(KsFragment ksFragment) {
        this.mBase.setPrimaryNavigationFragment(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction setReorderingAllowed(boolean z) {
        this.mBase.setReorderingAllowed(z);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction setTransition(int i) {
        this.mBase.setTransition(i);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction setTransitionStyle(int i) {
        this.mBase.setTransitionStyle(i);
        return this;
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction show(KsFragment ksFragment) {
        this.mBase.show(ksFragment.getBase());
        return this;
    }
}
