package f.a.d;

import io.flutter.util.Predicate;
import io.flutter.view.AccessibilityBridge;
/* compiled from: lambda */
/* loaded from: classes7.dex */
public final /* synthetic */ class b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ b f68234a = new b();

    private /* synthetic */ b() {
    }

    @Override // io.flutter.util.Predicate
    public final boolean test(Object obj) {
        boolean hasFlag;
        hasFlag = ((AccessibilityBridge.SemanticsNode) obj).hasFlag(AccessibilityBridge.Flag.HAS_IMPLICIT_SCROLLING);
        return hasFlag;
    }
}
