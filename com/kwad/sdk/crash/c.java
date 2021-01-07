package com.kwad.sdk.crash;

import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final double f9927a = Runtime.getRuntime().maxMemory();

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f9928b = Pattern.compile("/data/user");
    public static final Pattern c = Pattern.compile("/data");
    public static final Pattern d = Pattern.compile("/data/data/(.*)/data/.*");
    public static final Pattern e = Pattern.compile("/data/user/.*/(.*)/data/.*");
    public static int f = 20;
    public static String g = "sessionId";
}
