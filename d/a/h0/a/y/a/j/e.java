package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f45134a;

    /* renamed from: b  reason: collision with root package name */
    public float f45135b;

    /* renamed from: c  reason: collision with root package name */
    public float f45136c;

    /* renamed from: d  reason: collision with root package name */
    public float f45137d;

    /* renamed from: e  reason: collision with root package name */
    public float f45138e;

    /* renamed from: f  reason: collision with root package name */
    public float f45139f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45140g = false;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f45140g) {
            bVar.j.cubicTo(this.f45134a, this.f45135b, this.f45136c, this.f45137d, this.f45138e, this.f45139f);
        }
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.f45134a = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f45135b = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
            this.f45136c = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(2));
            this.f45137d = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(3));
            this.f45138e = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(4));
            this.f45139f = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(5));
            this.f45140g = true;
        }
    }
}
