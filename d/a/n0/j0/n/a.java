package d.a.n0.j0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public View f56197e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f56198f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56199g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56200h;

    /* renamed from: i  reason: collision with root package name */
    public int f56201i;
    public View.OnClickListener j;

    public a(TbPageContext<?> tbPageContext) {
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.f56197e = inflate;
        this.f56198f = (FrameLayout) inflate.findViewById(R.id.create_bar_container);
        this.f56199g = (ImageView) this.f56197e.findViewById(R.id.iv_create_icon);
        this.f56200h = (TextView) this.f56197e.findViewById(R.id.create_text);
        this.f56201i = l.g(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.f56198f.setOnClickListener(this);
        this.f56199g.setOnClickListener(this);
        this.f56200h.setOnClickListener(this);
        if (this.f56198f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.f56198f.getLayoutParams()).bottomMargin = l.g(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.f56198f.requestLayout();
        }
    }

    public void a() {
        TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0205).defaultStrokeColor(R.color.cp_cont_b_alpha42).strokeWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).radius(this.f56201i).into(this.f56198f);
        SkinManager.setViewTextColor(this.f56200h, R.color.CAM_X0105);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56199g, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public View b() {
        return this.f56197e;
    }

    public void c(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        if ((view == this.f56198f || view == this.f56199g || view == this.f56200h) && (onClickListener = this.j) != null) {
            onClickListener.onClick(view);
        }
    }
}
