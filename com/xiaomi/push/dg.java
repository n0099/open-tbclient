package com.xiaomi.push;

import android.util.Log;
import android.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes7.dex */
public class dg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ df f40361a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f232a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Throwable f233a;

    public dg(df dfVar, String str, Throwable th) {
        this.f40361a = dfVar;
        this.f232a = str;
        this.f233a = th;
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
        list = df.f229a;
        simpleDateFormat = df.f228a;
        str = this.f40361a.f40359b;
        list.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat.format(new Date()), str, this.f232a), this.f233a));
        list2 = df.f229a;
        if (list2.size() > 20000) {
            list3 = df.f229a;
            int size = (list3.size() - 20000) + 50;
            for (int i = 0; i < size; i++) {
                try {
                    list5 = df.f229a;
                    if (list5.size() > 0) {
                        list6 = df.f229a;
                        list6.remove(0);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            list4 = df.f229a;
            simpleDateFormat2 = df.f228a;
            str4 = this.f40361a.f40359b;
            list4.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat2.format(new Date()), str4, "flush " + size + " lines logs."), null));
        }
        try {
            if (aa.d()) {
                this.f40361a.m225a();
                return;
            }
            str3 = this.f40361a.f40359b;
            Log.w(str3, "SDCard is unavailable.");
        } catch (Exception e2) {
            str2 = this.f40361a.f40359b;
            Log.e(str2, "", e2);
        }
    }
}
