package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f40424a;

    /* renamed from: b  reason: collision with root package name */
    public float f40425b;

    /* renamed from: c  reason: collision with root package name */
    public float f40426c;

    /* renamed from: d  reason: collision with root package name */
    public float f40427d;

    /* renamed from: e  reason: collision with root package name */
    public float f40428e;

    /* renamed from: f  reason: collision with root package name */
    public float f40429f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40430g = false;

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f40430g) {
            bVar.j.cubicTo(this.f40424a, this.f40425b, this.f40426c, this.f40427d, this.f40428e, this.f40429f);
        }
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.f40424a = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(0));
            this.f40425b = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(1));
            this.f40426c = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(2));
            this.f40427d = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(3));
            this.f40428e = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(4));
            this.f40429f = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(5));
            this.f40430g = true;
        }
    }
}
