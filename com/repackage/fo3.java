package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.go3;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class fo3 implements go3.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService a;
    public final no3 b;
    public final DownloadInfo c;
    public final a d;
    public long e;
    public volatile AtomicBoolean f;

    /* loaded from: classes6.dex */
    public interface a {
        void e(DownloadInfo downloadInfo);
    }

    public fo3(ExecutorService executorService, no3 no3Var, DownloadInfo downloadInfo, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService, no3Var, downloadInfo, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = System.currentTimeMillis();
        this.f = new AtomicBoolean(false);
        this.a = executorService;
        this.b = no3Var;
        this.c = downloadInfo;
        this.d = aVar;
    }

    @Override // com.repackage.go3.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.getProgress() == this.c.getSize()) {
            this.c.setPackageName(aq3.d(AppRuntime.getAppContext(), this.c.getPath()));
            this.c.setStatus(DownloadState.DOWNLOADED.value());
            this.b.b(this.c);
            a aVar = this.d;
            if (aVar != null) {
                aVar.e(this.c);
            }
        }
    }

    @Override // com.repackage.go3.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f.get()) {
                this.f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.e > 1000) {
                    this.b.b(this.c);
                    this.e = currentTimeMillis;
                }
                this.f.set(false);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.submit(new go3(this.b, this.c, this));
        }
    }
}
