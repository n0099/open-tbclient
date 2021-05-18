package d.a.k0.e0;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.e.p.j;
import java.util.Random;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f54067c = {"119.75.222.62", "119.75.222.63"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f54068d = {"111.13.100.247", "117.185.16.61"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f54069e = {"111.206.37.190"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f54070f = {"115.239.211.146", "180.97.33.196"};

    /* renamed from: a  reason: collision with root package name */
    public volatile int f54071a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f54072b;

    public String a() {
        b();
        if (j.H()) {
            return f54070f[new Random().nextInt(f54070f.length)];
        }
        if (j.x()) {
            if (this.f54071a == 1) {
                return f54067c[new Random().nextInt(f54067c.length)];
            }
            if (this.f54071a == 2) {
                return f54068d[new Random().nextInt(f54068d.length)];
            }
            if (this.f54071a == 3) {
                return f54069e[new Random().nextInt(f54069e.length)];
            }
        }
        return "119.75.222.62";
    }

    public void b() {
        try {
            this.f54072b = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f54071a = 0;
        if (this.f54072b != null) {
            if (!this.f54072b.startsWith("46000") && !this.f54072b.startsWith("46002") && !this.f54072b.startsWith("46007")) {
                if (!this.f54072b.startsWith("46001") && !this.f54072b.startsWith("46006")) {
                    if (this.f54072b.startsWith("46003") || this.f54072b.startsWith("46005")) {
                        this.f54071a = 3;
                        return;
                    }
                    return;
                }
                this.f54071a = 2;
                return;
            }
            this.f54071a = 1;
        }
    }
}
