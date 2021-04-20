package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kuaishou.aegon.netcheck.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public enum EnumC0368a {
        RESULT_WEAK_SIGNAL(1),
        RESULT_BAD_WIFI_GATEWAY(2),
        RESULT_NOT_CONNECTED(3),
        RESULT_SLOW_INTERNET(4),
        RESULT_BAD_CELLULAR_GATEWAY(5);
        

        /* renamed from: g  reason: collision with root package name */
        public int f31921g;

        EnumC0368a(int i) {
            this.f31921g = i;
        }

        public int a() {
            return this.f31921g;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(int i);

        void a(EnumSet<EnumC0368a> enumSet, String str);
    }
}
