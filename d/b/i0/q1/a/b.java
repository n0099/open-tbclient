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
    public NavigationBar f59269a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59270b;

    /* renamed from: c  reason: collision with root package name */
    public GridView f59271c;

    /* renamed from: d  reason: collision with root package name */
    public View f59272d;

    /* renamed from: e  reason: collision with root package name */
    public a f59273e;

    /* renamed from: f  reason: collision with root package name */
    public BubbleChooseActivity f59274f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f59275g;

    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        BubbleChooseActivity orignalPage = tbPageContext.getOrignalPage();
        this.f59274f = orignalPage;
        orignalPage.setContentView(R.layout.bubble_activity_view);
        NavigationBar navigationBar = (NavigationBar) this.f59274f.findViewById(R.id.lay_title_bar);
        this.f59269a = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f59269a.setTitleText(R.string.editor_privilege);
        this.f59272d = this.f59269a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.f59274f);
        this.f59270b = (ViewGroup) this.f59274f.findViewById(R.id.container);
        this.f59271c = (GridView) this.f59274f.findViewById(R.id.gv_bubble_list);
        a aVar = new a(tbPageContext);
        this.f59273e = aVar;
        this.f59271c.setAdapter((ListAdapter) aVar);
        this.f59275g = (ProgressBar) this.f59274f.findViewById(R.id.bubble_progress);
    }

    public a d() {
        return this.f59273e;
    }

    public View e() {
        return this.f59272d;
    }

    public GridView f() {
        return this.f59271c;
    }

    public BubbleListData.BubbleData g(int i) {
        a aVar = this.f59273e;
        if (aVar == null) {
            return null;
        }
        return aVar.getItem(i);
    }

    public void h() {
        this.f59275g.setVisibility(8);
    }

    public void i(List<BubbleListData.BubbleData> list, boolean z) {
        a aVar = this.f59273e;
        if (aVar != null) {
            aVar.d(z);
            this.f59273e.c(list);
        }
    }

    public void k() {
        this.f59275g.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        this.f59269a.onChangeSkinType((TbPageContext) getPageContext(), i);
        this.f59274f.getLayoutMode().k(i == 1);
        this.f59274f.getLayoutMode().j(this.f59270b);
    }
}
