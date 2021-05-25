package d.a.l0.a.c0.d;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import d.a.l0.a.e0.d;
import d.a.l0.a.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f40910d = k.f43199a;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.w2.g.a f40911a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ArrayMap<String, d.a.l0.a.c0.b.a> f40912b = new ArrayMap<>();
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public ArrayMap<String, List<d.a.l0.a.c0.b.a>> f40913c = new ArrayMap<>();

    public c(@NonNull d.a.l0.a.w2.g.a aVar) {
        this.f40911a = aVar;
    }

    @Nullable
    public SwanAppComponentContainerView a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d.a.l0.a.c0.b.a aVar = this.f40912b.get(str);
        if (aVar == null) {
            d.b("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.m();
    }

    @UiThread
    public boolean b(d.a.l0.a.c0.b.a aVar) {
        boolean b2;
        if (aVar == null) {
            d.a.l0.a.c0.g.a.a("Component-Container", "insert component with a null component");
            return false;
        }
        d.a.l0.a.c0.b.b n = aVar.n();
        String str = n.f40844e;
        String str2 = n.f40845f;
        String o = aVar.o();
        SwanAppComponentContainerView m = aVar.m();
        if (m == null) {
            d.a.l0.a.c0.g.a.a("Component-Container", "insert " + o + " with a null container view");
            return false;
        }
        if (this.f40912b.containsKey(str2)) {
            d.l("Component-Container", o + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            d.a.l0.a.c0.g.a.a("Component-Container", "insert " + o + " with a empty component id");
            return false;
        }
        d.a.l0.a.l1.e.a.a aVar2 = n.l;
        if (aVar2 == null) {
            d.a.l0.a.c0.g.a.a("Component-Container", "insert " + o + " with a null position");
            return false;
        }
        if (!aVar2.i()) {
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = n.l;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            d.a.l0.a.c0.g.a.a("Component-Container", sb.toString());
            n.l = new d.a.l0.a.l1.e.a.a();
        }
        if (!b.c(n)) {
            if (TextUtils.isEmpty(n.f40847h)) {
                b2 = this.f40911a.c(m, n.l);
            } else {
                SwanAppComponentContainerView a2 = a(n.f40847h);
                if (a2 == null) {
                    d.b("Component-Container", "insert " + o + " to parent with a null parent container view");
                    return false;
                }
                if (a2.indexOfChild(m) >= 0) {
                    d.a.l0.a.c0.g.a.a("Component-Container", o + " repeat insert view!");
                    a2.removeView(m);
                }
                a2.addView(m, n.b());
                b2 = true;
            }
        } else {
            b2 = b.b(this, n, m);
            if (!b2) {
                d.a.l0.a.c0.g.a.a("Component-Container", o + " insertComponentForScroll fail");
            }
        }
        if (b2) {
            this.f40912b.put(n.f40845f, aVar);
            if (aVar.s(2)) {
                d.l("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                List<d.a.l0.a.c0.b.a> list = this.f40913c.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f40913c.put(str, list);
                }
                list.add(aVar);
            }
        }
        return b2;
    }

    public void c() {
        d.a.l0.a.c0.b.a value;
        if (f40910d) {
            Log.d("Component-Container", "container destroy");
        }
        for (Map.Entry<String, d.a.l0.a.c0.b.a> entry : this.f40912b.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.z();
            }
        }
        this.f40912b.clear();
        this.f40913c.clear();
    }

    public final boolean d(@NonNull d.a.l0.a.c0.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull d.a.l0.a.c0.b.b bVar) {
        String o = aVar.o();
        if (f40910d) {
            Log.d("Component-Container", o + " perform position update");
        }
        d.a.l0.a.l1.e.a.a aVar2 = bVar.l;
        if (aVar2 != null && aVar2.i()) {
            if (b.c(bVar) && !b.e(this, bVar, swanAppComponentContainerView)) {
                d.a.l0.a.c0.g.a.a("Component-Container", o + " performPositionUpdateForScroll fail");
            }
            String str = bVar.f40847h;
            if (TextUtils.isEmpty(str)) {
                return this.f40911a.a(swanAppComponentContainerView, bVar.l);
            }
            SwanAppComponentContainerView a2 = a(str);
            if (a2 == null) {
                d.b("Component-Container", "update " + o + " to parent with a null parent container view");
                return false;
            } else if (swanAppComponentContainerView.getParent() == a2) {
                a2.updateViewLayout(swanAppComponentContainerView, bVar.b());
                return true;
            } else {
                d.a.l0.a.c0.g.a.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                return false;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("insert ");
        sb.append(o);
        sb.append(" with a invalid position: ");
        Object obj = bVar.l;
        if (obj == null) {
            obj = StringUtil.NULL_STRING;
        }
        sb.append(obj);
        d.a.l0.a.c0.g.a.a("Component-Container", sb.toString());
        return false;
    }

    @UiThread
    public boolean e(d.a.l0.a.c0.b.a aVar) {
        boolean z = false;
        if (aVar == null) {
            d.a.l0.a.c0.g.a.a("Component-Container", "remove component with a null component");
            return false;
        }
        d.a.l0.a.c0.b.b n = aVar.n();
        String str = n.f40844e;
        String str2 = n.f40845f;
        String o = aVar.o();
        SwanAppComponentContainerView m = aVar.m();
        if (m == null) {
            d.a.l0.a.c0.g.a.a("Component-Container", "remove " + o + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            d.a.l0.a.c0.g.a.a("Component-Container", "remove " + o + " with a empty component id");
            return false;
        } else {
            if (!b.c(n)) {
                if (TextUtils.isEmpty(n.f40847h)) {
                    z = this.f40911a.removeView(m);
                } else {
                    SwanAppComponentContainerView a2 = a(n.f40847h);
                    if (a2 == null) {
                        d.b("Component-Container", "remove " + o + " to parent with a null parent container view");
                    } else if (a2 == m.getParent()) {
                        a2.removeView(m);
                        z = true;
                    } else {
                        d.a.l0.a.c0.g.a.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                    }
                }
            } else {
                z = b.g(this, n, m);
                if (!z) {
                    d.a.l0.a.c0.g.a.a("Component-Container", o + " removeComponentForScroll fail");
                }
            }
            if (z || aVar.s(1)) {
                this.f40912b.remove(str2);
                if (aVar.s(2)) {
                    d.l("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<d.a.l0.a.c0.b.a> list = this.f40913c.get(str);
                    if (list != null) {
                        list.remove(aVar);
                    }
                }
            }
            return z;
        }
    }

    @UiThread
    public boolean f(d.a.l0.a.c0.b.a aVar, @NonNull d.a.l0.a.c0.f.b bVar) {
        if (aVar == null) {
            d.a.l0.a.c0.g.a.a("Component-Container", "update component with a null component");
            return false;
        }
        d.a.l0.a.c0.b.b n = aVar.n();
        String o = aVar.o();
        SwanAppComponentContainerView m = aVar.m();
        if (m == null) {
            d.a.l0.a.c0.g.a.a("Component-Container", "update " + o + " with a null container view");
            return false;
        }
        if (!this.f40912b.containsKey(n.f40845f)) {
            d.b("Component-Container", "don't insert" + o);
        }
        if (aVar instanceof d.a.l0.a.c0.c.e.c.a) {
            if (bVar.a(7)) {
                boolean d2 = b.d(this, aVar, n, m, bVar);
                if (!d2) {
                    d.a.l0.a.c0.g.a.a("Component-Container", o + " perform scroll type update fail");
                }
                return d2;
            } else if (bVar.a(8)) {
                b.f(this, aVar, n, m, bVar);
            }
        }
        if (bVar.a(3) && !d(aVar, m, n)) {
            d.b("Component-Container", o + " perform position update fail");
            return false;
        } else if (aVar instanceof d.a.l0.a.c0.a.d.a) {
            d.a.l0.a.c0.a.d.a aVar2 = (d.a.l0.a.c0.a.d.a) aVar;
            if (aVar2.L()) {
                if (f40910d) {
                    Log.d("Component-Container", o + "perform position update with animation");
                }
                if (aVar2.O()) {
                    return true;
                }
                d.b("Component-Container", o + " perform position update with animation fail");
                return false;
            }
            return true;
        } else {
            return true;
        }
    }
}
