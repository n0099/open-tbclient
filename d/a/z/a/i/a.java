package d.a.z.a.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import d.a.z.a.e;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static e f68632a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.z.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1957a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f68633a;

        /* renamed from: b  reason: collision with root package name */
        public long f68634b;

        /* renamed from: c  reason: collision with root package name */
        public int f68635c;

        /* renamed from: d  reason: collision with root package name */
        public String f68636d;

        /* renamed from: e  reason: collision with root package name */
        public String f68637e;

        /* renamed from: f  reason: collision with root package name */
        public String f68638f;

        /* renamed from: g  reason: collision with root package name */
        public String f68639g;

        /* renamed from: h  reason: collision with root package name */
        public String f68640h;

        /* renamed from: i  reason: collision with root package name */
        public String f68641i;
        public boolean j;
        public boolean k;
        public boolean l;
        public int m;
        public int n;
        public JSONObject o;
        public JSONObject p;

        public C1957a() {
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
    }

    public static void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, jSONObject) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, Integer.valueOf(d.a.z.a.b.i()));
                if (jSONObject2.length() > 0) {
                    jSONObject2.put("debug_info", jSONObject);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e eVar = f68632a;
            if (eVar != null) {
                eVar.a(str, jSONObject2);
            }
        }
    }
}
