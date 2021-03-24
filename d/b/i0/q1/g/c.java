package d.b.i0.q1.g;

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
import d.b.b.e.p.k;
import d.b.i0.q1.g.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public MemberPrivilegeActivity f59458e;

    /* renamed from: f  reason: collision with root package name */
    public int f59459f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59460g = false;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f59461h = new ArrayList<>();

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f59462a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f59463b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f59464c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59465d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f59466e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f59467f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f59468g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f59469h;
        public TextView i;
        public ImageView j;
        public ImageView k;
        public TextView l;
        public TextView m;

        public b() {
        }
    }

    /* renamed from: d.b.i0.q1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1484c {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f59470a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59471b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59472c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f59473d;

        public C1484c() {
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public TextView f59474a;

        public d() {
        }
    }

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.f59458e = memberPrivilegeActivity;
    }

    public final SpannableString a(String str) {
        SpannableString spannableString = new SpannableString(this.f59458e.getResources().getString(R.string.endtime_days_tip, str));
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
        return spannableString;
    }

    public void b(ArrayList<a.C1483a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1483a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1483a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f59444d) && TextUtils.getTrimmedLength(next.f59444d) > 0) {
                arrayList2.add(next);
            }
        }
        arrayList.clear();
        arrayList.addAll(arrayList2);
    }

    public final View c(int i, View view, ViewGroup viewGroup) {
        View inflate;
        b bVar;
        a.e eVar;
        a.b bVar2;
        a.d dVar;
        String string;
        int i2;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.f59458e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
            bVar = new b();
            bVar.f59462a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
            bVar.f59463b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
            bVar.f59466e = (TextView) inflate.findViewById(R.id.nonmembername);
            bVar.f59464c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
            bVar.f59465d = (TextView) inflate.findViewById(R.id.membername);
            bVar.f59467f = (TbImageView) inflate.findViewById(R.id.membericon);
            bVar.j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
            bVar.k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
            bVar.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
            bVar.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
            bVar.f59468g = (TextView) inflate.findViewById(R.id.endtime);
            bVar.f59469h = (TextView) inflate.findViewById(R.id.left_button);
            bVar.i = (TextView) inflate.findViewById(R.id.right_button);
            inflate.setTag(bVar);
        }
        if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
            bVar.i.setVisibility(8);
        } else {
            bVar.i.setVisibility(0);
        }
        if (getItem(i) == null || (eVar = (a.e) getItem(i)) == null || (bVar2 = eVar.f59456d) == null || (dVar = eVar.f59457e) == null) {
            return null;
        }
        long j = dVar.f59451a + dVar.f59452b;
        this.f59459f = (int) bVar2.f59445a;
        long j2 = bVar2.f59446b;
        String e2 = e(j2, bVar2.f59447c);
        bVar.f59462a.W(eVar.f59455c, 25, false);
        SkinManager.setBackgroundResource(bVar.f59462a, R.drawable.memberinfo_bg_shape);
        if (!dVar.a()) {
            j = 0;
        }
        if (bVar2.a() && dVar.a()) {
            bVar.f59463b.setVisibility(8);
            bVar.f59464c.setVisibility(0);
            bVar.f59467f.W(eVar.f59456d.f59448d, 21, false);
            if (this.f59460g) {
                bVar.f59468g.setText(a(e2));
                i2 = 1;
            } else {
                if (1 == this.f59459f) {
                    string = this.f59458e.getPageContext().getString(R.string.member);
                } else {
                    string = this.f59458e.getPageContext().getString(R.string.vip_member);
                }
                i2 = 1;
                bVar.f59468g.setText(this.f59458e.getResources().getString(R.string.endtiem_memeber_tip, string, k.getDateStringDay(new Date(j2 * 1000))));
                SkinManager.setViewTextColor(bVar.f59468g, R.color.CAM_X0101, 1);
            }
            bVar.f59465d.setText(eVar.f59454b);
            bVar.f59469h.setText(this.f59459f == i2 ? R.string.continue_member : R.string.continue_vip_member);
            bVar.f59469h.setOnClickListener(this.f59458e);
            bVar.l.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.j, R.drawable.icon_vip_dou);
        } else {
            bVar.f59463b.setVisibility(0);
            bVar.f59464c.setVisibility(8);
            bVar.f59466e.setText(eVar.f59454b);
            bVar.f59469h.setText(R.string.dredge_member);
            bVar.f59469h.setOnClickListener(this.f59458e);
            bVar.m.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.k, R.drawable.icon_vip_dou);
        }
        SkinManager.setBackgroundResource(bVar.f59468g, R.drawable.bg_dredge_tips);
        bVar.i.setOnClickListener(this.f59458e);
        this.f59458e.getLayoutMode().k(z);
        this.f59458e.getLayoutMode().j(inflate);
        return inflate;
    }

    public final View d(int i, View view, ViewGroup viewGroup) {
        C1484c c1484c;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1484c)) {
            c1484c = (C1484c) view.getTag();
        } else {
            view = LayoutInflater.from(this.f59458e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
            c1484c = new C1484c();
            c1484c.f59470a = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1484c.f59471b = (TextView) view.findViewById(R.id.title);
            c1484c.f59472c = (TextView) view.findViewById(R.id.description);
            c1484c.f59473d = (ImageView) view.findViewById(R.id.divide_line_top);
            view.setTag(c1484c);
        }
        if (getItemViewType(i - 1) == 1) {
            c1484c.f59473d.setVisibility(8);
        }
        a.C1483a c1483a = (a.C1483a) getItem(i);
        c1484c.f59470a.W(c1483a.f59441a, 10, false);
        c1484c.f59471b.setText(c1483a.f59442b);
        c1484c.f59472c.setText(c1483a.f59443c);
        this.f59458e.getLayoutMode().k(z);
        this.f59458e.getLayoutMode().j(view);
        return view;
    }

    public final String e(long j, long j2) {
        long j3 = j - j2;
        if (0 >= j3 || j3 > 345600) {
            return "";
        }
        this.f59460g = true;
        if (0 >= j3 || j3 > 86400) {
            return (86400 >= j3 || j3 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j3 || j3 > 259200) ? "3" : "2" : "1";
        }
        return this.f59458e.getPageContext().getString(R.string.today);
    }

    public final View f(int i, View view, ViewGroup viewGroup) {
        d dVar;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        } else {
            view = LayoutInflater.from(this.f59458e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
            dVar = new d();
            dVar.f59474a = (TextView) view.findViewById(R.id.title_view);
            view.setTag(dVar);
        }
        dVar.f59474a.setText((String) getItem(i));
        this.f59458e.getLayoutMode().k(z);
        this.f59458e.getLayoutMode().j(view);
        return view;
    }

    public boolean g(ArrayList<a.C1483a> arrayList) {
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
        ArrayList<Object> arrayList = this.f59461h;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<Object> arrayList = this.f59461h;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.f59461h.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.f59461h != null && i >= 0 && i <= getCount() && i < this.f59461h.size()) {
            Object obj = this.f59461h.get(i);
            if (obj instanceof a.e) {
                return 0;
            }
            if (obj instanceof String) {
                return 1;
            }
            if (obj instanceof a.C1483a) {
                return 2;
            }
        }
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return c(i, view, viewGroup);
        }
        if (itemViewType == 1) {
            return f(i, view, viewGroup);
        }
        if (itemViewType == 2) {
            return d(i, view, viewGroup);
        }
        if (itemViewType == 3) {
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    public void h(d.b.i0.q1.g.a aVar) {
        List<a.c> list;
        ArrayList<a.C1483a> arrayList;
        this.f59461h.clear();
        if (aVar == null || aVar.f59439a == null || (list = aVar.f59440b) == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(aVar.f59439a);
        for (a.c cVar : list) {
            if (cVar != null && !TextUtils.isEmpty(cVar.f59449a) && (arrayList = cVar.f59450b) != null && arrayList.size() != 0 && g(cVar.f59450b)) {
                arrayList2.add(cVar.f59449a);
                Iterator<a.C1483a> it = cVar.f59450b.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next());
                }
            }
        }
        this.f59461h.addAll(arrayList2);
        notifyDataSetChanged();
    }
}
