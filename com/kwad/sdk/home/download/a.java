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
/* loaded from: classes6.dex */
public class a {
    public static volatile a l;

    /* renamed from: e  reason: collision with root package name */
    public File f36180e;

    /* renamed from: f  reason: collision with root package name */
    public File f36181f;

    /* renamed from: g  reason: collision with root package name */
    public File f36182g;

    /* renamed from: h  reason: collision with root package name */
    public File f36183h;
    public File i;

    /* renamed from: a  reason: collision with root package name */
    public Stack<HomeApkBannerData> f36176a = new Stack<>();

    /* renamed from: b  reason: collision with root package name */
    public Stack<HomeApkBannerData> f36177b = new Stack<>();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f36178c = new HashMap();
    public int j = 0;
    public boolean k = false;

    /* renamed from: d  reason: collision with root package name */
    public String f36179d = ad.d(KsAdSDKImpl.get().getContext());

    public a() {
        File file = new File(this.f36179d);
        if (!file.exists()) {
            file.mkdir();
        }
        this.f36180e = new File(this.f36179d + File.separator + "download_uninstall");
        File file2 = new File(this.f36179d + File.separator + "download_uninstall_apk_data");
        this.f36182g = file2;
        if (!file2.exists()) {
            this.f36182g.mkdir();
        }
        File file3 = new File(this.f36179d + File.separator + "install_unopen_apk_data");
        this.f36183h = file3;
        if (!file3.exists()) {
            this.f36183h.mkdir();
        }
        this.f36181f = new File(this.f36179d + File.separator + "install_unopen");
        this.i = new File(this.f36179d + File.separator + "app_has_show_banner_counts");
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
        String path = (z ? this.f36182g : this.f36183h).getPath();
        return new File(path + File.separator + homeApkBannerData.mAdTemplateUniqueId);
    }

    private boolean b(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ac A[Catch: all -> 0x00a6, Exception -> 0x00a8, TRY_LEAVE, TryCatch #5 {Exception -> 0x00a8, blocks: (B:45:0x00a2, B:51:0x00ac), top: B:60:0x00a2, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        String str;
        String str2;
        HomeApkBannerData convertAdTemplateToHomeApkBannerData;
        synchronized (a.class) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                try {
                    convertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(adTemplate);
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                objectOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = null;
            }
            if (convertAdTemplateToHomeApkBannerData == null) {
                return;
            }
            this.f36176a.push(convertAdTemplateToHomeApkBannerData);
            ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new FileOutputStream(this.f36180e));
            try {
                objectOutputStream3.writeObject(this.f36176a);
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(b(convertAdTemplateToHomeApkBannerData, true)));
                try {
                    objectOutputStream.writeObject(adTemplate);
                    try {
                        objectOutputStream3.close();
                        objectOutputStream.close();
                    } catch (Exception e3) {
                        str = "HomeApkBannerDataManager";
                        str2 = " addApkDownloadedData close e" + e3;
                        com.kwad.sdk.core.d.a.a(str, str2);
                    }
                } catch (Exception e4) {
                    e = e4;
                    objectOutputStream2 = objectOutputStream3;
                    try {
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addApkDownloadedData e" + e);
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e5) {
                                str = "HomeApkBannerDataManager";
                                str2 = " addApkDownloadedData close e" + e5;
                                com.kwad.sdk.core.d.a.a(str, str2);
                            }
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
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
                } catch (Throwable th4) {
                    th = th4;
                    objectOutputStream2 = objectOutputStream3;
                    if (objectOutputStream2 != null) {
                    }
                    if (objectOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                objectOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                objectOutputStream = null;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0058 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0096 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x002b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str) {
        Throwable th;
        ObjectOutputStream objectOutputStream;
        Exception e2;
        String str2;
        String str3;
        synchronized (a.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i = 1;
            this.j++;
            Integer num = this.f36178c.get(str);
            if (num != null) {
                i = 1 + num.intValue();
            }
            ?? r1 = this.f36178c;
            r1.put(str, Integer.valueOf(i));
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.i));
                    try {
                        objectOutputStream.writeObject(this.f36178c);
                        try {
                            objectOutputStream.close();
                            r1 = objectOutputStream;
                        } catch (Exception e3) {
                            str2 = "HomeApkBannerDataManager";
                            str3 = " addAppShowCount close e" + e3;
                            com.kwad.sdk.core.d.a.a(str2, str3);
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addAppShowCount e" + e2);
                        r1 = objectOutputStream;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                                r1 = objectOutputStream;
                            } catch (Exception e5) {
                                str2 = "HomeApkBannerDataManager";
                                str3 = " addAppShowCount close e" + e5;
                                com.kwad.sdk.core.d.a.a(str2, str3);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (Exception e6) {
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addAppShowCount close e" + e6);
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                objectOutputStream = null;
                e2 = e7;
            } catch (Throwable th3) {
                r1 = 0;
                th = th3;
                if (r1 != 0) {
                }
                throw th;
            }
        }
    }

    public void a(boolean z) {
        this.k = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00af A[Catch: all -> 0x00fc, TryCatch #5 {, blocks: (B:4:0x0003, B:6:0x000e, B:9:0x0012, B:11:0x0014, B:13:0x001c, B:15:0x001e, B:17:0x0028, B:23:0x0034, B:27:0x004f, B:45:0x00a5, B:49:0x00bb, B:51:0x00c3, B:54:0x00c7, B:56:0x00da, B:55:0x00ce, B:48:0x00af, B:30:0x0054, B:31:0x0067, B:41:0x008c, B:44:0x0091, B:61:0x00e0, B:65:0x00fb, B:64:0x00e5), top: B:76:0x0003, inners: #0, #3, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c3 A[Catch: all -> 0x00fc, DONT_GENERATE, TryCatch #5 {, blocks: (B:4:0x0003, B:6:0x000e, B:9:0x0012, B:11:0x0014, B:13:0x001c, B:15:0x001e, B:17:0x0028, B:23:0x0034, B:27:0x004f, B:45:0x00a5, B:49:0x00bb, B:51:0x00c3, B:54:0x00c7, B:56:0x00da, B:55:0x00ce, B:48:0x00af, B:30:0x0054, B:31:0x0067, B:41:0x008c, B:44:0x0091, B:61:0x00e0, B:65:0x00fb, B:64:0x00e5), top: B:76:0x0003, inners: #0, #3, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(HomeApkBannerData homeApkBannerData, boolean z) {
        ObjectInputStream objectInputStream;
        Exception e2;
        String str;
        String str2;
        synchronized (a.class) {
            if (this.j >= c.a.ad.d()) {
                return false;
            }
            if (homeApkBannerData == null) {
                return false;
            }
            String str3 = homeApkBannerData.appPackageName;
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            if (b(homeApkBannerData, z).exists()) {
                ObjectInputStream objectInputStream2 = null;
                try {
                } catch (Exception e3) {
                    objectInputStream = null;
                    e2 = e3;
                } catch (Throwable th) {
                    th = th;
                    if (objectInputStream2 != null) {
                    }
                    throw th;
                }
                if (this.i.exists()) {
                    this.f36178c.clear();
                    objectInputStream = new ObjectInputStream(new FileInputStream(this.i));
                    try {
                        try {
                            this.f36178c = (Map) objectInputStream.readObject();
                        } catch (Exception e4) {
                            e2 = e4;
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " canShowBanner e" + e2);
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Exception e5) {
                                    str = "HomeApkBannerDataManager";
                                    str2 = " canShowBanner close e" + e5;
                                    com.kwad.sdk.core.d.a.a(str, str2);
                                    if ((this.f36178c.get(str3) != null ? 0 : this.f36178c.get(str3).intValue()) < c.a.ad.e()) {
                                    }
                                }
                            }
                            if ((this.f36178c.get(str3) != null ? 0 : this.f36178c.get(str3).intValue()) < c.a.ad.e()) {
                            }
                        }
                        try {
                            objectInputStream.close();
                        } catch (Exception e6) {
                            str = "HomeApkBannerDataManager";
                            str2 = " canShowBanner close e" + e6;
                            com.kwad.sdk.core.d.a.a(str, str2);
                            if ((this.f36178c.get(str3) != null ? 0 : this.f36178c.get(str3).intValue()) < c.a.ad.e()) {
                            }
                        }
                        if ((this.f36178c.get(str3) != null ? 0 : this.f36178c.get(str3).intValue()) < c.a.ad.e()) {
                            return false;
                        }
                        return z ? b(homeApkBannerData.mDownloadFilePath) : y.a(KsAdSDKImpl.get().getContext(), str3);
                    } catch (Throwable th2) {
                        th = th2;
                        objectInputStream2 = objectInputStream;
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (Exception e7) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " canShowBanner close e" + e7);
                            }
                        }
                        throw th;
                    }
                }
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x009a, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009b, code lost:
        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdTemplate b() {
        ObjectInputStream objectInputStream;
        String str;
        String str2;
        Stack<HomeApkBannerData> stack;
        AdTemplate adTemplate;
        synchronized (a.class) {
            ObjectInputStream objectInputStream2 = null;
            try {
            } catch (Exception e2) {
                e = e2;
                objectInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            if (!this.f36180e.exists()) {
                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", "getCanShowDownloadBannerData mDownloadFile is not exists");
                return null;
            }
            this.f36176a.clear();
            ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream(this.f36180e));
            try {
                stack = (Stack) objectInputStream3.readObject();
                this.f36176a = stack;
            } catch (Exception e3) {
                objectInputStream = objectInputStream3;
                e = e3;
                try {
                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowDownloadBannerData e" + e);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e4) {
                            str = "HomeApkBannerDataManager";
                            str2 = " getCanShowInstalledBannerData finally e" + e4;
                            com.kwad.sdk.core.d.a.a(str, str2);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream2 = objectInputStream;
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (Exception e5) {
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e5);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream2 = objectInputStream3;
                if (objectInputStream2 != null) {
                }
                throw th;
            }
            if (stack.isEmpty()) {
                try {
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e6);
                }
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Stack stack2 = (Stack) this.f36176a.clone();
            while (true) {
                if (!stack2.isEmpty()) {
                    HomeApkBannerData homeApkBannerData = (HomeApkBannerData) stack2.pop();
                    if (homeApkBannerData != null) {
                        if (currentTimeMillis - homeApkBannerData.mTimeStamp > 604800000) {
                            break;
                        } else if (a(homeApkBannerData, true)) {
                            objectInputStream3 = new ObjectInputStream(new FileInputStream(b(homeApkBannerData, true)));
                            try {
                                try {
                                    adTemplate = (AdTemplate) objectInputStream3.readObject();
                                    break;
                                } catch (Exception e7) {
                                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowDownloadBannerData get adTemplate e" + e7);
                                    objectInputStream3.close();
                                }
                            } finally {
                                objectInputStream3.close();
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            try {
                break;
            } catch (Exception e8) {
                str = "HomeApkBannerDataManager";
                str2 = " getCanShowInstalledBannerData finally e" + e8;
                com.kwad.sdk.core.d.a.a(str, str2);
                return null;
            }
            return null;
        }
        return adTemplate;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e2;
        String str;
        String str2;
        synchronized (a.class) {
            HomeApkBannerData convertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(adTemplate);
            if (convertAdTemplateToHomeApkBannerData == null) {
                return;
            }
            boolean z = false;
            Iterator<HomeApkBannerData> it = this.f36176a.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(convertAdTemplateToHomeApkBannerData.appPackageName, it.next().appPackageName)) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f36180e));
                    try {
                        try {
                            objectOutputStream.writeObject(this.f36176a);
                        } catch (Exception e3) {
                            e2 = e3;
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " removeApkDownloadedData e" + e2);
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception e4) {
                                    str = "HomeApkBannerDataManager";
                                    str2 = " removeApkDownloadedData close e" + e4;
                                    com.kwad.sdk.core.d.a.a(str, str2);
                                }
                            }
                        }
                        try {
                            objectOutputStream.close();
                        } catch (Exception e5) {
                            str = "HomeApkBannerDataManager";
                            str2 = " removeApkDownloadedData close e" + e5;
                            com.kwad.sdk.core.d.a.a(str, str2);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e6) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " removeApkDownloadedData close e" + e6);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    objectOutputStream = null;
                    e2 = e7;
                } catch (Throwable th3) {
                    objectOutputStream = null;
                    th = th3;
                    if (objectOutputStream != null) {
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x009a, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009b, code lost:
        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdTemplate c() {
        ObjectInputStream objectInputStream;
        String str;
        String str2;
        Stack<HomeApkBannerData> stack;
        AdTemplate adTemplate;
        synchronized (a.class) {
            ObjectInputStream objectInputStream2 = null;
            try {
            } catch (Exception e2) {
                e = e2;
                objectInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            if (!this.f36181f.exists()) {
                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", "getCanShowInstalledBannerData mInstallFile is not exists");
                return null;
            }
            this.f36177b.clear();
            ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream(this.f36181f));
            try {
                stack = (Stack) objectInputStream3.readObject();
                this.f36177b = stack;
            } catch (Exception e3) {
                objectInputStream = objectInputStream3;
                e = e3;
                try {
                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData e" + e);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e4) {
                            str = "HomeApkBannerDataManager";
                            str2 = " getCanShowInstalledBannerData finally e" + e4;
                            com.kwad.sdk.core.d.a.a(str, str2);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream2 = objectInputStream;
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (Exception e5) {
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e5);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream2 = objectInputStream3;
                if (objectInputStream2 != null) {
                }
                throw th;
            }
            if (stack.isEmpty()) {
                try {
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e6);
                }
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Stack stack2 = (Stack) this.f36177b.clone();
            while (true) {
                if (!stack2.isEmpty()) {
                    HomeApkBannerData homeApkBannerData = (HomeApkBannerData) stack2.pop();
                    if (homeApkBannerData != null) {
                        if (currentTimeMillis - homeApkBannerData.mTimeStamp > 604800000) {
                            break;
                        } else if (a(homeApkBannerData, false)) {
                            objectInputStream3 = new ObjectInputStream(new FileInputStream(b(homeApkBannerData, false)));
                            try {
                                try {
                                    adTemplate = (AdTemplate) objectInputStream3.readObject();
                                    break;
                                } catch (Exception e7) {
                                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData get adTemplate e" + e7);
                                    objectInputStream3.close();
                                }
                            } finally {
                                objectInputStream3.close();
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            try {
                break;
            } catch (Exception e8) {
                str = "HomeApkBannerDataManager";
                str2 = " getCanShowInstalledBannerData finally e" + e8;
                com.kwad.sdk.core.d.a.a(str, str2);
                return null;
            }
            return null;
        }
        return adTemplate;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ac A[Catch: all -> 0x00a6, Exception -> 0x00a8, TRY_LEAVE, TryCatch #5 {Exception -> 0x00a8, blocks: (B:45:0x00a2, B:51:0x00ac), top: B:60:0x00a2, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        String str;
        String str2;
        HomeApkBannerData convertAdTemplateToHomeApkBannerData;
        synchronized (a.class) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                try {
                    convertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(adTemplate);
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                objectOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = null;
            }
            if (convertAdTemplateToHomeApkBannerData == null) {
                return;
            }
            this.f36177b.push(convertAdTemplateToHomeApkBannerData);
            ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new FileOutputStream(this.f36181f));
            try {
                objectOutputStream3.writeObject(this.f36177b);
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(b(convertAdTemplateToHomeApkBannerData, false)));
                try {
                    objectOutputStream.writeObject(adTemplate);
                    try {
                        objectOutputStream3.close();
                        objectOutputStream.close();
                    } catch (Exception e3) {
                        str = "HomeApkBannerDataManager";
                        str2 = " addInstalledData close e" + e3;
                        com.kwad.sdk.core.d.a.a(str, str2);
                    }
                } catch (Exception e4) {
                    e = e4;
                    objectOutputStream2 = objectOutputStream3;
                    try {
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addInstalledData e" + e);
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e5) {
                                str = "HomeApkBannerDataManager";
                                str2 = " addInstalledData close e" + e5;
                                com.kwad.sdk.core.d.a.a(str, str2);
                            }
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
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
                } catch (Throwable th4) {
                    th = th4;
                    objectOutputStream2 = objectOutputStream3;
                    if (objectOutputStream2 != null) {
                    }
                    if (objectOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                objectOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                objectOutputStream = null;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:116:0x000f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:117:0x000f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x006a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x003a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ce A[Catch: all -> 0x0178, TryCatch #9 {, blocks: (B:4:0x0003, B:5:0x000f, B:7:0x0019, B:9:0x0027, B:11:0x0034, B:17:0x004d, B:20:0x0053, B:21:0x0066, B:31:0x0088, B:34:0x008d, B:39:0x00a5, B:43:0x00c0, B:42:0x00aa, B:44:0x00c1, B:45:0x00c8, B:47:0x00ce, B:49:0x00dc, B:51:0x00e9, B:56:0x0101, B:59:0x0107, B:60:0x011a, B:77:0x015a, B:81:0x0175, B:80:0x015f, B:71:0x013f, B:74:0x0144, B:82:0x0176), top: B:103:0x0003, inners: #3, #5, #7, #8, #10, #12 }] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        ObjectOutputStream objectOutputStream;
        String str;
        String str2;
        Iterator<HomeApkBannerData> it;
        boolean z;
        String str3;
        String str4;
        ObjectOutputStream objectOutputStream2;
        synchronized (a.class) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<HomeApkBannerData> it2 = this.f36176a.iterator();
            ?? r5 = 0;
            while (it2.hasNext()) {
                HomeApkBannerData next = it2.next();
                if (currentTimeMillis - next.mTimeStamp > 604800000) {
                    it2.remove();
                    File b2 = b(next, true);
                    if (b2.exists()) {
                        b2.delete();
                    }
                    r5 = 1;
                }
            }
            ObjectOutputStream objectOutputStream3 = null;
            try {
                if (r5 != 0) {
                    try {
                        objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f36180e));
                        try {
                            objectOutputStream.writeObject(this.f36176a);
                        } catch (Exception e2) {
                            e = e2;
                            com.kwad.sdk.core.d.a.d("HomeApkBannerDataManager", " cleanInvalidData needUpdateDownloadData e" + e);
                            r5 = objectOutputStream;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                    r5 = objectOutputStream;
                                } catch (Exception e3) {
                                    str = "HomeApkBannerDataManager";
                                    str2 = " cleanInvalidData needUpdateDownloadData final close e" + e3;
                                    com.kwad.sdk.core.d.a.d(str, str2);
                                    it = this.f36177b.iterator();
                                    z = false;
                                    while (it.hasNext()) {
                                    }
                                    if (z) {
                                    }
                                }
                            }
                            it = this.f36177b.iterator();
                            z = false;
                            while (it.hasNext()) {
                            }
                            if (z) {
                            }
                        }
                        try {
                            objectOutputStream.close();
                            r5 = objectOutputStream;
                        } catch (Exception e4) {
                            str = "HomeApkBannerDataManager";
                            str2 = " cleanInvalidData needUpdateDownloadData final close e" + e4;
                            com.kwad.sdk.core.d.a.d(str, str2);
                            it = this.f36177b.iterator();
                            z = false;
                            while (it.hasNext()) {
                            }
                            if (z) {
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        objectOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        if (objectOutputStream3 != null) {
                            try {
                                objectOutputStream3.close();
                            } catch (Exception e6) {
                                com.kwad.sdk.core.d.a.d("HomeApkBannerDataManager", " cleanInvalidData needUpdateDownloadData final close e" + e6);
                            }
                        }
                        throw th;
                    }
                }
                it = this.f36177b.iterator();
                z = false;
                while (it.hasNext()) {
                    HomeApkBannerData next2 = it.next();
                    if (currentTimeMillis - next2.mTimeStamp > 604800000) {
                        it.remove();
                        File b3 = b(next2, false);
                        if (b3.exists()) {
                            b3.delete();
                        }
                        z = true;
                    }
                }
                try {
                    if (z) {
                        try {
                            objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.f36181f));
                        } catch (Exception e7) {
                            e = e7;
                        }
                        try {
                            objectOutputStream2.writeObject(this.f36177b);
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e8) {
                                str3 = "HomeApkBannerDataManager";
                                str4 = " cleanInvalidData needUpdateInstallData final close e" + e8;
                                com.kwad.sdk.core.d.a.d(str3, str4);
                            }
                        } catch (Exception e9) {
                            e = e9;
                            objectOutputStream3 = objectOutputStream2;
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " cleanInvalidData needUpdateInstallData e" + e);
                            if (objectOutputStream3 != null) {
                                try {
                                    objectOutputStream3.close();
                                } catch (Exception e10) {
                                    str3 = "HomeApkBannerDataManager";
                                    str4 = " cleanInvalidData needUpdateInstallData final close e" + e10;
                                    com.kwad.sdk.core.d.a.d(str3, str4);
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            objectOutputStream3 = objectOutputStream2;
                            if (objectOutputStream3 != null) {
                                try {
                                    objectOutputStream3.close();
                                } catch (Exception e11) {
                                    com.kwad.sdk.core.d.a.d("HomeApkBannerDataManager", " cleanInvalidData needUpdateInstallData final close e" + e11);
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream3 = r5;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e2;
        String str;
        String str2;
        synchronized (a.class) {
            HomeApkBannerData convertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(adTemplate);
            boolean z = false;
            Iterator<HomeApkBannerData> it = this.f36177b.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(convertAdTemplateToHomeApkBannerData.appPackageName, it.next().appPackageName)) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f36181f));
                    try {
                        try {
                            objectOutputStream.writeObject(this.f36177b);
                        } catch (Exception e3) {
                            e2 = e3;
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " removeInstalledData e" + e2);
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception e4) {
                                    str = "HomeApkBannerDataManager";
                                    str2 = " removeInstalledData close e" + e4;
                                    com.kwad.sdk.core.d.a.a(str, str2);
                                }
                            }
                        }
                        try {
                            objectOutputStream.close();
                        } catch (Exception e5) {
                            str = "HomeApkBannerDataManager";
                            str2 = " removeInstalledData close e" + e5;
                            com.kwad.sdk.core.d.a.a(str, str2);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e6) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " removeInstalledData close e" + e6);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    objectOutputStream = null;
                    e2 = e7;
                } catch (Throwable th3) {
                    objectOutputStream = null;
                    th = th3;
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
