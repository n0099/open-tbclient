package com.kwad.components.core.g;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;
/* loaded from: classes7.dex */
public abstract class c<T extends com.kwad.sdk.mvp.a> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T EH;
    public ViewGroup iB;
    public Presenter mPresenter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void onActivityDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.destroy();
            }
            this.iB = null;
        }
    }

    @LayoutRes
    public abstract int getLayoutId();

    public abstract ViewGroup jt();

    public abstract T jv();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            this.EH = jv();
            if (this.mPresenter == null) {
                this.mPresenter = onCreatePresenter();
                if (this.iB == null) {
                    this.iB = jt();
                }
                this.mPresenter.B(this.iB);
            }
            this.mPresenter.e(this.EH);
        }
    }

    @NonNull
    public abstract Presenter onCreatePresenter();

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            T t = this.EH;
            if (t != null) {
                t.release();
            }
            onActivityDestroy();
        }
    }
}
