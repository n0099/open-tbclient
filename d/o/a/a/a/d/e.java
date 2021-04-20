package d.o.a.a.a.d;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f67379a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f67380b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f67381c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f67382d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f67383e;

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f67379a = downloadInfo.c0();
        this.f67380b = downloadInfo.H0();
        this.f67382d = downloadInfo.E();
        this.f67381c = downloadInfo.Q0();
        this.f67383e = downloadInfo.K0();
        BaseException U = downloadInfo.U();
        if (U != null) {
            U.getErrorCode();
        }
        downloadInfo.K1();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof e) && obj != null) {
            e eVar = (e) obj;
            return ((this.f67379a > eVar.f67379a ? 1 : (this.f67379a == eVar.f67379a ? 0 : -1)) == 0) && (this.f67380b == eVar.f67380b) && ((this.f67381c > eVar.f67381c ? 1 : (this.f67381c == eVar.f67381c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f67383e) && TextUtils.isEmpty(eVar.f67383e)) || (!TextUtils.isEmpty(this.f67383e) && !TextUtils.isEmpty(eVar.f67383e) && this.f67383e.equals(eVar.f67383e)));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f67379a), Integer.valueOf(this.f67380b), Long.valueOf(this.f67381c), this.f67383e});
    }
}
