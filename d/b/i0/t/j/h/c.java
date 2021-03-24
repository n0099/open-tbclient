package d.b.i0.t.j.h;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends d.b.i0.x.b<d.b.i0.t.j.d.b> {
    public TextView m;
    public TextView n;
    public String o;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        u(m());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.ala_person_center_list_qq_group_item;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setViewTextColor(this.m, R.color.common_color_10106);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0302);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.o)) {
            UtilHelper.copyToClipBoard(this.o);
        }
        BdToast c2 = BdToast.c(b(), b().getResources().getString(R.string.ala_person_center_copy_to_clipboard));
        c2.j(17);
        c2.q();
    }

    public final void u(View view) {
        this.m = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_number_txt);
        TextView textView = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_copy_txt);
        this.n = textView;
        textView.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: v */
    public void n(d.b.i0.t.j.d.b bVar) {
    }

    public void w(String str) {
        this.o = str;
        TextView textView = this.m;
        if (textView != null) {
            textView.setText(b().getResources().getString(R.string.ala_person_center_qq_group) + str);
        }
    }
}
