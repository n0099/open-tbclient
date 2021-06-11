package d.a.y.e;

import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static Map<Integer, Integer> f68609b;

    /* renamed from: a  reason: collision with root package name */
    public int f68610a = 4;

    static {
        HashMap hashMap = new HashMap();
        f68609b = hashMap;
        hashMap.put(2, 256);
        f68609b.put(4, 8);
        f68609b.put(8, 286);
        f68609b.put(16, Integer.valueOf((int) QRScanCodeActivity.DIALOG_ALIPAY_JD_WX_COPY));
        f68609b.put(32, 326);
        f68609b.put(64, Integer.valueOf((int) HttpStatus.SC_UNPROCESSABLE_ENTITY));
        f68609b.put(128, 326);
        f68609b.put(256, 20);
    }

    public int a() {
        return this.f68610a;
    }

    public int b(int i2) {
        int i3 = this.f68610a;
        if (i3 == i2) {
            return 0;
        }
        if (i2 != (f68609b.get(Integer.valueOf(i3)).intValue() & i2)) {
            return -1;
        }
        this.f68610a = i2;
        return 1;
    }
}
