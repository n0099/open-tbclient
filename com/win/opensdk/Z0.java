package com.win.opensdk;

import android.content.Context;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONStringer;
/* loaded from: classes10.dex */
public class Z0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a */
    public static final String[] f76760a;

    /* renamed from: b */
    public static final String[] f76761b;

    /* renamed from: c */
    public static final String[] f76762c;

    /* renamed from: d */
    public static final String[] f76763d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639721735, "Lcom/win/opensdk/Z0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1639721735, "Lcom/win/opensdk/Z0;");
                return;
            }
        }
        f76760a = new String[]{"as", "ac", "ao", "scb", "wdin", "asr", "wbas", "wbao"};
        f76761b = new String[]{"ins", "bd", "wdtr", "witr"};
        f76762c = new String[]{"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe"};
        f76763d = new String[]{"Ld", "wdin", "wiin", "wdre", "wiop", "wii"};
    }

    public Z0() {
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

    public static Y0 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new Y0(new Z0(), context) : (Y0) invokeL.objValue;
    }

    public static /* synthetic */ JSONStringer a(String str, a1 a1Var) {
        JSONStringer d2 = d();
        d2.key("e").value(str).key("timeis").value(c());
        if (a1Var != null) {
            d2.key("pid").value(a1Var.f76767a);
            if (a1Var.f76768b != null) {
                JSONStringer key = d2.key("traceid");
                String traceid = a1Var.f76768b.getTraceid();
                try {
                    traceid = N.a(traceid);
                } catch (Exception unused) {
                }
                JSONStringer key2 = key.value(traceid).key(IAdRequestParam.CELL_ID);
                String id = a1Var.f76768b.getId();
                try {
                    id = N.a(id);
                } catch (Exception unused2) {
                }
                key2.value(id).key("type").value(a1Var.f76768b.getType());
            }
        }
        return d2;
    }

    public static /* synthetic */ String b() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            return N.a(valueOf);
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
                return N.a(valueOf);
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
            return N.a(str);
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.Y0.a(int, long):com.win.opensdk.Y0] */
    public static /* synthetic */ JSONStringer a() {
        return new JSONStringer().object();
    }
}
