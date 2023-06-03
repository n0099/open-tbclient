package com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import androidx.annotation.Keep;
@Keep
/* loaded from: classes10.dex */
public class b {
    @Keep
    public static volatile b e;
    @Keep
    public static boolean f;
    @Keep
    public BroadcastReceiver h;
    @Keep
    public OpenId a = new OpenId("udid");
    @Keep
    public OpenId b = new OpenId("oaid");
    @Keep
    public OpenId d = new OpenId("vaid");
    @Keep
    public OpenId c = new OpenId("aaid");
    @Keep
    public SupportInfo g = new SupportInfo();

    @Keep
    public static native ValueData a(Cursor cursor);

    @Keep
    public static final native b a();

    @Keep
    public static native String a(PackageManager packageManager, String str);

    @Keep
    public static native void a(String str);

    @Keep
    public static native void a(boolean z);

    @Keep
    public static native boolean a(Context context);

    @Keep
    private native String b(Context context, OpenId openId);

    @Keep
    public static native String b(PackageManager packageManager, String str);

    @Keep
    private native synchronized void b(Context context);

    @Keep
    public final native String a(Context context, OpenId openId);

    @Keep
    public final native boolean a(Context context, boolean z);
}
