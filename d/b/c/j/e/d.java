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
    public ArrayList<c> f42864a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f42865b;

    /* renamed from: c  reason: collision with root package name */
    public a f42866c = null;

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
        public long f42867a;

        /* renamed from: b  reason: collision with root package name */
        public int f42868b;

        /* renamed from: c  reason: collision with root package name */
        public TypeAdapter.ViewHolder f42869c;

        /* renamed from: d  reason: collision with root package name */
        public Object f42870d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f42871e;

        public c(d dVar) {
        }
    }

    public d() {
        this.f42864a = null;
        this.f42865b = null;
        this.f42864a = new ArrayList<>();
        this.f42865b = new ArrayList<>();
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f42869c = new TypeAdapter.ViewHolder(view);
        cVar.f42870d = obj;
        cVar.f42871e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f42868b = id;
        cVar.f42867a = id;
        view.setTag("FOOTER");
        if (i >= 0 && i <= this.f42865b.size()) {
            this.f42865b.add(i, cVar);
        } else {
            this.f42865b.add(cVar);
        }
    }

    public void b(View view, Object obj, boolean z, boolean z2, int i) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f42869c = new TypeAdapter.ViewHolder(view);
        cVar.f42870d = obj;
        cVar.f42871e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f42868b = id;
        cVar.f42867a = id;
        view.setTag("HEADER");
        if (i >= 0 && i <= this.f42864a.size()) {
            this.f42864a.add(i, cVar);
        } else {
            this.f42864a.add(cVar);
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
        for (int i = 0; i < this.f42865b.size(); i++) {
            c cVar = this.f42865b.get(i);
            if (cVar != null && (viewHolder = cVar.f42869c) != null && viewHolder.itemView == view) {
                return i;
            }
        }
        return -1;
    }

    public c e(int i) {
        Iterator<c> it = this.f42865b.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i == next.f42868b) {
                return next;
            }
        }
        return null;
    }

    public int f(View view) {
        TypeAdapter.ViewHolder viewHolder;
        for (int i = 0; i < this.f42864a.size(); i++) {
            c cVar = this.f42864a.get(i);
            if (cVar != null && (viewHolder = cVar.f42869c) != null && viewHolder.itemView == view) {
                return i;
            }
        }
        return -1;
    }

    public c g(int i) {
        Iterator<c> it = this.f42864a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i == next.f42868b) {
                return next;
            }
        }
        return null;
    }

    public int h() {
        return this.f42865b.size();
    }

    public int i() {
        return this.f42864a.size();
    }

    public boolean j(View view) {
        TypeAdapter.ViewHolder viewHolder;
        if (view == null) {
            return false;
        }
        for (int i = 0; i < this.f42865b.size(); i++) {
            c cVar = this.f42865b.get(i);
            if (cVar != null && (viewHolder = cVar.f42869c) != null && viewHolder.itemView == view) {
                this.f42865b.remove(i);
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
        for (int i = 0; i < this.f42864a.size(); i++) {
            c cVar = this.f42864a.get(i);
            if (cVar != null && (viewHolder = cVar.f42869c) != null && viewHolder.itemView == view) {
                this.f42864a.remove(i);
                return true;
            }
        }
        return false;
    }

    public void l(a aVar) {
        this.f42866c = aVar;
    }
}
