package d.a.n0.e2.k.e;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.m0.r.q.a2;
import d.a.n0.e2.i.c;
import d.a.n0.z.m;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class m extends o<PostData, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public d.a.n0.e2.i.c A;
    public View.OnLongClickListener B;
    public d.a.n0.e2.k.g.b C;
    public boolean D;
    public int E;
    public boolean F;
    public boolean G;
    public d.a.c.e.k.b<ConstrainImageLayout> H;
    public d.a.c.e.k.b<TbImageView> I;
    public d.a.n0.e2.i.c J;
    public int s;
    public TbRichTextView.r t;
    public boolean u;
    public String v;
    public d.a.n0.e2.h.e w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public TbRichTextView.x z;

    /* loaded from: classes5.dex */
    public class a implements d.a.c.e.k.c<ConstrainImageLayout> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            constrainImageLayout.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            return new ConstrainImageLayout(m.this.f39228e);
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.c.e.k.c<TbImageView> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            return tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            tbImageView.setOnClickListener(null);
            tbImageView.setForegroundColor(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            TbImageView tbImageView = new TbImageView(m.this.f39228e);
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

    /* loaded from: classes5.dex */
    public class c implements c.a {
        public c() {
        }

        @Override // d.a.n0.e2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // d.a.n0.e2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            if (m.this.A != null) {
                if (!(view instanceof TbListTextView) || m.this.y == null) {
                    m.this.A.a(view);
                    m.this.A.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                m.this.y.onClick(view);
                return true;
            }
            return true;
        }

        @Override // d.a.n0.e2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            PbFragment pbFragment;
            if (view == null || !((pbFragment = m.this.n) == null || pbFragment.K4() == null || m.this.n.K4().n1())) {
                return true;
            }
            if (view instanceof RelativeLayout) {
                m.this.y0(view);
            } else {
                ViewParent parent = view.getParent();
                int i2 = 0;
                while (true) {
                    if (parent == null || i2 >= 10) {
                        break;
                    } else if (parent instanceof RelativeLayout) {
                        m.this.y0((RelativeLayout) parent);
                        break;
                    } else {
                        parent = parent.getParent();
                        i2++;
                    }
                }
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f53375e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PostData f53376f;

        public d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            this.f53375e = pbCommenFloorItemViewHolder;
            this.f53376f = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = this.f53375e.Q.getVisibility() == 8;
            m.this.w0(this.f53375e, !z, this.f53376f.B());
            this.f53376f.m0(!z);
            m.this.S0(this.f53375e, this.f53376f);
            PbFragment pbFragment = m.this.n;
            if (pbFragment == null || pbFragment.K4() == null || m.this.n.K4().T0() == null || m.this.n.K4().B0() == null || z || this.f53375e.a().getTop() >= m.this.n.K4().T0().getMeasuredHeight()) {
                return;
            }
            m.this.n.K4().B0().setSelectionFromTop(ListUtils.getPosition(m.this.n.K4().B0().getData(), this.f53376f) + m.this.n.K4().B0().getHeaderViewsCount(), m.this.n.K4().T0().getMeasuredHeight());
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f53378e;

        public e(m mVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            this.f53378e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f53378e.s.performClick();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f53379e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.e2.k.e.c1.c f53380f;

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostData f53382e;

            public a(PostData postData) {
                this.f53382e = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                fVar.f53380f.f53219b.a(m.this.w, null, this.f53382e, fVar.f53379e.m.getLayoutStrategy());
            }
        }

        public f(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, d.a.n0.e2.k.e.c1.c cVar) {
            this.f53379e = pbCommenFloorItemViewHolder;
            this.f53380f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostData postData;
            if (view.getTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) == null || this.f53379e.f18881b == null || this.f53380f == null) {
                    return;
                }
                d.a.c.e.m.e.a().postDelayed(new a(postData), 100L);
                String N = m.this.w.N();
                if ((StringUtils.isNull(N) || "0".equals(m.this.w.N())) && m.this.w.L() != null) {
                    N = m.this.w.L().M0();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", N).param("fid", m.this.w.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.E()).param("obj_source", m.this.P0(view)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f53384e;

        public g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            this.f53384e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            if (view == null || m.this.w == null || (pbCommenFloorItemViewHolder = this.f53384e) == null || (agreeView = pbCommenFloorItemViewHolder.k) == null || agreeView.getData() == null) {
                return;
            }
            int i2 = view == this.f53384e.k.getImgAgree() ? 1 : 2;
            String N = m.this.w.N();
            if ((StringUtils.isNull(N) || "0".equals(m.this.w.N())) && m.this.w.L() != null) {
                N = m.this.w.L().M0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", N).param("fid", m.this.w.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f53384e.k.getData().postId).param("obj_source", m.this.P0(this.f53384e.k)).param("obj_type", i2));
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f53386e;

        public h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            this.f53386e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            if (view == null || m.this.w == null || (pbCommenFloorItemViewHolder = this.f53386e) == null || (agreeView = pbCommenFloorItemViewHolder.Y) == null || agreeView.getData() == null) {
                return;
            }
            int i2 = view == this.f53386e.Y.getImgAgree() ? 1 : 2;
            String N = m.this.w.N();
            if ((StringUtils.isNull(N) || "0".equals(m.this.w.N())) && m.this.w.L() != null) {
                N = m.this.w.L().M0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", N).param("fid", m.this.w.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f53386e.Y.getData().postId).param("obj_source", m.this.P0(this.f53386e.Y)).param("obj_type", i2));
        }
    }

    public m(d.a.n0.e2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
        this.s = 0;
        this.t = null;
        this.u = true;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = true;
        this.F = true;
        this.G = false;
        this.H = new d.a.c.e.k.b<>(new a(), 6, 0);
        this.I = new d.a.c.e.k.b<>(new b(), 12, 0);
        this.J = new d.a.n0.e2.i.c(new c());
        if (iVar != null && iVar.z() != null) {
            this.E = iVar.z().x0();
        }
        this.s = e0(R.dimen.tbds14);
    }

    public final void A0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (!TextUtils.isEmpty(postData.u()) && this.u) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.m.getLayoutParams();
            layoutParams.topMargin = e0(R.dimen.ds20);
            layoutParams.bottomMargin = e0(R.dimen.ds20);
            pbCommenFloorItemViewHolder.m.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.m.e0(postData.u());
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.m.getLayoutParams();
            layoutParams2.bottomMargin = 0;
            layoutParams2.topMargin = 0;
            pbCommenFloorItemViewHolder.m.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.m.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.m.e0(null);
        }
        pbCommenFloorItemViewHolder.m.setTextViewOnTouchListener(this.J);
        pbCommenFloorItemViewHolder.m.setTextViewCheckSelection(false);
    }

    public final void B0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        if (pbCommenFloorItemViewHolder == null || postData == null || (imageView = pbCommenFloorItemViewHolder.I) == null || this.w == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public final void C0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        int i2;
        int i3;
        d.a.n0.e2.h.e eVar;
        d.a.n0.e2.h.e eVar2;
        if (pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        boolean z2 = true;
        if (postData.A() > 0 && (eVar2 = this.w) != null && !eVar2.a0()) {
            String format = String.format(this.f39228e.getString(R.string.is_floor), Integer.valueOf(postData.A()));
            pbCommenFloorItemViewHolder.D.setVisibility(0);
            pbCommenFloorItemViewHolder.D.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.D.setVisibility(8);
            z = false;
        }
        d.a.m0.t.g I = postData.I();
        z2 = (I == null || StringUtils.isNull(I.b()) || (eVar = this.w) == null || eVar.a0()) ? false : false;
        if (z) {
            pbCommenFloorItemViewHolder.f18887h.setVisibility(0);
            i2 = this.s;
        } else {
            pbCommenFloorItemViewHolder.f18887h.setVisibility(8);
            i2 = 0;
        }
        if (z2) {
            pbCommenFloorItemViewHolder.f18888i.setVisibility(0);
            i3 = this.s;
        } else {
            pbCommenFloorItemViewHolder.f18888i.setVisibility(8);
            i3 = 0;
        }
        pbCommenFloorItemViewHolder.f18886g.setPadding(i2, 0, i3, 0);
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.R()), "yyyy"))) {
            pbCommenFloorItemViewHolder.f18886g.setText(StringHelper.getFormatTimeShort(postData.R()));
        } else {
            pbCommenFloorItemViewHolder.f18886g.setText(StringHelper.getFormatTime(postData.R()));
        }
        if (z2) {
            pbCommenFloorItemViewHolder.j.setVisibility(0);
            pbCommenFloorItemViewHolder.j.setPadding(this.s, 0, 0, 0);
            if (postData.b0) {
                pbCommenFloorItemViewHolder.j.setText(StringHelper.cutStringWithSuffix(I.b(), 7, StringHelper.STRING_MORE));
            } else {
                pbCommenFloorItemViewHolder.j.setText(I.b());
            }
        } else {
            pbCommenFloorItemViewHolder.j.setVisibility(8);
        }
        TextView textView = pbCommenFloorItemViewHolder.b0;
        textView.setText(((Object) pbCommenFloorItemViewHolder.f18886g.getText()) + "  • ");
    }

    public final void D0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.T.setVisibility(postData.b0 ? 0 : 8);
    }

    public final void E0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        if (pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.u.setVisibility(8);
        pbCommenFloorItemViewHolder.X.setVisibility(0);
        pbCommenFloorItemViewHolder.o.setVisibility(0);
        pbCommenFloorItemViewHolder.a0.setVisibility(8);
        pbCommenFloorItemViewHolder.s.setVisibility(8);
        pbCommenFloorItemViewHolder.t.setVisibility(8);
        pbCommenFloorItemViewHolder.k.setVisibility(8);
        pbCommenFloorItemViewHolder.d0.setVisibility(8);
        N0(pbCommenFloorItemViewHolder, postData, view, i2);
        B0(pbCommenFloorItemViewHolder, postData);
        F0(pbCommenFloorItemViewHolder, postData);
        I0(pbCommenFloorItemViewHolder, postData, view);
        H0(pbCommenFloorItemViewHolder, postData, view, i2);
        C0(pbCommenFloorItemViewHolder, postData);
        K0(pbCommenFloorItemViewHolder, postData);
        G0(pbCommenFloorItemViewHolder, postData);
        L0(pbCommenFloorItemViewHolder, postData);
        A0(pbCommenFloorItemViewHolder, postData);
        D0(pbCommenFloorItemViewHolder, postData);
        J0(pbCommenFloorItemViewHolder, postData);
        M0(pbCommenFloorItemViewHolder, postData);
    }

    public final void F0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder == null || postData == null || postData.r() == null) {
            return;
        }
        postData.r().threadId = this.m.z().O0();
        postData.r().objType = 1;
        postData.r().isInPost = true;
        a2 a2Var = null;
        d.a.n0.e2.h.e eVar = this.w;
        if (eVar != null && eVar.L() != null) {
            a2Var = this.w.L();
        }
        if (a2Var != null && a2Var.B2()) {
            pbCommenFloorItemViewHolder.k.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.k.setThreadData(a2Var);
        pbCommenFloorItemViewHolder.k.setData(postData.r());
        pbCommenFloorItemViewHolder.Y.setThreadData(a2Var);
        pbCommenFloorItemViewHolder.Y.setData(postData.r());
    }

    public final void G0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        if (pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.O == null || pbCommenFloorItemViewHolder.L == null) {
            return;
        }
        if (postData != null && (alaLiveInfoCoreData = postData.T) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
            pbCommenFloorItemViewHolder.O.setText(postData.T.liveTitle);
            pbCommenFloorItemViewHolder.L.setTag(postData.T);
            pbCommenFloorItemViewHolder.L.setVisibility(0);
            StatisticItem statisticItem = new StatisticItem("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(statisticItem);
            return;
        }
        pbCommenFloorItemViewHolder.L.setVisibility(8);
    }

    public final void H0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        if (pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.N() > 0) {
            pbCommenFloorItemViewHolder.r.setVisibility(8);
        } else {
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, postData);
            if (postData.C() == 2) {
                pbCommenFloorItemViewHolder.r.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.r.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.q.setVisibility(8);
        }
        ImageView imageView = pbCommenFloorItemViewHolder.s;
        if (imageView != null) {
            SparseArray sparseArray2 = (SparseArray) imageView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbCommenFloorItemViewHolder.s.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_load_sub_data, postData);
        }
        ImageView imageView2 = pbCommenFloorItemViewHolder.t;
        if (imageView2 != null) {
            SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.t.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        pbCommenFloorItemViewHolder.q.setVisibility(8);
        if (postData.W()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
            layoutParams.topMargin = d.a.c.e.p.l.g(this.f39228e, R.dimen.tbds10);
            layoutParams.leftMargin = d.a.c.e.p.l.g(this.f39228e, R.dimen.tbds148);
            layoutParams.rightMargin = d.a.c.e.p.l.g(this.f39228e, R.dimen.M_W_X007);
            layoutParams.bottomMargin = d.a.c.e.p.l.g(this.f39228e, R.dimen.tbds20);
            pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams);
            if (this.C == null) {
                d.a.n0.e2.k.g.b bVar = new d.a.n0.e2.k.g.b(this.f39228e);
                this.C = bVar;
                bVar.f(this.q);
                this.C.h(this.x);
                this.C.e(this.y);
                String str = null;
                d.a.n0.e2.h.e eVar = this.w;
                if (eVar != null && eVar.L() != null && this.w.L().T() != null) {
                    str = this.w.L().T().getUserId();
                }
                boolean z = true;
                z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                d.a.n0.e2.h.e eVar2 = this.w;
                if (eVar2 != null) {
                    this.C.j(eVar2.S(), z);
                    this.C.i(this.w.L());
                }
            }
            this.C.g(postData.E());
            pbCommenFloorItemViewHolder.p.setSubPbAdapter(this.C);
            pbCommenFloorItemViewHolder.p.setVisibility(0);
            pbCommenFloorItemViewHolder.p.setData(postData, view);
            pbCommenFloorItemViewHolder.p.setChildOnClickListener(this.y);
            pbCommenFloorItemViewHolder.p.setChildOnLongClickListener(this.B);
            pbCommenFloorItemViewHolder.p.setChildOnTouchListener(this.J);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
            layoutParams2.topMargin = 0;
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            layoutParams2.bottomMargin = 0;
            pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.p.setVisibility(8);
        }
        if (postData.P) {
            pbCommenFloorItemViewHolder.J.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.J.setVisibility(4);
        }
        pbCommenFloorItemViewHolder.r.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.o.getLayoutParams();
        layoutParams3.topMargin = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
        layoutParams3.bottomMargin = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
        if (pbCommenFloorItemViewHolder.q.getVisibility() == 8) {
            pbCommenFloorItemViewHolder.o.setVisibility(8);
        } else {
            pbCommenFloorItemViewHolder.o.setVisibility(0);
        }
        pbCommenFloorItemViewHolder.c0.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
    }

    public final void I0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view) {
        if (pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.m.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = d.a.c.e.p.l.g(this.f39228e, R.dimen.M_W_X007);
        layoutParams.leftMargin = d.a.c.e.p.l.g(this.f39228e, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        pbCommenFloorItemViewHolder.m.setPadding(0, 0, 0, 0);
        if (!this.u) {
            pbCommenFloorItemViewHolder.m.getLayoutStrategy().g(R.drawable.icon_click);
        } else {
            pbCommenFloorItemViewHolder.m.e0(null);
            pbCommenFloorItemViewHolder.m.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.m.getLayoutStrategy().g(R.drawable.transparent_bg);
        }
        pbCommenFloorItemViewHolder.m.getLayoutStrategy().x(R.drawable.pic_video);
        v0(pbCommenFloorItemViewHolder.m, view, !StringUtils.isNull(postData.u()));
        pbCommenFloorItemViewHolder.m.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.m.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.m.setIsFromCDN(this.q);
        pbCommenFloorItemViewHolder.m.setText(postData.K(), true, this.t);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.m.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
        pbCommenFloorItemViewHolder.m.setTag(sparseArray);
        pbCommenFloorItemViewHolder.f18881b.setTag(R.id.tag_from, sparseArray);
        pbCommenFloorItemViewHolder.d0.setTag(sparseArray);
        pbCommenFloorItemViewHolder.Z.setTag(sparseArray);
    }

    public final void J0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.f18881b == null) {
            return;
        }
        d.a.n0.e2.o.i iVar = this.m;
        if (iVar != null && iVar.z() != null && this.m.z().d1() && StringHelper.equals(this.m.z().b0(), postData.E())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f18881b, R.color.CAM_X0313);
        } else {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f18881b, R.color.CAM_X0205);
        }
    }

    public final void K0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (postData != null && postData.O() != null) {
            TbRichText K = postData.K();
            d.a.n0.e2.p.f.c(postData.O(), pbCommenFloorItemViewHolder.K, false, false, K != null && StringUtils.isNull(K.toString()) && StringUtils.isNull(postData.u()));
            return;
        }
        pbCommenFloorItemViewHolder.K.setVisibility(8);
    }

    public final void L0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (postData.C() != 2 && postData.C() != 4) {
            pbCommenFloorItemViewHolder.R.setVisibility(8);
            pbCommenFloorItemViewHolder.Q.setVisibility(0);
            x0(false, pbCommenFloorItemViewHolder, postData);
        } else {
            pbCommenFloorItemViewHolder.R.setOnClickListener(new d(pbCommenFloorItemViewHolder, postData));
            pbCommenFloorItemViewHolder.R.setVisibility(0);
            w0(pbCommenFloorItemViewHolder, postData.Y(), postData.B());
            x0(true, pbCommenFloorItemViewHolder, postData);
        }
        S0(pbCommenFloorItemViewHolder, postData);
    }

    public final void M0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.g(postData.S, postData.E(), this.G);
    }

    /* JADX WARN: Removed duplicated region for block: B:239:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0680  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0683  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x06d0  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0732  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x073b  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x077a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void N0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.t() != null) {
            postData.t().isBaijiahaoUser();
        }
        if (postData.R) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f18883d, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.f18883d.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.f18883d.setVisibility(8);
        }
        a2 a2Var = null;
        pbCommenFloorItemViewHolder.l.setTag(null);
        pbCommenFloorItemViewHolder.l.setUserId(null);
        pbCommenFloorItemViewHolder.f18884e.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.F.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.m.setIsHost(false);
        if (postData.t() != null) {
            String str = this.v;
            if (str != null && !str.equals("0") && this.v.equals(postData.t().getUserId())) {
                pbCommenFloorItemViewHolder.m.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.t().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.t().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.H;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, postData.t().getUserId());
                d.a.n0.e2.o.i iVar = this.m;
                if (iVar != null && iVar.A() != null) {
                    pbCommenFloorItemViewHolder.H.setOnClickListener(this.m.A().mEvent.f53196c);
                }
                int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                pbCommenFloorItemViewHolder.H.g(iconInfo, 2, g2, g2, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            if (pbCommenFloorItemViewHolder.G != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.G.setTag(tShowInfoNew.get(0).getUrl());
                }
                d.a.n0.e2.o.i iVar2 = this.m;
                if (iVar2 != null && iVar2.A() != null) {
                    pbCommenFloorItemViewHolder.G.setOnClickListener(this.m.A().mEvent.f53197d);
                }
                int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.G.h(tShowInfoNew, 3, g3, g3, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.t().isBigV()) {
                if (d.a.m0.b.d.x()) {
                    if (DeviceInfoUtil.isMate30()) {
                        r0.j(pbCommenFloorItemViewHolder.f18884e);
                    } else {
                        d.a.m0.r.u.c.d(pbCommenFloorItemViewHolder.f18884e).x(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f18884e, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f18884e, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f18884e, R.color.CAM_X0301, 1);
            }
            String avater = postData.t().getAvater();
            int i3 = postData.c0 ? 2 : 8;
            pbCommenFloorItemViewHolder.f18884e.setTag(R.id.tag_user_id, postData.t().getUserId());
            pbCommenFloorItemViewHolder.f18884e.setTag(R.id.tag_user_name, postData.t().getUserName());
            pbCommenFloorItemViewHolder.f18884e.setTag(R.id.tag_virtual_user_url, postData.t().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.f18884e.setTag(R.id.tag_statistic_item, d.a.n0.e2.m.a.g(this.w, postData, postData.d0, i3, 2));
            String name_show = postData.t().getName_show();
            String userName = postData.t().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.f18884e.setText(d.a.n0.e2.c.b(this.f39228e, pbCommenFloorItemViewHolder.f18884e.getText().toString()));
                pbCommenFloorItemViewHolder.f18884e.setGravity(16);
                pbCommenFloorItemViewHolder.f18884e.setTag(R.id.tag_nick_name_activity, d.a.n0.e2.c.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f18884e, R.color.CAM_X0312, 1);
            }
            if (postData.t().getPendantData() != null && !StringUtils.isNull(postData.t().getPendantData().a())) {
                pbCommenFloorItemViewHolder.F.setBigVDimenSize(R.dimen.tbds32);
                pbCommenFloorItemViewHolder.F.i(postData.t(), 4);
                pbCommenFloorItemViewHolder.l.setVisibility(8);
                pbCommenFloorItemViewHolder.F.setVisibility(0);
                pbCommenFloorItemViewHolder.F.getHeadView().V(avater, 28, false);
                pbCommenFloorItemViewHolder.F.getHeadView().setUserId(postData.t().getUserId());
                pbCommenFloorItemViewHolder.F.getHeadView().setUserName(postData.t().getUserName());
                d.a.n0.e2.h.e eVar = this.w;
                pbCommenFloorItemViewHolder.F.getHeadView().setFid(eVar != null ? eVar.m() : "");
                d.a.n0.e2.h.e eVar2 = this.w;
                pbCommenFloorItemViewHolder.F.getHeadView().setFName(eVar2 != null ? eVar2.n() : "");
                pbCommenFloorItemViewHolder.F.getHeadView().setFloor(postData.A());
                pbCommenFloorItemViewHolder.F.getHeadView().setTid(postData.E());
                pbCommenFloorItemViewHolder.F.getHeadView().setTag(R.id.tag_statistic_item, d.a.n0.e2.m.a.g(this.w, postData, postData.d0, i3, 2));
                pbCommenFloorItemViewHolder.F.l(postData.t().getPendantData().a());
            } else {
                pbCommenFloorItemViewHolder.l.setGodIconWidth(R.dimen.tbds32);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.l, postData.t(), 4);
                pbCommenFloorItemViewHolder.l.setUserId(postData.t().getUserId());
                d.a.n0.e2.h.e eVar3 = this.w;
                pbCommenFloorItemViewHolder.l.setFid(eVar3 != null ? eVar3.m() : "");
                d.a.n0.e2.h.e eVar4 = this.w;
                pbCommenFloorItemViewHolder.l.setFName(eVar4 != null ? eVar4.n() : "");
                pbCommenFloorItemViewHolder.l.setFloor(postData.A());
                pbCommenFloorItemViewHolder.l.setTid(postData.E());
                pbCommenFloorItemViewHolder.l.setUserName(postData.t().getUserName(), postData.T());
                pbCommenFloorItemViewHolder.l.setTag(R.id.tag_virtual_user_url, postData.t().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.l.setTag(R.id.tag_statistic_item, d.a.n0.e2.m.a.g(this.w, postData, postData.d0, i3, 2));
                pbCommenFloorItemViewHolder.l.setImageDrawable(null);
                pbCommenFloorItemViewHolder.l.V(avater, 28, false);
                pbCommenFloorItemViewHolder.l.setVisibility(0);
                pbCommenFloorItemViewHolder.F.setVisibility(8);
            }
            if (postData.t() != null && postData.t().getAlaInfo() != null && postData.t().getAlaUserData() != null && postData.t().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.e(true);
                pbCommenFloorItemViewHolder.l.setLiveStatus(1);
                pbCommenFloorItemViewHolder.l.setAlaInfo(postData.t().getAlaInfo());
                pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(postData.t().getAlaInfo());
            } else {
                pbCommenFloorItemViewHolder.e(false);
                pbCommenFloorItemViewHolder.l.setLiveStatus(0);
                pbCommenFloorItemViewHolder.l.setAlaInfo(null);
                pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(null);
            }
            b1(pbCommenFloorItemViewHolder.f18885f, postData);
        }
        d.a.n0.e2.o.i iVar3 = this.m;
        int level_id = (iVar3 == null || iVar3.A() == null || !this.m.A().isSimpleForum() || postData.t() == null) ? 0 : postData.t().getLevel_id();
        d.a.n0.e2.h.e eVar5 = this.w;
        if (eVar5 != null && eVar5.a0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.E.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.E, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.E.setVisibility(8);
        }
        int i4 = 15;
        if (pbCommenFloorItemViewHolder.H.getChildCount() == 1) {
            i4 = 13;
        } else if (pbCommenFloorItemViewHolder.H.getChildCount() > 1) {
            i4 = 11;
        }
        if (pbCommenFloorItemViewHolder.f18885f.getVisibility() == 0) {
            i4 -= 2;
        }
        if (pbCommenFloorItemViewHolder.G.getChildCount() > 0) {
            i4 -= 2;
        }
        if (postData.w() > 1000) {
            i4 -= 2;
        }
        if (postData.w() > 10) {
            i4 -= 2;
        }
        if (i4 < 10) {
            pbCommenFloorItemViewHolder.H.setVisibility(8);
            if (pbCommenFloorItemViewHolder.H.getChildCount() == 1) {
                i4 += 2;
            } else if (pbCommenFloorItemViewHolder.H.getChildCount() > 1) {
                i4 += 4;
            }
            if (i4 < 10 && pbCommenFloorItemViewHolder.f18885f.getVisibility() == 0) {
                i4 += 2;
                pbCommenFloorItemViewHolder.f18885f.setVisibility(8);
            }
            if (i4 < 10 && pbCommenFloorItemViewHolder.E.getVisibility() == 0) {
                i4 += 2;
                pbCommenFloorItemViewHolder.E.setVisibility(8);
            }
        }
        String name_show2 = postData.t() != null ? postData.t().getName_show() : "";
        int d2 = d.a.m0.z0.i0.d(name_show2);
        if (postData.t() != null && !StringUtils.isNull(postData.t().getSealPrefix())) {
            int i5 = i4 - 2;
            if (d2 > i5) {
                name_show2 = d.a.m0.z0.i0.m(name_show2, i5) + StringHelper.STRING_MORE;
            }
        } else if (d2 > i4) {
            name_show2 = d.a.m0.z0.i0.m(name_show2, i4) + StringHelper.STRING_MORE;
        }
        if (postData.t() != null && !StringUtils.isNull(postData.t().getSealPrefix())) {
            pbCommenFloorItemViewHolder.f18884e.setText(O0(postData.t().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.f18884e.setText(name_show2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_load_sub_data, postData);
        sparseArray.put(R.id.tag_load_sub_view, view);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.A()));
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
        sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.k);
        sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.Y);
        sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.s);
        sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.t);
        d.a.n0.e2.h.e eVar6 = this.w;
        if (eVar6 != null && eVar6.L() != null) {
            a2Var = this.w.L();
        }
        if (a2Var != null && a2Var.B2()) {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z6 = (postData.t() == null || StringUtils.isNull(postData.t().getVirtualUserUrl())) ? false : true;
        d.a.n0.e2.h.e eVar7 = this.w;
        if (eVar7 == null || eVar7.S() == 0) {
            z = false;
            z2 = false;
        } else {
            z = (this.w.S() == 1002 || this.w.S() == 3) ? false : true;
            z2 = (this.w.S() == 3 || this.w.a0()) ? false : true;
            if (postData != null && postData.t() != null) {
                String userId = postData.t().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        d.a.n0.e2.h.e eVar8 = this.w;
        if (eVar8 != null && eVar8.L() != null && this.w.L().T() != null && postData.t() != null) {
            String userId2 = this.w.L().T().getUserId();
            String userId3 = postData.t().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z4 = false;
                    z5 = true;
                } else {
                    z4 = true;
                    z5 = false;
                }
                z3 = true;
                if (postData != null && postData.t() != null && UtilHelper.isCurrentAccount(postData.t().getUserId())) {
                    z5 = true;
                    z3 = true;
                }
                if (z6) {
                    z = false;
                    z4 = false;
                    z3 = false;
                }
                int i6 = postData.A() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.w.S()));
                    if (postData.t() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.t() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.t().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.t().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.t().getName_show());
                    }
                    if (this.w.L() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.w.L().o0());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, postData.E());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(postData.W()));
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.w.S()));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                    sparseArray.put(R.id.tag_del_post_id, postData.E());
                } else {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                pbCommenFloorItemViewHolder.m.setTag(sparseArray);
            }
        }
        z3 = z2;
        z4 = false;
        z5 = false;
        if (postData != null) {
            z5 = true;
            z3 = true;
        }
        if (z6) {
        }
        if (postData.A() != 1) {
        }
        if (!z) {
        }
        if (!z4) {
        }
        if (!z3) {
        }
        pbCommenFloorItemViewHolder.m.setTag(sparseArray);
    }

    public final SpannableStringBuilder O0(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 == null || str == null) {
            return spannableStringBuilder;
        }
        arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
        return d.a.n0.z.m.h(this.m.A(), str2, arrayList, true);
    }

    public final String P0(View view) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return "1";
        }
        Object obj = sparseArray.get(R.id.pb_track_more_obj_source);
        String str = obj != null ? obj : "1";
        sparseArray.remove(R.id.pb_track_more_obj_source);
        view.setTag(sparseArray);
        return str.toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: Q0 */
    public PbCommenFloorItemViewHolder P(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f39228e).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
        ((ViewGroup) inflate.findViewById(R.id.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null));
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.m.A().getPageContext(), inflate, this.E);
        pbCommenFloorItemViewHolder.n.setConstrainLayoutPool(this.H);
        pbCommenFloorItemViewHolder.n.setImageViewPool(this.I);
        SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.p;
        if (subPbLayout != null) {
            subPbLayout.setShowChildComment(this.F);
        }
        Z0(pbCommenFloorItemViewHolder);
        TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.m;
        if (tbRichTextView != null) {
            tbRichTextView.setDuiEnabled(this.D);
        }
        return pbCommenFloorItemViewHolder;
    }

    public View R0(int i2, View view, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        super.W(i2, view, viewGroup, postData, pbCommenFloorItemViewHolder);
        Z0(pbCommenFloorItemViewHolder);
        V0(pbCommenFloorItemViewHolder);
        s0(pbCommenFloorItemViewHolder);
        PostData postData2 = (PostData) y(i2);
        if (postData2 != null) {
            postData2.d0 = i2 + 1;
            u0(postData2);
            t0(postData2);
            postData2.B0();
            z0(postData2);
            E0(pbCommenFloorItemViewHolder, postData2, view, i2);
        }
        return view;
    }

    public final void S0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        TbRichText K = postData.K();
        K.isChanged = true;
        pbCommenFloorItemViewHolder.m.setText(K, true, this.t);
    }

    public final void T0(PostData postData) {
        String userId = postData.t().getUserId();
        d.a.n0.e2.h.e eVar = this.w;
        String m = eVar != null ? eVar.m() : "";
        d.a.n0.e2.h.e eVar2 = this.w;
        String n = eVar2 != null ? eVar2.n() : "";
        int A = postData.A();
        String E = postData.E();
        StatisticItem statisticItem = new StatisticItem("c13714");
        statisticItem.param("fid", m);
        statisticItem.param("fname", n);
        statisticItem.param("obj_param1", userId);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("tid", E);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, A);
        if (postData.t().getAlaInfo() != null) {
            AlaInfoData alaInfo = postData.t().getAlaInfo();
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
            if (alaInfo.mYyExtData != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
            }
        }
        TiebaStatic.log(statisticItem);
    }

    public void U0(boolean z) {
        this.D = z;
    }

    public final void V0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.f18881b.setOnTouchListener(this.J);
        pbCommenFloorItemViewHolder.f18881b.setOnLongClickListener(this.B);
        if (this.m.A() == null || this.m.A().getPageContext() == null || this.m.A().getPageContext().getOrignalPage() == null) {
            return;
        }
        d.a.n0.e2.k.e.c1.a aVar = this.m.A().mEvent;
        pbCommenFloorItemViewHolder.f18884e.setOnClickListener(aVar.f53195b);
        pbCommenFloorItemViewHolder.l.setOnClickListener(aVar.f53195b);
        pbCommenFloorItemViewHolder.F.setOnClickListener(aVar.f53195b);
        pbCommenFloorItemViewHolder.F.getHeadView().setOnClickListener(aVar.f53195b);
        pbCommenFloorItemViewHolder.m.setOnLongClickListener(this.B);
        pbCommenFloorItemViewHolder.m.setOnTouchListener(this.J);
        pbCommenFloorItemViewHolder.m.setCommonTextViewOnClickListener(this.y);
        pbCommenFloorItemViewHolder.m.setOnImageClickListener(this.z);
        pbCommenFloorItemViewHolder.m.setOnImageTouchListener(this.J);
        pbCommenFloorItemViewHolder.m.setOnEmotionClickListener(aVar.f53198e);
        pbCommenFloorItemViewHolder.m.setOnVoiceAfterClickListener(this.y);
        pbCommenFloorItemViewHolder.K.setOnClickListener(this.y);
        pbCommenFloorItemViewHolder.L.setOnClickListener(this.y);
        pbCommenFloorItemViewHolder.q.setOnClickListener(this.y);
        pbCommenFloorItemViewHolder.r.setOnClickListener(this.y);
        pbCommenFloorItemViewHolder.Z.setOnClickListener(this.y);
        pbCommenFloorItemViewHolder.d0.setOnClickListener(this.y);
        pbCommenFloorItemViewHolder.a0.setOnClickListener(new e(this, pbCommenFloorItemViewHolder));
        d.a.n0.e2.k.e.c1.c cVar = this.m.A().mPostShareController;
        pbCommenFloorItemViewHolder.s.setOnClickListener(this.y);
        pbCommenFloorItemViewHolder.t.setOnClickListener(new f(pbCommenFloorItemViewHolder, cVar));
        pbCommenFloorItemViewHolder.k.z = new g(pbCommenFloorItemViewHolder);
        pbCommenFloorItemViewHolder.Y.z = new h(pbCommenFloorItemViewHolder);
    }

    @Override // d.a.n0.e2.k.e.o, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        R0(i2, view, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view;
    }

    public void W0(boolean z) {
        this.G = z;
    }

    public void X0(d.a.n0.e2.i.c cVar) {
        this.A = cVar;
    }

    public void Y0(TbRichTextView.r rVar) {
        this.t = rVar;
    }

    public final void Z0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        if (pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.f18880a != skinType) {
            a1(pbCommenFloorItemViewHolder.f18885f);
            if (d.a.m0.b.d.x()) {
                if (DeviceInfoUtil.isMate30()) {
                    r0.j(pbCommenFloorItemViewHolder.f18884e);
                } else {
                    d.a.m0.r.u.c.d(pbCommenFloorItemViewHolder.f18884e).x(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f18884e, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f18884e, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f18886g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f18887h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f18888i, R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.D, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.r, R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.m.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.b0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.c0, R.color.CAM_X0107, 1);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.p;
            int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            int i2 = R.color.CAM_X0206;
            SkinManager.setBackgroundShapeDrawable(subPbLayout, g2, i2, i2);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.q, R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.q, R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.q.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.s, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.t, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.p.d();
            pbCommenFloorItemViewHolder.n.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.O, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.M, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.L, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.N, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.P, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.S, R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.Q.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.S.setText(R.string.close_content);
            } else {
                d.a.n0.e2.h.e eVar = this.w;
                if (eVar != null && StringUtils.isNull(eVar.k())) {
                    pbCommenFloorItemViewHolder.S.setText(this.w.k());
                } else {
                    pbCommenFloorItemViewHolder.S.setText(R.string.expand_content);
                }
            }
            pbCommenFloorItemViewHolder.k.t(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.d(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.Z, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.d0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.c();
        }
        pbCommenFloorItemViewHolder.f18880a = skinType;
    }

    public final void a1(TextView textView) {
        if (textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (tag instanceof PostData) {
            b1(textView, (PostData) tag);
        }
    }

    public final void b1(TextView textView, PostData postData) {
        if (textView == null && postData == null) {
            return;
        }
        textView.setTag(postData);
        d.a.n0.e2.h.e eVar = this.w;
        if (eVar != null && eVar.a0()) {
            textView.setVisibility(8);
            textView.setTag(null);
        } else if (postData.t() != null) {
            MetaData t = postData.t();
            String str = this.v;
            if (str != null && !str.equals("0") && this.v.equals(t.getUserId())) {
                textView.setVisibility(0);
                textView.setAlpha(1.0f);
                textView.setText(R.string.host_name);
                textView.setBackgroundColor(0);
                d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(textView);
                d2.m(R.string.J_X04);
                d2.k(R.dimen.L_X01);
                d2.s(R.color.CAM_X0302);
                d2.j(R.color.CAM_X0302);
            } else if (t.getIs_bawu() == 1 && postData.X()) {
                d.a.m0.r.u.c d3 = d.a.m0.r.u.c.d(textView);
                d3.s(R.color.CAM_X0101);
                d3.m(R.string.J_X04);
                d3.f(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.brand_official);
            } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                d.a.m0.r.u.c d4 = d.a.m0.r.u.c.d(textView);
                d4.s(R.color.CAM_X0101);
                d4.m(R.string.J_X04);
                d4.f(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_member_bazhu_tip);
            } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                d.a.m0.r.u.c d5 = d.a.m0.r.u.c.d(textView);
                d5.s(R.color.CAM_X0101);
                d5.m(R.string.J_X04);
                d5.f(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_member_xbazhu_tip);
            } else if (t.getIs_bawu() == 1 && "pri_content_assist".equals(t.getBawu_type())) {
                d.a.m0.r.u.c d6 = d.a.m0.r.u.c.d(textView);
                d6.s(R.color.CAM_X0101);
                d6.m(R.string.J_X04);
                d6.f(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_content_assist_tip);
            } else if (t.getIs_bawu() == 1 && "pri_manage_assist".equals(t.getBawu_type())) {
                d.a.m0.r.u.c d7 = d.a.m0.r.u.c.d(textView);
                d7.s(R.color.CAM_X0101);
                d7.m(R.string.J_X04);
                d7.f(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_manage_assist_tip);
            } else {
                textView.setVisibility(8);
            }
        } else {
            textView.setVisibility(8);
        }
    }

    public void c(boolean z) {
        this.u = z;
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        this.B = onLongClickListener;
    }

    public void e(View.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void o(TbRichTextView.x xVar) {
        this.z = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void p(String str) {
        this.v = str;
    }

    public void s(d.a.n0.e2.h.e eVar) {
        this.w = eVar;
    }

    public final void s0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.m.setTextViewOnTouchListener(this.A);
        pbCommenFloorItemViewHolder.m.setTextViewCheckSelection(false);
    }

    public final void t0(PostData postData) {
        d.a.n0.e2.h.e eVar = this.w;
        if (eVar != null) {
            if (eVar.f0()) {
                VideoPbFragment videoPbFragment = this.o;
                if (videoPbFragment != null) {
                    d.a.n0.e2.m.a.d(videoPbFragment.getUniqueId(), this.w, postData, postData.d0, postData.c0 ? 2 : 8);
                    return;
                }
                return;
            }
            PbFragment pbFragment = this.n;
            if (pbFragment != null) {
                d.a.n0.e2.m.a.d(pbFragment.getUniqueId(), this.w, postData, postData.d0, postData.c0 ? 2 : 8);
            }
        }
    }

    public final void u0(PostData postData) {
        if (postData.E == 0 && postData.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", postData.E());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            d.a.n0.e2.o.i iVar = this.m;
            if (iVar != null) {
                int x0 = iVar.z().x0();
                if (1 == x0 || 2 == x0) {
                    statisticItem.param("obj_source", "1");
                } else if (3 == x0) {
                    statisticItem.param("obj_source", "2");
                } else {
                    statisticItem.param("obj_source", "0");
                }
            }
            TiebaStatic.log(statisticItem);
            if (postData.t() == null || postData.t().getAlaInfo() == null || postData.t().getAlaInfo().live_status != 1) {
                return;
            }
            T0(postData);
        }
    }

    public final void v0(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView == null || view == null) {
            return;
        }
        int k = (((d.a.c.e.p.l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k = (k - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int e0 = z ? e0(R.dimen.tbds115) : 0;
        tbRichTextView.getLayoutStrategy().q(k - e0);
        tbRichTextView.getLayoutStrategy().D = (k - e0) - e0(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k * 1.618f));
    }

    public final void w0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        if (z) {
            pbCommenFloorItemViewHolder.Q.setVisibility(8);
            if (StringUtils.isNull(str)) {
                pbCommenFloorItemViewHolder.S.setText(R.string.expand_content);
                return;
            } else {
                pbCommenFloorItemViewHolder.S.setText(str);
                return;
            }
        }
        pbCommenFloorItemViewHolder.Q.setVisibility(0);
        pbCommenFloorItemViewHolder.S.setText(R.string.close_content);
    }

    public final void x0(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view;
        if (pbCommenFloorItemViewHolder == null || (view = pbCommenFloorItemViewHolder.J) == null || pbCommenFloorItemViewHolder.R == null || !(view.getLayoutParams() instanceof RelativeLayout.LayoutParams) || !(pbCommenFloorItemViewHolder.R.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        boolean z2 = !ListUtils.isEmpty(postData.M());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.J.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.R.getLayoutParams();
        if (z) {
            pbCommenFloorItemViewHolder.m.getLayoutStrategy().m(0);
            if (z2) {
                pbCommenFloorItemViewHolder.m.getLayoutStrategy().l(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                }
            } else {
                pbCommenFloorItemViewHolder.m.getLayoutStrategy().l(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.R.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = d.a.c.e.p.l.g(this.f39228e, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        pbCommenFloorItemViewHolder.m.getLayoutStrategy().l(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        pbCommenFloorItemViewHolder.m.getLayoutStrategy().m(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = d.a.c.e.p.l.g(this.f39228e, R.dimen.tbds14);
            pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
        }
    }

    public final void y0(View view) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        if (view == null || !(view.getTag() instanceof PbCommenFloorItemViewHolder) || (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view.getTag()).Y) == null || agreeView.getData() == null) {
            return;
        }
        pbCommenFloorItemViewHolder.Y.s();
    }

    public final void z0(PostData postData) {
        if (postData != null) {
            StatisticItem g2 = d.a.n0.e2.m.a.g(this.w, postData, postData.d0, postData.c0 ? 2 : 8, 6);
            postData.e0 = g2;
            if (ListUtils.isEmpty(postData.M())) {
                return;
            }
            Iterator<PostData> it = postData.M().iterator();
            while (it.hasNext()) {
                it.next().e0 = g2;
            }
        }
    }
}
