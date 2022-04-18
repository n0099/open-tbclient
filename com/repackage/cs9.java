package com.repackage;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.baidu.sofire.d.D;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONStringer;
/* loaded from: classes5.dex */
public class cs9 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public static final String[] b;
    public static final String[] c;
    public static final String[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755786488, "Lcom/repackage/cs9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755786488, "Lcom/repackage/cs9;");
                return;
            }
        }
        a = new String[]{"as", D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, "ao", "scb", "wdin", "asr", "wbas", "wbao"};
        b = new String[]{"ins", Config.DEVICE_BRAND, "wdtr", "witr"};
        c = new String[]{"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe", "hte"};
        d = new String[]{"Ld", "wdin", "wiin", "wdre", "wiop", "wii", "rle"};
    }

    public cs9() {
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

    public static yr9 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new yr9(new cs9(), context) : (yr9) invokeL.objValue;
    }

    public static /* synthetic */ String b(String str) {
        try {
            return wp9.g(str);
        } catch (Exception unused) {
            return str;
        }
    }

    public static /* synthetic */ JSONStringer d(String str, gs9 gs9Var) {
        JSONStringer g = g();
        g.key("e").value(str).key("timeis").value(f());
        if (gs9Var != null) {
            g.key("pid").value(gs9Var.a);
            if (gs9Var.b != null) {
                JSONStringer key = g.key("traceid");
                String traceid = gs9Var.b.getTraceid();
                try {
                    traceid = wp9.g(traceid);
                } catch (Exception unused) {
                }
                JSONStringer key2 = key.value(traceid).key("cid");
                String id = gs9Var.b.getId();
                try {
                    id = wp9.g(id);
                } catch (Exception unused2) {
                }
                key2.value(id).key("type").value(gs9Var.b.getType());
            }
        }
        return g;
    }

    public static /* synthetic */ String e() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            return wp9.g(valueOf);
        } catch (Exception unused) {
            return valueOf;
        }
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            try {
                return wp9.g(valueOf);
            } catch (Exception unused) {
                return valueOf;
            }
        }
        return (String) invokeV.objValue;
    }

    public static JSONStringer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new JSONStringer().object() : (JSONStringer) invokeV.objValue;
    }
}
