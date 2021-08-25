package com.sdk.base.framework.d;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.a.h;
import com.sdk.base.framework.a.j;
import com.sdk.base.framework.a.k;
import com.sdk.base.framework.bean.AInfo;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.bean.MobileKInfo;
import com.sdk.base.framework.bean.PInfo;
import com.sdk.base.framework.bean.SInfo;
import com.sdk.base.framework.c.e;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.f.g.g;
import com.sdk.base.module.config.BaseConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes10.dex */
public class a<T> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f75376d = "com.sdk.base.framework.d.a";

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f75377e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f75378a;

    /* renamed from: b  reason: collision with root package name */
    public String f75379b;

    /* renamed from: c  reason: collision with root package name */
    public String f75380c;

    /* renamed from: f  reason: collision with root package name */
    public PInfo f75381f;

    /* renamed from: g  reason: collision with root package name */
    public AInfo f75382g;

    /* renamed from: h  reason: collision with root package name */
    public SInfo f75383h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<KInfo> f75384i;

    /* renamed from: j  reason: collision with root package name */
    public com.sdk.base.framework.b.a<T> f75385j;
    public e k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1040290235, "Lcom/sdk/base/framework/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1040290235, "Lcom/sdk/base/framework/d/a;");
                return;
            }
        }
        f75377e = f.f75370b;
    }

    public a() {
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

    public a(Context context, com.sdk.base.framework.b.a<T> aVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, eVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f75378a = context;
        this.f75385j = aVar;
        this.k = eVar;
    }

    private com.sdk.base.framework.a.f<T> a(String str, String str2, DataInfo dataInfo, ArrayList<File> arrayList, com.sdk.base.framework.b.b<T> bVar, int i2, j jVar) {
        InterceptResult invokeCommon;
        DataInfo dataInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{str, str2, dataInfo, arrayList, bVar, Integer.valueOf(i2), jVar})) == null) {
            com.sdk.base.framework.a.f<T> fVar = null;
            if (dataInfo == null) {
                try {
                    dataInfo2 = new DataInfo();
                } catch (Exception e2) {
                    e = e2;
                    com.sdk.base.framework.f.f.a.b(e.toString());
                    a(1, 302002, "网络访问异常");
                    c.b(f75376d, e.toString(), Boolean.valueOf(f75377e));
                    return fVar;
                }
            } else {
                dataInfo2 = dataInfo;
            }
            TreeMap<String, Object> treeMap = new TreeMap<>();
            String a2 = com.sdk.base.framework.f.i.a.a(this.f75378a);
            String a3 = com.sdk.base.framework.f.i.a.a(16);
            String a4 = com.sdk.base.framework.f.a.a.a(this.f75378a, BaseConfig.apk);
            String a5 = com.sdk.base.framework.f.b.a.a(this.f75378a, com.alipay.sdk.packet.e.m);
            if ("/st/api/v1.0/ses".equals(str2)) {
                a5 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCgdQaZgBcrXGxxD6F1TVVXAzvbB3xpoyk2AFMNj4vOcDWZoH1b3Mx5aVcEd0BZPZR6Icb8yi8ecMUVChGCRe20O8EQWLh1aCwR8JazNL+koD3Tn6TIwVwjVEQWy9w6DeXxMtQuFBL/jAChJcU7aDwMsSD1jYpdET37aB4p8Lvn2QIDAQAB";
            }
            if (c.a(a4, a5)) {
                a(1, 101004, "ApiKey或PublicKey不能为空");
                return null;
            }
            String a6 = a(dataInfo2, a3);
            try {
                String b2 = com.sdk.base.framework.f.h.b.b(a5, a2 + a3);
                treeMap.put("apiKey", a4);
                treeMap.put("params", a6);
                treeMap.put("paramsKey", b2);
                String a7 = com.sdk.base.framework.f.j.a.a(a4, str2, treeMap);
                HashMap<String, Object> hashMap = new HashMap<>(16);
                if (c.b(a7).booleanValue()) {
                    treeMap.put("sign", a7);
                    treeMap.put("sign_Type", "B");
                    hashMap.put("sign", a7);
                    hashMap.put("api-protocol", "1.1");
                }
                k kVar = new k();
                kVar.a(jVar.toString());
                kVar.b(str + str2);
                kVar.a(bVar);
                kVar.a(i2);
                kVar.a(treeMap);
                kVar.a((ArrayList<File>) null);
                kVar.a(hashMap);
                if ("/dro/netm/v1.0/qc".equals(str2)) {
                    g gVar = g.f75406a;
                } else if ("/dro/netm/v1.0/gctcbs".equals(str2)) {
                    g gVar2 = g.f75407b;
                }
                h hVar = new h(this.f75378a, kVar);
                com.sdk.base.framework.a.f<T> fVar2 = new com.sdk.base.framework.a.f<>(hVar);
                try {
                    fVar2.c(hVar);
                    return fVar2;
                } catch (Exception e3) {
                    e = e3;
                    fVar = fVar2;
                    com.sdk.base.framework.f.f.a.b(e.toString());
                    a(1, 302002, "网络访问异常");
                    c.b(f75376d, e.toString(), Boolean.valueOf(f75377e));
                    return fVar;
                }
            } catch (Exception e4) {
                a(1, 101006, "公钥出错");
                String str3 = f75376d;
                c.b(str3, "公钥出错：" + e4, Boolean.valueOf(f75377e));
                return null;
            }
        }
        return (com.sdk.base.framework.a.f) invokeCommon.objValue;
    }

    private String a(DataInfo dataInfo, String str) {
        String str2;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, dataInfo, str)) == null) {
            try {
                if (this.f75382g == null) {
                    this.f75382g = com.sdk.base.framework.c.a.a(this.f75378a);
                }
                if (this.f75383h == null) {
                    this.f75383h = com.sdk.base.framework.c.a.b();
                }
                if (this.f75384i == null) {
                    this.f75384i = com.sdk.base.framework.c.a.a();
                }
                ArrayList arrayList = new ArrayList();
                Iterator<KInfo> it = this.f75384i.iterator();
                while (it.hasNext()) {
                    KInfo next = it.next();
                    MobileKInfo mobileKInfo = new MobileKInfo();
                    mobileKInfo.setIe(next.getIe());
                    mobileKInfo.setIs(next.getIs());
                    mobileKInfo.setM(next.getM());
                    mobileKInfo.setIdfd(next.isIdfd());
                    arrayList.add(mobileKInfo);
                }
                if (this.f75381f == null) {
                    this.f75381f = com.sdk.base.framework.c.a.c();
                }
                StringBuilder sb = new StringBuilder("{app:");
                sb.append(this.f75382g);
                sb.append(",sdk:");
                sb.append(this.f75383h);
                sb.append(",device:");
                sb.append(this.f75381f);
                sb.append(",sim:");
                sb.append(arrayList);
                sb.append(",data:");
                sb.append(dataInfo);
                sb.append("}");
                str2 = sb.toString();
            } catch (Exception e2) {
                c.b(f75376d, e2.toString(), Boolean.valueOf(f75377e));
                str2 = null;
            }
            return com.sdk.base.framework.f.i.a.a(str2, com.sdk.base.framework.f.b.a.b(this.f75378a, f.f75369a), str);
        }
        return (String) invokeLL.objValue;
    }

    public final com.sdk.base.framework.a.f<T> a(String str, String str2, DataInfo dataInfo, com.sdk.base.framework.b.b<T> bVar, int i2, j jVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, dataInfo, bVar, Integer.valueOf(i2), jVar})) == null) {
            if (c.a(str).booleanValue()) {
                a(1, 101008, "未检测到域名");
                return null;
            }
            return a(str, str2, dataInfo, null, bVar, 0, jVar);
        }
        return (com.sdk.base.framework.a.f) invokeCommon.objValue;
    }

    public final com.sdk.base.framework.b.b<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this) : (com.sdk.base.framework.b.b) invokeV.objValue;
    }

    public final void a(int i2, int i3, String str) {
        com.sdk.base.framework.b.a<T> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) || (aVar = this.f75385j) == null) {
            return;
        }
        aVar.a(i2, i3, str);
        this.f75385j = null;
    }

    public final void a(int i2, String str, int i3, T t, String str2) {
        com.sdk.base.framework.b.a<T> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), t, str2}) == null) || (aVar = this.f75385j) == null) {
            return;
        }
        aVar.a(i2, str, i3, t, str2);
        this.f75385j = null;
    }
}
