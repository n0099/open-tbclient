package d.b.g0.a.p.d.j;

import android.util.Log;
import androidx.annotation.NonNull;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f45451h = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public long f45452a;

    /* renamed from: b  reason: collision with root package name */
    public long f45453b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f45454c;

    /* renamed from: d  reason: collision with root package name */
    public long f45455d;

    /* renamed from: e  reason: collision with root package name */
    public long f45456e;

    /* renamed from: f  reason: collision with root package name */
    public long f45457f;

    /* renamed from: g  reason: collision with root package name */
    public String f45458g = "1";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public String a() {
        char c2;
        String str = this.f45458g;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 49:
                if (str.equals("1")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 50:
                if (str.equals("2")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 51:
                if (str.equals("3")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        return c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? "unknown" : "fip" : "ftp" : "fcp" : "fmp";
    }

    public long b() {
        long j = this.f45457f;
        if (j > 0) {
            return j;
        }
        long[] jArr = {this.f45455d, this.f45456e, this.f45453b};
        long j2 = Long.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            long j3 = jArr[i];
            if (j3 > 0 && j3 < j2) {
                j2 = j3;
            }
        }
        if (j2 != Long.MAX_VALUE) {
            this.f45457f = j2;
        }
        return this.f45457f;
    }

    public String c(long j) {
        return j == this.f45455d ? "2" : j == this.f45456e ? "3" : (j != this.f45453b && j == this.f45454c) ? "0" : "1";
    }

    public final void d() {
        if (this.f45454c > 0 && this.f45454c != this.f45455d && this.f45454c != this.f45456e && this.f45454c != this.f45453b) {
            if (f45451h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.f45454c);
            }
        } else if (this.f45455d > 0) {
            if (f45451h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.f45455d);
            }
            this.f45454c = this.f45455d;
            this.f45458g = "2";
        } else if (this.f45456e > 0) {
            if (f45451h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.f45456e);
            }
            this.f45454c = this.f45456e;
            this.f45458g = "3";
        } else if (this.f45453b > 0) {
            if (f45451h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.f45453b);
            }
            this.f45454c = this.f45453b;
            this.f45458g = "1";
        } else if (f45451h) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.f45452a + ", fcp=" + this.f45453b + ", fmp=" + this.f45454c + ", ftp=" + this.f45455d + ", fip=" + this.f45456e + ", mMinCache=" + this.f45457f + ", fmpType='" + this.f45458g + "', fmpTypeName='" + a() + "'}";
    }
}
