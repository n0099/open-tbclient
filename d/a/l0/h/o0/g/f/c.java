package d.a.l0.h.o0.g.f;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import d.a.l0.f.f;
import d.a.l0.f.h;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class c extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public a f47611e;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public static final b f47612e = new b();

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View v, MotionEvent event) {
            Intrinsics.checkNotNullExpressionValue(event, "event");
            int action = event.getAction();
            if (action == 0) {
                Intrinsics.checkNotNullExpressionValue(v, "v");
                v.setAlpha(0.2f);
                return false;
            } else if (action == 1 || action == 3) {
                Intrinsics.checkNotNullExpressionValue(v, "v");
                v.setAlpha(1.0f);
                return false;
            } else {
                return false;
            }
        }
    }

    /* renamed from: d.a.l0.h.o0.g.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class View$OnClickListenerC1045c implements View.OnClickListener {
        public View$OnClickListenerC1045c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar = c.this.f47611e;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar = c.this.f47611e;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar = c.this.f47611e;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context, h.SwanGameNoTitleDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        c();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final View.OnTouchListener b() {
        return b.f47612e;
    }

    public final void c() {
        setContentView(f.aiapps_pandapark_close_dialog);
        setCanceledOnTouchOutside(false);
        d();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void d() {
        ((Button) findViewById(d.a.l0.f.e.exit_button)).setOnTouchListener(b());
        ((Button) findViewById(d.a.l0.f.e.exit_button)).setOnClickListener(new View$OnClickListenerC1045c());
        ((ImageView) findViewById(d.a.l0.f.e.image_close)).setOnTouchListener(b());
        ((ImageView) findViewById(d.a.l0.f.e.image_close)).setOnClickListener(new d());
        ((Button) findViewById(d.a.l0.f.e.continue_button)).setOnTouchListener(b());
        ((Button) findViewById(d.a.l0.f.e.continue_button)).setOnClickListener(new e());
    }

    public final void e(a onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.f47611e = onClickListener;
    }
}
