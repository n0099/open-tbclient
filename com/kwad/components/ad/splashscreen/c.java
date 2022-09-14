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
import com.kwad.components.core.m.o;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bd;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public ViewGroup uL;
    public boolean xA;
    public long xB;
    public boolean xC;
    public long xD;
    public boolean xE;
    public final WindowManager.LayoutParams xF;
    @Nullable
    public WindowManager xt;
    public ImageView xu;
    public com.kwad.components.ad.splashscreen.c.a xv;
    public KsSplashScreenAd.SplashScreenAdInteractionListener xw;
    public FrameLayout xx;
    public View xy;
    public ImageView xz;

    /* renamed from: com.kwad.components.ad.splashscreen.c$3  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass3 extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c xI;
        public final /* synthetic */ Rect xN;

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
            this.xI = cVar;
            this.xN = rect;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.xI.xF.x = this.xN.left - com.kwad.sdk.b.kwai.a.a(this.xI.mContext, 6.0f);
                this.xI.xF.y = this.xN.top - com.kwad.sdk.b.kwai.a.a(this.xI.mContext, 6.0f);
                WindowManager.LayoutParams layoutParams = this.xI.xF;
                Rect rect = this.xN;
                layoutParams.width = (rect.right - rect.left) + com.kwad.sdk.b.kwai.a.a(this.xI.mContext, 12.0f);
                WindowManager.LayoutParams layoutParams2 = this.xI.xF;
                Rect rect2 = this.xN;
                layoutParams2.height = (rect2.bottom - rect2.top) + com.kwad.sdk.b.kwai.a.a(this.xI.mContext, 12.0f);
                this.xI.xu.animate().cancel();
                this.xI.xz.setImageDrawable(new BitmapDrawable(this.xI.mContext.getResources(), this.xI.xv.mBitmap));
                ViewParent parent = this.xI.xv.ky().getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.xI.xv.ky());
                }
                this.xI.xx.addView(this.xI.xv.ky(), new ViewGroup.MarginLayoutParams(-1, -1));
                if (this.xI.xt != null) {
                    try {
                        this.xI.xt.addView(this.xI.uL, this.xI.xF);
                    } catch (Exception e) {
                        com.kwad.components.core.b.a.b(e);
                        com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                    }
                }
                this.xI.xv.resume();
                this.xI.xv.a(new com.kwad.components.core.video.g(this) { // from class: com.kwad.components.ad.splashscreen.c.3.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public boolean xO;
                    public final /* synthetic */ AnonymousClass3 xP;

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
                        this.xP = this;
                        this.xO = false;
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void onVideoPlayBufferingPaused() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void onVideoPlayBufferingPlaying() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void onVideoPlayCompleted() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.xO) {
                            return;
                        }
                        this.xO = true;
                        if (this.xP.xI.xw != null) {
                            this.xP.xI.xw.onAdShowEnd();
                        }
                        bd.runOnUiThreadDelay(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.c.3.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 xQ;

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
                                this.xQ = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.xQ.xP.xI.xv.release();
                                }
                            }
                        }, 0L);
                        if (this.xP.xI.xt != null) {
                            try {
                                if (Build.VERSION.SDK_INT < 19) {
                                    this.xP.xI.xt.removeView(this.xP.xI.uL);
                                } else if (this.xP.xI.uL.isAttachedToWindow()) {
                                    this.xP.xI.xt.removeView(this.xP.xI.uL);
                                }
                            } catch (Exception e2) {
                                com.kwad.components.core.b.a.b(e2);
                            }
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void onVideoPlayError(int i, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeII(1048579, this, i, i2) == null) {
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void onVideoPlayPaused() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void onVideoPlayProgress(long j, long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                            this.xP.xI.jq();
                            this.xP.xI.jr();
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void onVideoPlayStart() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void onVideoPlaying() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void onVideoPrepared() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                        }
                    }

                    @Override // com.kwad.components.core.video.g
                    public final void onVideoPreparing() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                        }
                    }
                });
                this.xI.xu.postDelayed(new o(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.c.3.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass3 xP;

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
                        this.xP = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.xP.xI.xC = true;
                            this.xP.xI.jp();
                        }
                    }
                }), 100L);
                this.xI.xD = System.currentTimeMillis() + 100;
                this.xI.xz.postDelayed(new o(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.c.3.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass3 xP;

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
                        this.xP = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.xP.xI.xz.setVisibility(8);
                            this.xP.xI.xA = true;
                        }
                    }
                }), 200L);
                this.xI.xB = System.currentTimeMillis() + 200;
            }
        }
    }

    @RequiresApi(api = 21)
    /* loaded from: classes7.dex */
    public static class a extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float wm;

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
            this.wm = f;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View view2, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, outline) == null) {
                Rect rect = new Rect();
                view2.getGlobalVisibleRect(rect);
                float f = this.wm;
                int i = (int) f;
                int i2 = (int) f;
                outline.setRoundRect(new Rect(i, i2, (rect.right - rect.left) - i, (rect.bottom - rect.top) - i2), this.wm);
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
        this.xF = new WindowManager.LayoutParams();
        if (context == null) {
            return;
        }
        Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(context);
        this.mContext = wrapContextIfNeed;
        this.xw = splashScreenAdInteractionListener;
        this.xE = z;
        this.xt = (WindowManager) wrapContextIfNeed.getSystemService("window");
        com.kwad.components.ad.splashscreen.c.a X = SplashPlayModuleCache.getInstance().X(str);
        this.xv = X;
        if (X == null || this.xt == null) {
            return;
        }
        ImageView imageView = new ImageView(this.mContext);
        this.xu = imageView;
        imageView.setImageDrawable(new BitmapDrawable(this.mContext.getResources(), this.xv.mBitmap));
        AdTemplate adTemplate = this.xv.getAdTemplate();
        com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(adTemplate);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0474, (ViewGroup) null);
        this.uL = viewGroup;
        this.xz = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911f8);
        this.xx = (FrameLayout) this.uL.findViewById(R.id.obfuscated_res_0x7f091202);
        this.xy = this.uL.findViewById(R.id.obfuscated_res_0x7f0911f6);
        this.xx.setOnClickListener(new View.OnClickListener(this, adTemplate, cVar) { // from class: com.kwad.components.ad.splashscreen.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate xG;
            public final /* synthetic */ com.kwad.components.core.c.a.c xH;
            public final /* synthetic */ c xI;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, adTemplate, cVar};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.xI = this;
                this.xG = adTemplate;
                this.xH = cVar;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && this.xI.xE) {
                    com.kwad.components.core.c.a.a.a(new a.C0574a(view2.getContext()).L(this.xG).b(this.xH).aj(false).ae(2).a(new a.b(this) { // from class: com.kwad.components.ad.splashscreen.c.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 xJ;

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
                            this.xJ = this;
                        }

                        @Override // com.kwad.components.core.c.a.a.b
                        public final void onAdClicked() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (this.xJ.xI.xw != null) {
                                    this.xJ.xI.xw.onAdClicked();
                                }
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("duration", this.xJ.xI.xv.getCurrentPosition());
                                } catch (JSONException e) {
                                    com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                                }
                                com.kwad.sdk.core.report.a.a(this.xJ.xG, 114, (aa.a) null, jSONObject);
                            }
                        }
                    }));
                    if (this.xI.xt != null) {
                        try {
                            this.xI.xt.removeView(this.xI.uL);
                        } catch (Exception e) {
                            com.kwad.components.core.b.a.b(e);
                            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                        }
                    }
                }
            }
        });
        this.xx.setClickable(true);
        this.xx.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.components.ad.splashscreen.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public float left;
            public float top;
            public final /* synthetic */ c xI;
            public float xK;
            public float xL;
            public long xM;

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
                this.xI = this;
                this.xK = 0.0f;
                this.xL = 0.0f;
                this.top = 0.0f;
                this.left = 0.0f;
                this.xM = 0L;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    if (this.xI.xF == null) {
                        return false;
                    }
                    if (motionEvent.getActionMasked() == 0) {
                        this.xK = motionEvent.getRawX();
                        this.xL = motionEvent.getRawY();
                        this.left = this.xI.xF.x;
                        this.top = this.xI.xF.y;
                        this.xM = SystemClock.elapsedRealtime();
                        PrintStream printStream = System.out;
                        printStream.println(" actionDownX " + this.xK + " actionDownX " + this.xK);
                    } else if (motionEvent.getActionMasked() == 2) {
                        float rawX = motionEvent.getRawX() - this.xK;
                        float rawY = motionEvent.getRawY() - this.xL;
                        if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                            this.xI.xF.x = (int) (this.left + rawX);
                            this.xI.xF.y = (int) (this.top + rawY);
                            if (this.xI.xt != null) {
                                try {
                                    this.xI.xt.updateViewLayout(this.xI.uL, this.xI.xF);
                                } catch (Exception e) {
                                    com.kwad.components.core.b.a.b(e);
                                    com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                                }
                            }
                        }
                        return true;
                    } else if (motionEvent.getActionMasked() == 1) {
                        float rawX2 = motionEvent.getRawX() - this.xK;
                        float rawY2 = motionEvent.getRawY() - this.xL;
                        float elapsedRealtime = (float) (SystemClock.elapsedRealtime() - this.xM);
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
    public void jp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            try {
                this.xt.removeView(this.xu);
            } catch (Exception e) {
                com.kwad.components.core.b.a.b(e);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.xv.ky().setOutlineProvider(new a(com.kwad.sdk.b.kwai.a.a(this.mContext, 1.0f)));
                this.xv.ky().setClipToOutline(true);
                this.xz.setOutlineProvider(new a(com.kwad.sdk.b.kwai.a.a(this.mContext, 1.0f)));
                this.xz.setClipToOutline(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || this.xC || System.currentTimeMillis() <= this.xD) {
            return;
        }
        this.xC = true;
        jp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jr() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || this.xA || System.currentTimeMillis() <= this.xB) {
            return;
        }
        this.xA = true;
        this.xz.setVisibility(8);
    }

    @SuppressLint({"RtlHardcoded"})
    public final boolean a(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rect)) == null) {
            if (this.xv == null || this.xt == null) {
                return false;
            }
            Rect rect2 = new Rect();
            rect2.left = rect.left - com.kwad.sdk.b.kwai.a.a(this.mContext, 6.0f);
            rect2.right = rect.right - com.kwad.sdk.b.kwai.a.a(this.mContext, 6.0f);
            rect2.top = rect.top - com.kwad.sdk.b.kwai.a.a(this.mContext, 6.0f);
            rect2.bottom = rect.bottom + com.kwad.sdk.b.kwai.a.a(this.mContext, 6.0f);
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            WindowManager.LayoutParams layoutParams = this.xF;
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
            this.xu.setPivotX((i4 * i) / ((i4 + i) - i3));
            this.xu.setPivotY((i6 * i2) / ((i6 + i2) - i5));
            WindowManager windowManager = this.xt;
            if (windowManager != null) {
                try {
                    windowManager.addView(this.xu, this.xF);
                } catch (Exception e) {
                    com.kwad.components.core.b.a.b(e);
                    com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                }
            }
            this.xu.animate().scaleX(f).scaleY(f2).setDuration(600L).start();
            this.xu.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new AnonymousClass3(this, rect2));
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.xw;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
            }
            com.kwad.sdk.core.report.a.c(this.xv.getAdTemplate(), 115, (JSONObject) null);
            this.xy.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.splashscreen.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c xI;

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
                    this.xI = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (this.xI.xt != null) {
                            try {
                                this.xI.xt.removeView(this.xI.uL);
                                this.xI.xv.release();
                            } catch (Exception e2) {
                                com.kwad.components.core.b.a.b(e2);
                            }
                        }
                        if (this.xI.xw != null) {
                            this.xI.xw.onSkippedAd();
                        }
                        com.kwad.sdk.kwai.kwai.c.rd().rg();
                        if (this.xI.xv != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("duration", this.xI.xv.getCurrentPosition());
                            } catch (JSONException e3) {
                                com.kwad.sdk.core.e.b.printStackTraceOnly(e3);
                            }
                            com.kwad.sdk.core.report.a.a(this.xI.xv.getAdTemplate(), 1, jSONObject);
                        }
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void jo() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            WindowManager windowManager = this.xt;
            if (windowManager != null && (viewGroup = this.uL) != null) {
                windowManager.removeView(viewGroup);
            }
            com.kwad.components.ad.splashscreen.c.a aVar = this.xv;
            if (aVar != null) {
                aVar.release();
            }
        }
    }
}
