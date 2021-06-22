package d.a.m0.g.c.h;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.gamecenter.appmanager.notification.InstallNotifyReceiver;
import d.a.m0.a.v2.k;
import d.a.m0.g.c.d.c;
import java.io.File;
import java.util.Calendar;
import java.util.Collection;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f50840c;

    /* renamed from: b  reason: collision with root package name */
    public String f50842b = "com.baidu.gamenow";

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f50841a = KVStorageFactory.getSharedPreferences("gamecenter_install_notification", 0);

    public static a f() {
        if (f50840c == null) {
            synchronized (a.class) {
                if (f50840c == null) {
                    f50840c = new a();
                }
            }
        }
        return f50840c;
    }

    public void a(Download download) {
        b.a(AppRuntime.getAppContext(), Long.valueOf(download.getId().longValue()).intValue());
    }

    public final boolean b() {
        return k.f(Long.valueOf(g()), Long.valueOf(System.currentTimeMillis()));
    }

    public final String c() {
        if (b()) {
            return null;
        }
        if (d()) {
            return "todayfirst";
        }
        if (e()) {
            return "pushregularly";
        }
        return null;
    }

    public final boolean d() {
        return (System.currentTimeMillis() / 86400000) - (g() / 86400000) > 1;
    }

    public final boolean e() {
        return i() <= System.currentTimeMillis();
    }

    public final long g() {
        return this.f50841a.getLong("key_notification_time", 0L);
    }

    public final long h() {
        long i2 = i();
        return i2 >= System.currentTimeMillis() ? i2 : i2 + 86400000;
    }

    public final long i() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 19);
        calendar.set(12, 30);
        return calendar.getTimeInMillis();
    }

    public void j() {
        if (TextUtils.isEmpty(c())) {
            return;
        }
        n(c());
    }

    public final void k() {
        SharedPreferences.Editor edit = this.f50841a.edit();
        edit.putLong("key_notification_time", System.currentTimeMillis());
        edit.apply();
    }

    public void l() {
        ((AlarmManager) AppRuntime.getAppContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, h(), PendingIntent.getBroadcast(AppRuntime.getAppContext(), 2147483646, InstallNotifyReceiver.createIntent(InstallNotifyReceiver.NOTIFICATION_INSTALL_ACTION_ALARM), 0));
    }

    public void m(Download download, boolean z, String str) {
        String format;
        String string;
        try {
            String str2 = download.getRealDownloadDir() + File.separator + download.getFileName();
            PackageManager packageManager = AppRuntime.getAppContext().getPackageManager();
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str2, 1);
            if (packageArchiveInfo == null) {
                return;
            }
            Context appContext = AppRuntime.getAppContext();
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str2;
            applicationInfo.publicSourceDir = str2;
            Drawable applicationIcon = packageManager.getApplicationIcon(applicationInfo);
            String charSequence = packageManager.getApplicationLabel(applicationInfo).toString();
            PendingIntent broadcast = PendingIntent.getBroadcast(appContext, Long.valueOf(download.getId().longValue()).intValue(), InstallNotifyReceiver.createIntent(InstallNotifyReceiver.NOTIFICATION_INSTALL_ACTION_ONE, download.getKeyByUser(), str), 134217728);
            if (z) {
                l();
                format = String.format(appContext.getString(d.a.m0.g.b.aiapps_title_notification1), charSequence);
                string = appContext.getString(d.a.m0.g.b.aiapps_content_notification1);
            } else {
                format = String.format(appContext.getString(d.a.m0.g.b.aiapps_title_notification1), charSequence);
                string = appContext.getString(d.a.m0.g.b.aiapps_content_notification1);
            }
            try {
                b.c(appContext, Long.valueOf(download.getId().longValue()).intValue(), format, TextUtils.equals(download.getKeyByUser(), this.f50842b) ? appContext.getString(d.a.m0.g.b.aiapps_gamenow_notification) : string, b.b(applicationIcon), System.currentTimeMillis(), broadcast, str, download.getKeyByUser());
            } catch (Exception e2) {
                e = e2;
                if (d.a.m0.a.k.f46983a) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void n(String str) {
        if (b()) {
            return;
        }
        try {
            Collection<Download> t = new c(DownloadManager.getInstance(AppRuntime.getAppContext())).t();
            if (t != null && t.size() != 0) {
                k();
                Download download = null;
                for (Download download2 : t) {
                    if (download2 != null) {
                        download = download2;
                    }
                }
                if (1 == t.size()) {
                    m(download, false, str);
                    return;
                }
                String str2 = download.getRealDownloadDir() + File.separator + download.getFileName();
                PackageManager packageManager = AppRuntime.getAppContext().getPackageManager();
                PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str2, 1);
                if (packageArchiveInfo == null) {
                    return;
                }
                Context appContext = AppRuntime.getAppContext();
                ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                applicationInfo.sourceDir = str2;
                applicationInfo.publicSourceDir = str2;
                b.c(appContext, 0, String.format(appContext.getString(d.a.m0.g.b.aiapps_title_notification2), Integer.valueOf(t.size())), appContext.getString(d.a.m0.g.b.aiapps_content_notification1), b.b(packageManager.getApplicationIcon(applicationInfo)), System.currentTimeMillis(), PendingIntent.getBroadcast(appContext, Integer.MAX_VALUE, InstallNotifyReceiver.createToDownloadPageIntent(InstallNotifyReceiver.NOTIFICATION_INSTALL_ACTION_MULTIPLE).putExtra(InstallNotifyReceiver.OPPORTUNITY, str), 134217728), str, download.getKeyByUser());
            }
        } catch (Exception e2) {
            if (d.a.m0.a.k.f46983a) {
                e2.printStackTrace();
            }
        }
    }
}
