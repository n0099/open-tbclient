package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class r extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f45206a;

    /* renamed from: b  reason: collision with root package name */
    public float f45207b;

    /* renamed from: c  reason: collision with root package name */
    public float f45208c;

    /* renamed from: d  reason: collision with root package name */
    public float f45209d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45210e = false;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f45210e) {
            bVar.j.quadTo(this.f45206a, this.f45207b, this.f45208c, this.f45209d);
        }
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.f45206a = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f45207b = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
            this.f45208c = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(2));
            this.f45209d = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(3));
            this.f45210e = true;
        }
    }
}
