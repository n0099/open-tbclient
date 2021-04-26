package d.a.p0.e;

import android.text.TextUtils;
import com.baidu.sapi2.share.ShareCallPacking;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Integer> f63483a;

    /* renamed from: b  reason: collision with root package name */
    public static String f63484b;

    static {
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        f63483a = arrayList;
        arrayList.add(10000);
        f63483a.add(10001);
        f63483a.add(10002);
        f63483a.add(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT));
        f63483a.add(-1);
    }

    public static int a() {
        if (TextUtils.isEmpty(f63484b)) {
            f63484b = d.a.p0.e.h.d.a();
        }
        if (TextUtils.isEmpty(f63484b)) {
            return ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT;
        }
        if (f63484b.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        if (f63484b.toUpperCase().contains("XIAOMI")) {
            return 10002;
        }
        return ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT;
    }
}
