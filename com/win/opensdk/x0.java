package com.win.opensdk;

import android.content.Context;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONStringer;
/* loaded from: classes7.dex */
public class x0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f42697a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f42698b;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f42699c;

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f42700d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639692905, "Lcom/win/opensdk/x0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1639692905, "Lcom/win/opensdk/x0;");
                return;
            }
        }
        f42697a = new String[]{"as", "ac", "ao", "scb", "wdin", "asr", "wbas", "wbao"};
        f42698b = new String[]{"ins", Config.DEVICE_BRAND, "wdtr", "witr"};
        f42699c = new String[]{"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe"};
        f42700d = new String[]{"Ld", "wdin", "wiin", "wdre", "wiop", "wii"};
    }

    public x0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static w0 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new w0(new x0(), context) : (w0) invokeL.objValue;
    }

    public static /* synthetic */ JSONStringer a(String str, y0 y0Var) {
        JSONStringer d2 = d();
        d2.key("e").value(str).key("timeis").value(c());
        if (y0Var != null) {
            d2.key("pid").value(y0Var.f42708a);
            if (y0Var.f42709b != null) {
                JSONStringer key = d2.key("traceid");
                String traceid = y0Var.f42709b.getTraceid();
                try {
                    traceid = z.a(traceid);
                } catch (Exception unused) {
                }
                JSONStringer key2 = key.value(traceid).key(IAdRequestParam.CELL_ID);
                String id = y0Var.f42709b.getId();
                try {
                    id = z.a(id);
                } catch (Exception unused2) {
                }
                key2.value(id).key("type").value(y0Var.f42709b.getType());
            }
        }
        return d2;
    }

    public static /* synthetic */ String b() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            return z.a(valueOf);
        } catch (Exception unused) {
            return valueOf;
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            try {
                return z.a(valueOf);
            } catch (Exception unused) {
                return valueOf;
            }
        }
        return (String) invokeV.objValue;
    }

    public static JSONStringer d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new JSONStringer().object() : (JSONStringer) invokeV.objValue;
    }

    public static /* synthetic */ String a(String str) {
        try {
            return z.a(str);
        } catch (Exception unused) {
            return str;
        }
    }
}
