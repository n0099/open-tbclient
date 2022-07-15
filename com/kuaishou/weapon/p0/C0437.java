package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ᴵ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0437 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0437() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m917(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return C0304.m177(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m918() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", m920("/data", true) ? 1 : 0);
                jSONObject.put("1", m920("/system/bin", true) ? 1 : 0);
                jSONObject.put("2", m920("/system/lib", true) ? 1 : 0);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m919(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return new File(File.separator + "proc" + File.separator + str).canWrite();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0023: INVOKE  (r1v2 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: ʻ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m920(String str, boolean z) {
        InterceptResult invokeLZ;
        String sb;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            if (z) {
                try {
                    str = str + "/-" + System.currentTimeMillis();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(System.currentTimeMillis());
                    sb = sb2.toString();
                } catch (Throwable unused) {
                    fileOutputStream = null;
                    if (fileOutputStream == null) {
                    }
                }
            } else {
                sb = "";
            }
            File file = new File(str);
            file.exists();
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(sb.getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                if (z) {
                    file.delete();
                }
                try {
                    fileOutputStream.close();
                    return true;
                } catch (Exception unused2) {
                    return true;
                }
            } catch (Throwable unused3) {
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Exception unused4) {
                        return false;
                    }
                }
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public JSONObject m921() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", m920("/sys", true) ? 1 : 0);
                jSONObject.put("1", m920("/sbin", true) ? 1 : 0);
                jSONObject.put("2", m920("/etc", true) ? 1 : 0);
                jSONObject.put("3", m920("/dev", true) ? 1 : 0);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m922(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? m920(str, false) : invokeL.booleanValue;
    }
}
