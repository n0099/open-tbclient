package com.huawei.hms.push;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.meizu.cloud.pushsdk.notification.model.AdvertisementOption;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public int B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public int t;
    public String u;
    public String v;
    public String w;
    public int x;
    public int y;
    public String z;

    public k(byte[] bArr, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, bArr2};
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
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.q = "";
        this.t = n.a.ordinal();
        this.u = "";
        this.v = "";
        this.w = "";
        this.x = 0;
        this.y = 0;
        this.A = "";
        this.C = "";
        this.E = "";
        this.F = "";
        this.r = new String(bArr, x.a);
        this.s = new String(bArr2, x.a);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.F;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.x;
        }
        return invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.v;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.u;
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.E;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            HMSLog.d("PushSelfShowLog", "msgId =" + this.e);
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.A;
        }
        return (String) invokeV.objValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.B;
        }
        return invokeV.intValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.D;
        }
        return (String) invokeV.objValue;
    }

    public byte[] y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.s.getBytes(x.a);
        }
        return (byte[]) invokeV.objValue;
    }

    public final JSONObject a(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
            jSONObject2.put("group", this.a);
            jSONObject2.put("tag", this.A);
            jSONObject2.put(RemoteMessageConst.Notification.AUTO_CANCEL, this.x);
            jSONObject2.put(RemoteMessageConst.Notification.VISIBILITY, this.y);
            jSONObject2.put(RemoteMessageConst.Notification.WHEN, this.z);
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final JSONObject b(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cmd", this.g);
            jSONObject2.put("content", this.h);
            jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_ICON, this.i);
            jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, this.j);
            jSONObject2.put("notifySummary", this.k);
            jSONObject2.put("param", jSONObject);
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final boolean e(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, jSONObject)) == null) {
            if (jSONObject.has("msgId")) {
                Object obj = jSONObject.get("msgId");
                if (obj instanceof String) {
                    this.e = (String) obj;
                    return true;
                } else if (obj instanceof Integer) {
                    this.e = String.valueOf(((Integer) obj).intValue());
                    return true;
                } else {
                    return true;
                }
            }
            HMSLog.i("PushSelfShowLog", "msgId == null");
            return false;
        }
        return invokeL.booleanValue;
    }

    public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, jSONObject2)) == null) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("dispPkgName", this.f);
            jSONObject3.put("msgId", this.e);
            jSONObject3.put(AdvertisementOption.AD_PACKAGE, this.d);
            jSONObject3.put("notifyId", this.B);
            jSONObject3.put(RemoteMessageConst.MessageBody.PS_CONTENT, jSONObject);
            jSONObject3.put(RemoteMessageConst.MessageBody.NOTIFY_DETAIL, jSONObject2);
            jSONObject3.put("ticker", this.D);
            jSONObject3.put("data", this.C);
            return jSONObject3;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.B = i;
        }
    }

    public final void c(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) && jSONObject.has(AdvertisementOption.AD_PACKAGE)) {
            String string = jSONObject.getString(AdvertisementOption.AD_PACKAGE);
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(string) && string.length() < 48) {
                int length = 48 - string.length();
                for (int i = 0; i < length; i++) {
                    sb.append("0");
                }
                sb.append(string);
                this.d = sb.toString();
                return;
            }
            this.d = string.substring(0, 48);
        }
    }

    public final boolean d(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            if (jSONObject.has(RemoteMessageConst.Notification.CLICK_ACTION)) {
                this.m = jSONObject.getString(RemoteMessageConst.Notification.CLICK_ACTION);
            }
            if (jSONObject.has(RemoteMessageConst.Notification.INTENT_URI)) {
                this.c = jSONObject.getString(RemoteMessageConst.Notification.INTENT_URI);
            }
            if (jSONObject.has("appPackageName")) {
                this.l = jSONObject.getString("appPackageName");
                return true;
            }
            HMSLog.d("PushSelfShowLog", "appPackageName is null");
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean f(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, jSONObject)) == null) {
            HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
                if (jSONObject2.has("style")) {
                    this.t = jSONObject2.getInt("style");
                }
                this.u = jSONObject2.optString("bigTitle");
                this.v = jSONObject2.optString("bigContent");
                this.E = jSONObject2.optString("icon");
                return true;
            } catch (JSONException e) {
                HMSLog.i("PushSelfShowLog", e.toString());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean j(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            if (jSONObject.has("appPackageName")) {
                this.l = jSONObject.getString("appPackageName");
            }
            if (jSONObject.has("rpt") && jSONObject.has("rpl")) {
                this.o = jSONObject.getString("rpl");
                this.p = jSONObject.getString("rpt");
                if (jSONObject.has("rpct")) {
                    this.q = jSONObject.getString("rpct");
                    return true;
                }
                return true;
            }
            HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            this.a = jSONObject.optString("group");
            HMSLog.d("PushSelfShowLog", "NOTIFY_GROUP:" + this.a);
            this.x = jSONObject.optInt(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
            HMSLog.d("PushSelfShowLog", "autoCancel: " + this.x);
            this.y = jSONObject.optInt(RemoteMessageConst.Notification.VISIBILITY, 0);
            this.z = jSONObject.optString(RemoteMessageConst.Notification.WHEN);
            this.A = jSONObject.optString("tag");
        }
    }

    public final boolean h(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, jSONObject)) == null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("param");
                if (jSONObject2.has("autoClear")) {
                    this.b = jSONObject2.getInt("autoClear");
                } else {
                    this.b = 0;
                }
                if (!"app".equals(this.g) && !"cosa".equals(this.g)) {
                    if ("url".equals(this.g)) {
                        k(jSONObject2);
                        return true;
                    } else if ("rp".equals(this.g)) {
                        j(jSONObject2);
                        return true;
                    } else {
                        return true;
                    }
                }
                d(jSONObject2);
                return true;
            } catch (Exception e) {
                HMSLog.e("PushSelfShowLog", "ParseParam error ", e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean i(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, jSONObject)) == null) {
            if (jSONObject.has(RemoteMessageConst.MessageBody.PS_CONTENT)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
                this.g = jSONObject2.getString("cmd");
                this.h = jSONObject2.optString("content");
                this.i = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_ICON);
                this.j = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_TITLE);
                this.k = jSONObject2.optString("notifySummary");
                this.D = jSONObject2.optString("ticker");
                if ((!jSONObject2.has(RemoteMessageConst.MessageBody.NOTIFY_DETAIL) || f(jSONObject2)) && jSONObject2.has("param")) {
                    return h(jSONObject2);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean k(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            if (jSONObject.has("url")) {
                this.n = jSONObject.getString("url");
                if (jSONObject.has("appPackageName")) {
                    this.l = jSONObject.getString("appPackageName");
                }
                if (jSONObject.has("rpt") && jSONObject.has("rpl")) {
                    this.o = jSONObject.getString("rpl");
                    this.p = jSONObject.getString("rpt");
                    if (jSONObject.has("rpct")) {
                        this.q = jSONObject.getString("rpct");
                        return true;
                    }
                    return true;
                }
                return true;
            }
            HMSLog.d("PushSelfShowLog", "url is null");
            return false;
        }
        return invokeL.booleanValue;
    }

    public byte[] o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            try {
                return a(a(b(v()), r())).toString().getBytes(x.a);
            } catch (JSONException e) {
                HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", e);
                return new byte[0];
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public final JSONObject r() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("style", this.t);
            jSONObject.put("bigTitle", this.u);
            jSONObject.put("bigContent", this.v);
            jSONObject.put("bigPic", this.w);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject v() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("autoClear", this.b);
            jSONObject.put("url", this.n);
            jSONObject.put("rpl", this.o);
            jSONObject.put("rpt", this.p);
            jSONObject.put("rpct", this.q);
            jSONObject.put("appPackageName", this.l);
            jSONObject.put(RemoteMessageConst.Notification.CLICK_ACTION, this.m);
            jSONObject.put(RemoteMessageConst.Notification.INTENT_URI, this.c);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            try {
                if (TextUtils.isEmpty(this.r)) {
                    HMSLog.d("PushSelfShowLog", "msg is null");
                    return false;
                }
                JSONObject jSONObject = new JSONObject(this.r);
                g(jSONObject);
                JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
                if (!e(jSONObject2)) {
                    return false;
                }
                this.f = jSONObject2.optString("dispPkgName");
                c(jSONObject2);
                this.B = jSONObject2.optInt("notifyId", -1);
                this.C = jSONObject2.optString("data");
                this.F = jSONObject2.optString(RemoteMessageConst.ANALYTIC_INFO);
                return i(jSONObject2);
            } catch (JSONException unused) {
                HMSLog.d("PushSelfShowLog", "parse message exception.");
                return false;
            } catch (Exception e) {
                HMSLog.d("PushSelfShowLog", e.toString());
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
