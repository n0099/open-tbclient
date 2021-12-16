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
    public final ReporterPidLoader<K> f56295b;

    /* loaded from: classes3.dex */
    public class ListenerHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final V f56296b;

        /* renamed from: c  reason: collision with root package name */
        public final Ssp.Pid f56297c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f56298d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f56299e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f56300f;

        /* renamed from: g  reason: collision with root package name */
        public FunAdInteractionListener f56301g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdListenerHelper f56302h;

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
            this.f56302h = funNativeAdListenerHelper;
            this.a = str;
            this.f56296b = v;
            this.f56297c = pid;
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
        this.f56295b = reporterPidLoader;
    }

    public final void destroy(K k2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k2) == null) {
            synchronized (this.a) {
                this.a.remove(k2);
            }
        }
    }

    public final void onAdClick(K k2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k2) == null) {
            synchronized (this.a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.a.get(k2);
                if (listenerHolder == null) {
                    return;
                }
                listenerHolder.f56302h.f56295b.onAdClicked(listenerHolder.f56300f);
                listenerHolder.f56300f = true;
                FunAdInteractionListener funAdInteractionListener = listenerHolder.f56301g;
                if (funAdInteractionListener != null) {
                    String str = listenerHolder.a;
                    Ssp.Pid pid = listenerHolder.f56297c;
                    funAdInteractionListener.onAdClicked(str, pid.ssp.type, pid.pid);
                }
            }
        }
    }

    public final void onAdShow(K k2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k2) == null) {
            synchronized (this.a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.a.get(k2);
                if (listenerHolder == null) {
                    return;
                }
                listenerHolder.f56302h.f56295b.onAdShow(k2, listenerHolder.f56299e);
                listenerHolder.f56299e = true;
                FunAdInteractionListener funAdInteractionListener = listenerHolder.f56301g;
                if (funAdInteractionListener != null) {
                    String str = listenerHolder.a;
                    Ssp.Pid pid = listenerHolder.f56297c;
                    funAdInteractionListener.onAdShow(str, pid.ssp.type, pid.pid);
                }
            }
        }
    }

    public final void startShow(K k2, String str, Ssp.Pid pid, V v, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, k2, str, pid, v, funAdInteractionListener) == null) {
            synchronized (this.a) {
                FunNativeAdListenerHelper<K, V>.ListenerHolder listenerHolder = this.a.get(k2);
                if (listenerHolder == null) {
                    listenerHolder = new ListenerHolder(this, str, pid, v);
                    this.a.put(k2, listenerHolder);
                }
                listenerHolder.f56302h.f56295b.onShowStart(listenerHolder.f56298d);
                listenerHolder.f56298d = true;
                listenerHolder.f56301g = funAdInteractionListener;
            }
        }
    }
}
