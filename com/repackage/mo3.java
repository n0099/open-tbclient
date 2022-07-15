package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
/* loaded from: classes6.dex */
public interface mo3<VIEW extends View> {
    void a(String str);

    void b(DownloadState downloadState);

    mo3 c(Context context, DownloadParams downloadParams, ho3 ho3Var);

    void d(int i);

    void e(Object obj);

    void f();

    VIEW getRealView();
}
