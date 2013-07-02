package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class bn {
    protected bj a;
    protected a b;

    /* loaded from: classes.dex */
    public final class a {
        public IBinder a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.b);
            bundle.putInt("popupLocationInfo.displayId", this.c);
            bundle.putInt("popupLocationInfo.left", this.d);
            bundle.putInt("popupLocationInfo.top", this.e);
            bundle.putInt("popupLocationInfo.right", this.f);
            bundle.putInt("popupLocationInfo.bottom", this.g);
            return bundle;
        }
    }

    /* loaded from: classes.dex */
    final class b extends bn implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        private WeakReference c;
        private boolean d;

        private void a(View view) {
            int displayId = ba.c() ? view.getDisplay().getDisplayId() : -1;
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.b.c = displayId;
            this.b.a = windowToken;
            this.b.d = iArr[0];
            this.b.e = iArr[1];
            this.b.f = iArr[0] + width;
            this.b.g = iArr[1] + height;
            if (this.d) {
                a();
                this.d = false;
            }
        }

        @Override // com.google.android.gms.internal.bn
        public void a() {
            if (this.b.a != null) {
                super.a();
            } else {
                this.d = this.c != null;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View view;
            if (this.c == null || (view = (View) this.c.get()) == null) {
                return;
            }
            a(view);
        }
    }

    public void a() {
        this.a.a(this.b.a, this.b.a());
    }

    public IBinder b() {
        return this.b.a;
    }
}
