package d.a.p0.z3.l;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.view.cloudmusic.MusicPlayer;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.view.cloudmusic.model.CloudMusicListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.n0.c.d.a;
import java.io.File;
/* loaded from: classes8.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicListModel f66830a;

    /* renamed from: b  reason: collision with root package name */
    public final f f66831b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f66832c;

    /* renamed from: d.a.p0.z3.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1875a implements d.a.p0.z3.l.j.a<CloudMusicData.MusicTagList> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66833a;

        public C1875a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66833a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.z3.l.j.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, musicTagList) == null) {
                this.f66833a.f66831b.u(false);
                if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    this.f66833a.f66831b.displayNoDataView(false);
                    this.f66833a.f66831b.X(musicTagList);
                } else {
                    this.f66833a.f66831b.displayNoDataView(true);
                }
                if (musicTagList.page.has_more == 0) {
                    this.f66833a.f66831b.w();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f66834a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f66835b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f66836c;

        /* renamed from: d.a.p0.z3.l.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1876a implements MusicPlayer.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f66837a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f66838b;

            public C1876a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66838b = bVar;
                this.f66837a = str;
            }

            @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f66838b.f66836c.f66832c.f();
                    if (this.f66837a.startsWith("/")) {
                        File file = new File(this.f66837a);
                        if (file.exists()) {
                            file.delete();
                        }
                        d.a.p0.n0.c.d.a.h().e();
                        b bVar = this.f66838b;
                        bVar.f66836c.a(bVar.f66834a, bVar.f66835b);
                    }
                }
            }
        }

        public b(a aVar, CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, musicList, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66836c = aVar;
            this.f66834a = musicList;
            this.f66835b = i2;
        }

        @Override // d.a.p0.n0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f66836c.f66831b.I(this.f66835b);
            }
        }

        @Override // d.a.p0.n0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f66836c.f66831b.K(this.f66835b);
            }
        }

        @Override // d.a.p0.n0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f66836c.f66832c.e(str, this.f66834a, new C1876a(this, str));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements MusicPlayer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f66839a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f66840b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f66841c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f66842d;

        public c(a aVar, String str, CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, musicList, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66842d = aVar;
            this.f66839a = str;
            this.f66840b = musicList;
            this.f66841c = i2;
        }

        @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66842d.f66832c.f();
                if (this.f66839a.startsWith("/")) {
                    File file = new File(this.f66839a);
                    if (file.exists()) {
                        file.delete();
                    }
                    d.a.p0.n0.c.d.a.h().e();
                    this.f66842d.a(this.f66840b, this.f66841c);
                }
            }
        }
    }

    public a(CloudMusicListModel cloudMusicListModel, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cloudMusicListModel, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66830a = cloudMusicListModel;
        this.f66831b = fVar;
        fVar.F(this);
        this.f66832c = MusicPlayer.c();
    }

    @Override // d.a.p0.z3.l.e
    public void a(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, musicList, i2) == null) || musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = d.a.p0.n0.c.d.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f66831b.h0(i2);
            d.a.p0.n0.c.d.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(this, musicList, i2));
            return;
        }
        this.f66832c.e(g2, musicList, new c(this, g2, musicList, i2));
    }

    @Override // d.a.p0.z3.l.e
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f66830a.A();
        }
    }

    @Override // d.a.p0.z3.l.e
    public void c(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, musicTagList) == null) {
            if (ListUtils.isEmpty(musicTagList.music_list)) {
                this.f66831b.displayNoDataView(true);
            } else {
                this.f66831b.displayNoDataView(false);
                this.f66831b.X(musicTagList);
            }
            if (musicTagList.page.has_more == 0) {
                this.f66831b.w();
            }
        }
    }

    @Override // d.a.p0.z3.l.e
    public void cancelLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f66830a.cancelLoadData();
        }
    }

    @Override // d.a.p0.z3.l.e
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f66831b.u(true);
            this.f66830a.y(i2, new C1875a(this));
        }
    }
}
