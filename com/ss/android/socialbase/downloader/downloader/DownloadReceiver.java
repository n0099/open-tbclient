package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;
/* loaded from: classes8.dex */
public class DownloadReceiver extends BroadcastReceiver {
    public static final String a = DownloadReceiver.class.getSimpleName();

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0000, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String DownloadReceiver1654612903256dc(String str) {
        while (true) {
            char c = 'I';
            char c2 = '`';
            while (true) {
                switch (c) {
                    case 'H':
                        c = 'J';
                        c2 = '7';
                    case 'I':
                        switch (c2) {
                            case '_':
                            case '`':
                                c = 'J';
                                c2 = '7';
                        }
                        break;
                    case 'J':
                        break;
                    default:
                        c = 'H';
                }
                switch (c2) {
                    case '7':
                        char[] charArray = str.toCharArray();
                        for (int i = 0; i < charArray.length; i++) {
                            charArray[i] = (char) (charArray[i] ^ i);
                        }
                        return new String(charArray);
                }
            }
        }
    }

    private void a(final Context context, final String str) {
        if (c.G()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, DownloadNotificationService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, 2000L);
        }
    }

    private void b(Context context, String str) {
        try {
            Intent intent = new Intent(context, DownloadNotificationService.class);
            intent.setAction(str);
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.a(a, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
            }
            a(context, action);
        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
            b(context, action);
        }
    }
}
