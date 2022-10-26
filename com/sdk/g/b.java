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
import com.sdk.a.g;
import com.sdk.a.h;
import com.sdk.base.framework.bean.AInfo;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.bean.MobileKInfo;
import com.sdk.base.framework.bean.PInfo;
import com.sdk.base.framework.bean.SInfo;
import com.sdk.base.framework.utils.app.AppUtils;
import com.sdk.base.module.config.BaseConfig;
import com.sdk.d.j;
import com.sdk.f.c;
import com.sdk.f.g;
import com.sdk.o.f;
import com.sdk.q.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.Executor;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.g.b";
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public PInfo c;
    public AInfo d;
    public SInfo e;
    public ArrayList f;
    public com.sdk.e.a g;
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
        b = g.b;
    }

    public b(Context context, com.sdk.e.a aVar, c cVar) {
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
        com.sdk.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, str) == null) || (aVar = this.g) == null) {
            return;
        }
        aVar.a(i, i2, str);
        this.g = null;
    }

    public void a(int i, String str, int i2, Object obj, String str2) {
        com.sdk.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), obj, str2}) == null) || (aVar = this.g) == null) {
            return;
        }
        aVar.onSuccess(i, str, i2, obj, str2);
        this.g = null;
    }

    public e a(String str, String str2, DataInfo dataInfo, com.sdk.e.b bVar, int i, g.a aVar) {
        InterceptResult invokeCommon;
        DataInfo dataInfo2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, dataInfo, bVar, Integer.valueOf(i), aVar})) == null) {
            e eVar = null;
            if (com.sdk.n.a.a(str).booleanValue()) {
                a(1, 101008, "未检测到域名");
                return null;
            }
            if (dataInfo == null) {
                try {
                    dataInfo2 = new DataInfo();
                } catch (Exception e) {
                    e = e;
                }
            } else {
                dataInfo2 = dataInfo;
            }
            TreeMap treeMap = new TreeMap();
            String a2 = com.sdk.q.a.a(16);
            String a3 = com.sdk.q.a.a(16);
            String apiKey = AppUtils.getApiKey(this.h, BaseConfig.apk);
            String str3 = com.sdk.u.a.b;
            if ("/st/api/v1.0/ses".equals(str2)) {
                str3 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCgdQaZgBcrXGxxD6F1TVVXAzvbB3xpoyk2AFMNj4vOcDWZoH1b3Mx5aVcEd0BZPZR6Icb8yi8ecMUVChGCRe20O8EQWLh1aCwR8JazNL+koD3Tn6TIwVwjVEQWy9w6DeXxMtQuFBL/jAChJcU7aDwMsSD1jYpdET37aB4p8Lvn2QIDAQAB";
            }
            int i2 = 2;
            String[] strArr = {apiKey, str3};
            int i3 = 0;
            while (true) {
                if (i3 < i2) {
                    String str4 = strArr[i3];
                    if ((str4 == null || str4.length() < 1) && com.sdk.n.a.a(str4).booleanValue()) {
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
            String a4 = a(dataInfo2, a2, a3);
            try {
                f a5 = f.a();
                String a6 = a5.b.a(a5.c, a2 + a3);
                treeMap.put("apiKey", apiKey);
                treeMap.put("params", a4);
                treeMap.put("paramsKey", a6);
                treeMap.put("l", Long.valueOf(System.currentTimeMillis()));
                String a7 = com.sdk.s.a.a(apiKey, str2, treeMap);
                HashMap hashMap = new HashMap(16);
                if (com.sdk.n.a.b(a7).booleanValue()) {
                    treeMap.put("sign", a7);
                    treeMap.put("sign_Type", com.sdk.u.a.e);
                    hashMap.put("sign", a7);
                    hashMap.put("api-protocol", "1.1");
                }
                h hVar = new h();
                hVar.a(aVar.l);
                hVar.b(str + str2);
                hVar.j = bVar;
                hVar.i = i;
                hVar.f = treeMap;
                hVar.g = null;
                hVar.h = hashMap;
                if ("/dro/netm/v1.0/qc".equals(str2)) {
                    f.b bVar2 = f.b.b;
                }
                com.sdk.a.g gVar = new com.sdk.a.g(this.h, hVar);
                e eVar2 = new e(gVar);
                try {
                    Object[] objArr = {gVar};
                    Executor executor = com.sdk.d.e.b;
                    if (!eVar2.g) {
                        eVar2.g = true;
                        eVar2.c.a = objArr;
                        executor.execute(new j(eVar2.i, eVar2.d));
                        return eVar2;
                    }
                    throw new IllegalStateException("Cannot execute task: the task is already executed.");
                } catch (Exception e2) {
                    e = e2;
                    eVar = eVar2;
                    com.sdk.n.b.c(e.toString());
                    a(1, 302002, "网络访问异常:" + e.getMessage());
                    String str5 = a;
                    com.sdk.n.a.a(str5, e.toString() + "，" + e.getMessage(), Boolean.valueOf(b));
                    return eVar;
                }
            } catch (Exception e3) {
                a(1, 101006, "公钥出错");
                String str6 = a;
                StringBuilder sb = new StringBuilder();
                sb.append("公钥出错：");
                sb.append(e3);
                com.sdk.n.a.a(str6, sb.toString(), Boolean.valueOf(b));
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
                Iterator it = this.f.iterator();
                while (it.hasNext()) {
                    KInfo kInfo = (KInfo) it.next();
                    MobileKInfo mobileKInfo = new MobileKInfo();
                    mobileKInfo.setIe(kInfo.getIe());
                    mobileKInfo.setIs(kInfo.getIs());
                    mobileKInfo.setM(kInfo.getM());
                    mobileKInfo.setIdfd(kInfo.isIdfd());
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
                com.sdk.n.a.a(a, e.toString(), Boolean.valueOf(b));
                str3 = null;
            }
            return com.sdk.q.f.a().b.a(str, str2, str3);
        }
        return (String) invokeLLL.objValue;
    }
}
