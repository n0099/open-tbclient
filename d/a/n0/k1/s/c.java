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
    public LegoPageModel f56790a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.k1.s.b f56791b;

    /* renamed from: c  reason: collision with root package name */
    public LegoPageModel.b f56792c = new a();

    /* loaded from: classes4.dex */
    public class a implements LegoPageModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void a(long j, String str, DataRes dataRes, boolean z) {
            if (c.this.f56791b != null) {
                c.this.f56791b.c(j, str, dataRes, z);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void b(long j, String str, int i2, String str2) {
            if (c.this.f56791b != null) {
                c.this.f56791b.b(j, str, str2, i2);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void c(long j, String str, DataRes dataRes, boolean z, int i2) {
            if (c.this.f56791b != null) {
                c.this.f56791b.a(true, dataRes, !z, j, str, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f0<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f56794a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f56795b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f56796c;

        public b(c cVar, l lVar, long j, String str) {
            this.f56794a = lVar;
            this.f56795b = j;
            this.f56796c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            l lVar = this.f56794a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f56795b);
            sb.append("_");
            sb.append(TextUtils.isEmpty(this.f56796c) ? "" : this.f56796c);
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
    public class C1415c implements n<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f56797a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f56798b;

        public C1415c(long j, String str) {
            this.f56797a = j;
            this.f56798b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            c.this.f(this.f56797a, this.f56798b, dataRes);
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        LegoPageModel legoPageModel = new LegoPageModel(tbPageContext, bdUniqueId);
        this.f56790a = legoPageModel;
        legoPageModel.v(this.f56792c);
    }

    @Override // d.a.n0.k1.s.a
    public void a(long j, String str) {
        h0.b(new b(this, d.a.m0.r.r.a.f().d("tb.lego_update"), j, str), new C1415c(j, str));
    }

    @Override // d.a.n0.k1.s.a
    public void b(d.a.n0.k1.s.b bVar) {
        this.f56791b = bVar;
    }

    @Override // d.a.n0.k1.s.a
    public void c(int i2, long j, String str, int i3, String str2) {
        LegoPageModel legoPageModel = this.f56790a;
        if (legoPageModel != null) {
            legoPageModel.t(i2, j, str, i3, str2);
        }
    }

    public final void f(long j, String str, DataRes dataRes) {
        if (j < 0) {
            return;
        }
        d.a.n0.k1.s.b bVar = this.f56791b;
        if (bVar != null) {
            bVar.a(false, dataRes, false, j, str, 1);
        }
        this.f56790a.t(2, j, str, 1, "");
    }
}
