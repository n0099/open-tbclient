package d.a.n0.r0.i1;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public d f58729a;

    /* renamed from: b  reason: collision with root package name */
    public String f58730b;

    /* renamed from: c  reason: collision with root package name */
    public VideoAggregationModel f58731c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58732d;

    /* renamed from: e  reason: collision with root package name */
    public VideoAggregationModel.c f58733e;

    /* loaded from: classes4.dex */
    public class a implements VideoAggregationModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void a(String str) {
            if (i.this.f58729a == null) {
                return;
            }
            i.this.f58729a.n();
            i.this.f58729a.c(str);
            i.this.f58729a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void b(List<g> list, boolean z, boolean z2) {
            if (i.this.f58729a == null) {
                return;
            }
            i.this.f58729a.n();
            i.this.f58732d = z2;
            i.this.f58729a.d(list, z, z2);
        }
    }

    public i(TbPageContext tbPageContext, d dVar) {
        a aVar = new a();
        this.f58733e = aVar;
        this.f58729a = dVar;
        this.f58731c = new VideoAggregationModel(tbPageContext, aVar);
    }

    public void c() {
        VideoAggregationModel videoAggregationModel = this.f58731c;
        if (videoAggregationModel != null) {
            videoAggregationModel.cancelLoadData();
        }
    }

    public void d() {
        VideoAggregationModel videoAggregationModel = this.f58731c;
        if (videoAggregationModel == null || !this.f58732d) {
            return;
        }
        videoAggregationModel.LoadData();
    }

    public void e() {
        VideoAggregationModel videoAggregationModel = this.f58731c;
        if (videoAggregationModel != null) {
            videoAggregationModel.w();
        }
    }

    public void f(String str) {
        VideoAggregationModel videoAggregationModel = this.f58731c;
        if (videoAggregationModel != null) {
            videoAggregationModel.setFrom(str);
        }
    }

    public void g(String str) {
        this.f58730b = str;
        VideoAggregationModel videoAggregationModel = this.f58731c;
        if (videoAggregationModel != null) {
            videoAggregationModel.x(str);
        }
    }

    public void h(String str) {
        VideoAggregationModel videoAggregationModel = this.f58731c;
        if (videoAggregationModel != null) {
            videoAggregationModel.y(str);
        }
    }

    public void i(String str) {
        VideoAggregationModel videoAggregationModel = this.f58731c;
        if (videoAggregationModel != null) {
            videoAggregationModel.z(str);
        }
    }
}
