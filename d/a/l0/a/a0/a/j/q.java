package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class q extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f40666a = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public int f40667b = Integer.MAX_VALUE;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2;
        int i3 = this.f40666a;
        if (i3 == Integer.MAX_VALUE || (i2 = this.f40667b) == Integer.MAX_VALUE) {
            return;
        }
        bVar.j.moveTo(i3, i2);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.f40666a = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(0));
            this.f40667b = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1));
        }
    }
}
