package d.b.g0.g.k0.i.f;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
/* loaded from: classes3.dex */
public class c extends StateListDrawable {

    /* renamed from: e  reason: collision with root package name */
    public a f48699e;

    /* renamed from: f  reason: collision with root package name */
    public View f48700f = null;

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
        this.f48699e = aVar;
    }

    public void b(View view) {
        this.f48700f = view;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.f48700f != null && this.f48699e != null) {
            if (StateSet.stateSetMatches(new int[]{16842919}, iArr)) {
                this.f48699e.a(this.f48700f);
            } else {
                this.f48699e.b(this.f48700f);
            }
        }
        return super.onStateChange(iArr);
    }
}
