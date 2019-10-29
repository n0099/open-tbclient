package com.vivo.push;

import android.content.Intent;
/* loaded from: classes3.dex */
public interface IPushClientFactory {
    com.vivo.push.c.aa createReceiveTask(y yVar);

    y createReceiverCommand(Intent intent);

    v createTask(y yVar);
}
