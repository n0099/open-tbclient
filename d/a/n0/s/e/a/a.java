package d.a.n0.s.e.a;

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
    public static SparseArray<Integer> f60341h = new SparseArray<>();

    /* renamed from: i  reason: collision with root package name */
    public static HashMap<b, Integer> f60342i = new HashMap<>();
    public static HashMap<b, Integer> j = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public NewFriendsActivity f60343e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.n0.f1.g.a> f60344f;

    /* renamed from: g  reason: collision with root package name */
    public c f60345g;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f60346a;

        public b(boolean z) {
            this.f60346a = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && b.class == obj.getClass() && this.f60346a == ((b) obj).f60346a;
        }

        public int hashCode() {
            return 31 + (this.f60346a ? 1231 : 1237);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i2, int i3, View view, d.a.n0.f1.g.a aVar);
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f60347a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60348b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60349c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60350d;

        public d() {
        }

        public void a(d.a.n0.f1.g.a aVar) {
            boolean z = false;
            this.f60347a.V(aVar.e(), 12, false);
            this.f60348b.setText(aVar.d());
            if (!TextUtils.isEmpty(aVar.a())) {
                this.f60349c.setText(aVar.a());
            } else {
                this.f60349c.setText("");
            }
            int f2 = aVar.f();
            this.f60350d.setText(((Integer) a.f60341h.get(f2)).intValue());
            this.f60350d.setEnabled((f2 == 0 || f2 == 1) ? true : true);
        }
    }

    static {
        f60341h.put(0, Integer.valueOf(R.string.add));
        f60341h.put(4, Integer.valueOf(R.string.added));
        f60341h.put(1, Integer.valueOf(R.string.pass));
        f60341h.put(2, Integer.valueOf(R.string.passed));
        f60341h.put(3, Integer.valueOf(R.string.waiting));
        f60342i.put(new b(false), Integer.valueOf(R.drawable.btn_pass));
        f60342i.put(new b(true), Integer.valueOf(R.drawable.btn_all_blue));
        j.put(new b(false), Integer.valueOf(R.color.btn_pass_text_color));
        j.put(new b(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.f60343e = newFriendsActivity;
    }

    public final int b(long j2) {
        List<d.a.n0.f1.g.a> list = this.f60344f;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (j2 == this.f60344f.get(i2).b()) {
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
    public d.a.n0.f1.g.a getItem(int i2) {
        return this.f60344f.get(i2);
    }

    public synchronized void d(d.a.n0.f1.g.a aVar) {
        if (this.f60344f != null) {
            this.f60344f.remove(aVar);
        }
    }

    public void e(List<d.a.n0.f1.g.a> list) {
        this.f60344f = list;
    }

    public void f(c cVar) {
        this.f60345g = cVar;
    }

    public void g(d.a.n0.f1.g.a aVar) {
        if (this.f60344f == null) {
            this.f60344f = new ArrayList();
        }
        if (aVar == null || aVar.b() == 0) {
            return;
        }
        int b2 = b(aVar.b());
        if (b2 != -1) {
            this.f60344f.remove(b2);
            this.f60344f.add(0, aVar);
            return;
        }
        this.f60344f.add(0, aVar);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.n0.f1.g.a> list = this.f60344f;
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
            dVar.f60347a = (HeadImageView) view.findViewById(R.id.friend_icon);
            dVar.f60348b = (TextView) view.findViewById(R.id.friend_name);
            dVar.f60349c = (TextView) view.findViewById(R.id.friend_info);
            dVar.f60350d = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(dVar);
        }
        d.a.n0.f1.g.a item = getItem(i2);
        dVar.a(item);
        dVar.f60350d.setTag(Integer.valueOf(i2));
        dVar.f60350d.setOnClickListener(this);
        this.f60343e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f60343e.getLayoutMode().j(view);
        Integer num = f60342i.get(new b(item.f() == 1));
        if (num != null) {
            SkinManager.setBackgroundResource(dVar.f60350d, num.intValue());
        }
        Integer num2 = j.get(new b(item.f() == 1));
        if (num2 != null) {
            SkinManager.setViewTextColor(dVar.f60350d, num2.intValue(), 1);
        }
        return view;
    }

    public void h(List<d.a.n0.f1.g.a> list) {
        if (this.f60344f == null) {
            this.f60344f = new ArrayList();
        }
        if (list != null) {
            for (d.a.n0.f1.g.a aVar : list) {
                g(aVar);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f60345g != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.f60345g.a(id, intValue, view, getItem(intValue));
        }
    }
}
