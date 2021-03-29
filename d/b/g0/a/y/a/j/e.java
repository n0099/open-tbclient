package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f46980a;

    /* renamed from: b  reason: collision with root package name */
    public float f46981b;

    /* renamed from: c  reason: collision with root package name */
    public float f46982c;

    /* renamed from: d  reason: collision with root package name */
    public float f46983d;

    /* renamed from: e  reason: collision with root package name */
    public float f46984e;

    /* renamed from: f  reason: collision with root package name */
    public float f46985f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46986g = false;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f46986g) {
            bVar.j.cubicTo(this.f46980a, this.f46981b, this.f46982c, this.f46983d, this.f46984e, this.f46985f);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.f46980a = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f46981b = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
            this.f46982c = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2));
            this.f46983d = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(3));
            this.f46984e = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(4));
            this.f46985f = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(5));
            this.f46986g = true;
        }
    }
}
