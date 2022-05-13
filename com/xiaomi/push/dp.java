package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class dp extends dq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dp(Context context, int i, String str) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
    }

    private String[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (TextUtils.isEmpty(this.a)) {
                return null;
            }
            String b = bj.b(this.a);
            if (TextUtils.isEmpty(b)) {
                return null;
            }
            return b.contains(",") ? b.split(",") : new String[]{b};
        }
        return (String[]) invokeV.objValue;
    }

    @Override // com.xiaomi.push.dq, com.xiaomi.push.ai.a
    /* renamed from: a */
    public hh mo223a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? hh.x : (hh) invokeV.objValue;
    }

    @Override // com.xiaomi.push.dq, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo223a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "24" : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.dq
    public String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String[] a = a();
            if (a == null || a.length <= 0) {
                return null;
            }
            PackageManager packageManager = ((dq) this).f222a.getPackageManager();
            StringBuilder sb = new StringBuilder();
            for (String str2 : a) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(str2, 16384);
                    if (packageInfo != null) {
                        if (sb.length() > 0) {
                            sb.append(";");
                        }
                        try {
                            str = packageManager.getInstallerPackageName(str2);
                        } catch (IllegalArgumentException unused) {
                            str = null;
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = StringUtil.NULL_STRING;
                        }
                        sb.append(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                        sb.append(",");
                        sb.append(packageInfo.packageName);
                        sb.append(",");
                        sb.append(packageInfo.versionName);
                        sb.append(",");
                        sb.append(packageInfo.versionCode);
                        sb.append(",");
                        sb.append(packageInfo.firstInstallTime);
                        sb.append(",");
                        sb.append(packageInfo.lastUpdateTime);
                        sb.append(",");
                        sb.append(str);
                    }
                } catch (Exception unused2) {
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }
}
