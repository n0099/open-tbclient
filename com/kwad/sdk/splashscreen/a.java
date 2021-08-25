package com.kwad.sdk.splashscreen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.v;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f73569a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f73570b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f73571c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f73572d;

    /* renamed from: e  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f73573e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f73574f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f73575g;

    /* renamed from: h  reason: collision with root package name */
    public View f73576h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f73577i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f73578j;
    public final WindowManager.LayoutParams k;

    @RequiresApi(api = 21)
    /* renamed from: com.kwad.sdk.splashscreen.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2017a extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f73596a;

        public C2017a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73596a = f2;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, outline) == null) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                float f2 = this.f73596a;
                int i2 = (int) f2;
                int i3 = (int) f2;
                outline.setRoundRect(new Rect(i2, i3, (rect.right - rect.left) - i2, (rect.bottom - rect.top) - i3), this.f73596a);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public a(Context context, String str, boolean z, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z), splashScreenAdInteractionListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new WindowManager.LayoutParams();
        if (context == null) {
            return;
        }
        Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(context);
        this.f73569a = wrapContextIfNeed;
        this.f73573e = splashScreenAdInteractionListener;
        this.f73578j = z;
        this.f73570b = (WindowManager) wrapContextIfNeed.getSystemService("window");
        com.kwad.sdk.splashscreen.b.a a2 = SplashPlayModuleCache.a().a(str);
        this.f73572d = a2;
        if (a2 == null || this.f73570b == null) {
            return;
        }
        ImageView imageView = new ImageView(this.f73569a);
        this.f73571c = imageView;
        imageView.setImageDrawable(new BitmapDrawable(this.f73569a.getResources(), this.f73572d.f73661a));
        AdTemplate b2 = this.f73572d.b();
        com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(b2);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f73569a).inflate(R.layout.ksad_splash_vplush, (ViewGroup) null);
        this.f73574f = viewGroup;
        this.f73577i = (ImageView) viewGroup.findViewById(R.id.ksad_splash_frame);
        this.f73575g = (FrameLayout) this.f73574f.findViewById(R.id.ksad_splash_texture);
        this.f73576h = this.f73574f.findViewById(R.id.ksad_splash_close_btn);
        this.f73575g.setOnClickListener(new View.OnClickListener(this, b2, bVar) { // from class: com.kwad.sdk.splashscreen.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f73579a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ com.kwad.sdk.core.download.b.b f73580b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f73581c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, b2, bVar};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f73581c = this;
                this.f73579a = b2;
                this.f73580b = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f73581c.f73578j) {
                    com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f73579a, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.splashscreen.a.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f73582a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f73582a = this;
                        }

                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                        public void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (this.f73582a.f73581c.f73573e != null) {
                                    this.f73582a.f73581c.f73573e.onAdClicked();
                                }
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("duration", this.f73582a.f73581c.f73572d.c());
                                } catch (JSONException e2) {
                                    com.kwad.sdk.core.d.a.a(e2);
                                }
                                com.kwad.sdk.core.report.a.a(this.f73582a.f73579a, 114, (v.a) null, jSONObject);
                            }
                        }
                    }, this.f73580b, false);
                    if (this.f73581c.f73570b != null) {
                        try {
                            if (com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.i(this.f73581c.f73572d.b()))) {
                                return;
                            }
                            this.f73581c.f73570b.removeView(this.f73581c.f73574f);
                        } catch (Exception e2) {
                            com.kwad.sdk.core.a.a.a(e2);
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                    }
                }
            }
        });
        this.f73575g.setClickable(true);
        this.f73575g.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.splashscreen.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public float f73583a;

            /* renamed from: b  reason: collision with root package name */
            public float f73584b;

            /* renamed from: c  reason: collision with root package name */
            public float f73585c;

            /* renamed from: d  reason: collision with root package name */
            public float f73586d;

            /* renamed from: e  reason: collision with root package name */
            public float f73587e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f73588f;

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
                this.f73588f = this;
                this.f73583a = 0.0f;
                this.f73584b = 0.0f;
                this.f73585c = 0.0f;
                this.f73586d = 0.0f;
                this.f73587e = 0.0f;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (this.f73588f.k == null) {
                        return false;
                    }
                    if (motionEvent.getActionMasked() == 0) {
                        this.f73583a = motionEvent.getRawX();
                        this.f73584b = motionEvent.getRawY();
                        this.f73586d = this.f73588f.k.x;
                        this.f73585c = this.f73588f.k.y;
                        this.f73587e = (float) SystemClock.elapsedRealtime();
                        PrintStream printStream = System.out;
                        printStream.println(" actionDownX " + this.f73583a + " actionDownX " + this.f73583a);
                    } else if (motionEvent.getActionMasked() == 2) {
                        float rawX = motionEvent.getRawX() - this.f73583a;
                        float rawY = motionEvent.getRawY() - this.f73584b;
                        if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                            this.f73588f.k.x = (int) (this.f73586d + rawX);
                            this.f73588f.k.y = (int) (this.f73585c + rawY);
                            if (this.f73588f.f73570b != null) {
                                try {
                                    this.f73588f.f73570b.updateViewLayout(this.f73588f.f73574f, this.f73588f.k);
                                } catch (Exception e2) {
                                    com.kwad.sdk.core.a.a.a(e2);
                                    com.kwad.sdk.core.d.a.a(e2);
                                }
                            }
                        }
                        return true;
                    } else if (motionEvent.getActionMasked() == 1) {
                        float rawX2 = motionEvent.getRawX() - this.f73583a;
                        float rawY2 = motionEvent.getRawY() - this.f73584b;
                        float elapsedRealtime = ((float) SystemClock.elapsedRealtime()) - this.f73587e;
                        if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && elapsedRealtime > 30.0f && elapsedRealtime < 300.0f) {
                            view.performClick();
                        }
                    }
                    return true;
                }
                return invokeLL.booleanValue;
            }
        });
    }

    @SuppressLint({"RtlHardcoded"})
    public boolean a(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rect)) == null) {
            if (this.f73572d == null || this.f73570b == null) {
                return false;
            }
            Rect rect2 = new Rect();
            rect2.left = rect.left - av.a(this.f73569a, 6.0f);
            rect2.right = rect.right - av.a(this.f73569a, 6.0f);
            rect2.top = rect.top - av.a(this.f73569a, 6.0f);
            rect2.bottom = rect.bottom + av.a(this.f73569a, 6.0f);
            DisplayMetrics displayMetrics = this.f73569a.getResources().getDisplayMetrics();
            WindowManager.LayoutParams layoutParams = this.k;
            layoutParams.type = 1;
            layoutParams.flags = 8;
            layoutParams.gravity = 51;
            layoutParams.format = 1;
            int i2 = displayMetrics.widthPixels;
            layoutParams.width = i2;
            int i3 = displayMetrics.heightPixels;
            layoutParams.height = i3;
            layoutParams.x = 0;
            layoutParams.y = 0;
            int i4 = rect2.right;
            int i5 = rect2.left;
            float f2 = (i4 - i5) / i2;
            int i6 = rect2.bottom;
            int i7 = rect2.top;
            float f3 = (i6 - i7) / i3;
            this.f73571c.setPivotX((i5 * i2) / ((i5 + i2) - i4));
            this.f73571c.setPivotY((i7 * i3) / ((i7 + i3) - i6));
            WindowManager windowManager = this.f73570b;
            if (windowManager != null) {
                try {
                    windowManager.addView(this.f73571c, this.k);
                } catch (Exception e2) {
                    com.kwad.sdk.core.a.a.a(e2);
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            this.f73571c.animate().scaleX(f2).scaleY(f3).setDuration(600L).start();
            this.f73571c.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new AnimatorListenerAdapter(this, rect2) { // from class: com.kwad.sdk.splashscreen.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Rect f73589a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f73590b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, rect2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i8 = newInitContext.flag;
                        if ((i8 & 1) != 0) {
                            int i9 = i8 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73590b = this;
                    this.f73589a = rect2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f73590b.k.x = this.f73589a.left - av.a(this.f73590b.f73569a, 6.0f);
                        this.f73590b.k.y = this.f73589a.top - av.a(this.f73590b.f73569a, 6.0f);
                        WindowManager.LayoutParams layoutParams2 = this.f73590b.k;
                        Rect rect3 = this.f73589a;
                        layoutParams2.width = (rect3.right - rect3.left) + av.a(this.f73590b.f73569a, 12.0f);
                        WindowManager.LayoutParams layoutParams3 = this.f73590b.k;
                        Rect rect4 = this.f73589a;
                        layoutParams3.height = (rect4.bottom - rect4.top) + av.a(this.f73590b.f73569a, 12.0f);
                        this.f73590b.f73571c.animate().cancel();
                        this.f73590b.f73577i.setImageDrawable(new BitmapDrawable(this.f73590b.f73569a.getResources(), this.f73590b.f73572d.f73661a));
                        ViewParent parent = this.f73590b.f73572d.a().getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(this.f73590b.f73572d.a());
                        }
                        this.f73590b.f73575g.addView(this.f73590b.f73572d.a(), new ViewGroup.MarginLayoutParams(-1, -1));
                        if (this.f73590b.f73570b != null) {
                            try {
                                this.f73590b.f73570b.addView(this.f73590b.f73574f, this.f73590b.k);
                            } catch (Exception e3) {
                                com.kwad.sdk.core.a.a.a(e3);
                                com.kwad.sdk.core.d.a.a(e3);
                            }
                        }
                        this.f73590b.f73572d.d();
                        this.f73590b.f73572d.a(new com.kwad.sdk.contentalliance.detail.video.d(this) { // from class: com.kwad.sdk.splashscreen.a.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f73591a;

                            /* renamed from: b  reason: collision with root package name */
                            public boolean f73592b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i8 = newInitContext.flag;
                                    if ((i8 & 1) != 0) {
                                        int i9 = i8 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f73591a = this;
                                this.f73592b = false;
                            }

                            @Override // com.kwad.sdk.contentalliance.detail.video.d
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                }
                            }

                            @Override // com.kwad.sdk.contentalliance.detail.video.d
                            public void a(int i8, int i9) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i8, i9) == null) {
                                }
                            }

                            @Override // com.kwad.sdk.contentalliance.detail.video.d
                            public void a(long j2, long j3) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                                }
                            }

                            @Override // com.kwad.sdk.contentalliance.detail.video.d
                            public void b() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048579, this) == null) {
                                }
                            }

                            @Override // com.kwad.sdk.contentalliance.detail.video.d
                            public void c() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048580, this) == null) {
                                }
                            }

                            @Override // com.kwad.sdk.contentalliance.detail.video.d
                            public void d() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048581, this) == null) {
                                }
                            }

                            @Override // com.kwad.sdk.contentalliance.detail.video.d
                            public void e() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048582, this) == null) {
                                }
                            }

                            @Override // com.kwad.sdk.contentalliance.detail.video.d
                            public void f() {
                                WindowManager windowManager2;
                                ViewGroup viewGroup;
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeV(1048583, this) == null) || this.f73592b) {
                                    return;
                                }
                                this.f73592b = true;
                                if (this.f73591a.f73590b.f73573e != null) {
                                    this.f73591a.f73590b.f73573e.onAdShowEnd();
                                }
                                this.f73591a.f73590b.f73572d.h();
                                if (this.f73591a.f73590b.f73570b != null) {
                                    try {
                                        if (Build.VERSION.SDK_INT < 19) {
                                            windowManager2 = this.f73591a.f73590b.f73570b;
                                            viewGroup = this.f73591a.f73590b.f73574f;
                                        } else if (!this.f73591a.f73590b.f73574f.isAttachedToWindow()) {
                                            return;
                                        } else {
                                            windowManager2 = this.f73591a.f73590b.f73570b;
                                            viewGroup = this.f73591a.f73590b.f73574f;
                                        }
                                        windowManager2.removeView(viewGroup);
                                    } catch (Exception e4) {
                                        com.kwad.sdk.core.a.a.a(e4);
                                    }
                                }
                            }

                            @Override // com.kwad.sdk.contentalliance.detail.video.d
                            public void g() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                                }
                            }

                            @Override // com.kwad.sdk.contentalliance.detail.video.d
                            public void h() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048585, this) == null) {
                                }
                            }
                        });
                        this.f73590b.f73571c.postDelayed(new ax(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.3.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f73593a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i8 = newInitContext.flag;
                                    if ((i8 & 1) != 0) {
                                        int i9 = i8 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f73593a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f73593a.f73590b.f73570b.removeView(this.f73593a.f73590b.f73571c);
                                    } catch (Exception e4) {
                                        com.kwad.sdk.core.a.a.a(e4);
                                    }
                                    if (Build.VERSION.SDK_INT >= 21) {
                                        this.f73593a.f73590b.f73572d.a().setOutlineProvider(new C2017a(av.a(this.f73593a.f73590b.f73569a, 1.0f)));
                                        this.f73593a.f73590b.f73572d.a().setClipToOutline(true);
                                        this.f73593a.f73590b.f73577i.setOutlineProvider(new C2017a(av.a(this.f73593a.f73590b.f73569a, 1.0f)));
                                        this.f73593a.f73590b.f73577i.setClipToOutline(true);
                                    }
                                }
                            }
                        }), 100L);
                        this.f73590b.f73577i.postDelayed(new ax(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.3.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f73594a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i8 = newInitContext.flag;
                                    if ((i8 & 1) != 0) {
                                        int i9 = i8 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f73594a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f73594a.f73590b.f73577i.setVisibility(8);
                                }
                            }
                        }), 200L);
                    }
                }
            });
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f73573e;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
            }
            com.kwad.sdk.core.report.a.c(this.f73572d.b(), 115, null);
            this.f73576h.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.splashscreen.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73595a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i8 = newInitContext.flag;
                        if ((i8 & 1) != 0) {
                            int i9 = i8 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73595a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f73595a.f73570b != null) {
                            try {
                                this.f73595a.f73570b.removeView(this.f73595a.f73574f);
                                this.f73595a.f73572d.h();
                            } catch (Exception e3) {
                                com.kwad.sdk.core.a.a.a(e3);
                            }
                        }
                        if (this.f73595a.f73573e != null) {
                            this.f73595a.f73573e.onSkippedAd();
                        }
                        if (this.f73595a.f73572d != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("duration", this.f73595a.f73572d.c());
                            } catch (JSONException e4) {
                                com.kwad.sdk.core.d.a.a(e4);
                            }
                            com.kwad.sdk.core.report.a.a(this.f73595a.f73572d.b(), 1, jSONObject);
                        }
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }
}
