package com.win.opensdk;

import android.content.Intent;
import java.net.URISyntaxException;
/* loaded from: classes3.dex */
public final class bs {
    public static Intent aaN(String str) {
        try {
            return Intent.parseUri(str, 1);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }
}
