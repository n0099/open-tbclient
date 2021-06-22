package d.a.n0.x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public View f54722a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f54723b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f54724c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54725d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f54726e;

    public a(Context context) {
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
        this.f54722a = inflate;
        this.f54723b = (ImageView) inflate.findViewById(R.id.floating_view_icon);
        this.f54725d = (TextView) this.f54722a.findViewById(R.id.floating_view_title);
        this.f54724c = (ImageView) this.f54722a.findViewById(R.id.floating_view_arrow);
        this.f54726e = (LinearLayout) this.f54722a.findViewById(R.id.floating_view_main);
        this.f54725d.setText(R.string.frs_forum_bcast_return_info);
        b();
    }

    @Override // d.a.n0.x.c
    public void b() {
        if (this.f54722a != null) {
            SkinManager.setViewTextColor(this.f54725d, R.color.CAM_X0101);
            SkinManager.setImageResource(this.f54723b, R.drawable.pic_float_return_broadcast32);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f54724c, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0305).setShape(0).setAlpha(211).tlRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52)).blRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52)).into(this.f54726e);
        }
    }

    @Override // d.a.n0.x.c
    public View getView() {
        View view = this.f54722a;
        return view != null ? view : LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
    }

    @Override // d.a.n0.x.c
    public void onClick() {
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_FORUM_FLOAT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()));
    }
}
