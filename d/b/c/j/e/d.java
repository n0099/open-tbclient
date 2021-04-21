package d.b.c.j.e;

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
    public ArrayList<c> f43104a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f43105b;

    /* renamed from: c  reason: collision with root package name */
    public a f43106c = null;

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
        public long f43107a;

        /* renamed from: b  reason: collision with root package name */
        public int f43108b;

        /* renamed from: c  reason: collision with root package name */
        public TypeAdapter.ViewHolder f43109c;

        /* renamed from: d  reason: collision with root package name */
        public Object f43110d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f43111e;

        public c(d dVar) {
        }
    }

    public d() {
        this.f43104a = null;
        this.f43105b = null;
        this.f43104a = new ArrayList<>();
        this.f43105b = new ArrayList<>();
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f43109c = new TypeAdapter.ViewHolder(view);
        cVar.f43110d = obj;
        cVar.f43111e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f43108b = id;
        cVar.f43107a = id;
        view.setTag("FOOTER");
        if (i >= 0 && i <= this.f43105b.size()) {
            this.f43105b.add(i, cVar);
        } else {
            this.f43105b.add(cVar);
        }
    }

    public void b(View view, Object obj, boolean z, boolean z2, int i) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f43109c = new TypeAdapter.ViewHolder(view);
        cVar.f43110d = obj;
        cVar.f43111e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f43108b = id;
        cVar.f43107a = id;
        view.setTag("HEADER");
        if (i >= 0 && i <= this.f43104a.size()) {
            this.f43104a.add(i, cVar);
        } else {
            this.f43104a.add(cVar);
        }
    }

    public TypeAdapter.ViewHolder c(Context context) {
        TextView textView = new TextView(context);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
        int e2 = d.b.c.e.p.l.e(context, 15.0f);
        textView.setPadding(e2, e2, e2, e2);
        textView.setHeight(0);
        return new b(this, textView);
    }

    public int d(View view) {
        TypeAdapter.ViewHolder viewHolder;
        for (int i = 0; i < this.f43105b.size(); i++) {
            c cVar = this.f43105b.get(i);
            if (cVar != null && (viewHolder = cVar.f43109c) != null && viewHolder.itemView == view) {
                return i;
            }
        }
        return -1;
    }

    public c e(int i) {
        Iterator<c> it = this.f43105b.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i == next.f43108b) {
                return next;
            }
        }
        return null;
    }

    public int f(View view) {
        TypeAdapter.ViewHolder viewHolder;
        for (int i = 0; i < this.f43104a.size(); i++) {
            c cVar = this.f43104a.get(i);
            if (cVar != null && (viewHolder = cVar.f43109c) != null && viewHolder.itemView == view) {
                return i;
            }
        }
        return -1;
    }

    public c g(int i) {
        Iterator<c> it = this.f43104a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i == next.f43108b) {
                return next;
            }
        }
        return null;
    }

    public int h() {
        return this.f43105b.size();
    }

    public int i() {
        return this.f43104a.size();
    }

    public boolean j(View view) {
        TypeAdapter.ViewHolder viewHolder;
        if (view == null) {
            return false;
        }
        for (int i = 0; i < this.f43105b.size(); i++) {
            c cVar = this.f43105b.get(i);
            if (cVar != null && (viewHolder = cVar.f43109c) != null && viewHolder.itemView == view) {
                this.f43105b.remove(i);
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
        for (int i = 0; i < this.f43104a.size(); i++) {
            c cVar = this.f43104a.get(i);
            if (cVar != null && (viewHolder = cVar.f43109c) != null && viewHolder.itemView == view) {
                this.f43104a.remove(i);
                return true;
            }
        }
        return false;
    }

    public void l(a aVar) {
        this.f43106c = aVar;
    }
}
