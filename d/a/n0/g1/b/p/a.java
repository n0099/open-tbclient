package d.a.n0.g1.b.p;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import d.a.c.e.p.k;
import d.a.m0.r.q.a2;
import tbclient.AgreeList;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes4.dex */
public class a extends BaseCardInfo {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f55120e;

    /* renamed from: g  reason: collision with root package name */
    public String f55122g;

    /* renamed from: h  reason: collision with root package name */
    public long f55123h;

    /* renamed from: i  reason: collision with root package name */
    public String f55124i;
    public String j;
    public OriginalThreadInfo k;
    public String l;
    public MetaData m;
    public int n;
    public String o;
    public String p;
    public long q;
    public boolean r;
    public String s;
    public boolean t;
    public BaijiahaoData v;
    public String w;
    public static final BdUniqueId x = BdUniqueId.gen();
    public static final BdUniqueId y = BdUniqueId.gen();
    public static final BdUniqueId z = BdUniqueId.gen();
    public static final BdUniqueId A = BdUniqueId.gen();
    public static final BdUniqueId B = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public MetaData f55121f = new MetaData();
    public boolean u = false;

    public long A() {
        return this.f55123h;
    }

    public String B() {
        return this.f55124i;
    }

    public boolean C() {
        return this.u;
    }

    public boolean D() {
        return this.t;
    }

    public boolean E() {
        return this.r;
    }

    public void F(FeedData feedData) {
        String str;
        if (feedData == null) {
            return;
        }
        this.f55121f = feedData.getReplyer();
        this.f55123h = feedData.getTime();
        this.p = feedData.getPost_id();
        if (!feedData.isHideForumName()) {
            this.l = feedData.getFname();
        }
        this.o = feedData.getThread_id();
        this.n = feedData.getThread_Type();
        this.f55124i = feedData.getContent();
        this.r = feedData.getIsFloor();
        this.f55122g = feedData.getPostFrom();
        this.s = feedData.getQuote_pid();
        this.t = feedData.isNew();
        this.m = feedData.getThreadAuthor();
        this.u = feedData.isBjh();
        this.v = feedData.getBaijiahaoData();
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        this.k = originalThreadInfo;
        originalThreadInfo.f12038f = this.o;
        originalThreadInfo.k = this.n;
        originalThreadInfo.f12035c = feedData.getThreadImgUrl();
        OriginalThreadInfo originalThreadInfo2 = this.k;
        originalThreadInfo2.o = this.u;
        originalThreadInfo2.p = this.v;
        this.w = "c12928";
        if (feedData.getType() == 1) {
            this.k.n = feedData.getQuote_pid();
            if (feedData.getQuote_user() == null) {
                str = "";
            } else if (StringHelper.equals(feedData.getQuote_user().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                str = TbadkCoreApplication.getInst().getString(R.string.me);
            } else {
                str = feedData.getQuote_user().getName_show();
            }
            this.k.f12039g = TbadkCoreApplication.getInst().getString(R.string.reply_me_original, new Object[]{str, feedData.getQuote_content()});
            if (TextUtils.isGraphic(this.k.f12039g)) {
                OriginalThreadInfo originalThreadInfo3 = this.k;
                originalThreadInfo3.f12039g = originalThreadInfo3.f12039g.replace("\n", " ");
            }
            if (feedData.getIsFloor()) {
                this.f55120e = z;
            } else {
                this.f55120e = A;
            }
        } else {
            this.k.n = "0";
            if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                this.k.f12039g = TbadkCoreApplication.getInst().getString(R.string.share_replyme_original, new Object[]{feedData.getOriginalThreadInfo().f12034b});
            } else {
                this.k.f12039g = feedData.getTitle();
            }
            this.f55120e = B;
        }
        this.k.n();
    }

    public void G(AgreeList agreeList) {
        User user;
        if (agreeList == null) {
            return;
        }
        this.q = agreeList.id.longValue();
        MetaData metaData = new MetaData();
        this.f55121f = metaData;
        metaData.parserProtobuf(agreeList.agreeer);
        this.f55123h = agreeList.time.intValue() * 1000;
        Post post = agreeList.post_info;
        if (post != null) {
            this.p = String.valueOf(post.id);
            if (!ListUtils.isEmpty(agreeList.post_info.content) && ListUtils.getItem(agreeList.post_info.content, 0) != null && (user = agreeList.post_info.author) != null) {
                String str = user.name_show;
                if (k.isEmpty(str)) {
                    str = agreeList.post_info.author.name;
                }
                this.j = str + "：" + agreeList.post_info.content.get(0).text;
            }
            this.s = agreeList.post_info.quote_id;
        }
        a2 a2Var = new a2();
        a2Var.U2(agreeList.thread_info);
        this.k = OriginalThreadInfo.i(a2Var);
        this.m = a2Var.T();
        this.l = a2Var.i0();
        this.o = a2Var.o0();
        this.n = a2Var.Z;
        this.u = a2Var.B2();
        this.v = a2Var.V();
        this.w = "c12927";
        if (agreeList.type.intValue() == 3) {
            this.f55120e = x;
            this.f55124i = TbadkCoreApplication.getInst().getResources().getString(R.string.agree_my_thread);
            if (this.u) {
                this.f55124i = TbadkCoreApplication.getInst().getResources().getString(R.string.agree_my_dynamic);
                return;
            }
            return;
        }
        this.f55120e = y;
        this.f55124i = TbadkCoreApplication.getInst().getResources().getString(R.string.agree_my_post);
    }

    public void H(boolean z2) {
        this.t = z2;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return this.f55120e;
    }

    public BaijiahaoData h() {
        return this.v;
    }

    public String l() {
        return this.l;
    }

    public long m() {
        return this.q;
    }

    public OriginalThreadInfo p() {
        return this.k;
    }

    public String s() {
        return this.f55122g;
    }

    public String t() {
        return this.p;
    }

    public String u() {
        return this.s;
    }

    public MetaData v() {
        return this.f55121f;
    }

    public String w() {
        return this.w;
    }

    public String x() {
        return this.j;
    }

    public MetaData y() {
        return this.m;
    }

    public String z() {
        return this.o;
    }
}
