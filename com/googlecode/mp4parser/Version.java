package com.googlecode.mp4parser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.logging.Logger;
/* loaded from: classes5.dex */
public class Version {
    private static final Logger LOG = Logger.getLogger(Version.class.getName());
    public static final String VERSION;

    static {
        String str;
        try {
            str = new LineNumberReader(new InputStreamReader(Version.class.getResourceAsStream("/version.txt"))).readLine();
        } catch (IOException e) {
            LOG.warning(e.getMessage());
            str = "unknown";
        }
        VERSION = str;
    }
}
