package d.l.a.d.b;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.a.a.c.t;
import d.l.a.d.b.c;
import d.l.a.d.b.d;
import d.l.a.d.c;
import d.l.a.d.e;
import d.l.a.d.f;
import d.l.a.d.h;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class i implements h.s.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f74323a;

    /* renamed from: b  reason: collision with root package name */
    public c.f f74324b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f74325c;

    /* renamed from: d  reason: collision with root package name */
    public g f74326d;

    /* renamed from: e  reason: collision with root package name */
    public e f74327e;

    /* loaded from: classes10.dex */
    public class a implements t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f74328a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f74329b;

        public a(i iVar, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74329b = iVar;
            this.f74328a = tVar;
        }

        @Override // d.l.a.a.a.c.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f74328a.a();
            }
        }

        @Override // d.l.a.a.a.c.t
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                l.p().a(1, l.a(), this.f74329b.f74324b.f74225b, "您已禁止使用存储权限，请授权后再下载", null, 1);
                e.c.a().t(this.f74329b.f74323a, 1);
                this.f74328a.a(str);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f74331a;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74331a = iVar;
        }

        @Override // d.l.a.d.b.i.e
        public void a(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) {
                e.c.a().d(this.f74331a.f74323a, 2, downloadInfo);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class d extends d.l.a.e.b.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public h.s f74332b;

        public d(h.s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74332b = sVar;
        }

        @Override // d.l.a.e.b.f.u
        public void a(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) {
                n(downloadInfo, 11);
            }
        }

        @Override // d.l.a.e.b.f.a, d.l.a.e.b.f.b
        public void b(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                n(downloadInfo, -2);
            }
        }

        @Override // d.l.a.e.b.f.a, d.l.a.e.b.f.b
        public void c(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) {
                n(downloadInfo, 2);
            }
        }

        @Override // d.l.a.e.b.f.a, d.l.a.e.b.f.b
        public void e(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadInfo) == null) {
                n(downloadInfo, -4);
            }
        }

        @Override // d.l.a.e.b.f.a, d.l.a.e.b.f.b
        public void f(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) {
                n(downloadInfo, -3);
            }
        }

        @Override // d.l.a.e.b.f.a, d.l.a.e.b.f.b
        public void g(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, downloadInfo) == null) {
                n(downloadInfo, 4);
            }
        }

        @Override // d.l.a.e.b.f.a, d.l.a.e.b.f.b
        public void h(DownloadInfo downloadInfo, BaseException baseException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, downloadInfo, baseException) == null) {
                n(downloadInfo, -1);
            }
        }

        @Override // d.l.a.e.b.f.a, d.l.a.e.b.f.b
        public void l(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, downloadInfo) == null) {
                n(downloadInfo, 1);
            }
        }

        public final void n(DownloadInfo downloadInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadInfo, i2) == null) {
                Message obtain = Message.obtain();
                obtain.what = 3;
                obtain.obj = downloadInfo;
                obtain.arg1 = i2;
                this.f74332b.sendMessage(obtain);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface e {
        void a(DownloadInfo downloadInfo);
    }

    public i(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f74325c = false;
        this.f74326d = gVar;
    }

    @NonNull
    public static List<d.l.a.a.a.d.e> d(Map<Integer, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            ArrayList arrayList = new ArrayList();
            if (map != null && !map.isEmpty()) {
                for (Object obj : map.values()) {
                    if (obj instanceof d.l.a.a.a.d.e) {
                        arrayList.add((d.l.a.a.a.d.e) obj);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof d.l.a.a.a.d.e) {
                            arrayList.add((d.l.a.a.a.d.e) softReference.get());
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public static List<d.l.a.a.a.d.f> q(Map<Integer, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, map)) == null) {
            ArrayList arrayList = new ArrayList();
            if (map != null && !map.isEmpty()) {
                for (Object obj : map.values()) {
                    if (obj instanceof d.l.a.a.a.d.f) {
                        arrayList.add((d.l.a.a.a.d.f) obj);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof d.l.a.a.a.d.f) {
                            arrayList.add((d.l.a.a.a.d.f) softReference.get());
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final boolean A(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadInfo)) == null) ? downloadInfo != null && downloadInfo.getStatus() == -3 && d.l.a.e.b.l.f.E0(downloadInfo.getSavePath(), downloadInfo.getName()) : invokeL.booleanValue;
    }

    public int a(Context context, d.l.a.e.b.f.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar)) == null) {
            if (context == null) {
                return 0;
            }
            Map<String, String> j = this.f74324b.f74225b.j();
            ArrayList arrayList = new ArrayList();
            if (j != null) {
                for (Map.Entry<String, String> entry : j.entrySet()) {
                    if (entry != null) {
                        arrayList.add(new com.ss.android.socialbase.downloader.model.c(entry.getKey(), entry.getValue()));
                    }
                }
            }
            String a2 = h.j.a(String.valueOf(this.f74324b.f74225b.d()), this.f74324b.f74225b.c(), this.f74324b.f74225b.k(), String.valueOf(this.f74324b.f74225b.A()));
            d.l.a.e.b.j.a g2 = h.k.g(this.f74324b.f74225b);
            JSONObject e2 = h.k.e(this.f74324b.f74225b);
            if (!this.f74324b.f74227d.h()) {
                e2 = h.r.n(e2);
                h.r.q(e2, "ah_plans", new JSONArray());
            }
            this.f74324b.f74225b.F();
            int i2 = (this.f74324b.f74225b.t() || j.i(this.f74324b.f74225b)) ? 4 : 4;
            String c2 = c(g2);
            DownloadInfo f2 = d.l.a.e.b.g.a.H(l.a()).f(d.l.a.e.b.g.e.w(this.f74324b.f74225b.a(), c2));
            if (f2 != null && 3 == this.f74324b.f74225b.A()) {
                f2.setFirstDownload(true);
            }
            d.l.a.e.a.i iVar = new d.l.a.e.a.i(context, this.f74324b.f74225b.a());
            iVar.V(this.f74324b.f74225b.b());
            iVar.H(this.f74324b.f74225b.h());
            iVar.c0(a2);
            iVar.I(arrayList);
            iVar.K(this.f74324b.f74225b.l());
            iVar.Z(this.f74324b.f74225b.m());
            iVar.U(this.f74324b.f74225b.o());
            iVar.Y(c2);
            iVar.w0(this.f74324b.f74225b.w());
            iVar.n0(this.f74324b.f74225b.e());
            iVar.t0(this.f74324b.f74225b.I());
            iVar.B(this.f74324b.f74225b.f());
            iVar.D(bVar);
            iVar.B0(this.f74324b.f74225b.q() || g2.b("need_independent_process", 0) == 1);
            iVar.G(this.f74324b.f74225b.D());
            iVar.W(this.f74324b.f74225b.C());
            iVar.k0(this.f74324b.f74225b.v());
            iVar.b0(1000);
            iVar.f0(100);
            iVar.J(e2);
            iVar.u0(true);
            iVar.x0(true);
            iVar.T(g2.b("retry_count", 5));
            iVar.X(g2.b("backup_url_retry_count", 0));
            iVar.x0(true);
            iVar.D0(g2.b("need_head_connection", 0) == 1);
            iVar.d0(g2.b("need_https_to_http_retry", 0) == 1);
            iVar.r0(g2.b("need_chunk_downgrade_retry", 1) == 1);
            iVar.o0(g2.b("need_retry_delay", 0) == 1);
            iVar.q0(g2.t("retry_delay_time_array"));
            iVar.z0(g2.b("need_reuse_runnable", 0) == 1);
            iVar.j0(i2);
            iVar.J0(this.f74324b.f74225b.J());
            iVar.H0(this.f74324b.f74225b.K());
            if (!TextUtils.isEmpty(this.f74324b.f74225b.i())) {
                iVar.g0(this.f74324b.f74225b.i());
            } else {
                iVar.g0("application/vnd.android.package-archive");
            }
            if (g2.b("notification_opt_2", 0) == 1) {
                iVar.K(false);
                iVar.W(true);
            }
            d.b bVar2 = null;
            if (g2.b("clear_space_use_disk_handler", 0) == 1) {
                bVar2 = new d.b();
                iVar.F(bVar2);
            }
            int a3 = j.a(this.f74324b, u(), iVar);
            if (bVar2 != null) {
                bVar2.c(a3);
            }
            return a3;
        }
        return invokeLL.intValue;
    }

    @Override // d.l.a.d.h.s.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }

    public final String c(d.l.a.e.b.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
            if (!TextUtils.isEmpty(this.f74324b.f74225b.n())) {
                return this.f74324b.f74225b.n();
            }
            DownloadInfo e2 = d.l.a.e.a.e.G().e(l.a(), this.f74324b.f74225b.a());
            boolean e3 = h.p.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            String p = p();
            if (e2 != null && !TextUtils.isEmpty(e2.getSavePath())) {
                String savePath = e2.getSavePath();
                if (e3 || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                    return savePath;
                }
                try {
                    if (!TextUtils.isEmpty(p)) {
                        if (savePath.startsWith(p)) {
                            return savePath;
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                d.l.a.e.b.g.a.H(d.l.a.e.b.g.e.n()).b(e2.getId());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("ttdownloader_code", Integer.valueOf(e3 ? 1 : 2));
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            e.c.a().r("label_external_permission", jSONObject, this.f74324b);
            String str = null;
            try {
                str = d.l.a.e.a.d.F();
            } catch (Exception unused) {
            }
            int b2 = h.k.b(aVar);
            if (b2 != 0) {
                if (b2 != 4 && (e3 || b2 != 2)) {
                    if ((b2 == 3 || (!e3 && b2 == 1)) && !TextUtils.isEmpty(p)) {
                        return p;
                    }
                } else {
                    File filesDir = l.a().getFilesDir();
                    if (!filesDir.exists()) {
                        filesDir.mkdirs();
                    }
                    if (filesDir.exists()) {
                        return filesDir.getAbsolutePath();
                    }
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f74327e == null) {
            this.f74327e = new c(this);
        }
    }

    public void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.f74323a = j;
            c.f v = c.g.e().v(j);
            this.f74324b = v;
            if (v.x()) {
                f.e.b().d("setAdId ModelBox notValid");
            }
        }
    }

    public void g(Message message, d.l.a.a.a.f.e eVar, Map<Integer, Object> map) {
        e eVar2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, message, eVar, map) == null) && message != null && message.what == 3) {
            DownloadInfo downloadInfo = (DownloadInfo) message.obj;
            int i2 = message.arg1;
            if (i2 != 1 && i2 != 6 && i2 == 2) {
                if (downloadInfo.getIsFirstDownload()) {
                    d.l.a.d.g b2 = d.l.a.d.g.b();
                    c.f fVar = this.f74324b;
                    b2.f(fVar.f74225b, fVar.f74227d, fVar.f74226c);
                    downloadInfo.setFirstDownload(false);
                }
                e.c.a().h(downloadInfo);
            }
            eVar.a(downloadInfo);
            k.c(eVar);
            int b3 = d.l.a.e.a.d.b(downloadInfo.getStatus());
            long totalBytes = downloadInfo.getTotalBytes();
            int i3 = (totalBytes > 0L ? 1 : (totalBytes == 0L ? 0 : -1));
            int curBytes = i3 > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
            if ((i3 > 0 || d.l.a.e.b.j.a.r().l("fix_click_start")) && (eVar2 = this.f74327e) != null) {
                eVar2.a(downloadInfo);
                this.f74327e = null;
            }
            for (d.l.a.a.a.d.e eVar3 : d(map)) {
                if (b3 != 1) {
                    if (b3 == 2) {
                        eVar3.b(eVar, k.a(downloadInfo.getId(), curBytes));
                    } else if (b3 == 3) {
                        if (downloadInfo.getStatus() == -4) {
                            eVar3.a();
                        } else if (downloadInfo.getStatus() == -1) {
                            eVar3.a(eVar);
                        } else if (downloadInfo.getStatus() == -3) {
                            if (h.r.v(this.f74324b.f74225b)) {
                                eVar3.b(eVar);
                            } else {
                                eVar3.c(eVar);
                            }
                        }
                    }
                } else if (downloadInfo.getStatus() != 11) {
                    eVar3.a(eVar, k.a(downloadInfo.getId(), curBytes));
                } else {
                    for (d.l.a.a.a.d.f fVar2 : q(map)) {
                        fVar2.a(downloadInfo);
                    }
                }
            }
        }
    }

    public void h(@NonNull t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tVar) == null) {
            if (!TextUtils.isEmpty(this.f74324b.f74225b.n())) {
                String n = this.f74324b.f74225b.n();
                if (n.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                    tVar.a();
                    return;
                }
                try {
                    if (n.startsWith(l.a().getExternalCacheDir().getParent())) {
                        tVar.a();
                        return;
                    }
                } catch (Exception unused) {
                }
            }
            r(new a(this, tVar));
        }
    }

    public void i(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadInfo) == null) {
            this.f74325c = false;
            s(downloadInfo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(DownloadInfo downloadInfo, d.l.a.a.a.f.e eVar, List<d.l.a.a.a.d.e> list) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048585, this, downloadInfo, eVar, list) == null) || list.isEmpty()) {
            return;
        }
        if (downloadInfo != null && eVar != null) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (downloadInfo.getTotalBytes() > 0) {
                i2 = (int) ((downloadInfo.getCurBytes() * 100) / downloadInfo.getTotalBytes());
                int i3 = i2 >= 0 ? i2 : 0;
                eVar.a(downloadInfo);
                k.c(eVar);
                for (d.l.a.a.a.d.e eVar2 : list) {
                    switch (downloadInfo.getStatus()) {
                        case -4:
                        case 0:
                            if (h.r.v(this.f74324b.f74225b)) {
                                eVar.f74083b = -3;
                                eVar2.b(eVar);
                                break;
                            } else {
                                eVar2.a();
                                break;
                            }
                        case -3:
                            if (h.r.v(this.f74324b.f74225b)) {
                                eVar2.b(eVar);
                                break;
                            } else {
                                eVar2.c(eVar);
                                break;
                            }
                        case -2:
                            eVar2.b(eVar, k.a(downloadInfo.getId(), i3));
                            break;
                        case -1:
                            eVar2.a(eVar);
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                        case 8:
                            eVar2.a(eVar, k.a(downloadInfo.getId(), i3));
                            break;
                        case 11:
                            if (eVar2 instanceof d.l.a.a.a.d.f) {
                                ((d.l.a.a.a.d.f) eVar2).a(downloadInfo);
                                break;
                            } else {
                                eVar2.a(eVar, k.a(downloadInfo.getId(), i3));
                                break;
                            }
                    }
                }
                return;
            }
            i2 = 0;
            if (i2 >= 0) {
            }
            eVar.a(downloadInfo);
            k.c(eVar);
            while (r9.hasNext()) {
            }
            return;
        }
        for (d.l.a.a.a.d.e eVar3 : list) {
            eVar3.a();
        }
    }

    public void k(DownloadInfo downloadInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, downloadInfo, z) == null) || this.f74324b.f74225b == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status != -1 && status != -4) {
            if (j.f(this.f74324b.f74225b)) {
                e.c.a().c(this.f74323a, 2);
            } else if (z && e.C2063e.a().f() && (status == -2 || status == -3)) {
                e.c.a().c(this.f74323a, 2);
            }
        } else {
            e.c.a().c(this.f74323a, 2);
        }
        switch (status) {
            case -4:
            case -1:
                e();
                c.g e2 = c.g.e();
                c.f fVar = this.f74324b;
                e2.j(new d.l.a.b.a.c.b(fVar.f74225b, fVar.f74226c, fVar.f74227d, downloadInfo.getId()));
                return;
            case -3:
                if (h.r.v(this.f74324b.f74225b)) {
                    f.e.b().g("SUCCESSED isInstalledApp");
                    return;
                }
                e.c.a().d(this.f74323a, 5, downloadInfo);
                if (z && e.C2063e.a().c() && !e.C2063e.a().d(this.f74323a, this.f74324b.f74225b.u())) {
                    e.c.a().c(this.f74323a, 2);
                    return;
                }
                return;
            case -2:
                e.c.a().d(this.f74323a, 4, downloadInfo);
                if (z && e.C2063e.a().c() && !e.C2063e.a().d(this.f74323a, this.f74324b.f74225b.u())) {
                    e.c.a().c(this.f74323a, 2);
                    return;
                }
                return;
            case 0:
            case 6:
            default:
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                e.c.a().d(this.f74323a, 3, downloadInfo);
                return;
        }
    }

    public final boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            if (this.f74324b.f74227d.b() == 2 && i2 == 2) {
                return true;
            }
            return this.f74324b.f74227d.b() == 2 && i2 == 1 && l.v().optInt("disable_lp_if_market", 0) == 1;
        }
        return invokeI.booleanValue;
    }

    public boolean m(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (h.r.v(this.f74324b.f74225b)) {
                d.l.a.b.a.c.b u = c.g.e().u(this.f74324b.f74224a);
                if (u != null) {
                    d.l.a.e.b.p.b.a().m(u.s());
                }
                return c.d.g(this.f74324b);
            } else if (l(i2) && !TextUtils.isEmpty(this.f74324b.f74225b.v()) && l.v().optInt("disable_market") != 1) {
                return c.d.h(this.f74324b, i2);
            } else {
                if (z && this.f74324b.f74227d.b() == 4 && !this.f74326d.D()) {
                    this.f74326d.w(true);
                    return true;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public boolean n(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) ? !z && this.f74324b.f74227d.b() == 1 : invokeZ.booleanValue;
    }

    @Nullable
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            File externalFilesDir = l.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (externalFilesDir != null) {
                if (!externalFilesDir.exists()) {
                    externalFilesDir.mkdirs();
                }
                if (externalFilesDir.exists()) {
                    return externalFilesDir.getAbsolutePath();
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void r(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tVar) == null) {
            if (!h.p.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                h.p.d(new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new b(this, tVar));
            } else if (tVar != null) {
                tVar.a();
            }
        }
    }

    public void s(@Nullable DownloadInfo downloadInfo) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, downloadInfo) == null) || (eVar = this.f74327e) == null) {
            return;
        }
        eVar.a(downloadInfo);
        this.f74327e = null;
    }

    public void t(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, downloadInfo) == null) && j.f(this.f74324b.f74225b) && !this.f74325c) {
            e.c.a().j("file_status", (downloadInfo == null || !h.r.D(downloadInfo.getTargetFilePath())) ? 2 : 1, this.f74324b);
            this.f74325c = true;
        }
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? v() && x() : invokeV.booleanValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            d.l.a.a.a.d.d dVar = this.f74324b.f74225b;
            return (dVar == null || TextUtils.isEmpty(dVar.v()) || TextUtils.isEmpty(this.f74324b.f74225b.a())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean w(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, downloadInfo)) == null) ? z() || y(downloadInfo) : invokeL.booleanValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f74324b.f74227d.d() : invokeV.booleanValue;
    }

    public final boolean y(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, downloadInfo)) == null) ? !h.r.v(this.f74324b.f74225b) && A(downloadInfo) : invokeL.booleanValue;
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? h.r.v(this.f74324b.f74225b) && j.e(this.f74324b.f74227d.a()) : invokeV.booleanValue;
    }

    /* loaded from: classes10.dex */
    public class b implements h.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f74330a;

        public b(i iVar, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74330a = tVar;
        }

        @Override // d.l.a.d.h.p.a
        public void a() {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tVar = this.f74330a) == null) {
                return;
            }
            tVar.a();
        }

        @Override // d.l.a.d.h.p.a
        public void a(String str) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (tVar = this.f74330a) == null) {
                return;
            }
            tVar.a(str);
        }
    }
}
