package d.a.j0.j3.e;

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
    public BackgroundGroupActivity f56106a;

    /* renamed from: b  reason: collision with root package name */
    public View f56107b;

    /* renamed from: c  reason: collision with root package name */
    public View f56108c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56109d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f56110e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f56111f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56112g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56113h;

    /* renamed from: i  reason: collision with root package name */
    public int f56114i;
    public d.a.j0.j3.e.a j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log("c10283");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropListActivityConfig(c.this.f56106a.getActivity())));
        }
    }

    public c(BackgroundGroupActivity backgroundGroupActivity, d dVar) {
        this.f56114i = 0;
        this.f56106a = backgroundGroupActivity;
        this.f56114i = l.g(backgroundGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f56106a.getPageContext().getPageActivity()).inflate(R.layout.background_group, (ViewGroup) null);
        this.f56107b = inflate;
        this.f56106a.setContentView(inflate);
        this.f56108c = this.f56107b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f56107b.findViewById(R.id.view_navigation_bar);
        this.f56109d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56109d.setTitleText(R.string.personal_background);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f56107b.findViewById(R.id.view_member_recommend);
        this.f56110e = memberRecommendView;
        memberRecommendView.setFromType(4);
        this.f56111f = (BdListView) this.f56107b.findViewById(R.id.listview_bg_group);
        TextView textView = new TextView(this.f56106a.getActivity());
        this.f56112g = textView;
        textView.setHeight(l.g(this.f56106a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f56106a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f56113h = textView2;
        textView2.setText(R.string.more_backgrounds);
        this.f56113h.setOnClickListener(new a());
        this.j = new d.a.j0.j3.e.a(this.f56106a.getPageContext(), dVar);
        TextView textView3 = new TextView(this.f56106a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f56106a.getActivity(), R.dimen.ds98)));
        this.f56111f.x(textView3, 0);
        this.f56111f.addFooterView(this.f56113h);
        this.f56111f.setAdapter((ListAdapter) this.j);
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
        SkinManager.setBackgroundColor(this.f56107b, R.color.CAM_X0204);
        this.f56106a.hideNetRefreshView(this.f56107b);
        this.f56108c.setVisibility(0);
    }

    public View d() {
        return this.f56107b;
    }

    public void e() {
        this.f56108c.setVisibility(8);
    }

    public void f() {
        d.a.j0.j3.e.a aVar;
        d.a.i0.s0.a.a(this.f56106a.getPageContext(), this.f56107b);
        this.f56106a.getLayoutMode().j(this.f56113h);
        d.a.i0.r.u.c.d(this.f56113h).q(R.color.CAM_X0108);
        NavigationBar navigationBar = this.f56109d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56106a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f56111f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
            aVar.notifyDataSetChanged();
        }
        SkinManager.setBackgroundColor(this.f56112g, R.color.CAM_X0204);
        this.f56110e.d();
    }

    public final void g(List<Object> list) {
        if (list != null && list.size() > 0) {
            this.f56111f.setVisibility(0);
            this.j.a(list);
            this.j.notifyDataSetChanged();
            return;
        }
        this.f56111f.setVisibility(8);
    }

    public final boolean h(d.a.j0.j3.h.e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56110e.setVisibility(0);
            this.f56110e.e(eVar);
            return true;
        }
        this.f56110e.setVisibility(8);
        return false;
    }

    public void i() {
        this.f56108c.setVisibility(0);
    }

    public void j() {
        this.f56108c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f56107b, R.color.CAM_X0201);
        String string = this.f56106a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56106a.setNetRefreshViewTopMargin(this.f56114i);
        this.f56106a.showNetRefreshView(this.f56107b, string, false);
    }

    public void k(d.a.j0.j3.h.e eVar, List<b> list, boolean z) {
        if (list != null && list.size() > 0) {
            c();
            if (h(eVar)) {
                this.f56111f.removeHeaderView(this.f56112g);
                this.f56111f.addHeaderView(this.f56112g);
            } else {
                this.f56111f.removeHeaderView(this.f56112g);
            }
            g(b(list));
            return;
        }
        j();
    }
}
