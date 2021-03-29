package d.b.g0.a.a0.a.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import d.b.g0.a.a0.a.d.b;
import d.b.g0.a.c0.c;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.v;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a<V extends View, M extends b> extends d.b.g0.a.a0.b.a<V, M> {

    /* renamed from: d.b.g0.a.a0.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0589a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppComponentContainerView f43097e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f43098f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f43099g;

        public C0589a(a aVar, SwanAppComponentContainerView swanAppComponentContainerView, boolean z, b bVar) {
            this.f43097e = swanAppComponentContainerView;
            this.f43098f = z;
            this.f43099g = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup.LayoutParams layoutParams = this.f43097e.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (this.f43098f) {
                    marginLayoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                } else {
                    marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                }
                this.f43099g.l.m(marginLayoutParams.leftMargin);
                this.f43099g.l.n(marginLayoutParams.topMargin);
                this.f43097e.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public a(@Nullable Context context, @NonNull M m) {
        super(context, m);
    }

    @Nullable
    public final ValueAnimator H(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull b bVar, @NonNull b bVar2) {
        if (bVar2.n != null) {
            float a2 = v.a(bVar.n, "opacity", 1.0f);
            float a3 = v.a(bVar2.n, "opacity", a2);
            if (a2 != a3) {
                return ObjectAnimator.ofFloat(swanAppComponentContainerView, "alpha", a2, a3);
            }
        }
        return null;
    }

    public final AnimatorSet I(long j, @NonNull Interpolator interpolator, List<Animator> list) {
        if (j <= 0 || list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Animator animator : list) {
            if (animator != null) {
                arrayList.add(animator);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(interpolator);
        animatorSet.setDuration(j);
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    @Nullable
    public final ValueAnimator J(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull b bVar, @NonNull b bVar2, boolean z) {
        d.b.g0.a.e1.d.a.a aVar = bVar.l;
        if (aVar == null || bVar2.l == null) {
            return null;
        }
        int e2 = z ? aVar.e() : aVar.f();
        d.b.g0.a.e1.d.a.a aVar2 = bVar2.l;
        int e3 = z ? aVar2.e() : aVar2.f();
        if (e2 != e3) {
            ValueAnimator ofInt = ValueAnimator.ofInt(e2, e3);
            ofInt.addUpdateListener(new C0589a(this, swanAppComponentContainerView, z, bVar2));
            return ofInt;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.b.a
    @NonNull
    /* renamed from: K */
    public d.b.g0.a.a0.f.b k(@NonNull M m, @NonNull M m2) {
        JSONObject jSONObject;
        d.b.g0.a.a0.f.b k = super.k(m, m2);
        if (m2.n != null && ((jSONObject = m.n) == null || !TextUtils.equals(jSONObject.toString(), m2.n.toString()))) {
            k.b(4);
        }
        return k;
    }

    public final boolean L() {
        JSONObject jSONObject;
        return s(4) && t() && (jSONObject = ((b) n()).u) != null && !TextUtils.isEmpty(jSONObject.optString("duration"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Interpolator M(@NonNull String str) {
        char c2;
        switch (str.hashCode()) {
            case -1965120668:
                if (str.equals("ease-in")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -789192465:
                if (str.equals("ease-out")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -361990811:
                if (str.equals("ease-in-out")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3105774:
                if (str.equals("ease")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        return PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
                    }
                    return PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
                }
                return PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            }
            return PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        }
        return PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
    }

    public final boolean N() {
        return P(false);
    }

    public final boolean O() {
        return P(true);
    }

    public final boolean P(boolean z) {
        JSONObject jSONObject;
        SwanAppComponentContainerView m = m();
        b bVar = (b) p();
        b bVar2 = (b) n();
        if (m == null || bVar == null || (jSONObject = bVar2.u) == null || TextUtils.isEmpty(jSONObject.optString("duration"))) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(J(m, bVar, bVar2, false));
            arrayList.add(J(m, bVar, bVar2, true));
        } else {
            arrayList.add(H(m, bVar, bVar2));
        }
        AnimatorSet I = I(bVar2.v, M(bVar2.w), arrayList);
        if (I != null) {
            I.start();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.b.a
    /* renamed from: Q */
    public void D(@NonNull V v, @NonNull M m, @NonNull d.b.g0.a.a0.f.b bVar) {
        super.D(v, m, bVar);
        if (bVar.a(4)) {
            T(v, m);
            S(v, m);
            R(v, m);
        }
    }

    public void R(@NonNull View view, @NonNull M m) {
        if (m.n == null) {
            return;
        }
        if (d.b.g0.a.a0.b.a.f43100h) {
            Log.d("Component-View", "renderAlpha");
        }
        if (L()) {
            if (d.b.g0.a.a0.b.a.f43100h) {
                Log.d("Component-View", "renderAlpha with animation");
            }
            if (N()) {
                return;
            }
            c.l("Component-View", "performAlphaUpdateAnimation fail");
            return;
        }
        float f2 = m.t;
        if (f2 >= 0.0f && f2 <= 1.0f) {
            view.setAlpha(f2);
            return;
        }
        c.l("Component-View", "alpha invalid: " + m.t);
    }

    public void S(@NonNull V v, @NonNull M m) {
        if (m.n == null) {
            return;
        }
        if (d.b.g0.a.a0.b.a.f43100h) {
            Log.d("Component-View", "renderBackground");
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(m.o);
        gradientDrawable.setCornerRadius(m.r);
        gradientDrawable.setStroke(m.p, m.q);
        v.setBackground(gradientDrawable);
    }

    public void T(@NonNull V v, @NonNull M m) {
        if (m.n == null) {
            return;
        }
        if (d.b.g0.a.a0.b.a.f43100h) {
            Log.d("Component-View", "renderPadding");
        }
        JSONArray jSONArray = m.s;
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.length() == 4) {
            v.setPadding(h0.f((float) jSONArray.optDouble(3, 0.0d)), h0.f((float) jSONArray.optDouble(0, 0.0d)), h0.f((float) jSONArray.optDouble(1, 0.0d)), h0.f((float) jSONArray.optDouble(2, 0.0d)));
            return;
        }
        c.b("Component-View", "invalid padding array length: " + jSONArray.length());
    }
}
