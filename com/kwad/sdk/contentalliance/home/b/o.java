package com.kwad.sdk.contentalliance.home.b;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
/* loaded from: classes7.dex */
public class o extends com.kwad.sdk.contentalliance.home.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public SlidePlayViewPager f35159b;

    /* renamed from: c  reason: collision with root package name */
    public View f35160c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35161d;

    /* renamed from: e  reason: collision with root package name */
    public LottieAnimationView f35162e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35163f;

    /* renamed from: g  reason: collision with root package name */
    public LottieAnimationView f35164g;

    /* renamed from: h  reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f35165h;

    /* renamed from: i  reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f35166i;
    public GestureDetector j;
    public ViewPager.OnPageChangeListener k;
    public boolean l;
    public boolean m;
    public int n;
    public boolean o;
    public com.kwad.sdk.contentalliance.home.a.d p;

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = false;
        this.n = 0;
        this.o = false;
        this.p = new com.kwad.sdk.contentalliance.home.a.e(this) { // from class: com.kwad.sdk.contentalliance.home.b.o.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ o f35169a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35169a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
            public void a(boolean z, boolean z2, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) && z && this.f35169a.f35160c.getVisibility() == 0) {
                    if (this.f35169a.m) {
                        this.f35169a.h();
                    } else if (this.f35169a.l) {
                        this.f35169a.g();
                    }
                }
            }
        };
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f35159b.b(this.k);
            ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener = new ViewPager.SimpleOnPageChangeListener(this) { // from class: com.kwad.sdk.contentalliance.home.b.o.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ o f35167a;

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
                    this.f35167a = this;
                }

                @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) && this.f35167a.n == 1) {
                        com.kwad.sdk.contentalliance.home.viewpager.a adapter = this.f35167a.f35159b.getAdapter();
                        AdTemplate e2 = adapter.e(adapter.a(i2));
                        if (e2 == null || !com.kwad.sdk.core.response.b.c.b(e2)) {
                            return;
                        }
                        this.f35167a.q();
                        this.f35167a.j = new GestureDetector(this.f35167a.o(), this.f35167a.f35166i);
                        this.f35167a.f35160c.setClickable(true);
                        this.f35167a.f35160c.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.contentalliance.home.b.o.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f35168a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f35168a = this;
                            }

                            @Override // android.view.View.OnTouchListener
                            @SuppressLint({"ClickableViewAccessibility"})
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                InterceptResult invokeLL;
                                Interceptable interceptable3 = $ic;
                                return (interceptable3 == null || (invokeLL = interceptable3.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f35168a.f35167a.j.onTouchEvent(motionEvent) : invokeLL.booleanValue;
                            }
                        });
                        this.f35167a.n = 2;
                    }
                }
            };
            this.k = simpleOnPageChangeListener;
            this.f35159b.a(simpleOnPageChangeListener);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void f() {
        GestureDetector gestureDetector;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.f35165h == null) {
            this.f35165h = new GestureDetector.SimpleOnGestureListener(this) { // from class: com.kwad.sdk.contentalliance.home.b.o.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ o f35170a;

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
                    this.f35170a = this;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (f3 >= -5000.0f || Math.abs(f3) <= Math.abs(f2) * 3.0f) ? super.onFling(motionEvent, motionEvent2, f2, f3) : this.f35170a.h() : invokeCommon.booleanValue;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (f3 <= 60.0f || Math.abs(f3) <= Math.abs(f2) * 2.0f) ? super.onScroll(motionEvent, motionEvent2, f2, f3) : this.f35170a.h() : invokeCommon.booleanValue;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) ? this.f35170a.h() : invokeL.booleanValue;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048579, this, motionEvent)) == null) ? this.f35170a.h() : invokeL.booleanValue;
                }
            };
            this.f35166i = new GestureDetector.SimpleOnGestureListener(this) { // from class: com.kwad.sdk.contentalliance.home.b.o.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ o f35171a;

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
                    this.f35171a = this;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.f35171a.g() : invokeCommon.booleanValue;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.f35171a.g() : invokeCommon.booleanValue;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) ? this.f35171a.g() : invokeL.booleanValue;
                }
            };
            int i2 = this.n;
            if (i2 != 0) {
                if (i2 == 1) {
                    gestureDetector = new GestureDetector(o(), this.f35166i);
                }
                this.f35160c.setClickable(true);
                this.f35160c.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.contentalliance.home.b.o.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ o f35172a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f35172a = this;
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f35172a.j.onTouchEvent(motionEvent) : invokeLL.booleanValue;
                    }
                });
            }
            gestureDetector = new GestureDetector(o(), this.f35165h);
            this.j = gestureDetector;
            this.f35160c.setClickable(true);
            this.f35160c.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.contentalliance.home.b.o.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ o f35172a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35172a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f35172a.j.onTouchEvent(motionEvent) : invokeLL.booleanValue;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (this.l) {
                this.l = false;
                ae.b(o());
                com.kwad.sdk.contentalliance.detail.photo.newui.d.c.a().b(false);
                this.f35159b.setEnabled(true);
                this.f35164g.d();
                this.f35160c.setOnTouchListener(null);
                this.f35160c.setVisibility(8);
                this.n = 2;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (this.m) {
                this.m = false;
                ae.d(o());
                com.kwad.sdk.contentalliance.detail.photo.newui.d.c.a().a(false);
                this.f35159b.setEnabled(true);
                this.f35162e.d();
                this.f35160c.setOnTouchListener(null);
                if (this.l) {
                    this.n = 1;
                }
                this.f35160c.animate().translationYBy(-o().getResources().getDisplayMetrics().heightPixels).setDuration(600L).setListener(new Animator.AnimatorListener(this) { // from class: com.kwad.sdk.contentalliance.home.b.o.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ o f35173a;

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
                        this.f35173a = this;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                            this.f35173a.f35160c.setVisibility(8);
                            this.f35173a.f35160c.setVisibility(8);
                            this.f35173a.f35162e.d();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                            this.f35173a.f35160c.setVisibility(8);
                            this.f35173a.f35160c.setVisibility(8);
                            this.f35173a.f35162e.d();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                        }
                    }
                }).start();
                this.o = true;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.f35159b.setEnabled(false);
            this.f35164g.d();
            this.f35163f.setVisibility(8);
            this.f35164g.setVisibility(8);
            this.f35161d.setVisibility(0);
            this.f35162e.setVisibility(0);
            this.f35162e.b();
            this.f35160c.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.f35159b.setEnabled(false);
            this.f35162e.d();
            this.f35162e.setVisibility(8);
            this.f35161d.setVisibility(8);
            this.f35164g.b();
            this.f35164g.setVisibility(0);
            this.f35163f.setVisibility(0);
            this.f35160c.setVisibility(0);
            if (this.o) {
                int i2 = this.f35160c.getContext().getResources().getDisplayMetrics().heightPixels;
                View view = this.f35160c;
                view.setTranslationY(view.getTranslationY() + i2);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f35159b.setEnabled(true);
            this.m = ae.c(o());
            boolean z = ae.a(o()) && ((com.kwad.sdk.contentalliance.home.e) this).f35218a.l;
            this.l = z;
            if (this.m) {
                this.n = 0;
                p();
                f();
                e();
            } else if (z) {
                this.n = 1;
                q();
                f();
            } else {
                this.n = 2;
                this.f35164g.setVisibility(8);
                this.f35160c.setVisibility(8);
            }
            ((com.kwad.sdk.contentalliance.home.e) this).f35218a.f35220b.a(this.p);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ViewPager.OnPageChangeListener onPageChangeListener = this.k;
            if (onPageChangeListener != null) {
                this.f35159b.b(onPageChangeListener);
            }
            if (this.f35162e.c()) {
                this.f35162e.d();
            }
            if (this.f35164g.c()) {
                this.f35164g.d();
            }
            this.f35160c.animate().cancel();
            this.f35160c.setOnTouchListener(null);
            this.f35160c.setVisibility(8);
            ((com.kwad.sdk.contentalliance.home.e) this).f35218a.f35220b.b(this.p);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35159b = (SlidePlayViewPager) b(R.id.ksad_slide_play_view_pager);
            this.f35160c = b(R.id.ksad_guider_mask);
            this.f35161d = (TextView) b(R.id.ksad_guider_up_title);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_guider_up_anim);
            this.f35162e = lottieAnimationView;
            lottieAnimationView.setAnimation(R.raw.ksad_detail_guider_slide_up_new);
            this.f35162e.setRepeatMode(1);
            this.f35162e.setRepeatCount(-1);
            this.f35163f = (TextView) b(R.id.ksad_guider_left_title);
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) b(R.id.ksad_guider_left_anim);
            this.f35164g = lottieAnimationView2;
            lottieAnimationView2.setAnimation(R.raw.ksad_detail_guider_slide_left);
            this.f35164g.setRepeatMode(1);
            this.f35164g.setRepeatCount(-1);
        }
    }
}
