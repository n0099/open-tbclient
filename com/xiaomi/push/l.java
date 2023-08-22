package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes10.dex */
public class l {
    public static volatile Handler a;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f821a = new Object();
    public static volatile Handler b;

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return a(context, broadcastReceiver, intentFilter, null);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str) {
        if (context == null || broadcastReceiver == null || intentFilter == null) {
            return null;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, str, b());
    }

    public static Handler a() {
        if (b == null) {
            synchronized (f821a) {
                if (b == null) {
                    HandlerThread handlerThread = new HandlerThread("receiver_task");
                    handlerThread.start();
                    b = new Handler(handlerThread.getLooper());
                }
            }
        }
        return b;
    }

    public static void a(Context context, ComponentName componentName) {
        b().post(new m(context, componentName));
    }

    public static void a(Context context, Class<?> cls) {
        if (context == null || cls == null) {
            return;
        }
        a(context, new ComponentName(context, cls));
    }

    public static Handler b() {
        if (a == null) {
            synchronized (l.class) {
                if (a == null) {
                    HandlerThread handlerThread = new HandlerThread("handle_receiver");
                    handlerThread.start();
                    a = new Handler(handlerThread.getLooper());
                }
            }
        }
        return a;
    }
}
