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
import com.repackage.bz1;
import com.repackage.oi2;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class iv2 extends gv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cv2 b;
        public final /* synthetic */ bz1 c;

        public a(iv2 iv2Var, String str, cv2 cv2Var, bz1 bz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv2Var, str, cv2Var, bz1Var};
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
            this.b = cv2Var;
            this.c = bz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sp2 sp2Var = new sp2();
                sp2Var.c = this.a;
                sp2Var.b = dv2.a(this.b);
                bz1.b i = this.c.i("navigateTo");
                i.n(bz1.g, bz1.i);
                i.k("pluginFunPage", sp2Var).a();
            }
        }
    }

    public iv2() {
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

    @Override // com.repackage.gv2
    public sr1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new sr1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new sr1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new sr1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (sr1) invokeL.objValue;
    }

    @Override // com.repackage.gv2
    public bv2 f(cv2 cv2Var) {
        InterceptResult invokeL;
        String[] list;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cv2Var)) == null) {
            File file = null;
            if (cv2Var == null) {
                return null;
            }
            String str = cv2Var.a;
            String str2 = cv2Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            bv2 bv2Var = new bv2();
            bv2Var.a = str;
            bv2Var.b = str2;
            if (jx1.d()) {
                file = oi2.f.e();
            } else if (rv2.H()) {
                file = oi2.b.e();
            } else if (rv2.D()) {
                file = zw1.d();
            } else {
                if (TextUtils.equals(cv2Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = ur1.a(str);
                    File g = oi2.g();
                    String[] list2 = g.list();
                    if (list2 == null || g.length() == 0) {
                        return bv2Var;
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
                                kv2.b(Log.getStackTraceString(e));
                            }
                        }
                    }
                    if (i2 > -1) {
                        bv2Var.a = str3 + i2;
                        bv2Var.e = true;
                        File file2 = new File(g, bv2Var.a + File.separator + i2);
                        bv2Var.c = file2.getAbsolutePath();
                        bv2Var.d = i2;
                        file = file2;
                    } else {
                        bv2Var.e = false;
                        bv2Var.c = null;
                    }
                } else {
                    File file3 = new File(oi2.g(), str);
                    if (file3.exists() && (list = file3.list()) != null && list.length != 0) {
                        String str5 = null;
                        int i3 = -1;
                        for (String str6 : list) {
                            if (!TextUtils.isEmpty(str6)) {
                                try {
                                    i = Integer.parseInt(str6);
                                } catch (NumberFormatException e2) {
                                    kv2.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            bv2Var.d = i3;
                            bv2Var.e = true;
                            file = new File(file3, str5);
                            bv2Var.c = file.getAbsolutePath();
                        }
                    }
                    return bv2Var;
                }
            }
            if (file == null) {
                return bv2Var;
            }
            File file4 = new File(file, str2);
            if (n(file4)) {
                bv2Var.f = true;
                bv2Var.c = file4.getAbsolutePath();
                return bv2Var;
            }
            return bv2Var;
        }
        return (bv2) invokeL.objValue;
    }

    @Override // com.repackage.gv2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.gv2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.gv2
    public sr1 j(String str, cv2 cv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cv2Var)) == null) {
            if (cv2Var == null) {
                return new sr1(201, "pay args is null");
            }
            SwanAppActivity x = rz2.K().x();
            if (x == null) {
                return new sr1(1001, "runtime exception, try reopen this app");
            }
            bz1 X = x.X();
            if (X == null) {
                return new sr1(1001, "runtime exception, page manager breakdown");
            }
            kv2.b("jump to fun page");
            rz2.M().post(new a(this, str, cv2Var, X));
            return new sr1(0);
        }
        return (sr1) invokeLL.objValue;
    }

    @Override // com.repackage.gv2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.gv2
    public sr1 m(cv2 cv2Var, e12<dv2> e12Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, cv2Var, e12Var)) == null) {
            return null;
        }
        return (sr1) invokeLL.objValue;
    }

    public final boolean n(File file) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) ? file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0 : invokeL.booleanValue;
    }
}
