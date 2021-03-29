package d.b.i0.p0.x1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.i0.f0.a;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f58722a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f58723b;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.f0.b f58725d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58726e;

    /* renamed from: f  reason: collision with root package name */
    public VelocityTracker f58727f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58724c = false;

    /* renamed from: g  reason: collision with root package name */
    public a.b f58728g = new a();

    /* loaded from: classes4.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.b.i0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.i0.f0.a.b
        public void b(int i, int i2) {
            if (e(i2)) {
                b.this.e(true);
            }
        }

        @Override // d.b.i0.f0.a.b
        public void c(int i, int i2) {
            if (e(i2)) {
                b.this.e(false);
            }
        }

        @Override // d.b.i0.f0.a.b
        public void d(int i, int i2) {
        }

        public final boolean e(float f2) {
            return Math.abs(f2) >= 10.0f;
        }
    }

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.f58722a = context;
        this.f58723b = bdUniqueId;
        this.f58726e = z;
        if (z) {
            d.b.i0.f0.b bVar = new d.b.i0.f0.b(context);
            this.f58725d = bVar;
            bVar.d(this.f58728g);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r3 != 3) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(View view, MotionEvent motionEvent) {
        d.b.i0.f0.b bVar;
        if (this.f58727f == null) {
            this.f58727f = VelocityTracker.obtain();
        }
        this.f58727f.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.f58727f.computeCurrentVelocity(1000);
                if (Math.abs(this.f58727f.getXVelocity()) > Math.abs(this.f58727f.getYVelocity())) {
                    this.f58726e = false;
                } else {
                    this.f58726e = true;
                }
            }
            if (this.f58726e || (bVar = this.f58725d) == null) {
            }
            bVar.c(motionEvent);
            return;
        }
        c();
        if (this.f58726e) {
        }
    }

    public final void c() {
        VelocityTracker velocityTracker = this.f58727f;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f58727f.recycle();
            this.f58727f = null;
        }
    }

    public final void d(boolean z, boolean z2) {
        if (z) {
            CustomMessage customMessage = new CustomMessage(2001617);
            customMessage.setTag(this.f58723b);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001617, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        CustomMessage customMessage2 = new CustomMessage(2001618);
        customMessage2.setTag(this.f58723b);
        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001618, Boolean.valueOf(z2));
        customResponsedMessage2.setOrginalMessage(customMessage2);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
    }

    public final void e(boolean z) {
        this.f58724c = z;
        if (this.f58726e) {
            d(!z, true);
        }
    }
}
