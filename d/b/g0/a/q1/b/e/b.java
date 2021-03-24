package d.b.g0.a.q1.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f45625a;

    /* renamed from: b  reason: collision with root package name */
    public int f45626b;

    /* renamed from: c  reason: collision with root package name */
    public Context f45627c;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public Drawable a() {
        Drawable drawable = this.f45625a;
        if (drawable != null) {
            return drawable;
        }
        if (this.f45626b != 0) {
            Drawable drawable2 = this.f45627c.getResources().getDrawable(this.f45626b);
            this.f45626b = 0;
            this.f45625a = drawable2;
            return drawable2;
        }
        return null;
    }
}
