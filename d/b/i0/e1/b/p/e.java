package d.b.i0.e1.b.p;

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
import d.b.b.a.f;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public f f54491a;

    /* renamed from: b  reason: collision with root package name */
    public View f54492b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f54493c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54494d;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f54495e;

    /* renamed from: f  reason: collision with root package name */
    public b f54496f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f54497g = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == e.this.f54495e.getId()) {
                d.b.h0.s.h.a.c(e.this.f54491a);
                TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 1));
            } else if (view.getId() == e.this.f54493c.getId()) {
                d.b.h0.r.d0.b.i().v("key_im_open_notification_close_time", System.currentTimeMillis());
                if (e.this.f54496f != null) {
                    e.this.f54496f.onClose();
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
        this.f54491a = fVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.open_notification_view, (ViewGroup) null);
        this.f54492b = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_close);
        this.f54493c = imageView;
        imageView.setOnClickListener(this.f54497g);
        this.f54494d = (TextView) this.f54492b.findViewById(R.id.open_desc);
        this.f54495e = (TBSpecificationBtn) this.f54492b.findViewById(R.id.btn_open);
        this.f54495e.setConfig(new d.b.h0.r.f0.m.b());
        this.f54495e.setText(fVar.getString(R.string.go_to_open));
        this.f54495e.setOnClickListener(this.f54497g);
        TiebaStatic.log("c13704");
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        return this.f54492b;
    }

    public void f(int i) {
        SkinManager.setBackgroundColor(this.f54492b, R.color.CAM_X0206);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f54493c, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setViewTextColor(this.f54494d, R.color.CAM_X0107);
    }

    public void g(b bVar) {
        this.f54496f = bVar;
    }
}
