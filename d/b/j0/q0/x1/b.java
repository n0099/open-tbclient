package d.b.j0.q0.x1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.j0.f0.a;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f60811a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f60812b;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.f0.b f60814d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60815e;

    /* renamed from: f  reason: collision with root package name */
    public VelocityTracker f60816f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60813c = false;

    /* renamed from: g  reason: collision with root package name */
    public a.b f60817g = new a();

    /* loaded from: classes4.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.b.j0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.j0.f0.a.b
        public void b(int i, int i2) {
            if (e(i2)) {
                b.this.e(true);
            }
        }

        @Override // d.b.j0.f0.a.b
        public void c(int i, int i2) {
            if (e(i2)) {
                b.this.e(false);
            }
        }

        @Override // d.b.j0.f0.a.b
        public void d(int i, int i2) {
        }

        public final boolean e(float f2) {
            return Math.abs(f2) >= 10.0f;
        }
    }

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.f60811a = context;
        this.f60812b = bdUniqueId;
        this.f60815e = z;
        if (z) {
            d.b.j0.f0.b bVar = new d.b.j0.f0.b(context);
            this.f60814d = bVar;
            bVar.d(this.f60817g);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r3 != 3) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(View view, MotionEvent motionEvent) {
        d.b.j0.f0.b bVar;
        if (this.f60816f == null) {
            this.f60816f = VelocityTracker.obtain();
        }
        this.f60816f.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.f60816f.computeCurrentVelocity(1000);
                if (Math.abs(this.f60816f.getXVelocity()) > Math.abs(this.f60816f.getYVelocity())) {
                    this.f60815e = false;
                } else {
                    this.f60815e = true;
                }
            }
            if (this.f60815e || (bVar = this.f60814d) == null) {
            }
            bVar.c(motionEvent);
            return;
        }
        c();
        if (this.f60815e) {
        }
    }

    public final void c() {
        VelocityTracker velocityTracker = this.f60816f;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f60816f.recycle();
            this.f60816f = null;
        }
    }

    public final void d(boolean z, boolean z2) {
        if (z) {
            CustomMessage customMessage = new CustomMessage(2001617);
            customMessage.setTag(this.f60812b);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001617, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        CustomMessage customMessage2 = new CustomMessage(2001618);
        customMessage2.setTag(this.f60812b);
        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001618, Boolean.valueOf(z2));
        customResponsedMessage2.setOrginalMessage(customMessage2);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
    }

    public final void e(boolean z) {
        this.f60813c = z;
        if (this.f60815e) {
            d(!z, true);
        }
    }
}
