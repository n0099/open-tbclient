package d.a.c.e.f;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static String f42327d = "_crashtime";

    /* renamed from: e  reason: collision with root package name */
    public static String f42328e = "_crashtype";

    /* renamed from: a  reason: collision with root package name */
    public int f42329a;

    /* renamed from: b  reason: collision with root package name */
    public int f42330b;

    /* renamed from: c  reason: collision with root package name */
    public b f42331c;

    public c(b bVar) {
        this.f42329a = 0;
        this.f42330b = 0;
        this.f42331c = null;
        if (bVar != null) {
            this.f42331c = bVar;
            if (bVar.d() > 0 && this.f42331c.c() != null) {
                int f2 = f();
                this.f42329a = f2;
                if (f2 == -1) {
                    h();
                }
            }
            if (!bVar.h()) {
                this.f42330b = g();
            }
            this.f42331c.a(this.f42330b, true);
            return;
        }
        throw new InvalidParameterException("SwitchHolder data is null");
    }

    public boolean a(String str) {
        String[] g2;
        String[] c2;
        if (str != null && this.f42331c.d() > 0) {
            if (this.f42331c.c() != null) {
                for (String str2 : this.f42331c.c()) {
                    if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                        int i2 = this.f42329a + 1;
                        this.f42329a = i2;
                        k(i2);
                        if (this.f42329a >= this.f42331c.d()) {
                            l(this.f42331c.f());
                            this.f42330b = this.f42331c.f();
                            b bVar = this.f42331c;
                            bVar.a(bVar.f(), false);
                        }
                        return true;
                    }
                }
            }
            if (this.f42331c.g() != null) {
                for (String str3 : this.f42331c.g()) {
                    if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                        int i3 = this.f42329a + 1;
                        this.f42329a = i3;
                        k(i3);
                        if (this.f42329a >= this.f42331c.d()) {
                            l(this.f42331c.f());
                            this.f42330b = this.f42331c.f();
                            b bVar2 = this.f42331c;
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
        return this.f42331c;
    }

    public int c() {
        return this.f42331c.b();
    }

    public String d() {
        return this.f42331c.e();
    }

    public int e() {
        return this.f42330b;
    }

    public final int f() {
        SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
        return sharedPreferences.getInt(this.f42331c.e() + f42327d, -1);
    }

    public final int g() {
        SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
        return sharedPreferences.getInt(this.f42331c.e() + f42328e, this.f42331c.b());
    }

    public void h() {
        this.f42329a = 0;
    }

    public void i(int i2) {
        this.f42329a = i2;
    }

    public boolean j(int i2) {
        if (this.f42331c.d() >= 0 && this.f42329a >= this.f42331c.d() + 2) {
            i2 = this.f42331c.f();
        }
        if (i2 == this.f42330b) {
            return false;
        }
        this.f42330b = i2;
        this.f42331c.a(i2, false);
        l(i2);
        return true;
    }

    public final void k(int i2) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.f42331c.e() + f42327d, i2);
        edit.commit();
    }

    public final void l(int i2) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.f42331c.e() + f42328e, i2);
        edit.commit();
    }
}
