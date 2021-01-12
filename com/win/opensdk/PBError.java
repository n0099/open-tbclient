package com.win.opensdk;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class PBError {
    private int java;

    /* renamed from: java  reason: collision with other field name */
    private String f6java;
    public static final PBError NO_FILL = new PBError(2001, "NO FILL");
    public static final PBError TIMEOUT = new PBError(2002, "TIME OUT");
    public static final PBError LOAD_TOO_FREQUENTLY = new PBError(2003, "LOAD TOO FREQUENTLY");
    public static final PBError SERVER_ERROR = new PBError(2004, "NET ERROR");
    public static final PBError PID_INVALID = new PBError(2005, "PID INVALID");
    public static final PBError PID_TYPE_ERROR = new PBError(2006, "PID ERROR");
    public static final PBError UNKNOWN = new PBError(2030, "UNKNOWN ERROR");
    public static final PBError NO_NETWORK = new PBError(2030, "No network available");
    public static final PBError NO_LOAD = new PBError(2031, "No Load");
    public static final PBError NO_RESUOURCE = new PBError(2031, "No Resources");
    public static final PBError LOAD_TIME_OUT = new PBError(2031, "Load Time Out");
    public static final PBError LOAD_TYPE_ERROR = new PBError(2031, "Load Type error");

    public PBError(int i, String str) {
        this.java = i;
        this.f6java = str;
    }

    public int getCode() {
        return this.java;
    }

    public void setCode(int i) {
        this.java = i;
    }

    public String getMsg() {
        return this.f6java;
    }

    public void setMsg(String str) {
        this.f6java = str;
    }

    @NonNull
    public String toString() {
        return "PBError{code=" + this.java + ", msg='" + this.f6java + "'}";
    }
}
