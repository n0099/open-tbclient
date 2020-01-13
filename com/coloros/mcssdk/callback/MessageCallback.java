package com.coloros.mcssdk.callback;

import android.content.Context;
import com.coloros.mcssdk.mode.AppMessage;
import com.coloros.mcssdk.mode.CommandMessage;
import com.coloros.mcssdk.mode.SptDataMessage;
/* loaded from: classes6.dex */
public interface MessageCallback {
    void processMessage(Context context, AppMessage appMessage);

    void processMessage(Context context, CommandMessage commandMessage);

    void processMessage(Context context, SptDataMessage sptDataMessage);
}
