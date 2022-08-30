package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.sina.weibo.sdk.utils.ResourceManager;
/* loaded from: classes8.dex */
public class c {
    public static int a(Context context) {
        return d.a(context).a("push_expandable_big_image_notification", TtmlNode.TAG_LAYOUT);
    }

    public static int b(Context context) {
        return d.a(context).a("push_expandable_big_text_notification", TtmlNode.TAG_LAYOUT);
    }

    public static int c(Context context) {
        return d.a(context).a("push_pure_pic_notification", TtmlNode.TAG_LAYOUT);
    }

    public static int d(Context context) {
        return d.a(context).a("push_big_notification_title", "id");
    }

    public static int e(Context context) {
        return d.a(context).a("push_big_notification_content", "id");
    }

    public static int f(Context context) {
        return d.a(context).a("push_big_notification_date", "id");
    }

    public static int g(Context context) {
        return d.a(context).a("push_big_bigview_defaultView", "id");
    }

    public static int h(Context context) {
        return d.a(context).a("push_big_bigtext_defaultView", "id");
    }

    public static int i(Context context) {
        return d.a(context).a("push_pure_bigview_banner", "id");
    }

    public static int j(Context context) {
        return d.a(context).a("push_pure_bigview_expanded", "id");
    }

    public static int k(Context context) {
        return d.a(context).a("push_big_notification_icon", "id");
    }

    public static int l(Context context) {
        return d.a(context).a("stat_sys_third_app_notify", ResourceManager.DRAWABLE);
    }
}
