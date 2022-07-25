package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
/* loaded from: classes6.dex */
public interface no3<VIEW extends View> {
    void a(String str);

    void b(DownloadState downloadState);

    no3 c(Context context, DownloadParams downloadParams, io3 io3Var);

    void d(int i);

    void e(Object obj);

    void f();

    VIEW getRealView();
}
