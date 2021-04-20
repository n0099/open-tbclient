package d.b.i0.q1.n;

import android.os.Environment;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public static g f60486c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f60487a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f60488b;

    /* loaded from: classes3.dex */
    public class a implements CyberPlayerManager.InstallListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CyberPlayerManager.InstallListener f60489a;

        public a(CyberPlayerManager.InstallListener installListener) {
            this.f60489a = installListener;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i, int i2, String str) {
            if (g.this.f60488b >= 3) {
                g.this.f60488b = 0;
                CyberPlayerManager.InstallListener installListener = this.f60489a;
                if (installListener != null) {
                    installListener.onInstallError(i, i2, str);
                    return;
                }
                return;
            }
            g.c(g.this);
            g.this.g(this.f60489a);
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i, int i2) {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i, String str) {
            g.this.f60488b = 0;
            g.this.f60487a = true;
            CyberPlayerManager.InstallListener installListener = this.f60489a;
            if (installListener != null) {
                installListener.onInstallSuccess(i, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CyberPlayerManager.InstallListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CyberPlayerManager.InstallListener f60491a;

        public b(CyberPlayerManager.InstallListener installListener) {
            this.f60491a = installListener;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i, int i2, String str) {
            if (g.this.f60488b >= 3) {
                g.this.f60488b = 0;
                CyberPlayerManager.InstallListener installListener = this.f60491a;
                if (installListener != null) {
                    installListener.onInstallError(i, i2, str);
                    return;
                }
                return;
            }
            g.c(g.this);
            g.this.g(this.f60491a);
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i, int i2) {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i, String str) {
            g.this.f60488b = 0;
            g.this.f60487a = true;
            CyberPlayerManager.InstallListener installListener = this.f60491a;
            if (installListener != null) {
                installListener.onInstallSuccess(i, str);
            }
        }
    }

    public static /* synthetic */ int c(g gVar) {
        int i = gVar.f60488b;
        gVar.f60488b = i + 1;
        return i;
    }

    public static g e() {
        if (f60486c == null) {
            i();
        }
        return f60486c;
    }

    public static synchronized void i() {
        synchronized (g.class) {
            if (f60486c == null) {
                f60486c = new g();
            }
        }
    }

    public boolean f() {
        boolean isCoreLoaded = CyberPlayerManager.isCoreLoaded(3);
        if (isCoreLoaded && !this.f60487a) {
            this.f60487a = true;
        }
        return isCoreLoaded;
    }

    public void g(CyberPlayerManager.InstallListener installListener) {
        String absolutePath;
        if (CyberPlayerManager.isCoreLoaded(3)) {
            return;
        }
        this.f60487a = false;
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

    public void h(CyberPlayerManager.InstallListener installListener, int i) {
        String absolutePath;
        if (CyberPlayerManager.isCoreLoaded(i)) {
            return;
        }
        this.f60487a = false;
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
            CyberPlayerManager.install(TbadkCoreApplication.getInst(), cuidGalaxy2, null, i, null, hashMap, new b(installListener));
        } catch (Exception unused) {
        }
    }
}
