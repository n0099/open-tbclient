package d.a.n0.b1.k.b.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewHottopic.PkItem;
import tbclient.NewHottopic.PkModule;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f55673a;

    /* renamed from: b  reason: collision with root package name */
    public long f55674b;

    /* renamed from: c  reason: collision with root package name */
    public long f55675c;

    /* renamed from: d  reason: collision with root package name */
    public a f55676d;

    /* renamed from: e  reason: collision with root package name */
    public a f55677e;

    /* renamed from: f  reason: collision with root package name */
    public int f55678f;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f55679a;

        /* renamed from: b  reason: collision with root package name */
        public String f55680b;

        /* renamed from: c  reason: collision with root package name */
        public String f55681c;

        /* renamed from: d  reason: collision with root package name */
        public String f55682d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f55683e;

        /* renamed from: f  reason: collision with root package name */
        public long f55684f;

        /* renamed from: g  reason: collision with root package name */
        public String f55685g;

        public a(b bVar) {
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f55674b = pkModule.pk_id.longValue();
        this.f55675c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f55676d = aVar;
        aVar.f55679a = pkModule.agree.pk_num.longValue();
        this.f55676d.f55680b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f55676d;
        PkItem pkItem = pkModule.agree;
        aVar2.f55681c = pkItem.last_username;
        aVar2.f55682d = pkItem.pk_icon;
        aVar2.f55683e = pkItem.has_clicked.longValue() == 1;
        this.f55676d.f55684f = pkModule.agree.pk_index.longValue();
        this.f55676d.f55685g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f55677e = aVar3;
        aVar3.f55679a = pkModule.disagree.pk_num.longValue();
        this.f55677e.f55680b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f55677e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f55681c = pkItem2.last_username;
        aVar4.f55682d = pkItem2.pk_icon;
        aVar4.f55683e = pkItem2.has_clicked.longValue() == 1;
        this.f55677e.f55684f = pkModule.disagree.pk_index.longValue();
        this.f55677e.f55685g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f55674b = pkModule.pk_id.longValue();
        this.f55675c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f55676d = aVar;
        aVar.f55679a = pkModule.agree.pk_num.longValue();
        this.f55676d.f55680b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f55676d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f55681c = pkItem.last_username;
        aVar2.f55682d = pkItem.pk_icon;
        aVar2.f55683e = pkItem.has_clicked.longValue() == 1;
        this.f55676d.f55684f = pkModule.agree.pk_index.longValue();
        this.f55676d.f55685g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f55677e = aVar3;
        aVar3.f55679a = pkModule.disagree.pk_num.longValue();
        this.f55677e.f55680b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f55677e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f55681c = pkItem2.last_username;
        aVar4.f55682d = pkItem2.pk_icon;
        aVar4.f55683e = pkItem2.has_clicked.longValue() == 1;
        this.f55677e.f55684f = pkModule.disagree.pk_index.longValue();
        this.f55677e.f55685g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f55674b = pkModule.pk_id.longValue();
        this.f55675c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f55676d = aVar;
        aVar.f55679a = pkModule.agree.pk_num.longValue();
        this.f55676d.f55680b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f55676d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f55681c = pkItem.last_username;
        aVar2.f55682d = pkItem.pk_icon;
        aVar2.f55683e = pkItem.has_clicked.longValue() == 1;
        this.f55676d.f55684f = pkModule.agree.pk_index.longValue();
        this.f55676d.f55685g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f55677e = aVar3;
        aVar3.f55679a = pkModule.disagree.pk_num.longValue();
        this.f55677e.f55680b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f55677e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f55681c = pkItem2.last_username;
        aVar4.f55682d = pkItem2.pk_icon;
        aVar4.f55683e = pkItem2.has_clicked.longValue() == 1;
        this.f55677e.f55684f = pkModule.disagree.pk_index.longValue();
        this.f55677e.f55685g = pkModule.disagree.pk_icon_after;
    }
}
