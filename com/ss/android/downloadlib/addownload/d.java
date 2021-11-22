package com.ss.android.downloadlib.addownload;

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
import com.ss.android.downloadlib.addownload.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f69520a;

    /* renamed from: b  reason: collision with root package name */
    public com.ss.android.downloadlib.addownload.b.e f69521b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f69522c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f69523d;

    public d(Handler handler) {
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
        this.f69522c = new AtomicBoolean(false);
        this.f69523d = new AtomicBoolean(false);
        this.f69520a = handler;
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (j.l() != null) {
                return j.l().a();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? com.ss.android.downloadlib.g.l.a(0L) : invokeV.longValue;
    }

    private void b(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{bVar, jSONObject, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            bVar.l("1");
            com.ss.android.downloadlib.addownload.b.i.a().a(bVar);
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(j2 - j));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("cleanspace_download_after_quite_clean", jSONObject, bVar);
        }
    }

    public void a(com.ss.android.downloadlib.addownload.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            this.f69521b = eVar;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f69523d.get() : invokeV.booleanValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f69523d.set(z);
        }
    }

    public void a(int i2, long j, long j2, e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), aVar}) == null) {
            this.f69523d.set(false);
            if (aVar == null) {
                return;
            }
            if (com.ss.android.downloadlib.g.e.f(i2) && com.ss.android.downloadlib.g.e.e(i2)) {
                long c2 = com.ss.android.downloadlib.g.e.c(i2);
                this.f69522c.set(false);
                String downloadUrl = this.f69521b.f69434b.getDownloadUrl();
                com.ss.android.downloadad.api.a.b b2 = com.ss.android.downloadlib.addownload.b.f.a().b(downloadUrl);
                if (b2 == null) {
                    com.ss.android.downloadlib.addownload.b.e eVar = this.f69521b;
                    b2 = new com.ss.android.downloadad.api.a.b(eVar.f69434b, eVar.f69435c, eVar.f69436d, 0);
                    com.ss.android.downloadlib.addownload.b.f.a().a(b2);
                }
                com.ss.android.downloadad.api.a.b bVar = b2;
                bVar.e(false);
                if (j.l() != null) {
                    j.l().a(bVar.b());
                }
                com.ss.android.downloadlib.addownload.c.d.a().a(bVar.a());
                boolean d2 = com.ss.android.downloadlib.g.e.d(i2);
                if (j2 > 0) {
                    a(i2, downloadUrl, j2, bVar, j, aVar);
                } else if (d2) {
                    a(downloadUrl, bVar, new e.b(this, i2, downloadUrl, bVar, j, aVar) { // from class: com.ss.android.downloadlib.addownload.d.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f69524a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f69525b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ com.ss.android.downloadad.api.a.b f69526c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ long f69527d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ e.a f69528e;

                        /* renamed from: f  reason: collision with root package name */
                        public final /* synthetic */ d f69529f;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i2), downloadUrl, bVar, Long.valueOf(j), aVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f69529f = this;
                            this.f69524a = i2;
                            this.f69525b = downloadUrl;
                            this.f69526c = bVar;
                            this.f69527d = j;
                            this.f69528e = aVar;
                        }

                        @Override // com.ss.android.downloadlib.addownload.e.b
                        public void a(long j3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j3) == null) {
                                this.f69529f.a(this.f69524a, this.f69525b, j3, this.f69526c, this.f69527d, this.f69528e);
                            }
                        }
                    });
                } else {
                    c2 = 0;
                }
                this.f69520a.postDelayed(new Runnable(this, aVar) { // from class: com.ss.android.downloadlib.addownload.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ e.a f69530a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ d f69531b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f69531b = this;
                        this.f69530a = aVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f69531b.f69522c.get()) {
                            return;
                        }
                        this.f69531b.f69522c.set(true);
                        this.f69530a.a();
                    }
                }, c2);
                return;
            }
            aVar.a();
        }
    }

    private void a(String str, com.ss.android.downloadad.api.a.b bVar, e.b bVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, this, str, bVar, bVar2) == null) || bVar2 == null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.a.b.a(str, new com.ss.android.socialbase.downloader.network.j(this, bVar2) { // from class: com.ss.android.downloadlib.addownload.d.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e.b f69532a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f69533b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, bVar2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f69533b = this;
                this.f69532a = bVar2;
            }

            @Override // com.ss.android.socialbase.downloader.network.j
            public void a(Map<String, String> map) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, map) == null) || this.f69533b.f69522c.get()) {
                    return;
                }
                this.f69533b.f69522c.set(true);
                long a2 = this.f69533b.a(map);
                if (a2 > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(a2));
                        jSONObject.putOpt("available_space", Long.valueOf(d.d()));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                this.f69532a.a(a2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, map)) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, long j, com.ss.android.downloadad.api.a.b bVar, long j2, e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j), bVar, Long.valueOf(j2), aVar}) == null) {
            this.f69522c.set(true);
            boolean z = false;
            if (j > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("apk_size", Long.valueOf(j));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                long longValue = (Double.valueOf((com.ss.android.downloadlib.g.e.a(i2) + 1.0d) * j).longValue() + com.ss.android.downloadlib.g.e.b(i2)) - j2;
                long d2 = d();
                if (d2 < longValue) {
                    a(bVar, jSONObject, longValue, d2);
                    a(bVar);
                    long d3 = d();
                    if (d3 < longValue) {
                        bVar.d(true);
                        String a2 = bVar.a();
                        com.ss.android.downloadlib.addownload.c.d.a().a(a2, new com.ss.android.downloadlib.addownload.c.e(this, bVar, aVar, a2) { // from class: com.ss.android.downloadlib.addownload.d.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ com.ss.android.downloadad.api.a.b f69534a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ e.a f69535b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ String f69536c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ d f69537d;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, bVar, aVar, a2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f69537d = this;
                                this.f69534a = bVar;
                                this.f69535b = aVar;
                                this.f69536c = a2;
                            }
                        });
                        z = a(i2, bVar, str, longValue);
                        if (z) {
                            bVar.e(true);
                        }
                    } else {
                        b(bVar, jSONObject, d2, d3);
                    }
                }
            }
            if (z) {
                return;
            }
            this.f69520a.post(new Runnable(this, aVar) { // from class: com.ss.android.downloadlib.addownload.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e.a f69538a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f69539b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69539b = this;
                    this.f69538a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f69538a.a();
                    }
                }
            });
        }
    }

    private boolean a(int i2, @NonNull com.ss.android.downloadad.api.a.b bVar, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{Integer.valueOf(i2), bVar, str, Long.valueOf(j)})) == null) {
            if (com.ss.android.downloadlib.g.e.f(i2)) {
                if (j.l() != null) {
                    return j.l().a(i2, str, true, j);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("show_dialog_result", 3);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.downloadlib.d.a.a().a("cleanspace_window_show", jSONObject, bVar);
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(DownloadInfo downloadInfo, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65548, null, downloadInfo, j)) == null) {
            int id = downloadInfo.getId();
            boolean z = false;
            if (com.ss.android.downloadlib.g.e.f(id)) {
                if (j.l() != null && (z = j.l().a(id, downloadInfo.getUrl(), false, j))) {
                    com.ss.android.downloadlib.addownload.c.d.a().a(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.c.e(downloadInfo) { // from class: com.ss.android.downloadlib.addownload.d.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ DownloadInfo f69540a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {downloadInfo};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f69540a = downloadInfo;
                        }
                    });
                }
                return z;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static JSONObject a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
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

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2) == null) && com.ss.android.downloadlib.g.e.f(i2) && j.l() != null && j.l().b()) {
            j.l().c();
        }
    }

    public static void a(com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, bVar) == null) {
            long d2 = d();
            if (j.l() != null) {
                j.l().e();
            }
            com.ss.android.downloadlib.addownload.c.c.a();
            com.ss.android.downloadlib.addownload.c.c.b();
            if (com.ss.android.downloadlib.g.e.g(bVar.s())) {
                com.ss.android.downloadlib.addownload.c.c.a(j.getContext());
            }
            long d3 = d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(d3 - d2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("clean_quite_finish", jSONObject, bVar);
        }
    }

    private void a(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{bVar, jSONObject, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            try {
                jSONObject.putOpt("available_space", Long.valueOf(j2));
                jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("clean_space_no_enough_for_download", jSONObject, bVar);
        }
    }
}
