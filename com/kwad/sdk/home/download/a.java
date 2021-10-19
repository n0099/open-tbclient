package com.kwad.sdk.home.download;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.al;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Stack<HomeApkBannerData> f73407a;

    /* renamed from: b  reason: collision with root package name */
    public Stack<HomeApkBannerData> f73408b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f73409c;

    /* renamed from: d  reason: collision with root package name */
    public String f73410d;

    /* renamed from: e  reason: collision with root package name */
    public File f73411e;

    /* renamed from: f  reason: collision with root package name */
    public File f73412f;

    /* renamed from: g  reason: collision with root package name */
    public File f73413g;

    /* renamed from: h  reason: collision with root package name */
    public File f73414h;

    /* renamed from: i  reason: collision with root package name */
    public File f73415i;

    /* renamed from: j  reason: collision with root package name */
    public int f73416j;
    public boolean k;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73407a = new Stack<>();
        this.f73408b = new Stack<>();
        this.f73409c = new HashMap();
        this.f73416j = 0;
        this.k = false;
        this.f73410d = al.d(KsAdSDKImpl.get().getContext());
        File file = new File(this.f73410d);
        if (!file.exists()) {
            file.mkdir();
        }
        this.f73411e = new File(this.f73410d + File.separator + "download_uninstall");
        File file2 = new File(this.f73410d + File.separator + "download_uninstall_apk_data");
        this.f73413g = file2;
        if (!file2.exists()) {
            this.f73413g.mkdir();
        }
        File file3 = new File(this.f73410d + File.separator + "install_unopen_apk_data");
        this.f73414h = file3;
        if (!file3.exists()) {
            this.f73414h.mkdir();
        }
        this.f73412f = new File(this.f73410d + File.separator + "install_unopen");
        this.f73415i = new File(this.f73410d + File.separator + "app_has_show_banner_counts");
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (l == null) {
                synchronized (a.class) {
                    if (l == null) {
                        l = new a();
                    }
                }
            }
            return l;
        }
        return (a) invokeV.objValue;
    }

    private File a(HomeApkBannerData homeApkBannerData, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, this, homeApkBannerData, z)) == null) {
            String path = (z ? this.f73413g : this.f73414h).getPath();
            return new File(path + File.separator + homeApkBannerData.mAdTemplateUniqueId);
        }
        return (File) invokeLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00b0 A[Catch: all -> 0x00aa, Exception -> 0x00ac, TRY_LEAVE, TryCatch #3 {Exception -> 0x00ac, blocks: (B:47:0x00a6, B:53:0x00b0), top: B:66:0x00a6, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        String str;
        String str2;
        HomeApkBannerData convertAdTemplateToHomeApkBannerData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
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
                this.f73407a.push(convertAdTemplateToHomeApkBannerData);
                ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new FileOutputStream(this.f73411e));
                try {
                    objectOutputStream3.writeObject(this.f73407a);
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(a(convertAdTemplateToHomeApkBannerData, true)));
                } catch (Exception e3) {
                    e = e3;
                    objectOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    objectOutputStream = null;
                }
                try {
                    objectOutputStream.writeObject(adTemplate);
                    try {
                        objectOutputStream3.close();
                        objectOutputStream.close();
                    } catch (Exception e4) {
                        str = "HomeApkBannerDataManager";
                        str2 = " addApkDownloadedData close e" + e4;
                        com.kwad.sdk.core.d.a.a(str, str2);
                    }
                } catch (Exception e5) {
                    e = e5;
                    objectOutputStream2 = objectOutputStream3;
                    try {
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addApkDownloadedData e" + e);
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e6) {
                                str = "HomeApkBannerDataManager";
                                str2 = " addApkDownloadedData close e" + e6;
                                com.kwad.sdk.core.d.a.a(str, str2);
                            }
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e7) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addApkDownloadedData close e" + e7);
                                throw th;
                            }
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    objectOutputStream2 = objectOutputStream3;
                    if (objectOutputStream2 != null) {
                    }
                    if (objectOutputStream != null) {
                    }
                    throw th;
                }
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.k = z;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0063 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00a1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x0036 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x0016 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:71:0x0016 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(AdTemplate adTemplate) {
        Throwable th;
        ObjectOutputStream objectOutputStream;
        Exception e2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            synchronized (a.class) {
                HomeApkBannerData convertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(adTemplate);
                if (convertAdTemplateToHomeApkBannerData == null) {
                    return;
                }
                ?? r1 = 0;
                Iterator<HomeApkBannerData> it = this.f73407a.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(convertAdTemplateToHomeApkBannerData.appPackageName, it.next().appPackageName)) {
                        it.remove();
                        r1 = 1;
                    }
                }
                if (r1 == 0) {
                    return;
                }
                try {
                    try {
                        objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f73411e));
                        try {
                            objectOutputStream.writeObject(this.f73407a);
                            try {
                                objectOutputStream.close();
                                r1 = objectOutputStream;
                            } catch (Exception e3) {
                                str = "HomeApkBannerDataManager";
                                str2 = " removeApkDownloadedData close e" + e3;
                                com.kwad.sdk.core.d.a.a(str, str2);
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " removeApkDownloadedData e" + e2);
                            r1 = objectOutputStream;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                    r1 = objectOutputStream;
                                } catch (Exception e5) {
                                    str = "HomeApkBannerDataManager";
                                    str2 = " removeApkDownloadedData close e" + e5;
                                    com.kwad.sdk.core.d.a.a(str, str2);
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (r1 != 0) {
                            try {
                                r1.close();
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
                    r1 = 0;
                    th = th3;
                    if (r1 != 0) {
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00b0 A[Catch: all -> 0x00aa, Exception -> 0x00ac, TRY_LEAVE, TryCatch #3 {Exception -> 0x00ac, blocks: (B:47:0x00a6, B:53:0x00b0), top: B:66:0x00a6, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        String str;
        String str2;
        HomeApkBannerData convertAdTemplateToHomeApkBannerData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adTemplate) == null) {
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
                this.f73408b.push(convertAdTemplateToHomeApkBannerData);
                ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new FileOutputStream(this.f73412f));
                try {
                    objectOutputStream3.writeObject(this.f73408b);
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(a(convertAdTemplateToHomeApkBannerData, false)));
                } catch (Exception e3) {
                    e = e3;
                    objectOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    objectOutputStream = null;
                }
                try {
                    objectOutputStream.writeObject(adTemplate);
                    try {
                        objectOutputStream3.close();
                        objectOutputStream.close();
                    } catch (Exception e4) {
                        str = "HomeApkBannerDataManager";
                        str2 = " addInstalledData close e" + e4;
                        com.kwad.sdk.core.d.a.a(str, str2);
                    }
                } catch (Exception e5) {
                    e = e5;
                    objectOutputStream2 = objectOutputStream3;
                    try {
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addInstalledData e" + e);
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e6) {
                                str = "HomeApkBannerDataManager";
                                str2 = " addInstalledData close e" + e6;
                                com.kwad.sdk.core.d.a.a(str, str2);
                            }
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e7) {
                                com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addInstalledData close e" + e7);
                                throw th;
                            }
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    objectOutputStream2 = objectOutputStream3;
                    if (objectOutputStream2 != null) {
                    }
                    if (objectOutputStream != null) {
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adTemplate) == null) {
            synchronized (a.class) {
                HomeApkBannerData convertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(adTemplate);
                boolean z = false;
                Iterator<HomeApkBannerData> it = this.f73408b.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(convertAdTemplateToHomeApkBannerData.appPackageName, it.next().appPackageName)) {
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    try {
                        objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f73412f));
                        try {
                            try {
                                objectOutputStream.writeObject(this.f73408b);
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
}
