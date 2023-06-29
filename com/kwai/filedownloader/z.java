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
public final class z extends e implements v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<a.InterfaceC0692a> atJ;

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
        this.atJ = new ArrayList<>();
    }

    @Override // com.kwai.filedownloader.e
    public final void CB() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            w Dc = r.CZ().Dc();
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "The downloader service is connected.", new Object[0]);
            }
            synchronized (this.atJ) {
                this.atJ.clear();
                ArrayList arrayList = new ArrayList(Dc.Dg());
                for (a.InterfaceC0692a interfaceC0692a : (List) this.atJ.clone()) {
                    int Ck = interfaceC0692a.Ck();
                    if (Dc.ca(Ck)) {
                        interfaceC0692a.Ci().BR().Cq();
                        if (!arrayList.contains(Integer.valueOf(Ck))) {
                            arrayList.add(Integer.valueOf(Ck));
                        }
                    } else {
                        interfaceC0692a.Co();
                    }
                }
                Dc.E(arrayList);
            }
        }
    }

    @Override // com.kwai.filedownloader.e
    public final void CC() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (CD() != DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
                if (h.CG().size() > 0) {
                    com.kwai.filedownloader.e.d.f(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.CG().size()));
                    return;
                }
                return;
            }
            w Dc = r.CZ().Dc();
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.CG().size()));
            }
            if (h.CG().size() > 0) {
                synchronized (this.atJ) {
                    h.CG().D(this.atJ);
                    Iterator<a.InterfaceC0692a> it = this.atJ.iterator();
                    while (it.hasNext()) {
                        it.next().free();
                    }
                    Dc.Df();
                }
                r.CZ().Da();
            }
        }
    }

    @Override // com.kwai.filedownloader.v
    public final boolean d(a.InterfaceC0692a interfaceC0692a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0692a)) == null) ? !this.atJ.isEmpty() && this.atJ.contains(interfaceC0692a) : invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.v
    public final void e(a.InterfaceC0692a interfaceC0692a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, interfaceC0692a) == null) || this.atJ.isEmpty()) {
            return;
        }
        synchronized (this.atJ) {
            this.atJ.remove(interfaceC0692a);
        }
    }

    @Override // com.kwai.filedownloader.v
    public final boolean f(a.InterfaceC0692a interfaceC0692a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, interfaceC0692a)) == null) {
            r.CZ();
            if (!r.Db()) {
                synchronized (this.atJ) {
                    r.CZ();
                    if (!r.Db()) {
                        if (com.kwai.filedownloader.e.d.awL) {
                            com.kwai.filedownloader.e.d.e(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC0692a.Ci().getId()));
                        }
                        n.CR().dC(com.kwai.filedownloader.e.c.EJ());
                        if (!this.atJ.contains(interfaceC0692a)) {
                            interfaceC0692a.free();
                            this.atJ.add(interfaceC0692a);
                        }
                        return true;
                    }
                }
            }
            e(interfaceC0692a);
            return false;
        }
        return invokeL.booleanValue;
    }
}
