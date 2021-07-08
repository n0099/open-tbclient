package com.yy.hiidostatis.inner.implementation;

import android.content.Context;
/* loaded from: classes6.dex */
public interface ITaskManager {
    void enableSend(boolean z);

    void flush(Context context);

    boolean send(Context context, String str, String str2);

    boolean send(Context context, String str, String str2, Long l);

    void sendTemporary(Context context, String str);
}
