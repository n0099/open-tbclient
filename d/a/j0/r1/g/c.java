package d.a.j0.r1.g;

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
import d.a.j0.r1.g.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public MemberPrivilegeActivity f59726e;

    /* renamed from: f  reason: collision with root package name */
    public int f59727f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59728g = false;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f59729h = new ArrayList<>();

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f59730a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f59731b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f59732c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59733d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f59734e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f59735f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f59736g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f59737h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f59738i;
        public ImageView j;
        public ImageView k;
        public TextView l;
        public TextView m;

        public b() {
        }
    }

    /* renamed from: d.a.j0.r1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1511c {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f59739a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59740b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59741c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f59742d;

        public C1511c() {
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public TextView f59743a;

        public d() {
        }
    }

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.f59726e = memberPrivilegeActivity;
    }

    public final SpannableString a(String str) {
        SpannableString spannableString = new SpannableString(this.f59726e.getResources().getString(R.string.endtime_days_tip, str));
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
        return spannableString;
    }

    public void b(ArrayList<a.C1510a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1510a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1510a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f59712d) && TextUtils.getTrimmedLength(next.f59712d) > 0) {
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
            inflate = LayoutInflater.from(this.f59726e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
            bVar = new b();
            bVar.f59730a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
            bVar.f59731b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
            bVar.f59734e = (TextView) inflate.findViewById(R.id.nonmembername);
            bVar.f59732c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
            bVar.f59733d = (TextView) inflate.findViewById(R.id.membername);
            bVar.f59735f = (TbImageView) inflate.findViewById(R.id.membericon);
            bVar.j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
            bVar.k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
            bVar.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
            bVar.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
            bVar.f59736g = (TextView) inflate.findViewById(R.id.endtime);
            bVar.f59737h = (TextView) inflate.findViewById(R.id.left_button);
            bVar.f59738i = (TextView) inflate.findViewById(R.id.right_button);
            inflate.setTag(bVar);
        }
        if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
            bVar.f59738i.setVisibility(8);
        } else {
            bVar.f59738i.setVisibility(0);
        }
        if (getItem(i2) == null || (eVar = (a.e) getItem(i2)) == null || (bVar2 = eVar.f59724d) == null || (dVar = eVar.f59725e) == null) {
            return null;
        }
        long j = dVar.f59719a + dVar.f59720b;
        this.f59727f = (int) bVar2.f59713a;
        long j2 = bVar2.f59714b;
        String e2 = e(j2, bVar2.f59715c);
        bVar.f59730a.V(eVar.f59723c, 25, false);
        SkinManager.setBackgroundResource(bVar.f59730a, R.drawable.memberinfo_bg_shape);
        if (!dVar.a()) {
            j = 0;
        }
        if (bVar2.a() && dVar.a()) {
            bVar.f59731b.setVisibility(8);
            bVar.f59732c.setVisibility(0);
            bVar.f59735f.V(eVar.f59724d.f59716d, 21, false);
            if (this.f59728g) {
                bVar.f59736g.setText(a(e2));
                i3 = 1;
            } else {
                if (1 == this.f59727f) {
                    string = this.f59726e.getPageContext().getString(R.string.member);
                } else {
                    string = this.f59726e.getPageContext().getString(R.string.vip_member);
                }
                i3 = 1;
                bVar.f59736g.setText(this.f59726e.getResources().getString(R.string.endtiem_memeber_tip, string, k.getDateStringDay(new Date(j2 * 1000))));
                SkinManager.setViewTextColor(bVar.f59736g, R.color.CAM_X0101, 1);
            }
            bVar.f59733d.setText(eVar.f59722b);
            bVar.f59737h.setText(this.f59727f == i3 ? R.string.continue_member : R.string.continue_vip_member);
            bVar.f59737h.setOnClickListener(this.f59726e);
            bVar.l.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.j, R.drawable.icon_vip_dou);
        } else {
            bVar.f59731b.setVisibility(0);
            bVar.f59732c.setVisibility(8);
            bVar.f59734e.setText(eVar.f59722b);
            bVar.f59737h.setText(R.string.dredge_member);
            bVar.f59737h.setOnClickListener(this.f59726e);
            bVar.m.setText(String.valueOf(j));
            SkinManager.setImageResource(bVar.k, R.drawable.icon_vip_dou);
        }
        SkinManager.setBackgroundResource(bVar.f59736g, R.drawable.bg_dredge_tips);
        bVar.f59738i.setOnClickListener(this.f59726e);
        this.f59726e.getLayoutMode().k(z);
        this.f59726e.getLayoutMode().j(inflate);
        return inflate;
    }

    public final View d(int i2, View view, ViewGroup viewGroup) {
        C1511c c1511c;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1511c)) {
            c1511c = (C1511c) view.getTag();
        } else {
            view = LayoutInflater.from(this.f59726e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
            c1511c = new C1511c();
            c1511c.f59739a = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1511c.f59740b = (TextView) view.findViewById(R.id.title);
            c1511c.f59741c = (TextView) view.findViewById(R.id.description);
            c1511c.f59742d = (ImageView) view.findViewById(R.id.divide_line_top);
            view.setTag(c1511c);
        }
        if (getItemViewType(i2 - 1) == 1) {
            c1511c.f59742d.setVisibility(8);
        }
        a.C1510a c1510a = (a.C1510a) getItem(i2);
        c1511c.f59739a.V(c1510a.f59709a, 10, false);
        c1511c.f59740b.setText(c1510a.f59710b);
        c1511c.f59741c.setText(c1510a.f59711c);
        this.f59726e.getLayoutMode().k(z);
        this.f59726e.getLayoutMode().j(view);
        return view;
    }

    public final String e(long j, long j2) {
        long j3 = j - j2;
        int i2 = (0L > j3 ? 1 : (0L == j3 ? 0 : -1));
        if (i2 >= 0 || j3 > 345600) {
            return "";
        }
        this.f59728g = true;
        if (i2 >= 0 || j3 > 86400) {
            return (86400 >= j3 || j3 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j3 || j3 > 259200) ? "3" : "2" : "1";
        }
        return this.f59726e.getPageContext().getString(R.string.today);
    }

    public final View f(int i2, View view, ViewGroup viewGroup) {
        d dVar;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view != null && view.getTag() != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        } else {
            view = LayoutInflater.from(this.f59726e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
            dVar = new d();
            dVar.f59743a = (TextView) view.findViewById(R.id.title_view);
            view.setTag(dVar);
        }
        dVar.f59743a.setText((String) getItem(i2));
        this.f59726e.getLayoutMode().k(z);
        this.f59726e.getLayoutMode().j(view);
        return view;
    }

    public boolean g(ArrayList<a.C1510a> arrayList) {
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
        ArrayList<Object> arrayList = this.f59729h;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<Object> arrayList = this.f59729h;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return null;
        }
        return this.f59729h.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.f59729h != null && i2 >= 0 && i2 <= getCount() && i2 < this.f59729h.size()) {
            Object obj = this.f59729h.get(i2);
            if (obj instanceof a.e) {
                return 0;
            }
            if (obj instanceof String) {
                return 1;
            }
            if (obj instanceof a.C1510a) {
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

    public void h(d.a.j0.r1.g.a aVar) {
        List<a.c> list;
        ArrayList<a.C1510a> arrayList;
        this.f59729h.clear();
        if (aVar == null || aVar.f59707a == null || (list = aVar.f59708b) == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(aVar.f59707a);
        for (a.c cVar : list) {
            if (cVar != null && !TextUtils.isEmpty(cVar.f59717a) && (arrayList = cVar.f59718b) != null && arrayList.size() != 0 && g(cVar.f59718b)) {
                arrayList2.add(cVar.f59717a);
                Iterator<a.C1510a> it = cVar.f59718b.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next());
                }
            }
        }
        this.f59729h.addAll(arrayList2);
        notifyDataSetChanged();
    }
}
