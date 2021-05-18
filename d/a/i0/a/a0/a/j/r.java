package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class r extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f40496a;

    /* renamed from: b  reason: collision with root package name */
    public float f40497b;

    /* renamed from: c  reason: collision with root package name */
    public float f40498c;

    /* renamed from: d  reason: collision with root package name */
    public float f40499d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40500e = false;

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f40500e) {
            bVar.j.quadTo(this.f40496a, this.f40497b, this.f40498c, this.f40499d);
        }
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.f40496a = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(0));
            this.f40497b = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(1));
            this.f40498c = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(2));
            this.f40499d = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(3));
            this.f40500e = true;
        }
    }
}
