package d.a.n0.x.f;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class a extends AlertDialog {

    /* renamed from: e  reason: collision with root package name */
    public View f66923e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66924f;

    /* renamed from: g  reason: collision with root package name */
    public String f66925g;

    public a(Context context) {
        super(context);
    }

    public void a(int i2) {
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        View view = this.f66923e;
        int i3 = R.color.cp_cont_b_alpha80;
        SkinManager.setBackgroundShapeDrawable(view, g2, i3, i3, i2);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
            window.setContentView(R.layout.id_card_dialog);
            this.f66923e = window.findViewById(R.id.toast_container);
            this.f66924f = (TextView) window.findViewById(R.id.toast_tv);
            if (!StringUtils.isNull(this.f66925g)) {
                this.f66924f.setText(this.f66925g);
            }
            a(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
