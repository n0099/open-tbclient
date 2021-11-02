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
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<a> f67026a;

    /* renamed from: b  reason: collision with root package name */
    public final e.b f67027b;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f67028a;

        /* renamed from: b  reason: collision with root package name */
        public final List<Integer> f67029b;

        /* renamed from: c  reason: collision with root package name */
        public final Executor f67030c;

        public a(g gVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67028a = gVar;
            this.f67029b = new ArrayList();
            this.f67030c = com.kwai.filedownloader.f.b.a(1, "Flow-" + i2);
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f67029b.add(Integer.valueOf(i2));
            }
        }

        public void a(MessageSnapshot messageSnapshot) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messageSnapshot) == null) {
                this.f67030c.execute(new Runnable(this, messageSnapshot) { // from class: com.kwai.filedownloader.message.g.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ MessageSnapshot f67031a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f67032b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, messageSnapshot};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67032b = this;
                        this.f67031a = messageSnapshot;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f67032b.f67028a.f67027b.a(this.f67031a);
                            try {
                                this.f67032b.f67029b.remove(Integer.valueOf(this.f67031a.m()));
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    public g(int i2, e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67027b = bVar;
        this.f67026a = new ArrayList();
        for (int i5 = 0; i5 < i2; i5++) {
            this.f67026a.add(new a(this, i5));
        }
    }

    public void a(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, messageSnapshot) == null) {
            a aVar = null;
            try {
                synchronized (this.f67026a) {
                    int m = messageSnapshot.m();
                    Iterator<a> it = this.f67026a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a next = it.next();
                        if (next.f67029b.contains(Integer.valueOf(m))) {
                            aVar = next;
                            break;
                        }
                    }
                    if (aVar == null) {
                        int i2 = 0;
                        Iterator<a> it2 = this.f67026a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            a next2 = it2.next();
                            if (next2.f67029b.size() <= 0) {
                                aVar = next2;
                                break;
                            } else if (i2 == 0 || next2.f67029b.size() < i2) {
                                i2 = next2.f67029b.size();
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
