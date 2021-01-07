package com.win.opensdk;

import android.content.Intent;
import java.net.URISyntaxException;
/* loaded from: classes4.dex */
public final class bs {
    public static Intent abU(String str) {
        try {
            return Intent.parseUri(str, 1);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }
}
