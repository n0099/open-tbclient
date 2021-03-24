package d.b.w.d;

import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static Map<Integer, Integer> f64825b;

    /* renamed from: a  reason: collision with root package name */
    public int f64826a = 4;

    static {
        HashMap hashMap = new HashMap();
        f64825b = hashMap;
        hashMap.put(2, 256);
        f64825b.put(4, 8);
        f64825b.put(8, 286);
        f64825b.put(16, Integer.valueOf((int) QRScanCodeActivity.DIALOG_ALIPAY_JD_WX_COPY));
        f64825b.put(32, 326);
        f64825b.put(64, Integer.valueOf((int) HttpStatus.SC_UNPROCESSABLE_ENTITY));
        f64825b.put(128, 326);
        f64825b.put(256, 20);
    }

    public int a() {
        return this.f64826a;
    }

    public int b(int i) {
        int i2 = this.f64826a;
        if (i2 == i) {
            return 0;
        }
        if (i != (f64825b.get(Integer.valueOf(i2)).intValue() & i)) {
            return -1;
        }
        this.f64826a = i;
        return 1;
    }
}
