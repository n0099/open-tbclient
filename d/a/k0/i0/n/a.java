package d.a.k0.i0.n;

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
    public View f56013e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f56014f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56015g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56016h;

    /* renamed from: i  reason: collision with root package name */
    public int f56017i;
    public View.OnClickListener j;

    public a(TbPageContext<?> tbPageContext) {
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.f56013e = inflate;
        this.f56014f = (FrameLayout) inflate.findViewById(R.id.create_bar_container);
        this.f56015g = (ImageView) this.f56013e.findViewById(R.id.iv_create_icon);
        this.f56016h = (TextView) this.f56013e.findViewById(R.id.create_text);
        this.f56017i = l.g(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.f56014f.setOnClickListener(this);
        this.f56015g.setOnClickListener(this);
        this.f56016h.setOnClickListener(this);
        if (this.f56014f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.f56014f.getLayoutParams()).bottomMargin = l.g(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.f56014f.requestLayout();
        }
    }

    public void a() {
        TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0205).defaultStrokeColor(R.color.cp_cont_b_alpha42).strokeWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).radius(this.f56017i).into(this.f56014f);
        SkinManager.setViewTextColor(this.f56016h, R.color.CAM_X0105);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56015g, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public View b() {
        return this.f56013e;
    }

    public void c(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        if ((view == this.f56014f || view == this.f56015g || view == this.f56016h) && (onClickListener = this.j) != null) {
            onClickListener.onClick(view);
        }
    }
}
