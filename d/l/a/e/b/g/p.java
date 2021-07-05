package d.l.a.e.b.g;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public interface p<T extends DownloadService> {
    IBinder a(Intent intent);

    void a(int i2);

    void a(int i2, Notification notification);

    void a(Intent intent, int i2, int i3);

    void a(d.l.a.e.b.n.a aVar);

    void a(boolean z);

    boolean a();

    void b(d.l.a.e.b.n.a aVar);

    boolean b();

    void c();

    void c(WeakReference<T> weakReference);

    void d();

    void d(o oVar);

    void f();
}
