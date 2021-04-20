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
/* loaded from: classes2.dex */
public class b extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public SwanAppActivity f46625a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f46626b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f46627c;

    /* renamed from: d  reason: collision with root package name */
    public int f46628d;

    /* renamed from: e  reason: collision with root package name */
    public d f46629e;

    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46630e;

        public a(int i) {
            this.f46630e = i;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int selectionStart = b.this.f46626b.getSelectionStart();
            Editable text = b.this.f46626b.getText();
            if (i == 11) {
                if (selectionStart <= 0 || text == null || text.length() <= 0) {
                    return;
                }
                int i2 = selectionStart - 1;
                text.delete(i2, selectionStart);
                b.this.f46626b.setText(text);
                b.this.f46626b.setSelection(i2);
                return;
            }
            int length = text.length();
            int i3 = this.f46630e;
            if (length < i3 || i3 < 0) {
                text.insert(selectionStart, b.this.f46627c[i]);
                b.this.f46626b.setText(text);
                b.this.f46626b.setSelection(selectionStart + b.this.f46627c[i].length());
            }
        }
    }

    /* renamed from: d.b.g0.a.t0.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0843b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridView f46632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f46633f;

        /* renamed from: d.b.g0.a.t0.f.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                RunnableC0843b runnableC0843b = RunnableC0843b.this;
                runnableC0843b.f46633f.onItemClick(runnableC0843b.f46632e, view, intValue, intValue);
            }
        }

        public RunnableC0843b(b bVar, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
            this.f46632e = gridView;
            this.f46633f = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            int childCount = this.f46632e.getChildCount();
            if (childCount > 0) {
                this.f46632e.setClickable(false);
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.f46632e.getChildAt(i);
                    childAt.setTag(Integer.valueOf(i));
                    childAt.setOnClickListener(new a());
                }
                return;
            }
            this.f46632e.setOnItemClickListener(this.f46633f);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            b.this.f46626b.clearFocus();
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a();

        void b(int i);
    }

    public b(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i, int i2) {
        super(swanAppActivity);
        this.f46627c = new String[12];
        c(i);
        d(swanAppActivity, editText, i2);
    }

    public final void c(int i) {
        int i2 = 0;
        while (i2 < 9) {
            int i3 = i2 + 1;
            this.f46627c[i2] = String.valueOf(i3);
            i2 = i3;
        }
        if (i == 1) {
            this.f46627c[9] = "X";
        } else if (i == 0) {
            this.f46627c[9] = "";
        } else if (i == 2) {
            this.f46627c[9] = ".";
        }
        this.f46627c[10] = "0";
    }

    public final void d(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i) {
        this.f46625a = swanAppActivity;
        this.f46626b = editText;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(swanAppActivity).inflate(g.aiapps_keyboard_layout, (ViewGroup) null);
        this.f46628d = swanAppActivity.getResources().getDimensionPixelOffset(d.b.g0.a.d.aiapps_keyboard_total_height);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        GridView gridView = (GridView) linearLayout.findViewById(f.keyboard_grid_view);
        gridView.setAdapter((ListAdapter) new d.b.g0.a.t0.f.a(swanAppActivity, this.f46627c));
        k0.T(new RunnableC0843b(this, gridView, new a(i)));
        ImageView imageView = (ImageView) linearLayout.findViewById(f.close_btn);
        imageView.setOnClickListener(new c());
        imageView.setClickable(true);
        setContentView(linearLayout);
        setWidth(-1);
        setHeight(this.f46628d);
        setBackgroundDrawable(new BitmapDrawable());
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        d dVar = this.f46629e;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void e(@NonNull d dVar) {
        this.f46629e = dVar;
    }

    public void f() {
        if (isShowing()) {
            return;
        }
        showAtLocation(this.f46625a.getWindow().getDecorView(), 80, 0, 0);
        d dVar = this.f46629e;
        if (dVar != null) {
            dVar.b(this.f46628d);
        }
    }
}
