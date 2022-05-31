package com.repackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class z30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String[] b;
    public int c;
    public String d;
    public long e;
    public long f;

    public z30(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            this.d = packageInfo.versionName;
            this.c = packageInfo.versionCode;
            this.e = packageInfo.firstInstallTime;
            this.f = packageInfo.lastUpdateTime;
            this.b = new String[packageInfo.signatures.length];
            for (int i3 = 0; i3 < this.b.length; i3++) {
                this.b[i3] = v30.c(packageInfo.signatures[i3].toByteArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SappInfo{pkg='" + this.a + "', sigs=" + Arrays.toString(this.b) + ", vc=" + this.c + ", va=" + this.d + ", installts=" + this.e + ", lstupdatets=" + this.f + '}';
        }
        return (String) invokeV.objValue;
    }
}
