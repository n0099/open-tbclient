package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.di2;
import com.repackage.qy1;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xu2 extends vu2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ru2 b;
        public final /* synthetic */ qy1 c;

        public a(xu2 xu2Var, String str, ru2 ru2Var, qy1 qy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu2Var, str, ru2Var, qy1Var};
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
            this.b = ru2Var;
            this.c = qy1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hp2 hp2Var = new hp2();
                hp2Var.c = this.a;
                hp2Var.b = su2.a(this.b);
                qy1.b i = this.c.i("navigateTo");
                i.n(qy1.g, qy1.i);
                i.k("pluginFunPage", hp2Var).a();
            }
        }
    }

    public xu2() {
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

    @Override // com.repackage.vu2
    public hr1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new hr1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new hr1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new hr1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (hr1) invokeL.objValue;
    }

    @Override // com.repackage.vu2
    public qu2 f(ru2 ru2Var) {
        InterceptResult invokeL;
        String[] list;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ru2Var)) == null) {
            File file = null;
            if (ru2Var == null) {
                return null;
            }
            String str = ru2Var.a;
            String str2 = ru2Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            qu2 qu2Var = new qu2();
            qu2Var.a = str;
            qu2Var.b = str2;
            if (yw1.d()) {
                file = di2.f.e();
            } else if (gv2.H()) {
                file = di2.b.e();
            } else if (gv2.D()) {
                file = ow1.d();
            } else {
                if (TextUtils.equals(ru2Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = jr1.a(str);
                    File g = di2.g();
                    String[] list2 = g.list();
                    if (list2 == null || g.length() == 0) {
                        return qu2Var;
                    }
                    String str3 = a2 + "_dev";
                    int i2 = -1;
                    for (String str4 : list2) {
                        if (!TextUtils.isEmpty(str4) && str4.startsWith(str3)) {
                            try {
                                int parseInt = Integer.parseInt(str4.substring(str3.length()));
                                if (parseInt > i2) {
                                    i2 = parseInt;
                                }
                            } catch (NumberFormatException e) {
                                zu2.b(Log.getStackTraceString(e));
                            }
                        }
                    }
                    if (i2 > -1) {
                        qu2Var.a = str3 + i2;
                        qu2Var.e = true;
                        File file2 = new File(g, qu2Var.a + File.separator + i2);
                        qu2Var.c = file2.getAbsolutePath();
                        qu2Var.d = i2;
                        file = file2;
                    } else {
                        qu2Var.e = false;
                        qu2Var.c = null;
                    }
                } else {
                    File file3 = new File(di2.g(), str);
                    if (file3.exists() && (list = file3.list()) != null && list.length != 0) {
                        String str5 = null;
                        int i3 = -1;
                        for (String str6 : list) {
                            if (!TextUtils.isEmpty(str6)) {
                                try {
                                    i = Integer.parseInt(str6);
                                } catch (NumberFormatException e2) {
                                    zu2.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            qu2Var.d = i3;
                            qu2Var.e = true;
                            file = new File(file3, str5);
                            qu2Var.c = file.getAbsolutePath();
                        }
                    }
                    return qu2Var;
                }
            }
            if (file == null) {
                return qu2Var;
            }
            File file4 = new File(file, str2);
            if (n(file4)) {
                qu2Var.f = true;
                qu2Var.c = file4.getAbsolutePath();
                return qu2Var;
            }
            return qu2Var;
        }
        return (qu2) invokeL.objValue;
    }

    @Override // com.repackage.vu2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.vu2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.vu2
    public hr1 j(String str, ru2 ru2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, ru2Var)) == null) {
            if (ru2Var == null) {
                return new hr1(201, "pay args is null");
            }
            SwanAppActivity x = gz2.J().x();
            if (x == null) {
                return new hr1(1001, "runtime exception, try reopen this app");
            }
            qy1 swanAppFragmentManager = x.getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                return new hr1(1001, "runtime exception, page manager breakdown");
            }
            zu2.b("jump to fun page");
            gz2.L().post(new a(this, str, ru2Var, swanAppFragmentManager));
            return new hr1(0);
        }
        return (hr1) invokeLL.objValue;
    }

    @Override // com.repackage.vu2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.vu2
    public hr1 m(ru2 ru2Var, t02<su2> t02Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, ru2Var, t02Var)) == null) {
            return null;
        }
        return (hr1) invokeLL.objValue;
    }

    public final boolean n(File file) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) ? file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0 : invokeL.booleanValue;
    }
}
