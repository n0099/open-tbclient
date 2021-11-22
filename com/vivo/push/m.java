package com.vivo.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public final class m implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f71236a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f71237b;

    public m(LocalAliasTagsManager localAliasTagsManager, List list) {
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
        this.f71237b = localAliasTagsManager;
        this.f71236a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        ISubscribeAppTagManager iSubscribeAppTagManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.f71236a) == null || list.size() <= 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (String str : this.f71236a) {
            hashSet.add(str);
        }
        iSubscribeAppTagManager = this.f71237b.mSubscribeAppTagManager;
        iSubscribeAppTagManager.delTagsSuccess(hashSet);
    }
}
