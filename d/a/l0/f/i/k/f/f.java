package d.a.l0.f.i.k.f;

import android.content.Context;
import android.view.View;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
/* loaded from: classes3.dex */
public interface f<VIEW extends View> {
    void a(String str);

    void b(DownloadState downloadState);

    f c(Context context, DownloadParams downloadParams, a aVar);

    void d(int i2);

    void e(Object obj);

    void f();

    VIEW getRealView();
}
