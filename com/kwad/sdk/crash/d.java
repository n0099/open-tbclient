package com.kwad.sdk.crash;

import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public final class d {
    public static final double aEz = Runtime.getRuntime().maxMemory();
    public static final Pattern aEA = Pattern.compile("/data/user");
    public static final Pattern aEB = Pattern.compile("/data");
    public static final Pattern aEC = Pattern.compile("/data/data/(.*)/data/.*");
    public static final Pattern aED = Pattern.compile("/data/user/.*/(.*)/data/.*");
    public static int aEE = 20;
    public static String aEF = "sessionId";
}
