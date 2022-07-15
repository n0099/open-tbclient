package com.repackage;

import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class c19 implements w19 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public j29 a;
    public String b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755849914, "Lcom/repackage/c19;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755849914, "Lcom/repackage/c19;");
                return;
            }
        }
        c = d29.m();
    }

    public c19() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new j29();
        this.b = "";
    }

    @Override // com.repackage.w19
    public boolean a(JSONObject jSONObject, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? i(this.b, jSONObject, z, z2) : invokeCommon.booleanValue;
    }

    @Override // com.repackage.w19
    public boolean b(File file, long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{file, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? h(this.b, file, j, z, z2) : invokeCommon.booleanValue;
    }

    public final HashMap<String, String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>(2);
            hashMap.put("Content-type", "application/x-www-form-urlencoded");
            hashMap.put(BaseContentUploader.NB, "1");
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public final String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = d29.k(z);
            }
            return this.b;
        }
        return (String) invokeZ.objValue;
    }

    public final String e(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean isUBCDebug = this.a.isUBCDebug();
            if (TextUtils.isEmpty(str)) {
                str = d(isUBCDebug);
            }
            if (z2) {
                c2 = d29.h(str);
            } else {
                c2 = d29.c(str);
            }
            if (isUBCDebug && !TextUtils.isEmpty(c2)) {
                c2 = j39.a(c2, "debug", "1");
            }
            if (z) {
                c2 = j39.a(c2, "reallog", "1");
            }
            return i19.o().E() ? j39.a(c2, "beta", "1") : c2;
        }
        return (String) invokeCommon.objValue;
    }

    public final boolean f(g29 g29Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, g29Var)) == null) {
            if (g29Var == null) {
                return false;
            }
            if (!g29Var.e()) {
                if (c) {
                    Log.d("UploadManager", "postByteRequest, fail: " + g29Var.d());
                } else {
                    f29.a().i(g29Var.d(), null);
                }
                if (i19.o().M()) {
                    g(g29Var.c());
                }
                g29Var.a();
                return false;
            }
            try {
                int i = new JSONObject(g29Var.b()).getInt("error");
                if (i != 0) {
                    if (c) {
                        Log.d("UploadManager", "server error");
                    }
                    if (!c) {
                        f29.a().k(i);
                    }
                }
            } catch (Exception e) {
                if (c) {
                    Log.d("UploadManager", "body tostring fail:" + e.getMessage());
                } else {
                    f29.a().j(Log.getStackTraceString(e));
                }
            }
            g29Var.a();
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(int i) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048582, this, i) != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        if (i == 403 || i == 408 || i == 499) {
            j = 60000;
        } else if (i < 500 || i >= 600) {
            z = false;
            if (z) {
                return;
            }
            i19.o().Z(currentTimeMillis);
            return;
        } else {
            j = 300000;
        }
        currentTimeMillis += j;
        if (z) {
        }
    }

    public final boolean h(String str, File file, long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, file, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) != null) {
            return invokeCommon.booleanValue;
        }
        if (file == null || !file.exists()) {
            return false;
        }
        String e = e(str, z, z2);
        HashMap<String, String> c2 = c();
        if (k29.m().p() && j > 0) {
            c2.put("Content-Length", String.valueOf(j));
        }
        InputStream inputStream2 = null;
        try {
            inputStream = new BufferedInputStream(new Base64InputStream(new FileInputStream(file), 2));
            try {
                try {
                    boolean f = f(j(e, inputStream, c2));
                    e39.b(inputStream);
                    return f;
                } catch (Exception e2) {
                    e = e2;
                    if (c) {
                        Log.d("UploadManager", "postByteRequest, Exception: ", e);
                    } else {
                        f29.a().i(null, Log.getStackTraceString(e));
                    }
                    e39.b(inputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                e39.b(inputStream2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean i(String str, JSONObject jSONObject, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        byte[] a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (jSONObject != null && (a = g39.a(jSONObject.toString().getBytes())) != null && a.length >= 2) {
                a[0] = ContentUtil.GZIP_HEAD_1;
                a[1] = ContentUtil.GZIP_HEAD_2;
                String e = e(str, z, z2);
                HashMap<String, String> c2 = c();
                if (k29.m().p()) {
                    c2.put("Content-Length", String.valueOf(a.length));
                }
                try {
                    return f(k(e, a, c2));
                } catch (IOException e2) {
                    if (c) {
                        Log.d("UploadManager", "postByteRequest, Exception: ", e2);
                    } else {
                        f29.a().i(null, Log.getStackTraceString(e2));
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public abstract g29 j(String str, InputStream inputStream, Map<String, String> map) throws IOException;

    public abstract g29 k(String str, byte[] bArr, Map<String, String> map) throws IOException;
}
