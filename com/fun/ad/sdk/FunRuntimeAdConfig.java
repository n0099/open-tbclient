package com.fun.ad.sdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class FunRuntimeAdConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<PersonalRecommendObserver> a;
    public volatile boolean personalRecommendStatus;

    public FunRuntimeAdConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.personalRecommendStatus = true;
        this.a = new HashSet();
    }

    public void registerPersonalRecommendObserver(PersonalRecommendObserver personalRecommendObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, personalRecommendObserver) == null) {
            synchronized (this.a) {
                this.a.add(personalRecommendObserver);
            }
        }
    }

    public void updatePersonalRecommendStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.personalRecommendStatus = z;
            synchronized (this.a) {
                for (PersonalRecommendObserver personalRecommendObserver : this.a) {
                    personalRecommendObserver.notifyStatusChanged(z);
                }
            }
        }
    }
}
