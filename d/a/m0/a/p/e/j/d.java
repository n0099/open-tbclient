package d.a.m0.a.p.e.j;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.m0.a.k;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f47781h = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public long f47782a;

    /* renamed from: b  reason: collision with root package name */
    public long f47783b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f47784c;

    /* renamed from: d  reason: collision with root package name */
    public long f47785d;

    /* renamed from: e  reason: collision with root package name */
    public long f47786e;

    /* renamed from: f  reason: collision with root package name */
    public long f47787f;

    /* renamed from: g  reason: collision with root package name */
    public String f47788g = "1";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public String a() {
        char c2;
        String str = this.f47788g;
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
        long j = this.f47787f;
        if (j > 0) {
            return j;
        }
        long[] jArr = {this.f47785d, this.f47786e, this.f47783b};
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < 3; i2++) {
            long j3 = jArr[i2];
            if (j3 > 0 && j3 < j2) {
                j2 = j3;
            }
        }
        if (j2 != Long.MAX_VALUE) {
            this.f47787f = j2;
        }
        return this.f47787f;
    }

    public String c(long j) {
        return j == this.f47785d ? "2" : j == this.f47786e ? "3" : (j != this.f47783b && j == this.f47784c) ? "0" : "1";
    }

    public final void d() {
        if (this.f47784c > 0 && this.f47784c != this.f47785d && this.f47784c != this.f47786e && this.f47784c != this.f47783b) {
            if (f47781h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.f47784c);
            }
        } else if (this.f47785d > 0) {
            if (f47781h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.f47785d);
            }
            this.f47784c = this.f47785d;
            this.f47788g = "2";
        } else if (this.f47786e > 0) {
            if (f47781h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.f47786e);
            }
            this.f47784c = this.f47786e;
            this.f47788g = "3";
        } else if (this.f47783b > 0) {
            if (f47781h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.f47783b);
            }
            this.f47784c = this.f47783b;
            this.f47788g = "1";
        } else if (f47781h) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.f47782a + ", fcp=" + this.f47783b + ", fmp=" + this.f47784c + ", ftp=" + this.f47785d + ", fip=" + this.f47786e + ", mMinCache=" + this.f47787f + ", fmpType='" + this.f47788g + "', fmpTypeName='" + a() + "'}";
    }
}
