package d.a.v;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static String f64796c = d.a.j0.r.d0.b.n("advert_hide_list");

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f64797a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f64798b;

    /* renamed from: d.a.v.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1811b {

        /* renamed from: a  reason: collision with root package name */
        public static b f64799a = new b();
    }

    public static b b() {
        return C1811b.f64799a;
    }

    public boolean a(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.f64798b == null) {
            this.f64798b = this.f64797a.getStringSet(f64796c, null);
        }
        Set<String> set = this.f64798b;
        if (set == null) {
            return false;
        }
        return set.contains(str);
    }

    public void c(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        Set<String> stringSet = this.f64797a.getStringSet(f64796c, null);
        this.f64798b = stringSet;
        if (stringSet == null) {
            this.f64798b = new HashSet();
        }
        this.f64798b.add(str);
        this.f64797a.edit().putStringSet(f64796c, this.f64798b).commit();
    }

    public b() {
        this.f64797a = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }
}
