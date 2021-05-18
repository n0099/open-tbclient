package d.a.j0.c1.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes3.dex */
public class c {
    public static void a() {
        d.a.j0.r.d0.b.j().C("key_youngster_verify");
    }

    public static String b(d.a.j0.c1.a.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.c()) || StringUtils.isNull(aVar.b()) || StringUtils.isNull(aVar.a())) {
            return "";
        }
        return aVar.c() + "," + aVar.b() + "," + aVar.a();
    }

    public static d.a.j0.c1.a.a c(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length > 2) {
            return new d.a.j0.c1.a.a(split[0], split[1], split[2]);
        }
        return null;
    }

    public static boolean d() {
        String p = d.a.j0.r.d0.b.j().p("key_youngster_verify", "");
        if (StringUtils.isNull(p)) {
            a();
            return false;
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            a();
            return false;
        }
        d.a.j0.c1.a.a c2 = c(p);
        if (c2 == null || StringUtils.isNull(c2.c()) || !c2.c().equals(currentAccountInfo.getID()) || StringUtils.isNull(c2.b()) || !c2.b().equals(currentAccountInfo.getPortrait())) {
            a();
            return false;
        }
        return true;
    }

    public static boolean e(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String p = d.a.j0.r.d0.b.j().p("key_youngster_verify", "");
        if (StringUtils.isNull(p)) {
            a();
            return false;
        }
        d.a.j0.c1.a.a c2 = c(p);
        if (c2 == null) {
            return false;
        }
        return str.equals(c2.a());
    }

    public static void f(String str) {
        AccountData currentAccountInfo;
        if (StringUtils.isNull(str) || (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) == null) {
            return;
        }
        d.a.j0.r.d0.b.j().x("key_youngster_verify", b(new d.a.j0.c1.a.a(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
    }
}
