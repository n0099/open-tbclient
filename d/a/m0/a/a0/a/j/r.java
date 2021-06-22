package d.a.m0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class r extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f44454a;

    /* renamed from: b  reason: collision with root package name */
    public float f44455b;

    /* renamed from: c  reason: collision with root package name */
    public float f44456c;

    /* renamed from: d  reason: collision with root package name */
    public float f44457d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44458e = false;

    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f44458e) {
            bVar.j.quadTo(this.f44454a, this.f44455b, this.f44456c, this.f44457d);
        }
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.f44454a = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(0));
            this.f44455b = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(1));
            this.f44456c = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(2));
            this.f44457d = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(3));
            this.f44458e = true;
        }
    }
}
