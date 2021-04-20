package d.b.i0.r1.a;

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
    public NavigationBar f60963a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f60964b;

    /* renamed from: c  reason: collision with root package name */
    public GridView f60965c;

    /* renamed from: d  reason: collision with root package name */
    public View f60966d;

    /* renamed from: e  reason: collision with root package name */
    public a f60967e;

    /* renamed from: f  reason: collision with root package name */
    public BubbleChooseActivity f60968f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f60969g;

    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        BubbleChooseActivity orignalPage = tbPageContext.getOrignalPage();
        this.f60968f = orignalPage;
        orignalPage.setContentView(R.layout.bubble_activity_view);
        NavigationBar navigationBar = (NavigationBar) this.f60968f.findViewById(R.id.lay_title_bar);
        this.f60963a = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60963a.setTitleText(R.string.editor_privilege);
        this.f60966d = this.f60963a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.f60968f);
        this.f60964b = (ViewGroup) this.f60968f.findViewById(R.id.container);
        this.f60965c = (GridView) this.f60968f.findViewById(R.id.gv_bubble_list);
        a aVar = new a(tbPageContext);
        this.f60967e = aVar;
        this.f60965c.setAdapter((ListAdapter) aVar);
        this.f60969g = (ProgressBar) this.f60968f.findViewById(R.id.bubble_progress);
    }

    public a d() {
        return this.f60967e;
    }

    public View e() {
        return this.f60966d;
    }

    public GridView f() {
        return this.f60965c;
    }

    public BubbleListData.BubbleData g(int i) {
        a aVar = this.f60967e;
        if (aVar == null) {
            return null;
        }
        return aVar.getItem(i);
    }

    public void h() {
        this.f60969g.setVisibility(8);
    }

    public void i(List<BubbleListData.BubbleData> list, boolean z) {
        a aVar = this.f60967e;
        if (aVar != null) {
            aVar.d(z);
            this.f60967e.c(list);
        }
    }

    public void k() {
        this.f60969g.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        this.f60963a.onChangeSkinType((TbPageContext) getPageContext(), i);
        this.f60968f.getLayoutMode().k(i == 1);
        this.f60968f.getLayoutMode().j(this.f60964b);
    }
}
