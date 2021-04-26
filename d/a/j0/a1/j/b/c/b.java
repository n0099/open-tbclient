package d.a.j0.a1.j.b.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewHottopic.PkItem;
import tbclient.NewHottopic.PkModule;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f51118a;

    /* renamed from: b  reason: collision with root package name */
    public long f51119b;

    /* renamed from: c  reason: collision with root package name */
    public long f51120c;

    /* renamed from: d  reason: collision with root package name */
    public a f51121d;

    /* renamed from: e  reason: collision with root package name */
    public a f51122e;

    /* renamed from: f  reason: collision with root package name */
    public int f51123f;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f51124a;

        /* renamed from: b  reason: collision with root package name */
        public String f51125b;

        /* renamed from: c  reason: collision with root package name */
        public String f51126c;

        /* renamed from: d  reason: collision with root package name */
        public String f51127d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f51128e;

        /* renamed from: f  reason: collision with root package name */
        public long f51129f;

        /* renamed from: g  reason: collision with root package name */
        public String f51130g;

        public a(b bVar) {
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f51119b = pkModule.pk_id.longValue();
        this.f51120c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f51121d = aVar;
        aVar.f51124a = pkModule.agree.pk_num.longValue();
        this.f51121d.f51125b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f51121d;
        PkItem pkItem = pkModule.agree;
        aVar2.f51126c = pkItem.last_username;
        aVar2.f51127d = pkItem.pk_icon;
        aVar2.f51128e = pkItem.has_clicked.longValue() == 1;
        this.f51121d.f51129f = pkModule.agree.pk_index.longValue();
        this.f51121d.f51130g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f51122e = aVar3;
        aVar3.f51124a = pkModule.disagree.pk_num.longValue();
        this.f51122e.f51125b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f51122e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f51126c = pkItem2.last_username;
        aVar4.f51127d = pkItem2.pk_icon;
        aVar4.f51128e = pkItem2.has_clicked.longValue() == 1;
        this.f51122e.f51129f = pkModule.disagree.pk_index.longValue();
        this.f51122e.f51130g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f51119b = pkModule.pk_id.longValue();
        this.f51120c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f51121d = aVar;
        aVar.f51124a = pkModule.agree.pk_num.longValue();
        this.f51121d.f51125b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f51121d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f51126c = pkItem.last_username;
        aVar2.f51127d = pkItem.pk_icon;
        aVar2.f51128e = pkItem.has_clicked.longValue() == 1;
        this.f51121d.f51129f = pkModule.agree.pk_index.longValue();
        this.f51121d.f51130g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f51122e = aVar3;
        aVar3.f51124a = pkModule.disagree.pk_num.longValue();
        this.f51122e.f51125b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f51122e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f51126c = pkItem2.last_username;
        aVar4.f51127d = pkItem2.pk_icon;
        aVar4.f51128e = pkItem2.has_clicked.longValue() == 1;
        this.f51122e.f51129f = pkModule.disagree.pk_index.longValue();
        this.f51122e.f51130g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f51119b = pkModule.pk_id.longValue();
        this.f51120c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f51121d = aVar;
        aVar.f51124a = pkModule.agree.pk_num.longValue();
        this.f51121d.f51125b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f51121d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f51126c = pkItem.last_username;
        aVar2.f51127d = pkItem.pk_icon;
        aVar2.f51128e = pkItem.has_clicked.longValue() == 1;
        this.f51121d.f51129f = pkModule.agree.pk_index.longValue();
        this.f51121d.f51130g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f51122e = aVar3;
        aVar3.f51124a = pkModule.disagree.pk_num.longValue();
        this.f51122e.f51125b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f51122e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f51126c = pkItem2.last_username;
        aVar4.f51127d = pkItem2.pk_icon;
        aVar4.f51128e = pkItem2.has_clicked.longValue() == 1;
        this.f51122e.f51129f = pkModule.disagree.pk_index.longValue();
        this.f51122e.f51130g = pkModule.disagree.pk_icon_after;
    }
}
