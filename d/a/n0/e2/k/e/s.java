package d.a.n0.e2.k.e;

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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.TypeAdapter;
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
import d.a.i.a;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.m2;
import d.a.n0.e2.i.c;
import tbclient.Item;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class s extends o<PostData, PbFirstFloorViewHolder> {
    public d.a.n0.e2.i.c A;
    public View.OnLongClickListener B;
    public TbRichTextView.r C;
    public boolean D;
    public final boolean E;
    public boolean F;
    public Context G;
    public int H;
    public d.a.n0.e2.i.c I;
    public d.a.n0.z.b0<d.a.m0.r.q.a> J;
    public a.InterfaceC0598a K;
    public int s;
    public boolean t;
    public boolean u;
    public d.a.n0.e2.h.e v;
    public d.a.n0.e2.k.g.b w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public TbRichTextView.x z;

    /* loaded from: classes5.dex */
    public class a implements c.a {
        public a() {
        }

        @Override // d.a.n0.e2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // d.a.n0.e2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            if (s.this.A != null) {
                s.this.A.a(view);
                s.this.A.onSingleTapConfirmed(motionEvent);
                return true;
            }
            return true;
        }

        @Override // d.a.n0.e2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (d.a.m0.c1.b.e.d()) {
                return true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, 2));
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.n0.z.b0<d.a.m0.r.q.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.m0.r.q.a aVar) {
            super.a(view, aVar);
            if (aVar == null || aVar.i() == null || aVar.i().t1 == null || s.this.v == null) {
                return;
            }
            OriginalThreadInfo originalThreadInfo = aVar.i().t1;
            String N = s.this.v.N();
            String str = originalThreadInfo.f12100f;
            int i2 = 1;
            int i3 = originalThreadInfo.f12095a;
            if (i3 == 3) {
                i2 = 2;
            } else if (i3 == 4) {
                i2 = 3;
            }
            if (StringUtils.isNull(N) || StringUtils.isNull(str)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12602").param("tid", N).param("obj_source", str).param("obj_type", i2));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.InterfaceC0598a {
        public c() {
        }

        @Override // d.a.i.a.InterfaceC0598a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null || aVar.i() == null || aVar.i().t1 == null) {
                return;
            }
            OriginalThreadInfo originalThreadInfo = aVar.i().t1;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(s.this.G);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f12100f, originalThreadInfo.n, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.f12099e));
            pbActivityConfig.setStartFrom(s.this.H);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    /* loaded from: classes5.dex */
    public class d implements TbRichTextView.u {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFirstFloorViewHolder f57116a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PostData f57117b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f57118c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f57119d;

        public d(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i2) {
            this.f57116a = pbFirstFloorViewHolder;
            this.f57117b = postData;
            this.f57118c = view;
            this.f57119d = i2;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
        public void a() {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f57116a.f18971e.getLayoutParams();
            layoutParams.topMargin = s.this.e0(R.dimen.ds16);
            int e0 = s.this.e0(R.dimen.ds34);
            layoutParams.bottomMargin = e0;
            layoutParams.leftMargin = e0;
            layoutParams.rightMargin = e0;
            this.f57116a.f18971e.setLayoutParams(layoutParams);
            s.this.p0(this.f57116a, this.f57117b, this.f57118c, this.f57119d);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e(s sVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public s(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
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
        this.D = false;
        int i2 = Build.VERSION.SDK_INT;
        this.E = (i2 < 14 || i2 > 16) ? false : false;
        this.F = false;
        this.H = 0;
        this.I = new d.a.n0.e2.i.c(new a());
        this.J = new b();
        this.K = new c();
        if (pbFragment != null && pbFragment.A() != null) {
            this.H = pbFragment.A().B0();
        }
        this.G = pbFragment.getContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: A0 */
    public PbFirstFloorViewHolder Q(ViewGroup viewGroup) {
        PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.n.getPageContext(), LayoutInflater.from(this.G).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.t, this.s);
        J0(pbFirstFloorViewHolder);
        pbFirstFloorViewHolder.o.f(this.H);
        return pbFirstFloorViewHolder;
    }

    public View B0(int i2, View view, ViewGroup viewGroup, PostData postData, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        BdListView listView;
        super.X(i2, view, viewGroup, postData, pbFirstFloorViewHolder);
        J0(pbFirstFloorViewHolder);
        F0(pbFirstFloorViewHolder);
        PostData postData2 = (PostData) z(i2);
        if (postData2 != null) {
            postData2.B0();
            postData2.d0 = i2 + 1;
            d.a.n0.e2.m.a.d(this.n.getUniqueId(), this.v, postData2, postData2.d0, 1);
            q0(pbFirstFloorViewHolder, postData2, view, i2);
        }
        if (!this.D && this.E && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.f18971e.E() && (listView = this.n.getListView()) != null) {
            this.D = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        pbFirstFloorViewHolder.v.setVisibility(d.a.m0.c1.b.e.d() ? 0 : 8);
        return view;
    }

    public void C0() {
        V v = this.k;
        if (v != 0) {
            ((PbFirstFloorViewHolder) v).o.d();
        }
    }

    public void D0() {
        V v = this.k;
        if (v != 0) {
            ((PbFirstFloorViewHolder) v).o.a();
            ((PbFirstFloorViewHolder) this.k).s.g();
        }
    }

    public void E0() {
        V v = this.k;
        if (v != 0) {
            ((PbFirstFloorViewHolder) v).o.e();
        }
    }

    public final void F0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.f18968b.setOnTouchListener(this.A);
        pbFirstFloorViewHolder.f18968b.setOnLongClickListener(this.B);
        d.a.n0.e2.k.e.c1.a aVar = this.m.B().mEvent;
        pbFirstFloorViewHolder.f18971e.setOnLongClickListener(this.B);
        pbFirstFloorViewHolder.f18971e.setOnTouchListener(this.I);
        pbFirstFloorViewHolder.f18971e.setCommonTextViewOnClickListener(this.y);
        pbFirstFloorViewHolder.f18971e.setOnImageClickListener(this.z);
        pbFirstFloorViewHolder.f18971e.setOnImageTouchListener(this.I);
        pbFirstFloorViewHolder.f18971e.setmGridEmptyClickListener(new e(this));
        pbFirstFloorViewHolder.f18971e.setOnEmotionClickListener(aVar.f56887e);
        pbFirstFloorViewHolder.j.setOnClickListener(this.y);
        pbFirstFloorViewHolder.r.setAfterItemClickListener(this.y);
        pbFirstFloorViewHolder.s.setAfterItemClickListener(this.y);
    }

    public void G0(boolean z) {
        this.u = z;
    }

    public void H0(d.a.n0.e2.i.c cVar) {
        this.A = cVar;
    }

    public void I0(TbRichTextView.r rVar) {
        this.C = rVar;
    }

    public final void J0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        if (pbFirstFloorViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbFirstFloorViewHolder.f18967a != skinType) {
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.v, R.color.CAM_X0202);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.f18968b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.f18972f, R.color.CAM_X0204);
            pbFirstFloorViewHolder.f18971e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
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
        pbFirstFloorViewHolder.f18967a = TbadkCoreApplication.getInst().getSkinType();
    }

    public void K0() {
        PbFirstFloorViewHolder y0 = y0();
        d.a.n0.e2.h.e eVar = this.v;
        if (eVar == null || eVar.L() == null || y0 == null) {
            return;
        }
        y0.d(this.v, this.v.L().x0() == 1, this.v.L().y0() == 1);
    }

    @Override // d.a.n0.e2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        B0(i2, view, viewGroup, (PostData) obj, (PbFirstFloorViewHolder) viewHolder);
        return view;
    }

    public void c(boolean z) {
        this.t = z;
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        this.B = onLongClickListener;
    }

    public void e(View.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public final void l0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.f18971e.setTextViewOnTouchListener(this.I);
        pbFirstFloorViewHolder.f18971e.setTextViewCheckSelection(false);
    }

    public void m(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public final void m0(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView == null) {
            return;
        }
        int min = Math.min(((((d.a.c.e.p.l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - (z ? e0(R.dimen.ds80) : 0), this.s);
        tbRichTextView.getLayoutStrategy().q(min);
        tbRichTextView.getLayoutStrategy().p((int) (min * 1.618f));
    }

    public void n(int i2) {
        this.s = i2;
    }

    public void p(TbRichTextView.x xVar) {
        this.z = xVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04b5  */
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
        if (this.v == null) {
            return;
        }
        TbRichText tbRichText = null;
        if (postData.A() != 1) {
            if (TextUtils.isEmpty(postData.u())) {
                pbFirstFloorViewHolder.f18971e.setOnClickListener(this.y);
                pbFirstFloorViewHolder.f18971e.setTextViewOnClickListener(this.y);
            } else {
                pbFirstFloorViewHolder.f18971e.setOnClickListener(null);
                pbFirstFloorViewHolder.f18971e.setTextViewOnClickListener(null);
            }
            pbFirstFloorViewHolder.f18968b.setOnClickListener(this.y);
        } else {
            pbFirstFloorViewHolder.f18968b.setOnClickListener(null);
        }
        if (postData.A() == 1) {
            pbFirstFloorViewHolder.c(this.v, this.n.isSimpleForum(), postData.Q);
            m0(pbFirstFloorViewHolder.f18971e, view, this.F);
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
            d.a.n0.e2.h.e eVar = this.v;
            if (eVar != null && eVar.L() != null) {
                pbFirstFloorViewHolder.o.b(postData.D(), str, str2, j, d.a.c.e.m.b.f(this.v.L().o0(), 0L), d.a.c.e.m.b.f(postData.E(), 0L));
            }
            if (this.n.N4().y1()) {
                pbFirstFloorViewHolder.f18971e.setVisibility(8);
            }
            d.a.n0.e2.h.e eVar2 = this.v;
            if (eVar2 != null && eVar2.L() != null && this.v.L().L1() != null) {
                m2 L1 = this.v.L().L1();
                String a2 = L1.a();
                if (StringUtils.isNull(L1.b())) {
                    return;
                }
                if (!StringUtils.isNull(a2)) {
                    pbFirstFloorViewHolder.f18974h.setVisibility(0);
                    pbFirstFloorViewHolder.f18974h.U(a2, 10, true);
                }
            } else {
                pbFirstFloorViewHolder.f18974h.setVisibility(8);
            }
            ThreadSkinView threadSkinView = pbFirstFloorViewHolder.f18975i;
            if (threadSkinView != null) {
                threadSkinView.setVisibility(8);
            }
            d.a.n0.e2.h.e eVar3 = this.v;
            if (eVar3 != null && eVar3.L() != null && this.v.L().D2() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.r) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.r.getPaddingRight(), pbFirstFloorViewHolder.r.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.f18971e.getLayoutStrategy().x(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_load_sub_data, postData);
        sparseArray.put(R.id.tag_load_sub_view, view);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.A()));
        boolean W = postData.W();
        if (W) {
            if (this.w == null) {
                d.a.n0.e2.k.g.b bVar = new d.a.n0.e2.k.g.b(this.G);
                this.w = bVar;
                bVar.f(this.q);
                this.w.h(this.x);
                d.a.n0.e2.h.e eVar4 = this.v;
                if (eVar4 != null) {
                    this.w.j(this.v.S(), TextUtils.equals(eVar4.L().T().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.w.i(this.v.L());
                }
            }
            this.w.g(postData.E());
        }
        pbFirstFloorViewHolder.f18971e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.t) {
            pbFirstFloorViewHolder.f18971e.getLayoutStrategy().g(R.drawable.transparent_bg);
        } else {
            pbFirstFloorViewHolder.f18971e.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.f18971e.setIsFromCDN(this.q);
        d.a.n0.e2.h.e eVar5 = this.v;
        if (eVar5 != null && eVar5.L() != null && this.v.L().i2()) {
            s0(pbFirstFloorViewHolder, this.v.L().I0());
        }
        d.a.n0.e2.h.e eVar6 = this.v;
        if ((eVar6 == null || eVar6.L() == null || !this.v.L().u1 || postData.J() == null) ? false : true) {
            if (postData.J().z != null) {
                pbFirstFloorViewHolder.f18971e.getLayoutStrategy().m(w0(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.f18971e.getLayoutStrategy().m(w0(R.dimen.tbds14));
            }
            t0(pbFirstFloorViewHolder, postData);
        } else {
            pbFirstFloorViewHolder.f18971e.getLayoutStrategy().m(w0(R.dimen.tbds24));
        }
        TbRichText K = postData.K();
        d.a.n0.e2.h.e eVar7 = this.v;
        if (eVar7 == null || !eVar7.f0()) {
            tbRichText = K;
        }
        if (this.v.L() != null) {
            pbFirstFloorViewHolder.f18971e.setIsUseGridImage(this.v.L().S1());
            pbFirstFloorViewHolder.f18971e.setmIsGridImageSupportLongPress(true);
        }
        d.a.n0.e2.h.e eVar8 = this.v;
        if (eVar8 != null && 3 == eVar8.g()) {
            if (!this.D && this.E) {
                pbFirstFloorViewHolder.f18971e.setText(tbRichText, true, this.C, true, false);
            } else {
                pbFirstFloorViewHolder.f18971e.setText(tbRichText, false, this.C, true, false);
            }
        } else if (!this.D && this.E) {
            pbFirstFloorViewHolder.f18971e.setText(tbRichText, true, this.C, false, true);
        } else {
            pbFirstFloorViewHolder.f18971e.setText(tbRichText, false, this.C, false, true);
        }
        v0(pbFirstFloorViewHolder, postData, tbRichText);
        boolean z5 = !StringUtils.isNull(postData.t().getVirtualUserUrl());
        d.a.n0.e2.h.e eVar9 = this.v;
        if (eVar9 == null || eVar9.S() == 0) {
            z = false;
            z2 = false;
        } else {
            if (this.v.S() != 3) {
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
        d.a.n0.e2.h.e eVar10 = this.v;
        if (eVar10 != null && eVar10.L() != null && this.v.L().T() != null && postData.t() != null) {
            String userId2 = this.v.L().T().getUserId();
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
                        d.a.n0.e2.h.e eVar11 = this.v;
                        if (eVar11 != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar11.S()));
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
                        d.a.n0.e2.h.e eVar12 = this.v;
                        if (eVar12 != null && eVar12.L() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.v.L().o0());
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
                        d.a.n0.e2.h.e eVar13 = this.v;
                        if (eVar13 != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar13.S()));
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
        d.a.n0.e2.h.k kVar;
        boolean z;
        if (pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        pbFirstFloorViewHolder.f18971e.setTag(sparseArray);
        pbFirstFloorViewHolder.f18968b.setTag(R.id.tag_from, sparseArray);
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
        pbFirstFloorViewHolder.f18971e.setIsHost(true);
        if (this.u) {
            pbFirstFloorViewHolder.f18972f.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.f18972f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(postData.u()) && this.t) {
            this.F = true;
            pbFirstFloorViewHolder.f18971e.f0(postData.u(), new d(pbFirstFloorViewHolder, postData, view, i2));
        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.f18971e.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            pbFirstFloorViewHolder.f18971e.setLayoutParams(layoutParams);
            pbFirstFloorViewHolder.f18971e.e0(null);
            this.F = false;
            p0(pbFirstFloorViewHolder, postData, view, i2);
        }
        d.a.n0.e2.h.e eVar = this.v;
        if (eVar != null && eVar.L() != null && this.v.L().D2() && this.v.L().x1() != null && d.a.c.e.p.k.isEmpty(this.v.l().getName())) {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
        } else if (postData.K() != null && !ListUtils.isEmpty(postData.K().y())) {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
        } else {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
        }
        if (postData.K() != null) {
            if (postData.K().z() > 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.m.getLayoutParams();
                layoutParams2.topMargin = e0(R.dimen.tbds26);
                pbFirstFloorViewHolder.m.setLayoutParams(layoutParams2);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.m.getLayoutParams();
                layoutParams3.topMargin = e0(R.dimen.tbds16);
                pbFirstFloorViewHolder.m.setLayoutParams(layoutParams3);
            }
        }
        d.a.n0.e2.h.e eVar2 = this.v;
        if (eVar2 != null && z0(eVar2.L())) {
            pbFirstFloorViewHolder.u.setDataForPb(this.v.L().P0(), this.v.L().z1(), this.v.m());
            if (postData.K() != null && !ListUtils.isEmpty(postData.K().y())) {
                pbFirstFloorViewHolder.u.setMarginTop(d.a.c.e.p.l.g(this.G, R.dimen.tbds26));
            } else {
                pbFirstFloorViewHolder.u.setMarginTop(d.a.c.e.p.l.g(this.G, R.dimen.tbds0));
            }
            pbFirstFloorViewHolder.u.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.u.setVisibility(8);
        }
        d.a.n0.e2.h.e eVar3 = this.v;
        if (eVar3 != null && eVar3.L() != null && this.v.L().l1() != null && this.v.L().x1() == null) {
            pbFirstFloorViewHolder.m.setData(this.v.L().l1());
            pbFirstFloorViewHolder.m.setVisibility(0);
            d.a.n0.e2.h.e eVar4 = this.v;
            if (eVar4 != null && eVar4.l() != null) {
                pbFirstFloorViewHolder.m.setForumId(String.valueOf(this.v.l().getId()));
            }
            d.a.n0.e2.h.e eVar5 = this.v;
            if (eVar5 != null && eVar5.N() != null) {
                pbFirstFloorViewHolder.m.setThreadId(this.v.N());
            }
            pbFirstFloorViewHolder.m.setFrom("PB_card");
        } else {
            pbFirstFloorViewHolder.m.setVisibility(8);
        }
        K0();
        d.a.n0.e2.h.e eVar6 = this.v;
        if (eVar6 != null && (kVar = eVar6.f56615h) != null) {
            if (pbFirstFloorViewHolder.l != null) {
                if (TextUtils.isEmpty(kVar.e())) {
                    pbFirstFloorViewHolder.l.setVisibility(8);
                } else {
                    pbFirstFloorViewHolder.l.setVisibility(0);
                    pbFirstFloorViewHolder.l.setText(this.v.f56615h.e());
                }
            }
            if (pbFirstFloorViewHolder.k != null && pbFirstFloorViewHolder.t.h() == null) {
                pbFirstFloorViewHolder.k.addView(pbFirstFloorViewHolder.t.a(this.v));
                String fromPageKey = UtilHelper.getFromPageKey(this.n.getPageContext());
                Context context = this.G;
                if (!(context instanceof PbActivity) || ((PbActivity) context).getIntent() == null) {
                    z = false;
                } else {
                    z = ((PbActivity) this.G).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
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
        d.a.n0.e2.h.e eVar7 = this.v;
        if (eVar7 != null && eVar7.L() != null && !z0(this.v.L()) && (!ListUtils.isEmpty(this.v.L().H0()) || !ListUtils.isEmpty(this.v.L().l0()))) {
            d.a.m0.z0.j0 j0Var = new d.a.m0.z0.j0();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.G);
            d.a.n0.e2.h.e eVar8 = this.v;
            pbLinkGoodsRootView.i(eVar8, j0Var.a(eVar8.L().H0(), this.v.L().l0()), this.v.n(), this.n, j0Var.b());
            pbFirstFloorViewHolder.n.addView(pbLinkGoodsRootView);
            pbFirstFloorViewHolder.n.setVisibility(0);
            return;
        }
        pbFirstFloorViewHolder.n.setVisibility(8);
    }

    public final void s0(PbFirstFloorViewHolder pbFirstFloorViewHolder, d.a.m0.r.q.p0 p0Var) {
        if (p0Var == null || d.a.c.e.p.k.isEmpty(p0Var.e()) || p0Var.c() != d.a.m0.r.q.p0.f53768g) {
            return;
        }
        if (!p0Var.f()) {
            pbFirstFloorViewHolder.f18971e.getLayoutStrategy().m(d.a.c.e.p.l.g(this.G, R.dimen.ds48));
        }
        pbFirstFloorViewHolder.o.c(p0Var);
    }

    public void t(d.a.n0.e2.h.e eVar) {
        this.v = eVar;
    }

    public final void t0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View a2;
        if (pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        pbFirstFloorViewHolder.p.setVisibility(0);
        if (pbFirstFloorViewHolder.q == null) {
            pbFirstFloorViewHolder.q = x0(postData);
        }
        if (pbFirstFloorViewHolder.p.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.q.a()) != null) {
            pbFirstFloorViewHolder.p.addView(a2);
        }
        pbFirstFloorViewHolder.q.e(this.J);
        pbFirstFloorViewHolder.q.d(this.K);
        pbFirstFloorViewHolder.q.c(postData.J());
        pbFirstFloorViewHolder.q.b(this.n.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void v0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        if (postData != null && postData.O() != null) {
            d.a.n0.e2.p.f.c(postData.O(), pbFirstFloorViewHolder.j, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.u()));
        } else {
            pbFirstFloorViewHolder.j.setVisibility(8);
        }
    }

    public final int w0(int i2) {
        return d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d.a.n0.e2.k.e.d1.a x0(PostData postData) {
        d.a.n0.e2.k.e.d1.a aVar;
        if (postData != null && postData.J() != null && postData.J().f()) {
            BaijiahaoData baijiahaoData = postData.J().p;
            Item item = postData.J().z;
            if (postData.J().m) {
                aVar = new d.a.n0.e2.k.e.d1.d(this.n.getPageContext(), this.H);
            } else if (item != null && item.item_id.longValue() != 0) {
                if (postData.J().f12095a != 0 && postData.J().f12095a != 1) {
                    if (postData.J().f12095a == 3) {
                        aVar = new d.a.n0.e2.k.e.d1.g(this.n.getPageContext());
                    } else {
                        aVar = new d.a.n0.e2.k.e.d1.e(this.n.getPageContext());
                    }
                } else {
                    aVar = new d.a.n0.e2.k.e.d1.f(this.n.getPageContext());
                }
            } else if (baijiahaoData != null && postData.J().g()) {
                int i2 = baijiahaoData.oriUgcType;
                if (i2 == 1) {
                    aVar = new d.a.n0.e2.k.e.d1.b(this.n.getPageContext(), this.H);
                } else if (i2 == 2) {
                    aVar = new d.a.n0.e2.k.e.d1.i(this.n.getPageContext(), this.H);
                } else if (i2 == 3) {
                    aVar = new d.a.n0.e2.k.e.d1.h(this.n.getPageContext(), this.H);
                } else if (i2 != 4) {
                    aVar = new d.a.n0.e2.k.e.d1.c(this.n.getPageContext(), this.H);
                } else {
                    aVar = new d.a.n0.e2.k.e.d1.i(this.n.getPageContext(), this.H);
                }
            } else if (postData.J().f12095a != 0 && postData.J().f12095a != 1) {
                if (postData.J().f12095a == 3) {
                    aVar = new d.a.n0.e2.k.e.d1.i(this.n.getPageContext(), this.H);
                }
            } else {
                aVar = new d.a.n0.e2.k.e.d1.h(this.n.getPageContext(), this.H);
            }
            return aVar != null ? new d.a.n0.e2.k.e.d1.c(this.n.getPageContext(), this.H) : aVar;
        }
        aVar = null;
        if (aVar != null) {
        }
    }

    public PbFirstFloorViewHolder y0() {
        return (PbFirstFloorViewHolder) this.k;
    }

    public final boolean z0(a2 a2Var) {
        return (a2Var == null || a2Var.P0() == null || a2Var.P0().getOptions() == null || a2Var.P0().getOptions().size() <= 0) ? false : true;
    }
}
