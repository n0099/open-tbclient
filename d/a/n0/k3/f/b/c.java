package d.a.n0.k3.f.b;

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
import d.a.c.e.p.l;
import d.a.n0.k3.h.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BubbleGroupActivity f60752a;

    /* renamed from: b  reason: collision with root package name */
    public View f60753b;

    /* renamed from: c  reason: collision with root package name */
    public View f60754c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f60755d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f60756e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f60757f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60758g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60759h;

    /* renamed from: i  reason: collision with root package name */
    public int f60760i;
    public d.a.n0.k3.f.b.a j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log("c10283");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleListActivityConfig(c.this.f60752a.getActivity())));
        }
    }

    public c(BubbleGroupActivity bubbleGroupActivity, d.a.n0.k3.f.a.a aVar) {
        this.f60760i = 0;
        this.f60752a = bubbleGroupActivity;
        this.f60760i = l.g(bubbleGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f60752a.getPageContext().getPageActivity()).inflate(R.layout.bubble_group, (ViewGroup) null);
        this.f60753b = inflate;
        this.f60752a.setContentView(inflate);
        this.f60754c = this.f60753b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f60753b.findViewById(R.id.view_navigation_bar);
        this.f60755d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60755d.setTitleText(R.string.editor_privilege);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f60753b.findViewById(R.id.view_member_recommend);
        this.f60756e = memberRecommendView;
        memberRecommendView.setFromType(6);
        this.f60757f = (BdListView) this.f60753b.findViewById(R.id.listview_group);
        TextView textView = new TextView(this.f60752a.getActivity());
        this.f60758g = textView;
        textView.setHeight(l.g(this.f60752a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f60752a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f60759h = textView2;
        textView2.setText(R.string.more_bubble);
        this.f60759h.setOnClickListener(new a());
        this.j = new d.a.n0.k3.f.b.a(this.f60752a.getPageContext(), aVar);
        TextView textView3 = new TextView(this.f60752a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f60752a.getActivity(), R.dimen.ds98)));
        this.f60757f.x(textView3, 0);
        this.f60757f.addFooterView(this.f60759h);
        this.f60757f.setAdapter((ListAdapter) this.j);
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
                for (int i2 = 0; i2 < size; i2 = i2 + 1 + 1) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < 2; i3++) {
                        int i4 = i2 + i3;
                        if (i4 < size) {
                            arrayList2.add(a2.get(i4));
                        }
                    }
                    arrayList.add(arrayList2);
                }
            }
        }
        return arrayList;
    }

    public void c() {
        SkinManager.setBackgroundColor(this.f60753b, R.color.CAM_X0204);
        this.f60752a.hideNetRefreshView(this.f60753b);
        this.f60754c.setVisibility(0);
    }

    public View d() {
        return this.f60753b;
    }

    public void e() {
        this.f60754c.setVisibility(8);
    }

    public void f() {
        d.a.n0.k3.f.b.a aVar;
        d.a.m0.s0.a.a(this.f60752a.getPageContext(), this.f60753b);
        d.a.m0.s0.a.a(this.f60752a.getPageContext(), this.f60759h);
        NavigationBar navigationBar = this.f60755d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60752a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f60757f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
            aVar.notifyDataSetChanged();
        }
        this.f60756e.d();
        SkinManager.setBackgroundColor(this.f60758g, R.color.CAM_X0204);
    }

    public final void g(List<Object> list) {
        if (list != null && list.size() > 0) {
            this.f60757f.setVisibility(0);
            this.j.a(list);
            this.j.notifyDataSetChanged();
            return;
        }
        this.f60757f.setVisibility(8);
    }

    public final boolean h(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f60756e.setVisibility(0);
            this.f60756e.e(eVar);
            return true;
        }
        this.f60756e.setVisibility(8);
        return false;
    }

    public void i() {
        this.f60754c.setVisibility(0);
    }

    public void j() {
        this.f60754c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f60753b, R.color.CAM_X0201);
        String string = this.f60752a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f60752a.setNetRefreshViewTopMargin(this.f60760i);
        this.f60752a.showNetRefreshView(this.f60753b, string, false);
    }

    public void k(e eVar, List<b> list, boolean z) {
        if (list != null && list.size() > 0) {
            c();
            if (h(eVar)) {
                this.f60757f.removeHeaderView(this.f60758g);
                this.f60757f.addHeaderView(this.f60758g);
            } else {
                this.f60757f.removeHeaderView(this.f60758g);
            }
            g(b(list));
            return;
        }
        j();
    }
}
