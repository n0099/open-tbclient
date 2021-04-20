package d.b.i0.q0.x1;

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
    public Context f60390a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f60391b;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.f0.b f60393d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60394e;

    /* renamed from: f  reason: collision with root package name */
    public VelocityTracker f60395f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60392c = false;

    /* renamed from: g  reason: collision with root package name */
    public a.b f60396g = new a();

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
        this.f60390a = context;
        this.f60391b = bdUniqueId;
        this.f60394e = z;
        if (z) {
            d.b.i0.f0.b bVar = new d.b.i0.f0.b(context);
            this.f60393d = bVar;
            bVar.d(this.f60396g);
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
        if (this.f60395f == null) {
            this.f60395f = VelocityTracker.obtain();
        }
        this.f60395f.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.f60395f.computeCurrentVelocity(1000);
                if (Math.abs(this.f60395f.getXVelocity()) > Math.abs(this.f60395f.getYVelocity())) {
                    this.f60394e = false;
                } else {
                    this.f60394e = true;
                }
            }
            if (this.f60394e || (bVar = this.f60393d) == null) {
            }
            bVar.c(motionEvent);
            return;
        }
        c();
        if (this.f60394e) {
        }
    }

    public final void c() {
        VelocityTracker velocityTracker = this.f60395f;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f60395f.recycle();
            this.f60395f = null;
        }
    }

    public final void d(boolean z, boolean z2) {
        if (z) {
            CustomMessage customMessage = new CustomMessage(2001617);
            customMessage.setTag(this.f60391b);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001617, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        CustomMessage customMessage2 = new CustomMessage(2001618);
        customMessage2.setTag(this.f60391b);
        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001618, Boolean.valueOf(z2));
        customResponsedMessage2.setOrginalMessage(customMessage2);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
    }

    public final void e(boolean z) {
        this.f60392c = z;
        if (this.f60394e) {
            d(!z, true);
        }
    }
}
