package io.flutter.embedding.engine.plugins.broadcastreceiver;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public interface BroadcastReceiverAware {
    void onAttachedToBroadcastReceiver(@NonNull BroadcastReceiverPluginBinding broadcastReceiverPluginBinding);

    void onDetachedFromBroadcastReceiver();
}
