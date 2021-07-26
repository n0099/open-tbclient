package d.a.w0.k.f;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
import java.util.concurrent.Executor;
/* loaded from: classes8.dex */
public class c implements d.a.w0.k.e.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Executor f68655a;

    /* loaded from: classes8.dex */
    public class a implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f68656e;

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
            this.f68656e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.f68656e.post(runnable);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final d.a.w0.k.e.c f68657e;

        /* renamed from: f  reason: collision with root package name */
        public final d.a.w0.k.e.a f68658f;

        public b(d.a.w0.k.e.c cVar) {
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
            this.f68657e = cVar;
            this.f68658f = cVar.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                switch (this.f68657e.h()) {
                    case 102:
                        d.a.w0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                        this.f68658f.c();
                        return;
                    case 103:
                        d.a.w0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.f68657e.e() + " acceptRanges: " + this.f68657e.i());
                        this.f68658f.b(this.f68657e.e(), this.f68657e.i());
                        return;
                    case 104:
                        d.a.w0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.f68657e.d() + " length: " + this.f68657e.e() + " percent: " + this.f68657e.f());
                        this.f68658f.g(this.f68657e.d(), this.f68657e.e(), this.f68657e.f());
                        return;
                    case 105:
                        d.a.w0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.f68657e.g());
                        if (this.f68657e.b()) {
                            return;
                        }
                        this.f68657e.l(true);
                        this.f68658f.a(this.f68657e.g());
                        return;
                    case 106:
                        d.a.w0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                        this.f68658f.e();
                        return;
                    case 107:
                        d.a.w0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                        this.f68658f.d();
                        return;
                    case 108:
                        d.a.w0.t.i.c(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.f68657e.c().getCause());
                        this.f68658f.f((DownloadException) this.f68657e.c());
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
        this.f68655a = new a(this, handler);
    }

    @Override // d.a.w0.k.e.d
    public void a(d.a.w0.k.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f68655a.execute(new b(cVar));
        }
    }
}
