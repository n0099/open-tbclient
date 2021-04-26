package d.a.j0.e0;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.e.p.j;
import java.util.Random;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f53360c = {"119.75.222.62", "119.75.222.63"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f53361d = {"111.13.100.247", "117.185.16.61"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f53362e = {"111.206.37.190"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f53363f = {"115.239.211.146", "180.97.33.196"};

    /* renamed from: a  reason: collision with root package name */
    public volatile int f53364a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f53365b;

    public String a() {
        b();
        if (j.H()) {
            return f53363f[new Random().nextInt(f53363f.length)];
        }
        if (j.x()) {
            if (this.f53364a == 1) {
                return f53360c[new Random().nextInt(f53360c.length)];
            }
            if (this.f53364a == 2) {
                return f53361d[new Random().nextInt(f53361d.length)];
            }
            if (this.f53364a == 3) {
                return f53362e[new Random().nextInt(f53362e.length)];
            }
        }
        return "119.75.222.62";
    }

    public void b() {
        try {
            this.f53365b = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f53364a = 0;
        if (this.f53365b != null) {
            if (!this.f53365b.startsWith("46000") && !this.f53365b.startsWith("46002") && !this.f53365b.startsWith("46007")) {
                if (!this.f53365b.startsWith("46001") && !this.f53365b.startsWith("46006")) {
                    if (this.f53365b.startsWith("46003") || this.f53365b.startsWith("46005")) {
                        this.f53364a = 3;
                        return;
                    }
                    return;
                }
                this.f53364a = 2;
                return;
            }
            this.f53364a = 1;
        }
    }
}
