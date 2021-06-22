package d.a.m0.a.z0.f;

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
import d.a.m0.a.f;
import d.a.m0.a.g;
import d.a.m0.a.v2.q0;
/* loaded from: classes3.dex */
public class b extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public SwanAppActivity f49776a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f49777b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f49778c;

    /* renamed from: d  reason: collision with root package name */
    public int f49779d;

    /* renamed from: e  reason: collision with root package name */
    public d f49780e;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f49781e;

        public a(int i2) {
            this.f49781e = i2;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            int selectionStart = b.this.f49777b.getSelectionStart();
            Editable text = b.this.f49777b.getText();
            if (i2 == 11) {
                if (selectionStart <= 0 || text == null || text.length() <= 0) {
                    return;
                }
                int i3 = selectionStart - 1;
                text.delete(i3, selectionStart);
                b.this.f49777b.setText(text);
                b.this.f49777b.setSelection(i3);
                return;
            }
            int length = text.length();
            int i4 = this.f49781e;
            if (length < i4 || i4 < 0) {
                text.insert(selectionStart, b.this.f49778c[i2]);
                b.this.f49777b.setText(text);
                b.this.f49777b.setSelection(selectionStart + b.this.f49778c[i2].length());
            }
        }
    }

    /* renamed from: d.a.m0.a.z0.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0988b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridView f49783e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f49784f;

        /* renamed from: d.a.m0.a.z0.f.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                RunnableC0988b runnableC0988b = RunnableC0988b.this;
                runnableC0988b.f49784f.onItemClick(runnableC0988b.f49783e, view, intValue, intValue);
            }
        }

        public RunnableC0988b(b bVar, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
            this.f49783e = gridView;
            this.f49784f = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            int childCount = this.f49783e.getChildCount();
            if (childCount > 0) {
                this.f49783e.setClickable(false);
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.f49783e.getChildAt(i2);
                    childAt.setTag(Integer.valueOf(i2));
                    childAt.setOnClickListener(new a());
                }
                return;
            }
            this.f49783e.setOnItemClickListener(this.f49784f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            b.this.f49777b.clearFocus();
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a();

        void b(int i2);
    }

    public b(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i2, int i3) {
        super(swanAppActivity);
        this.f49778c = new String[12];
        c(i2);
        d(swanAppActivity, editText, i3);
    }

    public final void c(int i2) {
        int i3 = 0;
        while (i3 < 9) {
            int i4 = i3 + 1;
            this.f49778c[i3] = String.valueOf(i4);
            i3 = i4;
        }
        if (i2 == 1) {
            this.f49778c[9] = "X";
        } else if (i2 == 0) {
            this.f49778c[9] = "";
        } else if (i2 == 2) {
            this.f49778c[9] = ".";
        }
        this.f49778c[10] = "0";
    }

    public final void d(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i2) {
        this.f49776a = swanAppActivity;
        this.f49777b = editText;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(swanAppActivity).inflate(g.aiapps_keyboard_layout, (ViewGroup) null);
        this.f49779d = swanAppActivity.getResources().getDimensionPixelOffset(d.a.m0.a.d.aiapps_keyboard_total_height);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        GridView gridView = (GridView) linearLayout.findViewById(f.keyboard_grid_view);
        gridView.setAdapter((ListAdapter) new d.a.m0.a.z0.f.a(swanAppActivity, this.f49778c));
        q0.X(new RunnableC0988b(this, gridView, new a(i2)));
        ImageView imageView = (ImageView) linearLayout.findViewById(f.close_btn);
        imageView.setOnClickListener(new c());
        imageView.setClickable(true);
        setContentView(linearLayout);
        setWidth(-1);
        setHeight(this.f49779d);
        setBackgroundDrawable(new BitmapDrawable());
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        d dVar = this.f49780e;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void e(@NonNull d dVar) {
        this.f49780e = dVar;
    }

    public void f() {
        if (isShowing()) {
            return;
        }
        showAtLocation(this.f49776a.getWindow().getDecorView(), 80, 0, 0);
        d dVar = this.f49780e;
        if (dVar != null) {
            dVar.b(this.f49779d);
        }
    }
}
