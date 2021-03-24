package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Region;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class g extends a {
    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        bVar.k = true;
        canvas.clipPath(bVar.j, Region.Op.INTERSECT);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
    }
}
