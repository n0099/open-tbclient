package d.a.j0.j3.f.b;

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
import d.a.j0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BubbleGroupActivity f56176a;

    /* renamed from: b  reason: collision with root package name */
    public View f56177b;

    /* renamed from: c  reason: collision with root package name */
    public View f56178c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56179d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f56180e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f56181f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56182g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56183h;

    /* renamed from: i  reason: collision with root package name */
    public int f56184i;
    public d.a.j0.j3.f.b.a j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log("c10283");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleListActivityConfig(c.this.f56176a.getActivity())));
        }
    }

    public c(BubbleGroupActivity bubbleGroupActivity, d.a.j0.j3.f.a.a aVar) {
        this.f56184i = 0;
        this.f56176a = bubbleGroupActivity;
        this.f56184i = l.g(bubbleGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f56176a.getPageContext().getPageActivity()).inflate(R.layout.bubble_group, (ViewGroup) null);
        this.f56177b = inflate;
        this.f56176a.setContentView(inflate);
        this.f56178c = this.f56177b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f56177b.findViewById(R.id.view_navigation_bar);
        this.f56179d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56179d.setTitleText(R.string.editor_privilege);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f56177b.findViewById(R.id.view_member_recommend);
        this.f56180e = memberRecommendView;
        memberRecommendView.setFromType(6);
        this.f56181f = (BdListView) this.f56177b.findViewById(R.id.listview_group);
        TextView textView = new TextView(this.f56176a.getActivity());
        this.f56182g = textView;
        textView.setHeight(l.g(this.f56176a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f56176a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f56183h = textView2;
        textView2.setText(R.string.more_bubble);
        this.f56183h.setOnClickListener(new a());
        this.j = new d.a.j0.j3.f.b.a(this.f56176a.getPageContext(), aVar);
        TextView textView3 = new TextView(this.f56176a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f56176a.getActivity(), R.dimen.ds98)));
        this.f56181f.x(textView3, 0);
        this.f56181f.addFooterView(this.f56183h);
        this.f56181f.setAdapter((ListAdapter) this.j);
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
        SkinManager.setBackgroundColor(this.f56177b, R.color.CAM_X0204);
        this.f56176a.hideNetRefreshView(this.f56177b);
        this.f56178c.setVisibility(0);
    }

    public View d() {
        return this.f56177b;
    }

    public void e() {
        this.f56178c.setVisibility(8);
    }

    public void f() {
        d.a.j0.j3.f.b.a aVar;
        d.a.i0.s0.a.a(this.f56176a.getPageContext(), this.f56177b);
        d.a.i0.s0.a.a(this.f56176a.getPageContext(), this.f56183h);
        NavigationBar navigationBar = this.f56179d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56176a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f56181f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
            aVar.notifyDataSetChanged();
        }
        this.f56180e.d();
        SkinManager.setBackgroundColor(this.f56182g, R.color.CAM_X0204);
    }

    public final void g(List<Object> list) {
        if (list != null && list.size() > 0) {
            this.f56181f.setVisibility(0);
            this.j.a(list);
            this.j.notifyDataSetChanged();
            return;
        }
        this.f56181f.setVisibility(8);
    }

    public final boolean h(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56180e.setVisibility(0);
            this.f56180e.e(eVar);
            return true;
        }
        this.f56180e.setVisibility(8);
        return false;
    }

    public void i() {
        this.f56178c.setVisibility(0);
    }

    public void j() {
        this.f56178c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f56177b, R.color.CAM_X0201);
        String string = this.f56176a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56176a.setNetRefreshViewTopMargin(this.f56184i);
        this.f56176a.showNetRefreshView(this.f56177b, string, false);
    }

    public void k(e eVar, List<b> list, boolean z) {
        if (list != null && list.size() > 0) {
            c();
            if (h(eVar)) {
                this.f56181f.removeHeaderView(this.f56182g);
                this.f56181f.addHeaderView(this.f56182g);
            } else {
                this.f56181f.removeHeaderView(this.f56182g);
            }
            g(b(list));
            return;
        }
        j();
    }
}
