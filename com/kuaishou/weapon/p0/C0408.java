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
/* renamed from: com.kuaishou.weapon.p0.ˋ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0408 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f477;

    /* renamed from: ʼ  reason: contains not printable characters */
    public int f478;

    /* renamed from: ʽ  reason: contains not printable characters */
    public C0374 f479;

    public C0408(Context context) {
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
        this.f478 = 0;
        this.f477 = context;
        C0374 m389 = C0374.m389(context);
        this.f479 = m389;
        if (m389 != null) {
            this.f478 = m389.m392(C0374.f319, 0);
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONArray m579(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? m580(i) : (JSONArray) invokeI.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public JSONArray m580(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                PackageManager packageManager = this.f477.getPackageManager();
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
                                    C0406 c0406 = new C0406(packageInfo, this.f477);
                                    c0406.m569();
                                    jSONArray.put(c0406.m553());
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

    /* renamed from: ʽ  reason: contains not printable characters */
    public JSONArray m581(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            try {
                return m579(i);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONArray) invokeI.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public JSONArray m582(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            try {
                new A(this.f477, i);
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
