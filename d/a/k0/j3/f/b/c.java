package d.a.k0.j3.f.b;

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
import d.a.k0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BubbleGroupActivity f56883a;

    /* renamed from: b  reason: collision with root package name */
    public View f56884b;

    /* renamed from: c  reason: collision with root package name */
    public View f56885c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56886d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f56887e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f56888f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56889g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56890h;

    /* renamed from: i  reason: collision with root package name */
    public int f56891i;
    public d.a.k0.j3.f.b.a j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log("c10283");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleListActivityConfig(c.this.f56883a.getActivity())));
        }
    }

    public c(BubbleGroupActivity bubbleGroupActivity, d.a.k0.j3.f.a.a aVar) {
        this.f56891i = 0;
        this.f56883a = bubbleGroupActivity;
        this.f56891i = l.g(bubbleGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f56883a.getPageContext().getPageActivity()).inflate(R.layout.bubble_group, (ViewGroup) null);
        this.f56884b = inflate;
        this.f56883a.setContentView(inflate);
        this.f56885c = this.f56884b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f56884b.findViewById(R.id.view_navigation_bar);
        this.f56886d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56886d.setTitleText(R.string.editor_privilege);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f56884b.findViewById(R.id.view_member_recommend);
        this.f56887e = memberRecommendView;
        memberRecommendView.setFromType(6);
        this.f56888f = (BdListView) this.f56884b.findViewById(R.id.listview_group);
        TextView textView = new TextView(this.f56883a.getActivity());
        this.f56889g = textView;
        textView.setHeight(l.g(this.f56883a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f56883a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f56890h = textView2;
        textView2.setText(R.string.more_bubble);
        this.f56890h.setOnClickListener(new a());
        this.j = new d.a.k0.j3.f.b.a(this.f56883a.getPageContext(), aVar);
        TextView textView3 = new TextView(this.f56883a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f56883a.getActivity(), R.dimen.ds98)));
        this.f56888f.x(textView3, 0);
        this.f56888f.addFooterView(this.f56890h);
        this.f56888f.setAdapter((ListAdapter) this.j);
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
        SkinManager.setBackgroundColor(this.f56884b, R.color.CAM_X0204);
        this.f56883a.hideNetRefreshView(this.f56884b);
        this.f56885c.setVisibility(0);
    }

    public View d() {
        return this.f56884b;
    }

    public void e() {
        this.f56885c.setVisibility(8);
    }

    public void f() {
        d.a.k0.j3.f.b.a aVar;
        d.a.j0.s0.a.a(this.f56883a.getPageContext(), this.f56884b);
        d.a.j0.s0.a.a(this.f56883a.getPageContext(), this.f56890h);
        NavigationBar navigationBar = this.f56886d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56883a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f56888f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
            aVar.notifyDataSetChanged();
        }
        this.f56887e.d();
        SkinManager.setBackgroundColor(this.f56889g, R.color.CAM_X0204);
    }

    public final void g(List<Object> list) {
        if (list != null && list.size() > 0) {
            this.f56888f.setVisibility(0);
            this.j.a(list);
            this.j.notifyDataSetChanged();
            return;
        }
        this.f56888f.setVisibility(8);
    }

    public final boolean h(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56887e.setVisibility(0);
            this.f56887e.e(eVar);
            return true;
        }
        this.f56887e.setVisibility(8);
        return false;
    }

    public void i() {
        this.f56885c.setVisibility(0);
    }

    public void j() {
        this.f56885c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f56884b, R.color.CAM_X0201);
        String string = this.f56883a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56883a.setNetRefreshViewTopMargin(this.f56891i);
        this.f56883a.showNetRefreshView(this.f56884b, string, false);
    }

    public void k(e eVar, List<b> list, boolean z) {
        if (list != null && list.size() > 0) {
            c();
            if (h(eVar)) {
                this.f56888f.removeHeaderView(this.f56889g);
                this.f56888f.addHeaderView(this.f56889g);
            } else {
                this.f56888f.removeHeaderView(this.f56889g);
            }
            g(b(list));
            return;
        }
        j();
    }
}
