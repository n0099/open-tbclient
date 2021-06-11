package d.a.l0.a.p.e.j;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f47673h = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public long f47674a;

    /* renamed from: b  reason: collision with root package name */
    public long f47675b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f47676c;

    /* renamed from: d  reason: collision with root package name */
    public long f47677d;

    /* renamed from: e  reason: collision with root package name */
    public long f47678e;

    /* renamed from: f  reason: collision with root package name */
    public long f47679f;

    /* renamed from: g  reason: collision with root package name */
    public String f47680g = "1";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public String a() {
        char c2;
        String str = this.f47680g;
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
        long j = this.f47679f;
        if (j > 0) {
            return j;
        }
        long[] jArr = {this.f47677d, this.f47678e, this.f47675b};
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < 3; i2++) {
            long j3 = jArr[i2];
            if (j3 > 0 && j3 < j2) {
                j2 = j3;
            }
        }
        if (j2 != Long.MAX_VALUE) {
            this.f47679f = j2;
        }
        return this.f47679f;
    }

    public String c(long j) {
        return j == this.f47677d ? "2" : j == this.f47678e ? "3" : (j != this.f47675b && j == this.f47676c) ? "0" : "1";
    }

    public final void d() {
        if (this.f47676c > 0 && this.f47676c != this.f47677d && this.f47676c != this.f47678e && this.f47676c != this.f47675b) {
            if (f47673h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.f47676c);
            }
        } else if (this.f47677d > 0) {
            if (f47673h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.f47677d);
            }
            this.f47676c = this.f47677d;
            this.f47680g = "2";
        } else if (this.f47678e > 0) {
            if (f47673h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.f47678e);
            }
            this.f47676c = this.f47678e;
            this.f47680g = "3";
        } else if (this.f47675b > 0) {
            if (f47673h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.f47675b);
            }
            this.f47676c = this.f47675b;
            this.f47680g = "1";
        } else if (f47673h) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.f47674a + ", fcp=" + this.f47675b + ", fmp=" + this.f47676c + ", ftp=" + this.f47677d + ", fip=" + this.f47678e + ", mMinCache=" + this.f47679f + ", fmpType='" + this.f47680g + "', fmpTypeName='" + a() + "'}";
    }
}
