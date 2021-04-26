package d.a.j0.q1.p;

import android.os.Environment;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public static g f59032c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f59033a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f59034b;

    /* loaded from: classes3.dex */
    public class a implements CyberPlayerManager.InstallListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CyberPlayerManager.InstallListener f59035a;

        public a(CyberPlayerManager.InstallListener installListener) {
            this.f59035a = installListener;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i2, int i3, String str) {
            if (g.this.f59034b >= 3) {
                g.this.f59034b = 0;
                CyberPlayerManager.InstallListener installListener = this.f59035a;
                if (installListener != null) {
                    installListener.onInstallError(i2, i3, str);
                    return;
                }
                return;
            }
            g.c(g.this);
            g.this.g(this.f59035a);
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i2, int i3) {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i2, String str) {
            g.this.f59034b = 0;
            g.this.f59033a = true;
            CyberPlayerManager.InstallListener installListener = this.f59035a;
            if (installListener != null) {
                installListener.onInstallSuccess(i2, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CyberPlayerManager.InstallListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CyberPlayerManager.InstallListener f59037a;

        public b(CyberPlayerManager.InstallListener installListener) {
            this.f59037a = installListener;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i2, int i3, String str) {
            if (g.this.f59034b >= 3) {
                g.this.f59034b = 0;
                CyberPlayerManager.InstallListener installListener = this.f59037a;
                if (installListener != null) {
                    installListener.onInstallError(i2, i3, str);
                    return;
                }
                return;
            }
            g.c(g.this);
            g.this.g(this.f59037a);
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i2, int i3) {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i2, String str) {
            g.this.f59034b = 0;
            g.this.f59033a = true;
            CyberPlayerManager.InstallListener installListener = this.f59037a;
            if (installListener != null) {
                installListener.onInstallSuccess(i2, str);
            }
        }
    }

    public static /* synthetic */ int c(g gVar) {
        int i2 = gVar.f59034b;
        gVar.f59034b = i2 + 1;
        return i2;
    }

    public static g e() {
        if (f59032c == null) {
            i();
        }
        return f59032c;
    }

    public static synchronized void i() {
        synchronized (g.class) {
            if (f59032c == null) {
                f59032c = new g();
            }
        }
    }

    public boolean f() {
        boolean isCoreLoaded = CyberPlayerManager.isCoreLoaded(3);
        if (isCoreLoaded && !this.f59033a) {
            this.f59033a = true;
        }
        return isCoreLoaded;
    }

    public void g(CyberPlayerManager.InstallListener installListener) {
        String absolutePath;
        if (CyberPlayerManager.isCoreLoaded(3)) {
            return;
        }
        this.f59033a = false;
        String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
        File cacheDir = TbadkCoreApplication.getInst().getCacheDir();
        if (cacheDir != null) {
            absolutePath = cacheDir.getAbsolutePath();
        } else {
            absolutePath = Environment.getDownloadCacheDirectory().getAbsolutePath();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cache-path", absolutePath);
        try {
            CyberPlayerManager.install(TbadkCoreApplication.getInst(), cuidGalaxy2, null, 3, null, hashMap, new a(installListener));
        } catch (Exception unused) {
        }
    }

    public void h(CyberPlayerManager.InstallListener installListener, int i2) {
        String absolutePath;
        if (CyberPlayerManager.isCoreLoaded(i2)) {
            return;
        }
        this.f59033a = false;
        String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
        File cacheDir = TbadkCoreApplication.getInst().getCacheDir();
        if (cacheDir != null) {
            absolutePath = cacheDir.getAbsolutePath();
        } else {
            absolutePath = Environment.getDownloadCacheDirectory().getAbsolutePath();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cache-path", absolutePath);
        try {
            CyberPlayerManager.install(TbadkCoreApplication.getInst(), cuidGalaxy2, null, i2, null, hashMap, new b(installListener));
        } catch (Exception unused) {
        }
    }
}
