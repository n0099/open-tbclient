package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f40598a;

    /* renamed from: b  reason: collision with root package name */
    public float f40599b;

    /* renamed from: c  reason: collision with root package name */
    public float f40600c;

    /* renamed from: d  reason: collision with root package name */
    public float f40601d;

    /* renamed from: e  reason: collision with root package name */
    public float f40602e;

    /* renamed from: f  reason: collision with root package name */
    public float f40603f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40604g = false;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f40604g) {
            bVar.j.cubicTo(this.f40598a, this.f40599b, this.f40600c, this.f40601d, this.f40602e, this.f40603f);
        }
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.f40598a = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(0));
            this.f40599b = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1));
            this.f40600c = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(2));
            this.f40601d = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(3));
            this.f40602e = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(4));
            this.f40603f = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(5));
            this.f40604g = true;
        }
    }
}
