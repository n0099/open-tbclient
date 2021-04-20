package d.b.i0.t.j.h;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.b.i0.t.j.d.f;
/* loaded from: classes4.dex */
public class b extends d.b.i0.x.b<f> {
    public TextView m;
    public ProgressBar n;
    public FrameLayout o;
    public TextView p;
    public TextView q;
    public TextView r;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        u(m());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.ala_person_center_list_head_item;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void u(View view) {
        this.m = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.q = (TextView) view.findViewById(R.id.level_name_curr);
        this.r = (TextView) view.findViewById(R.id.level_name_next);
        this.p = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.n = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.o = (FrameLayout) view.findViewById(R.id.level_privilege_layout);
        m().setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: v */
    public void n(f fVar) {
        d.b.i0.t.j.d.c g2 = fVar.g();
        if (g2 == null || g2.b() == null) {
            return;
        }
        String str = "LV." + g2.b().yy_level_id;
        if (!TextUtils.isEmpty(g2.b().yy_level_name)) {
            str = g2.b().yy_level_name + str;
            this.q.setText(g2.b().yy_level_name);
        }
        this.m.setText(str);
        if (g2.b().yy_levelup_exp <= g2.b().yy_level_exp) {
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.p.setVisibility(8);
            this.n.setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(g2.b().yy_level_next_name)) {
            this.r.setText(g2.b().yy_level_next_name);
        }
        long j = g2.b().yy_levelup_exp;
        long j2 = g2.b().yy_level_exp;
        this.n.setMax((int) j);
        this.n.setProgress((int) j2);
        if (TextUtils.isEmpty(g2.b().yy_level_next_name) || g2.b().yy_levelup_exp <= g2.b().yy_level_exp) {
            return;
        }
        String string = this.f63756f.getPageActivity().getResources().getString(R.string.ala_level_next_tips);
        int i = (int) ((((float) (g2.b().yy_levelup_exp - g2.b().yy_level_exp)) * 100.0f) / ((float) g2.b().yy_levelup_exp));
        if (i <= 0) {
            i = 1;
        }
        this.p.setText(String.format(string, g2.b().yy_level_next_name, i + "%"));
    }
}
