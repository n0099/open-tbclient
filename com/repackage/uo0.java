package com.repackage;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.exception.RequestError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.client.methods.HttpDelete;
/* loaded from: classes7.dex */
public class uo0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public URL a;
    public String b;
    public Headers.a c;
    @Nullable
    public to0 d;
    public Object e;
    public int f;
    public int g;
    public int h;
    public po0 i;
    public boolean j;

    public uo0() {
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
        this.j = true;
        this.b = "GET";
        this.c = new Headers.a();
        new Headers.a();
        this.f = 30000;
        this.g = 30000;
        this.h = 30000;
        this.i = do0.a().a(true);
    }

    public uo0 a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            this.c.a(str, str2);
            return this;
        }
        return (uo0) invokeLL.objValue;
    }

    public RequestError b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            RequestError requestError = this.a == null ? new RequestError("url is null") : null;
            if (this.d != null && !qo0.a(this.b)) {
                requestError = new RequestError("method " + this.b + " must not have a request body.");
            }
            if (this.d == null && qo0.b(this.b)) {
                return new RequestError("method " + this.b + " must have a request body.");
            }
            return requestError;
        }
        return (RequestError) invokeV.objValue;
    }

    public uo0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e("GET", null);
            return this;
        }
        return (uo0) invokeV.objValue;
    }

    public uo0 d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            this.c.e(str, str2);
            return this;
        }
        return (uo0) invokeLL.objValue;
    }

    public uo0 delete(@Nullable to0 to0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, to0Var)) == null) {
            e(HttpDelete.METHOD_NAME, to0Var);
            return this;
        }
        return (uo0) invokeL.objValue;
    }

    public uo0 e(String str, @Nullable to0 to0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, to0Var)) == null) {
            this.b = str;
            this.d = to0Var;
            return this;
        }
        return (uo0) invokeLL.objValue;
    }

    public uo0 f(to0 to0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, to0Var)) == null) {
            e("POST", to0Var);
            return this;
        }
        return (uo0) invokeL.objValue;
    }

    public uo0 g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.f = i;
            return this;
        }
        return (uo0) invokeI.objValue;
    }

    public uo0 h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.j = z;
            return this;
        }
        return (uo0) invokeZ.objValue;
    }

    public uo0 i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.g = i;
            return this;
        }
        return (uo0) invokeI.objValue;
    }

    public uo0 j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            this.h = i;
            return this;
        }
        return (uo0) invokeI.objValue;
    }

    public uo0 k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                this.a = null;
                return this;
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
            }
            try {
                l(new URL(str));
                return this;
            } catch (MalformedURLException | Exception unused) {
                l(null);
                return this;
            }
        }
        return (uo0) invokeL.objValue;
    }

    public uo0 l(URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, url)) == null) {
            this.a = url;
            return this;
        }
        return (uo0) invokeL.objValue;
    }

    public uo0 delete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? delete(to0.h) : (uo0) invokeV.objValue;
    }
}
