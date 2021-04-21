package d.b.h0.a.q1.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f46347a;

    /* renamed from: b  reason: collision with root package name */
    public int f46348b;

    /* renamed from: c  reason: collision with root package name */
    public Context f46349c;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public Drawable a() {
        Drawable drawable = this.f46347a;
        if (drawable != null) {
            return drawable;
        }
        if (this.f46348b != 0) {
            Drawable drawable2 = this.f46349c.getResources().getDrawable(this.f46348b);
            this.f46348b = 0;
            this.f46347a = drawable2;
            return drawable2;
        }
        return null;
    }
}
