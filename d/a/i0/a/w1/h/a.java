package d.a.i0.a.w1.h;

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
    public static a f45398d;

    /* renamed from: e  reason: collision with root package name */
    public static Context f45399e;

    /* renamed from: a  reason: collision with root package name */
    public EditText f45400a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45401b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f45402c = new RunnableC0881a();

    /* renamed from: d.a.i0.a.w1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0881a implements Runnable {
        public RunnableC0881a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f45400a.dispatchKeyEvent(new KeyEvent(0, 67));
            a.this.f45400a.postDelayed(a.this.f45402c, 60L);
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
                if (a.this.f45400a == null) {
                    return;
                }
                if (i2 == bVar.getCount() - 1) {
                    if (a.this.f45401b) {
                        a.this.f45400a.removeCallbacks(a.this.f45402c);
                        a.this.f45401b = false;
                        return;
                    }
                    a.this.f45400a.dispatchKeyEvent(new KeyEvent(0, 67));
                    return;
                }
                String item = bVar.getItem(i2);
                if (TextUtils.isEmpty(item)) {
                    return;
                }
                a.this.f45400a.getEditableText().insert(a.this.f45400a.getSelectionStart(), d.a.i0.a.w1.h.b.c().g(a.f45399e, item, a.this.f45400a));
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
                a.this.f45401b = true;
                if (a.this.f45400a != null) {
                    a.this.f45400a.post(a.this.f45402c);
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
        f45399e = context.getApplicationContext();
        if (f45398d == null) {
            synchronized (a.class) {
                if (f45398d == null) {
                    f45398d = new a();
                }
            }
        }
        return f45398d;
    }

    public void f(EditText editText) {
        this.f45400a = editText;
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
        EditText editText = this.f45400a;
        if (editText != null) {
            editText.removeCallbacks(this.f45402c);
        }
    }
}
