package com.kwad.sdk.contentalliance.refreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.refreshview.RefreshLayout;
import com.kwad.sdk.utils.ao;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class KsAdHotRefreshView extends e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final float f35403g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public RefreshLayout.b f35404h;

    /* renamed from: i  reason: collision with root package name */
    public LottieAnimationView f35405i;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<KsAdHotRefreshView> f35408a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f35409b;

        public a(KsAdHotRefreshView ksAdHotRefreshView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ksAdHotRefreshView, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35408a = new WeakReference<>(ksAdHotRefreshView);
            this.f35409b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            KsAdHotRefreshView ksAdHotRefreshView;
            d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ksAdHotRefreshView = this.f35408a.get()) == null) {
                return;
            }
            if (!ksAdHotRefreshView.e() && (dVar = ksAdHotRefreshView.f35420e) != null) {
                dVar.c();
            }
            ksAdHotRefreshView.a(this.f35409b);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2035448172, "Lcom/kwad/sdk/contentalliance/refreshview/KsAdHotRefreshView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2035448172, "Lcom/kwad/sdk/contentalliance/refreshview/KsAdHotRefreshView;");
                return;
            }
        }
        f35403g = ao.a(KsAdSDKImpl.get().getContext(), 37.5f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KsAdHotRefreshView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsAdHotRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        setRefreshTargetOffset(f35403g - 1.0f);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? i2 : invokeI.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public void a(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, animationListener) == null) {
            if (this.f35419d.getTop() != 0 && this.f35419d.getTop() != getRefreshTargetOffset()) {
                super.a(i2, animationListener);
                return;
            }
            this.f35419d.setTop(0);
            clearAnimation();
            this.f35405i.d();
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
        }
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.e, com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, attributeSet) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_hot_shoot_refresh_view_2, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.ksad_shoot_refresh_view);
            this.f35419d = findViewById;
            findViewById.setVisibility(8);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_pull_to_refresh_animation_view);
            this.f35405i = lottieAnimationView;
            lottieAnimationView.setAnimation(R.raw.ksad_detail_loading_amin_new);
            View view = this.f35419d;
            if (!(view instanceof d)) {
                throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
            }
            this.f35420e = (d) view;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            super.setRefreshing(z);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f35419d.getVisibility() == 0 && this.f35419d.getAlpha() != 0.0f : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.e, com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new b(this) { // from class: com.kwad.sdk.contentalliance.refreshview.KsAdHotRefreshView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ KsAdHotRefreshView f35407a;

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
                this.f35407a = this;
            }

            @Override // com.kwad.sdk.contentalliance.refreshview.b
            public float a(float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? Math.min(KsAdHotRefreshView.f35403g, 200.0f - (80000.0f / (f2 + 400.0f))) : invokeCommon.floatValue;
            }
        } : (b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public void setOnRefreshListener(RefreshLayout.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f35404h = bVar;
            super.setOnRefreshListener(new RefreshLayout.b(this) { // from class: com.kwad.sdk.contentalliance.refreshview.KsAdHotRefreshView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsAdHotRefreshView f35406a;

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
                    this.f35406a = this;
                }

                @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        KsAdHotRefreshView ksAdHotRefreshView = this.f35406a;
                        View view = ksAdHotRefreshView.f35419d;
                        if (view instanceof KsAdHotShootRefreshView) {
                            ((KsAdHotShootRefreshView) view).setOnRefreshListener(ksAdHotRefreshView.f35404h);
                        }
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public void setRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                super.setRefreshing(z);
            } else {
                postDelayed(new a(this, z), 600L);
            }
        }
    }
}
