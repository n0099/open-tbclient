package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class a implements IDiffDevOAuth {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public List<OAuthListener> f76067c;

    /* renamed from: d  reason: collision with root package name */
    public d f76068d;

    /* renamed from: e  reason: collision with root package name */
    public OAuthListener f76069e;
    public Handler handler;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.handler = null;
        this.f76067c = new ArrayList();
        this.f76069e = new b(this);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void addListener(OAuthListener oAuthListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oAuthListener) == null) || this.f76067c.contains(oAuthListener)) {
            return;
        }
        this.f76067c.add(oAuthListener);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, str4, str5, oAuthListener})) == null) {
            Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = ".concat(String.valueOf(str)));
            if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
                Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", str, str2));
                return false;
            }
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            addListener(oAuthListener);
            if (this.f76068d != null) {
                Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
                return true;
            }
            d dVar = new d(str, str2, str3, str4, str5, this.f76069e);
            this.f76068d = dVar;
            if (Build.VERSION.SDK_INT >= 11) {
                dVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                dVar.execute(new Void[0]);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void detach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
            this.f76067c.clear();
            stopAuth();
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void removeAllListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f76067c.clear();
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void removeListener(OAuthListener oAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, oAuthListener) == null) {
            this.f76067c.remove(oAuthListener);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final boolean stopAuth() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
            try {
                z = this.f76068d == null ? true : this.f76068d.a();
            } catch (Exception e2) {
                Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e2.getMessage());
                z = false;
            }
            this.f76068d = null;
            return z;
        }
        return invokeV.booleanValue;
    }
}
