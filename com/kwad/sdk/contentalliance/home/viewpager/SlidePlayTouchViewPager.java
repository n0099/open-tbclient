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
/* loaded from: classes6.dex */
public class SlidePlayTouchViewPager extends com.kwad.sdk.contentalliance.b.b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f33104a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f33105b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33106c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public e f33107d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33108e;

    /* renamed from: g  reason: collision with root package name */
    public int f33109g;

    /* renamed from: h  reason: collision with root package name */
    public float f33110h;
    public float i;
    public boolean j;
    public boolean k;
    public BitSet l;
    public List<a> m;

    /* loaded from: classes6.dex */
    public enum TargetBoundUpdatedType {
        ON_SCROLL_END,
        ON_MOVE_TO_NEXT,
        ON_MOVE_TO_PRE,
        RESET
    }

    /* loaded from: classes6.dex */
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
        this.f33108e = true;
        this.m = new ArrayList();
    }

    private void b(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return;
        }
        this.f33110h = motionEvent.getX();
        this.i = motionEvent.getY();
        this.k = false;
        this.j = false;
    }

    private void g() {
        this.j = false;
    }

    private boolean h() {
        return !this.f33108e || getAdapter() == null;
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public int a(int i) {
        if (getCurrentItem() <= getFirstValidItemPosition()) {
            int i2 = this.f33109g;
            if (i - i2 < 0) {
                return i2;
            }
        }
        if (getCurrentItem() >= getLastValidItemPosition()) {
            int i3 = this.f33109g;
            if (i - i3 > 0) {
                return i3;
            }
        }
        return super.a(i);
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public int a(int i, float f2, int i2, int i3) {
        return Math.max(Math.min(super.a(i, f2, i2, i3), getLastValidItemPosition()), getFirstValidItemPosition());
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public void a(int i, boolean z, boolean z2) {
        super.a(i, z, z2);
        a(TargetBoundUpdatedType.RESET);
    }

    public void a(MotionEvent motionEvent) {
        if (this.f33105b) {
            float abs = Math.abs(motionEvent.getX() - this.f33110h);
            float y = motionEvent.getY();
            float abs2 = Math.abs(y - this.i);
            if (abs2 <= this.f32186f || abs2 * 0.5f <= abs) {
                return;
            }
            if (!this.f33104a && y > this.i && getCurrentItem() == getFirstValidItemPosition()) {
                if (!this.f33106c) {
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
        this.f33109g = targetBoundUpdatedType == TargetBoundUpdatedType.ON_SCROLL_END ? getScrollY() : targetBoundUpdatedType == TargetBoundUpdatedType.RESET ? 0 : targetBoundUpdatedType == TargetBoundUpdatedType.ON_MOVE_TO_NEXT ? this.f33109g + getHeight() : this.f33109g - getHeight();
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
        this.f33108e = this.l.cardinality() == 0;
    }

    public boolean a() {
        return !this.f33108e;
    }

    public void b() {
        this.l.clear();
        this.f33108e = this.l.cardinality() == 0;
    }

    public void b(a aVar) {
        this.m.remove(aVar);
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public void c() {
        super.c();
        a(TargetBoundUpdatedType.ON_SCROLL_END);
    }

    public void d() {
    }

    public void e() {
    }

    public boolean f() {
        return false;
    }

    public int getFirstValidItemPosition() {
        return 0;
    }

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
            float abs = Math.abs(motionEvent.getX() - this.f33110h);
            float y = motionEvent.getY();
            float f2 = this.i;
            float f3 = y - f2;
            float abs2 = Math.abs(y - f2);
            if (getCurrentItem() == getFirstValidItemPosition() && f3 > this.f32186f && abs2 * 0.5f > abs) {
                this.j = true;
                e eVar = this.f33107d;
                if (eVar != null && this.f33104a) {
                    eVar.a(motionEvent);
                }
                return true;
            } else if (getCurrentItem() == getLastValidItemPosition() && f3 < (-this.f32186f) && abs2 * 0.5f > abs) {
                this.k = true;
                return true;
            }
        }
        e eVar2 = this.f33107d;
        if (eVar2 != null && this.f33104a) {
            eVar2.a(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        if (r0 != 2) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009b  */
    @Override // com.kwad.sdk.contentalliance.b.b, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        e eVar;
        if (h()) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        b(motionEvent);
        if (action != 0) {
            if (action == 1) {
                a(motionEvent);
            }
            if (this.j) {
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
            e eVar2 = this.f33107d;
            if (eVar2 != null && this.f33104a) {
                eVar2.b(motionEvent);
            }
            return true;
        }
        this.k = false;
        this.j = false;
        float abs = Math.abs(motionEvent.getX() - this.f33110h);
        float y = motionEvent.getY();
        float f2 = this.i;
        float f3 = y - f2;
        float abs2 = Math.abs(y - f2);
        if (getCurrentItem() == getFirstValidItemPosition()) {
            if (f3 > this.f32186f && abs2 * 0.5f > abs) {
                this.j = true;
            }
            if (!this.j && f3 > 0.0f && (eVar = this.f33107d) != null && this.f33104a) {
                eVar.b(motionEvent);
            }
        }
        if (getCurrentItem() == getLastValidItemPosition() && f3 < (-this.f32186f) && abs2 * 0.5f > abs) {
            this.k = true;
        }
        if (this.j) {
        }
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
