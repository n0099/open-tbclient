package d.b.j0.q.e.a;

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
    public static SparseArray<Integer> f59398h = new SparseArray<>();
    public static HashMap<b, Integer> i = new HashMap<>();
    public static HashMap<b, Integer> j = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public NewFriendsActivity f59399e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.j0.e1.g.a> f59400f;

    /* renamed from: g  reason: collision with root package name */
    public c f59401g;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f59402a;

        public b(boolean z) {
            this.f59402a = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && b.class == obj.getClass() && this.f59402a == ((b) obj).f59402a;
        }

        public int hashCode() {
            return 31 + (this.f59402a ? 1231 : 1237);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i, int i2, View view, d.b.j0.e1.g.a aVar);
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f59403a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59404b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59405c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59406d;

        public d() {
        }

        public void a(d.b.j0.e1.g.a aVar) {
            boolean z = false;
            this.f59403a.W(aVar.e(), 12, false);
            this.f59404b.setText(aVar.d());
            if (!TextUtils.isEmpty(aVar.a())) {
                this.f59405c.setText(aVar.a());
            } else {
                this.f59405c.setText("");
            }
            int f2 = aVar.f();
            this.f59406d.setText(((Integer) a.f59398h.get(f2)).intValue());
            this.f59406d.setEnabled((f2 == 0 || f2 == 1) ? true : true);
        }
    }

    static {
        f59398h.put(0, Integer.valueOf(R.string.add));
        f59398h.put(4, Integer.valueOf(R.string.added));
        f59398h.put(1, Integer.valueOf(R.string.pass));
        f59398h.put(2, Integer.valueOf(R.string.passed));
        f59398h.put(3, Integer.valueOf(R.string.waiting));
        i.put(new b(false), Integer.valueOf(R.drawable.btn_pass));
        i.put(new b(true), Integer.valueOf(R.drawable.btn_all_blue));
        j.put(new b(false), Integer.valueOf(R.color.btn_pass_text_color));
        j.put(new b(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.f59399e = newFriendsActivity;
    }

    public final int b(long j2) {
        List<d.b.j0.e1.g.a> list = this.f59400f;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (j2 == this.f59400f.get(i2).b()) {
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
    public d.b.j0.e1.g.a getItem(int i2) {
        return this.f59400f.get(i2);
    }

    public synchronized void d(d.b.j0.e1.g.a aVar) {
        if (this.f59400f != null) {
            this.f59400f.remove(aVar);
        }
    }

    public void e(List<d.b.j0.e1.g.a> list) {
        this.f59400f = list;
    }

    public void f(c cVar) {
        this.f59401g = cVar;
    }

    public void g(d.b.j0.e1.g.a aVar) {
        if (this.f59400f == null) {
            this.f59400f = new ArrayList();
        }
        if (aVar == null || aVar.b() == 0) {
            return;
        }
        int b2 = b(aVar.b());
        if (b2 != -1) {
            this.f59400f.remove(b2);
            this.f59400f.add(0, aVar);
            return;
        }
        this.f59400f.add(0, aVar);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.j0.e1.g.a> list = this.f59400f;
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
            dVar.f59403a = (HeadImageView) view.findViewById(R.id.friend_icon);
            dVar.f59404b = (TextView) view.findViewById(R.id.friend_name);
            dVar.f59405c = (TextView) view.findViewById(R.id.friend_info);
            dVar.f59406d = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(dVar);
        }
        d.b.j0.e1.g.a item = getItem(i2);
        dVar.a(item);
        dVar.f59406d.setTag(Integer.valueOf(i2));
        dVar.f59406d.setOnClickListener(this);
        this.f59399e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f59399e.getLayoutMode().j(view);
        Integer num = i.get(new b(item.f() == 1));
        if (num != null) {
            SkinManager.setBackgroundResource(dVar.f59406d, num.intValue());
        }
        Integer num2 = j.get(new b(item.f() == 1));
        if (num2 != null) {
            SkinManager.setViewTextColor(dVar.f59406d, num2.intValue(), 1);
        }
        return view;
    }

    public void h(List<d.b.j0.e1.g.a> list) {
        if (this.f59400f == null) {
            this.f59400f = new ArrayList();
        }
        if (list != null) {
            for (d.b.j0.e1.g.a aVar : list) {
                g(aVar);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f59401g != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.f59401g.a(id, intValue, view, getItem(intValue));
        }
    }
}
