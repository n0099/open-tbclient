package d.a.q0.t.a.f;

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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f62905a;

    /* renamed from: b  reason: collision with root package name */
    public String f62906b;

    /* renamed from: c  reason: collision with root package name */
    public String f62907c;

    /* renamed from: d  reason: collision with root package name */
    public String f62908d;

    /* renamed from: e  reason: collision with root package name */
    public String f62909e;

    /* renamed from: f  reason: collision with root package name */
    public String f62910f;

    /* renamed from: g  reason: collision with root package name */
    public int f62911g;

    /* renamed from: h  reason: collision with root package name */
    public int f62912h;

    /* renamed from: i  reason: collision with root package name */
    public int f62913i;
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
        this.f62908d = "";
        this.f62907c = "";
        this.f62909e = "";
        this.f62910f = "";
        this.f62906b = "";
        this.f62905a = "";
    }

    public static b a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            b bVar = new b();
            if (adInfo == null) {
                return bVar;
            }
            bVar.f62905a = adInfo.adImgUrl;
            bVar.f62906b = adInfo.redirectUrl;
            bVar.j = adInfo.startShowTime;
            bVar.k = adInfo.endShowTime;
            bVar.f62908d = adInfo.videoLocalPath;
            bVar.f62909e = adInfo.videoJumpUrl;
            bVar.f62910f = adInfo.videoMd5;
            bVar.f62911g = adInfo.videoDuration;
            bVar.f62912h = adInfo.videoWidth;
            bVar.f62913i = adInfo.videoHight;
            bVar.f62907c = adInfo.adVideoUrl;
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
                bVar.f62905a = jSONObject.optString("adImgUrl");
                bVar.f62906b = jSONObject.optString("redirectUrl");
                bVar.f62908d = jSONObject.optString("videoLocalPath");
                bVar.j = jSONObject.optLong("startShowTime");
                bVar.k = jSONObject.optLong("endShowTime");
                bVar.f62909e = jSONObject.optString("videoJumpUrl");
                bVar.f62910f = jSONObject.optString("videoMd5");
                bVar.f62911g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                bVar.f62912h = jSONObject.optInt("videoWidth");
                bVar.f62913i = jSONObject.optInt("videoHeight");
                bVar.f62907c = jSONObject.optString("adVideoUrl");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f62908d) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.f62905a);
                jSONObject.put("redirectUrl", this.f62906b);
                jSONObject.put("videoLocalPath", this.f62908d);
                jSONObject.put("startShowTime", this.j);
                jSONObject.put("endShowTime", this.k);
                jSONObject.put("videoMd5", this.f62910f);
                jSONObject.put("videoJumpUrl", this.f62909e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f62911g);
                jSONObject.put("videoWidth", this.f62912h);
                jSONObject.put("videoHeight", this.f62913i);
                jSONObject.put("adVideoUrl", this.f62907c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
