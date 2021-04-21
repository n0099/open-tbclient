package d.b.h0.a.t0.f;

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
import d.b.h0.a.f;
import d.b.h0.a.g;
import d.b.h0.a.i2.k0;
/* loaded from: classes2.dex */
public class b extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public SwanAppActivity f46954a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f46955b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f46956c;

    /* renamed from: d  reason: collision with root package name */
    public int f46957d;

    /* renamed from: e  reason: collision with root package name */
    public d f46958e;

    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46959e;

        public a(int i) {
            this.f46959e = i;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int selectionStart = b.this.f46955b.getSelectionStart();
            Editable text = b.this.f46955b.getText();
            if (i == 11) {
                if (selectionStart <= 0 || text == null || text.length() <= 0) {
                    return;
                }
                int i2 = selectionStart - 1;
                text.delete(i2, selectionStart);
                b.this.f46955b.setText(text);
                b.this.f46955b.setSelection(i2);
                return;
            }
            int length = text.length();
            int i3 = this.f46959e;
            if (length < i3 || i3 < 0) {
                text.insert(selectionStart, b.this.f46956c[i]);
                b.this.f46955b.setText(text);
                b.this.f46955b.setSelection(selectionStart + b.this.f46956c[i].length());
            }
        }
    }

    /* renamed from: d.b.h0.a.t0.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0863b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridView f46961e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f46962f;

        /* renamed from: d.b.h0.a.t0.f.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                RunnableC0863b runnableC0863b = RunnableC0863b.this;
                runnableC0863b.f46962f.onItemClick(runnableC0863b.f46961e, view, intValue, intValue);
            }
        }

        public RunnableC0863b(b bVar, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
            this.f46961e = gridView;
            this.f46962f = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            int childCount = this.f46961e.getChildCount();
            if (childCount > 0) {
                this.f46961e.setClickable(false);
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.f46961e.getChildAt(i);
                    childAt.setTag(Integer.valueOf(i));
                    childAt.setOnClickListener(new a());
                }
                return;
            }
            this.f46961e.setOnItemClickListener(this.f46962f);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            b.this.f46955b.clearFocus();
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a();

        void b(int i);
    }

    public b(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i, int i2) {
        super(swanAppActivity);
        this.f46956c = new String[12];
        c(i);
        d(swanAppActivity, editText, i2);
    }

    public final void c(int i) {
        int i2 = 0;
        while (i2 < 9) {
            int i3 = i2 + 1;
            this.f46956c[i2] = String.valueOf(i3);
            i2 = i3;
        }
        if (i == 1) {
            this.f46956c[9] = "X";
        } else if (i == 0) {
            this.f46956c[9] = "";
        } else if (i == 2) {
            this.f46956c[9] = ".";
        }
        this.f46956c[10] = "0";
    }

    public final void d(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i) {
        this.f46954a = swanAppActivity;
        this.f46955b = editText;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(swanAppActivity).inflate(g.aiapps_keyboard_layout, (ViewGroup) null);
        this.f46957d = swanAppActivity.getResources().getDimensionPixelOffset(d.b.h0.a.d.aiapps_keyboard_total_height);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        GridView gridView = (GridView) linearLayout.findViewById(f.keyboard_grid_view);
        gridView.setAdapter((ListAdapter) new d.b.h0.a.t0.f.a(swanAppActivity, this.f46956c));
        k0.T(new RunnableC0863b(this, gridView, new a(i)));
        ImageView imageView = (ImageView) linearLayout.findViewById(f.close_btn);
        imageView.setOnClickListener(new c());
        imageView.setClickable(true);
        setContentView(linearLayout);
        setWidth(-1);
        setHeight(this.f46957d);
        setBackgroundDrawable(new BitmapDrawable());
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        d dVar = this.f46958e;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void e(@NonNull d dVar) {
        this.f46958e = dVar;
    }

    public void f() {
        if (isShowing()) {
            return;
        }
        showAtLocation(this.f46954a.getWindow().getDecorView(), 80, 0, 0);
        d dVar = this.f46958e;
        if (dVar != null) {
            dVar.b(this.f46957d);
        }
    }
}
