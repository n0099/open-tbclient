package com.kwad.sdk.core.e;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.a;
/* loaded from: classes10.dex */
public abstract class a<T extends com.kwad.sdk.reward.a> extends com.kwad.sdk.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T mCallerContext;
    public Presenter mPresenter;
    public View mRootView;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void notifyOnCreate() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (t = this.mCallerContext) == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : t.f73602a) {
            aVar.a();
        }
    }

    private void notifyOnDestroy() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (t = this.mCallerContext) == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : t.f73602a) {
            aVar.d();
        }
    }

    private void notifyOnPause() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (t = this.mCallerContext) == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : t.f73602a) {
            aVar.c();
        }
    }

    private void notifyOnResume() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (t = this.mCallerContext) == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : t.f73602a) {
            aVar.b();
        }
    }

    public void onActivityCreated(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.mRootView = view;
            this.mCallerContext = onCreateCallerContext();
            if (this.mPresenter == null) {
                Presenter onCreatePresenter = onCreatePresenter();
                this.mPresenter = onCreatePresenter;
                onCreatePresenter.a(this.mRootView);
            }
            this.mPresenter.a(this.mCallerContext);
            notifyOnCreate();
        }
    }

    public abstract T onCreateCallerContext();

    public abstract Presenter onCreatePresenter();

    @Override // com.kwad.sdk.c.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            notifyOnDestroy();
            T t = this.mCallerContext;
            if (t != null) {
                t.a();
            }
            Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.h();
            }
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            notifyOnPause();
        }
    }

    @Override // com.kwad.sdk.c.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            notifyOnResume();
        }
    }
}
