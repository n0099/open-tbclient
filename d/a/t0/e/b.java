package d.a.t0.e;

import android.text.TextUtils;
import com.baidu.sapi2.share.ShareCallPacking;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Integer> f64659a;

    /* renamed from: b  reason: collision with root package name */
    public static String f64660b;

    static {
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        f64659a = arrayList;
        arrayList.add(10000);
        f64659a.add(10001);
        f64659a.add(10002);
        f64659a.add(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT));
        f64659a.add(-1);
    }

    public static int a() {
        if (TextUtils.isEmpty(f64660b)) {
            f64660b = d.a.t0.e.h.d.a();
        }
        if (TextUtils.isEmpty(f64660b)) {
            return ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT;
        }
        if (f64660b.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        if (f64660b.toUpperCase().contains("XIAOMI")) {
            return 10002;
        }
        return ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT;
    }
}
