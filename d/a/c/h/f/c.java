package d.a.c.h.f;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes7.dex */
public interface c {
    Service getService();

    boolean proxyBindService(Intent intent, ServiceConnection serviceConnection, int i2);

    void proxyDump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    void proxyFinalize() throws Throwable;

    PackageManager proxyGetPackageManager();

    SharedPreferences proxyGetSharedPreferences(String str, int i2);

    void proxyOnConfigurationChanged(Configuration configuration);

    void proxyOnDestroy();

    void proxyOnLowMemory();

    void proxyOnRebind(Intent intent);

    void proxyOnStart(Intent intent, int i2);

    int proxyOnStartCommand(Intent intent, int i2, int i3);

    boolean proxyOnUnbind(Intent intent);

    void proxyStartActivity(Intent intent);

    ComponentName proxyStartService(Intent intent);

    boolean proxyStopService(Intent intent);
}
