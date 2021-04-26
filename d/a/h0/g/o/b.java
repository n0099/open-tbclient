package d.a.h0.g.o;

import android.content.Context;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import d.a.h0.a.k;
import java.util.ArrayDeque;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f46735a;

    static {
        boolean z = k.f43101a;
    }

    public b() {
        new ArrayDeque();
    }

    public static b b() {
        if (f46735a == null) {
            synchronized (b.class) {
                if (f46735a == null) {
                    f46735a = new b();
                }
            }
        }
        return f46735a;
    }

    public DuMixGameSurfaceView a(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
