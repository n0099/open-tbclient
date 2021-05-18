package d.a.k0.t.j.h;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.a.k0.t.j.d.f;
/* loaded from: classes4.dex */
public class b extends d.a.k0.x.b<f> {
    public TextView m;
    public ProgressBar n;
    public FrameLayout o;
    public TextView p;
    public TextView q;
    public TextView r;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        s(l());
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.ala_person_center_list_head_item;
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void s(View view) {
        this.m = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.q = (TextView) view.findViewById(R.id.level_name_curr);
        this.r = (TextView) view.findViewById(R.id.level_name_next);
        this.p = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.n = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.o = (FrameLayout) view.findViewById(R.id.level_privilege_layout);
        l().setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.x.b
    /* renamed from: t */
    public void m(f fVar) {
        d.a.k0.t.j.d.c h2 = fVar.h();
        if (h2 == null || h2.b() == null) {
            return;
        }
        String str = "LV." + h2.b().yy_level_id;
        if (!TextUtils.isEmpty(h2.b().yy_level_name)) {
            str = h2.b().yy_level_name + str;
            this.q.setText(h2.b().yy_level_name);
        }
        this.m.setText(str);
        if (h2.b().yy_levelup_exp <= h2.b().yy_level_exp) {
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.p.setVisibility(8);
            this.n.setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(h2.b().yy_level_next_name)) {
            this.r.setText(h2.b().yy_level_next_name);
        }
        long j = h2.b().yy_levelup_exp;
        long j2 = h2.b().yy_level_exp;
        this.n.setMax((int) j);
        this.n.setProgress((int) j2);
        if (TextUtils.isEmpty(h2.b().yy_level_next_name) || h2.b().yy_levelup_exp <= h2.b().yy_level_exp) {
            return;
        }
        String string = this.f63161f.getPageActivity().getResources().getString(R.string.ala_level_next_tips);
        int i2 = (int) ((((float) (h2.b().yy_levelup_exp - h2.b().yy_level_exp)) * 100.0f) / ((float) h2.b().yy_levelup_exp));
        if (i2 <= 0) {
            i2 = 1;
        }
        this.p.setText(String.format(string, h2.b().yy_level_next_name, i2 + "%"));
    }
}
