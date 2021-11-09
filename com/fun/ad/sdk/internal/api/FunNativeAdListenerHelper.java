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
    public final HashMap<K, FunNativeAdListenerHelper<K, V>.ListenerHolder> f62831a;

    /* renamed from: b  reason: collision with root package name */
    public final BasePidLoader<?> f62832b;

    /* loaded from: classes11.dex */
    public class ListenerHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f62833a;

        /* renamed from: b  reason: collision with root package name */
        public final V f62834b;

        /* renamed from: c  reason: collision with root package name */
        public final Ssp.Pid f62835c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f62836d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f62837e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f62838f;

        /* renamed from: g  reason: collision with root package name */
        public FunAdInteractionListener f62839g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdListenerHelper f62840h;

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
            this.f62840h = funNativeAdListenerHelper;
            this.f62833a = str;
            this.f62834b = v;
            this.f62835c = pid;
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
        this.f62831a = new HashMap<>();
        this.f62832b = basePidLoader;
    }

    public final void destroy(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k) == null) {
            synchronized (this.f62831a) {
                this.f62831a.remove(k);
            }
        }
    }

    public final void onAdClick(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k) == null) {
            synchronized (this.f62831a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.f62831a.get(k);
                if (listenerHolder == null) {
                    return;
                }
                listenerHolder.f62840h.f62832b.mReporter.recordOnClicked(listenerHolder.f62838f);
                listenerHolder.f62838f = true;
                FunAdInteractionListener funAdInteractionListener = listenerHolder.f62839g;
                if (funAdInteractionListener != null) {
                    String str = listenerHolder.f62833a;
                    Ssp.Pid pid = listenerHolder.f62835c;
                    funAdInteractionListener.onAdClicked(str, pid.ssp.type, pid.pid);
                }
            }
        }
    }

    public final void onAdShow(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k) == null) {
            synchronized (this.f62831a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.f62831a.get(k);
                if (listenerHolder == null) {
                    return;
                }
                listenerHolder.f62840h.f62832b.mReporter.recordShowSucceed(listenerHolder.f62837e);
                listenerHolder.f62837e = true;
                FunAdInteractionListener funAdInteractionListener = listenerHolder.f62839g;
                if (funAdInteractionListener != null) {
                    String str = listenerHolder.f62833a;
                    Ssp.Pid pid = listenerHolder.f62835c;
                    funAdInteractionListener.onAdShow(str, pid.ssp.type, pid.pid);
                }
            }
        }
    }

    public final void startShow(K k, String str, Ssp.Pid pid, V v, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, k, str, pid, v, funAdInteractionListener) == null) {
            synchronized (this.f62831a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.f62831a.get(k);
                if (listenerHolder == null) {
                    listenerHolder = new ListenerHolder(this, str, pid, v);
                    this.f62831a.put(k, listenerHolder);
                }
                listenerHolder.f62840h.f62832b.mReporter.recordShowStart(listenerHolder.f62836d);
                listenerHolder.f62836d = true;
                listenerHolder.f62839g = funAdInteractionListener;
            }
        }
    }
}
