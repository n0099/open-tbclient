package d.a.x;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static String f68671c = d.a.n0.r.d0.b.n("advert_hide_list");

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f68672a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f68673b;

    /* renamed from: d.a.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1879b {

        /* renamed from: a  reason: collision with root package name */
        public static b f68674a = new b();
    }

    public static b b() {
        return C1879b.f68674a;
    }

    public boolean a(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.f68673b == null) {
            this.f68673b = this.f68672a.getStringSet(f68671c, null);
        }
        Set<String> set = this.f68673b;
        if (set == null) {
            return false;
        }
        return set.contains(str);
    }

    public void c(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        Set<String> stringSet = this.f68672a.getStringSet(f68671c, null);
        this.f68673b = stringSet;
        if (stringSet == null) {
            this.f68673b = new HashSet();
        }
        this.f68673b.add(str);
        this.f68672a.edit().putStringSet(f68671c, this.f68673b).commit();
    }

    public b() {
        this.f68672a = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }
}
