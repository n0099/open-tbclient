package com.repackage;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.identifier.IdentifierIdClient;
/* loaded from: classes7.dex */
public class yg1 implements pg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xg1 a;
    public String b;
    public Context c;
    public wg1 d;

    public yg1() {
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

    @Override // com.repackage.pg1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = this.a.a(0, null);
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.pg1
    public void a(Context context, qg1 qg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, qg1Var) == null) {
            this.a = new xg1(context);
            this.c = context;
            if (b()) {
                this.d = new wg1(this);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.d);
            }
            if (qg1Var != null) {
                qg1Var.a();
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class, String.class).invoke(cls, IdentifierIdClient.SYS_IDENTIFIERID_SUPPORTED, "0");
            } catch (Throwable unused) {
                str = null;
            }
            return "1".equals(str);
        }
        return invokeV.booleanValue;
    }
}
