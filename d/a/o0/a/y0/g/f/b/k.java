package d.a.o0.a.y0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k extends d.a.o0.a.y0.a<d.a.o0.a.y0.g.h.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k() {
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

    @Override // d.a.o0.a.y0.a
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getRemoteAudioLevels" : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.y0.a
    public void c(@NonNull ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, command) == null) {
            command.obj = new JSONObject();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.o0.a.y0.g.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, command, bVar) == null) {
            ArrayList<d.a.o0.a.y0.g.i.a> v = bVar.v();
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (v != null) {
                Iterator<d.a.o0.a.y0.g.i.a> it = v.iterator();
                while (it.hasNext()) {
                    d.a.o0.a.y0.g.i.a next = it.next();
                    JSONObject a2 = next == null ? null : next.a();
                    if (a2 != null) {
                        jSONArray.put(a2);
                    }
                }
            }
            try {
                jSONObject.put("audioLevels", jSONArray);
            } catch (JSONException unused) {
            }
            command.obj = jSONObject;
            String str = command.what;
            d(bVar, str, "" + command.obj, true);
        }
    }
}
