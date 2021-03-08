package com.pgl.sys.ces.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static a qbt = null;

    /* renamed from: a  reason: collision with root package name */
    private Context f7483a;
    private List<String> b = new ArrayList();

    private a(Context context) {
        this.f7483a = null;
        this.f7483a = context;
    }

    public static a iv(Context context) {
        if (qbt == null) {
            synchronized (a.class) {
                if (qbt == null) {
                    qbt = new a(context);
                }
            }
        }
        return qbt;
    }

    public int a() {
        Intent registerReceiver = this.f7483a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return -1;
        }
        return Math.round(((registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1)) * 100.0f) * 10.0f) / 10;
    }

    public int b() {
        Intent registerReceiver = this.f7483a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return -1;
        }
        return registerReceiver.getIntExtra("plugged", -1);
    }

    @SuppressLint({"DefaultLocale"})
    public String c() {
        int i;
        int i2;
        try {
            try {
                try {
                    synchronized (this) {
                        try {
                            i2 = b();
                            try {
                                return "" + (a() + (i2 * 10000));
                            } catch (Throwable th) {
                                th = th;
                                i = -1;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            i = -1;
                            i2 = -1;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    i = -1;
                    i2 = -1;
                    String str = "" + (i + (i2 * 10000));
                    throw th;
                }
            } catch (Exception e) {
                return "-10001";
            }
        } catch (Throwable th4) {
            th = th4;
        }
        try {
            throw th;
        } catch (Throwable th5) {
            th = th5;
            String str2 = "" + (i + (i2 * 10000));
            throw th;
        }
    }

    public void d() {
        String c = c();
        if (c == null) {
            return;
        }
        this.b.add(c);
        try {
            int size = this.b.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.b.subList(size - 10, size));
                this.b.clear();
                this.b = arrayList;
            }
        } catch (Throwable th) {
        }
    }

    public synchronized String e() {
        String str;
        List<String> subList;
        synchronized (this) {
            str = "";
            int size = this.b.size();
            if (size > 0) {
                if (size == 1) {
                    str = this.b.get(0);
                } else {
                    try {
                        String str2 = "";
                        for (int i = 0; i < this.b.subList(size + (-10) > 0 ? size - 10 : 0, size).size(); i++) {
                            try {
                                str2 = str2 + subList.get(i) + ",";
                            } catch (Throwable th) {
                                str = str2;
                            }
                        }
                        str = str2.substring(0, str2.length() - 1);
                    } catch (Throwable th2) {
                    }
                }
            }
        }
        return str;
    }
}
