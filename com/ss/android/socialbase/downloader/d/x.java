package com.ss.android.socialbase.downloader.d;
/* loaded from: classes4.dex */
public abstract class x implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13122a = x.class.getSimpleName();

    @Override // com.ss.android.socialbase.downloader.d.b
    public void a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (com.ss.android.socialbase.downloader.f.a.a() && cVar != null) {
            com.ss.android.socialbase.downloader.f.a.b(f13122a, " onPrepare -- " + cVar.h());
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.b
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        if (com.ss.android.socialbase.downloader.f.a.a() && cVar != null) {
            com.ss.android.socialbase.downloader.f.a.b(f13122a, " onStart -- " + cVar.h());
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.b
    public void c(com.ss.android.socialbase.downloader.g.c cVar) {
        if (com.ss.android.socialbase.downloader.f.a.a() && cVar != null && cVar.efR() != 0) {
            com.ss.android.socialbase.downloader.f.a.b(f13122a, cVar.h() + " onProgress -- %" + ((int) ((((float) cVar.eEJ()) / ((float) cVar.efR())) * 100.0f)));
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.b
    public void d(com.ss.android.socialbase.downloader.g.c cVar) {
        if (com.ss.android.socialbase.downloader.f.a.a() && cVar != null) {
            com.ss.android.socialbase.downloader.f.a.b(f13122a, " onPause -- " + cVar.h());
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.b
    public void e(com.ss.android.socialbase.downloader.g.c cVar) {
        if (com.ss.android.socialbase.downloader.f.a.a() && cVar != null) {
            com.ss.android.socialbase.downloader.f.a.b(f13122a, " onSuccessed -- " + cVar.h());
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.b
    public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar) {
        if (com.ss.android.socialbase.downloader.f.a.a() && cVar != null) {
            String str = f13122a;
            Object[] objArr = new Object[2];
            objArr[0] = cVar.h();
            objArr[1] = aVar != null ? aVar.b() : "unkown";
            com.ss.android.socialbase.downloader.f.a.b(str, String.format("onFailed on %s because of : %s", objArr));
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.b
    public void f(com.ss.android.socialbase.downloader.g.c cVar) {
        if (com.ss.android.socialbase.downloader.f.a.a() && cVar != null) {
            com.ss.android.socialbase.downloader.f.a.b(f13122a, " onCanceled -- " + cVar.h());
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.b
    public void h(com.ss.android.socialbase.downloader.g.c cVar) {
        if (com.ss.android.socialbase.downloader.f.a.a() && cVar != null) {
            com.ss.android.socialbase.downloader.f.a.b(f13122a, " onFirstStart -- " + cVar.h());
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.b
    public void i(com.ss.android.socialbase.downloader.g.c cVar) {
        if (com.ss.android.socialbase.downloader.f.a.a() && cVar != null) {
            com.ss.android.socialbase.downloader.f.a.b(f13122a, " onFirstSuccess -- " + cVar.h());
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.b
    public void b(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar) {
        if (com.ss.android.socialbase.downloader.f.a.a() && cVar != null) {
            String str = f13122a;
            Object[] objArr = new Object[2];
            objArr[0] = cVar.h();
            objArr[1] = aVar != null ? aVar.b() : "unkown";
            com.ss.android.socialbase.downloader.f.a.b(str, String.format("onRetry on %s because of : %s", objArr));
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.b
    public void c(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar) {
        if (com.ss.android.socialbase.downloader.f.a.a() && cVar != null) {
            String str = f13122a;
            Object[] objArr = new Object[2];
            objArr[0] = cVar.h();
            objArr[1] = aVar != null ? aVar.b() : "unkown";
            com.ss.android.socialbase.downloader.f.a.b(str, String.format("onRetryDelay on %s because of : %s", objArr));
        }
    }

    public void p(com.ss.android.socialbase.downloader.g.c cVar) {
        if (com.ss.android.socialbase.downloader.f.a.a() && cVar != null) {
            com.ss.android.socialbase.downloader.f.a.b(f13122a, " onIntercept -- " + cVar.h());
        }
    }
}
