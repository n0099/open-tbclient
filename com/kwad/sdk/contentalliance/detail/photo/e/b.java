package com.kwad.sdk.contentalliance.detail.photo.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.f.h;
import com.kwad.sdk.contentalliance.widget.KsAdFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b implements com.kwad.sdk.contentalliance.a.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Random f34736b;

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f34737c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f34738d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdFrameLayout f34739e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.c f34740f;

    /* renamed from: g  reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f34741g;

    /* renamed from: h  reason: collision with root package name */
    public long f34742h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34743i;
    public int j;
    public LinkedList<LottieAnimationView> k;
    public h l;
    public final Runnable m;
    public com.kwad.sdk.contentalliance.a.e n;
    public com.kwad.sdk.contentalliance.a.a o;

    public b() {
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
        this.f34736b = new Random();
        this.f34737c = new ArrayList();
        this.k = new LinkedList<>();
        this.m = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34744a;

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
                this.f34744a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34744a.f34740f.a(com.kwad.sdk.contentalliance.widget.c.f35870b);
                }
            }
        };
        this.n = new com.kwad.sdk.contentalliance.a.e(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34745a;

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
                this.f34745a = this;
            }
        };
        this.o = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34746a;

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
                this.f34746a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.j();
                    ((com.kwad.sdk.contentalliance.detail.b) this.f34746a).f34553a.f34577d.add(this.f34746a.n);
                }
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.k();
                    this.f34746a.f34738d.removeCallbacks(this.f34746a.m);
                    this.f34746a.f34740f.a(com.kwad.sdk.contentalliance.widget.c.f35870b);
                    ((com.kwad.sdk.contentalliance.detail.b) this.f34746a).f34553a.f34577d.remove(this.f34746a.n);
                    if (this.f34746a.f34738d != null) {
                        for (int i4 = 0; i4 < this.f34746a.f34738d.getChildCount(); i4++) {
                            if ((this.f34746a.f34738d.getChildAt(i4) instanceof LottieAnimationView) && ((LottieAnimationView) this.f34746a.f34738d.getChildAt(i4)).c()) {
                                ((LottieAnimationView) this.f34746a.f34738d.getChildAt(i4)).d();
                            }
                        }
                    }
                    this.f34746a.k.clear();
                    if (this.f34746a.f34738d != null) {
                        this.f34746a.f34738d.removeAllViews();
                    }
                }
            }
        };
        h hVar = new h();
        this.l = hVar;
        a((Presenter) hVar);
    }

    private void a(LottieAnimationView lottieAnimationView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, this, lottieAnimationView, z) == null) {
            lottieAnimationView.d();
            lottieAnimationView.setVisibility(4);
            lottieAnimationView.setAnimation(R.raw.ksad_detail_center_like_anim_new_ui);
            lottieAnimationView.setSpeed(z ? 2.0f : 1.5f);
            lottieAnimationView.a(new AnimatorListenerAdapter(this, lottieAnimationView) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LottieAnimationView f34749a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f34750b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, lottieAnimationView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34750b = this;
                    this.f34749a = lottieAnimationView;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f34749a.b(this);
                        if (this.f34750b.f34738d.indexOfChild(this.f34749a) > -1) {
                            this.f34749a.setVisibility(4);
                            if (this.f34750b.k.contains(this.f34749a)) {
                                this.f34750b.k.offer(this.f34749a);
                            }
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        this.f34749a.setVisibility(0);
                    }
                }
            });
            lottieAnimationView.b();
        }
    }

    private void c(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || o() == null) {
            return;
        }
        boolean z = f2 > -1.0f && f3 > -1.0f;
        int i2 = this.j;
        if (!z) {
            i2 = (int) (i2 * 1.2f);
        }
        LottieAnimationView pollFirst = this.k.pollFirst();
        if (pollFirst == null) {
            pollFirst = new LottieAnimationView(o());
            pollFirst.a(true);
            RelativeLayout relativeLayout = this.f34738d;
            int i3 = this.j;
            relativeLayout.addView(pollFirst, new RelativeLayout.LayoutParams(i3, i3));
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pollFirst.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        if (z) {
            float f4 = i2 / 2.0f;
            pollFirst.setTranslationX(f2 - f4);
            pollFirst.setTranslationY((f3 - f4) - (this.j / 3.0f));
            List<Integer> list = this.f34737c;
            pollFirst.setRotation(list.get(this.f34736b.nextInt(list.size())).intValue());
            layoutParams.addRule(13, 0);
        } else {
            pollFirst.setTranslationX(0.0f);
            pollFirst.setTranslationY(0.0f);
            pollFirst.setRotation(0.0f);
            layoutParams.addRule(13, -1);
        }
        pollFirst.setLayoutParams(layoutParams);
        a(pollFirst, z);
    }

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && this.f34741g == null) {
            this.f34741g = new GestureDetector.SimpleOnGestureListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f34747a;

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
                    this.f34747a = this;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) ? this.f34747a.a(motionEvent) : invokeL.booleanValue;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                        this.f34747a.b(motionEvent);
                        return super.onSingleTapConfirmed(motionEvent);
                    }
                    return invokeL.booleanValue;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                        this.f34747a.c(motionEvent);
                        return super.onSingleTapUp(motionEvent);
                    }
                    return invokeL.booleanValue;
                }
            };
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.f34740f == null) {
            if (this.f34741g == null) {
                e();
            }
            this.f34740f = new com.kwad.sdk.contentalliance.widget.c(this, o(), this.f34741g) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f34748a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (GestureDetector.OnGestureListener) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34748a = this;
                }

                @Override // com.kwad.sdk.contentalliance.widget.c, android.view.GestureDetector
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) ? motionEvent.getActionMasked() == 6 ? this.f34748a.d(motionEvent) : super.onTouchEvent(motionEvent) : invokeL.booleanValue;
                }
            };
        }
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? SystemClock.elapsedRealtime() - this.f34742h < ((long) ViewConfiguration.getJumpTapTimeout()) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.o);
            this.f34739e.a(this.f34740f);
            this.f34738d.setVisibility(0);
        }
    }

    public boolean a(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.f34740f.a(500L);
            this.f34738d.removeCallbacks(this.m);
            this.f34738d.postDelayed(this.m, 500L);
            this.l.h();
            c(f2, f3);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            this.f34742h = SystemClock.elapsedRealtime();
            return this.f34743i || a(motionEvent.getX(), motionEvent.getY());
        }
        return invokeL.booleanValue;
    }

    public boolean b(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.f34742h = SystemClock.elapsedRealtime();
            this.f34743i = true;
            return a(f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    public boolean b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    @SuppressLint({"ClickableViewAccessibility"})
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b_();
            l().setOnTouchListener(null);
            this.f34738d.setOnTouchListener(null);
            this.f34739e.b(this.f34740f);
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34577d.remove(this.n);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.c();
            if (o() != null) {
                this.j = o().getResources().getDimensionPixelSize(R.dimen.ksad_slide_play_center_like_view_size);
            }
            this.f34738d = (RelativeLayout) b(R.id.ksad_slide_play_like_image);
            this.f34739e = (KsAdFrameLayout) b(R.id.ksad_video_container);
            e();
            for (int i2 = -15; i2 < 15; i2++) {
                this.f34737c.add(Integer.valueOf(i2));
            }
            this.f34739e.setClickable(true);
            f();
        }
    }

    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            if (g()) {
                return b(motionEvent.getX(), motionEvent.getY());
            }
            this.f34743i = false;
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            RelativeLayout relativeLayout = this.f34738d;
            if (relativeLayout != null) {
                relativeLayout.removeCallbacks(this.m);
            }
            super.d();
        }
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            int actionIndex = motionEvent.getActionIndex();
            if (g()) {
                return b(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex));
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
