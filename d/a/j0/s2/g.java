package d.a.j0.s2;

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
/* loaded from: classes3.dex */
public class g implements d.a.j0.e.b.d {

    /* renamed from: a  reason: collision with root package name */
    public List<Object> f60277a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.e.e.c f60278b;

    /* renamed from: c  reason: collision with root package name */
    public t f60279c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.j.e.a f60280d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.j.e.a f60281e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.j.e.a f60282f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.j.e.a f60283g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.j.e.a f60284h;

    @Override // d.a.j0.e.b.d
    public void a(int i2) {
    }

    @Override // d.a.j0.e.e.a
    public void b(Map<String, String> map) {
    }

    @Override // d.a.j0.e.b.d
    public List<Integer> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.k4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.h4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.o4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.p4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.q4.getId()));
        return arrayList;
    }

    @Override // d.a.j0.e.b.d
    public void e(List<d.a.j0.e.b.c> list, String str, String str2, String str3, String str4, boolean z, int i2) {
        if (d.a.j0.j1.o.k.a.e(list)) {
            return;
        }
        Set<d.a.c.j.e.n> a2 = d.a.j0.s2.h0.a.a("FRS");
        if (a2 == null) {
            a2 = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (d.a.j0.e.b.c cVar : list) {
            if (cVar != null) {
                Object a3 = cVar.a();
                for (d.a.c.j.e.n nVar : a2) {
                    if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && a3.hashCode() == nVar.hashCode()) {
                        ((AdvertAppInfo) a3).Y3 = ((AdvertAppInfo) nVar).Y3;
                    }
                }
                if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a3;
                    if (advertAppInfo.Y3 == null) {
                        d.a.i0.r.q.d dVar = new d.a.i0.r.q.d();
                        advertAppInfo.Y3 = dVar;
                        dVar.f49116a = "FRS";
                        dVar.f49118c = String.valueOf(z);
                        d.a.i0.r.q.d dVar2 = advertAppInfo.Y3;
                        dVar2.f49117b = i2;
                        dVar2.f49119d = str;
                        dVar2.f49120e = str2;
                        dVar2.f49121f = str3;
                        dVar2.f49122g = str4;
                        dVar2.f49123h = advertAppInfo.T3;
                        dVar2.f49124i = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a2.addAll(hashSet);
        d.a.j0.s2.h0.a.b("FRS", a2);
    }

    @Override // d.a.j0.e.b.d
    public TypeAdapter.ViewHolder f(ViewGroup viewGroup, Object obj) {
        d.a.c.j.e.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.k4) {
                aVar = this.f60281e;
            } else if (type == AdvertAppInfo.h4) {
                aVar = this.f60280d;
            } else if (type == AdvertAppInfo.o4) {
                aVar = this.f60282f;
            } else if (type == AdvertAppInfo.p4) {
                aVar = this.f60283g;
            } else {
                aVar = type == AdvertAppInfo.q4 ? this.f60284h : null;
            }
            if (aVar != null) {
                return aVar.Q(viewGroup, obj);
            }
            return null;
        }
        return null;
    }

    @Override // d.a.j0.e.b.d
    public void h(List<d.a.j0.e.b.c> list, int i2) {
        if (d.a.j0.j1.o.k.a.e(this.f60277a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f60277a) {
            if (obj instanceof AdvertAppInfo) {
                d.a.j0.j1.o.k.a.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<d.a.j0.e.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = d.a.j0.j1.o.k.a.k(list);
        int i3 = 0;
        int i4 = 0;
        for (d.a.j0.e.b.c cVar : list) {
            if (cVar.c() == 1) {
                i4++;
            }
        }
        int k2 = d.a.j0.j1.o.k.a.k(arrayList);
        if (k2 < 1) {
            return;
        }
        int i5 = k - i4;
        HashSet hashSet = new HashSet();
        int i6 = 0;
        while (i6 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) d.a.j0.j1.o.k.a.d(arrayList, i6);
            advertAppInfo.c4 = "FRS";
            int E4 = advertAppInfo.E4();
            if (E4 != 0) {
                d.a.j0.s2.h0.d.g(advertAppInfo, i2, E4);
                if (E4 != 28 && E4 != 31) {
                    advertAppInfo.U3.f12794h = -1001;
                }
                i6++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                d.a.j0.s2.h0.d.g(advertAppInfo, i2, 100);
            } else {
                int d2 = (d.a.c.e.m.b.d(advertAppInfo.K3, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(d2))) {
                    d.a.j0.s2.h0.d.g(advertAppInfo, i2, 29);
                } else if (d2 < 0) {
                    d.a.j0.s2.h0.d.g(advertAppInfo, i2, 33);
                } else if (d2 >= k && i5 > 3) {
                    d.a.j0.s2.h0.d.h(advertAppInfo, i2, 2, d2, k);
                } else {
                    d.a.j0.e.b.c cVar2 = new d.a.j0.e.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.B4()) {
                        if (x.q(advertAppInfo.J3) && d.a.j0.a.e().u()) {
                            d.a.j0.s2.h0.d.g(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.J3) && !TextUtils.isEmpty(advertAppInfo.F3)) {
                            hashSet.add(Integer.valueOf(d2));
                            if (d2 < k) {
                                d.a.j0.j1.o.k.a.b(list, cVar2, d2);
                            } else if (d2 == k) {
                                d.a.j0.j1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.D4()) {
                        hashSet.add(Integer.valueOf(d2));
                        if (d2 < k) {
                            d.a.j0.j1.o.k.a.b(list, cVar2, d2);
                        } else if (d2 == k) {
                            d.a.j0.j1.o.k.a.a(list, cVar2);
                        }
                    } else {
                        d.a.j0.s2.h0.d.g(advertAppInfo, i2, 21);
                    }
                }
            }
            i6++;
            i3 = 0;
        }
    }

    @Override // d.a.j0.e.b.d
    public void j(List<Object> list) {
        this.f60277a = list;
    }

    @Override // d.a.j0.e.b.d
    public View l(int i2, View view, ViewGroup viewGroup, Object obj) {
        d.a.c.j.e.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.k4) {
                aVar = this.f60281e;
            } else if (type == AdvertAppInfo.h4) {
                aVar = this.f60280d;
            } else if (type == AdvertAppInfo.o4) {
                aVar = this.f60282f;
            } else if (type == AdvertAppInfo.p4) {
                aVar = this.f60283g;
            } else {
                aVar = type == AdvertAppInfo.q4 ? this.f60284h : null;
            }
            if (aVar != null) {
                return aVar.H(i2, view, viewGroup, advertAppInfo);
            }
            return null;
        }
        return null;
    }

    @Override // d.a.j0.e.b.d
    public void m(int i2, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        if (obj instanceof AdvertAppInfo) {
            d.a.c.j.e.a aVar = null;
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.k4) {
                aVar = this.f60281e;
            } else if (type == AdvertAppInfo.h4) {
                aVar = this.f60280d;
            } else if (type == AdvertAppInfo.o4) {
                aVar = this.f60282f;
            } else if (type == AdvertAppInfo.p4) {
                aVar = this.f60283g;
            } else if (type == AdvertAppInfo.q4) {
                aVar = this.f60284h;
            }
            if (aVar != null) {
                aVar.X(i2, viewGroup, viewHolder, obj);
            }
        }
    }

    @Override // d.a.j0.e.b.d
    public void n(List<d.a.j0.e.b.c> list, List<d.a.j0.e.b.c> list2, boolean z, int i2) {
        ArrayList arrayList;
        int i3;
        int i4;
        int d2;
        if (d.a.j0.j1.o.k.a.e(this.f60277a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.f60277a) {
            if (obj instanceof AdvertAppInfo) {
                d.a.j0.j1.o.k.a.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<d.a.j0.e.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = d.a.j0.j1.o.k.a.k(list);
        int i5 = 0;
        int i6 = 0;
        for (d.a.j0.e.b.c cVar : list) {
            if (cVar.c() == 1) {
                i6++;
            }
        }
        int k2 = d.a.j0.j1.o.k.a.k(arrayList2);
        if (k2 < 1) {
            return;
        }
        int i7 = 9;
        if (d.a.j0.j1.o.k.a.k(arrayList2) > 1 && (d2 = (d.a.c.e.m.b.d(((AdvertAppInfo) d.a.j0.j1.o.k.a.d(arrayList2, 1)).K3, 0) - d.a.c.e.m.b.d(((AdvertAppInfo) d.a.j0.j1.o.k.a.d(arrayList2, 0)).K3, 0)) - 1) > 0) {
            i7 = d2;
        }
        int d3 = d.a.c.e.m.b.d(((AdvertAppInfo) d.a.j0.j1.o.k.a.d(arrayList2, 0)).K3, 0) - 1;
        int i8 = k - i6;
        HashSet hashSet = new HashSet();
        int i9 = 0;
        while (i9 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) d.a.j0.j1.o.k.a.d(arrayList2, i9);
            advertAppInfo.c4 = "SMART_FRS";
            int E4 = advertAppInfo.E4();
            if (E4 != 0) {
                d.a.j0.s2.h0.d.g(advertAppInfo, i2, E4);
                if (E4 != 28 && E4 != 31) {
                    advertAppInfo.U3.f12794h = -1001;
                }
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                d.a.j0.s2.h0.d.g(advertAppInfo, i2, 100);
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int d4 = d.a.c.e.m.b.d(advertAppInfo.K3, i5);
                int i10 = (d4 + i6) - 1;
                if (i10 < 0 || hashSet.contains(Integer.valueOf(i10)) || i10 > k) {
                    arrayList = arrayList2;
                    if (i10 > k) {
                        d.a.j0.s2.h0.d.h(advertAppInfo, i2, 2, i10, k);
                        i9++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else {
                        i3 = i10 < 0 ? 33 : 29;
                    }
                } else {
                    if (d4 <= (i8 - i7) + d3 || !z) {
                        arrayList = arrayList2;
                    } else if (!d.a.j0.j1.o.k.a.e(list2)) {
                        int k3 = d.a.j0.j1.o.k.a.k(list2);
                        int i11 = (i7 - ((i8 - d4) + 1)) - 1;
                        int i12 = 0;
                        while (i12 < k3 && i12 < i11) {
                            arrayList = arrayList2;
                            if (((d.a.j0.e.b.c) d.a.j0.j1.o.k.a.d(list2, i12)).a() instanceof AdvertAppInfo) {
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
                        if (d.a.j0.a.e().t()) {
                            i3 = 36;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    d.a.j0.s2.h0.d.g(advertAppInfo, i2, i3);
                    i9++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    d.a.j0.e.b.c cVar2 = new d.a.j0.e.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.B4()) {
                        if (x.q(advertAppInfo.J3) && d.a.j0.a.e().u()) {
                            d.a.j0.s2.h0.d.g(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.J3) && !TextUtils.isEmpty(advertAppInfo.F3)) {
                            hashSet.add(Integer.valueOf(i10));
                            if (i10 < k) {
                                d.a.j0.j1.o.k.a.b(list, cVar2, i10);
                            } else if (i10 == k) {
                                d.a.j0.j1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.D4()) {
                        hashSet.add(Integer.valueOf(i10));
                        if (i10 < k) {
                            d.a.j0.j1.o.k.a.b(list, cVar2, i10);
                        } else if (i10 == k) {
                            d.a.j0.j1.o.k.a.a(list, cVar2);
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
    @Override // d.a.j0.e.e.a
    /* renamed from: p */
    public void o(d.a.j0.e.e.c cVar) {
        this.f60278b = cVar;
        if (cVar == null || !(cVar.a() instanceof t)) {
            return;
        }
        this.f60279c = (t) this.f60278b.a();
        this.f60280d = new d.a.j0.s2.a0.c(this.f60279c, AdvertAppInfo.h4);
        this.f60281e = new d.a.j0.s2.a0.d(this.f60279c, AdvertAppInfo.k4);
        this.f60282f = new d.a.j0.s2.a0.d(this.f60279c, AdvertAppInfo.o4);
        this.f60283g = new d.a.j0.s2.a0.d(this.f60279c, AdvertAppInfo.p4);
        this.f60284h = new d.a.j0.s2.a0.d(this.f60279c, AdvertAppInfo.q4);
    }
}
