package d.l.a.d.b.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.l.a.d.b.c;
import d.l.a.d.b.l;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    @NonNull
    public CopyOnWriteArrayList<c.b> a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            CopyOnWriteArrayList<c.b> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            try {
                String string = l.a().getSharedPreferences(str, 0).getString(str2, "");
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        c.b a2 = c.b.a(jSONObject.optJSONObject(keys.next()));
                        if (a2 != null) {
                            copyOnWriteArrayList.add(a2);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return copyOnWriteArrayList;
        }
        return (CopyOnWriteArrayList) invokeLL.objValue;
    }

    public void b(String str, String str2, CopyOnWriteArrayList<c.b> copyOnWriteArrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, copyOnWriteArrayList) == null) || copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<c.b> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                c.b next = it.next();
                if (next != null) {
                    jSONObject.put(String.valueOf(next.f74195b), next.b());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        l.a().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }

    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        l.a().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
    }
}
