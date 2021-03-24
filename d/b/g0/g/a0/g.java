package d.b.g0.g.a0;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47859c = k.f45050a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f47860d = null;

    /* renamed from: a  reason: collision with root package name */
    public GameRecorderController f47861a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47862b;

    public static g a() {
        if (f47860d == null) {
            synchronized (g.class) {
                if (f47860d == null) {
                    f47860d = new g();
                }
            }
        }
        return f47860d;
    }

    @NonNull
    public GameRecorderController b() {
        if (f47859c) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.f47861a);
        }
        GameRecorderController gameRecorderController = this.f47861a;
        return gameRecorderController == null ? GameRecorderController.j() : gameRecorderController;
    }

    public boolean c() {
        if (f47859c) {
            Log.i("GameRecorderManager", "isGamePause:" + this.f47862b);
        }
        return this.f47862b;
    }

    public void d() {
        this.f47862b = true;
    }

    public void e() {
        this.f47862b = false;
    }

    public void f(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f47861a;
        if (gameRecorderController2 == null || gameRecorderController2 != gameRecorderController) {
            return;
        }
        gameRecorderController2.p();
        this.f47861a = null;
    }

    public void g(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f47861a;
        if (gameRecorderController2 != null && gameRecorderController2 != gameRecorderController) {
            gameRecorderController2.p();
        }
        this.f47861a = gameRecorderController;
    }
}
