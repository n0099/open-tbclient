package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class r extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47051a;

    /* renamed from: b  reason: collision with root package name */
    public float f47052b;

    /* renamed from: c  reason: collision with root package name */
    public float f47053c;

    /* renamed from: d  reason: collision with root package name */
    public float f47054d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47055e = false;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f47055e) {
            bVar.j.quadTo(this.f47051a, this.f47052b, this.f47053c, this.f47054d);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.f47051a = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f47052b = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
            this.f47053c = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2));
            this.f47054d = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(3));
            this.f47055e = true;
        }
    }
}
