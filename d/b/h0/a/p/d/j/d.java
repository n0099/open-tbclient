package d.b.h0.a.p.d.j;

import android.util.Log;
import androidx.annotation.NonNull;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f46172h = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public long f46173a;

    /* renamed from: b  reason: collision with root package name */
    public long f46174b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f46175c;

    /* renamed from: d  reason: collision with root package name */
    public long f46176d;

    /* renamed from: e  reason: collision with root package name */
    public long f46177e;

    /* renamed from: f  reason: collision with root package name */
    public long f46178f;

    /* renamed from: g  reason: collision with root package name */
    public String f46179g = "1";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public String a() {
        char c2;
        String str = this.f46179g;
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
        long j = this.f46178f;
        if (j > 0) {
            return j;
        }
        long[] jArr = {this.f46176d, this.f46177e, this.f46174b};
        long j2 = Long.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            long j3 = jArr[i];
            if (j3 > 0 && j3 < j2) {
                j2 = j3;
            }
        }
        if (j2 != Long.MAX_VALUE) {
            this.f46178f = j2;
        }
        return this.f46178f;
    }

    public String c(long j) {
        return j == this.f46176d ? "2" : j == this.f46177e ? "3" : (j != this.f46174b && j == this.f46175c) ? "0" : "1";
    }

    public final void d() {
        if (this.f46175c > 0 && this.f46175c != this.f46176d && this.f46175c != this.f46177e && this.f46175c != this.f46174b) {
            if (f46172h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.f46175c);
            }
        } else if (this.f46176d > 0) {
            if (f46172h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.f46176d);
            }
            this.f46175c = this.f46176d;
            this.f46179g = "2";
        } else if (this.f46177e > 0) {
            if (f46172h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.f46177e);
            }
            this.f46175c = this.f46177e;
            this.f46179g = "3";
        } else if (this.f46174b > 0) {
            if (f46172h) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.f46174b);
            }
            this.f46175c = this.f46174b;
            this.f46179g = "1";
        } else if (f46172h) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.f46173a + ", fcp=" + this.f46174b + ", fmp=" + this.f46175c + ", ftp=" + this.f46176d + ", fip=" + this.f46177e + ", mMinCache=" + this.f46178f + ", fmpType='" + this.f46179g + "', fmpTypeName='" + a() + "'}";
    }
}
