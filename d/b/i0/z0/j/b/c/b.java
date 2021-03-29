package d.b.i0.z0.j.b.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewHottopic.PkItem;
import tbclient.NewHottopic.PkModule;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f63353a;

    /* renamed from: b  reason: collision with root package name */
    public long f63354b;

    /* renamed from: c  reason: collision with root package name */
    public long f63355c;

    /* renamed from: d  reason: collision with root package name */
    public a f63356d;

    /* renamed from: e  reason: collision with root package name */
    public a f63357e;

    /* renamed from: f  reason: collision with root package name */
    public int f63358f;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f63359a;

        /* renamed from: b  reason: collision with root package name */
        public String f63360b;

        /* renamed from: c  reason: collision with root package name */
        public String f63361c;

        /* renamed from: d  reason: collision with root package name */
        public String f63362d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f63363e;

        /* renamed from: f  reason: collision with root package name */
        public long f63364f;

        /* renamed from: g  reason: collision with root package name */
        public String f63365g;

        public a(b bVar) {
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f63354b = pkModule.pk_id.longValue();
        this.f63355c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f63356d = aVar;
        aVar.f63359a = pkModule.agree.pk_num.longValue();
        this.f63356d.f63360b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f63356d;
        PkItem pkItem = pkModule.agree;
        aVar2.f63361c = pkItem.last_username;
        aVar2.f63362d = pkItem.pk_icon;
        aVar2.f63363e = pkItem.has_clicked.longValue() == 1;
        this.f63356d.f63364f = pkModule.agree.pk_index.longValue();
        this.f63356d.f63365g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f63357e = aVar3;
        aVar3.f63359a = pkModule.disagree.pk_num.longValue();
        this.f63357e.f63360b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f63357e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f63361c = pkItem2.last_username;
        aVar4.f63362d = pkItem2.pk_icon;
        aVar4.f63363e = pkItem2.has_clicked.longValue() == 1;
        this.f63357e.f63364f = pkModule.disagree.pk_index.longValue();
        this.f63357e.f63365g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f63354b = pkModule.pk_id.longValue();
        this.f63355c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f63356d = aVar;
        aVar.f63359a = pkModule.agree.pk_num.longValue();
        this.f63356d.f63360b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f63356d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f63361c = pkItem.last_username;
        aVar2.f63362d = pkItem.pk_icon;
        aVar2.f63363e = pkItem.has_clicked.longValue() == 1;
        this.f63356d.f63364f = pkModule.agree.pk_index.longValue();
        this.f63356d.f63365g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f63357e = aVar3;
        aVar3.f63359a = pkModule.disagree.pk_num.longValue();
        this.f63357e.f63360b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f63357e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f63361c = pkItem2.last_username;
        aVar4.f63362d = pkItem2.pk_icon;
        aVar4.f63363e = pkItem2.has_clicked.longValue() == 1;
        this.f63357e.f63364f = pkModule.disagree.pk_index.longValue();
        this.f63357e.f63365g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f63354b = pkModule.pk_id.longValue();
        this.f63355c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f63356d = aVar;
        aVar.f63359a = pkModule.agree.pk_num.longValue();
        this.f63356d.f63360b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f63356d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f63361c = pkItem.last_username;
        aVar2.f63362d = pkItem.pk_icon;
        aVar2.f63363e = pkItem.has_clicked.longValue() == 1;
        this.f63356d.f63364f = pkModule.agree.pk_index.longValue();
        this.f63356d.f63365g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f63357e = aVar3;
        aVar3.f63359a = pkModule.disagree.pk_num.longValue();
        this.f63357e.f63360b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f63357e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f63361c = pkItem2.last_username;
        aVar4.f63362d = pkItem2.pk_icon;
        aVar4.f63363e = pkItem2.has_clicked.longValue() == 1;
        this.f63357e.f63364f = pkModule.disagree.pk_index.longValue();
        this.f63357e.f63365g = pkModule.disagree.pk_icon_after;
    }
}
