package d.a.h0.g.a0;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46043c = k.f43101a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f46044d = null;

    /* renamed from: a  reason: collision with root package name */
    public GameRecorderController f46045a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f46046b;

    public static g a() {
        if (f46044d == null) {
            synchronized (g.class) {
                if (f46044d == null) {
                    f46044d = new g();
                }
            }
        }
        return f46044d;
    }

    @NonNull
    public GameRecorderController b() {
        if (f46043c) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.f46045a);
        }
        GameRecorderController gameRecorderController = this.f46045a;
        return gameRecorderController == null ? GameRecorderController.j() : gameRecorderController;
    }

    public boolean c() {
        if (f46043c) {
            Log.i("GameRecorderManager", "isGamePause:" + this.f46046b);
        }
        return this.f46046b;
    }

    public void d() {
        this.f46046b = true;
    }

    public void e() {
        this.f46046b = false;
    }

    public void f(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f46045a;
        if (gameRecorderController2 == null || gameRecorderController2 != gameRecorderController) {
            return;
        }
        gameRecorderController2.p();
        this.f46045a = null;
    }

    public void g(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f46045a;
        if (gameRecorderController2 != null && gameRecorderController2 != gameRecorderController) {
            gameRecorderController2.p();
        }
        this.f46045a = gameRecorderController;
    }
}
