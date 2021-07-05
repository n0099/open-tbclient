package d.a.s0.v3.k;

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
import d.a.s0.v3.h.f.a;
import d.a.s0.v3.k.d;
import d.a.s0.v3.k.i;
import java.io.File;
/* loaded from: classes9.dex */
public class j implements i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f68851e;

    /* renamed from: f  reason: collision with root package name */
    public int f68852f;

    /* renamed from: g  reason: collision with root package name */
    public String f68853g;

    /* renamed from: h  reason: collision with root package name */
    public String f68854h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68855i;
    public Context j;
    public boolean k;
    public d.a.s0.x1.g l;

    /* loaded from: classes9.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f68856a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f68857b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j f68858c;

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
            this.f68858c = jVar;
            this.f68856a = aVar;
            this.f68857b = musicData;
        }

        @Override // d.a.s0.v3.h.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f68856a.f68811d == this.f68858c.f68852f) {
                this.f68858c.k = false;
                this.f68856a.f68809b.setVisibility(4);
                this.f68856a.f68808a.setDrawBorder(true);
                this.f68856a.f68808a.invalidate();
                d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), str);
                if (this.f68858c.l != null) {
                    this.f68858c.l.b(3, str);
                }
            }
        }

        @Override // d.a.s0.v3.h.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f68856a.f68811d == this.f68858c.f68852f) {
                this.f68858c.k = false;
                this.f68856a.f68808a.setDrawBorder(true);
                this.f68856a.f68808a.invalidate();
                this.f68856a.f68809b.setVisibility(4);
            }
        }

        @Override // d.a.s0.v3.h.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f68856a.f68811d == this.f68858c.f68852f) {
                this.f68858c.k = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f68858c.p(str, this.f68857b);
                this.f68856a.f68809b.setVisibility(4);
                this.f68856a.f68808a.setDrawBorder(true);
                this.f68856a.f68808a.invalidate();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f68859a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f68860b;

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
            this.f68860b = jVar;
            this.f68859a = musicData;
        }

        @Override // d.a.s0.v3.h.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), str);
                if (this.f68860b.l != null) {
                    this.f68860b.l.b(3, str);
                }
            }
        }

        @Override // d.a.s0.v3.h.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // d.a.s0.v3.h.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f68860b.p(str, this.f68859a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f68861e;

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
            this.f68861e = jVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f68861e.f68851e.setLooping(true);
                this.f68861e.f68851e.start();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f68862e;

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
            this.f68862e = jVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f68862e.l != null) {
                    d.a.s0.x1.g gVar = this.f68862e.l;
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, d.a.s0.x1.k.class);
        d.a.s0.x1.k kVar = runTask != null ? (d.a.s0.x1.k) runTask.getData() : null;
        if (kVar != null) {
            this.l = kVar.get();
        }
        this.j = activity;
    }

    @Override // d.a.s0.v3.k.i.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    public void g(EditVideoActivityConfig editVideoActivityConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editVideoActivityConfig) == null) || TextUtils.isEmpty(this.f68854h) || TextUtils.isEmpty(this.f68853g)) {
            return;
        }
        editVideoActivityConfig.addMusicInfo(this.f68854h, this.f68853g, this.f68852f);
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68854h : (String) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f68855i = false;
            this.f68854h = str;
            this.f68853g = str2;
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
            this.f68855i = true;
            MediaPlayer mediaPlayer = this.f68851e;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f68851e.pause();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f68855i = false;
            MediaPlayer mediaPlayer = this.f68851e;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f68851e.seekTo(0);
            }
        }
    }

    public void n(int i2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (mediaPlayer = this.f68851e) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.f68851e.getDuration()) {
            i2 %= this.f68851e.getDuration();
        }
        this.f68851e.seekTo(i2);
        this.f68851e.start();
    }

    public void o() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (mediaPlayer = this.f68851e) != null && mediaPlayer.isPlaying()) {
            this.f68851e.pause();
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, str, musicData) == null) || this.f68855i) {
            return;
        }
        if (this.f68851e == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f68851e = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f68854h = str;
            this.f68851e.reset();
            this.f68851e.setDataSource(str);
            this.f68851e.prepare();
            this.f68851e.setOnPreparedListener(new c(this));
            this.f68851e.setOnErrorListener(new d(this));
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
        MediaPlayer mediaPlayer = this.f68851e;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f68851e.stop();
        }
        this.k = false;
        this.f68853g = musicData.id;
        String f2 = d.a.s0.v3.h.f.a.g().f(musicData.resource);
        if (obj != null && (obj instanceof d.a)) {
            this.f68852f = ((d.a) obj).f68811d;
        }
        if (TextUtils.isEmpty(f2)) {
            if (obj instanceof d.a) {
                d.a aVar = (d.a) obj;
                aVar.f68809b.setVisibility(0);
                aVar.f68808a.setDrawBorder(false);
                aVar.f68808a.invalidate();
                this.k = true;
                d.a.s0.v3.h.f.a.g().e(musicData.id, musicData.resource, new a(this, aVar, musicData));
                return;
            }
            d.a.s0.v3.h.f.a.g().e(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        p(f2, musicData);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MediaPlayer mediaPlayer = this.f68851e;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f68851e.stop();
                }
                this.f68851e.release();
                this.f68851e = null;
            }
            this.f68854h = null;
            this.f68853g = null;
        }
    }

    public final void s(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f68854h = null;
            r();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                d.a.s0.v3.h.f.a.g().d();
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
