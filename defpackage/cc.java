package defpackage;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
/* renamed from: cc  reason: default package */
/* loaded from: classes.dex */
public class cc {

    /* renamed from: a  reason: collision with root package name */
    private SocialOAuthActivity f396a;
    private String b;
    private IBaiduListener c;

    public cc(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.f396a = socialOAuthActivity;
        this.b = str;
        this.c = iBaiduListener;
    }

    public cb a(String str) {
        switch (cd.f397a[MediaType.fromString(str).ordinal()]) {
            case 1:
                return new bu(this.f396a, this.b, this.c);
            case 2:
                return new bt(this.f396a, this.b, this.c);
            default:
                return new cb(this.f396a, this.b, str, this.c);
        }
    }
}
