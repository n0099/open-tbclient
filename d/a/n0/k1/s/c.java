package d.a.n0.k1.s;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.model.LegoPageModel;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n;
import java.io.IOException;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class c implements d.a.n0.k1.s.a {

    /* renamed from: a  reason: collision with root package name */
    public LegoPageModel f60479a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.k1.s.b f60480b;

    /* renamed from: c  reason: collision with root package name */
    public LegoPageModel.b f60481c = new a();

    /* loaded from: classes4.dex */
    public class a implements LegoPageModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void a(long j, String str, DataRes dataRes, boolean z) {
            if (c.this.f60480b != null) {
                c.this.f60480b.c(j, str, dataRes, z);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void b(long j, String str, int i2, String str2) {
            if (c.this.f60480b != null) {
                c.this.f60480b.b(j, str, str2, i2);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void c(long j, String str, DataRes dataRes, boolean z, int i2) {
            if (c.this.f60480b != null) {
                c.this.f60480b.a(true, dataRes, !z, j, str, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f0<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f60483a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f60484b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f60485c;

        public b(c cVar, l lVar, long j, String str) {
            this.f60483a = lVar;
            this.f60484b = j;
            this.f60485c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            l lVar = this.f60483a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f60484b);
            sb.append("_");
            sb.append(TextUtils.isEmpty(this.f60485c) ? "" : this.f60485c);
            byte[] bArr = (byte[]) lVar.get(sb.toString());
            if (bArr != null && bArr.length != 0) {
                try {
                    return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                } catch (IOException unused) {
                }
            }
            return null;
        }
    }

    /* renamed from: d.a.n0.k1.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1471c implements n<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f60486a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f60487b;

        public C1471c(long j, String str) {
            this.f60486a = j;
            this.f60487b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            c.this.f(this.f60486a, this.f60487b, dataRes);
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        LegoPageModel legoPageModel = new LegoPageModel(tbPageContext, bdUniqueId);
        this.f60479a = legoPageModel;
        legoPageModel.z(this.f60481c);
    }

    @Override // d.a.n0.k1.s.a
    public void a(long j, String str) {
        h0.b(new b(this, d.a.m0.r.r.a.f().d("tb.lego_update"), j, str), new C1471c(j, str));
    }

    @Override // d.a.n0.k1.s.a
    public void b(d.a.n0.k1.s.b bVar) {
        this.f60480b = bVar;
    }

    @Override // d.a.n0.k1.s.a
    public void c(int i2, long j, String str, int i3, String str2) {
        LegoPageModel legoPageModel = this.f60479a;
        if (legoPageModel != null) {
            legoPageModel.x(i2, j, str, i3, str2);
        }
    }

    public final void f(long j, String str, DataRes dataRes) {
        if (j < 0) {
            return;
        }
        d.a.n0.k1.s.b bVar = this.f60480b;
        if (bVar != null) {
            bVar.a(false, dataRes, false, j, str, 1);
        }
        this.f60479a.x(2, j, str, 1, "");
    }
}
