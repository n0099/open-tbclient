package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class r extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47050a;

    /* renamed from: b  reason: collision with root package name */
    public float f47051b;

    /* renamed from: c  reason: collision with root package name */
    public float f47052c;

    /* renamed from: d  reason: collision with root package name */
    public float f47053d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47054e = false;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f47054e) {
            bVar.j.quadTo(this.f47050a, this.f47051b, this.f47052c, this.f47053d);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.f47050a = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f47051b = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
            this.f47052c = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2));
            this.f47053d = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(3));
            this.f47054e = true;
        }
    }
}
