package d.b.h0.x;

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
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public View f52039a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f52040b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f52041c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52042d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f52043e;

    public b(Context context) {
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_rule_copy, (ViewGroup) null);
        this.f52039a = inflate;
        this.f52040b = (ImageView) inflate.findViewById(R.id.floating_view_icon);
        this.f52042d = (TextView) this.f52039a.findViewById(R.id.floating_view_title);
        this.f52041c = (ImageView) this.f52039a.findViewById(R.id.floating_view_arrow);
        this.f52043e = (LinearLayout) this.f52039a.findViewById(R.id.floating_view_main);
        this.f52042d.setText(R.string.frs_forum_rule_return_info);
        d();
    }

    @Override // d.b.h0.x.c
    public void d() {
        if (this.f52039a != null) {
            SkinManager.setViewTextColor(this.f52042d, R.color.CAM_X0101);
            this.f52041c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right_n, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0302).setShape(0).setAlpha(211).tlRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52)).blRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52)).into(this.f52043e);
            this.f52040b.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_manage_postdelete_cancel32, WebPManager.ResourceStateType.NORMAL));
        }
    }

    @Override // d.b.h0.x.c
    public View getView() {
        View view = this.f52039a;
        return view != null ? view : LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
    }

    @Override // d.b.h0.x.c
    public void onClick() {
    }
}
