package d.a.k0.j1.s;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.model.LegoPageModel;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import d.a.j0.z0.f0;
import d.a.j0.z0.h0;
import d.a.j0.z0.n;
import java.io.IOException;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class c implements d.a.k0.j1.s.a {

    /* renamed from: a  reason: collision with root package name */
    public LegoPageModel f56610a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.j1.s.b f56611b;

    /* renamed from: c  reason: collision with root package name */
    public LegoPageModel.b f56612c = new a();

    /* loaded from: classes4.dex */
    public class a implements LegoPageModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void a(long j, String str, DataRes dataRes, boolean z) {
            if (c.this.f56611b != null) {
                c.this.f56611b.c(j, str, dataRes, z);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void b(long j, String str, int i2, String str2) {
            if (c.this.f56611b != null) {
                c.this.f56611b.b(j, str, str2, i2);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void c(long j, String str, DataRes dataRes, boolean z, int i2) {
            if (c.this.f56611b != null) {
                c.this.f56611b.a(true, dataRes, !z, j, str, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f0<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f56614a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f56615b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f56616c;

        public b(c cVar, l lVar, long j, String str) {
            this.f56614a = lVar;
            this.f56615b = j;
            this.f56616c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            l lVar = this.f56614a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f56615b);
            sb.append("_");
            sb.append(TextUtils.isEmpty(this.f56616c) ? "" : this.f56616c);
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

    /* renamed from: d.a.k0.j1.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1397c implements n<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f56617a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f56618b;

        public C1397c(long j, String str) {
            this.f56617a = j;
            this.f56618b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            c.this.f(this.f56617a, this.f56618b, dataRes);
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        LegoPageModel legoPageModel = new LegoPageModel(tbPageContext, bdUniqueId);
        this.f56610a = legoPageModel;
        legoPageModel.v(this.f56612c);
    }

    @Override // d.a.k0.j1.s.a
    public void a(long j, String str) {
        h0.b(new b(this, d.a.j0.r.r.a.f().d("tb.lego_update"), j, str), new C1397c(j, str));
    }

    @Override // d.a.k0.j1.s.a
    public void b(d.a.k0.j1.s.b bVar) {
        this.f56611b = bVar;
    }

    @Override // d.a.k0.j1.s.a
    public void c(int i2, long j, String str, int i3, String str2) {
        LegoPageModel legoPageModel = this.f56610a;
        if (legoPageModel != null) {
            legoPageModel.t(i2, j, str, i3, str2);
        }
    }

    public final void f(long j, String str, DataRes dataRes) {
        if (j < 0) {
            return;
        }
        d.a.k0.j1.s.b bVar = this.f56611b;
        if (bVar != null) {
            bVar.a(false, dataRes, false, j, str, 1);
        }
        this.f56610a.t(2, j, str, 1, "");
    }
}
