package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes6.dex */
public class gq3 implements ox3 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "hasDownloadApk";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755669432, "Lcom/repackage/gq3;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755669432, "Lcom/repackage/gq3;");
        }
    }

    public gq3() {
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
        this.a = "com.baidu.gamenow";
    }

    @Override // com.repackage.ox3
    public boolean a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof Download) {
                Download download = (Download) obj;
                if (TextUtils.equals(kq3.a, download.getKeyByUser())) {
                    return true;
                }
                return TextUtils.isEmpty(hd3.d(download.getFromParam()).optString("apk_id"));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ox3
    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (obj instanceof Download)) {
            oq3 oq3Var = new oq3((Download) obj);
            cr3.n().f("reallyDownloaded", new br3(), oq3Var.m(), oq3Var.j(), oq3Var.l());
        }
    }

    @Override // com.repackage.ox3
    public void c(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (obj instanceof Download)) {
            Download download = (Download) obj;
            oq3 oq3Var = new oq3(download);
            cr3.n().f("statusInstalled", new br3(), download.getKeyByUser(), oq3Var.j(), oq3Var.l());
            if (TextUtils.equals(oq3Var.m(), this.a)) {
                v83.a().putBoolean(b, true);
                cr3.n().p(13, oq3Var.m(), oq3Var.h(), oq3Var.l());
            }
        }
    }
}
