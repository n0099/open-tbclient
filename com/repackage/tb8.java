package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes7.dex */
public class tb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Map<String, String> b;
    public LinkedList<BasicNameValuePair> c;
    public HashMap<String, byte[]> d;

    public tb8() {
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
        this.b = new HashMap();
        this.c = new LinkedList<>();
        this.d = new HashMap<>();
    }

    public void a(String str, String str2) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || (map = this.b) == null) {
            return;
        }
        map.put(str, str2);
    }

    public void b(BasicNameValuePair basicNameValuePair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, basicNameValuePair) == null) {
            this.c.add(basicNameValuePair);
        }
    }

    public String c(qb8 qb8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qb8Var)) == null) {
            if (this.c.size() == 0) {
                if (qb8Var != null) {
                    qb8Var.a = this.a.length();
                }
                return this.a;
            }
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.a);
            if (this.a.indexOf("?") < 0) {
                sb.append("?");
            } else if (!this.a.endsWith("?") && !this.a.endsWith("&")) {
                sb.append("&");
            }
            for (int i = 0; i < this.c.size(); i++) {
                if (i != 0) {
                    sb.append("&");
                }
                sb.append(this.c.get(i).getName());
                sb.append("=");
                sb.append(ni.getUrlEncode(this.c.get(i).getValue()));
            }
            if (qb8Var != null) {
                qb8Var.a = sb.length();
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HashMap<String, byte[]> hashMap = this.d;
            return hashMap != null && hashMap.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public final StringBuilder f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder(1024);
            LinkedList<BasicNameValuePair> linkedList = this.c;
            if (linkedList != null) {
                int i = 0;
                Iterator<BasicNameValuePair> it = linkedList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if (next != null) {
                        String name = next.getName();
                        String value = next.getValue();
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(name + "=");
                        sb.append(ni.getUrlEncode(value));
                        i++;
                    }
                }
            }
            return sb;
        }
        return (StringBuilder) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (str == null) {
                this.a = "";
            } else {
                this.a = str;
            }
        }
    }

    public void i(HttpURLConnection httpURLConnection) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, httpURLConnection) == null) || httpURLConnection == null || (map = this.b) == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public void j(HttpURLConnection httpURLConnection, qb8 qb8Var) throws Exception {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, httpURLConnection, qb8Var) == null) {
            if (httpURLConnection != null) {
                String sb = f().toString();
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.writeBytes(sb);
                    dataOutputStream.flush();
                    lg.d(dataOutputStream);
                    i = sb.length();
                } catch (Throwable th) {
                    lg.d(dataOutputStream);
                    throw th;
                }
            } else {
                i = 0;
            }
            if (qb8Var != null) {
                qb8Var.a = i;
            }
        }
    }

    public void k(HttpURLConnection httpURLConnection, String str, qb8 qb8Var) throws Exception {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, httpURLConnection, str, qb8Var) == null) {
            g();
            if (httpURLConnection != null) {
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    if (this.c != null) {
                        Iterator<BasicNameValuePair> it = this.c.iterator();
                        while (it.hasNext()) {
                            BasicNameValuePair next = it.next();
                            if (next != null) {
                                String name = next.getName();
                                String value = next.getValue();
                                if (value != null && name != null) {
                                    dataOutputStream.writeBytes("--" + str + "\r\n");
                                    byte[] bytes = value.getBytes("UTF-8");
                                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n");
                                    dataOutputStream.writeBytes("\r\n");
                                    dataOutputStream.write(bytes);
                                    dataOutputStream.writeBytes("\r\n");
                                }
                            }
                        }
                    }
                    if (this.d != null) {
                        for (Map.Entry<String, byte[]> entry : this.d.entrySet()) {
                            String key = entry.getKey();
                            byte[] value2 = entry.getValue();
                            if (value2 != null) {
                                dataOutputStream.writeBytes("--" + str + "\r\n");
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"\r\n");
                                dataOutputStream.writeBytes("\r\n");
                                dataOutputStream.write(value2);
                                dataOutputStream.writeBytes("\r\n");
                            }
                        }
                    }
                    dataOutputStream.writeBytes("--" + str + "--\r\n");
                    dataOutputStream.flush();
                    i = dataOutputStream.size();
                } finally {
                    lg.d(dataOutputStream);
                }
            } else {
                i = 0;
            }
            if (qb8Var != null) {
                qb8Var.a = i;
            }
        }
    }
}
