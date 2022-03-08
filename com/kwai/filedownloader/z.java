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
/* loaded from: classes8.dex */
public class z extends e implements v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<a.b> a;

    public z() {
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
        this.a = new ArrayList<>();
    }

    @Override // com.kwai.filedownloader.e
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            w d2 = r.a().d();
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "The downloader service is connected.", new Object[0]);
            }
            synchronized (this.a) {
                this.a.clear();
                ArrayList arrayList = new ArrayList(d2.b());
                for (a.b bVar : (List) this.a.clone()) {
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

    @Override // com.kwai.filedownloader.v
    public boolean a(a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) ? !this.a.isEmpty() && this.a.contains(bVar) : invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.e
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c() != DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
                if (h.a().b() > 0) {
                    com.kwai.filedownloader.e.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.a().b()));
                    return;
                }
                return;
            }
            w d2 = r.a().d();
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.a().b()));
            }
            if (h.a().b() > 0) {
                synchronized (this.a) {
                    h.a().a(this.a);
                    Iterator<a.b> it = this.a.iterator();
                    while (it.hasNext()) {
                        it.next().M();
                    }
                    d2.a();
                }
                r.a().b();
            }
        }
    }

    @Override // com.kwai.filedownloader.v
    public void b(a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || this.a.isEmpty()) {
            return;
        }
        synchronized (this.a) {
            this.a.remove(bVar);
        }
    }

    @Override // com.kwai.filedownloader.v
    public boolean c(a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            if (!r.a().c()) {
                synchronized (this.a) {
                    if (!r.a().c()) {
                        if (com.kwai.filedownloader.e.d.a) {
                            com.kwai.filedownloader.e.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(bVar.F().h()));
                        }
                        n.a().a(com.kwai.filedownloader.e.c.a());
                        if (!this.a.contains(bVar)) {
                            bVar.M();
                            this.a.add(bVar);
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
