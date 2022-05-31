package com.repackage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class dq5 extends yp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TbVideoViewContainer g;
    public ImageView h;
    public TbImageView i;
    public TextView j;
    public VideoInfo k;
    public String l;
    public String m;
    public long n;
    public String o;
    public y48 p;

    /* loaded from: classes5.dex */
    public class a implements y48 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq5 a;

        public a(dq5 dq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq5Var;
        }

        @Override // com.repackage.y48
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.repackage.y48
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.y48
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.repackage.y48
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.y48
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.y48
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.y48
        public boolean onBackground(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.a.s();
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) == null) {
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i, i2, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.a.s();
            }
        }

        @Override // com.repackage.y48
        public void onScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        @Override // com.repackage.y48
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.y48
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // com.repackage.y48
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // com.repackage.y48
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // com.repackage.y48
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // com.repackage.y48
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // com.repackage.y48
        public void setStatistic(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, t48Var) == null) {
            }
        }

        @Override // com.repackage.y48
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // com.repackage.y48
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // com.repackage.y48
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq5 a;

        public b(dq5 dq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || TextUtils.isEmpty(this.a.d.b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            dq5 dq5Var = this.a;
            urlManager.dealOneLink(dq5Var.c, new String[]{dq5Var.d.b}, true);
            zo5 c = zo5.c();
            dq5 dq5Var2 = this.a;
            c.f("c12909", dq5Var2.d.e, 2, dq5Var2.m, this.a.n, this.a.o, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dq5(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
    }

    @Override // com.repackage.yp5
    public void b(mp5 mp5Var) {
        String title;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mp5Var) == null) {
            super.b(mp5Var);
            if (!ListUtils.isEmpty(this.d.c) && this.d.c.get(0) != null) {
                this.k = this.d.c.get(0).getThreadVideoInfo();
                this.m = this.d.c.get(0).getId();
                this.n = this.d.c.get(0).getFid();
                this.o = this.d.c.get(0).getForum_name();
            }
            VideoInfo videoInfo = this.k;
            if (videoInfo != null) {
                this.i.K(videoInfo.thumbnail_url, 10, false);
                if (!TextUtils.isEmpty(this.d.c.get(0).getSpan_str())) {
                    title = this.d.c.get(0).getSpan_str().toString();
                } else {
                    title = this.d.c.get(0).getTitle();
                }
                if (!TextUtils.isEmpty(title)) {
                    this.j.setText(title);
                }
                this.l = this.k.video_url;
                zo5.c().f("c12908", this.d.e, 2, this.m, this.n, this.o, null);
            }
        }
    }

    @Override // com.repackage.yp5
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    @Override // com.repackage.yp5
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f = LayoutInflater.from(this.c.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0775, (ViewGroup) null);
            this.f.setLayoutParams(new FrameLayout.LayoutParams(this.a, this.b));
            TbVideoViewContainer tbVideoViewContainer = (TbVideoViewContainer) this.f.findViewById(R.id.obfuscated_res_0x7f092372);
            this.g = tbVideoViewContainer;
            tbVideoViewContainer.getControl().setOperableVideoContainer(this.p);
            this.g.getControl().setStageType(null);
            this.h = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f092336);
            TbImageView tbImageView = (TbImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0922fa);
            this.i = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.j = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f092368);
            this.f.setOnClickListener(new b(this));
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.repackage.yp5
    public boolean f(mp5 mp5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mp5Var)) == null) ? (mp5Var == null || 2 != mp5Var.d || TextUtils.isEmpty(mp5Var.a)) ? false : true : invokeL.booleanValue;
    }

    @Override // com.repackage.yp5
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    @Override // com.repackage.yp5
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams.width = this.a;
            layoutParams.height = this.b;
            this.f.setLayoutParams(layoutParams);
        }
    }

    @Override // com.repackage.yp5
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0111);
        }
    }

    @Override // com.repackage.yp5
    public void j() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tbVideoViewContainer = this.g) == null) {
            return;
        }
        tbVideoViewContainer.getControl().stopPlayback();
        this.g.a();
        this.g = null;
    }

    @Override // com.repackage.yp5
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.g;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl().isPlaying()) {
                this.h.setVisibility(0);
                this.g.getControl().pause();
            }
        }
    }

    @Override // com.repackage.yp5
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.g;
            if (tbVideoViewContainer == null || !tbVideoViewContainer.getControl().isPlaying()) {
                this.h.setVisibility(8);
                this.g.getControl().start();
            }
        }
    }

    @Override // com.repackage.yp5
    public void m() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbVideoViewContainer = this.g) == null || tbVideoViewContainer.getControl().isPlaying()) {
            return;
        }
        this.i.setVisibility(0);
        if (TextUtils.isEmpty(this.l) || !xc5.b(1, this.l)) {
            return;
        }
        this.g.getControl().setVideoPath(this.l);
        this.g.getControl().setLooping(true);
    }

    @Override // com.repackage.yp5
    public void n() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (tbVideoViewContainer = this.g) == null) {
            return;
        }
        tbVideoViewContainer.getControl().stopPlayback();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            zo5.c().f("c12910", this.d.e, 2, this.m, this.n, this.o, null);
            this.i.setVisibility(8);
            this.h.setVisibility(8);
            TbVideoViewContainer tbVideoViewContainer = this.g;
            if (tbVideoViewContainer != null) {
                tbVideoViewContainer.getControl().setVolume(0.0f, 0.0f);
                try {
                    this.g.getControl().start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
