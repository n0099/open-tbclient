package org.chromium.base;

import org.chromium.base.CommandLine;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
@MainDex
/* loaded from: classes2.dex */
public final class CommandLineJni implements CommandLine.Natives {
    public static final JniStaticTestMocker<CommandLine.Natives> TEST_HOOKS = new JniStaticTestMocker<CommandLine.Natives>() { // from class: org.chromium.base.CommandLineJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(CommandLine.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                CommandLine.Natives unused = CommandLineJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static CommandLine.Natives testInstance;

    public static CommandLine.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            CommandLine.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.CommandLine.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new CommandLineJni();
    }

    @Override // org.chromium.base.CommandLine.Natives
    public String[] getSwitchesFlattened() {
        return GEN_JNI.org_chromium_base_CommandLine_getSwitchesFlattened();
    }

    @Override // org.chromium.base.CommandLine.Natives
    public void appendSwitch(String str) {
        GEN_JNI.org_chromium_base_CommandLine_appendSwitch(str);
    }

    @Override // org.chromium.base.CommandLine.Natives
    public void appendSwitchesAndArguments(String[] strArr) {
        GEN_JNI.org_chromium_base_CommandLine_appendSwitchesAndArguments(strArr);
    }

    @Override // org.chromium.base.CommandLine.Natives
    public String getSwitchValue(String str) {
        return GEN_JNI.org_chromium_base_CommandLine_getSwitchValue(str);
    }

    @Override // org.chromium.base.CommandLine.Natives
    public boolean hasSwitch(String str) {
        return GEN_JNI.org_chromium_base_CommandLine_hasSwitch(str);
    }

    @Override // org.chromium.base.CommandLine.Natives
    public void init(String[] strArr) {
        GEN_JNI.org_chromium_base_CommandLine_init(strArr);
    }

    @Override // org.chromium.base.CommandLine.Natives
    public void removeSwitch(String str) {
        GEN_JNI.org_chromium_base_CommandLine_removeSwitch(str);
    }

    @Override // org.chromium.base.CommandLine.Natives
    public void appendSwitchWithValue(String str, String str2) {
        GEN_JNI.org_chromium_base_CommandLine_appendSwitchWithValue(str, str2);
    }
}
