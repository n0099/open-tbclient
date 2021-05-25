package com.kwad.sdk.crash.report;

import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C0377a> f32993a = new ArrayList<>();

    /* renamed from: com.kwad.sdk.crash.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0377a {

        /* renamed from: a  reason: collision with root package name */
        public ExceptionMessage f32994a;

        /* renamed from: b  reason: collision with root package name */
        public int f32995b;

        public C0377a(ExceptionMessage exceptionMessage, int i2) {
            this.f32994a = exceptionMessage;
            this.f32995b = i2;
        }
    }

    private void a() {
        if (this.f32993a.isEmpty()) {
            return;
        }
        try {
            Iterator<C0377a> it = this.f32993a.iterator();
            while (it.hasNext()) {
                C0377a next = it.next();
                b(next.f32994a, next.f32995b);
                it.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    private void b(ExceptionMessage exceptionMessage, int i2) {
        com.kwad.sdk.core.d.a.a("ExceptionCollector", "upload msg=" + exceptionMessage);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.a(exceptionMessage));
        new com.kwad.sdk.crash.report.request.b().a(arrayList);
    }

    public void a(ExceptionMessage exceptionMessage, int i2) {
        try {
            a();
            b(exceptionMessage, i2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
            this.f32993a.add(new C0377a(exceptionMessage, i2));
        }
    }

    @Override // com.kwad.sdk.crash.report.c
    public void a(String str, String str2) {
    }

    @Override // com.kwad.sdk.crash.report.c
    public void b(String str, String str2) {
    }
}
