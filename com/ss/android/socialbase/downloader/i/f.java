package com.ss.android.socialbase.downloader.i;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.a;
import d.o.a.e.b.f.q;
import d.o.a.e.b.f.r;
import d.o.a.e.b.f.s;
import d.o.a.e.b.f.t;
import d.o.a.e.b.f.u;
import d.o.a.e.b.f.w;
import d.o.a.e.b.f.x;
import d.o.a.e.b.f.y;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f39786a = new Handler(Looper.getMainLooper());

    /* loaded from: classes7.dex */
    public static class a implements d.o.a.e.b.f.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ag f39831a;

        public a(ag agVar) {
            this.f39831a = agVar;
        }

        @Override // d.o.a.e.b.f.i
        public boolean a(DownloadInfo downloadInfo) {
            try {
                return this.f39831a.a(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        @Override // d.o.a.e.b.f.i
        public boolean b(DownloadInfo downloadInfo) {
            try {
                return this.f39831a.b(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        @Override // d.o.a.e.b.f.i
        public boolean c(DownloadInfo downloadInfo) {
            try {
                return this.f39831a.c(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements d.o.a.e.b.g.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.e f39832a;

        public b(com.ss.android.socialbase.downloader.depend.e eVar) {
            this.f39832a = eVar;
        }

        @Override // d.o.a.e.b.g.i
        public int a(long j) {
            try {
                return this.f39832a.a(j);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.f f39833a;

        public c(com.ss.android.socialbase.downloader.depend.f fVar) {
            this.f39833a = fVar;
        }

        @Override // d.o.a.e.b.f.q
        public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
            if (downloadInfo == null) {
                return;
            }
            try {
                this.f39833a.a(downloadInfo, baseException, i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements w {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f39835a;

        public e(v vVar) {
            this.f39835a = vVar;
        }

        @Override // d.o.a.e.b.f.w
        public boolean a(d.o.a.e.b.f.v vVar) {
            try {
                return this.f39835a.a(f.x(vVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.i.f$f  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0503f implements d.o.a.e.b.f.k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ak f39836a;

        public C0503f(ak akVar) {
            this.f39836a = akVar;
        }

        @Override // d.o.a.e.b.f.k
        public void a(int i2, int i3) {
            try {
                this.f39836a.a(i2, i3);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements s {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f39837a;

        public g(p pVar) {
            this.f39837a = pVar;
        }

        @Override // d.o.a.e.b.f.s
        public boolean a(long j, long j2, r rVar) {
            try {
                return this.f39837a.a(j, j2, f.s(rVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements d.o.a.e.b.g.r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ai f39838a;

        public h(ai aiVar) {
            this.f39838a = aiVar;
        }

        @Override // d.o.a.e.b.g.r
        public long a(int i2, int i3) {
            try {
                return this.f39838a.a(i2, i3);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements x {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.h f39839a;

        public i(com.ss.android.socialbase.downloader.depend.h hVar) {
            this.f39839a = hVar;
        }

        @Override // d.o.a.e.b.f.x
        public boolean a() {
            try {
                return this.f39839a.a();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class j implements u {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.g f39840a;

        public j(com.ss.android.socialbase.downloader.depend.g gVar) {
            this.f39840a = gVar;
        }

        @Override // d.o.a.e.b.f.u
        public Uri a(String str, String str2) {
            try {
                return this.f39840a.a(str, str2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class k implements t {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.i f39841a;

        public k(com.ss.android.socialbase.downloader.depend.i iVar) {
            this.f39841a = iVar;
        }

        @Override // d.o.a.e.b.f.t
        public void a(DownloadInfo downloadInfo) {
            try {
                this.f39841a.i(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.b
        public void b(DownloadInfo downloadInfo) {
            try {
                this.f39841a.d(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.b
        public void c(DownloadInfo downloadInfo) {
            try {
                this.f39841a.b(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.b
        public void d(DownloadInfo downloadInfo) {
            try {
                this.f39841a.g(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.b
        public void e(DownloadInfo downloadInfo) {
            try {
                this.f39841a.f(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.b
        public void f(DownloadInfo downloadInfo) {
            try {
                this.f39841a.e(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.b
        public void g(DownloadInfo downloadInfo) {
            try {
                this.f39841a.c(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.b
        public void h(DownloadInfo downloadInfo, BaseException baseException) {
            try {
                this.f39841a.a(downloadInfo, baseException);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.b
        public void i(DownloadInfo downloadInfo, BaseException baseException) {
            try {
                this.f39841a.b(downloadInfo, baseException);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.b
        public void j(DownloadInfo downloadInfo, BaseException baseException) {
            try {
                this.f39841a.c(downloadInfo, baseException);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.b
        public void k(DownloadInfo downloadInfo) {
            try {
                this.f39841a.h(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.b
        public void l(DownloadInfo downloadInfo) {
            try {
                this.f39841a.a(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class l implements r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.o f39842a;

        public l(com.ss.android.socialbase.downloader.depend.o oVar) {
            this.f39842a = oVar;
        }

        @Override // d.o.a.e.b.f.r
        public void a() {
            try {
                this.f39842a.a();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class o implements d.o.a.e.b.f.p {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.l f39845a;

        public o(com.ss.android.socialbase.downloader.depend.l lVar) {
            this.f39845a = lVar;
        }

        @Override // d.o.a.e.b.f.p
        public void a(DownloadInfo downloadInfo) throws BaseException {
            try {
                this.f39845a.a(downloadInfo);
            } catch (RemoteException e2) {
                throw new BaseException(1008, e2);
            }
        }

        @Override // d.o.a.e.b.f.p
        public boolean b(DownloadInfo downloadInfo) {
            try {
                return this.f39845a.b(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    public static w A(v vVar) {
        if (vVar == null) {
            return null;
        }
        return new e(vVar);
    }

    public static x B(com.ss.android.socialbase.downloader.depend.h hVar) {
        if (hVar == null) {
            return null;
        }
        return new i(hVar);
    }

    public static y C(com.ss.android.socialbase.downloader.depend.j jVar) {
        if (jVar == null) {
            return null;
        }
        return new d(jVar);
    }

    public static d.o.a.e.b.g.i D(com.ss.android.socialbase.downloader.depend.e eVar) {
        if (eVar == null) {
            return null;
        }
        return new b(eVar);
    }

    public static d.o.a.e.b.g.r E(ai aiVar) {
        if (aiVar == null) {
            return null;
        }
        return new h(aiVar);
    }

    public static d.o.a.e.b.n.a F(com.ss.android.socialbase.downloader.model.a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            d.o.a.e.b.n.a aVar2 = new d.o.a.e.b.n.a(aVar.a());
            aVar2.k(D(aVar.b()));
            aVar2.p0(d(aVar.c()));
            aVar2.V(B(aVar.e()));
            aVar2.n(r(aVar.f()));
            aVar2.d0(C(aVar.j()));
            aVar2.y(A(aVar.g()));
            aVar2.o(v(aVar.i()));
            aVar2.x(w(aVar.k()));
            aVar2.o0(f(aVar.d()));
            aVar2.y0(E(aVar.h()));
            com.ss.android.socialbase.downloader.depend.i b2 = aVar.b(com.ss.android.socialbase.downloader.constants.g.MAIN.ordinal());
            if (b2 != null) {
                aVar2.Y(b2.hashCode(), b(b2));
            }
            com.ss.android.socialbase.downloader.depend.i b3 = aVar.b(com.ss.android.socialbase.downloader.constants.g.SUB.ordinal());
            if (b3 != null) {
                aVar2.H0(b3.hashCode(), b(b3));
            }
            com.ss.android.socialbase.downloader.depend.i b4 = aVar.b(com.ss.android.socialbase.downloader.constants.g.NOTIFICATION.ordinal());
            if (b4 != null) {
                aVar2.r0(b4.hashCode(), b(b4));
            }
            I(aVar2, aVar, com.ss.android.socialbase.downloader.constants.g.MAIN);
            I(aVar2, aVar, com.ss.android.socialbase.downloader.constants.g.SUB);
            I(aVar2, aVar, com.ss.android.socialbase.downloader.constants.g.NOTIFICATION);
            H(aVar2, aVar);
            return aVar2;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static com.ss.android.socialbase.downloader.model.a G(final d.o.a.e.b.n.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a.AbstractBinderC0504a() { // from class: com.ss.android.socialbase.downloader.i.f.1
            @Override // com.ss.android.socialbase.downloader.model.a
            public DownloadInfo a() throws RemoteException {
                return d.o.a.e.b.n.a.this.H();
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.e b() throws RemoteException {
                return f.j(d.o.a.e.b.n.a.this.B());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public aa c() throws RemoteException {
                return f.c(d.o.a.e.b.n.a.this.Q());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ag d() throws RemoteException {
                return f.e(d.o.a.e.b.n.a.this.P());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.h e() throws RemoteException {
                return f.m(d.o.a.e.b.n.a.this.N());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.f f() throws RemoteException {
                return f.k(d.o.a.e.b.n.a.this.C());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public v g() throws RemoteException {
                return f.y(d.o.a.e.b.n.a.this.M());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ai h() throws RemoteException {
                return f.g(d.o.a.e.b.n.a.this.R());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public p i() throws RemoteException {
                return f.t(d.o.a.e.b.n.a.this.D());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.j j() throws RemoteException {
                return f.o(d.o.a.e.b.n.a.this.O());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.g k() throws RemoteException {
                return f.l(d.o.a.e.b.n.a.this.L());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int l() throws RemoteException {
                return d.o.a.e.b.n.a.this.F().size();
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int a(int i2) throws RemoteException {
                return d.o.a.e.b.n.a.this.J(d.o.a.e.b.l.e.D0(i2));
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.i b(int i2) throws RemoteException {
                return f.n(d.o.a.e.b.n.a.this.S(d.o.a.e.b.l.e.D0(i2)), i2 != com.ss.android.socialbase.downloader.constants.g.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.l c(int i2) throws RemoteException {
                return f.p(d.o.a.e.b.n.a.this.E(i2));
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.i a(int i2, int i3) throws RemoteException {
                return f.n(d.o.a.e.b.n.a.this.I(d.o.a.e.b.l.e.D0(i2), i3), i2 != com.ss.android.socialbase.downloader.constants.g.SUB.ordinal());
            }
        };
    }

    public static void H(d.o.a.e.b.n.a aVar, com.ss.android.socialbase.downloader.model.a aVar2) throws RemoteException {
        for (int i2 = 0; i2 < aVar2.l(); i2++) {
            com.ss.android.socialbase.downloader.depend.l c2 = aVar2.c(i2);
            if (c2 != null) {
                aVar.b(q(c2));
            }
        }
    }

    public static void I(d.o.a.e.b.n.a aVar, com.ss.android.socialbase.downloader.model.a aVar2, com.ss.android.socialbase.downloader.constants.g gVar) throws RemoteException {
        SparseArray<d.o.a.e.b.f.b> sparseArray = new SparseArray<>();
        for (int i2 = 0; i2 < aVar2.a(gVar.ordinal()); i2++) {
            com.ss.android.socialbase.downloader.depend.i a2 = aVar2.a(gVar.ordinal(), i2);
            if (a2 != null) {
                sparseArray.put(a2.a(), b(a2));
            }
        }
        aVar.C0(sparseArray, gVar);
    }

    public static d.o.a.e.b.f.b b(com.ss.android.socialbase.downloader.depend.i iVar) {
        if (iVar == null) {
            return null;
        }
        return new k(iVar);
    }

    public static aa c(final d.o.a.e.b.f.d dVar) {
        if (dVar == null) {
            return null;
        }
        return new aa.a() { // from class: com.ss.android.socialbase.downloader.i.f.23
            @Override // com.ss.android.socialbase.downloader.depend.aa
            public void a(int i2, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                d.o.a.e.b.f.d.this.a(i2, downloadInfo, str, str2);
            }

            @Override // com.ss.android.socialbase.downloader.depend.aa
            public boolean a(boolean z) throws RemoteException {
                return d.o.a.e.b.f.d.this.a(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.aa
            public String a() throws RemoteException {
                return d.o.a.e.b.f.d.this.a();
            }
        };
    }

    public static d.o.a.e.b.f.d d(aa aaVar) {
        if (aaVar == null) {
            return null;
        }
        return new n(aaVar);
    }

    public static ag e(final d.o.a.e.b.f.i iVar) {
        if (iVar == null) {
            return null;
        }
        return new ag.a() { // from class: com.ss.android.socialbase.downloader.i.f.26
            @Override // com.ss.android.socialbase.downloader.depend.ag
            public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                return d.o.a.e.b.f.i.this.a(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.ag
            public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                return d.o.a.e.b.f.i.this.b(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.ag
            public boolean c(DownloadInfo downloadInfo) throws RemoteException {
                return d.o.a.e.b.f.i.this.c(downloadInfo);
            }
        };
    }

    public static d.o.a.e.b.f.i f(ag agVar) {
        if (agVar == null) {
            return null;
        }
        return new a(agVar);
    }

    public static ai g(final d.o.a.e.b.g.r rVar) {
        if (rVar == null) {
            return null;
        }
        return new ai.a() { // from class: com.ss.android.socialbase.downloader.i.f.27
            @Override // com.ss.android.socialbase.downloader.depend.ai
            public long a(int i2, int i3) throws RemoteException {
                return d.o.a.e.b.g.r.this.a(i2, i3);
            }
        };
    }

    public static ak h(final d.o.a.e.b.f.k kVar) {
        if (kVar == null) {
            return null;
        }
        return new ak.a() { // from class: com.ss.android.socialbase.downloader.i.f.17
            @Override // com.ss.android.socialbase.downloader.depend.ak
            public void a(int i2, int i3) {
                d.o.a.e.b.f.k.this.a(i2, i3);
            }
        };
    }

    public static d.o.a.e.b.f.k i(ak akVar) {
        if (akVar == null) {
            return null;
        }
        return new C0503f(akVar);
    }

    public static com.ss.android.socialbase.downloader.depend.e j(final d.o.a.e.b.g.i iVar) {
        if (iVar == null) {
            return null;
        }
        return new e.a() { // from class: com.ss.android.socialbase.downloader.i.f.5
            @Override // com.ss.android.socialbase.downloader.depend.e
            public int a(long j2) throws RemoteException {
                return d.o.a.e.b.g.i.this.a(j2);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.f k(final q qVar) {
        if (qVar == null) {
            return null;
        }
        return new f.a() { // from class: com.ss.android.socialbase.downloader.i.f.3
            @Override // com.ss.android.socialbase.downloader.depend.f
            public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) throws RemoteException {
                q.this.a(downloadInfo, baseException, i2);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.g l(final u uVar) {
        if (uVar == null) {
            return null;
        }
        return new g.a() { // from class: com.ss.android.socialbase.downloader.i.f.29
            @Override // com.ss.android.socialbase.downloader.depend.g
            public Uri a(String str, String str2) throws RemoteException {
                return u.this.a(str, str2);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.h m(final x xVar) {
        if (xVar == null) {
            return null;
        }
        return new h.a() { // from class: com.ss.android.socialbase.downloader.i.f.6
            @Override // com.ss.android.socialbase.downloader.depend.h
            public boolean a() throws RemoteException {
                return x.this.a();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.i n(final d.o.a.e.b.f.b bVar, final boolean z) {
        if (bVar == null) {
            return null;
        }
        return new i.a() { // from class: com.ss.android.socialbase.downloader.i.f.12

            /* renamed from: com.ss.android.socialbase.downloader.i.f$12$a */
            /* loaded from: classes7.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f39790e;

                public a(DownloadInfo downloadInfo) {
                    this.f39790e = downloadInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.o.a.e.b.f.b.this.e(this.f39790e);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.i.f$12$b */
            /* loaded from: classes7.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f39792e;

                public b(DownloadInfo downloadInfo) {
                    this.f39792e = downloadInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.o.a.e.b.f.b.this.d(this.f39792e);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.i.f$12$c */
            /* loaded from: classes7.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f39794e;

                public c(DownloadInfo downloadInfo) {
                    this.f39794e = downloadInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.o.a.e.b.f.b.this.k(this.f39794e);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.i.f$12$d */
            /* loaded from: classes7.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f39796e;

                public d(DownloadInfo downloadInfo) {
                    this.f39796e = downloadInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.o.a.e.b.f.b.this.l(this.f39796e);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.i.f$12$e */
            /* loaded from: classes7.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f39798e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ BaseException f39799f;

                public e(DownloadInfo downloadInfo, BaseException baseException) {
                    this.f39798e = downloadInfo;
                    this.f39799f = baseException;
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.o.a.e.b.f.b.this.i(this.f39798e, this.f39799f);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.i.f$12$f  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0502f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f39801e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ BaseException f39802f;

                public RunnableC0502f(DownloadInfo downloadInfo, BaseException baseException) {
                    this.f39801e = downloadInfo;
                    this.f39802f = baseException;
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.o.a.e.b.f.b.this.j(this.f39801e, this.f39802f);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.i.f$12$g */
            /* loaded from: classes7.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f39804e;

                public g(DownloadInfo downloadInfo) {
                    this.f39804e = downloadInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ((t) d.o.a.e.b.f.b.this).a(this.f39804e);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.i.f$12$h */
            /* loaded from: classes7.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f39806e;

                public h(DownloadInfo downloadInfo) {
                    this.f39806e = downloadInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.o.a.e.b.f.b.this.c(this.f39806e);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.i.f$12$i */
            /* loaded from: classes7.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f39808e;

                public i(DownloadInfo downloadInfo) {
                    this.f39808e = downloadInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.o.a.e.b.f.b.this.g(this.f39808e);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.i.f$12$j */
            /* loaded from: classes7.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f39810e;

                public j(DownloadInfo downloadInfo) {
                    this.f39810e = downloadInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.o.a.e.b.f.b.this.b(this.f39810e);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.i.f$12$k */
            /* loaded from: classes7.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f39812e;

                public k(DownloadInfo downloadInfo) {
                    this.f39812e = downloadInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.o.a.e.b.f.b.this.f(this.f39812e);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.i.f$12$l */
            /* loaded from: classes7.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f39814e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ BaseException f39815f;

                public l(DownloadInfo downloadInfo, BaseException baseException) {
                    this.f39814e = downloadInfo;
                    this.f39815f = baseException;
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.o.a.e.b.f.b.this.h(this.f39814e, this.f39815f);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public int a() throws RemoteException {
                return d.o.a.e.b.f.b.this.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void b(DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.f39786a.post(new h(downloadInfo));
                } else {
                    d.o.a.e.b.f.b.this.c(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void c(DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.f39786a.post(new i(downloadInfo));
                } else {
                    d.o.a.e.b.f.b.this.g(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void d(DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.f39786a.post(new j(downloadInfo));
                } else {
                    d.o.a.e.b.f.b.this.b(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void e(DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.f39786a.post(new k(downloadInfo));
                } else {
                    d.o.a.e.b.f.b.this.f(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void f(DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.f39786a.post(new a(downloadInfo));
                } else {
                    d.o.a.e.b.f.b.this.e(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void g(DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.f39786a.post(new b(downloadInfo));
                } else {
                    d.o.a.e.b.f.b.this.d(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void h(DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.f39786a.post(new c(downloadInfo));
                } else {
                    d.o.a.e.b.f.b.this.k(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void i(DownloadInfo downloadInfo) throws RemoteException {
                d.o.a.e.b.f.b bVar2 = d.o.a.e.b.f.b.this;
                if (bVar2 instanceof t) {
                    if (z) {
                        f.f39786a.post(new g(downloadInfo));
                    } else {
                        ((t) bVar2).a(downloadInfo);
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void a(DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.f39786a.post(new d(downloadInfo));
                } else {
                    d.o.a.e.b.f.b.this.l(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void b(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                if (z) {
                    f.f39786a.post(new e(downloadInfo, baseException));
                } else {
                    d.o.a.e.b.f.b.this.i(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void c(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                if (z) {
                    f.f39786a.post(new RunnableC0502f(downloadInfo, baseException));
                } else {
                    d.o.a.e.b.f.b.this.j(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void a(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                if (z) {
                    f.f39786a.post(new l(downloadInfo, baseException));
                } else {
                    d.o.a.e.b.f.b.this.h(downloadInfo, baseException);
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.j o(final y yVar) {
        if (yVar == null) {
            return null;
        }
        return new j.a() { // from class: com.ss.android.socialbase.downloader.i.f.4
            @Override // com.ss.android.socialbase.downloader.depend.j
            public void a(String str) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    y.this.a(new JSONObject(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public int[] b() throws RemoteException {
                y yVar2 = y.this;
                if (yVar2 instanceof d.o.a.e.b.f.m) {
                    return ((d.o.a.e.b.f.m) yVar2).a();
                }
                return null;
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public String a() throws RemoteException {
                return y.this.b();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.l p(final d.o.a.e.b.f.p pVar) {
        if (pVar == null) {
            return null;
        }
        return new l.a() { // from class: com.ss.android.socialbase.downloader.i.f.9
            @Override // com.ss.android.socialbase.downloader.depend.l
            public void a(DownloadInfo downloadInfo) throws RemoteException {
                try {
                    d.o.a.e.b.f.p.this.a(downloadInfo);
                } catch (BaseException e2) {
                    throw new IllegalArgumentException(e2);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.l
            public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                return d.o.a.e.b.f.p.this.b(downloadInfo);
            }
        };
    }

    public static d.o.a.e.b.f.p q(com.ss.android.socialbase.downloader.depend.l lVar) {
        if (lVar == null) {
            return null;
        }
        return new o(lVar);
    }

    public static q r(com.ss.android.socialbase.downloader.depend.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new c(fVar);
    }

    public static com.ss.android.socialbase.downloader.depend.o s(final r rVar) {
        if (rVar == null) {
            return null;
        }
        return new o.a() { // from class: com.ss.android.socialbase.downloader.i.f.20
            @Override // com.ss.android.socialbase.downloader.depend.o
            public void a() throws RemoteException {
                r.this.a();
            }
        };
    }

    public static p t(final s sVar) {
        if (sVar == null) {
            return null;
        }
        return new p.a() { // from class: com.ss.android.socialbase.downloader.i.f.31
            @Override // com.ss.android.socialbase.downloader.depend.p
            public boolean a(long j2, long j3, com.ss.android.socialbase.downloader.depend.o oVar) throws RemoteException {
                return s.this.a(j2, j3, f.u(oVar));
            }
        };
    }

    public static r u(com.ss.android.socialbase.downloader.depend.o oVar) {
        if (oVar == null) {
            return null;
        }
        return new l(oVar);
    }

    public static s v(p pVar) {
        if (pVar == null) {
            return null;
        }
        return new g(pVar);
    }

    public static u w(com.ss.android.socialbase.downloader.depend.g gVar) {
        if (gVar == null) {
            return null;
        }
        return new j(gVar);
    }

    public static com.ss.android.socialbase.downloader.depend.u x(final d.o.a.e.b.f.v vVar) {
        if (vVar == null) {
            return null;
        }
        return new u.a() { // from class: com.ss.android.socialbase.downloader.i.f.16
            @Override // com.ss.android.socialbase.downloader.depend.u
            public void a(List<String> list) {
                d.o.a.e.b.f.v.this.a(list);
            }

            @Override // com.ss.android.socialbase.downloader.depend.u
            public boolean a() {
                return d.o.a.e.b.f.v.this.a();
            }
        };
    }

    public static v y(final w wVar) {
        if (wVar == null) {
            return null;
        }
        return new v.a() { // from class: com.ss.android.socialbase.downloader.i.f.28
            @Override // com.ss.android.socialbase.downloader.depend.v
            public boolean a(com.ss.android.socialbase.downloader.depend.u uVar) throws RemoteException {
                return w.this.a(f.z(uVar));
            }
        };
    }

    public static d.o.a.e.b.f.v z(com.ss.android.socialbase.downloader.depend.u uVar) {
        if (uVar == null) {
            return null;
        }
        return new m(uVar);
    }

    /* loaded from: classes7.dex */
    public static class d extends d.o.a.e.b.f.m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.j f39834a;

        public d(com.ss.android.socialbase.downloader.depend.j jVar) {
            this.f39834a = jVar;
        }

        @Override // d.o.a.e.b.f.y
        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                this.f39834a.a(jSONObject.toString());
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.y
        public String b() {
            try {
                return this.f39834a.a();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return "";
            }
        }

        @Override // d.o.a.e.b.f.m
        public int[] a() {
            try {
                return this.f39834a.b();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class m implements d.o.a.e.b.f.v {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.u f39843a;

        public m(com.ss.android.socialbase.downloader.depend.u uVar) {
            this.f39843a = uVar;
        }

        @Override // d.o.a.e.b.f.v
        public void a(List<String> list) {
            try {
                this.f39843a.a(list);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.v
        public boolean a() {
            try {
                return this.f39843a.a();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class n implements d.o.a.e.b.f.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ aa f39844a;

        public n(aa aaVar) {
            this.f39844a = aaVar;
        }

        @Override // d.o.a.e.b.f.d
        public void a(int i2, DownloadInfo downloadInfo, String str, String str2) {
            try {
                this.f39844a.a(i2, downloadInfo, str, str2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.d
        public boolean a(boolean z) {
            try {
                return this.f39844a.a(z);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        @Override // d.o.a.e.b.f.d
        public String a() {
            try {
                return this.f39844a.a();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }
}
