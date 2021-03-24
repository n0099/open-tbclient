package d.b.g0.a.t0.f;

import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
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
    public SwanAppActivity f46232a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f46233b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f46234c;

    /* renamed from: d  reason: collision with root package name */
    public int f46235d;

    /* renamed from: e  reason: collision with root package name */
    public d f46236e;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46237e;

        public a(int i) {
            this.f46237e = i;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int selectionStart = b.this.f46233b.getSelectionStart();
            Editable text = b.this.f46233b.getText();
            if (i == 11) {
                if (selectionStart <= 0 || text == null || text.length() <= 0) {
                    return;
                }
                int i2 = selectionStart - 1;
                text.delete(i2, selectionStart);
                b.this.f46233b.setText(text);
                b.this.f46233b.setSelection(i2);
                return;
            }
            int length = text.length();
            int i3 = this.f46237e;
            if (length < i3 || i3 < 0) {
                text.insert(selectionStart, b.this.f46234c[i]);
                b.this.f46233b.setText(text);
                b.this.f46233b.setSelection(selectionStart + b.this.f46234c[i].length());
            }
        }
    }

    /* renamed from: d.b.g0.a.t0.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0830b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridView f46239e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f46240f;

        /* renamed from: d.b.g0.a.t0.f.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                RunnableC0830b runnableC0830b = RunnableC0830b.this;
                runnableC0830b.f46240f.onItemClick(runnableC0830b.f46239e, view, intValue, intValue);
            }
        }

        public RunnableC0830b(b bVar, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
            this.f46239e = gridView;
            this.f46240f = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            int childCount = this.f46239e.getChildCount();
            if (childCount > 0) {
                this.f46239e.setClickable(false);
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.f46239e.getChildAt(i);
                    childAt.setTag(Integer.valueOf(i));
                    childAt.setOnClickListener(new a());
                }
                return;
            }
            this.f46239e.setOnItemClickListener(this.f46240f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            b.this.f46233b.clearFocus();
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a();

        void b(int i);
    }

    public b(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i, int i2) {
        super(swanAppActivity);
        this.f46234c = new String[12];
        c(i);
        d(swanAppActivity, editText, i2);
    }

    public final void c(int i) {
        int i2 = 0;
        while (i2 < 9) {
            int i3 = i2 + 1;
            this.f46234c[i2] = String.valueOf(i3);
            i2 = i3;
        }
        if (i == 1) {
            this.f46234c[9] = "X";
        } else if (i == 0) {
            this.f46234c[9] = "";
        } else if (i == 2) {
            this.f46234c[9] = ".";
        }
        this.f46234c[10] = "0";
    }

    public final void d(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i) {
        this.f46232a = swanAppActivity;
        this.f46233b = editText;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(swanAppActivity).inflate(g.aiapps_keyboard_layout, (ViewGroup) null);
        this.f46235d = swanAppActivity.getResources().getDimensionPixelOffset(d.b.g0.a.d.aiapps_keyboard_total_height);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        GridView gridView = (GridView) linearLayout.findViewById(f.keyboard_grid_view);
        gridView.setAdapter((ListAdapter) new d.b.g0.a.t0.f.a(swanAppActivity, this.f46234c));
        k0.T(new RunnableC0830b(this, gridView, new a(i)));
        ImageView imageView = (ImageView) linearLayout.findViewById(f.close_btn);
        imageView.setOnClickListener(new c());
        imageView.setClickable(true);
        setContentView(linearLayout);
        setWidth(-1);
        setHeight(this.f46235d);
        setBackgroundDrawable(new BitmapDrawable());
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        d dVar = this.f46236e;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void e(@NonNull d dVar) {
        this.f46236e = dVar;
    }

    public void f() {
        if (isShowing()) {
            return;
        }
        showAtLocation(this.f46232a.getWindow().getDecorView(), 80, 0, 0);
        d dVar = this.f46236e;
        if (dVar != null) {
            dVar.b(this.f46235d);
        }
    }
}
