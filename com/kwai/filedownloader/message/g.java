package com.kwai.filedownloader.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e.b avU;
    public final List<a> avW;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<Integer> avX;
        public final Executor avY;
        public final /* synthetic */ g avZ;

        public a(g gVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.avZ = gVar;
            this.avX = new ArrayList();
            this.avY = com.kwai.filedownloader.e.b.l(1, "Flow-" + i);
        }

        public final void cu(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.avX.add(Integer.valueOf(i));
            }
        }

        public final void u(MessageSnapshot messageSnapshot) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messageSnapshot) == null) {
                this.avY.execute(new Runnable(this, messageSnapshot) { // from class: com.kwai.filedownloader.message.g.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MessageSnapshot awa;
                    public final /* synthetic */ a awb;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, messageSnapshot};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.awb = this;
                        this.awa = messageSnapshot;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.awb.avZ.avU.r(this.awa);
                            try {
                                this.awb.avX.remove(Integer.valueOf(this.awa.getId()));
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    public g(int i, e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.avU = bVar;
        this.avW = new ArrayList();
        for (int i4 = 0; i4 < 5; i4++) {
            this.avW.add(new a(this, i4));
        }
    }

    public final void u(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, messageSnapshot) == null) {
            a aVar = null;
            try {
                synchronized (this.avW) {
                    int id = messageSnapshot.getId();
                    Iterator<a> it = this.avW.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a next = it.next();
                        if (next.avX.contains(Integer.valueOf(id))) {
                            aVar = next;
                            break;
                        }
                    }
                    if (aVar == null) {
                        int i = 0;
                        Iterator<a> it2 = this.avW.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            a next2 = it2.next();
                            if (next2.avX.size() <= 0) {
                                aVar = next2;
                                break;
                            } else if (i == 0 || next2.avX.size() < i) {
                                i = next2.avX.size();
                                aVar = next2;
                            }
                        }
                    }
                    if (aVar != null) {
                        aVar.cu(id);
                    }
                }
            } finally {
                if (aVar != null) {
                    aVar.u(messageSnapshot);
                }
            }
        }
    }
}
