package d.a.l0.h.q;

import android.content.Context;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import d.a.l0.a.k;
import java.util.ArrayDeque;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f47649a;

    static {
        boolean z = k.f43199a;
    }

    public b() {
        new ArrayDeque();
    }

    public static b b() {
        if (f47649a == null) {
            synchronized (b.class) {
                if (f47649a == null) {
                    f47649a = new b();
                }
            }
        }
        return f47649a;
    }

    public DuMixGameSurfaceView a(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
