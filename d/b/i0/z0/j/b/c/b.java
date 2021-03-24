package d.b.i0.z0.j.b.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewHottopic.PkItem;
import tbclient.NewHottopic.PkModule;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f63352a;

    /* renamed from: b  reason: collision with root package name */
    public long f63353b;

    /* renamed from: c  reason: collision with root package name */
    public long f63354c;

    /* renamed from: d  reason: collision with root package name */
    public a f63355d;

    /* renamed from: e  reason: collision with root package name */
    public a f63356e;

    /* renamed from: f  reason: collision with root package name */
    public int f63357f;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f63358a;

        /* renamed from: b  reason: collision with root package name */
        public String f63359b;

        /* renamed from: c  reason: collision with root package name */
        public String f63360c;

        /* renamed from: d  reason: collision with root package name */
        public String f63361d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f63362e;

        /* renamed from: f  reason: collision with root package name */
        public long f63363f;

        /* renamed from: g  reason: collision with root package name */
        public String f63364g;

        public a(b bVar) {
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f63353b = pkModule.pk_id.longValue();
        this.f63354c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f63355d = aVar;
        aVar.f63358a = pkModule.agree.pk_num.longValue();
        this.f63355d.f63359b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f63355d;
        PkItem pkItem = pkModule.agree;
        aVar2.f63360c = pkItem.last_username;
        aVar2.f63361d = pkItem.pk_icon;
        aVar2.f63362e = pkItem.has_clicked.longValue() == 1;
        this.f63355d.f63363f = pkModule.agree.pk_index.longValue();
        this.f63355d.f63364g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f63356e = aVar3;
        aVar3.f63358a = pkModule.disagree.pk_num.longValue();
        this.f63356e.f63359b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f63356e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f63360c = pkItem2.last_username;
        aVar4.f63361d = pkItem2.pk_icon;
        aVar4.f63362e = pkItem2.has_clicked.longValue() == 1;
        this.f63356e.f63363f = pkModule.disagree.pk_index.longValue();
        this.f63356e.f63364g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f63353b = pkModule.pk_id.longValue();
        this.f63354c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f63355d = aVar;
        aVar.f63358a = pkModule.agree.pk_num.longValue();
        this.f63355d.f63359b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f63355d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f63360c = pkItem.last_username;
        aVar2.f63361d = pkItem.pk_icon;
        aVar2.f63362e = pkItem.has_clicked.longValue() == 1;
        this.f63355d.f63363f = pkModule.agree.pk_index.longValue();
        this.f63355d.f63364g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f63356e = aVar3;
        aVar3.f63358a = pkModule.disagree.pk_num.longValue();
        this.f63356e.f63359b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f63356e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f63360c = pkItem2.last_username;
        aVar4.f63361d = pkItem2.pk_icon;
        aVar4.f63362e = pkItem2.has_clicked.longValue() == 1;
        this.f63356e.f63363f = pkModule.disagree.pk_index.longValue();
        this.f63356e.f63364g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f63353b = pkModule.pk_id.longValue();
        this.f63354c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f63355d = aVar;
        aVar.f63358a = pkModule.agree.pk_num.longValue();
        this.f63355d.f63359b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f63355d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f63360c = pkItem.last_username;
        aVar2.f63361d = pkItem.pk_icon;
        aVar2.f63362e = pkItem.has_clicked.longValue() == 1;
        this.f63355d.f63363f = pkModule.agree.pk_index.longValue();
        this.f63355d.f63364g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f63356e = aVar3;
        aVar3.f63358a = pkModule.disagree.pk_num.longValue();
        this.f63356e.f63359b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f63356e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f63360c = pkItem2.last_username;
        aVar4.f63361d = pkItem2.pk_icon;
        aVar4.f63362e = pkItem2.has_clicked.longValue() == 1;
        this.f63356e.f63363f = pkModule.disagree.pk_index.longValue();
        this.f63356e.f63364g = pkModule.disagree.pk_icon_after;
    }
}
