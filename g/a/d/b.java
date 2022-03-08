package g.a.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.util.Predicate;
import io.flutter.view.AccessibilityBridge;
/* compiled from: lambda */
/* loaded from: classes8.dex */
public final /* synthetic */ class b implements Predicate {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ b a = new b();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ b() {
    }

    @Override // io.flutter.util.Predicate
    public final boolean test(Object obj) {
        InterceptResult invokeL;
        boolean hasFlag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            hasFlag = ((AccessibilityBridge.SemanticsNode) obj).hasFlag(AccessibilityBridge.Flag.HAS_IMPLICIT_SCROLLING);
            return hasFlag;
        }
        return invokeL.booleanValue;
    }
}
