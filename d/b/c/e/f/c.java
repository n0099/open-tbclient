package d.b.c.e.f;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static String f42228d = "_crashtime";

    /* renamed from: e  reason: collision with root package name */
    public static String f42229e = "_crashtype";

    /* renamed from: a  reason: collision with root package name */
    public int f42230a;

    /* renamed from: b  reason: collision with root package name */
    public int f42231b;

    /* renamed from: c  reason: collision with root package name */
    public b f42232c;

    public c(b bVar) {
        this.f42230a = 0;
        this.f42231b = 0;
        this.f42232c = null;
        if (bVar != null) {
            this.f42232c = bVar;
            if (bVar.d() > 0 && this.f42232c.c() != null) {
                int f2 = f();
                this.f42230a = f2;
                if (f2 == -1) {
                    h();
                }
            }
            if (!bVar.h()) {
                this.f42231b = g();
            }
            this.f42232c.a(this.f42231b, true);
            return;
        }
        throw new InvalidParameterException("SwitchHolder data is null");
    }

    public boolean a(String str) {
        String[] g2;
        String[] c2;
        if (str != null && this.f42232c.d() > 0) {
            if (this.f42232c.c() != null) {
                for (String str2 : this.f42232c.c()) {
                    if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                        int i = this.f42230a + 1;
                        this.f42230a = i;
                        k(i);
                        if (this.f42230a >= this.f42232c.d()) {
                            l(this.f42232c.f());
                            this.f42231b = this.f42232c.f();
                            b bVar = this.f42232c;
                            bVar.a(bVar.f(), false);
                        }
                        return true;
                    }
                }
            }
            if (this.f42232c.g() != null) {
                for (String str3 : this.f42232c.g()) {
                    if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                        int i2 = this.f42230a + 1;
                        this.f42230a = i2;
                        k(i2);
                        if (this.f42230a >= this.f42232c.d()) {
                            l(this.f42232c.f());
                            this.f42231b = this.f42232c.f();
                            b bVar2 = this.f42232c;
                            bVar2.a(bVar2.f(), false);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public b b() {
        return this.f42232c;
    }

    public int c() {
        return this.f42232c.b();
    }

    public String d() {
        return this.f42232c.e();
    }

    public int e() {
        return this.f42231b;
    }

    public final int f() {
        SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
        return sharedPreferences.getInt(this.f42232c.e() + f42228d, -1);
    }

    public final int g() {
        SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
        return sharedPreferences.getInt(this.f42232c.e() + f42229e, this.f42232c.b());
    }

    public void h() {
        this.f42230a = 0;
    }

    public void i(int i) {
        this.f42230a = i;
    }

    public boolean j(int i) {
        if (this.f42232c.d() >= 0 && this.f42230a >= this.f42232c.d() + 2) {
            i = this.f42232c.f();
        }
        if (i == this.f42231b) {
            return false;
        }
        this.f42231b = i;
        this.f42232c.a(i, false);
        l(i);
        return true;
    }

    public final void k(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.f42232c.e() + f42228d, i);
        edit.commit();
    }

    public final void l(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.f42232c.e() + f42229e, i);
        edit.commit();
    }
}
