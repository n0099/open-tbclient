package com.sdk.g;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.a.e;
import com.sdk.a.f;
import com.sdk.a.g;
import com.sdk.base.framework.bean.AInfo;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.bean.MobileKInfo;
import com.sdk.base.framework.bean.PInfo;
import com.sdk.base.framework.bean.SInfo;
import com.sdk.base.module.config.BaseConfig;
import com.sdk.d.j;
import com.sdk.f.c;
import com.sdk.f.f;
import com.sdk.p.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.Executor;
/* loaded from: classes9.dex */
public class b<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.g.b";
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public PInfo c;
    public AInfo d;
    public SInfo e;
    public ArrayList<KInfo> f;
    public com.sdk.e.a<T> g;
    public Context h;
    public String i;
    public c j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593137520, "Lcom/sdk/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593137520, "Lcom/sdk/g/b;");
                return;
            }
        }
        b = f.a;
    }

    public b(Context context, com.sdk.e.a<T> aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = context;
        this.g = aVar;
        this.j = cVar;
    }

    public void a(int i, int i2, String str) {
        com.sdk.e.a<T> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, str) == null) || (aVar = this.g) == null) {
            return;
        }
        aVar.a(i, i2, str);
        this.g = null;
    }

    public void a(int i, String str, int i2, T t, String str2) {
        com.sdk.e.a<T> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), t, str2}) == null) || (aVar = this.g) == null) {
            return;
        }
        aVar.onSuccess(i, str, i2, t, str2);
        this.g = null;
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [Params[], java.lang.Object[]] */
    public e<T> a(String str, String str2, DataInfo dataInfo, com.sdk.e.b<T> bVar, int i, f.a aVar) {
        InterceptResult invokeCommon;
        DataInfo dataInfo2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, dataInfo, bVar, Integer.valueOf(i), aVar})) == null) {
            e<T> eVar = null;
            if (com.sdk.o.a.a(str).booleanValue()) {
                a(1, 101008, "未检测到域名");
                return null;
            }
            if (dataInfo == null) {
                try {
                    dataInfo2 = new DataInfo();
                } catch (Exception e) {
                    e = e;
                    com.sdk.o.b.c(e.toString());
                    a(1, 302002, "网络访问异常:" + e.getMessage());
                    com.sdk.o.a.a(a + "BaseProtocol sendRequest", e.toString() + "，" + e.getMessage(), Boolean.valueOf(b));
                    return eVar;
                }
            } else {
                dataInfo2 = dataInfo;
            }
            TreeMap<String, Object> treeMap = new TreeMap<>();
            String a2 = com.sdk.r.a.a(16);
            String a3 = com.sdk.r.a.a(16);
            String a4 = com.sdk.j.a.a(this.h, BaseConfig.apk);
            int i2 = 2;
            String[] strArr = {a4, com.sdk.v.a.b};
            int i3 = 0;
            while (true) {
                if (i3 < i2) {
                    String str3 = strArr[i3];
                    if ((str3 == null || str3.length() < 1) && com.sdk.o.a.a(str3).booleanValue()) {
                        z = true;
                        break;
                    }
                    i3++;
                    i2 = 2;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                a(1, 101004, "ApiKey或PublicKey不能为空");
                return null;
            }
            String a5 = a(dataInfo2, a2, a3);
            try {
                com.sdk.r.f a6 = com.sdk.r.f.a();
                String a7 = a6.b.a(a6.c, a2 + a3);
                treeMap.put("apiKey", a4);
                treeMap.put("params", a5);
                treeMap.put("paramsKey", a7);
                treeMap.put("l", Long.valueOf(System.currentTimeMillis()));
                String a8 = com.sdk.t.a.a(a4, str2, treeMap);
                HashMap<String, Object> hashMap = new HashMap<>(16);
                if (com.sdk.o.a.b(a8).booleanValue()) {
                    treeMap.put("sign", a8);
                    treeMap.put("sign_Type", com.sdk.v.a.e);
                    hashMap.put("sign", a8);
                    hashMap.put("api-protocol", "1.1");
                }
                g gVar = new g();
                gVar.a(aVar.l);
                gVar.b(str + str2);
                gVar.j = bVar;
                gVar.i = i;
                gVar.f = treeMap;
                gVar.g = null;
                gVar.h = hashMap;
                if ("/dro/netm/v1.0/qc".equals(str2)) {
                    f.b bVar2 = f.b.b;
                }
                com.sdk.a.f fVar = new com.sdk.a.f(this.h, gVar);
                e<T> eVar2 = new e<>(fVar);
                try {
                    ?? r3 = {fVar};
                    Executor executor = com.sdk.d.e.b;
                    if (!eVar2.g) {
                        eVar2.g = true;
                        eVar2.c.a = r3;
                        executor.execute(new j(eVar2.i, eVar2.d));
                        return eVar2;
                    }
                    throw new IllegalStateException("Cannot execute task: the task is already executed.");
                } catch (Exception e2) {
                    e = e2;
                    eVar = eVar2;
                    com.sdk.o.b.c(e.toString());
                    a(1, 302002, "网络访问异常:" + e.getMessage());
                    com.sdk.o.a.a(a + "BaseProtocol sendRequest", e.toString() + "，" + e.getMessage(), Boolean.valueOf(b));
                    return eVar;
                }
            } catch (Exception e3) {
                a(1, 101006, "公钥出错");
                String str4 = a;
                StringBuilder sb = new StringBuilder();
                sb.append("公钥出错：");
                sb.append(e3);
                com.sdk.o.a.a(str4, sb.toString(), Boolean.valueOf(b));
                return null;
            }
        }
        return (e) invokeCommon.objValue;
    }

    public final String a(DataInfo dataInfo, String str, String str2) {
        String str3;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataInfo, str, str2)) == null) {
            try {
                if (this.d == null) {
                    this.d = com.sdk.f.a.a(this.h);
                }
                if (this.e == null) {
                    this.e = com.sdk.f.a.c();
                }
                if (this.f == null) {
                    this.f = com.sdk.f.a.a();
                }
                ArrayList arrayList = new ArrayList();
                Iterator<KInfo> it = this.f.iterator();
                while (it.hasNext()) {
                    KInfo next = it.next();
                    MobileKInfo mobileKInfo = new MobileKInfo();
                    mobileKInfo.setIe(next.getIe());
                    mobileKInfo.setIs(next.getIs());
                    mobileKInfo.setM(next.getM());
                    mobileKInfo.setIdfd(next.isIdfd());
                    arrayList.add(mobileKInfo);
                }
                if (this.c == null) {
                    this.c = com.sdk.f.a.b();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("{app:");
                sb.append(this.d);
                sb.append(",sdk:");
                sb.append(this.e);
                sb.append(",device:");
                sb.append(this.c);
                sb.append(",sim:");
                sb.append(arrayList);
                sb.append(",data:");
                sb.append(dataInfo);
                sb.append("}");
                str3 = sb.toString();
            } catch (Exception e) {
                com.sdk.o.a.a(a, e.toString(), Boolean.valueOf(b));
                str3 = null;
            }
            return com.sdk.r.f.a().b.a(str, str2, str3);
        }
        return (String) invokeLLL.objValue;
    }
}
