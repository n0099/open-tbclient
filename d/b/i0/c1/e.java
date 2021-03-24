package d.b.i0.c1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopicselect.HotTopicSelectActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseExpandableListAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicSelectActivity> f52295e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f52296f;

    /* renamed from: g  reason: collision with root package name */
    public ExpandableListView f52297g;

    /* renamed from: h  reason: collision with root package name */
    public final List<c> f52298h = new ArrayList();

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f52299a = 3;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52300b = null;

        /* renamed from: c  reason: collision with root package name */
        public TextView f52301c = null;

        /* renamed from: d  reason: collision with root package name */
        public View f52302d = null;

        /* renamed from: e  reason: collision with root package name */
        public View f52303e = null;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f52304a = 3;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52305b;

        /* renamed from: c  reason: collision with root package name */
        public View f52306c;

        /* renamed from: d  reason: collision with root package name */
        public View f52307d;
    }

    public e(TbPageContext tbPageContext) {
        this.f52295e = tbPageContext;
        this.f52296f = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(a aVar, View view, int i) {
        if (aVar == null || aVar.f52299a == i) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundResource(aVar.f52301c, R.drawable.hot_select_tag_bg);
        SkinManager.setBackgroundColor(aVar.f52302d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(aVar.f52303e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(aVar.f52301c, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(aVar.f52300b, R.color.CAM_X0105, 1);
        aVar.f52299a = i;
    }

    public final void b(b bVar, View view, int i) {
        if (bVar == null || bVar.f52304a == i) {
            return;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(bVar.f52306c, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(bVar.f52307d, R.color.CAM_X0205);
        SkinManager.setViewTextColor(bVar.f52305b, R.color.CAM_X0109, 1);
        bVar.f52304a = i;
    }

    public void c() {
        this.f52298h.clear();
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ExpandableListAdapter
    /* renamed from: d */
    public d getChild(int i, int i2) {
        if (getGroup(i) == null || getGroup(i).b() == null) {
            return null;
        }
        return getGroup(i).b().get(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ExpandableListAdapter
    /* renamed from: e */
    public c getGroup(int i) {
        return this.f52298h.get(i);
    }

    public List<c> f() {
        return this.f52298h;
    }

    public void g(c cVar) {
        this.f52298h.add(cVar);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i, int i2) {
        if (getChildTypeCount() == 2) {
            if (i != 0 && i == 1) {
                return 2;
            }
        } else if (getChildTypeCount() == 1 && getGroup(i).c() != 0 && getGroup(i).c() == 1) {
            return 2;
        }
        return 1;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        return this.f52298h.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        d child = getChild(i, i2);
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            view = this.f52296f.inflate(R.layout.hot_child_bang_item, (ViewGroup) null);
            aVar = new a();
            aVar.f52300b = (TextView) view.findViewById(R.id.hot_topic_title);
            aVar.f52301c = (TextView) view.findViewById(R.id.hot_topic_tag);
            aVar.f52302d = view.findViewById(R.id.divider_line_top);
            aVar.f52303e = view.findViewById(R.id.divider_line_bottom);
            view.setTag(aVar);
        }
        if (child == null) {
            return view;
        }
        aVar.f52300b.setText(d.b.h0.p0.b.a(StringHelper.cutStringWithEllipsisNew(child.b(), 15)));
        h(aVar.f52301c, child.a().intValue());
        a(aVar, view, TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        if (getGroup(i) == null || getGroup(i).b() == null) {
            return 0;
        }
        return getGroup(i).b().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f52298h.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        b bVar;
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        } else {
            view = this.f52296f.inflate(R.layout.hot_group_item, (ViewGroup) null);
            bVar = new b();
            bVar.f52305b = (TextView) view.findViewById(R.id.header_text);
            bVar.f52306c = view.findViewById(R.id.divider_line);
            bVar.f52307d = view.findViewById(R.id.group_divider);
            view.setTag(bVar);
            view.setClickable(false);
        }
        c group = getGroup(i);
        if (group == null) {
            return view;
        }
        bVar.f52305b.setText(StringHelper.cutStringWithSuffix(group.a(), 15, null));
        if (i == 0) {
            bVar.f52306c.setVisibility(0);
            bVar.f52307d.setVisibility(8);
        } else {
            bVar.f52306c.setVisibility(8);
            bVar.f52307d.setVisibility(0);
        }
        b(bVar, view, TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    public final void h(TextView textView, int i) {
        if (textView == null) {
            return;
        }
        if (i == 10) {
            textView.setVisibility(0);
            textView.setText(this.f52295e.getString(R.string.topic_tag_offical));
        } else if (i == 11) {
            textView.setVisibility(0);
            textView.setText(this.f52295e.getString(R.string.topic_tag_bar));
        } else {
            textView.setVisibility(8);
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public void onGroupCollapsed(int i) {
        if (this.f52297g == null) {
            return;
        }
        int groupCount = getGroupCount();
        for (int i2 = 0; i2 < groupCount; i2++) {
            if (i2 != i) {
                this.f52297g.collapseGroup(i);
            }
        }
    }
}
