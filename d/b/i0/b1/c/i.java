package d.b.i0.b1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.PkModule;
import tbclient.Hottopic.PkView;
/* loaded from: classes3.dex */
public class i implements d.b.b.j.e.n {
    public static final BdUniqueId p = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52118e;

    /* renamed from: f  reason: collision with root package name */
    public String f52119f;

    /* renamed from: g  reason: collision with root package name */
    public String f52120g;

    /* renamed from: h  reason: collision with root package name */
    public long f52121h;
    public String i;
    public long j;
    public int k;
    public long l;
    public long m;
    public long n;
    public long o;

    public void a(PkModule pkModule) {
        if (pkModule == null) {
            return;
        }
        this.f52118e = pkModule.module_name;
        this.f52119f = pkModule.ques_desc;
        PkView pkView = pkModule.pk_1;
        this.f52120g = pkView.pk_desc;
        this.f52121h = pkView.pk_num.longValue();
        pkModule.pk_1.pk_index.intValue();
        PkView pkView2 = pkModule.pk_2;
        this.i = pkView2.pk_desc;
        this.j = pkView2.pk_num.longValue();
        pkModule.pk_2.pk_index.intValue();
        this.k = pkModule.pk_1.has_clicked.intValue() == 1 ? 1 : pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
        pkModule.pk_type.intValue();
        pkModule.user_pk_index.intValue();
        this.l = pkModule.pk_id.longValue();
        this.m = pkModule.user_pk_id.longValue();
        int i = this.k;
        long j = this.f52121h;
        if (i == 1) {
            j--;
        }
        this.n = j;
        this.o = this.k == 2 ? this.j - 1 : this.j;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return p;
    }
}
