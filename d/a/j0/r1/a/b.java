package d.a.j0.r1.a;

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
    public NavigationBar f59527a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59528b;

    /* renamed from: c  reason: collision with root package name */
    public GridView f59529c;

    /* renamed from: d  reason: collision with root package name */
    public View f59530d;

    /* renamed from: e  reason: collision with root package name */
    public a f59531e;

    /* renamed from: f  reason: collision with root package name */
    public BubbleChooseActivity f59532f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f59533g;

    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        BubbleChooseActivity orignalPage = tbPageContext.getOrignalPage();
        this.f59532f = orignalPage;
        orignalPage.setContentView(R.layout.bubble_activity_view);
        NavigationBar navigationBar = (NavigationBar) this.f59532f.findViewById(R.id.lay_title_bar);
        this.f59527a = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f59527a.setTitleText(R.string.editor_privilege);
        this.f59530d = this.f59527a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.f59532f);
        this.f59528b = (ViewGroup) this.f59532f.findViewById(R.id.container);
        this.f59529c = (GridView) this.f59532f.findViewById(R.id.gv_bubble_list);
        a aVar = new a(tbPageContext);
        this.f59531e = aVar;
        this.f59529c.setAdapter((ListAdapter) aVar);
        this.f59533g = (ProgressBar) this.f59532f.findViewById(R.id.bubble_progress);
    }

    public a d() {
        return this.f59531e;
    }

    public View e() {
        return this.f59530d;
    }

    public GridView f() {
        return this.f59529c;
    }

    public BubbleListData.BubbleData g(int i2) {
        a aVar = this.f59531e;
        if (aVar == null) {
            return null;
        }
        return aVar.getItem(i2);
    }

    public void h() {
        this.f59533g.setVisibility(8);
    }

    public void j(List<BubbleListData.BubbleData> list, boolean z) {
        a aVar = this.f59531e;
        if (aVar != null) {
            aVar.d(z);
            this.f59531e.c(list);
        }
    }

    public void k() {
        this.f59533g.setVisibility(0);
    }

    public void onChangeSkinType(int i2) {
        this.f59527a.onChangeSkinType((TbPageContext) getPageContext(), i2);
        this.f59532f.getLayoutMode().k(i2 == 1);
        this.f59532f.getLayoutMode().j(this.f59528b);
    }
}
