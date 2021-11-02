package com.vivo.push;

import android.content.Intent;
import com.vivo.push.c.ab;
/* loaded from: classes2.dex */
public interface IPushClientFactory {
    ab createReceiveTask(y yVar);

    y createReceiverCommand(Intent intent);

    v createTask(y yVar);
}
