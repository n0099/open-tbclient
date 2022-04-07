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
import com.repackage.fj2;
import com.repackage.sz1;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zv2 extends xv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tv2 b;
        public final /* synthetic */ sz1 c;

        public a(zv2 zv2Var, String str, tv2 tv2Var, sz1 sz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv2Var, str, tv2Var, sz1Var};
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
            this.b = tv2Var;
            this.c = sz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jq2 jq2Var = new jq2();
                jq2Var.c = this.a;
                jq2Var.b = uv2.a(this.b);
                sz1.b i = this.c.i("navigateTo");
                i.n(sz1.g, sz1.i);
                i.k("pluginFunPage", jq2Var).a();
            }
        }
    }

    public zv2() {
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

    @Override // com.repackage.xv2
    public js1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new js1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new js1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new js1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (js1) invokeL.objValue;
    }

    @Override // com.repackage.xv2
    public sv2 f(tv2 tv2Var) {
        InterceptResult invokeL;
        String[] list;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tv2Var)) == null) {
            File file = null;
            if (tv2Var == null) {
                return null;
            }
            String str = tv2Var.a;
            String str2 = tv2Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            sv2 sv2Var = new sv2();
            sv2Var.a = str;
            sv2Var.b = str2;
            if (ay1.d()) {
                file = fj2.f.e();
            } else if (iw2.H()) {
                file = fj2.b.e();
            } else if (iw2.D()) {
                file = qx1.d();
            } else {
                if (TextUtils.equals(tv2Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = ls1.a(str);
                    File g = fj2.g();
                    String[] list2 = g.list();
                    if (list2 == null || g.length() == 0) {
                        return sv2Var;
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
                                bw2.b(Log.getStackTraceString(e));
                            }
                        }
                    }
                    if (i2 > -1) {
                        sv2Var.a = str3 + i2;
                        sv2Var.e = true;
                        File file2 = new File(g, sv2Var.a + File.separator + i2);
                        sv2Var.c = file2.getAbsolutePath();
                        sv2Var.d = i2;
                        file = file2;
                    } else {
                        sv2Var.e = false;
                        sv2Var.c = null;
                    }
                } else {
                    File file3 = new File(fj2.g(), str);
                    if (file3.exists() && (list = file3.list()) != null && list.length != 0) {
                        String str5 = null;
                        int i3 = -1;
                        for (String str6 : list) {
                            if (!TextUtils.isEmpty(str6)) {
                                try {
                                    i = Integer.parseInt(str6);
                                } catch (NumberFormatException e2) {
                                    bw2.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            sv2Var.d = i3;
                            sv2Var.e = true;
                            file = new File(file3, str5);
                            sv2Var.c = file.getAbsolutePath();
                        }
                    }
                    return sv2Var;
                }
            }
            if (file == null) {
                return sv2Var;
            }
            File file4 = new File(file, str2);
            if (n(file4)) {
                sv2Var.f = true;
                sv2Var.c = file4.getAbsolutePath();
                return sv2Var;
            }
            return sv2Var;
        }
        return (sv2) invokeL.objValue;
    }

    @Override // com.repackage.xv2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.xv2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.xv2
    public js1 j(String str, tv2 tv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, tv2Var)) == null) {
            if (tv2Var == null) {
                return new js1(201, "pay args is null");
            }
            SwanAppActivity x = i03.J().x();
            if (x == null) {
                return new js1(1001, "runtime exception, try reopen this app");
            }
            sz1 swanAppFragmentManager = x.getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                return new js1(1001, "runtime exception, page manager breakdown");
            }
            bw2.b("jump to fun page");
            i03.L().post(new a(this, str, tv2Var, swanAppFragmentManager));
            return new js1(0);
        }
        return (js1) invokeLL.objValue;
    }

    @Override // com.repackage.xv2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.xv2
    public js1 m(tv2 tv2Var, v12<uv2> v12Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, tv2Var, v12Var)) == null) {
            return null;
        }
        return (js1) invokeLL.objValue;
    }

    public final boolean n(File file) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) ? file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0 : invokeL.booleanValue;
    }
}
