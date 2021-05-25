package d.a.m0.r.q;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    public PrivatePopInfo f50039a = null;

    /* renamed from: b  reason: collision with root package name */
    public PrivateForumInfo f50040b = null;

    /* renamed from: c  reason: collision with root package name */
    public Integer f50041c = null;

    public PrivateForumInfo a() {
        return this.f50040b;
    }

    public Integer b() {
        return this.f50041c;
    }

    public PrivatePopInfo c() {
        return this.f50039a;
    }

    public void d(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo == null) {
            return;
        }
        try {
            PrivateForumShareinfo privateForumShareinfo = privateForumTotalInfo.private_forum_shareinfo;
            this.f50040b = privateForumTotalInfo.private_forum_info;
            this.f50041c = privateForumTotalInfo.private_forum_taskpercent;
            this.f50039a = privateForumTotalInfo.private_forum_popinfo;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
