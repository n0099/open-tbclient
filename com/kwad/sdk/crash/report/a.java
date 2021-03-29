package com.kwad.sdk.crash.report;

import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C0396a> f34468a = new ArrayList<>();

    /* renamed from: com.kwad.sdk.crash.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0396a {

        /* renamed from: a  reason: collision with root package name */
        public ExceptionMessage f34469a;

        /* renamed from: b  reason: collision with root package name */
        public int f34470b;

        public C0396a(ExceptionMessage exceptionMessage, int i) {
            this.f34469a = exceptionMessage;
            this.f34470b = i;
        }
    }

    private void a() {
        if (this.f34468a.isEmpty()) {
            return;
        }
        try {
            Iterator<C0396a> it = this.f34468a.iterator();
            while (it.hasNext()) {
                C0396a next = it.next();
                b(next.f34469a, next.f34470b);
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
            this.f34468a.add(new C0396a(exceptionMessage, i));
        }
    }

    @Override // com.kwad.sdk.crash.report.c
    public void a(String str, String str2) {
    }

    @Override // com.kwad.sdk.crash.report.c
    public void b(String str, String str2) {
    }
}
