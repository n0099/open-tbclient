package d.a.k0.r1.g;

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
import d.a.k0.r1.g.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public MemberPrivilegeActivity f60471e;

    /* renamed from: f  reason: collision with root package name */
    public int f60472f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60473g = false;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f60474h = new ArrayList<>();

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f60475a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f60476b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f60477c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60478d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f60479e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f60480f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60481g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f60482h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f60483i;
        public ImageView j;
        public ImageView k;
        public TextView l;
        public TextView m;

        public b() {
        }
    }

    /* renamed from: d.a.k0.r1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1585c {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f60484a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60485b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60486c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f60487d;

        public C1585c() {
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public TextView f60488a;

        public d() {
        }
    }

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.f60471e = memberPrivilegeActivity;
    }

    public final SpannableString a(String str) {
        SpannableString spannableString = new SpannableString(this.f60471e.getResources().getString(R.string.endtime_days_tip, str));
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
        return spannableString;
    }

    public void b(ArrayList<a.C1584a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1584a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1584a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f60457d) && TextUtils.getTrimmedLength(next.f60457d) > 0) {
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
            inflate = LayoutInflater.from(this.f60471e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
            bVar = new b();
            bVar.f60475a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
            bVar.f60476b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
            bVar.f60479e = (TextView) inflate.findViewById(R.id.nonmembername);
            bVar.f60477c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
            bVar.f60478d = (TextView) inflate.findViewById(R.id.membername);
            bVar.f60480f = (TbImageView) inflate.findViewById(R.id.membericon);
            bVar.j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
            bVar.k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
            bVar.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
            bVar.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
            bVar.f60481g = (TextView) inflate.findViewById(R.id.endtime);
            bVar.f60482h = (TextView) inflate.findViewById(R.id.left_button);
            bVar.f60483i = (TextView) inflate.findViewById(R.id.right_button);
            inflate.setTag(bVar);
        }
        if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
            bVar.f60483i.setVisibility(8);
        } else {
            bVar.f60483i.setVisibility(0);
        }
        if (getItem(i2) == null || (eVar = (a.e) getItem(i2)) == null || (bVar2 = eVar.f60469d) == null || (dVar = eVar.f60470e) == null) {
            return null;
        }
        long j = dVar.f60464a + dVar.f60465b;
        this.f60472f = (int) bVar2.f60458a;
        long j2 = bVar2.f60459b;
        String e2 = e(j2, bVar2.f60460c);
        bVar.f60475a.V(eVar.f60468c, 25, false);
        SkinManager.setBackgroundResource(bVar.f60475a, R.drawable.memberinfo_bg_shape);
        if (!dVar.a()) {
            j = 0;
        }
        if (bVar2.a() && dVar.a()) {
            bVar.f60476b.setVisibility(8);
            bVar.f60477c.setVisibility(0);
            bVar.f60480f.V(eVar.f60469d.f60461d, 21, false);
            if (this.f60473g) {
                bVar.f60481g.setText(a(e2));
                i3 = 1;
            } else {
                if (1 == this.f60472f) {
                    string = this.f60471e.getPageContext().getString(R.string.member);
                } else {
                    string = this.f60471e.getPageContext().getString(R.string.vip_member);
                }
                i3 = 1;
                bVar.f60481g.setText(this.f60471e.getResources().getString(R.string.endtiem_memeber_tip, string, k.getDateStringDay(new Date(j2 * 1000))));
                SkinManager.setViewTextColor(bVar.f60481g, R.color.CAM_X0101, 1);
            }
            bVar.f60478d.setText(eVar.f60467b);
            bVar.f60482h.setText(this.f60472f == i3 ? R.string.continue_member : R.string.continue_vip_member);
            bVar.f60482h.setOnClickListener(this.f60471e);
            bVar.l.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.j, R.drawable.icon_vip_dou);
        } else {
            bVar.f60476b.setVisibility(0);
            bVar.f60477c.setVisibility(8);
            bVar.f60479e.setText(eVar.f60467b);
            bVar.f60482h.setText(R.string.dredge_member);
            bVar.f60482h.setOnClickListener(this.f60471e);
            bVar.m.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.k, R.drawable.icon_vip_dou);
        }
        SkinManager.setBackgroundResource(bVar.f60481g, R.drawable.bg_dredge_tips);
        bVar.f60483i.setOnClickListener(this.f60471e);
        this.f60471e.getLayoutMode().k(z);
        this.f60471e.getLayoutMode().j(inflate);
        return inflate;
    }

    public final View d(int i2, View view, ViewGroup viewGroup) {
        C1585c c1585c;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1585c)) {
            c1585c = (C1585c) view.getTag();
        } else {
            view = LayoutInflater.from(this.f60471e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
            c1585c = new C1585c();
            c1585c.f60484a = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1585c.f60485b = (TextView) view.findViewById(R.id.title);
            c1585c.f60486c = (TextView) view.findViewById(R.id.description);
            c1585c.f60487d = (ImageView) view.findViewById(R.id.divide_line_top);
            view.setTag(c1585c);
        }
        if (getItemViewType(i2 - 1) == 1) {
            c1585c.f60487d.setVisibility(8);
        }
        a.C1584a c1584a = (a.C1584a) getItem(i2);
        c1585c.f60484a.V(c1584a.f60454a, 10, false);
        c1585c.f60485b.setText(c1584a.f60455b);
        c1585c.f60486c.setText(c1584a.f60456c);
        this.f60471e.getLayoutMode().k(z);
        this.f60471e.getLayoutMode().j(view);
        return view;
    }

    public final String e(long j, long j2) {
        long j3 = j - j2;
        int i2 = (0L > j3 ? 1 : (0L == j3 ? 0 : -1));
        if (i2 >= 0 || j3 > 345600) {
            return "";
        }
        this.f60473g = true;
        if (i2 >= 0 || j3 > 86400) {
            return (86400 >= j3 || j3 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j3 || j3 > 259200) ? "3" : "2" : "1";
        }
        return this.f60471e.getPageContext().getString(R.string.today);
    }

    public final View f(int i2, View view, ViewGroup viewGroup) {
        d dVar;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        } else {
            view = LayoutInflater.from(this.f60471e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
            dVar = new d();
            dVar.f60488a = (TextView) view.findViewById(R.id.title_view);
            view.setTag(dVar);
        }
        dVar.f60488a.setText((String) getItem(i2));
        this.f60471e.getLayoutMode().k(z);
        this.f60471e.getLayoutMode().j(view);
        return view;
    }

    public boolean g(ArrayList<a.C1584a> arrayList) {
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
        ArrayList<Object> arrayList = this.f60474h;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<Object> arrayList = this.f60474h;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return null;
        }
        return this.f60474h.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.f60474h != null && i2 >= 0 && i2 <= getCount() && i2 < this.f60474h.size()) {
            Object obj = this.f60474h.get(i2);
            if (obj instanceof a.e) {
                return 0;
            }
            if (obj instanceof String) {
                return 1;
            }
            if (obj instanceof a.C1584a) {
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

    public void h(d.a.k0.r1.g.a aVar) {
        List<a.c> list;
        ArrayList<a.C1584a> arrayList;
        this.f60474h.clear();
        if (aVar == null || aVar.f60452a == null || (list = aVar.f60453b) == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(aVar.f60452a);
        for (a.c cVar : list) {
            if (cVar != null && !TextUtils.isEmpty(cVar.f60462a) && (arrayList = cVar.f60463b) != null && arrayList.size() != 0 && g(cVar.f60463b)) {
                arrayList2.add(cVar.f60462a);
                Iterator<a.C1584a> it = cVar.f60463b.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next());
                }
            }
        }
        this.f60474h.addAll(arrayList2);
        notifyDataSetChanged();
    }
}
