package com.kwad.sdk.crash.report;

import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public abstract class a implements c {
    public ArrayList<C2122a> a = new ArrayList<>();

    /* renamed from: com.kwad.sdk.crash.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2122a {
        public ExceptionMessage a;

        /* renamed from: b  reason: collision with root package name */
        public int f56549b;

        public C2122a(ExceptionMessage exceptionMessage, int i2) {
            this.a = exceptionMessage;
            this.f56549b = i2;
        }
    }

    private void a() {
        if (this.a.isEmpty()) {
            return;
        }
        try {
            Iterator<C2122a> it = this.a.iterator();
            while (it.hasNext()) {
                C2122a next = it.next();
                b(next.a, next.f56549b);
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
            this.a.add(new C2122a(exceptionMessage, i2));
        }
    }

    @Override // com.kwad.sdk.crash.report.c
    public void a(String str, String str2) {
    }

    @Override // com.kwad.sdk.crash.report.c
    public void b(String str, String str2) {
    }
}
