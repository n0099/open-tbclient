package com.fun.ad.sdk.internal.api;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.config.Ssp;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class FunNativeAdListenerHelper<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<K, FunNativeAdListenerHelper<K, V>.ListenerHolder> a;

    /* renamed from: b  reason: collision with root package name */
    public final ReporterPidLoader<K> f54206b;

    /* loaded from: classes3.dex */
    public class ListenerHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final V f54207b;

        /* renamed from: c  reason: collision with root package name */
        public final Ssp.Pid f54208c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f54209d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f54210e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f54211f;

        /* renamed from: g  reason: collision with root package name */
        public FunAdInteractionListener f54212g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdListenerHelper f54213h;

        public ListenerHolder(FunNativeAdListenerHelper funNativeAdListenerHelper, String str, Ssp.Pid pid, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funNativeAdListenerHelper, str, pid, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54213h = funNativeAdListenerHelper;
            this.a = str;
            this.f54207b = v;
            this.f54208c = pid;
        }
    }

    public FunNativeAdListenerHelper(ReporterPidLoader<K> reporterPidLoader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reporterPidLoader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.f54206b = reporterPidLoader;
    }

    public final void destroy(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k) == null) {
            synchronized (this.a) {
                this.a.remove(k);
            }
        }
    }

    public final void onAdClick(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k) == null) {
            synchronized (this.a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.a.get(k);
                if (listenerHolder == null) {
                    return;
                }
                listenerHolder.f54213h.f54206b.onAdClicked(listenerHolder.f54211f);
                listenerHolder.f54211f = true;
                FunAdInteractionListener funAdInteractionListener = listenerHolder.f54212g;
                if (funAdInteractionListener != null) {
                    String str = listenerHolder.a;
                    Ssp.Pid pid = listenerHolder.f54208c;
                    funAdInteractionListener.onAdClicked(str, pid.ssp.type, pid.pid);
                }
            }
        }
    }

    public final void onAdShow(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k) == null) {
            synchronized (this.a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.a.get(k);
                if (listenerHolder == null) {
                    return;
                }
                listenerHolder.f54213h.f54206b.onAdShow(k, listenerHolder.f54210e);
                listenerHolder.f54210e = true;
                FunAdInteractionListener funAdInteractionListener = listenerHolder.f54212g;
                if (funAdInteractionListener != null) {
                    String str = listenerHolder.a;
                    Ssp.Pid pid = listenerHolder.f54208c;
                    funAdInteractionListener.onAdShow(str, pid.ssp.type, pid.pid);
                }
            }
        }
    }

    public final void startShow(K k, String str, Ssp.Pid pid, V v, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, k, str, pid, v, funAdInteractionListener) == null) {
            synchronized (this.a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.a.get(k);
                if (listenerHolder == null) {
                    listenerHolder = new ListenerHolder(this, str, pid, v);
                    this.a.put(k, listenerHolder);
                }
                listenerHolder.f54213h.f54206b.onShowStart(listenerHolder.f54209d);
                listenerHolder.f54209d = true;
                listenerHolder.f54212g = funAdInteractionListener;
            }
        }
    }
}
