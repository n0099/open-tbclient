package d.b.i0.r.l;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Integer> f51387a = new HashMap<>();

    public static int a(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (f51387a.containsKey(str)) {
            return f51387a.get(str).intValue();
        }
        f51387a.put(str, 1);
        return 1;
    }

    public static void b(PersonPrivateData personPrivateData) {
        if (personPrivateData == null) {
            return;
        }
        String str = TbadkCoreApplication.getCurrentAccount() + "@2";
        int s = personPrivateData.s();
        if (f51387a.containsKey(str)) {
            return;
        }
        f51387a.put(str, Integer.valueOf(s));
    }

    public static void c(int i, int i2) {
        f51387a.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }
}
