package d.a.k0.o.d.f;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public interface a {
        boolean b(View view);
    }

    void a(int i2);

    boolean b(View view);

    void c(@NonNull DownloadStatus downloadStatus);

    void d(DownloadStatus downloadStatus, int i2);

    View getActionBar();

    @NonNull
    View getRealView();
}
