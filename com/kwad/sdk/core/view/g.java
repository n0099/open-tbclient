package com.kwad.sdk.core.view;

import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class g implements com.kwad.sdk.core.i.b, ap.a {

    /* renamed from: b  reason: collision with root package name */
    private Set<a> f9535b;
    private Set<com.kwad.sdk.core.i.c> c;
    @NonNull
    private View f;
    private int g;
    private boolean d = false;
    private boolean e = true;

    /* renamed from: a  reason: collision with root package name */
    private final ap f9534a = new ap(this);

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z);
    }

    public g(@NonNull View view, int i) {
        this.f = view;
        this.g = i;
    }

    private void a(boolean z) {
        if (this.f9535b != null) {
            for (a aVar : this.f9535b) {
                if (aVar != null) {
                    aVar.a(z);
                }
            }
        }
        if (this.c != null) {
            if (z != this.d || this.e) {
                this.d = z;
                this.e = false;
                if (z) {
                    for (com.kwad.sdk.core.i.c cVar : this.c) {
                        if (cVar != null) {
                            cVar.c_();
                        }
                    }
                    return;
                }
                for (com.kwad.sdk.core.i.c cVar2 : this.c) {
                    if (cVar2 != null) {
                        cVar2.c_();
                    }
                }
            }
        }
    }

    public void a() {
        this.f9534a.removeMessages(1);
        this.f9534a.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        if (message.what == 1) {
            a(d());
            this.f9534a.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.sdk.core.i.b
    public void a(com.kwad.sdk.core.i.c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.c == null) {
            this.c = new HashSet();
        }
        this.c.add(cVar);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f9535b == null) {
            this.f9535b = new HashSet();
        }
        this.f9535b.add(aVar);
    }

    public void b() {
        this.f9534a.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.i.b
    public void b(com.kwad.sdk.core.i.c cVar) {
        if (cVar == null || this.c == null) {
            return;
        }
        this.c.remove(cVar);
    }

    public void b(a aVar) {
        if (aVar == null || this.f9535b == null) {
            return;
        }
        this.f9535b.remove(aVar);
    }

    public void c() {
        b();
        if (this.f9535b != null) {
            this.f9535b.clear();
        }
        if (this.c != null) {
            this.c.clear();
        }
    }

    public boolean d() {
        return ao.a(this.f, this.g);
    }
}
