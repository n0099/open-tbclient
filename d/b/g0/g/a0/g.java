package d.b.g0.g.a0;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48252c = k.f45443a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f48253d = null;

    /* renamed from: a  reason: collision with root package name */
    public GameRecorderController f48254a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48255b;

    public static g a() {
        if (f48253d == null) {
            synchronized (g.class) {
                if (f48253d == null) {
                    f48253d = new g();
                }
            }
        }
        return f48253d;
    }

    @NonNull
    public GameRecorderController b() {
        if (f48252c) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.f48254a);
        }
        GameRecorderController gameRecorderController = this.f48254a;
        return gameRecorderController == null ? GameRecorderController.j() : gameRecorderController;
    }

    public boolean c() {
        if (f48252c) {
            Log.i("GameRecorderManager", "isGamePause:" + this.f48255b);
        }
        return this.f48255b;
    }

    public void d() {
        this.f48255b = true;
    }

    public void e() {
        this.f48255b = false;
    }

    public void f(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f48254a;
        if (gameRecorderController2 == null || gameRecorderController2 != gameRecorderController) {
            return;
        }
        gameRecorderController2.p();
        this.f48254a = null;
    }

    public void g(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2 = this.f48254a;
        if (gameRecorderController2 != null && gameRecorderController2 != gameRecorderController) {
            gameRecorderController2.p();
        }
        this.f48254a = gameRecorderController;
    }
}
