package d.b.i0.v.f;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class a extends AlertDialog {

    /* renamed from: e  reason: collision with root package name */
    public View f61962e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61963f;

    /* renamed from: g  reason: collision with root package name */
    public String f61964g;

    public a(Context context) {
        super(context);
    }

    public void a(int i) {
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        View view = this.f61962e;
        int i2 = R.color.cp_cont_b_alpha80;
        SkinManager.setBackgroundShapeDrawable(view, g2, i2, i2, i);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
            window.setContentView(R.layout.id_card_dialog);
            this.f61962e = window.findViewById(R.id.toast_container);
            this.f61963f = (TextView) window.findViewById(R.id.toast_tv);
            if (!StringUtils.isNull(this.f61964g)) {
                this.f61963f.setText(this.f61964g);
            }
            a(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
