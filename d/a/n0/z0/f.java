package d.a.n0.z0;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f54805a;

        /* renamed from: b  reason: collision with root package name */
        public int f54806b;

        public a() {
        }

        public static a a(String str) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            a aVar = new a();
            if (str.contains("#")) {
                String[] split = str.split("#");
                if (split.length == 1) {
                    aVar.f54805a = split[0];
                } else if (split.length == 2) {
                    aVar.f54805a = split[0];
                    aVar.f54806b = d.a.c.e.m.b.d(split[1], -1);
                }
            } else {
                aVar.f54805a = str;
            }
            return aVar;
        }

        public String toString() {
            if (StringUtils.isNull(this.f54805a)) {
                return null;
            }
            return this.f54805a + "#" + this.f54806b;
        }

        public a(String str, int i2) {
            this.f54805a = str;
            this.f54806b = i2;
        }
    }

    public static String[] a() {
        String p = d.a.n0.r.d0.b.j().p("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "");
        if (StringUtils.isNull(p)) {
            return new String[0];
        }
        String[] split = p.split("\\^");
        if (split == null || split.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : split) {
            a a2 = a.a(str);
            if (a2 != null && !StringUtils.isNull(a2.f54805a)) {
                arrayList.add(a2.f54805a);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
