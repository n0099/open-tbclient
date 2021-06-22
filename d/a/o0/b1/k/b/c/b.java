package d.a.o0.b1.k.b.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewHottopic.PkItem;
import tbclient.NewHottopic.PkModule;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f55798a;

    /* renamed from: b  reason: collision with root package name */
    public long f55799b;

    /* renamed from: c  reason: collision with root package name */
    public long f55800c;

    /* renamed from: d  reason: collision with root package name */
    public a f55801d;

    /* renamed from: e  reason: collision with root package name */
    public a f55802e;

    /* renamed from: f  reason: collision with root package name */
    public int f55803f;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f55804a;

        /* renamed from: b  reason: collision with root package name */
        public String f55805b;

        /* renamed from: c  reason: collision with root package name */
        public String f55806c;

        /* renamed from: d  reason: collision with root package name */
        public String f55807d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f55808e;

        /* renamed from: f  reason: collision with root package name */
        public long f55809f;

        /* renamed from: g  reason: collision with root package name */
        public String f55810g;

        public a(b bVar) {
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f55799b = pkModule.pk_id.longValue();
        this.f55800c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f55801d = aVar;
        aVar.f55804a = pkModule.agree.pk_num.longValue();
        this.f55801d.f55805b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f55801d;
        PkItem pkItem = pkModule.agree;
        aVar2.f55806c = pkItem.last_username;
        aVar2.f55807d = pkItem.pk_icon;
        aVar2.f55808e = pkItem.has_clicked.longValue() == 1;
        this.f55801d.f55809f = pkModule.agree.pk_index.longValue();
        this.f55801d.f55810g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f55802e = aVar3;
        aVar3.f55804a = pkModule.disagree.pk_num.longValue();
        this.f55802e.f55805b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f55802e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f55806c = pkItem2.last_username;
        aVar4.f55807d = pkItem2.pk_icon;
        aVar4.f55808e = pkItem2.has_clicked.longValue() == 1;
        this.f55802e.f55809f = pkModule.disagree.pk_index.longValue();
        this.f55802e.f55810g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f55799b = pkModule.pk_id.longValue();
        this.f55800c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f55801d = aVar;
        aVar.f55804a = pkModule.agree.pk_num.longValue();
        this.f55801d.f55805b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f55801d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f55806c = pkItem.last_username;
        aVar2.f55807d = pkItem.pk_icon;
        aVar2.f55808e = pkItem.has_clicked.longValue() == 1;
        this.f55801d.f55809f = pkModule.agree.pk_index.longValue();
        this.f55801d.f55810g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f55802e = aVar3;
        aVar3.f55804a = pkModule.disagree.pk_num.longValue();
        this.f55802e.f55805b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f55802e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f55806c = pkItem2.last_username;
        aVar4.f55807d = pkItem2.pk_icon;
        aVar4.f55808e = pkItem2.has_clicked.longValue() == 1;
        this.f55802e.f55809f = pkModule.disagree.pk_index.longValue();
        this.f55802e.f55810g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f55799b = pkModule.pk_id.longValue();
        this.f55800c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f55801d = aVar;
        aVar.f55804a = pkModule.agree.pk_num.longValue();
        this.f55801d.f55805b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f55801d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f55806c = pkItem.last_username;
        aVar2.f55807d = pkItem.pk_icon;
        aVar2.f55808e = pkItem.has_clicked.longValue() == 1;
        this.f55801d.f55809f = pkModule.agree.pk_index.longValue();
        this.f55801d.f55810g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f55802e = aVar3;
        aVar3.f55804a = pkModule.disagree.pk_num.longValue();
        this.f55802e.f55805b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f55802e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f55806c = pkItem2.last_username;
        aVar4.f55807d = pkItem2.pk_icon;
        aVar4.f55808e = pkItem2.has_clicked.longValue() == 1;
        this.f55802e.f55809f = pkModule.disagree.pk_index.longValue();
        this.f55802e.f55810g = pkModule.disagree.pk_icon_after;
    }
}
