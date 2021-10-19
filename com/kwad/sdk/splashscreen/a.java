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
    public Context f74103a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f74104b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f74105c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f74106d;

    /* renamed from: e  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f74107e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f74108f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f74109g;

    /* renamed from: h  reason: collision with root package name */
    public View f74110h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f74111i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f74112j;
    public final WindowManager.LayoutParams k;

    @RequiresApi(api = 21)
    /* renamed from: com.kwad.sdk.splashscreen.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2023a extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f74130a;

        public C2023a(float f2) {
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
            this.f74130a = f2;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, outline) == null) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                float f2 = this.f74130a;
                int i2 = (int) f2;
                int i3 = (int) f2;
                outline.setRoundRect(new Rect(i2, i3, (rect.right - rect.left) - i2, (rect.bottom - rect.top) - i3), this.f74130a);
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
        this.f74103a = wrapContextIfNeed;
        this.f74107e = splashScreenAdInteractionListener;
        this.f74112j = z;
        this.f74104b = (WindowManager) wrapContextIfNeed.getSystemService("window");
        com.kwad.sdk.splashscreen.b.a a2 = SplashPlayModuleCache.a().a(str);
        this.f74106d = a2;
        if (a2 == null || this.f74104b == null) {
            return;
        }
        ImageView imageView = new ImageView(this.f74103a);
        this.f74105c = imageView;
        imageView.setImageDrawable(new BitmapDrawable(this.f74103a.getResources(), this.f74106d.f74195a));
        AdTemplate b2 = this.f74106d.b();
        com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(b2);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f74103a).inflate(R.layout.ksad_splash_vplush, (ViewGroup) null);
        this.f74108f = viewGroup;
        this.f74111i = (ImageView) viewGroup.findViewById(R.id.ksad_splash_frame);
        this.f74109g = (FrameLayout) this.f74108f.findViewById(R.id.ksad_splash_texture);
        this.f74110h = this.f74108f.findViewById(R.id.ksad_splash_close_btn);
        this.f74109g.setOnClickListener(new View.OnClickListener(this, b2, bVar) { // from class: com.kwad.sdk.splashscreen.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f74113a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ com.kwad.sdk.core.download.b.b f74114b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f74115c;

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
                this.f74115c = this;
                this.f74113a = b2;
                this.f74114b = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f74115c.f74112j) {
                    com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f74113a, new a.InterfaceC1992a(this) { // from class: com.kwad.sdk.splashscreen.a.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f74116a;

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
                            this.f74116a = this;
                        }

                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC1992a
                        public void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (this.f74116a.f74115c.f74107e != null) {
                                    this.f74116a.f74115c.f74107e.onAdClicked();
                                }
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("duration", this.f74116a.f74115c.f74106d.c());
                                } catch (JSONException e2) {
                                    com.kwad.sdk.core.d.a.a(e2);
                                }
                                com.kwad.sdk.core.report.a.a(this.f74116a.f74113a, 114, (v.a) null, jSONObject);
                            }
                        }
                    }, this.f74114b, false);
                    if (this.f74115c.f74104b != null) {
                        try {
                            if (com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.i(this.f74115c.f74106d.b()))) {
                                return;
                            }
                            this.f74115c.f74104b.removeView(this.f74115c.f74108f);
                        } catch (Exception e2) {
                            com.kwad.sdk.core.a.a.a(e2);
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                    }
                }
            }
        });
        this.f74109g.setClickable(true);
        this.f74109g.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.splashscreen.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public float f74117a;

            /* renamed from: b  reason: collision with root package name */
            public float f74118b;

            /* renamed from: c  reason: collision with root package name */
            public float f74119c;

            /* renamed from: d  reason: collision with root package name */
            public float f74120d;

            /* renamed from: e  reason: collision with root package name */
            public float f74121e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f74122f;

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
                this.f74122f = this;
                this.f74117a = 0.0f;
                this.f74118b = 0.0f;
                this.f74119c = 0.0f;
                this.f74120d = 0.0f;
                this.f74121e = 0.0f;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (this.f74122f.k == null) {
                        return false;
                    }
                    if (motionEvent.getActionMasked() == 0) {
                        this.f74117a = motionEvent.getRawX();
                        this.f74118b = motionEvent.getRawY();
                        this.f74120d = this.f74122f.k.x;
                        this.f74119c = this.f74122f.k.y;
                        this.f74121e = (float) SystemClock.elapsedRealtime();
                        PrintStream printStream = System.out;
                        printStream.println(" actionDownX " + this.f74117a + " actionDownX " + this.f74117a);
                    } else if (motionEvent.getActionMasked() == 2) {
                        float rawX = motionEvent.getRawX() - this.f74117a;
                        float rawY = motionEvent.getRawY() - this.f74118b;
                        if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                            this.f74122f.k.x = (int) (this.f74120d + rawX);
                            this.f74122f.k.y = (int) (this.f74119c + rawY);
                            if (this.f74122f.f74104b != null) {
                                try {
                                    this.f74122f.f74104b.updateViewLayout(this.f74122f.f74108f, this.f74122f.k);
                                } catch (Exception e2) {
                                    com.kwad.sdk.core.a.a.a(e2);
                                    com.kwad.sdk.core.d.a.a(e2);
                                }
                            }
                        }
                        return true;
                    } else if (motionEvent.getActionMasked() == 1) {
                        float rawX2 = motionEvent.getRawX() - this.f74117a;
                        float rawY2 = motionEvent.getRawY() - this.f74118b;
                        float elapsedRealtime = ((float) SystemClock.elapsedRealtime()) - this.f74121e;
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
            if (this.f74106d == null || this.f74104b == null) {
                return false;
            }
            Rect rect2 = new Rect();
            rect2.left = rect.left - av.a(this.f74103a, 6.0f);
            rect2.right = rect.right - av.a(this.f74103a, 6.0f);
            rect2.top = rect.top - av.a(this.f74103a, 6.0f);
            rect2.bottom = rect.bottom + av.a(this.f74103a, 6.0f);
            DisplayMetrics displayMetrics = this.f74103a.getResources().getDisplayMetrics();
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
            this.f74105c.setPivotX((i5 * i2) / ((i5 + i2) - i4));
            this.f74105c.setPivotY((i7 * i3) / ((i7 + i3) - i6));
            WindowManager windowManager = this.f74104b;
            if (windowManager != null) {
                try {
                    windowManager.addView(this.f74105c, this.k);
                } catch (Exception e2) {
                    com.kwad.sdk.core.a.a.a(e2);
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            this.f74105c.animate().scaleX(f2).scaleY(f3).setDuration(600L).start();
            this.f74105c.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new AnimatorListenerAdapter(this, rect2) { // from class: com.kwad.sdk.splashscreen.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Rect f74123a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f74124b;

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
                    this.f74124b = this;
                    this.f74123a = rect2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f74124b.k.x = this.f74123a.left - av.a(this.f74124b.f74103a, 6.0f);
                        this.f74124b.k.y = this.f74123a.top - av.a(this.f74124b.f74103a, 6.0f);
                        WindowManager.LayoutParams layoutParams2 = this.f74124b.k;
                        Rect rect3 = this.f74123a;
                        layoutParams2.width = (rect3.right - rect3.left) + av.a(this.f74124b.f74103a, 12.0f);
                        WindowManager.LayoutParams layoutParams3 = this.f74124b.k;
                        Rect rect4 = this.f74123a;
                        layoutParams3.height = (rect4.bottom - rect4.top) + av.a(this.f74124b.f74103a, 12.0f);
                        this.f74124b.f74105c.animate().cancel();
                        this.f74124b.f74111i.setImageDrawable(new BitmapDrawable(this.f74124b.f74103a.getResources(), this.f74124b.f74106d.f74195a));
                        ViewParent parent = this.f74124b.f74106d.a().getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(this.f74124b.f74106d.a());
                        }
                        this.f74124b.f74109g.addView(this.f74124b.f74106d.a(), new ViewGroup.MarginLayoutParams(-1, -1));
                        if (this.f74124b.f74104b != null) {
                            try {
                                this.f74124b.f74104b.addView(this.f74124b.f74108f, this.f74124b.k);
                            } catch (Exception e3) {
                                com.kwad.sdk.core.a.a.a(e3);
                                com.kwad.sdk.core.d.a.a(e3);
                            }
                        }
                        this.f74124b.f74106d.d();
                        this.f74124b.f74106d.a(new com.kwad.sdk.contentalliance.detail.video.d(this) { // from class: com.kwad.sdk.splashscreen.a.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f74125a;

                            /* renamed from: b  reason: collision with root package name */
                            public boolean f74126b;

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
                                this.f74125a = this;
                                this.f74126b = false;
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
                                if (!(interceptable3 == null || interceptable3.invokeV(1048583, this) == null) || this.f74126b) {
                                    return;
                                }
                                this.f74126b = true;
                                if (this.f74125a.f74124b.f74107e != null) {
                                    this.f74125a.f74124b.f74107e.onAdShowEnd();
                                }
                                this.f74125a.f74124b.f74106d.h();
                                if (this.f74125a.f74124b.f74104b != null) {
                                    try {
                                        if (Build.VERSION.SDK_INT < 19) {
                                            windowManager2 = this.f74125a.f74124b.f74104b;
                                            viewGroup = this.f74125a.f74124b.f74108f;
                                        } else if (!this.f74125a.f74124b.f74108f.isAttachedToWindow()) {
                                            return;
                                        } else {
                                            windowManager2 = this.f74125a.f74124b.f74104b;
                                            viewGroup = this.f74125a.f74124b.f74108f;
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
                        this.f74124b.f74105c.postDelayed(new ax(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.3.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f74127a;

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
                                this.f74127a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f74127a.f74124b.f74104b.removeView(this.f74127a.f74124b.f74105c);
                                    } catch (Exception e4) {
                                        com.kwad.sdk.core.a.a.a(e4);
                                    }
                                    if (Build.VERSION.SDK_INT >= 21) {
                                        this.f74127a.f74124b.f74106d.a().setOutlineProvider(new C2023a(av.a(this.f74127a.f74124b.f74103a, 1.0f)));
                                        this.f74127a.f74124b.f74106d.a().setClipToOutline(true);
                                        this.f74127a.f74124b.f74111i.setOutlineProvider(new C2023a(av.a(this.f74127a.f74124b.f74103a, 1.0f)));
                                        this.f74127a.f74124b.f74111i.setClipToOutline(true);
                                    }
                                }
                            }
                        }), 100L);
                        this.f74124b.f74111i.postDelayed(new ax(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.3.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f74128a;

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
                                this.f74128a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f74128a.f74124b.f74111i.setVisibility(8);
                                }
                            }
                        }), 200L);
                    }
                }
            });
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f74107e;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
            }
            com.kwad.sdk.core.report.a.c(this.f74106d.b(), 115, null);
            this.f74110h.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.splashscreen.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f74129a;

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
                    this.f74129a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f74129a.f74104b != null) {
                            try {
                                this.f74129a.f74104b.removeView(this.f74129a.f74108f);
                                this.f74129a.f74106d.h();
                            } catch (Exception e3) {
                                com.kwad.sdk.core.a.a.a(e3);
                            }
                        }
                        if (this.f74129a.f74107e != null) {
                            this.f74129a.f74107e.onSkippedAd();
                        }
                        if (this.f74129a.f74106d != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("duration", this.f74129a.f74106d.c());
                            } catch (JSONException e4) {
                                com.kwad.sdk.core.d.a.a(e4);
                            }
                            com.kwad.sdk.core.report.a.a(this.f74129a.f74106d.b(), 1, jSONObject);
                        }
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }
}
