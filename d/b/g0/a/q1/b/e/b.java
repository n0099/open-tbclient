package d.b.g0.a.q1.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f46018a;

    /* renamed from: b  reason: collision with root package name */
    public int f46019b;

    /* renamed from: c  reason: collision with root package name */
    public Context f46020c;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public Drawable a() {
        Drawable drawable = this.f46018a;
        if (drawable != null) {
            return drawable;
        }
        if (this.f46019b != 0) {
            Drawable drawable2 = this.f46020c.getResources().getDrawable(this.f46019b);
            this.f46019b = 0;
            this.f46018a = drawable2;
            return drawable2;
        }
        return null;
    }
}
