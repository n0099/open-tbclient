package d.l.a.d.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.d.b.f;
import d.l.a.d.e;
import d.l.a.d.f;
import d.l.a.d.h;
import d.l.a.e.b.m.q;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static d.l.a.d.b.a.c f71394a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements d.l.a.d.b.a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f71395a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.l.a.b.a.c.b f71396b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f.i f71397c;

        public a(int i2, d.l.a.b.a.c.b bVar, f.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), bVar, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71395a = i2;
            this.f71396b = bVar;
            this.f71397c = iVar;
        }

        @Override // d.l.a.d.b.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n.b(null);
                DownloadInfo f2 = d.l.a.e.b.g.a.H(l.a()).f(this.f71395a);
                if (f2 != null) {
                    f2.startPauseReserveOnWifi();
                    q.d().k(f2);
                    e.c.a().v("pause_reserve_wifi_confirm", this.f71396b);
                }
                this.f71397c.a(this.f71396b);
            }
        }

        @Override // d.l.a.d.b.a.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                n.b(null);
                DownloadInfo f2 = d.l.a.e.b.g.a.H(l.a()).f(this.f71395a);
                if (f2 != null) {
                    f2.stopPauseReserveOnWifi();
                }
                e.c.a().v("pause_reserve_wifi_cancel", this.f71396b);
                this.f71397c.a(this.f71396b);
            }
        }
    }

    public static d.l.a.d.b.a.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f71394a : (d.l.a.d.b.a.c) invokeV.objValue;
    }

    public static void b(d.l.a.d.b.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, cVar) == null) {
            f71394a = cVar;
        }
    }

    public static boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 7 || i2 == 8 : invokeI.booleanValue;
    }

    public static boolean d(d.l.a.b.a.c.b bVar, DownloadInfo downloadInfo, int i2, f.i iVar) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65539, null, bVar, downloadInfo, i2, iVar)) == null) {
            if (bVar == null) {
                f.e.b().d("tryReverseWifi nativeModel null");
                return false;
            } else if (downloadInfo == null) {
                f.e.b().d("tryReverseWifi info null");
                return false;
            } else {
                int id = downloadInfo.getId();
                boolean i3 = h.k.i(bVar);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("switch_status", Integer.valueOf(i3 ? 1 : 0));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                e.c.a().r("pause_reserve_wifi_switch_status", jSONObject, bVar);
                if (i3 && c(i2) && !d.l.a.e.b.l.f.g0(l.a()) && !downloadInfo.hasPauseReservedOnWifi()) {
                    b(new a(id, bVar, iVar));
                    TTDelegateActivity.b(bVar);
                    return true;
                }
                return false;
            }
        }
        return invokeLLIL.booleanValue;
    }
}
