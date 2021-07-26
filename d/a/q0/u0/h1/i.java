package d.a.q0.u0.h1;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f63531a;

    /* renamed from: b  reason: collision with root package name */
    public String f63532b;

    /* renamed from: c  reason: collision with root package name */
    public VideoAggregationModel f63533c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63534d;

    /* renamed from: e  reason: collision with root package name */
    public VideoAggregationModel.c f63535e;

    /* loaded from: classes8.dex */
    public class a implements VideoAggregationModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f63536a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63536a = iVar;
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f63536a.f63531a == null) {
                return;
            }
            this.f63536a.f63531a.l();
            this.f63536a.f63531a.c(str);
            this.f63536a.f63531a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void b(List<g> list, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f63536a.f63531a == null) {
                return;
            }
            this.f63536a.f63531a.l();
            this.f63536a.f63534d = z2;
            this.f63536a.f63531a.d(list, z, z2);
        }
    }

    public i(TbPageContext tbPageContext, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.f63535e = aVar;
        this.f63531a = dVar;
        this.f63533c = new VideoAggregationModel(tbPageContext, aVar);
    }

    public void c() {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoAggregationModel = this.f63533c) == null) {
            return;
        }
        videoAggregationModel.cancelLoadData();
    }

    public void d() {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (videoAggregationModel = this.f63533c) != null && this.f63534d) {
            videoAggregationModel.LoadData();
        }
    }

    public void e() {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (videoAggregationModel = this.f63533c) == null) {
            return;
        }
        videoAggregationModel.A();
    }

    public void f(String str) {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (videoAggregationModel = this.f63533c) == null) {
            return;
        }
        videoAggregationModel.setFrom(str);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f63532b = str;
            VideoAggregationModel videoAggregationModel = this.f63533c;
            if (videoAggregationModel != null) {
                videoAggregationModel.B(str);
            }
        }
    }

    public void h(String str) {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (videoAggregationModel = this.f63533c) == null) {
            return;
        }
        videoAggregationModel.C(str);
    }

    public void i(String str) {
        VideoAggregationModel videoAggregationModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (videoAggregationModel = this.f63533c) == null) {
            return;
        }
        videoAggregationModel.D(str);
    }
}
