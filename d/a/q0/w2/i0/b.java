package d.a.q0.w2.i0;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static b f66678c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, List<JSONObject>> f66679a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f66680b;

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
                return;
            }
        }
        this.f66679a = new ConcurrentHashMap<>();
        this.f66680b = new ConcurrentHashMap<>();
    }

    public static JSONObject b(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, threadInfo)) == null) {
            if (threadInfo == null) {
                return null;
            }
            return c(threadInfo, threadInfo.fname);
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject c(ThreadInfo threadInfo, String str) {
        InterceptResult invokeLL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, threadInfo, str)) == null) {
            if (threadInfo == null) {
                return null;
            }
            String str2 = "" + threadInfo.tid;
            if (StringUtils.isNull(str2) || "0".equals(str2)) {
                str2 = "" + threadInfo.id;
            }
            String str3 = threadInfo.video_info != null ? "" + threadInfo.video_info.video_duration : "0";
            StringBuilder sb = new StringBuilder();
            List<Abstract> list = threadInfo._abstract;
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Abstract r6 = (Abstract) d.a.q0.n1.o.k.a.d(list, i2);
                    if (r6 != null && r6.type.intValue() == 0) {
                        sb.append(r6.text);
                    }
                }
            }
            String sb2 = sb.toString();
            String str4 = "" + threadInfo.author_id;
            User user = threadInfo.author;
            if (user != null && (l = user.id) != null && l.longValue() != 0) {
                str4 = "" + threadInfo.author.id;
            }
            if (StringUtils.isNull(str)) {
                str = threadInfo.fname;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", threadInfo.title);
                jSONObject.put("tid", str2);
                jSONObject.put("fname", str);
                jSONObject.put("abstract", sb2);
                jSONObject.put("author_id", str4);
                jSONObject.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, str3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f66678c == null) {
                synchronized (b.class) {
                    if (f66678c == null) {
                        f66678c = new b();
                    }
                }
            }
            return f66678c;
        }
        return (b) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f66679a.put(str, new ArrayList());
        }
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? g(this.f66679a.get(str)) : (String) invokeL.objValue;
    }

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Integer num = this.f66680b.get(str);
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public final String g(List<JSONObject> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            try {
                if (ListUtils.isEmpty(list)) {
                    return "";
                }
                JSONArray jSONArray = new JSONArray();
                for (JSONObject jSONObject : list) {
                    if (jSONObject != null) {
                        jSONArray.put(jSONObject);
                    }
                }
                return d.a.d.e.p.c.j(jSONArray.toString().getBytes("UTF-8"));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public void h(String str, List<JSONObject> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            this.f66679a.put(str, arrayList);
        }
    }

    public void i(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i2) == null) {
            this.f66680b.put(str, Integer.valueOf(i2));
        }
    }
}
