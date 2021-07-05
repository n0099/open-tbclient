package com.kwad.sdk.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, context, charSequence, charSequence2) == null) || context == null || TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(charSequence2)) {
            return;
        }
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
    }
}
