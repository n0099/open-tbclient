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
/* loaded from: classes5.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<a> a;
    public final e.b b;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;
        public final List<Integer> b;
        public final Executor c;

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
            this.a = gVar;
            this.b = new ArrayList();
            this.c = com.kwai.filedownloader.e.b.a(1, "Flow-" + i);
        }

        public final void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.b.add(Integer.valueOf(i));
            }
        }

        public final void a(MessageSnapshot messageSnapshot) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messageSnapshot) == null) {
                this.c.execute(new Runnable(this, messageSnapshot) { // from class: com.kwai.filedownloader.message.g.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MessageSnapshot a;
                    public final /* synthetic */ a b;

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
                        this.b = this;
                        this.a = messageSnapshot;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.b.a.b.a(this.a);
                            try {
                                this.b.b.remove(Integer.valueOf(this.a.m()));
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
        this.b = bVar;
        this.a = new ArrayList();
        for (int i4 = 0; i4 < 5; i4++) {
            this.a.add(new a(this, i4));
        }
    }

    public final void a(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, messageSnapshot) == null) {
            a aVar = null;
            try {
                synchronized (this.a) {
                    int m = messageSnapshot.m();
                    Iterator<a> it = this.a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a next = it.next();
                        if (next.b.contains(Integer.valueOf(m))) {
                            aVar = next;
                            break;
                        }
                    }
                    if (aVar == null) {
                        int i = 0;
                        Iterator<a> it2 = this.a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            a next2 = it2.next();
                            if (next2.b.size() <= 0) {
                                aVar = next2;
                                break;
                            } else if (i == 0 || next2.b.size() < i) {
                                i = next2.b.size();
                                aVar = next2;
                            }
                        }
                    }
                    aVar.a(m);
                }
            } finally {
                aVar.a(messageSnapshot);
            }
        }
    }
}
