package d.a.s0.z3.l;

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
import d.a.s0.n0.c.d.a;
import java.io.File;
/* loaded from: classes9.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicListModel f70027a;

    /* renamed from: b  reason: collision with root package name */
    public final f f70028b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f70029c;

    /* renamed from: d.a.s0.z3.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1916a implements d.a.s0.z3.l.j.a<CloudMusicData.MusicTagList> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f70030a;

        public C1916a(a aVar) {
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
            this.f70030a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.z3.l.j.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, musicTagList) == null) {
                this.f70030a.f70028b.u(false);
                if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    this.f70030a.f70028b.displayNoDataView(false);
                    this.f70030a.f70028b.X(musicTagList);
                } else {
                    this.f70030a.f70028b.displayNoDataView(true);
                }
                if (musicTagList.page.has_more == 0) {
                    this.f70030a.f70028b.w();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f70031a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f70032b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f70033c;

        /* renamed from: d.a.s0.z3.l.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1917a implements MusicPlayer.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f70034a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f70035b;

            public C1917a(b bVar, String str) {
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
                this.f70035b = bVar;
                this.f70034a = str;
            }

            @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f70035b.f70033c.f70029c.f();
                    if (this.f70034a.startsWith("/")) {
                        File file = new File(this.f70034a);
                        if (file.exists()) {
                            file.delete();
                        }
                        d.a.s0.n0.c.d.a.h().e();
                        b bVar = this.f70035b;
                        bVar.f70033c.a(bVar.f70031a, bVar.f70032b);
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
            this.f70033c = aVar;
            this.f70031a = musicList;
            this.f70032b = i2;
        }

        @Override // d.a.s0.n0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f70033c.f70028b.I(this.f70032b);
            }
        }

        @Override // d.a.s0.n0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f70033c.f70028b.K(this.f70032b);
            }
        }

        @Override // d.a.s0.n0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f70033c.f70029c.e(str, this.f70031a, new C1917a(this, str));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements MusicPlayer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f70036a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f70037b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f70038c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f70039d;

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
            this.f70039d = aVar;
            this.f70036a = str;
            this.f70037b = musicList;
            this.f70038c = i2;
        }

        @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70039d.f70029c.f();
                if (this.f70036a.startsWith("/")) {
                    File file = new File(this.f70036a);
                    if (file.exists()) {
                        file.delete();
                    }
                    d.a.s0.n0.c.d.a.h().e();
                    this.f70039d.a(this.f70037b, this.f70038c);
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
        this.f70027a = cloudMusicListModel;
        this.f70028b = fVar;
        fVar.F(this);
        this.f70029c = MusicPlayer.c();
    }

    @Override // d.a.s0.z3.l.e
    public void a(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, musicList, i2) == null) || musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = d.a.s0.n0.c.d.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f70028b.h0(i2);
            d.a.s0.n0.c.d.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(this, musicList, i2));
            return;
        }
        this.f70029c.e(g2, musicList, new c(this, g2, musicList, i2));
    }

    @Override // d.a.s0.z3.l.e
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f70027a.A();
        }
    }

    @Override // d.a.s0.z3.l.e
    public void c(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, musicTagList) == null) {
            if (ListUtils.isEmpty(musicTagList.music_list)) {
                this.f70028b.displayNoDataView(true);
            } else {
                this.f70028b.displayNoDataView(false);
                this.f70028b.X(musicTagList);
            }
            if (musicTagList.page.has_more == 0) {
                this.f70028b.w();
            }
        }
    }

    @Override // d.a.s0.z3.l.e
    public void cancelLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f70027a.cancelLoadData();
        }
    }

    @Override // d.a.s0.z3.l.e
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f70028b.u(true);
            this.f70027a.y(i2, new C1916a(this));
        }
    }
}
