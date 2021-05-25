package d.a.n0.r0.x1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.n0.g0.a;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f59809a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f59810b;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.g0.b f59812d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59813e;

    /* renamed from: f  reason: collision with root package name */
    public VelocityTracker f59814f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59811c = false;

    /* renamed from: g  reason: collision with root package name */
    public a.b f59815g = new a();

    /* loaded from: classes4.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.n0.g0.a.b
        public void a(int i2, int i3) {
            if (e(i3)) {
                b.this.e(true);
            }
        }

        @Override // d.a.n0.g0.a.b
        public void b(int i2, int i3) {
            if (e(i3)) {
                b.this.e(false);
            }
        }

        @Override // d.a.n0.g0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.n0.g0.a.b
        public void d(int i2, int i3) {
        }

        public final boolean e(float f2) {
            return Math.abs(f2) >= 10.0f;
        }
    }

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.f59809a = context;
        this.f59810b = bdUniqueId;
        this.f59813e = z;
        if (z) {
            d.a.n0.g0.b bVar = new d.a.n0.g0.b(context);
            this.f59812d = bVar;
            bVar.d(this.f59815g);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r3 != 3) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(View view, MotionEvent motionEvent) {
        d.a.n0.g0.b bVar;
        if (this.f59814f == null) {
            this.f59814f = VelocityTracker.obtain();
        }
        this.f59814f.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.f59814f.computeCurrentVelocity(1000);
                if (Math.abs(this.f59814f.getXVelocity()) > Math.abs(this.f59814f.getYVelocity())) {
                    this.f59813e = false;
                } else {
                    this.f59813e = true;
                }
            }
            if (this.f59813e || (bVar = this.f59812d) == null) {
            }
            bVar.c(motionEvent);
            return;
        }
        c();
        if (this.f59813e) {
        }
    }

    public final void c() {
        VelocityTracker velocityTracker = this.f59814f;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f59814f.recycle();
            this.f59814f = null;
        }
    }

    public final void d(boolean z, boolean z2) {
        if (z) {
            CustomMessage customMessage = new CustomMessage(2001617);
            customMessage.setTag(this.f59810b);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001617, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        CustomMessage customMessage2 = new CustomMessage(2001618);
        customMessage2.setTag(this.f59810b);
        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001618, Boolean.valueOf(z2));
        customResponsedMessage2.setOrginalMessage(customMessage2);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
    }

    public final void e(boolean z) {
        this.f59811c = z;
        if (this.f59813e) {
            d(!z, true);
        }
    }
}
