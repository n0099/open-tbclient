package com.vivo.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes2.dex */
public final class h implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f71226a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f71227b;

    public h(LocalAliasTagsManager localAliasTagsManager, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {localAliasTagsManager, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71227b = localAliasTagsManager;
        this.f71226a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            iSubscribeAppAliasManager = this.f71227b.mSubscribeAppAliasManager;
            if (iSubscribeAppAliasManager.delAlias(this.f71226a)) {
                p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f71226a);
            }
        }
    }
}
