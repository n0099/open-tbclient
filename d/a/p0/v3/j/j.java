package d.a.p0.v3.j;

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
import d.a.p0.v3.g.f.a;
import d.a.p0.v3.j.d;
import d.a.p0.v3.j.i;
import java.io.File;
/* loaded from: classes8.dex */
public class j implements i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f65635e;

    /* renamed from: f  reason: collision with root package name */
    public int f65636f;

    /* renamed from: g  reason: collision with root package name */
    public String f65637g;

    /* renamed from: h  reason: collision with root package name */
    public String f65638h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65639i;
    public Context j;
    public boolean k;
    public d.a.p0.x1.g l;

    /* loaded from: classes8.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f65640a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f65641b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j f65642c;

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
            this.f65642c = jVar;
            this.f65640a = aVar;
            this.f65641b = musicData;
        }

        @Override // d.a.p0.v3.g.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f65640a.f65595d == this.f65642c.f65636f) {
                this.f65642c.k = false;
                this.f65640a.f65593b.setVisibility(4);
                this.f65640a.f65592a.setDrawBorder(true);
                this.f65640a.f65592a.invalidate();
                d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), str);
                if (this.f65642c.l != null) {
                    this.f65642c.l.b(3, str);
                }
            }
        }

        @Override // d.a.p0.v3.g.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f65640a.f65595d == this.f65642c.f65636f) {
                this.f65642c.k = false;
                this.f65640a.f65592a.setDrawBorder(true);
                this.f65640a.f65592a.invalidate();
                this.f65640a.f65593b.setVisibility(4);
            }
        }

        @Override // d.a.p0.v3.g.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f65640a.f65595d == this.f65642c.f65636f) {
                this.f65642c.k = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f65642c.p(str, this.f65641b);
                this.f65640a.f65593b.setVisibility(4);
                this.f65640a.f65592a.setDrawBorder(true);
                this.f65640a.f65592a.invalidate();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f65643a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f65644b;

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
            this.f65644b = jVar;
            this.f65643a = musicData;
        }

        @Override // d.a.p0.v3.g.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), str);
                if (this.f65644b.l != null) {
                    this.f65644b.l.b(3, str);
                }
            }
        }

        @Override // d.a.p0.v3.g.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // d.a.p0.v3.g.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f65644b.p(str, this.f65643a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f65645e;

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
            this.f65645e = jVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f65645e.f65635e.setLooping(true);
                this.f65645e.f65635e.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f65646e;

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
            this.f65646e = jVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f65646e.l != null) {
                    d.a.p0.x1.g gVar = this.f65646e.l;
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, d.a.p0.x1.k.class);
        d.a.p0.x1.k kVar = runTask != null ? (d.a.p0.x1.k) runTask.getData() : null;
        if (kVar != null) {
            this.l = kVar.get();
        }
        this.j = activity;
    }

    @Override // d.a.p0.v3.j.i.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    public void g(EditVideoActivityConfig editVideoActivityConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editVideoActivityConfig) == null) || TextUtils.isEmpty(this.f65638h) || TextUtils.isEmpty(this.f65637g)) {
            return;
        }
        editVideoActivityConfig.addMusicInfo(this.f65638h, this.f65637g, this.f65636f);
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65638h : (String) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f65639i = false;
            this.f65638h = str;
            this.f65637g = str2;
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
            this.f65639i = true;
            MediaPlayer mediaPlayer = this.f65635e;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f65635e.pause();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f65639i = false;
            MediaPlayer mediaPlayer = this.f65635e;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f65635e.seekTo(0);
            }
        }
    }

    public void n(int i2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (mediaPlayer = this.f65635e) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.f65635e.getDuration()) {
            i2 %= this.f65635e.getDuration();
        }
        this.f65635e.seekTo(i2);
        this.f65635e.start();
    }

    public void o() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (mediaPlayer = this.f65635e) != null && mediaPlayer.isPlaying()) {
            this.f65635e.pause();
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, str, musicData) == null) || this.f65639i) {
            return;
        }
        if (this.f65635e == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f65635e = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f65638h = str;
            this.f65635e.reset();
            this.f65635e.setDataSource(str);
            this.f65635e.prepare();
            this.f65635e.setOnPreparedListener(new c(this));
            this.f65635e.setOnErrorListener(new d(this));
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
        MediaPlayer mediaPlayer = this.f65635e;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f65635e.stop();
        }
        this.k = false;
        this.f65637g = musicData.id;
        String f2 = d.a.p0.v3.g.f.a.g().f(musicData.resource);
        if (obj != null && (obj instanceof d.a)) {
            this.f65636f = ((d.a) obj).f65595d;
        }
        if (TextUtils.isEmpty(f2)) {
            if (obj instanceof d.a) {
                d.a aVar = (d.a) obj;
                aVar.f65593b.setVisibility(0);
                aVar.f65592a.setDrawBorder(false);
                aVar.f65592a.invalidate();
                this.k = true;
                d.a.p0.v3.g.f.a.g().e(musicData.id, musicData.resource, new a(this, aVar, musicData));
                return;
            }
            d.a.p0.v3.g.f.a.g().e(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        p(f2, musicData);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MediaPlayer mediaPlayer = this.f65635e;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f65635e.stop();
                }
                this.f65635e.release();
                this.f65635e = null;
            }
            this.f65638h = null;
            this.f65637g = null;
        }
    }

    public final void s(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f65638h = null;
            r();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                d.a.p0.v3.g.f.a.g().d();
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
