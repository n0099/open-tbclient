package com.kwai.filedownloader;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class y extends e implements u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<a.b> f74673a;

    public y() {
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
        this.f74673a = new ArrayList<>();
    }

    @Override // com.kwai.filedownloader.e
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            v d2 = q.a().d();
            if (com.kwai.filedownloader.f.d.f74563a) {
                com.kwai.filedownloader.f.d.c(this, "The downloader service is connected.", new Object[0]);
            }
            synchronized (this.f74673a) {
                this.f74673a.clear();
                ArrayList arrayList = new ArrayList(d2.b());
                for (a.b bVar : (List) this.f74673a.clone()) {
                    int I = bVar.I();
                    if (d2.a(I)) {
                        bVar.F().a().a();
                        if (!arrayList.contains(Integer.valueOf(I))) {
                            arrayList.add(Integer.valueOf(I));
                        }
                    } else {
                        bVar.N();
                    }
                }
                d2.a(arrayList);
            }
        }
    }

    @Override // com.kwai.filedownloader.u
    public boolean a(a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) ? !this.f74673a.isEmpty() && this.f74673a.contains(bVar) : invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.e
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c() != DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
                if (h.a().b() > 0) {
                    com.kwai.filedownloader.f.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.a().b()));
                    return;
                }
                return;
            }
            v d2 = q.a().d();
            if (com.kwai.filedownloader.f.d.f74563a) {
                com.kwai.filedownloader.f.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.a().b()));
            }
            if (h.a().b() > 0) {
                synchronized (this.f74673a) {
                    h.a().a(this.f74673a);
                    Iterator<a.b> it = this.f74673a.iterator();
                    while (it.hasNext()) {
                        it.next().M();
                    }
                    d2.a();
                }
                q.a().b();
            }
        }
    }

    @Override // com.kwai.filedownloader.u
    public void b(a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || this.f74673a.isEmpty()) {
            return;
        }
        synchronized (this.f74673a) {
            this.f74673a.remove(bVar);
        }
    }

    @Override // com.kwai.filedownloader.u
    public boolean c(a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            if (!q.a().c()) {
                synchronized (this.f74673a) {
                    if (!q.a().c()) {
                        if (com.kwai.filedownloader.f.d.f74563a) {
                            com.kwai.filedownloader.f.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(bVar.F().h()));
                        }
                        m.a().a(com.kwai.filedownloader.f.c.a());
                        if (!this.f74673a.contains(bVar)) {
                            bVar.M();
                            this.f74673a.add(bVar);
                        }
                        return true;
                    }
                }
            }
            b(bVar);
            return false;
        }
        return invokeL.booleanValue;
    }
}
