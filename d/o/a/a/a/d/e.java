package d.o.a.a.a.d;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f70481a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f70482b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f70483c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f70484d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f70485e;

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f70481a = downloadInfo.c0();
        this.f70482b = downloadInfo.H0();
        this.f70484d = downloadInfo.E();
        this.f70483c = downloadInfo.Q0();
        this.f70485e = downloadInfo.K0();
        BaseException U = downloadInfo.U();
        if (U != null) {
            U.getErrorCode();
        }
        downloadInfo.K1();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof e) && obj != null) {
            e eVar = (e) obj;
            return ((this.f70481a > eVar.f70481a ? 1 : (this.f70481a == eVar.f70481a ? 0 : -1)) == 0) && (this.f70482b == eVar.f70482b) && ((this.f70483c > eVar.f70483c ? 1 : (this.f70483c == eVar.f70483c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f70485e) && TextUtils.isEmpty(eVar.f70485e)) || (!TextUtils.isEmpty(this.f70485e) && !TextUtils.isEmpty(eVar.f70485e) && this.f70485e.equals(eVar.f70485e)));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f70481a), Integer.valueOf(this.f70482b), Long.valueOf(this.f70483c), this.f70485e});
    }
}
