package com.fun.ad.sdk.internal.api;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.config.Ssp;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class FunNativeAdListenerHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap a;
    public final ReporterPidLoader b;

    /* loaded from: classes7.dex */
    public class ListenerHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final Object b;
        public final Ssp.Pid c;
        public boolean d;
        public boolean e;
        public boolean f;
        public FunAdInteractionListener g;
        public final /* synthetic */ FunNativeAdListenerHelper h;

        public ListenerHolder(FunNativeAdListenerHelper funNativeAdListenerHelper, String str, Ssp.Pid pid, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funNativeAdListenerHelper, str, pid, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = funNativeAdListenerHelper;
            this.a = str;
            this.b = obj;
            this.c = pid;
        }
    }

    public FunNativeAdListenerHelper(ReporterPidLoader reporterPidLoader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reporterPidLoader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = reporterPidLoader;
    }

    public final void destroy(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            synchronized (this.a) {
                this.a.remove(obj);
            }
        }
    }

    public final void onAdClick(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            synchronized (this.a) {
                ListenerHolder listenerHolder = (ListenerHolder) this.a.get(obj);
                if (listenerHolder == null) {
                    return;
                }
                listenerHolder.h.b.onAdClicked(obj, listenerHolder.f, new String[0]);
                listenerHolder.f = true;
                FunAdInteractionListener funAdInteractionListener = listenerHolder.g;
                if (funAdInteractionListener != null) {
                    String str = listenerHolder.a;
                    Ssp.Pid pid = listenerHolder.c;
                    funAdInteractionListener.onAdClicked(str, pid.ssp.type, pid.pid);
                }
            }
        }
    }

    public final void onAdClose(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            synchronized (this.a) {
                ListenerHolder listenerHolder = (ListenerHolder) this.a.get(obj);
                if (listenerHolder == null) {
                    return;
                }
                listenerHolder.h.b.onAdClose(obj);
                FunAdInteractionListener funAdInteractionListener = listenerHolder.g;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClose(listenerHolder.a);
                }
            }
        }
    }

    public final void onAdShow(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            synchronized (this.a) {
                ListenerHolder listenerHolder = (ListenerHolder) this.a.get(obj);
                if (listenerHolder == null) {
                    return;
                }
                listenerHolder.h.b.onAdShow(obj, listenerHolder.e, new String[0]);
                listenerHolder.e = true;
                FunAdInteractionListener funAdInteractionListener = listenerHolder.g;
                if (funAdInteractionListener != null) {
                    String str = listenerHolder.a;
                    Ssp.Pid pid = listenerHolder.c;
                    funAdInteractionListener.onAdShow(str, pid.ssp.type, pid.pid);
                }
            }
        }
    }

    public final void startShow(Object obj, String str, Ssp.Pid pid, Object obj2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, obj, str, pid, obj2, funAdInteractionListener) == null) {
            synchronized (this.a) {
                ListenerHolder listenerHolder = (ListenerHolder) this.a.get(obj);
                if (listenerHolder == null) {
                    listenerHolder = new ListenerHolder(this, str, pid, obj2);
                    this.a.put(obj, listenerHolder);
                }
                listenerHolder.h.b.onShowStart(obj, listenerHolder.d);
                listenerHolder.d = true;
                listenerHolder.g = funAdInteractionListener;
            }
        }
    }
}
