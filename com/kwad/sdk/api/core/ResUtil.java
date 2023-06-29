package com.kwad.sdk.api.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.baidu.spswitch.emotion.Emoticons;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.sina.weibo.sdk.utils.ResourceManager;
/* loaded from: classes10.dex */
public class ResUtil {
    public static int getAttrId(Context context, String str) {
        return getIdentifier(context, str, Emoticons.KEY_ATTR);
    }

    public static int getColor(Context context, String str) {
        return getResources(context).getColor(getIdentifier(context, str, "color"));
    }

    public static int getDimenId(Context context, String str) {
        return getIdentifier(context, str, EMABTest.TYPE_DIMEN);
    }

    public static Drawable getDrawable(Context context, String str) {
        return getResources(context).getDrawable(getIdentifier(context, str, ResourceManager.DRAWABLE));
    }

    public static int getDrawableId(Context context, String str) {
        return getIdentifier(context, str, ResourceManager.DRAWABLE);
    }

    public static int getId(Context context, String str) {
        return getIdentifier(context, str, "id");
    }

    public static int getIdentifier(Context context, String str, String str2) {
        return getResources(context).getIdentifier(str, str2, getPackageName(context));
    }

    public static int getLayoutId(Context context, String str) {
        return getIdentifier(context, str, TtmlNode.TAG_LAYOUT);
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    public static int getRawId(Context context, String str) {
        return getIdentifier(context, str, "raw");
    }

    public static Resources getResources(Context context) {
        return context.getResources();
    }

    public static String getString(Context context, String str) {
        return getResources(context).getString(getIdentifier(context, str, EMABTest.TYPE_STRING));
    }

    public static int getStyleId(Context context, String str) {
        return getIdentifier(context, str, "style");
    }
}
