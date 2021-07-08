package d.a.p0.n0.c;

import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.music.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.p0.n0.c.d.a;
import d.a.p0.x1.g;
import d.a.p0.x1.k;
import d.a.p0.z3.m.e.b.a;
import java.io.File;
/* loaded from: classes8.dex */
public class c implements d.a.p0.n0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SelectMusicModel f60469a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f60470b;

    /* renamed from: c  reason: collision with root package name */
    public int f60471c;

    /* renamed from: d  reason: collision with root package name */
    public TbMusicData f60472d;

    /* renamed from: e  reason: collision with root package name */
    public String f60473e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60474f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f60475g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60476h;

    /* renamed from: i  reason: collision with root package name */
    public g f60477i;

    /* loaded from: classes8.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C1881a f60478a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f60479b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f60480c;

        public a(c cVar, a.C1881a c1881a, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c1881a, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60480c = cVar;
            this.f60478a = c1881a;
            this.f60479b = musicData;
        }

        @Override // d.a.p0.n0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f60478a.f66951d == this.f60480c.f60471c) {
                this.f60480c.f60476h = false;
                this.f60478a.f66949b.setVisibility(4);
                this.f60478a.f66948a.setDrawBorder(true);
                this.f60478a.f66948a.invalidate();
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f60480c.f60477i != null) {
                    this.f60480c.f60477i.b(3, str);
                }
            }
        }

        @Override // d.a.p0.n0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f60478a.f66951d == this.f60480c.f60471c) {
                this.f60480c.f60476h = false;
                this.f60478a.f66948a.setDrawBorder(true);
                this.f60478a.f66948a.invalidate();
                this.f60478a.f66949b.setVisibility(4);
            }
        }

        @Override // d.a.p0.n0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f60478a.f66951d == this.f60480c.f60471c) {
                this.f60480c.f60476h = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f60480c.n(str, this.f60479b);
                this.f60478a.f66949b.setVisibility(4);
                this.f60478a.f66948a.setDrawBorder(true);
                this.f60478a.f66948a.invalidate();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f60481a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f60482b;

        public b(c cVar, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60482b = cVar;
            this.f60481a = musicData;
        }

        @Override // d.a.p0.n0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f60482b.f60477i != null) {
                    this.f60482b.f60477i.b(3, str);
                }
            }
        }

        @Override // d.a.p0.n0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // d.a.p0.n0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f60482b.n(str, this.f60481a);
            }
        }
    }

    /* renamed from: d.a.p0.n0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1556c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60483e;

        public C1556c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60483e = cVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f60483e.f60470b.setLooping(true);
                this.f60483e.f60470b.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60484e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60484e = cVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f60484e.f60477i != null) {
                    g gVar = this.f60484e.f60477i;
                    gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public c(TbPageContext tbPageContext, d.a.p0.n0.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.f60477i = kVar.get();
        }
        this.f60475g = tbPageContext;
        this.f60469a = new SelectMusicModel(tbPageContext, bVar);
        m();
    }

    @Override // d.a.p0.n0.c.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60473e : (String) invokeV.objValue;
    }

    @Override // d.a.p0.n0.c.a
    public void b(MusicData musicData, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, musicData, obj) == null) || musicData == null) {
            return;
        }
        int i2 = musicData.editMusicType;
        if (i2 == 0) {
            o(obj, musicData);
        } else if (i2 == 1) {
            releasePlayer();
        } else if (i2 != 2) {
        } else {
            CloudMusicActivityConfig cloudMusicActivityConfig = new CloudMusicActivityConfig(this.f60475g.getPageActivity(), 25032);
            cloudMusicActivityConfig.setCurrentMusicData(this.f60472d);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, cloudMusicActivityConfig));
        }
    }

    @Override // d.a.p0.n0.c.a
    public void c() {
        SelectMusicModel selectMusicModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (selectMusicModel = this.f60469a) == null) {
            return;
        }
        selectMusicModel.cancelLoadData();
    }

    @Override // d.a.p0.n0.c.a
    public void d(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbMusicData) == null) {
            this.f60472d = tbMusicData;
        }
    }

    @Override // d.a.p0.n0.c.a
    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f60474f = false;
            this.f60473e = str;
            n(str, null);
        }
    }

    @Override // d.a.p0.n0.c.a
    public void f(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048581, this, f2) == null) || (mediaPlayer = this.f60470b) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > this.f60470b.getDuration()) {
            f2 %= this.f60470b.getDuration();
        }
        this.f60470b.seekTo((int) (f2 * 1000.0f));
        this.f60470b.start();
    }

    @Override // d.a.p0.n0.c.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f60476h : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f60469a.x();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, musicData) == null) || this.f60474f) {
            return;
        }
        if (this.f60470b == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f60470b = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f60473e = str;
            this.f60470b.reset();
            this.f60470b.setDataSource(str);
            this.f60470b.prepare();
            this.f60470b.setOnPreparedListener(new C1556c(this));
            this.f60470b.setOnErrorListener(new d(this));
        } catch (Exception e2) {
            e2.printStackTrace();
            p(str, musicData);
        }
    }

    public final void o(Object obj, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, obj, musicData) == null) || musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        MediaPlayer mediaPlayer = this.f60470b;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f60470b.stop();
        }
        this.f60476h = false;
        String str = musicData.id;
        String g2 = d.a.p0.n0.c.d.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof a.C1881a)) {
            this.f60471c = ((a.C1881a) obj).f66951d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof a.C1881a) {
                a.C1881a c1881a = (a.C1881a) obj;
                c1881a.f66949b.setVisibility(0);
                c1881a.f66948a.setDrawBorder(false);
                c1881a.f66948a.invalidate();
                this.f60476h = true;
                d.a.p0.n0.c.d.a.h().f(musicData.id, musicData.resource, new a(this, c1881a, musicData));
                return;
            }
            d.a.p0.n0.c.d.a.h().f(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        n(g2, musicData);
    }

    @Override // d.a.p0.n0.c.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f60474f = true;
            MediaPlayer mediaPlayer = this.f60470b;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f60470b.pause();
        }
    }

    @Override // d.a.p0.n0.c.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f60474f = false;
            MediaPlayer mediaPlayer = this.f60470b;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f60470b.seekTo(0);
            }
        }
    }

    @Override // d.a.p0.n0.c.a
    public void onStopRecord() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (mediaPlayer = this.f60470b) != null && mediaPlayer.isPlaying()) {
            this.f60470b.pause();
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f60473e = null;
            releasePlayer();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                d.a.p0.n0.c.d.a.h().e();
            }
            o(null, musicData);
        }
    }

    @Override // d.a.p0.n0.c.a
    public void releasePlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MediaPlayer mediaPlayer = this.f60470b;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f60470b.stop();
                }
                this.f60470b.release();
                this.f60470b = null;
            }
            this.f60473e = null;
        }
    }

    @Override // d.a.p0.n0.c.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            releasePlayer();
        }
    }
}
