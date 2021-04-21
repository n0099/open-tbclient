package d.b.j0.r1.a;

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
import d.b.c.a.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends d<BubbleChooseActivity> {

    /* renamed from: a  reason: collision with root package name */
    public NavigationBar f61384a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f61385b;

    /* renamed from: c  reason: collision with root package name */
    public GridView f61386c;

    /* renamed from: d  reason: collision with root package name */
    public View f61387d;

    /* renamed from: e  reason: collision with root package name */
    public a f61388e;

    /* renamed from: f  reason: collision with root package name */
    public BubbleChooseActivity f61389f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f61390g;

    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        BubbleChooseActivity orignalPage = tbPageContext.getOrignalPage();
        this.f61389f = orignalPage;
        orignalPage.setContentView(R.layout.bubble_activity_view);
        NavigationBar navigationBar = (NavigationBar) this.f61389f.findViewById(R.id.lay_title_bar);
        this.f61384a = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61384a.setTitleText(R.string.editor_privilege);
        this.f61387d = this.f61384a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.f61389f);
        this.f61385b = (ViewGroup) this.f61389f.findViewById(R.id.container);
        this.f61386c = (GridView) this.f61389f.findViewById(R.id.gv_bubble_list);
        a aVar = new a(tbPageContext);
        this.f61388e = aVar;
        this.f61386c.setAdapter((ListAdapter) aVar);
        this.f61390g = (ProgressBar) this.f61389f.findViewById(R.id.bubble_progress);
    }

    public a d() {
        return this.f61388e;
    }

    public View e() {
        return this.f61387d;
    }

    public GridView f() {
        return this.f61386c;
    }

    public BubbleListData.BubbleData g(int i) {
        a aVar = this.f61388e;
        if (aVar == null) {
            return null;
        }
        return aVar.getItem(i);
    }

    public void h() {
        this.f61390g.setVisibility(8);
    }

    public void i(List<BubbleListData.BubbleData> list, boolean z) {
        a aVar = this.f61388e;
        if (aVar != null) {
            aVar.d(z);
            this.f61388e.c(list);
        }
    }

    public void k() {
        this.f61390g.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        this.f61384a.onChangeSkinType((TbPageContext) getPageContext(), i);
        this.f61389f.getLayoutMode().k(i == 1);
        this.f61389f.getLayoutMode().j(this.f61385b);
    }
}
