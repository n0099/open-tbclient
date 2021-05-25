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
    public ArrayList<c> f39239a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f39240b;

    /* renamed from: c  reason: collision with root package name */
    public a f39241c = null;

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
        public long f39242a;

        /* renamed from: b  reason: collision with root package name */
        public int f39243b;

        /* renamed from: c  reason: collision with root package name */
        public TypeAdapter.ViewHolder f39244c;

        /* renamed from: d  reason: collision with root package name */
        public Object f39245d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f39246e;

        public c(d dVar) {
        }
    }

    public d() {
        this.f39239a = null;
        this.f39240b = null;
        this.f39239a = new ArrayList<>();
        this.f39240b = new ArrayList<>();
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i2) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f39244c = new TypeAdapter.ViewHolder(view);
        cVar.f39245d = obj;
        cVar.f39246e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f39243b = id;
        cVar.f39242a = id;
        view.setTag("FOOTER");
        if (i2 >= 0 && i2 <= this.f39240b.size()) {
            this.f39240b.add(i2, cVar);
        } else {
            this.f39240b.add(cVar);
        }
    }

    public void b(View view, Object obj, boolean z, boolean z2, int i2) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f39244c = new TypeAdapter.ViewHolder(view);
        cVar.f39245d = obj;
        cVar.f39246e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f39243b = id;
        cVar.f39242a = id;
        view.setTag("HEADER");
        if (i2 >= 0 && i2 <= this.f39239a.size()) {
            this.f39239a.add(i2, cVar);
        } else {
            this.f39239a.add(cVar);
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
        for (int i2 = 0; i2 < this.f39240b.size(); i2++) {
            c cVar = this.f39240b.get(i2);
            if (cVar != null && (viewHolder = cVar.f39244c) != null && viewHolder.itemView == view) {
                return i2;
            }
        }
        return -1;
    }

    public c e(int i2) {
        Iterator<c> it = this.f39240b.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i2 == next.f39243b) {
                return next;
            }
        }
        return null;
    }

    public int f(View view) {
        TypeAdapter.ViewHolder viewHolder;
        for (int i2 = 0; i2 < this.f39239a.size(); i2++) {
            c cVar = this.f39239a.get(i2);
            if (cVar != null && (viewHolder = cVar.f39244c) != null && viewHolder.itemView == view) {
                return i2;
            }
        }
        return -1;
    }

    public c g(int i2) {
        Iterator<c> it = this.f39239a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i2 == next.f39243b) {
                return next;
            }
        }
        return null;
    }

    public int h() {
        return this.f39240b.size();
    }

    public int i() {
        return this.f39239a.size();
    }

    public boolean j(View view) {
        TypeAdapter.ViewHolder viewHolder;
        if (view == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.f39240b.size(); i2++) {
            c cVar = this.f39240b.get(i2);
            if (cVar != null && (viewHolder = cVar.f39244c) != null && viewHolder.itemView == view) {
                this.f39240b.remove(i2);
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
        for (int i2 = 0; i2 < this.f39239a.size(); i2++) {
            c cVar = this.f39239a.get(i2);
            if (cVar != null && (viewHolder = cVar.f39244c) != null && viewHolder.itemView == view) {
                this.f39239a.remove(i2);
                return true;
            }
        }
        return false;
    }

    public void l(a aVar) {
        this.f39241c = aVar;
    }
}
