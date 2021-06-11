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
    public static final String[] f57946c = {"119.75.222.62", "119.75.222.63"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f57947d = {"111.13.100.247", "117.185.16.61"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f57948e = {"111.206.37.190"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f57949f = {"115.239.211.146", "180.97.33.196"};

    /* renamed from: a  reason: collision with root package name */
    public volatile int f57950a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f57951b;

    public String a() {
        b();
        if (j.H()) {
            return f57949f[new Random().nextInt(f57949f.length)];
        }
        if (j.x()) {
            if (this.f57950a == 1) {
                return f57946c[new Random().nextInt(f57946c.length)];
            }
            if (this.f57950a == 2) {
                return f57947d[new Random().nextInt(f57947d.length)];
            }
            if (this.f57950a == 3) {
                return f57948e[new Random().nextInt(f57948e.length)];
            }
        }
        return "119.75.222.62";
    }

    public void b() {
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            try {
                this.f57951b = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.f57950a = 0;
            if (this.f57951b != null) {
                if (!this.f57951b.startsWith("46000") && !this.f57951b.startsWith("46002") && !this.f57951b.startsWith("46007")) {
                    if (!this.f57951b.startsWith("46001") && !this.f57951b.startsWith("46006")) {
                        if (this.f57951b.startsWith("46003") || this.f57951b.startsWith("46005")) {
                            this.f57950a = 3;
                            return;
                        }
                        return;
                    }
                    this.f57950a = 2;
                    return;
                }
                this.f57950a = 1;
            }
        }
    }
}
