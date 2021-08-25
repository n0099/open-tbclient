package com.ss.android.socialbase.downloader.downloader;

import c.p.a.e.b.g.e;
import c.p.a.e.b.g.p;
import c.p.a.e.b.g.v;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class IndependentProcessDownloadService extends DownloadService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IndependentProcessDownloadService() {
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

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onCreate();
            e.C(this);
            if (e.t() == null) {
                e.L(new v());
            }
            p O0 = e.O0();
            this.f75713a = O0;
            O0.c(new WeakReference(this));
        }
    }
}
