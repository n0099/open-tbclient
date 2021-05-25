package d.a.l0.a.p.e.j;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f43999h = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public long f44000a;

    /* renamed from: b  reason: collision with root package name */
    public long f44001b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f44002c;

    /* renamed from: d  reason: collision with root package name */
    public long f44003d;

    /* renamed from: e  reason: collision with root package name */
    public long f44004e;

    /* renamed from: f  reason: collision with root package name */
    public long f44005f;

    /* renamed from: g  reason: collision with root package name */
    public String f44006g = "1";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public String a() {
        char c2;
        String str = this.f44006g;
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
        long j = this.f44005f;
        if (j > 0) {
            return j;
        }
        long[] jArr = {this.f44003d, this.f44004e, this.f44001b};
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < 3; i2++) {
            long j3 = jArr[i2];
            if (j3 > 0 && j3 < j2) {
                j2 = j3;
            }
        }
        if (j2 != Long.MAX_VALUE) {
            this.f44005f = j2;
        }
        return this.f44005f;
    }

    public String c(long j) {
        return j == this.f44003d ? "2" : j == this.f44004e ? "3" : (j != this.f44001b && j == this.f44002c) ? "0" : "1";
    }

    public final void d() {
        if (this.f44002c > 0 && this.f44002c != this.f44003d && this.f44002c != this.f44004e && this.f44002c != this.f44001b) {
            if (f43999h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.f44002c);
            }
        } else if (this.f44003d > 0) {
            if (f43999h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.f44003d);
            }
            this.f44002c = this.f44003d;
            this.f44006g = "2";
        } else if (this.f44004e > 0) {
            if (f43999h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.f44004e);
            }
            this.f44002c = this.f44004e;
            this.f44006g = "3";
        } else if (this.f44001b > 0) {
            if (f43999h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.f44001b);
            }
            this.f44002c = this.f44001b;
            this.f44006g = "1";
        } else if (f43999h) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.f44000a + ", fcp=" + this.f44001b + ", fmp=" + this.f44002c + ", ftp=" + this.f44003d + ", fip=" + this.f44004e + ", mMinCache=" + this.f44005f + ", fmpType='" + this.f44006g + "', fmpTypeName='" + a() + "'}";
    }
}
