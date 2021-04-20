package d.b.i0.q3.i;

import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicModel f60596a;

    /* renamed from: b  reason: collision with root package name */
    public final d f60597b;

    /* loaded from: classes5.dex */
    public class a implements d.b.i0.q3.i.i.a<CloudMusicData> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.q3.i.i.a
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            b.this.f60597b.displayLoading(false);
            if (cloudMusicData != null) {
                b.this.f60597b.displayNoDataView(false);
                if (cloudMusicData.tag_list.isEmpty()) {
                    b.this.f60597b.displayNoDataView(true);
                    return;
                } else {
                    b.this.f60597b.showCloudMusicWithTagData(cloudMusicData);
                    return;
                }
            }
            b.this.f60597b.displayNoDataView(true);
        }
    }

    public b(CloudMusicModel cloudMusicModel, d dVar) {
        this.f60596a = cloudMusicModel;
        this.f60597b = dVar;
        dVar.setPresenter(this);
    }

    @Override // d.b.i0.q3.i.c
    public void a() {
        this.f60597b.displayLoading(true);
        this.f60596a.t(new a());
    }

    @Override // d.b.i0.q3.i.c
    public void cancelLoadData() {
        this.f60596a.cancelLoadData();
    }
}
