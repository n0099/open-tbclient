package com.bytedance.sdk.openadsdk.e.a;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public interface k {

    /* loaded from: classes6.dex */
    public interface a {

        /* renamed from: com.bytedance.sdk.openadsdk.e.a.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public interface InterfaceC1030a {
        }

        void a(@NonNull String str, @NonNull InterfaceC1030a interfaceC1030a);

        void a(@NonNull String str, @NonNull String str2);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a(String str);

        boolean a(String str, String str2);
    }

    @NonNull
    a a();

    @NonNull
    Executor b();

    int c();
}
