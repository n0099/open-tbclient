package com.repackage;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iq8;
import com.repackage.sq8;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class ar8 extends b9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public HorizontalListView b;
    public Resources c;
    public wq8 d;
    public iq8 e;
    public LinearLayout f;
    public ImageView g;
    public TextView h;
    public boolean i;
    public MediaPlayer j;
    public String k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public String p;
    public boolean q;
    public kl7 r;
    public String s;
    public String t;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ar8 a;

        public a(ar8 ar8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ar8Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (this.a.e.b() != i || i == this.a.l) {
                    this.a.m = i;
                    this.a.v(i, view2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements sq8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iq8.a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ar8 c;

        public b(ar8 ar8Var, iq8.a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar8Var, aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ar8Var;
            this.a = aVar;
            this.b = i;
        }

        @Override // com.repackage.sq8.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.b.setVisibility(4);
                pi.O(this.c.mContext.getPageActivity(), str);
                if (this.c.r != null) {
                    this.c.r.a(206, str);
                }
            }
        }

        @Override // com.repackage.sq8.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b.setVisibility(4);
            }
        }

        @Override // com.repackage.sq8.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.a.b.setVisibility(4);
                this.c.G(str, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements sq8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ar8 b;

        public c(ar8 ar8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ar8Var;
            this.a = i;
        }

        @Override // com.repackage.sq8.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                pi.O(this.b.mContext.getPageActivity(), str);
                if (this.b.r != null) {
                    this.b.r.a(206, str);
                }
            }
        }

        @Override // com.repackage.sq8.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.repackage.sq8.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.b.G(str, this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ar8 b;

        public d(ar8 ar8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ar8Var;
            this.a = i;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.b.e.d(this.a);
                this.b.j.setLooping(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ar8 a;

        public e(ar8 ar8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ar8Var;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                if (this.a.r != null) {
                    kl7 kl7Var = this.a.r;
                    kl7Var.a(207, "what-->" + i + "  extra-->" + i2);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ar8 b;

        public f(ar8 ar8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ar8Var;
            this.a = i;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.b.e.d(this.a);
                this.b.j.setLooping(true);
                this.b.j.start();
                this.b.d.Q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ar8 a;

        public g(ar8 ar8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ar8Var;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                if (this.a.r != null) {
                    kl7 kl7Var = this.a.r;
                    kl7Var.a(207, "what-->" + i + "  extra-->" + i2);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ar8 a;

        public h(ar8 ar8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ar8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ar8 ar8Var = this.a;
                ar8Var.O(!ar8Var.i);
                this.a.d.W(!this.a.i);
                this.a.L();
                StatisticItem statisticItem = new StatisticItem("c12423");
                statisticItem.param("obj_type", !this.a.i ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ar8 a;

        public i(ar8 ar8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ar8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.setSelection(this.a.n);
                this.a.b.v(this.a.m * pi.f(this.a.getPageContext().getContext(), R.dimen.obfuscated_res_0x7f07023f));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar8(d9 d9Var, wq8 wq8Var, kl7 kl7Var) {
        super(d9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var, wq8Var, kl7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = true;
        this.l = 1;
        this.d = wq8Var;
        this.r = kl7Var;
        View inflate = LayoutInflater.from(d9Var.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0241, (ViewGroup) null);
        this.a = inflate;
        this.c = inflate.getResources();
        A();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = (HorizontalListView) this.a.findViewById(R.id.obfuscated_res_0x7f090d63);
            iq8 iq8Var = new iq8(this.mContext);
            this.e = iq8Var;
            this.b.setAdapter((ListAdapter) iq8Var);
            this.b.setOnItemClickListener(new a(this));
        }
    }

    public void B(d9 d9Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d9Var, i2) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        }
    }

    public void C(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.o = false;
            int i2 = this.l;
            this.m = i2;
            this.p = str2;
            G(str, i2);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.o = true;
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.j.pause();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.o = false;
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer == null || this.d.l != 2) {
                return;
            }
            mediaPlayer.start();
            this.j.seekTo(0);
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.f.setVisibility(0);
                if (this.q && this.j == null && !TextUtils.isEmpty(this.k)) {
                    G(this.k, this.n);
                    this.q = false;
                    if (this.n > 4) {
                        new Handler().postDelayed(new i(this), 300L);
                        return;
                    }
                    return;
                }
                L();
                return;
            }
            this.f.setVisibility(8);
            D();
        }
    }

    public final void G(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            this.n = i2;
            if (this.m == i2 && !this.o) {
                if (this.j == null) {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    this.j = mediaPlayer;
                    mediaPlayer.setAudioStreamType(3);
                }
                try {
                    this.k = str;
                    this.j.reset();
                    this.j.setDataSource(str);
                    this.j.prepare();
                    this.j.setOnPreparedListener(new f(this, i2));
                    this.j.setOnErrorListener(new g(this));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    M(str, i2);
                    kl7 kl7Var = this.r;
                    if (kl7Var != null) {
                        kl7Var.a(208, el7.a(e2));
                    }
                }
            }
        }
    }

    public final void H(int i2, View view2, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048583, this, i2, view2, musicData) == null) || musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        this.p = musicData.id;
        this.d.u();
        String f2 = sq8.g().f(musicData.resource);
        if (!TextUtils.isEmpty(f2)) {
            G(f2, i2);
        } else if (view2 != null) {
            iq8.a aVar = (iq8.a) view2.getTag();
            aVar.b.setVisibility(0);
            sq8.g().e(musicData.id, musicData.resource, new b(this, aVar, i2));
        } else {
            sq8.g().e(musicData.id, musicData.resource, new c(this, i2));
        }
    }

    public final void I(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || oi.isEmpty(this.s)) {
            return;
        }
        this.n = i2;
        if (this.j == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.j = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            try {
                this.p = this.t;
                this.k = this.s;
                this.j.reset();
                this.j.setDataSource(this.s);
                this.j.prepare();
                this.j.setOnPreparedListener(new d(this, i2));
                this.j.setOnErrorListener(new e(this));
            } catch (Exception e2) {
                e2.printStackTrace();
                M(this.k, i2);
                if (this.r != null) {
                    this.r.a(208, el7.a(e2));
                }
            }
        } finally {
            this.t = null;
            this.s = null;
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.j.stop();
                }
                this.j.release();
                this.j = null;
            }
            this.k = null;
            this.p = null;
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o = false;
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.j.pause();
            }
            MediaPlayer mediaPlayer2 = this.j;
            if (mediaPlayer2 != null) {
                mediaPlayer2.start();
                this.j.seekTo(0);
            }
        }
    }

    public final void M(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, str, i2) == null) {
            this.k = null;
            J();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                sq8.g().d();
            }
            H(i2, this.b.getChildCount() > i2 ? this.b.getChildAt(i2) : null, (MusicData) this.e.getItem(i2));
        }
    }

    public void N(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.e.f(list);
            iq8 iq8Var = this.e;
            if (iq8Var != null) {
                int b2 = iq8Var.b();
                this.n = b2;
                this.m = b2;
            }
            R();
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.i = z;
            if (z) {
                this.g.setSelected(false);
                this.h.setText(this.c.getString(R.string.obfuscated_res_0x7f0f1546));
                return;
            }
            this.g.setSelected(true);
            this.h.setText(this.c.getString(R.string.obfuscated_res_0x7f0f1545));
        }
    }

    public void P(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, intent) == null) || intent == null || intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) == null || intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) == null) {
            return;
        }
        this.q = true;
        this.p = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
        this.k = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
        iq8 iq8Var = this.e;
        if (iq8Var != null) {
            iq8Var.e(this.p);
            int b2 = this.e.b();
            this.n = b2;
            this.l = b2;
            this.m = b2;
        }
    }

    public void Q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            this.s = str;
            this.t = str2;
            R();
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || oi.isEmpty(this.t) || oi.isEmpty(this.s)) {
            return;
        }
        List<MusicData> c2 = this.e.c();
        if (ListUtils.isEmpty(c2)) {
            return;
        }
        for (int i2 = 0; i2 < c2.size(); i2++) {
            if (c2.get(i2) != null && StringHelper.equals(c2.get(i2).id, this.t)) {
                I(i2);
                return;
            }
        }
        I(1);
    }

    public final void v(int i2, View view2) {
        MusicData musicData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048593, this, i2, view2) == null) || (musicData = (MusicData) this.e.getItem(i2)) == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12423");
        statisticItem.param("obj_id", musicData.id);
        statisticItem.param("obj_locate", i2 + 1);
        statisticItem.param("obj_source", 2);
        TiebaStatic.log(statisticItem);
        int i3 = musicData.editMusicType;
        if (i3 == 0) {
            H(i2, view2, musicData);
        } else if (i3 == 1) {
            this.e.d(i2);
            J();
            this.d.Q();
        } else if (i3 != 2) {
        } else {
            this.l = i2;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
        }
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void z(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092409);
            this.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092408);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09240a);
            this.f.setVisibility(8);
            this.f.setOnClickListener(new h(this));
            O(this.i);
            this.d.W(!this.i);
        }
    }
}
