package com.facebook.drawee.interfaces;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public interface SimpleDraweeControllerBuilder {
    DraweeController build();

    SimpleDraweeControllerBuilder setCallerContext(Object obj);

    SimpleDraweeControllerBuilder setOldController(@Nullable DraweeController draweeController);

    SimpleDraweeControllerBuilder setUri(Uri uri);

    SimpleDraweeControllerBuilder setUri(Uri uri, Map<String, String> map);

    SimpleDraweeControllerBuilder setUri(@Nullable String str);
}
