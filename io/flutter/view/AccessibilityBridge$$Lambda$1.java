package io.flutter.view;

import io.flutter.util.Predicate;
import io.flutter.view.AccessibilityBridge;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final /* synthetic */ class AccessibilityBridge$$Lambda$1 implements Predicate {
    static final Predicate $instance = new AccessibilityBridge$$Lambda$1();

    private AccessibilityBridge$$Lambda$1() {
    }

    @Override // io.flutter.util.Predicate
    public boolean test(Object obj) {
        boolean hasFlag;
        hasFlag = ((AccessibilityBridge.SemanticsNode) obj).hasFlag(AccessibilityBridge.Flag.HAS_IMPLICIT_SCROLLING);
        return hasFlag;
    }
}
