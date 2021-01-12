package com.google.ar.core;

import android.content.Context;
import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes5.dex */
public class ArCoreApk {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes5.dex */
    public static class Availability {
        final int nativeCode;
        public static final Availability UNKNOWN_ERROR = new com.google.ar.core.a("UNKNOWN_ERROR", 0, 0);
        public static final Availability UNKNOWN_CHECKING = new b("UNKNOWN_CHECKING", 1, 1);
        public static final Availability UNKNOWN_TIMED_OUT = new c("UNKNOWN_TIMED_OUT", 2, 2);
        public static final Availability UNSUPPORTED_DEVICE_NOT_CAPABLE = new d("UNSUPPORTED_DEVICE_NOT_CAPABLE", 3, 100);
        public static final Availability SUPPORTED_NOT_INSTALLED = new e("SUPPORTED_NOT_INSTALLED", 4, 201);
        public static final Availability SUPPORTED_APK_TOO_OLD = new f("SUPPORTED_APK_TOO_OLD", 5, 202);
        public static final Availability SUPPORTED_INSTALLED = new g("SUPPORTED_INSTALLED", 6, 203);
        private static final /* synthetic */ Availability[] $VALUES = {UNKNOWN_ERROR, UNKNOWN_CHECKING, UNKNOWN_TIMED_OUT, UNSUPPORTED_DEVICE_NOT_CAPABLE, SUPPORTED_NOT_INSTALLED, SUPPORTED_APK_TOO_OLD, SUPPORTED_INSTALLED};

        public static Availability[] values() {
            return (Availability[]) $VALUES.clone();
        }

        public static Availability valueOf(String str) {
            return (Availability) Enum.valueOf(Availability.class, str);
        }

        public boolean isUnknown() {
            return false;
        }

        public boolean isUnsupported() {
            return false;
        }

        public boolean isSupported() {
            return false;
        }

        public boolean isTransient() {
            return false;
        }

        private Availability(String str, int i, int i2) {
            this.nativeCode = i2;
        }

        static Availability forNumber(int i) {
            Availability[] values;
            for (Availability availability : values()) {
                if (availability.nativeCode == i) {
                    return availability;
                }
            }
            throw new FatalException(new StringBuilder(59).append("Unexpected value for native Availability, value=").append(i).toString());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ Availability(String str, int i, int i2, n nVar) {
            this(str, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface a {
        void a(Availability availability);
    }

    public static ArCoreApk eys() {
        return o.eyA();
    }

    /* loaded from: classes5.dex */
    public enum InstallBehavior {
        REQUIRED(0),
        OPTIONAL(1);
        
        final int nativeCode;

        InstallBehavior(int i) {
            this.nativeCode = i;
        }

        static InstallBehavior forNumber(int i) {
            InstallBehavior[] values;
            for (InstallBehavior installBehavior : values()) {
                if (installBehavior.nativeCode == i) {
                    return installBehavior;
                }
            }
            throw new FatalException(new StringBuilder(62).append("Unexpected value for native InstallBehavior, value=").append(i).toString());
        }
    }

    /* loaded from: classes5.dex */
    public enum InstallStatus {
        INSTALLED(0),
        INSTALL_REQUESTED(1);
        
        final int nativeCode;

        InstallStatus(int i) {
            this.nativeCode = i;
        }

        static InstallStatus forNumber(int i) {
            InstallStatus[] values;
            for (InstallStatus installStatus : values()) {
                if (installStatus.nativeCode == i) {
                    return installStatus;
                }
            }
            throw new FatalException(new StringBuilder(60).append("Unexpected value for native InstallStatus, value=").append(i).toString());
        }
    }

    /* loaded from: classes5.dex */
    public enum UserMessageType {
        APPLICATION(0),
        FEATURE(1),
        USER_ALREADY_INFORMED(2);
        
        final int nativeCode;

        UserMessageType(int i) {
            this.nativeCode = i;
        }

        static UserMessageType forNumber(int i) {
            UserMessageType[] values;
            for (UserMessageType userMessageType : values()) {
                if (userMessageType.nativeCode == i) {
                    return userMessageType;
                }
            }
            throw new FatalException(new StringBuilder(62).append("Unexpected value for native UserMessageType, value=").append(i).toString());
        }
    }

    public Availability in(Context context) {
        throw new UnsupportedOperationException("Stub");
    }
}
