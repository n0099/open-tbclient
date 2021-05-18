package d.r.b.a.a.j.d;

import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import d.r.b.a.a.f.h.f;
import d.r.b.a.a.j.d.f.e;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
/* loaded from: classes7.dex */
public final class d implements b, d.r.b.a.a.f.c.c {

    /* renamed from: a  reason: collision with root package name */
    public final String f67889a = "RevenueService";

    /* renamed from: b  reason: collision with root package name */
    public d.r.b.a.a.j.d.f.c f67890b = new d.r.b.a.a.j.d.f.c();

    /* renamed from: c  reason: collision with root package name */
    public d.r.b.a.a.j.d.g.b f67891c = new d.r.b.a.a.j.d.g.b();

    /* renamed from: d  reason: collision with root package name */
    public volatile Map<Integer, d.r.b.a.a.j.d.f.a> f67892d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public volatile Map<String, d.r.b.a.a.j.d.f.a> f67893e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    public final int f67894f;

    /* renamed from: g  reason: collision with root package name */
    public final d.r.b.a.a.f.c.d f67895g;

    /* renamed from: h  reason: collision with root package name */
    public final c f67896h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f67897i;

    /* loaded from: classes7.dex */
    public static final class a implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.r.b.a.a.j.d.f.a f67899f;

        public a(d.r.b.a.a.j.d.f.a aVar) {
            this.f67899f = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f67899f.run()) {
                if (d.this.f67897i) {
                    String str = d.this.f67889a;
                    d.r.b.a.a.f.d.d.f(str, "sendRequest requestReuse = " + d.this.f67897i + " Command:" + this.f67899f.b());
                    d.this.f67892d.put(Integer.valueOf(this.f67899f.b()), this.f67899f);
                    return;
                }
                String str2 = d.this.f67889a;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("sendRequest Seq = %s", Arrays.copyOf(new Object[]{this.f67899f.e()}, 1));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                d.r.b.a.a.f.d.d.f(str2, format);
                d.this.f67893e.put(this.f67899f.e(), this.f67899f);
                return;
            }
            String str3 = d.this.f67889a;
            d.r.b.a.a.f.d.d.f(str3, "sendRequest run failed Command:" + this.f67899f.b());
        }
    }

    public d(int i2, d.r.b.a.a.f.c.d dVar, c cVar, boolean z) {
        this.f67894f = i2;
        this.f67895g = dVar;
        this.f67896h = cVar;
        this.f67897i = z;
    }

    @Override // d.r.b.a.a.j.d.b
    public void a(int i2, String str, int i3, String str2) {
        String str3 = this.f67889a;
        d.r.b.a.a.f.d.d.f(str3, "cancel requestReuse = " + this.f67897i);
        d.r.b.a.a.j.d.g.c cVar = new d.r.b.a.a.j.d.g.c(i2, str, i3, str2);
        if (this.f67897i) {
            String str4 = this.f67889a;
            d.r.b.a.a.f.d.d.f(str4, "cancel requestReuse = " + this.f67897i + "Command:" + i2);
            cVar.f(this.f67892d.remove(Integer.valueOf(i2)));
        } else {
            String str5 = this.f67889a;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("cancel seq = %s", Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            d.r.b.a.a.f.d.d.e(str5, format, new Object[0]);
            Map<String, d.r.b.a.a.j.d.f.a> map = this.f67893e;
            if (map == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            }
            cVar.f((d.r.b.a.a.j.d.f.a) TypeIntrinsics.asMutableMap(map).remove(str));
        }
        c cVar2 = this.f67896h;
        if (cVar2 != null) {
            cVar2.d(i2, cVar);
        }
    }

    @Override // d.r.b.a.a.j.d.b
    public void b(String str, byte[] bArr) {
        String str2 = this.f67889a;
        d.r.b.a.a.f.d.d.f(str2, "sendData requestReuse = " + this.f67897i);
        d.r.b.a.a.f.c.d dVar = this.f67895g;
        if (dVar != null) {
            dVar.sendData(this.f67894f, str, null, bArr);
        }
    }

    @Override // d.r.b.a.a.f.c.c
    public void g(int i2, String str, int i3, int i4, String str2) {
        String str3 = this.f67889a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("onRequestError appId = %d, errCode = %d, seq = %s, message = %s", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), str, str2}, 4));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        d.r.b.a.a.f.d.d.e(str3, format, new Object[0]);
        if (this.f67897i) {
            String str4 = this.f67889a;
            d.r.b.a.a.f.d.d.f(str4, "onRequestError requestReuse = " + this.f67897i + "Command:" + i3);
            d.r.b.a.a.j.d.f.a aVar = this.f67892d.get(Integer.valueOf(i3));
            if (aVar != null) {
                if (aVar instanceof e) {
                    ((e) aVar).m(i4, str2);
                    return;
                } else {
                    a(aVar.b(), str, i4, str2);
                    return;
                }
            }
            return;
        }
        d.r.b.a.a.j.d.f.a aVar2 = this.f67893e.get(str);
        if (aVar2 != null) {
            if (aVar2 instanceof e) {
                ((e) aVar2).m(i4, str2);
            } else {
                a(aVar2.b(), str, i4, str2);
            }
        }
    }

    @Override // d.r.b.a.a.f.c.c
    public void h(int i2, d.r.b.a.a.f.e.b bVar) {
    }

    public <T extends RequestParams> d.r.b.a.a.j.d.f.a i(int i2, T t) {
        String str = this.f67889a;
        d.r.b.a.a.f.d.d.f(str, "obtainRequest command = " + i2 + " requestReuse = " + this.f67897i + " retryCount = " + t.getRetryCount());
        if (this.f67897i) {
            d.r.b.a.a.j.d.f.a aVar = this.f67892d.get(Integer.valueOf(i2));
            if (aVar != null) {
                return aVar;
            }
            if (t.getRetryCount() > 0) {
                return e.q.a(i2, this.f67894f, t, this.f67890b, this, t.getRetryCount(), t.getIntervalMs(), t.getTimeOutMs(), t.getRetryType());
            }
            return d.r.b.a.a.j.d.f.d.f68079i.a(i2, this.f67894f, t, this.f67890b, this);
        } else if (t.getRetryCount() > 0) {
            return e.q.a(i2, this.f67894f, t, this.f67890b, this, t.getRetryCount(), t.getIntervalMs(), t.getTimeOutMs(), t.getRetryType());
        } else {
            return d.r.b.a.a.j.d.f.d.f68079i.a(i2, this.f67894f, t, this.f67890b, this);
        }
    }

    @Override // d.r.b.a.a.f.c.c
    public void j(int i2, d.r.b.a.a.f.e.e eVar) {
        c cVar;
        c cVar2;
        c cVar3;
        if (eVar != null && eVar.n() == 4042389859L) {
            d.r.b.a.a.j.d.g.b bVar = this.f67891c;
            String m = eVar.m();
            Intrinsics.checkExpressionValueIsNotNull(m, "unicastData.jsonData");
            d.r.b.a.a.j.d.g.c a2 = bVar.a(40423898, m);
            if (a2 == null || (cVar3 = this.f67896h) == null) {
                return;
            }
            cVar3.d(40423898, a2);
        } else if (eVar != null && eVar.n() == 4042323555L) {
            d.r.b.a.a.j.d.g.b bVar2 = this.f67891c;
            String m2 = eVar.m();
            Intrinsics.checkExpressionValueIsNotNull(m2, "unicastData.jsonData");
            d.r.b.a.a.j.d.g.c a3 = bVar2.a(40423235, m2);
            if (a3 == null || (cVar2 = this.f67896h) == null) {
                return;
            }
            cVar2.d(40423235, a3);
        } else if (eVar != null && eVar.n() == 4042453603L) {
            d.r.b.a.a.j.d.g.b bVar3 = this.f67891c;
            String m3 = eVar.m();
            Intrinsics.checkExpressionValueIsNotNull(m3, "unicastData.jsonData");
            d.r.b.a.a.j.d.g.c a4 = bVar3.a(40424536, m3);
            if (a4 == null || (cVar = this.f67896h) == null) {
                return;
            }
            cVar.d(40424536, a4);
        } else {
            d.r.b.a.a.f.d.d.e(this.f67889a, "onUnicastData not match any uri!", new Object[0]);
        }
    }

    @Override // d.r.b.a.a.f.c.c
    public void k(int i2, d.r.b.a.a.f.e.d dVar) {
        String str = this.f67889a;
        d.r.b.a.a.f.d.d.f(str, "onResponseData requestReuse = " + this.f67897i);
        if (dVar != null) {
            d.r.b.a.a.j.d.g.b bVar = this.f67891c;
            int i3 = dVar.f67694e;
            String l = dVar.l();
            Intrinsics.checkExpressionValueIsNotNull(l, "responseData.targetJson()");
            d.r.b.a.a.j.d.g.c a2 = bVar.a(i3, l);
            if (a2 != null) {
                int c2 = a2.c();
                if (this.f67897i) {
                    a2.f(this.f67892d.get(Integer.valueOf(c2)));
                    this.f67892d.remove(Integer.valueOf(c2));
                    String str2 = this.f67889a;
                    d.r.b.a.a.f.d.d.f(str2, "onResponseData requestReuse = " + this.f67897i + "Command:" + c2);
                } else {
                    String str3 = this.f67889a;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    boolean z = true;
                    String format = String.format("onResponseData seq = %s", Arrays.copyOf(new Object[]{a2.d()}, 1));
                    Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                    d.r.b.a.a.f.d.d.f(str3, format);
                    String d2 = a2.d();
                    if (d2 != null && d2.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        a2.f(this.f67893e.get(a2.d()));
                        Map<String, d.r.b.a.a.j.d.f.a> map = this.f67893e;
                        String d3 = a2.d();
                        if (map == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                        }
                        TypeIntrinsics.asMutableMap(map).remove(d3);
                    }
                }
                c cVar = this.f67896h;
                if (cVar != null) {
                    cVar.d(c2, a2);
                }
            }
        }
    }

    public void l(d.r.b.a.a.j.d.f.a aVar) {
        String str = this.f67889a;
        d.r.b.a.a.f.d.d.f(str, "sendRequest requestReuse = " + this.f67897i);
        f.a().c().execute(new a(aVar));
    }
}
