package d.a.c.e.f;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static String f39662d = "_crashtime";

    /* renamed from: e  reason: collision with root package name */
    public static String f39663e = "_crashtype";

    /* renamed from: a  reason: collision with root package name */
    public int f39664a;

    /* renamed from: b  reason: collision with root package name */
    public int f39665b;

    /* renamed from: c  reason: collision with root package name */
    public b f39666c;

    public c(b bVar) {
        this.f39664a = 0;
        this.f39665b = 0;
        this.f39666c = null;
        if (bVar != null) {
            this.f39666c = bVar;
            if (bVar.d() > 0 && this.f39666c.c() != null) {
                int f2 = f();
                this.f39664a = f2;
                if (f2 == -1) {
                    h();
                }
            }
            if (!bVar.h()) {
                this.f39665b = g();
            }
            this.f39666c.a(this.f39665b, true);
            return;
        }
        throw new InvalidParameterException("SwitchHolder data is null");
    }

    public boolean a(String str) {
        String[] g2;
        String[] c2;
        if (str != null && this.f39666c.d() > 0) {
            if (this.f39666c.c() != null) {
                for (String str2 : this.f39666c.c()) {
                    if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                        int i2 = this.f39664a + 1;
                        this.f39664a = i2;
                        k(i2);
                        if (this.f39664a >= this.f39666c.d()) {
                            l(this.f39666c.f());
                            this.f39665b = this.f39666c.f();
                            b bVar = this.f39666c;
                            bVar.a(bVar.f(), false);
                        }
                        return true;
                    }
                }
            }
            if (this.f39666c.g() != null) {
                for (String str3 : this.f39666c.g()) {
                    if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                        int i3 = this.f39664a + 1;
                        this.f39664a = i3;
                        k(i3);
                        if (this.f39664a >= this.f39666c.d()) {
                            l(this.f39666c.f());
                            this.f39665b = this.f39666c.f();
                            b bVar2 = this.f39666c;
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
        return this.f39666c;
    }

    public int c() {
        return this.f39666c.b();
    }

    public String d() {
        return this.f39666c.e();
    }

    public int e() {
        return this.f39665b;
    }

    public final int f() {
        SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
        return sharedPreferences.getInt(this.f39666c.e() + f39662d, -1);
    }

    public final int g() {
        SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
        return sharedPreferences.getInt(this.f39666c.e() + f39663e, this.f39666c.b());
    }

    public void h() {
        this.f39664a = 0;
    }

    public void i(int i2) {
        this.f39664a = i2;
    }

    public boolean j(int i2) {
        if (this.f39666c.d() >= 0 && this.f39664a >= this.f39666c.d() + 2) {
            i2 = this.f39666c.f();
        }
        if (i2 == this.f39665b) {
            return false;
        }
        this.f39665b = i2;
        this.f39666c.a(i2, false);
        l(i2);
        return true;
    }

    public final void k(int i2) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.f39666c.e() + f39662d, i2);
        edit.commit();
    }

    public final void l(int i2) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.f39666c.e() + f39663e, i2);
        edit.commit();
    }
}
