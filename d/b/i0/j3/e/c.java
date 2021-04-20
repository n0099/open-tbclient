package d.b.i0.j3.e;

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
    public BackgroundGroupActivity f57700a;

    /* renamed from: b  reason: collision with root package name */
    public View f57701b;

    /* renamed from: c  reason: collision with root package name */
    public View f57702c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57703d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f57704e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f57705f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57706g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57707h;
    public int i;
    public d.b.i0.j3.e.a j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log("c10283");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropListActivityConfig(c.this.f57700a.getActivity())));
        }
    }

    public c(BackgroundGroupActivity backgroundGroupActivity, d dVar) {
        this.i = 0;
        this.f57700a = backgroundGroupActivity;
        this.i = l.g(backgroundGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f57700a.getPageContext().getPageActivity()).inflate(R.layout.background_group, (ViewGroup) null);
        this.f57701b = inflate;
        this.f57700a.setContentView(inflate);
        this.f57702c = this.f57701b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f57701b.findViewById(R.id.view_navigation_bar);
        this.f57703d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57703d.setTitleText(R.string.personal_background);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f57701b.findViewById(R.id.view_member_recommend);
        this.f57704e = memberRecommendView;
        memberRecommendView.setFromType(4);
        this.f57705f = (BdListView) this.f57701b.findViewById(R.id.listview_bg_group);
        TextView textView = new TextView(this.f57700a.getActivity());
        this.f57706g = textView;
        textView.setHeight(l.g(this.f57700a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f57700a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f57707h = textView2;
        textView2.setText(R.string.more_backgrounds);
        this.f57707h.setOnClickListener(new a());
        this.j = new d.b.i0.j3.e.a(this.f57700a.getPageContext(), dVar);
        TextView textView3 = new TextView(this.f57700a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f57700a.getActivity(), R.dimen.ds98)));
        this.f57705f.x(textView3, 0);
        this.f57705f.addFooterView(this.f57707h);
        this.f57705f.setAdapter((ListAdapter) this.j);
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
        SkinManager.setBackgroundColor(this.f57701b, R.color.CAM_X0204);
        this.f57700a.hideNetRefreshView(this.f57701b);
        this.f57702c.setVisibility(0);
    }

    public View d() {
        return this.f57701b;
    }

    public void e() {
        this.f57702c.setVisibility(8);
    }

    public void f() {
        d.b.i0.j3.e.a aVar;
        d.b.h0.s0.a.a(this.f57700a.getPageContext(), this.f57701b);
        this.f57700a.getLayoutMode().j(this.f57707h);
        d.b.h0.r.u.c.d(this.f57707h).q(R.color.CAM_X0108);
        NavigationBar navigationBar = this.f57703d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f57700a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f57705f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
            aVar.notifyDataSetChanged();
        }
        SkinManager.setBackgroundColor(this.f57706g, R.color.CAM_X0204);
        this.f57704e.d();
    }

    public final void g(List<Object> list) {
        if (list != null && list.size() > 0) {
            this.f57705f.setVisibility(0);
            this.j.a(list);
            this.j.notifyDataSetChanged();
            return;
        }
        this.f57705f.setVisibility(8);
    }

    public final boolean h(d.b.i0.j3.h.e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f57704e.setVisibility(0);
            this.f57704e.e(eVar);
            return true;
        }
        this.f57704e.setVisibility(8);
        return false;
    }

    public void i() {
        this.f57702c.setVisibility(0);
    }

    public void j() {
        this.f57702c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f57701b, R.color.CAM_X0201);
        String string = this.f57700a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f57700a.setNetRefreshViewTopMargin(this.i);
        this.f57700a.showNetRefreshView(this.f57701b, string, false);
    }

    public void k(d.b.i0.j3.h.e eVar, List<b> list, boolean z) {
        if (list != null && list.size() > 0) {
            c();
            if (h(eVar)) {
                this.f57705f.removeHeaderView(this.f57706g);
                this.f57705f.addHeaderView(this.f57706g);
            } else {
                this.f57705f.removeHeaderView(this.f57706g);
            }
            g(b(list));
            return;
        }
        j();
    }
}
