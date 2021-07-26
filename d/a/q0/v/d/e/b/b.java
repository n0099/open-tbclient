package d.a.q0.v.d.e.b;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b2 f65137a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65138b;

    /* renamed from: c  reason: collision with root package name */
    public long f65139c;

    /* renamed from: d  reason: collision with root package name */
    public List<a> f65140d;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f65141a;

        /* renamed from: b  reason: collision with root package name */
        public String f65142b;

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

        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f65141a = jSONObject.optInt("tag_type");
            this.f65142b = jSONObject.optString("tag_word");
        }
    }

    public b() {
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

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f65138b = jSONObject.optInt(TiebaStatic.Params.IS_FOLLOW) == 1;
        this.f65139c = jSONObject.optLong("last_watch_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("thread_info");
        if (optJSONObject != null) {
            b2 b2Var = new b2();
            this.f65137a = b2Var;
            b2Var.J2(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(CommandMessage.TYPE_TAGS);
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        this.f65140d = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
            if (optJSONObject2 != null) {
                a aVar = new a();
                aVar.a(optJSONObject2);
                this.f65140d.add(aVar);
            }
        }
    }
}
