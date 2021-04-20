package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class r extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47443a;

    /* renamed from: b  reason: collision with root package name */
    public float f47444b;

    /* renamed from: c  reason: collision with root package name */
    public float f47445c;

    /* renamed from: d  reason: collision with root package name */
    public float f47446d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47447e = false;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f47447e) {
            bVar.j.quadTo(this.f47443a, this.f47444b, this.f47445c, this.f47446d);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.f47443a = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f47444b = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
            this.f47445c = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2));
            this.f47446d = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(3));
            this.f47447e = true;
        }
    }
}
