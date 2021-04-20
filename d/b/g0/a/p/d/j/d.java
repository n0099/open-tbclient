package d.b.g0.a.p.d.j;

import android.util.Log;
import androidx.annotation.NonNull;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f45843h = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public long f45844a;

    /* renamed from: b  reason: collision with root package name */
    public long f45845b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f45846c;

    /* renamed from: d  reason: collision with root package name */
    public long f45847d;

    /* renamed from: e  reason: collision with root package name */
    public long f45848e;

    /* renamed from: f  reason: collision with root package name */
    public long f45849f;

    /* renamed from: g  reason: collision with root package name */
    public String f45850g = "1";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public String a() {
        char c2;
        String str = this.f45850g;
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
        long j = this.f45849f;
        if (j > 0) {
            return j;
        }
        long[] jArr = {this.f45847d, this.f45848e, this.f45845b};
        long j2 = Long.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            long j3 = jArr[i];
            if (j3 > 0 && j3 < j2) {
                j2 = j3;
            }
        }
        if (j2 != Long.MAX_VALUE) {
            this.f45849f = j2;
        }
        return this.f45849f;
    }

    public String c(long j) {
        return j == this.f45847d ? "2" : j == this.f45848e ? "3" : (j != this.f45845b && j == this.f45846c) ? "0" : "1";
    }

    public final void d() {
        if (this.f45846c > 0 && this.f45846c != this.f45847d && this.f45846c != this.f45848e && this.f45846c != this.f45845b) {
            if (f45843h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.f45846c);
            }
        } else if (this.f45847d > 0) {
            if (f45843h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.f45847d);
            }
            this.f45846c = this.f45847d;
            this.f45850g = "2";
        } else if (this.f45848e > 0) {
            if (f45843h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.f45848e);
            }
            this.f45846c = this.f45848e;
            this.f45850g = "3";
        } else if (this.f45845b > 0) {
            if (f45843h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.f45845b);
            }
            this.f45846c = this.f45845b;
            this.f45850g = "1";
        } else if (f45843h) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.f45844a + ", fcp=" + this.f45845b + ", fmp=" + this.f45846c + ", ftp=" + this.f45847d + ", fip=" + this.f45848e + ", mMinCache=" + this.f45849f + ", fmpType='" + this.f45850g + "', fmpTypeName='" + a() + "'}";
    }
}
