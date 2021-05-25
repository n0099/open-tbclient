package d.a.l0.a.w1.h;

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
    public static a f45574d;

    /* renamed from: e  reason: collision with root package name */
    public static Context f45575e;

    /* renamed from: a  reason: collision with root package name */
    public EditText f45576a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45577b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f45578c = new RunnableC0892a();

    /* renamed from: d.a.l0.a.w1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0892a implements Runnable {
        public RunnableC0892a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f45576a.dispatchKeyEvent(new KeyEvent(0, 67));
            a.this.f45576a.postDelayed(a.this.f45578c, 60L);
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
                if (a.this.f45576a == null) {
                    return;
                }
                if (i2 == bVar.getCount() - 1) {
                    if (a.this.f45577b) {
                        a.this.f45576a.removeCallbacks(a.this.f45578c);
                        a.this.f45577b = false;
                        return;
                    }
                    a.this.f45576a.dispatchKeyEvent(new KeyEvent(0, 67));
                    return;
                }
                String item = bVar.getItem(i2);
                if (TextUtils.isEmpty(item)) {
                    return;
                }
                a.this.f45576a.getEditableText().insert(a.this.f45576a.getSelectionStart(), d.a.l0.a.w1.h.b.c().g(a.f45575e, item, a.this.f45576a));
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
                a.this.f45577b = true;
                if (a.this.f45576a != null) {
                    a.this.f45576a.post(a.this.f45578c);
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
        f45575e = context.getApplicationContext();
        if (f45574d == null) {
            synchronized (a.class) {
                if (f45574d == null) {
                    f45574d = new a();
                }
            }
        }
        return f45574d;
    }

    public void f(EditText editText) {
        this.f45576a = editText;
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
        EditText editText = this.f45576a;
        if (editText != null) {
            editText.removeCallbacks(this.f45578c);
        }
    }
}
