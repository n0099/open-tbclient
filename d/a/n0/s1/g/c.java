package d.a.n0.s1.g;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberPrivilegeActivity;
import d.a.c.e.p.k;
import d.a.n0.s1.g.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public MemberPrivilegeActivity f60594e;

    /* renamed from: f  reason: collision with root package name */
    public int f60595f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60596g = false;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f60597h = new ArrayList<>();

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f60598a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f60599b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f60600c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60601d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f60602e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f60603f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60604g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f60605h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f60606i;
        public ImageView j;
        public ImageView k;
        public TextView l;
        public TextView m;

        public b() {
        }
    }

    /* renamed from: d.a.n0.s1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1597c {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f60607a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60608b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60609c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f60610d;

        public C1597c() {
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public TextView f60611a;

        public d() {
        }
    }

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.f60594e = memberPrivilegeActivity;
    }

    public final SpannableString a(String str) {
        SpannableString spannableString = new SpannableString(this.f60594e.getResources().getString(R.string.endtime_days_tip, str));
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
        return spannableString;
    }

    public void b(ArrayList<a.C1596a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1596a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1596a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f60580d) && TextUtils.getTrimmedLength(next.f60580d) > 0) {
                arrayList2.add(next);
            }
        }
        arrayList.clear();
        arrayList.addAll(arrayList2);
    }

    public final View c(int i2, View view, ViewGroup viewGroup) {
        View inflate;
        b bVar;
        a.e eVar;
        a.b bVar2;
        a.d dVar;
        String string;
        int i3;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.f60594e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
            bVar = new b();
            bVar.f60598a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
            bVar.f60599b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
            bVar.f60602e = (TextView) inflate.findViewById(R.id.nonmembername);
            bVar.f60600c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
            bVar.f60601d = (TextView) inflate.findViewById(R.id.membername);
            bVar.f60603f = (TbImageView) inflate.findViewById(R.id.membericon);
            bVar.j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
            bVar.k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
            bVar.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
            bVar.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
            bVar.f60604g = (TextView) inflate.findViewById(R.id.endtime);
            bVar.f60605h = (TextView) inflate.findViewById(R.id.left_button);
            bVar.f60606i = (TextView) inflate.findViewById(R.id.right_button);
            inflate.setTag(bVar);
        }
        if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
            bVar.f60606i.setVisibility(8);
        } else {
            bVar.f60606i.setVisibility(0);
        }
        if (getItem(i2) == null || (eVar = (a.e) getItem(i2)) == null || (bVar2 = eVar.f60592d) == null || (dVar = eVar.f60593e) == null) {
            return null;
        }
        long j = dVar.f60587a + dVar.f60588b;
        this.f60595f = (int) bVar2.f60581a;
        long j2 = bVar2.f60582b;
        String e2 = e(j2, bVar2.f60583c);
        bVar.f60598a.V(eVar.f60591c, 25, false);
        SkinManager.setBackgroundResource(bVar.f60598a, R.drawable.memberinfo_bg_shape);
        if (!dVar.a()) {
            j = 0;
        }
        if (bVar2.a() && dVar.a()) {
            bVar.f60599b.setVisibility(8);
            bVar.f60600c.setVisibility(0);
            bVar.f60603f.V(eVar.f60592d.f60584d, 21, false);
            if (this.f60596g) {
                bVar.f60604g.setText(a(e2));
                i3 = 1;
            } else {
                if (1 == this.f60595f) {
                    string = this.f60594e.getPageContext().getString(R.string.member);
                } else {
                    string = this.f60594e.getPageContext().getString(R.string.vip_member);
                }
                i3 = 1;
                bVar.f60604g.setText(this.f60594e.getResources().getString(R.string.endtiem_memeber_tip, string, k.getDateStringDay(new Date(j2 * 1000))));
                SkinManager.setViewTextColor(bVar.f60604g, R.color.CAM_X0101, 1);
            }
            bVar.f60601d.setText(eVar.f60590b);
            bVar.f60605h.setText(this.f60595f == i3 ? R.string.continue_member : R.string.continue_vip_member);
            bVar.f60605h.setOnClickListener(this.f60594e);
            bVar.l.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.j, R.drawable.icon_vip_dou);
        } else {
            bVar.f60599b.setVisibility(0);
            bVar.f60600c.setVisibility(8);
            bVar.f60602e.setText(eVar.f60590b);
            bVar.f60605h.setText(R.string.dredge_member);
            bVar.f60605h.setOnClickListener(this.f60594e);
            bVar.m.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.k, R.drawable.icon_vip_dou);
        }
        SkinManager.setBackgroundResource(bVar.f60604g, R.drawable.bg_dredge_tips);
        bVar.f60606i.setOnClickListener(this.f60594e);
        this.f60594e.getLayoutMode().k(z);
        this.f60594e.getLayoutMode().j(inflate);
        return inflate;
    }

    public final View d(int i2, View view, ViewGroup viewGroup) {
        C1597c c1597c;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1597c)) {
            c1597c = (C1597c) view.getTag();
        } else {
            view = LayoutInflater.from(this.f60594e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
            c1597c = new C1597c();
            c1597c.f60607a = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1597c.f60608b = (TextView) view.findViewById(R.id.title);
            c1597c.f60609c = (TextView) view.findViewById(R.id.description);
            c1597c.f60610d = (ImageView) view.findViewById(R.id.divide_line_top);
            view.setTag(c1597c);
        }
        if (getItemViewType(i2 - 1) == 1) {
            c1597c.f60610d.setVisibility(8);
        }
        a.C1596a c1596a = (a.C1596a) getItem(i2);
        c1597c.f60607a.V(c1596a.f60577a, 10, false);
        c1597c.f60608b.setText(c1596a.f60578b);
        c1597c.f60609c.setText(c1596a.f60579c);
        this.f60594e.getLayoutMode().k(z);
        this.f60594e.getLayoutMode().j(view);
        return view;
    }

    public final String e(long j, long j2) {
        long j3 = j - j2;
        int i2 = (0L > j3 ? 1 : (0L == j3 ? 0 : -1));
        if (i2 >= 0 || j3 > 345600) {
            return "";
        }
        this.f60596g = true;
        if (i2 >= 0 || j3 > 86400) {
            return (86400 >= j3 || j3 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j3 || j3 > 259200) ? "3" : "2" : "1";
        }
        return this.f60594e.getPageContext().getString(R.string.today);
    }

    public final View f(int i2, View view, ViewGroup viewGroup) {
        d dVar;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        } else {
            view = LayoutInflater.from(this.f60594e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
            dVar = new d();
            dVar.f60611a = (TextView) view.findViewById(R.id.title_view);
            view.setTag(dVar);
        }
        dVar.f60611a.setText((String) getItem(i2));
        this.f60594e.getLayoutMode().k(z);
        this.f60594e.getLayoutMode().j(view);
        return view;
    }

    public boolean g(ArrayList<a.C1596a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            b(arrayList);
            if (arrayList.size() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<Object> arrayList = this.f60597h;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<Object> arrayList = this.f60597h;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return null;
        }
        return this.f60597h.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.f60597h != null && i2 >= 0 && i2 <= getCount() && i2 < this.f60597h.size()) {
            Object obj = this.f60597h.get(i2);
            if (obj instanceof a.e) {
                return 0;
            }
            if (obj instanceof String) {
                return 1;
            }
            if (obj instanceof a.C1596a) {
                return 2;
            }
        }
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 0) {
            return c(i2, view, viewGroup);
        }
        if (itemViewType == 1) {
            return f(i2, view, viewGroup);
        }
        if (itemViewType == 2) {
            return d(i2, view, viewGroup);
        }
        if (itemViewType == 3) {
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    public void h(d.a.n0.s1.g.a aVar) {
        List<a.c> list;
        ArrayList<a.C1596a> arrayList;
        this.f60597h.clear();
        if (aVar == null || aVar.f60575a == null || (list = aVar.f60576b) == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(aVar.f60575a);
        for (a.c cVar : list) {
            if (cVar != null && !TextUtils.isEmpty(cVar.f60585a) && (arrayList = cVar.f60586b) != null && arrayList.size() != 0 && g(cVar.f60586b)) {
                arrayList2.add(cVar.f60585a);
                Iterator<a.C1596a> it = cVar.f60586b.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next());
                }
            }
        }
        this.f60597h.addAll(arrayList2);
        notifyDataSetChanged();
    }
}
