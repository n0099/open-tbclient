package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.RtcCertificatePem;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String o = "d";
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, List<String>> a;
    public byte[] b;
    public int c;
    public long d;
    public long e;
    public long f;
    public String g;
    public int h;
    public int i;
    public String j;
    public long k;
    public String l;
    public Exception m;
    public String n;

    public d(int i, Map<String, List<String>> map, byte[] bArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), map, bArr, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.h = 2;
        this.i = 9001;
        this.j = "";
        this.k = 0L;
        this.l = "";
        this.c = i;
        this.a = map;
        this.b = ByteBuffer.wrap(bArr).array();
        this.d = j;
        s();
    }

    public d(Exception exc, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {exc, Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.h = 2;
        this.i = 9001;
        this.j = "";
        this.k = 0L;
        this.l = "";
        this.m = exc;
        this.d = j;
    }

    private void a(Map<String, String> map) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, map) == null) {
            if (map.containsKey(Headers.ETAG)) {
                String str3 = map.get(Headers.ETAG);
                if (!TextUtils.isEmpty(str3)) {
                    Logger.i(o, "success get Etag from server");
                    a(str3);
                    return;
                }
                str = o;
                str2 = "The Response Heads Etag is Empty";
            } else {
                str = o;
                str2 = "Response Heads has not Etag";
            }
            Logger.i(str, str2);
        }
    }

    private void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
            this.i = i;
        }
    }

    private void b(Map<String, String> map) {
        long time;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, map) == null) {
            if (map.containsKey(Headers.CACHE_CONTROL)) {
                String str = map.get(Headers.CACHE_CONTROL);
                if (!TextUtils.isEmpty(str) && str.contains("max-age=")) {
                    try {
                        time = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                        try {
                            Logger.v(o, "Cache-Control value{%s}", Long.valueOf(time));
                        } catch (NumberFormatException e) {
                            e = e;
                            Logger.w(o, "getExpireTime addHeadersToResult NumberFormatException", e);
                            long j = ((time > 0 || time > RtcCertificatePem.DEFAULT_EXPIRY) ? 86400L : 86400L) * 1000;
                            Logger.i(o, "convert expireTime{%s}", Long.valueOf(j));
                            c(String.valueOf(j + System.currentTimeMillis()));
                        }
                    } catch (NumberFormatException e2) {
                        e = e2;
                        time = 0;
                    }
                }
                time = 0;
            } else {
                if (map.containsKey(Headers.EXPIRES)) {
                    String str2 = map.get(Headers.EXPIRES);
                    Logger.v(o, "expires is{%s}", str2);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
                    String str3 = map.containsKey("Date") ? map.get("Date") : null;
                    try {
                        time = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
                    } catch (ParseException e3) {
                        Logger.w(o, "getExpireTime ParseException.", e3);
                    }
                } else {
                    Logger.i(o, "response headers neither contains Cache-Control nor Expires.");
                }
                time = 0;
            }
            long j2 = ((time > 0 || time > RtcCertificatePem.DEFAULT_EXPIRY) ? 86400L : 86400L) * 1000;
            Logger.i(o, "convert expireTime{%s}", Long.valueOf(j2));
            c(String.valueOf(j2 + System.currentTimeMillis()));
        }
    }

    private void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            this.h = i;
        }
    }

    private void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, this, j) == null) {
            this.k = j;
        }
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            this.j = str;
        }
    }

    private void c(Map<String, String> map) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, map) == null) {
            if (map.containsKey("Retry-After")) {
                String str = map.get("Retry-After");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        j = Long.parseLong(str);
                    } catch (NumberFormatException e) {
                        Logger.w(o, "getRetryAfter addHeadersToResult NumberFormatException", e);
                    }
                    long j2 = j * 1000;
                    Logger.v(o, "convert retry-afterTime{%s}", Long.valueOf(j2));
                    c(j2);
                }
            }
            j = 0;
            long j22 = j * 1000;
            Logger.v(o, "convert retry-afterTime{%s}", Long.valueOf(j22));
            c(j22);
        }
    }

    private void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
        }
    }

    private void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
        }
    }

    private void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            this.g = str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r9.getInt("resultCode") == 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (m()) {
                Logger.i(o, "GRSSDK get httpcode{304} not any changed.");
                c(1);
            } else if (!o()) {
                Logger.i(o, "GRSSDK parse server body all failed.");
                c(2);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(StringUtils.byte2Str(this.b));
                    int i = -1;
                    if (jSONObject.has("isSuccess")) {
                        if (jSONObject.getInt("isSuccess") == 1) {
                            i = 1;
                        }
                        i = 2;
                    } else if (!jSONObject.has("resultCode")) {
                        Logger.e(o, "sth. wrong because server errorcode's key.");
                    }
                    if (i != 1 && jSONObject.has("services")) {
                        i = 0;
                    }
                    c(i);
                    if (i == 1 || i == 0) {
                        f(jSONObject.has("services") ? jSONObject.getJSONObject("services").toString() : "");
                        e(jSONObject.has("errorList") ? jSONObject.getJSONObject("errorList").toString() : "");
                        return;
                    }
                    b(jSONObject.has("errorCode") ? jSONObject.getInt("errorCode") : 9001);
                    d(jSONObject.has("errorDesc") ? jSONObject.getString("errorDesc") : "");
                } catch (JSONException e) {
                    Logger.w(o, "GrsResponse GrsResponse(String result) JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
                    c(2);
                }
            }
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (o() || n() || m()) {
                Map<String, String> r = r();
                if (r.size() <= 0) {
                    Logger.w(o, "parseHeader {headers.size() <= 0}");
                    return;
                }
                try {
                    if (o() || m()) {
                        b(r);
                        a(r);
                    }
                    if (n()) {
                        c(r);
                    }
                } catch (JSONException e) {
                    Logger.w(o, "parseHeader catch JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
                }
            }
        }
    }

    private Map<String, String> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            HashMap hashMap = new HashMap(16);
            Map<String, List<String>> map = this.a;
            if (map == null || map.size() <= 0) {
                Logger.v(o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
                return hashMap;
            }
            for (Map.Entry<String, List<String>> entry : this.a.entrySet()) {
                String key = entry.getKey();
                for (String str : entry.getValue()) {
                    hashMap.put(key, str);
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            q();
            p();
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f = j;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.l = str;
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.intValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.e = j;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.n = str;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.i : invokeV.intValue;
    }

    public Exception d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : (Exception) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.h : invokeV.intValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f : invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.e : invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.d : invokeV.longValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k : invokeV.longValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.c == 304 : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.c == 503 : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.c == 200 : invokeV.booleanValue;
    }
}
