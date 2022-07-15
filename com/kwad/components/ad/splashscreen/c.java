package com.kwad.components.ad.splashscreen;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.l.o;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.y;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    @Nullable
    public WindowManager b;
    public ImageView c;
    public com.kwad.components.ad.splashscreen.c.a d;
    public KsSplashScreenAd.SplashScreenAdInteractionListener e;
    public ViewGroup f;
    public FrameLayout g;
    public View h;
    public ImageView i;
    public boolean j;
    public long k;
    public boolean l;
    public long m;
    public boolean n;
    public final WindowManager.LayoutParams o;

    /* renamed from: com.kwad.components.ad.splashscreen.c$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Rect a;
        public final /* synthetic */ c b;

        public AnonymousClass3(c cVar, Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, rect};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cVar;
            this.a = rect;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.b.o.x = this.a.left - com.kwad.sdk.b.kwai.a.a(this.b.a, 6.0f);
                this.b.o.y = this.a.top - com.kwad.sdk.b.kwai.a.a(this.b.a, 6.0f);
                WindowManager.LayoutParams layoutParams = this.b.o;
                Rect rect = this.a;
                layoutParams.width = (rect.right - rect.left) + com.kwad.sdk.b.kwai.a.a(this.b.a, 12.0f);
                WindowManager.LayoutParams layoutParams2 = this.b.o;
                Rect rect2 = this.a;
                layoutParams2.height = (rect2.bottom - rect2.top) + com.kwad.sdk.b.kwai.a.a(this.b.a, 12.0f);
                this.b.c.animate().cancel();
                this.b.i.setImageDrawable(new BitmapDrawable(this.b.a.getResources(), this.b.d.a));
                ViewParent parent = this.b.d.c().getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.b.d.c());
                }
                this.b.g.addView(this.b.d.c(), new ViewGroup.MarginLayoutParams(-1, -1));
                if (this.b.b != null) {
                    try {
                        this.b.b.addView(this.b.f, this.b.o);
                    } catch (Exception e) {
                        com.kwad.components.core.b.a.a(e);
                        com.kwad.sdk.core.d.b.b(e);
                    }
                }
                this.b.d.f();
                this.b.d.a(new com.kwad.components.core.video.g(this) { // from class: com.kwad.components.ad.splashscreen.c.3.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass3 a;
                    public boolean b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                        this.b = false;
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void a(int i, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void a(long j, long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                            this.a.b.b();
                            this.a.b.c();
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void b() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void c() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void d() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.b) {
                            return;
                        }
                        this.b = true;
                        if (this.a.b.e != null) {
                            this.a.b.e.onAdShowEnd();
                        }
                        az.a(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.c.3.1.1
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
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.a.a.b.d.h();
                                }
                            }
                        }, 0L);
                        if (this.a.b.b != null) {
                            try {
                                if (Build.VERSION.SDK_INT < 19) {
                                    this.a.b.b.removeView(this.a.b.f);
                                } else if (this.a.b.f.isAttachedToWindow()) {
                                    this.a.b.b.removeView(this.a.b.f);
                                }
                            } catch (Exception e2) {
                                com.kwad.components.core.b.a.a(e2);
                            }
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void e() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void f() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void g() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void h() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                        }
                    }
                });
                this.b.c.postDelayed(new o(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.c.3.2
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.b.l = true;
                            this.a.b.a();
                        }
                    }
                }), 100L);
                this.b.m = System.currentTimeMillis() + 100;
                this.b.i.postDelayed(new o(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.c.3.3
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.b.i.setVisibility(8);
                            this.a.b.j = true;
                        }
                    }
                }), 200L);
                this.b.k = System.currentTimeMillis() + 200;
            }
        }
    }

    @RequiresApi(api = 21)
    /* loaded from: classes5.dex */
    public static class a extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        public a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View view2, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, outline) == null) {
                Rect rect = new Rect();
                view2.getGlobalVisibleRect(rect);
                float f = this.a;
                int i = (int) f;
                int i2 = (int) f;
                outline.setRoundRect(new Rect(i, i2, (rect.right - rect.left) - i, (rect.bottom - rect.top) - i2), this.a);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public c(Context context, String str, boolean z, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z), splashScreenAdInteractionListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.e = splashScreenAdInteractionListener;
        this.n = z;
        this.b = (WindowManager) wrapContextIfNeed.getSystemService("window");
        com.kwad.components.ad.splashscreen.c.a a2 = SplashPlayModuleCache.a().a(str);
        this.d = a2;
        if (a2 == null || this.b == null) {
            return;
        }
        ImageView imageView = new ImageView(this.a);
        this.c = imageView;
        imageView.setImageDrawable(new BitmapDrawable(this.a.getResources(), this.d.a));
        AdTemplate d = this.d.d();
        com.kwad.components.core.c.a.b bVar = new com.kwad.components.core.c.a.b(d);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d046d, (ViewGroup) null);
        this.f = viewGroup;
        this.i = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911a7);
        this.g = (FrameLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0911b1);
        this.h = this.f.findViewById(R.id.obfuscated_res_0x7f0911a5);
        this.g.setOnClickListener(new View.OnClickListener(this, d, bVar) { // from class: com.kwad.components.ad.splashscreen.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate a;
            public final /* synthetic */ com.kwad.components.core.c.a.b b;
            public final /* synthetic */ c c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, d, bVar};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.c = this;
                this.a = d;
                this.b = bVar;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && this.c.n) {
                    com.kwad.components.core.c.a.a.a(new a.C0507a(view2.getContext()).a(this.a).a(this.b).a(false).a(2).a(new a.b(this) { // from class: com.kwad.components.ad.splashscreen.c.1.1
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
                                int i3 = newInitContext2.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // com.kwad.components.core.c.a.a.b
                        public final void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (this.a.c.e != null) {
                                    this.a.c.e.onAdClicked();
                                }
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("duration", this.a.c.d.e());
                                } catch (JSONException e) {
                                    com.kwad.sdk.core.d.b.b(e);
                                }
                                com.kwad.sdk.core.report.a.a(this.a.a, 114, (y.a) null, jSONObject);
                            }
                        }
                    }));
                    if (this.c.b != null) {
                        try {
                            this.c.b.removeView(this.c.f);
                        } catch (Exception e) {
                            com.kwad.components.core.b.a.a(e);
                            com.kwad.sdk.core.d.b.b(e);
                        }
                    }
                }
            }
        });
        this.g.setClickable(true);
        this.g.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.components.ad.splashscreen.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public float a;
            public float b;
            public float c;
            public float d;
            public long e;
            public final /* synthetic */ c f;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f = this;
                this.a = 0.0f;
                this.b = 0.0f;
                this.c = 0.0f;
                this.d = 0.0f;
                this.e = 0L;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    if (this.f.o == null) {
                        return false;
                    }
                    if (motionEvent.getActionMasked() == 0) {
                        this.a = motionEvent.getRawX();
                        this.b = motionEvent.getRawY();
                        this.d = this.f.o.x;
                        this.c = this.f.o.y;
                        this.e = SystemClock.elapsedRealtime();
                        PrintStream printStream = System.out;
                        printStream.println(" actionDownX " + this.a + " actionDownX " + this.a);
                    } else if (motionEvent.getActionMasked() == 2) {
                        float rawX = motionEvent.getRawX() - this.a;
                        float rawY = motionEvent.getRawY() - this.b;
                        if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                            this.f.o.x = (int) (this.d + rawX);
                            this.f.o.y = (int) (this.c + rawY);
                            if (this.f.b != null) {
                                try {
                                    this.f.b.updateViewLayout(this.f.f, this.f.o);
                                } catch (Exception e) {
                                    com.kwad.components.core.b.a.a(e);
                                    com.kwad.sdk.core.d.b.b(e);
                                }
                            }
                        }
                        return true;
                    } else if (motionEvent.getActionMasked() == 1) {
                        float rawX2 = motionEvent.getRawX() - this.a;
                        float rawY2 = motionEvent.getRawY() - this.b;
                        float elapsedRealtime = (float) (SystemClock.elapsedRealtime() - this.e);
                        if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && elapsedRealtime > 30.0f && elapsedRealtime < 300.0f) {
                            view2.performClick();
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
                this.b.removeView(this.c);
            } catch (Exception e) {
                com.kwad.components.core.b.a.a(e);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.d.c().setOutlineProvider(new a(com.kwad.sdk.b.kwai.a.a(this.a, 1.0f)));
                this.d.c().setClipToOutline(true);
                this.i.setOutlineProvider(new a(com.kwad.sdk.b.kwai.a.a(this.a, 1.0f)));
                this.i.setClipToOutline(true);
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
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || this.j || System.currentTimeMillis() <= this.k) {
            return;
        }
        this.j = true;
        this.i.setVisibility(8);
    }

    @SuppressLint({"RtlHardcoded"})
    public final boolean a(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rect)) == null) {
            if (this.d == null || this.b == null) {
                return false;
            }
            Rect rect2 = new Rect();
            rect2.left = rect.left - com.kwad.sdk.b.kwai.a.a(this.a, 6.0f);
            rect2.right = rect.right - com.kwad.sdk.b.kwai.a.a(this.a, 6.0f);
            rect2.top = rect.top - com.kwad.sdk.b.kwai.a.a(this.a, 6.0f);
            rect2.bottom = rect.bottom + com.kwad.sdk.b.kwai.a.a(this.a, 6.0f);
            DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
            WindowManager.LayoutParams layoutParams = this.o;
            layoutParams.type = 1003;
            layoutParams.flags = 8;
            layoutParams.gravity = 51;
            layoutParams.format = 1;
            int i = displayMetrics.widthPixels;
            layoutParams.width = i;
            int i2 = displayMetrics.heightPixels;
            layoutParams.height = i2;
            layoutParams.x = 0;
            layoutParams.y = 0;
            int i3 = rect2.right;
            int i4 = rect2.left;
            float f = (i3 - i4) / i;
            int i5 = rect2.bottom;
            int i6 = rect2.top;
            float f2 = (i5 - i6) / i2;
            this.c.setPivotX((i4 * i) / ((i4 + i) - i3));
            this.c.setPivotY((i6 * i2) / ((i6 + i2) - i5));
            WindowManager windowManager = this.b;
            if (windowManager != null) {
                try {
                    windowManager.addView(this.c, this.o);
                } catch (Exception e) {
                    com.kwad.components.core.b.a.a(e);
                    com.kwad.sdk.core.d.b.b(e);
                }
            }
            this.c.animate().scaleX(f).scaleY(f2).setDuration(600L).start();
            this.c.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new AnonymousClass3(this, rect2));
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.e;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
            }
            com.kwad.sdk.core.report.a.c(this.d.d(), 115, (JSONObject) null);
            this.h.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.splashscreen.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i7 = newInitContext.flag;
                        if ((i7 & 1) != 0) {
                            int i8 = i7 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (this.a.b != null) {
                            try {
                                this.a.b.removeView(this.a.f);
                                this.a.d.h();
                            } catch (Exception e2) {
                                com.kwad.components.core.b.a.a(e2);
                            }
                        }
                        if (this.a.e != null) {
                            this.a.e.onSkippedAd();
                        }
                        if (this.a.d != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("duration", this.a.d.e());
                            } catch (JSONException e3) {
                                com.kwad.sdk.core.d.b.b(e3);
                            }
                            com.kwad.sdk.core.report.a.a(this.a.d.d(), 1, jSONObject);
                        }
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }
}
