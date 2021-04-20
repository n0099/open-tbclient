package d.b.i0.j3.f.b;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.BubbleListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.group.BubbleGroupActivity;
import d.b.c.e.p.l;
import d.b.i0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BubbleGroupActivity f57766a;

    /* renamed from: b  reason: collision with root package name */
    public View f57767b;

    /* renamed from: c  reason: collision with root package name */
    public View f57768c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57769d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f57770e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f57771f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57772g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57773h;
    public int i;
    public d.b.i0.j3.f.b.a j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log("c10283");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleListActivityConfig(c.this.f57766a.getActivity())));
        }
    }

    public c(BubbleGroupActivity bubbleGroupActivity, d.b.i0.j3.f.a.a aVar) {
        this.i = 0;
        this.f57766a = bubbleGroupActivity;
        this.i = l.g(bubbleGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f57766a.getPageContext().getPageActivity()).inflate(R.layout.bubble_group, (ViewGroup) null);
        this.f57767b = inflate;
        this.f57766a.setContentView(inflate);
        this.f57768c = this.f57767b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f57767b.findViewById(R.id.view_navigation_bar);
        this.f57769d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57769d.setTitleText(R.string.editor_privilege);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f57767b.findViewById(R.id.view_member_recommend);
        this.f57770e = memberRecommendView;
        memberRecommendView.setFromType(6);
        this.f57771f = (BdListView) this.f57767b.findViewById(R.id.listview_group);
        TextView textView = new TextView(this.f57766a.getActivity());
        this.f57772g = textView;
        textView.setHeight(l.g(this.f57766a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f57766a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f57773h = textView2;
        textView2.setText(R.string.more_bubble);
        this.f57773h.setOnClickListener(new a());
        this.j = new d.b.i0.j3.f.b.a(this.f57766a.getPageContext(), aVar);
        TextView textView3 = new TextView(this.f57766a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f57766a.getActivity(), R.dimen.ds98)));
        this.f57771f.x(textView3, 0);
        this.f57771f.addFooterView(this.f57773h);
        this.f57771f.setAdapter((ListAdapter) this.j);
    }

    public final List<Object> b(List<b> list) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            List<DressItemData> a2 = bVar.a();
            int size = a2.size();
            if (size != 0) {
                arrayList.add(bVar.b());
                if (size > 4) {
                    size = 4;
                }
                for (int i = 0; i < size; i = i + 1 + 1) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < 2; i2++) {
                        int i3 = i + i2;
                        if (i3 < size) {
                            arrayList2.add(a2.get(i3));
                        }
                    }
                    arrayList.add(arrayList2);
                }
            }
        }
        return arrayList;
    }

    public void c() {
        SkinManager.setBackgroundColor(this.f57767b, R.color.CAM_X0204);
        this.f57766a.hideNetRefreshView(this.f57767b);
        this.f57768c.setVisibility(0);
    }

    public View d() {
        return this.f57767b;
    }

    public void e() {
        this.f57768c.setVisibility(8);
    }

    public void f() {
        d.b.i0.j3.f.b.a aVar;
        d.b.h0.s0.a.a(this.f57766a.getPageContext(), this.f57767b);
        d.b.h0.s0.a.a(this.f57766a.getPageContext(), this.f57773h);
        NavigationBar navigationBar = this.f57769d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f57766a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f57771f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
            aVar.notifyDataSetChanged();
        }
        this.f57770e.d();
        SkinManager.setBackgroundColor(this.f57772g, R.color.CAM_X0204);
    }

    public final void g(List<Object> list) {
        if (list != null && list.size() > 0) {
            this.f57771f.setVisibility(0);
            this.j.a(list);
            this.j.notifyDataSetChanged();
            return;
        }
        this.f57771f.setVisibility(8);
    }

    public final boolean h(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f57770e.setVisibility(0);
            this.f57770e.e(eVar);
            return true;
        }
        this.f57770e.setVisibility(8);
        return false;
    }

    public void i() {
        this.f57768c.setVisibility(0);
    }

    public void j() {
        this.f57768c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f57767b, R.color.CAM_X0201);
        String string = this.f57766a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f57766a.setNetRefreshViewTopMargin(this.i);
        this.f57766a.showNetRefreshView(this.f57767b, string, false);
    }

    public void k(e eVar, List<b> list, boolean z) {
        if (list != null && list.size() > 0) {
            c();
            if (h(eVar)) {
                this.f57771f.removeHeaderView(this.f57772g);
                this.f57771f.addHeaderView(this.f57772g);
            } else {
                this.f57771f.removeHeaderView(this.f57772g);
            }
            g(b(list));
            return;
        }
        j();
    }
}
