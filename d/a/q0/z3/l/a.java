package d.a.q0.z3.l;

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
import d.a.q0.n0.c.d.a;
import java.io.File;
/* loaded from: classes8.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicListModel f67508a;

    /* renamed from: b  reason: collision with root package name */
    public final f f67509b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f67510c;

    /* renamed from: d.a.q0.z3.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1880a implements d.a.q0.z3.l.j.a<CloudMusicData.MusicTagList> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f67511a;

        public C1880a(a aVar) {
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
            this.f67511a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.z3.l.j.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, musicTagList) == null) {
                this.f67511a.f67509b.u(false);
                if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    this.f67511a.f67509b.displayNoDataView(false);
                    this.f67511a.f67509b.Y(musicTagList);
                } else {
                    this.f67511a.f67509b.displayNoDataView(true);
                }
                if (musicTagList.page.has_more == 0) {
                    this.f67511a.f67509b.w();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f67512a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f67513b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f67514c;

        /* renamed from: d.a.q0.z3.l.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1881a implements MusicPlayer.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f67515a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f67516b;

            public C1881a(b bVar, String str) {
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
                this.f67516b = bVar;
                this.f67515a = str;
            }

            @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f67516b.f67514c.f67510c.f();
                    if (this.f67515a.startsWith("/")) {
                        File file = new File(this.f67515a);
                        if (file.exists()) {
                            file.delete();
                        }
                        d.a.q0.n0.c.d.a.h().e();
                        b bVar = this.f67516b;
                        bVar.f67514c.a(bVar.f67512a, bVar.f67513b);
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
            this.f67514c = aVar;
            this.f67512a = musicList;
            this.f67513b = i2;
        }

        @Override // d.a.q0.n0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f67514c.f67509b.I(this.f67513b);
            }
        }

        @Override // d.a.q0.n0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f67514c.f67509b.L(this.f67513b);
            }
        }

        @Override // d.a.q0.n0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f67514c.f67510c.e(str, this.f67512a, new C1881a(this, str));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements MusicPlayer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f67517a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f67518b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f67519c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f67520d;

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
            this.f67520d = aVar;
            this.f67517a = str;
            this.f67518b = musicList;
            this.f67519c = i2;
        }

        @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67520d.f67510c.f();
                if (this.f67517a.startsWith("/")) {
                    File file = new File(this.f67517a);
                    if (file.exists()) {
                        file.delete();
                    }
                    d.a.q0.n0.c.d.a.h().e();
                    this.f67520d.a(this.f67518b, this.f67519c);
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
        this.f67508a = cloudMusicListModel;
        this.f67509b = fVar;
        fVar.F(this);
        this.f67510c = MusicPlayer.c();
    }

    @Override // d.a.q0.z3.l.e
    public void a(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, musicList, i2) == null) || musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = d.a.q0.n0.c.d.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f67509b.k0(i2);
            d.a.q0.n0.c.d.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(this, musicList, i2));
            return;
        }
        this.f67510c.e(g2, musicList, new c(this, g2, musicList, i2));
    }

    @Override // d.a.q0.z3.l.e
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f67508a.A();
        }
    }

    @Override // d.a.q0.z3.l.e
    public void c(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, musicTagList) == null) {
            if (ListUtils.isEmpty(musicTagList.music_list)) {
                this.f67509b.displayNoDataView(true);
            } else {
                this.f67509b.displayNoDataView(false);
                this.f67509b.Y(musicTagList);
            }
            if (musicTagList.page.has_more == 0) {
                this.f67509b.w();
            }
        }
    }

    @Override // d.a.q0.z3.l.e
    public void cancelLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f67508a.cancelLoadData();
        }
    }

    @Override // d.a.q0.z3.l.e
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f67509b.u(true);
            this.f67508a.y(i2, new C1880a(this));
        }
    }
}
