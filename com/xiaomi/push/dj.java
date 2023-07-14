package com.xiaomi.push;

import android.util.Log;
import android.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes10.dex */
public class dj implements Runnable {
    public final /* synthetic */ di a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f228a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Throwable f229a;

    public dj(di diVar, String str, Throwable th) {
        this.a = diVar;
        this.f228a = str;
        this.f229a = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        SimpleDateFormat simpleDateFormat;
        String str;
        List list2;
        String str2;
        String str3;
        List list3;
        List list4;
        SimpleDateFormat simpleDateFormat2;
        String str4;
        List list5;
        List list6;
        list = di.f225a;
        simpleDateFormat = di.f224a;
        str = this.a.b;
        list.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat.format(new Date()), str, this.f228a), this.f229a));
        list2 = di.f225a;
        if (list2.size() > 20000) {
            list3 = di.f225a;
            int size = (list3.size() - 20000) + 50;
            for (int i = 0; i < size; i++) {
                try {
                    list5 = di.f225a;
                    if (list5.size() > 0) {
                        list6 = di.f225a;
                        list6.remove(0);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            list4 = di.f225a;
            simpleDateFormat2 = di.f224a;
            str4 = this.a.b;
            list4.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat2.format(new Date()), str4, "flush " + size + " lines logs."), null));
        }
        try {
            if (aa.d()) {
                this.a.m358a();
                return;
            }
            str3 = this.a.b;
            Log.w(str3, "SDCard is unavailable.");
        } catch (Exception e) {
            str2 = this.a.b;
            Log.e(str2, "", e);
        }
    }
}
