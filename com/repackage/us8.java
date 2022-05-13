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
import com.repackage.cs8;
import com.repackage.ms8;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class us8 extends z8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public HorizontalListView b;
    public Resources c;
    public qs8 d;
    public cs8 e;
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
    public zl7 r;
    public String s;
    public String t;

    /* loaded from: classes7.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us8 a;

        public a(us8 us8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us8Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (this.a.e.b() != i || i == this.a.l) {
                    this.a.m = i;
                    this.a.u(i, view2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ms8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cs8.a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ us8 c;

        public b(us8 us8Var, cs8.a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us8Var, aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = us8Var;
            this.a = aVar;
            this.b = i;
        }

        @Override // com.repackage.ms8.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.b.setVisibility(4);
                mi.N(this.c.mContext.getPageActivity(), str);
                if (this.c.r != null) {
                    this.c.r.a(206, str);
                }
            }
        }

        @Override // com.repackage.ms8.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b.setVisibility(4);
            }
        }

        @Override // com.repackage.ms8.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.a.b.setVisibility(4);
                this.c.F(str, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ms8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ us8 b;

        public c(us8 us8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = us8Var;
            this.a = i;
        }

        @Override // com.repackage.ms8.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                mi.N(this.b.mContext.getPageActivity(), str);
                if (this.b.r != null) {
                    this.b.r.a(206, str);
                }
            }
        }

        @Override // com.repackage.ms8.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.repackage.ms8.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.b.F(str, this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ us8 b;

        public d(us8 us8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = us8Var;
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

    /* loaded from: classes7.dex */
    public class e implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us8 a;

        public e(us8 us8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us8Var;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                if (this.a.r != null) {
                    zl7 zl7Var = this.a.r;
                    zl7Var.a(207, "what-->" + i + "  extra-->" + i2);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ us8 b;

        public f(us8 us8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = us8Var;
            this.a = i;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.b.e.d(this.a);
                this.b.j.setLooping(true);
                this.b.j.start();
                this.b.d.P();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us8 a;

        public g(us8 us8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us8Var;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                if (this.a.r != null) {
                    zl7 zl7Var = this.a.r;
                    zl7Var.a(207, "what-->" + i + "  extra-->" + i2);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us8 a;

        public h(us8 us8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                us8 us8Var = this.a;
                us8Var.N(!us8Var.i);
                this.a.d.W(!this.a.i);
                this.a.K();
                StatisticItem statisticItem = new StatisticItem("c12423");
                statisticItem.param("obj_type", !this.a.i ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us8 a;

        public i(us8 us8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.setSelection(this.a.n);
                this.a.b.v(this.a.m * mi.f(this.a.getPageContext().getContext(), R.dimen.obfuscated_res_0x7f070240));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public us8(b9 b9Var, qs8 qs8Var, zl7 zl7Var) {
        super(b9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var, qs8Var, zl7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = true;
        this.l = 1;
        this.d = qs8Var;
        this.r = zl7Var;
        View inflate = LayoutInflater.from(b9Var.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d024a, (ViewGroup) null);
        this.a = inflate;
        this.c = inflate.getResources();
        z();
    }

    public void A(b9 b9Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, b9Var, i2) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        }
    }

    public void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.o = false;
            int i2 = this.l;
            this.m = i2;
            this.p = str2;
            F(str, i2);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.o = true;
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.j.pause();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.o = false;
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer == null || this.d.l != 2) {
                return;
            }
            mediaPlayer.start();
            this.j.seekTo(0);
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.f.setVisibility(0);
                if (this.q && this.j == null && !TextUtils.isEmpty(this.k)) {
                    F(this.k, this.n);
                    this.q = false;
                    if (this.n > 4) {
                        new Handler().postDelayed(new i(this), 300L);
                        return;
                    }
                    return;
                }
                K();
                return;
            }
            this.f.setVisibility(8);
            C();
        }
    }

    public final void F(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i2) == null) {
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
                    L(str, i2);
                    zl7 zl7Var = this.r;
                    if (zl7Var != null) {
                        zl7Var.a(208, tl7.a(e2));
                    }
                }
            }
        }
    }

    public final void G(int i2, View view2, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048582, this, i2, view2, musicData) == null) || musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        this.p = musicData.id;
        this.d.t();
        String f2 = ms8.g().f(musicData.resource);
        if (!TextUtils.isEmpty(f2)) {
            F(f2, i2);
        } else if (view2 != null) {
            cs8.a aVar = (cs8.a) view2.getTag();
            aVar.b.setVisibility(0);
            ms8.g().e(musicData.id, musicData.resource, new b(this, aVar, i2));
        } else {
            ms8.g().e(musicData.id, musicData.resource, new c(this, i2));
        }
    }

    public final void H(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || li.isEmpty(this.s)) {
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
                L(this.k, i2);
                if (this.r != null) {
                    this.r.a(208, tl7.a(e2));
                }
            }
        } finally {
            this.t = null;
            this.s = null;
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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

    public final void L(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, str, i2) == null) {
            this.k = null;
            I();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                ms8.g().d();
            }
            G(i2, this.b.getChildCount() > i2 ? this.b.getChildAt(i2) : null, (MusicData) this.e.getItem(i2));
        }
    }

    public void M(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.e.f(list);
            cs8 cs8Var = this.e;
            if (cs8Var != null) {
                int b2 = cs8Var.b();
                this.n = b2;
                this.m = b2;
            }
            Q();
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.i = z;
            if (z) {
                this.g.setSelected(false);
                this.h.setText(this.c.getString(R.string.obfuscated_res_0x7f0f152e));
                return;
            }
            this.g.setSelected(true);
            this.h.setText(this.c.getString(R.string.obfuscated_res_0x7f0f152d));
        }
    }

    public void O(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, intent) == null) || intent == null || intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) == null || intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) == null) {
            return;
        }
        this.q = true;
        this.p = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
        this.k = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
        cs8 cs8Var = this.e;
        if (cs8Var != null) {
            cs8Var.e(this.p);
            int b2 = this.e.b();
            this.n = b2;
            this.l = b2;
            this.m = b2;
        }
    }

    public void P(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.s = str;
            this.t = str2;
            Q();
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || li.isEmpty(this.t) || li.isEmpty(this.s)) {
            return;
        }
        List<MusicData> c2 = this.e.c();
        if (ListUtils.isEmpty(c2)) {
            return;
        }
        for (int i2 = 0; i2 < c2.size(); i2++) {
            if (c2.get(i2) != null && StringHelper.equals(c2.get(i2).id, this.t)) {
                H(i2);
                return;
            }
        }
        H(1);
    }

    public final void u(int i2, View view2) {
        MusicData musicData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048592, this, i2, view2) == null) || (musicData = (MusicData) this.e.getItem(i2)) == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12423");
        statisticItem.param("obj_id", musicData.id);
        statisticItem.param("obj_locate", i2 + 1);
        statisticItem.param("obj_source", 2);
        TiebaStatic.log(statisticItem);
        int i3 = musicData.editMusicType;
        if (i3 == 0) {
            G(i2, view2, musicData);
        } else if (i3 == 1) {
            this.e.d(i2);
            I();
            this.d.P();
        } else if (i3 != 2) {
        } else {
            this.l = i2;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
        }
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void y(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0923ce);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923d0);
            this.f.setVisibility(8);
            this.f.setOnClickListener(new h(this));
            N(this.i);
            this.d.W(!this.i);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.b = (HorizontalListView) this.a.findViewById(R.id.obfuscated_res_0x7f090da0);
            cs8 cs8Var = new cs8(this.mContext);
            this.e = cs8Var;
            this.b.setAdapter((ListAdapter) cs8Var);
            this.b.setOnItemClickListener(new a(this));
        }
    }
}
