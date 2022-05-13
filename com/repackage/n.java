package com.repackage;

import android.os.Handler;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public class n implements v10 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Executor a;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final u10 a;
        public final t10 b;

        public a(u10 u10Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u10Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u10Var;
            this.b = u10Var.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                switch (this.a.h()) {
                    case 102:
                        z10.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                        this.b.c();
                        return;
                    case 103:
                        z10.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.a.e() + " acceptRanges: " + this.a.i());
                        this.b.b(this.a.e(), this.a.i());
                        return;
                    case 104:
                        z10.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.a.d() + " length: " + this.a.e() + " percent: " + this.a.f());
                        this.b.g(this.a.d(), this.a.e(), this.a.f());
                        return;
                    case 105:
                        z10.a(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.a.g());
                        if (this.a.b()) {
                            return;
                        }
                        this.a.l(true);
                        this.b.a(this.a.g());
                        return;
                    case 106:
                        z10.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                        this.b.e();
                        return;
                    case 107:
                        z10.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                        this.b.d();
                        return;
                    case 108:
                        z10.b(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.a.c().getCause());
                        this.b.f((DownloadException) this.a.c());
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Handler a;

        public b(n nVar, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.a.post(runnable);
            }
        }
    }

    public n(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new b(this, handler);
    }

    @Override // com.repackage.v10
    public void a(u10 u10Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, u10Var) == null) {
            this.a.execute(new a(u10Var));
        }
    }
}
