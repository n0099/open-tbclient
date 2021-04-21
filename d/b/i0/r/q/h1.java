package d.b.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    public PrivatePopInfo f51548a = null;

    /* renamed from: b  reason: collision with root package name */
    public PrivateForumInfo f51549b = null;

    /* renamed from: c  reason: collision with root package name */
    public Integer f51550c = null;

    public PrivateForumInfo a() {
        return this.f51549b;
    }

    public Integer b() {
        return this.f51550c;
    }

    public PrivatePopInfo c() {
        return this.f51548a;
    }

    public void d(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo == null) {
            return;
        }
        try {
            PrivateForumShareinfo privateForumShareinfo = privateForumTotalInfo.private_forum_shareinfo;
            this.f51549b = privateForumTotalInfo.private_forum_info;
            this.f51550c = privateForumTotalInfo.private_forum_taskpercent;
            this.f51548a = privateForumTotalInfo.private_forum_popinfo;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
