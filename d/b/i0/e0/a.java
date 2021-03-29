package d.b.i0.e0;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.b.e.p.j;
import java.util.Random;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f54209c = {"119.75.222.62", "119.75.222.63"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f54210d = {"111.13.100.247", "117.185.16.61"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f54211e = {"111.206.37.190"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f54212f = {"115.239.211.146", "180.97.33.196"};

    /* renamed from: a  reason: collision with root package name */
    public volatile int f54213a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f54214b;

    public String a() {
        b();
        if (j.H()) {
            return f54212f[new Random().nextInt(f54212f.length)];
        }
        if (j.x()) {
            if (this.f54213a == 1) {
                return f54209c[new Random().nextInt(f54209c.length)];
            }
            if (this.f54213a == 2) {
                return f54210d[new Random().nextInt(f54210d.length)];
            }
            if (this.f54213a == 3) {
                return f54211e[new Random().nextInt(f54211e.length)];
            }
        }
        return "119.75.222.62";
    }

    public void b() {
        try {
            this.f54214b = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f54213a = 0;
        if (this.f54214b != null) {
            if (!this.f54214b.startsWith("46000") && !this.f54214b.startsWith("46002") && !this.f54214b.startsWith("46007")) {
                if (!this.f54214b.startsWith("46001") && !this.f54214b.startsWith("46006")) {
                    if (this.f54214b.startsWith("46003") || this.f54214b.startsWith("46005")) {
                        this.f54213a = 3;
                        return;
                    }
                    return;
                }
                this.f54213a = 2;
                return;
            }
            this.f54213a = 1;
        }
    }
}
