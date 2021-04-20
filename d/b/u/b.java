package d.b.u;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static String f65491c = d.b.h0.r.d0.b.n("advert_hide_list");

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f65492a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f65493b;

    /* renamed from: d.b.u.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1788b {

        /* renamed from: a  reason: collision with root package name */
        public static b f65494a = new b();
    }

    public static b b() {
        return C1788b.f65494a;
    }

    public boolean a(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.f65493b == null) {
            this.f65493b = this.f65492a.getStringSet(f65491c, null);
        }
        Set<String> set = this.f65493b;
        if (set == null) {
            return false;
        }
        return set.contains(str);
    }

    public void c(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        Set<String> stringSet = this.f65492a.getStringSet(f65491c, null);
        this.f65493b = stringSet;
        if (stringSet == null) {
            this.f65493b = new HashSet();
        }
        this.f65493b.add(str);
        this.f65492a.edit().putStringSet(f65491c, this.f65493b).commit();
    }

    public b() {
        this.f65492a = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }
}
