package com.bytedance.sdk.openadsdk.preload.a.a;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private List<Throwable> f7715a;

    public a(List<Throwable> list) {
        this.f7715a = list;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Throwable th : list) {
                a(th, arrayList);
            }
            setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]));
        }
    }

    private void a(Throwable th, List<StackTraceElement> list) {
        if (th != null) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                if (i == 0) {
                    String message = th.getMessage();
                    StringBuilder append = new StringBuilder().append("\b\b\b\nCaused by:");
                    if (message == null) {
                        message = "";
                    }
                    list.add(new StackTraceElement(append.append(message).append("\n\t").append(stackTraceElement.getClassName()).toString(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber()));
                } else {
                    list.add(stackTraceElement);
                }
            }
            a(th.getCause(), list);
        }
    }
}
