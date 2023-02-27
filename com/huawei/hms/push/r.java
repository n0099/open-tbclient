package com.huawei.hms.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.model.ResourceLoader;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.Field;
/* loaded from: classes8.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, String str) {
        Bundle bundle;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    return bundle.getInt(str);
                }
                return 0;
            } catch (PackageManager.NameNotFoundException unused) {
                HMSLog.w(ResourceLoader.TAG, "load meta data resource failed.");
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static int a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, str2)) == null) {
            try {
                int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
                if (identifier == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getPackageName());
                    sb.append(".R$");
                    sb.append(str);
                    Field field = Class.forName(sb.toString()).getField(str2);
                    identifier = Integer.parseInt(field.get(field.getName()).toString());
                    if (identifier == 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Error-resourceType=");
                        sb2.append(str);
                        sb2.append("--resourceName=");
                        sb2.append(str2);
                        sb2.append("--resourceId =");
                        sb2.append(identifier);
                        HMSLog.i(ResourceLoader.TAG, sb2.toString());
                    }
                }
                return identifier;
            } catch (ClassNotFoundException e) {
                HMSLog.e(ResourceLoader.TAG, "!!!! ResourceLoader: ClassNotFoundException-resourceType=" + str + "--resourceName=" + str2, e);
                return 0;
            } catch (IllegalAccessException e2) {
                HMSLog.e(ResourceLoader.TAG, "!!!! ResourceLoader: IllegalAccessException-resourceType=" + str + "--resourceName=" + str2, e2);
                return 0;
            } catch (IllegalArgumentException e3) {
                HMSLog.e(ResourceLoader.TAG, "!!!! ResourceLoader: IllegalArgumentException-resourceType=" + str + "--resourceName=" + str2, e3);
                return 0;
            } catch (NoSuchFieldException e4) {
                HMSLog.e(ResourceLoader.TAG, "!!!! ResourceLoader: NoSuchFieldException-resourceType=" + str + "--resourceName=" + str2, e4);
                return 0;
            } catch (NumberFormatException e5) {
                HMSLog.e(ResourceLoader.TAG, "!!!! ResourceLoader: NumberFormatException-resourceType=" + str + "--resourceName=" + str2, e5);
                return 0;
            }
        }
        return invokeLLL.intValue;
    }
}
