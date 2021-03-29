package d.b.g0.a.q1.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f45626a;

    /* renamed from: b  reason: collision with root package name */
    public int f45627b;

    /* renamed from: c  reason: collision with root package name */
    public Context f45628c;

    /* loaded from: classes2.dex */
    public interface a {
    }

    public Drawable a() {
        Drawable drawable = this.f45626a;
        if (drawable != null) {
            return drawable;
        }
        if (this.f45627b != 0) {
            Drawable drawable2 = this.f45628c.getResources().getDrawable(this.f45627b);
            this.f45627b = 0;
            this.f45626a = drawable2;
            return drawable2;
        }
        return null;
    }
}
