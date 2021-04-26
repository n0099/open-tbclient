package d.a.h0.a.t0.f;

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
import d.a.h0.a.f;
import d.a.h0.a.g;
import d.a.h0.a.i2.k0;
/* loaded from: classes2.dex */
public class b extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public SwanAppActivity f44342a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f44343b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f44344c;

    /* renamed from: d  reason: collision with root package name */
    public int f44345d;

    /* renamed from: e  reason: collision with root package name */
    public d f44346e;

    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f44347e;

        public a(int i2) {
            this.f44347e = i2;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            int selectionStart = b.this.f44343b.getSelectionStart();
            Editable text = b.this.f44343b.getText();
            if (i2 == 11) {
                if (selectionStart <= 0 || text == null || text.length() <= 0) {
                    return;
                }
                int i3 = selectionStart - 1;
                text.delete(i3, selectionStart);
                b.this.f44343b.setText(text);
                b.this.f44343b.setSelection(i3);
                return;
            }
            int length = text.length();
            int i4 = this.f44347e;
            if (length < i4 || i4 < 0) {
                text.insert(selectionStart, b.this.f44344c[i2]);
                b.this.f44343b.setText(text);
                b.this.f44343b.setSelection(selectionStart + b.this.f44344c[i2].length());
            }
        }
    }

    /* renamed from: d.a.h0.a.t0.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0802b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridView f44349e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f44350f;

        /* renamed from: d.a.h0.a.t0.f.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                RunnableC0802b runnableC0802b = RunnableC0802b.this;
                runnableC0802b.f44350f.onItemClick(runnableC0802b.f44349e, view, intValue, intValue);
            }
        }

        public RunnableC0802b(b bVar, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
            this.f44349e = gridView;
            this.f44350f = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            int childCount = this.f44349e.getChildCount();
            if (childCount > 0) {
                this.f44349e.setClickable(false);
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.f44349e.getChildAt(i2);
                    childAt.setTag(Integer.valueOf(i2));
                    childAt.setOnClickListener(new a());
                }
                return;
            }
            this.f44349e.setOnItemClickListener(this.f44350f);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            b.this.f44343b.clearFocus();
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a();

        void b(int i2);
    }

    public b(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i2, int i3) {
        super(swanAppActivity);
        this.f44344c = new String[12];
        c(i2);
        d(swanAppActivity, editText, i3);
    }

    public final void c(int i2) {
        int i3 = 0;
        while (i3 < 9) {
            int i4 = i3 + 1;
            this.f44344c[i3] = String.valueOf(i4);
            i3 = i4;
        }
        if (i2 == 1) {
            this.f44344c[9] = "X";
        } else if (i2 == 0) {
            this.f44344c[9] = "";
        } else if (i2 == 2) {
            this.f44344c[9] = ".";
        }
        this.f44344c[10] = "0";
    }

    public final void d(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i2) {
        this.f44342a = swanAppActivity;
        this.f44343b = editText;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(swanAppActivity).inflate(g.aiapps_keyboard_layout, (ViewGroup) null);
        this.f44345d = swanAppActivity.getResources().getDimensionPixelOffset(d.a.h0.a.d.aiapps_keyboard_total_height);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        GridView gridView = (GridView) linearLayout.findViewById(f.keyboard_grid_view);
        gridView.setAdapter((ListAdapter) new d.a.h0.a.t0.f.a(swanAppActivity, this.f44344c));
        k0.T(new RunnableC0802b(this, gridView, new a(i2)));
        ImageView imageView = (ImageView) linearLayout.findViewById(f.close_btn);
        imageView.setOnClickListener(new c());
        imageView.setClickable(true);
        setContentView(linearLayout);
        setWidth(-1);
        setHeight(this.f44345d);
        setBackgroundDrawable(new BitmapDrawable());
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        d dVar = this.f44346e;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void e(@NonNull d dVar) {
        this.f44346e = dVar;
    }

    public void f() {
        if (isShowing()) {
            return;
        }
        showAtLocation(this.f44342a.getWindow().getDecorView(), 80, 0, 0);
        d dVar = this.f44346e;
        if (dVar != null) {
            dVar.b(this.f44345d);
        }
    }
}
