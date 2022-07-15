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
/* loaded from: classes5.dex */
public final class z extends e implements v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<a.InterfaceC0555a> a;

    public z() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
    }

    @Override // com.kwai.filedownloader.e
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            w d = r.a().d();
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "The downloader service is connected.", new Object[0]);
            }
            synchronized (this.a) {
                this.a.clear();
                ArrayList arrayList = new ArrayList(d.b());
                for (a.InterfaceC0555a interfaceC0555a : (List) this.a.clone()) {
                    int I = interfaceC0555a.I();
                    if (d.a(I)) {
                        interfaceC0555a.F().a().a();
                        if (!arrayList.contains(Integer.valueOf(I))) {
                            arrayList.add(Integer.valueOf(I));
                        }
                    } else {
                        interfaceC0555a.N();
                    }
                }
                d.a(arrayList);
            }
        }
    }

    @Override // com.kwai.filedownloader.v
    public final boolean a(a.InterfaceC0555a interfaceC0555a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0555a)) == null) ? !this.a.isEmpty() && this.a.contains(interfaceC0555a) : invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.e
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c() != DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
                if (h.a().b() > 0) {
                    com.kwai.filedownloader.e.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.a().b()));
                    return;
                }
                return;
            }
            w d = r.a().d();
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.a().b()));
            }
            if (h.a().b() > 0) {
                synchronized (this.a) {
                    h.a().a(this.a);
                    Iterator<a.InterfaceC0555a> it = this.a.iterator();
                    while (it.hasNext()) {
                        it.next().M();
                    }
                    d.a();
                }
                r.a().b();
            }
        }
    }

    @Override // com.kwai.filedownloader.v
    public final void b(a.InterfaceC0555a interfaceC0555a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, interfaceC0555a) == null) || this.a.isEmpty()) {
            return;
        }
        synchronized (this.a) {
            this.a.remove(interfaceC0555a);
        }
    }

    @Override // com.kwai.filedownloader.v
    public final boolean c(a.InterfaceC0555a interfaceC0555a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, interfaceC0555a)) == null) {
            r.a();
            if (!r.c()) {
                synchronized (this.a) {
                    r.a();
                    if (!r.c()) {
                        if (com.kwai.filedownloader.e.d.a) {
                            com.kwai.filedownloader.e.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC0555a.F().h()));
                        }
                        n.a().a(com.kwai.filedownloader.e.c.a());
                        if (!this.a.contains(interfaceC0555a)) {
                            interfaceC0555a.M();
                            this.a.add(interfaceC0555a);
                        }
                        return true;
                    }
                }
            }
            b(interfaceC0555a);
            return false;
        }
        return invokeL.booleanValue;
    }
}
