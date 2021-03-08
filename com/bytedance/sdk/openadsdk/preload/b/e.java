package com.bytedance.sdk.openadsdk.preload.b;
/* loaded from: classes6.dex */
public interface e {
    <T> T a(Class<T> cls);

    /* loaded from: classes6.dex */
    public static class a implements e {
        @Override // com.bytedance.sdk.openadsdk.preload.b.e
        public <T> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
