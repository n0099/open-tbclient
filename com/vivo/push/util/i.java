package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes11.dex */
public final class i implements BaseNotifyDataAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Resources f4471a;
    private String b;
    private String c;
    private String d;

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        String replace;
        this.b = context.getPackageName();
        this.f4471a = context.getResources();
        this.c = k.a();
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            replace = null;
        } else {
            replace = str.replace(".", "");
        }
        this.d = replace;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        int i;
        String str = this.d;
        while (true) {
            if (Build.VERSION.SDK_INT < 26) {
                i = -1;
                break;
            } else if (TextUtils.isEmpty(str)) {
                p.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
                i = -1;
                break;
            } else {
                String str2 = "vivo_push_ard" + str + "_notifyicon";
                int identifier = this.f4471a.getIdentifier(str2, "drawable", this.b);
                if (identifier > 0) {
                    p.d("DefaultNotifyDataAdapter", "get notify icon : " + str2);
                    i = identifier;
                    break;
                }
                p.d("DefaultNotifyDataAdapter", "get notify error icon : " + str2);
                str = str.substring(0, str.length() - 1);
            }
        }
        return i != -1 ? i : a(this.c);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        int i;
        String str = this.d;
        while (true) {
            if (Build.VERSION.SDK_INT < 26) {
                i = -1;
                break;
            } else if (TextUtils.isEmpty(str)) {
                p.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
                i = -1;
                break;
            } else {
                String str2 = "vivo_push_ard" + str + "_icon";
                int identifier = this.f4471a.getIdentifier(str2, "drawable", this.b);
                if (identifier > 0) {
                    p.d("DefaultNotifyDataAdapter", "get small icon : " + str2);
                    i = identifier;
                    break;
                }
                p.d("DefaultNotifyDataAdapter", "get small error icon : " + str2);
                str = str.substring(0, str.length() - 1);
            }
        }
        return i != -1 ? i : b(this.c);
    }

    private int a(String str) {
        while (!TextUtils.isEmpty(str)) {
            int identifier = this.f4471a.getIdentifier("vivo_push_rom" + str + "_notifyicon", "drawable", this.b);
            if (identifier > 0) {
                return identifier;
            }
            str = str.substring(0, str.length() - 1);
        }
        return this.f4471a.getIdentifier("vivo_push_notifyicon", "drawable", this.b);
    }

    private int b(String str) {
        while (!TextUtils.isEmpty(str)) {
            int identifier = this.f4471a.getIdentifier("vivo_push_rom" + str + "_icon", "drawable", this.b);
            if (identifier > 0) {
                return identifier;
            }
            str = str.substring(0, str.length() - 1);
        }
        return this.f4471a.getIdentifier("vivo_push_icon", "drawable", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return Build.VERSION.SDK_INT >= 21 ? 2 : 1;
    }
}
