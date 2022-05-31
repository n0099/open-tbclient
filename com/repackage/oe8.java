package com.repackage;

import android.text.TextUtils;
import com.baidu.tieba.stampmission.message.StampMissionHttpRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class oe8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public String c;
    public String d;
    public int e;
    public int f;
    public int g;
    public b h;
    public String i;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                a aVar = new a();
                aVar.a = jSONObject.optString("name");
                jSONObject.optString("title");
                aVar.b = jSONObject.optString("pic");
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a a;
        public a b;
        public a c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static b a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                b bVar = new b();
                bVar.a = a.a(jSONObject.optJSONObject("follow_icon"));
                bVar.b = a.a(jSONObject.optJSONObject("like_icon"));
                bVar.c = a.a(jSONObject.optJSONObject("reply_icon"));
                return bVar;
            }
            return (b) invokeL.objValue;
        }
    }

    public oe8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static oe8 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return b(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (oe8) invokeL.objValue;
    }

    public static oe8 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            oe8 oe8Var = new oe8();
            oe8Var.a = jSONObject.optLong("effect_time", 0L);
            oe8Var.b = jSONObject.optLong("invalid_time", 0L);
            oe8Var.e = jSONObject.optInt(StampMissionHttpRequestMessage.TASK_FOLLOW, 0);
            oe8Var.f = jSONObject.optInt(StampMissionHttpRequestMessage.TASK_LIKE, 0);
            oe8Var.g = jSONObject.optInt(StampMissionHttpRequestMessage.TASK_REPLY, 0);
            oe8Var.c = jSONObject.optString("type");
            oe8Var.d = jSONObject.optString(StampMissionHttpRequestMessage.KEY_TASK_TYPE);
            oe8Var.h = b.a(jSONObject.optJSONObject("icon_info"));
            oe8Var.i = jSONObject.toString();
            return oe8Var;
        }
        return (oe8) invokeL.objValue;
    }
}
