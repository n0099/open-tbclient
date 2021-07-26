package d.a.o0.a.y0.k.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t extends d.a.o0.a.y0.a<d.a.o0.a.y0.k.g.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f49015b;

    /* renamed from: c  reason: collision with root package name */
    public int f49016c;

    public t() {
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
        this.f49015b = 1;
        this.f49016c = 3;
    }

    @Override // d.a.o0.a.y0.a
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setZeusVideoExt" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.o0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, aVar) == null) {
            Object obj = command.obj;
            if (!(obj instanceof String)) {
                if (d.a.o0.a.y0.a.f48901a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("setZeusVideoExt with a illegal obj ");
                    sb.append(obj == null);
                    throw new RuntimeException(sb.toString());
                }
                return;
            }
            String str = command.what;
            d(aVar, str, "setZeusVideoExt:" + obj, false);
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                if (jSONObject.has("instance-error")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("instance-error", jSONObject.optString("instance-error"));
                    aVar.T(hashMap);
                }
                String optString = jSONObject.optString("firstPlayStatus");
                if (!TextUtils.isEmpty(optString)) {
                    aVar.b0(optString);
                }
                this.f49015b = jSONObject.optInt("min-cache", this.f49015b);
                int optInt = jSONObject.optInt("max-cache", this.f49016c);
                this.f49016c = optInt;
                if (this.f49015b <= optInt) {
                    if (jSONObject.has("min-cache")) {
                        aVar.G(this.f49015b);
                    }
                    if (jSONObject.has("max-cache")) {
                        aVar.g0(this.f49016c);
                    }
                } else if (d.a.o0.a.y0.a.f48901a) {
                    Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.f49015b + " > maxCache " + this.f49016c);
                }
            } catch (Exception e2) {
                if (d.a.o0.a.y0.a.f48901a) {
                    throw new RuntimeException("setZeusVideoExt with a illegal str", e2);
                }
            }
        }
    }
}
