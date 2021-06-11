package d.a.l0.a.c0.c.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import d.a.l0.a.e0.d;
/* loaded from: classes2.dex */
public final class a extends d.a.l0.a.c0.b.a<CanvasView, d.a.l0.a.a0.b.a> {
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public CanvasView f44532i;

    /* renamed from: d.a.l0.a.c0.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0628a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CanvasView.c f44533e;

        public RunnableC0628a(a aVar, CanvasView.c cVar) {
            this.f44533e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            CanvasView.c cVar = this.f44533e;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.l0.a.w2.g.b.b {
        public final /* synthetic */ boolean n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            this.n = z;
        }

        @Override // d.a.l0.a.w2.g.b.b, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.n && super.onTouch(view, motionEvent);
        }
    }

    public a(@NonNull Context context, @NonNull d.a.l0.a.a0.b.a aVar) {
        super(context, aVar);
        CanvasView canvasView = new CanvasView(context);
        this.f44532i = canvasView;
        canvasView.setInterceptTouchEvent(aVar.n);
        this.f44532i.setHide(aVar.j);
        this.f44532i.setGesture(aVar.k);
        if (aVar.k) {
            this.f44532i.setInterceptTouchEvent(false);
        }
    }

    @Override // d.a.l0.a.c0.b.a
    public void A() {
        super.A();
        this.f44532i.f();
    }

    public boolean H(d.a.l0.a.a0.b.a aVar, CanvasView.c cVar) {
        if (aVar != null && (aVar instanceof d.a.l0.a.a0.b.b)) {
            d.a.l0.a.a0.b.a n = n();
            if (!TextUtils.equals(n.f44521f, aVar.f44521f) || !TextUtils.equals(n.f44522g, aVar.f44522g)) {
                d.a.l0.a.c0.g.a.a("Component-Canvas", "drawCanvas with illegal ids!");
            }
            d.a.l0.a.a0.b.b bVar = (d.a.l0.a.a0.b.b) aVar;
            this.f44532i.c(bVar.h(), bVar.i());
            this.f44532i.postInvalidate();
            this.f44532i.post(new RunnableC0628a(this, cVar));
            return true;
        }
        d.b("Component-Canvas", "some params is invalid");
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.c0.b.a
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: I */
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull d.a.l0.a.a0.b.a aVar) {
        swanAppComponentContainerView.setOnTouchListener(new b(this, aVar.f44522g, aVar.f44521f, aVar.f44520e, aVar.k));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.c0.b.a
    @NonNull
    /* renamed from: J */
    public CanvasView v(@NonNull Context context) {
        return this.f44532i;
    }
}
