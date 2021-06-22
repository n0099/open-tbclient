package com.kwad.sdk.core.view;

import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class g implements com.kwad.sdk.core.i.b, ap.a {

    /* renamed from: b  reason: collision with root package name */
    public Set<a> f35020b;

    /* renamed from: c  reason: collision with root package name */
    public Set<com.kwad.sdk.core.i.c> f35021c;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public View f35024f;

    /* renamed from: g  reason: collision with root package name */
    public int f35025g;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35022d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35023e = true;

    /* renamed from: a  reason: collision with root package name */
    public final ap f35019a = new ap(this);

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z);
    }

    public g(@NonNull View view, int i2) {
        this.f35024f = view;
        this.f35025g = i2;
    }

    private void a(boolean z) {
        Set<a> set = this.f35020b;
        if (set != null) {
            for (a aVar : set) {
                if (aVar != null) {
                    aVar.a(z);
                }
            }
        }
        if (this.f35021c != null) {
            if (z != this.f35022d || this.f35023e) {
                this.f35022d = z;
                this.f35023e = false;
                if (z) {
                    for (com.kwad.sdk.core.i.c cVar : this.f35021c) {
                        if (cVar != null) {
                            cVar.c_();
                        }
                    }
                    return;
                }
                for (com.kwad.sdk.core.i.c cVar2 : this.f35021c) {
                    if (cVar2 != null) {
                        cVar2.c_();
                    }
                }
            }
        }
    }

    public void a() {
        this.f35019a.removeMessages(1);
        this.f35019a.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        if (message.what == 1) {
            a(d());
            this.f35019a.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.sdk.core.i.b
    public void a(com.kwad.sdk.core.i.c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f35021c == null) {
            this.f35021c = new HashSet();
        }
        this.f35021c.add(cVar);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f35020b == null) {
            this.f35020b = new HashSet();
        }
        this.f35020b.add(aVar);
    }

    public void b() {
        this.f35019a.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.i.b
    public void b(com.kwad.sdk.core.i.c cVar) {
        Set<com.kwad.sdk.core.i.c> set;
        if (cVar == null || (set = this.f35021c) == null) {
            return;
        }
        set.remove(cVar);
    }

    public void b(a aVar) {
        Set<a> set;
        if (aVar == null || (set = this.f35020b) == null) {
            return;
        }
        set.remove(aVar);
    }

    public void c() {
        b();
        Set<a> set = this.f35020b;
        if (set != null) {
            set.clear();
        }
        Set<com.kwad.sdk.core.i.c> set2 = this.f35021c;
        if (set2 != null) {
            set2.clear();
        }
    }

    public boolean d() {
        return ao.a(this.f35024f, this.f35025g);
    }
}
