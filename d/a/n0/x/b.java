package d.a.n0.x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public View f54727a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f54728b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f54729c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54730d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f54731e;

    public b(Context context) {
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_rule_copy, (ViewGroup) null);
        this.f54727a = inflate;
        this.f54728b = (ImageView) inflate.findViewById(R.id.floating_view_icon);
        this.f54730d = (TextView) this.f54727a.findViewById(R.id.floating_view_title);
        this.f54729c = (ImageView) this.f54727a.findViewById(R.id.floating_view_arrow);
        this.f54731e = (LinearLayout) this.f54727a.findViewById(R.id.floating_view_main);
        this.f54730d.setText(R.string.frs_forum_rule_return_info);
        b();
    }

    @Override // d.a.n0.x.c
    public void b() {
        if (this.f54727a != null) {
            SkinManager.setViewTextColor(this.f54730d, R.color.CAM_X0101);
            this.f54729c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right_n, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0302).setShape(0).setAlpha(211).tlRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52)).blRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52)).into(this.f54731e);
            this.f54728b.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_manage_postdelete_cancel32, WebPManager.ResourceStateType.NORMAL));
        }
    }

    @Override // d.a.n0.x.c
    public View getView() {
        View view = this.f54727a;
        return view != null ? view : LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
    }

    @Override // d.a.n0.x.c
    public void onClick() {
    }
}
