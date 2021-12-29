package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f60211e;
    public j a;

    /* renamed from: b  reason: collision with root package name */
    public List<WeakReference<j.a>> f60212b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f60213c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60214d = false;

    public b(@NonNull Context context) {
        b(context);
    }

    public static b a(@NonNull Context context) {
        if (f60211e == null) {
            synchronized (b.class) {
                if (f60211e == null) {
                    f60211e = new b(context.getApplicationContext());
                }
            }
        }
        return f60211e;
    }

    private void b(Context context) {
        this.f60213c = false;
        j jVar = new j(context);
        this.a = jVar;
        jVar.a(new j.a() { // from class: com.kwad.sdk.utils.b.1
            @Override // com.kwad.sdk.utils.j.a
            public void a() {
                j.a aVar;
                Iterator it = b.this.f60212b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (aVar = (j.a) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        aVar.a();
                    }
                }
                b.this.f60214d = true;
            }

            @Override // com.kwad.sdk.utils.j.a
            public void b() {
                j.a aVar;
                Iterator it = b.this.f60212b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (aVar = (j.a) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        aVar.b();
                    }
                }
            }
        });
    }

    public void a(j.a aVar) {
        this.f60212b.add(new WeakReference<>(aVar));
    }

    public void a(boolean z) {
        if (this.a == null) {
            return;
        }
        if (z || !this.f60213c) {
            this.a.a();
            this.f60213c = true;
            this.f60214d = false;
        }
    }

    public boolean a() {
        return this.f60214d;
    }

    public void b(j.a aVar) {
        Iterator<WeakReference<j.a>> it = this.f60212b.iterator();
        while (it.hasNext()) {
            WeakReference<j.a> next = it.next();
            if (next == null || next.get() == aVar) {
                it.remove();
            }
        }
    }
}
