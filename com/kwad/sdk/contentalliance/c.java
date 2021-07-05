package com.kwad.sdk.contentalliance;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes7.dex */
public abstract class c<T extends com.kwad.sdk.core.e.b> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Presenter f34326a;

    /* renamed from: b  reason: collision with root package name */
    public T f34327b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f34328c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34328c = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Presenter presenter = this.f34326a;
            if (presenter != null) {
                presenter.j();
            }
            this.f34328c = null;
        }
    }

    public abstract T b();

    @NonNull
    public abstract Presenter c();

    @LayoutRes
    public abstract int getLayoutId();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            this.f34327b = b();
            if (this.f34326a == null) {
                Presenter c2 = c();
                this.f34326a = c2;
                c2.a((View) this.f34328c);
            }
            this.f34326a.a(this.f34327b);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            T t = this.f34327b;
            if (t != null) {
                t.a();
            }
            a();
        }
    }
}
