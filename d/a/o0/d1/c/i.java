package d.a.o0.d1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.PkModule;
import tbclient.Hottopic.PkView;
/* loaded from: classes4.dex */
public class i implements d.a.c.k.e.n {
    public static final BdUniqueId p = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56395e;

    /* renamed from: f  reason: collision with root package name */
    public String f56396f;

    /* renamed from: g  reason: collision with root package name */
    public String f56397g;

    /* renamed from: h  reason: collision with root package name */
    public long f56398h;

    /* renamed from: i  reason: collision with root package name */
    public String f56399i;
    public long j;
    public int k;
    public long l;
    public long m;
    public long n;
    public long o;

    public void b(PkModule pkModule) {
        if (pkModule == null) {
            return;
        }
        this.f56395e = pkModule.module_name;
        this.f56396f = pkModule.ques_desc;
        PkView pkView = pkModule.pk_1;
        this.f56397g = pkView.pk_desc;
        this.f56398h = pkView.pk_num.longValue();
        pkModule.pk_1.pk_index.intValue();
        PkView pkView2 = pkModule.pk_2;
        this.f56399i = pkView2.pk_desc;
        this.j = pkView2.pk_num.longValue();
        pkModule.pk_2.pk_index.intValue();
        this.k = pkModule.pk_1.has_clicked.intValue() == 1 ? 1 : pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
        pkModule.pk_type.intValue();
        pkModule.user_pk_index.intValue();
        this.l = pkModule.pk_id.longValue();
        this.m = pkModule.user_pk_id.longValue();
        int i2 = this.k;
        long j = this.f56398h;
        if (i2 == 1) {
            j--;
        }
        this.n = j;
        this.o = this.k == 2 ? this.j - 1 : this.j;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return p;
    }
}
