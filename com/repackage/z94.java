package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class z94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a> a;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public int c;
        public e84 d;
        public List<f84> e;
        public List<g84> f;
        public PMSAppInfo g;
        public boolean h;

        public a() {
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

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            e84 e84Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (super.equals(obj)) {
                    return true;
                }
                if (obj == null || (e84Var = this.d) == null || !(obj instanceof a)) {
                    return false;
                }
                return e84Var.equals(((a) obj).d);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                e84 e84Var = this.d;
                if (e84Var == null) {
                    return super.hashCode();
                }
                return e84Var.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("PMS Item: ");
                sb.append(this.b);
                if (this.d != null) {
                    sb.append(",pkgMain=");
                    sb.append(this.d);
                }
                if (this.g != null) {
                    sb.append(",appInfo=");
                    sb.append(this.g);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    public z94() {
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
}
