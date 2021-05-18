package d.a.q.d.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.a.q.d.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends d.a.q.d.a {

    /* renamed from: g  reason: collision with root package name */
    public d.a.q.d.a f64205g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64206h;

    public a(boolean z) {
        this.f64206h = z;
    }

    @Override // d.a.q.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        this.f64205g.a(str, bundle, cVar);
    }

    @Override // d.a.q.d.a
    public boolean d(String str) {
        return this.f64205g.d(str);
    }

    @Override // d.a.q.d.a
    public void e(a.b bVar) {
        d.a.q.d.a bVar2;
        if (this.f64206h ? i() : h()) {
            bVar2 = new d.a.q.d.c.a();
        } else {
            bVar2 = new b(this.f64206h ? ".helios.ipc.default" : ".helios.ipc.isolate");
        }
        this.f64205g = bVar2;
        bVar2.b(this.f64167e);
        this.f64205g.c(bVar);
    }

    @Override // d.a.q.d.a
    public a.d f(String str, Bundle bundle) {
        return this.f64205g.f(str, bundle);
    }

    public final String g() {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(ProcessUtils.CMD_LINE_NAME)));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    d.a.q.g.c.a.c.b(bufferedReader);
                    return readLine;
                }
            } catch (IOException unused) {
            } catch (Throwable th2) {
                th = th2;
                d.a.q.g.c.a.c.b(bufferedReader);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
        d.a.q.g.c.a.c.b(bufferedReader);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f64167e.f64171c.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        return null;
    }

    public final boolean h() {
        String g2 = g();
        return g2 != null && g2.contains(":helios");
    }

    public final boolean i() {
        String g2 = g();
        if (g2 == null) {
            return true;
        }
        Context context = this.f64167e.f64171c;
        String str = context.getApplicationInfo().processName;
        if (TextUtils.isEmpty(str)) {
            str = context.getPackageName();
        }
        if (g2.startsWith(str)) {
            return g2.length() == str.length() || g2.charAt(str.length()) != ':';
        }
        return false;
    }
}
