package d.b.g0.a.a0.c.e.c;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
/* loaded from: classes2.dex */
public final class a extends d.b.g0.a.a0.a.c.a<TextView, b> {
    public SwanAppComponentContainerView i;
    public TextView j;

    public a(@NonNull Context context, @NonNull b bVar) {
        super(context, bVar);
        g(4);
        this.i = new SwanAppComponentContainerView(context);
        this.j = new TextView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.c.a, d.b.g0.a.a0.a.d.a, d.b.g0.a.a0.b.a
    @NonNull
    /* renamed from: c0 */
    public d.b.g0.a.a0.f.b k(@NonNull b bVar, @NonNull b bVar2) {
        d.b.g0.a.a0.f.b k = super.k(bVar, bVar2);
        if (!TextUtils.equals(bVar.H, bVar2.H) && (TextUtils.equals(bVar.H, "scroll") || TextUtils.equals(bVar2.H, "scroll"))) {
            k.b(7);
        }
        if (!TextUtils.equals(bVar.H, bVar2.H) || (TextUtils.equals(bVar2.H, "scroll") && bVar.G != bVar2.G)) {
            k.b(8);
        }
        return k;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.b.a
    @NonNull
    /* renamed from: d0 */
    public TextView v(@NonNull Context context) {
        return this.j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.d.a
    /* renamed from: e0 */
    public void R(@NonNull View view, @NonNull b bVar) {
        if (d.b.g0.a.a0.b.a.f43100h) {
            Log.d("Component-CoverView", "renderAlpha");
        }
        if (bVar.n == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            super.R((View) parent, bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.d.a
    /* renamed from: f0 */
    public void S(@NonNull TextView textView, @NonNull b bVar) {
        if (d.b.g0.a.a0.b.a.f43100h) {
            Log.d("Component-CoverView", "renderBackground");
        }
        if (bVar.n == null) {
            return;
        }
        SwanAppComponentContainerView m = m();
        if (m != null) {
            m.setModel(bVar);
        }
        ViewParent parent = textView.getParent();
        if (parent instanceof View) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(bVar.o);
            gradientDrawable.setCornerRadius(bVar.r);
            gradientDrawable.setStroke(bVar.p, bVar.q);
            ((View) parent).setBackground(gradientDrawable);
        }
    }

    @Override // d.b.g0.a.a0.b.a
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        return this.i;
    }
}
