package d.b.i0.q1.a;

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
import d.b.b.a.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends d<BubbleChooseActivity> {

    /* renamed from: a  reason: collision with root package name */
    public NavigationBar f59268a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59269b;

    /* renamed from: c  reason: collision with root package name */
    public GridView f59270c;

    /* renamed from: d  reason: collision with root package name */
    public View f59271d;

    /* renamed from: e  reason: collision with root package name */
    public a f59272e;

    /* renamed from: f  reason: collision with root package name */
    public BubbleChooseActivity f59273f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f59274g;

    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        BubbleChooseActivity orignalPage = tbPageContext.getOrignalPage();
        this.f59273f = orignalPage;
        orignalPage.setContentView(R.layout.bubble_activity_view);
        NavigationBar navigationBar = (NavigationBar) this.f59273f.findViewById(R.id.lay_title_bar);
        this.f59268a = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f59268a.setTitleText(R.string.editor_privilege);
        this.f59271d = this.f59268a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.f59273f);
        this.f59269b = (ViewGroup) this.f59273f.findViewById(R.id.container);
        this.f59270c = (GridView) this.f59273f.findViewById(R.id.gv_bubble_list);
        a aVar = new a(tbPageContext);
        this.f59272e = aVar;
        this.f59270c.setAdapter((ListAdapter) aVar);
        this.f59274g = (ProgressBar) this.f59273f.findViewById(R.id.bubble_progress);
    }

    public a d() {
        return this.f59272e;
    }

    public View e() {
        return this.f59271d;
    }

    public GridView f() {
        return this.f59270c;
    }

    public BubbleListData.BubbleData g(int i) {
        a aVar = this.f59272e;
        if (aVar == null) {
            return null;
        }
        return aVar.getItem(i);
    }

    public void h() {
        this.f59274g.setVisibility(8);
    }

    public void i(List<BubbleListData.BubbleData> list, boolean z) {
        a aVar = this.f59272e;
        if (aVar != null) {
            aVar.d(z);
            this.f59272e.c(list);
        }
    }

    public void k() {
        this.f59274g.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        this.f59268a.onChangeSkinType((TbPageContext) getPageContext(), i);
        this.f59273f.getLayoutMode().k(i == 1);
        this.f59273f.getLayoutMode().j(this.f59269b);
    }
}
