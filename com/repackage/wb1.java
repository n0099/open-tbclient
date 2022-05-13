package com.repackage;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wb1 implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Uri b;
    public int c;
    public String[] d;
    public HashMap<String, String> e;
    public boolean f;
    public wb1 g;
    public boolean h;
    public JSONObject i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755207253, "Lcom/repackage/wb1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755207253, "Lcom/repackage/wb1;");
                return;
            }
        }
        String str = sb1.b() + "://";
    }

    public wb1(Uri uri, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.c = -1;
        this.f = false;
        this.h = false;
        this.a = str;
        this.b = uri;
        this.d = zb1.c(uri);
        this.e = zb1.b(uri.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public wb1 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Uri uri = this.b;
            wb1 wb1Var = new wb1(uri, this.a, zb1.c(uri), (HashMap) this.e.clone());
            wb1Var.g = this;
            wb1Var.h = this.h;
            wb1Var.j = this.j;
            return wb1Var;
        }
        return (wb1) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        String path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Uri uri = this.b;
            if (uri != null) {
                if (zb1.d(uri) && (path = this.b.getPath()) != null && path.length() > 1) {
                    return this.b.getPath().substring(1);
                }
                return this.b.getHost() + this.b.getPath();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public HashMap<String, String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (HashMap) invokeV.objValue;
    }

    public String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (this.d != null) {
                if (z) {
                    this.c++;
                }
                int i = this.c;
                String[] strArr = this.d;
                if (i < strArr.length) {
                    return strArr[i];
                }
                return null;
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public void f(String str, String str2) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || (uri = this.b) == null || str == null || str2 == null) {
            return;
        }
        Uri parse = Uri.parse(uri.toString().replace(str, str2));
        this.b = parse;
        this.d = zb1.c(parse);
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f = z;
        }
    }

    public wb1(Uri uri, String str, String[] strArr, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, str, strArr, hashMap};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.c = -1;
        this.f = false;
        this.h = false;
        this.b = uri;
        this.a = str;
        this.d = strArr;
        this.e = hashMap;
    }
}
