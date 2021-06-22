package d.a.m0.f.i.k.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import d.a.m0.f.i.k.f.e;
/* loaded from: classes3.dex */
public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f50512a = new a(this, Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public final d.a.m0.f.i.k.f.b f50513b;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(b bVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            DownloadInfo downloadInfo = (DownloadInfo) message.obj;
            int status = downloadInfo.getStatus();
            if (downloadInfo.getDownloadListener() == null) {
                return;
            }
            switch (C1039b.f50514a[DownloadState.convert(status).ordinal()]) {
                case 1:
                    downloadInfo.getDownloadListener().e(downloadInfo.getProgress(), downloadInfo.getSize());
                    return;
                case 2:
                    downloadInfo.getDownloadListener().onStart();
                    return;
                case 3:
                    downloadInfo.getDownloadListener().d();
                    return;
                case 4:
                    downloadInfo.getDownloadListener().f(downloadInfo.getProgress(), downloadInfo.getSize());
                    return;
                case 5:
                    downloadInfo.getDownloadListener().a();
                    return;
                case 6:
                    downloadInfo.getDownloadListener().b(downloadInfo.getException());
                    return;
                case 7:
                    downloadInfo.getDownloadListener().c();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: d.a.m0.f.i.k.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C1039b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50514a;

        static {
            int[] iArr = new int[DownloadState.values().length];
            f50514a = iArr;
            try {
                iArr[DownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50514a[DownloadState.PREPARE_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f50514a[DownloadState.WAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f50514a[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f50514a[DownloadState.DOWNLOADED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f50514a[DownloadState.DOWNLOAD_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f50514a[DownloadState.DELETED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(d.a.m0.f.i.k.f.b bVar) {
        this.f50513b = bVar;
    }

    @Override // d.a.m0.f.i.k.f.e
    public void a(DownloadException downloadException) {
    }

    @Override // d.a.m0.f.i.k.f.e
    public void b(DownloadInfo downloadInfo) {
        if (downloadInfo.getStatus() != DownloadState.DELETED.value()) {
            this.f50513b.a(downloadInfo);
        }
        Message obtainMessage = this.f50512a.obtainMessage(downloadInfo.getId().hashCode());
        obtainMessage.obj = downloadInfo;
        obtainMessage.sendToTarget();
    }
}
