package d.b.h0.g.k0.i.f;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
/* loaded from: classes3.dex */
public class c extends StateListDrawable {

    /* renamed from: e  reason: collision with root package name */
    public a f49028e;

    /* renamed from: f  reason: collision with root package name */
    public View f49029f = null;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view);

        void b(View view);
    }

    public c() {
        addState(new int[]{16842919}, new ColorDrawable(0));
        addState(new int[0], new ColorDrawable(0));
    }

    public void a(a aVar) {
        this.f49028e = aVar;
    }

    public void b(View view) {
        this.f49029f = view;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.f49029f != null && this.f49028e != null) {
            if (StateSet.stateSetMatches(new int[]{16842919}, iArr)) {
                this.f49028e.a(this.f49029f);
            } else {
                this.f49028e.b(this.f49029f);
            }
        }
        return super.onStateChange(iArr);
    }
}
