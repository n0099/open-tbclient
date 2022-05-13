package com.kwad.sdk.crash.report;

import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class a implements c {
    public ArrayList<C0317a> a = new ArrayList<>();

    /* renamed from: com.kwad.sdk.crash.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0317a {
        public ExceptionMessage a;
        public int b;

        public C0317a(ExceptionMessage exceptionMessage, int i) {
            this.a = exceptionMessage;
            this.b = i;
        }
    }

    private void a() {
        if (this.a.isEmpty()) {
            return;
        }
        try {
            Iterator<C0317a> it = this.a.iterator();
            while (it.hasNext()) {
                C0317a next = it.next();
                b(next.a, next.b);
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
            this.a.add(new C0317a(exceptionMessage, i));
        }
    }

    @Override // com.kwad.sdk.crash.report.c
    public void a(String str, String str2) {
    }

    @Override // com.kwad.sdk.crash.report.c
    public void b(String str, String str2) {
    }
}
