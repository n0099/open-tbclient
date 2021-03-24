package d.b.i0.o.c.e;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public interface a {
        boolean b(View view);
    }

    void a(int i);

    boolean b(View view);

    void c(@NonNull DownloadStatus downloadStatus);

    void d(DownloadStatus downloadStatus, int i);

    View getActionBar();

    @NonNull
    View getRealView();
}
