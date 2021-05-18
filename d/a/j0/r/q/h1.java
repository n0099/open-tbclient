package d.a.j0.r.q;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    public PrivatePopInfo f49995a = null;

    /* renamed from: b  reason: collision with root package name */
    public PrivateForumInfo f49996b = null;

    /* renamed from: c  reason: collision with root package name */
    public Integer f49997c = null;

    public PrivateForumInfo a() {
        return this.f49996b;
    }

    public Integer b() {
        return this.f49997c;
    }

    public PrivatePopInfo c() {
        return this.f49995a;
    }

    public void d(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo == null) {
            return;
        }
        try {
            PrivateForumShareinfo privateForumShareinfo = privateForumTotalInfo.private_forum_shareinfo;
            this.f49996b = privateForumTotalInfo.private_forum_info;
            this.f49997c = privateForumTotalInfo.private_forum_taskpercent;
            this.f49995a = privateForumTotalInfo.private_forum_popinfo;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
