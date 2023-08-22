package com.huawei.hms.common.internal;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes10.dex */
public final class Objects {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static final class ToStringHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<String> a;
        public final Object b;

        public ToStringHelper(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = Preconditions.checkNotNull(obj);
            this.a = new ArrayList();
        }

        public /* synthetic */ ToStringHelper(Object obj, a aVar) {
            this(obj);
        }

        public final ToStringHelper add(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
                String str2 = (String) Preconditions.checkNotNull(str);
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(str2.length() + valueOf.length() + 1);
                sb.append(str2);
                sb.append("=");
                sb.append(valueOf);
                this.a.add(sb.toString());
                return this;
            }
            return (ToStringHelper) invokeLL.objValue;
        }

        public final String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String simpleName = this.b.getClass().getSimpleName();
                StringBuilder sb = new StringBuilder(100);
                sb.append(simpleName);
                sb.append('{');
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    sb.append(this.a.get(i));
                    if (i < size - 1) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                }
                sb.append('}');
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    public Objects() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new AssertionError("Uninstantiable");
    }

    public static boolean equal(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, obj2)) == null) {
            if (obj == obj2) {
                return true;
            }
            if (obj != null && obj.equals(obj2)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int hashCode(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, objArr)) == null) {
            return Arrays.hashCode(objArr);
        }
        return invokeL.intValue;
    }

    public static ToStringHelper toStringHelper(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            return new ToStringHelper(obj, null);
        }
        return (ToStringHelper) invokeL.objValue;
    }
}
