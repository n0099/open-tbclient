package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.A;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public i c;

    public x(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.a = context;
        i a = i.a(context, "re_po_rt");
        this.c = a;
        if (a != null) {
            this.b = a.a(f3.r, 0);
        }
    }

    public JSONArray a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? b(i) : (JSONArray) invokeI.objValue;
    }

    public JSONArray b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                PackageManager packageManager = this.a.getPackageManager();
                for (int i2 = 1000; i2 <= 19999; i2++) {
                    String[] strArr = null;
                    try {
                        strArr = packageManager.getPackagesForUid(i2);
                    } catch (Exception unused) {
                    }
                    if (strArr != null) {
                        for (String str : strArr) {
                            try {
                                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                                if (i != 1 || (packageInfo.applicationInfo.flags & 1) != 1) {
                                    w wVar = new w(packageInfo, this.a);
                                    wVar.j();
                                    jSONArray.put(wVar.a());
                                }
                            } catch (Exception unused2) {
                            }
                        }
                    }
                }
            } catch (Exception unused3) {
            }
            return jSONArray;
        }
        return (JSONArray) invokeI.objValue;
    }

    public JSONArray c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            try {
                return a(i);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONArray) invokeI.objValue;
    }

    public JSONArray d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            try {
                new A(this.a, i);
                JSONArray jsonObject = A.getJsonObject();
                JSONArray jSONArray = new JSONArray();
                if (jsonObject != null) {
                    for (int i2 = 0; i2 < jsonObject.length(); i2++) {
                        jSONArray.put(jsonObject.get(i2));
                    }
                    A.setJsonObject(null);
                    return jSONArray;
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return (JSONArray) invokeI.objValue;
    }
}
