package d.a.x;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static String f64849c = d.a.m0.r.d0.b.n("advert_hide_list");

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f64850a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f64851b;

    /* renamed from: d.a.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1818b {

        /* renamed from: a  reason: collision with root package name */
        public static b f64852a = new b();
    }

    public static b b() {
        return C1818b.f64852a;
    }

    public boolean a(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.f64851b == null) {
            this.f64851b = this.f64850a.getStringSet(f64849c, null);
        }
        Set<String> set = this.f64851b;
        if (set == null) {
            return false;
        }
        return set.contains(str);
    }

    public void c(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        Set<String> stringSet = this.f64850a.getStringSet(f64849c, null);
        this.f64851b = stringSet;
        if (stringSet == null) {
            this.f64851b = new HashSet();
        }
        this.f64851b.add(str);
        this.f64850a.edit().putStringSet(f64849c, this.f64851b).commit();
    }

    public b() {
        this.f64850a = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }
}
