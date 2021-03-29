package d.b.g0.g.o;

import android.content.Context;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import d.b.g0.a.k;
import java.util.ArrayDeque;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f48520a;

    static {
        boolean z = k.f45051a;
    }

    public b() {
        new ArrayDeque();
    }

    public static b b() {
        if (f48520a == null) {
            synchronized (b.class) {
                if (f48520a == null) {
                    f48520a = new b();
                }
            }
        }
        return f48520a;
    }

    public DuMixGameSurfaceView a(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
