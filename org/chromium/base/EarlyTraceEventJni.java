package org.chromium.base;

import org.chromium.base.EarlyTraceEvent;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
@MainDex
/* loaded from: classes2.dex */
public final class EarlyTraceEventJni implements EarlyTraceEvent.Natives {
    public static final JniStaticTestMocker<EarlyTraceEvent.Natives> TEST_HOOKS = new JniStaticTestMocker<EarlyTraceEvent.Natives>() { // from class: org.chromium.base.EarlyTraceEventJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(EarlyTraceEvent.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                EarlyTraceEvent.Natives unused = EarlyTraceEventJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static EarlyTraceEvent.Natives testInstance;

    public static EarlyTraceEvent.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            EarlyTraceEvent.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.EarlyTraceEvent.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new EarlyTraceEventJni();
    }

    @Override // org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyAsyncBeginEvent(String str, long j, long j2) {
        GEN_JNI.org_chromium_base_EarlyTraceEvent_recordEarlyAsyncBeginEvent(str, j, j2);
    }

    @Override // org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyAsyncEndEvent(String str, long j, long j2) {
        GEN_JNI.org_chromium_base_EarlyTraceEvent_recordEarlyAsyncEndEvent(str, j, j2);
    }

    @Override // org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyBeginEvent(String str, long j, int i, long j2) {
        GEN_JNI.org_chromium_base_EarlyTraceEvent_recordEarlyBeginEvent(str, j, i, j2);
    }

    @Override // org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyEndEvent(String str, long j, int i, long j2) {
        GEN_JNI.org_chromium_base_EarlyTraceEvent_recordEarlyEndEvent(str, j, i, j2);
    }

    @Override // org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyToplevelBeginEvent(String str, long j, int i, long j2) {
        GEN_JNI.org_chromium_base_EarlyTraceEvent_recordEarlyToplevelBeginEvent(str, j, i, j2);
    }

    @Override // org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyToplevelEndEvent(String str, long j, int i, long j2) {
        GEN_JNI.org_chromium_base_EarlyTraceEvent_recordEarlyToplevelEndEvent(str, j, i, j2);
    }
}
