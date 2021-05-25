package d.a.l0.o.a.a;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class o {

    /* loaded from: classes3.dex */
    public static class a extends Transition.EpicenterCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Rect f48252a;

        public a(Rect rect) {
            this.f48252a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.f48252a;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f48253e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Transition f48254f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f48255g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f48256h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f48257i;
        public final /* synthetic */ Map j;
        public final /* synthetic */ ArrayList k;

        public b(View view, Transition transition, View view2, f fVar, Map map, Map map2, ArrayList arrayList) {
            this.f48253e = view;
            this.f48254f = transition;
            this.f48255g = view2;
            this.f48256h = fVar;
            this.f48257i = map;
            this.j = map2;
            this.k = arrayList;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f48253e.getViewTreeObserver().removeOnPreDrawListener(this);
            Transition transition = this.f48254f;
            if (transition != null) {
                transition.removeTarget(this.f48255g);
            }
            View view = this.f48256h.getView();
            if (view != null) {
                if (!this.f48257i.isEmpty()) {
                    o.m(this.j, view);
                    this.j.keySet().retainAll(this.f48257i.values());
                    for (Map.Entry entry : this.f48257i.entrySet()) {
                        View view2 = (View) this.j.get((String) entry.getValue());
                        if (view2 != null) {
                            view2.setTransitionName((String) entry.getKey());
                        }
                    }
                }
                if (this.f48254f != null) {
                    o.h(this.k, view);
                    this.k.removeAll(this.j.values());
                    this.k.add(this.f48255g);
                    o.c(this.f48254f, this.k);
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends Transition.EpicenterCallback {

        /* renamed from: a  reason: collision with root package name */
        public Rect f48258a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f48259b;

        public c(e eVar) {
            this.f48259b = eVar;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            View view;
            if (this.f48258a == null && (view = this.f48259b.f48265a) != null) {
                this.f48258a = o.n(view);
            }
            return this.f48258a;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f48260e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Transition f48261f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f48262g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Transition f48263h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ArrayList f48264i;
        public final /* synthetic */ Transition j;
        public final /* synthetic */ ArrayList k;
        public final /* synthetic */ Map l;
        public final /* synthetic */ ArrayList m;
        public final /* synthetic */ Transition n;
        public final /* synthetic */ View o;

        public d(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
            this.f48260e = view;
            this.f48261f = transition;
            this.f48262g = arrayList;
            this.f48263h = transition2;
            this.f48264i = arrayList2;
            this.j = transition3;
            this.k = arrayList3;
            this.l = map;
            this.m = arrayList4;
            this.n = transition4;
            this.o = view2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f48260e.getViewTreeObserver().removeOnPreDrawListener(this);
            Transition transition = this.f48261f;
            if (transition != null) {
                o.s(transition, this.f48262g);
            }
            Transition transition2 = this.f48263h;
            if (transition2 != null) {
                o.s(transition2, this.f48264i);
            }
            Transition transition3 = this.j;
            if (transition3 != null) {
                o.s(transition3, this.k);
            }
            for (Map.Entry entry : this.l.entrySet()) {
                ((View) entry.getValue()).setTransitionName((String) entry.getKey());
            }
            int size = this.m.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.n.excludeTarget((View) this.m.get(i2), false);
            }
            this.n.excludeTarget(this.o, false);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public View f48265a;
    }

    /* loaded from: classes3.dex */
    public interface f {
        View getView();
    }

    public static void c(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i2 < transitionCount) {
                c(transitionSet.getTransitionAt(i2), arrayList);
                i2++;
            }
        } else if (p(transition) || !q(transition.getTargets())) {
        } else {
            int size = arrayList.size();
            while (i2 < size) {
                transition.addTarget(arrayList.get(i2));
                i2++;
            }
        }
    }

    public static void d(Object obj, Object obj2, View view, f fVar, View view2, e eVar, Map<String, String> map, ArrayList<View> arrayList, Map<String, View> map2, Map<String, View> map3, ArrayList<View> arrayList2) {
        if (obj == null && obj2 == null) {
            return;
        }
        Transition transition = (Transition) obj;
        if (transition != null) {
            transition.addTarget(view2);
        }
        if (obj2 != null) {
            v(obj2, view2, map2, arrayList2);
        }
        if (fVar != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new b(view, transition, view2, fVar, map, map3, arrayList));
        }
        u(transition, eVar);
    }

    public static void e(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static void f(List<View> list, View view) {
        int size = list.size();
        if (k(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i2 = size; i2 < list.size(); i2++) {
            View view2 = list.get(i2);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    if (!k(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    public static Object g(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map, View view2) {
        if (obj != null) {
            h(arrayList, view);
            if (map != null) {
                arrayList.removeAll(map.values());
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            arrayList.add(view2);
            c((Transition) obj, arrayList);
            return obj;
        }
        return obj;
    }

    public static void h(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.isTransitionGroup()) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    h(arrayList, viewGroup.getChildAt(i2));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    public static void i(View view, View view2, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        Transition transition4 = (Transition) obj4;
        if (transition4 != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new d(view, transition, arrayList, transition2, arrayList2, transition3, arrayList3, map, arrayList4, transition4, view2));
        }
    }

    public static Object j(Object obj) {
        return obj != null ? ((Transition) obj).clone() : obj;
    }

    public static boolean k(List<View> list, View view, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (list.get(i3) == view) {
                return true;
            }
        }
        return false;
    }

    public static void l(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void m(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    m(map, viewGroup.getChildAt(i2));
                }
            }
        }
    }

    public static Rect n(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }

    public static String o(View view) {
        return view.getTransitionName();
    }

    public static boolean p(Transition transition) {
        return (q(transition.getTargetIds()) && q(transition.getTargetNames()) && q(transition.getTargetTypes())) ? false : true;
    }

    public static boolean q(List list) {
        return list == null || list.isEmpty();
    }

    public static Object r(Object obj, Object obj2, Object obj3, boolean z) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if ((transition == null || transition2 == null) ? true : true) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 != null) {
                transitionSet.addTransition(transition3);
                return transitionSet;
            }
            return transitionSet;
        }
        if (transition2 != null && transition != null) {
            transition = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
        } else if (transition2 != null) {
            transition = transition2;
        } else if (transition == null) {
            transition = null;
        }
        if (transition3 != null) {
            TransitionSet transitionSet2 = new TransitionSet();
            if (transition != null) {
                transitionSet2.addTransition(transition);
            }
            transitionSet2.addTransition(transition3);
            return transitionSet2;
        }
        return transition;
    }

    public static void s(Object obj, ArrayList<View> arrayList) {
        List<View> targets;
        Transition transition = (Transition) obj;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            for (int i2 = 0; i2 < transitionCount; i2++) {
                s(transitionSet.getTransitionAt(i2), arrayList);
            }
        } else if (!p(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                transition.removeTarget(arrayList.get(size));
            }
        }
    }

    public static void t(Object obj, View view) {
        ((Transition) obj).setEpicenterCallback(new a(n(view)));
    }

    public static void u(Transition transition, e eVar) {
        if (transition != null) {
            transition.setEpicenterCallback(new c(eVar));
        }
    }

    public static void v(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        arrayList.clear();
        arrayList.addAll(map.values());
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            f(targets, arrayList.get(i2));
        }
        arrayList.add(view);
        c(transitionSet, arrayList);
    }

    public static Object w(Object obj) {
        Transition transition;
        if (obj == null || (transition = (Transition) obj) == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(transition);
        return transitionSet;
    }
}
