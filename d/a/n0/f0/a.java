package d.a.n0.f0;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import d.a.c.e.p.j;
import java.util.Random;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f54257c = {"119.75.222.62", "119.75.222.63"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f54258d = {"111.13.100.247", "117.185.16.61"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f54259e = {"111.206.37.190"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f54260f = {"115.239.211.146", "180.97.33.196"};

    /* renamed from: a  reason: collision with root package name */
    public volatile int f54261a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f54262b;

    public String a() {
        b();
        if (j.H()) {
            return f54260f[new Random().nextInt(f54260f.length)];
        }
        if (j.x()) {
            if (this.f54261a == 1) {
                return f54257c[new Random().nextInt(f54257c.length)];
            }
            if (this.f54261a == 2) {
                return f54258d[new Random().nextInt(f54258d.length)];
            }
            if (this.f54261a == 3) {
                return f54259e[new Random().nextInt(f54259e.length)];
            }
        }
        return "119.75.222.62";
    }

    public void b() {
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            try {
                this.f54262b = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.f54261a = 0;
            if (this.f54262b != null) {
                if (!this.f54262b.startsWith("46000") && !this.f54262b.startsWith("46002") && !this.f54262b.startsWith("46007")) {
                    if (!this.f54262b.startsWith("46001") && !this.f54262b.startsWith("46006")) {
                        if (this.f54262b.startsWith("46003") || this.f54262b.startsWith("46005")) {
                            this.f54261a = 3;
                            return;
                        }
                        return;
                    }
                    this.f54261a = 2;
                    return;
                }
                this.f54261a = 1;
            }
        }
    }
}
