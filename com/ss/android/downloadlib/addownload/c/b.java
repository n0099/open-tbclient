package com.ss.android.downloadlib.addownload.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadInfo a;

    public b(DownloadInfo downloadInfo) {
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
                return;
            }
        }
        this.a = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.downloadad.api.a.b a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null || (a = f.a().a(this.a)) == null) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_task", a);
        long longValue = Double.valueOf((com.ss.android.downloadlib.g.e.a(this.a.getId()) + 1.0d) * this.a.getTotalBytes()).longValue() - this.a.getCurBytes();
        long a2 = l.a(0L);
        if (j.l() != null) {
            j.l().e();
        }
        c.a();
        c.b();
        if (com.ss.android.downloadlib.g.e.g(a.s())) {
            c.a(j.getContext());
        }
        long a3 = l.a(0L);
        if (a3 >= longValue) {
            a.l("1");
            i.a().a(a);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(a3 - a2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("cleanspace_download_after_quite_clean", jSONObject, a);
            Downloader.getInstance(j.getContext()).restart(this.a.getId());
        } else if (j.l() != null) {
            a.d(false);
            d.a().a(a.a(), new e(this, a) { // from class: com.ss.android.downloadlib.addownload.c.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.downloadad.api.a.b a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f61820b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, a};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61820b = this;
                    this.a = a;
                }
            });
            if (j.l().a(this.a.getId(), this.a.getUrl(), true, longValue)) {
                a.e(true);
            }
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("show_dialog_result", 3);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("cleanspace_window_show", jSONObject2, a);
        }
    }
}
