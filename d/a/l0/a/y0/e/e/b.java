package d.a.l0.a.y0.e.e;

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
import d.a.l0.a.f;
import d.a.l0.a.g;
import d.a.l0.a.v2.q0;
/* loaded from: classes3.dex */
public class b extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public Activity f49482a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f49483b;

    /* renamed from: c  reason: collision with root package name */
    public int f49484c;

    /* renamed from: d  reason: collision with root package name */
    public e f49485d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.t0.a f49486e;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (i2 < 0 || i2 > b.this.f49483b.length) {
                return;
            }
            if (i2 == 11) {
                if (b.this.f49485d != null) {
                    b.this.f49485d.d();
                }
            } else if (b.this.f49485d != null) {
                b.this.f49485d.c(b.this.f49483b[i2]);
            }
        }
    }

    /* renamed from: d.a.l0.a.y0.e.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0966b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridView f49488e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f49489f;

        /* renamed from: d.a.l0.a.y0.e.e.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                RunnableC0966b runnableC0966b = RunnableC0966b.this;
                runnableC0966b.f49489f.onItemClick(runnableC0966b.f49488e, view, intValue, intValue);
            }
        }

        public RunnableC0966b(b bVar, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
            this.f49488e = gridView;
            this.f49489f = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            int childCount = this.f49488e.getChildCount();
            if (childCount > 0) {
                this.f49488e.setClickable(false);
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.f49488e.getChildAt(i2);
                    childAt.setTag(Integer.valueOf(i2));
                    childAt.setOnClickListener(new a());
                }
                return;
            }
            this.f49488e.setOnItemClickListener(this.f49489f);
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
    public class d extends d.a.l0.a.t0.a {
        public d() {
        }

        @Override // d.a.l0.a.t0.a, d.a.l0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                b.this.dismiss();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();

        void b(int i2);

        void c(String str);

        void d();
    }

    public b(@NonNull Activity activity, int i2, @NonNull e eVar) {
        super(activity);
        this.f49483b = new String[12];
        this.f49486e = new d();
        this.f49485d = eVar;
        c(i2);
        d(activity);
    }

    public final void c(int i2) {
        int i3 = 0;
        while (i3 < 9) {
            int i4 = i3 + 1;
            this.f49483b[i3] = String.valueOf(i4);
            i3 = i4;
        }
        if (i2 == 1) {
            this.f49483b[9] = "X";
        } else if (i2 == 0) {
            this.f49483b[9] = "";
        } else if (i2 == 2) {
            this.f49483b[9] = ".";
        }
        this.f49483b[10] = "0";
    }

    public final void d(@NonNull Activity activity) {
        this.f49482a = activity;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_keyboard_layout, (ViewGroup) null);
        this.f49484c = activity.getResources().getDimensionPixelOffset(d.a.l0.a.d.aiapps_keyboard_total_height);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        GridView gridView = (GridView) linearLayout.findViewById(f.keyboard_grid_view);
        gridView.setAdapter((ListAdapter) new d.a.l0.a.y0.e.e.a(activity, this.f49483b));
        q0.X(new RunnableC0966b(this, gridView, new a()));
        ImageView imageView = (ImageView) linearLayout.findViewById(f.close_btn);
        imageView.setOnClickListener(new c());
        imageView.setClickable(true);
        setContentView(linearLayout);
        setWidth(-1);
        setHeight(this.f49484c);
        setBackgroundDrawable(new BitmapDrawable());
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        Activity activity = this.f49482a;
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).unregisterCallback(this.f49486e);
        }
        e eVar = this.f49485d;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void e() {
        if (isShowing()) {
            return;
        }
        showAtLocation(this.f49482a.getWindow().getDecorView(), 80, 0, 0);
        Activity activity = this.f49482a;
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).registerCallback(this.f49486e);
        }
        e eVar = this.f49485d;
        if (eVar != null) {
            eVar.b(this.f49484c);
        }
    }
}
