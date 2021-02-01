package com.kwad.sdk.contentalliance.home.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.sdk.contentalliance.refreshview.e;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes3.dex */
public class SlidePlayTouchViewPager extends com.kwad.sdk.contentalliance.b.b {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f8754a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f8755b;
    protected boolean c;
    @Nullable
    protected e d;
    protected boolean e;
    private int g;
    private float h;
    private float i;
    private boolean j;
    private boolean k;
    private BitSet l;
    private List<a> m;

    /* loaded from: classes3.dex */
    public enum TargetBoundUpdatedType {
        ON_SCROLL_END,
        ON_MOVE_TO_NEXT,
        ON_MOVE_TO_PRE,
        RESET
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    public SlidePlayTouchViewPager(Context context) {
        this(context, null);
    }

    public SlidePlayTouchViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new BitSet();
        this.e = true;
        this.m = new ArrayList();
    }

    private void b(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.h = motionEvent.getX();
                this.i = motionEvent.getY();
                this.k = false;
                this.j = false;
                return;
            default:
                return;
        }
    }

    private void g() {
        this.j = false;
    }

    private boolean h() {
        return !this.e || getAdapter() == null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.b.b
    public int a(int i) {
        return (getCurrentItem() > getFirstValidItemPosition() || i - this.g >= 0) ? (getCurrentItem() < getLastValidItemPosition() || i - this.g <= 0) ? super.a(i) : this.g : this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.b.b
    public int a(int i, float f, int i2, int i3) {
        return Math.max(Math.min(super.a(i, f, i2, i3), getLastValidItemPosition()), getFirstValidItemPosition());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.b.b
    public void a(int i, boolean z, boolean z2) {
        super.a(i, z, z2);
        a(TargetBoundUpdatedType.RESET);
    }

    protected void a(MotionEvent motionEvent) {
        if (this.f8755b) {
            float abs = Math.abs(motionEvent.getX() - this.h);
            float y = motionEvent.getY();
            float abs2 = Math.abs(y - this.i);
            if (abs2 <= this.f || abs2 * 0.5f <= abs) {
                return;
            }
            if (!this.f8754a && y > this.i && getCurrentItem() == getFirstValidItemPosition()) {
                if (!this.c) {
                    e();
                }
                for (a aVar : this.m) {
                    aVar.a();
                }
            } else if (getCurrentItem() == getLastValidItemPosition() && !f() && y < this.i) {
                d();
                for (a aVar2 : this.m) {
                    aVar2.b();
                }
            }
        }
    }

    public void a(TargetBoundUpdatedType targetBoundUpdatedType) {
        if (targetBoundUpdatedType == TargetBoundUpdatedType.ON_SCROLL_END) {
            this.g = getScrollY();
        } else if (targetBoundUpdatedType == TargetBoundUpdatedType.RESET) {
            this.g = 0;
        } else if (targetBoundUpdatedType == TargetBoundUpdatedType.ON_MOVE_TO_NEXT) {
            this.g += getHeight();
        } else {
            this.g -= getHeight();
        }
    }

    public void a(a aVar) {
        if (this.m.contains(aVar)) {
            return;
        }
        this.m.add(aVar);
    }

    public void a(boolean z, int i) {
        com.kwad.sdk.core.d.a.a("SlidePlayTouchViewPager", "enable:" + z + ";flag:" + i);
        if (z) {
            this.l.clear(i);
        } else {
            this.l.set(i);
        }
        this.e = this.l.cardinality() == 0;
    }

    public boolean a() {
        return !this.e;
    }

    public void b() {
        this.l.clear();
        this.e = this.l.cardinality() == 0;
    }

    public void b(a aVar) {
        this.m.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.b.b
    public void c() {
        super.c();
        a(TargetBoundUpdatedType.ON_SCROLL_END);
    }

    protected void d() {
    }

    protected void e() {
    }

    protected boolean f() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getFirstValidItemPosition() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLastValidItemPosition() {
        return getAdapter().getCount() - 1;
    }

    @Override // com.kwad.sdk.contentalliance.b.b, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (h()) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        b(motionEvent);
        if (action == 2) {
            float abs = Math.abs(motionEvent.getX() - this.h);
            float y = motionEvent.getY();
            float f = y - this.i;
            float abs2 = Math.abs(y - this.i);
            if (getCurrentItem() == getFirstValidItemPosition() && f > this.f && abs2 * 0.5f > abs) {
                this.j = true;
                if (this.d == null || !this.f8754a) {
                    return true;
                }
                this.d.a(motionEvent);
                return true;
            } else if (getCurrentItem() == getLastValidItemPosition() && f < (-this.f) && abs2 * 0.5f > abs) {
                this.k = true;
                return true;
            }
        }
        if (this.d != null && this.f8754a) {
            this.d.a(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    @Override // com.kwad.sdk.contentalliance.b.b, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (h()) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        b(motionEvent);
        switch (action) {
            case 0:
                this.k = false;
                this.j = false;
                float abs = Math.abs(motionEvent.getX() - this.h);
                float y = motionEvent.getY();
                float f = y - this.i;
                float abs2 = Math.abs(y - this.i);
                if (getCurrentItem() == getFirstValidItemPosition()) {
                    if (f > this.f && abs2 * 0.5f > abs) {
                        this.j = true;
                    }
                    if (!this.j && f > 0.0f && this.d != null && this.f8754a) {
                        this.d.b(motionEvent);
                    }
                }
                if (getCurrentItem() == getLastValidItemPosition() && f < (-this.f) && abs2 * 0.5f > abs) {
                    this.k = true;
                    break;
                }
                break;
            case 1:
                a(motionEvent);
                break;
            case 2:
                float abs3 = Math.abs(motionEvent.getX() - this.h);
                float y2 = motionEvent.getY();
                float f2 = y2 - this.i;
                float abs22 = Math.abs(y2 - this.i);
                if (getCurrentItem() == getFirstValidItemPosition()) {
                }
                if (getCurrentItem() == getLastValidItemPosition()) {
                    this.k = true;
                    break;
                }
                break;
        }
        if (!this.j) {
            if (this.k) {
                if (action == 1) {
                    super.onTouchEvent(motionEvent);
                }
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        if (action == 1 || action == 3) {
            g();
        }
        if (this.d != null && this.f8754a) {
            this.d.b(motionEvent);
        }
        return true;
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public void setAdapter(PagerAdapter pagerAdapter) {
        super.setAdapter(pagerAdapter);
        a(TargetBoundUpdatedType.RESET);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        a(z, 1);
    }
}
