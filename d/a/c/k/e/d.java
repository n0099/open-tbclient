package d.a.c.k.e;

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
    public ArrayList<c> f43023a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f43024b;

    /* renamed from: c  reason: collision with root package name */
    public a f43025c = null;

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
        public long f43026a;

        /* renamed from: b  reason: collision with root package name */
        public int f43027b;

        /* renamed from: c  reason: collision with root package name */
        public TypeAdapter.ViewHolder f43028c;

        /* renamed from: d  reason: collision with root package name */
        public Object f43029d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f43030e;

        public c(d dVar) {
        }
    }

    public d() {
        this.f43023a = null;
        this.f43024b = null;
        this.f43023a = new ArrayList<>();
        this.f43024b = new ArrayList<>();
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i2) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f43028c = new TypeAdapter.ViewHolder(view);
        cVar.f43029d = obj;
        cVar.f43030e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f43027b = id;
        cVar.f43026a = id;
        view.setTag("FOOTER");
        if (i2 >= 0 && i2 <= this.f43024b.size()) {
            this.f43024b.add(i2, cVar);
        } else {
            this.f43024b.add(cVar);
        }
    }

    public void b(View view, Object obj, boolean z, boolean z2, int i2) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f43028c = new TypeAdapter.ViewHolder(view);
        cVar.f43029d = obj;
        cVar.f43030e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f43027b = id;
        cVar.f43026a = id;
        view.setTag("HEADER");
        if (i2 >= 0 && i2 <= this.f43023a.size()) {
            this.f43023a.add(i2, cVar);
        } else {
            this.f43023a.add(cVar);
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
        for (int i2 = 0; i2 < this.f43024b.size(); i2++) {
            c cVar = this.f43024b.get(i2);
            if (cVar != null && (viewHolder = cVar.f43028c) != null && viewHolder.itemView == view) {
                return i2;
            }
        }
        return -1;
    }

    public c e(int i2) {
        Iterator<c> it = this.f43024b.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i2 == next.f43027b) {
                return next;
            }
        }
        return null;
    }

    public int f(View view) {
        TypeAdapter.ViewHolder viewHolder;
        for (int i2 = 0; i2 < this.f43023a.size(); i2++) {
            c cVar = this.f43023a.get(i2);
            if (cVar != null && (viewHolder = cVar.f43028c) != null && viewHolder.itemView == view) {
                return i2;
            }
        }
        return -1;
    }

    public c g(int i2) {
        Iterator<c> it = this.f43023a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i2 == next.f43027b) {
                return next;
            }
        }
        return null;
    }

    public int h() {
        return this.f43024b.size();
    }

    public int i() {
        return this.f43023a.size();
    }

    public boolean j(View view) {
        TypeAdapter.ViewHolder viewHolder;
        if (view == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.f43024b.size(); i2++) {
            c cVar = this.f43024b.get(i2);
            if (cVar != null && (viewHolder = cVar.f43028c) != null && viewHolder.itemView == view) {
                this.f43024b.remove(i2);
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
        for (int i2 = 0; i2 < this.f43023a.size(); i2++) {
            c cVar = this.f43023a.get(i2);
            if (cVar != null && (viewHolder = cVar.f43028c) != null && viewHolder.itemView == view) {
                this.f43023a.remove(i2);
                return true;
            }
        }
        return false;
    }

    public void l(a aVar) {
        this.f43025c = aVar;
    }
}
