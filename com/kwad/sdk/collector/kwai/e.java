package com.kwad.sdk.collector.kwai;

import android.hardware.SensorEvent;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public List<Float> f57133b;

    /* renamed from: c  reason: collision with root package name */
    public long f57134c;

    public e() {
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
        this.a = -1;
        this.f57133b = new ArrayList();
        this.f57134c = 0L;
    }

    public static e a(SensorEvent sensorEvent, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, sensorEvent, j2)) == null) {
            if (sensorEvent == null) {
                return null;
            }
            e eVar = new e();
            eVar.a = sensorEvent.sensor.getType();
            eVar.f57134c = j2 / 1000;
            for (float f2 : sensorEvent.values) {
                eVar.f57133b.add(Float.valueOf(f2));
            }
            return eVar;
        }
        return (e) invokeLJ.objValue;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.afterToJson(jSONObject);
            t.a(jSONObject, SavedStateHandle.VALUES, this.f57133b);
        }
    }
}
