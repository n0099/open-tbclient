package ms.bd.c;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.List;
import ms.bd.c.b;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class e1 extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e1() {
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

    @Override // ms.bd.c.b.a
    public Object b(int i2, long j, String str, Object obj) throws Throwable {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, obj})) == null) {
            Context c2 = a.a().c();
            JSONArray jSONArray = new JSONArray();
            AccessibilityManager accessibilityManager = (AccessibilityManager) c2.getSystemService((String) h.a(16777217, 0, 0L, "13646b", new byte[]{PublicSuffixDatabase.EXCEPTION_MARKER, 50, 70, 69, 26, 102, 59, 16, 110, 104, 41, 37, 92}));
            if (accessibilityManager != null) {
                List<AccessibilityServiceInfo> list = null;
                try {
                    Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod((String) h.a(16777217, 0, 0L, "b314d8", new byte[]{116, 52, 86, 105, 85, 60, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 19, 108, 104, 118, 53, 99, 67, 88, 42, 114, 1, 105, 102, 122, 61, 75, 84, 66, 28, 100, 0, 118, 109, 112, 52, 110, 73, 72, 59}), new Class[0]);
                    if (declaredMethod != null) {
                        list = (List) declaredMethod.invoke(accessibilityManager, new Object[0]);
                    }
                } catch (Throwable unused) {
                }
                if (list == null || list.size() == 0) {
                    return jSONArray.toString();
                }
                for (AccessibilityServiceInfo accessibilityServiceInfo : list) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put((String) h.a(16777217, 0, 0L, "de4dc4", new byte[]{112, 113}), accessibilityServiceInfo.eventTypes);
                        jSONObject.put((String) h.a(16777217, 0, 0L, "21e313", new byte[]{42, 55}), accessibilityServiceInfo.getId());
                        jSONArray.put(jSONObject);
                    } catch (Throwable unused2) {
                    }
                }
            }
            return jSONArray.toString();
        }
        return invokeCommon.objValue;
    }
}
