package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
/* loaded from: classes15.dex */
public class ao {
    public static Bitmap a(String str) {
        byte[] decode;
        if (TextUtils.isEmpty(str) || (decode = Base64.decode(str, 0)) == null || decode.length <= 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Drawable a(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return null;
        }
        try {
            return resources.getDrawable(resources.getIdentifier(str, "drawable", context.getPackageName()));
        } catch (Exception e) {
            ay.b("Drawable 资源 输入有误");
            return null;
        }
    }
}
