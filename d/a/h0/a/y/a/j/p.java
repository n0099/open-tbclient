package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class p extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f45194a = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public int f45195b = Integer.MAX_VALUE;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2;
        int i3 = this.f45194a;
        if (i3 == Integer.MAX_VALUE || (i2 = this.f45195b) == Integer.MAX_VALUE) {
            return;
        }
        bVar.j.lineTo(i3, i2);
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.f45194a = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f45195b = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
        }
    }
}
