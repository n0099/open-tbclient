package d.a.i0.h.q;

import android.content.Context;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import d.a.i0.a.k;
import java.util.ArrayDeque;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f47473a;

    static {
        boolean z = k.f43025a;
    }

    public b() {
        new ArrayDeque();
    }

    public static b b() {
        if (f47473a == null) {
            synchronized (b.class) {
                if (f47473a == null) {
                    f47473a = new b();
                }
            }
        }
        return f47473a;
    }

    public DuMixGameSurfaceView a(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
