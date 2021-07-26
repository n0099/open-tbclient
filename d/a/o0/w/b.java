package d.a.o0.w;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final String s;
    public static final String t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f51712a;

    /* renamed from: b  reason: collision with root package name */
    public int f51713b;

    /* renamed from: c  reason: collision with root package name */
    public int f51714c;

    /* renamed from: d  reason: collision with root package name */
    public String f51715d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f51716e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f51717f;

    /* renamed from: g  reason: collision with root package name */
    public int[] f51718g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f51719h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f51720i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public String p;
    public boolean q;
    public Method r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-799182598, "Ld/a/o0/w/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-799182598, "Ld/a/o0/w/b;");
                return;
            }
        }
        s = File.separator;
        t = ZeusWebViewPreloadClass.ZEUS_FILE_DIR + s + "libs" + s;
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51713b = 0;
        this.f51714c = 0;
        this.f51715d = null;
        this.f51716e = null;
        this.f51717f = null;
        this.f51718g = null;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.p = null;
        this.q = false;
        this.f51712a = context;
        m();
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            File file = new File(j());
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        }
        return invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String j = j();
            this.p = j + SevenZipUtils.FILE_NAME_TEMP;
            File file = new File(this.p);
            if (file.exists()) {
                return d(file);
            }
            return file.mkdirs();
        }
        return invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i3 = this.f51713b;
            if (i3 <= 0 || (i2 = this.f51714c) <= 0) {
                return true;
            }
            String str = this.f51715d;
            int[] iArr = this.f51716e;
            int[] iArr2 = this.f51717f;
            int[] iArr3 = this.f51718g;
            if (!this.o) {
                this.j = 0;
                this.k = i2;
            }
            String str2 = j() + "libzeuswebviewchromium.so";
            String str3 = j() + "libzeuswebviewchromium.so.tmp";
            int g2 = g(this.p, str3, this.f51714c, this.j, this.k, this.o ? 1 : 0);
            if (g2 != 0) {
                return false;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                e(null, str, iArr2[i4], iArr[i4], iArr3[i4]);
            }
            if (!this.o) {
                g2 = h();
            }
            File file = new File(str3);
            File file2 = new File(str2);
            if (file2.exists()) {
                file2.delete();
            }
            if (file.renameTo(file2)) {
                d(new File(this.p));
                return g2 == 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, file)) == null) {
            if (file == null) {
                return false;
            }
            if (file.isDirectory()) {
                for (String str : file.list()) {
                    if (!d(new File(file, str))) {
                        return false;
                    }
                }
            }
            if (file.exists()) {
                return file.delete();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void e(AssetManager assetManager, String str, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{assetManager, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            SevenZipUtils sevenZipUtils = SevenZipUtils.getInstance();
            if (this.r == null) {
                try {
                    this.r = SevenZipUtils.class.getDeclaredMethod("decodeAndMerge", AssetManager.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                } catch (Exception unused) {
                }
            }
            Method method = this.r;
            if (method == null) {
                return;
            }
            try {
                method.setAccessible(true);
                this.r.invoke(sevenZipUtils, assetManager, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (Exception unused2) {
            }
        }
    }

    public final int f(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            SevenZipUtils sevenZipUtils = SevenZipUtils.getInstance();
            try {
                Method declaredMethod = SevenZipUtils.class.getDeclaredMethod("doHook", Integer.TYPE, Boolean.TYPE);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(sevenZipUtils, Integer.valueOf(i2), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeCommon.intValue;
    }

    public final int g(String str, String str2, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            SevenZipUtils sevenZipUtils = SevenZipUtils.getInstance();
            try {
                Method declaredMethod = SevenZipUtils.class.getDeclaredMethod("init", String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(sevenZipUtils, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5))).intValue();
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeCommon.intValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            SevenZipUtils sevenZipUtils = SevenZipUtils.getInstance();
            try {
                Method declaredMethod = SevenZipUtils.class.getDeclaredMethod("submit", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(sevenZipUtils, new Object[0])).intValue();
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String k = k();
            if (new File(k).exists()) {
                FileInputStream fileInputStream2 = null;
                try {
                    fileInputStream = new FileInputStream(k);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[512];
                    fileInputStream.read(bArr);
                    String str = new String(bArr, "UTF-8");
                    int indexOf = str.indexOf(SevenZipUtils.FILE_SEP) + 2;
                    this.l = indexOf;
                    int indexOf2 = str.indexOf(SevenZipUtils.FILE_SEP, indexOf) + 2;
                    this.m = indexOf2;
                    this.n = str.indexOf(SevenZipUtils.FILE_SEP, indexOf2) + 2;
                    this.f51719h = new JSONObject(str.substring(this.l, this.m - 2));
                    JSONObject jSONObject = new JSONObject(str.substring(this.m, this.n - 2));
                    this.f51720i = jSONObject;
                    int i2 = Integer.MAX_VALUE;
                    JSONArray jSONArray = jSONObject.getJSONArray(SevenZipUtils.LZMA_META_KEY_LOADABLE);
                    int i3 = 0;
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                        int i5 = jSONObject2.getInt(SevenZipUtils.LZMA_META_KEY_VADDR);
                        int i6 = jSONObject2.getInt(SevenZipUtils.LZMA_META_KEY_MEMSZ);
                        if (i5 < i2) {
                            i2 = i5;
                        }
                        int i7 = i5 + i6;
                        if (i7 > i3) {
                            i3 = i7;
                        }
                    }
                    this.j = i2;
                    this.k = i3;
                    int i8 = this.f51719h.getInt("count");
                    this.f51713b = i8;
                    this.f51716e = new int[i8];
                    this.f51717f = new int[i8];
                    this.f51718g = new int[i8];
                    this.f51715d = k();
                    JSONArray jSONArray2 = this.f51719h.getJSONArray(SevenZipUtils.LZMA_META_KEY_OFFSET);
                    JSONArray jSONArray3 = this.f51719h.getJSONArray(SevenZipUtils.LZMA_META_KEY_SZ_OFFSET);
                    this.f51717f[0] = 0;
                    for (int i9 = 0; i9 < this.f51713b; i9++) {
                        this.f51716e[i9] = jSONArray2.getInt(i9);
                        if (i9 > 0) {
                            int i10 = i9 - 1;
                            this.f51717f[i9] = this.f51717f[i10] + this.f51716e[i10];
                        }
                        this.f51718g[i9] = jSONArray3.getInt(i9) + this.n;
                    }
                    this.f51714c = this.f51719h.getInt("total");
                    try {
                        fileInputStream.close();
                        return true;
                    } catch (Exception unused2) {
                        return true;
                    }
                } catch (Exception unused3) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused4) {
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused5) {
                        }
                    }
                    throw th;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f51712a.getFilesDir() + s + t;
        }
        return (String) invokeV.objValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return j() + s + "libzeuswebviewchromium.so";
        }
        return (String) invokeV.objValue;
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (!z || (this.j == 0 && !n())) {
                try {
                    if (f(Build.VERSION.SDK_INT, z) > 0) {
                        this.o = true;
                    }
                } catch (UnsatisfiedLinkError unused) {
                }
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                System.load(j() + "libzeuslzma.so");
                this.q = true;
            } catch (Throwable unused) {
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String property = System.getProperty("os.arch");
            if (TextUtils.isEmpty(property) || !property.endsWith(WebKitFactory.OS_64)) {
                try {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    String str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.product.cpu.abilist64", "");
                    if (str != null) {
                        if (!str.isEmpty()) {
                            return true;
                        }
                    }
                } catch (Exception unused) {
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean o(long j) {
        InterceptResult invokeJ;
        long blockSize;
        long availableBlocks;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                if (Build.VERSION.SDK_INT >= 18) {
                    blockSize = statFs.getBlockSizeLong();
                    availableBlocks = statFs.getAvailableBlocksLong();
                } else {
                    blockSize = statFs.getBlockSize();
                    availableBlocks = statFs.getAvailableBlocks();
                }
                return blockSize * availableBlocks > j;
            } catch (Exception unused) {
                return true;
            }
        }
        return invokeJ.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            try {
                byte[] bArr = new byte[64];
                new FileInputStream(k()).read(bArr);
                return new String(bArr, "UTF-8").startsWith("zeusmeta");
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (p()) {
                if (this.q && i() && o(this.f51714c)) {
                    l(false);
                    return a() && b() && c();
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
