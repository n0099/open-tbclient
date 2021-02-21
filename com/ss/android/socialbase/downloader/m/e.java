package com.ss.android.socialbase.downloader.m;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.d.ab;
import com.ss.android.socialbase.downloader.d.ac;
import com.ss.android.socialbase.downloader.d.ad;
import com.ss.android.socialbase.downloader.d.ae;
import com.ss.android.socialbase.downloader.d.af;
import com.ss.android.socialbase.downloader.d.ag;
import com.ss.android.socialbase.downloader.d.ah;
import com.ss.android.socialbase.downloader.d.ai;
import com.ss.android.socialbase.downloader.d.aj;
import com.ss.android.socialbase.downloader.d.ak;
import com.ss.android.socialbase.downloader.d.al;
import com.ss.android.socialbase.downloader.d.am;
import com.ss.android.socialbase.downloader.d.an;
import com.ss.android.socialbase.downloader.d.f;
import com.ss.android.socialbase.downloader.d.g;
import com.ss.android.socialbase.downloader.d.h;
import com.ss.android.socialbase.downloader.d.i;
import com.ss.android.socialbase.downloader.d.j;
import com.ss.android.socialbase.downloader.d.k;
import com.ss.android.socialbase.downloader.d.m;
import com.ss.android.socialbase.downloader.d.p;
import com.ss.android.socialbase.downloader.d.q;
import com.ss.android.socialbase.downloader.d.r;
import com.ss.android.socialbase.downloader.d.t;
import com.ss.android.socialbase.downloader.d.v;
import com.ss.android.socialbase.downloader.d.w;
import com.ss.android.socialbase.downloader.d.y;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.g.a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f13223a = new Handler(Looper.getMainLooper());

    public static com.ss.android.socialbase.downloader.g.a f(final com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar == null) {
            return null;
        }
        return new a.AbstractBinderC1253a() { // from class: com.ss.android.socialbase.downloader.m.e.1
            @Override // com.ss.android.socialbase.downloader.g.a
            public com.ss.android.socialbase.downloader.g.c a() throws RemoteException {
                return com.ss.android.socialbase.downloader.g.d.this.a();
            }

            @Override // com.ss.android.socialbase.downloader.g.a
            public com.ss.android.socialbase.downloader.d.f b() throws RemoteException {
                return e.d(com.ss.android.socialbase.downloader.g.d.this.eIl());
            }

            @Override // com.ss.android.socialbase.downloader.g.a
            public j b(int i) throws RemoteException {
                return e.a(com.ss.android.socialbase.downloader.g.d.this.d(d.Sa(i)), i != com.ss.android.socialbase.downloader.b.h.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.g.a
            public int a(int i) throws RemoteException {
                return com.ss.android.socialbase.downloader.g.d.this.c(d.Sa(i));
            }

            @Override // com.ss.android.socialbase.downloader.g.a
            public j a(int i, int i2) throws RemoteException {
                return e.a(com.ss.android.socialbase.downloader.g.d.this.a(d.Sa(i), i2), i != com.ss.android.socialbase.downloader.b.h.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.g.a
            public ac c() throws RemoteException {
                return e.c(com.ss.android.socialbase.downloader.g.d.this.eIp());
            }

            @Override // com.ss.android.socialbase.downloader.g.a
            public ai d() throws RemoteException {
                return e.d(com.ss.android.socialbase.downloader.g.d.this.eIq());
            }

            @Override // com.ss.android.socialbase.downloader.g.a
            public com.ss.android.socialbase.downloader.d.i e() throws RemoteException {
                return e.b(com.ss.android.socialbase.downloader.g.d.this.eIi());
            }

            @Override // com.ss.android.socialbase.downloader.g.a
            public com.ss.android.socialbase.downloader.d.g f() throws RemoteException {
                return e.b(com.ss.android.socialbase.downloader.g.d.this.eIj());
            }

            @Override // com.ss.android.socialbase.downloader.g.a
            public k j() throws RemoteException {
                return e.b(com.ss.android.socialbase.downloader.g.d.this.eIk());
            }

            @Override // com.ss.android.socialbase.downloader.g.a
            public w g() throws RemoteException {
                return e.b(com.ss.android.socialbase.downloader.g.d.this.eIn());
            }

            @Override // com.ss.android.socialbase.downloader.g.a
            public ak h() throws RemoteException {
                return e.b(com.ss.android.socialbase.downloader.g.d.this.eIm());
            }

            @Override // com.ss.android.socialbase.downloader.g.a
            public q i() throws RemoteException {
                return e.c(com.ss.android.socialbase.downloader.g.d.this.eIo());
            }

            @Override // com.ss.android.socialbase.downloader.g.a
            public com.ss.android.socialbase.downloader.d.h k() throws RemoteException {
                return e.c(com.ss.android.socialbase.downloader.g.d.this.eIr());
            }

            @Override // com.ss.android.socialbase.downloader.g.a
            public m l() throws RemoteException {
                return e.e(com.ss.android.socialbase.downloader.g.d.this.eIt());
            }
        };
    }

    public static j a(final com.ss.android.socialbase.downloader.d.b bVar, final boolean z) {
        if (bVar == null) {
            return null;
        }
        return new j.a() { // from class: com.ss.android.socialbase.downloader.m.e.12
            @Override // com.ss.android.socialbase.downloader.d.j
            public int a() throws RemoteException {
                return com.ss.android.socialbase.downloader.d.b.this.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.d.j
            public void a(final com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                if (z) {
                    e.f13223a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.m.e.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.socialbase.downloader.d.b.this.a(cVar);
                        }
                    });
                } else {
                    com.ss.android.socialbase.downloader.d.b.this.a(cVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.j
            public void b(final com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                if (z) {
                    e.f13223a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.m.e.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.socialbase.downloader.d.b.this.b(cVar);
                        }
                    });
                } else {
                    com.ss.android.socialbase.downloader.d.b.this.b(cVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.j
            public void c(final com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                if (z) {
                    e.f13223a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.m.e.12.9
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.socialbase.downloader.d.b.this.c(cVar);
                        }
                    });
                } else {
                    com.ss.android.socialbase.downloader.d.b.this.c(cVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.j
            public void d(final com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                if (z) {
                    e.f13223a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.m.e.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.socialbase.downloader.d.b.this.d(cVar);
                        }
                    });
                } else {
                    com.ss.android.socialbase.downloader.d.b.this.d(cVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.j
            public void e(final com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                if (z) {
                    e.f13223a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.m.e.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.socialbase.downloader.d.b.this.e(cVar);
                        }
                    });
                } else {
                    com.ss.android.socialbase.downloader.d.b.this.e(cVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.j
            public void a(final com.ss.android.socialbase.downloader.g.c cVar, final com.ss.android.socialbase.downloader.e.a aVar) throws RemoteException {
                if (z) {
                    e.f13223a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.m.e.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.socialbase.downloader.d.b.this.a(cVar, aVar);
                        }
                    });
                } else {
                    com.ss.android.socialbase.downloader.d.b.this.a(cVar, aVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.j
            public void f(final com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                if (z) {
                    e.f13223a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.m.e.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.socialbase.downloader.d.b.this.f(cVar);
                        }
                    });
                } else {
                    com.ss.android.socialbase.downloader.d.b.this.f(cVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.j
            public void g(final com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                if (z) {
                    e.f13223a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.m.e.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.socialbase.downloader.d.b.this.h(cVar);
                        }
                    });
                } else {
                    com.ss.android.socialbase.downloader.d.b.this.h(cVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.j
            public void h(final com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                if (z) {
                    e.f13223a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.m.e.12.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.socialbase.downloader.d.b.this.i(cVar);
                        }
                    });
                } else {
                    com.ss.android.socialbase.downloader.d.b.this.i(cVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.j
            public void b(final com.ss.android.socialbase.downloader.g.c cVar, final com.ss.android.socialbase.downloader.e.a aVar) throws RemoteException {
                if (z) {
                    e.f13223a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.m.e.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.socialbase.downloader.d.b.this.b(cVar, aVar);
                        }
                    });
                } else {
                    com.ss.android.socialbase.downloader.d.b.this.b(cVar, aVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.j
            public void c(final com.ss.android.socialbase.downloader.g.c cVar, final com.ss.android.socialbase.downloader.e.a aVar) throws RemoteException {
                if (z) {
                    e.f13223a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.m.e.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.socialbase.downloader.d.b.this.c(cVar, aVar);
                        }
                    });
                } else {
                    com.ss.android.socialbase.downloader.d.b.this.c(cVar, aVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.j
            public void i(final com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                if (com.ss.android.socialbase.downloader.d.b.this instanceof ag) {
                    if (z) {
                        e.f13223a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.m.e.12.7
                            @Override // java.lang.Runnable
                            public void run() {
                                ((ag) com.ss.android.socialbase.downloader.d.b.this).g(cVar);
                            }
                        });
                    } else {
                        ((ag) com.ss.android.socialbase.downloader.d.b.this).g(cVar);
                    }
                }
            }
        };
    }

    public static ac c(final com.ss.android.socialbase.downloader.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        return new ac.a() { // from class: com.ss.android.socialbase.downloader.m.e.23
            @Override // com.ss.android.socialbase.downloader.d.ac
            public void a(int i, com.ss.android.socialbase.downloader.g.c cVar, String str, String str2) throws RemoteException {
                com.ss.android.socialbase.downloader.d.d.this.a(i, cVar, str, str2);
            }

            @Override // com.ss.android.socialbase.downloader.d.ac
            public boolean a(boolean z) throws RemoteException {
                return com.ss.android.socialbase.downloader.d.d.this.a(z);
            }

            @Override // com.ss.android.socialbase.downloader.d.ac
            public String a() throws RemoteException {
                return com.ss.android.socialbase.downloader.d.d.this.a();
            }
        };
    }

    public static ai d(final r rVar) {
        if (rVar == null) {
            return null;
        }
        return new ai.a() { // from class: com.ss.android.socialbase.downloader.m.e.26
            @Override // com.ss.android.socialbase.downloader.d.ai
            public boolean a(com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                return r.this.a(cVar);
            }

            @Override // com.ss.android.socialbase.downloader.d.ai
            public boolean b(com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                return r.this.b(cVar);
            }

            @Override // com.ss.android.socialbase.downloader.d.ai
            public boolean c(com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                return r.this.c(cVar);
            }
        };
    }

    public static ak b(final s sVar) {
        if (sVar == null) {
            return null;
        }
        return new ak.a() { // from class: com.ss.android.socialbase.downloader.m.e.27
            @Override // com.ss.android.socialbase.downloader.d.ak
            public long a(int i, int i2) throws RemoteException {
                return s.this.a(i, i2);
            }
        };
    }

    public static w b(final al alVar) {
        if (alVar == null) {
            return null;
        }
        return new w.a() { // from class: com.ss.android.socialbase.downloader.m.e.28
            @Override // com.ss.android.socialbase.downloader.d.w
            public boolean a(v vVar) throws RemoteException {
                return al.this.a(e.b(vVar));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.d.h c(final ah ahVar) {
        if (ahVar == null) {
            return null;
        }
        return new h.a() { // from class: com.ss.android.socialbase.downloader.m.e.29
            @Override // com.ss.android.socialbase.downloader.d.h
            public Uri a(String str, String str2) throws RemoteException {
                return ah.this.a(str, str2);
            }
        };
    }

    public static aj b(final v vVar) {
        if (vVar == null) {
            return null;
        }
        return new aj() { // from class: com.ss.android.socialbase.downloader.m.e.24
            @Override // com.ss.android.socialbase.downloader.d.aj
            public void a(List<String> list) {
                try {
                    v.this.a(list);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.aj
            public boolean a() {
                try {
                    return v.this.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static q c(final af afVar) {
        if (afVar == null) {
            return null;
        }
        return new q.a() { // from class: com.ss.android.socialbase.downloader.m.e.31
            @Override // com.ss.android.socialbase.downloader.d.q
            public boolean a(long j, long j2, p pVar) throws RemoteException {
                return af.this.a(j, j2, e.a(pVar));
            }
        };
    }

    public static ae a(final p pVar) {
        if (pVar == null) {
            return null;
        }
        return new ae() { // from class: com.ss.android.socialbase.downloader.m.e.15
            @Override // com.ss.android.socialbase.downloader.d.ae
            public void a() {
                try {
                    p.this.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.d.g b(final ad adVar) {
        if (adVar == null) {
            return null;
        }
        return new g.a() { // from class: com.ss.android.socialbase.downloader.m.e.3
            @Override // com.ss.android.socialbase.downloader.d.g
            public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, int i) throws RemoteException {
                ad.this.a(cVar, aVar, i);
            }
        };
    }

    public static k b(final com.ss.android.socialbase.downloader.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        return new k.a() { // from class: com.ss.android.socialbase.downloader.m.e.4
            @Override // com.ss.android.socialbase.downloader.d.k
            public void a(String str) throws RemoteException {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        com.ss.android.socialbase.downloader.d.c.this.a(new JSONObject(str));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.k
            public String a() throws RemoteException {
                return com.ss.android.socialbase.downloader.d.c.this.b();
            }

            @Override // com.ss.android.socialbase.downloader.d.k
            public int[] b() throws RemoteException {
                if (com.ss.android.socialbase.downloader.d.c.this instanceof y) {
                    return ((y) com.ss.android.socialbase.downloader.d.c.this).a();
                }
                return null;
            }
        };
    }

    public static com.ss.android.socialbase.downloader.d.f d(final com.ss.android.socialbase.downloader.downloader.i iVar) {
        if (iVar == null) {
            return null;
        }
        return new f.a() { // from class: com.ss.android.socialbase.downloader.m.e.5
            @Override // com.ss.android.socialbase.downloader.d.f
            public int a(long j) throws RemoteException {
                return com.ss.android.socialbase.downloader.downloader.i.this.a(j);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.d.i b(final an anVar) {
        if (anVar == null) {
            return null;
        }
        return new i.a() { // from class: com.ss.android.socialbase.downloader.m.e.6
            @Override // com.ss.android.socialbase.downloader.d.i
            public boolean a() throws RemoteException {
                return an.this.a();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.g.d b(com.ss.android.socialbase.downloader.g.a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            com.ss.android.socialbase.downloader.g.d dVar = new com.ss.android.socialbase.downloader.g.d(aVar.a());
            dVar.c(a(aVar.b())).a(a(aVar.c())).a(a(aVar.e())).a(a(aVar.f())).a(a(aVar.j())).a(a(aVar.g())).b(a(aVar.i())).b(a(aVar.k())).c(a(aVar.d())).a(a(aVar.h())).d(a(aVar.l()));
            j b2 = aVar.b(com.ss.android.socialbase.downloader.b.h.MAIN.ordinal());
            if (b2 != null) {
                dVar.b(b2.hashCode(), a(b2));
            }
            j b3 = aVar.b(com.ss.android.socialbase.downloader.b.h.SUB.ordinal());
            if (b3 != null) {
                dVar.c(b3.hashCode(), a(b3));
            }
            j b4 = aVar.b(com.ss.android.socialbase.downloader.b.h.NOTIFICATION.ordinal());
            if (b4 != null) {
                dVar.d(b4.hashCode(), a(b4));
            }
            a(dVar, aVar, com.ss.android.socialbase.downloader.b.h.MAIN);
            a(dVar, aVar, com.ss.android.socialbase.downloader.b.h.SUB);
            a(dVar, aVar, com.ss.android.socialbase.downloader.b.h.NOTIFICATION);
            return dVar;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void a(com.ss.android.socialbase.downloader.g.d dVar, com.ss.android.socialbase.downloader.g.a aVar, com.ss.android.socialbase.downloader.b.h hVar) throws RemoteException {
        SparseArray<com.ss.android.socialbase.downloader.d.b> sparseArray = new SparseArray<>();
        for (int i = 0; i < aVar.a(hVar.ordinal()); i++) {
            j a2 = aVar.a(hVar.ordinal(), i);
            if (a2 != null) {
                sparseArray.put(a2.a(), a(a2));
            }
        }
        dVar.a(sparseArray, hVar);
    }

    public static com.ss.android.socialbase.downloader.d.d a(final ac acVar) {
        if (acVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.d.d() { // from class: com.ss.android.socialbase.downloader.m.e.25
            @Override // com.ss.android.socialbase.downloader.d.d
            public void a(int i, com.ss.android.socialbase.downloader.g.c cVar, String str, String str2) {
                try {
                    ac.this.a(i, cVar, str, str2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.d
            public boolean a(boolean z) {
                try {
                    return ac.this.a(z);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.d
            public String a() {
                try {
                    return ac.this.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static ab a(final m mVar) {
        if (mVar == null) {
            return null;
        }
        return new ab() { // from class: com.ss.android.socialbase.downloader.m.e.30
            @Override // com.ss.android.socialbase.downloader.d.ab
            public void a(com.ss.android.socialbase.downloader.g.c cVar) throws com.ss.android.socialbase.downloader.e.a {
                try {
                    m.this.a(cVar);
                } catch (RemoteException e) {
                    throw new com.ss.android.socialbase.downloader.e.a(1008, e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.ab
            public boolean b(com.ss.android.socialbase.downloader.g.c cVar) {
                try {
                    return m.this.b(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static m e(final ab abVar) {
        if (abVar == null) {
            return null;
        }
        return new m.a() { // from class: com.ss.android.socialbase.downloader.m.e.9
            @Override // com.ss.android.socialbase.downloader.d.m
            public void a(com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                try {
                    ab.this.a(cVar);
                } catch (com.ss.android.socialbase.downloader.e.a e) {
                    throw new IllegalArgumentException(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.m
            public boolean b(com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                return ab.this.b(cVar);
            }
        };
    }

    public static r a(final ai aiVar) {
        if (aiVar == null) {
            return null;
        }
        return new r() { // from class: com.ss.android.socialbase.downloader.m.e.2
            @Override // com.ss.android.socialbase.downloader.d.r
            public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
                try {
                    return ai.this.a(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.r
            public boolean b(com.ss.android.socialbase.downloader.g.c cVar) {
                try {
                    return ai.this.b(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.r
            public boolean c(com.ss.android.socialbase.downloader.g.c cVar) {
                try {
                    return ai.this.c(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.i a(final com.ss.android.socialbase.downloader.d.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.i() { // from class: com.ss.android.socialbase.downloader.m.e.7
            @Override // com.ss.android.socialbase.downloader.downloader.i
            public int a(long j) {
                try {
                    return com.ss.android.socialbase.downloader.d.f.this.a(j);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        };
    }

    public static ad a(final com.ss.android.socialbase.downloader.d.g gVar) {
        if (gVar == null) {
            return null;
        }
        return new ad() { // from class: com.ss.android.socialbase.downloader.m.e.8
            @Override // com.ss.android.socialbase.downloader.d.ad
            public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, int i) {
                if (cVar != null) {
                    try {
                        com.ss.android.socialbase.downloader.d.g.this.a(cVar, aVar, i);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.d.c a(final k kVar) {
        if (kVar == null) {
            return null;
        }
        return new y() { // from class: com.ss.android.socialbase.downloader.m.e.10
            @Override // com.ss.android.socialbase.downloader.d.c
            public void a(JSONObject jSONObject) {
                if (jSONObject != null) {
                    try {
                        k.this.a(jSONObject.toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.c
            public String b() {
                try {
                    return k.this.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return "";
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.y
            public int[] a() {
                try {
                    return k.this.b();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static al a(final w wVar) {
        if (wVar == null) {
            return null;
        }
        return new al() { // from class: com.ss.android.socialbase.downloader.m.e.11
            @Override // com.ss.android.socialbase.downloader.d.al
            public boolean a(aj ajVar) {
                try {
                    return w.this.a(e.b(ajVar));
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static v b(final aj ajVar) {
        if (ajVar == null) {
            return null;
        }
        return new v.a() { // from class: com.ss.android.socialbase.downloader.m.e.16
            @Override // com.ss.android.socialbase.downloader.d.v
            public void a(List<String> list) {
                aj.this.a(list);
            }

            @Override // com.ss.android.socialbase.downloader.d.v
            public boolean a() {
                return aj.this.a();
            }
        };
    }

    public static am b(final t tVar) {
        if (tVar == null) {
            return null;
        }
        return new am.a() { // from class: com.ss.android.socialbase.downloader.m.e.17
            @Override // com.ss.android.socialbase.downloader.d.am
            public void a(int i, int i2) {
                t.this.a(i, i2);
            }
        };
    }

    public static t b(final am amVar) {
        if (amVar == null) {
            return null;
        }
        return new t() { // from class: com.ss.android.socialbase.downloader.m.e.13
            @Override // com.ss.android.socialbase.downloader.d.t
            public void a(int i, int i2) {
                try {
                    am.this.a(i, i2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static af a(final q qVar) {
        if (qVar == null) {
            return null;
        }
        return new af() { // from class: com.ss.android.socialbase.downloader.m.e.14
            @Override // com.ss.android.socialbase.downloader.d.af
            public boolean a(long j, long j2, ae aeVar) {
                try {
                    return q.this.a(j, j2, e.a(aeVar));
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static p a(final ae aeVar) {
        if (aeVar == null) {
            return null;
        }
        return new p.a() { // from class: com.ss.android.socialbase.downloader.m.e.20
            @Override // com.ss.android.socialbase.downloader.d.p
            public void a() throws RemoteException {
                ae.this.a();
            }
        };
    }

    public static s a(final ak akVar) {
        if (akVar == null) {
            return null;
        }
        return new s() { // from class: com.ss.android.socialbase.downloader.m.e.18
            @Override // com.ss.android.socialbase.downloader.downloader.s
            public long a(int i, int i2) {
                try {
                    return ak.this.a(i, i2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 0L;
                }
            }
        };
    }

    public static an a(final com.ss.android.socialbase.downloader.d.i iVar) {
        if (iVar == null) {
            return null;
        }
        return new an() { // from class: com.ss.android.socialbase.downloader.m.e.19
            @Override // com.ss.android.socialbase.downloader.d.an
            public boolean a() {
                try {
                    return com.ss.android.socialbase.downloader.d.i.this.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static ah a(final com.ss.android.socialbase.downloader.d.h hVar) {
        if (hVar == null) {
            return null;
        }
        return new ah() { // from class: com.ss.android.socialbase.downloader.m.e.21
            @Override // com.ss.android.socialbase.downloader.d.ah
            public Uri a(String str, String str2) {
                try {
                    return com.ss.android.socialbase.downloader.d.h.this.a(str, str2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.d.b a(final j jVar) {
        if (jVar == null) {
            return null;
        }
        return new ag() { // from class: com.ss.android.socialbase.downloader.m.e.22
            @Override // com.ss.android.socialbase.downloader.d.ag
            public void g(com.ss.android.socialbase.downloader.g.c cVar) {
                try {
                    j.this.i(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.b
            public void a(com.ss.android.socialbase.downloader.g.c cVar) {
                try {
                    j.this.a(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.b
            public void b(com.ss.android.socialbase.downloader.g.c cVar) {
                try {
                    j.this.b(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.b
            public void c(com.ss.android.socialbase.downloader.g.c cVar) {
                try {
                    j.this.c(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.b
            public void d(com.ss.android.socialbase.downloader.g.c cVar) {
                try {
                    j.this.d(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.b
            public void e(com.ss.android.socialbase.downloader.g.c cVar) {
                try {
                    j.this.e(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.b
            public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar) {
                try {
                    j.this.a(cVar, aVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.b
            public void f(com.ss.android.socialbase.downloader.g.c cVar) {
                try {
                    j.this.f(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.b
            public void h(com.ss.android.socialbase.downloader.g.c cVar) {
                try {
                    j.this.g(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.b
            public void i(com.ss.android.socialbase.downloader.g.c cVar) {
                try {
                    j.this.h(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.b
            public void b(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar) {
                try {
                    j.this.b(cVar, aVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.b
            public void c(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar) {
                try {
                    j.this.c(cVar, aVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
