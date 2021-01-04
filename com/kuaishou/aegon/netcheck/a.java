package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: com.kuaishou.aegon.netcheck.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public enum EnumC1039a {
        RESULT_WEAK_SIGNAL(1),
        RESULT_BAD_WIFI_GATEWAY(2),
        RESULT_NOT_CONNECTED(3),
        RESULT_SLOW_INTERNET(4),
        RESULT_BAD_CELLULAR_GATEWAY(5);
        
        public int g;

        EnumC1039a(int i) {
            this.g = i;
        }

        public int a() {
            return this.g;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i);

        void a(EnumSet<EnumC1039a> enumSet, String str);
    }
}
