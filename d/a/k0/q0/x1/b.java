package d.a.k0.q0.x1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.k0.f0.a;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f59668a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f59669b;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.f0.b f59671d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59672e;

    /* renamed from: f  reason: collision with root package name */
    public VelocityTracker f59673f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59670c = false;

    /* renamed from: g  reason: collision with root package name */
    public a.b f59674g = new a();

    /* loaded from: classes4.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.k0.f0.a.b
        public void a(int i2, int i3) {
            if (e(i3)) {
                b.this.e(true);
            }
        }

        @Override // d.a.k0.f0.a.b
        public void b(int i2, int i3) {
            if (e(i3)) {
                b.this.e(false);
            }
        }

        @Override // d.a.k0.f0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.k0.f0.a.b
        public void d(int i2, int i3) {
        }

        public final boolean e(float f2) {
            return Math.abs(f2) >= 10.0f;
        }
    }

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.f59668a = context;
        this.f59669b = bdUniqueId;
        this.f59672e = z;
        if (z) {
            d.a.k0.f0.b bVar = new d.a.k0.f0.b(context);
            this.f59671d = bVar;
            bVar.d(this.f59674g);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r3 != 3) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(View view, MotionEvent motionEvent) {
        d.a.k0.f0.b bVar;
        if (this.f59673f == null) {
            this.f59673f = VelocityTracker.obtain();
        }
        this.f59673f.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.f59673f.computeCurrentVelocity(1000);
                if (Math.abs(this.f59673f.getXVelocity()) > Math.abs(this.f59673f.getYVelocity())) {
                    this.f59672e = false;
                } else {
                    this.f59672e = true;
                }
            }
            if (this.f59672e || (bVar = this.f59671d) == null) {
            }
            bVar.c(motionEvent);
            return;
        }
        c();
        if (this.f59672e) {
        }
    }

    public final void c() {
        VelocityTracker velocityTracker = this.f59673f;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f59673f.recycle();
            this.f59673f = null;
        }
    }

    public final void d(boolean z, boolean z2) {
        if (z) {
            CustomMessage customMessage = new CustomMessage(2001617);
            customMessage.setTag(this.f59669b);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001617, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        CustomMessage customMessage2 = new CustomMessage(2001618);
        customMessage2.setTag(this.f59669b);
        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001618, Boolean.valueOf(z2));
        customResponsedMessage2.setOrginalMessage(customMessage2);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
    }

    public final void e(boolean z) {
        this.f59670c = z;
        if (this.f59672e) {
            d(!z, true);
        }
    }
}
