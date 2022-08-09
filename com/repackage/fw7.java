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
import com.repackage.hu7;
import com.repackage.rw;
import java.util.List;
import tbclient.FullLengthNovel;
import tbclient.Item;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class fw7 extends bw7<PostData, PbFirstFloorViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hu7 A;
    public b06<fo4> B;
    public rw.a C;
    public int g;
    public boolean h;
    public boolean i;
    public PbModel j;
    public boolean k;
    public ft7 l;
    public rz7 m;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public TbRichTextView.y p;
    public hu7 q;
    public View.OnLongClickListener r;
    public TbRichTextView.s s;
    public View.OnClickListener t;
    public boolean u;
    public final boolean v;
    public boolean w;
    public Context x;
    public boolean y;
    public int z;

    /* loaded from: classes6.dex */
    public class a implements hu7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public a(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // com.repackage.hu7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.hu7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.q != null) {
                    this.a.q.a(view2);
                    this.a.q.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.hu7.a
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
    public class b extends b06<fo4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 b;

        public b(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, fo4 fo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, fo4Var) == null) {
                super.a(view2, fo4Var);
                if (fo4Var == null || fo4Var.getThreadData() == null || fo4Var.getThreadData().originalThreadData == null || this.b.l == null) {
                    return;
                }
                OriginalThreadInfo originalThreadInfo = fo4Var.getThreadData().originalThreadData;
                String Q = this.b.l.Q();
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
    public class c implements rw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public c(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // com.repackage.rw.a
        public void a(fo4 fo4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fo4Var) == null) || fo4Var == null || fo4Var.getThreadData() == null || fo4Var.getThreadData().originalThreadData == null) {
                return;
            }
            OriginalThreadInfo originalThreadInfo = fo4Var.getThreadData().originalThreadData;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.x);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f, originalThreadInfo.n, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.e));
            pbActivityConfig.setStartFrom(this.a.z);
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
        public final /* synthetic */ fw7 e;

        public d(fw7 fw7Var, PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, pbFirstFloorViewHolder, postData, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = fw7Var;
            this.a = pbFirstFloorViewHolder;
            this.b = postData;
            this.c = view2;
            this.d = i;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.v
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.f.getLayoutParams();
                layoutParams.topMargin = this.e.s(R.dimen.obfuscated_res_0x7f0701be);
                int s = this.e.s(R.dimen.obfuscated_res_0x7f07020f);
                layoutParams.bottomMargin = s;
                layoutParams.leftMargin = s;
                layoutParams.rightMargin = s;
                this.a.f.setLayoutParams(layoutParams);
                this.e.B(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
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
    public fw7(PbFragment pbFragment, BdUniqueId bdUniqueId) {
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
                super((t08) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = 0;
        boolean z = true;
        this.h = true;
        this.i = true;
        this.k = false;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = false;
        int i3 = Build.VERSION.SDK_INT;
        this.v = (i3 < 14 || i3 > 16) ? false : false;
        this.w = false;
        this.z = 0;
        this.A = new hu7(new a(this));
        this.B = new b(this);
        this.C = new c(this);
        if (pbFragment != null && pbFragment.K() != null) {
            this.z = pbFragment.K().P1();
            this.j = pbFragment.K();
        }
        this.x = pbFragment.getContext();
    }

    public final String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            return skinType != 1 ? skinType != 4 ? "default" : "dark" : "night";
        }
        return (String) invokeV.objValue;
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
    public final void B(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view2, int i) {
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
        if (!(interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbFirstFloorViewHolder, postData, view2, i) == null) || this.l == null) {
            return;
        }
        TbRichText tbRichText = null;
        if (postData.B() != 1) {
            if (TextUtils.isEmpty(postData.t())) {
                pbFirstFloorViewHolder.f.setOnClickListener(this.o);
                pbFirstFloorViewHolder.f.setTextViewOnClickListener(this.o);
            } else {
                pbFirstFloorViewHolder.f.setOnClickListener(null);
                pbFirstFloorViewHolder.f.setTextViewOnClickListener(null);
            }
            pbFirstFloorViewHolder.c.setOnClickListener(this.o);
        } else {
            pbFirstFloorViewHolder.c.setOnClickListener(null);
        }
        if (postData.B() == 1) {
            pbFirstFloorViewHolder.c(this.l, this.b.u0(), postData.O);
            z(pbFirstFloorViewHolder.f, view2, this.w);
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
            ft7 ft7Var = this.l;
            if (ft7Var != null && ft7Var.O() != null) {
                pbFirstFloorViewHolder.s.b(postData.I(), str, str2, j, og.g(this.l.O().getId(), 0L), og.g(postData.K(), 0L));
            }
            if (this.b.S5().S1()) {
                pbFirstFloorViewHolder.f.setVisibility(8);
            }
            ft7 ft7Var2 = this.l;
            if (ft7Var2 != null && ft7Var2.O() != null && this.l.O().getYulePostActivityData() != null) {
                sr4 yulePostActivityData = this.l.O().getYulePostActivityData();
                String a2 = yulePostActivityData.a();
                if (StringUtils.isNull(yulePostActivityData.b())) {
                    return;
                }
                if (!StringUtils.isNull(a2)) {
                    pbFirstFloorViewHolder.i.setVisibility(0);
                    pbFirstFloorViewHolder.i.K(a2, 10, true);
                }
            } else {
                pbFirstFloorViewHolder.i.setVisibility(8);
            }
            ThreadSkinView threadSkinView = pbFirstFloorViewHolder.j;
            if (threadSkinView != null) {
                threadSkinView.setVisibility(8);
            }
            ft7 ft7Var3 = this.l;
            if (ft7Var3 != null && ft7Var3.O() != null && this.l.O().isVideoThreadType() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.v) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.v.getPaddingRight(), pbFirstFloorViewHolder.v.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.f.getLayoutStrategy().x(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f091fe8, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092005, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092007, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f092016, Integer.valueOf(i));
        sparseArray.put(R.id.obfuscated_res_0x7f092015, Integer.valueOf(postData.B()));
        boolean z6 = postData.n0() || postData.m0(false);
        if (z6) {
            if (this.m == null) {
                rz7 rz7Var = new rz7(this.x);
                this.m = rz7Var;
                rz7Var.f(this.e);
                this.m.h(this.n);
                ft7 ft7Var4 = this.l;
                if (ft7Var4 != null) {
                    this.m.j(this.l.W(), TextUtils.equals(ft7Var4.O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.m.i(this.l.O());
                }
            }
            this.m.g(postData.K());
        }
        pbFirstFloorViewHolder.f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.h) {
            pbFirstFloorViewHolder.f.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f08120f);
        } else {
            pbFirstFloorViewHolder.f.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.f.setIsFromCDN(this.e);
        ft7 ft7Var5 = this.l;
        if (ft7Var5 != null && ft7Var5.O() != null && this.l.O().isLinkThread()) {
            D(pbFirstFloorViewHolder, this.l.O().getLinkThreadData());
        }
        ft7 ft7Var6 = this.l;
        if ((ft7Var6 == null || ft7Var6.O() == null || !this.l.O().isShareThread || postData.T() == null) ? false : true) {
            if (postData.T().C != null) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(G(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(G(R.dimen.tbds14));
            }
            E(pbFirstFloorViewHolder, postData);
        } else {
            pbFirstFloorViewHolder.f.getLayoutStrategy().m(G(R.dimen.tbds24));
        }
        TbRichText V = postData.V();
        ft7 ft7Var7 = this.l;
        if (ft7Var7 == null || !ft7Var7.u0()) {
            tbRichText = V;
        }
        if (this.l.O() != null) {
            pbFirstFloorViewHolder.f.setTid(this.l.Q());
            pbFirstFloorViewHolder.f.setIsUseGridImage(this.l.O().isBJHNormalThreadType());
            pbFirstFloorViewHolder.f.setmIsGridImageSupportLongPress(true);
        }
        ft7 ft7Var8 = this.l;
        if (ft7Var8 != null && 3 == ft7Var8.g()) {
            if (!this.u && this.v) {
                pbFirstFloorViewHolder.f.setText(tbRichText, true, this.s, true, false);
            } else {
                pbFirstFloorViewHolder.f.setText(tbRichText, false, this.s, true, false);
            }
        } else if (!this.u && this.v) {
            pbFirstFloorViewHolder.f.setText(tbRichText, true, this.s, false, true);
        } else {
            pbFirstFloorViewHolder.f.setText(tbRichText, false, this.s, false, true);
        }
        F(pbFirstFloorViewHolder, postData, tbRichText);
        boolean z7 = !StringUtils.isNull(postData.s().getVirtualUserUrl());
        ft7 ft7Var9 = this.l;
        if (ft7Var9 == null || ft7Var9.W() == 0 || K()) {
            z = false;
            z2 = false;
        } else {
            if (this.l.W() != 3) {
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
        ft7 ft7Var10 = this.l;
        if (ft7Var10 != null && ft7Var10.O() != null && this.l.O().getAuthor() != null && postData.s() != null) {
            String userId2 = this.l.O().getAuthor().getUserId();
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
                sparseArray.put(R.id.obfuscated_res_0x7f091ff8, postData.K());
                if (!z) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff5, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff6, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff7, postData.s().getPortrait());
                    }
                    ft7 ft7Var11 = this.l;
                    if (ft7Var11 != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(ft7Var11.W()));
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091fff, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092040, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f092041, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f09203f, postData.s().getName_show());
                    }
                    ft7 ft7Var12 = this.l;
                    if (ft7Var12 != null && ft7Var12.O() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092043, this.l.O().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092042, postData.K());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                }
                if (!z2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091ffc, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z4));
                    sparseArray.put(R.id.obfuscated_res_0x7f091fec, Integer.valueOf(i2));
                    sparseArray.put(R.id.obfuscated_res_0x7f091fea, postData.K());
                    ft7 ft7Var13 = this.l;
                    if (ft7Var13 != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(ft7Var13.W()));
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f09202e, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f092000, Boolean.valueOf(z5));
                y(pbFirstFloorViewHolder);
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
        sparseArray.put(R.id.obfuscated_res_0x7f091ff8, postData.K());
        if (!z) {
        }
        if (!z3) {
        }
        if (!z2) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f092000, Boolean.valueOf(z5));
        y(pbFirstFloorViewHolder);
    }

    public final void C(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view2, int i) {
        PostData postData2;
        ot7 ot7Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, pbFirstFloorViewHolder, postData, view2, i) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        pbFirstFloorViewHolder.f.setTag(sparseArray);
        pbFirstFloorViewHolder.c.setTag(R.id.obfuscated_res_0x7f091ffb, sparseArray);
        sparseArray.put(R.id.obfuscated_res_0x7f091fe8, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092001, Boolean.FALSE);
        pbFirstFloorViewHolder.f.setIsHost(true);
        if (this.i) {
            pbFirstFloorViewHolder.g.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.g.setVisibility(8);
        }
        List<CardLinkInfoData> list = null;
        if (!TextUtils.isEmpty(postData.t()) && this.h) {
            this.w = true;
            pbFirstFloorViewHolder.f.l0(postData.t(), new d(this, pbFirstFloorViewHolder, postData, view2, i));
        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.f.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            pbFirstFloorViewHolder.f.setLayoutParams(layoutParams);
            pbFirstFloorViewHolder.f.k0(null);
            this.w = false;
            B(pbFirstFloorViewHolder, postData, view2, i);
        }
        ft7 ft7Var = this.l;
        if (ft7Var != null && ft7Var.O() != null && this.l.O().isVideoThreadType() && this.l.O().getThreadVideoInfo() != null && pi.isEmpty(this.l.l().getName())) {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
        } else if (postData.V() != null && !ListUtils.isEmpty(postData.V().B())) {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
        } else {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
        }
        if (postData.V() != null) {
            if (postData.V().C() > 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.n.getLayoutParams();
                layoutParams2.topMargin = s(R.dimen.tbds26);
                pbFirstFloorViewHolder.n.setLayoutParams(layoutParams2);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.n.getLayoutParams();
                layoutParams3.topMargin = s(R.dimen.tbds16);
                pbFirstFloorViewHolder.n.setLayoutParams(layoutParams3);
            }
        }
        ft7 ft7Var2 = this.l;
        if (ft7Var2 != null && L(ft7Var2.O())) {
            pbFirstFloorViewHolder.y.setDataForPb(this.l.O().getPollData(), this.l.O().getTid(), this.l.m());
            if (postData.V() != null && !ListUtils.isEmpty(postData.V().B())) {
                pbFirstFloorViewHolder.y.setMarginTop(qi.f(this.x, R.dimen.tbds26));
            } else {
                pbFirstFloorViewHolder.y.setMarginTop(qi.f(this.x, R.dimen.tbds0));
            }
            pbFirstFloorViewHolder.y.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.y.setVisibility(8);
        }
        ft7 ft7Var3 = this.l;
        if (ft7Var3 != null && ft7Var3.O() != null && this.l.O().getSmartApp() != null && this.l.O().getThreadVideoInfo() == null) {
            pbFirstFloorViewHolder.n.setData(this.l.O().getSmartApp());
            pbFirstFloorViewHolder.n.setVisibility(0);
            ft7 ft7Var4 = this.l;
            if (ft7Var4 != null && ft7Var4.l() != null) {
                pbFirstFloorViewHolder.n.setForumId(String.valueOf(this.l.l().getId()));
            }
            ft7 ft7Var5 = this.l;
            if (ft7Var5 != null && ft7Var5.Q() != null) {
                pbFirstFloorViewHolder.n.setThreadId(this.l.Q());
            }
            pbFirstFloorViewHolder.n.setFrom("PB_card");
        } else {
            pbFirstFloorViewHolder.n.setVisibility(8);
        }
        ft7 ft7Var6 = this.l;
        if (ft7Var6 != null) {
            pbFirstFloorViewHolder.A.setData(ft7Var6.O(), this.l.P(), this.y);
        }
        if (NovelPaySwitch.isOn() && postData.S() != null && !postData.S().i() && this.l.m0()) {
            this.k = true;
            pbFirstFloorViewHolder.o.setVisibility(0);
            pbFirstFloorViewHolder.p.setVisibility(0);
            pbFirstFloorViewHolder.p.setData(postData.S());
            pbFirstFloorViewHolder.p.setStatisticData(this.l.Q(), this.l.m());
        } else {
            pbFirstFloorViewHolder.o.setVisibility(8);
            pbFirstFloorViewHolder.p.setVisibility(8);
        }
        FullLengthNovel fullLengthNovel = postData.E0;
        if (fullLengthNovel != null && !TextUtils.isEmpty(fullLengthNovel.schema)) {
            pbFirstFloorViewHolder.q.setVisibility(0);
            if (pbFirstFloorViewHolder.q.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.q.getLayoutParams();
                layoutParams4.height = (qi.k(this.x) * postData.E0.button_heigh.intValue()) / 1080;
                pbFirstFloorViewHolder.q.setLayoutParams(layoutParams4);
            }
            pbFirstFloorViewHolder.q.loadUrl(postData.E0.schema + "&curskintype=" + A());
        } else {
            pbFirstFloorViewHolder.q.setVisibility(8);
        }
        ft7 ft7Var7 = this.l;
        if (ft7Var7 != null && (ot7Var = ft7Var7.h) != null) {
            if (pbFirstFloorViewHolder.m != null) {
                if (TextUtils.isEmpty(ot7Var.e())) {
                    pbFirstFloorViewHolder.m.setVisibility(8);
                } else {
                    pbFirstFloorViewHolder.m.setVisibility(0);
                    pbFirstFloorViewHolder.m.setText(this.l.h.e());
                }
            }
            if (pbFirstFloorViewHolder.l != null && pbFirstFloorViewHolder.x.h() == null) {
                pbFirstFloorViewHolder.l.addView(pbFirstFloorViewHolder.x.a(this.l));
                String fromPageKey = UtilHelper.getFromPageKey(this.b.getPageContext());
                Context context = this.x;
                if (!(context instanceof AbsPbActivity) || ((AbsPbActivity) context).getIntent() == null) {
                    z = false;
                } else {
                    z = ((AbsPbActivity) this.x).getIntent().getBooleanExtra("is_from_bar_vote", false);
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
        LinearLayout linearLayout = pbFirstFloorViewHolder.r;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        ft7 ft7Var8 = this.l;
        if (ft7Var8 != null && ft7Var8.F() != null && this.l.F().size() > 0 && (postData2 = this.l.F().get(0)) != null) {
            list = postData2.v();
        }
        ft7 ft7Var9 = this.l;
        if (ft7Var9 != null && ft7Var9.O() != null && !L(this.l.O()) && (!ListUtils.isEmpty(this.l.O().getLinkDataList()) || !ListUtils.isEmpty(this.l.O().getGoodsDataList()) || !ListUtils.isEmpty(list))) {
            lf5 lf5Var = new lf5();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.x);
            ft7 ft7Var10 = this.l;
            pbLinkGoodsRootView.i(ft7Var10, lf5Var.b(ft7Var10.O().getLinkDataList(), this.l.O().getGoodsDataList(), list), this.l.n(), this.b, lf5Var.c());
            pbFirstFloorViewHolder.r.addView(pbLinkGoodsRootView);
            pbFirstFloorViewHolder.r.setVisibility(0);
            return;
        }
        pbFirstFloorViewHolder.r.setVisibility(8);
    }

    public final void D(PbFirstFloorViewHolder pbFirstFloorViewHolder, xp4 xp4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, pbFirstFloorViewHolder, xp4Var) == null) || xp4Var == null || pi.isEmpty(xp4Var.e()) || xp4Var.c() != xp4.g) {
            return;
        }
        if (!xp4Var.f()) {
            pbFirstFloorViewHolder.f.getLayoutStrategy().m(qi.f(this.x, R.dimen.obfuscated_res_0x7f0702cb));
        }
        pbFirstFloorViewHolder.s.c(xp4Var);
    }

    public final void E(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, pbFirstFloorViewHolder, postData) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        pbFirstFloorViewHolder.t.setVisibility(0);
        if (pbFirstFloorViewHolder.u == null) {
            pbFirstFloorViewHolder.u = H(postData);
        }
        if (pbFirstFloorViewHolder.t.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.u.a()) != null) {
            pbFirstFloorViewHolder.t.addView(a2);
        }
        pbFirstFloorViewHolder.u.e(this.B);
        pbFirstFloorViewHolder.u.d(this.C);
        pbFirstFloorViewHolder.u.c(postData.T());
        pbFirstFloorViewHolder.u.b(this.b.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void F(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, pbFirstFloorViewHolder, postData, tbRichText) == null) {
            if (postData != null && postData.b0() != null) {
                v18.c(postData.b0(), pbFirstFloorViewHolder.k, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.t()));
            } else {
                pbFirstFloorViewHolder.k.setVisibility(8);
            }
        }
    }

    public final int G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? qi.f(TbadkCoreApplication.getInst().getContext(), i) : invokeI.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final uy7 H(PostData postData) {
        InterceptResult invokeL;
        uy7 uy7Var;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, postData)) != null) {
            return (uy7) invokeL.objValue;
        }
        if (postData != null && postData.T() != null && postData.T().j()) {
            BaijiahaoData baijiahaoData = postData.T().p;
            Item item = postData.T().C;
            if (!postData.T().m && !postData.e1()) {
                if (item != null && item.item_id.longValue() != 0) {
                    if (postData.T().a != 0 && postData.T().a != 1) {
                        if (postData.T().a == 3) {
                            uy7Var = new az7(this.b.getPageContext());
                        } else {
                            uy7Var = new yy7(this.b.getPageContext());
                        }
                    } else {
                        uy7Var = new zy7(this.b.getPageContext());
                    }
                } else if (baijiahaoData != null && postData.T().k()) {
                    int i = baijiahaoData.oriUgcType;
                    if (i == 1) {
                        uy7Var = new vy7(this.b.getPageContext(), this.z);
                    } else if (i == 2) {
                        uy7Var = new cz7(this.b.getPageContext(), this.z);
                    } else if (i == 3) {
                        uy7Var = new bz7(this.b.getPageContext(), this.z);
                    } else if (i != 4) {
                        uy7Var = new wy7(this.b.getPageContext(), this.z);
                    } else {
                        uy7Var = new cz7(this.b.getPageContext(), this.z);
                    }
                } else if (postData.T().a != 0 && postData.T().a != 1) {
                    if (postData.T().a == 3) {
                        uy7Var = new cz7(this.b.getPageContext(), this.z);
                    }
                } else {
                    uy7Var = new bz7(this.b.getPageContext(), this.z);
                }
            } else {
                uy7Var = new xy7(this.b.getPageContext(), this.z);
            }
            return uy7Var != null ? new wy7(this.b.getPageContext(), this.z) : uy7Var;
        }
        uy7Var = null;
        if (uy7Var != null) {
        }
    }

    public PbFirstFloorViewHolder J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (PbFirstFloorViewHolder) this.viewholder : (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public final boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ft7 ft7Var = this.l;
            if (ft7Var == null || ft7Var.O() == null) {
                return false;
            }
            return this.l.O().isBlocked();
        }
        return invokeV.booleanValue;
    }

    public final boolean L(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, threadData)) == null) ? (threadData == null || threadData.getPollData() == null || threadData.getPollData().getOptions() == null || threadData.getPollData().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: M */
    public PbFirstFloorViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.b.getPageContext(), LayoutInflater.from(this.x).inflate(R.layout.obfuscated_res_0x7f0d062c, viewGroup, false), this.h, this.g);
            X(pbFirstFloorViewHolder);
            pbFirstFloorViewHolder.s.f(this.z);
            return pbFirstFloorViewHolder;
        }
        return (PbFirstFloorViewHolder) invokeL.objValue;
    }

    public View N(int i, View view2, ViewGroup viewGroup, PostData postData, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        InterceptResult invokeCommon;
        BdTypeListView listView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), view2, viewGroup, postData, pbFirstFloorViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, postData, pbFirstFloorViewHolder);
            X(pbFirstFloorViewHolder);
            S(pbFirstFloorViewHolder);
            PostData postData2 = (PostData) getItem(i);
            if (postData2 != null) {
                postData2.h1();
                postData2.b0 = i + 1;
                i08.d(this.b.getUniqueId(), this.l, postData2, postData2.b0, 1);
                C(pbFirstFloorViewHolder, postData2, view2, i);
            }
            if (!this.u && this.v && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.f.G() && (listView = this.b.getListView()) != null) {
                this.u = true;
                CompatibleUtile.getInstance().closeViewGpu(listView);
            }
            pbFirstFloorViewHolder.z.setVisibility(8);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void O(boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (pbModel = this.j) != null && z && this.k) {
            pbModel.k3(3);
        }
    }

    public void P() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (v = this.viewholder) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).s.d();
    }

    public void Q() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (v = this.viewholder) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).s.a();
        ((PbFirstFloorViewHolder) this.viewholder).w.g();
        ((PbFirstFloorViewHolder) this.viewholder).p.i();
    }

    public void R() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (v = this.viewholder) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).s.e();
        ((PbFirstFloorViewHolder) this.viewholder).p.j();
    }

    public final void S(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.c.setOnTouchListener(this.q);
            pbFirstFloorViewHolder.c.setOnLongClickListener(this.r);
            ry7 ry7Var = this.a.P().d;
            pbFirstFloorViewHolder.f.setOnLongClickListener(this.r);
            pbFirstFloorViewHolder.f.setOnTouchListener(this.A);
            pbFirstFloorViewHolder.f.setItemOrderOrDownloadListener(this.t);
            pbFirstFloorViewHolder.f.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.f.setCommonTextViewOnClickListener(this.o);
            pbFirstFloorViewHolder.f.setOnImageClickListener(this.p);
            pbFirstFloorViewHolder.f.setOnImageTouchListener(this.A);
            pbFirstFloorViewHolder.f.setmGridEmptyClickListener(new e(this));
            pbFirstFloorViewHolder.f.setOnEmotionClickListener(ry7Var.f);
            pbFirstFloorViewHolder.k.setOnClickListener(this.o);
            pbFirstFloorViewHolder.v.setAfterItemClickListener(this.o);
            pbFirstFloorViewHolder.w.setAfterItemClickListener(this.o);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.i = z;
        }
    }

    public void V(hu7 hu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, hu7Var) == null) {
            this.q = hu7Var;
        }
    }

    public void W(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, sVar) == null) {
            this.s = sVar;
        }
    }

    public final void X(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, pbFirstFloorViewHolder) == null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbFirstFloorViewHolder.b != skinType) {
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.z, R.color.CAM_X0202);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.c, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.g, R.color.CAM_X0204);
            pbFirstFloorViewHolder.f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbFirstFloorViewHolder.n.c();
            pbFirstFloorViewHolder.p.g();
            ThreadForumEnterButtonContainer threadForumEnterButtonContainer = pbFirstFloorViewHolder.v;
            if (threadForumEnterButtonContainer != null) {
                threadForumEnterButtonContainer.a();
            }
            PbBusinessPromotionContainer pbBusinessPromotionContainer = pbFirstFloorViewHolder.w;
            if (pbBusinessPromotionContainer != null) {
                pbBusinessPromotionContainer.h();
            }
            SkinManager.setViewTextColor(pbFirstFloorViewHolder.m, (int) R.color.CAM_X0107);
            pbFirstFloorViewHolder.x.i(skinType);
            VoteView voteView = pbFirstFloorViewHolder.y;
            if (voteView != null) {
                voteView.C(skinType);
            }
            SkinManager.setBackgroundColorToTransparent(pbFirstFloorViewHolder.o, R.color.CAM_X0201, GradientDrawable.Orientation.BOTTOM_TOP);
            pbFirstFloorViewHolder.A.d();
        }
        pbFirstFloorViewHolder.b = TbadkCoreApplication.getInst().getSkinType();
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.h = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onLongClickListener) == null) {
            this.r = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.g = i;
        }
    }

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, yVar) == null) {
            this.p = yVar;
        }
    }

    @Override // com.repackage.bw7, com.repackage.bn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        N(i, view2, viewGroup, (PostData) obj, (PbFirstFloorViewHolder) viewHolder);
        return view2;
    }

    public void r(ft7 ft7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, ft7Var) == null) {
            this.l = ft7Var;
        }
    }

    @Override // com.repackage.bn
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.y = z;
        }
    }

    public final void y(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.f.setTextViewOnTouchListener(this.A);
            pbFirstFloorViewHolder.f.setTextViewCheckSelection(false);
        }
    }

    public final void z(TbRichTextView tbRichTextView, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048610, this, tbRichTextView, view2, z) == null) || tbRichTextView == null) {
            return;
        }
        int min = Math.min(((((qi.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - (z ? s(R.dimen.obfuscated_res_0x7f070275) : 0), this.g);
        tbRichTextView.getLayoutStrategy().q(min);
        tbRichTextView.getLayoutStrategy().p((int) (min * 1.618f));
    }
}
