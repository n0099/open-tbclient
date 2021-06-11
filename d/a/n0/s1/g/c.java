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
    public MemberPrivilegeActivity f64285e;

    /* renamed from: f  reason: collision with root package name */
    public int f64286f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64287g = false;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f64288h = new ArrayList<>();

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f64289a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f64290b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f64291c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f64292d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f64293e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f64294f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f64295g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f64296h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f64297i;
        public ImageView j;
        public ImageView k;
        public TextView l;
        public TextView m;

        public b() {
        }
    }

    /* renamed from: d.a.n0.s1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1653c {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f64298a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f64299b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f64300c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f64301d;

        public C1653c() {
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public TextView f64302a;

        public d() {
        }
    }

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.f64285e = memberPrivilegeActivity;
    }

    public final SpannableString a(String str) {
        SpannableString spannableString = new SpannableString(this.f64285e.getResources().getString(R.string.endtime_days_tip, str));
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
        return spannableString;
    }

    public void b(ArrayList<a.C1652a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1652a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1652a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f64271d) && TextUtils.getTrimmedLength(next.f64271d) > 0) {
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
            inflate = LayoutInflater.from(this.f64285e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
            bVar = new b();
            bVar.f64289a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
            bVar.f64290b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
            bVar.f64293e = (TextView) inflate.findViewById(R.id.nonmembername);
            bVar.f64291c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
            bVar.f64292d = (TextView) inflate.findViewById(R.id.membername);
            bVar.f64294f = (TbImageView) inflate.findViewById(R.id.membericon);
            bVar.j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
            bVar.k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
            bVar.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
            bVar.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
            bVar.f64295g = (TextView) inflate.findViewById(R.id.endtime);
            bVar.f64296h = (TextView) inflate.findViewById(R.id.left_button);
            bVar.f64297i = (TextView) inflate.findViewById(R.id.right_button);
            inflate.setTag(bVar);
        }
        if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
            bVar.f64297i.setVisibility(8);
        } else {
            bVar.f64297i.setVisibility(0);
        }
        if (getItem(i2) == null || (eVar = (a.e) getItem(i2)) == null || (bVar2 = eVar.f64283d) == null || (dVar = eVar.f64284e) == null) {
            return null;
        }
        long j = dVar.f64278a + dVar.f64279b;
        this.f64286f = (int) bVar2.f64272a;
        long j2 = bVar2.f64273b;
        String e2 = e(j2, bVar2.f64274c);
        bVar.f64289a.U(eVar.f64282c, 25, false);
        SkinManager.setBackgroundResource(bVar.f64289a, R.drawable.memberinfo_bg_shape);
        if (!dVar.a()) {
            j = 0;
        }
        if (bVar2.a() && dVar.a()) {
            bVar.f64290b.setVisibility(8);
            bVar.f64291c.setVisibility(0);
            bVar.f64294f.U(eVar.f64283d.f64275d, 21, false);
            if (this.f64287g) {
                bVar.f64295g.setText(a(e2));
                i3 = 1;
            } else {
                if (1 == this.f64286f) {
                    string = this.f64285e.getPageContext().getString(R.string.member);
                } else {
                    string = this.f64285e.getPageContext().getString(R.string.vip_member);
                }
                i3 = 1;
                bVar.f64295g.setText(this.f64285e.getResources().getString(R.string.endtiem_memeber_tip, string, k.getDateStringDay(new Date(j2 * 1000))));
                SkinManager.setViewTextColor(bVar.f64295g, R.color.CAM_X0101, 1);
            }
            bVar.f64292d.setText(eVar.f64281b);
            bVar.f64296h.setText(this.f64286f == i3 ? R.string.continue_member : R.string.continue_vip_member);
            bVar.f64296h.setOnClickListener(this.f64285e);
            bVar.l.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.j, R.drawable.icon_vip_dou);
        } else {
            bVar.f64290b.setVisibility(0);
            bVar.f64291c.setVisibility(8);
            bVar.f64293e.setText(eVar.f64281b);
            bVar.f64296h.setText(R.string.dredge_member);
            bVar.f64296h.setOnClickListener(this.f64285e);
            bVar.m.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.k, R.drawable.icon_vip_dou);
        }
        SkinManager.setBackgroundResource(bVar.f64295g, R.drawable.bg_dredge_tips);
        bVar.f64297i.setOnClickListener(this.f64285e);
        this.f64285e.getLayoutMode().k(z);
        this.f64285e.getLayoutMode().j(inflate);
        return inflate;
    }

    public final View d(int i2, View view, ViewGroup viewGroup) {
        C1653c c1653c;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1653c)) {
            c1653c = (C1653c) view.getTag();
        } else {
            view = LayoutInflater.from(this.f64285e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
            c1653c = new C1653c();
            c1653c.f64298a = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1653c.f64299b = (TextView) view.findViewById(R.id.title);
            c1653c.f64300c = (TextView) view.findViewById(R.id.description);
            c1653c.f64301d = (ImageView) view.findViewById(R.id.divide_line_top);
            view.setTag(c1653c);
        }
        if (getItemViewType(i2 - 1) == 1) {
            c1653c.f64301d.setVisibility(8);
        }
        a.C1652a c1652a = (a.C1652a) getItem(i2);
        c1653c.f64298a.U(c1652a.f64268a, 10, false);
        c1653c.f64299b.setText(c1652a.f64269b);
        c1653c.f64300c.setText(c1652a.f64270c);
        this.f64285e.getLayoutMode().k(z);
        this.f64285e.getLayoutMode().j(view);
        return view;
    }

    public final String e(long j, long j2) {
        long j3 = j - j2;
        int i2 = (0L > j3 ? 1 : (0L == j3 ? 0 : -1));
        if (i2 >= 0 || j3 > 345600) {
            return "";
        }
        this.f64287g = true;
        if (i2 >= 0 || j3 > 86400) {
            return (86400 >= j3 || j3 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j3 || j3 > 259200) ? "3" : "2" : "1";
        }
        return this.f64285e.getPageContext().getString(R.string.today);
    }

    public final View f(int i2, View view, ViewGroup viewGroup) {
        d dVar;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        } else {
            view = LayoutInflater.from(this.f64285e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
            dVar = new d();
            dVar.f64302a = (TextView) view.findViewById(R.id.title_view);
            view.setTag(dVar);
        }
        dVar.f64302a.setText((String) getItem(i2));
        this.f64285e.getLayoutMode().k(z);
        this.f64285e.getLayoutMode().j(view);
        return view;
    }

    public boolean g(ArrayList<a.C1652a> arrayList) {
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
        ArrayList<Object> arrayList = this.f64288h;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<Object> arrayList = this.f64288h;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return null;
        }
        return this.f64288h.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.f64288h != null && i2 >= 0 && i2 <= getCount() && i2 < this.f64288h.size()) {
            Object obj = this.f64288h.get(i2);
            if (obj instanceof a.e) {
                return 0;
            }
            if (obj instanceof String) {
                return 1;
            }
            if (obj instanceof a.C1652a) {
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
        ArrayList<a.C1652a> arrayList;
        this.f64288h.clear();
        if (aVar == null || aVar.f64266a == null || (list = aVar.f64267b) == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(aVar.f64266a);
        for (a.c cVar : list) {
            if (cVar != null && !TextUtils.isEmpty(cVar.f64276a) && (arrayList = cVar.f64277b) != null && arrayList.size() != 0 && g(cVar.f64277b)) {
                arrayList2.add(cVar.f64276a);
                Iterator<a.C1652a> it = cVar.f64277b.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next());
                }
            }
        }
        this.f64288h.addAll(arrayList2);
        notifyDataSetChanged();
    }
}
