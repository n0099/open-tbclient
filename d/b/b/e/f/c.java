package d.b.b.e.f;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static String f41730d = "_crashtime";

    /* renamed from: e  reason: collision with root package name */
    public static String f41731e = "_crashtype";

    /* renamed from: a  reason: collision with root package name */
    public int f41732a;

    /* renamed from: b  reason: collision with root package name */
    public int f41733b;

    /* renamed from: c  reason: collision with root package name */
    public b f41734c;

    public c(b bVar) {
        this.f41732a = 0;
        this.f41733b = 0;
        this.f41734c = null;
        if (bVar != null) {
            this.f41734c = bVar;
            if (bVar.d() > 0 && this.f41734c.c() != null) {
                int f2 = f();
                this.f41732a = f2;
                if (f2 == -1) {
                    h();
                }
            }
            if (!bVar.h()) {
                this.f41733b = g();
            }
            this.f41734c.a(this.f41733b, true);
            return;
        }
        throw new InvalidParameterException("SwitchHolder data is null");
    }

    public boolean a(String str) {
        String[] g2;
        String[] c2;
        if (str != null && this.f41734c.d() > 0) {
            if (this.f41734c.c() != null) {
                for (String str2 : this.f41734c.c()) {
                    if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                        int i = this.f41732a + 1;
                        this.f41732a = i;
                        k(i);
                        if (this.f41732a >= this.f41734c.d()) {
                            l(this.f41734c.f());
                            this.f41733b = this.f41734c.f();
                            b bVar = this.f41734c;
                            bVar.a(bVar.f(), false);
                        }
                        return true;
                    }
                }
            }
            if (this.f41734c.g() != null) {
                for (String str3 : this.f41734c.g()) {
                    if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                        int i2 = this.f41732a + 1;
                        this.f41732a = i2;
                        k(i2);
                        if (this.f41732a >= this.f41734c.d()) {
                            l(this.f41734c.f());
                            this.f41733b = this.f41734c.f();
                            b bVar2 = this.f41734c;
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
        return this.f41734c;
    }

    public int c() {
        return this.f41734c.b();
    }

    public String d() {
        return this.f41734c.e();
    }

    public int e() {
        return this.f41733b;
    }

    public final int f() {
        SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
        return sharedPreferences.getInt(this.f41734c.e() + f41730d, -1);
    }

    public final int g() {
        SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
        return sharedPreferences.getInt(this.f41734c.e() + f41731e, this.f41734c.b());
    }

    public void h() {
        this.f41732a = 0;
    }

    public void i(int i) {
        this.f41732a = i;
    }

    public boolean j(int i) {
        if (this.f41734c.d() >= 0 && this.f41732a >= this.f41734c.d() + 2) {
            i = this.f41734c.f();
        }
        if (i == this.f41733b) {
            return false;
        }
        this.f41733b = i;
        this.f41734c.a(i, false);
        l(i);
        return true;
    }

    public final void k(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.f41734c.e() + f41730d, i);
        edit.commit();
    }

    public final void l(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.f41734c.e() + f41731e, i);
        edit.commit();
    }
}
