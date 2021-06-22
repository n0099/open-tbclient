package d.a.o0.t2;

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
public class h implements d.a.o0.e.b.d {

    /* renamed from: a  reason: collision with root package name */
    public List<Object> f64939a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.e.e.c f64940b;

    /* renamed from: c  reason: collision with root package name */
    public u f64941c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.k.e.a f64942d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.k.e.a f64943e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.k.e.a f64944f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.k.e.a f64945g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.k.e.a f64946h;

    @Override // d.a.o0.e.b.d
    public void a(int i2) {
    }

    @Override // d.a.o0.e.e.a
    public void b(Map<String, String> map) {
    }

    @Override // d.a.o0.e.b.d
    public List<Integer> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.g4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.d4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.h4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.i4.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.j4.getId()));
        return arrayList;
    }

    @Override // d.a.o0.e.b.d
    public void e(List<d.a.o0.e.b.c> list, String str, String str2, String str3, String str4, boolean z, int i2) {
        if (d.a.o0.k1.o.k.a.e(list)) {
            return;
        }
        Set<d.a.c.k.e.n> a2 = d.a.o0.t2.i0.a.a("FRS");
        if (a2 == null) {
            a2 = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (d.a.o0.e.b.c cVar : list) {
            if (cVar != null) {
                Object a3 = cVar.a();
                for (d.a.c.k.e.n nVar : a2) {
                    if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && a3.hashCode() == nVar.hashCode()) {
                        ((AdvertAppInfo) a3).S3 = ((AdvertAppInfo) nVar).S3;
                    }
                }
                if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a3;
                    if (advertAppInfo.S3 == null) {
                        d.a.n0.r.q.d dVar = new d.a.n0.r.q.d();
                        advertAppInfo.S3 = dVar;
                        dVar.f53762a = "FRS";
                        dVar.f53764c = String.valueOf(z);
                        d.a.n0.r.q.d dVar2 = advertAppInfo.S3;
                        dVar2.f53763b = i2;
                        dVar2.f53765d = str;
                        dVar2.f53766e = str2;
                        dVar2.f53767f = str3;
                        dVar2.f53768g = str4;
                        dVar2.f53769h = advertAppInfo.Q3;
                        dVar2.f53770i = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a2.addAll(hashSet);
        d.a.o0.t2.i0.a.b("FRS", a2);
    }

    @Override // d.a.o0.e.b.d
    public TypeAdapter.ViewHolder f(ViewGroup viewGroup, Object obj) {
        d.a.c.k.e.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.g4) {
                aVar = this.f64943e;
            } else if (type == AdvertAppInfo.d4) {
                aVar = this.f64942d;
            } else if (type == AdvertAppInfo.h4) {
                aVar = this.f64944f;
            } else if (type == AdvertAppInfo.i4) {
                aVar = this.f64945g;
            } else {
                aVar = type == AdvertAppInfo.j4 ? this.f64946h : null;
            }
            if (aVar != null) {
                return aVar.R(viewGroup, obj);
            }
            return null;
        }
        return null;
    }

    @Override // d.a.o0.e.b.d
    public void h(List<d.a.o0.e.b.c> list, int i2) {
        if (d.a.o0.k1.o.k.a.e(this.f64939a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f64939a) {
            if (obj instanceof AdvertAppInfo) {
                d.a.o0.k1.o.k.a.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<d.a.o0.e.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = d.a.o0.k1.o.k.a.k(list);
        int i3 = 0;
        int i4 = 0;
        for (d.a.o0.e.b.c cVar : list) {
            if (cVar.c() == 1) {
                i4++;
            }
        }
        int k2 = d.a.o0.k1.o.k.a.k(arrayList);
        if (k2 < 1) {
            return;
        }
        int i5 = k - i4;
        HashSet hashSet = new HashSet();
        int i6 = 0;
        while (i6 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) d.a.o0.k1.o.k.a.d(arrayList, i6);
            advertAppInfo.T3 = "FRS";
            int I4 = advertAppInfo.I4();
            if (I4 != 0) {
                d.a.o0.t2.i0.d.g(advertAppInfo, i2, I4);
                if (I4 != 28 && I4 != 31) {
                    advertAppInfo.L3 = -1001;
                }
                i6++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                d.a.o0.t2.i0.d.g(advertAppInfo, i2, 100);
            } else {
                int d2 = (d.a.c.e.m.b.d(advertAppInfo.P3, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(d2))) {
                    d.a.o0.t2.i0.d.g(advertAppInfo, i2, 29);
                } else if (d2 < 0) {
                    d.a.o0.t2.i0.d.g(advertAppInfo, i2, 33);
                } else if (d2 >= k && i5 > 3) {
                    d.a.o0.t2.i0.d.h(advertAppInfo, i2, 2, d2, k);
                } else {
                    d.a.o0.e.b.c cVar2 = new d.a.o0.e.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.F4()) {
                        if (y.q(advertAppInfo.b4) && d.a.o0.a.h().y()) {
                            d.a.o0.t2.i0.d.g(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.b4) && !TextUtils.isEmpty(advertAppInfo.W3)) {
                            hashSet.add(Integer.valueOf(d2));
                            if (d2 < k) {
                                d.a.o0.k1.o.k.a.b(list, cVar2, d2);
                            } else if (d2 == k) {
                                d.a.o0.k1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.H4()) {
                        hashSet.add(Integer.valueOf(d2));
                        if (d2 < k) {
                            d.a.o0.k1.o.k.a.b(list, cVar2, d2);
                        } else if (d2 == k) {
                            d.a.o0.k1.o.k.a.a(list, cVar2);
                        }
                    } else {
                        d.a.o0.t2.i0.d.g(advertAppInfo, i2, 21);
                    }
                }
            }
            i6++;
            i3 = 0;
        }
    }

    @Override // d.a.o0.e.b.d
    public void j(List<Object> list) {
        this.f64939a = list;
    }

    @Override // d.a.o0.e.b.d
    public View l(int i2, View view, ViewGroup viewGroup, Object obj) {
        d.a.c.k.e.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.g4) {
                aVar = this.f64943e;
            } else if (type == AdvertAppInfo.d4) {
                aVar = this.f64942d;
            } else if (type == AdvertAppInfo.h4) {
                aVar = this.f64944f;
            } else if (type == AdvertAppInfo.i4) {
                aVar = this.f64945g;
            } else {
                aVar = type == AdvertAppInfo.j4 ? this.f64946h : null;
            }
            if (aVar != null) {
                return aVar.I(i2, view, viewGroup, advertAppInfo);
            }
            return null;
        }
        return null;
    }

    @Override // d.a.o0.e.b.d
    public void m(int i2, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        if (obj instanceof AdvertAppInfo) {
            d.a.c.k.e.a aVar = null;
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.g4) {
                aVar = this.f64943e;
            } else if (type == AdvertAppInfo.d4) {
                aVar = this.f64942d;
            } else if (type == AdvertAppInfo.h4) {
                aVar = this.f64944f;
            } else if (type == AdvertAppInfo.i4) {
                aVar = this.f64945g;
            } else if (type == AdvertAppInfo.j4) {
                aVar = this.f64946h;
            }
            if (aVar != null) {
                aVar.Y(i2, viewGroup, viewHolder, obj);
            }
        }
    }

    @Override // d.a.o0.e.b.d
    public void n(List<d.a.o0.e.b.c> list, List<d.a.o0.e.b.c> list2, boolean z, int i2) {
        ArrayList arrayList;
        int i3;
        int i4;
        int d2;
        if (d.a.o0.k1.o.k.a.e(this.f64939a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.f64939a) {
            if (obj instanceof AdvertAppInfo) {
                d.a.o0.k1.o.k.a.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<d.a.o0.e.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = d.a.o0.k1.o.k.a.k(list);
        int i5 = 0;
        int i6 = 0;
        for (d.a.o0.e.b.c cVar : list) {
            if (cVar.c() == 1) {
                i6++;
            }
        }
        int k2 = d.a.o0.k1.o.k.a.k(arrayList2);
        if (k2 < 1) {
            return;
        }
        int i7 = 9;
        if (d.a.o0.k1.o.k.a.k(arrayList2) > 1 && (d2 = (d.a.c.e.m.b.d(((AdvertAppInfo) d.a.o0.k1.o.k.a.d(arrayList2, 1)).P3, 0) - d.a.c.e.m.b.d(((AdvertAppInfo) d.a.o0.k1.o.k.a.d(arrayList2, 0)).P3, 0)) - 1) > 0) {
            i7 = d2;
        }
        int d3 = d.a.c.e.m.b.d(((AdvertAppInfo) d.a.o0.k1.o.k.a.d(arrayList2, 0)).P3, 0) - 1;
        int i8 = k - i6;
        HashSet hashSet = new HashSet();
        int i9 = 0;
        while (i9 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) d.a.o0.k1.o.k.a.d(arrayList2, i9);
            advertAppInfo.T3 = "SMART_FRS";
            int I4 = advertAppInfo.I4();
            if (I4 != 0) {
                d.a.o0.t2.i0.d.g(advertAppInfo, i2, I4);
                if (I4 != 28 && I4 != 31) {
                    advertAppInfo.L3 = -1001;
                }
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                d.a.o0.t2.i0.d.g(advertAppInfo, i2, 100);
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int d4 = d.a.c.e.m.b.d(advertAppInfo.P3, i5);
                int i10 = (d4 + i6) - 1;
                if (i10 < 0 || hashSet.contains(Integer.valueOf(i10)) || i10 > k) {
                    arrayList = arrayList2;
                    if (i10 > k) {
                        d.a.o0.t2.i0.d.h(advertAppInfo, i2, 2, i10, k);
                        i9++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else {
                        i3 = i10 < 0 ? 33 : 29;
                    }
                } else {
                    if (d4 <= (i8 - i7) + d3 || !z) {
                        arrayList = arrayList2;
                    } else if (!d.a.o0.k1.o.k.a.e(list2)) {
                        int k3 = d.a.o0.k1.o.k.a.k(list2);
                        int i11 = (i7 - ((i8 - d4) + 1)) - 1;
                        int i12 = 0;
                        while (i12 < k3 && i12 < i11) {
                            arrayList = arrayList2;
                            if (((d.a.o0.e.b.c) d.a.o0.k1.o.k.a.d(list2, i12)).a() instanceof AdvertAppInfo) {
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
                        if (d.a.o0.a.h().x()) {
                            i3 = 36;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    d.a.o0.t2.i0.d.g(advertAppInfo, i2, i3);
                    i9++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    d.a.o0.e.b.c cVar2 = new d.a.o0.e.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.F4()) {
                        if (y.q(advertAppInfo.b4) && d.a.o0.a.h().y()) {
                            d.a.o0.t2.i0.d.g(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.b4) && !TextUtils.isEmpty(advertAppInfo.W3)) {
                            hashSet.add(Integer.valueOf(i10));
                            if (i10 < k) {
                                d.a.o0.k1.o.k.a.b(list, cVar2, i10);
                            } else if (i10 == k) {
                                d.a.o0.k1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.H4()) {
                        hashSet.add(Integer.valueOf(i10));
                        if (i10 < k) {
                            d.a.o0.k1.o.k.a.b(list, cVar2, i10);
                        } else if (i10 == k) {
                            d.a.o0.k1.o.k.a.a(list, cVar2);
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
    @Override // d.a.o0.e.e.a
    /* renamed from: p */
    public void o(d.a.o0.e.e.c cVar) {
        this.f64940b = cVar;
        if (cVar == null || !(cVar.a() instanceof u)) {
            return;
        }
        this.f64941c = (u) this.f64940b.a();
        this.f64942d = new d.a.o0.t2.b0.c(this.f64941c, AdvertAppInfo.d4);
        this.f64943e = new d.a.o0.t2.b0.d(this.f64941c, AdvertAppInfo.g4);
        this.f64944f = new d.a.o0.t2.b0.d(this.f64941c, AdvertAppInfo.h4);
        this.f64945g = new d.a.o0.t2.b0.d(this.f64941c, AdvertAppInfo.i4);
        this.f64946h = new d.a.o0.t2.b0.d(this.f64941c, AdvertAppInfo.j4);
    }
}
