package com.kwad.sdk.crash.report;

import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<C1122a> f9943a = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kwad.sdk.crash.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1122a {

        /* renamed from: a  reason: collision with root package name */
        private ExceptionMessage f9944a;

        /* renamed from: b  reason: collision with root package name */
        private int f9945b;

        C1122a(ExceptionMessage exceptionMessage, int i) {
            this.f9944a = exceptionMessage;
            this.f9945b = i;
        }
    }

    private void a() {
        if (this.f9943a.isEmpty()) {
            return;
        }
        try {
            Iterator<C1122a> it = this.f9943a.iterator();
            while (it.hasNext()) {
                C1122a next = it.next();
                b(next.f9944a, next.f9945b);
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
            this.f9943a.add(new C1122a(exceptionMessage, i));
        }
    }

    @Override // com.kwad.sdk.crash.report.c
    public void a(String str, String str2) {
    }

    @Override // com.kwad.sdk.crash.report.c
    public void b(String str, String str2) {
    }
}
