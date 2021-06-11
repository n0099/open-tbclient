package d.a.n0.r3.h;

import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicModel f63723a;

    /* renamed from: b  reason: collision with root package name */
    public final d f63724b;

    /* loaded from: classes5.dex */
    public class a implements d.a.n0.r3.h.i.a<CloudMusicData> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.r3.h.i.a
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            b.this.f63724b.displayLoading(false);
            if (cloudMusicData != null) {
                b.this.f63724b.displayNoDataView(false);
                if (cloudMusicData.tag_list.isEmpty()) {
                    b.this.f63724b.displayNoDataView(true);
                    return;
                } else {
                    b.this.f63724b.showCloudMusicWithTagData(cloudMusicData);
                    return;
                }
            }
            b.this.f63724b.displayNoDataView(true);
        }
    }

    public b(CloudMusicModel cloudMusicModel, d dVar) {
        this.f63723a = cloudMusicModel;
        this.f63724b = dVar;
        dVar.setPresenter(this);
    }

    @Override // d.a.n0.r3.h.c
    public void a() {
        this.f63724b.displayLoading(true);
        this.f63723a.x(new a());
    }

    @Override // d.a.n0.r3.h.c
    public void cancelLoadData() {
        this.f63723a.cancelLoadData();
    }
}
