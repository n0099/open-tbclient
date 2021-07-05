package d.l.a.d.b;

import android.net.http.Headers;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.kwai.video.player.KsMediaMeta;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.d.b.c;
import d.l.a.d.b.d;
import d.l.a.d.b.g;
import d.l.a.d.e;
import d.l.a.d.h;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f74277a;

    /* renamed from: b  reason: collision with root package name */
    public c.f f74278b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f74279c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f74280d;

    /* loaded from: classes10.dex */
    public class a implements g.InterfaceC2055g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f74281a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f74282b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.l.a.b.a.c.b f74283c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f74284d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.f f74285e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f74286f;

        public a(f fVar, int i2, String str, d.l.a.b.a.c.b bVar, long j, g.f fVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2), str, bVar, Long.valueOf(j), fVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74286f = fVar;
            this.f74281a = i2;
            this.f74282b = str;
            this.f74283c = bVar;
            this.f74284d = j;
            this.f74285e = fVar2;
        }

        @Override // d.l.a.d.b.g.InterfaceC2055g
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f74286f.g(this.f74281a, this.f74282b, j, this.f74283c, this.f74284d, this.f74285e);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.f f74287e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f74288f;

        public b(f fVar, g.f fVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, fVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74288f = fVar;
            this.f74287e = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f74288f.f74279c.get()) {
                return;
            }
            this.f74288f.f74279c.set(true);
            this.f74287e.a();
        }
    }

    /* loaded from: classes10.dex */
    public class c implements d.l.a.e.b.o.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g.InterfaceC2055g f74289a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f74290b;

        public c(f fVar, g.InterfaceC2055g interfaceC2055g) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, interfaceC2055g};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74290b = fVar;
            this.f74289a = interfaceC2055g;
        }

        @Override // d.l.a.e.b.o.l
        public void a(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, map) == null) || this.f74290b.f74279c.get()) {
                return;
            }
            this.f74290b.f74279c.set(true);
            long b2 = this.f74290b.b(map);
            if (b2 > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("apk_size", Long.valueOf(b2));
                    jSONObject.putOpt("available_space", Long.valueOf(f.t()));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.f74289a.a(b2);
        }
    }

    /* loaded from: classes10.dex */
    public class d implements d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(f fVar, d.l.a.b.a.c.b bVar, g.f fVar2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar, fVar2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.f f74291e;

        public e(f fVar, g.f fVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, fVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74291e = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f74291e.a();
            }
        }
    }

    /* renamed from: d.l.a.d.b.f$f  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2054f implements d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2054f(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g implements j {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static d.l.a.d.b.a.c f74292a;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes10.dex */
        public class a implements d.l.a.d.b.a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.l.a.b.a.c.b f74293a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ i f74294b;

            public a(g gVar, d.l.a.b.a.c.b bVar, i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, bVar, iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74293a = bVar;
                this.f74294b = iVar;
            }

            @Override // d.l.a.d.b.a.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.l.a.d.b.a.c unused = g.f74292a = null;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("pause_optimise_type", "apk_size");
                        jSONObject.putOpt("pause_optimise_action", "confirm");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    e.c.a().r("pause_optimise", jSONObject, this.f74293a);
                }
            }

            @Override // d.l.a.d.b.a.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    d.l.a.d.b.a.c unused = g.f74292a = null;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("pause_optimise_type", "apk_size");
                        jSONObject.putOpt("pause_optimise_action", QueryResponse.Options.CANCEL);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    e.c.a().r("pause_optimise", jSONObject, this.f74293a);
                    this.f74294b.a(this.f74293a);
                }
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
                }
            }
        }

        public static d.l.a.d.b.a.c c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f74292a : (d.l.a.d.b.a.c) invokeV.objValue;
        }

        public static String e(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) {
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                if (j >= KsMediaMeta.AV_CH_STEREO_RIGHT) {
                    return (j / KsMediaMeta.AV_CH_STEREO_RIGHT) + "G";
                } else if (j >= 1048576) {
                    return (j / 1048576) + "M";
                } else {
                    return decimalFormat.format(((float) j) / 1048576.0f) + "M";
                }
            }
            return (String) invokeJ.objValue;
        }

        @Override // d.l.a.d.b.f.j
        public boolean a(d.l.a.b.a.c.b bVar, int i2, i iVar) {
            InterceptResult invokeLIL;
            DownloadInfo d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, bVar, i2, iVar)) == null) {
                if (bVar == null || bVar.e0() || !f(bVar) || (d2 = d.l.a.d.h.b(null).d(bVar.a())) == null) {
                    return false;
                }
                long b2 = d.l.a.d.b.k.b(d2.getId(), d2.getCurBytes(), d2.getTotalBytes());
                long totalBytes = d2.getTotalBytes();
                if (b2 <= 0 || totalBytes <= 0 || totalBytes > b(bVar.s())) {
                    return false;
                }
                f74292a = new a(this, bVar, iVar);
                TTDelegateActivity.a(bVar, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", e(totalBytes - b2)), "继续", "暂停");
                bVar.c1(true);
                return true;
            }
            return invokeLIL.booleanValue;
        }

        public final int b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? d.l.a.e.b.j.a.d(i2).b("pause_optimise_apk_size", 100) * 1024 * 1024 : invokeI.intValue;
        }

        public final boolean f(d.l.a.b.a.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) ? h.k.c(aVar).b("pause_optimise_apk_size_switch", 0) == 1 && aVar.q() : invokeL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class h implements j {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static d.l.a.d.b.a.c f74295a;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes10.dex */
        public class a implements d.l.a.d.b.a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.l.a.b.a.c.b f74296a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ i f74297b;

            public a(h hVar, d.l.a.b.a.c.b bVar, i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, bVar, iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74296a = bVar;
                this.f74297b = iVar;
            }

            @Override // d.l.a.d.b.a.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.l.a.d.b.a.c unused = h.f74295a = null;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("pause_optimise_type", "download_percent");
                        jSONObject.putOpt("pause_optimise_action", "confirm");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    e.c.a().r("pause_optimise", jSONObject, this.f74296a);
                }
            }

            @Override // d.l.a.d.b.a.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    d.l.a.d.b.a.c unused = h.f74295a = null;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("pause_optimise_type", "download_percent");
                        jSONObject.putOpt("pause_optimise_action", QueryResponse.Options.CANCEL);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    e.c.a().r("pause_optimise", jSONObject, this.f74296a);
                    this.f74297b.a(this.f74296a);
                }
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
                }
            }
        }

        public static d.l.a.d.b.a.c c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f74295a : (d.l.a.d.b.a.c) invokeV.objValue;
        }

        @Override // d.l.a.d.b.f.j
        public boolean a(d.l.a.b.a.c.b bVar, int i2, i iVar) {
            InterceptResult invokeLIL;
            DownloadInfo d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, bVar, i2, iVar)) == null) {
                if (bVar == null || bVar.f0() || !e(bVar) || (d2 = d.l.a.d.h.b(null).d(bVar.a())) == null) {
                    return false;
                }
                long curBytes = d2.getCurBytes();
                long totalBytes = d2.getTotalBytes();
                if (curBytes > 0 && totalBytes > 0) {
                    int a2 = d.l.a.d.b.k.a(d2.getId(), (int) ((curBytes * 100) / totalBytes));
                    if (a2 > b(bVar.s())) {
                        f74295a = new a(this, bVar, iVar);
                        TTDelegateActivity.b(bVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(a2)), "继续", "暂停");
                        bVar.d1(true);
                        return true;
                    }
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }

        public final int b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? d.l.a.e.b.j.a.d(i2).b("pause_optimise_download_percent", 50) : invokeI.intValue;
        }

        public final boolean e(d.l.a.b.a.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) ? h.k.c(aVar).b("pause_optimise_download_percent_switch", 0) == 1 && aVar.q() : invokeL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface i {
        void a(d.l.a.b.a.c.b bVar);
    }

    /* loaded from: classes10.dex */
    public interface j {
        boolean a(d.l.a.b.a.c.b bVar, int i2, i iVar);
    }

    /* loaded from: classes10.dex */
    public class k implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.l.a.d.b.f.j
        public boolean a(d.l.a.b.a.c.b bVar, int i2, i iVar) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, bVar, i2, iVar)) == null) {
                if (bVar != null && c(bVar.s())) {
                    if (System.currentTimeMillis() - bVar.Q() <= b(bVar.s())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "mistake_click");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        e.c.a().r("pause_optimise", jSONObject, bVar);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }

        public final long b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? d.l.a.e.b.j.a.d(i2).b("pause_optimise_mistake_click_interval", 300) : invokeI.longValue;
        }

        public final boolean c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? d.l.a.e.b.j.a.d(i2).b("pause_optimise_mistake_click_interval_switch", 0) == 1 : invokeI.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class l {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static l f74298b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<j> f74299a;

        public l() {
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
            ArrayList arrayList = new ArrayList();
            this.f74299a = arrayList;
            arrayList.add(new k());
            this.f74299a.add(new m());
            this.f74299a.add(new h());
            this.f74299a.add(new g());
        }

        public static l a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f74298b == null) {
                    synchronized (l.class) {
                        if (f74298b == null) {
                            f74298b = new l();
                        }
                    }
                }
                return f74298b;
            }
            return (l) invokeV.objValue;
        }

        public void b(d.l.a.b.a.c.b bVar, int i2, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, iVar) == null) {
                List<j> list = this.f74299a;
                if (list != null && list.size() != 0 && bVar != null) {
                    DownloadInfo d2 = d.l.a.d.h.b(null).d(bVar.a());
                    if (d2 != null && "application/vnd.android.package-archive".equals(d2.getMimeType())) {
                        boolean z = d.l.a.e.b.j.a.d(bVar.s()).b("pause_optimise_switch", 0) == 1;
                        for (j jVar : this.f74299a) {
                            if (z || (jVar instanceof m)) {
                                if (jVar.a(bVar, i2, iVar)) {
                                    return;
                                }
                            }
                        }
                        iVar.a(bVar);
                        return;
                    }
                    iVar.a(bVar);
                    return;
                }
                iVar.a(bVar);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class m implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.l.a.d.b.f.j
        public boolean a(d.l.a.b.a.c.b bVar, int i2, i iVar) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, bVar, i2, iVar)) == null) {
                if (bVar == null) {
                    return false;
                }
                return n.d(bVar, d.l.a.d.h.b(null).d(bVar.a()), i2, iVar);
            }
            return invokeLIL.booleanValue;
        }
    }

    public f(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f74279c = new AtomicBoolean(false);
        this.f74280d = new AtomicBoolean(false);
        this.f74277a = handler;
    }

    public static JSONObject d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("clean_space_install_params", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void e(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65540, null, i2) == null) && h.k.r(i2) && d.l.a.d.b.l.y() != null && d.l.a.d.b.l.y().b()) {
            d.l.a.d.b.l.y().c();
        }
    }

    public static void h(d.l.a.b.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar) == null) {
            long t = t();
            if (d.l.a.d.b.l.y() != null) {
                d.l.a.d.b.l.y().e();
            }
            d.C2051d.a();
            d.C2051d.e();
            if (h.k.s(bVar.s())) {
                d.C2051d.b(d.l.a.d.b.l.a());
            }
            long t2 = t();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(t2 - t));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            e.c.a().r("clean_quite_finish", jSONObject, bVar);
        }
    }

    public static boolean p(DownloadInfo downloadInfo, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, downloadInfo, j2)) == null) {
            int id = downloadInfo.getId();
            boolean z = false;
            if (h.k.r(id)) {
                if (d.l.a.d.b.l.y() != null && (z = d.l.a.d.b.l.y().a(id, downloadInfo.getUrl(), false, j2))) {
                    d.e.a().e(downloadInfo.getUrl(), new C2054f(downloadInfo));
                }
                return z;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (d.l.a.d.b.l.y() != null) {
                return d.l.a.d.b.l.y().a();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? h.r.d(0L) : invokeV.longValue;
    }

    public final long b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            if (map != null && map.size() != 0) {
                try {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String value = entry.getValue();
                        if (Headers.CONTENT_LEN.equalsIgnoreCase(entry.getKey())) {
                            return Long.parseLong(value);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public void f(int i2, long j2, long j3, g.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), fVar}) == null) {
            this.f74280d.set(false);
            if (fVar == null) {
                return;
            }
            if (h.k.r(i2) && h.k.q(i2)) {
                long l2 = h.k.l(i2);
                this.f74279c.set(false);
                String a2 = this.f74278b.f74225b.a();
                d.l.a.b.a.c.b o = c.g.e().o(a2);
                if (o == null) {
                    c.f fVar2 = this.f74278b;
                    o = new d.l.a.b.a.c.b(fVar2.f74225b, fVar2.f74226c, fVar2.f74227d, 0);
                    c.g.e().j(o);
                }
                d.l.a.b.a.c.b bVar = o;
                bVar.A0(false);
                if (d.l.a.d.b.l.y() != null) {
                    d.l.a.d.b.l.y().a(bVar.b());
                }
                d.e.a().d(bVar.a());
                boolean o2 = h.k.o(i2);
                if (j3 > 0) {
                    g(i2, a2, j3, bVar, j2, fVar);
                } else if (o2) {
                    l(a2, bVar, new a(this, i2, a2, bVar, j2, fVar));
                } else {
                    l2 = 0;
                }
                this.f74277a.postDelayed(new b(this, fVar), l2);
                return;
            }
            fVar.a();
        }
    }

    public final void g(int i2, String str, long j2, d.l.a.b.a.c.b bVar, long j3, g.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), bVar, Long.valueOf(j3), fVar}) == null) {
            this.f74279c.set(true);
            boolean z = false;
            if (j2 > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("apk_size", Long.valueOf(j2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                long longValue = (Double.valueOf((h.k.a(i2) + 1.0d) * j2).longValue() + h.k.f(i2)) - j3;
                long t = t();
                if (t < longValue) {
                    i(bVar, jSONObject, longValue, t);
                    h(bVar);
                    long t2 = t();
                    if (t2 < longValue) {
                        bVar.w0(true);
                        String a2 = bVar.a();
                        d.e.a().e(a2, new d(this, bVar, fVar, a2));
                        z = o(i2, bVar, str, longValue);
                        if (z) {
                            bVar.A0(true);
                        }
                    } else {
                        r(bVar, jSONObject, t, t2);
                    }
                }
            }
            if (z) {
                return;
            }
            this.f74277a.post(new e(this, fVar));
        }
    }

    public final void i(d.l.a.b.a.c.b bVar, JSONObject jSONObject, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bVar, jSONObject, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            try {
                jSONObject.putOpt("available_space", Long.valueOf(j3));
                jSONObject.putOpt("apk_download_need_size", Long.valueOf(j2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            e.c.a().r("clean_space_no_enough_for_download", jSONObject, bVar);
        }
    }

    public void j(c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f74278b = fVar;
        }
    }

    public final void l(String str, d.l.a.b.a.c.b bVar, g.InterfaceC2055g interfaceC2055g) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, bVar, interfaceC2055g) == null) || interfaceC2055g == null) {
            return;
        }
        d.l.a.e.b.o.b.b.c(str, new c(this, interfaceC2055g));
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f74280d.set(z);
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f74280d.get() : invokeV.booleanValue;
    }

    public final boolean o(int i2, @NonNull d.l.a.b.a.c.b bVar, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), bVar, str, Long.valueOf(j2)})) == null) {
            if (h.k.r(i2)) {
                if (d.l.a.d.b.l.y() != null) {
                    return d.l.a.d.b.l.y().a(i2, str, true, j2);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("show_dialog_result", 3);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                e.c.a().r("cleanspace_window_show", jSONObject, bVar);
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void r(d.l.a.b.a.c.b bVar, JSONObject jSONObject, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{bVar, jSONObject, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            bVar.Y0("1");
            c.j.b().c(bVar);
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(j3 - j2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            e.c.a().r("cleanspace_download_after_quite_clean", jSONObject, bVar);
        }
    }
}
