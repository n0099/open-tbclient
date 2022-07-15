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
import com.repackage.dj2;
import com.repackage.qz1;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xv2 extends vv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ rv2 b;
        public final /* synthetic */ qz1 c;

        public a(xv2 xv2Var, String str, rv2 rv2Var, qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv2Var, str, rv2Var, qz1Var};
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
            this.b = rv2Var;
            this.c = qz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hq2 hq2Var = new hq2();
                hq2Var.c = this.a;
                hq2Var.b = sv2.a(this.b);
                qz1.b i = this.c.i("navigateTo");
                i.n(qz1.g, qz1.i);
                i.k("pluginFunPage", hq2Var).a();
            }
        }
    }

    public xv2() {
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

    @Override // com.repackage.vv2
    public hs1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new hs1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new hs1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new hs1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (hs1) invokeL.objValue;
    }

    @Override // com.repackage.vv2
    public qv2 f(rv2 rv2Var) {
        InterceptResult invokeL;
        String[] list;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv2Var)) == null) {
            File file = null;
            if (rv2Var == null) {
                return null;
            }
            String str = rv2Var.a;
            String str2 = rv2Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            qv2 qv2Var = new qv2();
            qv2Var.a = str;
            qv2Var.b = str2;
            if (yx1.d()) {
                file = dj2.f.e();
            } else if (gw2.H()) {
                file = dj2.b.e();
            } else if (gw2.D()) {
                file = ox1.d();
            } else {
                if (TextUtils.equals(rv2Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = js1.a(str);
                    File g = dj2.g();
                    String[] list2 = g.list();
                    if (list2 == null || g.length() == 0) {
                        return qv2Var;
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
                                zv2.b(Log.getStackTraceString(e));
                            }
                        }
                    }
                    if (i2 > -1) {
                        qv2Var.a = str3 + i2;
                        qv2Var.e = true;
                        File file2 = new File(g, qv2Var.a + File.separator + i2);
                        qv2Var.c = file2.getAbsolutePath();
                        qv2Var.d = i2;
                        file = file2;
                    } else {
                        qv2Var.e = false;
                        qv2Var.c = null;
                    }
                } else {
                    File file3 = new File(dj2.g(), str);
                    if (file3.exists() && (list = file3.list()) != null && list.length != 0) {
                        String str5 = null;
                        int i3 = -1;
                        for (String str6 : list) {
                            if (!TextUtils.isEmpty(str6)) {
                                try {
                                    i = Integer.parseInt(str6);
                                } catch (NumberFormatException e2) {
                                    zv2.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            qv2Var.d = i3;
                            qv2Var.e = true;
                            file = new File(file3, str5);
                            qv2Var.c = file.getAbsolutePath();
                        }
                    }
                    return qv2Var;
                }
            }
            if (file == null) {
                return qv2Var;
            }
            File file4 = new File(file, str2);
            if (n(file4)) {
                qv2Var.f = true;
                qv2Var.c = file4.getAbsolutePath();
                return qv2Var;
            }
            return qv2Var;
        }
        return (qv2) invokeL.objValue;
    }

    @Override // com.repackage.vv2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.vv2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.vv2
    public hs1 j(String str, rv2 rv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, rv2Var)) == null) {
            if (rv2Var == null) {
                return new hs1(201, "pay args is null");
            }
            SwanAppActivity w = g03.K().w();
            if (w == null) {
                return new hs1(1001, "runtime exception, try reopen this app");
            }
            qz1 X = w.X();
            if (X == null) {
                return new hs1(1001, "runtime exception, page manager breakdown");
            }
            zv2.b("jump to fun page");
            g03.M().post(new a(this, str, rv2Var, X));
            return new hs1(0);
        }
        return (hs1) invokeLL.objValue;
    }

    @Override // com.repackage.vv2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.vv2
    public hs1 m(rv2 rv2Var, t12<sv2> t12Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, rv2Var, t12Var)) == null) {
            return null;
        }
        return (hs1) invokeLL.objValue;
    }

    public final boolean n(File file) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) ? file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0 : invokeL.booleanValue;
    }
}
