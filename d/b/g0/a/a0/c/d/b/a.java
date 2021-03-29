package d.b.g0.a.a0.c.d.b;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import d.b.g0.a.c0.c;
/* loaded from: classes2.dex */
public class a {
    @Nullable
    public static CanvasView a(d.b.g0.a.y.b.a aVar) {
        d.b.g0.a.a0.c.d.a aVar2 = (d.b.g0.a.a0.c.d.a) d.b.g0.a.a0.d.a.a(aVar);
        if (aVar2 == null) {
            c.b("Component-Canvas-Utils", "get canvas view fail: find a null component");
            return null;
        }
        return aVar2.i;
    }
}
