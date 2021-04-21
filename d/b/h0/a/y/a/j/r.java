package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class r extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47772a;

    /* renamed from: b  reason: collision with root package name */
    public float f47773b;

    /* renamed from: c  reason: collision with root package name */
    public float f47774c;

    /* renamed from: d  reason: collision with root package name */
    public float f47775d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47776e = false;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f47776e) {
            bVar.j.quadTo(this.f47772a, this.f47773b, this.f47774c, this.f47775d);
        }
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.f47772a = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f47773b = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
            this.f47774c = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(2));
            this.f47775d = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(3));
            this.f47776e = true;
        }
    }
}
