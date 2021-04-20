package com.kwad.sdk.crash.report;

import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C0410a> f34757a = new ArrayList<>();

    /* renamed from: com.kwad.sdk.crash.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0410a {

        /* renamed from: a  reason: collision with root package name */
        public ExceptionMessage f34758a;

        /* renamed from: b  reason: collision with root package name */
        public int f34759b;

        public C0410a(ExceptionMessage exceptionMessage, int i) {
            this.f34758a = exceptionMessage;
            this.f34759b = i;
        }
    }

    private void a() {
        if (this.f34757a.isEmpty()) {
            return;
        }
        try {
            Iterator<C0410a> it = this.f34757a.iterator();
            while (it.hasNext()) {
                C0410a next = it.next();
                b(next.f34758a, next.f34759b);
                it.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    private void b(ExceptionMessage exceptionMessage, int i) {
        com.kwad.sdk.core.d.a.a("ExceptionCollector", "upload msg=" + exceptionMessage);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.a(exceptionMessage));
        new com.kwad.sdk.crash.report.request.b().a(arrayList);
    }

    public void a(ExceptionMessage exceptionMessage, int i) {
        try {
            a();
            b(exceptionMessage, i);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
            this.f34757a.add(new C0410a(exceptionMessage, i));
        }
    }

    @Override // com.kwad.sdk.crash.report.c
    public void a(String str, String str2) {
    }

    @Override // com.kwad.sdk.crash.report.c
    public void b(String str, String str2) {
    }
}
