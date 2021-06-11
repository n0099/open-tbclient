package d.a.m0.r.l;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Integer> f53555a = new HashMap<>();

    public static int a(int i2) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i2;
        if (f53555a.containsKey(str)) {
            return f53555a.get(str).intValue();
        }
        f53555a.put(str, 1);
        return 1;
    }

    public static void b(PersonPrivateData personPrivateData) {
        if (personPrivateData == null) {
            return;
        }
        String str = TbadkCoreApplication.getCurrentAccount() + "@2";
        int w = personPrivateData.w();
        if (f53555a.containsKey(str)) {
            return;
        }
        f53555a.put(str, Integer.valueOf(w));
    }

    public static void c(int i2, int i3) {
        f53555a.put(TbadkCoreApplication.getCurrentAccount() + "@" + i2, Integer.valueOf(i3));
    }
}
