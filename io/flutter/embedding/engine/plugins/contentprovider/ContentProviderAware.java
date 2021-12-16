package io.flutter.embedding.engine.plugins.contentprovider;

import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public interface ContentProviderAware {
    void onAttachedToContentProvider(@NonNull ContentProviderPluginBinding contentProviderPluginBinding);

    void onDetachedFromContentProvider();
}
