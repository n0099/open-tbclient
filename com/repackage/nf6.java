package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class nf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public if6 a;
    public String b;
    public VideoAggregationModel c;
    public boolean d;
    public VideoAggregationModel.c e;

    /* loaded from: classes6.dex */
    public class a implements VideoAggregationModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf6 a;

        public a(nf6 nf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf6Var;
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a.a == null) {
                return;
            }
            this.a.a.m();
            this.a.a.k(str);
            this.a.a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void b(List<lf6> list, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.a.a == null) {
                return;
            }
            this.a.a.m();
            this.a.d = z2;
            this.a.a.N0(list, z, z2);
        }
    }

    public nf6(TbPageContext tbPageContext, if6 if6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, if6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.e = aVar;
        this.a = if6Var;
        this.c = new VideoAggregationModel(tbPageContext, aVar);
    }

    public void c() {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoAggregationModel = this.c) == null) {
            return;
        }
        videoAggregationModel.cancelLoadData();
    }

    public void d() {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (videoAggregationModel = this.c) != null && this.d) {
            videoAggregationModel.loadData();
        }
    }

    public void e() {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (videoAggregationModel = this.c) == null) {
            return;
        }
        videoAggregationModel.D();
    }

    public void f(String str) {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (videoAggregationModel = this.c) == null) {
            return;
        }
        videoAggregationModel.setFrom(str);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.b = str;
            VideoAggregationModel videoAggregationModel = this.c;
            if (videoAggregationModel != null) {
                videoAggregationModel.E(str);
            }
        }
    }

    public void h(String str) {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (videoAggregationModel = this.c) == null) {
            return;
        }
        videoAggregationModel.F(str);
    }

    public void i(String str) {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (videoAggregationModel = this.c) == null) {
            return;
        }
        videoAggregationModel.G(str);
    }
}
