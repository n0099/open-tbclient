package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47372a;

    /* renamed from: b  reason: collision with root package name */
    public float f47373b;

    /* renamed from: c  reason: collision with root package name */
    public float f47374c;

    /* renamed from: d  reason: collision with root package name */
    public float f47375d;

    /* renamed from: e  reason: collision with root package name */
    public float f47376e;

    /* renamed from: f  reason: collision with root package name */
    public float f47377f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47378g = false;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f47378g) {
            bVar.j.cubicTo(this.f47372a, this.f47373b, this.f47374c, this.f47375d, this.f47376e, this.f47377f);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.f47372a = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f47373b = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
            this.f47374c = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2));
            this.f47375d = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(3));
            this.f47376e = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(4));
            this.f47377f = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(5));
            this.f47378g = true;
        }
    }
}
