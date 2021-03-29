package d.b.i0.o0.d;

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
import d.b.i0.o0.b.e;
/* loaded from: classes4.dex */
public class d extends d.b.i0.x.b<d.b.i0.o0.c.b> {
    public BarImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public int q;
    public d.b.i0.o0.c.b r;
    public View.OnClickListener s;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.q = 3;
        this.m = (BarImageView) m().findViewById(R.id.forum_avatar);
        this.n = (TextView) m().findViewById(R.id.forum_name);
        this.o = (TextView) m().findViewById(R.id.forum_attention);
        this.p = (TextView) m().findViewById(R.id.forum_thread_count);
        m().setOnClickListener(this);
        o(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.forum_search_result_item;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.q == i) {
            return;
        }
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(m(), R.drawable.square_search_item_bg);
        this.q = i;
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
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(d.b.i0.o0.c.b bVar) {
        if (bVar == null) {
            return;
        }
        this.r = bVar;
        this.m.W(bVar.g(), 10, false);
        this.n.setText(v(bVar.o(), bVar.u()));
        this.o.setText(String.format(this.f62181f.getString(R.string.concern), bVar.j()));
        this.p.setText(String.format(this.f62181f.getString(R.string.search_bar_thread), bVar.t()));
        o(this.f62181f, TbadkCoreApplication.getInst().getSkinType());
    }

    public SpannableStringBuilder v(String str, String str2) {
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

    public void w(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }
}
