package d.b.g0.g.a0;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47860c = k.f45051a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f47861d = null;

    /* renamed from: a  reason: collision with root package name */
    public GameRecorderController f47862a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47863b;

    public static g a() {
        if (f47861d == null) {
            synchronized (g.class) {
                if (f47861d == null) {
                    f47861d = new g();
                }
            }
        }
        return f47861d;
    }

    @NonNull
    public GameRecorderController b() {
        if (f47860c) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.f47862a);
        }
        GameRecorderController gameRecorderController = this.f47862a;
        return gameRecorderController == null ? GameRecorderController.j() : gameRecorderController;
    }

    public boolean c() {
        if (f47860c) {
            Log.i("GameRecorderManager", "isGamePause:" + this.f47863b);
        }
        return this.f47863b;
    }

    public void d() {
        this.f47863b = true;
    }

    public void e() {
        this.f47863b = false;
    }

    public void f(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f47862a;
        if (gameRecorderController2 == null || gameRecorderController2 != gameRecorderController) {
            return;
        }
        gameRecorderController2.p();
        this.f47862a = null;
    }

    public void g(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f47862a;
        if (gameRecorderController2 != null && gameRecorderController2 != gameRecorderController) {
            gameRecorderController2.p();
        }
        this.f47862a = gameRecorderController;
    }
}
