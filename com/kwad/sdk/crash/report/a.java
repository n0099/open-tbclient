package com.kwad.sdk.crash.report;

import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C0389a> f33819a = new ArrayList<>();

    /* renamed from: com.kwad.sdk.crash.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0389a {

        /* renamed from: a  reason: collision with root package name */
        public ExceptionMessage f33820a;

        /* renamed from: b  reason: collision with root package name */
        public int f33821b;

        public C0389a(ExceptionMessage exceptionMessage, int i2) {
            this.f33820a = exceptionMessage;
            this.f33821b = i2;
        }
    }

    private void a() {
        if (this.f33819a.isEmpty()) {
            return;
        }
        try {
            Iterator<C0389a> it = this.f33819a.iterator();
            while (it.hasNext()) {
                C0389a next = it.next();
                b(next.f33820a, next.f33821b);
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
            this.f33819a.add(new C0389a(exceptionMessage, i2));
        }
    }

    @Override // com.kwad.sdk.crash.report.c
    public void a(String str, String str2) {
    }

    @Override // com.kwad.sdk.crash.report.c
    public void b(String str, String str2) {
    }
}
