package com.ss.android.downloadlib.addownload.b;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.yy.hiidostatis.inner.FlushManager;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d a;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f61216c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f61217d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<a> f61218b;

    /* renamed from: com.ss.android.downloadlib.addownload.b.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final int f61219b;

        /* renamed from: c  reason: collision with root package name */
        public final String f61220c;

        /* renamed from: d  reason: collision with root package name */
        public final String f61221d;

        /* renamed from: e  reason: collision with root package name */
        public final long f61222e;

        public /* synthetic */ a(String str, int i2, String str2, String str3, long j2, AnonymousClass1 anonymousClass1) {
            this(str, i2, str2, str3, j2);
        }

        public a(String str, int i2, String str2, String str3, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f61219b = i2;
            this.f61220c = str2 != null ? str2.toLowerCase() : null;
            this.f61221d = str3 != null ? str3.toLowerCase() : null;
            this.f61222e = j2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1166678977, "Lcom/ss/android/downloadlib/addownload/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1166678977, "Lcom/ss/android/downloadlib/addownload/b/d;");
                return;
            }
        }
        f61216c = new String[]{"com", "android", "ss"};
        f61217d = new int[]{3101, 3102, 3103, 3201, 3202, 3203};
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61218b = new LinkedList<>();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (d.class) {
                    if (a == null) {
                        a = new d();
                    }
                }
            }
            return a;
        }
        return (d) invokeV.objValue;
    }

    private a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            try {
                PackageManager packageManager = j.getContext().getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo != null) {
                    return new a(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis(), null);
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            b();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (this.f61218b) {
                Iterator<a> it = this.f61218b.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().a)) {
                        it.remove();
                        return;
                    }
                }
            }
        }
    }

    public void a(String str) {
        a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            b();
            if (TextUtils.isEmpty(str) || (c2 = c(str)) == null) {
                return;
            }
            synchronized (this.f61218b) {
                this.f61218b.add(c2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x009a, code lost:
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<a, Integer> b(com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeL;
        int i2;
        a next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            try {
                b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.f61218b.isEmpty()) {
                return null;
            }
            String N = bVar.N();
            String e2 = bVar.e();
            String J = bVar.J();
            int I = bVar.I();
            int length = f61217d.length;
            a[] aVarArr = new a[length];
            synchronized (this.f61218b) {
                Iterator<a> it = this.f61218b.iterator();
                PackageInfo packageInfo = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    if (next.f61222e >= bVar.C()) {
                        if (TextUtils.isEmpty(N)) {
                            if (packageInfo == null) {
                                packageInfo = l.a(bVar);
                            }
                            if (packageInfo != null) {
                                try {
                                    N = (String) j.getContext().getPackageManager().getApplicationLabel(packageInfo.applicationInfo);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(N) && !TextUtils.isEmpty(next.f61221d)) {
                            N = N.toLowerCase();
                            if (N.equals(next.f61221d)) {
                                aVarArr[0] = next;
                                break;
                            } else if (N.contains(next.f61221d) || next.f61221d.contains(N)) {
                                break;
                            }
                        }
                        if (TextUtils.isEmpty(e2)) {
                            if (packageInfo == null) {
                                packageInfo = l.a(bVar);
                            }
                            if (packageInfo != null) {
                                e2 = packageInfo.packageName;
                            }
                        }
                        if (!TextUtils.isEmpty(e2) && !TextUtils.isEmpty(next.a)) {
                            e2 = e2.toLowerCase();
                            if (e2.contains(next.a) || next.a.contains(e2)) {
                                break;
                            } else if (aVarArr[3] == null) {
                                if (a(e2, next.a)) {
                                    aVarArr[3] = next;
                                }
                            }
                        }
                        if (aVarArr[4] == null) {
                            if (TextUtils.isEmpty(J)) {
                                if (packageInfo == null) {
                                    packageInfo = l.a(bVar);
                                }
                                if (packageInfo != null) {
                                    J = packageInfo.versionName;
                                }
                            }
                            if (!TextUtils.isEmpty(J) && !TextUtils.isEmpty(next.f61220c)) {
                                J = J.toLowerCase();
                                if (J.equals(next.f61220c)) {
                                    aVarArr[4] = next;
                                }
                            }
                            if (aVarArr[5] == null) {
                                if (I <= 0) {
                                    if (packageInfo == null) {
                                        packageInfo = l.a(bVar);
                                    }
                                    if (packageInfo != null) {
                                        I = packageInfo.versionCode;
                                    }
                                }
                                if (I == next.f61219b) {
                                    aVarArr[5] = next;
                                }
                            }
                        }
                    }
                }
                aVarArr[2] = next;
            }
            for (i2 = 0; i2 < length; i2++) {
                if (aVarArr[i2] != null) {
                    return new Pair<>(aVarArr[i2], Integer.valueOf(f61217d[i2]));
                }
            }
            return null;
        }
        return (Pair) invokeL.objValue;
    }

    public a a(com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            b();
            synchronized (this.f61218b) {
                Iterator<a> it = this.f61218b.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.f61222e > bVar.C()) {
                        return next;
                    }
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        String[] split;
        String[] split2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            try {
                split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (split.length != 0 && split2.length != 0) {
                int i2 = 0;
                int i3 = 0;
                for (String str3 : split) {
                    String[] strArr = f61216c;
                    int length = strArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            z = false;
                            break;
                        }
                        String str4 = strArr[i4];
                        if (str4.equals(str3)) {
                            if (i2 < split2.length && str4.equals(split2[i2])) {
                                i2++;
                            }
                            z = true;
                        } else {
                            i4++;
                        }
                    }
                    if (!z) {
                        int i5 = i3;
                        int i6 = i2;
                        while (i2 < split2.length) {
                            if (str3.equals(split2[i2])) {
                                if (i2 == i6) {
                                    i6++;
                                }
                                i5++;
                                if (i5 >= 2) {
                                    return true;
                                }
                            }
                            i2++;
                        }
                        i2 = i6;
                        i3 = i5;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.f61218b) {
                Iterator<a> it = this.f61218b.iterator();
                while (it.hasNext() && currentTimeMillis - it.next().f61222e > FlushManager.ReportTimer.DEFAULT_INTERVAL) {
                    it.remove();
                }
            }
        }
    }
}
