package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    public PrivatePopInfo f50805a = null;

    /* renamed from: b  reason: collision with root package name */
    public PrivateForumInfo f50806b = null;

    /* renamed from: c  reason: collision with root package name */
    public Integer f50807c = null;

    public PrivateForumInfo a() {
        return this.f50806b;
    }

    public Integer b() {
        return this.f50807c;
    }

    public PrivatePopInfo c() {
        return this.f50805a;
    }

    public void d(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo == null) {
            return;
        }
        try {
            PrivateForumShareinfo privateForumShareinfo = privateForumTotalInfo.private_forum_shareinfo;
            this.f50806b = privateForumTotalInfo.private_forum_info;
            this.f50807c = privateForumTotalInfo.private_forum_taskpercent;
            this.f50805a = privateForumTotalInfo.private_forum_popinfo;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
