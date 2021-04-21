package d.b.c.e.e;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.webkit.sdk.VideoCloudSetting;
import d.b.c.e.p.j;
import java.net.InetAddress;
import java.net.URL;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f42455d;

    /* renamed from: a  reason: collision with root package name */
    public long f42456a;

    /* renamed from: b  reason: collision with root package name */
    public String f42457b;

    /* renamed from: c  reason: collision with root package name */
    public long f42458c;

    public a() {
        this.f42456a = 0L;
        this.f42457b = null;
        this.f42458c = 0L;
        SharedPreferences a2 = a();
        this.f42456a = a2.getLong(f("c.tieba.baidu.com"), 0L);
        this.f42457b = a2.getString(e("c.tieba.baidu.com"), null);
        this.f42458c = a2.getLong(d("c.tieba.baidu.com"), 0L);
    }

    public static final a c() {
        if (f42455d == null) {
            synchronized (a.class) {
                if (f42455d == null) {
                    f42455d = new a();
                }
            }
        }
        return f42455d;
    }

    public final SharedPreferences a() {
        return BdBaseApplication.getInst().getSharedPreferences("adp", 0);
    }

    /* JADX DEBUG: Throwable added to exception handler: 'UnknownHostException', keep only Throwable */
    public final String b(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String d(String str) {
        return str + "-lastGetIpTime";
    }

    public final String e(String str) {
        return str + "-lastIpAddress";
    }

    public final String f(String str) {
        return str + "-lastLogTime";
    }

    public void g(String str, String str2, boolean z, boolean z2) {
        String str3;
        String host;
        if (!TextUtils.isEmpty(str) && j.z()) {
            try {
                URL url = new URL(str);
                String host2 = url.getHost();
                if ("c.tieba.baidu.com".equals(host2) || TextUtils.isEmpty(str2)) {
                    str3 = null;
                    host = url.getHost();
                } else {
                    str3 = host2;
                    host = str2;
                }
                if ("c.tieba.baidu.com".equals(host)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = this.f42456a;
                    long j2 = this.f42458c;
                    String str4 = this.f42457b;
                    if (currentTimeMillis - j > 43200000) {
                        h(host, str3, z, "12hour", z2);
                        return;
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(currentTimeMillis);
                    int i = calendar.get(6);
                    calendar.setTimeInMillis(j);
                    if (i != calendar.get(6)) {
                        h(host, str3, z, "newday", z2);
                    } else if (System.currentTimeMillis() - j2 > VideoCloudSetting.HOUR_MILLISECOND) {
                        String b2 = TextUtils.isEmpty(str3) ? b(host) : str3;
                        if (TextUtils.equals(b2, str4) && str4 != null) {
                            this.f42458c = System.currentTimeMillis();
                        } else {
                            h(host, b2, z, "ipchange", z2);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void h(String str, String str2, boolean z, String str3, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str2 == null) {
            str2 = b(str);
        }
        if (str2 == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long currentTimeMillis2 = System.currentTimeMillis();
        d.b.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
        statsItem.b("host", str);
        statsItem.b("hostip", str2);
        statsItem.c("issuc", Boolean.valueOf(z));
        statsItem.c("isuseip", Boolean.valueOf(z2));
        BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        SharedPreferences a2 = a();
        EditorHelper.putLong(a2, f(str), currentTimeMillis);
        EditorHelper.putString(a2, e(str), str2);
        EditorHelper.putLong(a2, d(str), currentTimeMillis2);
        this.f42456a = currentTimeMillis;
        this.f42458c = currentTimeMillis2;
        this.f42457b = str2;
    }
}
