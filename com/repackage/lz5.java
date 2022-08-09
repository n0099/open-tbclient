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
import com.repackage.m88;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class lz5 extends bz5<o06> implements View.OnClickListener, ol5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public TextView B;
    public View C;
    public w88 D;
    public o06 E;
    public View F;
    public int G;
    public int H;
    public boolean I;
    public boolean J;
    public String K;
    public m88 L;
    public Animation M;
    public TextView N;
    public TextView O;
    public Handler P;
    public Runnable Q;
    public Runnable R;
    public final View.OnClickListener S;
    public final View.OnClickListener T;
    public ThreadCommentAndPraiseInfoLayout i;
    public View j;
    public FrameLayout k;
    public ThreadGodReplyLayout l;
    public NEGFeedBackView m;
    public String n;
    public ThreadSourceShareAndPraiseLayout o;
    public TbPageContext<?> p;
    public RelativeLayout q;
    public TextView r;
    public ThreadUserInfoLayout s;
    public HeadPendantClickableView t;
    public TbImageView u;
    public ImageView v;
    public TbVideoViewContainer w;
    public TextView x;
    public LinearLayout y;
    public TextView z;

    /* loaded from: classes6.dex */
    public class a extends gi5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lz5 lz5Var, int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lz5Var, Integer.valueOf(i), str, str2};
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

        @Override // com.repackage.gi5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jm4.x(TbadkCoreApplication.getInst().getApplicationContext(), false, this.h);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "0"));
            }
        }

        @Override // com.repackage.gi5, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements m88.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lz5 a;

        public b(lz5 lz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lz5Var;
        }

        @Override // com.repackage.m88.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || i2 >= i || i == 0 || (i2 * 100) / i < 80 || i <= 15000) {
                return;
            }
            lz5 lz5Var = this.a;
            lz5Var.M(lz5Var.E);
        }
    }

    public final void A(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            if (e() != null) {
                e().a(view2, this.E);
            }
            if (!oi.z()) {
                qi.N(this.p.getPageActivity(), R.string.obfuscated_res_0x7f0f0c75);
            } else {
                w(ThreadCardUtils.computeViewArea(this.k));
            }
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            o06 o06Var = this.E;
            return (o06Var == null || (threadData = o06Var.a) == null || threadData.getThreadVideoSegment() == null || TextUtils.isEmpty(this.E.a.getThreadVideoSegment().video_url)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            o06 o06Var = this.E;
            return o06Var.R && !o06Var.S;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.I : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bz5
    /* renamed from: E */
    public void i(o06 o06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, o06Var) == null) {
            this.E = o06Var;
            F();
        }
    }

    public final void F() {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            o06 o06Var = this.E;
            if (o06Var != null && (threadData = o06Var.a) != null && threadData.getAuthor() != null) {
                this.q.setVisibility(0);
                z();
                if (!C() && mz5.k(this.E.a.getId())) {
                    mz5.l(this.r, this.E.a.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    mz5.l(this.l.getGodReplyContent(), this.E.getThreadData().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
                }
                this.E.getThreadData().parser_title();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.E.getThreadData().getSpan_str());
                if (this.E.getThreadData().canShowNaniTail() && !StringUtils.isNull(this.E.getThreadData().getTid())) {
                    String str = ru4.k().q("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.E.getThreadData().getTid();
                    spannableStringBuilder.append((CharSequence) this.E.getThreadData().generateNaniTail(new a(this, 2, str, str)));
                }
                this.r.setOnTouchListener(new rw8(spannableStringBuilder));
                this.r.setText(spannableStringBuilder);
                this.s.j(this.E.getThreadData());
                this.s.setUserAfterClickListener(this.S);
                if (this.s.getHeaderImg() != null) {
                    this.s.getHeaderImg().setAfterClickListener(this.T);
                    if (this.s.getIsSimpleThread()) {
                        this.s.getHeaderImg().setVisibility(8);
                        this.t.setVisibility(8);
                    } else if (this.E.getThreadData() != null && this.E.getThreadData().getAuthor() != null && this.E.getThreadData().getAuthor().getPendantData() != null && !StringUtils.isNull(this.E.getThreadData().getAuthor().getPendantData().getImgUrl())) {
                        this.s.getHeaderImg().setVisibility(4);
                        this.t.setVisibility(0);
                        this.t.setData(this.E.getThreadData());
                    } else {
                        this.t.setVisibility(8);
                        this.s.getHeaderImg().setVisibility(0);
                        if (this.E.getThreadData().middle_page_num > 0 && this.E.getThreadData().middle_page_pass_flag == 0) {
                            this.E.getThreadData().getAuthor().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                            this.s.getHeaderImg().setData(this.E.getThreadData(), false);
                        } else {
                            this.s.getHeaderImg().setData(this.E.getThreadData());
                            this.s.getHeaderImg().setOnInterceptClickEventListener(null);
                        }
                    }
                }
                this.x.setText(StringHelper.stringForVideoTime(this.E.a.getThreadVideoInfo().video_duration.intValue() * 1000));
                this.z.setText(String.format(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f0e87), StringHelper.numFormatOverWan(this.E.a.getThreadVideoInfo().play_count.intValue())));
                if (this.m != null && this.E.getThreadData() != null) {
                    cq4 cq4Var = new cq4();
                    cq4Var.o(this.E.getThreadData().getTid());
                    cq4Var.k(this.E.getThreadData().getFid());
                    cq4Var.n(this.E.getThreadData().getNid());
                    cq4Var.j(this.E.feedBackReasonMap);
                    this.m.setData(cq4Var);
                    this.m.setFirstRowSingleColumn(true);
                    this.m.setVisibility(this.J ? 0 : 8);
                }
                this.l.setData(this.E.getThreadData().getTopAgreePost());
                L(t(1));
                j(this.p, TbadkCoreApplication.getInst().getSkinType());
                if (mz5.k(this.E.a.getId())) {
                    SkinManager.setViewTextColor(this.r, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1);
                }
                o06 o06Var2 = this.E;
                if ((o06Var2 == null || (threadData2 = o06Var2.a) == null || threadData2.getThreadVideoInfo() == null || this.E.a.getThreadVideoInfo().is_vertical.intValue() != 1) ? false : true) {
                    this.O.setVisibility(0);
                    if (B()) {
                        this.O.setText(String.format("%s | %s", this.p.getResources().getString(R.string.obfuscated_res_0x7f0f0c2c), this.p.getResources().getString(R.string.obfuscated_res_0x7f0f1529)));
                        return;
                    } else {
                        this.O.setText(this.p.getString(R.string.obfuscated_res_0x7f0f0c2c));
                        return;
                    }
                } else if (B()) {
                    this.O.setVisibility(0);
                    this.O.setText(this.p.getString(R.string.obfuscated_res_0x7f0f1529));
                    return;
                } else {
                    this.O.setVisibility(8);
                    return;
                }
            }
            this.q.setVisibility(8);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.P.removeMessages(202);
            this.P.removeMessages(203);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            rg.a().removeCallbacks(this.Q);
            rg.a().removeCallbacks(this.R);
        }
    }

    public final void J() {
        o06 o06Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (o06Var = this.E) == null || o06Var.a == null) {
            return;
        }
        z88 z88Var = new z88();
        z88Var.a = this.E.T == 0 ? "index" : "hot_juhe";
        z88Var.c = this.E.a.getTid();
        z88Var.d = this.E.a.getFid() + "";
        z88Var.e = TbadkCoreApplication.getCurrentAccount();
        o06 o06Var2 = this.E;
        ThreadData threadData = o06Var2.a;
        z88Var.f = threadData.mRecomSource;
        String str = threadData.mRecomAbTag;
        z88Var.l = str;
        z88Var.g = str;
        z88Var.h = threadData.mRecomWeight;
        z88Var.i = "";
        z88Var.k = o06Var2.h();
        if (this.E.a.getThreadVideoInfo() != null) {
            z88Var.m = this.E.a.getThreadVideoInfo().video_md5;
        }
        o88.e(this.E.a.getThreadVideoInfo().video_md5, "", "1", z88Var, this.w.getControl().getPcdnState());
    }

    public final void K(boolean z, int i) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || this.v == null || this.u == null || this.F == null || this.D == null || this.C == null || this.B == null) {
            return;
        }
        if (z || this.H != i) {
            this.H = i;
            rg.a().removeCallbacks(this.R);
            rg.a().removeCallbacks(this.Q);
            if (i == 2) {
                this.v.setVisibility(8);
                this.M.cancel();
                this.u.clearAnimation();
                this.u.setVisibility(0);
                this.F.setVisibility(0);
                this.y.setVisibility(0);
                this.N.setVisibility(8);
                this.D.g();
                this.C.setVisibility(8);
                this.B.setVisibility(8);
                rg.a().postDelayed(this.R, 60000L);
            } else if (i == 3) {
                this.v.setVisibility(8);
                this.u.startAnimation(this.M);
                this.F.setVisibility(8);
                this.y.setVisibility(8);
                o06 o06Var = this.E;
                if (o06Var != null && o06Var.getThreadData() != null && this.E.getThreadData().middle_page_num > 0) {
                    this.N.setVisibility(0);
                }
                this.D.c();
                this.C.setVisibility(8);
                this.B.setVisibility(8);
                o06 o06Var2 = this.E;
                if (o06Var2 != null && (threadData = o06Var2.a) != null && threadData.getThreadVideoInfo() != null) {
                    this.E.a.getThreadVideoInfo().video_length.intValue();
                    this.E.a.getThreadVideoInfo().video_duration.intValue();
                    this.E.a.getTid();
                }
            } else if (i == 4) {
                this.v.setVisibility(8);
                this.u.startAnimation(this.M);
                this.F.setVisibility(8);
                this.D.b();
                this.C.setVisibility(0);
                this.B.setVisibility(0);
                rg.a().postDelayed(this.Q, 2000L);
            } else {
                this.v.setVisibility(0);
                this.M.cancel();
                this.u.clearAnimation();
                this.u.setVisibility(0);
                this.F.setVisibility(0);
                this.y.setVisibility(0);
                this.D.b();
                this.C.setVisibility(8);
                this.B.setVisibility(8);
            }
            o06 o06Var3 = this.E;
            if (o06Var3 == null || o06Var3.getThreadData() == null || this.E.getThreadData().middle_page_num <= 0) {
                return;
            }
            this.y.setVisibility(8);
        }
    }

    public void L(int i) {
        o06 o06Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || (o06Var = this.E) == null || (threadData = o06Var.a) == null) {
            return;
        }
        if (i == 1) {
            if (threadData.middle_page_num > 0) {
                this.o.b.setShowPraiseNum(false);
                this.o.b.setShareVisible(false);
                this.N.setText(StringHelper.numFormatOverWan(this.E.a.middle_page_num));
                this.N.setVisibility(0);
            } else {
                this.o.b.setShowPraiseNum(true);
                this.o.b.setShareVisible(true);
                this.N.setVisibility(8);
            }
            this.o.g(this.E.a);
            this.i.setVisibility(8);
            this.s.l(false);
            return;
        }
        this.o.setVisibility(8);
        this.s.l(true);
        if (this.E.a.middle_page_num > 0) {
            this.i.setShowPraiseNum(false);
            this.i.setShareVisible(false);
            this.N.setText(StringHelper.numFormatOverWan(this.E.a.middle_page_num));
            this.N.setVisibility(0);
        } else {
            this.i.setShowPraiseNum(true);
            this.i.setShareVisible(true);
            this.N.setVisibility(8);
        }
        if (this.i.setData(this.E.a)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
    }

    public final void M(o06 o06Var) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, o06Var) != null) || o06Var == null || (threadData = o06Var.a) == null || threadData.getId() == null) {
        }
    }

    @Override // com.repackage.ol5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.repackage.bz5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? R.layout.obfuscated_res_0x7f0d0191 : invokeV.intValue;
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.w;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null) {
                return 0;
            }
            return this.w.getControl().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.w;
            if (tbVideoViewContainer == null) {
                return false;
            }
            return tbVideoViewContainer.getControl().isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.bz5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048593, this, tbPageContext, i) == null) || this.G == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.q, R.drawable.addresslist_item_bg);
        SkinManager.setImageResource(this.v, R.drawable.obfuscated_res_0x7f080393);
        SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.N, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.C, R.color.common_color_10014);
        SkinManager.setBackgroundColor(this.A, R.color.CAM_X0204);
        TextView textView = this.O;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.O, R.drawable.obfuscated_res_0x7f081247);
        }
        if (this.B != null) {
            this.B.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080aa9), (Drawable) null, (Drawable) null);
        }
        this.l.k();
        NEGFeedBackView nEGFeedBackView = this.m;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.q();
        }
        this.s.h();
        this.i.onChangeSkinType();
        this.o.f();
        this.u.setPlaceHolder(3);
        this.t.getHeadView().setPlaceHolder(1);
        this.G = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
            o06 o06Var = this.E;
            if (o06Var != null && (threadData2 = o06Var.a) != null && threadData2.middle_page_num > 0) {
                if (e() != null) {
                    e().a(view2, this.E);
                }
                this.p.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.p.getPageActivity(), this.E.a.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, mz5.g(), this.E.getPbInputLocate())));
                return;
            }
            if (view2 == this.q || view2 == this.l) {
                y(view2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
            }
            if (view2 == this.w) {
                o06 o06Var2 = this.E;
                if (o06Var2 != null) {
                    o06Var2.f = 5;
                }
                o06 o06Var3 = this.E;
                boolean z = false;
                if (o06Var3 != null && (threadData = o06Var3.a) != null && threadData.getThreadVideoInfo() != null && this.E.a.getThreadVideoInfo().is_vertical.intValue() == 1) {
                    z = true;
                }
                if (z) {
                    x(this.w);
                } else if (UtilHelper.isGotoVideoMiddlePage()) {
                    A(this.w);
                } else {
                    y(h());
                }
            }
        }
    }

    public void startPlay() {
        o06 o06Var;
        ThreadData threadData;
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.I || (o06Var = this.E) == null || (threadData = o06Var.a) == null || threadData.getThreadVideoInfo() == null || (tbVideoViewContainer = this.w) == null) {
            return;
        }
        tbVideoViewContainer.getControl().stopPlayback();
        if (of5.b(1, this.K)) {
            K(true, 2);
            if (StringUtils.isNull(this.K)) {
                TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "index").param("tid", this.E.g));
                this.K = this.E.a.getThreadVideoInfo().video_url;
            }
            this.I = true;
            this.w.getControl().setVideoPath(this.K, this.E.g);
            m88 m88Var = this.L;
            if (m88Var != null) {
                m88Var.m();
            }
            J();
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            H();
            G();
            K(true, 1);
            TbVideoViewContainer tbVideoViewContainer = this.w;
            if (tbVideoViewContainer != null) {
                tbVideoViewContainer.getControl().stopPlayback();
                m88 m88Var = this.L;
                if (m88Var != null) {
                    m88Var.n();
                }
            }
            this.I = false;
        }
    }

    public int t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) ? nl5.c().b(this.n, i) : invokeI.intValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.K : (String) invokeV.objValue;
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public final void w(Rect rect) {
        o06 o06Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, rect) == null) || (o06Var = this.E) == null || o06Var.a == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.buildWithThreadData(this.E.a);
        videoItemData.mRecomExtra = this.E.h();
        videoItemData.mRecomAbTag = this.E.c();
        videoItemData.mRecomSource = this.E.r();
        videoItemData.mRecomWeight = this.E.D();
        arrayList.add(videoItemData);
        pe5.d(this.b.getPageActivity(), arrayList, this.E.a.getBaijiahaoData() != null ? this.E.a.getBaijiahaoData().oriUgcNid : null, false, 0, rect, "from_nani_video", "personalize_page", this.E.getPbInputLocate(), "index", "", false, false);
    }

    public final void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            if (e() != null) {
                e().a(view2, this.E);
            }
            if (!oi.z()) {
                qi.N(this.p.getPageActivity(), R.string.obfuscated_res_0x7f0f0c75);
            } else {
                w(ThreadCardUtils.computeViewArea(this.k));
            }
        }
    }

    public final void y(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            o06 o06Var = this.E;
            if (o06Var != null) {
                o06Var.f = 1;
            }
            if (e() != null) {
                e().a(view2, this.E);
            }
            o06 o06Var2 = this.E;
            if (o06Var2 == null || o06Var2.a == null) {
                return;
            }
            if (!C()) {
                mz5.a(this.E.a.getId());
                mz5.l(this.r, this.E.a.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.p.getPageActivity()).createFromThreadCfg(this.E.a, null, mz5.g(), 18003, true, false, false).addLocateParam(this.E.getPbInputLocate());
            addLocateParam.setVideo_source(this.E.T == 0 ? "index" : "hot_juhe");
            if (this.E.T == 0) {
                addLocateParam.setFrom("from_personalize");
            }
            addLocateParam.setForumId(String.valueOf(this.E.a.getFid()));
            addLocateParam.setForumName(this.E.a.getForum_name());
            addLocateParam.setStartFrom(this.h);
            if (view2 == this.l) {
                addLocateParam.setJumpGodReply(true);
            }
            this.p.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    public final void z() {
        o06 o06Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            H();
            G();
            if (this.u == null || this.k == null || this.w == null) {
                return;
            }
            if (rn4.c().g() && (o06Var = this.E) != null && (threadData = o06Var.a) != null && threadData.getThreadVideoInfo() != null) {
                this.u.setPlaceHolder(3);
                this.u.K(this.E.a.getThreadVideoInfo().thumbnail_url, 10, false);
                this.k.setVisibility(0);
                stopPlay();
                this.K = this.E.a.getThreadVideoInfo().video_url;
                if (B()) {
                    this.K = this.E.a.getThreadVideoSegment().video_url;
                }
                if (StringUtils.isNull(this.E.a.getThreadVideoInfo().video_url)) {
                    K(true, 4);
                }
                this.w.getControl().setThreadDataForStatistic(this.E.a);
            } else {
                this.k.setVisibility(8);
            }
            this.L.j(new b(this));
        }
    }
}
