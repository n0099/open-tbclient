package com.kwai.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 10;

    /* renamed from: b  reason: collision with root package name */
    public static int f60585b = 5;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f60586c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f60587d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedBlockingQueue<t> f60588e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f60589f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<t> f60590g;

    /* loaded from: classes3.dex */
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
            a = new j();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        private void a(ArrayList<t> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, arrayList) == null) {
                Iterator<t> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().b();
                }
                arrayList.clear();
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 1) {
                    ((t) message.obj).b();
                } else if (i2 == 2) {
                    a((ArrayList) message.obj);
                    j.a().c();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60586c = com.kwai.filedownloader.e.b.a(5, "BlockCompleted");
        this.f60589f = new Object();
        this.f60590g = new ArrayList<>();
        this.f60587d = new Handler(Looper.getMainLooper(), new b());
        this.f60588e = new LinkedBlockingQueue<>();
    }

    public static j a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.a : (j) invokeV.objValue;
    }

    private void b(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, tVar) == null) {
            Handler handler = this.f60587d;
            handler.sendMessage(handler.obtainMessage(1, tVar));
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? a > 0 : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            synchronized (this.f60589f) {
                if (this.f60590g.isEmpty()) {
                    if (this.f60588e.isEmpty()) {
                        return;
                    }
                    int i2 = 0;
                    if (b()) {
                        int i3 = a;
                        int min = Math.min(this.f60588e.size(), f60585b);
                        while (i2 < min) {
                            this.f60590g.add(this.f60588e.remove());
                            i2++;
                        }
                        i2 = i3;
                    } else {
                        this.f60588e.drainTo(this.f60590g);
                    }
                    Handler handler = this.f60587d;
                    handler.sendMessageDelayed(handler.obtainMessage(2, this.f60590g), i2);
                }
            }
        }
    }

    private void c(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, tVar) == null) {
            synchronized (this.f60589f) {
                this.f60588e.offer(tVar);
            }
            c();
        }
    }

    public void a(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tVar) == null) {
            a(tVar, false);
        }
    }

    public void a(t tVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tVar, z) == null) {
            if (tVar.c()) {
                tVar.b();
            } else if (tVar.d()) {
                this.f60586c.execute(new Runnable(this, tVar) { // from class: com.kwai.filedownloader.j.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ t a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ j f60591b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, tVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60591b = this;
                        this.a = tVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.b();
                        }
                    }
                });
            } else {
                if (!b() && !this.f60588e.isEmpty()) {
                    synchronized (this.f60589f) {
                        if (!this.f60588e.isEmpty()) {
                            Iterator<t> it = this.f60588e.iterator();
                            while (it.hasNext()) {
                                b(it.next());
                            }
                        }
                        this.f60588e.clear();
                    }
                }
                if (!b() || z) {
                    b(tVar);
                } else {
                    c(tVar);
                }
            }
        }
    }
}
