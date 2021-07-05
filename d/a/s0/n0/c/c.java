package d.a.s0.n0.c;

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
import d.a.s0.n0.c.d.a;
import d.a.s0.x1.g;
import d.a.s0.x1.k;
import d.a.s0.z3.m.e.b.a;
import java.io.File;
/* loaded from: classes9.dex */
public class c implements d.a.s0.n0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SelectMusicModel f63703a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f63704b;

    /* renamed from: c  reason: collision with root package name */
    public int f63705c;

    /* renamed from: d  reason: collision with root package name */
    public TbMusicData f63706d;

    /* renamed from: e  reason: collision with root package name */
    public String f63707e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63708f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f63709g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63710h;

    /* renamed from: i  reason: collision with root package name */
    public g f63711i;

    /* loaded from: classes9.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C1922a f63712a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f63713b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f63714c;

        public a(c cVar, a.C1922a c1922a, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c1922a, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63714c = cVar;
            this.f63712a = c1922a;
            this.f63713b = musicData;
        }

        @Override // d.a.s0.n0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f63712a.f70148d == this.f63714c.f63705c) {
                this.f63714c.f63710h = false;
                this.f63712a.f70146b.setVisibility(4);
                this.f63712a.f70145a.setDrawBorder(true);
                this.f63712a.f70145a.invalidate();
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f63714c.f63711i != null) {
                    this.f63714c.f63711i.b(3, str);
                }
            }
        }

        @Override // d.a.s0.n0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f63712a.f70148d == this.f63714c.f63705c) {
                this.f63714c.f63710h = false;
                this.f63712a.f70145a.setDrawBorder(true);
                this.f63712a.f70145a.invalidate();
                this.f63712a.f70146b.setVisibility(4);
            }
        }

        @Override // d.a.s0.n0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f63712a.f70148d == this.f63714c.f63705c) {
                this.f63714c.f63710h = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f63714c.n(str, this.f63713b);
                this.f63712a.f70146b.setVisibility(4);
                this.f63712a.f70145a.setDrawBorder(true);
                this.f63712a.f70145a.invalidate();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f63715a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f63716b;

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
            this.f63716b = cVar;
            this.f63715a = musicData;
        }

        @Override // d.a.s0.n0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f63716b.f63711i != null) {
                    this.f63716b.f63711i.b(3, str);
                }
            }
        }

        @Override // d.a.s0.n0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // d.a.s0.n0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f63716b.n(str, this.f63715a);
            }
        }
    }

    /* renamed from: d.a.s0.n0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1600c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f63717e;

        public C1600c(c cVar) {
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
            this.f63717e = cVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f63717e.f63704b.setLooping(true);
                this.f63717e.f63704b.start();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f63718e;

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
            this.f63718e = cVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f63718e.f63711i != null) {
                    g gVar = this.f63718e.f63711i;
                    gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public c(TbPageContext tbPageContext, d.a.s0.n0.c.b bVar) {
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
            this.f63711i = kVar.get();
        }
        this.f63709g = tbPageContext;
        this.f63703a = new SelectMusicModel(tbPageContext, bVar);
        m();
    }

    @Override // d.a.s0.n0.c.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f63707e : (String) invokeV.objValue;
    }

    @Override // d.a.s0.n0.c.a
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
            CloudMusicActivityConfig cloudMusicActivityConfig = new CloudMusicActivityConfig(this.f63709g.getPageActivity(), 25032);
            cloudMusicActivityConfig.setCurrentMusicData(this.f63706d);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, cloudMusicActivityConfig));
        }
    }

    @Override // d.a.s0.n0.c.a
    public void c() {
        SelectMusicModel selectMusicModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (selectMusicModel = this.f63703a) == null) {
            return;
        }
        selectMusicModel.cancelLoadData();
    }

    @Override // d.a.s0.n0.c.a
    public void d(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbMusicData) == null) {
            this.f63706d = tbMusicData;
        }
    }

    @Override // d.a.s0.n0.c.a
    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f63708f = false;
            this.f63707e = str;
            n(str, null);
        }
    }

    @Override // d.a.s0.n0.c.a
    public void f(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048581, this, f2) == null) || (mediaPlayer = this.f63704b) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > this.f63704b.getDuration()) {
            f2 %= this.f63704b.getDuration();
        }
        this.f63704b.seekTo((int) (f2 * 1000.0f));
        this.f63704b.start();
    }

    @Override // d.a.s0.n0.c.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f63710h : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f63703a.x();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, musicData) == null) || this.f63708f) {
            return;
        }
        if (this.f63704b == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f63704b = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f63707e = str;
            this.f63704b.reset();
            this.f63704b.setDataSource(str);
            this.f63704b.prepare();
            this.f63704b.setOnPreparedListener(new C1600c(this));
            this.f63704b.setOnErrorListener(new d(this));
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
        MediaPlayer mediaPlayer = this.f63704b;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f63704b.stop();
        }
        this.f63710h = false;
        String str = musicData.id;
        String g2 = d.a.s0.n0.c.d.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof a.C1922a)) {
            this.f63705c = ((a.C1922a) obj).f70148d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof a.C1922a) {
                a.C1922a c1922a = (a.C1922a) obj;
                c1922a.f70146b.setVisibility(0);
                c1922a.f70145a.setDrawBorder(false);
                c1922a.f70145a.invalidate();
                this.f63710h = true;
                d.a.s0.n0.c.d.a.h().f(musicData.id, musicData.resource, new a(this, c1922a, musicData));
                return;
            }
            d.a.s0.n0.c.d.a.h().f(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        n(g2, musicData);
    }

    @Override // d.a.s0.n0.c.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f63708f = true;
            MediaPlayer mediaPlayer = this.f63704b;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f63704b.pause();
        }
    }

    @Override // d.a.s0.n0.c.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f63708f = false;
            MediaPlayer mediaPlayer = this.f63704b;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f63704b.seekTo(0);
            }
        }
    }

    @Override // d.a.s0.n0.c.a
    public void onStopRecord() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (mediaPlayer = this.f63704b) != null && mediaPlayer.isPlaying()) {
            this.f63704b.pause();
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f63707e = null;
            releasePlayer();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                d.a.s0.n0.c.d.a.h().e();
            }
            o(null, musicData);
        }
    }

    @Override // d.a.s0.n0.c.a
    public void releasePlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MediaPlayer mediaPlayer = this.f63704b;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f63704b.stop();
                }
                this.f63704b.release();
                this.f63704b = null;
            }
            this.f63707e = null;
        }
    }

    @Override // d.a.s0.n0.c.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            releasePlayer();
        }
    }
}
