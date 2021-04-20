package d.b.i0.q.e.a;

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
    public static SparseArray<Integer> f58977h = new SparseArray<>();
    public static HashMap<b, Integer> i = new HashMap<>();
    public static HashMap<b, Integer> j = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public NewFriendsActivity f58978e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.e1.g.a> f58979f;

    /* renamed from: g  reason: collision with root package name */
    public c f58980g;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f58981a;

        public b(boolean z) {
            this.f58981a = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && b.class == obj.getClass() && this.f58981a == ((b) obj).f58981a;
        }

        public int hashCode() {
            return 31 + (this.f58981a ? 1231 : 1237);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i, int i2, View view, d.b.i0.e1.g.a aVar);
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f58982a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58983b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58984c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58985d;

        public d() {
        }

        public void a(d.b.i0.e1.g.a aVar) {
            boolean z = false;
            this.f58982a.W(aVar.e(), 12, false);
            this.f58983b.setText(aVar.d());
            if (!TextUtils.isEmpty(aVar.a())) {
                this.f58984c.setText(aVar.a());
            } else {
                this.f58984c.setText("");
            }
            int f2 = aVar.f();
            this.f58985d.setText(((Integer) a.f58977h.get(f2)).intValue());
            this.f58985d.setEnabled((f2 == 0 || f2 == 1) ? true : true);
        }
    }

    static {
        f58977h.put(0, Integer.valueOf(R.string.add));
        f58977h.put(4, Integer.valueOf(R.string.added));
        f58977h.put(1, Integer.valueOf(R.string.pass));
        f58977h.put(2, Integer.valueOf(R.string.passed));
        f58977h.put(3, Integer.valueOf(R.string.waiting));
        i.put(new b(false), Integer.valueOf(R.drawable.btn_pass));
        i.put(new b(true), Integer.valueOf(R.drawable.btn_all_blue));
        j.put(new b(false), Integer.valueOf(R.color.btn_pass_text_color));
        j.put(new b(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.f58978e = newFriendsActivity;
    }

    public final int b(long j2) {
        List<d.b.i0.e1.g.a> list = this.f58979f;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (j2 == this.f58979f.get(i2).b()) {
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
    public d.b.i0.e1.g.a getItem(int i2) {
        return this.f58979f.get(i2);
    }

    public synchronized void d(d.b.i0.e1.g.a aVar) {
        if (this.f58979f != null) {
            this.f58979f.remove(aVar);
        }
    }

    public void e(List<d.b.i0.e1.g.a> list) {
        this.f58979f = list;
    }

    public void f(c cVar) {
        this.f58980g = cVar;
    }

    public void g(d.b.i0.e1.g.a aVar) {
        if (this.f58979f == null) {
            this.f58979f = new ArrayList();
        }
        if (aVar == null || aVar.b() == 0) {
            return;
        }
        int b2 = b(aVar.b());
        if (b2 != -1) {
            this.f58979f.remove(b2);
            this.f58979f.add(0, aVar);
            return;
        }
        this.f58979f.add(0, aVar);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.i0.e1.g.a> list = this.f58979f;
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
            dVar.f58982a = (HeadImageView) view.findViewById(R.id.friend_icon);
            dVar.f58983b = (TextView) view.findViewById(R.id.friend_name);
            dVar.f58984c = (TextView) view.findViewById(R.id.friend_info);
            dVar.f58985d = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(dVar);
        }
        d.b.i0.e1.g.a item = getItem(i2);
        dVar.a(item);
        dVar.f58985d.setTag(Integer.valueOf(i2));
        dVar.f58985d.setOnClickListener(this);
        this.f58978e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f58978e.getLayoutMode().j(view);
        Integer num = i.get(new b(item.f() == 1));
        if (num != null) {
            SkinManager.setBackgroundResource(dVar.f58985d, num.intValue());
        }
        Integer num2 = j.get(new b(item.f() == 1));
        if (num2 != null) {
            SkinManager.setViewTextColor(dVar.f58985d, num2.intValue(), 1);
        }
        return view;
    }

    public void h(List<d.b.i0.e1.g.a> list) {
        if (this.f58979f == null) {
            this.f58979f = new ArrayList();
        }
        if (list != null) {
            for (d.b.i0.e1.g.a aVar : list) {
                g(aVar);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f58980g != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.f58980g.a(id, intValue, view, getItem(intValue));
        }
    }
}
