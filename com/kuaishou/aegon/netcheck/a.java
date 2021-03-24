package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kuaishou.aegon.netcheck.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public enum EnumC0353a {
        RESULT_WEAK_SIGNAL(1),
        RESULT_BAD_WIFI_GATEWAY(2),
        RESULT_NOT_CONNECTED(3),
        RESULT_SLOW_INTERNET(4),
        RESULT_BAD_CELLULAR_GATEWAY(5);
        

        /* renamed from: g  reason: collision with root package name */
        public int f31631g;

        EnumC0353a(int i) {
            this.f31631g = i;
        }

        public int a() {
            return this.f31631g;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(int i);

        void a(EnumSet<EnumC0353a> enumSet, String str);
    }
}
