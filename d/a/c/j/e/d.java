package d.a.c.j.e;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.widget.ListView.TypeAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<c> f40330a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f40331b;

    /* renamed from: c  reason: collision with root package name */
    public a f40332c = null;

    /* loaded from: classes.dex */
    public interface a {
        void onPreLoad();
    }

    /* loaded from: classes.dex */
    public class b extends TypeAdapter.ViewHolder {
        public b(d dVar, View view) {
            super(view);
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public long f40333a;

        /* renamed from: b  reason: collision with root package name */
        public int f40334b;

        /* renamed from: c  reason: collision with root package name */
        public TypeAdapter.ViewHolder f40335c;

        /* renamed from: d  reason: collision with root package name */
        public Object f40336d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f40337e;

        public c(d dVar) {
        }
    }

    public d() {
        this.f40330a = null;
        this.f40331b = null;
        this.f40330a = new ArrayList<>();
        this.f40331b = new ArrayList<>();
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i2) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f40335c = new TypeAdapter.ViewHolder(view);
        cVar.f40336d = obj;
        cVar.f40337e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f40334b = id;
        cVar.f40333a = id;
        view.setTag("FOOTER");
        if (i2 >= 0 && i2 <= this.f40331b.size()) {
            this.f40331b.add(i2, cVar);
        } else {
            this.f40331b.add(cVar);
        }
    }

    public void b(View view, Object obj, boolean z, boolean z2, int i2) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f40335c = new TypeAdapter.ViewHolder(view);
        cVar.f40336d = obj;
        cVar.f40337e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f40334b = id;
        cVar.f40333a = id;
        view.setTag("HEADER");
        if (i2 >= 0 && i2 <= this.f40330a.size()) {
            this.f40330a.add(i2, cVar);
        } else {
            this.f40330a.add(cVar);
        }
    }

    public TypeAdapter.ViewHolder c(Context context) {
        TextView textView = new TextView(context);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
        int e2 = d.a.c.e.p.l.e(context, 15.0f);
        textView.setPadding(e2, e2, e2, e2);
        textView.setHeight(0);
        return new b(this, textView);
    }

    public int d(View view) {
        TypeAdapter.ViewHolder viewHolder;
        for (int i2 = 0; i2 < this.f40331b.size(); i2++) {
            c cVar = this.f40331b.get(i2);
            if (cVar != null && (viewHolder = cVar.f40335c) != null && viewHolder.itemView == view) {
                return i2;
            }
        }
        return -1;
    }

    public c e(int i2) {
        Iterator<c> it = this.f40331b.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i2 == next.f40334b) {
                return next;
            }
        }
        return null;
    }

    public int f(View view) {
        TypeAdapter.ViewHolder viewHolder;
        for (int i2 = 0; i2 < this.f40330a.size(); i2++) {
            c cVar = this.f40330a.get(i2);
            if (cVar != null && (viewHolder = cVar.f40335c) != null && viewHolder.itemView == view) {
                return i2;
            }
        }
        return -1;
    }

    public c g(int i2) {
        Iterator<c> it = this.f40330a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i2 == next.f40334b) {
                return next;
            }
        }
        return null;
    }

    public int h() {
        return this.f40331b.size();
    }

    public int i() {
        return this.f40330a.size();
    }

    public boolean j(View view) {
        TypeAdapter.ViewHolder viewHolder;
        if (view == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.f40331b.size(); i2++) {
            c cVar = this.f40331b.get(i2);
            if (cVar != null && (viewHolder = cVar.f40335c) != null && viewHolder.itemView == view) {
                this.f40331b.remove(i2);
                return true;
            }
        }
        return false;
    }

    public boolean k(View view) {
        TypeAdapter.ViewHolder viewHolder;
        if (view == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.f40330a.size(); i2++) {
            c cVar = this.f40330a.get(i2);
            if (cVar != null && (viewHolder = cVar.f40335c) != null && viewHolder.itemView == view) {
                this.f40330a.remove(i2);
                return true;
            }
        }
        return false;
    }

    public void l(a aVar) {
        this.f40332c = aVar;
    }
}
