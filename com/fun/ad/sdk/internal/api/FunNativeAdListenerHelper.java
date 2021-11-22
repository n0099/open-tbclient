package com.fun.ad.sdk.internal.api;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.config.Ssp;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class FunNativeAdListenerHelper<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<K, FunNativeAdListenerHelper<K, V>.ListenerHolder> f63731a;

    /* renamed from: b  reason: collision with root package name */
    public final BasePidLoader<?> f63732b;

    /* loaded from: classes11.dex */
    public class ListenerHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f63733a;

        /* renamed from: b  reason: collision with root package name */
        public final V f63734b;

        /* renamed from: c  reason: collision with root package name */
        public final Ssp.Pid f63735c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f63736d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f63737e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f63738f;

        /* renamed from: g  reason: collision with root package name */
        public FunAdInteractionListener f63739g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdListenerHelper f63740h;

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
            this.f63740h = funNativeAdListenerHelper;
            this.f63733a = str;
            this.f63734b = v;
            this.f63735c = pid;
        }
    }

    public FunNativeAdListenerHelper(BasePidLoader<?> basePidLoader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {basePidLoader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63731a = new HashMap<>();
        this.f63732b = basePidLoader;
    }

    public final void destroy(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k) == null) {
            synchronized (this.f63731a) {
                this.f63731a.remove(k);
            }
        }
    }

    public final void onAdClick(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k) == null) {
            synchronized (this.f63731a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.f63731a.get(k);
                if (listenerHolder == null) {
                    return;
                }
                listenerHolder.f63740h.f63732b.mReporter.recordOnClicked(listenerHolder.f63738f);
                listenerHolder.f63738f = true;
                FunAdInteractionListener funAdInteractionListener = listenerHolder.f63739g;
                if (funAdInteractionListener != null) {
                    String str = listenerHolder.f63733a;
                    Ssp.Pid pid = listenerHolder.f63735c;
                    funAdInteractionListener.onAdClicked(str, pid.ssp.type, pid.pid);
                }
            }
        }
    }

    public final void onAdShow(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k) == null) {
            synchronized (this.f63731a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.f63731a.get(k);
                if (listenerHolder == null) {
                    return;
                }
                listenerHolder.f63740h.f63732b.mReporter.recordShowSucceed(listenerHolder.f63737e);
                listenerHolder.f63737e = true;
                FunAdInteractionListener funAdInteractionListener = listenerHolder.f63739g;
                if (funAdInteractionListener != null) {
                    String str = listenerHolder.f63733a;
                    Ssp.Pid pid = listenerHolder.f63735c;
                    funAdInteractionListener.onAdShow(str, pid.ssp.type, pid.pid);
                }
            }
        }
    }

    public final void startShow(K k, String str, Ssp.Pid pid, V v, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, k, str, pid, v, funAdInteractionListener) == null) {
            synchronized (this.f63731a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.f63731a.get(k);
                if (listenerHolder == null) {
                    listenerHolder = new ListenerHolder(this, str, pid, v);
                    this.f63731a.put(k, listenerHolder);
                }
                listenerHolder.f63740h.f63732b.mReporter.recordShowStart(listenerHolder.f63736d);
                listenerHolder.f63736d = true;
                listenerHolder.f63739g = funAdInteractionListener;
            }
        }
    }
}
