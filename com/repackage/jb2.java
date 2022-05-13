package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qj2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements qj2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
        }

        @Override // com.repackage.qj2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.repackage.qj2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ux1.k("DebugDependencyControl", "debug扩展库下载失败 url=" + this.c);
                if (this.a == null || TextUtils.isEmpty(this.b)) {
                    return;
                }
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // com.repackage.qj2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a != null && !TextUtils.isEmpty(this.b)) {
                    File j = jb2.j();
                    ux1.k("DebugDependencyControl", "debug扩展库下载成功 file=" + j.getAbsolutePath());
                    Pair d = jb2.d(j);
                    if (((Boolean) d.first).booleanValue()) {
                        if (!jb2.o((File) d.second)) {
                            ux1.k("DebugDependencyControl", "debug扩展库解压失败 file=" + j.getAbsolutePath());
                            this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, "debug扩展库解压失败").toString());
                            return;
                        }
                        jb2.n(true);
                        this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                        return;
                    }
                    ux1.k("DebugDependencyControl", "debug扩展库解密失败 file=" + j.getAbsolutePath());
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, "debug扩展库解密失败").toString());
                    return;
                }
                ux1.k("DebugDependencyControl", "debug扩展库下载成功 handler=" + this.a + " cb=" + this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755594505, "Lcom/repackage/jb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755594505, "Lcom/repackage/jb2;");
                return;
            }
        }
        a = "190d49fefe87b97c6b8adeebd11fc227".getBytes(StandardCharsets.UTF_8);
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            for (File file : l()) {
                xg4.j(file);
            }
        }
    }

    public static Pair<Boolean, File> d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            if (file != null && file.exists()) {
                File g = g();
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(g);
                    byte[] bArr = new byte[16];
                    fileInputStream.skip(10L);
                    fileInputStream.read(bArr, 0, 10);
                    fileInputStream.skip(5L);
                    fileInputStream.read(bArr, 10, 6);
                    fileInputStream.skip(3L);
                    byte[] bArr2 = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr2);
                    g.deleteOnExit();
                    g.createNewFile();
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(a, "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(2, secretKeySpec, ivParameterSpec);
                    fileOutputStream.write(cipher.doFinal(bArr2));
                    fileOutputStream.flush();
                    xg4.L(file);
                    Pair<Boolean, File> pair = new Pair<>(Boolean.TRUE, g);
                    fileOutputStream.close();
                    fileInputStream.close();
                    return pair;
                } catch (Exception e) {
                    ux1.l("DebugDependencyControl", "debug扩展库解密失败: ", e);
                    return new Pair<>(Boolean.FALSE, null);
                }
            }
            return new Pair<>(Boolean.FALSE, null);
        }
        return (Pair) invokeL.objValue;
    }

    public static synchronized void e(@NonNull String str, @Nullable CallbackHandler callbackHandler, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, callbackHandler, str2) == null) {
            synchronized (jb2.class) {
                if (TextUtils.isEmpty(str)) {
                    ux1.k("DebugDependencyControl", "download url is empty");
                } else {
                    qj2.G(str, new a(callbackHandler, str2, str));
                }
            }
        }
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? qj2.r() : (String) invokeV.objValue;
    }

    public static File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new File(f(), "dependency_decrypt.zip") : (File) invokeV.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return f() + File.separator + str + File.separator + "debug_dependency";
        }
        return (String) invokeL.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return f() + File.separator + "temp_unzip";
        }
        return (String) invokeV.objValue;
    }

    public static File j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? new File(f(), "dependency.zip") : (File) invokeV.objValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? i93.a().getBoolean("debugDependency", false) : invokeV.booleanValue;
    }

    @NonNull
    public static List<File> l() {
        InterceptResult invokeV;
        File[] C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (File file : xg4.C(new File(f()))) {
                if (file.isDirectory()) {
                    File[] C2 = xg4.C(file);
                    int length = C2.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            File file2 = C2[i];
                            if (file2.isDirectory() && "debug_dependency".equals(file2.getName())) {
                                arrayList.add(file2);
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static String m(@NonNull File file) {
        InterceptResult invokeL;
        String str;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, file)) == null) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length == 1 && listFiles[0].isDirectory()) {
                xg4.e(listFiles[0], file);
                xg4.L(listFiles[0]);
            }
            try {
                str = new JSONObject(xg4.E(new File(file, "swan-package.json"))).getString("name");
            } catch (JSONException e) {
                e.printStackTrace();
                str = "";
            }
            return TextUtils.isEmpty(str) ? "unknown" : str;
        }
        return (String) invokeL.objValue;
    }

    public static void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            i93.a().putBoolean("debugDependency", z);
        }
    }

    public static boolean o(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, file)) == null) {
            boolean z = false;
            if (file != null && file.exists()) {
                File file2 = new File(i());
                xg4.l(file2);
                if (xg4.U(file.getAbsolutePath(), file2.getAbsolutePath())) {
                    File file3 = new File(h(m(file2)));
                    if (file3.exists()) {
                        xg4.L(file3);
                    }
                    file3.mkdirs();
                    xg4.e(file2, file3);
                    xg4.L(file2);
                    xg4.L(file);
                    z = true;
                }
                ux1.k("DebugDependencyControl", "debug扩展库解压结果: unzipSuccess=" + z);
                return z;
            }
            ux1.k("DebugDependencyControl", "debug扩展库压缩包不存在");
            return false;
        }
        return invokeL.booleanValue;
    }
}
