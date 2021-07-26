package d.a.q0.h3.q0;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f58786a;

    /* renamed from: b  reason: collision with root package name */
    public long f58787b;

    /* renamed from: c  reason: collision with root package name */
    public String f58788c;

    /* renamed from: d  reason: collision with root package name */
    public int f58789d;

    /* renamed from: e  reason: collision with root package name */
    public String f58790e;

    /* renamed from: f  reason: collision with root package name */
    public String f58791f;

    /* renamed from: g  reason: collision with root package name */
    public long f58792g;

    public f(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58786a = System.currentTimeMillis();
        this.f58788c = str;
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", String.valueOf(this.f58786a));
            jSONObject.put("endTime", String.valueOf(this.f58787b));
            jSONObject.put("errorCode", String.valueOf(this.f58789d));
            jSONObject.put("errorMessage", this.f58790e);
            jSONObject.put("voiceMd5", this.f58791f);
            jSONObject.put("voiceId", this.f58788c);
            jSONObject.put("voiceSize", String.valueOf(this.f58792g));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
