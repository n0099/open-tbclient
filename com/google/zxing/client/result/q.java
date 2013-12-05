package com.google.zxing.client.result;
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    private final ParsedResultType f2853a;

    public abstract String a();

    /* JADX INFO: Access modifiers changed from: protected */
    public q(ParsedResultType parsedResultType) {
        this.f2853a = parsedResultType;
    }

    public final String toString() {
        return a();
    }

    public static void a(String str, StringBuilder sb) {
        if (str != null && str.length() > 0) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(str);
        }
    }

    public static void a(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                a(str, sb);
            }
        }
    }
}
