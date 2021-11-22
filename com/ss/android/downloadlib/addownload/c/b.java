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
/* loaded from: classes2.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DownloadInfo f69461a;

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
        this.f69461a = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.downloadad.api.a.b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f69461a == null || (a2 = f.a().a(this.f69461a)) == null) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_task", a2);
        long longValue = Double.valueOf((com.ss.android.downloadlib.g.e.a(this.f69461a.getId()) + 1.0d) * this.f69461a.getTotalBytes()).longValue() - this.f69461a.getCurBytes();
        long a3 = l.a(0L);
        if (j.l() != null) {
            j.l().e();
        }
        c.a();
        c.b();
        if (com.ss.android.downloadlib.g.e.g(a2.s())) {
            c.a(j.getContext());
        }
        long a4 = l.a(0L);
        if (a4 >= longValue) {
            a2.l("1");
            i.a().a(a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(a4 - a3));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("cleanspace_download_after_quite_clean", jSONObject, a2);
            Downloader.getInstance(j.getContext()).restart(this.f69461a.getId());
        } else if (j.l() != null) {
            a2.d(false);
            d.a().a(a2.a(), new e(this, a2) { // from class: com.ss.android.downloadlib.addownload.c.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.downloadad.api.a.b f69462a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f69463b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, a2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69463b = this;
                    this.f69462a = a2;
                }
            });
            if (j.l().a(this.f69461a.getId(), this.f69461a.getUrl(), true, longValue)) {
                a2.e(true);
            }
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("show_dialog_result", 3);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("cleanspace_window_show", jSONObject2, a2);
        }
    }
}
