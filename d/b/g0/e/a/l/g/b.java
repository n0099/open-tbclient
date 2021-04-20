package d.b.g0.e.a.l.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class b implements d.b.g0.e.a.l.i.d {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f47990a = new a(this, Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public final d.b.g0.e.a.l.i.a f47991b;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(b bVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            DownloadInfo downloadInfo = (DownloadInfo) message.obj;
            int status = downloadInfo.getStatus();
            if (downloadInfo.getDownloadListener() == null) {
                return;
            }
            switch (C0943b.f47992a[SwanAdDownloadState.convert(status).ordinal()]) {
                case 1:
                    downloadInfo.getDownloadListener().d(downloadInfo.getProgress(), downloadInfo.getSize());
                    return;
                case 2:
                    downloadInfo.getDownloadListener().onStart();
                    return;
                case 3:
                    downloadInfo.getDownloadListener().b();
                    return;
                case 4:
                    downloadInfo.getDownloadListener().f(downloadInfo.getProgress(), downloadInfo.getSize());
                    return;
                case 5:
                    downloadInfo.getDownloadListener().a();
                    return;
                case 6:
                    downloadInfo.getDownloadListener().c(downloadInfo.getException());
                    return;
                case 7:
                    downloadInfo.getDownloadListener().e();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: d.b.g0.e.a.l.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0943b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f47992a;

        static {
            int[] iArr = new int[SwanAdDownloadState.values().length];
            f47992a = iArr;
            try {
                iArr[SwanAdDownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47992a[SwanAdDownloadState.PREPARE_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47992a[SwanAdDownloadState.WAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47992a[SwanAdDownloadState.DOWNLOAD_PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47992a[SwanAdDownloadState.DOWNLOADED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f47992a[SwanAdDownloadState.DOWNLOAD_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f47992a[SwanAdDownloadState.DELETED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(d.b.g0.e.a.l.i.a aVar) {
        this.f47991b = aVar;
    }

    @Override // d.b.g0.e.a.l.i.d
    public void a(DownloadException downloadException) {
        if (k.f45443a) {
            Log.d("AdDownload", downloadException.getCode() + "异常");
        }
    }

    @Override // d.b.g0.e.a.l.i.d
    public void b(DownloadInfo downloadInfo) {
        if (downloadInfo.getStatus() != SwanAdDownloadState.DELETED.value()) {
            this.f47991b.a(downloadInfo);
        }
        Message obtainMessage = this.f47990a.obtainMessage(downloadInfo.getId().hashCode());
        obtainMessage.obj = downloadInfo;
        obtainMessage.sendToTarget();
    }
}
