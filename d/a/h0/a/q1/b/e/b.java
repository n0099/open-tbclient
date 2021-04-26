package d.a.h0.a.q1.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f43704a;

    /* renamed from: b  reason: collision with root package name */
    public int f43705b;

    /* renamed from: c  reason: collision with root package name */
    public Context f43706c;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public Drawable a() {
        Drawable drawable = this.f43704a;
        if (drawable != null) {
            return drawable;
        }
        if (this.f43705b != 0) {
            Drawable drawable2 = this.f43706c.getResources().getDrawable(this.f43705b);
            this.f43705b = 0;
            this.f43704a = drawable2;
            return drawable2;
        }
        return null;
    }
}
