package com.heytap.mcssdk.callback;

import android.content.Context;
import com.heytap.mcssdk.mode.AppMessage;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.SptDataMessage;
/* loaded from: classes15.dex */
public interface MessageCallback {
    void processMessage(Context context, AppMessage appMessage);

    void processMessage(Context context, CommandMessage commandMessage);

    void processMessage(Context context, SptDataMessage sptDataMessage);
}
