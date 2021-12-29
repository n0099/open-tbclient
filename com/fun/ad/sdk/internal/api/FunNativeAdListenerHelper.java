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
    public final ReporterPidLoader<K> f56294b;

    /* loaded from: classes3.dex */
    public class ListenerHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final V f56295b;

        /* renamed from: c  reason: collision with root package name */
        public final Ssp.Pid f56296c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f56297d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f56298e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f56299f;

        /* renamed from: g  reason: collision with root package name */
        public FunAdInteractionListener f56300g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdListenerHelper f56301h;

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
            this.f56301h = funNativeAdListenerHelper;
            this.a = str;
            this.f56295b = v;
            this.f56296c = pid;
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
        this.f56294b = reporterPidLoader;
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
                listenerHolder.f56301h.f56294b.onAdClicked(listenerHolder.f56299f);
                listenerHolder.f56299f = true;
                FunAdInteractionListener funAdInteractionListener = listenerHolder.f56300g;
                if (funAdInteractionListener != null) {
                    String str = listenerHolder.a;
                    Ssp.Pid pid = listenerHolder.f56296c;
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
                listenerHolder.f56301h.f56294b.onAdShow(k2, listenerHolder.f56298e);
                listenerHolder.f56298e = true;
                FunAdInteractionListener funAdInteractionListener = listenerHolder.f56300g;
                if (funAdInteractionListener != null) {
                    String str = listenerHolder.a;
                    Ssp.Pid pid = listenerHolder.f56296c;
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
                listenerHolder.f56301h.f56294b.onShowStart(listenerHolder.f56297d);
                listenerHolder.f56297d = true;
                listenerHolder.f56300g = funAdInteractionListener;
            }
        }
    }
}
