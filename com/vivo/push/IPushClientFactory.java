package com.vivo.push;

import android.content.Intent;
import com.vivo.push.c.z;
/* loaded from: classes7.dex */
public interface IPushClientFactory {
    z createReceiveTask(o oVar);

    o createReceiverCommand(Intent intent);

    l createTask(o oVar);
}
