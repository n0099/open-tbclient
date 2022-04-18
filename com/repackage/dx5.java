package com.repackage;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.z68;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class dx5 extends tw5<gy5> implements View.OnClickListener, pi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public View B;
    public TextView C;
    public View D;
    public j78 E;
    public gy5 F;
    public View G;
    public int H;
    public int I;
    public boolean J;
    public boolean K;
    public String L;
    public z68 M;
    public Animation N;
    public TextView O;
    public TextView P;
    public Handler Q;
    public Runnable R;
    public Runnable S;
    public final View.OnClickListener T;
    public final View.OnClickListener U;
    public wp i;
    public ThreadCommentAndPraiseInfoLayout j;
    public View k;
    public FrameLayout l;
    public ThreadGodReplyLayout m;
    public NEGFeedBackView n;
    public String o;
    public ThreadSourceShareAndPraiseLayout p;
    public TbPageContext<?> q;
    public RelativeLayout r;
    public TextView s;
    public ThreadUserInfoLayout t;
    public HeadPendantClickableView u;
    public TbImageView v;
    public ImageView w;
    public TbVideoViewContainer x;
    public TextView y;
    public LinearLayout z;

    /* loaded from: classes5.dex */
    public class a extends ff5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dx5 dx5Var, int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx5Var, Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = str2;
        }

        @Override // com.repackage.ff5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ul4.v(TbadkCoreApplication.getInst().getApplicationContext(), false, this.h);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "0"));
            }
        }

        @Override // com.repackage.ff5, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements z68.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx5 a;

        public b(dx5 dx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx5Var;
        }

        @Override // com.repackage.z68.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (i2 >= i) {
                    this.a.i.E(false, false, "HOME");
                } else if (i == 0 || (i2 * 100) / i < 80 || i <= 15000) {
                } else {
                    dx5 dx5Var = this.a;
                    dx5Var.N(dx5Var.F);
                }
            }
        }
    }

    public final void A(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            gy5 gy5Var = this.F;
            if (gy5Var != null) {
                gy5Var.f = 1;
            }
            if (e() != null) {
                e().a(view2, this.F);
            }
            gy5 gy5Var2 = this.F;
            if (gy5Var2 == null || gy5Var2.a == null) {
                return;
            }
            if (!E()) {
                ex5.a(this.F.a.getId());
                ex5.l(this.s, this.F.a.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.q.getPageActivity()).createFromThreadCfg(this.F.a, null, ex5.g(), 18003, true, false, false).addLocateParam(this.F.getPbInputLocate());
            addLocateParam.setVideo_source(this.F.T == 0 ? "index" : "hot_juhe");
            if (this.F.T == 0) {
                addLocateParam.setFrom("from_personalize");
            }
            addLocateParam.setForumId(String.valueOf(this.F.a.getFid()));
            addLocateParam.setForumName(this.F.a.getForum_name());
            addLocateParam.setStartFrom(this.h);
            if (view2 == this.m) {
                addLocateParam.setJumpGodReply(true);
            }
            this.q.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    public final void B() {
        gy5 gy5Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            J();
            I();
            if (this.v == null || this.l == null || this.x == null) {
                return;
            }
            if (bn4.c().g() && (gy5Var = this.F) != null && (threadData = gy5Var.a) != null && threadData.getThreadVideoInfo() != null) {
                this.v.setPlaceHolder(3);
                this.v.K(this.F.a.getThreadVideoInfo().thumbnail_url, 10, false);
                this.l.setVisibility(0);
                stopPlay();
                this.L = this.F.a.getThreadVideoInfo().video_url;
                if (D()) {
                    this.L = this.F.a.getThreadVideoSegment().video_url;
                }
                if (StringUtils.isNull(this.F.a.getThreadVideoInfo().video_url)) {
                    L(true, 4);
                }
                this.x.getControl().setThreadDataForStatistic(this.F.a);
            } else {
                this.l.setVisibility(8);
            }
            this.i.y();
            this.M.j(new b(this));
        }
    }

    public final void C(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (e() != null) {
                e().a(view2, this.F);
            }
            if (!mi.z()) {
                oi.M(this.q.getPageActivity(), R.string.obfuscated_res_0x7f0f0c4e);
            } else {
                y(ThreadCardUtils.computeViewArea(this.l));
            }
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            gy5 gy5Var = this.F;
            return (gy5Var == null || (threadData = gy5Var.a) == null || threadData.getThreadVideoSegment() == null || TextUtils.isEmpty(this.F.a.getThreadVideoSegment().video_url)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            gy5 gy5Var = this.F;
            return gy5Var.R && !gy5Var.S;
        }
        return invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.J : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tw5
    /* renamed from: G */
    public void l(gy5 gy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gy5Var) == null) {
            this.F = gy5Var;
            H();
        }
    }

    public final void H() {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            gy5 gy5Var = this.F;
            if (gy5Var != null && (threadData = gy5Var.a) != null && threadData.getAuthor() != null) {
                this.r.setVisibility(0);
                B();
                if (!E() && ex5.k(this.F.a.getId())) {
                    ex5.l(this.s, this.F.a.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    ex5.l(this.m.getGodReplyContent(), this.F.getThreadData().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
                }
                this.F.getThreadData().parser_title();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.F.getThreadData().getSpan_str());
                if (this.F.getThreadData().canShowNaniTail() && !StringUtils.isNull(this.F.getThreadData().getTid())) {
                    String str = vt4.k().q("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.F.getThreadData().getTid();
                    spannableStringBuilder.append((CharSequence) this.F.getThreadData().generateNaniTail(new a(this, 2, str, str)));
                }
                this.s.setOnTouchListener(new xw8(spannableStringBuilder));
                this.s.setText(spannableStringBuilder);
                this.t.j(this.F.getThreadData());
                this.t.setUserAfterClickListener(this.T);
                if (this.t.getHeaderImg() != null) {
                    this.t.getHeaderImg().setAfterClickListener(this.U);
                    if (this.t.getIsSimpleThread()) {
                        this.t.getHeaderImg().setVisibility(8);
                        this.u.setVisibility(8);
                    } else if (this.F.getThreadData() != null && this.F.getThreadData().getAuthor() != null && this.F.getThreadData().getAuthor().getPendantData() != null && !StringUtils.isNull(this.F.getThreadData().getAuthor().getPendantData().getImgUrl())) {
                        this.t.getHeaderImg().setVisibility(4);
                        this.u.setVisibility(0);
                        this.u.setData(this.F.getThreadData());
                    } else {
                        this.u.setVisibility(8);
                        this.t.getHeaderImg().setVisibility(0);
                        if (this.F.getThreadData().middle_page_num > 0 && this.F.getThreadData().middle_page_pass_flag == 0) {
                            this.F.getThreadData().getAuthor().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                            this.t.getHeaderImg().setData(this.F.getThreadData(), false);
                        } else {
                            this.t.getHeaderImg().setData(this.F.getThreadData());
                            this.t.getHeaderImg().setOnInterceptClickEventListener(null);
                        }
                    }
                }
                this.y.setText(StringHelper.stringForVideoTime(this.F.a.getThreadVideoInfo().video_duration.intValue() * 1000));
                this.A.setText(String.format(this.q.getResources().getString(R.string.obfuscated_res_0x7f0f0e4d), StringHelper.numFormatOverWan(this.F.a.getThreadVideoInfo().play_count.intValue())));
                if (this.n != null && this.F.getThreadData() != null) {
                    lp4 lp4Var = new lp4();
                    lp4Var.o(this.F.getThreadData().getTid());
                    lp4Var.k(this.F.getThreadData().getFid());
                    lp4Var.n(this.F.getThreadData().getNid());
                    lp4Var.j(this.F.feedBackReasonMap);
                    this.n.setData(lp4Var);
                    this.n.setFirstRowSingleColumn(true);
                    this.n.setVisibility(this.K ? 0 : 8);
                }
                this.m.setData(this.F.getThreadData().getTopAgreePost());
                M(v(1));
                m(this.q, TbadkCoreApplication.getInst().getSkinType());
                if (ex5.k(this.F.a.getId())) {
                    SkinManager.setViewTextColor(this.s, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
                }
                gy5 gy5Var2 = this.F;
                if ((gy5Var2 == null || (threadData2 = gy5Var2.a) == null || threadData2.getThreadVideoInfo() == null || this.F.a.getThreadVideoInfo().is_vertical.intValue() != 1) ? false : true) {
                    this.P.setVisibility(0);
                    if (D()) {
                        this.P.setText(String.format("%s | %s", this.q.getResources().getString(R.string.obfuscated_res_0x7f0f0c09), this.q.getResources().getString(R.string.obfuscated_res_0x7f0f14ef)));
                        return;
                    } else {
                        this.P.setText(this.q.getString(R.string.obfuscated_res_0x7f0f0c09));
                        return;
                    }
                } else if (D()) {
                    this.P.setVisibility(0);
                    this.P.setText(this.q.getString(R.string.obfuscated_res_0x7f0f14ef));
                    return;
                } else {
                    this.P.setVisibility(8);
                    return;
                }
            }
            this.r.setVisibility(8);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.Q.removeMessages(202);
            this.Q.removeMessages(203);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            pg.a().removeCallbacks(this.R);
            pg.a().removeCallbacks(this.S);
        }
    }

    public final void K() {
        gy5 gy5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (gy5Var = this.F) == null || gy5Var.a == null) {
            return;
        }
        m78 m78Var = new m78();
        m78Var.a = this.F.T == 0 ? "index" : "hot_juhe";
        m78Var.c = this.F.a.getTid();
        m78Var.d = this.F.a.getFid() + "";
        m78Var.e = TbadkCoreApplication.getCurrentAccount();
        gy5 gy5Var2 = this.F;
        ThreadData threadData = gy5Var2.a;
        m78Var.f = threadData.mRecomSource;
        String str = threadData.mRecomAbTag;
        m78Var.l = str;
        m78Var.g = str;
        m78Var.h = threadData.mRecomWeight;
        m78Var.i = "";
        m78Var.k = gy5Var2.i();
        if (this.F.a.getThreadVideoInfo() != null) {
            m78Var.m = this.F.a.getThreadVideoInfo().video_md5;
        }
        b78.e(this.F.a.getThreadVideoInfo().video_md5, "", "1", m78Var, this.x.getControl().getPcdnState());
    }

    public final void L(boolean z, int i) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || this.w == null || this.v == null || this.G == null || this.E == null || this.D == null || this.C == null) {
            return;
        }
        if (z || this.I != i) {
            this.I = i;
            pg.a().removeCallbacks(this.S);
            pg.a().removeCallbacks(this.R);
            if (i == 2) {
                this.w.setVisibility(8);
                this.N.cancel();
                this.v.clearAnimation();
                this.v.setVisibility(0);
                this.G.setVisibility(0);
                this.z.setVisibility(0);
                this.O.setVisibility(8);
                this.E.g();
                this.D.setVisibility(8);
                this.C.setVisibility(8);
                pg.a().postDelayed(this.S, 60000L);
            } else if (i == 3) {
                this.w.setVisibility(8);
                this.v.startAnimation(this.N);
                this.G.setVisibility(8);
                this.z.setVisibility(8);
                gy5 gy5Var = this.F;
                if (gy5Var != null && gy5Var.getThreadData() != null && this.F.getThreadData().middle_page_num > 0) {
                    this.O.setVisibility(0);
                }
                this.E.c();
                this.D.setVisibility(8);
                this.C.setVisibility(8);
                gy5 gy5Var2 = this.F;
                if (gy5Var2 != null && (threadData = gy5Var2.a) != null && threadData.getThreadVideoInfo() != null) {
                    this.F.a.getThreadVideoInfo().video_length.intValue();
                    this.F.a.getThreadVideoInfo().video_duration.intValue();
                    this.F.a.getTid();
                }
            } else if (i == 4) {
                this.w.setVisibility(8);
                this.v.startAnimation(this.N);
                this.G.setVisibility(8);
                this.E.b();
                this.D.setVisibility(0);
                this.C.setVisibility(0);
                pg.a().postDelayed(this.R, 2000L);
            } else {
                this.w.setVisibility(0);
                this.N.cancel();
                this.v.clearAnimation();
                this.v.setVisibility(0);
                this.G.setVisibility(0);
                this.z.setVisibility(0);
                this.E.b();
                this.D.setVisibility(8);
                this.C.setVisibility(8);
            }
            gy5 gy5Var3 = this.F;
            if (gy5Var3 == null || gy5Var3.getThreadData() == null || this.F.getThreadData().middle_page_num <= 0) {
                return;
            }
            this.z.setVisibility(8);
        }
    }

    public void M(int i) {
        gy5 gy5Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (gy5Var = this.F) == null || (threadData = gy5Var.a) == null) {
            return;
        }
        if (i == 1) {
            if (threadData.middle_page_num > 0) {
                this.p.b.setShowPraiseNum(false);
                this.p.b.setShareVisible(false);
                this.O.setText(StringHelper.numFormatOverWan(this.F.a.middle_page_num));
                this.O.setVisibility(0);
            } else {
                this.p.b.setShowPraiseNum(true);
                this.p.b.setShareVisible(true);
                this.O.setVisibility(8);
            }
            this.p.g(this.F.a);
            this.j.setVisibility(8);
            this.t.l(false);
            return;
        }
        this.p.setVisibility(8);
        this.t.l(true);
        if (this.F.a.middle_page_num > 0) {
            this.j.setShowPraiseNum(false);
            this.j.setShareVisible(false);
            this.O.setText(StringHelper.numFormatOverWan(this.F.a.middle_page_num));
            this.O.setVisibility(0);
        } else {
            this.j.setShowPraiseNum(true);
            this.j.setShareVisible(true);
            this.O.setVisibility(8);
        }
        if (this.j.setData(this.F.a)) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
        }
    }

    public final void N(gy5 gy5Var) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, gy5Var) == null) || gy5Var == null || (threadData = gy5Var.a) == null || threadData.getId() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, threadData.getId()));
    }

    @Override // com.repackage.pi5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.repackage.tw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? R.layout.obfuscated_res_0x7f0d019b : invokeV.intValue;
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.x;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null) {
                return 0;
            }
            return this.x.getControl().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.x;
            if (tbVideoViewContainer == null) {
                return false;
            }
            return tbVideoViewContainer.getControl().isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.tw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048595, this, tbPageContext, i) == null) || this.H == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.r, R.drawable.addresslist_item_bg);
        SkinManager.setImageResource(this.w, R.drawable.obfuscated_res_0x7f08039a);
        SkinManager.setViewTextColor(this.C, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.A, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.O, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.D, R.color.common_color_10014);
        SkinManager.setBackgroundColor(this.B, R.color.CAM_X0204);
        TextView textView = this.P;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.P, R.drawable.obfuscated_res_0x7f081248);
        }
        if (this.C != null) {
            this.C.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080a6a), (Drawable) null, (Drawable) null);
        }
        this.m.k();
        NEGFeedBackView nEGFeedBackView = this.n;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.r();
        }
        this.t.h();
        this.j.onChangeSkinType();
        this.p.f();
        this.v.setPlaceHolder(3);
        this.u.getHeadView().setPlaceHolder(1);
        this.H = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            gy5 gy5Var = this.F;
            if (gy5Var != null && (threadData2 = gy5Var.a) != null && threadData2.middle_page_num > 0) {
                if (e() != null) {
                    e().a(view2, this.F);
                }
                this.q.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.q.getPageActivity(), this.F.a.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, ex5.g(), this.F.getPbInputLocate())));
                return;
            }
            if (view2 == this.r || view2 == this.m) {
                A(view2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
            }
            if (view2 == this.x) {
                gy5 gy5Var2 = this.F;
                if (gy5Var2 != null) {
                    gy5Var2.f = 5;
                }
                gy5 gy5Var3 = this.F;
                boolean z = false;
                if (gy5Var3 != null && (threadData = gy5Var3.a) != null && threadData.getThreadVideoInfo() != null && this.F.a.getThreadVideoInfo().is_vertical.intValue() == 1) {
                    z = true;
                }
                if (z) {
                    z(this.x);
                } else if (UtilHelper.isGotoVideoMiddlePage()) {
                    C(this.x);
                } else {
                    A(k());
                }
            }
        }
    }

    public void startPlay() {
        gy5 gy5Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.J || (gy5Var = this.F) == null || (threadData = gy5Var.a) == null || threadData.getThreadVideoInfo() == null || this.x == null) {
            return;
        }
        if (this.i.q()) {
            this.i.A();
            return;
        }
        this.x.getControl().stopPlayback();
        if (kd5.b(1, this.L)) {
            L(true, 2);
            if (StringUtils.isNull(this.L)) {
                TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "index").param("tid", this.F.g));
                this.L = this.F.a.getThreadVideoInfo().video_url;
            }
            this.J = true;
            this.x.getControl().setVideoPath(this.L, this.F.g);
            z68 z68Var = this.M;
            if (z68Var != null) {
                z68Var.m();
            }
            K();
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            J();
            I();
            L(true, 1);
            TbVideoViewContainer tbVideoViewContainer = this.x;
            if (tbVideoViewContainer != null) {
                tbVideoViewContainer.getControl().stopPlayback();
                z68 z68Var = this.M;
                if (z68Var != null) {
                    z68Var.n();
                }
            }
            this.J = false;
            this.i.G();
        }
    }

    public int v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) ? oi5.c().b(this.o, i) : invokeI.intValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.L : (String) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public final void y(Rect rect) {
        gy5 gy5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, rect) == null) || (gy5Var = this.F) == null || gy5Var.a == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.buildWithThreadData(this.F.a);
        videoItemData.mRecomExtra = this.F.i();
        videoItemData.mRecomAbTag = this.F.e();
        videoItemData.mRecomSource = this.F.r();
        videoItemData.mRecomWeight = this.F.D();
        arrayList.add(videoItemData);
        nc5.d(this.b.getPageActivity(), arrayList, this.F.a.getBaijiahaoData() != null ? this.F.a.getBaijiahaoData().oriUgcNid : null, false, 0, rect, "from_nani_video", "personalize_page", this.F.getPbInputLocate(), "index", "", false, false);
    }

    public final void z(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view2) == null) {
            if (e() != null) {
                e().a(view2, this.F);
            }
            if (!mi.z()) {
                oi.M(this.q.getPageActivity(), R.string.obfuscated_res_0x7f0f0c4e);
            } else {
                y(ThreadCardUtils.computeViewArea(this.l));
            }
        }
    }
}
