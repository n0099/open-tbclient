package d.b.j0.r1.g;

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
import d.b.c.e.p.k;
import d.b.j0.r1.g.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public MemberPrivilegeActivity f61574e;

    /* renamed from: f  reason: collision with root package name */
    public int f61575f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61576g = false;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f61577h = new ArrayList<>();

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f61578a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f61579b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f61580c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61581d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61582e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f61583f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61584g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f61585h;
        public TextView i;
        public ImageView j;
        public ImageView k;
        public TextView l;
        public TextView m;

        public b() {
        }
    }

    /* renamed from: d.b.j0.r1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1572c {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f61586a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61587b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61588c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f61589d;

        public C1572c() {
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61590a;

        public d() {
        }
    }

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.f61574e = memberPrivilegeActivity;
    }

    public final SpannableString a(String str) {
        SpannableString spannableString = new SpannableString(this.f61574e.getResources().getString(R.string.endtime_days_tip, str));
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
        return spannableString;
    }

    public void b(ArrayList<a.C1571a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1571a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1571a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f61560d) && TextUtils.getTrimmedLength(next.f61560d) > 0) {
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
            inflate = LayoutInflater.from(this.f61574e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
            bVar = new b();
            bVar.f61578a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
            bVar.f61579b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
            bVar.f61582e = (TextView) inflate.findViewById(R.id.nonmembername);
            bVar.f61580c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
            bVar.f61581d = (TextView) inflate.findViewById(R.id.membername);
            bVar.f61583f = (TbImageView) inflate.findViewById(R.id.membericon);
            bVar.j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
            bVar.k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
            bVar.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
            bVar.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
            bVar.f61584g = (TextView) inflate.findViewById(R.id.endtime);
            bVar.f61585h = (TextView) inflate.findViewById(R.id.left_button);
            bVar.i = (TextView) inflate.findViewById(R.id.right_button);
            inflate.setTag(bVar);
        }
        if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
            bVar.i.setVisibility(8);
        } else {
            bVar.i.setVisibility(0);
        }
        if (getItem(i) == null || (eVar = (a.e) getItem(i)) == null || (bVar2 = eVar.f61572d) == null || (dVar = eVar.f61573e) == null) {
            return null;
        }
        long j = dVar.f61567a + dVar.f61568b;
        this.f61575f = (int) bVar2.f61561a;
        long j2 = bVar2.f61562b;
        String e2 = e(j2, bVar2.f61563c);
        bVar.f61578a.W(eVar.f61571c, 25, false);
        SkinManager.setBackgroundResource(bVar.f61578a, R.drawable.memberinfo_bg_shape);
        if (!dVar.a()) {
            j = 0;
        }
        if (bVar2.a() && dVar.a()) {
            bVar.f61579b.setVisibility(8);
            bVar.f61580c.setVisibility(0);
            bVar.f61583f.W(eVar.f61572d.f61564d, 21, false);
            if (this.f61576g) {
                bVar.f61584g.setText(a(e2));
                i2 = 1;
            } else {
                if (1 == this.f61575f) {
                    string = this.f61574e.getPageContext().getString(R.string.member);
                } else {
                    string = this.f61574e.getPageContext().getString(R.string.vip_member);
                }
                i2 = 1;
                bVar.f61584g.setText(this.f61574e.getResources().getString(R.string.endtiem_memeber_tip, string, k.getDateStringDay(new Date(j2 * 1000))));
                SkinManager.setViewTextColor(bVar.f61584g, R.color.CAM_X0101, 1);
            }
            bVar.f61581d.setText(eVar.f61570b);
            bVar.f61585h.setText(this.f61575f == i2 ? R.string.continue_member : R.string.continue_vip_member);
            bVar.f61585h.setOnClickListener(this.f61574e);
            bVar.l.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.j, R.drawable.icon_vip_dou);
        } else {
            bVar.f61579b.setVisibility(0);
            bVar.f61580c.setVisibility(8);
            bVar.f61582e.setText(eVar.f61570b);
            bVar.f61585h.setText(R.string.dredge_member);
            bVar.f61585h.setOnClickListener(this.f61574e);
            bVar.m.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.k, R.drawable.icon_vip_dou);
        }
        SkinManager.setBackgroundResource(bVar.f61584g, R.drawable.bg_dredge_tips);
        bVar.i.setOnClickListener(this.f61574e);
        this.f61574e.getLayoutMode().k(z);
        this.f61574e.getLayoutMode().j(inflate);
        return inflate;
    }

    public final View d(int i, View view, ViewGroup viewGroup) {
        C1572c c1572c;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1572c)) {
            c1572c = (C1572c) view.getTag();
        } else {
            view = LayoutInflater.from(this.f61574e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
            c1572c = new C1572c();
            c1572c.f61586a = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1572c.f61587b = (TextView) view.findViewById(R.id.title);
            c1572c.f61588c = (TextView) view.findViewById(R.id.description);
            c1572c.f61589d = (ImageView) view.findViewById(R.id.divide_line_top);
            view.setTag(c1572c);
        }
        if (getItemViewType(i - 1) == 1) {
            c1572c.f61589d.setVisibility(8);
        }
        a.C1571a c1571a = (a.C1571a) getItem(i);
        c1572c.f61586a.W(c1571a.f61557a, 10, false);
        c1572c.f61587b.setText(c1571a.f61558b);
        c1572c.f61588c.setText(c1571a.f61559c);
        this.f61574e.getLayoutMode().k(z);
        this.f61574e.getLayoutMode().j(view);
        return view;
    }

    public final String e(long j, long j2) {
        long j3 = j - j2;
        int i = (0L > j3 ? 1 : (0L == j3 ? 0 : -1));
        if (i >= 0 || j3 > 345600) {
            return "";
        }
        this.f61576g = true;
        if (i >= 0 || j3 > 86400) {
            return (86400 >= j3 || j3 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j3 || j3 > 259200) ? "3" : "2" : "1";
        }
        return this.f61574e.getPageContext().getString(R.string.today);
    }

    public final View f(int i, View view, ViewGroup viewGroup) {
        d dVar;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        } else {
            view = LayoutInflater.from(this.f61574e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
            dVar = new d();
            dVar.f61590a = (TextView) view.findViewById(R.id.title_view);
            view.setTag(dVar);
        }
        dVar.f61590a.setText((String) getItem(i));
        this.f61574e.getLayoutMode().k(z);
        this.f61574e.getLayoutMode().j(view);
        return view;
    }

    public boolean g(ArrayList<a.C1571a> arrayList) {
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
        ArrayList<Object> arrayList = this.f61577h;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<Object> arrayList = this.f61577h;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.f61577h.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.f61577h != null && i >= 0 && i <= getCount() && i < this.f61577h.size()) {
            Object obj = this.f61577h.get(i);
            if (obj instanceof a.e) {
                return 0;
            }
            if (obj instanceof String) {
                return 1;
            }
            if (obj instanceof a.C1571a) {
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

    public void h(d.b.j0.r1.g.a aVar) {
        List<a.c> list;
        ArrayList<a.C1571a> arrayList;
        this.f61577h.clear();
        if (aVar == null || aVar.f61555a == null || (list = aVar.f61556b) == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(aVar.f61555a);
        for (a.c cVar : list) {
            if (cVar != null && !TextUtils.isEmpty(cVar.f61565a) && (arrayList = cVar.f61566b) != null && arrayList.size() != 0 && g(cVar.f61566b)) {
                arrayList2.add(cVar.f61565a);
                Iterator<a.C1571a> it = cVar.f61566b.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next());
                }
            }
        }
        this.f61577h.addAll(arrayList2);
        notifyDataSetChanged();
    }
}
