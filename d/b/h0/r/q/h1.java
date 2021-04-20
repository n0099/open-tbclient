package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    public PrivatePopInfo f51212a = null;

    /* renamed from: b  reason: collision with root package name */
    public PrivateForumInfo f51213b = null;

    /* renamed from: c  reason: collision with root package name */
    public Integer f51214c = null;

    public PrivateForumInfo a() {
        return this.f51213b;
    }

    public Integer b() {
        return this.f51214c;
    }

    public PrivatePopInfo c() {
        return this.f51212a;
    }

    public void d(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo == null) {
            return;
        }
        try {
            PrivateForumShareinfo privateForumShareinfo = privateForumTotalInfo.private_forum_shareinfo;
            this.f51213b = privateForumTotalInfo.private_forum_info;
            this.f51214c = privateForumTotalInfo.private_forum_taskpercent;
            this.f51212a = privateForumTotalInfo.private_forum_popinfo;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
