package d.a.s0.h2.k.e;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFirstFloorViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.j.a;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.n2;
import d.a.s0.h2.i.c;
import tbclient.Item;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class s extends o<PostData, PbFirstFloorViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.s0.h2.i.c A;
    public View.OnLongClickListener B;
    public TbRichTextView.r C;
    public View.OnClickListener D;
    public boolean E;
    public final boolean F;
    public boolean G;
    public Context H;
    public int I;
    public d.a.s0.h2.i.c J;
    public d.a.s0.a0.b0<d.a.r0.r.q.a> K;
    public a.InterfaceC0643a L;
    public int s;
    public boolean t;
    public boolean u;
    public d.a.s0.h2.h.e v;
    public d.a.s0.h2.k.g.b w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public TbRichTextView.x z;

    /* loaded from: classes9.dex */
    public class a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f60652a;

        public a(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60652a = sVar;
        }

        @Override // d.a.s0.h2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.s0.h2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.f60652a.A != null) {
                    this.f60652a.A.a(view);
                    this.f60652a.A.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.s0.h2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (d.a.r0.c1.b.e.d()) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, 2));
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends d.a.s0.a0.b0<d.a.r0.r.q.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s f60653b;

        public b(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60653b = sVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.r0.r.q.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, aVar) == null) {
                super.a(view, aVar);
                if (aVar == null || aVar.getThreadData() == null || aVar.getThreadData().u1 == null || this.f60653b.v == null) {
                    return;
                }
                OriginalThreadInfo originalThreadInfo = aVar.getThreadData().u1;
                String P = this.f60653b.v.P();
                String str = originalThreadInfo.f12235f;
                int i2 = 1;
                int i3 = originalThreadInfo.f12230a;
                if (i3 == 3) {
                    i2 = 2;
                } else if (i3 == 4) {
                    i2 = 3;
                }
                if (StringUtils.isNull(P) || StringUtils.isNull(str)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12602").param("tid", P).param("obj_source", str).param("obj_type", i2));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.InterfaceC0643a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f60654a;

        public c(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60654a = sVar;
        }

        @Override // d.a.j.a.InterfaceC0643a
        public void a(d.a.r0.r.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().u1 == null) {
                return;
            }
            OriginalThreadInfo originalThreadInfo = aVar.getThreadData().u1;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f60654a.H);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f12235f, originalThreadInfo.n, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.f12234e));
            pbActivityConfig.setStartFrom(this.f60654a.I);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    /* loaded from: classes9.dex */
    public class d implements TbRichTextView.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFirstFloorViewHolder f60655a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PostData f60656b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f60657c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f60658d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f60659e;

        public d(s sVar, PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, pbFirstFloorViewHolder, postData, view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60659e = sVar;
            this.f60655a = pbFirstFloorViewHolder;
            this.f60656b = postData;
            this.f60657c = view;
            this.f60658d = i2;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60655a.f19175e.getLayoutParams();
                layoutParams.topMargin = this.f60659e.f0(R.dimen.ds16);
                int f0 = this.f60659e.f0(R.dimen.ds34);
                layoutParams.bottomMargin = f0;
                layoutParams.leftMargin = f0;
                layoutParams.rightMargin = f0;
                this.f60655a.f19175e.setLayoutParams(layoutParams);
                this.f60659e.p0(this.f60655a, this.f60656b, this.f60657c, this.f60658d);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.s0.h2.o.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = 0;
        boolean z = true;
        this.t = true;
        this.u = true;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = false;
        int i4 = Build.VERSION.SDK_INT;
        this.F = (i4 < 14 || i4 > 16) ? false : false;
        this.G = false;
        this.I = 0;
        this.J = new d.a.s0.h2.i.c(new a(this));
        this.K = new b(this);
        this.L = new c(this);
        if (pbFragment != null && pbFragment.y() != null) {
            this.I = pbFragment.y().C0();
        }
        this.H = pbFragment.getContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: A0 */
    public PbFirstFloorViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.n.getPageContext(), LayoutInflater.from(this.H).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.t, this.s);
            K0(pbFirstFloorViewHolder);
            pbFirstFloorViewHolder.o.f(this.I);
            return pbFirstFloorViewHolder;
        }
        return (PbFirstFloorViewHolder) invokeL.objValue;
    }

    public View B0(int i2, View view, ViewGroup viewGroup, PostData postData, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        InterceptResult invokeCommon;
        BdListView listView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, pbFirstFloorViewHolder})) == null) {
            super.X(i2, view, viewGroup, postData, pbFirstFloorViewHolder);
            K0(pbFirstFloorViewHolder);
            F0(pbFirstFloorViewHolder);
            PostData postData2 = (PostData) z(i2);
            if (postData2 != null) {
                postData2.B0();
                postData2.i0 = i2 + 1;
                d.a.s0.h2.m.a.d(this.n.getUniqueId(), this.v, postData2, postData2.i0, 1);
                q0(pbFirstFloorViewHolder, postData2, view, i2);
            }
            if (!this.E && this.F && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.f19175e.E() && (listView = this.n.getListView()) != null) {
                this.E = true;
                CompatibleUtile.getInstance().closeViewGpu(listView);
            }
            pbFirstFloorViewHolder.v.setVisibility(d.a.r0.c1.b.e.d() ? 0 : 8);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void C0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (v = this.k) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).o.d();
    }

    public void D0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (v = this.k) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).o.a();
        ((PbFirstFloorViewHolder) this.k).s.g();
    }

    public void E0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (v = this.k) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).o.e();
    }

    public final void F0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.f19172b.setOnTouchListener(this.A);
            pbFirstFloorViewHolder.f19172b.setOnLongClickListener(this.B);
            d.a.s0.h2.k.e.c1.a aVar = this.m.z().mEvent;
            pbFirstFloorViewHolder.f19175e.setOnLongClickListener(this.B);
            pbFirstFloorViewHolder.f19175e.setOnTouchListener(this.J);
            pbFirstFloorViewHolder.f19175e.setItemOrderOrDownloadListener(this.D);
            pbFirstFloorViewHolder.f19175e.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.f19175e.setCommonTextViewOnClickListener(this.y);
            pbFirstFloorViewHolder.f19175e.setOnImageClickListener(this.z);
            pbFirstFloorViewHolder.f19175e.setOnImageTouchListener(this.J);
            pbFirstFloorViewHolder.f19175e.setmGridEmptyClickListener(new e(this));
            pbFirstFloorViewHolder.f19175e.setOnEmotionClickListener(aVar.f60417e);
            pbFirstFloorViewHolder.j.setOnClickListener(this.y);
            pbFirstFloorViewHolder.r.setAfterItemClickListener(this.y);
            pbFirstFloorViewHolder.s.setAfterItemClickListener(this.y);
        }
    }

    public void G0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.D = onClickListener;
        }
    }

    public void H0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.u = z;
        }
    }

    public void I0(d.a.s0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.A = cVar;
        }
    }

    public void J0(TbRichTextView.r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, rVar) == null) {
            this.C = rVar;
        }
    }

    public final void K0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, pbFirstFloorViewHolder) == null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbFirstFloorViewHolder.f19171a != skinType) {
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.v, R.color.CAM_X0202);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.f19172b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.f19176f, R.color.CAM_X0204);
            pbFirstFloorViewHolder.f19175e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbFirstFloorViewHolder.m.c();
            ThreadForumEnterButtonContainer threadForumEnterButtonContainer = pbFirstFloorViewHolder.r;
            if (threadForumEnterButtonContainer != null) {
                threadForumEnterButtonContainer.a();
            }
            PbBusinessPromotionContainer pbBusinessPromotionContainer = pbFirstFloorViewHolder.s;
            if (pbBusinessPromotionContainer != null) {
                pbBusinessPromotionContainer.h();
            }
            SkinManager.setViewTextColor(pbFirstFloorViewHolder.l, R.color.CAM_X0107);
            pbFirstFloorViewHolder.t.i(skinType);
            VoteView voteView = pbFirstFloorViewHolder.u;
            if (voteView != null) {
                voteView.C(skinType);
            }
        }
        pbFirstFloorViewHolder.f19171a = TbadkCoreApplication.getInst().getSkinType();
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PbFirstFloorViewHolder y0 = y0();
            d.a.s0.h2.h.e eVar = this.v;
            if (eVar == null || eVar.N() == null || y0 == null) {
                return;
            }
            y0.d(this.v, this.v.N().l0() == 1, this.v.N().m0() == 1);
        }
    }

    @Override // d.a.s0.h2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        B0(i2, view, viewGroup, (PostData) obj, (PbFirstFloorViewHolder) viewHolder);
        return view;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.t = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onLongClickListener) == null) {
            this.B = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.y = onClickListener;
        }
    }

    public final void l0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.f19175e.setTextViewOnTouchListener(this.J);
            pbFirstFloorViewHolder.f19175e.setTextViewCheckSelection(false);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public final void m0(TbRichTextView tbRichTextView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048595, this, tbRichTextView, view, z) == null) || tbRichTextView == null) {
            return;
        }
        int min = Math.min(((((d.a.c.e.p.l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - (z ? f0(R.dimen.ds80) : 0), this.s);
        tbRichTextView.getLayoutStrategy().q(min);
        tbRichTextView.getLayoutStrategy().p((int) (min * 1.618f));
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.s = i2;
        }
    }

    public void p(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, xVar) == null) {
            this.z = xVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str;
        String str2;
        long j;
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048598, this, pbFirstFloorViewHolder, postData, view, i2) == null) || this.v == null) {
            return;
        }
        TbRichText tbRichText = null;
        if (postData.A() != 1) {
            if (TextUtils.isEmpty(postData.u())) {
                pbFirstFloorViewHolder.f19175e.setOnClickListener(this.y);
                pbFirstFloorViewHolder.f19175e.setTextViewOnClickListener(this.y);
            } else {
                pbFirstFloorViewHolder.f19175e.setOnClickListener(null);
                pbFirstFloorViewHolder.f19175e.setTextViewOnClickListener(null);
            }
            pbFirstFloorViewHolder.f19172b.setOnClickListener(this.y);
        } else {
            pbFirstFloorViewHolder.f19172b.setOnClickListener(null);
        }
        if (postData.A() == 1) {
            pbFirstFloorViewHolder.c(this.v, this.n.isSimpleForum(), postData.Q);
            m0(pbFirstFloorViewHolder.f19175e, view, this.G);
            if (postData.t() != null) {
                long userIdLong = postData.t().getUserIdLong();
                str = postData.t().getUserName();
                j = userIdLong;
                str2 = postData.t().getName_show();
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            d.a.s0.h2.h.e eVar = this.v;
            if (eVar != null && eVar.N() != null) {
                pbFirstFloorViewHolder.o.b(postData.D(), str, str2, j, d.a.c.e.m.b.f(this.v.N().c0(), 0L), d.a.c.e.m.b.f(postData.E(), 0L));
            }
            if (this.n.P4().A1()) {
                pbFirstFloorViewHolder.f19175e.setVisibility(8);
            }
            d.a.s0.h2.h.e eVar2 = this.v;
            if (eVar2 != null && eVar2.N() != null && this.v.N().y1() != null) {
                n2 y1 = this.v.N().y1();
                String a2 = y1.a();
                if (StringUtils.isNull(y1.b())) {
                    return;
                }
                if (!StringUtils.isNull(a2)) {
                    pbFirstFloorViewHolder.f19178h.setVisibility(0);
                    pbFirstFloorViewHolder.f19178h.M(a2, 10, true);
                }
            } else {
                pbFirstFloorViewHolder.f19178h.setVisibility(8);
            }
            ThreadSkinView threadSkinView = pbFirstFloorViewHolder.f19179i;
            if (threadSkinView != null) {
                threadSkinView.setVisibility(8);
            }
            d.a.s0.h2.h.e eVar3 = this.v;
            if (eVar3 != null && eVar3.N() != null && this.v.N().q2() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.r) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.r.getPaddingRight(), pbFirstFloorViewHolder.r.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.f19175e.getLayoutStrategy().x(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_load_sub_data, postData);
        sparseArray.put(R.id.tag_load_sub_view, view);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.A()));
        boolean W = postData.W();
        if (W) {
            if (this.w == null) {
                d.a.s0.h2.k.g.b bVar = new d.a.s0.h2.k.g.b(this.H);
                this.w = bVar;
                bVar.f(this.q);
                this.w.h(this.x);
                d.a.s0.h2.h.e eVar4 = this.v;
                if (eVar4 != null) {
                    this.w.j(this.v.U(), TextUtils.equals(eVar4.N().H().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.w.i(this.v.N());
                }
            }
            this.w.g(postData.E());
        }
        pbFirstFloorViewHolder.f19175e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.t) {
            pbFirstFloorViewHolder.f19175e.getLayoutStrategy().g(R.drawable.transparent_bg);
        } else {
            pbFirstFloorViewHolder.f19175e.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.f19175e.setIsFromCDN(this.q);
        d.a.s0.h2.h.e eVar5 = this.v;
        if (eVar5 != null && eVar5.N() != null && this.v.N().V1()) {
            s0(pbFirstFloorViewHolder, this.v.N().w0());
        }
        d.a.s0.h2.h.e eVar6 = this.v;
        if ((eVar6 == null || eVar6.N() == null || !this.v.N().v1 || postData.J() == null) ? false : true) {
            if (postData.J().z != null) {
                pbFirstFloorViewHolder.f19175e.getLayoutStrategy().m(w0(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.f19175e.getLayoutStrategy().m(w0(R.dimen.tbds14));
            }
            t0(pbFirstFloorViewHolder, postData);
        } else {
            pbFirstFloorViewHolder.f19175e.getLayoutStrategy().m(w0(R.dimen.tbds24));
        }
        TbRichText K = postData.K();
        d.a.s0.h2.h.e eVar7 = this.v;
        if (eVar7 == null || !eVar7.l0()) {
            tbRichText = K;
        }
        if (this.v.N() != null) {
            pbFirstFloorViewHolder.f19175e.setIsUseGridImage(this.v.N().F1());
            pbFirstFloorViewHolder.f19175e.setmIsGridImageSupportLongPress(true);
        }
        d.a.s0.h2.h.e eVar8 = this.v;
        if (eVar8 != null && 3 == eVar8.g()) {
            if (!this.E && this.F) {
                pbFirstFloorViewHolder.f19175e.setText(tbRichText, true, this.C, true, false);
            } else {
                pbFirstFloorViewHolder.f19175e.setText(tbRichText, false, this.C, true, false);
            }
        } else if (!this.E && this.F) {
            pbFirstFloorViewHolder.f19175e.setText(tbRichText, true, this.C, false, true);
        } else {
            pbFirstFloorViewHolder.f19175e.setText(tbRichText, false, this.C, false, true);
        }
        v0(pbFirstFloorViewHolder, postData, tbRichText);
        boolean z5 = !StringUtils.isNull(postData.t().getVirtualUserUrl());
        d.a.s0.h2.h.e eVar9 = this.v;
        if (eVar9 == null || eVar9.U() == 0) {
            z = false;
            z2 = false;
        } else {
            if (this.v.U() != 3) {
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            if (postData.t() != null) {
                String userId = postData.t().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        d.a.s0.h2.h.e eVar10 = this.v;
        if (eVar10 != null && eVar10.N() != null && this.v.N().H() != null && postData.t() != null) {
            String userId2 = this.v.N().H().getUserId();
            String userId3 = postData.t().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z2 = true;
                    z3 = false;
                    z4 = true;
                    if (postData.t() != null && UtilHelper.isCurrentAccount(postData.t().getUserId())) {
                        z2 = true;
                        z4 = true;
                    }
                    if (z5) {
                        z = false;
                        z2 = false;
                        z3 = false;
                    }
                    int i3 = postData.A() == 1 ? 0 : 1;
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                    if (z) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                        }
                        d.a.s0.h2.h.e eVar11 = this.v;
                        if (eVar11 != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar11.U()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.t().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.t().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.t().getName_show());
                        }
                        d.a.s0.h2.h.e eVar12 = this.v;
                        if (eVar12 != null && eVar12.N() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.v.N().c0());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.E());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z2) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(W));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(R.id.tag_del_post_id, postData.E());
                        d.a.s0.h2.h.e eVar13 = this.v;
                        if (eVar13 != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar13.U()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    l0(pbFirstFloorViewHolder);
                }
                z2 = true;
                z3 = true;
                z4 = false;
                if (postData.t() != null) {
                    z2 = true;
                    z4 = true;
                }
                if (z5) {
                }
                if (postData.A() == 1) {
                }
                sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                if (z) {
                }
                if (z3) {
                }
                if (z2) {
                }
                l0(pbFirstFloorViewHolder);
            }
        }
        z3 = false;
        z4 = false;
        if (postData.t() != null) {
        }
        if (z5) {
        }
        if (postData.A() == 1) {
        }
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
        if (z) {
        }
        if (z3) {
        }
        if (z2) {
        }
        l0(pbFirstFloorViewHolder);
    }

    public final void q0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i2) {
        d.a.s0.h2.h.k kVar;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048599, this, pbFirstFloorViewHolder, postData, view, i2) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        pbFirstFloorViewHolder.f19175e.setTag(sparseArray);
        pbFirstFloorViewHolder.f19172b.setTag(R.id.tag_from, sparseArray);
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
        pbFirstFloorViewHolder.f19175e.setIsHost(true);
        if (this.u) {
            pbFirstFloorViewHolder.f19176f.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.f19176f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(postData.u()) && this.t) {
            this.G = true;
            pbFirstFloorViewHolder.f19175e.f0(postData.u(), new d(this, pbFirstFloorViewHolder, postData, view, i2));
        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.f19175e.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            pbFirstFloorViewHolder.f19175e.setLayoutParams(layoutParams);
            pbFirstFloorViewHolder.f19175e.e0(null);
            this.G = false;
            p0(pbFirstFloorViewHolder, postData, view, i2);
        }
        d.a.s0.h2.h.e eVar = this.v;
        if (eVar != null && eVar.N() != null && this.v.N().q2() && this.v.N().l1() != null && d.a.c.e.p.k.isEmpty(this.v.m().getName())) {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
        } else if (postData.K() != null && !ListUtils.isEmpty(postData.K().y())) {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
        } else {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
        }
        if (postData.K() != null) {
            if (postData.K().z() > 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.m.getLayoutParams();
                layoutParams2.topMargin = f0(R.dimen.tbds26);
                pbFirstFloorViewHolder.m.setLayoutParams(layoutParams2);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.m.getLayoutParams();
                layoutParams3.topMargin = f0(R.dimen.tbds16);
                pbFirstFloorViewHolder.m.setLayoutParams(layoutParams3);
            }
        }
        d.a.s0.h2.h.e eVar2 = this.v;
        if (eVar2 != null && z0(eVar2.N())) {
            pbFirstFloorViewHolder.u.setDataForPb(this.v.N().D0(), this.v.N().n1(), this.v.n());
            if (postData.K() != null && !ListUtils.isEmpty(postData.K().y())) {
                pbFirstFloorViewHolder.u.setMarginTop(d.a.c.e.p.l.g(this.H, R.dimen.tbds26));
            } else {
                pbFirstFloorViewHolder.u.setMarginTop(d.a.c.e.p.l.g(this.H, R.dimen.tbds0));
            }
            pbFirstFloorViewHolder.u.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.u.setVisibility(8);
        }
        d.a.s0.h2.h.e eVar3 = this.v;
        if (eVar3 != null && eVar3.N() != null && this.v.N().Z0() != null && this.v.N().l1() == null) {
            pbFirstFloorViewHolder.m.setData(this.v.N().Z0());
            pbFirstFloorViewHolder.m.setVisibility(0);
            d.a.s0.h2.h.e eVar4 = this.v;
            if (eVar4 != null && eVar4.m() != null) {
                pbFirstFloorViewHolder.m.setForumId(String.valueOf(this.v.m().getId()));
            }
            d.a.s0.h2.h.e eVar5 = this.v;
            if (eVar5 != null && eVar5.P() != null) {
                pbFirstFloorViewHolder.m.setThreadId(this.v.P());
            }
            pbFirstFloorViewHolder.m.setFrom("PB_card");
        } else {
            pbFirstFloorViewHolder.m.setVisibility(8);
        }
        L0();
        d.a.s0.h2.h.e eVar6 = this.v;
        if (eVar6 != null && (kVar = eVar6.f60144h) != null) {
            if (pbFirstFloorViewHolder.l != null) {
                if (TextUtils.isEmpty(kVar.e())) {
                    pbFirstFloorViewHolder.l.setVisibility(8);
                } else {
                    pbFirstFloorViewHolder.l.setVisibility(0);
                    pbFirstFloorViewHolder.l.setText(this.v.f60144h.e());
                }
            }
            if (pbFirstFloorViewHolder.k != null && pbFirstFloorViewHolder.t.h() == null) {
                pbFirstFloorViewHolder.k.addView(pbFirstFloorViewHolder.t.a(this.v));
                String fromPageKey = UtilHelper.getFromPageKey(this.n.getPageContext());
                Context context = this.H;
                if (!(context instanceof PbActivity) || ((PbActivity) context).getIntent() == null) {
                    z = false;
                } else {
                    z = ((PbActivity) this.H).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
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
        LinearLayout linearLayout = pbFirstFloorViewHolder.n;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        d.a.s0.h2.h.e eVar7 = this.v;
        if (eVar7 != null && eVar7.N() != null && !z0(this.v.N()) && (!ListUtils.isEmpty(this.v.N().v0()) || !ListUtils.isEmpty(this.v.N().Z()))) {
            d.a.r0.z0.l0 l0Var = new d.a.r0.z0.l0();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.H);
            d.a.s0.h2.h.e eVar8 = this.v;
            pbLinkGoodsRootView.i(eVar8, l0Var.a(eVar8.N().v0(), this.v.N().Z()), this.v.o(), this.n, l0Var.b());
            pbFirstFloorViewHolder.n.addView(pbLinkGoodsRootView);
            pbFirstFloorViewHolder.n.setVisibility(0);
            return;
        }
        pbFirstFloorViewHolder.n.setVisibility(8);
    }

    public final void s0(PbFirstFloorViewHolder pbFirstFloorViewHolder, d.a.r0.r.q.q0 q0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048600, this, pbFirstFloorViewHolder, q0Var) == null) || q0Var == null || d.a.c.e.p.k.isEmpty(q0Var.e()) || q0Var.c() != d.a.r0.r.q.q0.f56030g) {
            return;
        }
        if (!q0Var.f()) {
            pbFirstFloorViewHolder.f19175e.getLayoutStrategy().m(d.a.c.e.p.l.g(this.H, R.dimen.ds48));
        }
        pbFirstFloorViewHolder.o.c(q0Var);
    }

    public void t(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, eVar) == null) {
            this.v = eVar;
        }
    }

    public final void t0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, pbFirstFloorViewHolder, postData) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        pbFirstFloorViewHolder.p.setVisibility(0);
        if (pbFirstFloorViewHolder.q == null) {
            pbFirstFloorViewHolder.q = x0(postData);
        }
        if (pbFirstFloorViewHolder.p.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.q.a()) != null) {
            pbFirstFloorViewHolder.p.addView(a2);
        }
        pbFirstFloorViewHolder.q.e(this.K);
        pbFirstFloorViewHolder.q.d(this.L);
        pbFirstFloorViewHolder.q.c(postData.J());
        pbFirstFloorViewHolder.q.b(this.n.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void v0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, pbFirstFloorViewHolder, postData, tbRichText) == null) {
            if (postData != null && postData.O() != null) {
                d.a.s0.h2.p.f.c(postData.O(), pbFirstFloorViewHolder.j, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.u()));
            } else {
                pbFirstFloorViewHolder.j.setVisibility(8);
            }
        }
    }

    public final int w0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) ? d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), i2) : invokeI.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d.a.s0.h2.k.e.d1.a x0(PostData postData) {
        InterceptResult invokeL;
        d.a.s0.h2.k.e.d1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048605, this, postData)) != null) {
            return (d.a.s0.h2.k.e.d1.a) invokeL.objValue;
        }
        if (postData != null && postData.J() != null && postData.J().f()) {
            BaijiahaoData baijiahaoData = postData.J().p;
            Item item = postData.J().z;
            if (postData.J().m) {
                aVar = new d.a.s0.h2.k.e.d1.d(this.n.getPageContext(), this.I);
            } else if (item != null && item.item_id.longValue() != 0) {
                if (postData.J().f12230a != 0 && postData.J().f12230a != 1) {
                    if (postData.J().f12230a == 3) {
                        aVar = new d.a.s0.h2.k.e.d1.g(this.n.getPageContext());
                    } else {
                        aVar = new d.a.s0.h2.k.e.d1.e(this.n.getPageContext());
                    }
                } else {
                    aVar = new d.a.s0.h2.k.e.d1.f(this.n.getPageContext());
                }
            } else if (baijiahaoData != null && postData.J().g()) {
                int i2 = baijiahaoData.oriUgcType;
                if (i2 == 1) {
                    aVar = new d.a.s0.h2.k.e.d1.b(this.n.getPageContext(), this.I);
                } else if (i2 == 2) {
                    aVar = new d.a.s0.h2.k.e.d1.i(this.n.getPageContext(), this.I);
                } else if (i2 == 3) {
                    aVar = new d.a.s0.h2.k.e.d1.h(this.n.getPageContext(), this.I);
                } else if (i2 != 4) {
                    aVar = new d.a.s0.h2.k.e.d1.c(this.n.getPageContext(), this.I);
                } else {
                    aVar = new d.a.s0.h2.k.e.d1.i(this.n.getPageContext(), this.I);
                }
            } else if (postData.J().f12230a != 0 && postData.J().f12230a != 1) {
                if (postData.J().f12230a == 3) {
                    aVar = new d.a.s0.h2.k.e.d1.i(this.n.getPageContext(), this.I);
                }
            } else {
                aVar = new d.a.s0.h2.k.e.d1.h(this.n.getPageContext(), this.I);
            }
            return aVar != null ? new d.a.s0.h2.k.e.d1.c(this.n.getPageContext(), this.I) : aVar;
        }
        aVar = null;
        if (aVar != null) {
        }
    }

    public PbFirstFloorViewHolder y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? (PbFirstFloorViewHolder) this.k : (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public final boolean z0(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, b2Var)) == null) ? (b2Var == null || b2Var.D0() == null || b2Var.D0().getOptions() == null || b2Var.D0().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }
}
