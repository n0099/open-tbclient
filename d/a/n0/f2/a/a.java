package d.a.n0.f2.a;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pbextra.adapter.PbInterviewLiveNormalItemViewHolder;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.e.m.b;
import d.a.c.e.p.l;
import d.a.m0.r.q.y1;
import d.a.n0.e2.h.e;
import d.a.n0.e2.i.c;
import d.a.n0.e2.k.e.o;
import d.a.n0.e2.o.i;
/* loaded from: classes5.dex */
public class a extends o<PostData, PbInterviewLiveNormalItemViewHolder> implements View.OnClickListener, d.a.n0.e2.k.c.a {
    public View.OnLongClickListener A;
    public int B;
    public int C;
    public boolean D;
    public final boolean E;
    public int s;
    public boolean t;
    public boolean u;
    public e v;
    public boolean w;
    public View.OnClickListener x;
    public TbRichTextView.x y;
    public c z;

    /* renamed from: d.a.n0.f2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1333a implements View.OnClickListener {
        public View$OnClickListenerC1333a(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = false;
        this.s = 0;
        this.t = true;
        this.u = true;
        this.v = null;
        this.w = true;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.D = false;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 14 && i2 <= 16) {
            z = true;
        }
        this.E = z;
        f0(pbFragment);
    }

    @Override // d.a.n0.e2.k.e.o, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        m0(i2, view, viewGroup, (PostData) obj, (PbInterviewLiveNormalItemViewHolder) viewHolder);
        return view;
    }

    @Override // d.a.n0.e2.k.c.a
    public void c(boolean z) {
        this.t = z;
    }

    @Override // d.a.n0.e2.k.c.a
    public void d(View.OnLongClickListener onLongClickListener) {
        this.A = onLongClickListener;
    }

    @Override // d.a.n0.e2.k.c.a
    public void e(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    @Override // d.a.n0.e2.k.c.a
    public void f(boolean z) {
        this.w = z;
    }

    @Override // d.a.n0.e2.k.e.o
    public void f0(i iVar) {
        super.f0(iVar);
        if (iVar != null) {
            this.B = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.C = l.k(this.f39228e) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    public final void g0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        if (!TextUtils.isEmpty(postData.u()) && this.t) {
            pbInterviewLiveNormalItemViewHolder.f19579f.setOnClickListener(this.x);
        } else {
            pbInterviewLiveNormalItemViewHolder.f19579f.setOnClickListener(null);
        }
        pbInterviewLiveNormalItemViewHolder.f19579f.setTextViewCheckSelection(false);
        pbInterviewLiveNormalItemViewHolder.f19579f.setTextViewOnClickListener(new View$OnClickListenerC1333a(this));
    }

    public final void h0(TbRichTextView tbRichTextView, int i2) {
        if (tbRichTextView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
        layoutParams.leftMargin = i2;
        tbRichTextView.getLayoutStrategy().q(this.C - (i2 - this.B));
        tbRichTextView.setLayoutParams(layoutParams);
    }

    public final void i0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        y1 p1;
        String str;
        String str2;
        long j;
        if (pbInterviewLiveNormalItemViewHolder == null || postData == null) {
            return;
        }
        h0(pbInterviewLiveNormalItemViewHolder.f19579f, (int) this.f39228e.getResources().getDimension(R.dimen.ds30));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.f19579f.getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        pbInterviewLiveNormalItemViewHolder.f19579f.setLayoutParams(layoutParams);
        pbInterviewLiveNormalItemViewHolder.f19579f.setPadding(0, 0, 0, 0);
        pbInterviewLiveNormalItemViewHolder.f19579f.e0(null);
        postData.B0();
        if (postData.A() == 1) {
            pbInterviewLiveNormalItemViewHolder.f19581h.setVisibility(0);
            if (postData.t() != null) {
                long userIdLong = postData.t().getUserIdLong();
                String userName = postData.t().getUserName();
                str2 = postData.t().getName_show();
                str = userName;
                j = userIdLong;
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            pbInterviewLiveNormalItemViewHolder.f19581h.g(postData.D(), str, str2, j, b.f(this.v.L().o0(), 0L), b.f(postData.E(), 0L));
            pbInterviewLiveNormalItemViewHolder.f19581h.i();
            if (this.w) {
                PraiseData Q0 = this.v.L().Q0();
                if (Q0 != null && Q0.getUser() != null && Q0.getUser().size() > 0) {
                    pbInterviewLiveNormalItemViewHolder.f19582i.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.f19580g.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.j.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.f19582i.setIsFromPb(true);
                    pbInterviewLiveNormalItemViewHolder.f19582i.setData(Q0, this.v.L().o0(), Q0.getPostId(), true);
                    pbInterviewLiveNormalItemViewHolder.f19582i.i(this.p);
                } else {
                    pbInterviewLiveNormalItemViewHolder.f19582i.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.f19580g.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.j.setVisibility(8);
                }
            } else {
                pbInterviewLiveNormalItemViewHolder.f19582i.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.f19580g.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.j.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.f19582i.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.f19580g.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.j.setVisibility(0);
            h0(pbInterviewLiveNormalItemViewHolder.f19579f, (int) this.f39228e.getResources().getDimension(R.dimen.ds30));
        } else {
            pbInterviewLiveNormalItemViewHolder.f19581h.setVisibility(8);
        }
        pbInterviewLiveNormalItemViewHolder.f19579f.getLayoutStrategy().x(R.drawable.pic_video);
        pbInterviewLiveNormalItemViewHolder.f19579f.setTextColor(SkinManager.getColor(R.color.common_color_10039));
        pbInterviewLiveNormalItemViewHolder.f19579f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbInterviewLiveNormalItemViewHolder.f19579f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.t) {
            pbInterviewLiveNormalItemViewHolder.f19579f.getLayoutStrategy().g(R.drawable.transparent_bg);
        } else {
            pbInterviewLiveNormalItemViewHolder.f19579f.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbInterviewLiveNormalItemViewHolder.f19579f.setIsFromCDN(this.q);
        TbRichText K = postData.K();
        if (!this.D && this.E) {
            pbInterviewLiveNormalItemViewHolder.f19579f.setText(K, true);
        } else {
            pbInterviewLiveNormalItemViewHolder.f19579f.setText(K, false);
        }
        if (this.v.L().p1() != null) {
            pbInterviewLiveNormalItemViewHolder.f19578e.V(this.v.L().p1().i(), this.q ? 17 : 18, false);
            int k = l.k(this.f39228e);
            float h2 = p1.h() / p1.j();
            int i2 = (int) (h2 > 1.0f ? k * 1.0f : h2 < 0.2f ? k * 0.2f : k * h2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.f19578e.getLayoutParams();
            layoutParams2.height = i2;
            layoutParams2.width = k;
            pbInterviewLiveNormalItemViewHolder.f19578e.setLayoutParams(layoutParams2);
        } else {
            pbInterviewLiveNormalItemViewHolder.f19578e.setVisibility(8);
        }
        g0(pbInterviewLiveNormalItemViewHolder, postData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: j0 */
    public PbInterviewLiveNormalItemViewHolder P(ViewGroup viewGroup) {
        return new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.f39228e).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.u, this.t, this.s, false);
    }

    @Override // d.a.n0.e2.k.c.a
    public void l(View.OnClickListener onClickListener) {
    }

    @Override // d.a.n0.e2.k.c.a
    public void m(int i2) {
        this.s = i2;
    }

    public View m0(int i2, View view, ViewGroup viewGroup, PostData postData, PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        super.W(i2, view, viewGroup, postData, pbInterviewLiveNormalItemViewHolder);
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        n0(pbInterviewLiveNormalItemViewHolder);
        i0(pbInterviewLiveNormalItemViewHolder, postData);
        return view;
    }

    public final void n0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        pbInterviewLiveNormalItemViewHolder.f19579f.setOnLongClickListener(this.A);
        pbInterviewLiveNormalItemViewHolder.f19579f.setOnTouchListener(this.z);
        pbInterviewLiveNormalItemViewHolder.f19579f.setOnImageClickListener(this.y);
        i iVar = this.m;
        if (iVar == null || iVar.A() == null) {
            return;
        }
        pbInterviewLiveNormalItemViewHolder.f19579f.setOnEmotionClickListener(this.m.A().mEvent.f53198e);
    }

    @Override // d.a.n0.e2.k.c.a
    public void o(TbRichTextView.x xVar) {
        this.y = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // d.a.n0.e2.k.c.a
    public void p(String str) {
    }

    @Override // d.a.n0.e2.k.c.a
    public void r(boolean z) {
    }

    @Override // d.a.n0.e2.k.c.a
    public void s(e eVar) {
        this.v = eVar;
    }
}
