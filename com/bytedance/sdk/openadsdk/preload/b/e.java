package com.bytedance.sdk.openadsdk.preload.b;
/* loaded from: classes5.dex */
public interface e {

    /* loaded from: classes5.dex */
    public static class a implements e {
        @Override // com.bytedance.sdk.openadsdk.preload.b.e
        public <T> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    <T> T a(Class<T> cls);
}
