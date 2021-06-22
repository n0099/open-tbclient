package d.a.m0.h.o0.g.f;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
/* loaded from: classes3.dex */
public class d extends StateListDrawable {

    /* renamed from: e  reason: collision with root package name */
    public a f51398e;

    /* renamed from: f  reason: collision with root package name */
    public View f51399f = null;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view);

        void b(View view);
    }

    public d() {
        addState(new int[]{16842919}, new ColorDrawable(0));
        addState(new int[0], new ColorDrawable(0));
    }

    public void a(a aVar) {
        this.f51398e = aVar;
    }

    public void b(View view) {
        this.f51399f = view;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.f51399f != null && this.f51398e != null) {
            if (StateSet.stateSetMatches(new int[]{16842919}, iArr)) {
                this.f51398e.b(this.f51399f);
            } else {
                this.f51398e.a(this.f51399f);
            }
        }
        return super.onStateChange(iArr);
    }

    public d(Drawable drawable) {
        addState(new int[]{16842919}, drawable);
        addState(new int[0], drawable);
    }
}
