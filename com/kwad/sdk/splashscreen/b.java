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
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.z;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f59522b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f59523c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f59524d;

    /* renamed from: e  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f59525e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f59526f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f59527g;

    /* renamed from: h  reason: collision with root package name */
    public View f59528h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f59529i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f59530j;

    /* renamed from: k  reason: collision with root package name */
    public long f59531k;
    public boolean l;
    public long m;
    public boolean n;
    public final WindowManager.LayoutParams o;

    /* renamed from: com.kwad.sdk.splashscreen.b$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Rect a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f59539b;

        public AnonymousClass3(b bVar, Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, rect};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59539b = bVar;
            this.a = rect;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.f59539b.o.x = this.a.left - com.kwad.sdk.a.kwai.a.a(this.f59539b.a, 6.0f);
                this.f59539b.o.y = this.a.top - com.kwad.sdk.a.kwai.a.a(this.f59539b.a, 6.0f);
                WindowManager.LayoutParams layoutParams = this.f59539b.o;
                Rect rect = this.a;
                layoutParams.width = (rect.right - rect.left) + com.kwad.sdk.a.kwai.a.a(this.f59539b.a, 12.0f);
                WindowManager.LayoutParams layoutParams2 = this.f59539b.o;
                Rect rect2 = this.a;
                layoutParams2.height = (rect2.bottom - rect2.top) + com.kwad.sdk.a.kwai.a.a(this.f59539b.a, 12.0f);
                this.f59539b.f59523c.animate().cancel();
                this.f59539b.f59529i.setImageDrawable(new BitmapDrawable(this.f59539b.a.getResources(), this.f59539b.f59524d.a));
                ViewParent parent = this.f59539b.f59524d.a().getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f59539b.f59524d.a());
                }
                this.f59539b.f59527g.addView(this.f59539b.f59524d.a(), new ViewGroup.MarginLayoutParams(-1, -1));
                if (this.f59539b.f59522b != null) {
                    try {
                        this.f59539b.f59522b.addView(this.f59539b.f59526f, this.f59539b.o);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.kwai.a.a(e2);
                        com.kwad.sdk.core.d.a.b(e2);
                    }
                }
                this.f59539b.f59524d.d();
                this.f59539b.f59524d.a(new com.kwad.sdk.contentalliance.detail.video.d(this) { // from class: com.kwad.sdk.splashscreen.b.3.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass3 a;

                    /* renamed from: b  reason: collision with root package name */
                    public boolean f59540b;

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
                        this.a = this;
                        this.f59540b = false;
                    }

                    @Override // com.kwad.sdk.contentalliance.detail.video.d
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        }
                    }

                    @Override // com.kwad.sdk.contentalliance.detail.video.d
                    public void a(int i2, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                        }
                    }

                    @Override // com.kwad.sdk.contentalliance.detail.video.d
                    public void a(long j2, long j3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                            this.a.f59539b.b();
                            this.a.f59539b.c();
                        }
                    }

                    @Override // com.kwad.sdk.contentalliance.detail.video.d
                    public void b() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        }
                    }

                    @Override // com.kwad.sdk.contentalliance.detail.video.d
                    public void c() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        }
                    }

                    @Override // com.kwad.sdk.contentalliance.detail.video.d
                    public void d() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                        }
                    }

                    @Override // com.kwad.sdk.contentalliance.detail.video.d
                    public void e() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                        }
                    }

                    @Override // com.kwad.sdk.contentalliance.detail.video.d
                    public void f() {
                        WindowManager windowManager;
                        ViewGroup viewGroup;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048583, this) == null) || this.f59540b) {
                            return;
                        }
                        this.f59540b = true;
                        if (this.a.f59539b.f59525e != null) {
                            this.a.f59539b.f59525e.onAdShowEnd();
                        }
                        ax.a(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.b.3.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.a.a.f59539b.f59524d.h();
                                }
                            }
                        }, 0L);
                        if (this.a.f59539b.f59522b != null) {
                            try {
                                if (Build.VERSION.SDK_INT < 19) {
                                    windowManager = this.a.f59539b.f59522b;
                                    viewGroup = this.a.f59539b.f59526f;
                                } else if (!this.a.f59539b.f59526f.isAttachedToWindow()) {
                                    return;
                                } else {
                                    windowManager = this.a.f59539b.f59522b;
                                    viewGroup = this.a.f59539b.f59526f;
                                }
                                windowManager.removeView(viewGroup);
                            } catch (Exception e3) {
                                com.kwad.sdk.core.kwai.a.a(e3);
                            }
                        }
                    }

                    @Override // com.kwad.sdk.contentalliance.detail.video.d
                    public void g() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                        }
                    }

                    @Override // com.kwad.sdk.contentalliance.detail.video.d
                    public void h() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                        }
                    }
                });
                this.f59539b.f59523c.postDelayed(new bd(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.b.3.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass3 a;

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
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.f59539b.l = true;
                            this.a.f59539b.a();
                        }
                    }
                }), 100L);
                this.f59539b.m = System.currentTimeMillis() + 100;
                this.f59539b.f59529i.postDelayed(new bd(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.b.3.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass3 a;

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
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.f59539b.f59529i.setVisibility(8);
                            this.a.f59539b.f59530j = true;
                        }
                    }
                }), 200L);
                this.f59539b.f59531k = System.currentTimeMillis() + 200;
            }
        }
    }

    @RequiresApi(api = 21)
    /* loaded from: classes2.dex */
    public static class a extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        public a(float f2) {
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
            this.a = f2;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, outline) == null) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                float f2 = this.a;
                int i2 = (int) f2;
                int i3 = (int) f2;
                outline.setRoundRect(new Rect(i2, i3, (rect.right - rect.left) - i2, (rect.bottom - rect.top) - i3), this.a);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public b(Context context, String str, boolean z, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
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
        this.o = new WindowManager.LayoutParams();
        if (context == null) {
            return;
        }
        Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(context);
        this.a = wrapContextIfNeed;
        this.f59525e = splashScreenAdInteractionListener;
        this.n = z;
        this.f59522b = (WindowManager) wrapContextIfNeed.getSystemService("window");
        com.kwad.sdk.splashscreen.b.a a2 = SplashPlayModuleCache.a().a(str);
        this.f59524d = a2;
        if (a2 == null || this.f59522b == null) {
            return;
        }
        ImageView imageView = new ImageView(this.a);
        this.f59523c = imageView;
        imageView.setImageDrawable(new BitmapDrawable(this.a.getResources(), this.f59524d.a));
        AdTemplate b2 = this.f59524d.b();
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(b2);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(R.layout.ksad_splash_vplush, (ViewGroup) null);
        this.f59526f = viewGroup;
        this.f59529i = (ImageView) viewGroup.findViewById(R.id.ksad_splash_frame);
        this.f59527g = (FrameLayout) this.f59526f.findViewById(R.id.ksad_splash_texture);
        this.f59528h = this.f59526f.findViewById(R.id.ksad_splash_close_btn);
        this.f59527g.setOnClickListener(new View.OnClickListener(this, b2, bVar) { // from class: com.kwad.sdk.splashscreen.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ com.kwad.sdk.core.download.a.b f59532b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f59533c;

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
                this.f59533c = this;
                this.a = b2;
                this.f59532b = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f59533c.n) {
                    com.kwad.sdk.core.download.a.a.a(new a.C2015a(view.getContext()).a(this.a).a(this.f59532b).a(false).a(2).a(new a.b(this) { // from class: com.kwad.sdk.splashscreen.b.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 a;

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
                            this.a = this;
                        }

                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (this.a.f59533c.f59525e != null) {
                                    this.a.f59533c.f59525e.onAdClicked();
                                }
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("duration", this.a.f59533c.f59524d.c());
                                } catch (JSONException e2) {
                                    com.kwad.sdk.core.d.a.b(e2);
                                }
                                com.kwad.sdk.core.report.a.a(this.a.a, 114, (z.a) null, jSONObject);
                            }
                        }
                    }));
                    if (this.f59533c.f59522b != null) {
                        try {
                            this.f59533c.f59522b.removeView(this.f59533c.f59526f);
                        } catch (Exception e2) {
                            com.kwad.sdk.core.kwai.a.a(e2);
                            com.kwad.sdk.core.d.a.b(e2);
                        }
                    }
                }
            }
        });
        this.f59527g.setClickable(true);
        this.f59527g.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.splashscreen.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public float a;

            /* renamed from: b  reason: collision with root package name */
            public float f59534b;

            /* renamed from: c  reason: collision with root package name */
            public float f59535c;

            /* renamed from: d  reason: collision with root package name */
            public float f59536d;

            /* renamed from: e  reason: collision with root package name */
            public float f59537e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f59538f;

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
                this.f59538f = this;
                this.a = 0.0f;
                this.f59534b = 0.0f;
                this.f59535c = 0.0f;
                this.f59536d = 0.0f;
                this.f59537e = 0.0f;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (this.f59538f.o == null) {
                        return false;
                    }
                    if (motionEvent.getActionMasked() == 0) {
                        this.a = motionEvent.getRawX();
                        this.f59534b = motionEvent.getRawY();
                        this.f59536d = this.f59538f.o.x;
                        this.f59535c = this.f59538f.o.y;
                        this.f59537e = (float) SystemClock.elapsedRealtime();
                        PrintStream printStream = System.out;
                        printStream.println(" actionDownX " + this.a + " actionDownX " + this.a);
                    } else if (motionEvent.getActionMasked() == 2) {
                        float rawX = motionEvent.getRawX() - this.a;
                        float rawY = motionEvent.getRawY() - this.f59534b;
                        if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                            this.f59538f.o.x = (int) (this.f59536d + rawX);
                            this.f59538f.o.y = (int) (this.f59535c + rawY);
                            if (this.f59538f.f59522b != null) {
                                try {
                                    this.f59538f.f59522b.updateViewLayout(this.f59538f.f59526f, this.f59538f.o);
                                } catch (Exception e2) {
                                    com.kwad.sdk.core.kwai.a.a(e2);
                                    com.kwad.sdk.core.d.a.b(e2);
                                }
                            }
                        }
                        return true;
                    } else if (motionEvent.getActionMasked() == 1) {
                        float rawX2 = motionEvent.getRawX() - this.a;
                        float rawY2 = motionEvent.getRawY() - this.f59534b;
                        float elapsedRealtime = ((float) SystemClock.elapsedRealtime()) - this.f59537e;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            try {
                this.f59522b.removeView(this.f59523c);
            } catch (Exception e2) {
                com.kwad.sdk.core.kwai.a.a(e2);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.f59524d.a().setOutlineProvider(new a(com.kwad.sdk.a.kwai.a.a(this.a, 1.0f)));
                this.f59524d.a().setClipToOutline(true);
                this.f59529i.setOutlineProvider(new a(com.kwad.sdk.a.kwai.a.a(this.a, 1.0f)));
                this.f59529i.setClipToOutline(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.l || System.currentTimeMillis() <= this.m) {
            return;
        }
        this.l = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || this.f59530j || System.currentTimeMillis() <= this.f59531k) {
            return;
        }
        this.f59530j = true;
        this.f59529i.setVisibility(8);
    }

    @SuppressLint({"RtlHardcoded"})
    public boolean a(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rect)) == null) {
            if (this.f59524d == null || this.f59522b == null) {
                return false;
            }
            Rect rect2 = new Rect();
            rect2.left = rect.left - com.kwad.sdk.a.kwai.a.a(this.a, 6.0f);
            rect2.right = rect.right - com.kwad.sdk.a.kwai.a.a(this.a, 6.0f);
            rect2.top = rect.top - com.kwad.sdk.a.kwai.a.a(this.a, 6.0f);
            rect2.bottom = rect.bottom + com.kwad.sdk.a.kwai.a.a(this.a, 6.0f);
            DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
            WindowManager.LayoutParams layoutParams = this.o;
            layoutParams.type = 1003;
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
            this.f59523c.setPivotX((i5 * i2) / ((i5 + i2) - i4));
            this.f59523c.setPivotY((i7 * i3) / ((i7 + i3) - i6));
            WindowManager windowManager = this.f59522b;
            if (windowManager != null) {
                try {
                    windowManager.addView(this.f59523c, this.o);
                } catch (Exception e2) {
                    com.kwad.sdk.core.kwai.a.a(e2);
                    com.kwad.sdk.core.d.a.b(e2);
                }
            }
            this.f59523c.animate().scaleX(f2).scaleY(f3).setDuration(600L).start();
            this.f59523c.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new AnonymousClass3(this, rect2));
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f59525e;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
            }
            com.kwad.sdk.core.report.a.c(this.f59524d.b(), 115, null);
            this.f59528h.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.splashscreen.b.4
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
                        int i8 = newInitContext.flag;
                        if ((i8 & 1) != 0) {
                            int i9 = i8 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.a.f59522b != null) {
                            try {
                                this.a.f59522b.removeView(this.a.f59526f);
                                this.a.f59524d.h();
                            } catch (Exception e3) {
                                com.kwad.sdk.core.kwai.a.a(e3);
                            }
                        }
                        if (this.a.f59525e != null) {
                            this.a.f59525e.onSkippedAd();
                        }
                        if (this.a.f59524d != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("duration", this.a.f59524d.c());
                            } catch (JSONException e4) {
                                com.kwad.sdk.core.d.a.b(e4);
                            }
                            com.kwad.sdk.core.report.a.a(this.a.f59524d.b(), 1, jSONObject);
                        }
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }
}
