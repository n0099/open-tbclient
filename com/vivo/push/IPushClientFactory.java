package com.vivo.push;

import android.content.Intent;
import com.vivo.push.c.aa;
/* loaded from: classes3.dex */
public interface IPushClientFactory {
    aa createReceiveTask(v vVar);

    v createReceiverCommand(Intent intent);

    s createTask(v vVar);
}
