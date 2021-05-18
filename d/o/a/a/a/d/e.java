package d.o.a.a.a.d;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f66548a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f66549b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f66550c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f66551d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f66552e;

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f66548a = downloadInfo.c0();
        this.f66549b = downloadInfo.H0();
        this.f66551d = downloadInfo.E();
        this.f66550c = downloadInfo.Q0();
        this.f66552e = downloadInfo.K0();
        BaseException U = downloadInfo.U();
        if (U != null) {
            U.getErrorCode();
        }
        downloadInfo.K1();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof e) && obj != null) {
            e eVar = (e) obj;
            return ((this.f66548a > eVar.f66548a ? 1 : (this.f66548a == eVar.f66548a ? 0 : -1)) == 0) && (this.f66549b == eVar.f66549b) && ((this.f66550c > eVar.f66550c ? 1 : (this.f66550c == eVar.f66550c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f66552e) && TextUtils.isEmpty(eVar.f66552e)) || (!TextUtils.isEmpty(this.f66552e) && !TextUtils.isEmpty(eVar.f66552e) && this.f66552e.equals(eVar.f66552e)));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f66548a), Integer.valueOf(this.f66549b), Long.valueOf(this.f66550c), this.f66552e});
    }
}
