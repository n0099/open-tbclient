package d.a.s0.z3.l;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.view.cloudmusic.model.CloudMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicModel f70040a;

    /* renamed from: b  reason: collision with root package name */
    public final d f70041b;

    /* loaded from: classes9.dex */
    public class a implements d.a.s0.z3.l.j.a<CloudMusicData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f70042a;

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
            this.f70042a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.z3.l.j.a
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cloudMusicData) == null) {
                this.f70042a.f70041b.displayLoading(false);
                if (cloudMusicData != null) {
                    this.f70042a.f70041b.displayNoDataView(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        this.f70042a.f70041b.displayNoDataView(true);
                        return;
                    } else {
                        this.f70042a.f70041b.showCloudMusicWithTagData(cloudMusicData);
                        return;
                    }
                }
                this.f70042a.f70041b.displayNoDataView(true);
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
        this.f70040a = cloudMusicModel;
        this.f70041b = dVar;
        dVar.setPresenter(this);
    }

    @Override // d.a.s0.z3.l.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f70041b.displayLoading(true);
            this.f70040a.x(new a(this));
        }
    }

    @Override // d.a.s0.z3.l.c
    public void cancelLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f70040a.cancelLoadData();
        }
    }
}
