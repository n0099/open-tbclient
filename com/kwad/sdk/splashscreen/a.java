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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f67405a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f67406b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f67407c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f67408d;

    /* renamed from: e  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f67409e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f67410f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f67411g;

    /* renamed from: h  reason: collision with root package name */
    public View f67412h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f67413i;
    public boolean j;
    public final WindowManager.LayoutParams k;

    @RequiresApi(api = 21)
    /* renamed from: com.kwad.sdk.splashscreen.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1973a extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f67431a;

        public C1973a(float f2) {
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
            this.f67431a = f2;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, outline) == null) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                float f2 = this.f67431a;
                int i2 = (int) f2;
                int i3 = (int) f2;
                outline.setRoundRect(new Rect(i2, i3, (rect.right - rect.left) - i2, (rect.bottom - rect.top) - i3), this.f67431a);
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
        this.f67405a = wrapContextIfNeed;
        this.f67409e = splashScreenAdInteractionListener;
        this.j = z;
        this.f67406b = (WindowManager) wrapContextIfNeed.getSystemService("window");
        com.kwad.sdk.splashscreen.b.a a2 = SplashPlayModuleCache.a().a(str);
        this.f67408d = a2;
        if (a2 == null || this.f67406b == null) {
            return;
        }
        ImageView imageView = new ImageView(this.f67405a);
        this.f67407c = imageView;
        imageView.setImageDrawable(new BitmapDrawable(this.f67405a.getResources(), this.f67408d.f67495a));
        AdTemplate b2 = this.f67408d.b();
        com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(b2);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f67405a).inflate(R.layout.ksad_splash_vplush, (ViewGroup) null);
        this.f67410f = viewGroup;
        this.f67413i = (ImageView) viewGroup.findViewById(R.id.ksad_splash_frame);
        this.f67411g = (FrameLayout) this.f67410f.findViewById(R.id.ksad_splash_texture);
        this.f67412h = this.f67410f.findViewById(R.id.ksad_splash_close_btn);
        this.f67411g.setOnClickListener(new View.OnClickListener(this, b2, bVar) { // from class: com.kwad.sdk.splashscreen.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f67414a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ com.kwad.sdk.core.download.b.b f67415b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f67416c;

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
                this.f67416c = this;
                this.f67414a = b2;
                this.f67415b = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f67416c.j) {
                    com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f67414a, new a.InterfaceC1941a(this) { // from class: com.kwad.sdk.splashscreen.a.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f67417a;

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
                            this.f67417a = this;
                        }

                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC1941a
                        public void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (this.f67417a.f67416c.f67409e != null) {
                                    this.f67417a.f67416c.f67409e.onAdClicked();
                                }
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("duration", this.f67417a.f67416c.f67408d.c());
                                } catch (JSONException e2) {
                                    com.kwad.sdk.core.d.a.a(e2);
                                }
                                com.kwad.sdk.core.report.a.a(this.f67417a.f67414a, 114, (v.a) null, jSONObject);
                            }
                        }
                    }, this.f67415b, false);
                    if (this.f67416c.f67406b != null) {
                        try {
                            if (com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.i(this.f67416c.f67408d.b()))) {
                                return;
                            }
                            this.f67416c.f67406b.removeView(this.f67416c.f67410f);
                        } catch (Exception e2) {
                            com.kwad.sdk.core.a.a.a(e2);
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                    }
                }
            }
        });
        this.f67411g.setClickable(true);
        this.f67411g.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.splashscreen.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public float f67418a;

            /* renamed from: b  reason: collision with root package name */
            public float f67419b;

            /* renamed from: c  reason: collision with root package name */
            public float f67420c;

            /* renamed from: d  reason: collision with root package name */
            public float f67421d;

            /* renamed from: e  reason: collision with root package name */
            public float f67422e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f67423f;

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
                this.f67423f = this;
                this.f67418a = 0.0f;
                this.f67419b = 0.0f;
                this.f67420c = 0.0f;
                this.f67421d = 0.0f;
                this.f67422e = 0.0f;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (this.f67423f.k == null) {
                        return false;
                    }
                    if (motionEvent.getActionMasked() == 0) {
                        this.f67418a = motionEvent.getRawX();
                        this.f67419b = motionEvent.getRawY();
                        this.f67421d = this.f67423f.k.x;
                        this.f67420c = this.f67423f.k.y;
                        this.f67422e = (float) SystemClock.elapsedRealtime();
                        PrintStream printStream = System.out;
                        printStream.println(" actionDownX " + this.f67418a + " actionDownX " + this.f67418a);
                    } else if (motionEvent.getActionMasked() == 2) {
                        float rawX = motionEvent.getRawX() - this.f67418a;
                        float rawY = motionEvent.getRawY() - this.f67419b;
                        if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                            this.f67423f.k.x = (int) (this.f67421d + rawX);
                            this.f67423f.k.y = (int) (this.f67420c + rawY);
                            if (this.f67423f.f67406b != null) {
                                try {
                                    this.f67423f.f67406b.updateViewLayout(this.f67423f.f67410f, this.f67423f.k);
                                } catch (Exception e2) {
                                    com.kwad.sdk.core.a.a.a(e2);
                                    com.kwad.sdk.core.d.a.a(e2);
                                }
                            }
                        }
                        return true;
                    } else if (motionEvent.getActionMasked() == 1) {
                        float rawX2 = motionEvent.getRawX() - this.f67418a;
                        float rawY2 = motionEvent.getRawY() - this.f67419b;
                        float elapsedRealtime = ((float) SystemClock.elapsedRealtime()) - this.f67422e;
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
            if (this.f67408d == null || this.f67406b == null) {
                return false;
            }
            Rect rect2 = new Rect();
            rect2.left = rect.left - av.a(this.f67405a, 6.0f);
            rect2.right = rect.right - av.a(this.f67405a, 6.0f);
            rect2.top = rect.top - av.a(this.f67405a, 6.0f);
            rect2.bottom = rect.bottom + av.a(this.f67405a, 6.0f);
            DisplayMetrics displayMetrics = this.f67405a.getResources().getDisplayMetrics();
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
            this.f67407c.setPivotX((i5 * i2) / ((i5 + i2) - i4));
            this.f67407c.setPivotY((i7 * i3) / ((i7 + i3) - i6));
            WindowManager windowManager = this.f67406b;
            if (windowManager != null) {
                try {
                    windowManager.addView(this.f67407c, this.k);
                } catch (Exception e2) {
                    com.kwad.sdk.core.a.a.a(e2);
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            this.f67407c.animate().scaleX(f2).scaleY(f3).setDuration(600L).start();
            this.f67407c.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new AnimatorListenerAdapter(this, rect2) { // from class: com.kwad.sdk.splashscreen.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Rect f67424a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f67425b;

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
                    this.f67425b = this;
                    this.f67424a = rect2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f67425b.k.x = this.f67424a.left - av.a(this.f67425b.f67405a, 6.0f);
                        this.f67425b.k.y = this.f67424a.top - av.a(this.f67425b.f67405a, 6.0f);
                        WindowManager.LayoutParams layoutParams2 = this.f67425b.k;
                        Rect rect3 = this.f67424a;
                        layoutParams2.width = (rect3.right - rect3.left) + av.a(this.f67425b.f67405a, 12.0f);
                        WindowManager.LayoutParams layoutParams3 = this.f67425b.k;
                        Rect rect4 = this.f67424a;
                        layoutParams3.height = (rect4.bottom - rect4.top) + av.a(this.f67425b.f67405a, 12.0f);
                        this.f67425b.f67407c.animate().cancel();
                        this.f67425b.f67413i.setImageDrawable(new BitmapDrawable(this.f67425b.f67405a.getResources(), this.f67425b.f67408d.f67495a));
                        ViewParent parent = this.f67425b.f67408d.a().getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(this.f67425b.f67408d.a());
                        }
                        this.f67425b.f67411g.addView(this.f67425b.f67408d.a(), new ViewGroup.MarginLayoutParams(-1, -1));
                        if (this.f67425b.f67406b != null) {
                            try {
                                this.f67425b.f67406b.addView(this.f67425b.f67410f, this.f67425b.k);
                            } catch (Exception e3) {
                                com.kwad.sdk.core.a.a.a(e3);
                                com.kwad.sdk.core.d.a.a(e3);
                            }
                        }
                        this.f67425b.f67408d.d();
                        this.f67425b.f67408d.a(new com.kwad.sdk.contentalliance.detail.video.d(this) { // from class: com.kwad.sdk.splashscreen.a.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f67426a;

                            /* renamed from: b  reason: collision with root package name */
                            public boolean f67427b;

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
                                this.f67426a = this;
                                this.f67427b = false;
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
                            public void a(long j, long j2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
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
                                if (!(interceptable3 == null || interceptable3.invokeV(1048583, this) == null) || this.f67427b) {
                                    return;
                                }
                                this.f67427b = true;
                                if (this.f67426a.f67425b.f67409e != null) {
                                    this.f67426a.f67425b.f67409e.onAdShowEnd();
                                }
                                this.f67426a.f67425b.f67408d.h();
                                if (this.f67426a.f67425b.f67406b != null) {
                                    try {
                                        if (Build.VERSION.SDK_INT < 19) {
                                            windowManager2 = this.f67426a.f67425b.f67406b;
                                            viewGroup = this.f67426a.f67425b.f67410f;
                                        } else if (!this.f67426a.f67425b.f67410f.isAttachedToWindow()) {
                                            return;
                                        } else {
                                            windowManager2 = this.f67426a.f67425b.f67406b;
                                            viewGroup = this.f67426a.f67425b.f67410f;
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
                        this.f67425b.f67407c.postDelayed(new ax(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.3.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f67428a;

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
                                this.f67428a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f67428a.f67425b.f67406b.removeView(this.f67428a.f67425b.f67407c);
                                    } catch (Exception e4) {
                                        com.kwad.sdk.core.a.a.a(e4);
                                    }
                                    if (Build.VERSION.SDK_INT >= 21) {
                                        this.f67428a.f67425b.f67408d.a().setOutlineProvider(new C1973a(av.a(this.f67428a.f67425b.f67405a, 1.0f)));
                                        this.f67428a.f67425b.f67408d.a().setClipToOutline(true);
                                        this.f67428a.f67425b.f67413i.setOutlineProvider(new C1973a(av.a(this.f67428a.f67425b.f67405a, 1.0f)));
                                        this.f67428a.f67425b.f67413i.setClipToOutline(true);
                                    }
                                }
                            }
                        }), 100L);
                        this.f67425b.f67413i.postDelayed(new ax(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.3.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f67429a;

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
                                this.f67429a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f67429a.f67425b.f67413i.setVisibility(8);
                                }
                            }
                        }), 200L);
                    }
                }
            });
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f67409e;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
            }
            com.kwad.sdk.core.report.a.c(this.f67408d.b(), 115, null);
            this.f67412h.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.splashscreen.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67430a;

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
                    this.f67430a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f67430a.f67406b != null) {
                            try {
                                this.f67430a.f67406b.removeView(this.f67430a.f67410f);
                                this.f67430a.f67408d.h();
                            } catch (Exception e3) {
                                com.kwad.sdk.core.a.a.a(e3);
                            }
                        }
                        if (this.f67430a.f67409e != null) {
                            this.f67430a.f67409e.onSkippedAd();
                        }
                        if (this.f67430a.f67408d != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("duration", this.f67430a.f67408d.c());
                            } catch (JSONException e4) {
                                com.kwad.sdk.core.d.a.a(e4);
                            }
                            com.kwad.sdk.core.report.a.a(this.f67430a.f67408d.b(), 1, jSONObject);
                        }
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }
}
