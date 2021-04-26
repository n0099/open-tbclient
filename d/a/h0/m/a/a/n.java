package d.a.h0.m.a.a;

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
public class n {

    /* loaded from: classes3.dex */
    public static class a extends Transition.EpicenterCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Rect f47358a;

        public a(Rect rect) {
            this.f47358a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.f47358a;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f47359e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Transition f47360f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f47361g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f47362h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f47363i;
        public final /* synthetic */ Map j;
        public final /* synthetic */ ArrayList k;

        public b(View view, Transition transition, View view2, f fVar, Map map, Map map2, ArrayList arrayList) {
            this.f47359e = view;
            this.f47360f = transition;
            this.f47361g = view2;
            this.f47362h = fVar;
            this.f47363i = map;
            this.j = map2;
            this.k = arrayList;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f47359e.getViewTreeObserver().removeOnPreDrawListener(this);
            Transition transition = this.f47360f;
            if (transition != null) {
                transition.removeTarget(this.f47361g);
            }
            View view = this.f47362h.getView();
            if (view != null) {
                if (!this.f47363i.isEmpty()) {
                    n.m(this.j, view);
                    this.j.keySet().retainAll(this.f47363i.values());
                    for (Map.Entry entry : this.f47363i.entrySet()) {
                        View view2 = (View) this.j.get((String) entry.getValue());
                        if (view2 != null) {
                            view2.setTransitionName((String) entry.getKey());
                        }
                    }
                }
                if (this.f47360f != null) {
                    n.h(this.k, view);
                    this.k.removeAll(this.j.values());
                    this.k.add(this.f47361g);
                    n.c(this.f47360f, this.k);
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
        public Rect f47364a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f47365b;

        public c(e eVar) {
            this.f47365b = eVar;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            View view;
            if (this.f47364a == null && (view = this.f47365b.f47371a) != null) {
                this.f47364a = n.n(view);
            }
            return this.f47364a;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f47366e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Transition f47367f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f47368g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Transition f47369h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ArrayList f47370i;
        public final /* synthetic */ Transition j;
        public final /* synthetic */ ArrayList k;
        public final /* synthetic */ Map l;
        public final /* synthetic */ ArrayList m;
        public final /* synthetic */ Transition n;
        public final /* synthetic */ View o;

        public d(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
            this.f47366e = view;
            this.f47367f = transition;
            this.f47368g = arrayList;
            this.f47369h = transition2;
            this.f47370i = arrayList2;
            this.j = transition3;
            this.k = arrayList3;
            this.l = map;
            this.m = arrayList4;
            this.n = transition4;
            this.o = view2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f47366e.getViewTreeObserver().removeOnPreDrawListener(this);
            Transition transition = this.f47367f;
            if (transition != null) {
                n.s(transition, this.f47368g);
            }
            Transition transition2 = this.f47369h;
            if (transition2 != null) {
                n.s(transition2, this.f47370i);
            }
            Transition transition3 = this.j;
            if (transition3 != null) {
                n.s(transition3, this.k);
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
        public View f47371a;
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
