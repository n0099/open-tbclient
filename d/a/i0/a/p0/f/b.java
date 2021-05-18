package d.a.i0.a.p0.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.a1.e;
import d.a.i0.a.e0.d;
import d.a.i0.a.k2.g.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final File f43850a = e.q();

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f43851b = "rMzurs3ur83vsM7vss/vtNHwt9LwuNPx".getBytes(StandardCharsets.UTF_8);

    /* loaded from: classes2.dex */
    public static class a implements e.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43852a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43853b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43854c;

        public a(CallbackHandler callbackHandler, String str, String str2) {
            this.f43852a = callbackHandler;
            this.f43853b = str;
            this.f43854c = str2;
        }

        @Override // d.a.i0.a.a1.e.c
        public void a(int i2) {
        }

        @Override // d.a.i0.a.a1.e.c
        public void onFailed() {
            d.h("DebugDynamicLibControl", "debug动态库下载失败 url=" + this.f43854c);
            if (this.f43852a == null || TextUtils.isEmpty(this.f43853b)) {
                return;
            }
            this.f43852a.handleSchemeDispatchCallback(this.f43853b, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
        }

        @Override // d.a.i0.a.a1.e.c
        public void onSuccess() {
            if (this.f43852a != null && !TextUtils.isEmpty(this.f43853b)) {
                File j = b.j();
                d.h("DebugDynamicLibControl", "debug动态库下载成功 file=" + j.getAbsolutePath());
                Pair g2 = b.g(j);
                if (!((Boolean) g2.first).booleanValue()) {
                    d.h("DebugDynamicLibControl", "debug动态库解密失败 file=" + j.getAbsolutePath());
                    this.f43852a.handleSchemeDispatchCallback(this.f43853b, UnitedSchemeUtility.wrapCallbackParams(1001, "debug动态库解密失败").toString());
                    return;
                } else if (((Boolean) b.s((File) g2.second).first).booleanValue()) {
                    b.r(true);
                    this.f43852a.handleSchemeDispatchCallback(this.f43853b, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    return;
                } else {
                    d.h("DebugDynamicLibControl", "debug动态库解压失败 file=" + j.getAbsolutePath());
                    this.f43852a.handleSchemeDispatchCallback(this.f43853b, UnitedSchemeUtility.wrapCallbackParams(1001, "debug动态库解压失败").toString());
                    return;
                }
            }
            d.h("DebugDynamicLibControl", "debug动态库下载成功，但是 handler=" + this.f43852a + " cb=" + this.f43853b);
        }
    }

    public static File d(String str) {
        return new File(f43850a.getAbsolutePath() + File.separator + str + File.separator + "debug");
    }

    public static void e() {
        d.a.i0.t.d.i(j());
        d.a.i0.t.d.i(k());
        for (File file : n()) {
            d.a.i0.t.d.i(file);
        }
    }

    public static void f() {
        r(false);
        e();
    }

    public static Pair<Boolean, File> g(File file) {
        if (file != null && file.exists()) {
            File file2 = new File(file.getAbsolutePath() + ".zip");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[16];
                fileInputStream.skip(10L);
                fileInputStream.read(bArr, 0, 10);
                fileInputStream.skip(5L);
                fileInputStream.read(bArr, 10, 6);
                fileInputStream.skip(3L);
                byte[] bArr2 = new byte[fileInputStream.available()];
                fileInputStream.read(bArr2);
                file2.deleteOnExit();
                file2.createNewFile();
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                SecretKeySpec secretKeySpec = new SecretKeySpec(f43851b, "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, ivParameterSpec);
                fileOutputStream.write(cipher.doFinal(bArr2));
                fileOutputStream.flush();
                Pair<Boolean, File> pair = new Pair<>(Boolean.TRUE, file2);
                fileOutputStream.close();
                fileInputStream.close();
                return pair;
            } catch (Exception e2) {
                d.i("DebugDynamicLibControl", "debug动态库解密失败: ", e2);
                return new Pair<>(Boolean.FALSE, null);
            }
        }
        return new Pair<>(Boolean.FALSE, null);
    }

    public static synchronized void h(@NonNull String str, @Nullable CallbackHandler callbackHandler, @Nullable String str2) {
        synchronized (b.class) {
            if (TextUtils.isEmpty(str)) {
                d.h("DebugDynamicLibControl", "download url is empty");
            } else {
                e.F(str, new a(callbackHandler, str2, str));
            }
        }
    }

    public static Pair<Boolean, File> i(String str) {
        File d2 = d(str);
        if (d2.exists() && d2.isDirectory()) {
            return new Pair<>(Boolean.TRUE, d2);
        }
        return new Pair<>(Boolean.FALSE, null);
    }

    public static File j() {
        return new File(d.a.i0.a.f1.c.a.d().get(0).f45247a, "debugDynamicLib.zip");
    }

    public static File k() {
        return new File(d.a.i0.a.f1.c.a.d().get(0).f45247a, "aiapps_debug_dynamic_lib");
    }

    public static boolean l() {
        return h.a().getBoolean("KEY_SWAN_APP_DEBUG_DYNAMIC_LIB_MODE", false);
    }

    public static boolean m() {
        return l();
    }

    public static List<File> n() {
        File[] B;
        ArrayList arrayList = new ArrayList();
        for (File file : d.a.i0.t.d.B(f43850a)) {
            if (file.isDirectory()) {
                File[] B2 = d.a.i0.t.d.B(file);
                int length = B2.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        File file2 = B2[i2];
                        if (file2.isDirectory() && "debug".equals(file2.getName())) {
                            arrayList.add(file2);
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public static List<String> o() {
        File[] B;
        ArrayList arrayList = new ArrayList();
        for (File file : d.a.i0.t.d.B(f43850a)) {
            if (file.isDirectory()) {
                File[] B2 = d.a.i0.t.d.B(file);
                int length = B2.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        File file2 = B2[i2];
                        if (file2.isDirectory() && "debug".equals(file2.getName())) {
                            arrayList.add(file.getName());
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        return arrayList;
    }

    public static void p() {
        r(true);
    }

    public static String q(File file) throws Exception {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length == 1 && listFiles[0].isDirectory()) {
            d.a.i0.t.d.e(listFiles[0], file);
            d.a.i0.t.d.i(listFiles[0]);
        }
        return (String) new JSONObject(d.a.i0.t.d.D(new File(file, "dynamicLib.json"))).get("name");
    }

    public static void r(boolean z) {
        h.a().putBoolean("KEY_SWAN_APP_DEBUG_DYNAMIC_LIB_MODE", z);
    }

    public static Pair<Boolean, String> s(File file) {
        String str = "";
        boolean z = false;
        try {
            File k = k();
            d.a.i0.t.d.k(k);
            if (file.exists() && d.a.i0.t.d.T(file.getAbsolutePath(), k.getAbsolutePath())) {
                str = q(k);
                File d2 = d(str);
                if (d2.exists()) {
                    d.a.i0.t.d.i(d2);
                }
                d2.mkdirs();
                d.a.i0.t.d.e(k, d2);
                d.a.i0.t.d.i(k);
                d.a.i0.t.d.i(file);
                z = true;
            }
        } catch (Exception e2) {
            d.h("DebugDynamicLibControl", "debug动态库解压异常: " + e2.toString());
        }
        d.h("DebugDynamicLibControl", "debug动态库解压结果: unzipSuccess=" + z + " dynamicLibName=" + str);
        return new Pair<>(Boolean.valueOf(z), str);
    }
}
