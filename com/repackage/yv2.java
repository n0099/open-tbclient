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
import com.repackage.ej2;
import com.repackage.rz1;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yv2 extends wv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ sv2 b;
        public final /* synthetic */ rz1 c;

        public a(yv2 yv2Var, String str, sv2 sv2Var, rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv2Var, str, sv2Var, rz1Var};
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
            this.b = sv2Var;
            this.c = rz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                iq2 iq2Var = new iq2();
                iq2Var.c = this.a;
                iq2Var.b = tv2.a(this.b);
                rz1.b i = this.c.i("navigateTo");
                i.n(rz1.g, rz1.i);
                i.k("pluginFunPage", iq2Var).a();
            }
        }
    }

    public yv2() {
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

    @Override // com.repackage.wv2
    public is1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new is1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new is1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new is1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (is1) invokeL.objValue;
    }

    @Override // com.repackage.wv2
    public rv2 f(sv2 sv2Var) {
        InterceptResult invokeL;
        String[] list;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sv2Var)) == null) {
            File file = null;
            if (sv2Var == null) {
                return null;
            }
            String str = sv2Var.a;
            String str2 = sv2Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            rv2 rv2Var = new rv2();
            rv2Var.a = str;
            rv2Var.b = str2;
            if (zx1.d()) {
                file = ej2.f.e();
            } else if (hw2.H()) {
                file = ej2.b.e();
            } else if (hw2.D()) {
                file = px1.d();
            } else {
                if (TextUtils.equals(sv2Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = ks1.a(str);
                    File g = ej2.g();
                    String[] list2 = g.list();
                    if (list2 == null || g.length() == 0) {
                        return rv2Var;
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
                                aw2.b(Log.getStackTraceString(e));
                            }
                        }
                    }
                    if (i2 > -1) {
                        rv2Var.a = str3 + i2;
                        rv2Var.e = true;
                        File file2 = new File(g, rv2Var.a + File.separator + i2);
                        rv2Var.c = file2.getAbsolutePath();
                        rv2Var.d = i2;
                        file = file2;
                    } else {
                        rv2Var.e = false;
                        rv2Var.c = null;
                    }
                } else {
                    File file3 = new File(ej2.g(), str);
                    if (file3.exists() && (list = file3.list()) != null && list.length != 0) {
                        String str5 = null;
                        int i3 = -1;
                        for (String str6 : list) {
                            if (!TextUtils.isEmpty(str6)) {
                                try {
                                    i = Integer.parseInt(str6);
                                } catch (NumberFormatException e2) {
                                    aw2.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            rv2Var.d = i3;
                            rv2Var.e = true;
                            file = new File(file3, str5);
                            rv2Var.c = file.getAbsolutePath();
                        }
                    }
                    return rv2Var;
                }
            }
            if (file == null) {
                return rv2Var;
            }
            File file4 = new File(file, str2);
            if (n(file4)) {
                rv2Var.f = true;
                rv2Var.c = file4.getAbsolutePath();
                return rv2Var;
            }
            return rv2Var;
        }
        return (rv2) invokeL.objValue;
    }

    @Override // com.repackage.wv2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.wv2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.wv2
    public is1 j(String str, sv2 sv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, sv2Var)) == null) {
            if (sv2Var == null) {
                return new is1(201, "pay args is null");
            }
            SwanAppActivity w = h03.K().w();
            if (w == null) {
                return new is1(1001, "runtime exception, try reopen this app");
            }
            rz1 X = w.X();
            if (X == null) {
                return new is1(1001, "runtime exception, page manager breakdown");
            }
            aw2.b("jump to fun page");
            h03.M().post(new a(this, str, sv2Var, X));
            return new is1(0);
        }
        return (is1) invokeLL.objValue;
    }

    @Override // com.repackage.wv2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.wv2
    public is1 m(sv2 sv2Var, u12<tv2> u12Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sv2Var, u12Var)) == null) {
            return null;
        }
        return (is1) invokeLL.objValue;
    }

    public final boolean n(File file) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) ? file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0 : invokeL.booleanValue;
    }
}
