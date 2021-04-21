package d.b.h0.a.a0.c.a;

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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.h0.a.c0.c;
import d.b.h0.a.r1.e;
import d.b.h0.a.z1.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a extends d.b.h0.a.a0.a.d.a<LottieAnimationView, b> {
    @NonNull
    public String i;

    /* renamed from: d.b.h0.a.a0.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0623a implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f43839e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43840f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f43841g;

        public C0623a(a aVar, b bVar, JSONObject jSONObject, LottieAnimationView lottieAnimationView) {
            this.f43839e = bVar;
            this.f43840f = jSONObject;
            this.f43841g = lottieAnimationView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b bVar = this.f43839e;
            d.b.h0.a.j2.f.c.a.d(bVar.f43835g, bVar.f43834f, "animateview", "ended", this.f43840f);
            c.g("Component-AnimationView", "progress: " + this.f43841g.getProgress());
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            c.g("Component-AnimationView", "onAnimationRepeat ");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public a(@Nullable Context context, @NonNull b bVar, @NonNull String str) {
        super(context, bVar);
        this.i = str;
    }

    public static void b0(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("json", str);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str2);
        } catch (Exception e2) {
            if (d.b.h0.a.a0.b.a.f43821h) {
                e2.printStackTrace();
            }
        }
        String jSONObject2 = jSONObject.toString();
        if (d.b.h0.a.a0.b.a.f43821h && TextUtils.isEmpty(jSONObject2)) {
            Log.d("Component-AnimationView", "reportLottieAnimationCrash: empty");
            return;
        }
        if (d.b.h0.a.a0.b.a.f43821h) {
            Log.d("Component-AnimationView", "reportLottieAnimationCrash: " + jSONObject2);
        }
        c.b bVar = new c.b(10009);
        bVar.i(jSONObject2);
        bVar.h(e.T());
        bVar.l();
    }

    public final void U(@NonNull LottieAnimationView lottieAnimationView, @NonNull b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("wvID", bVar.f43835g);
            jSONObject.put("vtype", "ended");
            jSONObject2.putOpt("animationViewId", bVar.f43834f);
            jSONObject.put("data", jSONObject2.toString());
        } catch (JSONException e2) {
            if (d.b.h0.a.a0.b.a.f43821h) {
                e2.printStackTrace();
            }
        }
        lottieAnimationView.addAnimatorListener(new C0623a(this, bVar, jSONObject, lottieAnimationView));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.a0.b.a
    @NonNull
    /* renamed from: V */
    public LottieAnimationView v(@NonNull Context context) {
        return new LottieAnimationView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.a0.b.a
    /* renamed from: W */
    public void B(@NonNull LottieAnimationView lottieAnimationView) {
        super.B(lottieAnimationView);
        try {
            b bVar = (b) n();
            lottieAnimationView.loop(bVar.y);
            lottieAnimationView.enableMergePathsForKitKatAndAbove(true);
            lottieAnimationView.setAnimationFromJson(this.i, bVar.f43834f);
            if (bVar.z) {
                lottieAnimationView.playAnimation();
            }
            if (bVar.y) {
                return;
            }
            U(lottieAnimationView, bVar);
        } catch (Exception unused) {
            b0(this.i, e.T());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.a0.a.d.a
    /* renamed from: X */
    public void Q(@NonNull LottieAnimationView lottieAnimationView, @NonNull b bVar, @NonNull d.b.h0.a.a0.f.b bVar2) {
        super.D(lottieAnimationView, bVar, bVar2);
        Y(lottieAnimationView, bVar);
    }

    public final void Y(@NonNull LottieAnimationView lottieAnimationView, @NonNull b bVar) {
        if (t()) {
            if (d.b.h0.a.a0.b.a.f43821h) {
                Log.d("Component-AnimationView", "renderAction");
            }
            String str = bVar.A;
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
    @Override // d.b.h0.a.a0.a.d.a
    /* renamed from: Z */
    public void S(@NonNull LottieAnimationView lottieAnimationView, @NonNull b bVar) {
        if (d.b.h0.a.a0.b.a.f43821h) {
            Log.d("Component-AnimationView", "renderBackground");
        }
        lottieAnimationView.setColorFilter(new PorterDuffColorFilter(bVar.o, PorterDuff.Mode.ADD));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.a0.a.d.a
    /* renamed from: a0 */
    public void T(@NonNull LottieAnimationView lottieAnimationView, @NonNull b bVar) {
    }
}
