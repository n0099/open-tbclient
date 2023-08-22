package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class RemoteMessage implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<RemoteMessage> CREATOR;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    public static final String[] a;
    public static final int[] b;
    public static final long[] c;
    public static final HashMap<String, Object> d;
    public static final HashMap<String, Object> e;
    public static final HashMap<String, Object> f;
    public static final HashMap<String, Object> g;
    public static final HashMap<String, Object> h;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle i;
    public Notification j;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes10.dex */
    public @interface MessagePriority {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes10.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Bundle a;
        public final Map<String, String> b;

        public Builder(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new Bundle();
            this.b = new HashMap();
            this.a.putString("to", str);
        }

        public Builder setData(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
                this.b.clear();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    this.b.put(entry.getKey(), entry.getValue());
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addData(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                if (str != null) {
                    this.b.put(str, str2);
                    return this;
                }
                throw new IllegalArgumentException("add data failed, key is null.");
            }
            return (Builder) invokeLL.objValue;
        }

        public RemoteMessage build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Bundle bundle = new Bundle();
                JSONObject jSONObject = new JSONObject();
                try {
                    for (Map.Entry<String, String> entry : this.b.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    try {
                        String jSONObject2 = jSONObject.toString();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(RemoteMessageConst.COLLAPSE_KEY, this.a.getString(RemoteMessageConst.COLLAPSE_KEY));
                        jSONObject3.put("ttl", this.a.getInt("ttl"));
                        jSONObject3.put(RemoteMessageConst.SEND_MODE, this.a.getInt(RemoteMessageConst.SEND_MODE));
                        jSONObject3.put(RemoteMessageConst.RECEIPT_MODE, this.a.getInt(RemoteMessageConst.RECEIPT_MODE));
                        JSONObject jSONObject4 = new JSONObject();
                        if (jSONObject.length() != 0) {
                            jSONObject4.put("data", jSONObject2);
                        }
                        jSONObject4.put("msgId", this.a.getString("msgId"));
                        jSONObject3.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject4);
                        bundle.putByteArray(RemoteMessageConst.MSGBODY, jSONObject3.toString().getBytes(x.a));
                        bundle.putString("to", this.a.getString("to"));
                        bundle.putString("message_type", this.a.getString("message_type"));
                        return new RemoteMessage(bundle);
                    } catch (JSONException unused) {
                        HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
                        throw new PushException(PushException.EXCEPTION_SEND_FAILED);
                    }
                } catch (JSONException unused2) {
                    HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
                    throw new PushException(PushException.EXCEPTION_SEND_FAILED);
                }
            }
            return (RemoteMessage) invokeV.objValue;
        }

        public Builder clearData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.b.clear();
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder setCollapseKey(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.a.putString(RemoteMessageConst.COLLAPSE_KEY, str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMessageId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.a.putString("msgId", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMessageType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.a.putString("message_type", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setReceiptMode(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                if (i != 1 && i != 0) {
                    throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
                }
                this.a.putInt(RemoteMessageConst.RECEIPT_MODE, i);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSendMode(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                if (i != 0 && i != 1) {
                    throw new IllegalArgumentException("send mode can only be 0 or 1.");
                }
                this.a.putInt(RemoteMessageConst.SEND_MODE, i);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTtl(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                if (i >= 1 && i <= 1296000) {
                    this.a.putInt("ttl", i);
                    return this;
                }
                throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
            }
            return (Builder) invokeI.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class Notification implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long[] A;
        public final String B;
        public final String a;
        public final String b;
        public final String[] c;
        public final String d;
        public final String e;
        public final String[] f;
        public final String g;
        public final String h;
        public final String i;
        public final String j;
        public final String k;
        public final String l;
        public final String m;
        public final Uri n;
        public final int o;
        public final String p;
        public final int q;
        public final int r;
        public final int s;
        public final int[] t;
        public final String u;
        public final int v;
        public final String w;
        public final int x;
        public final String y;
        public final String z;

        public Notification(Bundle bundle) {
            Uri uri;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bundle.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.d = bundle.getString("content");
            this.b = bundle.getString(RemoteMessageConst.Notification.TITLE_LOC_KEY);
            this.e = bundle.getString(RemoteMessageConst.Notification.BODY_LOC_KEY);
            this.c = bundle.getStringArray(RemoteMessageConst.Notification.TITLE_LOC_ARGS);
            this.f = bundle.getStringArray(RemoteMessageConst.Notification.BODY_LOC_ARGS);
            this.g = bundle.getString("icon");
            this.j = bundle.getString("color");
            this.h = bundle.getString(RemoteMessageConst.Notification.SOUND);
            this.i = bundle.getString("tag");
            this.m = bundle.getString("channelId");
            this.k = bundle.getString(RemoteMessageConst.Notification.CLICK_ACTION);
            this.l = bundle.getString(RemoteMessageConst.Notification.INTENT_URI);
            this.o = bundle.getInt("notifyId");
            String string = bundle.getString("url");
            if (!TextUtils.isEmpty(string)) {
                uri = Uri.parse(string);
            } else {
                uri = null;
            }
            this.n = uri;
            this.p = bundle.getString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.q = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS);
            this.r = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_SOUND);
            this.s = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS);
            this.t = bundle.getIntArray(RemoteMessageConst.Notification.LIGHT_SETTINGS);
            this.u = bundle.getString(RemoteMessageConst.Notification.WHEN);
            this.v = bundle.getInt(RemoteMessageConst.Notification.LOCAL_ONLY);
            this.w = bundle.getString(RemoteMessageConst.Notification.BADGE_SET_NUM, null);
            this.x = bundle.getInt(RemoteMessageConst.Notification.AUTO_CANCEL);
            this.y = bundle.getString("priority", null);
            this.z = bundle.getString("ticker");
            this.A = bundle.getLongArray(RemoteMessageConst.Notification.VIBRATE_TIMINGS);
            this.B = bundle.getString("visibility", null);
        }

        public /* synthetic */ Notification(Bundle bundle, b bVar) {
            this(bundle);
        }

        public final Integer a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str != null) {
                    try {
                        return Integer.valueOf(str);
                    } catch (NumberFormatException unused) {
                        HMSLog.w("RemoteMessage", "NumberFormatException: get " + str + " failed.");
                    }
                }
                return null;
            }
            return (Integer) invokeL.objValue;
        }

        public Integer getBadgeNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return a(this.w);
            }
            return (Integer) invokeV.objValue;
        }

        public String getBody() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }

        public String[] getBodyLocalizationArgs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                String[] strArr = this.f;
                if (strArr == null) {
                    return new String[0];
                }
                return (String[]) strArr.clone();
            }
            return (String[]) invokeV.objValue;
        }

        public String getBodyLocalizationKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.e;
            }
            return (String) invokeV.objValue;
        }

        public String getChannelId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.m;
            }
            return (String) invokeV.objValue;
        }

        public String getClickAction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.k;
            }
            return (String) invokeV.objValue;
        }

        public String getColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.j;
            }
            return (String) invokeV.objValue;
        }

        public String getIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.g;
            }
            return (String) invokeV.objValue;
        }

        public Uri getImageUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                String str = this.p;
                if (str == null) {
                    return null;
                }
                return Uri.parse(str);
            }
            return (Uri) invokeV.objValue;
        }

        public Integer getImportance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return a(this.y);
            }
            return (Integer) invokeV.objValue;
        }

        public String getIntentUri() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.l;
            }
            return (String) invokeV.objValue;
        }

        public int[] getLightSettings() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                int[] iArr = this.t;
                if (iArr == null) {
                    return new int[0];
                }
                return (int[]) iArr.clone();
            }
            return (int[]) invokeV.objValue;
        }

        public Uri getLink() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.n;
            }
            return (Uri) invokeV.objValue;
        }

        public int getNotifyId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.o;
            }
            return invokeV.intValue;
        }

        public String getSound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.h;
            }
            return (String) invokeV.objValue;
        }

        public String getTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.i;
            }
            return (String) invokeV.objValue;
        }

        public String getTicker() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.z;
            }
            return (String) invokeV.objValue;
        }

        public String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public String[] getTitleLocalizationArgs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                String[] strArr = this.c;
                if (strArr == null) {
                    return new String[0];
                }
                return (String[]) strArr.clone();
            }
            return (String[]) invokeV.objValue;
        }

        public String getTitleLocalizationKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public long[] getVibrateConfig() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                long[] jArr = this.A;
                if (jArr == null) {
                    return new long[0];
                }
                return (long[]) jArr.clone();
            }
            return (long[]) invokeV.objValue;
        }

        public Integer getVisibility() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return a(this.B);
            }
            return (Integer) invokeV.objValue;
        }

        public boolean isAutoCancel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                if (this.x == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isDefaultLight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                if (this.q == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isDefaultSound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                if (this.r == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isDefaultVibrate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                if (this.s == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isLocalOnly() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                if (this.v == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public Long getWhen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                if (!TextUtils.isEmpty(this.u)) {
                    try {
                        return Long.valueOf(DateUtil.parseUtcToMillisecond(this.u));
                    } catch (StringIndexOutOfBoundsException unused) {
                        HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                    } catch (ParseException unused2) {
                        HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
                    }
                }
                return null;
            }
            return (Long) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-41290976, "Lcom/huawei/hms/push/RemoteMessage;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-41290976, "Lcom/huawei/hms/push/RemoteMessage;");
                return;
            }
        }
        a = new String[0];
        b = new int[0];
        c = new long[0];
        HashMap<String, Object> hashMap = new HashMap<>(8);
        d = hashMap;
        hashMap.put("from", "");
        d.put(RemoteMessageConst.COLLAPSE_KEY, "");
        d.put(RemoteMessageConst.SEND_TIME, "");
        d.put("ttl", 86400);
        d.put(RemoteMessageConst.URGENCY, 2);
        d.put(RemoteMessageConst.ORI_URGENCY, 2);
        d.put(RemoteMessageConst.SEND_MODE, 0);
        d.put(RemoteMessageConst.RECEIPT_MODE, 0);
        HashMap<String, Object> hashMap2 = new HashMap<>(8);
        e = hashMap2;
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_KEY, "");
        e.put(RemoteMessageConst.Notification.BODY_LOC_KEY, "");
        e.put(RemoteMessageConst.Notification.NOTIFY_ICON, "");
        e.put(RemoteMessageConst.Notification.TITLE_LOC_ARGS, a);
        e.put(RemoteMessageConst.Notification.BODY_LOC_ARGS, a);
        e.put("ticker", "");
        e.put(RemoteMessageConst.Notification.NOTIFY_TITLE, "");
        e.put("content", "");
        HashMap<String, Object> hashMap3 = new HashMap<>(8);
        f = hashMap3;
        hashMap3.put("icon", "");
        f.put("color", "");
        f.put(RemoteMessageConst.Notification.SOUND, "");
        f.put(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS, 1);
        f.put(RemoteMessageConst.Notification.LIGHT_SETTINGS, b);
        f.put(RemoteMessageConst.Notification.DEFAULT_SOUND, 1);
        f.put(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS, 1);
        f.put(RemoteMessageConst.Notification.VIBRATE_TIMINGS, c);
        HashMap<String, Object> hashMap4 = new HashMap<>(8);
        g = hashMap4;
        hashMap4.put("tag", "");
        g.put(RemoteMessageConst.Notification.WHEN, "");
        g.put(RemoteMessageConst.Notification.LOCAL_ONLY, 1);
        g.put(RemoteMessageConst.Notification.BADGE_SET_NUM, "");
        g.put("priority", "");
        g.put(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        g.put("visibility", "");
        g.put("channelId", "");
        HashMap<String, Object> hashMap5 = new HashMap<>(3);
        h = hashMap5;
        hashMap5.put(RemoteMessageConst.Notification.CLICK_ACTION, "");
        h.put(RemoteMessageConst.Notification.INTENT_URI, "");
        h.put("url", "");
        CREATOR = new b();
    }

    public RemoteMessage(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = a(bundle);
    }

    public RemoteMessage(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = parcel.readBundle();
        this.j = (Notification) parcel.readSerializable();
    }

    public static JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject != null) {
                return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject b(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) {
            try {
                return new JSONObject(w.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jSONObject)) == null) {
            if (jSONObject != null) {
                return jSONObject.optJSONObject("param");
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) {
            if (jSONObject != null) {
                return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jSONObject)) == null) {
            if (jSONObject != null) {
                return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            JSONObject b2 = b(bundle);
            JSONObject a2 = a(b2);
            String string = JsonUtil.getString(a2, "data", null);
            bundle2.putString(RemoteMessageConst.ANALYTIC_INFO, JsonUtil.getString(a2, RemoteMessageConst.ANALYTIC_INFO, null));
            bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, bundle.getString(RemoteMessageConst.DEVICE_TOKEN));
            JSONObject d2 = d(a2);
            JSONObject b3 = b(d2);
            JSONObject c2 = c(d2);
            if (bundle.getInt(RemoteMessageConst.INPUT_TYPE) == 1 && s.a(a2, d2, string)) {
                bundle2.putString("data", w.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
                return bundle2;
            }
            String string2 = bundle.getString("to");
            String string3 = bundle.getString("message_type");
            String string4 = JsonUtil.getString(a2, "msgId", null);
            bundle2.putString("to", string2);
            bundle2.putString("data", string);
            bundle2.putString("msgId", string4);
            bundle2.putString("message_type", string3);
            JsonUtil.transferJsonObjectToBundle(b2, bundle2, d);
            bundle2.putBundle("notification", a(b2, a2, d2, b3, c2));
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    public final Bundle a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, jSONObject2, jSONObject3, jSONObject4, jSONObject5)) == null) {
            Bundle bundle = new Bundle();
            JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, e);
            JsonUtil.transferJsonObjectToBundle(jSONObject4, bundle, f);
            JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, g);
            JsonUtil.transferJsonObjectToBundle(jSONObject5, bundle, h);
            bundle.putInt("notifyId", JsonUtil.getInt(jSONObject2, "notifyId", 0));
            return bundle;
        }
        return (Bundle) invokeLLLLL.objValue;
    }

    public String getAnalyticInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i.getString(RemoteMessageConst.ANALYTIC_INFO);
        }
        return (String) invokeV.objValue;
    }

    public String getCollapseKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i.getString(RemoteMessageConst.COLLAPSE_KEY);
        }
        return (String) invokeV.objValue;
    }

    public String getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i.getString("data");
        }
        return (String) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i.getString("from");
        }
        return (String) invokeV.objValue;
    }

    public String getMessageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.i.getString("msgId");
        }
        return (String) invokeV.objValue;
    }

    public String getMessageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.i.getString("message_type");
        }
        return (String) invokeV.objValue;
    }

    public int getOriginalUrgency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = this.i.getInt(RemoteMessageConst.ORI_URGENCY);
            if (i != 1 && i != 2) {
                return 0;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public int getReceiptMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.i.getInt(RemoteMessageConst.RECEIPT_MODE);
        }
        return invokeV.intValue;
    }

    public int getSendMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.i.getInt(RemoteMessageConst.SEND_MODE);
        }
        return invokeV.intValue;
    }

    public long getSentTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            try {
                String string = this.i.getString(RemoteMessageConst.SEND_TIME);
                if (TextUtils.isEmpty(string)) {
                    return 0L;
                }
                return Long.parseLong(string);
            } catch (NumberFormatException unused) {
                HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public String getTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.i.getString("to");
        }
        return (String) invokeV.objValue;
    }

    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.i.getString(RemoteMessageConst.DEVICE_TOKEN);
        }
        return (String) invokeV.objValue;
    }

    public int getTtl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.i.getInt("ttl");
        }
        return invokeV.intValue;
    }

    public int getUrgency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int i = this.i.getInt(RemoteMessageConst.URGENCY);
            if (i != 1 && i != 2) {
                return 0;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public Map<String, String> getAnalyticInfoMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HashMap hashMap = new HashMap();
            String string = this.i.getString(RemoteMessageConst.ANALYTIC_INFO);
            if (string != null && !string.trim().isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String valueOf = String.valueOf(keys.next());
                        hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                    }
                } catch (JSONException unused) {
                    HMSLog.w("RemoteMessage", "JSONException: get analyticInfo from map failed.");
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, String> getDataOfMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            HashMap hashMap = new HashMap();
            String string = this.i.getString("data");
            if (string != null && !string.trim().isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String valueOf = String.valueOf(keys.next());
                        hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                    }
                } catch (JSONException unused) {
                    HMSLog.w("RemoteMessage", "JSONException: get data from map failed");
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public Notification getNotification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Bundle bundle = this.i.getBundle("notification");
            if (this.j == null && bundle != null) {
                this.j = new Notification(bundle, null);
            }
            if (this.j == null) {
                this.j = new Notification(new Bundle(), null);
            }
            return this.j;
        }
        return (Notification) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, parcel, i) == null) {
            parcel.writeBundle(this.i);
            parcel.writeSerializable(this.j);
        }
    }
}
