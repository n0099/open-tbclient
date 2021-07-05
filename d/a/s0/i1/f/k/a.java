package d.a.s0.i1.f.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.s0.i1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1504a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f61599a;

        /* renamed from: b  reason: collision with root package name */
        public String f61600b;

        /* renamed from: c  reason: collision with root package name */
        public String f61601c;

        /* renamed from: d  reason: collision with root package name */
        public long f61602d;

        /* renamed from: e  reason: collision with root package name */
        public String f61603e;

        /* renamed from: f  reason: collision with root package name */
        public long f61604f;

        /* renamed from: g  reason: collision with root package name */
        public String f61605g;

        /* renamed from: h  reason: collision with root package name */
        public long f61606h;

        /* renamed from: i  reason: collision with root package name */
        public int f61607i;
        public int j;

        public C1504a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61599a = null;
            this.f61600b = null;
            this.f61601c = null;
            this.f61604f = 0L;
            this.f61605g = null;
            this.f61606h = 0L;
            this.f61607i = 0;
            this.j = 0;
        }
    }

    public static C1504a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1504a c1504a = new C1504a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c1504a.f61599a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c1504a.f61600b = optJSONObject.optString("user_id");
                    c1504a.f61601c = optJSONObject.optString("nick_name");
                    c1504a.f61602d = optJSONObject.optLong("caller_time");
                    c1504a.f61603e = optJSONObject.optString("caller_content");
                    c1504a.f61604f = optJSONObject.optLong("thread_id");
                    c1504a.f61605g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c1504a.f61606h = optJSONObject.optLong("post_id");
                    c1504a.f61607i = optJSONObject.optInt("msg_type");
                    c1504a.j = optJSONObject.optInt("remind_count");
                }
                return c1504a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1504a) invokeL.objValue;
    }
}
