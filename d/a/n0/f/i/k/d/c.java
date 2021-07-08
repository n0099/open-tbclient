package d.a.n0.f.i.k.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.f.i.k.d.d;
import d.a.n0.f.i.k.f.e;
import d.a.n0.f.i.r.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class c implements d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f49359a;

    /* renamed from: b  reason: collision with root package name */
    public final e f49360b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f49361c;

    /* renamed from: d  reason: collision with root package name */
    public final a f49362d;

    /* renamed from: e  reason: collision with root package name */
    public long f49363e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f49364f;

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
        this.f49363e = System.currentTimeMillis();
        this.f49364f = new AtomicBoolean(false);
        this.f49359a = executorService;
        this.f49360b = eVar;
        this.f49361c = downloadInfo;
        this.f49362d = aVar;
    }

    @Override // d.a.n0.f.i.k.d.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f49361c.getProgress() == this.f49361c.getSize()) {
            this.f49361c.setPackageName(g.d(AppRuntime.getAppContext(), this.f49361c.getPath()));
            this.f49361c.setStatus(DownloadState.DOWNLOADED.value());
            this.f49360b.b(this.f49361c);
            a aVar = this.f49362d;
            if (aVar != null) {
                aVar.e(this.f49361c);
            }
        }
    }

    @Override // d.a.n0.f.i.k.d.d.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f49364f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f49364f.get()) {
                this.f49364f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f49363e > 1000) {
                    this.f49360b.b(this.f49361c);
                    this.f49363e = currentTimeMillis;
                }
                this.f49364f.set(false);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f49359a.submit(new d(this.f49360b, this.f49361c, this));
        }
    }
}
