package com.kwad.sdk.crash.report;

import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C0399a> f35215a = new ArrayList<>();

    /* renamed from: com.kwad.sdk.crash.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0399a {

        /* renamed from: a  reason: collision with root package name */
        public ExceptionMessage f35216a;

        /* renamed from: b  reason: collision with root package name */
        public int f35217b;

        public C0399a(ExceptionMessage exceptionMessage, int i2) {
            this.f35216a = exceptionMessage;
            this.f35217b = i2;
        }
    }

    private void a() {
        if (this.f35215a.isEmpty()) {
            return;
        }
        try {
            Iterator<C0399a> it = this.f35215a.iterator();
            while (it.hasNext()) {
                C0399a next = it.next();
                b(next.f35216a, next.f35217b);
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
            this.f35215a.add(new C0399a(exceptionMessage, i2));
        }
    }

    @Override // com.kwad.sdk.crash.report.c
    public void a(String str, String str2) {
    }

    @Override // com.kwad.sdk.crash.report.c
    public void b(String str, String str2) {
    }
}
