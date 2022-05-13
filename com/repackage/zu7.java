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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
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
import com.repackage.dt7;
import com.repackage.zx;
import java.util.Locale;
import tbclient.Item;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class zu7 extends vu7<PostData, PbFirstFloorViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView.s A;
    public View.OnClickListener B;
    public boolean C;
    public final boolean D;
    public boolean E;
    public Context F;
    public int G;
    public dt7 H;
    public ux5<zn4> I;
    public zx.a J;
    public int o;
    public boolean p;
    public boolean q;
    public PbModel r;
    public boolean s;
    public bs7 t;
    public ey7 u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public TbRichTextView.y x;
    public dt7 y;
    public View.OnLongClickListener z;

    /* loaded from: classes7.dex */
    public class a implements dt7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zu7 a;

        public a(zu7 zu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zu7Var;
        }

        @Override // com.repackage.dt7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
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

        @Override // com.repackage.dt7.a
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

    /* loaded from: classes7.dex */
    public class b extends ux5<zn4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zu7 b;

        public b(zu7 zu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zu7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, zn4 zn4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zn4Var) == null) {
                super.a(view2, zn4Var);
                if (zn4Var == null || zn4Var.getThreadData() == null || zn4Var.getThreadData().originalThreadData == null || this.b.t == null) {
                    return;
                }
                OriginalThreadInfo originalThreadInfo = zn4Var.getThreadData().originalThreadData;
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

    /* loaded from: classes7.dex */
    public class c implements zx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zu7 a;

        public c(zu7 zu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zu7Var;
        }

        @Override // com.repackage.zx.a
        public void a(zn4 zn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, zn4Var) == null) || zn4Var == null || zn4Var.getThreadData() == null || zn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            OriginalThreadInfo originalThreadInfo = zn4Var.getThreadData().originalThreadData;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.F);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f, originalThreadInfo.n, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.e));
            pbActivityConfig.setStartFrom(this.a.G);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    /* loaded from: classes7.dex */
    public class d implements TbRichTextView.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ View c;
        public final /* synthetic */ int d;
        public final /* synthetic */ zu7 e;

        public d(zu7 zu7Var, PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu7Var, pbFirstFloorViewHolder, postData, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zu7Var;
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

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public e(zu7 zu7Var, PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu7Var, pbFirstFloorViewHolder, postData, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFirstFloorViewHolder;
            this.b = postData;
            this.c = str;
            this.d = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r.m();
                d85.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_CLICK, String.valueOf(this.b.N().h()), this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(zu7 zu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu7Var};
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
    public zu7(PbFragment pbFragment, BdUniqueId bdUniqueId) {
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
                super((gz7) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.H = new dt7(new a(this));
        this.I = new b(this);
        this.J = new c(this);
        if (pbFragment != null && pbFragment.v() != null) {
            this.G = pbFragment.v().O1();
            this.r = pbFragment.v();
        }
        this.F = pbFragment.getContext();
    }

    public void A0(dt7 dt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dt7Var) == null) {
            this.y = dt7Var;
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
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.A, R.color.CAM_X0202);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.f, R.color.CAM_X0204);
            pbFirstFloorViewHolder.e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbFirstFloorViewHolder.m.c();
            pbFirstFloorViewHolder.r.l();
            ThreadForumEnterButtonContainer threadForumEnterButtonContainer = pbFirstFloorViewHolder.w;
            if (threadForumEnterButtonContainer != null) {
                threadForumEnterButtonContainer.a();
            }
            PbBusinessPromotionContainer pbBusinessPromotionContainer = pbFirstFloorViewHolder.x;
            if (pbBusinessPromotionContainer != null) {
                pbBusinessPromotionContainer.h();
            }
            SkinManager.setViewTextColor(pbFirstFloorViewHolder.l, (int) R.color.CAM_X0107);
            pbFirstFloorViewHolder.y.i(skinType);
            VoteView voteView = pbFirstFloorViewHolder.z;
            if (voteView != null) {
                voteView.C(skinType);
            }
            SkinManager.setBackgroundColorToTransparent(pbFirstFloorViewHolder.n, R.color.CAM_X0201, GradientDrawable.Orientation.BOTTOM_TOP);
            gs4 d2 = gs4.d(pbFirstFloorViewHolder.q);
            d2.A(R.string.F_X01);
            d2.v(R.color.CAM_X0311);
            SkinManager.setBackgroundShapeDrawable(pbFirstFloorViewHolder.o, mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50), R.color.CAM_X0328, R.color.CAM_X0207);
            WebPManager.setPureDrawable(pbFirstFloorViewHolder.p, R.drawable.obfuscated_res_0x7f0808fb, R.color.CAM_X0311, WebPManager.ResourceStateType.NORMAL);
            pbFirstFloorViewHolder.o.getBackground().setAlpha(90);
        }
        pbFirstFloorViewHolder.a = TbadkCoreApplication.getInst().getSkinType();
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PbFirstFloorViewHolder o0 = o0();
            bs7 bs7Var = this.t;
            if (bs7Var == null || bs7Var.O() == null || o0 == null) {
                return;
            }
            o0.e(this.t, this.t.O().getIs_good() == 1, this.t.O().getIs_top() == 1);
        }
    }

    @Override // com.repackage.vu7, com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        s0(i, view2, viewGroup, (PostData) obj, (PbFirstFloorViewHolder) viewHolder);
        return view2;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.p = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.z = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public final void f0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.e.setTextViewOnTouchListener(this.H);
            pbFirstFloorViewHolder.e.setTextViewCheckSelection(false);
        }
    }

    public final void g0(TbRichTextView tbRichTextView, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048586, this, tbRichTextView, view2, z) == null) || tbRichTextView == null) {
            return;
        }
        int min = Math.min(((((mi.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - (z ? Z(R.dimen.obfuscated_res_0x7f070275) : 0), this.o);
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
        if (!(interceptable == null || interceptable.invokeLLLI(1048587, this, pbFirstFloorViewHolder, postData, view2, i) == null) || this.t == null) {
            return;
        }
        TbRichText tbRichText = null;
        if (postData.A() != 1) {
            if (TextUtils.isEmpty(postData.u())) {
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
        if (postData.A() == 1) {
            pbFirstFloorViewHolder.d(this.t, this.j.isSimpleForum(), postData.O);
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
            bs7 bs7Var = this.t;
            if (bs7Var != null && bs7Var.O() != null) {
                pbFirstFloorViewHolder.t.b(postData.H(), str, str2, j, kg.g(this.t.O().getId(), 0L), kg.g(postData.I(), 0L));
            }
            if (this.j.Q4().O1()) {
                pbFirstFloorViewHolder.e.setVisibility(8);
            }
            bs7 bs7Var2 = this.t;
            if (bs7Var2 != null && bs7Var2.O() != null && this.t.O().getYulePostActivityData() != null) {
                lr4 yulePostActivityData = this.t.O().getYulePostActivityData();
                String a2 = yulePostActivityData.a();
                if (StringUtils.isNull(yulePostActivityData.b())) {
                    return;
                }
                if (!StringUtils.isNull(a2)) {
                    pbFirstFloorViewHolder.h.setVisibility(0);
                    pbFirstFloorViewHolder.h.K(a2, 10, true);
                }
            } else {
                pbFirstFloorViewHolder.h.setVisibility(8);
            }
            ThreadSkinView threadSkinView = pbFirstFloorViewHolder.i;
            if (threadSkinView != null) {
                threadSkinView.setVisibility(8);
            }
            bs7 bs7Var3 = this.t;
            if (bs7Var3 != null && bs7Var3.O() != null && this.t.O().isVideoThreadType() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.w) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.w.getPaddingRight(), pbFirstFloorViewHolder.w.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.e.getLayoutStrategy().x(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f091eae, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091eca, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091ecc, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f091ed8, Integer.valueOf(i));
        sparseArray.put(R.id.obfuscated_res_0x7f091ed7, Integer.valueOf(postData.A()));
        boolean z6 = postData.d0() || postData.c0(false);
        if (z6) {
            if (this.u == null) {
                ey7 ey7Var = new ey7(this.F);
                this.u = ey7Var;
                ey7Var.f(this.m);
                this.u.h(this.v);
                bs7 bs7Var4 = this.t;
                if (bs7Var4 != null) {
                    this.u.j(this.t.V(), TextUtils.equals(bs7Var4.O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.u.i(this.t.O());
                }
            }
            this.u.g(postData.I());
        }
        pbFirstFloorViewHolder.e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.p) {
            pbFirstFloorViewHolder.e.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f081221);
        } else {
            pbFirstFloorViewHolder.e.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.e.setIsFromCDN(this.m);
        bs7 bs7Var5 = this.t;
        if (bs7Var5 != null && bs7Var5.O() != null && this.t.O().isLinkThread()) {
            j0(pbFirstFloorViewHolder, this.t.O().getLinkThreadData());
        }
        bs7 bs7Var6 = this.t;
        if ((bs7Var6 == null || bs7Var6.O() == null || !this.t.O().isShareThread || postData.O() == null) ? false : true) {
            if (postData.O().C != null) {
                pbFirstFloorViewHolder.e.getLayoutStrategy().m(m0(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.e.getLayoutStrategy().m(m0(R.dimen.tbds14));
            }
            k0(pbFirstFloorViewHolder, postData);
        } else {
            pbFirstFloorViewHolder.e.getLayoutStrategy().m(m0(R.dimen.tbds24));
        }
        TbRichText P = postData.P();
        bs7 bs7Var7 = this.t;
        if (bs7Var7 == null || !bs7Var7.r0()) {
            tbRichText = P;
        }
        if (this.t.O() != null) {
            pbFirstFloorViewHolder.e.setTid(this.t.Q());
            pbFirstFloorViewHolder.e.setIsUseGridImage(this.t.O().isBJHNormalThreadType());
            pbFirstFloorViewHolder.e.setmIsGridImageSupportLongPress(true);
        }
        bs7 bs7Var8 = this.t;
        if (bs7Var8 != null && 3 == bs7Var8.g()) {
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
        bs7 bs7Var9 = this.t;
        if (bs7Var9 == null || bs7Var9.V() == 0 || p0()) {
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
        bs7 bs7Var10 = this.t;
        if (bs7Var10 != null && bs7Var10.O() != null && this.t.O().getAuthor() != null && postData.s() != null) {
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
                int i2 = postData.A() == 1 ? 0 : 1;
                sparseArray.put(R.id.obfuscated_res_0x7f091ebe, postData.I());
                if (!z) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.TRUE);
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ebb, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ebc, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ebd, postData.s().getPortrait());
                    }
                    bs7 bs7Var11 = this.t;
                    if (bs7Var11 != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ecd, Integer.valueOf(bs7Var11.V()));
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f03, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091ec5, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091eff, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f091f00, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091efe, postData.s().getName_show());
                    }
                    bs7 bs7Var12 = this.t;
                    if (bs7Var12 != null && bs7Var12.O() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091f02, this.t.O().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091f01, postData.I());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f03, Boolean.FALSE);
                }
                if (!z2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eee, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091ec2, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(z4));
                    sparseArray.put(R.id.obfuscated_res_0x7f091eb2, Integer.valueOf(i2));
                    sparseArray.put(R.id.obfuscated_res_0x7f091eb0, postData.I());
                    bs7 bs7Var13 = this.t;
                    if (bs7Var13 != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ecd, Integer.valueOf(bs7Var13.V()));
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eee, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091ec6, Boolean.valueOf(z5));
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
        if (postData.A() == 1) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091ebe, postData.I());
        if (!z) {
        }
        if (!z3) {
        }
        if (!z2) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091ec6, Boolean.valueOf(z5));
        f0(pbFirstFloorViewHolder);
    }

    public final void i0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view2, int i) {
        ks7 ks7Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048588, this, pbFirstFloorViewHolder, postData, view2, i) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        pbFirstFloorViewHolder.e.setTag(sparseArray);
        pbFirstFloorViewHolder.b.setTag(R.id.obfuscated_res_0x7f091ec1, sparseArray);
        sparseArray.put(R.id.obfuscated_res_0x7f091eae, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091ec7, Boolean.FALSE);
        pbFirstFloorViewHolder.e.setIsHost(true);
        if (this.q) {
            pbFirstFloorViewHolder.f.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(postData.u()) && this.p) {
            this.E = true;
            pbFirstFloorViewHolder.e.l0(postData.u(), new d(this, pbFirstFloorViewHolder, postData, view2, i));
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
        bs7 bs7Var = this.t;
        if (bs7Var != null && bs7Var.O() != null && this.t.O().isVideoThreadType() && this.t.O().getThreadVideoInfo() != null && li.isEmpty(this.t.l().getName())) {
            pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
        } else if (postData.P() != null && !ListUtils.isEmpty(postData.P().A())) {
            pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
        } else {
            pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
        }
        if (postData.P() != null) {
            if (postData.P().B() > 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.m.getLayoutParams();
                layoutParams2.topMargin = Z(R.dimen.tbds26);
                pbFirstFloorViewHolder.m.setLayoutParams(layoutParams2);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.m.getLayoutParams();
                layoutParams3.topMargin = Z(R.dimen.tbds16);
                pbFirstFloorViewHolder.m.setLayoutParams(layoutParams3);
            }
        }
        bs7 bs7Var2 = this.t;
        if (bs7Var2 != null && q0(bs7Var2.O())) {
            pbFirstFloorViewHolder.z.setDataForPb(this.t.O().getPollData(), this.t.O().getTid(), this.t.m());
            if (postData.P() != null && !ListUtils.isEmpty(postData.P().A())) {
                pbFirstFloorViewHolder.z.setMarginTop(mi.f(this.F, R.dimen.tbds26));
            } else {
                pbFirstFloorViewHolder.z.setMarginTop(mi.f(this.F, R.dimen.tbds0));
            }
            pbFirstFloorViewHolder.z.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.z.setVisibility(8);
        }
        bs7 bs7Var3 = this.t;
        if (bs7Var3 != null && bs7Var3.O() != null && this.t.O().getSmartApp() != null && this.t.O().getThreadVideoInfo() == null) {
            pbFirstFloorViewHolder.m.setData(this.t.O().getSmartApp());
            pbFirstFloorViewHolder.m.setVisibility(0);
            bs7 bs7Var4 = this.t;
            if (bs7Var4 != null && bs7Var4.l() != null) {
                pbFirstFloorViewHolder.m.setForumId(String.valueOf(this.t.l().getId()));
            }
            bs7 bs7Var5 = this.t;
            if (bs7Var5 != null && bs7Var5.Q() != null) {
                pbFirstFloorViewHolder.m.setThreadId(this.t.Q());
            }
            pbFirstFloorViewHolder.m.setFrom("PB_card");
        } else {
            pbFirstFloorViewHolder.m.setVisibility(8);
        }
        if (NovelPaySwitch.isOn() && postData.N() != null && !postData.N().k() && this.t.j0()) {
            String Q = this.t.Q();
            String m = this.t.m();
            pbFirstFloorViewHolder.r.setData(postData.N(), Q, m);
            pbFirstFloorViewHolder.n.setVisibility(0);
            pbFirstFloorViewHolder.r.setReadMoreButtonState(pbFirstFloorViewHolder.o);
            pbFirstFloorViewHolder.r.setVisibility(0);
            this.s = true;
            if (postData.N().i()) {
                pbFirstFloorViewHolder.o.setVisibility(8);
            } else {
                pbFirstFloorViewHolder.o.setVisibility(0);
                pbFirstFloorViewHolder.q.setText(String.format(Locale.CHINA, this.F.getString(R.string.obfuscated_res_0x7f0f0caf), Long.valueOf(postData.N().j()), String.valueOf(kg.c(postData.N().d(), 0.0d) / 100.0d)));
            }
            pbFirstFloorViewHolder.o.setOnClickListener(new e(this, pbFirstFloorViewHolder, postData, Q, m));
        } else {
            pbFirstFloorViewHolder.n.setVisibility(8);
            pbFirstFloorViewHolder.o.setVisibility(8);
            pbFirstFloorViewHolder.r.setVisibility(8);
        }
        D0();
        bs7 bs7Var6 = this.t;
        if (bs7Var6 != null && (ks7Var = bs7Var6.h) != null) {
            if (pbFirstFloorViewHolder.l != null) {
                if (TextUtils.isEmpty(ks7Var.e())) {
                    pbFirstFloorViewHolder.l.setVisibility(8);
                } else {
                    pbFirstFloorViewHolder.l.setVisibility(0);
                    pbFirstFloorViewHolder.l.setText(this.t.h.e());
                }
            }
            if (pbFirstFloorViewHolder.k != null && pbFirstFloorViewHolder.y.h() == null) {
                pbFirstFloorViewHolder.k.addView(pbFirstFloorViewHolder.y.a(this.t));
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
        LinearLayout linearLayout = pbFirstFloorViewHolder.s;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        bs7 bs7Var7 = this.t;
        if (bs7Var7 != null && bs7Var7.O() != null && !q0(this.t.O()) && (!ListUtils.isEmpty(this.t.O().getLinkDataList()) || !ListUtils.isEmpty(this.t.O().getGoodsDataList()))) {
            ae5 ae5Var = new ae5();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.F);
            bs7 bs7Var8 = this.t;
            pbLinkGoodsRootView.i(bs7Var8, ae5Var.a(bs7Var8.O().getLinkDataList(), this.t.O().getGoodsDataList()), this.t.n(), this.j, ae5Var.b());
            pbFirstFloorViewHolder.s.addView(pbLinkGoodsRootView);
            pbFirstFloorViewHolder.s.setVisibility(0);
            return;
        }
        pbFirstFloorViewHolder.s.setVisibility(8);
    }

    public final void j0(PbFirstFloorViewHolder pbFirstFloorViewHolder, rp4 rp4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, pbFirstFloorViewHolder, rp4Var) == null) || rp4Var == null || li.isEmpty(rp4Var.e()) || rp4Var.c() != rp4.g) {
            return;
        }
        if (!rp4Var.f()) {
            pbFirstFloorViewHolder.e.getLayoutStrategy().m(mi.f(this.F, R.dimen.obfuscated_res_0x7f0702ce));
        }
        pbFirstFloorViewHolder.t.c(rp4Var);
    }

    public final void k0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, pbFirstFloorViewHolder, postData) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        pbFirstFloorViewHolder.u.setVisibility(0);
        if (pbFirstFloorViewHolder.v == null) {
            pbFirstFloorViewHolder.v = n0(postData);
        }
        if (pbFirstFloorViewHolder.u.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.v.a()) != null) {
            pbFirstFloorViewHolder.u.addView(a2);
        }
        pbFirstFloorViewHolder.v.e(this.I);
        pbFirstFloorViewHolder.v.d(this.J);
        pbFirstFloorViewHolder.v.c(postData.O());
        pbFirstFloorViewHolder.v.b(this.j.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.v = onClickListener;
        }
    }

    public final void l0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, pbFirstFloorViewHolder, postData, tbRichText) == null) {
            if (postData != null && postData.U() != null) {
                i08.c(postData.U(), pbFirstFloorViewHolder.j, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.u()));
            } else {
                pbFirstFloorViewHolder.j.setVisibility(8);
            }
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.o = i;
        }
    }

    public final int m0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) ? mi.f(TbadkCoreApplication.getInst().getContext(), i) : invokeI.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final kx7 n0(PostData postData) {
        InterceptResult invokeL;
        kx7 kx7Var;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048595, this, postData)) != null) {
            return (kx7) invokeL.objValue;
        }
        if (postData != null && postData.O() != null && postData.O().j()) {
            BaijiahaoData baijiahaoData = postData.O().p;
            Item item = postData.O().C;
            if (!postData.O().m && !postData.I0()) {
                if (item != null && item.item_id.longValue() != 0) {
                    if (postData.O().a != 0 && postData.O().a != 1) {
                        if (postData.O().a == 3) {
                            kx7Var = new qx7(this.j.getPageContext());
                        } else {
                            kx7Var = new ox7(this.j.getPageContext());
                        }
                    } else {
                        kx7Var = new px7(this.j.getPageContext());
                    }
                } else if (baijiahaoData != null && postData.O().k()) {
                    int i = baijiahaoData.oriUgcType;
                    if (i == 1) {
                        kx7Var = new lx7(this.j.getPageContext(), this.G);
                    } else if (i == 2) {
                        kx7Var = new sx7(this.j.getPageContext(), this.G);
                    } else if (i == 3) {
                        kx7Var = new rx7(this.j.getPageContext(), this.G);
                    } else if (i != 4) {
                        kx7Var = new mx7(this.j.getPageContext(), this.G);
                    } else {
                        kx7Var = new sx7(this.j.getPageContext(), this.G);
                    }
                } else if (postData.O().a != 0 && postData.O().a != 1) {
                    if (postData.O().a == 3) {
                        kx7Var = new sx7(this.j.getPageContext(), this.G);
                    }
                } else {
                    kx7Var = new rx7(this.j.getPageContext(), this.G);
                }
            } else {
                kx7Var = new nx7(this.j.getPageContext(), this.G);
            }
            return kx7Var != null ? new mx7(this.j.getPageContext(), this.G) : kx7Var;
        }
        kx7Var = null;
        if (kx7Var != null) {
        }
    }

    public void o(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, yVar) == null) {
            this.x = yVar;
        }
    }

    public PbFirstFloorViewHolder o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (PbFirstFloorViewHolder) this.g : (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            bs7 bs7Var = this.t;
            if (bs7Var == null || bs7Var.O() == null) {
                return false;
            }
            return this.t.O().isBlocked();
        }
        return invokeV.booleanValue;
    }

    public final boolean q0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, threadData)) == null) ? (threadData == null || threadData.getPollData() == null || threadData.getPollData().getOptions() == null || threadData.getPollData().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: r0 */
    public PbFirstFloorViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.j.getPageContext(), LayoutInflater.from(this.F).inflate(R.layout.obfuscated_res_0x7f0d05f3, viewGroup, false), this.p, this.o);
            C0(pbFirstFloorViewHolder);
            pbFirstFloorViewHolder.t.f(this.G);
            return pbFirstFloorViewHolder;
        }
        return (PbFirstFloorViewHolder) invokeL.objValue;
    }

    public View s0(int i, View view2, ViewGroup viewGroup, PostData postData, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        InterceptResult invokeCommon;
        BdTypeListView listView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), view2, viewGroup, postData, pbFirstFloorViewHolder})) == null) {
            super.S(i, view2, viewGroup, postData, pbFirstFloorViewHolder);
            C0(pbFirstFloorViewHolder);
            x0(pbFirstFloorViewHolder);
            PostData postData2 = (PostData) z(i);
            if (postData2 != null) {
                postData2.L0();
                postData2.h0 = i + 1;
                vy7.d(this.j.getUniqueId(), this.t, postData2, postData2.h0, 1);
                i0(pbFirstFloorViewHolder, postData2, view2, i);
            }
            if (!this.C && this.D && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.e.G() && (listView = this.j.getListView()) != null) {
                this.C = true;
                CompatibleUtile.getInstance().closeViewGpu(listView);
            }
            pbFirstFloorViewHolder.A.setVisibility(8);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void t(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bs7Var) == null) {
            this.t = bs7Var;
        }
    }

    public void t0(boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048603, this, z) == null) && (pbModel = this.r) != null && z && this.s) {
            pbModel.j3(3);
        }
    }

    public void u0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (v = this.g) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).t.d();
    }

    public void v0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (v = this.g) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).t.a();
        ((PbFirstFloorViewHolder) this.g).x.g();
        ((PbFirstFloorViewHolder) this.g).r.n();
    }

    public void w0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (v = this.g) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).t.e();
        ((PbFirstFloorViewHolder) this.g).r.o();
    }

    public final void x0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.b.setOnTouchListener(this.y);
            pbFirstFloorViewHolder.b.setOnLongClickListener(this.z);
            hx7 hx7Var = this.i.w().mEvent;
            pbFirstFloorViewHolder.e.setOnLongClickListener(this.z);
            pbFirstFloorViewHolder.e.setOnTouchListener(this.H);
            pbFirstFloorViewHolder.e.setItemOrderOrDownloadListener(this.B);
            pbFirstFloorViewHolder.e.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.e.setCommonTextViewOnClickListener(this.w);
            pbFirstFloorViewHolder.e.setOnImageClickListener(this.x);
            pbFirstFloorViewHolder.e.setOnImageTouchListener(this.H);
            pbFirstFloorViewHolder.e.setmGridEmptyClickListener(new f(this));
            pbFirstFloorViewHolder.e.setOnEmotionClickListener(hx7Var.e);
            pbFirstFloorViewHolder.j.setOnClickListener(this.w);
            pbFirstFloorViewHolder.w.setAfterItemClickListener(this.w);
            pbFirstFloorViewHolder.x.setAfterItemClickListener(this.w);
        }
    }

    public void y0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
            this.B = onClickListener;
        }
    }

    public void z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.q = z;
        }
    }
}
