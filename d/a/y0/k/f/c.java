package d.a.y0.k.f;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
import java.util.concurrent.Executor;
/* loaded from: classes9.dex */
public class c implements d.a.y0.k.e.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Executor f71174a;

    /* loaded from: classes9.dex */
    public class a implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f71175e;

        public a(c cVar, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71175e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.f71175e.post(runnable);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final d.a.y0.k.e.c f71176e;

        /* renamed from: f  reason: collision with root package name */
        public final d.a.y0.k.e.a f71177f;

        public b(d.a.y0.k.e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71176e = cVar;
            this.f71177f = cVar.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                switch (this.f71176e.h()) {
                    case 102:
                        d.a.y0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                        this.f71177f.c();
                        return;
                    case 103:
                        d.a.y0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.f71176e.e() + " acceptRanges: " + this.f71176e.i());
                        this.f71177f.b(this.f71176e.e(), this.f71176e.i());
                        return;
                    case 104:
                        d.a.y0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.f71176e.d() + " length: " + this.f71176e.e() + " percent: " + this.f71176e.f());
                        this.f71177f.g(this.f71176e.d(), this.f71176e.e(), this.f71176e.f());
                        return;
                    case 105:
                        d.a.y0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.f71176e.g());
                        if (this.f71176e.b()) {
                            return;
                        }
                        this.f71176e.l(true);
                        this.f71177f.a(this.f71176e.g());
                        return;
                    case 106:
                        d.a.y0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                        this.f71177f.e();
                        return;
                    case 107:
                        d.a.y0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                        this.f71177f.d();
                        return;
                    case 108:
                        d.a.y0.t.i.c(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.f71176e.c().getCause());
                        this.f71177f.f((DownloadException) this.f71176e.c());
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public c(Handler handler) {
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
        this.f71174a = new a(this, handler);
    }

    @Override // d.a.y0.k.e.d
    public void a(d.a.y0.k.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f71174a.execute(new b(cVar));
        }
    }
}
