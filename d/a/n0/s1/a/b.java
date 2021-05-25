package d.a.n0.s1.a;

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
/* loaded from: classes3.dex */
public class b extends d<BubbleChooseActivity> {

    /* renamed from: a  reason: collision with root package name */
    public NavigationBar f60395a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f60396b;

    /* renamed from: c  reason: collision with root package name */
    public GridView f60397c;

    /* renamed from: d  reason: collision with root package name */
    public View f60398d;

    /* renamed from: e  reason: collision with root package name */
    public a f60399e;

    /* renamed from: f  reason: collision with root package name */
    public BubbleChooseActivity f60400f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f60401g;

    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        BubbleChooseActivity orignalPage = tbPageContext.getOrignalPage();
        this.f60400f = orignalPage;
        orignalPage.setContentView(R.layout.bubble_activity_view);
        NavigationBar navigationBar = (NavigationBar) this.f60400f.findViewById(R.id.lay_title_bar);
        this.f60395a = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60395a.setTitleText(R.string.editor_privilege);
        this.f60398d = this.f60395a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.f60400f);
        this.f60396b = (ViewGroup) this.f60400f.findViewById(R.id.container);
        this.f60397c = (GridView) this.f60400f.findViewById(R.id.gv_bubble_list);
        a aVar = new a(tbPageContext);
        this.f60399e = aVar;
        this.f60397c.setAdapter((ListAdapter) aVar);
        this.f60401g = (ProgressBar) this.f60400f.findViewById(R.id.bubble_progress);
    }

    public a d() {
        return this.f60399e;
    }

    public View e() {
        return this.f60398d;
    }

    public GridView f() {
        return this.f60397c;
    }

    public BubbleListData.BubbleData g(int i2) {
        a aVar = this.f60399e;
        if (aVar == null) {
            return null;
        }
        return aVar.getItem(i2);
    }

    public void h() {
        this.f60401g.setVisibility(8);
    }

    public void j(List<BubbleListData.BubbleData> list, boolean z) {
        a aVar = this.f60399e;
        if (aVar != null) {
            aVar.d(z);
            this.f60399e.c(list);
        }
    }

    public void k() {
        this.f60401g.setVisibility(0);
    }

    public void onChangeSkinType(int i2) {
        this.f60395a.onChangeSkinType((TbPageContext) getPageContext(), i2);
        this.f60400f.getLayoutMode().k(i2 == 1);
        this.f60400f.getLayoutMode().j(this.f60396b);
    }
}
