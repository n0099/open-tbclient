package com.kwad.sdk.crash.report;

import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<C1128a> f6385a = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kwad.sdk.crash.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1128a {

        /* renamed from: a  reason: collision with root package name */
        private ExceptionMessage f6386a;
        private int b;

        C1128a(ExceptionMessage exceptionMessage, int i) {
            this.f6386a = exceptionMessage;
            this.b = i;
        }
    }

    private void a() {
        if (this.f6385a.isEmpty()) {
            return;
        }
        try {
            Iterator<C1128a> it = this.f6385a.iterator();
            while (it.hasNext()) {
                C1128a next = it.next();
                b(next.f6386a, next.b);
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
            this.f6385a.add(new C1128a(exceptionMessage, i));
        }
    }

    @Override // com.kwad.sdk.crash.report.c
    public void a(String str, String str2) {
    }

    @Override // com.kwad.sdk.crash.report.c
    public void b(String str, String str2) {
    }
}
