package com.ss.android.downloadlib.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.c.i;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements j {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public List<j> f61984b;

    public c() {
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
        this.f61984b = arrayList;
        arrayList.add(new b());
        this.f61984b.add(new a());
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (c.class) {
                    if (a == null) {
                        a = new c();
                    }
                }
            }
            return a;
        }
        return (c) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.j
    public void a(DownloadInfo downloadInfo, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, downloadInfo, iVar) == null) {
            if (downloadInfo != null && this.f61984b.size() != 0) {
                a(downloadInfo, 0, iVar);
            } else if (iVar != null) {
                iVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadInfo downloadInfo, int i2, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65539, this, downloadInfo, i2, iVar) == null) {
            if (i2 != this.f61984b.size() && i2 >= 0) {
                this.f61984b.get(i2).a(downloadInfo, new i(this, i2, downloadInfo, iVar) { // from class: com.ss.android.downloadlib.f.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f61985b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ i f61986c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ c f61987d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2), downloadInfo, iVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61987d = this;
                        this.a = i2;
                        this.f61985b = downloadInfo;
                        this.f61986c = iVar;
                    }

                    @Override // com.ss.android.socialbase.appdownloader.c.i
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f61987d.a(this.f61985b, this.a + 1, this.f61986c);
                        }
                    }
                });
            } else {
                iVar.a();
            }
        }
    }
}
