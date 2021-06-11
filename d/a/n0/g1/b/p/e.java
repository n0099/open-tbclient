package d.a.n0.g1.b.p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.a.c.a.f;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public f f58823a;

    /* renamed from: b  reason: collision with root package name */
    public View f58824b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f58825c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58826d;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f58827e;

    /* renamed from: f  reason: collision with root package name */
    public b f58828f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f58829g = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == e.this.f58827e.getId()) {
                d.a.m0.s.h.a.c(e.this.f58823a);
                TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 1));
            } else if (view.getId() == e.this.f58825c.getId()) {
                d.a.m0.r.d0.b.j().w("key_im_open_notification_close_time", System.currentTimeMillis());
                if (e.this.f58828f != null) {
                    e.this.f58828f.onClose();
                }
                TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onClose();
    }

    public e(f fVar) {
        this.f58823a = fVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.open_notification_view, (ViewGroup) null);
        this.f58824b = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_close);
        this.f58825c = imageView;
        imageView.setOnClickListener(this.f58829g);
        this.f58826d = (TextView) this.f58824b.findViewById(R.id.open_desc);
        this.f58827e = (TBSpecificationBtn) this.f58824b.findViewById(R.id.btn_open);
        this.f58827e.setConfig(new d.a.m0.r.f0.m.b());
        this.f58827e.setText(fVar.getString(R.string.go_to_open));
        this.f58827e.setOnClickListener(this.f58829g);
        TiebaStatic.log("c13704");
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        return this.f58824b;
    }

    public void f(int i2) {
        SkinManager.setBackgroundColor(this.f58824b, R.color.CAM_X0206);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58825c, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setViewTextColor(this.f58826d, R.color.CAM_X0107);
    }

    public void g(b bVar) {
        this.f58828f = bVar;
    }
}
