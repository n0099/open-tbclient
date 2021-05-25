package d.o.a.a.a.d;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f66591a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f66592b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f66593c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f66594d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f66595e;

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f66591a = downloadInfo.c0();
        this.f66592b = downloadInfo.H0();
        this.f66594d = downloadInfo.E();
        this.f66593c = downloadInfo.Q0();
        this.f66595e = downloadInfo.K0();
        BaseException U = downloadInfo.U();
        if (U != null) {
            U.getErrorCode();
        }
        downloadInfo.K1();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof e) && obj != null) {
            e eVar = (e) obj;
            return ((this.f66591a > eVar.f66591a ? 1 : (this.f66591a == eVar.f66591a ? 0 : -1)) == 0) && (this.f66592b == eVar.f66592b) && ((this.f66593c > eVar.f66593c ? 1 : (this.f66593c == eVar.f66593c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f66595e) && TextUtils.isEmpty(eVar.f66595e)) || (!TextUtils.isEmpty(this.f66595e) && !TextUtils.isEmpty(eVar.f66595e) && this.f66595e.equals(eVar.f66595e)));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f66591a), Integer.valueOf(this.f66592b), Long.valueOf(this.f66593c), this.f66595e});
    }
}
