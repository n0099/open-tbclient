package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f36562a;

    /* renamed from: b  reason: collision with root package name */
    public String f36563b;

    /* renamed from: c  reason: collision with root package name */
    public int f36564c;

    /* renamed from: d  reason: collision with root package name */
    public int f36565d;

    /* renamed from: e  reason: collision with root package name */
    public String f36566e;

    /* renamed from: f  reason: collision with root package name */
    public String f36567f;

    /* renamed from: g  reason: collision with root package name */
    public int f36568g;

    /* renamed from: h  reason: collision with root package name */
    public int f36569h;

    /* renamed from: i  reason: collision with root package name */
    public int f36570i;
    public int j;
    public transient List<AdTemplate> k;

    public a() {
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
        this.f36564c = 1;
        this.f36568g = 1;
        this.f36569h = 1;
        this.f36570i = 1;
        this.j = 1;
    }

    public void a(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.f36562a = jSONObject.optInt("entryType");
            this.f36563b = jSONObject.optString("sourceDesc");
            this.f36564c = jSONObject.optInt("sourceDescPos", this.f36564c);
            this.f36566e = jSONObject.optString("entryId");
            this.f36565d = jSONObject.optInt("likePos", this.f36565d);
            String optString = jSONObject.optString("entryTitle");
            this.f36567f = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f36567f = "精彩短视频";
            }
            this.f36568g = jSONObject.optInt("entryTitlePos", this.f36568g);
            this.f36569h = jSONObject.optInt("videoDurationPos", this.f36569h);
            this.f36570i = jSONObject.optInt("videoDescPos", this.f36570i);
            this.j = jSONObject.optInt("commentsPos", this.j);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "entryType", this.f36562a);
            o.a(jSONObject, "sourceDesc", this.f36563b);
            o.a(jSONObject, "sourceDescPos", this.f36564c);
            o.a(jSONObject, "entryId", this.f36566e);
            o.a(jSONObject, "likePos", this.f36565d);
            o.a(jSONObject, "entryTitle", this.f36567f);
            o.a(jSONObject, "entryTitlePos", this.f36568g);
            o.a(jSONObject, "videoDurationPos", this.f36569h);
            o.a(jSONObject, "videoDescPos", this.f36570i);
            o.a(jSONObject, "commentsPos", this.j);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
