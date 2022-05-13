package com.repackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.async.BdRunnable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class ix {
    public static /* synthetic */ Interceptable $ic;
    public static ix e;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService a;
    public Handler b;
    public Handler c;
    public List<hx> d;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ix ixVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ixVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ixVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i == 0) {
                    if (this.a.d != null) {
                        Iterator it = this.a.d.iterator();
                        while (it.hasNext()) {
                            hx hxVar = (hx) it.next();
                            if (this.a.e(hxVar)) {
                                this.a.a.submit(hxVar);
                                it.remove();
                            }
                        }
                    }
                } else if (i == 1) {
                    if (message.obj instanceof hx) {
                        this.a.d.add((hx) message.obj);
                    }
                } else if (i != 2) {
                } else {
                    Object obj = message.obj;
                    if (obj instanceof BdRunnable) {
                        post((BdRunnable) obj);
                    }
                }
            }
        }
    }

    public ix() {
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
        this.d = new ArrayList();
        this.a = Executors.newFixedThreadPool(5);
        Executors.newSingleThreadExecutor();
        this.b = new a(this, gx.a("threadpool").getLooper());
        this.c = new Handler(Looper.getMainLooper());
    }

    public static ix f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (ix.class) {
                    if (e == null) {
                        e = new ix();
                    }
                }
            }
            return e;
        }
        return (ix) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.removeMessages(0);
            this.b.sendEmptyMessage(0);
        }
    }

    public final boolean e(hx hxVar) {
        InterceptResult invokeL;
        List<BdRunnable> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hxVar)) == null) {
            if (hxVar != null && (d = hxVar.d()) != null) {
                for (int i = 0; i < d.size(); i++) {
                    BdRunnable bdRunnable = d.get(i);
                    if (bdRunnable != null && !bdRunnable.c()) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void g(BdRunnable bdRunnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdRunnable) == null) || bdRunnable == null) {
            return;
        }
        if (bdRunnable instanceof hx) {
            if (e((hx) bdRunnable)) {
                this.a.submit(bdRunnable);
                return;
            } else {
                this.b.obtainMessage(1, bdRunnable).sendToTarget();
                return;
            }
        }
        try {
            this.a.submit(bdRunnable);
        } catch (Error e2) {
            bdRunnable.a(e2);
        } catch (Exception e3) {
            bdRunnable.onException(e3);
        }
    }

    public void h(BdRunnable bdRunnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdRunnable) == null) {
            this.c.post(bdRunnable);
        }
    }
}
