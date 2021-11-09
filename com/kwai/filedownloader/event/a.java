package com.kwai.filedownloader.event;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.f.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f66961a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, LinkedList<c>> f66962b;

    public a() {
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
        this.f66961a = com.kwai.filedownloader.f.b.a(10, "EventPool");
        this.f66962b = new HashMap<>();
    }

    private void a(LinkedList<c> linkedList, b bVar) {
        Object[] array;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, linkedList, bVar) == null) {
            for (Object obj : linkedList.toArray()) {
                if (obj != null && ((c) obj).a(bVar)) {
                    break;
                }
            }
            Runnable runnable = bVar.f66965a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public boolean a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (d.f66973a) {
                d.e(this, "publish %s", bVar.b());
            }
            if (bVar != null) {
                String b2 = bVar.b();
                LinkedList<c> linkedList = this.f66962b.get(b2);
                if (linkedList == null) {
                    synchronized (b2.intern()) {
                        linkedList = this.f66962b.get(b2);
                        if (linkedList == null) {
                            if (d.f66973a) {
                                d.c(this, "No listener for this event %s", b2);
                            }
                            return false;
                        }
                    }
                }
                a(linkedList, bVar);
                return true;
            }
            throw new IllegalArgumentException("event must not be null!");
        }
        return invokeL.booleanValue;
    }

    public boolean a(String str, c cVar) {
        InterceptResult invokeLL;
        boolean add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar)) == null) {
            if (d.f66973a) {
                d.e(this, "setListener %s", str);
            }
            if (cVar != null) {
                LinkedList<c> linkedList = this.f66962b.get(str);
                if (linkedList == null) {
                    synchronized (str.intern()) {
                        linkedList = this.f66962b.get(str);
                        if (linkedList == null) {
                            HashMap<String, LinkedList<c>> hashMap = this.f66962b;
                            LinkedList<c> linkedList2 = new LinkedList<>();
                            hashMap.put(str, linkedList2);
                            linkedList = linkedList2;
                        }
                    }
                }
                synchronized (str.intern()) {
                    add = linkedList.add(cVar);
                }
                return add;
            }
            throw new IllegalArgumentException("listener must not be null!");
        }
        return invokeLL.booleanValue;
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            if (d.f66973a) {
                d.e(this, "asyncPublishInNewThread %s", bVar.b());
            }
            if (bVar == null) {
                throw new IllegalArgumentException("event must not be null!");
            }
            this.f66961a.execute(new Runnable(this, bVar) { // from class: com.kwai.filedownloader.event.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f66963a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f66964b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66964b = this;
                    this.f66963a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f66964b.a(this.f66963a);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }
}
