package d.a.n0.r.q;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    public PrivatePopInfo f53822a = null;

    /* renamed from: b  reason: collision with root package name */
    public PrivateForumInfo f53823b = null;

    /* renamed from: c  reason: collision with root package name */
    public Integer f53824c = null;

    public PrivateForumInfo a() {
        return this.f53823b;
    }

    public Integer b() {
        return this.f53824c;
    }

    public PrivatePopInfo c() {
        return this.f53822a;
    }

    public void d(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo == null) {
            return;
        }
        try {
            PrivateForumShareinfo privateForumShareinfo = privateForumTotalInfo.private_forum_shareinfo;
            this.f53823b = privateForumTotalInfo.private_forum_info;
            this.f53824c = privateForumTotalInfo.private_forum_taskpercent;
            this.f53822a = privateForumTotalInfo.private_forum_popinfo;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
