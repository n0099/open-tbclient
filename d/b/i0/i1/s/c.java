package d.b.i0.i1.s;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.model.LegoPageModel;
import com.squareup.wire.Wire;
import d.b.b.e.d.l;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.h0.z0.n;
import java.io.IOException;
import tbclient.Lego.DataRes;
/* loaded from: classes3.dex */
public class c implements d.b.i0.i1.s.a {

    /* renamed from: a  reason: collision with root package name */
    public LegoPageModel f56061a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.i1.s.b f56062b;

    /* renamed from: c  reason: collision with root package name */
    public LegoPageModel.b f56063c = new a();

    /* loaded from: classes3.dex */
    public class a implements LegoPageModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void a(long j, String str, DataRes dataRes, boolean z) {
            if (c.this.f56062b != null) {
                c.this.f56062b.b(j, str, dataRes, z);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void b(long j, String str, int i, String str2) {
            if (c.this.f56062b != null) {
                c.this.f56062b.a(j, str, str2, i);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void c(long j, String str, DataRes dataRes, boolean z, int i) {
            if (c.this.f56062b != null) {
                c.this.f56062b.c(true, dataRes, !z, j, str, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends f0<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f56065a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f56066b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f56067c;

        public b(c cVar, l lVar, long j, String str) {
            this.f56065a = lVar;
            this.f56066b = j;
            this.f56067c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            l lVar = this.f56065a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f56066b);
            sb.append("_");
            sb.append(TextUtils.isEmpty(this.f56067c) ? "" : this.f56067c);
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

    /* renamed from: d.b.i0.i1.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1307c implements n<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f56068a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f56069b;

        public C1307c(long j, String str) {
            this.f56068a = j;
            this.f56069b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            c.this.f(this.f56068a, this.f56069b, dataRes);
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        LegoPageModel legoPageModel = new LegoPageModel(tbPageContext, bdUniqueId);
        this.f56061a = legoPageModel;
        legoPageModel.v(this.f56063c);
    }

    @Override // d.b.i0.i1.s.a
    public void a(long j, String str) {
        h0.b(new b(this, d.b.h0.r.r.a.f().d("tb.lego_update"), j, str), new C1307c(j, str));
    }

    @Override // d.b.i0.i1.s.a
    public void b(d.b.i0.i1.s.b bVar) {
        this.f56062b = bVar;
    }

    @Override // d.b.i0.i1.s.a
    public void c(int i, long j, String str, int i2, String str2) {
        LegoPageModel legoPageModel = this.f56061a;
        if (legoPageModel != null) {
            legoPageModel.t(i, j, str, i2, str2);
        }
    }

    public final void f(long j, String str, DataRes dataRes) {
        if (j < 0) {
            return;
        }
        d.b.i0.i1.s.b bVar = this.f56062b;
        if (bVar != null) {
            bVar.c(false, dataRes, false, j, str, 1);
        }
        this.f56061a.t(2, j, str, 1, "");
    }
}
