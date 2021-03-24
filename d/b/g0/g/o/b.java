package d.b.g0.g.o;

import android.content.Context;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import d.b.g0.a.k;
import java.util.ArrayDeque;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f48519a;

    static {
        boolean z = k.f45050a;
    }

    public b() {
        new ArrayDeque();
    }

    public static b b() {
        if (f48519a == null) {
            synchronized (b.class) {
                if (f48519a == null) {
                    f48519a = new b();
                }
            }
        }
        return f48519a;
    }

    public DuMixGameSurfaceView a(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
