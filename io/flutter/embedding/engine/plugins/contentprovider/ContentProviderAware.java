package io.flutter.embedding.engine.plugins.contentprovider;

import androidx.annotation.NonNull;
/* loaded from: classes19.dex */
public interface ContentProviderAware {
    void onAttachedToContentProvider(@NonNull ContentProviderPluginBinding contentProviderPluginBinding);

    void onDetachedFromContentProvider();
}
