package com.kwad.components.core.g;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.g.a;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public abstract class b<T extends a> extends com.kwad.components.core.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T mCallerContext;
    public Presenter mPresenter;
    public View mRootView;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        for (com.kwad.components.core.g.kwai.a aVar : t.EF) {
            aVar.iK();
        }
    }

    private void notifyOnDestroy() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (t = this.mCallerContext) == null) {
            return;
        }
        for (com.kwad.components.core.g.kwai.a aVar : t.EF) {
            aVar.iN();
        }
    }

    private void notifyOnPause() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (t = this.mCallerContext) == null) {
            return;
        }
        for (com.kwad.components.core.g.kwai.a aVar : t.EF) {
            aVar.iM();
        }
    }

    private void notifyOnResume() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (t = this.mCallerContext) == null) {
            return;
        }
        for (com.kwad.components.core.g.kwai.a aVar : t.EF) {
            aVar.iL();
        }
    }

    public void onActivityCreated(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.mRootView = view2;
            this.mCallerContext = onCreateCallerContext();
            if (this.mPresenter == null) {
                Presenter onCreatePresenter = onCreatePresenter();
                this.mPresenter = onCreatePresenter;
                onCreatePresenter.B(this.mRootView);
            }
            this.mPresenter.e(this.mCallerContext);
            notifyOnCreate();
        }
    }

    public abstract T onCreateCallerContext();

    public abstract Presenter onCreatePresenter();

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            notifyOnDestroy();
            T t = this.mCallerContext;
            if (t != null) {
                t.release();
            }
            Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.destroy();
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

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            notifyOnResume();
        }
    }
}
