package d.a.s0.i1.l.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Pattern f61763a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.s0.i1.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1512a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f61764a;

        /* renamed from: b  reason: collision with root package name */
        public String f61765b;

        /* renamed from: c  reason: collision with root package name */
        public String f61766c;

        /* renamed from: d  reason: collision with root package name */
        public String f61767d;

        /* renamed from: e  reason: collision with root package name */
        public String f61768e;

        /* renamed from: f  reason: collision with root package name */
        public String f61769f;

        /* renamed from: g  reason: collision with root package name */
        public int f61770g;

        /* renamed from: h  reason: collision with root package name */
        public long f61771h;

        /* renamed from: i  reason: collision with root package name */
        public String f61772i;
        public int j;
        public long k;
        public long l;
        public long m;
        public String n;

        public C1512a() {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1249029827, "Ld/a/s0/i1/l/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1249029827, "Ld/a/s0/i1/l/c/a;");
                return;
            }
        }
        f61763a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
    }

    public static List<C1512a> a(String str, String str2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2)})) == null) ? b(str, str2, null, 0L, j, j2) : (List) invokeCommon.objValue;
    }

    public static List<C1512a> b(String str, String str2, UserData userData, long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, str2, userData, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i2 = -1;
            int userType = userData != null ? userData.getUserType() : -1;
            LinkedList linkedList = new LinkedList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                int i3 = 0;
                while (i3 < length) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    String optString = optJSONObject.optString("title");
                    String optString2 = optJSONObject.optString("url");
                    String optString3 = optJSONObject.optString("src");
                    String optString4 = optJSONObject.optString("text");
                    optJSONObject.optLong("picId");
                    String optString5 = optJSONObject.optString("msg_src");
                    C1512a c1512a = new C1512a();
                    if (!TextUtils.isEmpty(optString2)) {
                        optString2 = optString2.trim();
                        Matcher matcher = f61763a.matcher(optString2);
                        if (matcher.find()) {
                            c1512a.n = matcher.group(1);
                        }
                    }
                    c1512a.f61767d = optString2;
                    c1512a.f61764a = optString;
                    c1512a.f61765b = optString4;
                    c1512a.f61766c = optString3;
                    c1512a.f61768e = str2;
                    c1512a.k = j2;
                    c1512a.l = j3;
                    c1512a.f61769f = optString5;
                    if (userType > i2) {
                        c1512a.f61770g = userType;
                    }
                    if (userData != null) {
                        c1512a.f61771h = j;
                        c1512a.f61772i = userData.getUserId();
                        c1512a.j = userData.getUserType();
                    }
                    linkedList.add(c1512a);
                    i3++;
                    i2 = -1;
                }
                return linkedList;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeCommon.objValue;
    }
}
