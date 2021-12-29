package com.yxcorp.kuaishou.addfp.a.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public /* synthetic */ b a;

    public d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bVar;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
            } catch (Exception unused) {
                str3 = null;
            }
            return str3 == null ? "" : str3;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, IF, IGET, INVOKE, SGET, INVOKE, INVOKE, IF, IF, SGET, INVOKE, INVOKE, IF, IF, SGET, INVOKE] complete} */
    @Override // com.yxcorp.kuaishou.addfp.a.a.a
    public final void a(boolean z, com.yxcorp.kuaishou.addfp.a.b.a aVar) {
        String b2;
        com.yxcorp.kuaishou.addfp.android.a.e eVar;
        com.yxcorp.kuaishou.addfp.android.a.e eVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, aVar) == null) {
            if (z || aVar != null) {
                try {
                    b2 = aVar.b();
                    if (!TextUtils.isEmpty(b2)) {
                        b.a = b2;
                    }
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        try {
                            if (!TextUtils.isEmpty(b.a) && !b.a.startsWith("KWE")) {
                                eVar2 = this.a.f63872g;
                                eVar2.b(b.a);
                            }
                            if (aVar != null) {
                                aVar.d();
                                return;
                            }
                            return;
                        } catch (Throwable unused) {
                            return;
                        }
                    } finally {
                        try {
                            if (!TextUtils.isEmpty(b.a) && !b.a.startsWith("KWE")) {
                                eVar = this.a.f63872g;
                                eVar.b(b.a);
                            }
                            if (aVar != null) {
                                aVar.d();
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
            } else {
                b2 = null;
            }
            new StringBuilder("get OAID ").append(b2);
            b.a().b();
        }
    }
}
