package com.repackage;

import android.animation.Animator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.p63;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bw1 extends uv1<LottieAnimationView, cw1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public String i;

    /* loaded from: classes5.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cw1 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ LottieAnimationView c;

        public a(bw1 bw1Var, cw1 cw1Var, JSONObject jSONObject, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw1Var, cw1Var, jSONObject, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cw1Var;
            this.b = jSONObject;
            this.c = lottieAnimationView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                cw1 cw1Var = this.a;
                of3.d(cw1Var.c, cw1Var.b, "animateview", "ended", this.b);
                hx1.i("Component-AnimationView", "progress: " + this.c.getProgress());
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                hx1.i("Component-AnimationView", "onAnimationRepeat ");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw1(@Nullable Context context, @NonNull cw1 cw1Var, @NonNull String str) {
        super(context, cw1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cw1Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (vv1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = str;
    }

    public static void Z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("json", str);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str2);
            } catch (Exception e) {
                if (wv1.h) {
                    e.printStackTrace();
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (wv1.h && TextUtils.isEmpty(jSONObject2)) {
                Log.d("Component-AnimationView", "reportLottieAnimationCrash: empty");
                return;
            }
            if (wv1.h) {
                Log.d("Component-AnimationView", "reportLottieAnimationCrash: " + jSONObject2);
            }
            p63.b bVar = new p63.b(10009);
            bVar.i(jSONObject2);
            bVar.h(h03.g0());
            bVar.m();
        }
    }

    public final void S(@NonNull LottieAnimationView lottieAnimationView, @NonNull cw1 cw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, lottieAnimationView, cw1Var) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cw1Var.c);
                jSONObject.put("vtype", "ended");
                jSONObject2.putOpt("animationViewId", cw1Var.b);
                jSONObject.put("data", jSONObject2.toString());
            } catch (JSONException e) {
                if (wv1.h) {
                    e.printStackTrace();
                }
            }
            lottieAnimationView.addAnimatorListener(new a(this, cw1Var, jSONObject, lottieAnimationView));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wv1
    @NonNull
    /* renamed from: T */
    public LottieAnimationView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? new LottieAnimationView(context) : (LottieAnimationView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wv1
    /* renamed from: U */
    public void A(@NonNull LottieAnimationView lottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lottieAnimationView) == null) {
            super.A(lottieAnimationView);
            try {
                cw1 cw1Var = (cw1) n();
                lottieAnimationView.loop(cw1Var.u);
                lottieAnimationView.enableMergePathsForKitKatAndAbove(true);
                lottieAnimationView.setImageAssetDelegate(new aw1(cw1Var.t));
                lottieAnimationView.setAnimationFromJson(this.i, cw1Var.b);
                if (cw1Var.v) {
                    lottieAnimationView.playAnimation();
                }
                if (cw1Var.u) {
                    return;
                }
                S(lottieAnimationView, cw1Var);
            } catch (Exception unused) {
                Z(this.i, h03.g0());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uv1
    /* renamed from: V */
    public void O(@NonNull LottieAnimationView lottieAnimationView, @NonNull cw1 cw1Var, @NonNull zw1 zw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lottieAnimationView, cw1Var, zw1Var) == null) {
            super.C(lottieAnimationView, cw1Var, zw1Var);
            W(lottieAnimationView, cw1Var);
        }
    }

    public final void W(@NonNull LottieAnimationView lottieAnimationView, @NonNull cw1 cw1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, lottieAnimationView, cw1Var) == null) && t()) {
            if (wv1.h) {
                Log.d("Component-AnimationView", "renderAction");
            }
            String str = cw1Var.w;
            if (TextUtils.equals(str, "play")) {
                lottieAnimationView.resumeAnimation();
            } else if (TextUtils.equals(str, "pause")) {
                lottieAnimationView.pauseAnimation();
            } else if (TextUtils.equals(str, IntentConfig.STOP)) {
                lottieAnimationView.cancelAnimation();
                lottieAnimationView.setProgress(0.0f);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uv1
    /* renamed from: X */
    public void Q(@NonNull LottieAnimationView lottieAnimationView, @NonNull cw1 cw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, lottieAnimationView, cw1Var) == null) {
            if (wv1.h) {
                Log.d("Component-AnimationView", "renderBackground");
            }
            lottieAnimationView.setColorFilter(new PorterDuffColorFilter(cw1Var.k, PorterDuff.Mode.ADD));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uv1
    /* renamed from: Y */
    public void R(@NonNull LottieAnimationView lottieAnimationView, @NonNull cw1 cw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, lottieAnimationView, cw1Var) == null) {
        }
    }
}
