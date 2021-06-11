package com.kwai.sodler.lib.ext;
/* loaded from: classes7.dex */
public abstract class PluginError extends Exception {
    public static final int ERROR_INS_CAPACITY = 3005;
    public static final int ERROR_INS_INSTALL = 3004;
    public static final int ERROR_INS_INSTALL_PATH = 3006;
    public static final int ERROR_INS_NOT_FOUND = 3001;
    public static final int ERROR_INS_PACKAGE_INFO = 3002;
    public static final int ERROR_INS_SIGNATURE = 3003;
    public static final int ERROR_LOA_ASSET_MANAGER = 4006;
    public static final int ERROR_LOA_CLASS = 4007;
    public static final int ERROR_LOA_CLASSLOADER = 4005;
    public static final int ERROR_LOA_CREATE_PLUGIN = 4011;
    public static final int ERROR_LOA_NOT_FOUND = 4001;
    public static final int ERROR_LOA_NOT_LOADED = 4010;
    public static final int ERROR_LOA_OPT_DIR = 4002;
    public static final int ERROR_LOA_SO_DIR = 4003;
    public static final int ERROR_LOA_SO_INSTALL = 4004;
    public static final int ERROR_LOA_SO_MD5_CHECK = 4008;
    public static final int ERROR_OVER_RETRY = 1001;
    public static final int ERROR_UPD_CANCELED = 2001;
    public static final int ERROR_UPD_CAPACITY = 2005;
    public static final int ERROR_UPD_DOWNLOAD = 2002;
    public static final int ERROR_UPD_EXTRACT = 2004;
    public static final int ERROR_UPD_NOT_WIFI_DOWNLOAD = 2007;
    public static final int ERROR_UPD_NO_TEMP = 2003;
    public static final int ERROR_UPD_REQUEST = 2006;
    public final int mCode;

    /* loaded from: classes7.dex */
    public static final class CancelError extends PluginError {
        public CancelError(int i2) {
            super("Operation was canceled.", i2);
        }
    }

    /* loaded from: classes7.dex */
    public static final class InstallError extends PluginError {
        public InstallError(String str, int i2) {
            super(str, i2);
        }

        public InstallError(Throwable th, int i2) {
            super(th, i2);
        }
    }

    /* loaded from: classes7.dex */
    public static final class LoadError extends PluginError {
        public LoadError(String str, int i2) {
            super(str, i2);
        }

        public LoadError(Throwable th, int i2) {
            super(th, i2);
            setStackTrace(th.getStackTrace());
        }
    }

    /* loaded from: classes7.dex */
    public static final class NotWifiDownloadError extends PluginError {
        public NotWifiDownloadError(String str, int i2) {
            super(str, i2);
        }

        public NotWifiDownloadError(Throwable th, int i2) {
            super(th, i2);
            setStackTrace(th.getStackTrace());
        }
    }

    /* loaded from: classes7.dex */
    public static final class RetryError extends PluginError {
        public RetryError() {
            super("Reach max retry.", 1001);
        }
    }

    /* loaded from: classes7.dex */
    public static final class UpdateError extends PluginError {
        public UpdateError(String str, int i2) {
            super(str, i2);
        }

        public UpdateError(Throwable th, int i2) {
            super(th, i2);
        }
    }

    public PluginError(String str, int i2) {
        super(str);
        this.mCode = i2;
    }

    public PluginError(String str, Throwable th, int i2) {
        super(str, th);
        this.mCode = i2;
    }

    public PluginError(Throwable th, int i2) {
        super(th);
        this.mCode = i2;
    }

    public int getCode() {
        return this.mCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "PluginError{code=" + this.mCode + ", msg = " + super.toString() + '}';
    }
}
