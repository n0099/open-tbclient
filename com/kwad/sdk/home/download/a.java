package com.kwad.sdk.home.download;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Stack<HomeApkBannerData> f38449a;

    /* renamed from: b  reason: collision with root package name */
    public Stack<HomeApkBannerData> f38450b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f38451c;

    /* renamed from: d  reason: collision with root package name */
    public String f38452d;

    /* renamed from: e  reason: collision with root package name */
    public File f38453e;

    /* renamed from: f  reason: collision with root package name */
    public File f38454f;

    /* renamed from: g  reason: collision with root package name */
    public File f38455g;

    /* renamed from: h  reason: collision with root package name */
    public File f38456h;

    /* renamed from: i  reason: collision with root package name */
    public File f38457i;
    public int j;
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
        this.f38449a = new Stack<>();
        this.f38450b = new Stack<>();
        this.f38451c = new HashMap();
        this.j = 0;
        this.k = false;
        this.f38452d = ad.d(KsAdSDKImpl.get().getContext());
        File file = new File(this.f38452d);
        if (!file.exists()) {
            file.mkdir();
        }
        this.f38453e = new File(this.f38452d + File.separator + "download_uninstall");
        File file2 = new File(this.f38452d + File.separator + "download_uninstall_apk_data");
        this.f38455g = file2;
        if (!file2.exists()) {
            this.f38455g.mkdir();
        }
        File file3 = new File(this.f38452d + File.separator + "install_unopen_apk_data");
        this.f38456h = file3;
        if (!file3.exists()) {
            this.f38456h.mkdir();
        }
        this.f38454f = new File(this.f38452d + File.separator + "install_unopen");
        this.f38457i = new File(this.f38452d + File.separator + "app_has_show_banner_counts");
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

    private File b(HomeApkBannerData homeApkBannerData, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, this, homeApkBannerData, z)) == null) {
            String path = (z ? this.f38455g : this.f38456h).getPath();
            return new File(path + File.separator + homeApkBannerData.mAdTemplateUniqueId);
        }
        return (File) invokeLZ.objValue;
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) ? !TextUtils.isEmpty(str) && new File(str).exists() : invokeL.booleanValue;
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
                this.f38449a.push(convertAdTemplateToHomeApkBannerData);
                ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new FileOutputStream(this.f38453e));
                try {
                    objectOutputStream3.writeObject(this.f38449a);
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(b(convertAdTemplateToHomeApkBannerData, true)));
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

    /* JADX WARN: Removed duplicated region for block: B:59:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e2;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (a.class) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                int i2 = 1;
                this.j++;
                Integer num = this.f38451c.get(str);
                if (num != null) {
                    i2 = 1 + num.intValue();
                }
                this.f38451c.put(str, Integer.valueOf(i2));
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f38457i));
                    try {
                        try {
                            objectOutputStream.writeObject(this.f38451c);
                        } catch (Exception e3) {
                            e2 = e3;
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " addAppShowCount e" + e2);
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception e4) {
                                    str2 = "HomeApkBannerDataManager";
                                    str3 = " addAppShowCount close e" + e4;
                                    com.kwad.sdk.core.d.a.a(str2, str3);
                                }
                            }
                        }
                        try {
                            objectOutputStream.close();
                        } catch (Exception e5) {
                            str2 = "HomeApkBannerDataManager";
                            str3 = " addAppShowCount close e" + e5;
                            com.kwad.sdk.core.d.a.a(str2, str3);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
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
                    objectOutputStream = null;
                    th = th3;
                    if (objectOutputStream != null) {
                    }
                    throw th;
                }
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.k = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b3 A[Catch: all -> 0x0100, TryCatch #1 {, blocks: (B:6:0x0007, B:8:0x0012, B:11:0x0016, B:13:0x0018, B:15:0x0020, B:17:0x0022, B:19:0x002c, B:25:0x0038, B:29:0x0053, B:47:0x00a9, B:51:0x00bf, B:53:0x00c7, B:56:0x00cb, B:58:0x00de, B:57:0x00d2, B:50:0x00b3, B:32:0x0058, B:33:0x006b, B:43:0x0090, B:46:0x0095, B:63:0x00e4, B:67:0x00ff, B:66:0x00e9), top: B:78:0x0007, inners: #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c7 A[Catch: all -> 0x0100, DONT_GENERATE, TryCatch #1 {, blocks: (B:6:0x0007, B:8:0x0012, B:11:0x0016, B:13:0x0018, B:15:0x0020, B:17:0x0022, B:19:0x002c, B:25:0x0038, B:29:0x0053, B:47:0x00a9, B:51:0x00bf, B:53:0x00c7, B:56:0x00cb, B:58:0x00de, B:57:0x00d2, B:50:0x00b3, B:32:0x0058, B:33:0x006b, B:43:0x0090, B:46:0x0095, B:63:0x00e4, B:67:0x00ff, B:66:0x00e9), top: B:78:0x0007, inners: #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(HomeApkBannerData homeApkBannerData, boolean z) {
        InterceptResult invokeLZ;
        ObjectInputStream objectInputStream;
        Exception e2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, homeApkBannerData, z)) == null) {
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
                        try {
                        } catch (Throwable th) {
                            th = th;
                            objectInputStream2 = objectInputStream;
                            if (objectInputStream2 != null) {
                                try {
                                    objectInputStream2.close();
                                } catch (Exception e3) {
                                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " canShowBanner close e" + e3);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        objectInputStream = null;
                        e2 = e4;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectInputStream2 != null) {
                        }
                        throw th;
                    }
                    if (this.f38457i.exists()) {
                        this.f38451c.clear();
                        objectInputStream = new ObjectInputStream(new FileInputStream(this.f38457i));
                        try {
                            this.f38451c = (Map) objectInputStream.readObject();
                        } catch (Exception e5) {
                            e2 = e5;
                            com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " canShowBanner e" + e2);
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Exception e6) {
                                    str = "HomeApkBannerDataManager";
                                    str2 = " canShowBanner close e" + e6;
                                    com.kwad.sdk.core.d.a.a(str, str2);
                                    if ((this.f38451c.get(str3) != null ? 0 : this.f38451c.get(str3).intValue()) < c.a.ad.e()) {
                                    }
                                }
                            }
                            if ((this.f38451c.get(str3) != null ? 0 : this.f38451c.get(str3).intValue()) < c.a.ad.e()) {
                            }
                        }
                        try {
                            objectInputStream.close();
                        } catch (Exception e7) {
                            str = "HomeApkBannerDataManager";
                            str2 = " canShowBanner close e" + e7;
                            com.kwad.sdk.core.d.a.a(str, str2);
                            if ((this.f38451c.get(str3) != null ? 0 : this.f38451c.get(str3).intValue()) < c.a.ad.e()) {
                            }
                        }
                        if ((this.f38451c.get(str3) != null ? 0 : this.f38451c.get(str3).intValue()) < c.a.ad.e()) {
                            return false;
                        }
                        return z ? b(homeApkBannerData.mDownloadFilePath) : y.a(KsAdSDKImpl.get().getContext(), str3);
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0097, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009a, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009e, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009f, code lost:
        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdTemplate b() {
        InterceptResult invokeV;
        ObjectInputStream objectInputStream;
        String str;
        String str2;
        Stack<HomeApkBannerData> stack;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (a.class) {
                ObjectInputStream objectInputStream2 = null;
                try {
                } catch (Exception e2) {
                    e = e2;
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                }
                if (!this.f38453e.exists()) {
                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", "getCanShowDownloadBannerData mDownloadFile is not exists");
                    return null;
                }
                this.f38449a.clear();
                ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream(this.f38453e));
                try {
                    stack = (Stack) objectInputStream3.readObject();
                    this.f38449a = stack;
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
                        objectInputStream3.close();
                    } catch (Exception e6) {
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e6);
                    }
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Stack stack2 = (Stack) this.f38449a.clone();
                while (true) {
                    if (!stack2.isEmpty()) {
                        HomeApkBannerData homeApkBannerData = (HomeApkBannerData) stack2.pop();
                        if (homeApkBannerData != null) {
                            if (currentTimeMillis - homeApkBannerData.mTimeStamp > 604800000) {
                                break;
                            } else if (a(homeApkBannerData, true)) {
                                ObjectInputStream objectInputStream4 = new ObjectInputStream(new FileInputStream(b(homeApkBannerData, true)));
                                try {
                                    adTemplate = (AdTemplate) objectInputStream4.readObject();
                                    break;
                                } catch (Exception e7) {
                                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowDownloadBannerData get adTemplate e" + e7);
                                    objectInputStream4.close();
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                try {
                    objectInputStream3.close();
                    break;
                } catch (Exception e8) {
                    str = "HomeApkBannerDataManager";
                    str2 = " getCanShowInstalledBannerData finally e" + e8;
                    com.kwad.sdk.core.d.a.a(str, str2);
                    return null;
                }
                return null;
            }
        }
        return (AdTemplate) invokeV.objValue;
        return adTemplate;
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
        if (interceptable == null || interceptable.invokeL(1048581, this, adTemplate) == null) {
            synchronized (a.class) {
                HomeApkBannerData convertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(adTemplate);
                if (convertAdTemplateToHomeApkBannerData == null) {
                    return;
                }
                ?? r1 = 0;
                Iterator<HomeApkBannerData> it = this.f38449a.iterator();
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
                        objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f38453e));
                        try {
                            objectOutputStream.writeObject(this.f38449a);
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

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0097, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009a, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009e, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009f, code lost:
        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdTemplate c() {
        InterceptResult invokeV;
        ObjectInputStream objectInputStream;
        String str;
        String str2;
        Stack<HomeApkBannerData> stack;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (a.class) {
                ObjectInputStream objectInputStream2 = null;
                try {
                } catch (Exception e2) {
                    e = e2;
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                }
                if (!this.f38454f.exists()) {
                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", "getCanShowInstalledBannerData mInstallFile is not exists");
                    return null;
                }
                this.f38450b.clear();
                ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream(this.f38454f));
                try {
                    stack = (Stack) objectInputStream3.readObject();
                    this.f38450b = stack;
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
                        objectInputStream3.close();
                    } catch (Exception e6) {
                        com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData finally e" + e6);
                    }
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Stack stack2 = (Stack) this.f38450b.clone();
                while (true) {
                    if (!stack2.isEmpty()) {
                        HomeApkBannerData homeApkBannerData = (HomeApkBannerData) stack2.pop();
                        if (homeApkBannerData != null) {
                            if (currentTimeMillis - homeApkBannerData.mTimeStamp > 604800000) {
                                break;
                            } else if (a(homeApkBannerData, false)) {
                                ObjectInputStream objectInputStream4 = new ObjectInputStream(new FileInputStream(b(homeApkBannerData, false)));
                                try {
                                    adTemplate = (AdTemplate) objectInputStream4.readObject();
                                    break;
                                } catch (Exception e7) {
                                    com.kwad.sdk.core.d.a.a("HomeApkBannerDataManager", " getCanShowInstalledBannerData get adTemplate e" + e7);
                                    objectInputStream4.close();
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                try {
                    objectInputStream3.close();
                    break;
                } catch (Exception e8) {
                    str = "HomeApkBannerDataManager";
                    str2 = " getCanShowInstalledBannerData finally e" + e8;
                    com.kwad.sdk.core.d.a.a(str, str2);
                    return null;
                }
                return null;
            }
        }
        return (AdTemplate) invokeV.objValue;
        return adTemplate;
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
        if (interceptable == null || interceptable.invokeL(1048583, this, adTemplate) == null) {
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
                this.f38450b.push(convertAdTemplateToHomeApkBannerData);
                ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new FileOutputStream(this.f38454f));
                try {
                    objectOutputStream3.writeObject(this.f38450b);
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(b(convertAdTemplateToHomeApkBannerData, false)));
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

    /* JADX WARN: Removed duplicated region for block: B:101:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d2 A[Catch: all -> 0x017c, TryCatch #13 {, blocks: (B:6:0x0007, B:7:0x0013, B:9:0x001d, B:11:0x002b, B:13:0x0038, B:19:0x0051, B:22:0x0057, B:23:0x006a, B:33:0x008c, B:36:0x0091, B:41:0x00a9, B:45:0x00c4, B:44:0x00ae, B:46:0x00c5, B:47:0x00cc, B:49:0x00d2, B:51:0x00e0, B:53:0x00ed, B:58:0x0105, B:61:0x010b, B:62:0x011e, B:79:0x015e, B:83:0x0179, B:82:0x0163, B:73:0x0143, B:76:0x0148, B:84:0x017a), top: B:108:0x0007, inners: #0, #3, #5, #8, #11, #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (a.class) {
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<HomeApkBannerData> it2 = this.f38449a.iterator();
                boolean z2 = false;
                while (it2.hasNext()) {
                    HomeApkBannerData next = it2.next();
                    if (currentTimeMillis - next.mTimeStamp > 604800000) {
                        it2.remove();
                        File b2 = b(next, true);
                        if (b2.exists()) {
                            b2.delete();
                        }
                        z2 = true;
                    }
                }
                ObjectOutputStream objectOutputStream3 = null;
                if (z2) {
                    try {
                        objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f38453e));
                        try {
                            try {
                                objectOutputStream.writeObject(this.f38449a);
                            } catch (Exception e2) {
                                e = e2;
                                com.kwad.sdk.core.d.a.d("HomeApkBannerDataManager", " cleanInvalidData needUpdateDownloadData e" + e);
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception e3) {
                                        str = "HomeApkBannerDataManager";
                                        str2 = " cleanInvalidData needUpdateDownloadData final close e" + e3;
                                        com.kwad.sdk.core.d.a.d(str, str2);
                                        it = this.f38450b.iterator();
                                        z = false;
                                        while (it.hasNext()) {
                                        }
                                        if (z) {
                                        }
                                    }
                                }
                                it = this.f38450b.iterator();
                                z = false;
                                while (it.hasNext()) {
                                }
                                if (z) {
                                }
                            }
                            try {
                                objectOutputStream.close();
                            } catch (Exception e4) {
                                str = "HomeApkBannerDataManager";
                                str2 = " cleanInvalidData needUpdateDownloadData final close e" + e4;
                                com.kwad.sdk.core.d.a.d(str, str2);
                                it = this.f38450b.iterator();
                                z = false;
                                while (it.hasNext()) {
                                }
                                if (z) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            objectOutputStream3 = objectOutputStream;
                            if (objectOutputStream3 != null) {
                                try {
                                    objectOutputStream3.close();
                                } catch (Exception e5) {
                                    com.kwad.sdk.core.d.a.d("HomeApkBannerDataManager", " cleanInvalidData needUpdateDownloadData final close e" + e5);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        objectOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectOutputStream3 != null) {
                        }
                        throw th;
                    }
                }
                it = this.f38450b.iterator();
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
                if (z) {
                    try {
                        try {
                            objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.f38454f));
                        } catch (Exception e7) {
                            e = e7;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    try {
                        objectOutputStream2.writeObject(this.f38450b);
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
                    } catch (Throwable th4) {
                        th = th4;
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
        if (interceptable == null || interceptable.invokeL(1048585, this, adTemplate) == null) {
            synchronized (a.class) {
                HomeApkBannerData convertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(adTemplate);
                boolean z = false;
                Iterator<HomeApkBannerData> it = this.f38450b.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(convertAdTemplateToHomeApkBannerData.appPackageName, it.next().appPackageName)) {
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    try {
                        objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f38454f));
                        try {
                            try {
                                objectOutputStream.writeObject(this.f38450b);
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

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : invokeV.booleanValue;
    }
}
