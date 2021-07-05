package com.kwad.sdk.glide.c;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class k implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final a f37644i;
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public final Map<FragmentManager, Object> f37645a;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    public final Map<KsFragmentManager, n> f37646b;

    /* renamed from: c  reason: collision with root package name */
    public volatile com.kwad.sdk.glide.g f37647c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f37648d;

    /* renamed from: e  reason: collision with root package name */
    public final a f37649e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayMap<View, KsFragment> f37650f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayMap<View, Fragment> f37651g;

    /* renamed from: h  reason: collision with root package name */
    public final Bundle f37652h;

    /* loaded from: classes7.dex */
    public interface a {
        @NonNull
        com.kwad.sdk.glide.g a(@NonNull com.kwad.sdk.glide.c cVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(905918369, "Lcom/kwad/sdk/glide/c/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(905918369, "Lcom/kwad/sdk/glide/c/k;");
                return;
            }
        }
        f37644i = new a() { // from class: com.kwad.sdk.glide.c.k.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kwad.sdk.glide.c.k.a
            @NonNull
            public com.kwad.sdk.glide.g a(@NonNull com.kwad.sdk.glide.c cVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context) {
                InterceptResult invokeLLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(1048576, this, cVar, hVar, lVar, context)) == null) ? new com.kwad.sdk.glide.g(cVar, hVar, lVar, context) : (com.kwad.sdk.glide.g) invokeLLLL.objValue;
            }
        };
    }

    public k(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37645a = new HashMap();
        this.f37646b = new HashMap();
        this.f37650f = new ArrayMap<>();
        this.f37651g = new ArrayMap<>();
        this.f37652h = new Bundle();
        this.f37649e = aVar == null ? f37644i : aVar;
        this.f37648d = new Handler(Looper.getMainLooper(), this);
    }

    @NonNull
    private n a(@NonNull KsFragmentManager ksFragmentManager, @Nullable KsFragment ksFragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, this, ksFragmentManager, ksFragment, z)) == null) {
            n nVar = (n) ksFragmentManager.findFragmentByTag("com.kwad.sdk.glide.manager");
            if (nVar == null && (nVar = this.f37646b.get(ksFragmentManager)) == null) {
                nVar = new n();
                nVar.a(ksFragment);
                if (z) {
                    nVar.a().a();
                }
                this.f37646b.put(ksFragmentManager, nVar);
                ksFragmentManager.beginTransaction().add(nVar, "com.kwad.sdk.glide.manager").commitAllowingStateLoss();
                this.f37648d.obtainMessage(2, ksFragmentManager).sendToTarget();
            }
            return nVar;
        }
        return (n) invokeLLZ.objValue;
    }

    @NonNull
    private com.kwad.sdk.glide.g a(@NonNull Context context, @NonNull KsFragmentManager ksFragmentManager, @Nullable KsFragment ksFragment, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{context, ksFragmentManager, ksFragment, Boolean.valueOf(z)})) == null) {
            n a2 = a(ksFragmentManager, ksFragment, z);
            com.kwad.sdk.glide.g b2 = a2.b();
            if (b2 == null) {
                com.kwad.sdk.glide.g a3 = this.f37649e.a(com.kwad.sdk.glide.c.a(context), a2.a(), a2.c(), context);
                a2.a(a3);
                return a3;
            }
            return b2;
        }
        return (com.kwad.sdk.glide.g) invokeCommon.objValue;
    }

    public static boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, activity)) == null) ? !activity.isFinishing() : invokeL.booleanValue;
    }

    @NonNull
    private com.kwad.sdk.glide.g b(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
            if (this.f37647c == null) {
                synchronized (this) {
                    if (this.f37647c == null) {
                        this.f37647c = this.f37649e.a(com.kwad.sdk.glide.c.a(context.getApplicationContext()), new b(), new g(), context.getApplicationContext());
                    }
                }
            }
            return this.f37647c;
        }
        return (com.kwad.sdk.glide.g) invokeL.objValue;
    }

    @NonNull
    public n a(KsFragmentManager ksFragmentManager, Activity activity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ksFragmentManager, activity)) == null) ? a(ksFragmentManager, null, a(activity)) : (n) invokeLL.objValue;
    }

    @NonNull
    public com.kwad.sdk.glide.g a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (context != null) {
                return b(context);
            }
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        return (com.kwad.sdk.glide.g) invokeL.objValue;
    }

    @NonNull
    public com.kwad.sdk.glide.g a(@NonNull KsFragment ksFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksFragment)) == null) {
            com.kwad.sdk.glide.g.j.a(ksFragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
            return com.kwad.sdk.glide.g.k.c() ? b(ksFragment.getActivity().getApplicationContext()) : a(ksFragment.getActivity(), ksFragment.getChildFragmentManager(), ksFragment, ksFragment.isVisible());
        }
        return (com.kwad.sdk.glide.g) invokeL.objValue;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Object obj;
        Map map;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, message)) == null) {
            int i2 = message.what;
            Object obj3 = null;
            boolean z = true;
            if (i2 == 1) {
                obj = (FragmentManager) message.obj;
                map = this.f37645a;
            } else if (i2 != 2) {
                z = false;
                obj2 = null;
                if (z && obj3 == null && Log.isLoggable(RequestManagerRetriever.TAG, 5)) {
                    Log.w(RequestManagerRetriever.TAG, "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z;
            } else {
                obj = (KsFragmentManager) message.obj;
                map = this.f37646b;
            }
            Object obj4 = obj;
            obj3 = map.remove(obj);
            obj2 = obj4;
            if (z) {
                Log.w(RequestManagerRetriever.TAG, "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
