package com.kwai.filedownloader.event;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.e.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor avD;
    public final HashMap<String, LinkedList<c>> avE;

    public a() {
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
        this.avD = com.kwai.filedownloader.e.b.l(10, "EventPool");
        this.avE = new HashMap<>();
    }

    public static void a(LinkedList<c> linkedList, b bVar) {
        Object[] array;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, linkedList, bVar) == null) {
            for (Object obj : linkedList.toArray()) {
                if (obj != null) {
                    ((c) obj).a(bVar);
                }
            }
            Runnable runnable = bVar.avJ;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public final boolean a(String str, c cVar) {
        InterceptResult invokeLL;
        boolean add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, cVar)) == null) {
            if (d.awL) {
                d.g(this, "setListener %s", str);
            }
            if (cVar != null) {
                LinkedList<c> linkedList = this.avE.get(str);
                if (linkedList == null) {
                    synchronized (str.intern()) {
                        linkedList = this.avE.get(str);
                        if (linkedList == null) {
                            HashMap<String, LinkedList<c>> hashMap = this.avE;
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

    public final boolean b(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            if (d.awL) {
                d.g(this, "publish %s", bVar.getId());
            }
            if (bVar != null) {
                String id = bVar.getId();
                LinkedList<c> linkedList = this.avE.get(id);
                if (linkedList == null) {
                    synchronized (id.intern()) {
                        linkedList = this.avE.get(id);
                        if (linkedList == null) {
                            if (d.awL) {
                                d.e(this, "No listener for this event %s", id);
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

    public final void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            if (d.awL) {
                d.g(this, "asyncPublishInNewThread %s", bVar.getId());
            }
            this.avD.execute(new Runnable(this, bVar) { // from class: com.kwai.filedownloader.event.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b avF;
                public final /* synthetic */ a avG;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.avG = this;
                    this.avF = bVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.avG.b(this.avF);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }
}
