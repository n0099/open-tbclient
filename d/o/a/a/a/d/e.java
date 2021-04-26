package d.o.a.a.a.d;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f65862a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f65863b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f65864c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f65865d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f65866e;

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f65862a = downloadInfo.c0();
        this.f65863b = downloadInfo.H0();
        this.f65865d = downloadInfo.E();
        this.f65864c = downloadInfo.Q0();
        this.f65866e = downloadInfo.K0();
        BaseException U = downloadInfo.U();
        if (U != null) {
            U.getErrorCode();
        }
        downloadInfo.K1();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof e) && obj != null) {
            e eVar = (e) obj;
            return ((this.f65862a > eVar.f65862a ? 1 : (this.f65862a == eVar.f65862a ? 0 : -1)) == 0) && (this.f65863b == eVar.f65863b) && ((this.f65864c > eVar.f65864c ? 1 : (this.f65864c == eVar.f65864c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f65866e) && TextUtils.isEmpty(eVar.f65866e)) || (!TextUtils.isEmpty(this.f65866e) && !TextUtils.isEmpty(eVar.f65866e) && this.f65866e.equals(eVar.f65866e)));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f65862a), Integer.valueOf(this.f65863b), Long.valueOf(this.f65864c), this.f65866e});
    }
}
