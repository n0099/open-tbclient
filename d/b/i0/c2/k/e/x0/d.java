package d.b.i0.c2.k.e.x0;

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
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f52905a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f52906b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f52907c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f52908d;

    /* renamed from: e  reason: collision with root package name */
    public String f52909e;

    /* renamed from: f  reason: collision with root package name */
    public int f52910f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f52911e;

        public a(TbPageContext tbPageContext) {
            this.f52911e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f52911e;
            urlManager.dealOneLink(tbPageContext, new String[]{"http://tieba.baidu.com/mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1&postId=" + d.this.f52909e});
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_UEG_POST_CLICKED).param("obj_locate", d.this.f52910f));
        }
    }

    public d(PbFragment pbFragment) {
        c(pbFragment.getPageContext());
    }

    public void b(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.x(this.f52905a, i);
        }
    }

    public final void c(TbPageContext<?> tbPageContext) {
        if (this.f52905a != null) {
            return;
        }
        this.f52905a = (FrameLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.pb_head_ueg_layout, (ViewGroup) null);
        h(tbPageContext);
    }

    public void d() {
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.f52906b);
        a2.h(R.string.J_X05);
        a2.c(R.color.CAM_X0206);
        SkinManager.setViewTextColor(this.f52907c, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f52908d, R.color.CAM_X0109);
    }

    public void e(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.f52905a);
        }
    }

    public void f(String str) {
        this.f52909e = str;
    }

    public void g(int i) {
        this.f52905a.setVisibility(i);
    }

    public final void h(TbPageContext<?> tbPageContext) {
        this.f52906b = (LinearLayout) this.f52905a.findViewById(R.id.container);
        this.f52907c = (EMTextView) this.f52905a.findViewById(R.id.tv_title);
        this.f52908d = (EMTextView) this.f52905a.findViewById(R.id.tv_content);
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.f52907c);
        a2.n(R.color.CAM_X0109);
        a2.s(R.string.F_X01);
        d.b.h0.r.u.c a3 = d.b.h0.r.u.c.a(this.f52908d);
        a3.o(R.dimen.M_H_X003);
        a3.n(R.color.CAM_X0109);
        a3.s(R.string.F_X01);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_head_block_title));
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan.d(l.g(tbPageContext.getContext(), R.dimen.tbds31));
        eMRichTextAnyIconSpan.c(l.g(tbPageContext.getContext(), R.dimen.M_W_X002));
        eMRichTextAnyIconSpan.a(0);
        spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
        this.f52907c.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_head_block_content));
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_pure_arrow12_right_n, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan2.a(l.g(tbPageContext.getContext(), R.dimen.tbds3));
        spannableStringBuilder2.setSpan(eMRichTextAnyIconSpan2, spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 33);
        this.f52908d.setText(spannableStringBuilder2);
        this.f52906b.setOnClickListener(new a(tbPageContext));
    }

    public d(VideoPbFragment videoPbFragment, FrameLayout frameLayout) {
        this(videoPbFragment.getPageContext(), frameLayout);
    }

    public d(TbPageContext<?> tbPageContext, FrameLayout frameLayout) {
        this.f52905a = frameLayout;
        h(tbPageContext);
    }
}
