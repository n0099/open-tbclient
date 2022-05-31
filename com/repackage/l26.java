package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class l26 extends db1<i45> {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public static final String c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements i45 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(l26 l26Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l26Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.i45
        public boolean a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? s26.k().m(str) : invokeL.booleanValue;
        }

        @Override // com.repackage.i45
        @NonNull
        public String b(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? s26.k().j(str) : (String) invokeL.objValue;
        }

        @Override // com.repackage.i45
        @NonNull
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? l26.c : (String) invokeV.objValue;
        }

        @Override // com.repackage.i45
        @NonNull
        public String d(@NonNull String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
                s26 k = s26.k();
                boolean q = k.q(str);
                boolean r = k.r(str);
                String g = k.g(str, z);
                if (g == null) {
                    g = "";
                }
                return (q || r) ? g : e(k.h(str), g);
            }
            return (String) invokeLZ.objValue;
        }

        @Override // com.repackage.i45
        @NonNull
        public String e(@NonNull String str, @NonNull String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                return l26.b + File.separator + str + File.separator + str2;
            }
            return (String) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755580927, "Lcom/repackage/l26;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755580927, "Lcom/repackage/l26;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
        b = a + File.separator + ".emotions";
        c = a + File.separator + ".collect";
    }

    public l26() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.db1
    /* renamed from: c */
    public i45 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (i45) invokeV.objValue;
    }
}
