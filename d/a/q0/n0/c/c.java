package d.a.q0.n0.c;

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
import d.a.d.e.p.l;
import d.a.q0.n0.c.d.a;
import d.a.q0.x1.g;
import d.a.q0.x1.k;
import d.a.q0.z3.m.e.b.a;
import java.io.File;
/* loaded from: classes8.dex */
public class c implements d.a.q0.n0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SelectMusicModel f61083a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f61084b;

    /* renamed from: c  reason: collision with root package name */
    public int f61085c;

    /* renamed from: d  reason: collision with root package name */
    public TbMusicData f61086d;

    /* renamed from: e  reason: collision with root package name */
    public String f61087e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61088f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f61089g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61090h;

    /* renamed from: i  reason: collision with root package name */
    public g f61091i;

    /* loaded from: classes8.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C1886a f61092a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f61093b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f61094c;

        public a(c cVar, a.C1886a c1886a, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c1886a, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61094c = cVar;
            this.f61092a = c1886a;
            this.f61093b = musicData;
        }

        @Override // d.a.q0.n0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f61092a.f67629d == this.f61094c.f61085c) {
                this.f61094c.f61090h = false;
                this.f61092a.f67627b.setVisibility(4);
                this.f61092a.f67626a.setDrawBorder(true);
                this.f61092a.f67626a.invalidate();
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f61094c.f61091i != null) {
                    this.f61094c.f61091i.b(3, str);
                }
            }
        }

        @Override // d.a.q0.n0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f61092a.f67629d == this.f61094c.f61085c) {
                this.f61094c.f61090h = false;
                this.f61092a.f67626a.setDrawBorder(true);
                this.f61092a.f67626a.invalidate();
                this.f61092a.f67627b.setVisibility(4);
            }
        }

        @Override // d.a.q0.n0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f61092a.f67629d == this.f61094c.f61085c) {
                this.f61094c.f61090h = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f61094c.n(str, this.f61093b);
                this.f61092a.f67627b.setVisibility(4);
                this.f61092a.f67626a.setDrawBorder(true);
                this.f61092a.f67626a.invalidate();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f61095a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f61096b;

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
            this.f61096b = cVar;
            this.f61095a = musicData;
        }

        @Override // d.a.q0.n0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f61096b.f61091i != null) {
                    this.f61096b.f61091i.b(3, str);
                }
            }
        }

        @Override // d.a.q0.n0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // d.a.q0.n0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f61096b.n(str, this.f61095a);
            }
        }
    }

    /* renamed from: d.a.q0.n0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1561c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61097e;

        public C1561c(c cVar) {
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
            this.f61097e = cVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f61097e.f61084b.setLooping(true);
                this.f61097e.f61084b.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61098e;

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
            this.f61098e = cVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f61098e.f61091i != null) {
                    g gVar = this.f61098e.f61091i;
                    gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public c(TbPageContext tbPageContext, d.a.q0.n0.c.b bVar) {
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
            this.f61091i = kVar.get();
        }
        this.f61089g = tbPageContext;
        this.f61083a = new SelectMusicModel(tbPageContext, bVar);
        m();
    }

    @Override // d.a.q0.n0.c.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61087e : (String) invokeV.objValue;
    }

    @Override // d.a.q0.n0.c.a
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
            CloudMusicActivityConfig cloudMusicActivityConfig = new CloudMusicActivityConfig(this.f61089g.getPageActivity(), 25032);
            cloudMusicActivityConfig.setCurrentMusicData(this.f61086d);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, cloudMusicActivityConfig));
        }
    }

    @Override // d.a.q0.n0.c.a
    public void c() {
        SelectMusicModel selectMusicModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (selectMusicModel = this.f61083a) == null) {
            return;
        }
        selectMusicModel.cancelLoadData();
    }

    @Override // d.a.q0.n0.c.a
    public void d(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbMusicData) == null) {
            this.f61086d = tbMusicData;
        }
    }

    @Override // d.a.q0.n0.c.a
    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f61088f = false;
            this.f61087e = str;
            n(str, null);
        }
    }

    @Override // d.a.q0.n0.c.a
    public void f(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048581, this, f2) == null) || (mediaPlayer = this.f61084b) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > this.f61084b.getDuration()) {
            f2 %= this.f61084b.getDuration();
        }
        this.f61084b.seekTo((int) (f2 * 1000.0f));
        this.f61084b.start();
    }

    @Override // d.a.q0.n0.c.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f61090h : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f61083a.x();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, musicData) == null) || this.f61088f) {
            return;
        }
        if (this.f61084b == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f61084b = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f61087e = str;
            this.f61084b.reset();
            this.f61084b.setDataSource(str);
            this.f61084b.prepare();
            this.f61084b.setOnPreparedListener(new C1561c(this));
            this.f61084b.setOnErrorListener(new d(this));
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
        MediaPlayer mediaPlayer = this.f61084b;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f61084b.stop();
        }
        this.f61090h = false;
        String str = musicData.id;
        String g2 = d.a.q0.n0.c.d.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof a.C1886a)) {
            this.f61085c = ((a.C1886a) obj).f67629d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof a.C1886a) {
                a.C1886a c1886a = (a.C1886a) obj;
                c1886a.f67627b.setVisibility(0);
                c1886a.f67626a.setDrawBorder(false);
                c1886a.f67626a.invalidate();
                this.f61090h = true;
                d.a.q0.n0.c.d.a.h().f(musicData.id, musicData.resource, new a(this, c1886a, musicData));
                return;
            }
            d.a.q0.n0.c.d.a.h().f(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        n(g2, musicData);
    }

    @Override // d.a.q0.n0.c.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f61088f = true;
            MediaPlayer mediaPlayer = this.f61084b;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f61084b.pause();
        }
    }

    @Override // d.a.q0.n0.c.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f61088f = false;
            MediaPlayer mediaPlayer = this.f61084b;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f61084b.seekTo(0);
            }
        }
    }

    @Override // d.a.q0.n0.c.a
    public void onStopRecord() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (mediaPlayer = this.f61084b) != null && mediaPlayer.isPlaying()) {
            this.f61084b.pause();
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f61087e = null;
            releasePlayer();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                d.a.q0.n0.c.d.a.h().e();
            }
            o(null, musicData);
        }
    }

    @Override // d.a.q0.n0.c.a
    public void releasePlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MediaPlayer mediaPlayer = this.f61084b;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f61084b.stop();
                }
                this.f61084b.release();
                this.f61084b = null;
            }
            this.f61087e = null;
        }
    }

    @Override // d.a.q0.n0.c.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            releasePlayer();
        }
    }
}
