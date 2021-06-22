package d.a.o0.q0.d;

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
import d.a.o0.q0.b.e;
/* loaded from: classes4.dex */
public class d extends d.a.o0.z.b<d.a.o0.q0.c.b> {
    public BarImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public int q;
    public d.a.o0.q0.c.b r;
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

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.forum_search_result_item;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.q == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(m(), R.drawable.square_search_item_bg);
        this.q = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.r == null) {
            return;
        }
        TiebaStatic.log("c12261");
        e.d(this.r.q());
        view.setTag(this.r);
        View.OnClickListener onClickListener = this.s;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: t */
    public void n(d.a.o0.q0.c.b bVar) {
        if (bVar == null) {
            return;
        }
        this.r = bVar;
        this.m.U(bVar.c(), 10, false);
        this.n.setText(u(bVar.k(), bVar.q()));
        this.o.setText(String.format(this.f67284f.getString(R.string.concern), bVar.g()));
        this.p.setText(String.format(this.f67284f.getString(R.string.search_bar_thread), bVar.p()));
        o(this.f67284f, TbadkCoreApplication.getInst().getSkinType());
    }

    public SpannableStringBuilder u(String str, String str2) {
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

    public void v(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }
}
