package com.kwad.sdk.core.request.model;

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
import com.kuaishou.weapon.adsdk.DeviceInfo;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.crash.utils.SystemUtil;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.t;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class g implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f58367b;

    /* renamed from: c  reason: collision with root package name */
    public int f58368c;

    /* renamed from: d  reason: collision with root package name */
    public Long f58369d;

    /* renamed from: e  reason: collision with root package name */
    public Long f58370e;

    /* renamed from: f  reason: collision with root package name */
    public Long f58371f;

    /* renamed from: g  reason: collision with root package name */
    public Long f58372g;

    /* renamed from: h  reason: collision with root package name */
    public String f58373h;

    /* renamed from: i  reason: collision with root package name */
    public String f58374i;

    /* renamed from: j  reason: collision with root package name */
    public List<com.kwad.sdk.core.request.model.a> f58375j;

    /* renamed from: k  reason: collision with root package name */
    public long f58376k;
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
    public com.kwad.sdk.collector.kwai.f v;
    public com.kwad.sdk.collector.kwai.d w;
    public c x;
    public List<com.kwad.sdk.collector.kwai.e> y;

    /* loaded from: classes3.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f58377b;

        /* renamed from: c  reason: collision with root package name */
        public int f58378c;

        /* renamed from: d  reason: collision with root package name */
        public int f58379d;

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.f58377b = -1;
            this.f58378c = -1;
            this.f58379d = -1;
            this.a = i2;
        }

        private int a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
                if (i2 != 0) {
                    if (i2 == 1) {
                        return 1;
                    }
                    if (i2 == 2) {
                        return 2;
                    }
                    if (i2 == 3) {
                        return 3;
                    }
                    if (i2 == 4) {
                        return 4;
                    }
                    if (i2 == 5) {
                        return 5;
                    }
                }
                return 0;
            }
            return invokeI.intValue;
        }

        public static List<a> a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
                ArrayList arrayList = new ArrayList();
                if (com.kwad.sdk.core.config.b.a(256L)) {
                    return arrayList;
                }
                for (int i2 = 0; i2 <= 5; i2++) {
                    a aVar = new a(i2);
                    if (com.kwad.sdk.b.a.booleanValue()) {
                        aVar.b(context);
                    } else {
                        aVar.c(context);
                    }
                    arrayList.add(aVar);
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        public a b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                if (context == null) {
                    return null;
                }
                int[] audioVolumes = DeviceInfo.getAudioVolumes(context, a(this.a));
                if (audioVolumes != null && audioVolumes.length == 3) {
                    this.f58379d = audioVolumes[0];
                    this.f58377b = audioVolumes[1];
                    if (Build.VERSION.SDK_INT >= 28) {
                        this.f58378c = audioVolumes[2];
                    }
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                if (context == null) {
                    return null;
                }
                int a = a(this.a);
                AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                this.f58379d = audioManager.getStreamVolume(a);
                this.f58377b = audioManager.getStreamMaxVolume(a);
                if (Build.VERSION.SDK_INT >= 28) {
                    this.f58378c = audioManager.getStreamMinVolume(a);
                }
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public g() {
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
        this.f58375j = new ArrayList();
        this.o = -1;
        this.r = -1.0f;
        this.t = -1;
    }

    @WorkerThread
    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            g gVar = new g();
            gVar.a = av.c();
            gVar.f58367b = AbiUtil.a();
            gVar.f58368c = av.a(KsAdSDKImpl.get().getContext());
            gVar.f58369d = Long.valueOf(av.b(KsAdSDKImpl.get().getContext()));
            gVar.f58370e = Long.valueOf(av.c(KsAdSDKImpl.get().getContext()));
            gVar.f58371f = Long.valueOf(av.a());
            gVar.f58372g = Long.valueOf(av.b());
            gVar.f58373h = av.h(KsAdSDKImpl.get().getContext());
            gVar.f58374i = av.j(KsAdSDKImpl.get().getContext());
            gVar.f58375j = bg.a(KsAdSDKImpl.get().getContext(), 15);
            gVar.f58376k = av.h();
            gVar.n = av.i();
            gVar.q = av.j();
            gVar.p = av.k();
            gVar.l = av.l();
            gVar.m = av.m();
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null) {
                gVar.o = av.m(context);
                gVar.u = a.a(context);
                gVar.r = SystemUtil.d(context);
                gVar.a(context);
            }
            gVar.w = com.kwad.sdk.collector.kwai.c.a();
            gVar.x = av.l(context);
            gVar.y = com.kwad.sdk.collector.i.b();
            gVar.v = av.k(context);
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    private void a(@NonNull Context context) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, context) == null) || com.kwad.sdk.core.config.b.a(512L)) {
            return;
        }
        if (com.kwad.sdk.b.a.booleanValue()) {
            this.s = DeviceInfo.isCharging(context);
            i2 = DeviceInfo.getChargeType(context);
        } else {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            Intent registerReceiver = context.registerReceiver(null, intentFilter);
            if (registerReceiver == null) {
                return;
            }
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.s = intExtra == 2 || intExtra == 5;
            int intExtra2 = registerReceiver.getIntExtra("plugged", -1);
            if (intExtra2 == 2) {
                this.t = 1;
                return;
            } else if (intExtra2 == 1) {
                this.t = 2;
                return;
            } else if (intExtra2 != 4) {
                if (intExtra2 == 0) {
                    this.t = 0;
                    return;
                }
                return;
            } else {
                i2 = 3;
            }
        }
        this.t = i2;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "cpuCount", this.a);
            t.a(jSONObject, "cpuAbi", this.f58367b);
            t.a(jSONObject, "batteryPercent", this.f58368c);
            t.a(jSONObject, "totalMemorySize", this.f58369d.longValue());
            t.a(jSONObject, "availableMemorySize", this.f58370e.longValue());
            t.a(jSONObject, "totalDiskSize", this.f58371f.longValue());
            t.a(jSONObject, "availableDiskSize", this.f58372g.longValue());
            t.a(jSONObject, BaseStatisContent.IMSI, this.f58373h);
            t.a(jSONObject, "iccid", this.f58374i);
            t.a(jSONObject, "wifiList", this.f58375j);
            t.a(jSONObject, "bootTime", this.f58376k);
            t.a(jSONObject, "romName", this.l);
            t.a(jSONObject, "romVersion", this.m);
            t.a(jSONObject, "romBuildTimestamp", this.n);
            t.a(jSONObject, "ringerMode", this.o);
            t.a(jSONObject, "audioStreamInfo", this.u);
            t.a(jSONObject, "baseBandVersion", this.p);
            t.a(jSONObject, "fingerPrint", this.q);
            t.a(jSONObject, "screenBrightness", this.r);
            t.a(jSONObject, "isCharging", this.s);
            t.a(jSONObject, "chargeType", this.t);
            com.kwad.sdk.collector.kwai.f fVar = this.v;
            if (fVar != null) {
                t.a(jSONObject, "simCardInfo", fVar);
            }
            com.kwad.sdk.collector.kwai.d dVar = this.w;
            if (dVar != null) {
                t.a(jSONObject, "environmentInfo", dVar);
            }
            c cVar = this.x;
            if (cVar != null) {
                t.a(jSONObject, "baseStationInfo", cVar);
            }
            List<com.kwad.sdk.collector.kwai.e> list = this.y;
            if (list != null) {
                t.a(jSONObject, "sensorEventInfoList", list);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
