package d.a.l0.h.q;

import android.content.Context;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import d.a.l0.a.k;
import java.util.ArrayDeque;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f51323a;

    static {
        boolean z = k.f46875a;
    }

    public b() {
        new ArrayDeque();
    }

    public static b b() {
        if (f51323a == null) {
            synchronized (b.class) {
                if (f51323a == null) {
                    f51323a = new b();
                }
            }
        }
        return f51323a;
    }

    public DuMixGameSurfaceView a(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
