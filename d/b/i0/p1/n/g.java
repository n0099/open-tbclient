package d.b.i0.p1.n;

import android.os.Environment;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public static g f58818c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f58819a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f58820b;

    /* loaded from: classes3.dex */
    public class a implements CyberPlayerManager.InstallListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CyberPlayerManager.InstallListener f58821a;

        public a(CyberPlayerManager.InstallListener installListener) {
            this.f58821a = installListener;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i, int i2, String str) {
            if (g.this.f58820b >= 3) {
                g.this.f58820b = 0;
                CyberPlayerManager.InstallListener installListener = this.f58821a;
                if (installListener != null) {
                    installListener.onInstallError(i, i2, str);
                    return;
                }
                return;
            }
            g.c(g.this);
            g.this.g(this.f58821a);
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i, int i2) {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i, String str) {
            g.this.f58820b = 0;
            g.this.f58819a = true;
            CyberPlayerManager.InstallListener installListener = this.f58821a;
            if (installListener != null) {
                installListener.onInstallSuccess(i, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CyberPlayerManager.InstallListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CyberPlayerManager.InstallListener f58823a;

        public b(CyberPlayerManager.InstallListener installListener) {
            this.f58823a = installListener;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i, int i2, String str) {
            if (g.this.f58820b >= 3) {
                g.this.f58820b = 0;
                CyberPlayerManager.InstallListener installListener = this.f58823a;
                if (installListener != null) {
                    installListener.onInstallError(i, i2, str);
                    return;
                }
                return;
            }
            g.c(g.this);
            g.this.g(this.f58823a);
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i, int i2) {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i, String str) {
            g.this.f58820b = 0;
            g.this.f58819a = true;
            CyberPlayerManager.InstallListener installListener = this.f58823a;
            if (installListener != null) {
                installListener.onInstallSuccess(i, str);
            }
        }
    }

    public static /* synthetic */ int c(g gVar) {
        int i = gVar.f58820b;
        gVar.f58820b = i + 1;
        return i;
    }

    public static g e() {
        if (f58818c == null) {
            i();
        }
        return f58818c;
    }

    public static synchronized void i() {
        synchronized (g.class) {
            if (f58818c == null) {
                f58818c = new g();
            }
        }
    }

    public boolean f() {
        boolean isCoreLoaded = CyberPlayerManager.isCoreLoaded(3);
        if (isCoreLoaded && !this.f58819a) {
            this.f58819a = true;
        }
        return isCoreLoaded;
    }

    public void g(CyberPlayerManager.InstallListener installListener) {
        String absolutePath;
        if (CyberPlayerManager.isCoreLoaded(3)) {
            return;
        }
        this.f58819a = false;
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
        this.f58819a = false;
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
