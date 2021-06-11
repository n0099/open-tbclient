package d.o.a.a.a.d;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f70377a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f70378b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f70379c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f70380d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f70381e;

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f70377a = downloadInfo.c0();
        this.f70378b = downloadInfo.H0();
        this.f70380d = downloadInfo.E();
        this.f70379c = downloadInfo.Q0();
        this.f70381e = downloadInfo.K0();
        BaseException U = downloadInfo.U();
        if (U != null) {
            U.getErrorCode();
        }
        downloadInfo.K1();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof e) && obj != null) {
            e eVar = (e) obj;
            return ((this.f70377a > eVar.f70377a ? 1 : (this.f70377a == eVar.f70377a ? 0 : -1)) == 0) && (this.f70378b == eVar.f70378b) && ((this.f70379c > eVar.f70379c ? 1 : (this.f70379c == eVar.f70379c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f70381e) && TextUtils.isEmpty(eVar.f70381e)) || (!TextUtils.isEmpty(this.f70381e) && !TextUtils.isEmpty(eVar.f70381e) && this.f70381e.equals(eVar.f70381e)));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f70377a), Integer.valueOf(this.f70378b), Long.valueOf(this.f70379c), this.f70381e});
    }
}
