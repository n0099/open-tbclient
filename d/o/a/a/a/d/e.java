package d.o.a.a.a.d;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f66386a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f66387b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f66388c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f66389d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f66390e;

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f66386a = downloadInfo.c0();
        this.f66387b = downloadInfo.H0();
        this.f66389d = downloadInfo.E();
        this.f66388c = downloadInfo.Q0();
        this.f66390e = downloadInfo.K0();
        BaseException U = downloadInfo.U();
        if (U != null) {
            U.getErrorCode();
        }
        downloadInfo.K1();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof e) && obj != null) {
            e eVar = (e) obj;
            return ((this.f66386a > eVar.f66386a ? 1 : (this.f66386a == eVar.f66386a ? 0 : -1)) == 0) && (this.f66387b == eVar.f66387b) && ((this.f66388c > eVar.f66388c ? 1 : (this.f66388c == eVar.f66388c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f66390e) && TextUtils.isEmpty(eVar.f66390e)) || (!TextUtils.isEmpty(this.f66390e) && !TextUtils.isEmpty(eVar.f66390e) && this.f66390e.equals(eVar.f66390e)));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f66386a), Integer.valueOf(this.f66387b), Long.valueOf(this.f66388c), this.f66390e});
    }
}
