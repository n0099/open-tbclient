package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kuaishou.aegon.netcheck.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public enum EnumC0357a {
        RESULT_WEAK_SIGNAL(1),
        RESULT_BAD_WIFI_GATEWAY(2),
        RESULT_NOT_CONNECTED(3),
        RESULT_SLOW_INTERNET(4),
        RESULT_BAD_CELLULAR_GATEWAY(5);
        

        /* renamed from: g  reason: collision with root package name */
        public int f32271g;

        EnumC0357a(int i2) {
            this.f32271g = i2;
        }

        public int a() {
            return this.f32271g;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(int i2);

        void a(EnumSet<EnumC0357a> enumSet, String str);
    }
}
