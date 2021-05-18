package d.a.k0.a1.j.b.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewHottopic.PkItem;
import tbclient.NewHottopic.PkModule;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f51817a;

    /* renamed from: b  reason: collision with root package name */
    public long f51818b;

    /* renamed from: c  reason: collision with root package name */
    public long f51819c;

    /* renamed from: d  reason: collision with root package name */
    public a f51820d;

    /* renamed from: e  reason: collision with root package name */
    public a f51821e;

    /* renamed from: f  reason: collision with root package name */
    public int f51822f;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f51823a;

        /* renamed from: b  reason: collision with root package name */
        public String f51824b;

        /* renamed from: c  reason: collision with root package name */
        public String f51825c;

        /* renamed from: d  reason: collision with root package name */
        public String f51826d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f51827e;

        /* renamed from: f  reason: collision with root package name */
        public long f51828f;

        /* renamed from: g  reason: collision with root package name */
        public String f51829g;

        public a(b bVar) {
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f51818b = pkModule.pk_id.longValue();
        this.f51819c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f51820d = aVar;
        aVar.f51823a = pkModule.agree.pk_num.longValue();
        this.f51820d.f51824b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f51820d;
        PkItem pkItem = pkModule.agree;
        aVar2.f51825c = pkItem.last_username;
        aVar2.f51826d = pkItem.pk_icon;
        aVar2.f51827e = pkItem.has_clicked.longValue() == 1;
        this.f51820d.f51828f = pkModule.agree.pk_index.longValue();
        this.f51820d.f51829g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f51821e = aVar3;
        aVar3.f51823a = pkModule.disagree.pk_num.longValue();
        this.f51821e.f51824b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f51821e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f51825c = pkItem2.last_username;
        aVar4.f51826d = pkItem2.pk_icon;
        aVar4.f51827e = pkItem2.has_clicked.longValue() == 1;
        this.f51821e.f51828f = pkModule.disagree.pk_index.longValue();
        this.f51821e.f51829g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f51818b = pkModule.pk_id.longValue();
        this.f51819c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f51820d = aVar;
        aVar.f51823a = pkModule.agree.pk_num.longValue();
        this.f51820d.f51824b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f51820d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f51825c = pkItem.last_username;
        aVar2.f51826d = pkItem.pk_icon;
        aVar2.f51827e = pkItem.has_clicked.longValue() == 1;
        this.f51820d.f51828f = pkModule.agree.pk_index.longValue();
        this.f51820d.f51829g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f51821e = aVar3;
        aVar3.f51823a = pkModule.disagree.pk_num.longValue();
        this.f51821e.f51824b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f51821e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f51825c = pkItem2.last_username;
        aVar4.f51826d = pkItem2.pk_icon;
        aVar4.f51827e = pkItem2.has_clicked.longValue() == 1;
        this.f51821e.f51828f = pkModule.disagree.pk_index.longValue();
        this.f51821e.f51829g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f51818b = pkModule.pk_id.longValue();
        this.f51819c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f51820d = aVar;
        aVar.f51823a = pkModule.agree.pk_num.longValue();
        this.f51820d.f51824b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f51820d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f51825c = pkItem.last_username;
        aVar2.f51826d = pkItem.pk_icon;
        aVar2.f51827e = pkItem.has_clicked.longValue() == 1;
        this.f51820d.f51828f = pkModule.agree.pk_index.longValue();
        this.f51820d.f51829g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f51821e = aVar3;
        aVar3.f51823a = pkModule.disagree.pk_num.longValue();
        this.f51821e.f51824b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f51821e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f51825c = pkItem2.last_username;
        aVar4.f51826d = pkItem2.pk_icon;
        aVar4.f51827e = pkItem2.has_clicked.longValue() == 1;
        this.f51821e.f51828f = pkModule.disagree.pk_index.longValue();
        this.f51821e.f51829g = pkModule.disagree.pk_icon_after;
    }
}
