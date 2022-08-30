package com.kwad.sdk.kwai.kwai;

import android.content.Context;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
/* loaded from: classes7.dex */
public class b {
    public static volatile b Re;
    public Stack<AdTemplate> Rb = new Stack<>();
    public String Rc;
    public File Rd;
    public boolean mHasInit;

    /* loaded from: classes7.dex */
    public interface a {
        void fT();

        void rc();
    }

    public b() {
        qZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Y(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        boolean z = false;
        Iterator<AdTemplate> it = this.Rb.iterator();
        while (it.hasNext()) {
            if (com.kwad.sdk.core.response.a.d.ca(it.next()) == com.kwad.sdk.core.response.a.d.ca(adTemplate)) {
                it.remove();
                z = true;
            }
        }
        if (!z) {
            return;
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.Rd));
            try {
                try {
                    objectOutputStream.writeObject(this.Rb);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    com.kwad.sdk.core.e.b.d("InstallTipsDataManager", " removeApkDownloadedData e" + e);
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
    public synchronized void Z(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        this.Rb.add(adTemplate);
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                if (!this.Rd.exists()) {
                    com.kwad.sdk.core.e.b.d("InstallTipsDataManager", "getCanShowDownloadData mDownloadFile is not exists");
                }
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.Rd));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            objectOutputStream.writeObject(this.Rb);
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
        } catch (Exception e2) {
            e = e2;
            objectOutputStream2 = objectOutputStream;
            com.kwad.sdk.core.e.b.printStackTrace(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
            throw th;
        }
    }

    public static File ac(AdTemplate adTemplate) {
        File file = new File(com.kwad.sdk.core.download.a.w(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
        if (o.I(file)) {
            return file;
        }
        return null;
    }

    private synchronized void qZ() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            this.Rc = as.db(context);
            File file = new File(this.Rc);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(this.Rc + File.separator + "uninstall_ad");
            this.Rd = file2;
            if (!file2.exists()) {
                try {
                    this.Rd.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static b ra() {
        if (Re == null) {
            synchronized (b.class) {
                if (Re == null) {
                    Re = new b();
                }
            }
        }
        return Re;
    }

    public final synchronized void a(final a aVar) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.b.1
            /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: java.io.ObjectOutputStream */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:60:0x0118 A[Catch: all -> 0x0128, TryCatch #6 {all -> 0x0128, blocks: (B:3:0x0002, B:28:0x00ac, B:43:0x00f1, B:58:0x0114, B:60:0x0118, B:62:0x011e, B:63:0x0121, B:55:0x010d, B:57:0x0111, B:39:0x00d4, B:66:0x0124, B:67:0x0127), top: B:76:0x0002 }] */
            /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                ObjectInputStream objectInputStream;
                ObjectOutputStream objectOutputStream;
                try {
                    HashMap hashMap = new HashMap();
                    ObjectInputStream objectInputStream2 = null;
                    try {
                        if (!b.this.Rd.exists()) {
                            com.kwad.sdk.core.e.b.d("InstallTipsDataManager", "getCanShowDownloadData mDownloadFile is not exists");
                        }
                        b.this.Rb.clear();
                        objectInputStream = new ObjectInputStream(new FileInputStream(b.this.Rd));
                        try {
                            try {
                                b.this.Rb = (Stack) objectInputStream.readObject();
                                if (!b.this.Rb.isEmpty()) {
                                    Stack stack = new Stack();
                                    while (!b.this.Rb.isEmpty()) {
                                        AdTemplate adTemplate = (AdTemplate) b.this.Rb.pop();
                                        if (adTemplate != null) {
                                            String valueOf = String.valueOf(com.kwad.sdk.core.response.a.d.ca(adTemplate));
                                            File ac = b.ac(adTemplate);
                                            if (ac == null || !ac.exists() || ac.lastModified() + 604800000 <= System.currentTimeMillis()) {
                                                hashMap.put(valueOf, Boolean.TRUE);
                                            } else {
                                                stack.push(adTemplate);
                                            }
                                        }
                                    }
                                    while (!stack.isEmpty()) {
                                        b.this.Rb.push((AdTemplate) stack.pop());
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                com.kwad.sdk.core.e.b.d("InstallTipsDataManager", " getCanShowDownloadBannerData e" + e);
                                if (aVar != null) {
                                    aVar.rc();
                                    com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                    return;
                                }
                                com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                try {
                                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(b.this.Rd));
                                    objectOutputStream.writeObject(b.this.Rb);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                                } catch (Exception e2) {
                                    e = e2;
                                }
                                if (aVar != null) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            objectInputStream2 = objectInputStream;
                            com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream2);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        objectInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream2);
                        throw th;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                    try {
                        objectOutputStream = new ObjectOutputStream(new FileOutputStream(b.this.Rd));
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    try {
                        objectOutputStream.writeObject(b.this.Rb);
                        com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                    } catch (Exception e4) {
                        e = e4;
                        objectInputStream2 = objectOutputStream;
                        com.kwad.sdk.core.e.b.printStackTrace(e);
                        if (aVar != null) {
                            aVar.rc();
                            com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream2);
                            return;
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream2);
                        if (aVar != null) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        objectInputStream2 = objectOutputStream;
                        com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream2);
                        throw th;
                    }
                    if (aVar != null) {
                        aVar.fT();
                    }
                } catch (Throwable th5) {
                    com.kwad.components.core.b.a.b(th5);
                }
            }
        });
    }

    public final void aa(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.b.2
            @Override // java.lang.Runnable
            public final void run() {
                b.this.Z(adTemplate);
            }
        });
    }

    public final void ab(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.b.3
            @Override // java.lang.Runnable
            public final void run() {
                b.this.Y(adTemplate);
            }
        });
    }

    public final synchronized AdTemplate rb() {
        AdTemplate adTemplate;
        adTemplate = null;
        Stack stack = (Stack) this.Rb.clone();
        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            AdTemplate adTemplate2 = (AdTemplate) stack.pop();
            if (adTemplate2 != null) {
                String str = com.kwad.sdk.core.response.a.d.bQ(adTemplate2).adBaseInfo.appPackageName;
                Context context = KsAdSDKImpl.get().getContext();
                File ac = ac(adTemplate2);
                if (ac != null && ac.exists() && ac.lastModified() + 604800000 > System.currentTimeMillis() && !ai.U(context, str)) {
                    adTemplate = adTemplate2;
                    break;
                }
            }
        }
        return adTemplate;
    }
}
