package d.b.i0.e0;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.c.e.p.j;
import java.util.Random;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f55092c = {"119.75.222.62", "119.75.222.63"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f55093d = {"111.13.100.247", "117.185.16.61"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f55094e = {"111.206.37.190"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f55095f = {"115.239.211.146", "180.97.33.196"};

    /* renamed from: a  reason: collision with root package name */
    public volatile int f55096a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f55097b;

    public String a() {
        b();
        if (j.H()) {
            return f55095f[new Random().nextInt(f55095f.length)];
        }
        if (j.x()) {
            if (this.f55096a == 1) {
                return f55092c[new Random().nextInt(f55092c.length)];
            }
            if (this.f55096a == 2) {
                return f55093d[new Random().nextInt(f55093d.length)];
            }
            if (this.f55096a == 3) {
                return f55094e[new Random().nextInt(f55094e.length)];
            }
        }
        return "119.75.222.62";
    }

    public void b() {
        try {
            this.f55097b = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f55096a = 0;
        if (this.f55097b != null) {
            if (!this.f55097b.startsWith("46000") && !this.f55097b.startsWith("46002") && !this.f55097b.startsWith("46007")) {
                if (!this.f55097b.startsWith("46001") && !this.f55097b.startsWith("46006")) {
                    if (this.f55097b.startsWith("46003") || this.f55097b.startsWith("46005")) {
                        this.f55096a = 3;
                        return;
                    }
                    return;
                }
                this.f55096a = 2;
                return;
            }
            this.f55096a = 1;
        }
    }
}
