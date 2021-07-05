package com.kwad.sdk.core.g.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.crash.utils.AbiUtil;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.o;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f36143a;

    /* renamed from: b  reason: collision with root package name */
    public String f36144b;

    /* renamed from: c  reason: collision with root package name */
    public int f36145c;

    /* renamed from: d  reason: collision with root package name */
    public Long f36146d;

    /* renamed from: e  reason: collision with root package name */
    public Long f36147e;

    /* renamed from: f  reason: collision with root package name */
    public Long f36148f;

    /* renamed from: g  reason: collision with root package name */
    public Long f36149g;

    /* renamed from: h  reason: collision with root package name */
    public String f36150h;

    /* renamed from: i  reason: collision with root package name */
    public String f36151i;
    public List<a> j;

    public h() {
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
        this.j = new ArrayList();
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            h hVar = new h();
            hVar.f36143a = ah.c();
            hVar.f36144b = AbiUtil.a();
            hVar.f36145c = ah.a(KsAdSDKImpl.get().getContext());
            hVar.f36146d = Long.valueOf(ah.b(KsAdSDKImpl.get().getContext()));
            hVar.f36147e = Long.valueOf(ah.c(KsAdSDKImpl.get().getContext()));
            hVar.f36148f = Long.valueOf(ah.a());
            hVar.f36149g = Long.valueOf(ah.b());
            hVar.f36150h = ah.e(KsAdSDKImpl.get().getContext());
            hVar.f36151i = ah.f(KsAdSDKImpl.get().getContext());
            hVar.j = at.a(KsAdSDKImpl.get().getContext(), 15);
            return hVar;
        }
        return (h) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "cpuCount", this.f36143a);
            o.a(jSONObject, "cpuAbi", this.f36144b);
            o.a(jSONObject, "batteryPercent", this.f36145c);
            o.a(jSONObject, "totalMemorySize", this.f36146d.longValue());
            o.a(jSONObject, "availableMemorySize", this.f36147e.longValue());
            o.a(jSONObject, "totalDiskSize", this.f36148f.longValue());
            o.a(jSONObject, "availableDiskSize", this.f36149g.longValue());
            o.a(jSONObject, BaseStatisContent.IMSI, this.f36150h);
            o.a(jSONObject, "iccid", this.f36151i);
            o.a(jSONObject, "wifiList", this.j);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
