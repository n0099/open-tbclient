package com.kwad.sdk.api.core.fragment;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes6.dex */
public class ResDialogFragment extends DelegateDialogFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResDialogFragment() {
        super(new KsDialogFragment(null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((KsDialogFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getBase().setBase(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"ValidFragment"})
    public ResDialogFragment(KsDialogFragment ksDialogFragment) {
        super(ksDialogFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksDialogFragment};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((KsDialogFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, com.kwad.sdk.api.core.fragment.IDelegateFragment
    public final Activity getActivity2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.getActivity() : (Activity) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, com.kwad.sdk.api.core.fragment.IDelegateFragment
    public /* bridge */ /* synthetic */ KsFragment getBase() {
        return super.getBase();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Wrapper.wrapContextIfNeed(super.getContext()) : (Context) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    @SuppressLint({"RestrictedApi"})
    public LayoutInflater getLayoutInflater(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bundle)) == null) ? Wrapper.wrapInflaterIfNeed(super.getLayoutInflater(bundle)) : (LayoutInflater) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            super.onAttach(Wrapper.wrapContextIfNeed(context));
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public /* bridge */ /* synthetic */ void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ Animation onCreateAnimation(int i2, boolean z, int i3) {
        return super.onCreateAnimation(i2, z, i3);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ Animator onCreateAnimator(int i2, boolean z, int i3) {
        return super.onCreateAnimator(i2, z, i3);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public /* bridge */ /* synthetic */ void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public /* bridge */ /* synthetic */ Dialog onCreateDialog(Bundle bundle) {
        return super.onCreateDialog(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    @Nullable
    public /* bridge */ /* synthetic */ View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDetach() {
        super.onDetach();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public /* bridge */ /* synthetic */ void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, bundle)) == null) ? Wrapper.wrapInflaterIfNeed(super.onGetLayoutInflater(bundle)) : (LayoutInflater) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public /* bridge */ /* synthetic */ void onLowMemory() {
        super.onLowMemory();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onPictureInPictureModeChanged(boolean z) {
        super.onPictureInPictureModeChanged(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public /* bridge */ /* synthetic */ void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onResume() {
        super.onResume();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onStart() {
        super.onStart();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
    }
}
