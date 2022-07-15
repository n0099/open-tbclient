package com.kwai.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 10;
    public static int b = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor c;
    public final Handler d;
    public final LinkedBlockingQueue<t> e;
    public final Object f;
    public final ArrayList<t> g;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final j a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1185542351, "Lcom/kwai/filedownloader/j$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1185542351, "Lcom/kwai/filedownloader/j$a;");
                    return;
                }
            }
            a = new j((byte) 0);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        public static void a(ArrayList<t> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, arrayList) == null) {
                Iterator<t> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().b();
                }
                arrayList.clear();
            }
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i == 1) {
                    ((t) message.obj).b();
                } else if (i == 2) {
                    a((ArrayList) message.obj);
                    j.a().b();
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-224697074, "Lcom/kwai/filedownloader/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-224697074, "Lcom/kwai/filedownloader/j;");
        }
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = com.kwai.filedownloader.e.b.a(5, "BlockCompleted");
        this.f = new Object();
        this.g = new ArrayList<>();
        this.d = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.e = new LinkedBlockingQueue<>();
    }

    public /* synthetic */ j(byte b2) {
        this();
    }

    public static j a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.a : (j) invokeV.objValue;
    }

    private void a(t tVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, this, tVar, z) == null) {
            if (tVar.c()) {
                tVar.b();
            } else if (tVar.d()) {
                this.c.execute(new Runnable(this, tVar) { // from class: com.kwai.filedownloader.j.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ t a;
                    public final /* synthetic */ j b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, tVar};
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
                        this.a = tVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.b();
                        }
                    }
                });
            } else {
                if (!c() && !this.e.isEmpty()) {
                    synchronized (this.f) {
                        if (!this.e.isEmpty()) {
                            Iterator<t> it = this.e.iterator();
                            while (it.hasNext()) {
                                b(it.next());
                            }
                        }
                        this.e.clear();
                    }
                }
                if (c()) {
                    c(tVar);
                } else {
                    b(tVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            synchronized (this.f) {
                if (this.g.isEmpty()) {
                    if (this.e.isEmpty()) {
                        return;
                    }
                    int i = 0;
                    if (c()) {
                        int i2 = a;
                        int min = Math.min(this.e.size(), b);
                        while (i < min) {
                            this.g.add(this.e.remove());
                            i++;
                        }
                        i = i2;
                    } else {
                        this.e.drainTo(this.g);
                    }
                    Handler handler = this.d;
                    handler.sendMessageDelayed(handler.obtainMessage(2, this.g), i);
                }
            }
        }
    }

    private void b(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, tVar) == null) {
            Handler handler = this.d;
            handler.sendMessage(handler.obtainMessage(1, tVar));
        }
    }

    private void c(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, tVar) == null) {
            synchronized (this.f) {
                this.e.offer(tVar);
            }
            b();
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a > 0 : invokeV.booleanValue;
    }

    public final void a(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tVar) == null) {
            a(tVar, false);
        }
    }
}
