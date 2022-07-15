package com.kwad.components.core.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes5.dex */
public abstract class b<T extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.sdk.core.g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.widget.kwai.b a;
    @NonNull
    public T j;
    public AdInfo k;
    public InterfaceC0528b l;
    @NonNull
    public Context m;

    /* loaded from: classes5.dex */
    public static class a implements InterfaceC0528b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.kwad.components.core.widget.b.InterfaceC0528b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.kwad.components.core.widget.b.InterfaceC0528b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.kwad.components.core.widget.b.InterfaceC0528b
        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.kwad.components.core.widget.b.InterfaceC0528b
        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.kwad.components.core.widget.b.InterfaceC0528b
        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* renamed from: com.kwad.components.core.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0528b {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = context;
        f();
    }

    private void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, viewGroup) == null) {
            if (!com.kwad.sdk.core.config.d.Y() && com.kwad.sdk.core.config.d.X() >= 0.0f) {
                c(viewGroup);
                com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
                viewGroup.addView(aVar);
                aVar.setViewCallback(new a.InterfaceC0527a(this) { // from class: com.kwad.components.core.widget.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.components.core.widget.a.InterfaceC0527a
                    public final void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.e();
                        }
                    }
                });
                aVar.c();
                return;
            }
            c b = b(viewGroup);
            if (b == null) {
                b = new c(viewGroup.getContext(), viewGroup);
                viewGroup.addView(b);
            }
            b.setViewCallback(new c.a(this) { // from class: com.kwad.components.core.widget.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.widget.c.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.e();
                    }
                }
            });
            b.setNeedCheckingShow(true);
        }
    }

    public static c b(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup)) == null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof c) {
                    return (c) childAt;
                }
            }
            return null;
        }
        return (c) invokeL.objValue;
    }

    public static void c(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, viewGroup) == null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof com.kwad.components.core.widget.a) {
                    viewGroup.removeView(childAt);
                }
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            FrameLayout.inflate(this.m, getLayoutId(), this);
            setRatio(getHWRatio());
            c();
            this.a = new com.kwad.components.core.widget.kwai.b(this, 70);
            a((ViewGroup) this);
        }
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            com.kwad.sdk.core.report.a.a(this.j, i, getTouchCoords());
            InterfaceC0528b interfaceC0528b = this.l;
            if (interfaceC0528b != null) {
                interfaceC0528b.a();
            }
        }
    }

    public void a(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.j = t;
            this.k = com.kwad.sdk.core.response.a.d.i(t);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.a_();
            this.a.b(this);
            this.a.c();
            d();
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.b_();
            this.a.a(this);
            this.a.b();
        }
    }

    public abstract void c();

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void e() {
        InterfaceC0528b interfaceC0528b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!this.j.mPvReported && (interfaceC0528b = this.l) != null) {
                interfaceC0528b.b();
            }
            com.kwad.components.core.l.c.a().a(this.j, null, null);
        }
    }

    public final void g() {
        InterfaceC0528b interfaceC0528b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (interfaceC0528b = this.l) == null) {
            return;
        }
        interfaceC0528b.a();
    }

    public float getHWRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public abstract int getLayoutId();

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            com.kwad.sdk.core.report.a.a(this.j);
            InterfaceC0528b interfaceC0528b = this.l;
            if (interfaceC0528b != null) {
                interfaceC0528b.c();
            }
        }
    }

    public void m_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        InterfaceC0528b interfaceC0528b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, dialogInterface) == null) || (interfaceC0528b = this.l) == null) {
            return;
        }
        interfaceC0528b.e();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        InterfaceC0528b interfaceC0528b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, dialogInterface) == null) || (interfaceC0528b = this.l) == null) {
            return;
        }
        interfaceC0528b.d();
    }

    public void setInnerAdInteractionListener(InterfaceC0528b interfaceC0528b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, interfaceC0528b) == null) {
            this.l = interfaceC0528b;
        }
    }

    public void setMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            setPadding(i, i, i, i);
            setBackgroundColor(-1);
        }
    }
}
