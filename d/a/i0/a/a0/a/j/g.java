package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Region;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class g extends a {
    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        bVar.k = true;
        canvas.clipPath(bVar.j, Region.Op.INTERSECT);
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
    }
}
