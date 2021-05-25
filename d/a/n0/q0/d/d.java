package d.a.n0.q0.d;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import d.a.n0.q0.b.e;
/* loaded from: classes4.dex */
public class d extends d.a.n0.z.b<d.a.n0.q0.c.b> {
    public BarImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public int q;
    public d.a.n0.q0.c.b r;
    public View.OnClickListener s;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.q = 3;
        this.m = (BarImageView) l().findViewById(R.id.forum_avatar);
        this.n = (TextView) l().findViewById(R.id.forum_name);
        this.o = (TextView) l().findViewById(R.id.forum_attention);
        this.p = (TextView) l().findViewById(R.id.forum_thread_count);
        l().setOnClickListener(this);
        n(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.n0.z.b
    public int g() {
        return R.layout.forum_search_result_item;
    }

    @Override // d.a.n0.z.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.q == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(l(), R.drawable.square_search_item_bg);
        this.q = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.r == null) {
            return;
        }
        TiebaStatic.log("c12261");
        e.d(this.r.u());
        view.setTag(this.r);
        View.OnClickListener onClickListener = this.s;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: s */
    public void m(d.a.n0.q0.c.b bVar) {
        if (bVar == null) {
            return;
        }
        this.r = bVar;
        this.m.V(bVar.h(), 10, false);
        this.n.setText(t(bVar.p(), bVar.u()));
        this.o.setText(String.format(this.f63441f.getString(R.string.concern), bVar.l()));
        this.p.setText(String.format(this.f63441f.getString(R.string.search_bar_thread), bVar.t()));
        n(this.f63441f, TbadkCoreApplication.getInst().getSkinType());
    }

    public SpannableStringBuilder t(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int indexOf = str.indexOf(trim);
        if (indexOf != -1) {
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, trim.length() + indexOf, 33);
        }
        return spannableStringBuilder;
    }

    public void u(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }
}
