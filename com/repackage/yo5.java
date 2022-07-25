package com.repackage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.toplivecard.AlaSquareLiveVideoMask;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f68;
/* loaded from: classes7.dex */
public class yo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrameLayout b;
    public AlaSquareLiveVideoMask c;
    public TbVideoViewContainer d;
    public e68 e;
    public f68 f;
    public vo5 g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public String m;
    public boolean n;
    public e o;
    public int p;
    public TbVideoViewContainer.a q;
    public x68 r;
    public View.OnClickListener s;

    /* loaded from: classes7.dex */
    public class a implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yo5 a;

        public a(yo5 yo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yo5Var;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements x68 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yo5 a;

        public b(yo5 yo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yo5Var;
        }

        @Override // com.repackage.x68
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.repackage.x68
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.x68
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.repackage.x68
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.x68
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.x68
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.x68
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
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) == null) {
                this.a.s(false);
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
            if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.a.e == null) {
                return;
            }
            this.a.e.setLooping(false);
            this.a.e.setVolume(0.0f, 0.0f);
            if (this.a.g != null && this.a.g.a != null) {
                if (this.a.n) {
                    if (this.a.o != null) {
                        this.a.o.b(this.a.g.a);
                    }
                } else {
                    StatisticItem statisticItem = new StatisticItem("c12646");
                    if (this.a.g.b != 0) {
                        if (this.a.g.b == 1) {
                            statisticItem.param("obj_type", 2);
                        }
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    statisticItem.param("tid", this.a.g.a.getTid());
                    TiebaStatic.log(statisticItem);
                }
            }
            if (this.a.e.getPlayerWidth() != 0) {
                yo5 yo5Var = this.a;
                yo5Var.v(yo5Var.e.getPlayerHeight(), this.a.e.getPlayerWidth());
            }
            if (this.a.c != null) {
                this.a.c.d();
            }
        }

        @Override // com.repackage.x68
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

        @Override // com.repackage.x68
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.x68
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // com.repackage.x68
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // com.repackage.x68
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // com.repackage.x68
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // com.repackage.x68
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // com.repackage.x68
        public void setStatistic(s68 s68Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, s68Var) == null) {
            }
        }

        @Override // com.repackage.x68
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // com.repackage.x68
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // com.repackage.x68
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements f68.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(yo5 yo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.f68.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yo5 a;

        public d(yo5 yo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yo5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g == null || this.a.g.a == null) {
                return;
            }
            if (this.a.o != null) {
                this.a.o.a(this.a.g.a);
            }
            if (this.a.g.a != null && this.a.g.a.getThreadAlaInfo() != null && this.a.g.a.getThreadAlaInfo().isLegalYYLiveData()) {
                AlaInfoData threadAlaInfo = this.a.g.a.getThreadAlaInfo();
                TbPageContext tbPageContext = this.a.a;
                YyExtData yyExtData = threadAlaInfo.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + threadAlaInfo.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_TOP_PLAY);
                return;
            }
            yo5 yo5Var = this.a;
            yo5Var.l(yo5Var.a, this.a.g.a);
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(ThreadData threadData);

        void b(ThreadData threadData);
    }

    public yo5(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.m = "";
        this.n = false;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new d(this);
        this.a = tbPageContext;
        k();
    }

    public final void i() {
        vo5 vo5Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (vo5Var = this.g) == null || (threadData = vo5Var.a) == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        TbVideoViewContainer tbVideoViewContainer = this.d;
        if (tbVideoViewContainer != null && tbVideoViewContainer.getParent() != null) {
            q();
        }
        this.f = new f68();
        TbVideoViewContainer tbVideoViewContainer2 = new TbVideoViewContainer(this.a.getPageActivity());
        this.d = tbVideoViewContainer2;
        e68 control = tbVideoViewContainer2.getControl();
        this.e = control;
        control.setOperableVideoContainer(this.r);
        this.e.setOnSurfaceDestroyedListener(this.q);
        this.e.setVolume(0.0f, 0.0f);
        this.e.setStageType(null);
        this.f.l(this.e);
        this.f.k(new c(this));
        if (this.d.getParent() == null) {
            this.b.addView(this.d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.g.a.getThreadAlaInfo().screen_direction);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public final void k() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.a) == null) {
            return;
        }
        this.b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0612, (ViewGroup) null);
        this.i = pi.k(this.a.getPageActivity());
        int i = pi.i(this.a.getPageActivity());
        this.j = i;
        int i2 = this.i;
        this.k = (int) ((i2 / 16.0d) * 9.0d);
        int i3 = (int) ((i2 / 4.0d) * 3.0d);
        this.l = i3;
        this.p = (int) ((i / 3.0d) - (i3 / 2.0d));
        this.c = (AlaSquareLiveVideoMask) this.b.findViewById(R.id.obfuscated_res_0x7f0923b8);
        this.b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, ThreadData threadData) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, threadData) == null) || tbPageContext == null || threadData == null || threadData.getAuthor() == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        vo5 vo5Var = this.g;
        if (vo5Var != null && vo5Var.a != null && !this.n) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i = this.g.b;
            if (i == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.g.a.getTid());
            TiebaStatic.log(statisticItem);
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = threadData.getAuthor().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        String str2 = this.n ? AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_TAB_TOP_LIVE : AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_RECOMMEND_TOP_CARD;
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
        alaLiveInfoCoreData.userName = threadData.getThreadAlaInfo().user_info.user_name;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str2, str, z, "")));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i = pi.k(this.a.getPageActivity());
            int i = pi.i(this.a.getPageActivity());
            this.j = i;
            int i2 = this.i;
            this.k = (int) ((i2 / 16.0d) * 9.0d);
            int i3 = (int) ((i2 / 4.0d) * 3.0d);
            this.l = i3;
            this.p = (int) ((i / 3.0d) - (i3 / 2.0d));
            if (this.g != null) {
                e68 e68Var = this.e;
                boolean isPlaying = e68Var == null ? false : e68Var.isPlaying();
                t(this.g.a.getThreadAlaInfo().screen_direction);
                u(this.g.a.getThreadAlaInfo().screen_direction);
                r();
                if (isPlaying) {
                    x(this.m);
                }
            }
        }
    }

    public void n(vo5 vo5Var) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, vo5Var) == null) || vo5Var == null || (threadData = vo5Var.a) == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        vo5 vo5Var2 = this.g;
        if (vo5Var2 == null || ((threadData2 = vo5Var2.a) != null && !threadData2.getTid().equals(vo5Var.a.getTid()))) {
            t(vo5Var.a.getThreadAlaInfo().screen_direction);
        }
        this.g = vo5Var;
        this.h = vo5Var.a.getThreadAlaInfo().screen_direction;
        this.c.setData(this.g.a);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.b();
            }
            SkinManager.setBackgroundColor(this.d, R.color.black_alpha100);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q();
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.c();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            f68 f68Var = this.f;
            if (f68Var != null) {
                f68Var.l(null);
                this.f.n();
                this.f = null;
            }
            e68 e68Var = this.e;
            if (e68Var != null) {
                e68Var.stopPlayback();
                this.d.a();
                if (this.e.getMediaProgressObserver() != null) {
                    this.e.getMediaProgressObserver().l(null);
                    this.e.getMediaProgressObserver().n();
                }
                this.e = null;
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            s(true);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                q();
            }
            e68 e68Var = this.e;
            if (e68Var != null) {
                e68Var.stopPlayback();
            }
            this.c.f();
            this.c.e();
        }
    }

    public final void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i == 1) {
                if (this.n) {
                    if (this.b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
                        layoutParams.width = this.i;
                        layoutParams.height = this.l;
                        this.b.setLayoutParams(layoutParams);
                        return;
                    }
                    this.b.setLayoutParams(new FrameLayout.LayoutParams(this.i, this.l));
                    return;
                } else if (this.b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.b.getLayoutParams();
                    int i2 = this.i;
                    layoutParams2.width = i2;
                    layoutParams2.height = i2;
                    this.b.setLayoutParams(layoutParams2);
                    return;
                } else {
                    FrameLayout frameLayout = this.b;
                    int i3 = this.i;
                    frameLayout.setLayoutParams(new AbsListView.LayoutParams(i3, i3));
                    return;
                }
            }
            this.h = 2;
            if (this.n) {
                if (this.b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.b.getLayoutParams();
                    layoutParams3.width = this.i;
                    layoutParams3.height = this.k;
                    this.b.setLayoutParams(layoutParams3);
                    return;
                }
                this.b.setLayoutParams(new AbsListView.LayoutParams(this.i, this.k));
            } else if (this.b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.b.getLayoutParams();
                layoutParams4.width = this.i;
                layoutParams4.height = this.k;
                this.b.setLayoutParams(layoutParams4);
            } else {
                this.b.setLayoutParams(new AbsListView.LayoutParams(this.i, this.k));
            }
        }
    }

    public final void u(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || this.e == null) {
            return;
        }
        if (i == 1) {
            if (this.d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.d.getLayoutParams();
                layoutParams.width = this.i;
                layoutParams.height = this.j;
                layoutParams.topMargin = -this.p;
                this.d.setLayoutParams(layoutParams);
                return;
            }
            this.d.setLayoutParams(new FrameLayout.LayoutParams(this.i, this.j));
        } else if (this.d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams2.width = this.i;
            layoutParams2.height = this.k;
            this.d.setLayoutParams(layoutParams2);
        } else {
            this.d.setLayoutParams(new FrameLayout.LayoutParams(this.i, this.k));
        }
    }

    public final void v(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) || this.h != 1 || this.e == null || this.d.getParent() == null) {
            return;
        }
        float f = i;
        float f2 = i2;
        float f3 = f / f2;
        int i3 = this.i;
        float f4 = i3 * f;
        int i4 = this.j;
        float f5 = f4 / i4;
        if (f5 < f2) {
            i3 = (int) (i4 / f3);
        } else if (f5 > f2) {
            i4 = (int) (i3 * f3);
        }
        if (this.d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.d.setLayoutParams(layoutParams);
            return;
        }
        this.d.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
    }

    public void w(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.o = eVar;
        }
    }

    public void x(String str) {
        vo5 vo5Var;
        ThreadData threadData;
        e68 e68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || StringUtils.isNull(str) || (vo5Var = this.g) == null || (threadData = vo5Var.a) == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        if (!str.equals(this.m) || ((e68Var = this.e) != null && !e68Var.isPlaying())) {
            this.m = str;
            r();
        }
        if (this.e == null) {
            i();
        }
        e68 e68Var2 = this.e;
        if (e68Var2 == null || e68Var2.isPlaying()) {
            return;
        }
        s68 s68Var = new s68();
        s68Var.a = "9";
        s68Var.d = String.valueOf(this.g.a.getFid());
        s68Var.c = this.g.a.getTid();
        this.e.setVideoStatData(s68Var);
        e68 e68Var3 = this.e;
        if (e68Var3 != null) {
            e68Var3.setVideoPath(this.g.a.getThreadAlaInfo().hls_url);
        }
        e68 e68Var4 = this.e;
        if (e68Var4 != null) {
            e68Var4.start();
        }
        f68 f68Var = this.f;
        if (f68Var != null) {
            f68Var.m();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public yo5(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = z;
        this.c.setFromSpecialForum(z);
    }
}
