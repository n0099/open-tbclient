package d.a.i0.h.d0;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47111c = k.f43025a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f47112d = null;

    /* renamed from: a  reason: collision with root package name */
    public GameRecorderController f47113a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47114b;

    public static g a() {
        if (f47112d == null) {
            synchronized (g.class) {
                if (f47112d == null) {
                    f47112d = new g();
                }
            }
        }
        return f47112d;
    }

    @NonNull
    public GameRecorderController b() {
        if (f47111c) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.f47113a);
        }
        GameRecorderController gameRecorderController = this.f47113a;
        return gameRecorderController == null ? GameRecorderController.j() : gameRecorderController;
    }

    public boolean c() {
        if (f47111c) {
            Log.i("GameRecorderManager", "isGamePause:" + this.f47114b);
        }
        return this.f47114b;
    }

    public void d() {
        this.f47114b = true;
    }

    public void e() {
        this.f47114b = false;
    }

    public void f(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f47113a;
        if (gameRecorderController2 == null || gameRecorderController2 != gameRecorderController) {
            return;
        }
        gameRecorderController2.p();
        this.f47113a = null;
    }

    public void g(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f47113a;
        if (gameRecorderController2 != null && gameRecorderController2 != gameRecorderController) {
            gameRecorderController2.p();
        }
        this.f47113a = gameRecorderController;
    }
}
