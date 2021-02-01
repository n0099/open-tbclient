package com.kwad.sdk.home.download;

import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes3.dex */
public class a {
    private static volatile a l;
    private File e;
    private File f;
    private File g;
    private File h;
    private File i;

    /* renamed from: a  reason: collision with root package name */
    private Stack<HomeApkBannerData> f10400a = new Stack<>();

    /* renamed from: b  reason: collision with root package name */
    private Stack<HomeApkBannerData> f10401b = new Stack<>();
    private Map<String, Integer> c = new HashMap();
    private int j = 0;
    private boolean k = false;
    private String d = ad.d(KsAdSDKImpl.get().getContext());

    public a() {
        File file = new File(this.d);
        if (!file.exists()) {
            file.mkdir();
        }
        this.e = new File(this.d + File.separator + "download_uninstall");
        this.g = new File(this.d + File.separator + "download_uninstall_apk_data");
        if (!this.g.exists()) {
            this.g.mkdir();
        }
        this.h = new File(this.d + File.separator + "install_unopen_apk_data");
        if (!this.h.exists()) {
            this.h.mkdir();
        }
        this.f = new File(this.d + File.separator + "install_unopen");
        this.i = new File(this.d + File.separator + "app_has_show_banner_counts");
    }

    public static a a() {
        if (l == null) {
            synchronized (a.class) {
                if (l == null) {
                    l = new a();
                }
            }
        }
        return l;
    }

    private File b(HomeApkBannerData homeApkBannerData, boolean z) {
        return new File((z ? this.g.getPath() : this.h.getPath()) + File.separator + homeApkBannerData.mAdTemplateUniqueId);
    }

    private boolean b(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d5 A[Catch: all -> 0x0034, Exception -> 0x00d9, TRY_LEAVE, TryCatch #6 {Exception -> 0x00d9, blocks: (B:44:0x00d0, B:46:0x00d5), top: B:66:0x00d0, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        HomeApkBannerData convertAdTemplateToHomeApkBannerData;
        synchronized (a.class) {
            ObjectOutputStream objectOutputStream3 = null;
            ObjectOutputStream objectOutputStream4 = null;
            try {
                convertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(adTemplate);
            } catch (Exception e) {
                e = e;
                objectOutputStream = null;
                objectOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
                objectOutputStream = null;
                objectOutputStream2 = null;
            }
            if (convertAdTemplateToHomeApkBannerData == null) {
                if (0 != 0) {
                    try {
                        objectOutputStream3.close();
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addApkDownloadedData close e" + e2);
                    }
                }
                if (0 != 0) {
                    objectOutputStream4.close();
                }
                return;
            }
            this.f10400a.push(convertAdTemplateToHomeApkBannerData);
            objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.e));
            try {
                objectOutputStream2.writeObject(this.f10400a);
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(b(convertAdTemplateToHomeApkBannerData, true)));
                try {
                    try {
                        objectOutputStream.writeObject(adTemplate);
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e3) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addApkDownloadedData close e" + e3);
                            }
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Exception e4) {
                        e = e4;
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addApkDownloadedData e" + e);
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e5) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addApkDownloadedData close e" + e5);
                            }
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (Exception e6) {
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addApkDownloadedData close e" + e6);
                            throw th;
                        }
                    }
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                objectOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = null;
                if (objectOutputStream2 != null) {
                }
                if (objectOutputStream != null) {
                }
                throw th;
            }
            return;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x00c6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x00c8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0026 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str) {
        ObjectOutputStream objectOutputStream;
        synchronized (a.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.j++;
            Integer num = this.c.get(str);
            int intValue = num == null ? 1 : num.intValue() + 1;
            ?? r1 = this.c;
            r1.put(str, Integer.valueOf(intValue));
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.i));
                    try {
                        objectOutputStream.writeObject(this.c);
                        r1 = objectOutputStream;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                                r1 = objectOutputStream;
                            } catch (Exception e) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addAppShowCount close e" + e);
                                r1 = "HomeApkBannerDataManager";
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addAppShowCount e" + e);
                        r1 = objectOutputStream;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                                r1 = objectOutputStream;
                            } catch (Exception e3) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addAppShowCount close e" + e3);
                                r1 = "HomeApkBannerDataManager";
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (Exception e4) {
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addAppShowCount close e" + e4);
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                objectOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                r1 = 0;
                if (r1 != 0) {
                }
                throw th;
            }
        }
    }

    public void a(boolean z) {
        this.k = z;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:71:0x0134 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x0136 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x002f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008d A[Catch: all -> 0x003f, DONT_GENERATE, TryCatch #8 {, blocks: (B:4:0x0004, B:6:0x000e, B:10:0x0013, B:12:0x0016, B:14:0x001e, B:16:0x0021, B:18:0x002b, B:25:0x003a, B:26:0x003d, B:32:0x0043, B:37:0x0079, B:38:0x007c, B:41:0x0085, B:43:0x008d, B:66:0x011e, B:67:0x0124, B:69:0x0127, B:64:0x010e, B:46:0x0091, B:60:0x00ee, B:61:0x00f1, B:63:0x00f3, B:52:0x00ca, B:55:0x00cf), top: B:87:0x0004, inners: #0, #1, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010e A[Catch: all -> 0x003f, TryCatch #8 {, blocks: (B:4:0x0004, B:6:0x000e, B:10:0x0013, B:12:0x0016, B:14:0x001e, B:16:0x0021, B:18:0x002b, B:25:0x003a, B:26:0x003d, B:32:0x0043, B:37:0x0079, B:38:0x007c, B:41:0x0085, B:43:0x008d, B:66:0x011e, B:67:0x0124, B:69:0x0127, B:64:0x010e, B:46:0x0091, B:60:0x00ee, B:61:0x00f1, B:63:0x00f3, B:52:0x00ca, B:55:0x00cf), top: B:87:0x0004, inners: #0, #1, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(HomeApkBannerData homeApkBannerData, boolean z) {
        ObjectInputStream objectInputStream;
        synchronized (a.class) {
            int i = this.j;
            int d = c.a.ad.d();
            if (i >= d) {
                return false;
            }
            if (homeApkBannerData == null) {
                return false;
            }
            String str = homeApkBannerData.appPackageName;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (b(homeApkBannerData, z).exists()) {
                ObjectInputStream objectInputStream2 = null;
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                        if (d != 0) {
                            try {
                                d.close();
                            } catch (Exception e) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " canShowBanner close e" + e);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    objectInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    d = 0;
                    if (d != 0) {
                    }
                    throw th;
                }
                if (!this.i.exists()) {
                    if (0 != 0) {
                        try {
                            objectInputStream2.close();
                        } catch (Exception e3) {
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " canShowBanner close e" + e3);
                        }
                    }
                    return true;
                }
                this.c.clear();
                objectInputStream = new ObjectInputStream(new FileInputStream(this.i));
                try {
                    this.c = (Map) objectInputStream.readObject();
                    d = objectInputStream;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                            d = objectInputStream;
                        } catch (Exception e4) {
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " canShowBanner close e" + e4);
                            d = "HomeApkBannerDataManager";
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " canShowBanner e" + e);
                    d = objectInputStream;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                            d = objectInputStream;
                        } catch (Exception e6) {
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " canShowBanner close e" + e6);
                            d = "HomeApkBannerDataManager";
                        }
                    }
                    if ((this.c.get(str) != null ? 0 : this.c.get(str).intValue()) < c.a.ad.e()) {
                    }
                }
                if ((this.c.get(str) != null ? 0 : this.c.get(str).intValue()) < c.a.ad.e()) {
                    return false;
                }
                return z ? b(homeApkBannerData.mDownloadFilePath) : y.a(KsAdSDKImpl.get().getContext(), str);
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ad -> B:12:0x001d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdTemplate b() {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2;
        synchronized (a.class) {
            ObjectInputStream objectInputStream3 = null;
            try {
            } catch (Exception e) {
                e = e;
                objectInputStream2 = null;
            } catch (Throwable th) {
                th = th;
                objectInputStream = null;
            }
            if (this.e.exists()) {
                this.f10400a.clear();
                objectInputStream = new ObjectInputStream(new FileInputStream(this.e));
                try {
                    this.f10400a = (Stack) objectInputStream.readObject();
                } catch (Exception e2) {
                    e = e2;
                    objectInputStream2 = objectInputStream;
                    try {
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowDownloadBannerData e" + e);
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (Exception e3) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e3);
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        objectInputStream = objectInputStream2;
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Exception e4) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e4);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (objectInputStream != null) {
                    }
                    throw th;
                }
                if (this.f10400a.isEmpty()) {
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e5) {
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e5);
                        }
                    }
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Stack stack = (Stack) this.f10400a.clone();
                while (!stack.isEmpty()) {
                    HomeApkBannerData homeApkBannerData = (HomeApkBannerData) stack.pop();
                    if (homeApkBannerData != null) {
                        if (currentTimeMillis - homeApkBannerData.mTimeStamp > 604800000) {
                            break;
                        } else if (a(homeApkBannerData, true)) {
                            ObjectInputStream objectInputStream4 = new ObjectInputStream(new FileInputStream(b(homeApkBannerData, true)));
                            try {
                                AdTemplate adTemplate = (AdTemplate) objectInputStream4.readObject();
                                objectInputStream4.close();
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Exception e6) {
                                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e6);
                                    }
                                }
                                return adTemplate;
                            } catch (Exception e7) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowDownloadBannerData get adTemplate e" + e7);
                                objectInputStream4.close();
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e8) {
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e8);
                    }
                }
                return null;
            }
            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", "getCanShowDownloadBannerData mDownloadFile is not exists");
            if (0 != 0) {
                try {
                    objectInputStream3.close();
                } catch (Exception e9) {
                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e9);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        boolean z;
        synchronized (a.class) {
            HomeApkBannerData convertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(adTemplate);
            if (convertAdTemplateToHomeApkBannerData == null) {
                return;
            }
            boolean z2 = false;
            Iterator<HomeApkBannerData> it = this.f10400a.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(convertAdTemplateToHomeApkBannerData.appPackageName, it.next().appPackageName)) {
                    it.remove();
                    z = true;
                } else {
                    z = z2;
                }
                z2 = z;
            }
            if (z2) {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.e));
                    try {
                        try {
                            objectOutputStream.writeObject(this.f10400a);
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception e) {
                                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " removeApkDownloadedData close e" + e);
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " removeApkDownloadedData e" + e);
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception e3) {
                                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " removeApkDownloadedData close e" + e3);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e4) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " removeApkDownloadedData close e" + e4);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    objectOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream = null;
                    if (objectOutputStream != null) {
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ad -> B:12:0x001d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdTemplate c() {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2;
        synchronized (a.class) {
            ObjectInputStream objectInputStream3 = null;
            try {
            } catch (Exception e) {
                e = e;
                objectInputStream2 = null;
            } catch (Throwable th) {
                th = th;
                objectInputStream = null;
            }
            if (this.f.exists()) {
                this.f10401b.clear();
                objectInputStream = new ObjectInputStream(new FileInputStream(this.f));
                try {
                    this.f10401b = (Stack) objectInputStream.readObject();
                } catch (Exception e2) {
                    e = e2;
                    objectInputStream2 = objectInputStream;
                    try {
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData e" + e);
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (Exception e3) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e3);
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        objectInputStream = objectInputStream2;
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Exception e4) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e4);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (objectInputStream != null) {
                    }
                    throw th;
                }
                if (this.f10401b.isEmpty()) {
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e5) {
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e5);
                        }
                    }
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Stack stack = (Stack) this.f10401b.clone();
                while (!stack.isEmpty()) {
                    HomeApkBannerData homeApkBannerData = (HomeApkBannerData) stack.pop();
                    if (homeApkBannerData != null) {
                        if (currentTimeMillis - homeApkBannerData.mTimeStamp > 604800000) {
                            break;
                        } else if (a(homeApkBannerData, false)) {
                            ObjectInputStream objectInputStream4 = new ObjectInputStream(new FileInputStream(b(homeApkBannerData, false)));
                            try {
                                AdTemplate adTemplate = (AdTemplate) objectInputStream4.readObject();
                                objectInputStream4.close();
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Exception e6) {
                                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e6);
                                    }
                                }
                                return adTemplate;
                            } catch (Exception e7) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData get adTemplate e" + e7);
                                objectInputStream4.close();
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e8) {
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e8);
                    }
                }
                return null;
            }
            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", "getCanShowInstalledBannerData mInstallFile is not exists");
            if (0 != 0) {
                try {
                    objectInputStream3.close();
                } catch (Exception e9) {
                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e9);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d5 A[Catch: all -> 0x0034, Exception -> 0x00d9, TRY_LEAVE, TryCatch #6 {Exception -> 0x00d9, blocks: (B:44:0x00d0, B:46:0x00d5), top: B:66:0x00d0, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        HomeApkBannerData convertAdTemplateToHomeApkBannerData;
        synchronized (a.class) {
            ObjectOutputStream objectOutputStream3 = null;
            ObjectOutputStream objectOutputStream4 = null;
            try {
                convertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(adTemplate);
            } catch (Exception e) {
                e = e;
                objectOutputStream = null;
                objectOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
                objectOutputStream = null;
                objectOutputStream2 = null;
            }
            if (convertAdTemplateToHomeApkBannerData == null) {
                if (0 != 0) {
                    try {
                        objectOutputStream3.close();
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addInstalledData close e" + e2);
                    }
                }
                if (0 != 0) {
                    objectOutputStream4.close();
                }
                return;
            }
            this.f10401b.push(convertAdTemplateToHomeApkBannerData);
            objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.f));
            try {
                objectOutputStream2.writeObject(this.f10401b);
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(b(convertAdTemplateToHomeApkBannerData, false)));
                try {
                    try {
                        objectOutputStream.writeObject(adTemplate);
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e3) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addInstalledData close e" + e3);
                            }
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Exception e4) {
                        e = e4;
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addInstalledData e" + e);
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e5) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addInstalledData close e" + e5);
                            }
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (Exception e6) {
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addInstalledData close e" + e6);
                            throw th;
                        }
                    }
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                objectOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = null;
                if (objectOutputStream2 != null) {
                }
                if (objectOutputStream != null) {
                }
                throw th;
            }
            return;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x01a1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x01a4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x003c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061 A[Catch: all -> 0x009f, TryCatch #14 {, blocks: (B:4:0x0009, B:5:0x0014, B:7:0x001a, B:9:0x0028, B:11:0x0036, B:18:0x0051, B:30:0x0084, B:46:0x00e5, B:47:0x00e8, B:49:0x00ea, B:38:0x00c0, B:41:0x00c5, B:19:0x0054, B:20:0x005b, B:22:0x0061, B:24:0x006f, B:26:0x007d, B:55:0x011a, B:59:0x0120, B:71:0x017b, B:72:0x017e, B:74:0x0180, B:64:0x0158, B:67:0x015d, B:56:0x011d), top: B:106:0x0009, inners: #2, #3, #4, #6, #10, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        ObjectOutputStream objectOutputStream;
        Iterator<HomeApkBannerData> it;
        boolean z;
        ObjectOutputStream objectOutputStream2;
        boolean z2;
        ObjectOutputStream objectOutputStream3;
        ObjectOutputStream objectOutputStream4 = null;
        synchronized (a.class) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<HomeApkBannerData> it2 = this.f10400a.iterator();
            ObjectOutputStream objectOutputStream5 = null;
            while (it2.hasNext()) {
                HomeApkBannerData next = it2.next();
                if (currentTimeMillis - next.mTimeStamp > 604800000) {
                    it2.remove();
                    File b2 = b(next, true);
                    if (b2.exists()) {
                        b2.delete();
                    }
                    objectOutputStream3 = 1;
                } else {
                    objectOutputStream3 = objectOutputStream5;
                }
                objectOutputStream5 = objectOutputStream3;
            }
            try {
                if (objectOutputStream5 != null) {
                    try {
                        objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.e));
                        try {
                            objectOutputStream.writeObject(this.f10400a);
                            objectOutputStream5 = objectOutputStream;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                    objectOutputStream5 = objectOutputStream;
                                } catch (Exception e) {
                                    com.kwad.sdk.core.d.a.d("HomeApkBannerDataManager", " cleanInvalidData needUpdateDownloadData final close e" + e);
                                    objectOutputStream5 = "HomeApkBannerDataManager";
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            com.kwad.sdk.core.d.a.d("HomeApkBannerDataManager", " cleanInvalidData needUpdateDownloadData e" + e);
                            objectOutputStream5 = objectOutputStream;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                    objectOutputStream5 = objectOutputStream;
                                } catch (Exception e3) {
                                    com.kwad.sdk.core.d.a.d("HomeApkBannerDataManager", " cleanInvalidData needUpdateDownloadData final close e" + e3);
                                    objectOutputStream5 = "HomeApkBannerDataManager";
                                }
                            }
                            it = this.f10401b.iterator();
                            z = false;
                            while (it.hasNext()) {
                            }
                            if (z) {
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        objectOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        objectOutputStream5 = null;
                        if (objectOutputStream5 != null) {
                            try {
                                objectOutputStream5.close();
                            } catch (Exception e5) {
                                com.kwad.sdk.core.d.a.d("HomeApkBannerDataManager", " cleanInvalidData needUpdateDownloadData final close e" + e5);
                            }
                        }
                        throw th;
                    }
                }
                it = this.f10401b.iterator();
                z = false;
                while (it.hasNext()) {
                    HomeApkBannerData next2 = it.next();
                    if (currentTimeMillis - next2.mTimeStamp > 604800000) {
                        it.remove();
                        File b3 = b(next2, false);
                        if (b3.exists()) {
                            b3.delete();
                        }
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    z = z2;
                }
                if (z) {
                    try {
                        try {
                            objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.f));
                        } catch (Exception e6) {
                            e = e6;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        objectOutputStream2.writeObject(this.f10401b);
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e7) {
                                com.kwad.sdk.core.d.a.d("HomeApkBannerDataManager", " cleanInvalidData needUpdateInstallData final close e" + e7);
                            }
                        }
                    } catch (Exception e8) {
                        e = e8;
                        objectOutputStream4 = objectOutputStream2;
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " cleanInvalidData needUpdateInstallData e" + e);
                        if (objectOutputStream4 != null) {
                            try {
                                objectOutputStream4.close();
                            } catch (Exception e9) {
                                com.kwad.sdk.core.d.a.d("HomeApkBannerDataManager", " cleanInvalidData needUpdateInstallData final close e" + e9);
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        objectOutputStream4 = objectOutputStream2;
                        if (objectOutputStream4 != null) {
                            try {
                                objectOutputStream4.close();
                            } catch (Exception e10) {
                                com.kwad.sdk.core.d.a.d("HomeApkBannerDataManager", " cleanInvalidData needUpdateInstallData final close e" + e10);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        boolean z;
        synchronized (a.class) {
            HomeApkBannerData convertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(adTemplate);
            boolean z2 = false;
            Iterator<HomeApkBannerData> it = this.f10401b.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(convertAdTemplateToHomeApkBannerData.appPackageName, it.next().appPackageName)) {
                    it.remove();
                    z = true;
                } else {
                    z = z2;
                }
                z2 = z;
            }
            if (z2) {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f));
                    try {
                        try {
                            objectOutputStream.writeObject(this.f10401b);
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception e) {
                                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " removeInstalledData close e" + e);
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " removeInstalledData e" + e);
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception e3) {
                                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " removeInstalledData close e" + e3);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e4) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " removeInstalledData close e" + e4);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    objectOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream = null;
                    if (objectOutputStream != null) {
                    }
                    throw th;
                }
            }
        }
    }

    public boolean e() {
        return this.k;
    }
}
