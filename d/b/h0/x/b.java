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
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public View f51621a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f51622b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f51623c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f51624d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f51625e;

    public b(Context context) {
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_rule_copy, (ViewGroup) null);
        this.f51621a = inflate;
        this.f51622b = (ImageView) inflate.findViewById(R.id.floating_view_icon);
        this.f51624d = (TextView) this.f51621a.findViewById(R.id.floating_view_title);
        this.f51623c = (ImageView) this.f51621a.findViewById(R.id.floating_view_arrow);
        this.f51625e = (LinearLayout) this.f51621a.findViewById(R.id.floating_view_main);
        this.f51624d.setText(R.string.frs_forum_rule_return_info);
        d();
    }

    @Override // d.b.h0.x.c
    public void d() {
        if (this.f51621a != null) {
            SkinManager.setViewTextColor(this.f51624d, R.color.CAM_X0101);
            this.f51623c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right_n, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0302).setShape(0).setAlpha(211).tlRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52)).blRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52)).into(this.f51625e);
            this.f51622b.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_manage_postdelete_cancel32, WebPManager.ResourceStateType.NORMAL));
        }
    }

    @Override // d.b.h0.x.c
    public View getView() {
        View view = this.f51621a;
        return view != null ? view : LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
    }

    @Override // d.b.h0.x.c
    public void onClick() {
    }
}
