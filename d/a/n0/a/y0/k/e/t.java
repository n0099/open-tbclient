package d.a.n0.a.y0.k.e;

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
public class t extends d.a.n0.a.y0.a<d.a.n0.a.y0.k.g.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f48511b;

    /* renamed from: c  reason: collision with root package name */
    public int f48512c;

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
        this.f48511b = 1;
        this.f48512c = 3;
    }

    @Override // d.a.n0.a.y0.a
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setZeusVideoExt" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.n0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, aVar) == null) {
            Object obj = command.obj;
            if (!(obj instanceof String)) {
                if (d.a.n0.a.y0.a.f48397a) {
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
                this.f48511b = jSONObject.optInt("min-cache", this.f48511b);
                int optInt = jSONObject.optInt("max-cache", this.f48512c);
                this.f48512c = optInt;
                if (this.f48511b <= optInt) {
                    if (jSONObject.has("min-cache")) {
                        aVar.G(this.f48511b);
                    }
                    if (jSONObject.has("max-cache")) {
                        aVar.g0(this.f48512c);
                    }
                } else if (d.a.n0.a.y0.a.f48397a) {
                    Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.f48511b + " > maxCache " + this.f48512c);
                }
            } catch (Exception e2) {
                if (d.a.n0.a.y0.a.f48397a) {
                    throw new RuntimeException("setZeusVideoExt with a illegal str", e2);
                }
            }
        }
    }
}
