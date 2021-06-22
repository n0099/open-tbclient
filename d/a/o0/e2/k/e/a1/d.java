package d.a.o0.e2.k.e.a1;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f56916a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f56917b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f56918c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f56919d;

    /* renamed from: e  reason: collision with root package name */
    public String f56920e;

    /* renamed from: f  reason: collision with root package name */
    public int f56921f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f56922e;

        public a(TbPageContext tbPageContext) {
            this.f56922e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f56922e;
            urlManager.dealOneLink(tbPageContext, new String[]{"http://tieba.baidu.com/mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1&postId=" + d.this.f56920e});
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_UEG_POST_CLICKED).param("obj_locate", d.this.f56921f));
        }
    }

    public d(PbFragment pbFragment) {
        c(pbFragment.getPageContext());
    }

    public void b(BdTypeListView bdTypeListView, int i2) {
        if (bdTypeListView != null) {
            bdTypeListView.x(this.f56916a, i2);
        }
    }

    public final void c(TbPageContext<?> tbPageContext) {
        if (this.f56916a != null) {
            return;
        }
        this.f56916a = (FrameLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.pb_head_ueg_layout, (ViewGroup) null);
        h(tbPageContext);
    }

    public void d() {
        d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(this.f56917b);
        d2.m(R.string.J_X05);
        d2.f(R.color.CAM_X0206);
        SkinManager.setViewTextColor(this.f56918c, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f56919d, R.color.CAM_X0109);
    }

    public void e(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.f56916a);
        }
    }

    public void f(String str) {
        this.f56920e = str;
    }

    public void g(int i2) {
        this.f56916a.setVisibility(i2);
    }

    public final void h(TbPageContext<?> tbPageContext) {
        this.f56917b = (LinearLayout) this.f56916a.findViewById(R.id.container);
        this.f56918c = (EMTextView) this.f56916a.findViewById(R.id.tv_title);
        this.f56919d = (EMTextView) this.f56916a.findViewById(R.id.tv_content);
        d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(this.f56918c);
        d2.s(R.color.CAM_X0109);
        d2.x(R.string.F_X01);
        d.a.n0.r.u.c d3 = d.a.n0.r.u.c.d(this.f56919d);
        d3.t(R.dimen.M_H_X003);
        d3.s(R.color.CAM_X0109);
        d3.x(R.string.F_X01);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_head_block_title));
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan.d(l.g(tbPageContext.getContext(), R.dimen.tbds31));
        eMRichTextAnyIconSpan.c(l.g(tbPageContext.getContext(), R.dimen.M_W_X002));
        eMRichTextAnyIconSpan.a(0);
        spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
        this.f56918c.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_head_block_content));
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_pure_arrow12_right_n, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan2.a(l.g(tbPageContext.getContext(), R.dimen.tbds3));
        spannableStringBuilder2.setSpan(eMRichTextAnyIconSpan2, spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 33);
        this.f56919d.setText(spannableStringBuilder2);
        this.f56917b.setOnClickListener(new a(tbPageContext));
    }

    public d(VideoPbFragment videoPbFragment, FrameLayout frameLayout) {
        this(videoPbFragment.getPageContext(), frameLayout);
    }

    public d(TbPageContext<?> tbPageContext, FrameLayout frameLayout) {
        this.f56916a = frameLayout;
        h(tbPageContext);
    }
}
