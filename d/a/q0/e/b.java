package d.a.q0.e;

import android.text.TextUtils;
import com.baidu.sapi2.share.ShareCallPacking;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Integer> f64480a;

    /* renamed from: b  reason: collision with root package name */
    public static String f64481b;

    static {
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        f64480a = arrayList;
        arrayList.add(10000);
        f64480a.add(10001);
        f64480a.add(10002);
        f64480a.add(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT));
        f64480a.add(-1);
    }

    public static int a() {
        if (TextUtils.isEmpty(f64481b)) {
            f64481b = d.a.q0.e.h.d.a();
        }
        if (TextUtils.isEmpty(f64481b)) {
            return ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT;
        }
        if (f64481b.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        if (f64481b.toUpperCase().contains("XIAOMI")) {
            return 10002;
        }
        return ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT;
    }
}
