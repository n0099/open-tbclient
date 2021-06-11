package com.kwai.filedownloader.f;
/* loaded from: classes7.dex */
public class a {
    public static void a(String str, Object... objArr) {
        d.d(a.class, str + ", but the download service isn't connected yet.\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your requestHttpCode invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()", objArr);
    }

    public static boolean a(int i2) {
        a("request pause the task[%d] in the download service", Integer.valueOf(i2));
        return false;
    }

    public static boolean a(String str, String str2, boolean z) {
        a("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z));
        return false;
    }

    public static byte b(int i2) {
        a("request get the status for the task[%d] in the download service", Integer.valueOf(i2));
        return (byte) 0;
    }

    public static boolean c(int i2) {
        a("request clear the task[%d] data in the database", Integer.valueOf(i2));
        return false;
    }
}
