package defpackage;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
/* renamed from: cc  reason: default package */
/* loaded from: classes.dex */
public class cc {
    private SocialOAuthActivity a;
    private String b;
    private IBaiduListener c;

    public cc(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.a = socialOAuthActivity;
        this.b = str;
        this.c = iBaiduListener;
    }

    public cb a(String str) {
        switch (cd.a[MediaType.fromString(str).ordinal()]) {
            case 1:
                return new bu(this.a, this.b, this.c);
            case 2:
                return new bt(this.a, this.b, this.c);
            default:
                return new cb(this.a, this.b, str, this.c);
        }
    }
}
