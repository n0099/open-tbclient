package com.xiaomi.push.service;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public abstract class az {
    public static /* synthetic */ Interceptable $ic = null;
    public static String A = "ext_pkg_name";
    public static String B = "ext_notify_id";
    public static String C = "ext_notify_type";
    public static String D = "ext_session";
    public static String E = "sig";
    public static String F = "ext_notify_title";
    public static String G = "ext_notify_description";
    public static String H = "ext_messenger";
    public static String I = "title";
    public static String J = "description";
    public static String K = "notifyId";

    /* renamed from: a  reason: collision with root package name */
    public static String f77769a = "1";

    /* renamed from: b  reason: collision with root package name */
    public static String f77770b = "2";

    /* renamed from: c  reason: collision with root package name */
    public static String f77771c = "3";

    /* renamed from: d  reason: collision with root package name */
    public static String f77772d = "com.xiaomi.push.OPEN_CHANNEL";

    /* renamed from: e  reason: collision with root package name */
    public static String f77773e = "com.xiaomi.push.SEND_MESSAGE";

    /* renamed from: f  reason: collision with root package name */
    public static String f77774f = "com.xiaomi.push.SEND_IQ";

    /* renamed from: g  reason: collision with root package name */
    public static String f77775g = "com.xiaomi.push.BATCH_SEND_MESSAGE";

    /* renamed from: h  reason: collision with root package name */
    public static String f77776h = "com.xiaomi.push.SEND_PRES";

    /* renamed from: i  reason: collision with root package name */
    public static String f77777i = "com.xiaomi.push.CLOSE_CHANNEL";

    /* renamed from: j  reason: collision with root package name */
    public static String f77778j = "com.xiaomi.push.FORCE_RECONN";
    public static String k = "com.xiaomi.push.RESET_CONN";
    public static String l = "com.xiaomi.push.UPDATE_CHANNEL_INFO";
    public static String m = "com.xiaomi.push.SEND_STATS";
    public static String n = "com.xiaomi.push.CHANGE_HOST";
    public static String o = "com.xiaomi.push.PING_TIMER";
    public static String p = "ext_user_id";
    public static String q = "ext_user_server";
    public static String r = "ext_user_res";
    public static String s = "ext_chid";
    public static String t = "ext_sid";
    public static String u = "ext_token";
    public static String v = "ext_auth_method";
    public static String w = "ext_security";
    public static String x = "ext_kick";
    public static String y = "ext_client_attr";
    public static String z = "ext_cloud_attr";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1071162829, "Lcom/xiaomi/push/service/az;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1071162829, "Lcom/xiaomi/push/service/az;");
        }
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            switch (i2) {
                case 0:
                    return "ERROR_OK";
                case 1:
                    return "ERROR_SERVICE_NOT_INSTALLED";
                case 2:
                    return "ERROR_NETWORK_NOT_AVAILABLE";
                case 3:
                    return "ERROR_NETWORK_FAILED";
                case 4:
                    return "ERROR_ACCESS_DENIED";
                case 5:
                    return "ERROR_AUTH_FAILED";
                case 6:
                    return "ERROR_MULTI_LOGIN";
                case 7:
                    return "ERROR_SERVER_ERROR";
                case 8:
                    return "ERROR_RECEIVE_TIMEOUT";
                case 9:
                    return "ERROR_READ_ERROR";
                case 10:
                    return "ERROR_SEND_ERROR";
                case 11:
                    return "ERROR_RESET";
                case 12:
                    return "ERROR_NO_CLIENT";
                case 13:
                    return "ERROR_SERVER_STREAM";
                case 14:
                    return "ERROR_THREAD_BLOCK";
                case 15:
                    return "ERROR_SERVICE_DESTROY";
                case 16:
                    return "ERROR_SESSION_CHANGED";
                case 17:
                    return "ERROR_READ_TIMEOUT";
                case 18:
                    return "ERROR_CONNECTIING_TIMEOUT";
                case 19:
                    return "ERROR_USER_BLOCKED";
                case 20:
                    return "ERROR_REDIRECT";
                case 21:
                    return "ERROR_BIND_TIMEOUT";
                case 22:
                    return "ERROR_PING_TIMEOUT";
                default:
                    return String.valueOf(i2);
            }
        }
        return (String) invokeI.objValue;
    }
}
