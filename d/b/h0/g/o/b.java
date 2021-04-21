package d.b.h0.g.o;

import android.content.Context;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import d.b.h0.a.k;
import java.util.ArrayDeque;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f49241a;

    static {
        boolean z = k.f45772a;
    }

    public b() {
        new ArrayDeque();
    }

    public static b b() {
        if (f49241a == null) {
            synchronized (b.class) {
                if (f49241a == null) {
                    f49241a = new b();
                }
            }
        }
        return f49241a;
    }

    public DuMixGameSurfaceView a(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
