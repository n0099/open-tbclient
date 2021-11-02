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
    public final HashMap<K, FunNativeAdListenerHelper<K, V>.ListenerHolder> f62832a;

    /* renamed from: b  reason: collision with root package name */
    public final BasePidLoader<?> f62833b;

    /* loaded from: classes11.dex */
    public class ListenerHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f62834a;

        /* renamed from: b  reason: collision with root package name */
        public final V f62835b;

        /* renamed from: c  reason: collision with root package name */
        public final Ssp.Pid f62836c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f62837d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f62838e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f62839f;

        /* renamed from: g  reason: collision with root package name */
        public FunAdInteractionListener f62840g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdListenerHelper f62841h;

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
            this.f62841h = funNativeAdListenerHelper;
            this.f62834a = str;
            this.f62835b = v;
            this.f62836c = pid;
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
        this.f62832a = new HashMap<>();
        this.f62833b = basePidLoader;
    }

    public final void destroy(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k) == null) {
            synchronized (this.f62832a) {
                this.f62832a.remove(k);
            }
        }
    }

    public final void onAdClick(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k) == null) {
            synchronized (this.f62832a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.f62832a.get(k);
                if (listenerHolder == null) {
                    return;
                }
                listenerHolder.f62841h.f62833b.mReporter.recordOnClicked(listenerHolder.f62839f);
                listenerHolder.f62839f = true;
                FunAdInteractionListener funAdInteractionListener = listenerHolder.f62840g;
                if (funAdInteractionListener != null) {
                    String str = listenerHolder.f62834a;
                    Ssp.Pid pid = listenerHolder.f62836c;
                    funAdInteractionListener.onAdClicked(str, pid.ssp.type, pid.pid);
                }
            }
        }
    }

    public final void onAdShow(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k) == null) {
            synchronized (this.f62832a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.f62832a.get(k);
                if (listenerHolder == null) {
                    return;
                }
                listenerHolder.f62841h.f62833b.mReporter.recordShowSucceed(listenerHolder.f62838e);
                listenerHolder.f62838e = true;
                FunAdInteractionListener funAdInteractionListener = listenerHolder.f62840g;
                if (funAdInteractionListener != null) {
                    String str = listenerHolder.f62834a;
                    Ssp.Pid pid = listenerHolder.f62836c;
                    funAdInteractionListener.onAdShow(str, pid.ssp.type, pid.pid);
                }
            }
        }
    }

    public final void startShow(K k, String str, Ssp.Pid pid, V v, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, k, str, pid, v, funAdInteractionListener) == null) {
            synchronized (this.f62832a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.f62832a.get(k);
                if (listenerHolder == null) {
                    listenerHolder = new ListenerHolder(this, str, pid, v);
                    this.f62832a.put(k, listenerHolder);
                }
                listenerHolder.f62841h.f62833b.mReporter.recordShowStart(listenerHolder.f62837d);
                listenerHolder.f62837d = true;
                listenerHolder.f62840g = funAdInteractionListener;
            }
        }
    }
}
