package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class q extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f47768a = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public int f47769b = Integer.MAX_VALUE;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i;
        int i2 = this.f47768a;
        if (i2 == Integer.MAX_VALUE || (i = this.f47769b) == Integer.MAX_VALUE) {
            return;
        }
        bVar.j.moveTo(i2, i);
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.f47768a = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f47769b = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
        }
    }
}
