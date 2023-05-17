package com.vivo.push;

import android.content.Intent;
import com.vivo.push.f.aa;
/* loaded from: classes10.dex */
public interface IPushClientFactory {
    aa createReceiveTask(o oVar);

    o createReceiverCommand(Intent intent);

    l createTask(o oVar);
}
