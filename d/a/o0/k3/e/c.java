package d.a.o0.k3.e;

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
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BackgroundGroupActivity f60807a;

    /* renamed from: b  reason: collision with root package name */
    public View f60808b;

    /* renamed from: c  reason: collision with root package name */
    public View f60809c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f60810d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f60811e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f60812f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60813g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60814h;

    /* renamed from: i  reason: collision with root package name */
    public int f60815i;
    public d.a.o0.k3.e.a j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log("c10283");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropListActivityConfig(c.this.f60807a.getActivity())));
        }
    }

    public c(BackgroundGroupActivity backgroundGroupActivity, d dVar) {
        this.f60815i = 0;
        this.f60807a = backgroundGroupActivity;
        this.f60815i = l.g(backgroundGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f60807a.getPageContext().getPageActivity()).inflate(R.layout.background_group, (ViewGroup) null);
        this.f60808b = inflate;
        this.f60807a.setContentView(inflate);
        this.f60809c = this.f60808b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f60808b.findViewById(R.id.view_navigation_bar);
        this.f60810d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60810d.setTitleText(R.string.personal_background);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f60808b.findViewById(R.id.view_member_recommend);
        this.f60811e = memberRecommendView;
        memberRecommendView.setFromType(4);
        this.f60812f = (BdListView) this.f60808b.findViewById(R.id.listview_bg_group);
        TextView textView = new TextView(this.f60807a.getActivity());
        this.f60813g = textView;
        textView.setHeight(l.g(this.f60807a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f60807a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f60814h = textView2;
        textView2.setText(R.string.more_backgrounds);
        this.f60814h.setOnClickListener(new a());
        this.j = new d.a.o0.k3.e.a(this.f60807a.getPageContext(), dVar);
        TextView textView3 = new TextView(this.f60807a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f60807a.getActivity(), R.dimen.ds98)));
        this.f60812f.x(textView3, 0);
        this.f60812f.addFooterView(this.f60814h);
        this.f60812f.setAdapter((ListAdapter) this.j);
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
            for (int i2 = 0; i2 < size; i2 = i2 + 2 + 1) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < 3; i3++) {
                    int i4 = i2 + i3;
                    if (i4 < size) {
                        arrayList2.add(a2.get(i4));
                    }
                }
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public void c() {
        SkinManager.setBackgroundColor(this.f60808b, R.color.CAM_X0204);
        this.f60807a.hideNetRefreshView(this.f60808b);
        this.f60809c.setVisibility(0);
    }

    public View d() {
        return this.f60808b;
    }

    public void e() {
        this.f60809c.setVisibility(8);
    }

    public void f() {
        d.a.o0.k3.e.a aVar;
        d.a.n0.s0.a.a(this.f60807a.getPageContext(), this.f60808b);
        this.f60807a.getLayoutMode().j(this.f60814h);
        d.a.n0.r.u.c.d(this.f60814h).s(R.color.CAM_X0108);
        NavigationBar navigationBar = this.f60810d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60807a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f60812f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
            aVar.notifyDataSetChanged();
        }
        SkinManager.setBackgroundColor(this.f60813g, R.color.CAM_X0204);
        this.f60811e.d();
    }

    public final void g(List<Object> list) {
        if (list != null && list.size() > 0) {
            this.f60812f.setVisibility(0);
            this.j.a(list);
            this.j.notifyDataSetChanged();
            return;
        }
        this.f60812f.setVisibility(8);
    }

    public final boolean h(d.a.o0.k3.h.e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f60811e.setVisibility(0);
            this.f60811e.e(eVar);
            return true;
        }
        this.f60811e.setVisibility(8);
        return false;
    }

    public void i() {
        this.f60809c.setVisibility(0);
    }

    public void j() {
        this.f60809c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f60808b, R.color.CAM_X0201);
        String string = this.f60807a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f60807a.setNetRefreshViewTopMargin(this.f60815i);
        this.f60807a.showNetRefreshView(this.f60808b, string, false);
    }

    public void k(d.a.o0.k3.h.e eVar, List<b> list, boolean z) {
        if (list != null && list.size() > 0) {
            c();
            if (h(eVar)) {
                this.f60812f.removeHeaderView(this.f60813g);
                this.f60812f.addHeaderView(this.f60813g);
            } else {
                this.f60812f.removeHeaderView(this.f60813g);
            }
            g(b(list));
            return;
        }
        j();
    }
}
