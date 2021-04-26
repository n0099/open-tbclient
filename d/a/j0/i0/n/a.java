package d.a.j0.i0.n;

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
    public View f55306e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f55307f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f55308g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55309h;

    /* renamed from: i  reason: collision with root package name */
    public int f55310i;
    public View.OnClickListener j;

    public a(TbPageContext<?> tbPageContext) {
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.f55306e = inflate;
        this.f55307f = (FrameLayout) inflate.findViewById(R.id.create_bar_container);
        this.f55308g = (ImageView) this.f55306e.findViewById(R.id.iv_create_icon);
        this.f55309h = (TextView) this.f55306e.findViewById(R.id.create_text);
        this.f55310i = l.g(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.f55307f.setOnClickListener(this);
        this.f55308g.setOnClickListener(this);
        this.f55309h.setOnClickListener(this);
        if (this.f55307f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.f55307f.getLayoutParams()).bottomMargin = l.g(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.f55307f.requestLayout();
        }
    }

    public void a() {
        TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0205).defaultStrokeColor(R.color.cp_cont_b_alpha42).strokeWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).radius(this.f55310i).into(this.f55307f);
        SkinManager.setViewTextColor(this.f55309h, R.color.CAM_X0105);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55308g, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public View b() {
        return this.f55306e;
    }

    public void c(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        if ((view == this.f55307f || view == this.f55308g || view == this.f55309h) && (onClickListener = this.j) != null) {
            onClickListener.onClick(view);
        }
    }
}
