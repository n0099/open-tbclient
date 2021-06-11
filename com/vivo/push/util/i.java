package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes7.dex */
public final class i implements BaseNotifyDataAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Resources f40383a;

    /* renamed from: b  reason: collision with root package name */
    public String f40384b;

    /* renamed from: c  reason: collision with root package name */
    public String f40385c;

    /* renamed from: d  reason: collision with root package name */
    public String f40386d;

    private int a(String str) {
        while (!TextUtils.isEmpty(str)) {
            Resources resources = this.f40383a;
            int identifier = resources.getIdentifier("vivo_push_rom" + str + "_notifyicon", "drawable", this.f40384b);
            if (identifier > 0) {
                return identifier;
            }
            str = str.substring(0, str.length() - 1);
        }
        return this.f40383a.getIdentifier("vivo_push_notifyicon", "drawable", this.f40384b);
    }

    private int b(String str) {
        while (!TextUtils.isEmpty(str)) {
            Resources resources = this.f40383a;
            int identifier = resources.getIdentifier("vivo_push_rom" + str + "_icon", "drawable", this.f40384b);
            if (identifier > 0) {
                return identifier;
            }
            str = str.substring(0, str.length() - 1);
        }
        return this.f40383a.getIdentifier("vivo_push_icon", "drawable", this.f40384b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        int i2;
        String str = this.f40386d;
        while (true) {
            if (Build.VERSION.SDK_INT < 26) {
                break;
            } else if (TextUtils.isEmpty(str)) {
                p.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
                break;
            } else {
                String str2 = "vivo_push_ard" + str + "_notifyicon";
                i2 = this.f40383a.getIdentifier(str2, "drawable", this.f40384b);
                if (i2 > 0) {
                    p.d("DefaultNotifyDataAdapter", "get notify icon : " + str2);
                    break;
                }
                p.d("DefaultNotifyDataAdapter", "get notify error icon : " + str2);
                str = str.substring(0, str.length() + (-1));
            }
        }
        i2 = -1;
        return i2 != -1 ? i2 : a(this.f40385c);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        int i2;
        String str = this.f40386d;
        while (true) {
            if (Build.VERSION.SDK_INT < 26) {
                break;
            } else if (TextUtils.isEmpty(str)) {
                p.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
                break;
            } else {
                String str2 = "vivo_push_ard" + str + "_icon";
                i2 = this.f40383a.getIdentifier(str2, "drawable", this.f40384b);
                if (i2 > 0) {
                    p.d("DefaultNotifyDataAdapter", "get small icon : " + str2);
                    break;
                }
                p.d("DefaultNotifyDataAdapter", "get small error icon : " + str2);
                str = str.substring(0, str.length() + (-1));
            }
        }
        i2 = -1;
        return i2 != -1 ? i2 : b(this.f40385c);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return Build.VERSION.SDK_INT >= 21 ? 2 : 1;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.f40384b = context.getPackageName();
        this.f40383a = context.getResources();
        this.f40385c = k.a();
        String str = Build.VERSION.RELEASE;
        this.f40386d = TextUtils.isEmpty(str) ? null : str.replace(".", "");
    }
}
