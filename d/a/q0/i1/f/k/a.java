package d.a.q0.i1.f.k;

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

    /* renamed from: d.a.q0.i1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1465a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f58978a;

        /* renamed from: b  reason: collision with root package name */
        public String f58979b;

        /* renamed from: c  reason: collision with root package name */
        public String f58980c;

        /* renamed from: d  reason: collision with root package name */
        public long f58981d;

        /* renamed from: e  reason: collision with root package name */
        public String f58982e;

        /* renamed from: f  reason: collision with root package name */
        public long f58983f;

        /* renamed from: g  reason: collision with root package name */
        public String f58984g;

        /* renamed from: h  reason: collision with root package name */
        public long f58985h;

        /* renamed from: i  reason: collision with root package name */
        public int f58986i;
        public int j;

        public C1465a() {
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
            this.f58978a = null;
            this.f58979b = null;
            this.f58980c = null;
            this.f58983f = 0L;
            this.f58984g = null;
            this.f58985h = 0L;
            this.f58986i = 0;
            this.j = 0;
        }
    }

    public static C1465a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1465a c1465a = new C1465a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c1465a.f58978a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c1465a.f58979b = optJSONObject.optString("user_id");
                    c1465a.f58980c = optJSONObject.optString("nick_name");
                    c1465a.f58981d = optJSONObject.optLong("caller_time");
                    c1465a.f58982e = optJSONObject.optString("caller_content");
                    c1465a.f58983f = optJSONObject.optLong("thread_id");
                    c1465a.f58984g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c1465a.f58985h = optJSONObject.optLong("post_id");
                    c1465a.f58986i = optJSONObject.optInt("msg_type");
                    c1465a.j = optJSONObject.optInt("remind_count");
                }
                return c1465a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1465a) invokeL.objValue;
    }
}
