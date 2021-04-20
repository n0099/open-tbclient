package d.b.i0.e2.a;

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
import d.b.c.e.m.b;
import d.b.c.e.p.l;
import d.b.h0.r.q.y1;
import d.b.i0.d2.h.e;
import d.b.i0.d2.i.c;
import d.b.i0.d2.k.e.o;
import d.b.i0.d2.o.i;
/* loaded from: classes3.dex */
public class a extends o<PostData, PbInterviewLiveNormalItemViewHolder> implements View.OnClickListener, d.b.i0.d2.k.c.a {
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

    /* renamed from: d.b.i0.e2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1281a implements View.OnClickListener {
        public View$OnClickListenerC1281a(a aVar) {
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
        int i = Build.VERSION.SDK_INT;
        if (i >= 14 && i <= 16) {
            z = true;
        }
        this.E = z;
        i0(pbFragment);
    }

    @Override // d.b.i0.d2.k.e.o, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        o0(i, view, viewGroup, (PostData) obj, (PbInterviewLiveNormalItemViewHolder) viewHolder);
        return view;
    }

    @Override // d.b.i0.d2.k.c.a
    public void e(View.OnClickListener onClickListener) {
    }

    @Override // d.b.i0.d2.k.c.a
    public void g(int i) {
        this.s = i;
    }

    @Override // d.b.i0.d2.k.c.a
    public void h(boolean z) {
        this.t = z;
    }

    @Override // d.b.i0.d2.k.e.o
    public void i0(i iVar) {
        super.i0(iVar);
        if (iVar != null) {
            this.B = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.C = l.k(this.f42855e) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    @Override // d.b.i0.d2.k.c.a
    public void j(TbRichTextView.x xVar) {
        this.y = xVar;
    }

    public final void j0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        if (!TextUtils.isEmpty(postData.u()) && this.t) {
            pbInterviewLiveNormalItemViewHolder.f19863f.setOnClickListener(this.x);
        } else {
            pbInterviewLiveNormalItemViewHolder.f19863f.setOnClickListener(null);
        }
        pbInterviewLiveNormalItemViewHolder.f19863f.setTextViewCheckSelection(false);
        pbInterviewLiveNormalItemViewHolder.f19863f.setTextViewOnClickListener(new View$OnClickListenerC1281a(this));
    }

    @Override // d.b.i0.d2.k.c.a
    public void k(View.OnLongClickListener onLongClickListener) {
        this.A = onLongClickListener;
    }

    @Override // d.b.i0.d2.k.c.a
    public void l(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public final void l0(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
        layoutParams.leftMargin = i;
        tbRichTextView.getLayoutStrategy().q(this.C - (i - this.B));
        tbRichTextView.setLayoutParams(layoutParams);
    }

    @Override // d.b.i0.d2.k.c.a
    public void m(boolean z) {
        this.w = z;
    }

    public final void m0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        y1 o1;
        String str;
        String str2;
        long j;
        if (pbInterviewLiveNormalItemViewHolder == null || postData == null) {
            return;
        }
        l0(pbInterviewLiveNormalItemViewHolder.f19863f, (int) this.f42855e.getResources().getDimension(R.dimen.ds30));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.f19863f.getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        pbInterviewLiveNormalItemViewHolder.f19863f.setLayoutParams(layoutParams);
        pbInterviewLiveNormalItemViewHolder.f19863f.setPadding(0, 0, 0, 0);
        pbInterviewLiveNormalItemViewHolder.f19863f.e0(null);
        postData.B0();
        if (postData.A() == 1) {
            pbInterviewLiveNormalItemViewHolder.f19865h.setVisibility(0);
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
            pbInterviewLiveNormalItemViewHolder.f19865h.g(postData.D(), str, str2, j, b.f(this.v.L().o0(), 0L), b.f(postData.E(), 0L));
            pbInterviewLiveNormalItemViewHolder.f19865h.i();
            if (this.w) {
                PraiseData P0 = this.v.L().P0();
                if (P0 != null && P0.getUser() != null && P0.getUser().size() > 0) {
                    pbInterviewLiveNormalItemViewHolder.i.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.f19864g.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.j.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.i.setIsFromPb(true);
                    pbInterviewLiveNormalItemViewHolder.i.setData(P0, this.v.L().o0(), P0.getPostId(), true);
                    pbInterviewLiveNormalItemViewHolder.i.i(this.p);
                } else {
                    pbInterviewLiveNormalItemViewHolder.i.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.f19864g.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.j.setVisibility(8);
                }
            } else {
                pbInterviewLiveNormalItemViewHolder.i.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.f19864g.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.j.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.i.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.f19864g.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.j.setVisibility(0);
            l0(pbInterviewLiveNormalItemViewHolder.f19863f, (int) this.f42855e.getResources().getDimension(R.dimen.ds30));
        } else {
            pbInterviewLiveNormalItemViewHolder.f19865h.setVisibility(8);
        }
        pbInterviewLiveNormalItemViewHolder.f19863f.getLayoutStrategy().x(R.drawable.pic_video);
        pbInterviewLiveNormalItemViewHolder.f19863f.setTextColor(SkinManager.getColor(R.color.common_color_10039));
        pbInterviewLiveNormalItemViewHolder.f19863f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbInterviewLiveNormalItemViewHolder.f19863f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.t) {
            pbInterviewLiveNormalItemViewHolder.f19863f.getLayoutStrategy().g(R.drawable.transparent_bg);
        } else {
            pbInterviewLiveNormalItemViewHolder.f19863f.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbInterviewLiveNormalItemViewHolder.f19863f.setIsFromCDN(this.q);
        TbRichText K = postData.K();
        if (!this.D && this.E) {
            pbInterviewLiveNormalItemViewHolder.f19863f.setText(K, true);
        } else {
            pbInterviewLiveNormalItemViewHolder.f19863f.setText(K, false);
        }
        if (this.v.L().o1() != null) {
            pbInterviewLiveNormalItemViewHolder.f19862e.W(this.v.L().o1().i(), this.q ? 17 : 18, false);
            int k = l.k(this.f42855e);
            float h2 = o1.h() / o1.j();
            int i = (int) (h2 > 1.0f ? k * 1.0f : h2 < 0.2f ? k * 0.2f : k * h2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.f19862e.getLayoutParams();
            layoutParams2.height = i;
            layoutParams2.width = k;
            pbInterviewLiveNormalItemViewHolder.f19862e.setLayoutParams(layoutParams2);
        } else {
            pbInterviewLiveNormalItemViewHolder.f19862e.setVisibility(8);
        }
        j0(pbInterviewLiveNormalItemViewHolder, postData);
    }

    @Override // d.b.i0.d2.k.c.a
    public void n(String str) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: n0 */
    public PbInterviewLiveNormalItemViewHolder R(ViewGroup viewGroup) {
        return new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.f42855e).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.u, this.t, this.s, false);
    }

    public View o0(int i, View view, ViewGroup viewGroup, PostData postData, PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        super.X(i, view, viewGroup, postData, pbInterviewLiveNormalItemViewHolder);
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        p0(pbInterviewLiveNormalItemViewHolder);
        m0(pbInterviewLiveNormalItemViewHolder, postData);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void p0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        pbInterviewLiveNormalItemViewHolder.f19863f.setOnLongClickListener(this.A);
        pbInterviewLiveNormalItemViewHolder.f19863f.setOnTouchListener(this.z);
        pbInterviewLiveNormalItemViewHolder.f19863f.setOnImageClickListener(this.y);
        i iVar = this.m;
        if (iVar == null || iVar.P() == null) {
            return;
        }
        pbInterviewLiveNormalItemViewHolder.f19863f.setOnEmotionClickListener(this.m.P().mEvent.f54026e);
    }

    @Override // d.b.i0.d2.k.c.a
    public void r(boolean z) {
    }

    @Override // d.b.i0.d2.k.c.a
    public void s(e eVar) {
        this.v = eVar;
    }
}
