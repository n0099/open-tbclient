package d.a.m0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f44382a;

    /* renamed from: b  reason: collision with root package name */
    public float f44383b;

    /* renamed from: c  reason: collision with root package name */
    public float f44384c;

    /* renamed from: d  reason: collision with root package name */
    public float f44385d;

    /* renamed from: e  reason: collision with root package name */
    public float f44386e;

    /* renamed from: f  reason: collision with root package name */
    public float f44387f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44388g = false;

    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f44388g) {
            bVar.j.cubicTo(this.f44382a, this.f44383b, this.f44384c, this.f44385d, this.f44386e, this.f44387f);
        }
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.f44382a = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(0));
            this.f44383b = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(1));
            this.f44384c = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(2));
            this.f44385d = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(3));
            this.f44386e = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(4));
            this.f44387f = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(5));
            this.f44388g = true;
        }
    }
}
