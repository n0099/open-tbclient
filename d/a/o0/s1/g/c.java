package d.a.o0.s1.g;

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
import d.a.o0.s1.g.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public MemberPrivilegeActivity f64410e;

    /* renamed from: f  reason: collision with root package name */
    public int f64411f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64412g = false;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f64413h = new ArrayList<>();

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f64414a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f64415b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f64416c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f64417d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f64418e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f64419f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f64420g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f64421h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f64422i;
        public ImageView j;
        public ImageView k;
        public TextView l;
        public TextView m;

        public b() {
        }
    }

    /* renamed from: d.a.o0.s1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1657c {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f64423a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f64424b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f64425c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f64426d;

        public C1657c() {
        }
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public TextView f64427a;

        public d() {
        }
    }

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.f64410e = memberPrivilegeActivity;
    }

    public final SpannableString a(String str) {
        SpannableString spannableString = new SpannableString(this.f64410e.getResources().getString(R.string.endtime_days_tip, str));
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
        return spannableString;
    }

    public void b(ArrayList<a.C1656a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1656a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1656a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f64396d) && TextUtils.getTrimmedLength(next.f64396d) > 0) {
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
            inflate = LayoutInflater.from(this.f64410e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
            bVar = new b();
            bVar.f64414a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
            bVar.f64415b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
            bVar.f64418e = (TextView) inflate.findViewById(R.id.nonmembername);
            bVar.f64416c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
            bVar.f64417d = (TextView) inflate.findViewById(R.id.membername);
            bVar.f64419f = (TbImageView) inflate.findViewById(R.id.membericon);
            bVar.j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
            bVar.k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
            bVar.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
            bVar.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
            bVar.f64420g = (TextView) inflate.findViewById(R.id.endtime);
            bVar.f64421h = (TextView) inflate.findViewById(R.id.left_button);
            bVar.f64422i = (TextView) inflate.findViewById(R.id.right_button);
            inflate.setTag(bVar);
        }
        if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
            bVar.f64422i.setVisibility(8);
        } else {
            bVar.f64422i.setVisibility(0);
        }
        if (getItem(i2) == null || (eVar = (a.e) getItem(i2)) == null || (bVar2 = eVar.f64408d) == null || (dVar = eVar.f64409e) == null) {
            return null;
        }
        long j = dVar.f64403a + dVar.f64404b;
        this.f64411f = (int) bVar2.f64397a;
        long j2 = bVar2.f64398b;
        String e2 = e(j2, bVar2.f64399c);
        bVar.f64414a.U(eVar.f64407c, 25, false);
        SkinManager.setBackgroundResource(bVar.f64414a, R.drawable.memberinfo_bg_shape);
        if (!dVar.a()) {
            j = 0;
        }
        if (bVar2.a() && dVar.a()) {
            bVar.f64415b.setVisibility(8);
            bVar.f64416c.setVisibility(0);
            bVar.f64419f.U(eVar.f64408d.f64400d, 21, false);
            if (this.f64412g) {
                bVar.f64420g.setText(a(e2));
                i3 = 1;
            } else {
                if (1 == this.f64411f) {
                    string = this.f64410e.getPageContext().getString(R.string.member);
                } else {
                    string = this.f64410e.getPageContext().getString(R.string.vip_member);
                }
                i3 = 1;
                bVar.f64420g.setText(this.f64410e.getResources().getString(R.string.endtiem_memeber_tip, string, k.getDateStringDay(new Date(j2 * 1000))));
                SkinManager.setViewTextColor(bVar.f64420g, R.color.CAM_X0101, 1);
            }
            bVar.f64417d.setText(eVar.f64406b);
            bVar.f64421h.setText(this.f64411f == i3 ? R.string.continue_member : R.string.continue_vip_member);
            bVar.f64421h.setOnClickListener(this.f64410e);
            bVar.l.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.j, R.drawable.icon_vip_dou);
        } else {
            bVar.f64415b.setVisibility(0);
            bVar.f64416c.setVisibility(8);
            bVar.f64418e.setText(eVar.f64406b);
            bVar.f64421h.setText(R.string.dredge_member);
            bVar.f64421h.setOnClickListener(this.f64410e);
            bVar.m.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.k, R.drawable.icon_vip_dou);
        }
        SkinManager.setBackgroundResource(bVar.f64420g, R.drawable.bg_dredge_tips);
        bVar.f64422i.setOnClickListener(this.f64410e);
        this.f64410e.getLayoutMode().k(z);
        this.f64410e.getLayoutMode().j(inflate);
        return inflate;
    }

    public final View d(int i2, View view, ViewGroup viewGroup) {
        C1657c c1657c;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1657c)) {
            c1657c = (C1657c) view.getTag();
        } else {
            view = LayoutInflater.from(this.f64410e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
            c1657c = new C1657c();
            c1657c.f64423a = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1657c.f64424b = (TextView) view.findViewById(R.id.title);
            c1657c.f64425c = (TextView) view.findViewById(R.id.description);
            c1657c.f64426d = (ImageView) view.findViewById(R.id.divide_line_top);
            view.setTag(c1657c);
        }
        if (getItemViewType(i2 - 1) == 1) {
            c1657c.f64426d.setVisibility(8);
        }
        a.C1656a c1656a = (a.C1656a) getItem(i2);
        c1657c.f64423a.U(c1656a.f64393a, 10, false);
        c1657c.f64424b.setText(c1656a.f64394b);
        c1657c.f64425c.setText(c1656a.f64395c);
        this.f64410e.getLayoutMode().k(z);
        this.f64410e.getLayoutMode().j(view);
        return view;
    }

    public final String e(long j, long j2) {
        long j3 = j - j2;
        int i2 = (0L > j3 ? 1 : (0L == j3 ? 0 : -1));
        if (i2 >= 0 || j3 > 345600) {
            return "";
        }
        this.f64412g = true;
        if (i2 >= 0 || j3 > 86400) {
            return (86400 >= j3 || j3 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j3 || j3 > 259200) ? "3" : "2" : "1";
        }
        return this.f64410e.getPageContext().getString(R.string.today);
    }

    public final View f(int i2, View view, ViewGroup viewGroup) {
        d dVar;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        } else {
            view = LayoutInflater.from(this.f64410e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
            dVar = new d();
            dVar.f64427a = (TextView) view.findViewById(R.id.title_view);
            view.setTag(dVar);
        }
        dVar.f64427a.setText((String) getItem(i2));
        this.f64410e.getLayoutMode().k(z);
        this.f64410e.getLayoutMode().j(view);
        return view;
    }

    public boolean g(ArrayList<a.C1656a> arrayList) {
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
        ArrayList<Object> arrayList = this.f64413h;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<Object> arrayList = this.f64413h;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return null;
        }
        return this.f64413h.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.f64413h != null && i2 >= 0 && i2 <= getCount() && i2 < this.f64413h.size()) {
            Object obj = this.f64413h.get(i2);
            if (obj instanceof a.e) {
                return 0;
            }
            if (obj instanceof String) {
                return 1;
            }
            if (obj instanceof a.C1656a) {
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

    public void h(d.a.o0.s1.g.a aVar) {
        List<a.c> list;
        ArrayList<a.C1656a> arrayList;
        this.f64413h.clear();
        if (aVar == null || aVar.f64391a == null || (list = aVar.f64392b) == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(aVar.f64391a);
        for (a.c cVar : list) {
            if (cVar != null && !TextUtils.isEmpty(cVar.f64401a) && (arrayList = cVar.f64402b) != null && arrayList.size() != 0 && g(cVar.f64402b)) {
                arrayList2.add(cVar.f64401a);
                Iterator<a.C1656a> it = cVar.f64402b.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next());
                }
            }
        }
        this.f64413h.addAll(arrayList2);
        notifyDataSetChanged();
    }
}
