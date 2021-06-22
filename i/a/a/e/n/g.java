package i.a.a.e.n;

import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.ThemeColorConfig;
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f72271a = new g();

    public final int a(PayUIKitConfig payUIKitConfig) {
        ThemeColorConfig themeColorConfig;
        if (payUIKitConfig != null && (themeColorConfig = payUIKitConfig.themeColorConfig) != null && themeColorConfig.getThemeResId() != null) {
            Integer themeResId = payUIKitConfig.themeColorConfig.getThemeResId();
            if (themeResId == null) {
                Intrinsics.throwNpe();
            }
            return themeResId.intValue();
        }
        return i.a.a.e.g.PayUi_Base_Theme;
    }

    public final boolean b(PayUIKitConfig payUIKitConfig) {
        ThemeColorConfig themeColorConfig;
        if (payUIKitConfig == null || (themeColorConfig = payUIKitConfig.themeColorConfig) == null) {
            return true;
        }
        Integer themeResId = themeColorConfig != null ? themeColorConfig.getThemeResId() : null;
        return themeResId != null && themeResId.intValue() == i.a.a.e.g.PayUi_Base_Theme;
    }
}
