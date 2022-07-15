package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
/* loaded from: classes7.dex */
public class zl5 extends dc1<mh0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements mh0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zl5 c;

        /* renamed from: com.repackage.zl5$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0788a implements oh0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a f;

            public C0788a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = aVar;
            }

            @Override // com.repackage.oh0
            public String a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? am5.h().a() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? am5.h().d() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? am5.h().l() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? am5.h().o() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String e() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? am5.h().f() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String g() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? am5.h().b() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f.c.c() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String i() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? am5.h().n() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String j() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? am5.h().j() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String k() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "tieba" : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String l() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "2" : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String m() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? am5.h().p() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            @NonNull
            public String o() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? am5.h().e() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String p() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? am5.h().g() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String packageName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? am5.h().m() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String q() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? am5.h().c() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String t() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? am5.h().i() : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public String u() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "Tieba" : (String) invokeV.objValue;
            }

            @Override // com.repackage.oh0
            public boolean v() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        public a(zl5 zl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zl5Var;
        }

        @Override // com.repackage.mh0
        @NonNull
        public oh0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C0788a(this) : (oh0) invokeV.objValue;
        }
    }

    public zl5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.dc1
    /* renamed from: b */
    public mh0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (mh0) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        byte[] b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = "";
            String q = xt4.k().q("key_last_cached_real_oid", "");
            if (StringUtils.isNull(q)) {
                String k = am5.h().k();
                if (StringUtils.isNull(k)) {
                    return "";
                }
                String[] split = k.split("-");
                if (split != null && split.length > 1) {
                    String str2 = split[1];
                    if (StringUtils.isNull(str2) || (b = new x30("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(str2)) == null) {
                        return "";
                    }
                    try {
                        str = new String(b, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    if (!StringUtils.isNull(str)) {
                        xt4.k().y("key_last_cached_real_oid", str);
                    }
                }
                return str;
            }
            return q;
        }
        return (String) invokeV.objValue;
    }
}
