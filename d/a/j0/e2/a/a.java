package d.a.j0.e2.a;

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
import d.a.i0.r.q.y1;
import d.a.j0.d2.h.e;
import d.a.j0.d2.i.c;
import d.a.j0.d2.k.e.o;
import d.a.j0.d2.o.i;
/* loaded from: classes3.dex */
public class a extends o<PostData, PbInterviewLiveNormalItemViewHolder> implements View.OnClickListener, d.a.j0.d2.k.c.a {
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

    /* renamed from: d.a.j0.e2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1243a implements View.OnClickListener {
        public View$OnClickListenerC1243a(a aVar) {
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

    @Override // d.a.j0.d2.k.e.o, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        m0(i2, view, viewGroup, (PostData) obj, (PbInterviewLiveNormalItemViewHolder) viewHolder);
        return view;
    }

    @Override // d.a.j0.d2.k.c.a
    public void c(boolean z) {
        this.t = z;
    }

    @Override // d.a.j0.d2.k.c.a
    public void d(View.OnLongClickListener onLongClickListener) {
        this.A = onLongClickListener;
    }

    @Override // d.a.j0.d2.k.c.a
    public void e(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    @Override // d.a.j0.d2.k.c.a
    public void f(boolean z) {
        this.w = z;
    }

    @Override // d.a.j0.d2.k.e.o
    public void f0(i iVar) {
        super.f0(iVar);
        if (iVar != null) {
            this.B = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.C = l.k(this.f40319e) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    public final void g0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        if (!TextUtils.isEmpty(postData.u()) && this.t) {
            pbInterviewLiveNormalItemViewHolder.f20369f.setOnClickListener(this.x);
        } else {
            pbInterviewLiveNormalItemViewHolder.f20369f.setOnClickListener(null);
        }
        pbInterviewLiveNormalItemViewHolder.f20369f.setTextViewCheckSelection(false);
        pbInterviewLiveNormalItemViewHolder.f20369f.setTextViewOnClickListener(new View$OnClickListenerC1243a(this));
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
        y1 o1;
        String str;
        String str2;
        long j;
        if (pbInterviewLiveNormalItemViewHolder == null || postData == null) {
            return;
        }
        h0(pbInterviewLiveNormalItemViewHolder.f20369f, (int) this.f40319e.getResources().getDimension(R.dimen.ds30));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.f20369f.getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        pbInterviewLiveNormalItemViewHolder.f20369f.setLayoutParams(layoutParams);
        pbInterviewLiveNormalItemViewHolder.f20369f.setPadding(0, 0, 0, 0);
        pbInterviewLiveNormalItemViewHolder.f20369f.e0(null);
        postData.B0();
        if (postData.A() == 1) {
            pbInterviewLiveNormalItemViewHolder.f20371h.setVisibility(0);
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
            pbInterviewLiveNormalItemViewHolder.f20371h.g(postData.D(), str, str2, j, b.f(this.v.L().o0(), 0L), b.f(postData.E(), 0L));
            pbInterviewLiveNormalItemViewHolder.f20371h.i();
            if (this.w) {
                PraiseData P0 = this.v.L().P0();
                if (P0 != null && P0.getUser() != null && P0.getUser().size() > 0) {
                    pbInterviewLiveNormalItemViewHolder.f20372i.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.f20370g.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.j.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.f20372i.setIsFromPb(true);
                    pbInterviewLiveNormalItemViewHolder.f20372i.setData(P0, this.v.L().o0(), P0.getPostId(), true);
                    pbInterviewLiveNormalItemViewHolder.f20372i.i(this.p);
                } else {
                    pbInterviewLiveNormalItemViewHolder.f20372i.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.f20370g.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.j.setVisibility(8);
                }
            } else {
                pbInterviewLiveNormalItemViewHolder.f20372i.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.f20370g.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.j.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.f20372i.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.f20370g.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.j.setVisibility(0);
            h0(pbInterviewLiveNormalItemViewHolder.f20369f, (int) this.f40319e.getResources().getDimension(R.dimen.ds30));
        } else {
            pbInterviewLiveNormalItemViewHolder.f20371h.setVisibility(8);
        }
        pbInterviewLiveNormalItemViewHolder.f20369f.getLayoutStrategy().x(R.drawable.pic_video);
        pbInterviewLiveNormalItemViewHolder.f20369f.setTextColor(SkinManager.getColor(R.color.common_color_10039));
        pbInterviewLiveNormalItemViewHolder.f20369f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbInterviewLiveNormalItemViewHolder.f20369f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.t) {
            pbInterviewLiveNormalItemViewHolder.f20369f.getLayoutStrategy().g(R.drawable.transparent_bg);
        } else {
            pbInterviewLiveNormalItemViewHolder.f20369f.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbInterviewLiveNormalItemViewHolder.f20369f.setIsFromCDN(this.q);
        TbRichText K = postData.K();
        if (!this.D && this.E) {
            pbInterviewLiveNormalItemViewHolder.f20369f.setText(K, true);
        } else {
            pbInterviewLiveNormalItemViewHolder.f20369f.setText(K, false);
        }
        if (this.v.L().o1() != null) {
            pbInterviewLiveNormalItemViewHolder.f20368e.V(this.v.L().o1().i(), this.q ? 17 : 18, false);
            int k = l.k(this.f40319e);
            float h2 = o1.h() / o1.j();
            int i2 = (int) (h2 > 1.0f ? k * 1.0f : h2 < 0.2f ? k * 0.2f : k * h2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.f20368e.getLayoutParams();
            layoutParams2.height = i2;
            layoutParams2.width = k;
            pbInterviewLiveNormalItemViewHolder.f20368e.setLayoutParams(layoutParams2);
        } else {
            pbInterviewLiveNormalItemViewHolder.f20368e.setVisibility(8);
        }
        g0(pbInterviewLiveNormalItemViewHolder, postData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: j0 */
    public PbInterviewLiveNormalItemViewHolder P(ViewGroup viewGroup) {
        return new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.f40319e).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.u, this.t, this.s, false);
    }

    @Override // d.a.j0.d2.k.c.a
    public void l(View.OnClickListener onClickListener) {
    }

    @Override // d.a.j0.d2.k.c.a
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
        pbInterviewLiveNormalItemViewHolder.f20369f.setOnLongClickListener(this.A);
        pbInterviewLiveNormalItemViewHolder.f20369f.setOnTouchListener(this.z);
        pbInterviewLiveNormalItemViewHolder.f20369f.setOnImageClickListener(this.y);
        i iVar = this.m;
        if (iVar == null || iVar.A() == null) {
            return;
        }
        pbInterviewLiveNormalItemViewHolder.f20369f.setOnEmotionClickListener(this.m.A().mEvent.f52241e);
    }

    @Override // d.a.j0.d2.k.c.a
    public void o(TbRichTextView.x xVar) {
        this.y = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // d.a.j0.d2.k.c.a
    public void p(String str) {
    }

    @Override // d.a.j0.d2.k.c.a
    public void r(boolean z) {
    }

    @Override // d.a.j0.d2.k.c.a
    public void s(e eVar) {
        this.v = eVar;
    }
}
