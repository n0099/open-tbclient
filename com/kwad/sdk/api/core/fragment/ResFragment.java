package com.kwad.sdk.api.core.fragment;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.core.ComponentDestroyer;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes7.dex */
public class ResFragment extends DelegateFragment {
    public ResFragment() {
        super(new KsFragment(null));
        getBase().setBase(this);
    }

    @SuppressLint({"ValidFragment"})
    public ResFragment(KsFragment ksFragment) {
        super(ksFragment);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, com.kwad.sdk.api.core.fragment.IDelegateFragment
    public final Activity getActivity2() {
        return super.getActivity();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, com.kwad.sdk.api.core.fragment.IDelegateFragment
    public /* bridge */ /* synthetic */ KsFragment getBase() {
        return super.getBase();
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.tieba.h2
    @Nullable
    public Context getContext() {
        if (super.getContext() == null) {
            return null;
        }
        return Wrapper.wrapContextIfNeed(super.getContext());
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    @SuppressLint({"RestrictedApi"})
    public LayoutInflater getLayoutInflater(@Nullable Bundle bundle) {
        return Wrapper.wrapInflaterIfNeed(super.getLayoutInflater(bundle));
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    @Deprecated
    public /* bridge */ /* synthetic */ void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(Wrapper.wrapContextIfNeed(context));
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ Animation onCreateAnimation(int i, boolean z, int i2) {
        return super.onCreateAnimation(i, z, i2);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ Animator onCreateAnimator(int i, boolean z, int i2) {
        return super.onCreateAnimator(i, z, i2);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public /* bridge */ /* synthetic */ void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view2, contextMenuInfo);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    @Nullable
    public /* bridge */ /* synthetic */ View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ComponentDestroyer.destroyFragment(this);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDetach() {
        super.onDetach();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        return Wrapper.wrapInflaterIfNeed(super.onGetLayoutInflater(bundle));
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public /* bridge */ /* synthetic */ void onLowMemory() {
        super.onLowMemory();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onPictureInPictureModeChanged(boolean z) {
        super.onPictureInPictureModeChanged(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public /* bridge */ /* synthetic */ void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onResume() {
        super.onResume();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onStart() {
        super.onStart();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        super.onViewCreated(view2, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
    }
}
