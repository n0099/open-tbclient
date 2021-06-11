package d.a.m0.r.q;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    public PrivatePopInfo f53715a = null;

    /* renamed from: b  reason: collision with root package name */
    public PrivateForumInfo f53716b = null;

    /* renamed from: c  reason: collision with root package name */
    public Integer f53717c = null;

    public PrivateForumInfo a() {
        return this.f53716b;
    }

    public Integer b() {
        return this.f53717c;
    }

    public PrivatePopInfo c() {
        return this.f53715a;
    }

    public void d(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo == null) {
            return;
        }
        try {
            PrivateForumShareinfo privateForumShareinfo = privateForumTotalInfo.private_forum_shareinfo;
            this.f53716b = privateForumTotalInfo.private_forum_info;
            this.f53717c = privateForumTotalInfo.private_forum_taskpercent;
            this.f53715a = privateForumTotalInfo.private_forum_popinfo;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
