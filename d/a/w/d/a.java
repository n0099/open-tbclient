package d.a.w.d;

import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static Map<Integer, Integer> f64138b;

    /* renamed from: a  reason: collision with root package name */
    public int f64139a = 4;

    static {
        HashMap hashMap = new HashMap();
        f64138b = hashMap;
        hashMap.put(2, 256);
        f64138b.put(4, 8);
        f64138b.put(8, 286);
        f64138b.put(16, Integer.valueOf((int) QRScanCodeActivity.DIALOG_ALIPAY_JD_WX_COPY));
        f64138b.put(32, 326);
        f64138b.put(64, Integer.valueOf((int) HttpStatus.SC_UNPROCESSABLE_ENTITY));
        f64138b.put(128, 326);
        f64138b.put(256, 20);
    }

    public int a() {
        return this.f64139a;
    }

    public int b(int i2) {
        int i3 = this.f64139a;
        if (i3 == i2) {
            return 0;
        }
        if (i2 != (f64138b.get(Integer.valueOf(i3)).intValue() & i2)) {
            return -1;
        }
        this.f64139a = i2;
        return 1;
    }
}
