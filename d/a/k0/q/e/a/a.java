package d.a.k0.q.e.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes4.dex */
public class a extends BaseAdapter implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public static SparseArray<Integer> f58178h = new SparseArray<>();

    /* renamed from: i  reason: collision with root package name */
    public static HashMap<b, Integer> f58179i = new HashMap<>();
    public static HashMap<b, Integer> j = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public NewFriendsActivity f58180e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.k0.e1.g.a> f58181f;

    /* renamed from: g  reason: collision with root package name */
    public c f58182g;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f58183a;

        public b(boolean z) {
            this.f58183a = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && b.class == obj.getClass() && this.f58183a == ((b) obj).f58183a;
        }

        public int hashCode() {
            return 31 + (this.f58183a ? 1231 : 1237);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i2, int i3, View view, d.a.k0.e1.g.a aVar);
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f58184a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58185b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58186c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58187d;

        public d() {
        }

        public void a(d.a.k0.e1.g.a aVar) {
            boolean z = false;
            this.f58184a.V(aVar.e(), 12, false);
            this.f58185b.setText(aVar.d());
            if (!TextUtils.isEmpty(aVar.a())) {
                this.f58186c.setText(aVar.a());
            } else {
                this.f58186c.setText("");
            }
            int f2 = aVar.f();
            this.f58187d.setText(((Integer) a.f58178h.get(f2)).intValue());
            this.f58187d.setEnabled((f2 == 0 || f2 == 1) ? true : true);
        }
    }

    static {
        f58178h.put(0, Integer.valueOf(R.string.add));
        f58178h.put(4, Integer.valueOf(R.string.added));
        f58178h.put(1, Integer.valueOf(R.string.pass));
        f58178h.put(2, Integer.valueOf(R.string.passed));
        f58178h.put(3, Integer.valueOf(R.string.waiting));
        f58179i.put(new b(false), Integer.valueOf(R.drawable.btn_pass));
        f58179i.put(new b(true), Integer.valueOf(R.drawable.btn_all_blue));
        j.put(new b(false), Integer.valueOf(R.color.btn_pass_text_color));
        j.put(new b(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.f58180e = newFriendsActivity;
    }

    public final int b(long j2) {
        List<d.a.k0.e1.g.a> list = this.f58181f;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (j2 == this.f58181f.get(i2).b()) {
                    return i2;
                }
            }
            return -1;
        }
        return -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d.a.k0.e1.g.a getItem(int i2) {
        return this.f58181f.get(i2);
    }

    public synchronized void d(d.a.k0.e1.g.a aVar) {
        if (this.f58181f != null) {
            this.f58181f.remove(aVar);
        }
    }

    public void e(List<d.a.k0.e1.g.a> list) {
        this.f58181f = list;
    }

    public void f(c cVar) {
        this.f58182g = cVar;
    }

    public void g(d.a.k0.e1.g.a aVar) {
        if (this.f58181f == null) {
            this.f58181f = new ArrayList();
        }
        if (aVar == null || aVar.b() == 0) {
            return;
        }
        int b2 = b(aVar.b());
        if (b2 != -1) {
            this.f58181f.remove(b2);
            this.f58181f.add(0, aVar);
            return;
        }
        this.f58181f.add(0, aVar);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.k0.e1.g.a> list = this.f58181f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        d dVar;
        if (view != null && view.getTag() != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_new_friend_list_item, (ViewGroup) null);
            dVar = new d();
            dVar.f58184a = (HeadImageView) view.findViewById(R.id.friend_icon);
            dVar.f58185b = (TextView) view.findViewById(R.id.friend_name);
            dVar.f58186c = (TextView) view.findViewById(R.id.friend_info);
            dVar.f58187d = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(dVar);
        }
        d.a.k0.e1.g.a item = getItem(i2);
        dVar.a(item);
        dVar.f58187d.setTag(Integer.valueOf(i2));
        dVar.f58187d.setOnClickListener(this);
        this.f58180e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f58180e.getLayoutMode().j(view);
        Integer num = f58179i.get(new b(item.f() == 1));
        if (num != null) {
            SkinManager.setBackgroundResource(dVar.f58187d, num.intValue());
        }
        Integer num2 = j.get(new b(item.f() == 1));
        if (num2 != null) {
            SkinManager.setViewTextColor(dVar.f58187d, num2.intValue(), 1);
        }
        return view;
    }

    public void h(List<d.a.k0.e1.g.a> list) {
        if (this.f58181f == null) {
            this.f58181f = new ArrayList();
        }
        if (list != null) {
            for (d.a.k0.e1.g.a aVar : list) {
                g(aVar);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f58182g != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.f58182g.a(id, intValue, view, getItem(intValue));
        }
    }
}
