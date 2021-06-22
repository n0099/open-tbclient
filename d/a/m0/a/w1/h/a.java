package d.a.m0.a.w1.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import com.baidu.swan.apps.publisher.emoji.view.EmojiBagLayout;
/* loaded from: classes3.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static a f49356d;

    /* renamed from: e  reason: collision with root package name */
    public static Context f49357e;

    /* renamed from: a  reason: collision with root package name */
    public EditText f49358a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49359b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f49360c = new RunnableC0951a();

    /* renamed from: d.a.m0.a.w1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0951a implements Runnable {
        public RunnableC0951a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f49358a.dispatchKeyEvent(new KeyEvent(0, 67));
            a.this.f49358a.postDelayed(a.this.f49360c, 60L);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Object adapter = adapterView.getAdapter();
            if (adapter instanceof EmojiBagLayout.b) {
                EmojiBagLayout.b bVar = (EmojiBagLayout.b) adapter;
                if (a.this.f49358a == null) {
                    return;
                }
                if (i2 == bVar.getCount() - 1) {
                    if (a.this.f49359b) {
                        a.this.f49358a.removeCallbacks(a.this.f49360c);
                        a.this.f49359b = false;
                        return;
                    }
                    a.this.f49358a.dispatchKeyEvent(new KeyEvent(0, 67));
                    return;
                }
                String item = bVar.getItem(i2);
                if (TextUtils.isEmpty(item)) {
                    return;
                }
                a.this.f49358a.getEditableText().insert(a.this.f49358a.getSelectionStart(), d.a.m0.a.w1.h.b.c().g(a.f49357e, item, a.this.f49358a));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Object adapter = adapterView.getAdapter();
            if ((adapter instanceof EmojiBagLayout.b) && i2 == ((EmojiBagLayout.b) adapter).getCount() - 1) {
                a.this.f49359b = true;
                if (a.this.f49358a != null) {
                    a.this.f49358a.post(a.this.f49360c);
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                a.this.k();
                return false;
            }
            return false;
        }
    }

    public static a g(Context context) {
        f49357e = context.getApplicationContext();
        if (f49356d == null) {
            synchronized (a.class) {
                if (f49356d == null) {
                    f49356d = new a();
                }
            }
        }
        return f49356d;
    }

    public void f(EditText editText) {
        this.f49358a = editText;
    }

    public AdapterView.OnItemClickListener h() {
        return new b();
    }

    public AdapterView.OnItemLongClickListener i() {
        return new c();
    }

    public View.OnTouchListener j() {
        return new d();
    }

    public void k() {
        EditText editText = this.f49358a;
        if (editText != null) {
            editText.removeCallbacks(this.f49360c);
        }
    }
}
