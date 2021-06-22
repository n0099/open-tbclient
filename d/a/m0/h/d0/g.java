package d.a.m0.h.d0;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f51069c = k.f46983a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f51070d = null;

    /* renamed from: a  reason: collision with root package name */
    public GameRecorderController f51071a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51072b;

    public static g a() {
        if (f51070d == null) {
            synchronized (g.class) {
                if (f51070d == null) {
                    f51070d = new g();
                }
            }
        }
        return f51070d;
    }

    @NonNull
    public GameRecorderController b() {
        if (f51069c) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.f51071a);
        }
        GameRecorderController gameRecorderController = this.f51071a;
        return gameRecorderController == null ? GameRecorderController.j() : gameRecorderController;
    }

    public boolean c() {
        if (f51069c) {
            Log.i("GameRecorderManager", "isGamePause:" + this.f51072b);
        }
        return this.f51072b;
    }

    public void d() {
        this.f51072b = true;
    }

    public void e() {
        this.f51072b = false;
    }

    public void f(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f51071a;
        if (gameRecorderController2 == null || gameRecorderController2 != gameRecorderController) {
            return;
        }
        gameRecorderController2.p();
        this.f51071a = null;
    }

    public void g(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f51071a;
        if (gameRecorderController2 != null && gameRecorderController2 != gameRecorderController) {
            gameRecorderController2.p();
        }
        this.f51071a = gameRecorderController;
    }
}
