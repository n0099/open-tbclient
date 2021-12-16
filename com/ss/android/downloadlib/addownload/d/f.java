package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static f a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public List<d> f61872b;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.f61872b = arrayList;
        arrayList.add(new e());
        this.f61872b.add(new g());
        this.f61872b.add(new b());
        this.f61872b.add(new a());
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (f.class) {
                    if (a == null) {
                        a = new f();
                    }
                }
            }
            return a;
        }
        return (f) invokeV.objValue;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar, int i2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, cVar) == null) {
            List<d> list = this.f61872b;
            if (list != null && list.size() != 0 && bVar != null) {
                DownloadInfo a2 = com.ss.android.downloadlib.g.a((Context) null).a(bVar.a());
                if (a2 != null && "application/vnd.android.package-archive".equals(a2.getMimeType())) {
                    boolean z = com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("pause_optimise_switch", 0) == 1;
                    for (d dVar : this.f61872b) {
                        if (z || (dVar instanceof g)) {
                            if (dVar.a(bVar, i2, cVar)) {
                                return;
                            }
                        }
                    }
                    cVar.a(bVar);
                    return;
                }
                cVar.a(bVar);
                return;
            }
            cVar.a(bVar);
        }
    }
}
