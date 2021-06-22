package d.a.o0.r0.x1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.o0.g0.a;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f63625a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f63626b;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.g0.b f63628d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63629e;

    /* renamed from: f  reason: collision with root package name */
    public VelocityTracker f63630f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63627c = false;

    /* renamed from: g  reason: collision with root package name */
    public a.b f63631g = new a();

    /* loaded from: classes4.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.o0.g0.a.b
        public void a(int i2, int i3) {
            if (e(i3)) {
                b.this.e(true);
            }
        }

        @Override // d.a.o0.g0.a.b
        public void b(int i2, int i3) {
            if (e(i3)) {
                b.this.e(false);
            }
        }

        @Override // d.a.o0.g0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.o0.g0.a.b
        public void d(int i2, int i3) {
        }

        public final boolean e(float f2) {
            return Math.abs(f2) >= 10.0f;
        }
    }

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.f63625a = context;
        this.f63626b = bdUniqueId;
        this.f63629e = z;
        if (z) {
            d.a.o0.g0.b bVar = new d.a.o0.g0.b(context);
            this.f63628d = bVar;
            bVar.d(this.f63631g);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r3 != 3) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(View view, MotionEvent motionEvent) {
        d.a.o0.g0.b bVar;
        if (this.f63630f == null) {
            this.f63630f = VelocityTracker.obtain();
        }
        this.f63630f.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.f63630f.computeCurrentVelocity(1000);
                if (Math.abs(this.f63630f.getXVelocity()) > Math.abs(this.f63630f.getYVelocity())) {
                    this.f63629e = false;
                } else {
                    this.f63629e = true;
                }
            }
            if (this.f63629e || (bVar = this.f63628d) == null) {
            }
            bVar.c(motionEvent);
            return;
        }
        c();
        if (this.f63629e) {
        }
    }

    public final void c() {
        VelocityTracker velocityTracker = this.f63630f;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f63630f.recycle();
            this.f63630f = null;
        }
    }

    public final void d(boolean z, boolean z2) {
        if (z) {
            CustomMessage customMessage = new CustomMessage(2001617);
            customMessage.setTag(this.f63626b);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001617, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        CustomMessage customMessage2 = new CustomMessage(2001618);
        customMessage2.setTag(this.f63626b);
        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001618, Boolean.valueOf(z2));
        customResponsedMessage2.setOrginalMessage(customMessage2);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
    }

    public final void e(boolean z) {
        this.f63627c = z;
        if (this.f63629e) {
            d(!z, true);
        }
    }
}
