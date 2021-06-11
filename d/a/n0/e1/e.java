package d.a.n0.e1;

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
    public TbPageContext<HotTopicSelectActivity> f56479e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f56480f;

    /* renamed from: g  reason: collision with root package name */
    public ExpandableListView f56481g;

    /* renamed from: h  reason: collision with root package name */
    public final List<c> f56482h = new ArrayList();

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f56483a = 3;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56484b = null;

        /* renamed from: c  reason: collision with root package name */
        public TextView f56485c = null;

        /* renamed from: d  reason: collision with root package name */
        public View f56486d = null;

        /* renamed from: e  reason: collision with root package name */
        public View f56487e = null;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f56488a = 3;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56489b;

        /* renamed from: c  reason: collision with root package name */
        public View f56490c;

        /* renamed from: d  reason: collision with root package name */
        public View f56491d;
    }

    public e(TbPageContext tbPageContext) {
        this.f56479e = tbPageContext;
        this.f56480f = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(a aVar, View view, int i2) {
        if (aVar == null || aVar.f56483a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundResource(aVar.f56485c, R.drawable.hot_select_tag_bg);
        SkinManager.setBackgroundColor(aVar.f56486d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(aVar.f56487e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(aVar.f56485c, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(aVar.f56484b, R.color.CAM_X0105, 1);
        aVar.f56483a = i2;
    }

    public final void b(b bVar, View view, int i2) {
        if (bVar == null || bVar.f56488a == i2) {
            return;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(bVar.f56490c, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(bVar.f56491d, R.color.CAM_X0205);
        SkinManager.setViewTextColor(bVar.f56489b, R.color.CAM_X0109, 1);
        bVar.f56488a = i2;
    }

    public void c() {
        this.f56482h.clear();
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ExpandableListAdapter
    /* renamed from: d */
    public d getChild(int i2, int i3) {
        if (getGroup(i2) == null || getGroup(i2).b() == null) {
            return null;
        }
        return getGroup(i2).b().get(i3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ExpandableListAdapter
    /* renamed from: e */
    public c getGroup(int i2) {
        return this.f56482h.get(i2);
    }

    public List<c> f() {
        return this.f56482h;
    }

    public void g(c cVar) {
        this.f56482h.add(cVar);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i2, int i3) {
        return i3;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i2, int i3) {
        if (getChildTypeCount() == 2) {
            if (i2 != 0 && i2 == 1) {
                return 2;
            }
        } else if (getChildTypeCount() == 1 && getGroup(i2).c() != 0 && getGroup(i2).c() == 1) {
            return 2;
        }
        return 1;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        return this.f56482h.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i2, int i3, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        d child = getChild(i2, i3);
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            view = this.f56480f.inflate(R.layout.hot_child_bang_item, (ViewGroup) null);
            aVar = new a();
            aVar.f56484b = (TextView) view.findViewById(R.id.hot_topic_title);
            aVar.f56485c = (TextView) view.findViewById(R.id.hot_topic_tag);
            aVar.f56486d = view.findViewById(R.id.divider_line_top);
            aVar.f56487e = view.findViewById(R.id.divider_line_bottom);
            view.setTag(aVar);
        }
        if (child == null) {
            return view;
        }
        aVar.f56484b.setText(d.a.m0.p0.b.a(StringHelper.cutStringWithEllipsisNew(child.b(), 15)));
        h(aVar.f56485c, child.a().intValue());
        a(aVar, view, TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i2) {
        if (getGroup(i2) == null || getGroup(i2).b() == null) {
            return 0;
        }
        return getGroup(i2).b().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f56482h.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i2, boolean z, View view, ViewGroup viewGroup) {
        b bVar;
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        } else {
            view = this.f56480f.inflate(R.layout.hot_group_item, (ViewGroup) null);
            bVar = new b();
            bVar.f56489b = (TextView) view.findViewById(R.id.header_text);
            bVar.f56490c = view.findViewById(R.id.divider_line);
            bVar.f56491d = view.findViewById(R.id.group_divider);
            view.setTag(bVar);
            view.setClickable(false);
        }
        c group = getGroup(i2);
        if (group == null) {
            return view;
        }
        bVar.f56489b.setText(StringHelper.cutStringWithSuffix(group.a(), 15, null));
        if (i2 == 0) {
            bVar.f56490c.setVisibility(0);
            bVar.f56491d.setVisibility(8);
        } else {
            bVar.f56490c.setVisibility(8);
            bVar.f56491d.setVisibility(0);
        }
        b(bVar, view, TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    public final void h(TextView textView, int i2) {
        if (textView == null) {
            return;
        }
        if (i2 == 10) {
            textView.setVisibility(0);
            textView.setText(this.f56479e.getString(R.string.topic_tag_offical));
        } else if (i2 == 11) {
            textView.setVisibility(0);
            textView.setText(this.f56479e.getString(R.string.topic_tag_bar));
        } else {
            textView.setVisibility(8);
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i2, int i3) {
        return true;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public void onGroupCollapsed(int i2) {
        if (this.f56481g == null) {
            return;
        }
        int groupCount = getGroupCount();
        for (int i3 = 0; i3 < groupCount; i3++) {
            if (i3 != i2) {
                this.f56481g.collapseGroup(i2);
            }
        }
    }
}
