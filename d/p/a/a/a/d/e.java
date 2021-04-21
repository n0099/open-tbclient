package d.p.a.a.a.d;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f67526a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f67527b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f67528c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f67529d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f67530e;

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f67526a = downloadInfo.c0();
        this.f67527b = downloadInfo.H0();
        this.f67529d = downloadInfo.E();
        this.f67528c = downloadInfo.Q0();
        this.f67530e = downloadInfo.K0();
        BaseException U = downloadInfo.U();
        if (U != null) {
            U.getErrorCode();
        }
        downloadInfo.K1();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof e) && obj != null) {
            e eVar = (e) obj;
            return ((this.f67526a > eVar.f67526a ? 1 : (this.f67526a == eVar.f67526a ? 0 : -1)) == 0) && (this.f67527b == eVar.f67527b) && ((this.f67528c > eVar.f67528c ? 1 : (this.f67528c == eVar.f67528c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f67530e) && TextUtils.isEmpty(eVar.f67530e)) || (!TextUtils.isEmpty(this.f67530e) && !TextUtils.isEmpty(eVar.f67530e) && this.f67530e.equals(eVar.f67530e)));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f67526a), Integer.valueOf(this.f67527b), Long.valueOf(this.f67528c), this.f67530e});
    }
}
