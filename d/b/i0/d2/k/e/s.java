package d.b.i0.d2.k.e;

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
import d.b.h0.r.q.a2;
import d.b.h0.r.q.m2;
import d.b.i.a;
import d.b.i0.d2.i.c;
import tbclient.Item;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class s extends o<PostData, PbFirstFloorViewHolder> {
    public d.b.i0.d2.i.c A;
    public View.OnLongClickListener B;
    public TbRichTextView.r C;
    public boolean D;
    public final boolean E;
    public boolean F;
    public int G;
    public d.b.i0.d2.i.c H;
    public d.b.i0.x.b0<d.b.h0.r.q.a> I;
    public a.InterfaceC1129a J;
    public int s;
    public boolean t;
    public boolean u;
    public d.b.i0.d2.h.e v;
    public d.b.i0.d2.k.g.b w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public TbRichTextView.x z;

    /* loaded from: classes3.dex */
    public class a implements c.a {
        public a() {
        }

        @Override // d.b.i0.d2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (s.this.A != null) {
                s.this.A.a(view);
                s.this.A.onSingleTapConfirmed(motionEvent);
                return true;
            }
            return true;
        }

        @Override // d.b.i0.d2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, 2));
            return true;
        }

        @Override // d.b.i0.d2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.i0.x.b0<d.b.h0.r.q.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.h0.r.q.a aVar) {
            super.a(view, aVar);
            if (aVar == null || aVar.n() == null || aVar.n().r1 == null || s.this.v == null) {
                return;
            }
            OriginalThreadInfo originalThreadInfo = aVar.n().r1;
            String N = s.this.v.N();
            String str = originalThreadInfo.f12877f;
            int i = 1;
            int i2 = originalThreadInfo.f12872a;
            if (i2 == 3) {
                i = 2;
            } else if (i2 == 4) {
                i = 3;
            }
            if (StringUtils.isNull(N) || StringUtils.isNull(str)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12602").param("tid", N).param("obj_source", str).param("obj_type", i));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.InterfaceC1129a {
        public c() {
        }

        @Override // d.b.i.a.InterfaceC1129a
        public void a(d.b.h0.r.q.a aVar) {
            if (aVar == null || aVar.n() == null || aVar.n().r1 == null) {
                return;
            }
            OriginalThreadInfo originalThreadInfo = aVar.n().r1;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(s.this.f42855e);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f12877f, originalThreadInfo.n, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.f12876e));
            pbActivityConfig.setStartFrom(s.this.G);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements TbRichTextView.u {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFirstFloorViewHolder f54241a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PostData f54242b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f54243c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f54244d;

        public d(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i) {
            this.f54241a = pbFirstFloorViewHolder;
            this.f54242b = postData;
            this.f54243c = view;
            this.f54244d = i;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
        public void a() {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f54241a.f19223e.getLayoutParams();
            layoutParams.topMargin = s.this.h0(R.dimen.ds16);
            int h0 = s.this.h0(R.dimen.ds34);
            layoutParams.bottomMargin = h0;
            layoutParams.leftMargin = h0;
            layoutParams.rightMargin = h0;
            this.f54241a.f19223e.setLayoutParams(layoutParams);
            s.this.q0(this.f54241a, this.f54242b, this.f54243c, this.f54244d);
        }
    }

    /* loaded from: classes3.dex */
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
        int i = Build.VERSION.SDK_INT;
        this.E = (i < 14 || i > 16) ? false : false;
        this.F = false;
        this.G = 0;
        this.H = new d.b.i0.d2.i.c(new a());
        this.I = new b();
        this.J = new c();
        if (pbFragment == null || pbFragment.L() == null) {
            return;
        }
        this.G = pbFragment.L().x0();
    }

    public View A0(int i, View view, ViewGroup viewGroup, PostData postData, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        BdListView listView;
        super.X(i, view, viewGroup, postData, pbFirstFloorViewHolder);
        I0(pbFirstFloorViewHolder);
        E0(pbFirstFloorViewHolder);
        PostData postData2 = (PostData) z(i);
        if (postData2 != null) {
            postData2.B0();
            postData2.d0 = i + 1;
            d.b.i0.d2.m.a.d(this.n.getUniqueId(), this.v, postData2, postData2.d0, 1);
            r0(pbFirstFloorViewHolder, postData2, view, i);
        }
        if (!this.D && this.E && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.f19223e.E() && (listView = this.n.getListView()) != null) {
            this.D = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    public void B0() {
        V v = this.k;
        if (v != 0) {
            ((PbFirstFloorViewHolder) v).o.d();
        }
    }

    public void C0() {
        V v = this.k;
        if (v != 0) {
            ((PbFirstFloorViewHolder) v).o.a();
            ((PbFirstFloorViewHolder) this.k).s.g();
        }
    }

    public void D0() {
        V v = this.k;
        if (v != 0) {
            ((PbFirstFloorViewHolder) v).o.e();
        }
    }

    public final void E0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.f19220b.setOnTouchListener(this.A);
        pbFirstFloorViewHolder.f19220b.setOnLongClickListener(this.B);
        d.b.i0.d2.k.e.b1.a aVar = this.m.P().mEvent;
        pbFirstFloorViewHolder.f19223e.setOnLongClickListener(this.B);
        pbFirstFloorViewHolder.f19223e.setOnTouchListener(this.H);
        pbFirstFloorViewHolder.f19223e.setCommonTextViewOnClickListener(this.y);
        pbFirstFloorViewHolder.f19223e.setOnImageClickListener(this.z);
        pbFirstFloorViewHolder.f19223e.setOnImageTouchListener(this.H);
        pbFirstFloorViewHolder.f19223e.setmGridEmptyClickListener(new e(this));
        pbFirstFloorViewHolder.f19223e.setOnEmotionClickListener(aVar.f54026e);
        pbFirstFloorViewHolder.j.setOnClickListener(this.y);
        pbFirstFloorViewHolder.r.setAfterItemClickListener(this.y);
        pbFirstFloorViewHolder.s.setAfterItemClickListener(this.y);
    }

    public void F0(boolean z) {
        this.u = z;
    }

    public void G0(d.b.i0.d2.i.c cVar) {
        this.A = cVar;
    }

    public void H0(TbRichTextView.r rVar) {
        this.C = rVar;
    }

    public final void I0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        if (pbFirstFloorViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbFirstFloorViewHolder.f19219a != skinType) {
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.f19224f, R.color.CAM_X0204);
            pbFirstFloorViewHolder.f19223e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
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
        pbFirstFloorViewHolder.f19219a = TbadkCoreApplication.getInst().getSkinType();
    }

    public void J0() {
        PbFirstFloorViewHolder x0 = x0();
        d.b.i0.d2.h.e eVar = this.v;
        if (eVar == null || eVar.L() == null || x0 == null) {
            return;
        }
        x0.d(this.v, this.v.L().w0() == 1, this.v.L().x0() == 1);
    }

    @Override // d.b.i0.d2.k.e.o, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        A0(i, view, viewGroup, (PostData) obj, (PbFirstFloorViewHolder) viewHolder);
        return view;
    }

    public void e(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void g(int i) {
        this.s = i;
    }

    public void h(boolean z) {
        this.t = z;
    }

    public void j(TbRichTextView.x xVar) {
        this.z = xVar;
    }

    public void k(View.OnLongClickListener onLongClickListener) {
        this.B = onLongClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public final void o0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.f19223e.setTextViewOnTouchListener(this.H);
        pbFirstFloorViewHolder.f19223e.setTextViewCheckSelection(false);
    }

    public final void p0(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView == null) {
            return;
        }
        int min = Math.min(((((d.b.c.e.p.l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - (z ? h0(R.dimen.ds80) : 0), this.s);
        tbRichTextView.getLayoutStrategy().q(min);
        tbRichTextView.getLayoutStrategy().p((int) (min * 1.618f));
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
    public final void q0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i) {
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
                pbFirstFloorViewHolder.f19223e.setOnClickListener(this.y);
                pbFirstFloorViewHolder.f19223e.setTextViewOnClickListener(this.y);
            } else {
                pbFirstFloorViewHolder.f19223e.setOnClickListener(null);
                pbFirstFloorViewHolder.f19223e.setTextViewOnClickListener(null);
            }
            pbFirstFloorViewHolder.f19220b.setOnClickListener(this.y);
        } else {
            pbFirstFloorViewHolder.f19220b.setOnClickListener(null);
        }
        if (postData.A() == 1) {
            pbFirstFloorViewHolder.c(this.v, this.n.isSimpleForum(), postData.Q);
            p0(pbFirstFloorViewHolder.f19223e, view, this.F);
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
            d.b.i0.d2.h.e eVar = this.v;
            if (eVar != null && eVar.L() != null) {
                pbFirstFloorViewHolder.o.b(postData.D(), str, str2, j, d.b.c.e.m.b.f(this.v.L().o0(), 0L), d.b.c.e.m.b.f(postData.E(), 0L));
            }
            if (this.n.J4().x1()) {
                pbFirstFloorViewHolder.f19223e.setVisibility(8);
            }
            d.b.i0.d2.h.e eVar2 = this.v;
            if (eVar2 != null && eVar2.L() != null && this.v.L().I1() != null) {
                m2 I1 = this.v.L().I1();
                String a2 = I1.a();
                if (StringUtils.isNull(I1.b())) {
                    return;
                }
                if (!StringUtils.isNull(a2)) {
                    pbFirstFloorViewHolder.f19226h.setVisibility(0);
                    pbFirstFloorViewHolder.f19226h.W(a2, 10, true);
                }
            } else {
                pbFirstFloorViewHolder.f19226h.setVisibility(8);
            }
            ThreadSkinView threadSkinView = pbFirstFloorViewHolder.i;
            if (threadSkinView != null) {
                threadSkinView.setVisibility(8);
            }
            d.b.i0.d2.h.e eVar3 = this.v;
            if (eVar3 != null && eVar3.L() != null && this.v.L().z2() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.r) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.r.getPaddingRight(), pbFirstFloorViewHolder.r.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.f19223e.getLayoutStrategy().x(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_load_sub_data, postData);
        sparseArray.put(R.id.tag_load_sub_view, view);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.A()));
        boolean W = postData.W();
        if (W) {
            if (this.w == null) {
                d.b.i0.d2.k.g.b bVar = new d.b.i0.d2.k.g.b(this.f42855e);
                this.w = bVar;
                bVar.f(this.q);
                this.w.h(this.x);
                d.b.i0.d2.h.e eVar4 = this.v;
                if (eVar4 != null) {
                    this.w.j(this.v.S(), TextUtils.equals(eVar4.L().T().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.w.i(this.v.L());
                }
            }
            this.w.g(postData.E());
        }
        pbFirstFloorViewHolder.f19223e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.t) {
            pbFirstFloorViewHolder.f19223e.getLayoutStrategy().g(R.drawable.transparent_bg);
        } else {
            pbFirstFloorViewHolder.f19223e.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.f19223e.setIsFromCDN(this.q);
        d.b.i0.d2.h.e eVar5 = this.v;
        if (eVar5 != null && eVar5.L() != null && this.v.L().f2()) {
            s0(pbFirstFloorViewHolder, this.v.L().H0());
        }
        d.b.i0.d2.h.e eVar6 = this.v;
        if ((eVar6 == null || eVar6.L() == null || !this.v.L().s1 || postData.J() == null) ? false : true) {
            if (postData.J().z != null) {
                pbFirstFloorViewHolder.f19223e.getLayoutStrategy().m(v0(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.f19223e.getLayoutStrategy().m(v0(R.dimen.tbds14));
            }
            t0(pbFirstFloorViewHolder, postData);
        } else {
            pbFirstFloorViewHolder.f19223e.getLayoutStrategy().m(v0(R.dimen.tbds24));
        }
        TbRichText K = postData.K();
        d.b.i0.d2.h.e eVar7 = this.v;
        if (eVar7 == null || !eVar7.f0()) {
            tbRichText = K;
        }
        if (this.v.L() != null) {
            pbFirstFloorViewHolder.f19223e.setIsUseGridImage(this.v.L().P1());
            pbFirstFloorViewHolder.f19223e.setmIsGridImageSupportLongPress(true);
        }
        d.b.i0.d2.h.e eVar8 = this.v;
        if (eVar8 != null && 3 == eVar8.g()) {
            if (!this.D && this.E) {
                pbFirstFloorViewHolder.f19223e.setText(tbRichText, true, this.C, true, false);
            } else {
                pbFirstFloorViewHolder.f19223e.setText(tbRichText, false, this.C, true, false);
            }
        } else if (!this.D && this.E) {
            pbFirstFloorViewHolder.f19223e.setText(tbRichText, true, this.C, false, true);
        } else {
            pbFirstFloorViewHolder.f19223e.setText(tbRichText, false, this.C, false, true);
        }
        u0(pbFirstFloorViewHolder, postData, tbRichText);
        boolean z5 = !StringUtils.isNull(postData.t().getVirtualUserUrl());
        d.b.i0.d2.h.e eVar9 = this.v;
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
        d.b.i0.d2.h.e eVar10 = this.v;
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
                    int i2 = postData.A() == 1 ? 0 : 1;
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                    if (z) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                        }
                        d.b.i0.d2.h.e eVar11 = this.v;
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
                        d.b.i0.d2.h.e eVar12 = this.v;
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
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.E());
                        d.b.i0.d2.h.e eVar13 = this.v;
                        if (eVar13 != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar13.S()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    o0(pbFirstFloorViewHolder);
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
                o0(pbFirstFloorViewHolder);
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
        o0(pbFirstFloorViewHolder);
    }

    public final void r0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i) {
        d.b.i0.d2.h.k kVar;
        boolean z;
        if (pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        pbFirstFloorViewHolder.f19223e.setTag(sparseArray);
        pbFirstFloorViewHolder.f19220b.setTag(R.id.tag_from, sparseArray);
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
        pbFirstFloorViewHolder.f19223e.setIsHost(true);
        if (this.u) {
            pbFirstFloorViewHolder.f19224f.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.f19224f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(postData.u()) && this.t) {
            this.F = true;
            pbFirstFloorViewHolder.f19223e.f0(postData.u(), new d(pbFirstFloorViewHolder, postData, view, i));
        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.f19223e.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            pbFirstFloorViewHolder.f19223e.setLayoutParams(layoutParams);
            pbFirstFloorViewHolder.f19223e.e0(null);
            this.F = false;
            q0(pbFirstFloorViewHolder, postData, view, i);
        }
        d.b.i0.d2.h.e eVar = this.v;
        if (eVar != null && eVar.L() != null && this.v.L().z2() && this.v.L().u1() != null && d.b.c.e.p.k.isEmpty(this.v.l().getName())) {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
        } else if (postData.K() != null && !ListUtils.isEmpty(postData.K().u())) {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
        } else {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
        }
        if (postData.K() != null) {
            if (postData.K().v() > 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.m.getLayoutParams();
                layoutParams2.topMargin = h0(R.dimen.tbds26);
                pbFirstFloorViewHolder.m.setLayoutParams(layoutParams2);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.m.getLayoutParams();
                layoutParams3.topMargin = h0(R.dimen.tbds16);
                pbFirstFloorViewHolder.m.setLayoutParams(layoutParams3);
            }
        }
        d.b.i0.d2.h.e eVar2 = this.v;
        if (eVar2 != null && y0(eVar2.L())) {
            pbFirstFloorViewHolder.u.setDataForPb(this.v.L().O0(), this.v.L().w1(), this.v.m());
            if (postData.K() != null && !ListUtils.isEmpty(postData.K().u())) {
                pbFirstFloorViewHolder.u.setMarginTop(d.b.c.e.p.l.g(this.f42855e, R.dimen.tbds26));
            } else {
                pbFirstFloorViewHolder.u.setMarginTop(d.b.c.e.p.l.g(this.f42855e, R.dimen.tbds0));
            }
            pbFirstFloorViewHolder.u.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.u.setVisibility(8);
        }
        d.b.i0.d2.h.e eVar3 = this.v;
        if (eVar3 != null && eVar3.L() != null && this.v.L().j1() != null && this.v.L().u1() == null) {
            pbFirstFloorViewHolder.m.setData(this.v.L().j1());
            pbFirstFloorViewHolder.m.setVisibility(0);
            d.b.i0.d2.h.e eVar4 = this.v;
            if (eVar4 != null && eVar4.l() != null) {
                pbFirstFloorViewHolder.m.setForumId(String.valueOf(this.v.l().getId()));
            }
            d.b.i0.d2.h.e eVar5 = this.v;
            if (eVar5 != null && eVar5.N() != null) {
                pbFirstFloorViewHolder.m.setThreadId(this.v.N());
            }
            pbFirstFloorViewHolder.m.setFrom("PB_card");
        } else {
            pbFirstFloorViewHolder.m.setVisibility(8);
        }
        J0();
        d.b.i0.d2.h.e eVar6 = this.v;
        if (eVar6 != null && (kVar = eVar6.f53822h) != null) {
            if (pbFirstFloorViewHolder.l != null) {
                if (TextUtils.isEmpty(kVar.e())) {
                    pbFirstFloorViewHolder.l.setVisibility(8);
                } else {
                    pbFirstFloorViewHolder.l.setVisibility(0);
                    pbFirstFloorViewHolder.l.setText(this.v.f53822h.e());
                }
            }
            if (pbFirstFloorViewHolder.k != null && pbFirstFloorViewHolder.t.h() == null) {
                pbFirstFloorViewHolder.k.addView(pbFirstFloorViewHolder.t.a(this.v));
                String fromPageKey = UtilHelper.getFromPageKey(this.n.getPageContext());
                Context context = this.f42855e;
                if (!(context instanceof PbActivity) || ((PbActivity) context).getIntent() == null) {
                    z = false;
                } else {
                    z = ((PbActivity) this.f42855e).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
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
        d.b.i0.d2.h.e eVar7 = this.v;
        if (eVar7 != null && eVar7.L() != null && !y0(this.v.L()) && (!ListUtils.isEmpty(this.v.L().G0()) || !ListUtils.isEmpty(this.v.L().l0()))) {
            d.b.h0.z0.j0 j0Var = new d.b.h0.z0.j0();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.f42855e);
            d.b.i0.d2.h.e eVar8 = this.v;
            pbLinkGoodsRootView.i(eVar8, j0Var.a(eVar8.L().G0(), this.v.L().l0()), this.v.n(), this.n, j0Var.b());
            pbFirstFloorViewHolder.n.addView(pbLinkGoodsRootView);
            pbFirstFloorViewHolder.n.setVisibility(0);
            return;
        }
        pbFirstFloorViewHolder.n.setVisibility(8);
    }

    public void s(d.b.i0.d2.h.e eVar) {
        this.v = eVar;
    }

    public final void s0(PbFirstFloorViewHolder pbFirstFloorViewHolder, d.b.h0.r.q.p0 p0Var) {
        if (p0Var == null || d.b.c.e.p.k.isEmpty(p0Var.e()) || p0Var.c() != d.b.h0.r.q.p0.f51262g) {
            return;
        }
        if (!p0Var.f()) {
            pbFirstFloorViewHolder.f19223e.getLayoutStrategy().m(d.b.c.e.p.l.g(this.f42855e, R.dimen.ds48));
        }
        pbFirstFloorViewHolder.o.c(p0Var);
    }

    public final void t0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View a2;
        if (pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        pbFirstFloorViewHolder.p.setVisibility(0);
        if (pbFirstFloorViewHolder.q == null) {
            pbFirstFloorViewHolder.q = w0(postData);
        }
        if (pbFirstFloorViewHolder.p.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.q.a()) != null) {
            pbFirstFloorViewHolder.p.addView(a2);
        }
        pbFirstFloorViewHolder.q.e(this.I);
        pbFirstFloorViewHolder.q.d(this.J);
        pbFirstFloorViewHolder.q.c(postData.J());
        pbFirstFloorViewHolder.q.b(this.n.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void u0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        if (postData != null && postData.O() != null) {
            d.b.i0.d2.p.f.c(postData.O(), pbFirstFloorViewHolder.j, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.u()));
        } else {
            pbFirstFloorViewHolder.j.setVisibility(8);
        }
    }

    public final int v0(int i) {
        return d.b.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), i);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d.b.i0.d2.k.e.c1.a w0(PostData postData) {
        d.b.i0.d2.k.e.c1.a aVar;
        if (postData != null && postData.J() != null && postData.J().f()) {
            BaijiahaoData baijiahaoData = postData.J().p;
            Item item = postData.J().z;
            if (postData.J().m) {
                aVar = new d.b.i0.d2.k.e.c1.d(this.n.getPageContext(), this.G);
            } else if (item != null && item.item_id.longValue() != 0) {
                if (postData.J().f12872a != 0 && postData.J().f12872a != 1) {
                    if (postData.J().f12872a == 3) {
                        aVar = new d.b.i0.d2.k.e.c1.g(this.n.getPageContext());
                    } else {
                        aVar = new d.b.i0.d2.k.e.c1.e(this.n.getPageContext());
                    }
                } else {
                    aVar = new d.b.i0.d2.k.e.c1.f(this.n.getPageContext());
                }
            } else if (baijiahaoData != null && postData.J().g()) {
                int i = baijiahaoData.oriUgcType;
                if (i == 1) {
                    aVar = new d.b.i0.d2.k.e.c1.b(this.n.getPageContext(), this.G);
                } else if (i == 2) {
                    aVar = new d.b.i0.d2.k.e.c1.i(this.n.getPageContext(), this.G);
                } else if (i == 3) {
                    aVar = new d.b.i0.d2.k.e.c1.h(this.n.getPageContext(), this.G);
                } else if (i != 4) {
                    aVar = new d.b.i0.d2.k.e.c1.c(this.n.getPageContext(), this.G);
                } else {
                    aVar = new d.b.i0.d2.k.e.c1.i(this.n.getPageContext(), this.G);
                }
            } else if (postData.J().f12872a != 0 && postData.J().f12872a != 1) {
                if (postData.J().f12872a == 3) {
                    aVar = new d.b.i0.d2.k.e.c1.i(this.n.getPageContext(), this.G);
                }
            } else {
                aVar = new d.b.i0.d2.k.e.c1.h(this.n.getPageContext(), this.G);
            }
            return aVar != null ? new d.b.i0.d2.k.e.c1.c(this.n.getPageContext(), this.G) : aVar;
        }
        aVar = null;
        if (aVar != null) {
        }
    }

    public PbFirstFloorViewHolder x0() {
        return (PbFirstFloorViewHolder) this.k;
    }

    public final boolean y0(a2 a2Var) {
        return (a2Var == null || a2Var.O0() == null || a2Var.O0().getOptions() == null || a2Var.O0().getOptions().size() <= 0) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: z0 */
    public PbFirstFloorViewHolder R(ViewGroup viewGroup) {
        PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.n.getPageContext(), LayoutInflater.from(this.f42855e).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.t, this.s);
        I0(pbFirstFloorViewHolder);
        pbFirstFloorViewHolder.o.f(this.G);
        return pbFirstFloorViewHolder;
    }
}
