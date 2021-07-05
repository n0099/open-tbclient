package d.a.q0.f.i.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.f.i.l.g;
import d.a.q0.f.i.q.d;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class b implements d.a.q0.f.i.k.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f52636a;

    /* renamed from: b  reason: collision with root package name */
    public String f52637b;

    /* renamed from: c  reason: collision with root package name */
    public AdElementInfo f52638c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadState f52639d;

    /* renamed from: e  reason: collision with root package name */
    public g f52640e;

    /* renamed from: f  reason: collision with root package name */
    public C1097b f52641f;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public b(Context context, AdElementInfo adElementInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adElementInfo, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52639d = DownloadState.NOT_START;
        this.f52636a = context;
        this.f52638c = adElementInfo;
        this.f52640e = gVar;
    }

    @Override // d.a.q0.f.i.k.f.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    @Override // d.a.q0.f.i.k.f.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h();
        }
    }

    @Override // d.a.q0.f.i.k.f.a
    public void c(DownloadState downloadState, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) || this.f52639d == downloadState) {
            return;
        }
        if (downloadState == DownloadState.DOWNLOADED) {
            j("2");
            h();
        }
        this.f52639d = downloadState;
    }

    @Override // d.a.q0.f.i.k.f.a
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // d.a.q0.f.i.k.f.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.q0.f.i.k.f.a
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f52641f == null) {
            this.f52641f = new C1097b(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
            this.f52636a.registerReceiver(this.f52641f, intentFilter);
        }
    }

    public void i() {
        C1097b c1097b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (c1097b = this.f52641f) == null) {
            return;
        }
        this.f52636a.unregisterReceiver(c1097b);
        this.f52641f = null;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            d.a.q0.f.i.q.a aVar = new d.a.q0.f.i.q.a();
            aVar.s = this.f52637b;
            aVar.r = str;
            d.e(aVar, this.f52638c, this.f52640e);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f52637b = str;
            j("1");
        }
    }

    /* renamed from: d.a.q0.f.i.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1097b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b this$0;
        public long time;

        public C1097b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bVar;
            this.time = 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null || intent.getData() == null || !PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction())) {
                return;
            }
            if (!TextUtils.equals(this.this$0.f52638c.getPackageName(), intent.getData().getSchemeSpecificPart()) || System.currentTimeMillis() - this.time < TimeUnit.SECONDS.toMillis(10L)) {
                return;
            }
            this.time = System.currentTimeMillis();
            this.this$0.j("3");
        }

        public /* synthetic */ C1097b(b bVar, a aVar) {
            this(bVar);
        }
    }
}
