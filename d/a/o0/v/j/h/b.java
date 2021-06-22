package d.a.o0.v.j.h;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.a.o0.v.j.d.f;
/* loaded from: classes4.dex */
public class b extends d.a.o0.z.b<f> {
    public TextView m;
    public ProgressBar n;
    public FrameLayout o;
    public TextView p;
    public TextView q;
    public TextView r;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        t(m());
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.ala_person_center_list_head_item;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void t(View view) {
        this.m = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.q = (TextView) view.findViewById(R.id.level_name_curr);
        this.r = (TextView) view.findViewById(R.id.level_name_next);
        this.p = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.n = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.o = (FrameLayout) view.findViewById(R.id.level_privilege_layout);
        m().setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: u */
    public void n(f fVar) {
        d.a.o0.v.j.d.c c2 = fVar.c();
        if (c2 == null || c2.b() == null) {
            return;
        }
        String str = "LV." + c2.b().yy_level_id;
        if (!TextUtils.isEmpty(c2.b().yy_level_name)) {
            str = c2.b().yy_level_name + str;
            this.q.setText(c2.b().yy_level_name);
        }
        this.m.setText(str);
        if (c2.b().yy_levelup_exp <= c2.b().yy_level_exp) {
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.p.setVisibility(8);
            this.n.setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(c2.b().yy_level_next_name)) {
            this.r.setText(c2.b().yy_level_next_name);
        }
        long j = c2.b().yy_levelup_exp;
        long j2 = c2.b().yy_level_exp;
        this.n.setMax((int) j);
        this.n.setProgress((int) j2);
        if (TextUtils.isEmpty(c2.b().yy_level_next_name) || c2.b().yy_levelup_exp <= c2.b().yy_level_exp) {
            return;
        }
        String string = this.f67284f.getPageActivity().getResources().getString(R.string.ala_level_next_tips);
        int i2 = (int) ((((float) (c2.b().yy_levelup_exp - c2.b().yy_level_exp)) * 100.0f) / ((float) c2.b().yy_levelup_exp));
        if (i2 <= 0) {
            i2 = 1;
        }
        this.p.setText(String.format(string, c2.b().yy_level_next_name, i2 + "%"));
    }
}
