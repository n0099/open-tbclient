package com.repackage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class wg4 implements xg4<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public wg4(Context context) {
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
        this.a = context.getApplicationContext();
    }

    @Override // com.repackage.xg4
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && fh4.a(this.a, "android.permission.READ_EXTERNAL_STORAGE")) {
                return !new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid").exists();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.xg4
    /* renamed from: b */
    public String get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c() : (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && fh4.a(this.a, "android.permission.READ_EXTERNAL_STORAGE")) {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid");
                if (file.exists()) {
                    return dh4.c(file);
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.xg4
    /* renamed from: d */
    public void put(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            e(str);
        }
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && TextUtils.equals("mounted", Environment.getExternalStorageState()) && fh4.a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            dh4.d(str, new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid"));
        }
    }
}
