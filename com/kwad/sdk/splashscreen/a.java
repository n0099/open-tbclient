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
    public Context f66492a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f66493b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f66494c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f66495d;

    /* renamed from: e  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f66496e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f66497f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f66498g;

    /* renamed from: h  reason: collision with root package name */
    public View f66499h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f66500i;
    public boolean j;
    public final WindowManager.LayoutParams k;

    @RequiresApi(api = 21)
    /* renamed from: com.kwad.sdk.splashscreen.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1933a extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f66518a;

        public C1933a(float f2) {
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
            this.f66518a = f2;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, outline) == null) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                float f2 = this.f66518a;
                int i2 = (int) f2;
                int i3 = (int) f2;
                outline.setRoundRect(new Rect(i2, i3, (rect.right - rect.left) - i2, (rect.bottom - rect.top) - i3), this.f66518a);
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
        this.f66492a = wrapContextIfNeed;
        this.f66496e = splashScreenAdInteractionListener;
        this.j = z;
        this.f66493b = (WindowManager) wrapContextIfNeed.getSystemService("window");
        com.kwad.sdk.splashscreen.b.a a2 = SplashPlayModuleCache.a().a(str);
        this.f66495d = a2;
        if (a2 == null || this.f66493b == null) {
            return;
        }
        ImageView imageView = new ImageView(this.f66492a);
        this.f66494c = imageView;
        imageView.setImageDrawable(new BitmapDrawable(this.f66492a.getResources(), this.f66495d.f66582a));
        AdTemplate b2 = this.f66495d.b();
        com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(b2);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f66492a).inflate(R.layout.ksad_splash_vplush, (ViewGroup) null);
        this.f66497f = viewGroup;
        this.f66500i = (ImageView) viewGroup.findViewById(R.id.ksad_splash_frame);
        this.f66498g = (FrameLayout) this.f66497f.findViewById(R.id.ksad_splash_texture);
        this.f66499h = this.f66497f.findViewById(R.id.ksad_splash_close_btn);
        this.f66498g.setOnClickListener(new View.OnClickListener(this, b2, bVar) { // from class: com.kwad.sdk.splashscreen.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f66501a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ com.kwad.sdk.core.download.b.b f66502b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f66503c;

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
                this.f66503c = this;
                this.f66501a = b2;
                this.f66502b = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f66503c.j) {
                    com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f66501a, new a.InterfaceC1901a(this) { // from class: com.kwad.sdk.splashscreen.a.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f66504a;

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
                            this.f66504a = this;
                        }

                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC1901a
                        public void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (this.f66504a.f66503c.f66496e != null) {
                                    this.f66504a.f66503c.f66496e.onAdClicked();
                                }
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("duration", this.f66504a.f66503c.f66495d.c());
                                } catch (JSONException e2) {
                                    com.kwad.sdk.core.d.a.a(e2);
                                }
                                com.kwad.sdk.core.report.a.a(this.f66504a.f66501a, 114, (v.a) null, jSONObject);
                            }
                        }
                    }, this.f66502b, false);
                    if (this.f66503c.f66493b != null) {
                        try {
                            if (com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.i(this.f66503c.f66495d.b()))) {
                                return;
                            }
                            this.f66503c.f66493b.removeView(this.f66503c.f66497f);
                        } catch (Exception e2) {
                            com.kwad.sdk.core.a.a.a(e2);
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                    }
                }
            }
        });
        this.f66498g.setClickable(true);
        this.f66498g.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.splashscreen.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public float f66505a;

            /* renamed from: b  reason: collision with root package name */
            public float f66506b;

            /* renamed from: c  reason: collision with root package name */
            public float f66507c;

            /* renamed from: d  reason: collision with root package name */
            public float f66508d;

            /* renamed from: e  reason: collision with root package name */
            public float f66509e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f66510f;

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
                this.f66510f = this;
                this.f66505a = 0.0f;
                this.f66506b = 0.0f;
                this.f66507c = 0.0f;
                this.f66508d = 0.0f;
                this.f66509e = 0.0f;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (this.f66510f.k == null) {
                        return false;
                    }
                    if (motionEvent.getActionMasked() == 0) {
                        this.f66505a = motionEvent.getRawX();
                        this.f66506b = motionEvent.getRawY();
                        this.f66508d = this.f66510f.k.x;
                        this.f66507c = this.f66510f.k.y;
                        this.f66509e = (float) SystemClock.elapsedRealtime();
                        PrintStream printStream = System.out;
                        printStream.println(" actionDownX " + this.f66505a + " actionDownX " + this.f66505a);
                    } else if (motionEvent.getActionMasked() == 2) {
                        float rawX = motionEvent.getRawX() - this.f66505a;
                        float rawY = motionEvent.getRawY() - this.f66506b;
                        if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                            this.f66510f.k.x = (int) (this.f66508d + rawX);
                            this.f66510f.k.y = (int) (this.f66507c + rawY);
                            if (this.f66510f.f66493b != null) {
                                try {
                                    this.f66510f.f66493b.updateViewLayout(this.f66510f.f66497f, this.f66510f.k);
                                } catch (Exception e2) {
                                    com.kwad.sdk.core.a.a.a(e2);
                                    com.kwad.sdk.core.d.a.a(e2);
                                }
                            }
                        }
                        return true;
                    } else if (motionEvent.getActionMasked() == 1) {
                        float rawX2 = motionEvent.getRawX() - this.f66505a;
                        float rawY2 = motionEvent.getRawY() - this.f66506b;
                        float elapsedRealtime = ((float) SystemClock.elapsedRealtime()) - this.f66509e;
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
            if (this.f66495d == null || this.f66493b == null) {
                return false;
            }
            Rect rect2 = new Rect();
            rect2.left = rect.left - av.a(this.f66492a, 6.0f);
            rect2.right = rect.right - av.a(this.f66492a, 6.0f);
            rect2.top = rect.top - av.a(this.f66492a, 6.0f);
            rect2.bottom = rect.bottom + av.a(this.f66492a, 6.0f);
            DisplayMetrics displayMetrics = this.f66492a.getResources().getDisplayMetrics();
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
            this.f66494c.setPivotX((i5 * i2) / ((i5 + i2) - i4));
            this.f66494c.setPivotY((i7 * i3) / ((i7 + i3) - i6));
            WindowManager windowManager = this.f66493b;
            if (windowManager != null) {
                try {
                    windowManager.addView(this.f66494c, this.k);
                } catch (Exception e2) {
                    com.kwad.sdk.core.a.a.a(e2);
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            this.f66494c.animate().scaleX(f2).scaleY(f3).setDuration(600L).start();
            this.f66494c.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new AnimatorListenerAdapter(this, rect2) { // from class: com.kwad.sdk.splashscreen.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Rect f66511a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f66512b;

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
                    this.f66512b = this;
                    this.f66511a = rect2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f66512b.k.x = this.f66511a.left - av.a(this.f66512b.f66492a, 6.0f);
                        this.f66512b.k.y = this.f66511a.top - av.a(this.f66512b.f66492a, 6.0f);
                        WindowManager.LayoutParams layoutParams2 = this.f66512b.k;
                        Rect rect3 = this.f66511a;
                        layoutParams2.width = (rect3.right - rect3.left) + av.a(this.f66512b.f66492a, 12.0f);
                        WindowManager.LayoutParams layoutParams3 = this.f66512b.k;
                        Rect rect4 = this.f66511a;
                        layoutParams3.height = (rect4.bottom - rect4.top) + av.a(this.f66512b.f66492a, 12.0f);
                        this.f66512b.f66494c.animate().cancel();
                        this.f66512b.f66500i.setImageDrawable(new BitmapDrawable(this.f66512b.f66492a.getResources(), this.f66512b.f66495d.f66582a));
                        ViewParent parent = this.f66512b.f66495d.a().getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(this.f66512b.f66495d.a());
                        }
                        this.f66512b.f66498g.addView(this.f66512b.f66495d.a(), new ViewGroup.MarginLayoutParams(-1, -1));
                        if (this.f66512b.f66493b != null) {
                            try {
                                this.f66512b.f66493b.addView(this.f66512b.f66497f, this.f66512b.k);
                            } catch (Exception e3) {
                                com.kwad.sdk.core.a.a.a(e3);
                                com.kwad.sdk.core.d.a.a(e3);
                            }
                        }
                        this.f66512b.f66495d.d();
                        this.f66512b.f66495d.a(new com.kwad.sdk.contentalliance.detail.video.d(this) { // from class: com.kwad.sdk.splashscreen.a.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f66513a;

                            /* renamed from: b  reason: collision with root package name */
                            public boolean f66514b;

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
                                this.f66513a = this;
                                this.f66514b = false;
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
                                if (!(interceptable3 == null || interceptable3.invokeV(1048583, this) == null) || this.f66514b) {
                                    return;
                                }
                                this.f66514b = true;
                                if (this.f66513a.f66512b.f66496e != null) {
                                    this.f66513a.f66512b.f66496e.onAdShowEnd();
                                }
                                this.f66513a.f66512b.f66495d.h();
                                if (this.f66513a.f66512b.f66493b != null) {
                                    try {
                                        if (Build.VERSION.SDK_INT < 19) {
                                            windowManager2 = this.f66513a.f66512b.f66493b;
                                            viewGroup = this.f66513a.f66512b.f66497f;
                                        } else if (!this.f66513a.f66512b.f66497f.isAttachedToWindow()) {
                                            return;
                                        } else {
                                            windowManager2 = this.f66513a.f66512b.f66493b;
                                            viewGroup = this.f66513a.f66512b.f66497f;
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
                        this.f66512b.f66494c.postDelayed(new ax(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.3.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f66515a;

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
                                this.f66515a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f66515a.f66512b.f66493b.removeView(this.f66515a.f66512b.f66494c);
                                    } catch (Exception e4) {
                                        com.kwad.sdk.core.a.a.a(e4);
                                    }
                                    if (Build.VERSION.SDK_INT >= 21) {
                                        this.f66515a.f66512b.f66495d.a().setOutlineProvider(new C1933a(av.a(this.f66515a.f66512b.f66492a, 1.0f)));
                                        this.f66515a.f66512b.f66495d.a().setClipToOutline(true);
                                        this.f66515a.f66512b.f66500i.setOutlineProvider(new C1933a(av.a(this.f66515a.f66512b.f66492a, 1.0f)));
                                        this.f66515a.f66512b.f66500i.setClipToOutline(true);
                                    }
                                }
                            }
                        }), 100L);
                        this.f66512b.f66500i.postDelayed(new ax(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.3.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f66516a;

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
                                this.f66516a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f66516a.f66512b.f66500i.setVisibility(8);
                                }
                            }
                        }), 200L);
                    }
                }
            });
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f66496e;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
            }
            com.kwad.sdk.core.report.a.c(this.f66495d.b(), 115, null);
            this.f66499h.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.splashscreen.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66517a;

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
                    this.f66517a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f66517a.f66493b != null) {
                            try {
                                this.f66517a.f66493b.removeView(this.f66517a.f66497f);
                                this.f66517a.f66495d.h();
                            } catch (Exception e3) {
                                com.kwad.sdk.core.a.a.a(e3);
                            }
                        }
                        if (this.f66517a.f66496e != null) {
                            this.f66517a.f66496e.onSkippedAd();
                        }
                        if (this.f66517a.f66495d != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("duration", this.f66517a.f66495d.c());
                            } catch (JSONException e4) {
                                com.kwad.sdk.core.d.a.a(e4);
                            }
                            com.kwad.sdk.core.report.a.a(this.f66517a.f66495d.b(), 1, jSONObject);
                        }
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }
}
