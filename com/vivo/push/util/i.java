package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes7.dex */
public final class i implements BaseNotifyDataAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Resources f36775a;

    /* renamed from: b  reason: collision with root package name */
    public String f36776b;

    /* renamed from: c  reason: collision with root package name */
    public String f36777c;

    /* renamed from: d  reason: collision with root package name */
    public String f36778d;

    private int a(String str) {
        while (!TextUtils.isEmpty(str)) {
            Resources resources = this.f36775a;
            int identifier = resources.getIdentifier("vivo_push_rom" + str + "_notifyicon", "drawable", this.f36776b);
            if (identifier > 0) {
                return identifier;
            }
            str = str.substring(0, str.length() - 1);
        }
        return this.f36775a.getIdentifier("vivo_push_notifyicon", "drawable", this.f36776b);
    }

    private int b(String str) {
        while (!TextUtils.isEmpty(str)) {
            Resources resources = this.f36775a;
            int identifier = resources.getIdentifier("vivo_push_rom" + str + "_icon", "drawable", this.f36776b);
            if (identifier > 0) {
                return identifier;
            }
            str = str.substring(0, str.length() - 1);
        }
        return this.f36775a.getIdentifier("vivo_push_icon", "drawable", this.f36776b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        int i2;
        String str = this.f36778d;
        while (true) {
            if (Build.VERSION.SDK_INT < 26) {
                break;
            } else if (TextUtils.isEmpty(str)) {
                p.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
                break;
            } else {
                String str2 = "vivo_push_ard" + str + "_notifyicon";
                i2 = this.f36775a.getIdentifier(str2, "drawable", this.f36776b);
                if (i2 > 0) {
                    p.d("DefaultNotifyDataAdapter", "get notify icon : " + str2);
                    break;
                }
                p.d("DefaultNotifyDataAdapter", "get notify error icon : " + str2);
                str = str.substring(0, str.length() + (-1));
            }
        }
        i2 = -1;
        return i2 != -1 ? i2 : a(this.f36777c);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        int i2;
        String str = this.f36778d;
        while (true) {
            if (Build.VERSION.SDK_INT < 26) {
                break;
            } else if (TextUtils.isEmpty(str)) {
                p.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
                break;
            } else {
                String str2 = "vivo_push_ard" + str + "_icon";
                i2 = this.f36775a.getIdentifier(str2, "drawable", this.f36776b);
                if (i2 > 0) {
                    p.d("DefaultNotifyDataAdapter", "get small icon : " + str2);
                    break;
                }
                p.d("DefaultNotifyDataAdapter", "get small error icon : " + str2);
                str = str.substring(0, str.length() + (-1));
            }
        }
        i2 = -1;
        return i2 != -1 ? i2 : b(this.f36777c);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return Build.VERSION.SDK_INT >= 21 ? 2 : 1;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.f36776b = context.getPackageName();
        this.f36775a = context.getResources();
        this.f36777c = k.a();
        String str = Build.VERSION.RELEASE;
        this.f36778d = TextUtils.isEmpty(str) ? null : str.replace(".", "");
    }
}
