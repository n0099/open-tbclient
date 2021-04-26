package d.a.h0.a.p.d.j;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.h0.a.k;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f43519h = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public long f43520a;

    /* renamed from: b  reason: collision with root package name */
    public long f43521b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f43522c;

    /* renamed from: d  reason: collision with root package name */
    public long f43523d;

    /* renamed from: e  reason: collision with root package name */
    public long f43524e;

    /* renamed from: f  reason: collision with root package name */
    public long f43525f;

    /* renamed from: g  reason: collision with root package name */
    public String f43526g = "1";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public String a() {
        char c2;
        String str = this.f43526g;
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
        long j = this.f43525f;
        if (j > 0) {
            return j;
        }
        long[] jArr = {this.f43523d, this.f43524e, this.f43521b};
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < 3; i2++) {
            long j3 = jArr[i2];
            if (j3 > 0 && j3 < j2) {
                j2 = j3;
            }
        }
        if (j2 != Long.MAX_VALUE) {
            this.f43525f = j2;
        }
        return this.f43525f;
    }

    public String c(long j) {
        return j == this.f43523d ? "2" : j == this.f43524e ? "3" : (j != this.f43521b && j == this.f43522c) ? "0" : "1";
    }

    public final void d() {
        if (this.f43522c > 0 && this.f43522c != this.f43523d && this.f43522c != this.f43524e && this.f43522c != this.f43521b) {
            if (f43519h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.f43522c);
            }
        } else if (this.f43523d > 0) {
            if (f43519h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.f43523d);
            }
            this.f43522c = this.f43523d;
            this.f43526g = "2";
        } else if (this.f43524e > 0) {
            if (f43519h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.f43524e);
            }
            this.f43522c = this.f43524e;
            this.f43526g = "3";
        } else if (this.f43521b > 0) {
            if (f43519h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.f43521b);
            }
            this.f43522c = this.f43521b;
            this.f43526g = "1";
        } else if (f43519h) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.f43520a + ", fcp=" + this.f43521b + ", fmp=" + this.f43522c + ", ftp=" + this.f43523d + ", fip=" + this.f43524e + ", mMinCache=" + this.f43525f + ", fmpType='" + this.f43526g + "', fmpTypeName='" + a() + "'}";
    }
}
