package d.b.g0.t;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.webkit.sdk.SevenZipUtils;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static final String s = File.separator;
    public static final String t = ZeusWebViewPreloadClass.ZEUS_FILE_DIR + s + "libs" + s;

    /* renamed from: a  reason: collision with root package name */
    public Context f49814a;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f49821h;
    public JSONObject i;
    public int j;
    public int k;
    public Method r;

    /* renamed from: b  reason: collision with root package name */
    public int f49815b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f49816c = 0;

    /* renamed from: d  reason: collision with root package name */
    public String f49817d = null;

    /* renamed from: e  reason: collision with root package name */
    public int[] f49818e = null;

    /* renamed from: f  reason: collision with root package name */
    public int[] f49819f = null;

    /* renamed from: g  reason: collision with root package name */
    public int[] f49820g = null;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public boolean o = false;
    public String p = null;
    public boolean q = false;

    public b(Context context) {
        this.f49814a = context;
        m();
    }

    public final boolean a() {
        File file = new File(j());
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public final boolean b() {
        String j = j();
        this.p = j + SevenZipUtils.FILE_NAME_TEMP;
        File file = new File(this.p);
        if (file.exists()) {
            return d(file);
        }
        return file.mkdirs();
    }

    public final boolean c() {
        int i;
        int i2 = this.f49815b;
        if (i2 <= 0 || (i = this.f49816c) <= 0) {
            return true;
        }
        String str = this.f49817d;
        int[] iArr = this.f49818e;
        int[] iArr2 = this.f49819f;
        int[] iArr3 = this.f49820g;
        if (!this.o) {
            this.j = 0;
            this.k = i;
        }
        String str2 = j() + "libzeuswebviewchromium.so";
        String str3 = j() + "libzeuswebviewchromium.so.tmp";
        int g2 = g(this.p, str3, this.f49816c, this.j, this.k, this.o ? 1 : 0);
        if (g2 != 0) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            e(null, str, iArr2[i3], iArr[i3], iArr3[i3]);
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

    public final boolean d(File file) {
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

    public final void e(AssetManager assetManager, String str, int i, int i2, int i3) {
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
            this.r.invoke(sevenZipUtils, assetManager, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        } catch (Exception unused2) {
        }
    }

    public final int f(int i, boolean z) {
        SevenZipUtils sevenZipUtils = SevenZipUtils.getInstance();
        try {
            Method declaredMethod = SevenZipUtils.class.getDeclaredMethod("doHook", Integer.TYPE, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(sevenZipUtils, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public final int g(String str, String str2, int i, int i2, int i3, int i4) {
        SevenZipUtils sevenZipUtils = SevenZipUtils.getInstance();
        try {
            Method declaredMethod = SevenZipUtils.class.getDeclaredMethod("init", String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(sevenZipUtils, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4))).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public final int h() {
        SevenZipUtils sevenZipUtils = SevenZipUtils.getInstance();
        try {
            Method declaredMethod = SevenZipUtils.class.getDeclaredMethod("submit", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(sevenZipUtils, new Object[0])).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public final boolean i() {
        FileInputStream fileInputStream;
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
                this.f49821h = new JSONObject(str.substring(this.l, this.m - 2));
                JSONObject jSONObject = new JSONObject(str.substring(this.m, this.n - 2));
                this.i = jSONObject;
                int i = Integer.MAX_VALUE;
                JSONArray jSONArray = jSONObject.getJSONArray(SevenZipUtils.LZMA_META_KEY_LOADABLE);
                int i2 = 0;
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    int i4 = jSONObject2.getInt(SevenZipUtils.LZMA_META_KEY_VADDR);
                    int i5 = jSONObject2.getInt(SevenZipUtils.LZMA_META_KEY_MEMSZ);
                    if (i4 < i) {
                        i = i4;
                    }
                    int i6 = i4 + i5;
                    if (i6 > i2) {
                        i2 = i6;
                    }
                }
                this.j = i;
                this.k = i2;
                int i7 = this.f49821h.getInt("count");
                this.f49815b = i7;
                this.f49818e = new int[i7];
                this.f49819f = new int[i7];
                this.f49820g = new int[i7];
                this.f49817d = k();
                JSONArray jSONArray2 = this.f49821h.getJSONArray(SevenZipUtils.LZMA_META_KEY_OFFSET);
                JSONArray jSONArray3 = this.f49821h.getJSONArray(SevenZipUtils.LZMA_META_KEY_SZ_OFFSET);
                this.f49819f[0] = 0;
                for (int i8 = 0; i8 < this.f49815b; i8++) {
                    this.f49818e[i8] = jSONArray2.getInt(i8);
                    if (i8 > 0) {
                        int i9 = i8 - 1;
                        this.f49819f[i8] = this.f49819f[i9] + this.f49818e[i9];
                    }
                    this.f49820g[i8] = jSONArray3.getInt(i8) + this.n;
                }
                this.f49816c = this.f49821h.getInt("total");
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

    public final String j() {
        return this.f49814a.getFilesDir() + s + t;
    }

    public final String k() {
        return j() + s + "libzeuswebviewchromium.so";
    }

    public final void l(boolean z) {
        if (!z || (this.j == 0 && !n())) {
            try {
                if (f(Build.VERSION.SDK_INT, z) > 0) {
                    this.o = true;
                }
            } catch (UnsatisfiedLinkError unused) {
            }
        }
    }

    public final void m() {
        try {
            System.load(j() + "libzeuslzma.so");
            this.q = true;
        } catch (Throwable unused) {
        }
    }

    public final boolean n() {
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

    public final boolean o(long j) {
        long blockSize;
        long availableBlocks;
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

    public final boolean p() {
        try {
            byte[] bArr = new byte[64];
            new FileInputStream(k()).read(bArr);
            return new String(bArr, "UTF-8").startsWith("zeusmeta");
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean q() {
        if (p()) {
            if (this.q && i() && o(this.f49816c)) {
                l(false);
                return a() && b() && c();
            }
            return false;
        }
        return true;
    }
}
