package d.a.q0.f.i.k.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.f.i.k.d.d;
import d.a.q0.f.i.k.f.e;
import d.a.q0.f.i.r.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class c implements d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f52661a;

    /* renamed from: b  reason: collision with root package name */
    public final e f52662b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f52663c;

    /* renamed from: d  reason: collision with root package name */
    public final a f52664d;

    /* renamed from: e  reason: collision with root package name */
    public long f52665e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f52666f;

    /* loaded from: classes8.dex */
    public interface a {
        void e(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, e eVar, DownloadInfo downloadInfo, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService, eVar, downloadInfo, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52665e = System.currentTimeMillis();
        this.f52666f = new AtomicBoolean(false);
        this.f52661a = executorService;
        this.f52662b = eVar;
        this.f52663c = downloadInfo;
        this.f52664d = aVar;
    }

    @Override // d.a.q0.f.i.k.d.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f52663c.getProgress() == this.f52663c.getSize()) {
            this.f52663c.setPackageName(g.d(AppRuntime.getAppContext(), this.f52663c.getPath()));
            this.f52663c.setStatus(DownloadState.DOWNLOADED.value());
            this.f52662b.b(this.f52663c);
            a aVar = this.f52664d;
            if (aVar != null) {
                aVar.e(this.f52663c);
            }
        }
    }

    @Override // d.a.q0.f.i.k.d.d.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f52666f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f52666f.get()) {
                this.f52666f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f52665e > 1000) {
                    this.f52662b.b(this.f52663c);
                    this.f52665e = currentTimeMillis;
                }
                this.f52666f.set(false);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f52661a.submit(new d(this.f52662b, this.f52663c, this));
        }
    }
}
