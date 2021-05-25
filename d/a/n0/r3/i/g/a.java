package d.a.n0.r3.i.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import d.a.c.a.f;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public f f60037e;

    /* renamed from: f  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f60038f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public c f60039g;

    /* renamed from: d.a.n0.r3.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1569a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f60040e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f60041f;

        public View$OnClickListenerC1569a(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f60040e = musicList;
            this.f60041f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f60039g != null) {
                a.this.f60039g.x0(view, this.f60040e.resource, this.f60041f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60043a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f60044b;

        /* renamed from: c  reason: collision with root package name */
        public View f60045c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60046d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f60047e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f60048f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60049g;

        /* renamed from: h  reason: collision with root package name */
        public View f60050h;

        public void b(int i2) {
            SkinManager.setViewTextColor(this.f60046d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f60047e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f60048f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f60049g, R.color.common_color_10140);
            SkinManager.setBackgroundResource(this.f60049g, R.drawable.bg_music_choose);
            SkinManager.setBackgroundColor(this.f60050h, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f60044b, R.drawable.btn_icon_play_video_n);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void x0(View view, String str, int i2);
    }

    public a(f fVar) {
        this.f60037e = fVar;
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f60038f.contains(musicList)) {
                this.f60038f.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i2) {
        return this.f60038f.get(i2);
    }

    public void d(c cVar) {
        this.f60039g = cVar;
    }

    public void e(int i2, boolean z) {
        getItem(i2).isLoading = z;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f60038f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f60037e.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            bVar = new b();
            bVar.f60044b = (TbImageView) view.findViewById(R.id.music_state);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.music_image);
            bVar.f60043a = tbImageView;
            tbImageView.setDrawerType(1);
            bVar.f60043a.setIsRound(true);
            bVar.f60043a.setDefaultResource(R.drawable.bg_video_cloudmusic);
            bVar.f60043a.setDefaultBgResource(R.color.transparent);
            bVar.f60043a.setBorderWidth(l.g(this.f60037e.getPageActivity(), R.dimen.ds4));
            bVar.f60043a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            bVar.f60043a.setConrers(15);
            bVar.f60045c = view.findViewById(R.id.music_loading);
            bVar.f60046d = (TextView) view.findViewById(R.id.music_title);
            bVar.f60047e = (TextView) view.findViewById(R.id.music_author_name);
            bVar.f60048f = (TextView) view.findViewById(R.id.music_duration);
            bVar.f60049g = (TextView) view.findViewById(R.id.music_choose);
            bVar.f60050h = view.findViewById(R.id.line);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.b(TbadkCoreApplication.getInst().getSkinType());
        CloudMusicData.MusicTagList.MusicList musicList = this.f60038f.get(i2);
        if (musicList != null) {
            bVar.f60046d.setText(musicList.name);
            bVar.f60043a.V(musicList.image, 10, false);
            bVar.f60047e.setText(musicList.author);
            bVar.f60048f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                bVar.f60045c.setVisibility(0);
            } else {
                bVar.f60045c.setVisibility(4);
            }
            if (musicList.equals(d.a.n0.r3.i.h.a.b().a())) {
                bVar.f60044b.setImageResource(R.drawable.btn_icon_stop_video);
                bVar.f60043a.setDrawBorder(true);
                bVar.f60049g.setVisibility(0);
                bVar.f60045c.setVisibility(4);
                musicList.isLoading = false;
                bVar.f60049g.setOnClickListener(new View$OnClickListenerC1569a(musicList, i2));
            } else {
                bVar.f60044b.setImageResource(R.drawable.btn_icon_play_video_n);
                bVar.f60043a.setDrawBorder(false);
                bVar.f60049g.setVisibility(8);
            }
        }
        return view;
    }
}
