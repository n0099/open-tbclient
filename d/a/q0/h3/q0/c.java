package d.a.q0.h3.q0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f58768a;

    /* renamed from: b  reason: collision with root package name */
    public long f58769b;

    /* renamed from: c  reason: collision with root package name */
    public long f58770c;

    /* renamed from: d  reason: collision with root package name */
    public long f58771d;

    /* renamed from: e  reason: collision with root package name */
    public int f58772e;

    /* renamed from: f  reason: collision with root package name */
    public String f58773f;

    /* renamed from: g  reason: collision with root package name */
    public b f58774g;

    /* renamed from: h  reason: collision with root package name */
    public f f58775h;

    /* renamed from: i  reason: collision with root package name */
    public e f58776i;
    public a j;

    public c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writeData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (writeData != null && writeData.startPublishTime() > 0) {
            c asyncPublishStatData = writeData.getAsyncPublishStatData();
            if (asyncPublishStatData != null) {
                long j = asyncPublishStatData.f58769b;
                if (j > 0) {
                    this.f58769b = j;
                } else {
                    this.f58769b = asyncPublishStatData.f58768a;
                }
            }
            this.f58768a = writeData.startPublishTime();
            this.f58770c = writeData.startPublishTime();
            return;
        }
        throw new RuntimeException("writeData must is async mode(has startPublishTime)");
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", String.valueOf(this.f58768a));
            jSONObject.put("parentId", String.valueOf(this.f58769b));
            jSONObject.put("startTime", String.valueOf(this.f58770c));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject b() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", String.valueOf(this.f58768a));
            jSONObject.put("parentId", String.valueOf(this.f58769b));
            jSONObject.put("startTime", String.valueOf(this.f58770c));
            jSONObject.put("endTime", String.valueOf(this.f58771d));
            jSONObject.put("errorCode", String.valueOf(this.f58772e));
            jSONObject.put("errorMessage", this.f58773f);
            b bVar = this.f58774g;
            if (bVar != null) {
                jSONObject.put("imagesData", bVar.a());
            }
            f fVar = this.f58775h;
            if (fVar != null) {
                jSONObject.put("voiceData", fVar.a());
            }
            e eVar = this.f58776i;
            if (eVar != null) {
                jSONObject.put("videoData", eVar.a());
            }
            a aVar = this.j;
            if (aVar != null) {
                jSONObject.put("videoFirstFrame", aVar.a());
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
