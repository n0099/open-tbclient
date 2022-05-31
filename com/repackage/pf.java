package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes6.dex */
public class pf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public HttpMessageTask.HTTP_METHOD c;
    public Map<String, String> d;
    public LinkedList<BasicNameValuePair> e;
    public Map<String, String> f;
    public HashMap<String, byte[]> g;
    public boolean h;
    public boolean i;

    public pf() {
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
        this.a = "";
        this.b = "";
        this.d = new HashMap();
        this.e = new LinkedList<>();
        this.f = new LinkedHashMap();
        this.g = new HashMap<>();
        this.h = false;
        this.i = false;
    }

    public void a(String str, String str2) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || (map = this.d) == null) {
            return;
        }
        map.put(str, str2);
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || str2 == null) {
            return;
        }
        this.e.add(new BasicNameValuePair(str, str2));
        this.f.put(str, str2);
    }

    public void c(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr) == null) {
            this.g.put(str, bArr);
        }
    }

    public void d(BasicNameValuePair basicNameValuePair) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, basicNameValuePair) == null) || basicNameValuePair == null || basicNameValuePair.getValue() == null) {
            return;
        }
        this.e.add(basicNameValuePair);
        this.f.put(basicNameValuePair.getName(), basicNameValuePair.getValue());
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public String f(boolean z, nf nfVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048581, this, z, nfVar)) == null) {
            String str = z ? this.b : this.a;
            if (this.e.size() == 0) {
                if (nfVar != null) {
                    nfVar.a = str.length();
                }
                return str;
            }
            StringBuilder sb = new StringBuilder(30);
            sb.append(str);
            if (str.indexOf("?") < 0) {
                sb.append("?");
            } else if (!str.endsWith("?") && !str.endsWith("&")) {
                sb.append("&");
            }
            for (int i = 0; i < this.e.size(); i++) {
                if (i != 0) {
                    sb.append("&");
                }
                sb.append(this.e.get(i).getName());
                sb.append("=");
                sb.append(ki.getUrlEncode(this.e.get(i).getValue()));
            }
            if (nfVar != null) {
                nfVar.a = sb.length();
            }
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            Map<String, String> map = this.d;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public Map<String, String> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (Map) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public HttpMessageTask.HTTP_METHOD j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c : (HttpMessageTask.HTTP_METHOD) invokeV.objValue;
    }

    public Map<String, String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f : (Map) invokeV.objValue;
    }

    public LinkedList<BasicNameValuePair> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.e : (LinkedList) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            HashMap<String, byte[]> hashMap = this.g;
            return hashMap != null && hashMap.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.i = z;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.h = z;
        }
    }

    public void r(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, hashMap) == null) {
            this.d = hashMap;
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || str == null) {
            return;
        }
        this.b = str;
    }

    public void t(HttpMessageTask.HTTP_METHOD http_method) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, http_method) == null) {
            this.c = http_method;
        }
    }

    public void u(List<Map.Entry<String, Object>> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || list == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : list) {
            Object value = entry.getValue();
            if (value != null) {
                if (value instanceof String) {
                    if (entry.getValue() != null) {
                        this.e.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                        this.f.put(entry.getKey(), (String) entry.getValue());
                    }
                } else if (value instanceof byte[]) {
                    this.g.put(entry.getKey(), (byte[]) entry.getValue());
                } else {
                    throw new UnsupportedOperationException("post type is not String and byte[]");
                }
            }
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            if (str == null) {
                this.a = "";
            } else {
                this.a = str;
            }
        }
    }

    public void w(HttpURLConnection httpURLConnection) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, httpURLConnection) == null) || httpURLConnection == null || (map = this.d) == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
