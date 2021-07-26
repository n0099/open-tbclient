package d.a.q0.v3.l;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.v3.i.f.a;
import d.a.q0.v3.l.d;
import d.a.q0.v3.l.i;
import java.io.File;
/* loaded from: classes8.dex */
public class j implements i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f66292e;

    /* renamed from: f  reason: collision with root package name */
    public int f66293f;

    /* renamed from: g  reason: collision with root package name */
    public String f66294g;

    /* renamed from: h  reason: collision with root package name */
    public String f66295h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66296i;
    public Context j;
    public boolean k;
    public d.a.q0.x1.g l;

    /* loaded from: classes8.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f66297a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f66298b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j f66299c;

        public a(j jVar, d.a aVar, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, aVar, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66299c = jVar;
            this.f66297a = aVar;
            this.f66298b = musicData;
        }

        @Override // d.a.q0.v3.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f66297a.f66252d == this.f66299c.f66293f) {
                this.f66299c.k = false;
                this.f66297a.f66250b.setVisibility(4);
                this.f66297a.f66249a.setDrawBorder(true);
                this.f66297a.f66249a.invalidate();
                d.a.d.e.p.l.M(TbadkCoreApplication.getInst(), str);
                if (this.f66299c.l != null) {
                    this.f66299c.l.b(3, str);
                }
            }
        }

        @Override // d.a.q0.v3.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f66297a.f66252d == this.f66299c.f66293f) {
                this.f66299c.k = false;
                this.f66297a.f66249a.setDrawBorder(true);
                this.f66297a.f66249a.invalidate();
                this.f66297a.f66250b.setVisibility(4);
            }
        }

        @Override // d.a.q0.v3.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f66297a.f66252d == this.f66299c.f66293f) {
                this.f66299c.k = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f66299c.p(str, this.f66298b);
                this.f66297a.f66250b.setVisibility(4);
                this.f66297a.f66249a.setDrawBorder(true);
                this.f66297a.f66249a.invalidate();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f66300a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f66301b;

        public b(j jVar, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66301b = jVar;
            this.f66300a = musicData;
        }

        @Override // d.a.q0.v3.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.d.e.p.l.M(TbadkCoreApplication.getInst(), str);
                if (this.f66301b.l != null) {
                    this.f66301b.l.b(3, str);
                }
            }
        }

        @Override // d.a.q0.v3.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // d.a.q0.v3.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f66301b.p(str, this.f66300a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f66302e;

        public c(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66302e = jVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f66302e.f66292e.setLooping(true);
                this.f66302e.f66292e.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f66303e;

        public d(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66303e = jVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f66303e.l != null) {
                    d.a.q0.x1.g gVar = this.f66303e.l;
                    gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public j(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, d.a.q0.x1.k.class);
        d.a.q0.x1.k kVar = runTask != null ? (d.a.q0.x1.k) runTask.getData() : null;
        if (kVar != null) {
            this.l = kVar.get();
        }
        this.j = activity;
    }

    @Override // d.a.q0.v3.l.i.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    public void g(EditVideoActivityConfig editVideoActivityConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editVideoActivityConfig) == null) || TextUtils.isEmpty(this.f66295h) || TextUtils.isEmpty(this.f66294g)) {
            return;
        }
        editVideoActivityConfig.addMusicInfo(this.f66295h, this.f66294g, this.f66293f);
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66295h : (String) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f66296i = false;
            this.f66295h = str;
            this.f66294g = str2;
            p(str, null);
        }
    }

    public void k(MusicData musicData, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, musicData, obj) == null) || musicData == null) {
            return;
        }
        int i2 = musicData.editMusicType;
        if (i2 == 0) {
            q(obj, musicData);
        } else if (i2 == 1) {
            r();
        } else if (i2 != 2) {
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.j, 25032)));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f66296i = true;
            MediaPlayer mediaPlayer = this.f66292e;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f66292e.pause();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f66296i = false;
            MediaPlayer mediaPlayer = this.f66292e;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f66292e.seekTo(0);
            }
        }
    }

    public void n(int i2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (mediaPlayer = this.f66292e) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.f66292e.getDuration()) {
            i2 %= this.f66292e.getDuration();
        }
        this.f66292e.seekTo(i2);
        this.f66292e.start();
    }

    public void o() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (mediaPlayer = this.f66292e) != null && mediaPlayer.isPlaying()) {
            this.f66292e.pause();
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, str, musicData) == null) || this.f66296i) {
            return;
        }
        if (this.f66292e == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f66292e = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f66295h = str;
            this.f66292e.reset();
            this.f66292e.setDataSource(str);
            this.f66292e.prepare();
            this.f66292e.setOnPreparedListener(new c(this));
            this.f66292e.setOnErrorListener(new d(this));
        } catch (Exception e2) {
            e2.printStackTrace();
            s(str, musicData);
        }
    }

    public final void q(Object obj, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, obj, musicData) == null) || musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        MediaPlayer mediaPlayer = this.f66292e;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f66292e.stop();
        }
        this.k = false;
        this.f66294g = musicData.id;
        String f2 = d.a.q0.v3.i.f.a.g().f(musicData.resource);
        if (obj != null && (obj instanceof d.a)) {
            this.f66293f = ((d.a) obj).f66252d;
        }
        if (TextUtils.isEmpty(f2)) {
            if (obj instanceof d.a) {
                d.a aVar = (d.a) obj;
                aVar.f66250b.setVisibility(0);
                aVar.f66249a.setDrawBorder(false);
                aVar.f66249a.invalidate();
                this.k = true;
                d.a.q0.v3.i.f.a.g().e(musicData.id, musicData.resource, new a(this, aVar, musicData));
                return;
            }
            d.a.q0.v3.i.f.a.g().e(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        p(f2, musicData);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MediaPlayer mediaPlayer = this.f66292e;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f66292e.stop();
                }
                this.f66292e.release();
                this.f66292e = null;
            }
            this.f66295h = null;
            this.f66294g = null;
        }
    }

    public final void s(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f66295h = null;
            r();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                d.a.q0.v3.i.f.a.g().d();
            }
            q(null, musicData);
        }
    }

    public void t(SelectMusicModel selectMusicModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, selectMusicModel) == null) {
        }
    }
}
