package com.kwad.sdk.contentalliance.trends.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class TrendsPanelLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f35543a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.view.a f35544b;

    /* renamed from: c  reason: collision with root package name */
    public a f35545c;

    /* renamed from: d  reason: collision with root package name */
    public b f35546d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f35547e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f35548f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f35549g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f35550h;

    /* renamed from: i  reason: collision with root package name */
    public TranslateAnimation f35551i;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i2);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(View view, TrendInfo trendInfo, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendsPanelLayout(Context context) {
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
        this.f35545c = null;
        this.f35546d = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendsPanelLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35545c = null;
        this.f35546d = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendsPanelLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f35545c = null;
        this.f35546d = null;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_trend_list_panel_space);
            this.f35548f = linearLayout;
            linearLayout.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TrendsPanelLayout f35552a;

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
                    this.f35552a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f35552a.a(3);
                    }
                }
            });
            this.f35549g = (RelativeLayout) findViewById(R.id.ksad_trend_list_panel_layout);
            this.f35543a = (RecyclerView) findViewById(R.id.ksad_trend_list_recycler_view);
            this.f35547e = (ImageView) findViewById(R.id.ksad_trend_list_panel_close_button);
            TextView textView = (TextView) findViewById(R.id.ksad_trend_panel_title);
            this.f35550h = textView;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.addRule(9);
            layoutParams.leftMargin = ao.a(getContext(), 16.0f);
            this.f35547e.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TrendsPanelLayout f35553a;

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
                    this.f35553a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f35553a.a(1);
                    }
                }
            });
            this.f35543a.setVisibility(8);
            setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TrendsPanelLayout f35554a;

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
                    this.f35554a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    }
                }
            });
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
            this.f35551i = translateAnimation;
            translateAnimation.setDuration(300L);
            this.f35551i.setInterpolator(AnimationUtils.loadInterpolator(getContext(), 17432580));
            this.f35549g.startAnimation(this.f35551i);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
            this.f35551i = translateAnimation;
            translateAnimation.setDuration(300L);
            this.f35551i.setInterpolator(AnimationUtils.loadInterpolator(getContext(), 17432580));
            this.f35551i.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TrendsPanelLayout f35555a;

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
                    this.f35555a = this;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                        this.f35555a.f35549g.setVisibility(8);
                        this.f35555a.f35548f.setVisibility(8);
                        this.f35555a.setVisibility(8);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                    }
                }
            });
            this.f35549g.startAnimation(this.f35551i);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f35543a.setVisibility(0);
            this.f35549g.setVisibility(0);
            this.f35548f.setVisibility(0);
            setVisibility(0);
            e();
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            f();
            a aVar = this.f35545c;
            if (aVar != null) {
                aVar.a(i2);
            }
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.trends.view.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f35543a.setItemAnimator(null);
            this.f35543a.setLayoutManager(b());
            com.kwad.sdk.contentalliance.trends.view.a b2 = b(bVar);
            this.f35544b = b2;
            this.f35543a.setAdapter(b2);
        }
    }

    @NonNull
    public RecyclerView.LayoutManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(1);
            return linearLayoutManager;
        }
        return (RecyclerView.LayoutManager) invokeV.objValue;
    }

    public com.kwad.sdk.contentalliance.trends.view.a b(@NonNull com.kwad.sdk.contentalliance.trends.view.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? new com.kwad.sdk.contentalliance.trends.view.a(getContext(), bVar, new b(this) { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TrendsPanelLayout f35556a;

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
                this.f35556a = this;
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.b
            public void a(View view, TrendInfo trendInfo, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, view, trendInfo, i2) == null) {
                    if (this.f35556a.f35546d != null) {
                        this.f35556a.f35546d.a(view, trendInfo, i2);
                    }
                    this.f35556a.a(4);
                }
            }
        }) : (com.kwad.sdk.contentalliance.trends.view.a) invokeL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r0 != 2) goto L8;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            boolean z = true;
            if (action != 0) {
                if (action == 1) {
                    parent = getParent();
                    z = false;
                    parent.requestDisallowInterceptTouchEvent(z);
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            parent = getParent();
            parent.requestDisallowInterceptTouchEvent(z);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onFinishInflate();
            d();
        }
    }

    public void setCloseListener(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f35545c = aVar;
        }
    }

    public void setItemClickListener(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.f35546d = bVar;
        }
    }
}
