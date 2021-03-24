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
    public ArrayList<c> f42366a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f42367b;

    /* renamed from: c  reason: collision with root package name */
    public a f42368c = null;

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
        public long f42369a;

        /* renamed from: b  reason: collision with root package name */
        public int f42370b;

        /* renamed from: c  reason: collision with root package name */
        public TypeAdapter.ViewHolder f42371c;

        /* renamed from: d  reason: collision with root package name */
        public Object f42372d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f42373e;

        public c(d dVar) {
        }
    }

    public d() {
        this.f42366a = null;
        this.f42367b = null;
        this.f42366a = new ArrayList<>();
        this.f42367b = new ArrayList<>();
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f42371c = new TypeAdapter.ViewHolder(view);
        cVar.f42372d = obj;
        cVar.f42373e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f42370b = id;
        cVar.f42369a = id;
        view.setTag("FOOTER");
        if (i >= 0 && i <= this.f42367b.size()) {
            this.f42367b.add(i, cVar);
        } else {
            this.f42367b.add(cVar);
        }
    }

    public void b(View view, Object obj, boolean z, boolean z2, int i) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f42371c = new TypeAdapter.ViewHolder(view);
        cVar.f42372d = obj;
        cVar.f42373e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f42370b = id;
        cVar.f42369a = id;
        view.setTag("HEADER");
        if (i >= 0 && i <= this.f42366a.size()) {
            this.f42366a.add(i, cVar);
        } else {
            this.f42366a.add(cVar);
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
        for (int i = 0; i < this.f42367b.size(); i++) {
            c cVar = this.f42367b.get(i);
            if (cVar != null && (viewHolder = cVar.f42371c) != null && viewHolder.itemView == view) {
                return i;
            }
        }
        return -1;
    }

    public c e(int i) {
        Iterator<c> it = this.f42367b.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i == next.f42370b) {
                return next;
            }
        }
        return null;
    }

    public int f(View view) {
        TypeAdapter.ViewHolder viewHolder;
        for (int i = 0; i < this.f42366a.size(); i++) {
            c cVar = this.f42366a.get(i);
            if (cVar != null && (viewHolder = cVar.f42371c) != null && viewHolder.itemView == view) {
                return i;
            }
        }
        return -1;
    }

    public c g(int i) {
        Iterator<c> it = this.f42366a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i == next.f42370b) {
                return next;
            }
        }
        return null;
    }

    public int h() {
        return this.f42367b.size();
    }

    public int i() {
        return this.f42366a.size();
    }

    public boolean j(View view) {
        TypeAdapter.ViewHolder viewHolder;
        if (view == null) {
            return false;
        }
        for (int i = 0; i < this.f42367b.size(); i++) {
            c cVar = this.f42367b.get(i);
            if (cVar != null && (viewHolder = cVar.f42371c) != null && viewHolder.itemView == view) {
                this.f42367b.remove(i);
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
        for (int i = 0; i < this.f42366a.size(); i++) {
            c cVar = this.f42366a.get(i);
            if (cVar != null && (viewHolder = cVar.f42371c) != null && viewHolder.itemView == view) {
                this.f42366a.remove(i);
                return true;
            }
        }
        return false;
    }

    public void l(a aVar) {
        this.f42368c = aVar;
    }
}
