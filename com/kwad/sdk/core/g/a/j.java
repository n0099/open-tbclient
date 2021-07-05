package com.kwad.sdk.core.g.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f36156a;

    /* renamed from: b  reason: collision with root package name */
    public int f36157b;

    /* renamed from: c  reason: collision with root package name */
    public int f36158c;

    /* renamed from: d  reason: collision with root package name */
    public List<Long> f36159d;

    public j() {
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
        this.f36159d = new ArrayList();
    }

    public j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36159d = new ArrayList();
        this.f36156a = true;
        this.f36157b = i2;
    }

    public j(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f36159d = new ArrayList();
        this.f36156a = false;
        if (list != null) {
            this.f36158c = list.size();
            for (AdTemplate adTemplate : list) {
                this.f36159d.add(Long.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)));
            }
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "preload", this.f36156a);
            if (this.f36156a) {
                o.a(jSONObject, "requestVideoCount", this.f36157b);
            } else {
                o.a(jSONObject, "preloadedVideoCount", this.f36158c);
                JSONArray jSONArray = new JSONArray();
                for (Long l : this.f36159d) {
                    jSONArray.put(l);
                }
                o.a(jSONObject, "preloadedVideoList", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
