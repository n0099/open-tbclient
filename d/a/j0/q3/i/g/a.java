package d.a.j0.q3.i.g;

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
    public f f59151e;

    /* renamed from: f  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f59152f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public c f59153g;

    /* renamed from: d.a.j0.q3.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1482a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f59154e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f59155f;

        public View$OnClickListenerC1482a(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f59154e = musicList;
            this.f59155f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f59153g != null) {
                a.this.f59153g.y0(view, this.f59154e.resource, this.f59155f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f59157a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f59158b;

        /* renamed from: c  reason: collision with root package name */
        public View f59159c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59160d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f59161e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f59162f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f59163g;

        /* renamed from: h  reason: collision with root package name */
        public View f59164h;

        public void b(int i2) {
            SkinManager.setViewTextColor(this.f59160d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f59161e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f59162f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f59163g, R.color.common_color_10140);
            SkinManager.setBackgroundResource(this.f59163g, R.drawable.bg_music_choose);
            SkinManager.setBackgroundColor(this.f59164h, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f59158b, R.drawable.btn_icon_play_video_n);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void y0(View view, String str, int i2);
    }

    public a(f fVar) {
        this.f59151e = fVar;
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f59152f.contains(musicList)) {
                this.f59152f.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i2) {
        return this.f59152f.get(i2);
    }

    public void d(c cVar) {
        this.f59153g = cVar;
    }

    public void e(int i2, boolean z) {
        getItem(i2).isLoading = z;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f59152f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f59151e.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            bVar = new b();
            bVar.f59158b = (TbImageView) view.findViewById(R.id.music_state);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.music_image);
            bVar.f59157a = tbImageView;
            tbImageView.setDrawerType(1);
            bVar.f59157a.setIsRound(true);
            bVar.f59157a.setDefaultResource(R.drawable.bg_video_cloudmusic);
            bVar.f59157a.setDefaultBgResource(R.color.transparent);
            bVar.f59157a.setBorderWidth(l.g(this.f59151e.getPageActivity(), R.dimen.ds4));
            bVar.f59157a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            bVar.f59157a.setConrers(15);
            bVar.f59159c = view.findViewById(R.id.music_loading);
            bVar.f59160d = (TextView) view.findViewById(R.id.music_title);
            bVar.f59161e = (TextView) view.findViewById(R.id.music_author_name);
            bVar.f59162f = (TextView) view.findViewById(R.id.music_duration);
            bVar.f59163g = (TextView) view.findViewById(R.id.music_choose);
            bVar.f59164h = view.findViewById(R.id.line);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.b(TbadkCoreApplication.getInst().getSkinType());
        CloudMusicData.MusicTagList.MusicList musicList = this.f59152f.get(i2);
        if (musicList != null) {
            bVar.f59160d.setText(musicList.name);
            bVar.f59157a.V(musicList.image, 10, false);
            bVar.f59161e.setText(musicList.author);
            bVar.f59162f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                bVar.f59159c.setVisibility(0);
            } else {
                bVar.f59159c.setVisibility(4);
            }
            if (musicList.equals(d.a.j0.q3.i.h.a.b().a())) {
                bVar.f59158b.setImageResource(R.drawable.btn_icon_stop_video);
                bVar.f59157a.setDrawBorder(true);
                bVar.f59163g.setVisibility(0);
                bVar.f59159c.setVisibility(4);
                musicList.isLoading = false;
                bVar.f59163g.setOnClickListener(new View$OnClickListenerC1482a(musicList, i2));
            } else {
                bVar.f59158b.setImageResource(R.drawable.btn_icon_play_video_n);
                bVar.f59157a.setDrawBorder(false);
                bVar.f59163g.setVisibility(8);
            }
        }
        return view;
    }
}
