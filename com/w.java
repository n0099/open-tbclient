package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
/* loaded from: classes.dex */
public class w {
    private SocialOAuthActivity a;
    private String b;
    private IBaiduListener c;

    public w(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.a = socialOAuthActivity;
        this.b = str;
        this.c = iBaiduListener;
    }

    public v a(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new s(this.a, this.b, this.c);
            case QZONE:
                return new r(this.a, this.b, this.c);
            default:
                return new v(this.a, this.b, str, this.c);
        }
    }
}
