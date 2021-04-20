package com.bytedance.sdk.openadsdk.preload.b.a;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public List<Throwable> f29829a;

    public a(List<Throwable> list) {
        this.f29829a = list;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Throwable th : list) {
            a(th, arrayList);
        }
        setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]));
    }

    private void a(Throwable th, List<StackTraceElement> list) {
        if (th == null) {
            return;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        for (int i = 0; i < length; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (i == 0) {
                String message = th.getMessage();
                StringBuilder sb = new StringBuilder();
                sb.append("\b\b\b\nCaused by:");
                if (message == null) {
                    message = "";
                }
                sb.append(message);
                sb.append("\n\t");
                sb.append(stackTraceElement.getClassName());
                list.add(new StackTraceElement(sb.toString(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber()));
            } else {
                list.add(stackTraceElement);
            }
        }
        a(th.getCause(), list);
    }
}
