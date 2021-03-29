package d.b.v;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static String f64797c = d.b.h0.r.d0.b.m("advert_hide_list");

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f64798a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f64799b;

    /* renamed from: d.b.v.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1776b {

        /* renamed from: a  reason: collision with root package name */
        public static b f64800a = new b();
    }

    public static b b() {
        return C1776b.f64800a;
    }

    public boolean a(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.f64799b == null) {
            this.f64799b = this.f64798a.getStringSet(f64797c, null);
        }
        Set<String> set = this.f64799b;
        if (set == null) {
            return false;
        }
        return set.contains(str);
    }

    public void c(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        Set<String> stringSet = this.f64798a.getStringSet(f64797c, null);
        this.f64799b = stringSet;
        if (stringSet == null) {
            this.f64799b = new HashSet();
        }
        this.f64799b.add(str);
        this.f64798a.edit().putStringSet(f64797c, this.f64799b).commit();
    }

    public b() {
        this.f64798a = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }
}
