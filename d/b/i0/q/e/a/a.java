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
    public static SparseArray<Integer> f59223h = new SparseArray<>();
    public static HashMap<b, Integer> i = new HashMap<>();
    public static HashMap<b, Integer> j = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public NewFriendsActivity f59224e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.d1.g.a> f59225f;

    /* renamed from: g  reason: collision with root package name */
    public c f59226g;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f59227a;

        public b(boolean z) {
            this.f59227a = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && b.class == obj.getClass() && this.f59227a == ((b) obj).f59227a;
        }

        public int hashCode() {
            return 31 + (this.f59227a ? 1231 : 1237);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i, int i2, View view, d.b.i0.d1.g.a aVar);
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f59228a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59229b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59230c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59231d;

        public d() {
        }

        public void a(d.b.i0.d1.g.a aVar) {
            boolean z = false;
            this.f59228a.W(aVar.e(), 12, false);
            this.f59229b.setText(aVar.d());
            if (!TextUtils.isEmpty(aVar.a())) {
                this.f59230c.setText(aVar.a());
            } else {
                this.f59230c.setText("");
            }
            int f2 = aVar.f();
            this.f59231d.setText(((Integer) a.f59223h.get(f2)).intValue());
            this.f59231d.setEnabled((f2 == 0 || f2 == 1) ? true : true);
        }
    }

    static {
        f59223h.put(0, Integer.valueOf(R.string.add));
        f59223h.put(4, Integer.valueOf(R.string.added));
        f59223h.put(1, Integer.valueOf(R.string.pass));
        f59223h.put(2, Integer.valueOf(R.string.passed));
        f59223h.put(3, Integer.valueOf(R.string.waiting));
        i.put(new b(false), Integer.valueOf(R.drawable.btn_pass));
        i.put(new b(true), Integer.valueOf(R.drawable.btn_all_blue));
        j.put(new b(false), Integer.valueOf(R.color.btn_pass_text_color));
        j.put(new b(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.f59224e = newFriendsActivity;
    }

    public final int b(long j2) {
        List<d.b.i0.d1.g.a> list = this.f59225f;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (j2 == this.f59225f.get(i2).b()) {
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
    public d.b.i0.d1.g.a getItem(int i2) {
        return this.f59225f.get(i2);
    }

    public synchronized void d(d.b.i0.d1.g.a aVar) {
        if (this.f59225f != null) {
            this.f59225f.remove(aVar);
        }
    }

    public void e(List<d.b.i0.d1.g.a> list) {
        this.f59225f = list;
    }

    public void f(c cVar) {
        this.f59226g = cVar;
    }

    public void g(d.b.i0.d1.g.a aVar) {
        if (this.f59225f == null) {
            this.f59225f = new ArrayList();
        }
        if (aVar == null || aVar.b() == 0) {
            return;
        }
        int b2 = b(aVar.b());
        if (b2 != -1) {
            this.f59225f.remove(b2);
            this.f59225f.add(0, aVar);
            return;
        }
        this.f59225f.add(0, aVar);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.i0.d1.g.a> list = this.f59225f;
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
            dVar.f59228a = (HeadImageView) view.findViewById(R.id.friend_icon);
            dVar.f59229b = (TextView) view.findViewById(R.id.friend_name);
            dVar.f59230c = (TextView) view.findViewById(R.id.friend_info);
            dVar.f59231d = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(dVar);
        }
        d.b.i0.d1.g.a item = getItem(i2);
        dVar.a(item);
        dVar.f59231d.setTag(Integer.valueOf(i2));
        dVar.f59231d.setOnClickListener(this);
        this.f59224e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f59224e.getLayoutMode().j(view);
        Integer num = i.get(new b(item.f() == 1));
        if (num != null) {
            SkinManager.setBackgroundResource(dVar.f59231d, num.intValue());
        }
        Integer num2 = j.get(new b(item.f() == 1));
        if (num2 != null) {
            SkinManager.setViewTextColor(dVar.f59231d, num2.intValue(), 1);
        }
        return view;
    }

    public void h(List<d.b.i0.d1.g.a> list) {
        if (this.f59225f == null) {
            this.f59225f = new ArrayList();
        }
        if (list != null) {
            for (d.b.i0.d1.g.a aVar : list) {
                g(aVar);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f59226g != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.f59226g.a(id, intValue, view, getItem(intValue));
        }
    }
}
