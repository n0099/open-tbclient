package com.kwai.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes10.dex */
public class j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f74081a = 10;

    /* renamed from: b  reason: collision with root package name */
    public static int f74082b = 5;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f74083c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f74084d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedBlockingQueue<s> f74085e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f74086f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<s> f74087g;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final j f74090a;
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
            f74090a = new j();
        }
    }

    /* loaded from: classes10.dex */
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

        private void a(ArrayList<s> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, arrayList) == null) {
                Iterator<s> it = arrayList.iterator();
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
                    ((s) message.obj).b();
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
        this.f74083c = com.kwai.filedownloader.f.b.a(5, "BlockCompleted");
        this.f74086f = new Object();
        this.f74087g = new ArrayList<>();
        this.f74084d = new Handler(Looper.getMainLooper(), new b());
        this.f74085e = new LinkedBlockingQueue<>();
    }

    public static j a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f74090a : (j) invokeV.objValue;
    }

    private void b(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, sVar) == null) {
            Handler handler = this.f74084d;
            handler.sendMessage(handler.obtainMessage(1, sVar));
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f74081a > 0 : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            synchronized (this.f74086f) {
                if (this.f74087g.isEmpty()) {
                    if (this.f74085e.isEmpty()) {
                        return;
                    }
                    int i2 = 0;
                    if (b()) {
                        int i3 = f74081a;
                        int min = Math.min(this.f74085e.size(), f74082b);
                        while (i2 < min) {
                            this.f74087g.add(this.f74085e.remove());
                            i2++;
                        }
                        i2 = i3;
                    } else {
                        this.f74085e.drainTo(this.f74087g);
                    }
                    Handler handler = this.f74084d;
                    handler.sendMessageDelayed(handler.obtainMessage(2, this.f74087g), i2);
                }
            }
        }
    }

    private void c(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, sVar) == null) {
            synchronized (this.f74086f) {
                this.f74085e.offer(sVar);
            }
            c();
        }
    }

    public void a(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sVar) == null) {
            a(sVar, false);
        }
    }

    public void a(s sVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar, z) == null) {
            if (sVar.c()) {
                sVar.b();
            } else if (sVar.d()) {
                this.f74083c.execute(new Runnable(this, sVar) { // from class: com.kwai.filedownloader.j.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ s f74088a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ j f74089b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f74089b = this;
                        this.f74088a = sVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f74088a.b();
                        }
                    }
                });
            } else {
                if (!b() && !this.f74085e.isEmpty()) {
                    synchronized (this.f74086f) {
                        if (!this.f74085e.isEmpty()) {
                            Iterator<s> it = this.f74085e.iterator();
                            while (it.hasNext()) {
                                b(it.next());
                            }
                        }
                        this.f74085e.clear();
                    }
                }
                if (!b() || z) {
                    b(sVar);
                } else {
                    c(sVar);
                }
            }
        }
    }
}
