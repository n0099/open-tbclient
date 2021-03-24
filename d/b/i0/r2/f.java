package d.b.i0.r2;

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
public class f implements d.b.i0.e.b.d {

    /* renamed from: a  reason: collision with root package name */
    public List<Object> f59834a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.e.e.c f59835b;

    /* renamed from: c  reason: collision with root package name */
    public q f59836c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.b.j.e.a f59837d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.b.j.e.a f59838e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.b.j.e.a f59839f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.j.e.a f59840g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.j.e.a f59841h;

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
        if (d.b.i0.i1.o.k.a.e(this.f59834a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f59834a) {
            if (obj instanceof AdvertAppInfo) {
                d.b.i0.i1.o.k.a.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<d.b.i0.e.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int j = d.b.i0.i1.o.k.a.j(list);
        int i2 = 0;
        int i3 = 0;
        for (d.b.i0.e.b.c cVar : list) {
            if (cVar.c() == 1) {
                i3++;
            }
        }
        int j2 = d.b.i0.i1.o.k.a.j(arrayList);
        if (j2 < 1) {
            return;
        }
        int i4 = j - i3;
        HashSet hashSet = new HashSet();
        int i5 = 0;
        while (i5 < j2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) d.b.i0.i1.o.k.a.d(arrayList, i5);
            advertAppInfo.c4 = "FRS";
            int D4 = advertAppInfo.D4();
            if (D4 != 0) {
                d.b.i0.r2.b0.d.f(advertAppInfo, i, D4);
                if (D4 != 28 && D4 != 31) {
                    advertAppInfo.U3.f13209h = -1001;
                }
                i5++;
                i2 = 0;
            }
            if (advertAppInfo.getType() == null) {
                d.b.i0.r2.b0.d.f(advertAppInfo, i, 100);
            } else {
                int d2 = (d.b.b.e.m.b.d(advertAppInfo.K3, i2) + i3) - 1;
                if (hashSet.contains(Integer.valueOf(d2))) {
                    d.b.i0.r2.b0.d.f(advertAppInfo, i, 29);
                } else if (d2 < 0) {
                    d.b.i0.r2.b0.d.f(advertAppInfo, i, 33);
                } else if (d2 >= j && i4 > 3) {
                    d.b.i0.r2.b0.d.g(advertAppInfo, i, 2, d2, j);
                } else {
                    d.b.i0.e.b.c cVar2 = new d.b.i0.e.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.A4()) {
                        if (t.q(advertAppInfo.J3) && d.b.i0.a.e().j()) {
                            d.b.i0.r2.b0.d.f(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.J3) && !TextUtils.isEmpty(advertAppInfo.F3)) {
                            hashSet.add(Integer.valueOf(d2));
                            if (d2 < j) {
                                d.b.i0.i1.o.k.a.b(list, cVar2, d2);
                            } else if (d2 == j) {
                                d.b.i0.i1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.C4()) {
                        hashSet.add(Integer.valueOf(d2));
                        if (d2 < j) {
                            d.b.i0.i1.o.k.a.b(list, cVar2, d2);
                        } else if (d2 == j) {
                            d.b.i0.i1.o.k.a.a(list, cVar2);
                        }
                    } else {
                        d.b.i0.r2.b0.d.f(advertAppInfo, i, 21);
                    }
                }
            }
            i5++;
            i2 = 0;
        }
    }

    @Override // d.b.i0.e.b.d
    public void h(List<d.b.i0.e.b.c> list, String str, String str2, String str3, String str4, boolean z, int i) {
        if (d.b.i0.i1.o.k.a.e(list)) {
            return;
        }
        Set<d.b.b.j.e.n> a2 = d.b.i0.r2.b0.a.a("FRS");
        if (a2 == null) {
            a2 = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (d.b.i0.e.b.c cVar : list) {
            if (cVar != null) {
                Object a3 = cVar.a();
                for (d.b.b.j.e.n nVar : a2) {
                    if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && a3.hashCode() == nVar.hashCode()) {
                        ((AdvertAppInfo) a3).Y3 = ((AdvertAppInfo) nVar).Y3;
                    }
                }
                if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a3;
                    if (advertAppInfo.Y3 == null) {
                        d.b.h0.r.q.d dVar = new d.b.h0.r.q.d();
                        advertAppInfo.Y3 = dVar;
                        dVar.f50748a = "FRS";
                        dVar.f50750c = String.valueOf(z);
                        d.b.h0.r.q.d dVar2 = advertAppInfo.Y3;
                        dVar2.f50749b = i;
                        dVar2.f50751d = str;
                        dVar2.f50752e = str2;
                        dVar2.f50753f = str3;
                        dVar2.f50754g = str4;
                        dVar2.f50755h = advertAppInfo.T3;
                        dVar2.i = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a2.addAll(hashSet);
        d.b.i0.r2.b0.a.b("FRS", a2);
    }

    @Override // d.b.i0.e.b.d
    public void i(List<Object> list) {
        this.f59834a = list;
    }

    @Override // d.b.i0.e.b.d
    public View k(int i, View view, ViewGroup viewGroup, Object obj) {
        d.b.b.j.e.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.k4) {
                aVar = this.f59838e;
            } else if (type == AdvertAppInfo.h4) {
                aVar = this.f59837d;
            } else if (type == AdvertAppInfo.o4) {
                aVar = this.f59839f;
            } else if (type == AdvertAppInfo.p4) {
                aVar = this.f59840g;
            } else {
                aVar = type == AdvertAppInfo.q4 ? this.f59841h : null;
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
            d.b.b.j.e.a aVar = null;
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.k4) {
                aVar = this.f59838e;
            } else if (type == AdvertAppInfo.h4) {
                aVar = this.f59837d;
            } else if (type == AdvertAppInfo.o4) {
                aVar = this.f59839f;
            } else if (type == AdvertAppInfo.p4) {
                aVar = this.f59840g;
            } else if (type == AdvertAppInfo.q4) {
                aVar = this.f59841h;
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
        if (d.b.i0.i1.o.k.a.e(this.f59834a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.f59834a) {
            if (obj instanceof AdvertAppInfo) {
                d.b.i0.i1.o.k.a.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<d.b.i0.e.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int j = d.b.i0.i1.o.k.a.j(list);
        int i4 = 0;
        int i5 = 0;
        for (d.b.i0.e.b.c cVar : list) {
            if (cVar.c() == 1) {
                i5++;
            }
        }
        int j2 = d.b.i0.i1.o.k.a.j(arrayList2);
        if (j2 < 1) {
            return;
        }
        int i6 = 9;
        if (d.b.i0.i1.o.k.a.j(arrayList2) > 1 && (d2 = (d.b.b.e.m.b.d(((AdvertAppInfo) d.b.i0.i1.o.k.a.d(arrayList2, 1)).K3, 0) - d.b.b.e.m.b.d(((AdvertAppInfo) d.b.i0.i1.o.k.a.d(arrayList2, 0)).K3, 0)) - 1) > 0) {
            i6 = d2;
        }
        int d3 = d.b.b.e.m.b.d(((AdvertAppInfo) d.b.i0.i1.o.k.a.d(arrayList2, 0)).K3, 0) - 1;
        int i7 = j - i5;
        HashSet hashSet = new HashSet();
        int i8 = 0;
        while (i8 < j2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) d.b.i0.i1.o.k.a.d(arrayList2, i8);
            advertAppInfo.c4 = "SMART_FRS";
            int D4 = advertAppInfo.D4();
            if (D4 != 0) {
                d.b.i0.r2.b0.d.f(advertAppInfo, i, D4);
                if (D4 != 28 && D4 != 31) {
                    advertAppInfo.U3.f13209h = -1001;
                }
                arrayList = arrayList2;
                i8++;
                arrayList2 = arrayList;
                i4 = 0;
            }
            if (advertAppInfo.getType() == null) {
                d.b.i0.r2.b0.d.f(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i8++;
                arrayList2 = arrayList;
                i4 = 0;
            } else {
                int d4 = d.b.b.e.m.b.d(advertAppInfo.K3, i4);
                int i9 = (d4 + i5) - 1;
                if (i9 < 0 || hashSet.contains(Integer.valueOf(i9)) || i9 > j) {
                    arrayList = arrayList2;
                    if (i9 > j) {
                        d.b.i0.r2.b0.d.g(advertAppInfo, i, 2, i9, j);
                        i8++;
                        arrayList2 = arrayList;
                        i4 = 0;
                    } else {
                        i2 = i9 < 0 ? 33 : 29;
                    }
                } else {
                    if (d4 <= (i7 - i6) + d3 || !z) {
                        arrayList = arrayList2;
                    } else if (!d.b.i0.i1.o.k.a.e(list2)) {
                        int j3 = d.b.i0.i1.o.k.a.j(list2);
                        int i10 = (i6 - ((i7 - d4) + 1)) - 1;
                        int i11 = 0;
                        while (i11 < j3 && i11 < i10) {
                            arrayList = arrayList2;
                            if (((d.b.i0.e.b.c) d.b.i0.i1.o.k.a.d(list2, i11)).a() instanceof AdvertAppInfo) {
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
                        if (d.b.i0.a.e().i()) {
                            i2 = 36;
                        }
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    d.b.i0.r2.b0.d.f(advertAppInfo, i, i2);
                    i8++;
                    arrayList2 = arrayList;
                    i4 = 0;
                } else {
                    d.b.i0.e.b.c cVar2 = new d.b.i0.e.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.A4()) {
                        if (t.q(advertAppInfo.J3) && d.b.i0.a.e().j()) {
                            d.b.i0.r2.b0.d.f(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.J3) && !TextUtils.isEmpty(advertAppInfo.F3)) {
                            hashSet.add(Integer.valueOf(i9));
                            if (i9 < j) {
                                d.b.i0.i1.o.k.a.b(list, cVar2, i9);
                            } else if (i9 == j) {
                                d.b.i0.i1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.C4()) {
                        hashSet.add(Integer.valueOf(i9));
                        if (i9 < j) {
                            d.b.i0.i1.o.k.a.b(list, cVar2, i9);
                        } else if (i9 == j) {
                            d.b.i0.i1.o.k.a.a(list, cVar2);
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
        d.b.b.j.e.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.k4) {
                aVar = this.f59838e;
            } else if (type == AdvertAppInfo.h4) {
                aVar = this.f59837d;
            } else if (type == AdvertAppInfo.o4) {
                aVar = this.f59839f;
            } else if (type == AdvertAppInfo.p4) {
                aVar = this.f59840g;
            } else {
                aVar = type == AdvertAppInfo.q4 ? this.f59841h : null;
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
        this.f59835b = cVar;
        if (cVar == null || !(cVar.a() instanceof q)) {
            return;
        }
        this.f59836c = (q) this.f59835b.a();
        this.f59837d = new d.b.i0.r2.w.c(this.f59836c, AdvertAppInfo.h4);
        this.f59838e = new d.b.i0.r2.w.d(this.f59836c, AdvertAppInfo.k4);
        this.f59839f = new d.b.i0.r2.w.d(this.f59836c, AdvertAppInfo.o4);
        this.f59840g = new d.b.i0.r2.w.d(this.f59836c, AdvertAppInfo.p4);
        this.f59841h = new d.b.i0.r2.w.d(this.f59836c, AdvertAppInfo.q4);
    }
}
