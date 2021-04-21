package d.b.j0.j3.f.b;

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
import d.b.j0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BubbleGroupActivity f58187a;

    /* renamed from: b  reason: collision with root package name */
    public View f58188b;

    /* renamed from: c  reason: collision with root package name */
    public View f58189c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58190d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f58191e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f58192f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58193g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58194h;
    public int i;
    public d.b.j0.j3.f.b.a j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log("c10283");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleListActivityConfig(c.this.f58187a.getActivity())));
        }
    }

    public c(BubbleGroupActivity bubbleGroupActivity, d.b.j0.j3.f.a.a aVar) {
        this.i = 0;
        this.f58187a = bubbleGroupActivity;
        this.i = l.g(bubbleGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f58187a.getPageContext().getPageActivity()).inflate(R.layout.bubble_group, (ViewGroup) null);
        this.f58188b = inflate;
        this.f58187a.setContentView(inflate);
        this.f58189c = this.f58188b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f58188b.findViewById(R.id.view_navigation_bar);
        this.f58190d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58190d.setTitleText(R.string.editor_privilege);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f58188b.findViewById(R.id.view_member_recommend);
        this.f58191e = memberRecommendView;
        memberRecommendView.setFromType(6);
        this.f58192f = (BdListView) this.f58188b.findViewById(R.id.listview_group);
        TextView textView = new TextView(this.f58187a.getActivity());
        this.f58193g = textView;
        textView.setHeight(l.g(this.f58187a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f58187a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f58194h = textView2;
        textView2.setText(R.string.more_bubble);
        this.f58194h.setOnClickListener(new a());
        this.j = new d.b.j0.j3.f.b.a(this.f58187a.getPageContext(), aVar);
        TextView textView3 = new TextView(this.f58187a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f58187a.getActivity(), R.dimen.ds98)));
        this.f58192f.x(textView3, 0);
        this.f58192f.addFooterView(this.f58194h);
        this.f58192f.setAdapter((ListAdapter) this.j);
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
        SkinManager.setBackgroundColor(this.f58188b, R.color.CAM_X0204);
        this.f58187a.hideNetRefreshView(this.f58188b);
        this.f58189c.setVisibility(0);
    }

    public View d() {
        return this.f58188b;
    }

    public void e() {
        this.f58189c.setVisibility(8);
    }

    public void f() {
        d.b.j0.j3.f.b.a aVar;
        d.b.i0.s0.a.a(this.f58187a.getPageContext(), this.f58188b);
        d.b.i0.s0.a.a(this.f58187a.getPageContext(), this.f58194h);
        NavigationBar navigationBar = this.f58190d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f58187a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f58192f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
            aVar.notifyDataSetChanged();
        }
        this.f58191e.d();
        SkinManager.setBackgroundColor(this.f58193g, R.color.CAM_X0204);
    }

    public final void g(List<Object> list) {
        if (list != null && list.size() > 0) {
            this.f58192f.setVisibility(0);
            this.j.a(list);
            this.j.notifyDataSetChanged();
            return;
        }
        this.f58192f.setVisibility(8);
    }

    public final boolean h(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f58191e.setVisibility(0);
            this.f58191e.e(eVar);
            return true;
        }
        this.f58191e.setVisibility(8);
        return false;
    }

    public void i() {
        this.f58189c.setVisibility(0);
    }

    public void j() {
        this.f58189c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f58188b, R.color.CAM_X0201);
        String string = this.f58187a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f58187a.setNetRefreshViewTopMargin(this.i);
        this.f58187a.showNetRefreshView(this.f58188b, string, false);
    }

    public void k(e eVar, List<b> list, boolean z) {
        if (list != null && list.size() > 0) {
            c();
            if (h(eVar)) {
                this.f58192f.removeHeaderView(this.f58193g);
                this.f58192f.addHeaderView(this.f58193g);
            } else {
                this.f58192f.removeHeaderView(this.f58193g);
            }
            g(b(list));
            return;
        }
        j();
    }
}
