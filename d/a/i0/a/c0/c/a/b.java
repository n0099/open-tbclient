package d.a.i0.a.c0.c.a;

import android.animation.Animator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.i0.a.a2.e;
import d.a.i0.a.e0.d;
import d.a.i0.a.j2.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b extends d.a.i0.a.c0.a.d.a<LottieAnimationView, c> {
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public String f40678i;

    /* loaded from: classes2.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f40679e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f40680f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f40681g;

        public a(b bVar, c cVar, JSONObject jSONObject, LottieAnimationView lottieAnimationView) {
            this.f40679e = cVar;
            this.f40680f = jSONObject;
            this.f40681g = lottieAnimationView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c cVar = this.f40679e;
            d.a.i0.a.w2.g.c.a.d(cVar.f40672g, cVar.f40671f, "animateview", "ended", this.f40680f);
            d.g("Component-AnimationView", "progress: " + this.f40681g.getProgress());
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            d.g("Component-AnimationView", "onAnimationRepeat ");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public b(@Nullable Context context, @NonNull c cVar, @NonNull String str) {
        super(context, cVar);
        this.f40678i = str;
    }

    public static void b0(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("json", str);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str2);
        } catch (Exception e2) {
            if (d.a.i0.a.c0.b.a.f40658h) {
                e2.printStackTrace();
            }
        }
        String jSONObject2 = jSONObject.toString();
        if (d.a.i0.a.c0.b.a.f40658h && TextUtils.isEmpty(jSONObject2)) {
            Log.d("Component-AnimationView", "reportLottieAnimationCrash: empty");
            return;
        }
        if (d.a.i0.a.c0.b.a.f40658h) {
            Log.d("Component-AnimationView", "reportLottieAnimationCrash: " + jSONObject2);
        }
        c.b bVar = new c.b(10009);
        bVar.i(jSONObject2);
        bVar.h(e.V());
        bVar.m();
    }

    public final void U(@NonNull LottieAnimationView lottieAnimationView, @NonNull c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f40672g);
            jSONObject.put("vtype", "ended");
            jSONObject2.putOpt("animationViewId", cVar.f40671f);
            jSONObject.put("data", jSONObject2.toString());
        } catch (JSONException e2) {
            if (d.a.i0.a.c0.b.a.f40658h) {
                e2.printStackTrace();
            }
        }
        lottieAnimationView.addAnimatorListener(new a(this, cVar, jSONObject, lottieAnimationView));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.c0.b.a
    @NonNull
    /* renamed from: V */
    public LottieAnimationView v(@NonNull Context context) {
        return new LottieAnimationView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.c0.b.a
    /* renamed from: W */
    public void B(@NonNull LottieAnimationView lottieAnimationView) {
        super.B(lottieAnimationView);
        try {
            c cVar = (c) n();
            lottieAnimationView.loop(cVar.y);
            lottieAnimationView.enableMergePathsForKitKatAndAbove(true);
            lottieAnimationView.setImageAssetDelegate(new d.a.i0.a.c0.c.a.a(cVar.x));
            lottieAnimationView.setAnimationFromJson(this.f40678i, cVar.f40671f);
            if (cVar.z) {
                lottieAnimationView.playAnimation();
            }
            if (cVar.y) {
                return;
            }
            U(lottieAnimationView, cVar);
        } catch (Exception unused) {
            b0(this.f40678i, e.V());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.c0.a.d.a
    /* renamed from: X */
    public void Q(@NonNull LottieAnimationView lottieAnimationView, @NonNull c cVar, @NonNull d.a.i0.a.c0.f.b bVar) {
        super.D(lottieAnimationView, cVar, bVar);
        Y(lottieAnimationView, cVar);
    }

    public final void Y(@NonNull LottieAnimationView lottieAnimationView, @NonNull c cVar) {
        if (t()) {
            if (d.a.i0.a.c0.b.a.f40658h) {
                Log.d("Component-AnimationView", "renderAction");
            }
            String str = cVar.A;
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
    @Override // d.a.i0.a.c0.a.d.a
    /* renamed from: Z */
    public void S(@NonNull LottieAnimationView lottieAnimationView, @NonNull c cVar) {
        if (d.a.i0.a.c0.b.a.f40658h) {
            Log.d("Component-AnimationView", "renderBackground");
        }
        lottieAnimationView.setColorFilter(new PorterDuffColorFilter(cVar.o, PorterDuff.Mode.ADD));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.c0.a.d.a
    /* renamed from: a0 */
    public void T(@NonNull LottieAnimationView lottieAnimationView, @NonNull c cVar) {
    }
}
