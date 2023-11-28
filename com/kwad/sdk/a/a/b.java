package com.kwad.sdk.a.a;

import android.content.Context;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
/* loaded from: classes10.dex */
public class b {
    public static volatile b akP;
    public Stack<AdTemplate> akN = new Stack<>();
    public File akO;
    public boolean mHasInit;

    /* loaded from: classes10.dex */
    public interface a {
        void gm();

        void yS();
    }

    public static b yQ() {
        if (akP == null) {
            synchronized (b.class) {
                if (akP == null) {
                    akP = new b();
                }
            }
        }
        return akP;
    }

    public static File aK(AdTemplate adTemplate) {
        File file = new File(com.kwad.sdk.core.download.a.G(com.kwad.sdk.core.response.b.e.dP(adTemplate)));
        if (q.L(file)) {
            return file;
        }
        return null;
    }

    public final void aI(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        g.execute(new Runnable() { // from class: com.kwad.sdk.a.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                b.this.aH(adTemplate);
            }
        });
    }

    public final void aJ(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        g.execute(new Runnable() { // from class: com.kwad.sdk.a.a.b.3
            @Override // java.lang.Runnable
            public final void run() {
                b.this.aG(adTemplate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aG(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        boolean z = false;
        Iterator<AdTemplate> it = this.akN.iterator();
        while (it.hasNext()) {
            if (com.kwad.sdk.core.response.b.e.dZ(it.next()) == com.kwad.sdk.core.response.b.e.dZ(adTemplate)) {
                it.remove();
                z = true;
            }
        }
        if (!z) {
            return;
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.akO));
            try {
                try {
                    objectOutputStream.writeObject(this.akN);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    com.kwad.sdk.core.e.c.d("InstallTipsDataManager", " removeApkDownloadedData e" + e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                }
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            objectOutputStream = null;
            e = e3;
        } catch (Throwable th3) {
            objectOutputStream = null;
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aH(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        this.akN.add(adTemplate);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(yP()));
            try {
                try {
                    objectOutputStream.writeObject(this.akN);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    com.kwad.sdk.core.e.c.printStackTrace(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                }
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            objectOutputStream = null;
            e = e3;
        } catch (Throwable th3) {
            objectOutputStream = null;
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized File yP() {
        if (this.akO != null) {
            return this.akO;
        }
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        String cO = aw.cO(context);
        File file = new File(cO);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(cO + File.separator + "uninstall_ad");
        this.akO = file2;
        if (!file2.exists()) {
            try {
                this.akO.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.akO;
    }

    public final synchronized AdTemplate yR() {
        AdTemplate adTemplate;
        adTemplate = null;
        Stack stack = (Stack) this.akN.clone();
        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            AdTemplate adTemplate2 = (AdTemplate) stack.pop();
            if (adTemplate2 != null) {
                String str = com.kwad.sdk.core.response.b.e.dP(adTemplate2).adBaseInfo.appPackageName;
                Context context = KsAdSDKImpl.get().getContext();
                File aK = aK(adTemplate2);
                if (aK != null && aK.exists() && aK.lastModified() + 604800000 > System.currentTimeMillis() && !ak.an(context, str)) {
                    adTemplate = adTemplate2;
                    break;
                }
            }
        }
        return adTemplate;
    }

    public final synchronized void a(final a aVar) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        g.execute(new ay() { // from class: com.kwad.sdk.a.a.b.1
            /* JADX WARN: Not initialized variable reg: 4, insn: 0x0124: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:71:0x0124 */
            /* JADX WARN: Removed duplicated region for block: B:66:0x0119 A[Catch: all -> 0x0129, TryCatch #6 {all -> 0x0129, blocks: (B:3:0x0002, B:6:0x0009, B:9:0x0010, B:34:0x00b4, B:49:0x00f2, B:64:0x0115, B:66:0x0119, B:68:0x011f, B:69:0x0122, B:61:0x010e, B:63:0x0112, B:45:0x00db, B:72:0x0125, B:73:0x0128), top: B:82:0x0002 }] */
            /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
            @Override // com.kwad.sdk.utils.ay
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void doTask() {
                ObjectInputStream objectInputStream;
                ObjectOutputStream objectOutputStream;
                ObjectOutputStream objectOutputStream2;
                try {
                    if (com.kwad.sdk.core.config.d.AG() == 0 || com.kwad.sdk.a.a.a.b.cM() > 0) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    File yP = b.this.yP();
                    ObjectOutputStream objectOutputStream3 = null;
                    try {
                        try {
                            if (!yP.exists()) {
                                com.kwad.sdk.core.e.c.d("InstallTipsDataManager", "getCanShowDownloadData mDownloadFile is not exists");
                            }
                            b.this.akN.clear();
                            objectInputStream = new ObjectInputStream(new FileInputStream(yP));
                            try {
                                b.this.akN = (Stack) objectInputStream.readObject();
                                if (!b.this.akN.isEmpty()) {
                                    Stack stack = new Stack();
                                    while (!b.this.akN.isEmpty()) {
                                        AdTemplate adTemplate = (AdTemplate) b.this.akN.pop();
                                        if (adTemplate != null) {
                                            String valueOf = String.valueOf(com.kwad.sdk.core.response.b.e.dZ(adTemplate));
                                            File aK = b.aK(adTemplate);
                                            if (aK != null && aK.exists() && aK.lastModified() + 604800000 > System.currentTimeMillis()) {
                                                stack.push(adTemplate);
                                            } else {
                                                hashMap.put(valueOf, Boolean.TRUE);
                                            }
                                        }
                                    }
                                    while (!stack.isEmpty()) {
                                        b.this.akN.push((AdTemplate) stack.pop());
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                com.kwad.sdk.core.e.c.d("InstallTipsDataManager", " getCanShowDownloadBannerData e" + e);
                                if (aVar != null) {
                                    aVar.yS();
                                    com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                    return;
                                }
                                com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                try {
                                    objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(yP));
                                    objectOutputStream2.writeObject(b.this.akN);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                                } catch (Exception e2) {
                                    e = e2;
                                }
                                if (aVar != null) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            objectOutputStream3 = objectOutputStream;
                            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream3);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        objectInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream3);
                        throw th;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                    try {
                        objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(yP));
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    try {
                        objectOutputStream2.writeObject(b.this.akN);
                        com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                    } catch (Exception e4) {
                        e = e4;
                        objectOutputStream3 = objectOutputStream2;
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                        if (aVar != null) {
                            aVar.yS();
                            com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream3);
                            return;
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream3);
                        if (aVar != null) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        objectOutputStream3 = objectOutputStream2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream3);
                        throw th;
                    }
                    if (aVar != null) {
                        aVar.gm();
                    }
                } catch (Throwable th5) {
                    com.kwad.components.core.d.a.b(th5);
                }
            }
        });
    }
}
