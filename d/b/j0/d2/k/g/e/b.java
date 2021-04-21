package d.b.j0.d2.k.g.e;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.i0.r.k;
import d.b.i0.r.q.a2;
/* loaded from: classes3.dex */
public class b extends d.b.j0.d2.k.g.e.a<PostData, PbCommenFloorItemViewHolder> {
    public d.b.c.e.k.b<ConstrainImageLayout> A;
    public d.b.c.e.k.b<TbImageView> B;
    public a2 o;
    public TbRichTextView.r p;
    public boolean q;
    public String r;
    public View.OnClickListener s;
    public TbRichTextView.x t;
    public d.b.j0.d2.i.c u;
    public View.OnLongClickListener v;
    public d.b.j0.d2.k.e.b1.c w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements d.b.c.e.k.c<ConstrainImageLayout> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            constrainImageLayout.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            return new ConstrainImageLayout(b.this.m.getPageContext().getPageActivity());
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }
    }

    /* renamed from: d.b.j0.d2.k.g.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1248b implements d.b.c.e.k.c<TbImageView> {
        public C1248b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            return tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            tbImageView.setOnClickListener(null);
            tbImageView.setForegroundColor(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            TbImageView tbImageView = new TbImageView(b.this.m.getPageContext().getPageActivity());
            tbImageView.setDrawBorder(true);
            tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
            return tbImageView;
        }

        public TbImageView h(TbImageView tbImageView) {
            tbImageView.setOnClickListener(null);
            tbImageView.setForegroundColor(0);
            return tbImageView;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f54907e;

        public c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            this.f54907e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && this.f54907e.a() != null) {
                this.f54907e.a().setTag(R.id.tag_subpb_ban_display_keyboard, Boolean.TRUE);
            }
            b.this.s.onClick(this.f54907e.a());
            if (view != null) {
                view.setTag(R.id.tag_subpb_ban_display_keyboard, null);
            }
            if (this.f54907e.a() != null) {
                this.f54907e.a().setTag(R.id.tag_subpb_ban_display_keyboard, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f54909e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostData f54911e;

            public a(PostData postData) {
                this.f54911e = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                b bVar = b.this;
                bVar.w.f54467b.a(null, bVar.o, this.f54911e, dVar.f54909e.m.getLayoutStrategy());
            }
        }

        public d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            this.f54909e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostData postData;
            if (view.getTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) == null || this.f54909e.f19219b == null || b.this.w == null) {
                    return;
                }
                d.b.c.e.m.e.a().postDelayed(new a(postData), 100L);
                String o0 = b.this.o.o0();
                if (StringUtils.isNull(o0) || "0".equals(o0)) {
                    o0 = b.this.o.L0();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", o0).param("fid", b.this.o.c0()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.E()).param("obj_source", 1).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f54913e;

        public e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            this.f54913e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            if (view == null || b.this.o == null || (pbCommenFloorItemViewHolder = this.f54913e) == null || (agreeView = pbCommenFloorItemViewHolder.C) == null || agreeView.getData() == null) {
                return;
            }
            int i = view == this.f54913e.C.getImgAgree() ? 1 : 2;
            String o0 = b.this.o.o0();
            if (StringUtils.isNull(o0) || "0".equals(o0)) {
                o0 = b.this.o.L0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", o0).param("fid", b.this.o.c0()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f54913e.C.getData().postId).param("obj_source", 1).param("obj_type", i));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f54915e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostData f54917e;

            public a(PostData postData) {
                this.f54917e = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                b bVar = b.this;
                bVar.w.f54467b.a(null, bVar.o, this.f54917e, fVar.f54915e.m.getLayoutStrategy());
            }
        }

        public f(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            this.f54915e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostData postData;
            if (view.getTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) == null || this.f54915e.f19219b == null || b.this.w == null) {
                    return;
                }
                d.b.c.e.m.e.a().postDelayed(new a(postData), 100L);
                String o0 = b.this.o.o0();
                if (StringUtils.isNull(o0) || "0".equals(o0)) {
                    o0 = b.this.o.L0();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", o0).param("fid", b.this.o.c0()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.E()).param("obj_source", 1).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f54919e;

        public g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            this.f54919e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            if (view == null || b.this.o == null || (pbCommenFloorItemViewHolder = this.f54919e) == null || (agreeView = pbCommenFloorItemViewHolder.k) == null || agreeView.getData() == null) {
                return;
            }
            int i = view == this.f54919e.k.getImgAgree() ? 1 : 2;
            String o0 = b.this.o.o0();
            if (StringUtils.isNull(o0) || "0".equals(o0)) {
                o0 = b.this.o.L0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", o0).param("fid", b.this.o.c0()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f54919e.k.getData().postId).param("obj_source", 1).param("obj_type", i));
        }
    }

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.o = null;
        this.p = null;
        this.q = k.c().g();
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = d.b.i0.b.d.U();
        this.z = false;
        this.A = new d.b.c.e.k.b<>(new a(), 6, 0);
        this.B = new d.b.c.e.k.b<>(new C1248b(), 12, 0);
        if (newSubPbActivity == null || newSubPbActivity.getSubPbModel() == null) {
            return;
        }
        this.x = newSubPbActivity.getSubPbModel().Y();
    }

    @Override // d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        r0(i, view, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view;
    }

    public final void i0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.m.setTextViewOnTouchListener(this.u);
        pbCommenFloorItemViewHolder.m.setTextViewCheckSelection(false);
    }

    public void j(TbRichTextView.x xVar) {
        this.t = xVar;
    }

    public final void j0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (pbCommenFloorItemViewHolder.J.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.J.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = d.b.j0.d2.k.b.i(R.dimen.tbds2);
        layoutParams.leftMargin = d.b.j0.d2.k.b.i(R.dimen.tbds148);
        if (this.y) {
            layoutParams.topMargin = d.b.j0.d2.k.b.i(R.dimen.tbds0);
        }
        pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
        ColumnLayout columnLayout = (ColumnLayout) pbCommenFloorItemViewHolder.a().findViewById(R.id.item_head_owner_root);
        if (columnLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) columnLayout.getLayoutParams();
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams2.leftMargin = d.b.j0.d2.k.b.i(R.dimen.tbds21);
        layoutParams2.rightMargin = d.b.j0.d2.k.b.i(R.dimen.tbds1);
        columnLayout.setLayoutParams(layoutParams2);
        pbCommenFloorItemViewHolder.m.setCommonTextViewOnClickListener(new c(pbCommenFloorItemViewHolder));
    }

    public void k(View.OnLongClickListener onLongClickListener) {
        this.v = onLongClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }

    public final void l0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i) {
        if (this.y) {
            View view = pbCommenFloorItemViewHolder.w;
            if (view != null) {
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.w.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            View view2 = pbCommenFloorItemViewHolder.v;
            if (view2 != null) {
                SparseArray sparseArray2 = (SparseArray) view2.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.v.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        ImageView imageView = pbCommenFloorItemViewHolder.s;
        if (imageView != null) {
            SparseArray sparseArray3 = (SparseArray) imageView.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.s.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        ImageView imageView2 = pbCommenFloorItemViewHolder.t;
        if (imageView2 != null) {
            SparseArray sparseArray4 = (SparseArray) imageView2.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                pbCommenFloorItemViewHolder.t.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.h0));
        }
    }

    public final void m0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.T.setVisibility(postData.b0 ? 0 : 8);
    }

    public final void n0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.U = i;
        d.b.j0.d2.k.b.h(pbCommenFloorItemViewHolder, postData, view, i, this.m, this.o, this.y, i == 0);
        d.b.j0.d2.k.b.e(pbCommenFloorItemViewHolder, postData, this.o, i, this.y);
        if (this.y && postData.h0) {
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            if (this.o.y2()) {
                pbCommenFloorItemViewHolder.I.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.I.setVisibility(0);
            }
        } else {
            pbCommenFloorItemViewHolder.u.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(0);
            pbCommenFloorItemViewHolder.s.setVisibility(0);
            pbCommenFloorItemViewHolder.t.setVisibility(0);
            pbCommenFloorItemViewHolder.k.setVisibility(0);
            pbCommenFloorItemViewHolder.I.setVisibility(8);
        }
        d.b.j0.d2.k.b.c(pbCommenFloorItemViewHolder, postData, postData.h0, this.y);
        d.b.j0.d2.k.b.f(this.m, pbCommenFloorItemViewHolder, postData, view, this.q, this.n, i != 0, this.p);
        d.b.j0.d2.k.b.d(this.m, pbCommenFloorItemViewHolder, postData, this.o);
        d.b.j0.d2.k.b.g(pbCommenFloorItemViewHolder, postData);
        d.b.j0.d2.k.b.b(pbCommenFloorItemViewHolder, postData, this.q);
        m0(pbCommenFloorItemViewHolder, postData);
    }

    public final void o0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.f19219b == null) {
            return;
        }
        if (StringHelper.equals(this.r, postData.E())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f19219b, R.color.CAM_X0313);
        } else {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f19219b, R.color.CAM_X0205);
        }
    }

    public final void p0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i) {
        if (pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (i == 0) {
            pbCommenFloorItemViewHolder.g(postData.S, postData.E(), this.z);
        } else {
            pbCommenFloorItemViewHolder.g(postData.l0 == 1, postData.E(), this.z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: q0 */
    public PbCommenFloorItemViewHolder R(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f43095e).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
        ((ViewGroup) inflate.findViewById(R.id.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null));
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.m.getPageContext(), inflate, this.x);
        pbCommenFloorItemViewHolder.f(true);
        pbCommenFloorItemViewHolder.n.setConstrainLayoutPool(this.A);
        pbCommenFloorItemViewHolder.n.setImageViewPool(this.B);
        j0(pbCommenFloorItemViewHolder);
        d.b.j0.d2.k.b.k(pbCommenFloorItemViewHolder, null, this.y);
        return pbCommenFloorItemViewHolder;
    }

    public View r0(int i, View view, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        l0(pbCommenFloorItemViewHolder, postData, i);
        s0(pbCommenFloorItemViewHolder);
        i0(pbCommenFloorItemViewHolder);
        PostData postData2 = (PostData) z(i);
        if (postData2 != null) {
            postData2.B0();
            n0(pbCommenFloorItemViewHolder, postData2, view, i);
            o0(pbCommenFloorItemViewHolder, postData);
            p0(pbCommenFloorItemViewHolder, postData, i);
        }
        d.b.j0.d2.k.b.k(pbCommenFloorItemViewHolder, null, this.y);
        pbCommenFloorItemViewHolder.J.setVisibility(i == 0 ? 8 : 0);
        return view;
    }

    public final void s0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.f19219b.setOnLongClickListener(this.v);
        d.b.j0.d2.k.a aVar = this.m;
        if (aVar == null || aVar.getPageContext().getOrignalPage() == null) {
            return;
        }
        d.b.j0.d2.k.e.b1.a eventController = this.m.getEventController();
        if (eventController != null) {
            pbCommenFloorItemViewHolder.f19222e.setOnClickListener(eventController.f54444b);
            pbCommenFloorItemViewHolder.l.setOnClickListener(eventController.f54444b);
            pbCommenFloorItemViewHolder.F.setOnClickListener(eventController.f54444b);
            pbCommenFloorItemViewHolder.F.getHeadView().setOnClickListener(eventController.f54444b);
            pbCommenFloorItemViewHolder.m.setOnEmotionClickListener(eventController.f54447e);
        }
        pbCommenFloorItemViewHolder.m.setOnLongClickListener(this.v);
        pbCommenFloorItemViewHolder.m.setOnImageClickListener(this.t);
        pbCommenFloorItemViewHolder.m.setOnClickListener(this.s);
        pbCommenFloorItemViewHolder.a().setOnClickListener(this.s);
        pbCommenFloorItemViewHolder.K.setOnClickListener(this.s);
        pbCommenFloorItemViewHolder.L.setOnClickListener(this.s);
        if (this.w == null) {
            this.w = new d.b.j0.d2.k.e.b1.c(this.m.getPageContext());
        }
        if (this.y) {
            pbCommenFloorItemViewHolder.w.setOnClickListener(this.s);
            pbCommenFloorItemViewHolder.v.setOnClickListener(new d(pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.C.z = new e(pbCommenFloorItemViewHolder);
        }
        pbCommenFloorItemViewHolder.s.setOnClickListener(this.s);
        pbCommenFloorItemViewHolder.t.setOnClickListener(new f(pbCommenFloorItemViewHolder));
        pbCommenFloorItemViewHolder.k.z = new g(pbCommenFloorItemViewHolder);
        if (this.y) {
            pbCommenFloorItemViewHolder.I.setOnClickListener(this.s);
        }
    }

    public void t0(boolean z) {
        this.z = z;
    }

    public void u0(String str) {
        this.r = str;
    }

    public void v0(a2 a2Var) {
        this.o = a2Var;
    }
}
