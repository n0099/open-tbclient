package d.b.g0.a.a0.c.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import d.b.g0.a.c0.c;
/* loaded from: classes3.dex */
public final class a extends d.b.g0.a.a0.b.a<CanvasView, d.b.g0.a.y.b.a> {
    @NonNull
    public CanvasView i;

    /* renamed from: d.b.g0.a.a0.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0591a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CanvasView.c f43120e;

        public RunnableC0591a(a aVar, CanvasView.c cVar) {
            this.f43120e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            CanvasView.c cVar = this.f43120e;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.g0.a.j2.f.b.b {
        public final /* synthetic */ boolean n;
        public final /* synthetic */ boolean o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, String str, String str2, String str3, boolean z, boolean z2) {
            super(str, str2, str3);
            this.n = z;
            this.o = z2;
        }

        @Override // d.b.g0.a.j2.f.b.b, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.n && super.onTouch(view, motionEvent) && this.o;
        }
    }

    public a(@NonNull Context context, @NonNull d.b.g0.a.y.b.a aVar) {
        super(context, aVar);
        CanvasView canvasView = new CanvasView(context);
        this.i = canvasView;
        canvasView.setInterceptTouchEvent(aVar.n);
        this.i.setHide(aVar.j);
        this.i.setGesture(aVar.k);
        if (aVar.k) {
            this.i.setInterceptTouchEvent(false);
        }
    }

    @Override // d.b.g0.a.a0.b.a
    public void A() {
        super.A();
        this.i.f();
    }

    public boolean H(d.b.g0.a.y.b.a aVar, CanvasView.c cVar) {
        if (aVar != null && (aVar instanceof d.b.g0.a.y.b.b)) {
            d.b.g0.a.y.b.a n = n();
            if (!TextUtils.equals(n.f43112f, aVar.f43112f) || !TextUtils.equals(n.f43113g, aVar.f43113g)) {
                d.b.g0.a.a0.g.a.a("Component-Canvas", "drawCanvas with illegal ids!");
            }
            d.b.g0.a.y.b.b bVar = (d.b.g0.a.y.b.b) aVar;
            this.i.c(bVar.h(), bVar.i());
            this.i.postInvalidate();
            this.i.post(new RunnableC0591a(this, cVar));
            return true;
        }
        c.b("Component-Canvas", "some params is invalid");
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.b.a
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: I */
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull d.b.g0.a.y.b.a aVar) {
        swanAppComponentContainerView.setOnTouchListener(new b(this, aVar.f43113g, aVar.f43112f, aVar.f43111e, aVar.k, aVar.n));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.b.a
    @NonNull
    /* renamed from: J */
    public CanvasView v(@NonNull Context context) {
        return this.i;
    }
}
