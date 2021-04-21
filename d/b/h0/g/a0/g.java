package d.b.h0.g.a0;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import d.b.h0.a.k;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48581c = k.f45772a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f48582d = null;

    /* renamed from: a  reason: collision with root package name */
    public GameRecorderController f48583a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48584b;

    public static g a() {
        if (f48582d == null) {
            synchronized (g.class) {
                if (f48582d == null) {
                    f48582d = new g();
                }
            }
        }
        return f48582d;
    }

    @NonNull
    public GameRecorderController b() {
        if (f48581c) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.f48583a);
        }
        GameRecorderController gameRecorderController = this.f48583a;
        return gameRecorderController == null ? GameRecorderController.j() : gameRecorderController;
    }

    public boolean c() {
        if (f48581c) {
            Log.i("GameRecorderManager", "isGamePause:" + this.f48584b);
        }
        return this.f48584b;
    }

    public void d() {
        this.f48584b = true;
    }

    public void e() {
        this.f48584b = false;
    }

    public void f(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f48583a;
        if (gameRecorderController2 == null || gameRecorderController2 != gameRecorderController) {
            return;
        }
        gameRecorderController2.p();
        this.f48583a = null;
    }

    public void g(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f48583a;
        if (gameRecorderController2 != null && gameRecorderController2 != gameRecorderController) {
            gameRecorderController2.p();
        }
        this.f48583a = gameRecorderController;
    }
}
