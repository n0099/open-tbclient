package com.kwad.sdk.home.download;

import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes3.dex */
public class a {
    public static volatile a l;

    /* renamed from: e  reason: collision with root package name */
    public File f59197e;

    /* renamed from: f  reason: collision with root package name */
    public File f59198f;

    /* renamed from: g  reason: collision with root package name */
    public File f59199g;

    /* renamed from: h  reason: collision with root package name */
    public File f59200h;

    /* renamed from: i  reason: collision with root package name */
    public File f59201i;
    public Stack<HomeApkBannerData> a = new Stack<>();

    /* renamed from: b  reason: collision with root package name */
    public Stack<HomeApkBannerData> f59194b = new Stack<>();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f59195c = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public int f59202j = 0;

    /* renamed from: k  reason: collision with root package name */
    public boolean f59203k = false;

    /* renamed from: d  reason: collision with root package name */
    public String f59196d = aq.d(KsAdSDKImpl.get().getContext());

    public a() {
        File file = new File(this.f59196d);
        if (!file.exists()) {
            file.mkdir();
        }
        this.f59197e = new File(this.f59196d + File.separator + "download_uninstall");
        File file2 = new File(this.f59196d + File.separator + "download_uninstall_apk_data");
        this.f59199g = file2;
        if (!file2.exists()) {
            this.f59199g.mkdir();
        }
        File file3 = new File(this.f59196d + File.separator + "install_unopen_apk_data");
        this.f59200h = file3;
        if (!file3.exists()) {
            this.f59200h.mkdir();
        }
        this.f59198f = new File(this.f59196d + File.separator + "install_unopen");
        this.f59201i = new File(this.f59196d + File.separator + "app_has_show_banner_counts");
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

    private File a(HomeApkBannerData homeApkBannerData, boolean z) {
        String path = (z ? this.f59199g : this.f59200h).getPath();
        return new File(path + File.separator + homeApkBannerData.mAdTemplateUniqueId);
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
            this.a.push(convertAdTemplateToHomeApkBannerData);
            ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new FileOutputStream(this.f59197e));
            try {
                objectOutputStream3.writeObject(this.a);
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(a(convertAdTemplateToHomeApkBannerData, true)));
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

    public void a(boolean z) {
        this.f59203k = z;
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
            Iterator<HomeApkBannerData> it = this.a.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(convertAdTemplateToHomeApkBannerData.appPackageName, it.next().appPackageName)) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f59197e));
                    try {
                        try {
                            objectOutputStream.writeObject(this.a);
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
            this.f59194b.push(convertAdTemplateToHomeApkBannerData);
            ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new FileOutputStream(this.f59198f));
            try {
                objectOutputStream3.writeObject(this.f59194b);
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(a(convertAdTemplateToHomeApkBannerData, false)));
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
            Iterator<HomeApkBannerData> it = this.f59194b.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(convertAdTemplateToHomeApkBannerData.appPackageName, it.next().appPackageName)) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f59198f));
                    try {
                        try {
                            objectOutputStream.writeObject(this.f59194b);
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
}
