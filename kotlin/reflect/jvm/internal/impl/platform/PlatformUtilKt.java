package kotlin.reflect.jvm.internal.impl.platform;

import kotlin.collections.CollectionsKt___CollectionsKt;
/* loaded from: classes2.dex */
public final class PlatformUtilKt {
    public static final String getPresentableDescription(TargetPlatform targetPlatform) {
        return CollectionsKt___CollectionsKt.joinToString$default(targetPlatform.getComponentPlatforms(), "/", null, null, 0, null, null, 62, null);
    }
}
