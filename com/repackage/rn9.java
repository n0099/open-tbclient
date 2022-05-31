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
/* loaded from: classes7.dex */
public class rn9 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public static final String[] b;
    public static final String[] c;
    public static final String[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755344428, "Lcom/repackage/rn9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755344428, "Lcom/repackage/rn9;");
                return;
            }
        }
        a = new String[]{"as", D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, "ao", "scb", "wdin", "asr", "wbas", "wbao"};
        b = new String[]{"ins", Config.DEVICE_BRAND, "wdtr", "witr"};
        c = new String[]{"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe", "hte"};
        d = new String[]{"Ld", "wdin", "wiin", "wdre", "wiop", "wii", "rle"};
    }

    public rn9() {
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

    public static nn9 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new nn9(new rn9(), context) : (nn9) invokeL.objValue;
    }

    public static /* synthetic */ String b(String str) {
        try {
            return ll9.g(str);
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.repackage.nn9.a(int, long):com.repackage.nn9] */
    public static /* synthetic */ JSONStringer c() {
        return new JSONStringer().object();
    }

    public static /* synthetic */ JSONStringer d(String str, vn9 vn9Var) {
        JSONStringer g = g();
        g.key("e").value(str).key("timeis").value(f());
        if (vn9Var != null) {
            g.key("pid").value(vn9Var.a);
            if (vn9Var.b != null) {
                JSONStringer key = g.key("traceid");
                String traceid = vn9Var.b.getTraceid();
                try {
                    traceid = ll9.g(traceid);
                } catch (Exception unused) {
                }
                JSONStringer key2 = key.value(traceid).key("cid");
                String id = vn9Var.b.getId();
                try {
                    id = ll9.g(id);
                } catch (Exception unused2) {
                }
                key2.value(id).key("type").value(vn9Var.b.getType());
            }
        }
        return g;
    }

    public static /* synthetic */ String e() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            return ll9.g(valueOf);
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
                return ll9.g(valueOf);
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
