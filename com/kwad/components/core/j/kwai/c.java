package com.kwad.components.core.j.kwai;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.g.kwai.e;
import com.kwad.sdk.g.kwai.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.r;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public int c;
    public Long d;
    public Long e;
    public Long f;
    public Long g;
    public String h;
    public String i;
    public List<be.a> j;
    public long k;
    public String l;
    public String m;
    public long n;
    public int o;
    public String p;
    public String q;
    public float r;
    public boolean s;
    public int t;
    public List<a> u;
    public f v;
    public com.kwad.sdk.g.kwai.d w;
    public com.kwad.sdk.g.kwai.b x;
    public List<e> y;

    @KsJson
    /* loaded from: classes5.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;

        public a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.a = i;
        }

        public static int a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
                if (i != 0) {
                    if (i == 1) {
                        return 1;
                    }
                    if (i == 2) {
                        return 2;
                    }
                    if (i == 3) {
                        return 3;
                    }
                    if (i == 4) {
                        return 4;
                    }
                    if (i == 5) {
                        return 5;
                    }
                }
                return 0;
            }
            return invokeI.intValue;
        }

        public static List<a> a(Context context) {
            InterceptResult invokeL;
            AudioManager audioManager;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
                ArrayList arrayList = new ArrayList();
                if (context == null || com.kwad.sdk.core.config.d.a(256L)) {
                    return arrayList;
                }
                try {
                    audioManager = (AudioManager) context.getSystemService("audio");
                } catch (Exception unused) {
                }
                if (audioManager == null) {
                    return arrayList;
                }
                for (int i = 0; i <= 5; i++) {
                    a aVar = new a(i);
                    int a = a(i);
                    aVar.d = audioManager.getStreamVolume(a);
                    aVar.b = audioManager.getStreamMaxVolume(a);
                    if (Build.VERSION.SDK_INT >= 28) {
                        aVar.c = audioManager.getStreamMinVolume(a);
                    }
                    arrayList.add(aVar);
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new ArrayList();
        this.o = -1;
        this.r = -1.0f;
        this.t = -1;
    }

    @WorkerThread
    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            c cVar = new c();
            cVar.a = av.c();
            cVar.b = AbiUtil.a(b());
            cVar.c = av.a(b());
            cVar.d = Long.valueOf(av.b(b()));
            cVar.e = Long.valueOf(av.c(b()));
            cVar.f = Long.valueOf(av.a());
            cVar.g = Long.valueOf(av.b());
            cVar.h = ao.g(b());
            cVar.i = ao.h(b());
            cVar.j = ao.a(b(), 15);
            cVar.k = av.h();
            cVar.n = av.i();
            cVar.q = av.j();
            cVar.p = av.k();
            cVar.l = av.l();
            cVar.m = av.m();
            Context b = b();
            if (b != null) {
                cVar.o = av.j(b);
                cVar.u = a.a(b);
                cVar.a(b);
            }
            cVar.w = m.a();
            cVar.x = ao.c();
            cVar.y = ao.d();
            cVar.v = ao.b();
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    private void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, context) == null) || com.kwad.sdk.core.config.d.a(512L)) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        Intent registerReceiver = context.registerReceiver(null, intentFilter);
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.s = intExtra == 2 || intExtra == 5;
            int intExtra2 = registerReceiver.getIntExtra("plugged", -1);
            if (intExtra2 == 2) {
                this.t = 1;
            } else if (intExtra2 == 1) {
                this.t = 2;
            } else if (intExtra2 == 4) {
                this.t = 3;
            } else if (intExtra2 == 0) {
                this.t = 0;
            }
        }
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a() : (Context) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
        }
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            r.a(jSONObject, "cpuCount", this.a);
            r.a(jSONObject, "cpuAbi", this.b);
            r.a(jSONObject, "batteryPercent", this.c);
            r.a(jSONObject, "totalMemorySize", this.d.longValue());
            r.a(jSONObject, "availableMemorySize", this.e.longValue());
            r.a(jSONObject, "totalDiskSize", this.f.longValue());
            r.a(jSONObject, "availableDiskSize", this.g.longValue());
            r.a(jSONObject, BaseStatisContent.IMSI, this.h);
            r.a(jSONObject, "iccid", this.i);
            r.a(jSONObject, "wifiList", this.j);
            r.a(jSONObject, "bootTime", this.k);
            r.a(jSONObject, "romName", this.l);
            r.a(jSONObject, "romVersion", this.m);
            r.a(jSONObject, "romBuildTimestamp", this.n);
            r.a(jSONObject, "ringerMode", this.o);
            r.a(jSONObject, "audioStreamInfo", this.u);
            r.a(jSONObject, "baseBandVersion", this.p);
            r.a(jSONObject, "fingerPrint", this.q);
            r.a(jSONObject, "screenBrightness", this.r);
            r.a(jSONObject, "isCharging", this.s);
            r.a(jSONObject, "chargeType", this.t);
            f fVar = this.v;
            if (fVar != null) {
                r.a(jSONObject, "simCardInfo", fVar);
            }
            com.kwad.sdk.g.kwai.d dVar = this.w;
            if (dVar != null) {
                r.a(jSONObject, "environmentInfo", dVar);
            }
            com.kwad.sdk.g.kwai.b bVar = this.x;
            if (bVar != null) {
                r.a(jSONObject, "baseStationInfo", bVar);
            }
            List<e> list = this.y;
            if (list != null) {
                r.a(jSONObject, "sensorEventInfoList", list);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
