package com.bytedance.sdk.openadsdk.n.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.n.i;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<i.b> f68576a;

    /* renamed from: b  reason: collision with root package name */
    public f f68577b;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract int a();

    public i.b a(String str) {
        InterceptResult invokeL;
        List<i.b> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str != null && (list = this.f68576a) != null && list.size() > 0) {
                for (i.b bVar : this.f68576a) {
                    if (str.equals(bVar.f68662a)) {
                        return bVar;
                    }
                }
            }
            return null;
        }
        return (i.b) invokeL.objValue;
    }

    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            switch (i2) {
                case 200:
                    return StatHelper.SENSOR_OK;
                case 201:
                    return "Created";
                case 202:
                    return "Accepted";
                case 203:
                    return "Non-Authoritative";
                case 204:
                    return "No Content";
                case 205:
                    return "Reset Content";
                case 206:
                    return "Partial Content";
                default:
                    switch (i2) {
                        case 300:
                            return "Multiple Choices";
                        case 301:
                            return "Moved Permanently";
                        case 302:
                            return "Temporary Redirect";
                        case 303:
                            return "See Other";
                        case 304:
                            return "Not Modified";
                        case 305:
                            return "Use Proxy";
                        default:
                            switch (i2) {
                                case 400:
                                    return "Bad Request";
                                case 401:
                                    return "Unauthorized";
                                case 402:
                                    return "Payment Required";
                                case 403:
                                    return "Forbidden";
                                case 404:
                                    return "Not Found";
                                case 405:
                                    return "Method Not Allowed";
                                case 406:
                                    return "Not Acceptable";
                                case 407:
                                    return "Proxy Authentication Required";
                                case 408:
                                    return "Request Time-Out";
                                case 409:
                                    return "Conflict";
                                case 410:
                                    return "Gone";
                                case 411:
                                    return "Length Required";
                                case 412:
                                    return "Precondition Failed";
                                case 413:
                                    return "Request Entity Too Large";
                                case 414:
                                    return "Request-URI Too Large";
                                case 415:
                                    return "Unsupported Media Type";
                                default:
                                    switch (i2) {
                                        case 500:
                                            return "Internal Server Error";
                                        case 501:
                                            return "Not Implemented";
                                        case 502:
                                            return "Bad Gateway";
                                        case 503:
                                            return "Service Unavailable";
                                        case 504:
                                            return "Gateway Timeout";
                                        case 505:
                                            return "HTTP Version Not Supported";
                                        default:
                                            return "";
                                    }
                            }
                    }
            }
        }
        return (String) invokeI.objValue;
    }

    public abstract String a(String str, String str2);

    public abstract boolean b();

    public abstract List<i.b> c();

    public abstract InputStream d();

    public abstract String e();

    public abstract String f();

    public f g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f68577b : (f) invokeV.objValue;
    }
}
