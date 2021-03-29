package d.b.h0.z0;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f51690a;

        /* renamed from: b  reason: collision with root package name */
        public int f51691b;

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
                    aVar.f51690a = split[0];
                } else if (split.length == 2) {
                    aVar.f51690a = split[0];
                    aVar.f51691b = d.b.b.e.m.b.d(split[1], -1);
                }
            } else {
                aVar.f51690a = str;
            }
            return aVar;
        }

        public String toString() {
            if (StringUtils.isNull(this.f51690a)) {
                return null;
            }
            return this.f51690a + "#" + this.f51691b;
        }

        public a(String str, int i) {
            this.f51690a = str;
            this.f51691b = i;
        }
    }

    public static String[] a() {
        String o = d.b.h0.r.d0.b.i().o("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "");
        if (StringUtils.isNull(o)) {
            return new String[0];
        }
        String[] split = o.split("\\^");
        if (split == null || split.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : split) {
            a a2 = a.a(str);
            if (a2 != null && !StringUtils.isNull(a2.f51690a)) {
                arrayList.add(a2.f51690a);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
