package d.a.i0.a.c0.c.e.c;

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
public final class a extends d.a.i0.a.c0.a.c.b<TextView, b> {

    /* renamed from: i  reason: collision with root package name */
    public SwanAppComponentContainerView f40691i;
    public TextView j;

    public a(@NonNull Context context, @NonNull b bVar) {
        super(context, bVar);
        g(4);
        this.f40691i = new SwanAppComponentContainerView(context);
        this.j = new TextView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.c0.a.c.b, d.a.i0.a.c0.a.d.a, d.a.i0.a.c0.b.a
    @NonNull
    /* renamed from: b0 */
    public d.a.i0.a.c0.f.b k(@NonNull b bVar, @NonNull b bVar2) {
        d.a.i0.a.c0.f.b k = super.k(bVar, bVar2);
        if (!TextUtils.equals(bVar.H, bVar2.H) && (TextUtils.equals(bVar.H, "scroll") || TextUtils.equals(bVar2.H, "scroll"))) {
            k.b(7);
        }
        if (!TextUtils.equals(bVar.H, bVar2.H) || (TextUtils.equals(bVar2.H, "scroll") && bVar.G != bVar2.G)) {
            k.b(8);
        }
        return k;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.c0.b.a
    @NonNull
    /* renamed from: c0 */
    public TextView v(@NonNull Context context) {
        return this.j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.c0.a.d.a
    /* renamed from: d0 */
    public void R(@NonNull View view, @NonNull b bVar) {
        if (d.a.i0.a.c0.b.a.f40658h) {
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
    @Override // d.a.i0.a.c0.a.d.a
    /* renamed from: e0 */
    public void S(@NonNull TextView textView, @NonNull b bVar) {
        if (d.a.i0.a.c0.b.a.f40658h) {
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

    @Override // d.a.i0.a.c0.b.a
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        return this.f40691i;
    }
}
