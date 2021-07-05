package d.a.s0.t.a.f;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f65480a;

    /* renamed from: b  reason: collision with root package name */
    public String f65481b;

    /* renamed from: c  reason: collision with root package name */
    public String f65482c;

    /* renamed from: d  reason: collision with root package name */
    public String f65483d;

    /* renamed from: e  reason: collision with root package name */
    public String f65484e;

    /* renamed from: f  reason: collision with root package name */
    public String f65485f;

    /* renamed from: g  reason: collision with root package name */
    public int f65486g;

    /* renamed from: h  reason: collision with root package name */
    public int f65487h;

    /* renamed from: i  reason: collision with root package name */
    public int f65488i;
    public long j;
    public long k;

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
        this.f65483d = "";
        this.f65482c = "";
        this.f65484e = "";
        this.f65485f = "";
        this.f65481b = "";
        this.f65480a = "";
    }

    public static b a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            b bVar = new b();
            if (adInfo == null) {
                return bVar;
            }
            bVar.f65480a = adInfo.adImgUrl;
            bVar.f65481b = adInfo.redirectUrl;
            bVar.j = adInfo.startShowTime;
            bVar.k = adInfo.endShowTime;
            bVar.f65483d = adInfo.videoLocalPath;
            bVar.f65484e = adInfo.videoJumpUrl;
            bVar.f65485f = adInfo.videoMd5;
            bVar.f65486g = adInfo.videoDuration;
            bVar.f65487h = adInfo.videoWidth;
            bVar.f65488i = adInfo.videoHight;
            bVar.f65482c = adInfo.adVideoUrl;
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static b b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(str);
                bVar.f65480a = jSONObject.optString("adImgUrl");
                bVar.f65481b = jSONObject.optString("redirectUrl");
                bVar.f65483d = jSONObject.optString("videoLocalPath");
                bVar.j = jSONObject.optLong("startShowTime");
                bVar.k = jSONObject.optLong("endShowTime");
                bVar.f65484e = jSONObject.optString("videoJumpUrl");
                bVar.f65485f = jSONObject.optString("videoMd5");
                bVar.f65486g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                bVar.f65487h = jSONObject.optInt("videoWidth");
                bVar.f65488i = jSONObject.optInt("videoHeight");
                bVar.f65482c = jSONObject.optString("adVideoUrl");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (System.currentTimeMillis() / 1000 >= this.j && System.currentTimeMillis() / 1000 <= this.k) || (this.j == 0 && this.k == 0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f65483d) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.f65480a);
                jSONObject.put("redirectUrl", this.f65481b);
                jSONObject.put("videoLocalPath", this.f65483d);
                jSONObject.put("startShowTime", this.j);
                jSONObject.put("endShowTime", this.k);
                jSONObject.put("videoMd5", this.f65485f);
                jSONObject.put("videoJumpUrl", this.f65484e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f65486g);
                jSONObject.put("videoWidth", this.f65487h);
                jSONObject.put("videoHeight", this.f65488i);
                jSONObject.put("adVideoUrl", this.f65482c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
