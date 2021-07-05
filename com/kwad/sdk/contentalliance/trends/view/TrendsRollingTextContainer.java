package com.kwad.sdk.contentalliance.trends.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.TrendInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class TrendsRollingTextContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f35557a;

    /* renamed from: b  reason: collision with root package name */
    public TextView[] f35558b;

    /* renamed from: c  reason: collision with root package name */
    public int f35559c;

    /* renamed from: d  reason: collision with root package name */
    public int f35560d;

    /* renamed from: e  reason: collision with root package name */
    public List<TrendInfo> f35561e;

    /* renamed from: f  reason: collision with root package name */
    public AlphaAnimation f35562f;

    /* renamed from: g  reason: collision with root package name */
    public AlphaAnimation f35563g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f35564h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f35565i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendsRollingTextContainer(@NonNull Context context) {
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
        this.f35558b = new TextView[2];
        this.f35559c = 0;
        this.f35560d = 0;
        this.f35561e = new ArrayList();
        this.f35562f = null;
        this.f35563g = null;
        this.f35564h = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TrendsRollingTextContainer f35566a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35566a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    TrendsRollingTextContainer trendsRollingTextContainer = this.f35566a;
                    trendsRollingTextContainer.b(trendsRollingTextContainer.f35558b[trendsRollingTextContainer.f35559c]);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = this.f35566a;
                    trendsRollingTextContainer2.f35557a.removeCallbacks(trendsRollingTextContainer2.f35565i);
                    TrendsRollingTextContainer trendsRollingTextContainer3 = this.f35566a;
                    trendsRollingTextContainer3.f35557a.postDelayed(trendsRollingTextContainer3.f35565i, 200L);
                }
            }
        };
        this.f35565i = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TrendsRollingTextContainer f35567a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35567a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35567a.f35561e.size() <= 0) {
                    return;
                }
                TrendsRollingTextContainer.d(this.f35567a);
                TrendsRollingTextContainer trendsRollingTextContainer = this.f35567a;
                trendsRollingTextContainer.f35558b[1 - trendsRollingTextContainer.f35559c].setText(((TrendInfo) this.f35567a.f35561e.get(this.f35567a.f35560d % this.f35567a.f35561e.size())).name);
                TrendsRollingTextContainer trendsRollingTextContainer2 = this.f35567a;
                trendsRollingTextContainer2.a(trendsRollingTextContainer2.f35558b[1 - trendsRollingTextContainer2.f35559c]);
            }
        };
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendsRollingTextContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.f35558b = new TextView[2];
        this.f35559c = 0;
        this.f35560d = 0;
        this.f35561e = new ArrayList();
        this.f35562f = null;
        this.f35563g = null;
        this.f35564h = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TrendsRollingTextContainer f35566a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35566a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    TrendsRollingTextContainer trendsRollingTextContainer = this.f35566a;
                    trendsRollingTextContainer.b(trendsRollingTextContainer.f35558b[trendsRollingTextContainer.f35559c]);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = this.f35566a;
                    trendsRollingTextContainer2.f35557a.removeCallbacks(trendsRollingTextContainer2.f35565i);
                    TrendsRollingTextContainer trendsRollingTextContainer3 = this.f35566a;
                    trendsRollingTextContainer3.f35557a.postDelayed(trendsRollingTextContainer3.f35565i, 200L);
                }
            }
        };
        this.f35565i = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TrendsRollingTextContainer f35567a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35567a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35567a.f35561e.size() <= 0) {
                    return;
                }
                TrendsRollingTextContainer.d(this.f35567a);
                TrendsRollingTextContainer trendsRollingTextContainer = this.f35567a;
                trendsRollingTextContainer.f35558b[1 - trendsRollingTextContainer.f35559c].setText(((TrendInfo) this.f35567a.f35561e.get(this.f35567a.f35560d % this.f35567a.f35561e.size())).name);
                TrendsRollingTextContainer trendsRollingTextContainer2 = this.f35567a;
                trendsRollingTextContainer2.a(trendsRollingTextContainer2.f35558b[1 - trendsRollingTextContainer2.f35559c]);
            }
        };
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendsRollingTextContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f35558b = new TextView[2];
        this.f35559c = 0;
        this.f35560d = 0;
        this.f35561e = new ArrayList();
        this.f35562f = null;
        this.f35563g = null;
        this.f35564h = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TrendsRollingTextContainer f35566a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35566a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    TrendsRollingTextContainer trendsRollingTextContainer = this.f35566a;
                    trendsRollingTextContainer.b(trendsRollingTextContainer.f35558b[trendsRollingTextContainer.f35559c]);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = this.f35566a;
                    trendsRollingTextContainer2.f35557a.removeCallbacks(trendsRollingTextContainer2.f35565i);
                    TrendsRollingTextContainer trendsRollingTextContainer3 = this.f35566a;
                    trendsRollingTextContainer3.f35557a.postDelayed(trendsRollingTextContainer3.f35565i, 200L);
                }
            }
        };
        this.f35565i = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TrendsRollingTextContainer f35567a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35567a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35567a.f35561e.size() <= 0) {
                    return;
                }
                TrendsRollingTextContainer.d(this.f35567a);
                TrendsRollingTextContainer trendsRollingTextContainer = this.f35567a;
                trendsRollingTextContainer.f35558b[1 - trendsRollingTextContainer.f35559c].setText(((TrendInfo) this.f35567a.f35561e.get(this.f35567a.f35560d % this.f35567a.f35561e.size())).name);
                TrendsRollingTextContainer trendsRollingTextContainer2 = this.f35567a;
                trendsRollingTextContainer2.a(trendsRollingTextContainer2.f35558b[1 - trendsRollingTextContainer2.f35559c]);
            }
        };
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView) {
        AlphaAnimation alphaAnimation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, textView) == null) || (alphaAnimation = this.f35563g) == null) {
            return;
        }
        textView.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView) {
        AlphaAnimation alphaAnimation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, textView) == null) || (alphaAnimation = this.f35562f) == null) {
            return;
        }
        textView.startAnimation(alphaAnimation);
    }

    public static /* synthetic */ int d(TrendsRollingTextContainer trendsRollingTextContainer) {
        int i2 = trendsRollingTextContainer.f35560d;
        trendsRollingTextContainer.f35560d = i2 + 1;
        return i2;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f35557a = new Handler(getContext().getMainLooper());
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.f35558b[0] = (TextView) findViewById(R.id.ksad_trends_rolling_trend_name1);
            this.f35558b[1] = (TextView) findViewById(R.id.ksad_trends_rolling_trend_name2);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || this.f35561e.size() <= 0) {
            return;
        }
        TextView textView = this.f35558b[this.f35559c];
        List<TrendInfo> list = this.f35561e;
        textView.setText(list.get(this.f35560d % list.size()).name);
        this.f35558b[this.f35559c].setVisibility(0);
        this.f35558b[1 - this.f35559c].setVisibility(8);
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.f35562f = alphaAnimation;
            alphaAnimation.setDuration(300L);
            this.f35562f.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TrendsRollingTextContainer f35568a;

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
                    this.f35568a = this;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                        TrendsRollingTextContainer trendsRollingTextContainer = this.f35568a;
                        trendsRollingTextContainer.f35558b[trendsRollingTextContainer.f35559c].setVisibility(8);
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
                        TrendsRollingTextContainer trendsRollingTextContainer = this.f35568a;
                        trendsRollingTextContainer.f35558b[trendsRollingTextContainer.f35559c].setVisibility(0);
                    }
                }
            });
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
            this.f35563g = alphaAnimation2;
            alphaAnimation2.setDuration(300L);
            this.f35563g.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TrendsRollingTextContainer f35569a;

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
                    this.f35569a = this;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                        TrendsRollingTextContainer trendsRollingTextContainer = this.f35569a;
                        trendsRollingTextContainer.f35558b[1 - trendsRollingTextContainer.f35559c].setVisibility(0);
                        TrendsRollingTextContainer trendsRollingTextContainer2 = this.f35569a;
                        trendsRollingTextContainer2.f35559c = 1 - trendsRollingTextContainer2.f35559c;
                        this.f35569a.c();
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
                        TrendsRollingTextContainer trendsRollingTextContainer = this.f35569a;
                        trendsRollingTextContainer.f35558b[1 - trendsRollingTextContainer.f35559c].setVisibility(0);
                    }
                }
            });
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOnClickListener(null);
            AlphaAnimation alphaAnimation = this.f35562f;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
                this.f35562f.setAnimationListener(null);
            }
            AlphaAnimation alphaAnimation2 = this.f35563g;
            if (alphaAnimation2 != null) {
                alphaAnimation2.cancel();
                this.f35563g.setAnimationListener(null);
            }
            b();
        }
    }

    public void a(List<TrendInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            e();
            this.f35561e = list;
            this.f35559c = 0;
            this.f35560d = 0;
            if (list.size() == 1) {
                f();
                setVisibility(0);
            } else if (this.f35561e.size() < 2) {
                setVisibility(8);
            } else {
                f();
                setVisibility(0);
                g();
                c();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f35557a.removeCallbacks(this.f35565i);
            this.f35557a.removeCallbacks(this.f35564h);
            f();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f35561e.size() <= 1) {
            return;
        }
        this.f35557a.removeCallbacks(this.f35564h);
        this.f35557a.postDelayed(this.f35564h, 2000L);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onFinishInflate();
            e();
        }
    }
}
