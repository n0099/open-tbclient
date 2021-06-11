package d.a.x;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static String f68567c = d.a.m0.r.d0.b.n("advert_hide_list");

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f68568a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f68569b;

    /* renamed from: d.a.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1876b {

        /* renamed from: a  reason: collision with root package name */
        public static b f68570a = new b();
    }

    public static b b() {
        return C1876b.f68570a;
    }

    public boolean a(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.f68569b == null) {
            this.f68569b = this.f68568a.getStringSet(f68567c, null);
        }
        Set<String> set = this.f68569b;
        if (set == null) {
            return false;
        }
        return set.contains(str);
    }

    public void c(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        Set<String> stringSet = this.f68568a.getStringSet(f68567c, null);
        this.f68569b = stringSet;
        if (stringSet == null) {
            this.f68569b = new HashSet();
        }
        this.f68569b.add(str);
        this.f68568a.edit().putStringSet(f68567c, this.f68569b).commit();
    }

    public b() {
        this.f68568a = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }
}
