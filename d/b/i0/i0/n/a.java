package d.b.i0.i0.n;

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
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public View f56948e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f56949f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56950g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56951h;
    public int i;
    public View.OnClickListener j;

    public a(TbPageContext<?> tbPageContext) {
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.f56948e = inflate;
        this.f56949f = (FrameLayout) inflate.findViewById(R.id.create_bar_container);
        this.f56950g = (ImageView) this.f56948e.findViewById(R.id.iv_create_icon);
        this.f56951h = (TextView) this.f56948e.findViewById(R.id.create_text);
        this.i = l.g(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.f56949f.setOnClickListener(this);
        this.f56950g.setOnClickListener(this);
        this.f56951h.setOnClickListener(this);
        if (this.f56949f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.f56949f.getLayoutParams()).bottomMargin = l.g(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.f56949f.requestLayout();
        }
    }

    public void a() {
        TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0205).defaultStrokeColor(R.color.cp_cont_b_alpha42).strokeWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).radius(this.i).into(this.f56949f);
        SkinManager.setViewTextColor(this.f56951h, R.color.CAM_X0105);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56950g, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public View b() {
        return this.f56948e;
    }

    public void c(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        if ((view == this.f56949f || view == this.f56950g || view == this.f56951h) && (onClickListener = this.j) != null) {
            onClickListener.onClick(view);
        }
    }
}
