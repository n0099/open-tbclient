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
/* loaded from: classes5.dex */
public abstract class c<T extends com.kwad.sdk.mvp.a> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Presenter a;
    public T b;
    public ViewGroup c;

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
        this.c = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Presenter presenter = this.a;
            if (presenter != null) {
                presenter.p();
            }
            this.c = null;
        }
    }

    @NonNull
    public abstract Presenter a();

    public abstract T b();

    @LayoutRes
    public abstract int getLayoutId();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            this.b = b();
            if (this.a == null) {
                Presenter a = a();
                this.a = a;
                a.c(this.c);
            }
            this.a.a(this.b);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            T t = this.b;
            if (t != null) {
                t.a();
            }
            c();
        }
    }
}
