package d.b.j0.e0;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.c.e.p.j;
import java.util.Random;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f55513c = {"119.75.222.62", "119.75.222.63"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f55514d = {"111.13.100.247", "117.185.16.61"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f55515e = {"111.206.37.190"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f55516f = {"115.239.211.146", "180.97.33.196"};

    /* renamed from: a  reason: collision with root package name */
    public volatile int f55517a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f55518b;

    public String a() {
        b();
        if (j.H()) {
            return f55516f[new Random().nextInt(f55516f.length)];
        }
        if (j.x()) {
            if (this.f55517a == 1) {
                return f55513c[new Random().nextInt(f55513c.length)];
            }
            if (this.f55517a == 2) {
                return f55514d[new Random().nextInt(f55514d.length)];
            }
            if (this.f55517a == 3) {
                return f55515e[new Random().nextInt(f55515e.length)];
            }
        }
        return "119.75.222.62";
    }

    public void b() {
        try {
            this.f55518b = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f55517a = 0;
        if (this.f55518b != null) {
            if (!this.f55518b.startsWith("46000") && !this.f55518b.startsWith("46002") && !this.f55518b.startsWith("46007")) {
                if (!this.f55518b.startsWith("46001") && !this.f55518b.startsWith("46006")) {
                    if (this.f55518b.startsWith("46003") || this.f55518b.startsWith("46005")) {
                        this.f55517a = 3;
                        return;
                    }
                    return;
                }
                this.f55517a = 2;
                return;
            }
            this.f55517a = 1;
        }
    }
}
