package com.repackage;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.repackage.bo3;
/* loaded from: classes6.dex */
public interface ko3 {
    void a(DownloadInfo downloadInfo);

    void b(DownloadInfo downloadInfo);

    void c(DownloadInfo downloadInfo);

    void d(DownloadInfo downloadInfo);

    void destroy();

    void f(@NonNull String str, @NonNull Uri uri, @NonNull bo3.d<Boolean> dVar);

    DownloadInfo g(String str);
}
