package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f46979a;

    /* renamed from: b  reason: collision with root package name */
    public float f46980b;

    /* renamed from: c  reason: collision with root package name */
    public float f46981c;

    /* renamed from: d  reason: collision with root package name */
    public float f46982d;

    /* renamed from: e  reason: collision with root package name */
    public float f46983e;

    /* renamed from: f  reason: collision with root package name */
    public float f46984f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46985g = false;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f46985g) {
            bVar.j.cubicTo(this.f46979a, this.f46980b, this.f46981c, this.f46982d, this.f46983e, this.f46984f);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.f46979a = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f46980b = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
            this.f46981c = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2));
            this.f46982d = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(3));
            this.f46983e = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(4));
            this.f46984f = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(5));
            this.f46985g = true;
        }
    }
}
