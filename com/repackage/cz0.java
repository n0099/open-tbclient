package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class cz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final ArrayList<String> b;
    public final StringBuilder c;

    public cz0() {
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
        this.a = false;
        this.b = new ArrayList<>();
        this.c = new StringBuilder();
    }

    public static cz0 g(Column column) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, column)) == null) ? i(column.field, column.stringValue()) : (cz0) invokeL.objValue;
    }

    public static cz0 h(sy0 sy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sy0Var)) == null) {
            cz0 cz0Var = new cz0();
            cz0Var.f(null, sy0Var, " = ?");
            return cz0Var;
        }
        return (cz0) invokeL.objValue;
    }

    public static cz0 i(sy0 sy0Var, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, sy0Var, obj)) == null) {
            cz0 h = h(sy0Var);
            h.d(obj);
            return h;
        }
        return (cz0) invokeLL.objValue;
    }

    public static cz0 j(Column... columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, columnArr)) == null) {
            cz0 g = g(columnArr[0]);
            for (int i = 1; i < columnArr.length; i++) {
                g.b(columnArr[i].field, columnArr[i].stringValue());
            }
            return g;
        }
        return (cz0) invokeL.objValue;
    }

    public cz0 a(String str, sy0 sy0Var, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, sy0Var, str2)) == null) {
            this.a = true;
            this.c.append(" AND ");
            f(str, sy0Var, str2);
            return this;
        }
        return (cz0) invokeLLL.objValue;
    }

    public cz0 b(sy0 sy0Var, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sy0Var, obj)) == null) {
            c(null, sy0Var, obj);
            return this;
        }
        return (cz0) invokeLL.objValue;
    }

    public cz0 c(String str, sy0 sy0Var, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, sy0Var, obj)) == null) {
            a(str, sy0Var, " = ?");
            d(obj);
            return this;
        }
        return (cz0) invokeLLL.objValue;
    }

    public cz0 d(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, objArr)) == null) {
            for (Object obj : objArr) {
                this.b.add(String.valueOf(obj));
            }
            return this;
        }
        return (cz0) invokeL.objValue;
    }

    public String[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String[] strArr = new String[this.b.size()];
            for (int i = 0; i < this.b.size(); i++) {
                strArr[i] = this.b.get(i);
            }
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }

    public final void f(String str, sy0 sy0Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, sy0Var, str2) == null) {
            if (sy0Var != null) {
                if (str != null) {
                    this.c.append(str);
                    this.c.append(".");
                }
                this.c.append(sy0Var.b);
                if (str2.charAt(0) != ' ') {
                    this.c.append(" ");
                }
            } else if (str != null) {
                throw new IllegalArgumentException("prefix should be null when field is null");
            }
            this.c.append(str2);
        }
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) this.c);
            if (this.a) {
                sb.insert(0, "(");
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            sb.insert(0, " WHERE ");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) this.c);
            if (this.a) {
                sb.insert(0, "(");
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
