package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.feedManager.FeedRecModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.DataRes;
/* loaded from: classes7.dex */
public class zq4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zq4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public FeedRecModel a;
    public DataRes b;
    public FeedRecModel.b c;

    /* loaded from: classes7.dex */
    public class a implements FeedRecModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zq4 a;

        public a(zq4 zq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zq4Var;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.b = dataRes;
            }
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void onLoadError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.b = null;
            }
        }
    }

    public zq4() {
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
        this.c = new a(this);
        FeedRecModel feedRecModel = new FeedRecModel();
        this.a = feedRecModel;
        feedRecModel.A(this.c);
    }

    public static zq4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (zq4.class) {
                    if (d == null) {
                        d = new zq4();
                    }
                }
            }
            return d;
        }
        return (zq4) invokeV.objValue;
    }

    public DataRes c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (DataRes) invokeV.objValue;
    }
}
