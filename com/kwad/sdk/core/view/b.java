package com.kwad.sdk.core.view;

import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.i.c;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.ao;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.i.b, ao.a {

    /* renamed from: b  reason: collision with root package name */
    public Set<a> f33615b;

    /* renamed from: c  reason: collision with root package name */
    public Set<c> f33616c;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public View f33619f;

    /* renamed from: g  reason: collision with root package name */
    public int f33620g;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33617d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33618e = true;

    /* renamed from: a  reason: collision with root package name */
    public final ao f33614a = new ao(this);

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z);
    }

    public b(@NonNull View view, int i2) {
        this.f33619f = view;
        this.f33620g = i2;
    }

    private void a(boolean z) {
        Set<a> set = this.f33615b;
        if (set != null) {
            for (a aVar : set) {
                if (aVar != null) {
                    aVar.a(z);
                }
            }
        }
        if (this.f33616c != null) {
            if (z != this.f33617d || this.f33618e) {
                this.f33617d = z;
                this.f33618e = false;
                if (z) {
                    for (c cVar : this.f33616c) {
                        if (cVar != null) {
                            cVar.a_();
                        }
                    }
                    return;
                }
                for (c cVar2 : this.f33616c) {
                    if (cVar2 != null) {
                        cVar2.a_();
                    }
                }
            }
        }
    }

    public void a() {
        this.f33614a.removeMessages(1);
        this.f33614a.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ao.a
    public void a(Message message) {
        if (message.what == 1) {
            a(d());
            this.f33614a.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.sdk.core.i.b
    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f33616c == null) {
            this.f33616c = new HashSet();
        }
        this.f33616c.add(cVar);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f33615b == null) {
            this.f33615b = new HashSet();
        }
        this.f33615b.add(aVar);
    }

    public void b() {
        this.f33614a.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.i.b
    public void b(c cVar) {
        Set<c> set;
        if (cVar == null || (set = this.f33616c) == null) {
            return;
        }
        set.remove(cVar);
    }

    public void b(a aVar) {
        Set<a> set;
        if (aVar == null || (set = this.f33615b) == null) {
            return;
        }
        set.remove(aVar);
    }

    public void c() {
        b();
        Set<a> set = this.f33615b;
        if (set != null) {
            set.clear();
        }
        Set<c> set2 = this.f33616c;
        if (set2 != null) {
            set2.clear();
        }
    }

    public boolean d() {
        return an.a(this.f33619f, this.f33620g);
    }
}
