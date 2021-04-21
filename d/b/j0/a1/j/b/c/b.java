package d.b.j0.a1.j.b.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewHottopic.PkItem;
import tbclient.NewHottopic.PkModule;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f53393a;

    /* renamed from: b  reason: collision with root package name */
    public long f53394b;

    /* renamed from: c  reason: collision with root package name */
    public long f53395c;

    /* renamed from: d  reason: collision with root package name */
    public a f53396d;

    /* renamed from: e  reason: collision with root package name */
    public a f53397e;

    /* renamed from: f  reason: collision with root package name */
    public int f53398f;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f53399a;

        /* renamed from: b  reason: collision with root package name */
        public String f53400b;

        /* renamed from: c  reason: collision with root package name */
        public String f53401c;

        /* renamed from: d  reason: collision with root package name */
        public String f53402d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f53403e;

        /* renamed from: f  reason: collision with root package name */
        public long f53404f;

        /* renamed from: g  reason: collision with root package name */
        public String f53405g;

        public a(b bVar) {
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f53394b = pkModule.pk_id.longValue();
        this.f53395c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f53396d = aVar;
        aVar.f53399a = pkModule.agree.pk_num.longValue();
        this.f53396d.f53400b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f53396d;
        PkItem pkItem = pkModule.agree;
        aVar2.f53401c = pkItem.last_username;
        aVar2.f53402d = pkItem.pk_icon;
        aVar2.f53403e = pkItem.has_clicked.longValue() == 1;
        this.f53396d.f53404f = pkModule.agree.pk_index.longValue();
        this.f53396d.f53405g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f53397e = aVar3;
        aVar3.f53399a = pkModule.disagree.pk_num.longValue();
        this.f53397e.f53400b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f53397e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f53401c = pkItem2.last_username;
        aVar4.f53402d = pkItem2.pk_icon;
        aVar4.f53403e = pkItem2.has_clicked.longValue() == 1;
        this.f53397e.f53404f = pkModule.disagree.pk_index.longValue();
        this.f53397e.f53405g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f53394b = pkModule.pk_id.longValue();
        this.f53395c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f53396d = aVar;
        aVar.f53399a = pkModule.agree.pk_num.longValue();
        this.f53396d.f53400b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f53396d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f53401c = pkItem.last_username;
        aVar2.f53402d = pkItem.pk_icon;
        aVar2.f53403e = pkItem.has_clicked.longValue() == 1;
        this.f53396d.f53404f = pkModule.agree.pk_index.longValue();
        this.f53396d.f53405g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f53397e = aVar3;
        aVar3.f53399a = pkModule.disagree.pk_num.longValue();
        this.f53397e.f53400b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f53397e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f53401c = pkItem2.last_username;
        aVar4.f53402d = pkItem2.pk_icon;
        aVar4.f53403e = pkItem2.has_clicked.longValue() == 1;
        this.f53397e.f53404f = pkModule.disagree.pk_index.longValue();
        this.f53397e.f53405g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f53394b = pkModule.pk_id.longValue();
        this.f53395c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f53396d = aVar;
        aVar.f53399a = pkModule.agree.pk_num.longValue();
        this.f53396d.f53400b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f53396d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f53401c = pkItem.last_username;
        aVar2.f53402d = pkItem.pk_icon;
        aVar2.f53403e = pkItem.has_clicked.longValue() == 1;
        this.f53396d.f53404f = pkModule.agree.pk_index.longValue();
        this.f53396d.f53405g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f53397e = aVar3;
        aVar3.f53399a = pkModule.disagree.pk_num.longValue();
        this.f53397e.f53400b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f53397e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f53401c = pkItem2.last_username;
        aVar4.f53402d = pkItem2.pk_icon;
        aVar4.f53403e = pkItem2.has_clicked.longValue() == 1;
        this.f53397e.f53404f = pkModule.disagree.pk_index.longValue();
        this.f53397e.f53405g = pkModule.disagree.pk_icon_after;
    }
}
