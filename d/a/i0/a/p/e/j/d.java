package d.a.i0.a.p.e.j;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f43823h = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public long f43824a;

    /* renamed from: b  reason: collision with root package name */
    public long f43825b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f43826c;

    /* renamed from: d  reason: collision with root package name */
    public long f43827d;

    /* renamed from: e  reason: collision with root package name */
    public long f43828e;

    /* renamed from: f  reason: collision with root package name */
    public long f43829f;

    /* renamed from: g  reason: collision with root package name */
    public String f43830g = "1";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public String a() {
        char c2;
        String str = this.f43830g;
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
        long j = this.f43829f;
        if (j > 0) {
            return j;
        }
        long[] jArr = {this.f43827d, this.f43828e, this.f43825b};
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < 3; i2++) {
            long j3 = jArr[i2];
            if (j3 > 0 && j3 < j2) {
                j2 = j3;
            }
        }
        if (j2 != Long.MAX_VALUE) {
            this.f43829f = j2;
        }
        return this.f43829f;
    }

    public String c(long j) {
        return j == this.f43827d ? "2" : j == this.f43828e ? "3" : (j != this.f43825b && j == this.f43826c) ? "0" : "1";
    }

    public final void d() {
        if (this.f43826c > 0 && this.f43826c != this.f43827d && this.f43826c != this.f43828e && this.f43826c != this.f43825b) {
            if (f43823h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.f43826c);
            }
        } else if (this.f43827d > 0) {
            if (f43823h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.f43827d);
            }
            this.f43826c = this.f43827d;
            this.f43830g = "2";
        } else if (this.f43828e > 0) {
            if (f43823h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.f43828e);
            }
            this.f43826c = this.f43828e;
            this.f43830g = "3";
        } else if (this.f43825b > 0) {
            if (f43823h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.f43825b);
            }
            this.f43826c = this.f43825b;
            this.f43830g = "1";
        } else if (f43823h) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.f43824a + ", fcp=" + this.f43825b + ", fmp=" + this.f43826c + ", ftp=" + this.f43827d + ", fip=" + this.f43828e + ", mMinCache=" + this.f43829f + ", fmpType='" + this.f43830g + "', fmpTypeName='" + a() + "'}";
    }
}
