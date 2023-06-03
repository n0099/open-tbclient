package org.chromium.base;

import org.chromium.base.TraceEvent;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
@MainDex
/* loaded from: classes2.dex */
public final class TraceEventJni implements TraceEvent.Natives {
    public static final JniStaticTestMocker<TraceEvent.Natives> TEST_HOOKS = new JniStaticTestMocker<TraceEvent.Natives>() { // from class: org.chromium.base.TraceEventJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(TraceEvent.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                TraceEvent.Natives unused = TraceEventJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static TraceEvent.Natives testInstance;

    public static TraceEvent.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            TraceEvent.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.TraceEvent.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new TraceEventJni();
    }

    @Override // org.chromium.base.TraceEvent.Natives
    public void registerEnabledObserver() {
        GEN_JNI.org_chromium_base_TraceEvent_registerEnabledObserver();
    }

    @Override // org.chromium.base.TraceEvent.Natives
    public void stopATrace() {
        GEN_JNI.org_chromium_base_TraceEvent_stopATrace();
    }

    @Override // org.chromium.base.TraceEvent.Natives
    public void beginToplevel(String str) {
        GEN_JNI.org_chromium_base_TraceEvent_beginToplevel(str);
    }

    @Override // org.chromium.base.TraceEvent.Natives
    public void endToplevel(String str) {
        GEN_JNI.org_chromium_base_TraceEvent_endToplevel(str);
    }

    @Override // org.chromium.base.TraceEvent.Natives
    public void setupATraceStartupTrace(String str) {
        GEN_JNI.org_chromium_base_TraceEvent_setupATraceStartupTrace(str);
    }

    @Override // org.chromium.base.TraceEvent.Natives
    public void startATrace(String str) {
        GEN_JNI.org_chromium_base_TraceEvent_startATrace(str);
    }

    @Override // org.chromium.base.TraceEvent.Natives
    public void begin(String str, String str2) {
        GEN_JNI.org_chromium_base_TraceEvent_begin(str, str2);
    }

    @Override // org.chromium.base.TraceEvent.Natives
    public void end(String str, String str2) {
        GEN_JNI.org_chromium_base_TraceEvent_end(str, str2);
    }

    @Override // org.chromium.base.TraceEvent.Natives
    public void finishAsync(String str, long j) {
        GEN_JNI.org_chromium_base_TraceEvent_finishAsync(str, j);
    }

    @Override // org.chromium.base.TraceEvent.Natives
    public void instant(String str, String str2) {
        GEN_JNI.org_chromium_base_TraceEvent_instant(str, str2);
    }

    @Override // org.chromium.base.TraceEvent.Natives
    public void startAsync(String str, long j) {
        GEN_JNI.org_chromium_base_TraceEvent_startAsync(str, j);
    }
}
