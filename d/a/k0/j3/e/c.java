package d.a.k0.j3.e;

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
    public BackgroundGroupActivity f56813a;

    /* renamed from: b  reason: collision with root package name */
    public View f56814b;

    /* renamed from: c  reason: collision with root package name */
    public View f56815c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56816d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f56817e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f56818f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56819g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56820h;

    /* renamed from: i  reason: collision with root package name */
    public int f56821i;
    public d.a.k0.j3.e.a j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log("c10283");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropListActivityConfig(c.this.f56813a.getActivity())));
        }
    }

    public c(BackgroundGroupActivity backgroundGroupActivity, d dVar) {
        this.f56821i = 0;
        this.f56813a = backgroundGroupActivity;
        this.f56821i = l.g(backgroundGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f56813a.getPageContext().getPageActivity()).inflate(R.layout.background_group, (ViewGroup) null);
        this.f56814b = inflate;
        this.f56813a.setContentView(inflate);
        this.f56815c = this.f56814b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f56814b.findViewById(R.id.view_navigation_bar);
        this.f56816d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56816d.setTitleText(R.string.personal_background);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f56814b.findViewById(R.id.view_member_recommend);
        this.f56817e = memberRecommendView;
        memberRecommendView.setFromType(4);
        this.f56818f = (BdListView) this.f56814b.findViewById(R.id.listview_bg_group);
        TextView textView = new TextView(this.f56813a.getActivity());
        this.f56819g = textView;
        textView.setHeight(l.g(this.f56813a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f56813a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f56820h = textView2;
        textView2.setText(R.string.more_backgrounds);
        this.f56820h.setOnClickListener(new a());
        this.j = new d.a.k0.j3.e.a(this.f56813a.getPageContext(), dVar);
        TextView textView3 = new TextView(this.f56813a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f56813a.getActivity(), R.dimen.ds98)));
        this.f56818f.x(textView3, 0);
        this.f56818f.addFooterView(this.f56820h);
        this.f56818f.setAdapter((ListAdapter) this.j);
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
        SkinManager.setBackgroundColor(this.f56814b, R.color.CAM_X0204);
        this.f56813a.hideNetRefreshView(this.f56814b);
        this.f56815c.setVisibility(0);
    }

    public View d() {
        return this.f56814b;
    }

    public void e() {
        this.f56815c.setVisibility(8);
    }

    public void f() {
        d.a.k0.j3.e.a aVar;
        d.a.j0.s0.a.a(this.f56813a.getPageContext(), this.f56814b);
        this.f56813a.getLayoutMode().j(this.f56820h);
        d.a.j0.r.u.c.d(this.f56820h).q(R.color.CAM_X0108);
        NavigationBar navigationBar = this.f56816d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56813a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f56818f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
            aVar.notifyDataSetChanged();
        }
        SkinManager.setBackgroundColor(this.f56819g, R.color.CAM_X0204);
        this.f56817e.d();
    }

    public final void g(List<Object> list) {
        if (list != null && list.size() > 0) {
            this.f56818f.setVisibility(0);
            this.j.a(list);
            this.j.notifyDataSetChanged();
            return;
        }
        this.f56818f.setVisibility(8);
    }

    public final boolean h(d.a.k0.j3.h.e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56817e.setVisibility(0);
            this.f56817e.e(eVar);
            return true;
        }
        this.f56817e.setVisibility(8);
        return false;
    }

    public void i() {
        this.f56815c.setVisibility(0);
    }

    public void j() {
        this.f56815c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f56814b, R.color.CAM_X0201);
        String string = this.f56813a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56813a.setNetRefreshViewTopMargin(this.f56821i);
        this.f56813a.showNetRefreshView(this.f56814b, string, false);
    }

    public void k(d.a.k0.j3.h.e eVar, List<b> list, boolean z) {
        if (list != null && list.size() > 0) {
            c();
            if (h(eVar)) {
                this.f56818f.removeHeaderView(this.f56819g);
                this.f56818f.addHeaderView(this.f56819g);
            } else {
                this.f56818f.removeHeaderView(this.f56819g);
            }
            g(b(list));
            return;
        }
        j();
    }
}
