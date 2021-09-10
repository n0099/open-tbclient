package com.vivo.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* loaded from: classes10.dex */
public final class l implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f76612a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f76613b;

    public l(LocalAliasTagsManager localAliasTagsManager, List list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {localAliasTagsManager, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76613b = localAliasTagsManager;
        this.f76612a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.f76612a) == null || list.size() <= 0) {
            return;
        }
        iSubscribeAppAliasManager = this.f76613b.mSubscribeAppAliasManager;
        iSubscribeAppAliasManager.delAliasSuccess((String) this.f76612a.get(0));
    }
}
