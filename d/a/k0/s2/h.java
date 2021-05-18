package d.a.k0.s2;

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
/* loaded from: classes5.dex */
public class h implements d.a.k0.e.b.d {

    /* renamed from: a  reason: collision with root package name */
    public List<Object> f61020a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.e.e.c f61021b;

    /* renamed from: c  reason: collision with root package name */
    public u f61022c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.j.e.a f61023d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.j.e.a f61024e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.j.e.a f61025f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.j.e.a f61026g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.j.e.a f61027h;

    @Override // d.a.k0.e.b.d
    public void a(int i2) {
    }

    @Override // d.a.k0.e.e.a
    public void b(Map<String, String> map) {
    }

    @Override // d.a.k0.e.b.d
    public List<Integer> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.c4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.Z3.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.d4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.e4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.f4.getId()));
        return arrayList;
    }

    @Override // d.a.k0.e.b.d
    public void e(List<d.a.k0.e.b.c> list, String str, String str2, String str3, String str4, boolean z, int i2) {
        if (d.a.k0.j1.o.k.a.e(list)) {
            return;
        }
        Set<d.a.c.j.e.n> a2 = d.a.k0.s2.i0.a.a("FRS");
        if (a2 == null) {
            a2 = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (d.a.k0.e.b.c cVar : list) {
            if (cVar != null) {
                Object a3 = cVar.a();
                for (d.a.c.j.e.n nVar : a2) {
                    if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && a3.hashCode() == nVar.hashCode()) {
                        ((AdvertAppInfo) a3).O3 = ((AdvertAppInfo) nVar).O3;
                    }
                }
                if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a3;
                    if (advertAppInfo.O3 == null) {
                        d.a.j0.r.q.d dVar = new d.a.j0.r.q.d();
                        advertAppInfo.O3 = dVar;
                        dVar.f49935a = "FRS";
                        dVar.f49937c = String.valueOf(z);
                        d.a.j0.r.q.d dVar2 = advertAppInfo.O3;
                        dVar2.f49936b = i2;
                        dVar2.f49938d = str;
                        dVar2.f49939e = str2;
                        dVar2.f49940f = str3;
                        dVar2.f49941g = str4;
                        dVar2.f49942h = advertAppInfo.M3;
                        dVar2.f49943i = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a2.addAll(hashSet);
        d.a.k0.s2.i0.a.b("FRS", a2);
    }

    @Override // d.a.k0.e.b.d
    public TypeAdapter.ViewHolder f(ViewGroup viewGroup, Object obj) {
        d.a.c.j.e.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.c4) {
                aVar = this.f61024e;
            } else if (type == AdvertAppInfo.Z3) {
                aVar = this.f61023d;
            } else if (type == AdvertAppInfo.d4) {
                aVar = this.f61025f;
            } else if (type == AdvertAppInfo.e4) {
                aVar = this.f61026g;
            } else {
                aVar = type == AdvertAppInfo.f4 ? this.f61027h : null;
            }
            if (aVar != null) {
                return aVar.Q(viewGroup, obj);
            }
            return null;
        }
        return null;
    }

    @Override // d.a.k0.e.b.d
    public void h(List<d.a.k0.e.b.c> list, int i2) {
        if (d.a.k0.j1.o.k.a.e(this.f61020a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f61020a) {
            if (obj instanceof AdvertAppInfo) {
                d.a.k0.j1.o.k.a.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<d.a.k0.e.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = d.a.k0.j1.o.k.a.k(list);
        int i3 = 0;
        int i4 = 0;
        for (d.a.k0.e.b.c cVar : list) {
            if (cVar.c() == 1) {
                i4++;
            }
        }
        int k2 = d.a.k0.j1.o.k.a.k(arrayList);
        if (k2 < 1) {
            return;
        }
        int i5 = k - i4;
        HashSet hashSet = new HashSet();
        int i6 = 0;
        while (i6 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) d.a.k0.j1.o.k.a.d(arrayList, i6);
            advertAppInfo.P3 = "FRS";
            int G4 = advertAppInfo.G4();
            if (G4 != 0) {
                d.a.k0.s2.i0.d.g(advertAppInfo, i2, G4);
                if (G4 != 28 && G4 != 31) {
                    advertAppInfo.H3 = -1001;
                }
                i6++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                d.a.k0.s2.i0.d.g(advertAppInfo, i2, 100);
            } else {
                int d2 = (d.a.c.e.m.b.d(advertAppInfo.L3, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(d2))) {
                    d.a.k0.s2.i0.d.g(advertAppInfo, i2, 29);
                } else if (d2 < 0) {
                    d.a.k0.s2.i0.d.g(advertAppInfo, i2, 33);
                } else if (d2 >= k && i5 > 3) {
                    d.a.k0.s2.i0.d.h(advertAppInfo, i2, 2, d2, k);
                } else {
                    d.a.k0.e.b.c cVar2 = new d.a.k0.e.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.D4()) {
                        if (y.q(advertAppInfo.X3) && d.a.k0.a.e().u()) {
                            d.a.k0.s2.i0.d.g(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.X3) && !TextUtils.isEmpty(advertAppInfo.S3)) {
                            hashSet.add(Integer.valueOf(d2));
                            if (d2 < k) {
                                d.a.k0.j1.o.k.a.b(list, cVar2, d2);
                            } else if (d2 == k) {
                                d.a.k0.j1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.F4()) {
                        hashSet.add(Integer.valueOf(d2));
                        if (d2 < k) {
                            d.a.k0.j1.o.k.a.b(list, cVar2, d2);
                        } else if (d2 == k) {
                            d.a.k0.j1.o.k.a.a(list, cVar2);
                        }
                    } else {
                        d.a.k0.s2.i0.d.g(advertAppInfo, i2, 21);
                    }
                }
            }
            i6++;
            i3 = 0;
        }
    }

    @Override // d.a.k0.e.b.d
    public void j(List<Object> list) {
        this.f61020a = list;
    }

    @Override // d.a.k0.e.b.d
    public View l(int i2, View view, ViewGroup viewGroup, Object obj) {
        d.a.c.j.e.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.c4) {
                aVar = this.f61024e;
            } else if (type == AdvertAppInfo.Z3) {
                aVar = this.f61023d;
            } else if (type == AdvertAppInfo.d4) {
                aVar = this.f61025f;
            } else if (type == AdvertAppInfo.e4) {
                aVar = this.f61026g;
            } else {
                aVar = type == AdvertAppInfo.f4 ? this.f61027h : null;
            }
            if (aVar != null) {
                return aVar.H(i2, view, viewGroup, advertAppInfo);
            }
            return null;
        }
        return null;
    }

    @Override // d.a.k0.e.b.d
    public void m(int i2, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        if (obj instanceof AdvertAppInfo) {
            d.a.c.j.e.a aVar = null;
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.c4) {
                aVar = this.f61024e;
            } else if (type == AdvertAppInfo.Z3) {
                aVar = this.f61023d;
            } else if (type == AdvertAppInfo.d4) {
                aVar = this.f61025f;
            } else if (type == AdvertAppInfo.e4) {
                aVar = this.f61026g;
            } else if (type == AdvertAppInfo.f4) {
                aVar = this.f61027h;
            }
            if (aVar != null) {
                aVar.X(i2, viewGroup, viewHolder, obj);
            }
        }
    }

    @Override // d.a.k0.e.b.d
    public void n(List<d.a.k0.e.b.c> list, List<d.a.k0.e.b.c> list2, boolean z, int i2) {
        ArrayList arrayList;
        int i3;
        int i4;
        int d2;
        if (d.a.k0.j1.o.k.a.e(this.f61020a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.f61020a) {
            if (obj instanceof AdvertAppInfo) {
                d.a.k0.j1.o.k.a.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<d.a.k0.e.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = d.a.k0.j1.o.k.a.k(list);
        int i5 = 0;
        int i6 = 0;
        for (d.a.k0.e.b.c cVar : list) {
            if (cVar.c() == 1) {
                i6++;
            }
        }
        int k2 = d.a.k0.j1.o.k.a.k(arrayList2);
        if (k2 < 1) {
            return;
        }
        int i7 = 9;
        if (d.a.k0.j1.o.k.a.k(arrayList2) > 1 && (d2 = (d.a.c.e.m.b.d(((AdvertAppInfo) d.a.k0.j1.o.k.a.d(arrayList2, 1)).L3, 0) - d.a.c.e.m.b.d(((AdvertAppInfo) d.a.k0.j1.o.k.a.d(arrayList2, 0)).L3, 0)) - 1) > 0) {
            i7 = d2;
        }
        int d3 = d.a.c.e.m.b.d(((AdvertAppInfo) d.a.k0.j1.o.k.a.d(arrayList2, 0)).L3, 0) - 1;
        int i8 = k - i6;
        HashSet hashSet = new HashSet();
        int i9 = 0;
        while (i9 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) d.a.k0.j1.o.k.a.d(arrayList2, i9);
            advertAppInfo.P3 = "SMART_FRS";
            int G4 = advertAppInfo.G4();
            if (G4 != 0) {
                d.a.k0.s2.i0.d.g(advertAppInfo, i2, G4);
                if (G4 != 28 && G4 != 31) {
                    advertAppInfo.H3 = -1001;
                }
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                d.a.k0.s2.i0.d.g(advertAppInfo, i2, 100);
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int d4 = d.a.c.e.m.b.d(advertAppInfo.L3, i5);
                int i10 = (d4 + i6) - 1;
                if (i10 < 0 || hashSet.contains(Integer.valueOf(i10)) || i10 > k) {
                    arrayList = arrayList2;
                    if (i10 > k) {
                        d.a.k0.s2.i0.d.h(advertAppInfo, i2, 2, i10, k);
                        i9++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else {
                        i3 = i10 < 0 ? 33 : 29;
                    }
                } else {
                    if (d4 <= (i8 - i7) + d3 || !z) {
                        arrayList = arrayList2;
                    } else if (!d.a.k0.j1.o.k.a.e(list2)) {
                        int k3 = d.a.k0.j1.o.k.a.k(list2);
                        int i11 = (i7 - ((i8 - d4) + 1)) - 1;
                        int i12 = 0;
                        while (i12 < k3 && i12 < i11) {
                            arrayList = arrayList2;
                            if (((d.a.k0.e.b.c) d.a.k0.j1.o.k.a.d(list2, i12)).a() instanceof AdvertAppInfo) {
                                i4 = 0;
                                break;
                            } else {
                                i12++;
                                arrayList2 = arrayList;
                            }
                        }
                        arrayList = arrayList2;
                        i4 = 1;
                        i3 = i4 ^ 1;
                    } else {
                        arrayList = arrayList2;
                        if (d.a.k0.a.e().t()) {
                            i3 = 36;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    d.a.k0.s2.i0.d.g(advertAppInfo, i2, i3);
                    i9++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    d.a.k0.e.b.c cVar2 = new d.a.k0.e.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.D4()) {
                        if (y.q(advertAppInfo.X3) && d.a.k0.a.e().u()) {
                            d.a.k0.s2.i0.d.g(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.X3) && !TextUtils.isEmpty(advertAppInfo.S3)) {
                            hashSet.add(Integer.valueOf(i10));
                            if (i10 < k) {
                                d.a.k0.j1.o.k.a.b(list, cVar2, i10);
                            } else if (i10 == k) {
                                d.a.k0.j1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.F4()) {
                        hashSet.add(Integer.valueOf(i10));
                        if (i10 < k) {
                            d.a.k0.j1.o.k.a.b(list, cVar2, i10);
                        } else if (i10 == k) {
                            d.a.k0.j1.o.k.a.a(list, cVar2);
                        }
                    }
                    i9++;
                    arrayList2 = arrayList;
                    i5 = 0;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.e.e.a
    /* renamed from: p */
    public void o(d.a.k0.e.e.c cVar) {
        this.f61021b = cVar;
        if (cVar == null || !(cVar.a() instanceof u)) {
            return;
        }
        this.f61022c = (u) this.f61021b.a();
        this.f61023d = new d.a.k0.s2.b0.c(this.f61022c, AdvertAppInfo.Z3);
        this.f61024e = new d.a.k0.s2.b0.d(this.f61022c, AdvertAppInfo.c4);
        this.f61025f = new d.a.k0.s2.b0.d(this.f61022c, AdvertAppInfo.d4);
        this.f61026g = new d.a.k0.s2.b0.d(this.f61022c, AdvertAppInfo.e4);
        this.f61027h = new d.a.k0.s2.b0.d(this.f61022c, AdvertAppInfo.f4);
    }
}
