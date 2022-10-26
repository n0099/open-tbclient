package com.kwai.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes8.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic = null;
    public static int atj = 10;
    public static int atk = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor atf;
    public final LinkedBlockingQueue atg;
    public final Object ath;
    public final ArrayList ati;
    public final Handler handler;

    /* loaded from: classes8.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final j atn;
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
            atn = new j((byte) 0);
        }
    }

    /* loaded from: classes8.dex */
    public final class b implements Handler.Callback {
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

        public static void b(ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, arrayList) == null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((t) it.next()).CM();
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
                    ((t) message.obj).CM();
                } else if (i == 2) {
                    b((ArrayList) message.obj);
                    j.CI().push();
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
        this.atf = com.kwai.filedownloader.e.b.l(5, "BlockCompleted");
        this.ath = new Object();
        this.ati = new ArrayList();
        this.handler = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.atg = new LinkedBlockingQueue();
    }

    public /* synthetic */ j(byte b2) {
        this();
    }

    public static j CI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.atn : (j) invokeV.objValue;
    }

    public static boolean CJ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? atj > 0 : invokeV.booleanValue;
    }

    private void a(t tVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65542, this, tVar, z) == null) {
            if (tVar.CN()) {
                tVar.CM();
            } else if (tVar.CO()) {
                this.atf.execute(new Runnable(this, tVar) { // from class: com.kwai.filedownloader.j.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ t atl;
                    public final /* synthetic */ j atm;

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
                        this.atm = this;
                        this.atl = tVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.atl.CM();
                        }
                    }
                });
            } else {
                if (!CJ() && !this.atg.isEmpty()) {
                    synchronized (this.ath) {
                        if (!this.atg.isEmpty()) {
                            Iterator it = this.atg.iterator();
                            while (it.hasNext()) {
                                b((t) it.next());
                            }
                        }
                        this.atg.clear();
                    }
                }
                if (CJ()) {
                    c(tVar);
                } else {
                    b(tVar);
                }
            }
        }
    }

    private void b(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, tVar) == null) {
            Handler handler = this.handler;
            handler.sendMessage(handler.obtainMessage(1, tVar));
        }
    }

    private void c(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, tVar) == null) {
            synchronized (this.ath) {
                this.atg.offer(tVar);
            }
            push();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void push() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            synchronized (this.ath) {
                if (this.ati.isEmpty()) {
                    if (this.atg.isEmpty()) {
                        return;
                    }
                    int i = 0;
                    if (CJ()) {
                        int i2 = atj;
                        int min = Math.min(this.atg.size(), atk);
                        while (i < min) {
                            this.ati.add(this.atg.remove());
                            i++;
                        }
                        i = i2;
                    } else {
                        this.atg.drainTo(this.ati);
                    }
                    Handler handler = this.handler;
                    handler.sendMessageDelayed(handler.obtainMessage(2, this.ati), i);
                }
            }
        }
    }

    public final void a(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tVar) == null) {
            a(tVar, false);
        }
    }
}
