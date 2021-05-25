package d.a.n0.b1.j.b.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewHottopic.PkItem;
import tbclient.NewHottopic.PkModule;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f51984a;

    /* renamed from: b  reason: collision with root package name */
    public long f51985b;

    /* renamed from: c  reason: collision with root package name */
    public long f51986c;

    /* renamed from: d  reason: collision with root package name */
    public a f51987d;

    /* renamed from: e  reason: collision with root package name */
    public a f51988e;

    /* renamed from: f  reason: collision with root package name */
    public int f51989f;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f51990a;

        /* renamed from: b  reason: collision with root package name */
        public String f51991b;

        /* renamed from: c  reason: collision with root package name */
        public String f51992c;

        /* renamed from: d  reason: collision with root package name */
        public String f51993d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f51994e;

        /* renamed from: f  reason: collision with root package name */
        public long f51995f;

        /* renamed from: g  reason: collision with root package name */
        public String f51996g;

        public a(b bVar) {
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f51985b = pkModule.pk_id.longValue();
        this.f51986c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f51987d = aVar;
        aVar.f51990a = pkModule.agree.pk_num.longValue();
        this.f51987d.f51991b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f51987d;
        PkItem pkItem = pkModule.agree;
        aVar2.f51992c = pkItem.last_username;
        aVar2.f51993d = pkItem.pk_icon;
        aVar2.f51994e = pkItem.has_clicked.longValue() == 1;
        this.f51987d.f51995f = pkModule.agree.pk_index.longValue();
        this.f51987d.f51996g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f51988e = aVar3;
        aVar3.f51990a = pkModule.disagree.pk_num.longValue();
        this.f51988e.f51991b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f51988e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f51992c = pkItem2.last_username;
        aVar4.f51993d = pkItem2.pk_icon;
        aVar4.f51994e = pkItem2.has_clicked.longValue() == 1;
        this.f51988e.f51995f = pkModule.disagree.pk_index.longValue();
        this.f51988e.f51996g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f51985b = pkModule.pk_id.longValue();
        this.f51986c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f51987d = aVar;
        aVar.f51990a = pkModule.agree.pk_num.longValue();
        this.f51987d.f51991b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f51987d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f51992c = pkItem.last_username;
        aVar2.f51993d = pkItem.pk_icon;
        aVar2.f51994e = pkItem.has_clicked.longValue() == 1;
        this.f51987d.f51995f = pkModule.agree.pk_index.longValue();
        this.f51987d.f51996g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f51988e = aVar3;
        aVar3.f51990a = pkModule.disagree.pk_num.longValue();
        this.f51988e.f51991b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f51988e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f51992c = pkItem2.last_username;
        aVar4.f51993d = pkItem2.pk_icon;
        aVar4.f51994e = pkItem2.has_clicked.longValue() == 1;
        this.f51988e.f51995f = pkModule.disagree.pk_index.longValue();
        this.f51988e.f51996g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f51985b = pkModule.pk_id.longValue();
        this.f51986c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f51987d = aVar;
        aVar.f51990a = pkModule.agree.pk_num.longValue();
        this.f51987d.f51991b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f51987d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f51992c = pkItem.last_username;
        aVar2.f51993d = pkItem.pk_icon;
        aVar2.f51994e = pkItem.has_clicked.longValue() == 1;
        this.f51987d.f51995f = pkModule.agree.pk_index.longValue();
        this.f51987d.f51996g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f51988e = aVar3;
        aVar3.f51990a = pkModule.disagree.pk_num.longValue();
        this.f51988e.f51991b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f51988e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f51992c = pkItem2.last_username;
        aVar4.f51993d = pkItem2.pk_icon;
        aVar4.f51994e = pkItem2.has_clicked.longValue() == 1;
        this.f51988e.f51995f = pkModule.disagree.pk_index.longValue();
        this.f51988e.f51996g = pkModule.disagree.pk_icon_after;
    }
}
