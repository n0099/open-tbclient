package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class r extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f40670a;

    /* renamed from: b  reason: collision with root package name */
    public float f40671b;

    /* renamed from: c  reason: collision with root package name */
    public float f40672c;

    /* renamed from: d  reason: collision with root package name */
    public float f40673d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40674e = false;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f40674e) {
            bVar.j.quadTo(this.f40670a, this.f40671b, this.f40672c, this.f40673d);
        }
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.f40670a = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(0));
            this.f40671b = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1));
            this.f40672c = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(2));
            this.f40673d = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(3));
            this.f40674e = true;
        }
    }
}
