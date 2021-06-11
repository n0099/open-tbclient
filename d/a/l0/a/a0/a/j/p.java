package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class p extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f44334a = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public int f44335b = Integer.MAX_VALUE;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2;
        int i3 = this.f44334a;
        if (i3 == Integer.MAX_VALUE || (i2 = this.f44335b) == Integer.MAX_VALUE) {
            return;
        }
        bVar.j.lineTo(i3, i2);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.f44334a = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(0));
            this.f44335b = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1));
        }
    }
}
