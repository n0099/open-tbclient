package d.a.o0.s1.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import d.a.c.a.d;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends d<BubbleChooseActivity> {

    /* renamed from: a  reason: collision with root package name */
    public NavigationBar f64211a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f64212b;

    /* renamed from: c  reason: collision with root package name */
    public GridView f64213c;

    /* renamed from: d  reason: collision with root package name */
    public View f64214d;

    /* renamed from: e  reason: collision with root package name */
    public a f64215e;

    /* renamed from: f  reason: collision with root package name */
    public BubbleChooseActivity f64216f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f64217g;

    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        BubbleChooseActivity orignalPage = tbPageContext.getOrignalPage();
        this.f64216f = orignalPage;
        orignalPage.setContentView(R.layout.bubble_activity_view);
        NavigationBar navigationBar = (NavigationBar) this.f64216f.findViewById(R.id.lay_title_bar);
        this.f64211a = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f64211a.setTitleText(R.string.editor_privilege);
        this.f64214d = this.f64211a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.f64216f);
        this.f64212b = (ViewGroup) this.f64216f.findViewById(R.id.container);
        this.f64213c = (GridView) this.f64216f.findViewById(R.id.gv_bubble_list);
        a aVar = new a(tbPageContext);
        this.f64215e = aVar;
        this.f64213c.setAdapter((ListAdapter) aVar);
        this.f64217g = (ProgressBar) this.f64216f.findViewById(R.id.bubble_progress);
    }

    public a d() {
        return this.f64215e;
    }

    public View e() {
        return this.f64214d;
    }

    public GridView f() {
        return this.f64213c;
    }

    public BubbleListData.BubbleData g(int i2) {
        a aVar = this.f64215e;
        if (aVar == null) {
            return null;
        }
        return aVar.getItem(i2);
    }

    public void h() {
        this.f64217g.setVisibility(8);
    }

    public void i(List<BubbleListData.BubbleData> list, boolean z) {
        a aVar = this.f64215e;
        if (aVar != null) {
            aVar.d(z);
            this.f64215e.c(list);
        }
    }

    public void k() {
        this.f64217g.setVisibility(0);
    }

    public void onChangeSkinType(int i2) {
        this.f64211a.onChangeSkinType((TbPageContext) getPageContext(), i2);
        this.f64216f.getLayoutMode().k(i2 == 1);
        this.f64216f.getLayoutMode().j(this.f64212b);
    }
}
