package com.qq.e.comm.net;

import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public interface NetworkClient {

    /* loaded from: classes6.dex */
    public enum Priority {
        High(1),
        Mid(2),
        Low(3);
        

        /* renamed from: a  reason: collision with root package name */
        public int f38637a;

        Priority(int i) {
            this.f38637a = i;
        }

        public final int value() {
            return this.f38637a;
        }
    }

    Future<Response> submit(Request request);

    Future<Response> submit(Request request, Priority priority);

    void submit(Request request, NetworkCallBack networkCallBack);

    void submit(Request request, Priority priority, NetworkCallBack networkCallBack);

    void submit(Request request, Priority priority, NetworkCallBack networkCallBack, Executor executor);
}
