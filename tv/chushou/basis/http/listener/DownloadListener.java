package tv.chushou.basis.http.listener;

import android.support.annotation.Keep;
import java.io.File;
import tv.chushou.basis.d.a.c.a;
@Keep
/* loaded from: classes5.dex */
public interface DownloadListener extends a<File> {
    void onProgress(int i);
}
