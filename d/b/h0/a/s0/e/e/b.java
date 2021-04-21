package d.b.h0.a.s0.e.e;

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
import d.b.h0.a.f;
import d.b.h0.a.g;
import d.b.h0.a.i2.k0;
/* loaded from: classes2.dex */
public class b extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public Activity f46539a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f46540b;

    /* renamed from: c  reason: collision with root package name */
    public int f46541c;

    /* renamed from: d  reason: collision with root package name */
    public e f46542d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.a.o0.a f46543e;

    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0 || i > b.this.f46540b.length) {
                return;
            }
            if (i == 11) {
                if (b.this.f46542d != null) {
                    b.this.f46542d.d();
                }
            } else if (b.this.f46542d != null) {
                b.this.f46542d.c(b.this.f46540b[i]);
            }
        }
    }

    /* renamed from: d.b.h0.a.s0.e.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0815b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridView f46545e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f46546f;

        /* renamed from: d.b.h0.a.s0.e.e.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                RunnableC0815b runnableC0815b = RunnableC0815b.this;
                runnableC0815b.f46546f.onItemClick(runnableC0815b.f46545e, view, intValue, intValue);
            }
        }

        public RunnableC0815b(b bVar, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
            this.f46545e = gridView;
            this.f46546f = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            int childCount = this.f46545e.getChildCount();
            if (childCount > 0) {
                this.f46545e.setClickable(false);
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.f46545e.getChildAt(i);
                    childAt.setTag(Integer.valueOf(i));
                    childAt.setOnClickListener(new a());
                }
                return;
            }
            this.f46545e.setOnItemClickListener(this.f46546f);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.b.h0.a.o0.a {
        public d() {
        }

        @Override // d.b.h0.a.o0.a, d.b.h0.a.o0.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4) {
                b.this.dismiss();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a();

        void b(int i);

        void c(String str);

        void d();
    }

    public b(@NonNull Activity activity, int i, @NonNull e eVar) {
        super(activity);
        this.f46540b = new String[12];
        this.f46543e = new d();
        this.f46542d = eVar;
        c(i);
        d(activity);
    }

    public final void c(int i) {
        int i2 = 0;
        while (i2 < 9) {
            int i3 = i2 + 1;
            this.f46540b[i2] = String.valueOf(i3);
            i2 = i3;
        }
        if (i == 1) {
            this.f46540b[9] = "X";
        } else if (i == 0) {
            this.f46540b[9] = "";
        } else if (i == 2) {
            this.f46540b[9] = ".";
        }
        this.f46540b[10] = "0";
    }

    public final void d(@NonNull Activity activity) {
        this.f46539a = activity;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_keyboard_layout, (ViewGroup) null);
        this.f46541c = activity.getResources().getDimensionPixelOffset(d.b.h0.a.d.aiapps_keyboard_total_height);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        GridView gridView = (GridView) linearLayout.findViewById(f.keyboard_grid_view);
        gridView.setAdapter((ListAdapter) new d.b.h0.a.s0.e.e.a(activity, this.f46540b));
        k0.T(new RunnableC0815b(this, gridView, new a()));
        ImageView imageView = (ImageView) linearLayout.findViewById(f.close_btn);
        imageView.setOnClickListener(new c());
        imageView.setClickable(true);
        setContentView(linearLayout);
        setWidth(-1);
        setHeight(this.f46541c);
        setBackgroundDrawable(new BitmapDrawable());
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        Activity activity = this.f46539a;
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).unregisterCallback(this.f46543e);
        }
        e eVar = this.f46542d;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void e() {
        if (isShowing()) {
            return;
        }
        showAtLocation(this.f46539a.getWindow().getDecorView(), 80, 0, 0);
        Activity activity = this.f46539a;
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).registerCallback(this.f46543e);
        }
        e eVar = this.f46542d;
        if (eVar != null) {
            eVar.b(this.f46541c);
        }
    }
}
