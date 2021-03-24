package com.kwad.sdk.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class i {
    public static void a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        if (context == null || TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(charSequence2)) {
            return;
        }
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
    }
}
