package d.b.i0.s2;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class g implements d.b.i0.e.b.d {

    /* renamed from: a  reason: collision with root package name */
    public List<Object> f61695a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.e.e.c f61696b;

    /* renamed from: c  reason: collision with root package name */
    public t f61697c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.c.j.e.a f61698d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.j.e.a f61699e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.j.e.a f61700f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.j.e.a f61701g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.j.e.a f61702h;

    @Override // d.b.i0.e.b.d
    public void a(int i) {
    }

    @Override // d.b.i0.e.e.a
    public void b(Map<String, String> map) {
    }

    @Override // d.b.i0.e.b.d
    public List<Integer> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.k4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.h4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.o4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.p4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.q4.getId()));
        return arrayList;
    }

    @Override // d.b.i0.e.b.d
    public void f(List<d.b.i0.e.b.c> list, int i) {
        if (d.b.i0.j1.o.k.a.e(this.f61695a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f61695a) {
            if (obj instanceof AdvertAppInfo) {
                d.b.i0.j1.o.k.a.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<d.b.i0.e.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = d.b.i0.j1.o.k.a.k(list);
        int i2 = 0;
        int i3 = 0;
        for (d.b.i0.e.b.c cVar : list) {
            if (cVar.c() == 1) {
                i3++;
            }
        }
        int k2 = d.b.i0.j1.o.k.a.k(arrayList);
        if (k2 < 1) {
            return;
        }
        int i4 = k - i3;
        HashSet hashSet = new HashSet();
        int i5 = 0;
        while (i5 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) d.b.i0.j1.o.k.a.d(arrayList, i5);
            advertAppInfo.c4 = "FRS";
            int E4 = advertAppInfo.E4();
            if (E4 != 0) {
                d.b.i0.s2.f0.d.g(advertAppInfo, i, E4);
                if (E4 != 28 && E4 != 31) {
                    advertAppInfo.U3.f12871h = -1001;
                }
                i5++;
                i2 = 0;
            }
            if (advertAppInfo.getType() == null) {
                d.b.i0.s2.f0.d.g(advertAppInfo, i, 100);
            } else {
                int d2 = (d.b.c.e.m.b.d(advertAppInfo.K3, i2) + i3) - 1;
                if (hashSet.contains(Integer.valueOf(d2))) {
                    d.b.i0.s2.f0.d.g(advertAppInfo, i, 29);
                } else if (d2 < 0) {
                    d.b.i0.s2.f0.d.g(advertAppInfo, i, 33);
                } else if (d2 >= k && i4 > 3) {
                    d.b.i0.s2.f0.d.h(advertAppInfo, i, 2, d2, k);
                } else {
                    d.b.i0.e.b.c cVar2 = new d.b.i0.e.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.B4()) {
                        if (w.q(advertAppInfo.J3) && d.b.i0.a.e().u()) {
                            d.b.i0.s2.f0.d.g(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.J3) && !TextUtils.isEmpty(advertAppInfo.F3)) {
                            hashSet.add(Integer.valueOf(d2));
                            if (d2 < k) {
                                d.b.i0.j1.o.k.a.b(list, cVar2, d2);
                            } else if (d2 == k) {
                                d.b.i0.j1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.D4()) {
                        hashSet.add(Integer.valueOf(d2));
                        if (d2 < k) {
                            d.b.i0.j1.o.k.a.b(list, cVar2, d2);
                        } else if (d2 == k) {
                            d.b.i0.j1.o.k.a.a(list, cVar2);
                        }
                    } else {
                        d.b.i0.s2.f0.d.g(advertAppInfo, i, 21);
                    }
                }
            }
            i5++;
            i2 = 0;
        }
    }

    @Override // d.b.i0.e.b.d
    public void h(List<d.b.i0.e.b.c> list, String str, String str2, String str3, String str4, boolean z, int i) {
        if (d.b.i0.j1.o.k.a.e(list)) {
            return;
        }
        Set<d.b.c.j.e.n> a2 = d.b.i0.s2.f0.a.a("FRS");
        if (a2 == null) {
            a2 = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (d.b.i0.e.b.c cVar : list) {
            if (cVar != null) {
                Object a3 = cVar.a();
                for (d.b.c.j.e.n nVar : a2) {
                    if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && a3.hashCode() == nVar.hashCode()) {
                        ((AdvertAppInfo) a3).Y3 = ((AdvertAppInfo) nVar).Y3;
                    }
                }
                if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a3;
                    if (advertAppInfo.Y3 == null) {
                        d.b.h0.r.q.d dVar = new d.b.h0.r.q.d();
                        advertAppInfo.Y3 = dVar;
                        dVar.f51156a = "FRS";
                        dVar.f51158c = String.valueOf(z);
                        d.b.h0.r.q.d dVar2 = advertAppInfo.Y3;
                        dVar2.f51157b = i;
                        dVar2.f51159d = str;
                        dVar2.f51160e = str2;
                        dVar2.f51161f = str3;
                        dVar2.f51162g = str4;
                        dVar2.f51163h = advertAppInfo.T3;
                        dVar2.i = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a2.addAll(hashSet);
        d.b.i0.s2.f0.a.b("FRS", a2);
    }

    @Override // d.b.i0.e.b.d
    public void i(List<Object> list) {
        this.f61695a = list;
    }

    @Override // d.b.i0.e.b.d
    public View k(int i, View view, ViewGroup viewGroup, Object obj) {
        d.b.c.j.e.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.k4) {
                aVar = this.f61699e;
            } else if (type == AdvertAppInfo.h4) {
                aVar = this.f61698d;
            } else if (type == AdvertAppInfo.o4) {
                aVar = this.f61700f;
            } else if (type == AdvertAppInfo.p4) {
                aVar = this.f61701g;
            } else {
                aVar = type == AdvertAppInfo.q4 ? this.f61702h : null;
            }
            if (aVar != null) {
                return aVar.I(i, view, viewGroup, advertAppInfo);
            }
            return null;
        }
        return null;
    }

    @Override // d.b.i0.e.b.d
    public void l(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        if (obj instanceof AdvertAppInfo) {
            d.b.c.j.e.a aVar = null;
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.k4) {
                aVar = this.f61699e;
            } else if (type == AdvertAppInfo.h4) {
                aVar = this.f61698d;
            } else if (type == AdvertAppInfo.o4) {
                aVar = this.f61700f;
            } else if (type == AdvertAppInfo.p4) {
                aVar = this.f61701g;
            } else if (type == AdvertAppInfo.q4) {
                aVar = this.f61702h;
            }
            if (aVar != null) {
                aVar.Y(i, viewGroup, viewHolder, obj);
            }
        }
    }

    @Override // d.b.i0.e.b.d
    public void m(List<d.b.i0.e.b.c> list, List<d.b.i0.e.b.c> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int d2;
        if (d.b.i0.j1.o.k.a.e(this.f61695a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.f61695a) {
            if (obj instanceof AdvertAppInfo) {
                d.b.i0.j1.o.k.a.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<d.b.i0.e.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = d.b.i0.j1.o.k.a.k(list);
        int i4 = 0;
        int i5 = 0;
        for (d.b.i0.e.b.c cVar : list) {
            if (cVar.c() == 1) {
                i5++;
            }
        }
        int k2 = d.b.i0.j1.o.k.a.k(arrayList2);
        if (k2 < 1) {
            return;
        }
        int i6 = 9;
        if (d.b.i0.j1.o.k.a.k(arrayList2) > 1 && (d2 = (d.b.c.e.m.b.d(((AdvertAppInfo) d.b.i0.j1.o.k.a.d(arrayList2, 1)).K3, 0) - d.b.c.e.m.b.d(((AdvertAppInfo) d.b.i0.j1.o.k.a.d(arrayList2, 0)).K3, 0)) - 1) > 0) {
            i6 = d2;
        }
        int d3 = d.b.c.e.m.b.d(((AdvertAppInfo) d.b.i0.j1.o.k.a.d(arrayList2, 0)).K3, 0) - 1;
        int i7 = k - i5;
        HashSet hashSet = new HashSet();
        int i8 = 0;
        while (i8 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) d.b.i0.j1.o.k.a.d(arrayList2, i8);
            advertAppInfo.c4 = "SMART_FRS";
            int E4 = advertAppInfo.E4();
            if (E4 != 0) {
                d.b.i0.s2.f0.d.g(advertAppInfo, i, E4);
                if (E4 != 28 && E4 != 31) {
                    advertAppInfo.U3.f12871h = -1001;
                }
                arrayList = arrayList2;
                i8++;
                arrayList2 = arrayList;
                i4 = 0;
            }
            if (advertAppInfo.getType() == null) {
                d.b.i0.s2.f0.d.g(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i8++;
                arrayList2 = arrayList;
                i4 = 0;
            } else {
                int d4 = d.b.c.e.m.b.d(advertAppInfo.K3, i4);
                int i9 = (d4 + i5) - 1;
                if (i9 < 0 || hashSet.contains(Integer.valueOf(i9)) || i9 > k) {
                    arrayList = arrayList2;
                    if (i9 > k) {
                        d.b.i0.s2.f0.d.h(advertAppInfo, i, 2, i9, k);
                        i8++;
                        arrayList2 = arrayList;
                        i4 = 0;
                    } else {
                        i2 = i9 < 0 ? 33 : 29;
                    }
                } else {
                    if (d4 <= (i7 - i6) + d3 || !z) {
                        arrayList = arrayList2;
                    } else if (!d.b.i0.j1.o.k.a.e(list2)) {
                        int k3 = d.b.i0.j1.o.k.a.k(list2);
                        int i10 = (i6 - ((i7 - d4) + 1)) - 1;
                        int i11 = 0;
                        while (i11 < k3 && i11 < i10) {
                            arrayList = arrayList2;
                            if (((d.b.i0.e.b.c) d.b.i0.j1.o.k.a.d(list2, i11)).a() instanceof AdvertAppInfo) {
                                i3 = 0;
                                break;
                            } else {
                                i11++;
                                arrayList2 = arrayList;
                            }
                        }
                        arrayList = arrayList2;
                        i3 = 1;
                        i2 = i3 ^ 1;
                    } else {
                        arrayList = arrayList2;
                        if (d.b.i0.a.e().t()) {
                            i2 = 36;
                        }
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    d.b.i0.s2.f0.d.g(advertAppInfo, i, i2);
                    i8++;
                    arrayList2 = arrayList;
                    i4 = 0;
                } else {
                    d.b.i0.e.b.c cVar2 = new d.b.i0.e.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.B4()) {
                        if (w.q(advertAppInfo.J3) && d.b.i0.a.e().u()) {
                            d.b.i0.s2.f0.d.g(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.J3) && !TextUtils.isEmpty(advertAppInfo.F3)) {
                            hashSet.add(Integer.valueOf(i9));
                            if (i9 < k) {
                                d.b.i0.j1.o.k.a.b(list, cVar2, i9);
                            } else if (i9 == k) {
                                d.b.i0.j1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.D4()) {
                        hashSet.add(Integer.valueOf(i9));
                        if (i9 < k) {
                            d.b.i0.j1.o.k.a.b(list, cVar2, i9);
                        } else if (i9 == k) {
                            d.b.i0.j1.o.k.a.a(list, cVar2);
                        }
                    }
                    i8++;
                    arrayList2 = arrayList;
                    i4 = 0;
                }
            }
        }
    }

    @Override // d.b.i0.e.b.d
    public TypeAdapter.ViewHolder o(ViewGroup viewGroup, Object obj) {
        d.b.c.j.e.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.k4) {
                aVar = this.f61699e;
            } else if (type == AdvertAppInfo.h4) {
                aVar = this.f61698d;
            } else if (type == AdvertAppInfo.o4) {
                aVar = this.f61700f;
            } else if (type == AdvertAppInfo.p4) {
                aVar = this.f61701g;
            } else {
                aVar = type == AdvertAppInfo.q4 ? this.f61702h : null;
            }
            if (aVar != null) {
                return aVar.S(viewGroup, obj);
            }
            return null;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.e.e.a
    /* renamed from: p */
    public void n(d.b.i0.e.e.c cVar) {
        this.f61696b = cVar;
        if (cVar == null || !(cVar.a() instanceof t)) {
            return;
        }
        this.f61697c = (t) this.f61696b.a();
        this.f61698d = new d.b.i0.s2.z.c(this.f61697c, AdvertAppInfo.h4);
        this.f61699e = new d.b.i0.s2.z.d(this.f61697c, AdvertAppInfo.k4);
        this.f61700f = new d.b.i0.s2.z.d(this.f61697c, AdvertAppInfo.o4);
        this.f61701g = new d.b.i0.s2.z.d(this.f61697c, AdvertAppInfo.p4);
        this.f61702h = new d.b.i0.s2.z.d(this.f61697c, AdvertAppInfo.q4);
    }
}
