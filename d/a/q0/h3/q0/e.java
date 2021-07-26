package d.a.q0.h3.q0;

import androidx.annotation.NonNull;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f58777a;

    /* renamed from: b  reason: collision with root package name */
    public long f58778b;

    /* renamed from: c  reason: collision with root package name */
    public String f58779c;

    /* renamed from: d  reason: collision with root package name */
    public int f58780d;

    /* renamed from: e  reason: collision with root package name */
    public long f58781e;

    /* renamed from: f  reason: collision with root package name */
    public int f58782f;

    /* renamed from: g  reason: collision with root package name */
    public String f58783g;

    /* renamed from: h  reason: collision with root package name */
    public String f58784h;

    /* renamed from: i  reason: collision with root package name */
    public String f58785i;

    public e(@NonNull VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58777a = System.currentTimeMillis();
        this.f58779c = videoInfo.getVideoPath();
        this.f58780d = videoInfo.getVideoDuration();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", String.valueOf(this.f58777a));
            jSONObject.put("endTime", String.valueOf(this.f58778b));
            jSONObject.put("errorCode", String.valueOf(this.f58782f));
            jSONObject.put("errorMessage", this.f58783g);
            jSONObject.put("videoMd5", this.f58784h);
            jSONObject.put("videoUrl", this.f58785i);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, String.valueOf(this.f58779c));
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, String.valueOf(this.f58780d));
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, String.valueOf(this.f58781e));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
