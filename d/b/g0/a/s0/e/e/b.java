package d.b.g0.a.s0.e.e;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.i2.k0;
/* loaded from: classes3.dex */
public class b extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public Activity f45817a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f45818b;

    /* renamed from: c  reason: collision with root package name */
    public int f45819c;

    /* renamed from: d  reason: collision with root package name */
    public e f45820d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.a.o0.a f45821e;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0 || i > b.this.f45818b.length) {
                return;
            }
            if (i == 11) {
                if (b.this.f45820d != null) {
                    b.this.f45820d.d();
                }
            } else if (b.this.f45820d != null) {
                b.this.f45820d.c(b.this.f45818b[i]);
            }
        }
    }

    /* renamed from: d.b.g0.a.s0.e.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0782b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridView f45823e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f45824f;

        /* renamed from: d.b.g0.a.s0.e.e.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                RunnableC0782b runnableC0782b = RunnableC0782b.this;
                runnableC0782b.f45824f.onItemClick(runnableC0782b.f45823e, view, intValue, intValue);
            }
        }

        public RunnableC0782b(b bVar, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
            this.f45823e = gridView;
            this.f45824f = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            int childCount = this.f45823e.getChildCount();
            if (childCount > 0) {
                this.f45823e.setClickable(false);
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.f45823e.getChildAt(i);
                    childAt.setTag(Integer.valueOf(i));
                    childAt.setOnClickListener(new a());
                }
                return;
            }
            this.f45823e.setOnItemClickListener(this.f45824f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.b.g0.a.o0.a {
        public d() {
        }

        @Override // d.b.g0.a.o0.a, d.b.g0.a.o0.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4) {
                b.this.dismiss();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();

        void b(int i);

        void c(String str);

        void d();
    }

    public b(@NonNull Activity activity, int i, @NonNull e eVar) {
        super(activity);
        this.f45818b = new String[12];
        this.f45821e = new d();
        this.f45820d = eVar;
        c(i);
        d(activity);
    }

    public final void c(int i) {
        int i2 = 0;
        while (i2 < 9) {
            int i3 = i2 + 1;
            this.f45818b[i2] = String.valueOf(i3);
            i2 = i3;
        }
        if (i == 1) {
            this.f45818b[9] = "X";
        } else if (i == 0) {
            this.f45818b[9] = "";
        } else if (i == 2) {
            this.f45818b[9] = ".";
        }
        this.f45818b[10] = "0";
    }

    public final void d(@NonNull Activity activity) {
        this.f45817a = activity;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_keyboard_layout, (ViewGroup) null);
        this.f45819c = activity.getResources().getDimensionPixelOffset(d.b.g0.a.d.aiapps_keyboard_total_height);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        GridView gridView = (GridView) linearLayout.findViewById(f.keyboard_grid_view);
        gridView.setAdapter((ListAdapter) new d.b.g0.a.s0.e.e.a(activity, this.f45818b));
        k0.T(new RunnableC0782b(this, gridView, new a()));
        ImageView imageView = (ImageView) linearLayout.findViewById(f.close_btn);
        imageView.setOnClickListener(new c());
        imageView.setClickable(true);
        setContentView(linearLayout);
        setWidth(-1);
        setHeight(this.f45819c);
        setBackgroundDrawable(new BitmapDrawable());
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        Activity activity = this.f45817a;
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).unregisterCallback(this.f45821e);
        }
        e eVar = this.f45820d;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void e() {
        if (isShowing()) {
            return;
        }
        showAtLocation(this.f45817a.getWindow().getDecorView(), 80, 0, 0);
        Activity activity = this.f45817a;
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).registerCallback(this.f45821e);
        }
        e eVar = this.f45820d;
        if (eVar != null) {
            eVar.b(this.f45819c);
        }
    }
}
