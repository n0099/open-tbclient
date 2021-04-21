package d.b.j0.j3.e;

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
import com.baidu.tbadk.core.atomData.PersonalBackdropListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.BackgroundGroupActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BackgroundGroupActivity f58121a;

    /* renamed from: b  reason: collision with root package name */
    public View f58122b;

    /* renamed from: c  reason: collision with root package name */
    public View f58123c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58124d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f58125e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f58126f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58127g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58128h;
    public int i;
    public d.b.j0.j3.e.a j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log("c10283");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropListActivityConfig(c.this.f58121a.getActivity())));
        }
    }

    public c(BackgroundGroupActivity backgroundGroupActivity, d dVar) {
        this.i = 0;
        this.f58121a = backgroundGroupActivity;
        this.i = l.g(backgroundGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f58121a.getPageContext().getPageActivity()).inflate(R.layout.background_group, (ViewGroup) null);
        this.f58122b = inflate;
        this.f58121a.setContentView(inflate);
        this.f58123c = this.f58122b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f58122b.findViewById(R.id.view_navigation_bar);
        this.f58124d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58124d.setTitleText(R.string.personal_background);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f58122b.findViewById(R.id.view_member_recommend);
        this.f58125e = memberRecommendView;
        memberRecommendView.setFromType(4);
        this.f58126f = (BdListView) this.f58122b.findViewById(R.id.listview_bg_group);
        TextView textView = new TextView(this.f58121a.getActivity());
        this.f58127g = textView;
        textView.setHeight(l.g(this.f58121a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f58121a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f58128h = textView2;
        textView2.setText(R.string.more_backgrounds);
        this.f58128h.setOnClickListener(new a());
        this.j = new d.b.j0.j3.e.a(this.f58121a.getPageContext(), dVar);
        TextView textView3 = new TextView(this.f58121a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f58121a.getActivity(), R.dimen.ds98)));
        this.f58126f.x(textView3, 0);
        this.f58126f.addFooterView(this.f58128h);
        this.f58126f.setAdapter((ListAdapter) this.j);
    }

    public final List<Object> b(List<b> list) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            arrayList.add(bVar.b());
            List<DressItemData> a2 = bVar.a();
            int size = a2.size();
            if (size > 3) {
                size = 3;
            }
            for (int i = 0; i < size; i = i + 2 + 1) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < 3; i2++) {
                    int i3 = i + i2;
                    if (i3 < size) {
                        arrayList2.add(a2.get(i3));
                    }
                }
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public void c() {
        SkinManager.setBackgroundColor(this.f58122b, R.color.CAM_X0204);
        this.f58121a.hideNetRefreshView(this.f58122b);
        this.f58123c.setVisibility(0);
    }

    public View d() {
        return this.f58122b;
    }

    public void e() {
        this.f58123c.setVisibility(8);
    }

    public void f() {
        d.b.j0.j3.e.a aVar;
        d.b.i0.s0.a.a(this.f58121a.getPageContext(), this.f58122b);
        this.f58121a.getLayoutMode().j(this.f58128h);
        d.b.i0.r.u.c.d(this.f58128h).q(R.color.CAM_X0108);
        NavigationBar navigationBar = this.f58124d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f58121a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f58126f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
            aVar.notifyDataSetChanged();
        }
        SkinManager.setBackgroundColor(this.f58127g, R.color.CAM_X0204);
        this.f58125e.d();
    }

    public final void g(List<Object> list) {
        if (list != null && list.size() > 0) {
            this.f58126f.setVisibility(0);
            this.j.a(list);
            this.j.notifyDataSetChanged();
            return;
        }
        this.f58126f.setVisibility(8);
    }

    public final boolean h(d.b.j0.j3.h.e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f58125e.setVisibility(0);
            this.f58125e.e(eVar);
            return true;
        }
        this.f58125e.setVisibility(8);
        return false;
    }

    public void i() {
        this.f58123c.setVisibility(0);
    }

    public void j() {
        this.f58123c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f58122b, R.color.CAM_X0201);
        String string = this.f58121a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f58121a.setNetRefreshViewTopMargin(this.i);
        this.f58121a.showNetRefreshView(this.f58122b, string, false);
    }

    public void k(d.b.j0.j3.h.e eVar, List<b> list, boolean z) {
        if (list != null && list.size() > 0) {
            c();
            if (h(eVar)) {
                this.f58126f.removeHeaderView(this.f58127g);
                this.f58126f.addHeaderView(this.f58127g);
            } else {
                this.f58126f.removeHeaderView(this.f58127g);
            }
            g(b(list));
            return;
        }
        j();
    }
}
