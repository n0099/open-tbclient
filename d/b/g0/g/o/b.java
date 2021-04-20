package d.b.g0.g.o;

import android.content.Context;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import d.b.g0.a.k;
import java.util.ArrayDeque;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f48912a;

    static {
        boolean z = k.f45443a;
    }

    public b() {
        new ArrayDeque();
    }

    public static b b() {
        if (f48912a == null) {
            synchronized (b.class) {
                if (f48912a == null) {
                    f48912a = new b();
                }
            }
        }
        return f48912a;
    }

    public DuMixGameSurfaceView a(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
