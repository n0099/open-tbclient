package com.repackage;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes6.dex */
public interface oj5 {

    /* loaded from: classes6.dex */
    public interface a {
        boolean b(View view2);
    }

    void a(int i);

    boolean b(View view2);

    void d(@NonNull DownloadStatus downloadStatus);

    void e(DownloadStatus downloadStatus, int i);

    View getActionBar();

    @NonNull
    View getRealView();
}
