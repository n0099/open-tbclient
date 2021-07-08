package d.a.p0.z3.l;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.view.cloudmusic.model.CloudMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicModel f66843a;

    /* renamed from: b  reason: collision with root package name */
    public final d f66844b;

    /* loaded from: classes8.dex */
    public class a implements d.a.p0.z3.l.j.a<CloudMusicData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f66845a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66845a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.z3.l.j.a
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cloudMusicData) == null) {
                this.f66845a.f66844b.displayLoading(false);
                if (cloudMusicData != null) {
                    this.f66845a.f66844b.displayNoDataView(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        this.f66845a.f66844b.displayNoDataView(true);
                        return;
                    } else {
                        this.f66845a.f66844b.showCloudMusicWithTagData(cloudMusicData);
                        return;
                    }
                }
                this.f66845a.f66844b.displayNoDataView(true);
            }
        }
    }

    public b(CloudMusicModel cloudMusicModel, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cloudMusicModel, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66843a = cloudMusicModel;
        this.f66844b = dVar;
        dVar.setPresenter(this);
    }

    @Override // d.a.p0.z3.l.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f66844b.displayLoading(true);
            this.f66843a.x(new a(this));
        }
    }

    @Override // d.a.p0.z3.l.c
    public void cancelLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f66843a.cancelLoadData();
        }
    }
}
