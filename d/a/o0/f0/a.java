package d.a.o0.f0;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import d.a.c.e.p.j;
import java.util.Random;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f58071c = {"119.75.222.62", "119.75.222.63"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f58072d = {"111.13.100.247", "117.185.16.61"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f58073e = {"111.206.37.190"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f58074f = {"115.239.211.146", "180.97.33.196"};

    /* renamed from: a  reason: collision with root package name */
    public volatile int f58075a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f58076b;

    public String a() {
        b();
        if (j.H()) {
            return f58074f[new Random().nextInt(f58074f.length)];
        }
        if (j.x()) {
            if (this.f58075a == 1) {
                return f58071c[new Random().nextInt(f58071c.length)];
            }
            if (this.f58075a == 2) {
                return f58072d[new Random().nextInt(f58072d.length)];
            }
            if (this.f58075a == 3) {
                return f58073e[new Random().nextInt(f58073e.length)];
            }
        }
        return "119.75.222.62";
    }

    public void b() {
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            try {
                this.f58076b = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.f58075a = 0;
            if (this.f58076b != null) {
                if (!this.f58076b.startsWith("46000") && !this.f58076b.startsWith("46002") && !this.f58076b.startsWith("46007")) {
                    if (!this.f58076b.startsWith("46001") && !this.f58076b.startsWith("46006")) {
                        if (this.f58076b.startsWith("46003") || this.f58076b.startsWith("46005")) {
                            this.f58075a = 3;
                            return;
                        }
                        return;
                    }
                    this.f58075a = 2;
                    return;
                }
                this.f58075a = 1;
            }
        }
    }
}
