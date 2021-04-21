package d.b.c.e.f;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static String f42468d = "_crashtime";

    /* renamed from: e  reason: collision with root package name */
    public static String f42469e = "_crashtype";

    /* renamed from: a  reason: collision with root package name */
    public int f42470a;

    /* renamed from: b  reason: collision with root package name */
    public int f42471b;

    /* renamed from: c  reason: collision with root package name */
    public b f42472c;

    public c(b bVar) {
        this.f42470a = 0;
        this.f42471b = 0;
        this.f42472c = null;
        if (bVar != null) {
            this.f42472c = bVar;
            if (bVar.d() > 0 && this.f42472c.c() != null) {
                int f2 = f();
                this.f42470a = f2;
                if (f2 == -1) {
                    h();
                }
            }
            if (!bVar.h()) {
                this.f42471b = g();
            }
            this.f42472c.a(this.f42471b, true);
            return;
        }
        throw new InvalidParameterException("SwitchHolder data is null");
    }

    public boolean a(String str) {
        String[] g2;
        String[] c2;
        if (str != null && this.f42472c.d() > 0) {
            if (this.f42472c.c() != null) {
                for (String str2 : this.f42472c.c()) {
                    if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                        int i = this.f42470a + 1;
                        this.f42470a = i;
                        k(i);
                        if (this.f42470a >= this.f42472c.d()) {
                            l(this.f42472c.f());
                            this.f42471b = this.f42472c.f();
                            b bVar = this.f42472c;
                            bVar.a(bVar.f(), false);
                        }
                        return true;
                    }
                }
            }
            if (this.f42472c.g() != null) {
                for (String str3 : this.f42472c.g()) {
                    if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                        int i2 = this.f42470a + 1;
                        this.f42470a = i2;
                        k(i2);
                        if (this.f42470a >= this.f42472c.d()) {
                            l(this.f42472c.f());
                            this.f42471b = this.f42472c.f();
                            b bVar2 = this.f42472c;
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
        return this.f42472c;
    }

    public int c() {
        return this.f42472c.b();
    }

    public String d() {
        return this.f42472c.e();
    }

    public int e() {
        return this.f42471b;
    }

    public final int f() {
        SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
        return sharedPreferences.getInt(this.f42472c.e() + f42468d, -1);
    }

    public final int g() {
        SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
        return sharedPreferences.getInt(this.f42472c.e() + f42469e, this.f42472c.b());
    }

    public void h() {
        this.f42470a = 0;
    }

    public void i(int i) {
        this.f42470a = i;
    }

    public boolean j(int i) {
        if (this.f42472c.d() >= 0 && this.f42470a >= this.f42472c.d() + 2) {
            i = this.f42472c.f();
        }
        if (i == this.f42471b) {
            return false;
        }
        this.f42471b = i;
        this.f42472c.a(i, false);
        l(i);
        return true;
    }

    public final void k(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.f42472c.e() + f42468d, i);
        edit.commit();
    }

    public final void l(int i) {
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(this.f42472c.e() + f42469e, i);
        edit.commit();
    }
}
