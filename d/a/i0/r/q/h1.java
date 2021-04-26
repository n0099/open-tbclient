package d.a.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    public PrivatePopInfo f49176a = null;

    /* renamed from: b  reason: collision with root package name */
    public PrivateForumInfo f49177b = null;

    /* renamed from: c  reason: collision with root package name */
    public Integer f49178c = null;

    public PrivateForumInfo a() {
        return this.f49177b;
    }

    public Integer b() {
        return this.f49178c;
    }

    public PrivatePopInfo c() {
        return this.f49176a;
    }

    public void d(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo == null) {
            return;
        }
        try {
            PrivateForumShareinfo privateForumShareinfo = privateForumTotalInfo.private_forum_shareinfo;
            this.f49177b = privateForumTotalInfo.private_forum_info;
            this.f49178c = privateForumTotalInfo.private_forum_taskpercent;
            this.f49176a = privateForumTotalInfo.private_forum_popinfo;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
