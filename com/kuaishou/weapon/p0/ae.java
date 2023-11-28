package com.kuaishou.weapon.p0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ae {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ae() {
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

    public JSONObject a() {
        int i;
        int i2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                int i3 = 1;
                if (a("/data", true)) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("0", i);
                if (a("/system/bin", true)) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("1", i2);
                if (!a("/system/lib", true)) {
                    i3 = 0;
                }
                jSONObject.put("2", i3);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject b() {
        int i;
        int i2;
        int i3;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                int i4 = 1;
                if (a("/sys", true)) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("0", i);
                if (a("/sbin", true)) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("1", i2);
                if (a("/etc", true)) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                jSONObject.put("2", i3);
                if (!a("/dev", true)) {
                    i4 = 0;
                }
                jSONObject.put("3", i4);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return new File(File.separator + "proc" + File.separator + str).canWrite();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0025: INVOKE  (r1v2 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, boolean z) {
        InterceptResult invokeLZ;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            String str2 = "";
            if (z) {
                try {
                    str = str + "/-" + System.currentTimeMillis();
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    str2 = sb.toString();
                } catch (Throwable unused) {
                    fileOutputStream = null;
                    if (fileOutputStream == null) {
                    }
                }
            }
            File file = new File(str);
            file.exists();
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(str2.getBytes());
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

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return a(str, false);
        }
        return invokeL.booleanValue;
    }
}
