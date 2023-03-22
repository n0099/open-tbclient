package com.google.ar.core;

import android.content.Context;
import com.baidu.tieba.tia;
import com.baidu.tieba.uia;
import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes8.dex */
public class ArCoreApk {

    /* loaded from: classes8.dex */
    public interface a {
        void a(Availability availability);
    }

    public abstract Availability a(Context context);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes8.dex */
    public static class Availability {
        public static final /* synthetic */ Availability[] $VALUES;
        public static final Availability SUPPORTED_INSTALLED;
        public final int nativeCode;
        public static final Availability UNKNOWN_ERROR = new com.google.ar.core.a("UNKNOWN_ERROR", 0, 0);
        public static final Availability UNKNOWN_CHECKING = new b("UNKNOWN_CHECKING", 1, 1);
        public static final Availability UNKNOWN_TIMED_OUT = new c("UNKNOWN_TIMED_OUT", 2, 2);
        public static final Availability UNSUPPORTED_DEVICE_NOT_CAPABLE = new d("UNSUPPORTED_DEVICE_NOT_CAPABLE", 3, 100);
        public static final Availability SUPPORTED_NOT_INSTALLED = new e("SUPPORTED_NOT_INSTALLED", 4, 201);
        public static final Availability SUPPORTED_APK_TOO_OLD = new f("SUPPORTED_APK_TOO_OLD", 5, 202);

        public boolean isSupported() {
            return false;
        }

        public boolean isTransient() {
            return false;
        }

        public boolean isUnknown() {
            return false;
        }

        public boolean isUnsupported() {
            return false;
        }

        static {
            g gVar = new g("SUPPORTED_INSTALLED", 6, 203);
            SUPPORTED_INSTALLED = gVar;
            $VALUES = new Availability[]{UNKNOWN_ERROR, UNKNOWN_CHECKING, UNKNOWN_TIMED_OUT, UNSUPPORTED_DEVICE_NOT_CAPABLE, SUPPORTED_NOT_INSTALLED, SUPPORTED_APK_TOO_OLD, gVar};
        }

        public Availability(String str, int i, int i2) {
            this.nativeCode = i2;
        }

        public /* synthetic */ Availability(String str, int i, int i2, tia tiaVar) {
            this(str, i, i2);
        }

        public static Availability forNumber(int i) {
            Availability[] values;
            for (Availability availability : values()) {
                if (availability.nativeCode == i) {
                    return availability;
                }
            }
            StringBuilder sb = new StringBuilder(59);
            sb.append("Unexpected value for native Availability, value=");
            sb.append(i);
            throw new FatalException(sb.toString());
        }

        public static Availability valueOf(String str) {
            return (Availability) Enum.valueOf(Availability.class, str);
        }

        public static Availability[] values() {
            return (Availability[]) $VALUES.clone();
        }
    }

    public static ArCoreApk b() {
        return uia.d();
    }

    /* loaded from: classes8.dex */
    public enum InstallBehavior {
        REQUIRED(0),
        OPTIONAL(1);
        
        public final int nativeCode;

        InstallBehavior(int i) {
            this.nativeCode = i;
        }

        public static InstallBehavior forNumber(int i) {
            InstallBehavior[] values;
            for (InstallBehavior installBehavior : values()) {
                if (installBehavior.nativeCode == i) {
                    return installBehavior;
                }
            }
            StringBuilder sb = new StringBuilder(62);
            sb.append("Unexpected value for native InstallBehavior, value=");
            sb.append(i);
            throw new FatalException(sb.toString());
        }
    }

    /* loaded from: classes8.dex */
    public enum InstallStatus {
        INSTALLED(0),
        INSTALL_REQUESTED(1);
        
        public final int nativeCode;

        InstallStatus(int i) {
            this.nativeCode = i;
        }

        public static InstallStatus forNumber(int i) {
            InstallStatus[] values;
            for (InstallStatus installStatus : values()) {
                if (installStatus.nativeCode == i) {
                    return installStatus;
                }
            }
            StringBuilder sb = new StringBuilder(60);
            sb.append("Unexpected value for native InstallStatus, value=");
            sb.append(i);
            throw new FatalException(sb.toString());
        }
    }

    /* loaded from: classes8.dex */
    public enum UserMessageType {
        APPLICATION(0),
        FEATURE(1),
        USER_ALREADY_INFORMED(2);
        
        public final int nativeCode;

        UserMessageType(int i) {
            this.nativeCode = i;
        }

        public static UserMessageType forNumber(int i) {
            UserMessageType[] values;
            for (UserMessageType userMessageType : values()) {
                if (userMessageType.nativeCode == i) {
                    return userMessageType;
                }
            }
            StringBuilder sb = new StringBuilder(62);
            sb.append("Unexpected value for native UserMessageType, value=");
            sb.append(i);
            throw new FatalException(sb.toString());
        }
    }
}
