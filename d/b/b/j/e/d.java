package d.b.b.j.e;

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
    public ArrayList<c> f42367a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f42368b;

    /* renamed from: c  reason: collision with root package name */
    public a f42369c = null;

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
        public long f42370a;

        /* renamed from: b  reason: collision with root package name */
        public int f42371b;

        /* renamed from: c  reason: collision with root package name */
        public TypeAdapter.ViewHolder f42372c;

        /* renamed from: d  reason: collision with root package name */
        public Object f42373d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f42374e;

        public c(d dVar) {
        }
    }

    public d() {
        this.f42367a = null;
        this.f42368b = null;
        this.f42367a = new ArrayList<>();
        this.f42368b = new ArrayList<>();
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f42372c = new TypeAdapter.ViewHolder(view);
        cVar.f42373d = obj;
        cVar.f42374e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f42371b = id;
        cVar.f42370a = id;
        view.setTag("FOOTER");
        if (i >= 0 && i <= this.f42368b.size()) {
            this.f42368b.add(i, cVar);
        } else {
            this.f42368b.add(cVar);
        }
    }

    public void b(View view, Object obj, boolean z, boolean z2, int i) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f42372c = new TypeAdapter.ViewHolder(view);
        cVar.f42373d = obj;
        cVar.f42374e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f42371b = id;
        cVar.f42370a = id;
        view.setTag("HEADER");
        if (i >= 0 && i <= this.f42367a.size()) {
            this.f42367a.add(i, cVar);
        } else {
            this.f42367a.add(cVar);
        }
    }

    public TypeAdapter.ViewHolder c(Context context) {
        TextView textView = new TextView(context);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
        int e2 = d.b.b.e.p.l.e(context, 15.0f);
        textView.setPadding(e2, e2, e2, e2);
        textView.setHeight(0);
        return new b(this, textView);
    }

    public int d(View view) {
        TypeAdapter.ViewHolder viewHolder;
        for (int i = 0; i < this.f42368b.size(); i++) {
            c cVar = this.f42368b.get(i);
            if (cVar != null && (viewHolder = cVar.f42372c) != null && viewHolder.itemView == view) {
                return i;
            }
        }
        return -1;
    }

    public c e(int i) {
        Iterator<c> it = this.f42368b.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i == next.f42371b) {
                return next;
            }
        }
        return null;
    }

    public int f(View view) {
        TypeAdapter.ViewHolder viewHolder;
        for (int i = 0; i < this.f42367a.size(); i++) {
            c cVar = this.f42367a.get(i);
            if (cVar != null && (viewHolder = cVar.f42372c) != null && viewHolder.itemView == view) {
                return i;
            }
        }
        return -1;
    }

    public c g(int i) {
        Iterator<c> it = this.f42367a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i == next.f42371b) {
                return next;
            }
        }
        return null;
    }

    public int h() {
        return this.f42368b.size();
    }

    public int i() {
        return this.f42367a.size();
    }

    public boolean j(View view) {
        TypeAdapter.ViewHolder viewHolder;
        if (view == null) {
            return false;
        }
        for (int i = 0; i < this.f42368b.size(); i++) {
            c cVar = this.f42368b.get(i);
            if (cVar != null && (viewHolder = cVar.f42372c) != null && viewHolder.itemView == view) {
                this.f42368b.remove(i);
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
        for (int i = 0; i < this.f42367a.size(); i++) {
            c cVar = this.f42367a.get(i);
            if (cVar != null && (viewHolder = cVar.f42372c) != null && viewHolder.itemView == view) {
                this.f42367a.remove(i);
                return true;
            }
        }
        return false;
    }

    public void l(a aVar) {
        this.f42369c = aVar;
    }
}
