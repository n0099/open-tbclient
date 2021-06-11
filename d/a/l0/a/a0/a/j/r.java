package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class r extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f44346a;

    /* renamed from: b  reason: collision with root package name */
    public float f44347b;

    /* renamed from: c  reason: collision with root package name */
    public float f44348c;

    /* renamed from: d  reason: collision with root package name */
    public float f44349d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44350e = false;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f44350e) {
            bVar.j.quadTo(this.f44346a, this.f44347b, this.f44348c, this.f44349d);
        }
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.f44346a = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(0));
            this.f44347b = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1));
            this.f44348c = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(2));
            this.f44349d = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(3));
            this.f44350e = true;
        }
    }
}
