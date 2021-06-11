package com.win.opensdk;
/* loaded from: classes7.dex */
public class PBError {

    /* renamed from: a  reason: collision with root package name */
    public int f40574a;

    /* renamed from: b  reason: collision with root package name */
    public String f40575b;
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

    public PBError(int i2, String str) {
        this.f40574a = i2;
        this.f40575b = str;
    }

    public int getCode() {
        return this.f40574a;
    }

    public String getMsg() {
        return this.f40575b;
    }

    public void setCode(int i2) {
        this.f40574a = i2;
    }

    public void setMsg(String str) {
        this.f40575b = str;
    }

    public String toString() {
        return "PBError{code=" + this.f40574a + ", msg='" + this.f40575b + "'}";
    }
}
