package defpackage;

import com.baidu.cloudsdk.social.share.SocialShare;
/* renamed from: bo  reason: default package */
/* loaded from: classes.dex */
public enum bo {
    LIGHT("menu_bg_white", "cancelbar_bg", "cancel_btn_white", "cancel_btn_white_mask", "pager_icon_light", "pager_icon_light_gray", "list_divider_white", -11184811, -12829636, -1710619),
    DARK("menu_bg_black", "", "cancel_btn_black", "cancel_btn_black_mask", "pager_icon_dark", "pager_icon_dark_gray", "list_divider_black", -6052957, -6052957, -14145496);
    
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private int j;
    private int k;
    private int l;

    bo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, int i3) {
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = str7;
        this.j = i;
        this.k = i2;
        this.l = i3;
    }

    public static bo a(SocialShare.Theme theme) {
        switch (theme) {
            case LIGHT:
                return LIGHT;
            default:
                return DARK;
        }
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.g;
    }

    public String f() {
        return this.h;
    }

    public String g() {
        return this.i;
    }

    public int h() {
        return this.j;
    }

    public int i() {
        return this.k;
    }

    public int j() {
        return this.l;
    }
}
