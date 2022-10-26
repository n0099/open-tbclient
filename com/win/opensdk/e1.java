package com.win.opensdk;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONStringer;
/* loaded from: classes8.dex */
public class e1 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public static final String[] b;
    public static final String[] c;
    public static final String[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639711133, "Lcom/win/opensdk/e1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1639711133, "Lcom/win/opensdk/e1;");
                return;
            }
        }
        a = new String[]{"as", "ac", "ao", "scb", "wdin", "wbas", "wbao"};
        b = new String[]{"ins", Config.DEVICE_BRAND, "wdtr", "witr", "irs"};
        c = new String[]{"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe", "hte"};
        d = new String[]{"Ld", "wdin", "wiin", "wdre", "wiop", "wii", "rle"};
    }

    public e1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static d1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new d1(new e1(), context) : (d1) invokeL.objValue;
    }

    public static JSONStringer b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? new JSONStringer().object() : (JSONStringer) invokeV.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            try {
                return M.a(valueOf);
            } catch (Exception unused) {
                return valueOf;
            }
        }
        return (String) invokeV.objValue;
    }

    public static /* synthetic */ String a(String str) {
        try {
            return M.a(str);
        } catch (Exception unused) {
            return str;
        }
    }

    public static /* synthetic */ JSONStringer a(String str, f1 f1Var) {
        JSONStringer b2 = b();
        b2.key("e").value(str).key("timeis").value(a());
        if (f1Var != null) {
            b2.key("pid").value(f1Var.a);
            if (f1Var.b != null) {
                JSONStringer key = b2.key("traceid");
                String traceid = f1Var.b.getTraceid();
                try {
                    traceid = M.a(traceid);
                } catch (Exception unused) {
                }
                JSONStringer key2 = key.value(traceid).key("cid");
                String id = f1Var.b.getId();
                try {
                    id = M.a(id);
                } catch (Exception unused2) {
                }
                key2.value(id).key("type").value(f1Var.b.getType());
            }
        }
        return b2;
    }
}
