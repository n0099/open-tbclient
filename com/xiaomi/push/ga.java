package com.xiaomi.push;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class ga extends gc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f78025a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, String> f427a;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f78026a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f78027b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f78028c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f78029d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f78030e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with other field name */
        public String f428a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1659039945, "Lcom/xiaomi/push/ga$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1659039945, "Lcom/xiaomi/push/ga$a;");
                    return;
                }
            }
            f78026a = new a("get");
            f78027b = new a("set");
            f78028c = new a("result");
            f78029d = new a("error");
            f78030e = new a("command");
        }

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f428a = str;
        }

        public static a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                if (str == null) {
                    return null;
                }
                String lowerCase = str.toLowerCase();
                if (f78026a.toString().equals(lowerCase)) {
                    return f78026a;
                }
                if (f78027b.toString().equals(lowerCase)) {
                    return f78027b;
                }
                if (f78029d.toString().equals(lowerCase)) {
                    return f78029d;
                }
                if (f78028c.toString().equals(lowerCase)) {
                    return f78028c;
                }
                if (f78030e.toString().equals(lowerCase)) {
                    return f78030e;
                }
                return null;
            }
            return (a) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f428a : (String) invokeV.objValue;
        }
    }

    public ga() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f78025a = a.f78026a;
        this.f427a = new HashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ga(Bundle bundle) {
        super(bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Bundle) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f78025a = a.f78026a;
        this.f427a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f78025a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    @Override // com.xiaomi.push.gc
    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle a2 = super.a();
            a aVar = this.f78025a;
            if (aVar != null) {
                a2.putString("ext_iq_type", aVar.toString());
            }
            return a2;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // com.xiaomi.push.gc
    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f78025a : (a) invokeV.objValue;
    }

    @Override // com.xiaomi.push.gc
    public String a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("<iq ");
            if (j() != null) {
                sb.append("id=\"" + j() + "\" ");
            }
            if (l() != null) {
                sb.append("to=\"");
                sb.append(gn.a(l()));
                sb.append("\" ");
            }
            if (m() != null) {
                sb.append("from=\"");
                sb.append(gn.a(m()));
                sb.append("\" ");
            }
            if (k() != null) {
                sb.append("chid=\"");
                sb.append(gn.a(k()));
                sb.append("\" ");
            }
            for (Map.Entry<String, String> entry : this.f427a.entrySet()) {
                sb.append(gn.a(entry.getKey()));
                sb.append("=\"");
                sb.append(gn.a(entry.getValue()));
                sb.append("\" ");
            }
            if (this.f78025a == null) {
                str = "type=\"get\">";
            } else {
                sb.append("type=\"");
                sb.append(a());
                str = "\">";
            }
            sb.append(str);
            String b2 = b();
            if (b2 != null) {
                sb.append(b2);
            }
            sb.append(o());
            gg m346a = m346a();
            if (m346a != null) {
                sb.append(m346a.m350a());
            }
            sb.append("</iq>");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (aVar == null) {
                aVar = a.f78026a;
            }
            this.f78025a = aVar;
        }
    }

    public synchronized void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
            synchronized (this) {
                this.f427a.putAll(map);
            }
        }
    }

    @Override // com.xiaomi.push.gc
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }
}
