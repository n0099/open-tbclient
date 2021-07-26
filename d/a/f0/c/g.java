package d.a.f0.c;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
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
public class g implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f42796e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f42797f;

    /* renamed from: g  reason: collision with root package name */
    public int f42798g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f42799h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f42800i;
    public boolean j;
    public g k;
    public boolean l;
    public JSONObject m;
    public String n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-197376800, "Ld/a/f0/c/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-197376800, "Ld/a/f0/c/g;");
                return;
            }
        }
        String str = c.b() + "://";
    }

    public g(Uri uri, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42796e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f42798g = -1;
        this.j = false;
        this.l = false;
        this.f42796e = str;
        this.f42797f = uri;
        this.f42799h = j.c(uri);
        this.f42800i = j.b(uri.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public g clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Uri uri = this.f42797f;
            g gVar = new g(uri, this.f42796e, j.c(uri), (HashMap) this.f42800i.clone());
            gVar.k = this;
            gVar.l = this.l;
            gVar.n = this.n;
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        String path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Uri uri = this.f42797f;
            if (uri != null) {
                if (j.d(uri) && (path = this.f42797f.getPath()) != null && path.length() > 1) {
                    return this.f42797f.getPath().substring(1);
                }
                return this.f42797f.getHost() + this.f42797f.getPath();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public HashMap<String, String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f42800i : (HashMap) invokeV.objValue;
    }

    public String g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (this.f42799h != null) {
                if (z) {
                    this.f42798g++;
                }
                int i2 = this.f42798g;
                String[] strArr = this.f42799h;
                if (i2 < strArr.length) {
                    return strArr[i2];
                }
                return null;
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    public Uri h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f42797f : (Uri) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void j(String str, String str2) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) || (uri = this.f42797f) == null || str == null || str2 == null) {
            return;
        }
        Uri parse = Uri.parse(uri.toString().replace(str, str2));
        this.f42797f = parse;
        this.f42799h = j.c(parse);
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.j = z;
        }
    }

    public g(Uri uri, String str, String[] strArr, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, str, strArr, hashMap};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f42796e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f42798g = -1;
        this.j = false;
        this.l = false;
        this.f42797f = uri;
        this.f42796e = str;
        this.f42799h = strArr;
        this.f42800i = hashMap;
    }
}
