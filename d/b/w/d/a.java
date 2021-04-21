package d.b.w.d;

import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static Map<Integer, Integer> f65784b;

    /* renamed from: a  reason: collision with root package name */
    public int f65785a = 4;

    static {
        HashMap hashMap = new HashMap();
        f65784b = hashMap;
        hashMap.put(2, 256);
        f65784b.put(4, 8);
        f65784b.put(8, 286);
        f65784b.put(16, Integer.valueOf((int) QRScanCodeActivity.DIALOG_ALIPAY_JD_WX_COPY));
        f65784b.put(32, 326);
        f65784b.put(64, Integer.valueOf((int) HttpStatus.SC_UNPROCESSABLE_ENTITY));
        f65784b.put(128, 326);
        f65784b.put(256, 20);
    }

    public int a() {
        return this.f65785a;
    }

    public int b(int i) {
        int i2 = this.f65785a;
        if (i2 == i) {
            return 0;
        }
        if (i != (f65784b.get(Integer.valueOf(i2)).intValue() & i)) {
            return -1;
        }
        this.f65785a = i;
        return 1;
    }
}
