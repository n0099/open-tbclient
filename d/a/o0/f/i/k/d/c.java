package d.a.o0.f.i.k.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.f.i.k.d.d;
import d.a.o0.f.i.k.f.e;
import d.a.o0.f.i.r.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class c implements d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f49863a;

    /* renamed from: b  reason: collision with root package name */
    public final e f49864b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f49865c;

    /* renamed from: d  reason: collision with root package name */
    public final a f49866d;

    /* renamed from: e  reason: collision with root package name */
    public long f49867e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f49868f;

    /* loaded from: classes7.dex */
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
        this.f49867e = System.currentTimeMillis();
        this.f49868f = new AtomicBoolean(false);
        this.f49863a = executorService;
        this.f49864b = eVar;
        this.f49865c = downloadInfo;
        this.f49866d = aVar;
    }

    @Override // d.a.o0.f.i.k.d.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f49865c.getProgress() == this.f49865c.getSize()) {
            this.f49865c.setPackageName(g.d(AppRuntime.getAppContext(), this.f49865c.getPath()));
            this.f49865c.setStatus(DownloadState.DOWNLOADED.value());
            this.f49864b.b(this.f49865c);
            a aVar = this.f49866d;
            if (aVar != null) {
                aVar.e(this.f49865c);
            }
        }
    }

    @Override // d.a.o0.f.i.k.d.d.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f49868f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f49868f.get()) {
                this.f49868f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f49867e > 1000) {
                    this.f49864b.b(this.f49865c);
                    this.f49867e = currentTimeMillis;
                }
                this.f49868f.set(false);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f49863a.submit(new d(this.f49864b, this.f49865c, this));
        }
    }
}
