package d.a.l0.h.d0;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50961c = k.f46875a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f50962d = null;

    /* renamed from: a  reason: collision with root package name */
    public GameRecorderController f50963a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50964b;

    public static g a() {
        if (f50962d == null) {
            synchronized (g.class) {
                if (f50962d == null) {
                    f50962d = new g();
                }
            }
        }
        return f50962d;
    }

    @NonNull
    public GameRecorderController b() {
        if (f50961c) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.f50963a);
        }
        GameRecorderController gameRecorderController = this.f50963a;
        return gameRecorderController == null ? GameRecorderController.j() : gameRecorderController;
    }

    public boolean c() {
        if (f50961c) {
            Log.i("GameRecorderManager", "isGamePause:" + this.f50964b);
        }
        return this.f50964b;
    }

    public void d() {
        this.f50964b = true;
    }

    public void e() {
        this.f50964b = false;
    }

    public void f(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f50963a;
        if (gameRecorderController2 == null || gameRecorderController2 != gameRecorderController) {
            return;
        }
        gameRecorderController2.p();
        this.f50963a = null;
    }

    public void g(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f50963a;
        if (gameRecorderController2 != null && gameRecorderController2 != gameRecorderController) {
            gameRecorderController2.p();
        }
        this.f50963a = gameRecorderController;
    }
}
