package d.b.i0.a1.j.b.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewHottopic.PkItem;
import tbclient.NewHottopic.PkModule;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f52972a;

    /* renamed from: b  reason: collision with root package name */
    public long f52973b;

    /* renamed from: c  reason: collision with root package name */
    public long f52974c;

    /* renamed from: d  reason: collision with root package name */
    public a f52975d;

    /* renamed from: e  reason: collision with root package name */
    public a f52976e;

    /* renamed from: f  reason: collision with root package name */
    public int f52977f;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f52978a;

        /* renamed from: b  reason: collision with root package name */
        public String f52979b;

        /* renamed from: c  reason: collision with root package name */
        public String f52980c;

        /* renamed from: d  reason: collision with root package name */
        public String f52981d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f52982e;

        /* renamed from: f  reason: collision with root package name */
        public long f52983f;

        /* renamed from: g  reason: collision with root package name */
        public String f52984g;

        public a(b bVar) {
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f52973b = pkModule.pk_id.longValue();
        this.f52974c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f52975d = aVar;
        aVar.f52978a = pkModule.agree.pk_num.longValue();
        this.f52975d.f52979b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f52975d;
        PkItem pkItem = pkModule.agree;
        aVar2.f52980c = pkItem.last_username;
        aVar2.f52981d = pkItem.pk_icon;
        aVar2.f52982e = pkItem.has_clicked.longValue() == 1;
        this.f52975d.f52983f = pkModule.agree.pk_index.longValue();
        this.f52975d.f52984g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f52976e = aVar3;
        aVar3.f52978a = pkModule.disagree.pk_num.longValue();
        this.f52976e.f52979b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f52976e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f52980c = pkItem2.last_username;
        aVar4.f52981d = pkItem2.pk_icon;
        aVar4.f52982e = pkItem2.has_clicked.longValue() == 1;
        this.f52976e.f52983f = pkModule.disagree.pk_index.longValue();
        this.f52976e.f52984g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f52973b = pkModule.pk_id.longValue();
        this.f52974c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f52975d = aVar;
        aVar.f52978a = pkModule.agree.pk_num.longValue();
        this.f52975d.f52979b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f52975d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f52980c = pkItem.last_username;
        aVar2.f52981d = pkItem.pk_icon;
        aVar2.f52982e = pkItem.has_clicked.longValue() == 1;
        this.f52975d.f52983f = pkModule.agree.pk_index.longValue();
        this.f52975d.f52984g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f52976e = aVar3;
        aVar3.f52978a = pkModule.disagree.pk_num.longValue();
        this.f52976e.f52979b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f52976e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f52980c = pkItem2.last_username;
        aVar4.f52981d = pkItem2.pk_icon;
        aVar4.f52982e = pkItem2.has_clicked.longValue() == 1;
        this.f52976e.f52983f = pkModule.disagree.pk_index.longValue();
        this.f52976e.f52984g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f52973b = pkModule.pk_id.longValue();
        this.f52974c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f52975d = aVar;
        aVar.f52978a = pkModule.agree.pk_num.longValue();
        this.f52975d.f52979b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f52975d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f52980c = pkItem.last_username;
        aVar2.f52981d = pkItem.pk_icon;
        aVar2.f52982e = pkItem.has_clicked.longValue() == 1;
        this.f52975d.f52983f = pkModule.agree.pk_index.longValue();
        this.f52975d.f52984g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f52976e = aVar3;
        aVar3.f52978a = pkModule.disagree.pk_num.longValue();
        this.f52976e.f52979b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f52976e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f52980c = pkItem2.last_username;
        aVar4.f52981d = pkItem2.pk_icon;
        aVar4.f52982e = pkItem2.has_clicked.longValue() == 1;
        this.f52976e.f52983f = pkModule.disagree.pk_index.longValue();
        this.f52976e.f52984g = pkModule.disagree.pk_icon_after;
    }
}
