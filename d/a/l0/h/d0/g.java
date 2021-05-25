package d.a.l0.h.d0;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47287c = k.f43199a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f47288d = null;

    /* renamed from: a  reason: collision with root package name */
    public GameRecorderController f47289a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47290b;

    public static g a() {
        if (f47288d == null) {
            synchronized (g.class) {
                if (f47288d == null) {
                    f47288d = new g();
                }
            }
        }
        return f47288d;
    }

    @NonNull
    public GameRecorderController b() {
        if (f47287c) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.f47289a);
        }
        GameRecorderController gameRecorderController = this.f47289a;
        return gameRecorderController == null ? GameRecorderController.j() : gameRecorderController;
    }

    public boolean c() {
        if (f47287c) {
            Log.i("GameRecorderManager", "isGamePause:" + this.f47290b);
        }
        return this.f47290b;
    }

    public void d() {
        this.f47290b = true;
    }

    public void e() {
        this.f47290b = false;
    }

    public void f(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f47289a;
        if (gameRecorderController2 == null || gameRecorderController2 != gameRecorderController) {
            return;
        }
        gameRecorderController2.p();
        this.f47289a = null;
    }

    public void g(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f47289a;
        if (gameRecorderController2 != null && gameRecorderController2 != gameRecorderController) {
            gameRecorderController2.p();
        }
        this.f47289a = gameRecorderController;
    }
}
