package com.qq.e.comm.plugin.t;

import java.util.concurrent.Future;
/* loaded from: classes15.dex */
public interface c {

    /* loaded from: classes15.dex */
    public enum a {
        High(1),
        Mid(2),
        Low(3);
        
        private int d;

        a(int i) {
            this.d = i;
        }

        public int a() {
            return this.d;
        }
    }

    Future<com.qq.e.comm.plugin.t.b.f> a(com.qq.e.comm.plugin.t.b.e eVar);

    Future<com.qq.e.comm.plugin.t.b.f> a(com.qq.e.comm.plugin.t.b.e eVar, a aVar);

    void a(com.qq.e.comm.plugin.t.b.e eVar, a aVar, b bVar);
}
