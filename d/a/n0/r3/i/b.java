package d.a.n0.r3.i;

import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicModel f60034a;

    /* renamed from: b  reason: collision with root package name */
    public final d f60035b;

    /* loaded from: classes5.dex */
    public class a implements d.a.n0.r3.i.i.a<CloudMusicData> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.r3.i.i.a
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            b.this.f60035b.displayLoading(false);
            if (cloudMusicData != null) {
                b.this.f60035b.displayNoDataView(false);
                if (cloudMusicData.tag_list.isEmpty()) {
                    b.this.f60035b.displayNoDataView(true);
                    return;
                } else {
                    b.this.f60035b.showCloudMusicWithTagData(cloudMusicData);
                    return;
                }
            }
            b.this.f60035b.displayNoDataView(true);
        }
    }

    public b(CloudMusicModel cloudMusicModel, d dVar) {
        this.f60034a = cloudMusicModel;
        this.f60035b = dVar;
        dVar.setPresenter(this);
    }

    @Override // d.a.n0.r3.i.c
    public void a() {
        this.f60035b.displayLoading(true);
        this.f60034a.t(new a());
    }

    @Override // d.a.n0.r3.i.c
    public void cancelLoadData() {
        this.f60034a.cancelLoadData();
    }
}
