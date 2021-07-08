package d.a.p0.i1.f.k;

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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.p0.i1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1460a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f58364a;

        /* renamed from: b  reason: collision with root package name */
        public String f58365b;

        /* renamed from: c  reason: collision with root package name */
        public String f58366c;

        /* renamed from: d  reason: collision with root package name */
        public long f58367d;

        /* renamed from: e  reason: collision with root package name */
        public String f58368e;

        /* renamed from: f  reason: collision with root package name */
        public long f58369f;

        /* renamed from: g  reason: collision with root package name */
        public String f58370g;

        /* renamed from: h  reason: collision with root package name */
        public long f58371h;

        /* renamed from: i  reason: collision with root package name */
        public int f58372i;
        public int j;

        public C1460a() {
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
            this.f58364a = null;
            this.f58365b = null;
            this.f58366c = null;
            this.f58369f = 0L;
            this.f58370g = null;
            this.f58371h = 0L;
            this.f58372i = 0;
            this.j = 0;
        }
    }

    public static C1460a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1460a c1460a = new C1460a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c1460a.f58364a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c1460a.f58365b = optJSONObject.optString("user_id");
                    c1460a.f58366c = optJSONObject.optString("nick_name");
                    c1460a.f58367d = optJSONObject.optLong("caller_time");
                    c1460a.f58368e = optJSONObject.optString("caller_content");
                    c1460a.f58369f = optJSONObject.optLong("thread_id");
                    c1460a.f58370g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c1460a.f58371h = optJSONObject.optLong("post_id");
                    c1460a.f58372i = optJSONObject.optInt("msg_type");
                    c1460a.j = optJSONObject.optInt("remind_count");
                }
                return c1460a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1460a) invokeL.objValue;
    }
}
