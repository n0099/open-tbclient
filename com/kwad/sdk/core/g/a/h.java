package com.kwad.sdk.core.g.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.crash.utils.SystemUtil;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.q;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes10.dex */
public class h implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f72141a;

    /* renamed from: b  reason: collision with root package name */
    public String f72142b;

    /* renamed from: c  reason: collision with root package name */
    public int f72143c;

    /* renamed from: d  reason: collision with root package name */
    public Long f72144d;

    /* renamed from: e  reason: collision with root package name */
    public Long f72145e;

    /* renamed from: f  reason: collision with root package name */
    public Long f72146f;

    /* renamed from: g  reason: collision with root package name */
    public Long f72147g;

    /* renamed from: h  reason: collision with root package name */
    public String f72148h;

    /* renamed from: i  reason: collision with root package name */
    public String f72149i;

    /* renamed from: j  reason: collision with root package name */
    public List<com.kwad.sdk.core.g.a.a> f72150j;
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
    public com.kwad.sdk.collector.a.f v;
    public com.kwad.sdk.collector.a.d w;
    public c x;
    public List<com.kwad.sdk.collector.a.e> y;

    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f72151a;

        /* renamed from: b  reason: collision with root package name */
        public int f72152b;

        /* renamed from: c  reason: collision with root package name */
        public int f72153c;

        /* renamed from: d  reason: collision with root package name */
        public int f72154d;

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
            this.f72151a = -1;
            this.f72152b = -1;
            this.f72153c = -1;
            this.f72154d = -1;
            this.f72151a = i2;
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
                if (com.kwad.sdk.core.config.c.a(256L)) {
                    return arrayList;
                }
                for (int i2 = 0; i2 <= 5; i2++) {
                    a aVar = new a(i2);
                    aVar.b(context);
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
                int a2 = a(this.f72151a);
                AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                this.f72154d = audioManager.getStreamVolume(a2);
                this.f72152b = audioManager.getStreamMaxVolume(a2);
                if (Build.VERSION.SDK_INT >= 28) {
                    this.f72153c = audioManager.getStreamMinVolume(a2);
                }
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

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
        this.f72150j = new ArrayList();
        this.o = -1;
        this.r = -1.0f;
        this.t = -1;
    }

    @WorkerThread
    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            h hVar = new h();
            hVar.f72141a = ap.c();
            hVar.f72142b = AbiUtil.a();
            hVar.f72143c = ap.a(KsAdSDKImpl.get().getContext());
            hVar.f72144d = Long.valueOf(ap.b(KsAdSDKImpl.get().getContext()));
            hVar.f72145e = Long.valueOf(ap.c(KsAdSDKImpl.get().getContext()));
            hVar.f72146f = Long.valueOf(ap.a());
            hVar.f72147g = Long.valueOf(ap.b());
            hVar.f72148h = ap.h(KsAdSDKImpl.get().getContext());
            hVar.f72149i = ap.j(KsAdSDKImpl.get().getContext());
            hVar.f72150j = ba.a(KsAdSDKImpl.get().getContext(), 15);
            hVar.k = SystemClock.elapsedRealtime() / 1000;
            hVar.n = Build.TIME;
            hVar.q = Build.FINGERPRINT;
            hVar.p = Build.getRadioVersion();
            hVar.l = aj.c();
            hVar.m = aj.d();
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null) {
                hVar.o = ((AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).getRingerMode();
                hVar.u = a.a(context);
                hVar.r = SystemUtil.d(context);
                hVar.a(context);
            }
            hVar.w = com.kwad.sdk.collector.a.c.a();
            hVar.x = com.kwad.sdk.collector.i.a();
            hVar.y = com.kwad.sdk.collector.i.b();
            hVar.v = com.kwad.sdk.collector.i.c();
            return hVar;
        }
        return (h) invokeV.objValue;
    }

    private void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, context) == null) || com.kwad.sdk.core.config.c.a(512L)) {
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
            q.a(jSONObject, "cpuCount", this.f72141a);
            q.a(jSONObject, "cpuAbi", this.f72142b);
            q.a(jSONObject, "batteryPercent", this.f72143c);
            q.a(jSONObject, "totalMemorySize", this.f72144d.longValue());
            q.a(jSONObject, "availableMemorySize", this.f72145e.longValue());
            q.a(jSONObject, "totalDiskSize", this.f72146f.longValue());
            q.a(jSONObject, "availableDiskSize", this.f72147g.longValue());
            q.a(jSONObject, BaseStatisContent.IMSI, this.f72148h);
            q.a(jSONObject, "iccid", this.f72149i);
            q.a(jSONObject, "wifiList", this.f72150j);
            q.a(jSONObject, "bootTime", this.k);
            q.a(jSONObject, "romName", this.l);
            q.a(jSONObject, "romVersion", this.m);
            q.a(jSONObject, "romBuildTimestamp", this.n);
            q.a(jSONObject, "ringerMode", this.o);
            q.a(jSONObject, "audioStreamInfo", this.u);
            q.a(jSONObject, "baseBandVersion", this.p);
            q.a(jSONObject, "fingerPrint", this.q);
            q.a(jSONObject, "screenBrightness", this.r);
            q.a(jSONObject, "isCharging", this.s);
            q.a(jSONObject, "chargeType", this.t);
            com.kwad.sdk.collector.a.f fVar = this.v;
            if (fVar != null) {
                q.a(jSONObject, "simCardInfo", fVar);
            }
            com.kwad.sdk.collector.a.d dVar = this.w;
            if (dVar != null) {
                q.a(jSONObject, "environmentInfo", dVar);
            }
            c cVar = this.x;
            if (cVar != null) {
                q.a(jSONObject, "baseStationInfo", cVar);
            }
            List<com.kwad.sdk.collector.a.e> list = this.y;
            if (list != null) {
                q.a(jSONObject, "sensorEventInfoList", list);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
