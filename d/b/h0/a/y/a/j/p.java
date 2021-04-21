package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class p extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f47760a = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public int f47761b = Integer.MAX_VALUE;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i;
        int i2 = this.f47760a;
        if (i2 == Integer.MAX_VALUE || (i = this.f47761b) == Integer.MAX_VALUE) {
            return;
        }
        bVar.j.lineTo(i2, i);
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.f47760a = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f47761b = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
        }
    }
}
