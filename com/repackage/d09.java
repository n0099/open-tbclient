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
public abstract class d09 implements x09 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public k19 a;
    public String b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755821084, "Lcom/repackage/d09;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755821084, "Lcom/repackage/d09;");
                return;
            }
        }
        c = e19.m();
    }

    public d09() {
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
        this.a = new k19();
        this.b = "";
    }

    @Override // com.repackage.x09
    public boolean a(JSONObject jSONObject, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? i(this.b, jSONObject, z, z2) : invokeCommon.booleanValue;
    }

    @Override // com.repackage.x09
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
                this.b = e19.k(z);
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
                c2 = e19.h(str);
            } else {
                c2 = e19.c(str);
            }
            if (isUBCDebug && !TextUtils.isEmpty(c2)) {
                c2 = k29.a(c2, "debug", "1");
            }
            if (z) {
                c2 = k29.a(c2, "reallog", "1");
            }
            return j09.o().E() ? k29.a(c2, "beta", "1") : c2;
        }
        return (String) invokeCommon.objValue;
    }

    public final boolean f(h19 h19Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, h19Var)) == null) {
            if (h19Var == null) {
                return false;
            }
            if (!h19Var.e()) {
                if (c) {
                    Log.d("UploadManager", "postByteRequest, fail: " + h19Var.d());
                } else {
                    g19.a().i(h19Var.d(), null);
                }
                if (j09.o().M()) {
                    g(h19Var.c());
                }
                h19Var.a();
                return false;
            }
            try {
                int i = new JSONObject(h19Var.b()).getInt("error");
                if (i != 0) {
                    if (c) {
                        Log.d("UploadManager", "server error");
                    }
                    if (!c) {
                        g19.a().k(i);
                    }
                }
            } catch (Exception e) {
                if (c) {
                    Log.d("UploadManager", "body tostring fail:" + e.getMessage());
                } else {
                    g19.a().j(Log.getStackTraceString(e));
                }
            }
            h19Var.a();
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
            j09.o().Z(currentTimeMillis);
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
        if (l19.m().p() && j > 0) {
            c2.put("Content-Length", String.valueOf(j));
        }
        InputStream inputStream2 = null;
        try {
            inputStream = new BufferedInputStream(new Base64InputStream(new FileInputStream(file), 2));
            try {
                try {
                    boolean f = f(j(e, inputStream, c2));
                    f29.b(inputStream);
                    return f;
                } catch (Exception e2) {
                    e = e2;
                    if (c) {
                        Log.d("UploadManager", "postByteRequest, Exception: ", e);
                    } else {
                        g19.a().i(null, Log.getStackTraceString(e));
                    }
                    f29.b(inputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                f29.b(inputStream2);
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
            if (jSONObject != null && (a = h29.a(jSONObject.toString().getBytes())) != null && a.length >= 2) {
                a[0] = ContentUtil.GZIP_HEAD_1;
                a[1] = ContentUtil.GZIP_HEAD_2;
                String e = e(str, z, z2);
                HashMap<String, String> c2 = c();
                if (l19.m().p()) {
                    c2.put("Content-Length", String.valueOf(a.length));
                }
                try {
                    return f(k(e, a, c2));
                } catch (IOException e2) {
                    if (c) {
                        Log.d("UploadManager", "postByteRequest, Exception: ", e2);
                    } else {
                        g19.a().i(null, Log.getStackTraceString(e2));
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public abstract h19 j(String str, InputStream inputStream, Map<String, String> map) throws IOException;

    public abstract h19 k(String str, byte[] bArr, Map<String, String> map) throws IOException;
}
