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
    public Set<a> f32789b;

    /* renamed from: c  reason: collision with root package name */
    public Set<c> f32790c;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public View f32793f;

    /* renamed from: g  reason: collision with root package name */
    public int f32794g;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32791d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32792e = true;

    /* renamed from: a  reason: collision with root package name */
    public final ao f32788a = new ao(this);

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z);
    }

    public b(@NonNull View view, int i2) {
        this.f32793f = view;
        this.f32794g = i2;
    }

    private void a(boolean z) {
        Set<a> set = this.f32789b;
        if (set != null) {
            for (a aVar : set) {
                if (aVar != null) {
                    aVar.a(z);
                }
            }
        }
        if (this.f32790c != null) {
            if (z != this.f32791d || this.f32792e) {
                this.f32791d = z;
                this.f32792e = false;
                if (z) {
                    for (c cVar : this.f32790c) {
                        if (cVar != null) {
                            cVar.a_();
                        }
                    }
                    return;
                }
                for (c cVar2 : this.f32790c) {
                    if (cVar2 != null) {
                        cVar2.a_();
                    }
                }
            }
        }
    }

    public void a() {
        this.f32788a.removeMessages(1);
        this.f32788a.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ao.a
    public void a(Message message) {
        if (message.what == 1) {
            a(d());
            this.f32788a.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.sdk.core.i.b
    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f32790c == null) {
            this.f32790c = new HashSet();
        }
        this.f32790c.add(cVar);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f32789b == null) {
            this.f32789b = new HashSet();
        }
        this.f32789b.add(aVar);
    }

    public void b() {
        this.f32788a.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.i.b
    public void b(c cVar) {
        Set<c> set;
        if (cVar == null || (set = this.f32790c) == null) {
            return;
        }
        set.remove(cVar);
    }

    public void b(a aVar) {
        Set<a> set;
        if (aVar == null || (set = this.f32789b) == null) {
            return;
        }
        set.remove(aVar);
    }

    public void c() {
        b();
        Set<a> set = this.f32789b;
        if (set != null) {
            set.clear();
        }
        Set<c> set2 = this.f32790c;
        if (set2 != null) {
            set2.clear();
        }
    }

    public boolean d() {
        return an.a(this.f32793f, this.f32794g);
    }
}
