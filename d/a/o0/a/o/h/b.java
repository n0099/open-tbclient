package d.a.o0.a.o.h;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v1.a.b.c.c;
/* loaded from: classes7.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.f.i.k.f.a f47030c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadParams.SwanAppDownloadType f47031d;

    public b(d.a.o0.f.i.k.f.a aVar, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, swanAppDownloadType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47030c = aVar;
        this.f47031d = swanAppDownloadType;
    }

    @Override // d.a.o0.a.v1.a.b.c.a
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // d.a.o0.a.v1.a.b.c.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.a.v1.a.b.c.c, d.a.o0.a.v1.a.b.c.a
    public void onEvent(@NonNull d.a.o0.a.v1.a.b.a.b bVar) {
        Bundle a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (a2 = bVar.a()) == null || this.f47030c == null) {
            return;
        }
        int i2 = a2.getInt("state", DownloadState.NOT_START.value());
        int i3 = a2.getInt("progress", 0);
        this.f47030c.c(DownloadState.convert(i2), i3);
        this.f47030c.a(i3);
        String string = a2.getString("packageName", "");
        if (!TextUtils.isEmpty(string)) {
            this.f47030c.d(string);
        }
        if (this.f47031d == DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD) {
            this.f47030c.f(true);
        }
    }
}
