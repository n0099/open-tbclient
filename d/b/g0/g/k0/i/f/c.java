package d.b.g0.g.k0.i.f;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
/* loaded from: classes3.dex */
public class c extends StateListDrawable {

    /* renamed from: e  reason: collision with root package name */
    public a f48306e;

    /* renamed from: f  reason: collision with root package name */
    public View f48307f = null;

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
        this.f48306e = aVar;
    }

    public void b(View view) {
        this.f48307f = view;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.f48307f != null && this.f48306e != null) {
            if (StateSet.stateSetMatches(new int[]{16842919}, iArr)) {
                this.f48306e.a(this.f48307f);
            } else {
                this.f48306e.b(this.f48307f);
            }
        }
        return super.onStateChange(iArr);
    }
}
