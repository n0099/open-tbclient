package d.o.a.a.a.d;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f66385a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f66386b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f66387c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f66388d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f66389e;

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f66385a = downloadInfo.c0();
        this.f66386b = downloadInfo.H0();
        this.f66388d = downloadInfo.E();
        this.f66387c = downloadInfo.Q0();
        this.f66389e = downloadInfo.K0();
        BaseException U = downloadInfo.U();
        if (U != null) {
            U.getErrorCode();
        }
        downloadInfo.K1();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof e) && obj != null) {
            e eVar = (e) obj;
            return ((this.f66385a > eVar.f66385a ? 1 : (this.f66385a == eVar.f66385a ? 0 : -1)) == 0) && (this.f66386b == eVar.f66386b) && ((this.f66387c > eVar.f66387c ? 1 : (this.f66387c == eVar.f66387c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f66389e) && TextUtils.isEmpty(eVar.f66389e)) || (!TextUtils.isEmpty(this.f66389e) && !TextUtils.isEmpty(eVar.f66389e) && this.f66389e.equals(eVar.f66389e)));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f66385a), Integer.valueOf(this.f66386b), Long.valueOf(this.f66387c), this.f66389e});
    }
}
