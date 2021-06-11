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
    public ArrayList<c> f42920a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f42921b;

    /* renamed from: c  reason: collision with root package name */
    public a f42922c = null;

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
        public long f42923a;

        /* renamed from: b  reason: collision with root package name */
        public int f42924b;

        /* renamed from: c  reason: collision with root package name */
        public TypeAdapter.ViewHolder f42925c;

        /* renamed from: d  reason: collision with root package name */
        public Object f42926d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f42927e;

        public c(d dVar) {
        }
    }

    public d() {
        this.f42920a = null;
        this.f42921b = null;
        this.f42920a = new ArrayList<>();
        this.f42921b = new ArrayList<>();
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i2) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f42925c = new TypeAdapter.ViewHolder(view);
        cVar.f42926d = obj;
        cVar.f42927e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f42924b = id;
        cVar.f42923a = id;
        view.setTag("FOOTER");
        if (i2 >= 0 && i2 <= this.f42921b.size()) {
            this.f42921b.add(i2, cVar);
        } else {
            this.f42921b.add(cVar);
        }
    }

    public void b(View view, Object obj, boolean z, boolean z2, int i2) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f42925c = new TypeAdapter.ViewHolder(view);
        cVar.f42926d = obj;
        cVar.f42927e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f42924b = id;
        cVar.f42923a = id;
        view.setTag("HEADER");
        if (i2 >= 0 && i2 <= this.f42920a.size()) {
            this.f42920a.add(i2, cVar);
        } else {
            this.f42920a.add(cVar);
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
        for (int i2 = 0; i2 < this.f42921b.size(); i2++) {
            c cVar = this.f42921b.get(i2);
            if (cVar != null && (viewHolder = cVar.f42925c) != null && viewHolder.itemView == view) {
                return i2;
            }
        }
        return -1;
    }

    public c e(int i2) {
        Iterator<c> it = this.f42921b.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i2 == next.f42924b) {
                return next;
            }
        }
        return null;
    }

    public int f(View view) {
        TypeAdapter.ViewHolder viewHolder;
        for (int i2 = 0; i2 < this.f42920a.size(); i2++) {
            c cVar = this.f42920a.get(i2);
            if (cVar != null && (viewHolder = cVar.f42925c) != null && viewHolder.itemView == view) {
                return i2;
            }
        }
        return -1;
    }

    public c g(int i2) {
        Iterator<c> it = this.f42920a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i2 == next.f42924b) {
                return next;
            }
        }
        return null;
    }

    public int h() {
        return this.f42921b.size();
    }

    public int i() {
        return this.f42920a.size();
    }

    public boolean j(View view) {
        TypeAdapter.ViewHolder viewHolder;
        if (view == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.f42921b.size(); i2++) {
            c cVar = this.f42921b.get(i2);
            if (cVar != null && (viewHolder = cVar.f42925c) != null && viewHolder.itemView == view) {
                this.f42921b.remove(i2);
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
        for (int i2 = 0; i2 < this.f42920a.size(); i2++) {
            c cVar = this.f42920a.get(i2);
            if (cVar != null && (viewHolder = cVar.f42925c) != null && viewHolder.itemView == view) {
                this.f42920a.remove(i2);
                return true;
            }
        }
        return false;
    }

    public void l(a aVar) {
        this.f42922c = aVar;
    }
}
