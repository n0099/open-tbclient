package defpackage;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bb  reason: default package */
/* loaded from: classes.dex */
public class bb {
    private static final Handler a = new bd(null);

    public static void a(Runnable runnable) {
        Message message = new Message();
        message.what = LocationClientOption.MIN_SCAN_SPAN;
        message.obj = runnable;
        a.sendMessageDelayed(message, 16L);
    }
}
