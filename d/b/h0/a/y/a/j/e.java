package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47701a;

    /* renamed from: b  reason: collision with root package name */
    public float f47702b;

    /* renamed from: c  reason: collision with root package name */
    public float f47703c;

    /* renamed from: d  reason: collision with root package name */
    public float f47704d;

    /* renamed from: e  reason: collision with root package name */
    public float f47705e;

    /* renamed from: f  reason: collision with root package name */
    public float f47706f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47707g = false;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f47707g) {
            bVar.j.cubicTo(this.f47701a, this.f47702b, this.f47703c, this.f47704d, this.f47705e, this.f47706f);
        }
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.f47701a = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f47702b = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
            this.f47703c = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(2));
            this.f47704d = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(3));
            this.f47705e = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(4));
            this.f47706f = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(5));
            this.f47707g = true;
        }
    }
}
