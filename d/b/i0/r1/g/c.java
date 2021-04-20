package d.b.i0.r1.g;

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
import d.b.i0.r1.g.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public MemberPrivilegeActivity f61153e;

    /* renamed from: f  reason: collision with root package name */
    public int f61154f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61155g = false;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f61156h = new ArrayList<>();

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f61157a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f61158b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f61159c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61160d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61161e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f61162f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61163g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f61164h;
        public TextView i;
        public ImageView j;
        public ImageView k;
        public TextView l;
        public TextView m;

        public b() {
        }
    }

    /* renamed from: d.b.i0.r1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1549c {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f61165a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61166b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61167c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f61168d;

        public C1549c() {
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61169a;

        public d() {
        }
    }

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.f61153e = memberPrivilegeActivity;
    }

    public final SpannableString a(String str) {
        SpannableString spannableString = new SpannableString(this.f61153e.getResources().getString(R.string.endtime_days_tip, str));
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
        return spannableString;
    }

    public void b(ArrayList<a.C1548a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1548a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1548a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f61139d) && TextUtils.getTrimmedLength(next.f61139d) > 0) {
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
            inflate = LayoutInflater.from(this.f61153e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
            bVar = new b();
            bVar.f61157a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
            bVar.f61158b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
            bVar.f61161e = (TextView) inflate.findViewById(R.id.nonmembername);
            bVar.f61159c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
            bVar.f61160d = (TextView) inflate.findViewById(R.id.membername);
            bVar.f61162f = (TbImageView) inflate.findViewById(R.id.membericon);
            bVar.j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
            bVar.k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
            bVar.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
            bVar.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
            bVar.f61163g = (TextView) inflate.findViewById(R.id.endtime);
            bVar.f61164h = (TextView) inflate.findViewById(R.id.left_button);
            bVar.i = (TextView) inflate.findViewById(R.id.right_button);
            inflate.setTag(bVar);
        }
        if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
            bVar.i.setVisibility(8);
        } else {
            bVar.i.setVisibility(0);
        }
        if (getItem(i) == null || (eVar = (a.e) getItem(i)) == null || (bVar2 = eVar.f61151d) == null || (dVar = eVar.f61152e) == null) {
            return null;
        }
        long j = dVar.f61146a + dVar.f61147b;
        this.f61154f = (int) bVar2.f61140a;
        long j2 = bVar2.f61141b;
        String e2 = e(j2, bVar2.f61142c);
        bVar.f61157a.W(eVar.f61150c, 25, false);
        SkinManager.setBackgroundResource(bVar.f61157a, R.drawable.memberinfo_bg_shape);
        if (!dVar.a()) {
            j = 0;
        }
        if (bVar2.a() && dVar.a()) {
            bVar.f61158b.setVisibility(8);
            bVar.f61159c.setVisibility(0);
            bVar.f61162f.W(eVar.f61151d.f61143d, 21, false);
            if (this.f61155g) {
                bVar.f61163g.setText(a(e2));
                i2 = 1;
            } else {
                if (1 == this.f61154f) {
                    string = this.f61153e.getPageContext().getString(R.string.member);
                } else {
                    string = this.f61153e.getPageContext().getString(R.string.vip_member);
                }
                i2 = 1;
                bVar.f61163g.setText(this.f61153e.getResources().getString(R.string.endtiem_memeber_tip, string, k.getDateStringDay(new Date(j2 * 1000))));
                SkinManager.setViewTextColor(bVar.f61163g, R.color.CAM_X0101, 1);
            }
            bVar.f61160d.setText(eVar.f61149b);
            bVar.f61164h.setText(this.f61154f == i2 ? R.string.continue_member : R.string.continue_vip_member);
            bVar.f61164h.setOnClickListener(this.f61153e);
            bVar.l.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.j, R.drawable.icon_vip_dou);
        } else {
            bVar.f61158b.setVisibility(0);
            bVar.f61159c.setVisibility(8);
            bVar.f61161e.setText(eVar.f61149b);
            bVar.f61164h.setText(R.string.dredge_member);
            bVar.f61164h.setOnClickListener(this.f61153e);
            bVar.m.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.k, R.drawable.icon_vip_dou);
        }
        SkinManager.setBackgroundResource(bVar.f61163g, R.drawable.bg_dredge_tips);
        bVar.i.setOnClickListener(this.f61153e);
        this.f61153e.getLayoutMode().k(z);
        this.f61153e.getLayoutMode().j(inflate);
        return inflate;
    }

    public final View d(int i, View view, ViewGroup viewGroup) {
        C1549c c1549c;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1549c)) {
            c1549c = (C1549c) view.getTag();
        } else {
            view = LayoutInflater.from(this.f61153e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
            c1549c = new C1549c();
            c1549c.f61165a = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1549c.f61166b = (TextView) view.findViewById(R.id.title);
            c1549c.f61167c = (TextView) view.findViewById(R.id.description);
            c1549c.f61168d = (ImageView) view.findViewById(R.id.divide_line_top);
            view.setTag(c1549c);
        }
        if (getItemViewType(i - 1) == 1) {
            c1549c.f61168d.setVisibility(8);
        }
        a.C1548a c1548a = (a.C1548a) getItem(i);
        c1549c.f61165a.W(c1548a.f61136a, 10, false);
        c1549c.f61166b.setText(c1548a.f61137b);
        c1549c.f61167c.setText(c1548a.f61138c);
        this.f61153e.getLayoutMode().k(z);
        this.f61153e.getLayoutMode().j(view);
        return view;
    }

    public final String e(long j, long j2) {
        long j3 = j - j2;
        int i = (0L > j3 ? 1 : (0L == j3 ? 0 : -1));
        if (i >= 0 || j3 > 345600) {
            return "";
        }
        this.f61155g = true;
        if (i >= 0 || j3 > 86400) {
            return (86400 >= j3 || j3 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j3 || j3 > 259200) ? "3" : "2" : "1";
        }
        return this.f61153e.getPageContext().getString(R.string.today);
    }

    public final View f(int i, View view, ViewGroup viewGroup) {
        d dVar;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        } else {
            view = LayoutInflater.from(this.f61153e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
            dVar = new d();
            dVar.f61169a = (TextView) view.findViewById(R.id.title_view);
            view.setTag(dVar);
        }
        dVar.f61169a.setText((String) getItem(i));
        this.f61153e.getLayoutMode().k(z);
        this.f61153e.getLayoutMode().j(view);
        return view;
    }

    public boolean g(ArrayList<a.C1548a> arrayList) {
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
        ArrayList<Object> arrayList = this.f61156h;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<Object> arrayList = this.f61156h;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.f61156h.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.f61156h != null && i >= 0 && i <= getCount() && i < this.f61156h.size()) {
            Object obj = this.f61156h.get(i);
            if (obj instanceof a.e) {
                return 0;
            }
            if (obj instanceof String) {
                return 1;
            }
            if (obj instanceof a.C1548a) {
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

    public void h(d.b.i0.r1.g.a aVar) {
        List<a.c> list;
        ArrayList<a.C1548a> arrayList;
        this.f61156h.clear();
        if (aVar == null || aVar.f61134a == null || (list = aVar.f61135b) == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(aVar.f61134a);
        for (a.c cVar : list) {
            if (cVar != null && !TextUtils.isEmpty(cVar.f61144a) && (arrayList = cVar.f61145b) != null && arrayList.size() != 0 && g(cVar.f61145b)) {
                arrayList2.add(cVar.f61144a);
                Iterator<a.C1548a> it = cVar.f61145b.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next());
                }
            }
        }
        this.f61156h.addAll(arrayList2);
        notifyDataSetChanged();
    }
}
