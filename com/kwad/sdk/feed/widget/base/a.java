package com.kwad.sdk.feed.widget.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.page.widget.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class a extends com.kwad.sdk.core.view.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f37439a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f37440b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0452a f37441c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public Context f37442d;

    /* renamed from: e  reason: collision with root package name */
    public s.a f37443e;

    /* renamed from: f  reason: collision with root package name */
    public g f37444f;

    /* renamed from: g  reason: collision with root package name */
    public float f37445g;

    /* renamed from: h  reason: collision with root package name */
    public g.a f37446h;

    /* renamed from: com.kwad.sdk.feed.widget.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0452a {
        void a();

        void b();

        void c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f37445g = 0.0f;
        this.f37446h = new g.a(this) { // from class: com.kwad.sdk.feed.widget.base.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f37447a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37447a = this;
            }

            @Override // com.kwad.sdk.core.view.g.a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    if (z) {
                        this.f37447a.d();
                    } else {
                        this.f37447a.e();
                    }
                }
            }
        };
        this.f37443e = new s.a();
        this.f37442d = context;
        f();
    }

    private void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, viewGroup) == null) {
            com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
            if (b2 == null) {
                b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
                viewGroup.addView(b2);
            }
            b2.setViewCallback(new a.InterfaceC0437a(this) { // from class: com.kwad.sdk.feed.widget.base.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f37448a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37448a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0437a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0437a
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        this.f37448a.j();
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0437a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0437a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    }
                }
            });
            b2.setNeedCheckingShow(true);
        }
    }

    private com.kwad.sdk.core.page.widget.a b(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, viewGroup)) == null) {
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof com.kwad.sdk.core.page.widget.a) {
                    return (com.kwad.sdk.core.page.widget.a) childAt;
                }
            }
            return null;
        }
        return (com.kwad.sdk.core.page.widget.a) invokeL.objValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            FrameLayout.inflate(this.f37442d, getLayoutId(), this);
            setRatio(getHWRatio());
            c();
            this.f37444f = new g(this, 70);
            a(this);
        }
    }

    @Override // com.kwad.sdk.core.view.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f37444f.a(this.f37446h);
            this.f37444f.a();
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.f37439a = adTemplate;
            this.f37440b = c.j(adTemplate);
        }
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f37444f.b(this.f37446h);
            this.f37444f.b();
        }
    }

    public abstract void c();

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                s.a aVar = new s.a(getWidth(), getHeight());
                this.f37443e = aVar;
                aVar.a(motionEvent.getX(), motionEvent.getY());
            } else if (action == 1) {
                this.f37443e.b(motionEvent.getX(), motionEvent.getY());
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public float getHWRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public abstract int getLayoutId();

    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37445g : invokeV.floatValue;
    }

    @MainThread
    public s.a getTouchCoords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f37443e : (s.a) invokeV.objValue;
    }

    public void j() {
        InterfaceC0452a interfaceC0452a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!this.f37439a.mPvReported && (interfaceC0452a = this.f37441c) != null) {
                interfaceC0452a.b();
            }
            com.kwad.sdk.core.report.b.a(this.f37439a, (JSONObject) null);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.kwad.sdk.core.report.b.a(this.f37439a, getTouchCoords());
            InterfaceC0452a interfaceC0452a = this.f37441c;
            if (interfaceC0452a != null) {
                interfaceC0452a.a();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            com.kwad.sdk.core.report.b.a(this.f37439a);
            InterfaceC0452a interfaceC0452a = this.f37441c;
            if (interfaceC0452a != null) {
                interfaceC0452a.c();
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            if (this.f37445g != 0.0f) {
                int size = View.MeasureSpec.getSize(i2);
                com.kwad.sdk.core.d.a.a("BaseFeedView", "widthSize:" + size);
                i3 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * this.f37445g), 1073741824);
            }
            super.onMeasure(i2, i3);
        }
    }

    public void setAdClickListener(InterfaceC0452a interfaceC0452a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, interfaceC0452a) == null) {
            this.f37441c = interfaceC0452a;
        }
    }

    public void setMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            setPadding(i2, i2, i2, i2);
            setBackgroundColor(-1);
        }
    }

    public void setRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
            this.f37445g = f2;
        }
    }
}
