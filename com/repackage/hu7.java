package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.tbadk.switchs.NovelPaySwitch;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFirstFloorViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ls7;
import com.repackage.qw;
import java.util.List;
import tbclient.Item;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class hu7 extends du7<PostData, PbFirstFloorViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView.s A;
    public View.OnClickListener B;
    public boolean C;
    public final boolean D;
    public boolean E;
    public Context F;
    public int G;
    public ls7 H;
    public jy5<on4> I;
    public qw.a J;
    public int o;
    public boolean p;
    public boolean q;
    public PbModel r;
    public boolean s;
    public jr7 t;
    public ox7 u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public TbRichTextView.y x;
    public ls7 y;
    public View.OnLongClickListener z;

    /* loaded from: classes6.dex */
    public class a implements ls7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hu7 a;

        public a(hu7 hu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hu7Var;
        }

        @Override // com.repackage.ls7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.ls7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.y != null) {
                    this.a.y.a(view2);
                    this.a.y.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.ls7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, motionEvent));
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends jy5<on4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hu7 b;

        public b(hu7 hu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hu7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, on4 on4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, on4Var) == null) {
                super.a(view2, on4Var);
                if (on4Var == null || on4Var.getThreadData() == null || on4Var.getThreadData().originalThreadData == null || this.b.t == null) {
                    return;
                }
                OriginalThreadInfo originalThreadInfo = on4Var.getThreadData().originalThreadData;
                String Q = this.b.t.Q();
                String str = originalThreadInfo.f;
                int i = 1;
                int i2 = originalThreadInfo.a;
                if (i2 == 3) {
                    i = 2;
                } else if (i2 == 4) {
                    i = 3;
                }
                if (StringUtils.isNull(Q) || StringUtils.isNull(str)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12602").param("tid", Q).param("obj_source", str).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hu7 a;

        public c(hu7 hu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hu7Var;
        }

        @Override // com.repackage.qw.a
        public void a(on4 on4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, on4Var) == null) || on4Var == null || on4Var.getThreadData() == null || on4Var.getThreadData().originalThreadData == null) {
                return;
            }
            OriginalThreadInfo originalThreadInfo = on4Var.getThreadData().originalThreadData;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.F);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f, originalThreadInfo.n, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.e));
            pbActivityConfig.setStartFrom(this.a.G);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    /* loaded from: classes6.dex */
    public class d implements TbRichTextView.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ View c;
        public final /* synthetic */ int d;
        public final /* synthetic */ hu7 e;

        public d(hu7 hu7Var, PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hu7Var, pbFirstFloorViewHolder, postData, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = hu7Var;
            this.a = pbFirstFloorViewHolder;
            this.b = postData;
            this.c = view2;
            this.d = i;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.v
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.e.getLayoutParams();
                layoutParams.topMargin = this.e.Z(R.dimen.obfuscated_res_0x7f0701be);
                int Z = this.e.Z(R.dimen.obfuscated_res_0x7f07020f);
                layoutParams.bottomMargin = Z;
                layoutParams.leftMargin = Z;
                layoutParams.rightMargin = Z;
                this.a.e.setLayoutParams(layoutParams);
                this.e.h0(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(hu7 hu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hu7(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((qy7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 0;
        boolean z = true;
        this.p = true;
        this.q = true;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = false;
        int i3 = Build.VERSION.SDK_INT;
        this.D = (i3 < 14 || i3 > 16) ? false : false;
        this.E = false;
        this.G = 0;
        this.H = new ls7(new a(this));
        this.I = new b(this);
        this.J = new c(this);
        if (pbFragment != null && pbFragment.F() != null) {
            this.G = pbFragment.F().Q1();
            this.r = pbFragment.F();
        }
        this.F = pbFragment.getContext();
    }

    public void A0(ls7 ls7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ls7Var) == null) {
            this.y = ls7Var;
        }
    }

    public void B0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar) == null) {
            this.A = sVar;
        }
    }

    public final void C0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbFirstFloorViewHolder) == null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbFirstFloorViewHolder.a != skinType) {
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.x, R.color.CAM_X0202);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.f, R.color.CAM_X0204);
            pbFirstFloorViewHolder.e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbFirstFloorViewHolder.m.c();
            pbFirstFloorViewHolder.o.g();
            ThreadForumEnterButtonContainer threadForumEnterButtonContainer = pbFirstFloorViewHolder.t;
            if (threadForumEnterButtonContainer != null) {
                threadForumEnterButtonContainer.a();
            }
            PbBusinessPromotionContainer pbBusinessPromotionContainer = pbFirstFloorViewHolder.u;
            if (pbBusinessPromotionContainer != null) {
                pbBusinessPromotionContainer.h();
            }
            SkinManager.setViewTextColor(pbFirstFloorViewHolder.l, (int) R.color.CAM_X0107);
            pbFirstFloorViewHolder.v.i(skinType);
            VoteView voteView = pbFirstFloorViewHolder.w;
            if (voteView != null) {
                voteView.C(skinType);
            }
            SkinManager.setBackgroundColorToTransparent(pbFirstFloorViewHolder.n, R.color.CAM_X0201, GradientDrawable.Orientation.BOTTOM_TOP);
        }
        pbFirstFloorViewHolder.a = TbadkCoreApplication.getInst().getSkinType();
    }

    @Override // com.repackage.du7, com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        s0(i, view2, viewGroup, (PostData) obj, (PbFirstFloorViewHolder) viewHolder);
        return view2;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.p = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onLongClickListener) == null) {
            this.z = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public final void f0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.e.setTextViewOnTouchListener(this.H);
            pbFirstFloorViewHolder.e.setTextViewCheckSelection(false);
        }
    }

    public final void g0(TbRichTextView tbRichTextView, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048585, this, tbRichTextView, view2, z) == null) || tbRichTextView == null) {
            return;
        }
        int min = Math.min(((((pi.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - (z ? Z(R.dimen.obfuscated_res_0x7f070275) : 0), this.o);
        tbRichTextView.getLayoutStrategy().q(min);
        tbRichTextView.getLayoutStrategy().p((int) (min * 1.618f));
    }

    /* JADX WARN: Removed duplicated region for block: B:168:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x04ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view2, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String str;
        String str2;
        long j;
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048586, this, pbFirstFloorViewHolder, postData, view2, i) == null) || this.t == null) {
            return;
        }
        TbRichText tbRichText = null;
        if (postData.B() != 1) {
            if (TextUtils.isEmpty(postData.t())) {
                pbFirstFloorViewHolder.e.setOnClickListener(this.w);
                pbFirstFloorViewHolder.e.setTextViewOnClickListener(this.w);
            } else {
                pbFirstFloorViewHolder.e.setOnClickListener(null);
                pbFirstFloorViewHolder.e.setTextViewOnClickListener(null);
            }
            pbFirstFloorViewHolder.b.setOnClickListener(this.w);
        } else {
            pbFirstFloorViewHolder.b.setOnClickListener(null);
        }
        if (postData.B() == 1) {
            pbFirstFloorViewHolder.c(this.t, this.j.v0(), postData.O);
            g0(pbFirstFloorViewHolder.e, view2, this.E);
            if (postData.s() != null) {
                long userIdLong = postData.s().getUserIdLong();
                str = postData.s().getUserName();
                j = userIdLong;
                str2 = postData.s().getName_show();
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            jr7 jr7Var = this.t;
            if (jr7Var != null && jr7Var.O() != null) {
                pbFirstFloorViewHolder.q.b(postData.I(), str, str2, j, ng.g(this.t.O().getId(), 0L), ng.g(postData.J(), 0L));
            }
            if (this.j.O5().S1()) {
                pbFirstFloorViewHolder.e.setVisibility(8);
            }
            jr7 jr7Var2 = this.t;
            if (jr7Var2 != null && jr7Var2.O() != null && this.t.O().getYulePostActivityData() != null) {
                br4 yulePostActivityData = this.t.O().getYulePostActivityData();
                String a2 = yulePostActivityData.a();
                if (StringUtils.isNull(yulePostActivityData.b())) {
                    return;
                }
                if (!StringUtils.isNull(a2)) {
                    pbFirstFloorViewHolder.h.setVisibility(0);
                    pbFirstFloorViewHolder.h.J(a2, 10, true);
                }
            } else {
                pbFirstFloorViewHolder.h.setVisibility(8);
            }
            ThreadSkinView threadSkinView = pbFirstFloorViewHolder.i;
            if (threadSkinView != null) {
                threadSkinView.setVisibility(8);
            }
            jr7 jr7Var3 = this.t;
            if (jr7Var3 != null && jr7Var3.O() != null && this.t.O().isVideoThreadType() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.t) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.t.getPaddingRight(), pbFirstFloorViewHolder.t.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.e.getLayoutStrategy().x(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f091ef1, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091f0d, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091f0f, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f091f1b, Integer.valueOf(i));
        sparseArray.put(R.id.obfuscated_res_0x7f091f1a, Integer.valueOf(postData.B()));
        boolean z6 = postData.g0() || postData.f0(false);
        if (z6) {
            if (this.u == null) {
                ox7 ox7Var = new ox7(this.F);
                this.u = ox7Var;
                ox7Var.f(this.m);
                this.u.h(this.v);
                jr7 jr7Var4 = this.t;
                if (jr7Var4 != null) {
                    this.u.j(this.t.V(), TextUtils.equals(jr7Var4.O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.u.i(this.t.O());
                }
            }
            this.u.g(postData.J());
        }
        pbFirstFloorViewHolder.e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.p) {
            pbFirstFloorViewHolder.e.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f0811a8);
        } else {
            pbFirstFloorViewHolder.e.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.e.setIsFromCDN(this.m);
        jr7 jr7Var5 = this.t;
        if (jr7Var5 != null && jr7Var5.O() != null && this.t.O().isLinkThread()) {
            j0(pbFirstFloorViewHolder, this.t.O().getLinkThreadData());
        }
        jr7 jr7Var6 = this.t;
        if ((jr7Var6 == null || jr7Var6.O() == null || !this.t.O().isShareThread || postData.P() == null) ? false : true) {
            if (postData.P().C != null) {
                pbFirstFloorViewHolder.e.getLayoutStrategy().m(m0(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.e.getLayoutStrategy().m(m0(R.dimen.tbds14));
            }
            k0(pbFirstFloorViewHolder, postData);
        } else {
            pbFirstFloorViewHolder.e.getLayoutStrategy().m(m0(R.dimen.tbds24));
        }
        TbRichText Q = postData.Q();
        jr7 jr7Var7 = this.t;
        if (jr7Var7 == null || !jr7Var7.r0()) {
            tbRichText = Q;
        }
        if (this.t.O() != null) {
            pbFirstFloorViewHolder.e.setTid(this.t.Q());
            pbFirstFloorViewHolder.e.setIsUseGridImage(this.t.O().isBJHNormalThreadType());
            pbFirstFloorViewHolder.e.setmIsGridImageSupportLongPress(true);
        }
        jr7 jr7Var8 = this.t;
        if (jr7Var8 != null && 3 == jr7Var8.g()) {
            if (!this.C && this.D) {
                pbFirstFloorViewHolder.e.setText(tbRichText, true, this.A, true, false);
            } else {
                pbFirstFloorViewHolder.e.setText(tbRichText, false, this.A, true, false);
            }
        } else if (!this.C && this.D) {
            pbFirstFloorViewHolder.e.setText(tbRichText, true, this.A, false, true);
        } else {
            pbFirstFloorViewHolder.e.setText(tbRichText, false, this.A, false, true);
        }
        l0(pbFirstFloorViewHolder, postData, tbRichText);
        boolean z7 = !StringUtils.isNull(postData.s().getVirtualUserUrl());
        jr7 jr7Var9 = this.t;
        if (jr7Var9 == null || jr7Var9.V() == 0 || p0()) {
            z = false;
            z2 = false;
        } else {
            if (this.t.V() != 3) {
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            if (postData.s() != null) {
                String userId = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        jr7 jr7Var10 = this.t;
        if (jr7Var10 != null && jr7Var10.O() != null && this.t.O().getAuthor() != null && postData.s() != null) {
            String userId2 = this.t.O().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z2 = true;
                    z3 = false;
                    z4 = true;
                } else {
                    z2 = true;
                    z3 = true;
                    z4 = false;
                }
                z5 = true;
                if (postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z2 = true;
                    z4 = true;
                }
                if (z7) {
                    z = false;
                    z2 = false;
                    z3 = false;
                }
                int i2 = postData.B() == 1 ? 0 : 1;
                sparseArray.put(R.id.obfuscated_res_0x7f091f01, postData.J());
                if (!z) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f34, Boolean.TRUE);
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091efe, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091eff, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091f00, postData.s().getPortrait());
                    }
                    jr7 jr7Var11 = this.t;
                    if (jr7Var11 != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091f10, Integer.valueOf(jr7Var11.V()));
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f34, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f48, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091f08, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091f44, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f091f45, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091f43, postData.s().getName_show());
                    }
                    jr7 jr7Var12 = this.t;
                    if (jr7Var12 != null && jr7Var12.O() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091f47, this.t.O().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091f46, postData.J());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f48, Boolean.FALSE);
                }
                if (!z2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f32, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091f05, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef4, Boolean.valueOf(z4));
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef5, Integer.valueOf(i2));
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef3, postData.J());
                    jr7 jr7Var13 = this.t;
                    if (jr7Var13 != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091f10, Integer.valueOf(jr7Var13.V()));
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f32, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091f09, Boolean.valueOf(z5));
                f0(pbFirstFloorViewHolder);
            }
        }
        z3 = false;
        z4 = false;
        z5 = false;
        if (postData.s() != null) {
            z2 = true;
            z4 = true;
        }
        if (z7) {
        }
        if (postData.B() == 1) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091f01, postData.J());
        if (!z) {
        }
        if (!z3) {
        }
        if (!z2) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091f09, Boolean.valueOf(z5));
        f0(pbFirstFloorViewHolder);
    }

    public final void i0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view2, int i) {
        PostData postData2;
        sr7 sr7Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048587, this, pbFirstFloorViewHolder, postData, view2, i) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        pbFirstFloorViewHolder.e.setTag(sparseArray);
        pbFirstFloorViewHolder.b.setTag(R.id.obfuscated_res_0x7f091f04, sparseArray);
        sparseArray.put(R.id.obfuscated_res_0x7f091ef1, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091f0a, Boolean.FALSE);
        pbFirstFloorViewHolder.e.setIsHost(true);
        if (this.q) {
            pbFirstFloorViewHolder.f.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.f.setVisibility(8);
        }
        List<CardLinkInfoData> list = null;
        if (!TextUtils.isEmpty(postData.t()) && this.p) {
            this.E = true;
            pbFirstFloorViewHolder.e.l0(postData.t(), new d(this, pbFirstFloorViewHolder, postData, view2, i));
        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.e.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            pbFirstFloorViewHolder.e.setLayoutParams(layoutParams);
            pbFirstFloorViewHolder.e.k0(null);
            this.E = false;
            h0(pbFirstFloorViewHolder, postData, view2, i);
        }
        jr7 jr7Var = this.t;
        if (jr7Var != null && jr7Var.O() != null && this.t.O().isVideoThreadType() && this.t.O().getThreadVideoInfo() != null && oi.isEmpty(this.t.l().getName())) {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
        } else if (postData.Q() != null && !ListUtils.isEmpty(postData.Q().C())) {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
        } else {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
        }
        if (postData.Q() != null) {
            if (postData.Q().D() > 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.m.getLayoutParams();
                layoutParams2.topMargin = Z(R.dimen.tbds26);
                pbFirstFloorViewHolder.m.setLayoutParams(layoutParams2);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.m.getLayoutParams();
                layoutParams3.topMargin = Z(R.dimen.tbds16);
                pbFirstFloorViewHolder.m.setLayoutParams(layoutParams3);
            }
        }
        jr7 jr7Var2 = this.t;
        if (jr7Var2 != null && q0(jr7Var2.O())) {
            pbFirstFloorViewHolder.w.setDataForPb(this.t.O().getPollData(), this.t.O().getTid(), this.t.m());
            if (postData.Q() != null && !ListUtils.isEmpty(postData.Q().C())) {
                pbFirstFloorViewHolder.w.setMarginTop(pi.f(this.F, R.dimen.tbds26));
            } else {
                pbFirstFloorViewHolder.w.setMarginTop(pi.f(this.F, R.dimen.tbds0));
            }
            pbFirstFloorViewHolder.w.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.w.setVisibility(8);
        }
        jr7 jr7Var3 = this.t;
        if (jr7Var3 != null && jr7Var3.O() != null && this.t.O().getSmartApp() != null && this.t.O().getThreadVideoInfo() == null) {
            pbFirstFloorViewHolder.m.setData(this.t.O().getSmartApp());
            pbFirstFloorViewHolder.m.setVisibility(0);
            jr7 jr7Var4 = this.t;
            if (jr7Var4 != null && jr7Var4.l() != null) {
                pbFirstFloorViewHolder.m.setForumId(String.valueOf(this.t.l().getId()));
            }
            jr7 jr7Var5 = this.t;
            if (jr7Var5 != null && jr7Var5.Q() != null) {
                pbFirstFloorViewHolder.m.setThreadId(this.t.Q());
            }
            pbFirstFloorViewHolder.m.setFrom("PB_card");
        } else {
            pbFirstFloorViewHolder.m.setVisibility(8);
        }
        if (NovelPaySwitch.isOn() && postData.O() != null && !postData.O().i() && this.t.j0()) {
            this.s = true;
            pbFirstFloorViewHolder.n.setVisibility(0);
            pbFirstFloorViewHolder.o.setVisibility(0);
            pbFirstFloorViewHolder.o.setData(postData.O());
            pbFirstFloorViewHolder.o.setStatisticData(this.t.Q(), this.t.m());
        } else {
            pbFirstFloorViewHolder.n.setVisibility(8);
            pbFirstFloorViewHolder.o.setVisibility(8);
        }
        jr7 jr7Var6 = this.t;
        if (jr7Var6 != null && (sr7Var = jr7Var6.h) != null) {
            if (pbFirstFloorViewHolder.l != null) {
                if (TextUtils.isEmpty(sr7Var.e())) {
                    pbFirstFloorViewHolder.l.setVisibility(8);
                } else {
                    pbFirstFloorViewHolder.l.setVisibility(0);
                    pbFirstFloorViewHolder.l.setText(this.t.h.e());
                }
            }
            if (pbFirstFloorViewHolder.k != null && pbFirstFloorViewHolder.v.h() == null) {
                pbFirstFloorViewHolder.k.addView(pbFirstFloorViewHolder.v.a(this.t));
                String fromPageKey = UtilHelper.getFromPageKey(this.j.getPageContext());
                Context context = this.F;
                if (!(context instanceof AbsPbActivity) || ((AbsPbActivity) context).getIntent() == null) {
                    z = false;
                } else {
                    z = ((AbsPbActivity) this.F).getIntent().getBooleanExtra("is_from_bar_vote", false);
                    if (z) {
                        new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 1).eventStat();
                    }
                }
                if (fromPageKey != null && !z) {
                    if (fromPageKey.equals("a002")) {
                        new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 3).eventStat();
                    } else if (fromPageKey.equals("a006")) {
                        new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 2).eventStat();
                    } else if (fromPageKey.equals("a026")) {
                        new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 4).eventStat();
                    }
                }
            }
        }
        LinearLayout linearLayout = pbFirstFloorViewHolder.p;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        jr7 jr7Var7 = this.t;
        if (jr7Var7 != null && jr7Var7.F() != null && this.t.F().size() > 0 && (postData2 = this.t.F().get(0)) != null) {
            list = postData2.u();
        }
        jr7 jr7Var8 = this.t;
        if (jr7Var8 != null && jr7Var8.O() != null && !q0(this.t.O()) && (!ListUtils.isEmpty(this.t.O().getLinkDataList()) || !ListUtils.isEmpty(this.t.O().getGoodsDataList()) || !ListUtils.isEmpty(list))) {
            me5 me5Var = new me5();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.F);
            jr7 jr7Var9 = this.t;
            pbLinkGoodsRootView.i(jr7Var9, me5Var.b(jr7Var9.O().getLinkDataList(), this.t.O().getGoodsDataList(), list), this.t.n(), this.j, me5Var.c());
            pbFirstFloorViewHolder.p.addView(pbLinkGoodsRootView);
            pbFirstFloorViewHolder.p.setVisibility(0);
            return;
        }
        pbFirstFloorViewHolder.p.setVisibility(8);
    }

    public final void j0(PbFirstFloorViewHolder pbFirstFloorViewHolder, gp4 gp4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, pbFirstFloorViewHolder, gp4Var) == null) || gp4Var == null || oi.isEmpty(gp4Var.e()) || gp4Var.c() != gp4.g) {
            return;
        }
        if (!gp4Var.f()) {
            pbFirstFloorViewHolder.e.getLayoutStrategy().m(pi.f(this.F, R.dimen.obfuscated_res_0x7f0702cb));
        }
        pbFirstFloorViewHolder.q.c(gp4Var);
    }

    public final void k0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, pbFirstFloorViewHolder, postData) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        pbFirstFloorViewHolder.r.setVisibility(0);
        if (pbFirstFloorViewHolder.s == null) {
            pbFirstFloorViewHolder.s = n0(postData);
        }
        if (pbFirstFloorViewHolder.r.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.s.a()) != null) {
            pbFirstFloorViewHolder.r.addView(a2);
        }
        pbFirstFloorViewHolder.s.e(this.I);
        pbFirstFloorViewHolder.s.d(this.J);
        pbFirstFloorViewHolder.s.c(postData.P());
        pbFirstFloorViewHolder.s.b(this.j.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.v = onClickListener;
        }
    }

    public final void l0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, pbFirstFloorViewHolder, postData, tbRichText) == null) {
            if (postData != null && postData.V() != null) {
                sz7.c(postData.V(), pbFirstFloorViewHolder.j, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.t()));
            } else {
                pbFirstFloorViewHolder.j.setVisibility(8);
            }
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.o = i;
        }
    }

    public final int m0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) ? pi.f(TbadkCoreApplication.getInst().getContext(), i) : invokeI.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final uw7 n0(PostData postData) {
        InterceptResult invokeL;
        uw7 uw7Var;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048594, this, postData)) != null) {
            return (uw7) invokeL.objValue;
        }
        if (postData != null && postData.P() != null && postData.P().j()) {
            BaijiahaoData baijiahaoData = postData.P().p;
            Item item = postData.P().C;
            if (!postData.P().m && !postData.M0()) {
                if (item != null && item.item_id.longValue() != 0) {
                    if (postData.P().a != 0 && postData.P().a != 1) {
                        if (postData.P().a == 3) {
                            uw7Var = new ax7(this.j.getPageContext());
                        } else {
                            uw7Var = new yw7(this.j.getPageContext());
                        }
                    } else {
                        uw7Var = new zw7(this.j.getPageContext());
                    }
                } else if (baijiahaoData != null && postData.P().k()) {
                    int i = baijiahaoData.oriUgcType;
                    if (i == 1) {
                        uw7Var = new vw7(this.j.getPageContext(), this.G);
                    } else if (i == 2) {
                        uw7Var = new cx7(this.j.getPageContext(), this.G);
                    } else if (i == 3) {
                        uw7Var = new bx7(this.j.getPageContext(), this.G);
                    } else if (i != 4) {
                        uw7Var = new ww7(this.j.getPageContext(), this.G);
                    } else {
                        uw7Var = new cx7(this.j.getPageContext(), this.G);
                    }
                } else if (postData.P().a != 0 && postData.P().a != 1) {
                    if (postData.P().a == 3) {
                        uw7Var = new cx7(this.j.getPageContext(), this.G);
                    }
                } else {
                    uw7Var = new bx7(this.j.getPageContext(), this.G);
                }
            } else {
                uw7Var = new xw7(this.j.getPageContext(), this.G);
            }
            return uw7Var != null ? new ww7(this.j.getPageContext(), this.G) : uw7Var;
        }
        uw7Var = null;
        if (uw7Var != null) {
        }
    }

    public void o(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, yVar) == null) {
            this.x = yVar;
        }
    }

    public PbFirstFloorViewHolder o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (PbFirstFloorViewHolder) this.g : (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            jr7 jr7Var = this.t;
            if (jr7Var == null || jr7Var.O() == null) {
                return false;
            }
            return this.t.O().isBlocked();
        }
        return invokeV.booleanValue;
    }

    public final boolean q0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, threadData)) == null) ? (threadData == null || threadData.getPollData() == null || threadData.getPollData().getOptions() == null || threadData.getPollData().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: r0 */
    public PbFirstFloorViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.j.getPageContext(), LayoutInflater.from(this.F).inflate(R.layout.obfuscated_res_0x7f0d060c, viewGroup, false), this.p, this.o);
            C0(pbFirstFloorViewHolder);
            pbFirstFloorViewHolder.q.f(this.G);
            return pbFirstFloorViewHolder;
        }
        return (PbFirstFloorViewHolder) invokeL.objValue;
    }

    public void s(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, jr7Var) == null) {
            this.t = jr7Var;
        }
    }

    public View s0(int i, View view2, ViewGroup viewGroup, PostData postData, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        InterceptResult invokeCommon;
        BdTypeListView listView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), view2, viewGroup, postData, pbFirstFloorViewHolder})) == null) {
            super.S(i, view2, viewGroup, postData, pbFirstFloorViewHolder);
            C0(pbFirstFloorViewHolder);
            x0(pbFirstFloorViewHolder);
            PostData postData2 = (PostData) y(i);
            if (postData2 != null) {
                postData2.P0();
                postData2.b0 = i + 1;
                fy7.d(this.j.getUniqueId(), this.t, postData2, postData2.b0, 1);
                i0(pbFirstFloorViewHolder, postData2, view2, i);
            }
            if (!this.C && this.D && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.e.G() && (listView = this.j.getListView()) != null) {
                this.C = true;
                CompatibleUtile.getInstance().closeViewGpu(listView);
            }
            pbFirstFloorViewHolder.x.setVisibility(8);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void t0(boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048602, this, z) == null) && (pbModel = this.r) != null && z && this.s) {
            pbModel.l3(3);
        }
    }

    public void u0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (v = this.g) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).q.d();
    }

    public void v0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (v = this.g) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).q.a();
        ((PbFirstFloorViewHolder) this.g).u.g();
        ((PbFirstFloorViewHolder) this.g).o.i();
    }

    public void w0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (v = this.g) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).q.e();
        ((PbFirstFloorViewHolder) this.g).o.j();
    }

    public final void x0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.b.setOnTouchListener(this.y);
            pbFirstFloorViewHolder.b.setOnLongClickListener(this.z);
            rw7 rw7Var = this.i.N().d;
            pbFirstFloorViewHolder.e.setOnLongClickListener(this.z);
            pbFirstFloorViewHolder.e.setOnTouchListener(this.H);
            pbFirstFloorViewHolder.e.setItemOrderOrDownloadListener(this.B);
            pbFirstFloorViewHolder.e.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.e.setCommonTextViewOnClickListener(this.w);
            pbFirstFloorViewHolder.e.setOnImageClickListener(this.x);
            pbFirstFloorViewHolder.e.setOnImageTouchListener(this.H);
            pbFirstFloorViewHolder.e.setmGridEmptyClickListener(new e(this));
            pbFirstFloorViewHolder.e.setOnEmotionClickListener(rw7Var.f);
            pbFirstFloorViewHolder.j.setOnClickListener(this.w);
            pbFirstFloorViewHolder.t.setAfterItemClickListener(this.w);
            pbFirstFloorViewHolder.u.setAfterItemClickListener(this.w);
        }
    }

    public void y0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) {
            this.B = onClickListener;
        }
    }

    public void z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.q = z;
        }
    }
}
