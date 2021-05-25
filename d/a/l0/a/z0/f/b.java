package d.a.l0.a.z0.f;

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
import d.a.l0.a.f;
import d.a.l0.a.g;
import d.a.l0.a.v2.q0;
/* loaded from: classes3.dex */
public class b extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public SwanAppActivity f45994a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f45995b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f45996c;

    /* renamed from: d  reason: collision with root package name */
    public int f45997d;

    /* renamed from: e  reason: collision with root package name */
    public d f45998e;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45999e;

        public a(int i2) {
            this.f45999e = i2;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            int selectionStart = b.this.f45995b.getSelectionStart();
            Editable text = b.this.f45995b.getText();
            if (i2 == 11) {
                if (selectionStart <= 0 || text == null || text.length() <= 0) {
                    return;
                }
                int i3 = selectionStart - 1;
                text.delete(i3, selectionStart);
                b.this.f45995b.setText(text);
                b.this.f45995b.setSelection(i3);
                return;
            }
            int length = text.length();
            int i4 = this.f45999e;
            if (length < i4 || i4 < 0) {
                text.insert(selectionStart, b.this.f45996c[i2]);
                b.this.f45995b.setText(text);
                b.this.f45995b.setSelection(selectionStart + b.this.f45996c[i2].length());
            }
        }
    }

    /* renamed from: d.a.l0.a.z0.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0929b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridView f46001e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f46002f;

        /* renamed from: d.a.l0.a.z0.f.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                RunnableC0929b runnableC0929b = RunnableC0929b.this;
                runnableC0929b.f46002f.onItemClick(runnableC0929b.f46001e, view, intValue, intValue);
            }
        }

        public RunnableC0929b(b bVar, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
            this.f46001e = gridView;
            this.f46002f = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            int childCount = this.f46001e.getChildCount();
            if (childCount > 0) {
                this.f46001e.setClickable(false);
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.f46001e.getChildAt(i2);
                    childAt.setTag(Integer.valueOf(i2));
                    childAt.setOnClickListener(new a());
                }
                return;
            }
            this.f46001e.setOnItemClickListener(this.f46002f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            b.this.f45995b.clearFocus();
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a();

        void b(int i2);
    }

    public b(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i2, int i3) {
        super(swanAppActivity);
        this.f45996c = new String[12];
        c(i2);
        d(swanAppActivity, editText, i3);
    }

    public final void c(int i2) {
        int i3 = 0;
        while (i3 < 9) {
            int i4 = i3 + 1;
            this.f45996c[i3] = String.valueOf(i4);
            i3 = i4;
        }
        if (i2 == 1) {
            this.f45996c[9] = "X";
        } else if (i2 == 0) {
            this.f45996c[9] = "";
        } else if (i2 == 2) {
            this.f45996c[9] = ".";
        }
        this.f45996c[10] = "0";
    }

    public final void d(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i2) {
        this.f45994a = swanAppActivity;
        this.f45995b = editText;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(swanAppActivity).inflate(g.aiapps_keyboard_layout, (ViewGroup) null);
        this.f45997d = swanAppActivity.getResources().getDimensionPixelOffset(d.a.l0.a.d.aiapps_keyboard_total_height);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        GridView gridView = (GridView) linearLayout.findViewById(f.keyboard_grid_view);
        gridView.setAdapter((ListAdapter) new d.a.l0.a.z0.f.a(swanAppActivity, this.f45996c));
        q0.X(new RunnableC0929b(this, gridView, new a(i2)));
        ImageView imageView = (ImageView) linearLayout.findViewById(f.close_btn);
        imageView.setOnClickListener(new c());
        imageView.setClickable(true);
        setContentView(linearLayout);
        setWidth(-1);
        setHeight(this.f45997d);
        setBackgroundDrawable(new BitmapDrawable());
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        d dVar = this.f45998e;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void e(@NonNull d dVar) {
        this.f45998e = dVar;
    }

    public void f() {
        if (isShowing()) {
            return;
        }
        showAtLocation(this.f45994a.getWindow().getDecorView(), 80, 0, 0);
        d dVar = this.f45998e;
        if (dVar != null) {
            dVar.b(this.f45997d);
        }
    }
}
