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
    public View f59886e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f59887f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59888g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59889h;

    /* renamed from: i  reason: collision with root package name */
    public int f59890i;
    public View.OnClickListener j;

    public a(TbPageContext<?> tbPageContext) {
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.f59886e = inflate;
        this.f59887f = (FrameLayout) inflate.findViewById(R.id.create_bar_container);
        this.f59888g = (ImageView) this.f59886e.findViewById(R.id.iv_create_icon);
        this.f59889h = (TextView) this.f59886e.findViewById(R.id.create_text);
        this.f59890i = l.g(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.f59887f.setOnClickListener(this);
        this.f59888g.setOnClickListener(this);
        this.f59889h.setOnClickListener(this);
        if (this.f59887f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.f59887f.getLayoutParams()).bottomMargin = l.g(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.f59887f.requestLayout();
        }
    }

    public void a() {
        TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0205).defaultStrokeColor(R.color.cp_cont_b_alpha42).strokeWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).radius(this.f59890i).into(this.f59887f);
        SkinManager.setViewTextColor(this.f59889h, R.color.CAM_X0105);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59888g, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public View b() {
        return this.f59886e;
    }

    public void c(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        if ((view == this.f59887f || view == this.f59888g || view == this.f59889h) && (onClickListener = this.j) != null) {
            onClickListener.onClick(view);
        }
    }
}
