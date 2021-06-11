package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f44274a;

    /* renamed from: b  reason: collision with root package name */
    public float f44275b;

    /* renamed from: c  reason: collision with root package name */
    public float f44276c;

    /* renamed from: d  reason: collision with root package name */
    public float f44277d;

    /* renamed from: e  reason: collision with root package name */
    public float f44278e;

    /* renamed from: f  reason: collision with root package name */
    public float f44279f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44280g = false;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f44280g) {
            bVar.j.cubicTo(this.f44274a, this.f44275b, this.f44276c, this.f44277d, this.f44278e, this.f44279f);
        }
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.f44274a = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(0));
            this.f44275b = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1));
            this.f44276c = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(2));
            this.f44277d = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(3));
            this.f44278e = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(4));
            this.f44279f = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(5));
            this.f44280g = true;
        }
    }
}
