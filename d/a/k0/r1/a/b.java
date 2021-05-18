package d.a.k0.r1.a;

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
    public NavigationBar f60272a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f60273b;

    /* renamed from: c  reason: collision with root package name */
    public GridView f60274c;

    /* renamed from: d  reason: collision with root package name */
    public View f60275d;

    /* renamed from: e  reason: collision with root package name */
    public a f60276e;

    /* renamed from: f  reason: collision with root package name */
    public BubbleChooseActivity f60277f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f60278g;

    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        BubbleChooseActivity orignalPage = tbPageContext.getOrignalPage();
        this.f60277f = orignalPage;
        orignalPage.setContentView(R.layout.bubble_activity_view);
        NavigationBar navigationBar = (NavigationBar) this.f60277f.findViewById(R.id.lay_title_bar);
        this.f60272a = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60272a.setTitleText(R.string.editor_privilege);
        this.f60275d = this.f60272a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.f60277f);
        this.f60273b = (ViewGroup) this.f60277f.findViewById(R.id.container);
        this.f60274c = (GridView) this.f60277f.findViewById(R.id.gv_bubble_list);
        a aVar = new a(tbPageContext);
        this.f60276e = aVar;
        this.f60274c.setAdapter((ListAdapter) aVar);
        this.f60278g = (ProgressBar) this.f60277f.findViewById(R.id.bubble_progress);
    }

    public a d() {
        return this.f60276e;
    }

    public View e() {
        return this.f60275d;
    }

    public GridView f() {
        return this.f60274c;
    }

    public BubbleListData.BubbleData g(int i2) {
        a aVar = this.f60276e;
        if (aVar == null) {
            return null;
        }
        return aVar.getItem(i2);
    }

    public void h() {
        this.f60278g.setVisibility(8);
    }

    public void j(List<BubbleListData.BubbleData> list, boolean z) {
        a aVar = this.f60276e;
        if (aVar != null) {
            aVar.d(z);
            this.f60276e.c(list);
        }
    }

    public void k() {
        this.f60278g.setVisibility(0);
    }

    public void onChangeSkinType(int i2) {
        this.f60272a.onChangeSkinType((TbPageContext) getPageContext(), i2);
        this.f60277f.getLayoutMode().k(i2 == 1);
        this.f60277f.getLayoutMode().j(this.f60273b);
    }
}
