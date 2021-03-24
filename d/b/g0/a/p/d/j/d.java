package d.b.g0.a.p.d.j;

import android.util.Log;
import androidx.annotation.NonNull;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f45450h = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public long f45451a;

    /* renamed from: b  reason: collision with root package name */
    public long f45452b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f45453c;

    /* renamed from: d  reason: collision with root package name */
    public long f45454d;

    /* renamed from: e  reason: collision with root package name */
    public long f45455e;

    /* renamed from: f  reason: collision with root package name */
    public long f45456f;

    /* renamed from: g  reason: collision with root package name */
    public String f45457g = "1";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public String a() {
        char c2;
        String str = this.f45457g;
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
        long j = this.f45456f;
        if (j > 0) {
            return j;
        }
        long[] jArr = {this.f45454d, this.f45455e, this.f45452b};
        long j2 = Long.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            long j3 = jArr[i];
            if (j3 > 0 && j3 < j2) {
                j2 = j3;
            }
        }
        if (j2 != Long.MAX_VALUE) {
            this.f45456f = j2;
        }
        return this.f45456f;
    }

    public String c(long j) {
        return j == this.f45454d ? "2" : j == this.f45455e ? "3" : (j != this.f45452b && j == this.f45453c) ? "0" : "1";
    }

    public final void d() {
        if (this.f45453c > 0 && this.f45453c != this.f45454d && this.f45453c != this.f45455e && this.f45453c != this.f45452b) {
            if (f45450h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.f45453c);
            }
        } else if (this.f45454d > 0) {
            if (f45450h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.f45454d);
            }
            this.f45453c = this.f45454d;
            this.f45457g = "2";
        } else if (this.f45455e > 0) {
            if (f45450h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.f45455e);
            }
            this.f45453c = this.f45455e;
            this.f45457g = "3";
        } else if (this.f45452b > 0) {
            if (f45450h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.f45452b);
            }
            this.f45453c = this.f45452b;
            this.f45457g = "1";
        } else if (f45450h) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.f45451a + ", fcp=" + this.f45452b + ", fmp=" + this.f45453c + ", ftp=" + this.f45454d + ", fip=" + this.f45455e + ", mMinCache=" + this.f45456f + ", fmpType='" + this.f45457g + "', fmpTypeName='" + a() + "'}";
    }
}
